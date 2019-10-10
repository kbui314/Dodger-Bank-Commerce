import { UserProfile } from './UserProfile';

export class User{
    id:Number;
    userName: String;
    password: String;
    userType: String;
    profile:UserProfile;

    constructor(id:Number,userName:String,password:String,userType:String,profile:UserProfile){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.profile = profile;
    }
}