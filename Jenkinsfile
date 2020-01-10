pipeline {

    agent any
    tools {
        maven 'maven' 
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }

         stage('testing stage') {
             steps {
                bat "mvn test"
        }
    }
    
     stage('build stage') {
             steps {
                bat "mvn clean install"
        }
    }

          stage('Archive artifacts') {
              steps {
                 archiveArtifacts 'target/*.war'
        }
    }
    
    
   /* stage('deployment stage') {
              steps {
                 deploy adapters: [tomcat9(credentialsId: '2d2d4d19-3332-4188-8299-cbc5c741768d', path: '', url: 'http://localhost:8080')], contextPath: 'rps1', war: 'target/*.war'
        }*/
    
    stage('deployment to Jfrog artifactory') {
              steps {
			rtUpload (
    					serverId: 'First_server',
    					spec: '''{
          							"files": [
            									{
              										"pattern": "target/*.war",
              										"target": "Maven_localRepo/0.0.1-SNAPSHOT/"
            									}
         									]
    							}''',
					)
                 
        }
    }
	
	stage('Build docker image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("newimage/tomcat")
    }
	
	stage('Test image') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            bat 'echo "Tests passed"'
        }
    }

  }

}