export class UserProfile{
    id:Number;
    firstName:String;
    lastName:String;
    phoneNumber:String;
    email:String;
    constructor(id:Number,firstName:String,lastName:String,phoneNumber:String,email:String){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
}