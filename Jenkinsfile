pipeline {
    agent any

    tools {
        jdk 'JDK17'              // Configure in Jenkins → Global Tool Config
        maven 'Maven-3.9.14'
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

        stage('selenium grid run'){
             steps{
                 bat 'docker compose up -d'
             }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Parallel tests') {
        parallel{
        stage('Chrome'){
            steps {
                bat 'mvn test -Dbrowser=chrome'
            }
            }
            stage('Firefox'){
            steps{
            bat 'mvn test -Dbrowser=firefox'
            }
            }
        }
        }

        stage('Generate Reports') {
            steps {
                bat 'mvn surefire-report:report -DskipTests'
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
            bat 'docker compose down'
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