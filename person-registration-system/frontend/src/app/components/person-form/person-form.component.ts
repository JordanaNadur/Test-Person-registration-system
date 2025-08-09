import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PersonService } from '../../services/person.service';
import { Person, Address, Sex } from '../../models/person.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {
  personForm: FormGroup;
  isEditMode = false;
  loading = false;
  sexOptions = Object.values(Sex);

  constructor(
    private fb: FormBuilder,
    private personService: PersonService,
    private router: Router
  ) {
    this.personForm = this.createForm();
  }

  ngOnInit(): void {
    // Verificar se está em modo de edição
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state?.['person']) {
      this.isEditMode = true;
      this.loadPersonData(navigation.extras.state['person']);
    }
  }

  createForm(): FormGroup {
    return this.fb.group({
      id: [null],
      name: ['', [Validators.required, Validators.minLength(3)]],
      sex: ['', Validators.required],
      email: ['', [Validators.email]],
      birthDate: ['', [Validators.required]],
      birthplace: ['', [Validators.required]],
      nationality: ['', [Validators.required]],
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      observation: [''],
      address: this.fb.group({
        street: ['', [Validators.required]],
        number: ['', [Validators.required]],
        complement: [''],
        neighborhood: ['', [Validators.required]],
        city: ['', [Validators.required]],
        state: ['', [Validators.required, Validators.maxLength(2)]],
        zipCode: ['', [Validators.required, Validators.pattern(/^\d{8}$/)]]
      })
    });
  }

  loadPersonData(person: Person): void {
    this.personForm.patchValue(person);
  }

  onSubmit(): void {
    if (this.personForm.valid) {
      this.loading = true;
      const personData = this.personForm.value;

      const operation = this.isEditMode
        ? this.personService.updatePerson(personData.id, personData)
        : this.personService.createPerson(personData);

      operation.subscribe({
        next: () => {
          alert(this.isEditMode ? 'Pessoa atualizada com sucesso!' : 'Pessoa cadastrada com sucesso!');
          this.router.navigate(['/persons']);
        },
        error: (error) => {
          console.error('Erro ao salvar pessoa:', error);
          alert('Erro ao salvar pessoa. Por favor, tente novamente.');
          this.loading = false;
        }
      });
    } else {
      this.markFormGroupTouched(this.personForm);
    }
  }

  onCancel(): void {
    this.router.navigate(['/persons']);
  }

  private markFormGroupTouched(formGroup: FormGroup): void {
    Object.keys(formGroup.controls).forEach(key => {
      const control = formGroup.get(key);
      control?.markAsTouched();
      if (control instanceof FormGroup) {
        this.markFormGroupTouched(control);
      }
    });
  }

  get f() { return this.personForm.controls; }
  get address() { return this.personForm.get('address') as FormGroup; }
}
