pipeline {
    agent any
    stages {
        stage('Compile stage') {
        	steps{
            withMaven(maven : 'maven' ) {
                sh 'mvn clean compile'
            	}
            }
        }
		
		stage('Testing stage') {
        	steps{
            withMaven(maven : 'maven' ) {
                sh 'mvn test'
            	}
            }
        }
		
		stage('Deployment stage') {
        	steps{
            withMaven(maven : 'maven' ) {
                sh 'mvn deploy'
            	}
            }
        }
    }
}