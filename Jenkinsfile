pipeline {
    agent any

    tools {
        jdk 'JDK17'              // Configure in Jenkins → Global Tool Config
        maven 'Maven-3.9'
    }

    environment {
        PROJECT_NAME = 'Web-Automation'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Tester123-rak/automation-project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                bat 'mvn surefire-report:report'
            }
        }

        stage('Archive Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {

        always {
            echo 'Pipeline execution completed'
        }

        success {
            echo 'Build SUCCESS ✅'
        }

        failure {
            echo 'Build FAILED ❌'
        }
    }
}