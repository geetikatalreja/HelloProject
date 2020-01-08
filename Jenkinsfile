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
    
    stage('deployment to Jfrog artifactory') {
              steps {
			rtUpload (
    					serverId: 'Artifactory-1',
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

  }

}