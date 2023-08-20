# <u>***Assembly Language Parser***</u>

This application is used to parse a set of limited commands.

## <u>***Commands***</u>
 These are the available commands for our APP

- **<u>MV</u>** : Move command. This command is used to assign a constant value for a register. The constant should start with #

    _Syntax_: MV <register_name>,<constant>
   
    _For Example_: MV REG1,#2000


- **<u>ADD</u>** : Add command. This command is used to add two register values or a constant to a register value. For adding, the constant should not have any prefix.

  _Syntax_: ADD <register_name1>,<register_name2>/<constant>

  _For Example_: ADD REG1,REG2 (or) ADD REG1,600


- **<u>SHOW REG</u>** : Show Register Command. This is the final command for the program written. This denotes the End of the Program.

  _Syntax_: SHOW REG
  
  _For Example_: SHOW REG

## <u>***Properties to be changed***</u>
In the application.properties, which is present in src/main/resources, the following properties need to be changed.

*<u>spring.datasource.url</u>=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/${MYSQL_DATABASE:assembly_language}
<u>spring.datasource.username</u>=${MYSQL_USERNAME:root}
<u>spring.datasource.password</u>=${MYSQL_PASSWORD}*

## <u>***Docker configurations to be changed***</u>
If the application is accessed using the docker-compose,

- Open the cmd/terminal in the project location where the *docker-compose.yml* file is located.
- Execute *docker-compose up* command to start the app

## <u>***Run as a Java Jar***</u>
To execute the app as a java jar, 

- Open the cmd/terminal in the project location where the *pom.xml* file is located.
- Execute *mvn clean install -DskipTests* to build the jar
- The jar will be available in the *target* folder
- Navigate to cmd to target folder
- Execute java -jar *<jar_name>* to start the app and start programming with the assembly code.


# *STAY SAFE!!! HAPPY CODING!!!*