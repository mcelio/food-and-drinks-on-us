import React from "react";
import ReactDOM from "react-dom";
import Users from './Users';
import 'bootstrap/dist/css/bootstrap.css';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';
import { BrowserRouter as Router, Route, Redirect, Link } from "react-router-dom";
import { NavLink as RRNavLink } from 'react-router-dom';

class Intercom extends React.Component {

  constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  componentDidMount() {
     //this.props.history.push('/map');
  }

  render() {
    return (
          <div>
              <Users/>
         </div>   
    );
  }
}

export default Intercom;




