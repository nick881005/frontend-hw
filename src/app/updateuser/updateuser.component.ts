import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '/Users/nick881005/Documents/code/8:23hw-angular html/src/app/service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-update-user',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateUserComponent implements OnInit {
  id: number;
  user: User;

  constructor( 
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.userService.updateUser(this.id, this.user).subscribe( data =>{
      this.gotoUserList();
    }
    , error => console.log(error));
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}