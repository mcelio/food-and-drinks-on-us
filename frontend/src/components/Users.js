import React, { Component } from 'react';
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

class Users extends Component {

    // Initializing important variables
    constructor(props) {
       super(props);
       this.state = {
         users: []
       };
     }

    componentDidMount() {
        console.log("Getting users within 100km");
        const headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Access-Control-Request-Origin" : "*"
        }
        return axios.get("http://localhost:8081/v1/users/list", headers)
            .then(response => {
              // create an array of contacts only with relevant data
              this.setState({
                      users: response.data
                    });
         }).catch(error => console.log(error));
    }

    render() {
            return (
              <ul>
                {this.state.users.map(function(user, index){
                  return (
                      <div key={index}>
                        <p>{user.id} - {user.name}</p>
                      </div>
                    )
                  }
                )}
              </ul>
            );
        }
}

export default Users;
