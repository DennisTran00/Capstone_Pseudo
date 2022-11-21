<p align="center">
<img src="images/cea7bc01a8580673bbaa7ac0e457536b.png">
</p>

# Authors

- [Brandon Pearson](https://github.com/blpearson26) - Cyber Security
- [Dennis Tran](https://github.com/DennisTran00)    - Computer Science
- [Addison Burkett](https://github.com/westvalard)  - Cyber Security
- [Kyle Parker](https://github.com/CraftyAmigo)     - Software Design & Development

# Background
The purpose of this product is to provide individuals, teams, and organizations with an easy-to-use, secure credential sharing solution. There are two main focuses for the Password Manager. 
* First, it will eliminate the hassle and security lapses of having to memorize/maintain passwords with a centralized vault for user credential storage and access. 
* Secondly, it will provide credential sharing ability with real-time alerts on credential access. 

With the Password Manager, users will be able to set up hierarchical systems in which specific users can be granted access to resources and credentials. When administrators change credential information, the software will automatically update passwords of any resources that are shared to other members. Additionally, administrators get privileged access to audit logs which display a record of credential access from all members.

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
    │   │   │   │   ├── Main          # Package that contains the launch application and GUI file
    │   │   │   │   ├── credential    # Package for credential isntances used to save user credentials
    │   │   │   │   ├── database      # Contains the database connection class for database access
    │   │   │   │   ├── gui           # Package for the GUI controller class
    │   │   │   │   ├── invites       # Package for invitation instances to add users to a team (feature)
    │   │   │   │   ├── role          # Package for creating role instances for team credential privileges 
    │   │   │   │   ├── team          # Package for team instances and storing information about created teams
    │   │   │   │   └── user          # Package for user isntances when a user registers an account
    │   │   │   └── ... 
    │   │   └── ... 
    │   └── ... 
    └── ...

<details><summary><b>Package Details</b></summary>

#### Main
    .
    ├── Main
    │   ├── PasswordManager.java        # The main launch application (creates the JavaFX Stage)
    │   ├── PasswordManagerGUI.fxml     # FXML file exported from SceneBuilder GUI creator
    │   └── Style.css                   # CSS file that formats fxml elements in the GUI
    
 #### credential
    .
    ├── credential
    │   ├── Credential.java             # Stores information about user added credentials
    │   └── CredentialInterface.java    # Methods for defining the behavior of Credential
    
 #### database
    .
    ├── database
    │   └── DBConnection.java           # Creates a connection to the database and has querying methods
    
 #### gui
    .
    ├── gui
    │   ├── InfoList.java                     # Updates the thumbnail list in the GUI
    │   └── PasswordManagerController.java    # Controller class that is linked to the FXML file
 
 #### invites
    .
    ├── invites
    │   ├── Invite.java                 # Stores information about team invitiations sent to other users
    │   └── InviteInterface.java        # Methods for defining the behavior of Invite
    
  #### role
    .
    ├── role
    │   ├── Role.java                   # Stores information about team role privileges
    │   └── RoleInterface.java          # Methods for defining the behavior of Role
 
   #### team
    .
    ├── team
    │   ├── Team.java                   # Stores information about a user created team
    │   └── TeamInterface.java          # Methods for defining the behavior of Team
    
   #### user
    .
    ├── user
    │   ├── User.java                   # Stores information about every user that registers
    │   └── UserInterface.java          # Methods for defining the behavior of User
 
 ### Resource Icons
 > Icons used in the Graphical User Interface can be found in the `res` pacakge by following the path: src > main > java > res.
 </details>
 
Screenshots
============================
<details><summary><b>Initial Startup</b></summary> 
<p align="center">
<img src="images/Initial.png">
</p>
</details>

<details><summary><b>Credential View</b></summary>
<p align="center">
<img src="images/example.png">
</p>
<p align="center">
<img src="images/cred2.png">
</p>
</details>

<details><summary><b>Team View</b></summary>
<p align="center">
<img src="images/team.png">
</p>
<p align="center">
<img src="images/assign.png">
</p>
</details>

<details><summary><b>Inbox with team invitiation</b></summary>
<p align="center">
<img src="images/invitation.png">
</p>
</details>

<details><summary><b>Audit Log</b></summary>
<p align="center">
<img src="images/audit1.png">
</p>
<p align="center">
<img src="images/audit2.png">
</p>
</details>

Database
============================
This project currently utilizes a local MySQL database for demonstration purposes. Therefore, it is necessary to correctly set up the database before the software can be launched. The database connection is established by the following code within DBConnection.java:
````
    private DBConnection() {
		uri = "jdbc:mysql://localhost/passwordmanager?useSSL=false&allowPublicKeyRetrieval=true";
		try {
			dbCon = DriverManager.getConnection(uri, "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
````
This means that the MySQL account must have a username of `root` and a password of `password` to get the database working correctly. If the database is being establish on Windows OS, ensure that the MySQL service is running by pressing `Win + R` on your keyboard to open the Run window. Then type `services.msc` and hit enter. Scroll down until you see MySQL and run the service if it not doing so already.
Once MySQL is running on your machine, launch the MySQL command line. The following commands will set up the database required for the software to work:

<details><summary><b>Database Setup Commands</b></summary> 

````
CREATE DATABASE passwordmanager;

use passwordmanager;

CREATE TABLE user_info (
username VARCHAR(255),
password VARCHAR(255),
ID VARCHAR(255)
);

CREATE TABLE credentials (
UserID VARCHAR(255),
Username VARCHAR(255),
Password VARCHAR(255),
URL VARCHAR(255),
Notes VARCHAR(255),
Created VARCHAR(255),
CreationDate VARCHAR(255),
ModifiedDate VARCHAR(255),
Title VARCHAR(255)
);

CREATE TABLE teams (
GroupID VARCHAR(255),
GroupName VARCHAR(255),
OwnerID VARCHAR(255)
);

CREATE TABLE members (
GroupID VARCHAR(255),
Username VARCHAR(255),
UserID VARCHAR(255),
Role VARCHAR(255),
GroupName VARCHAR(255),
Joined VARCHAR(255)
);

CREATE TABLE roles (
GroupID VARCHAR(255),
RoleID VARCHAR(255),
RoleName VARCHAR(255),
Username VARCHAR(255),
Password VARCHAR(255)
);

CREATE TABLE invites (
GroupID VARCHAR(255),
UserID VARCHAR(255),
Username VARCHAR(255)
);
````
</details>
 
Troubleshooting Problems
============================
> Since this project uses JavaFX for the graphical user interface, some problems related to JavaFX dependencies may occur when trying to launch the project for the first time. Make sure to follow these fixes to common problems with our project. All of these fixes are through the assumption that the project is being imported into Eclipse IDE.

<details><summary><b>Ensure that the correct JavaSE version is being used</b></summary>
	
Make sure that the correct JavaSE version is being utilized. To do this, expand the project directory in the workspace. 
Once the project directory has been expanded, you should see `JRE System Library`. 
Right click on it and proceed to `Properties`. A new window will open with the title `Properties for JRE Systerm Library`. 
Here you can change the version by checking `Execution Environment` and change it to `JavaSE-11 (jre)` if it is not so already
	
</details>

<details><summary><b>Installing the correct Java dependencies and setting it in the runtime configurations</b></summary>

If you run the project it will compile but you will get this error:

```` diff
- Error: JavaFX runtime components are missing, and are required to run this application

````
This error is shown since the Java 17 launcher checks if the main class extends javafx.application.Application. If that is the case, it is required to have the javafx.graphics module on the module-path.

A possible fix to many problems regarding JavaFX would be to use the JavaFX SDK instead of a build tool. Use this [link](https://gluonhq.com/products/javafx/) to download the correct JavaFX SDK. Our project uses javafx-sdk-17.0.0.1. Download the zip file and save it to a location on your drive.

Now, locate PasswordManager.java and right click it. Hover over `Run As` and select `Run Configurations...`. A new window titled `Run Configurations` should pop up. Navigate to the tab that says `Arguments` and under `VM arguments` add these VM arguments:

````

--module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls,javafx.fxml

````

</details>

<details><summary><b>Refreshing the workspace</b></summary>
</details>
<details><summary><b>Program launches but program fails when trying to log in / register</b></summary>
</details>
