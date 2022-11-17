<p align="center">
<img src="images/cea7bc01a8580673bbaa7ac0e457536b.png">
</p>

# Authors

- [Brandon Pearson](https://github.com/blpearson26)
- [Dennis Tran](https://github.com/DennisTran00)
- [Addison Burkett](https://github.com/westvalard)
- [Kyle Parker](https://github.com/CraftyAmigo)

# Background

The purpose of this product is to provide individuals, teams, and organizations with an easy-to-use, secure credential sharing solution. There are two main focuses for the Password Manager. First, it will eliminate the hassle and security lapses of having to memorize/maintain passwords with a centralized vault for user credential storage and access. Secondly, it will provide credential sharing ability with real-time alerts on credential access. With the Password Manager, users will be able to set up hierarchical systems in which specific users can be granted access to resources and credentials. When administrators change credential information, the software will automatically update passwords of any resources that are shared to other members. Additionally, administrators get privileged access to audit logs which display a record of credential access from all members.

Project Submission Structure
============================
> Folder structure has been split into detailed section for ease of understanding

### Top-level directory

    .
    ├── PassMnger                 # Project files
    ├── images                    # image files for the README.md
    ├── .gitignore
    └── README.md
    
### Source files
    .
    ├── PassMnger
    │   ├── src
    │   │   ├── main
    │   │   │   ├── java
    │   │   │   │   ├── Main             # Package that contains the launch application and GUI file
    │   │   │   │   ├── credential       # Package for credential isntances used to save user credentials
    │   │   │   │   ├── database         # Contains the database connection class for database access
    │   │   │   │   ├── gui              # Package for the GUI controller class
    │   │   │   │   ├── invites          # Package for invitation instances to add users to a team (feature)
    │   │   │   │   ├── role             # Package for creating role instances for team credential privileges 
    │   │   │   │   ├── team             # Package for team instances and storing information about created teams
    │   │   │   │   └── user             # Package for user isntances when a user registers an account
    │   │   │   └── ... 
    │   │   └── ... 
    │   └── ... 
    └── ...
