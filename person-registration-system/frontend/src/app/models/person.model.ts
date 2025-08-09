export interface Person {
  id?: number;
  name: string;
  sex: Sex;
  email?: string;
  birthDate: string;
  birthplace: string;
  nationality: string;
  cpf: string;
  observation?: string;
  createdAt?: string;
  updatedAt?: string;
}

export interface Address {
  id?: number;
  street: string;
  number: string;
  complement?: string;
  neighborhood: string;
  city: string;
  state: string;
  zipCode: string;
}

export interface PersonWithAddress extends Person {
  address: Address;
}

export enum Sex {
  MALE = 'MALE',
  FEMALE = 'FEMALE',
  OTHER = 'OTHER'
}

export interface ApiResponse<T> {
  data: T;
  message?: string;
  success: boolean;
}
