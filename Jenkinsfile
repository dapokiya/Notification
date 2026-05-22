pipeline {
    agent any

    environment {
        DOCKER_USER = "dapokiya"
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                echo "checking out code from git repository"
                git branch: 'main', url: 'https://github.com/dapokiya/Notification.git'
            }
        }

        stage('Build') {
            steps {
                echo "building project using maven"
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                echo "building docker image"
                sh 'docker build -t dapokiya/notification:demo .'
            }
        }

        stage('Docker Login') {
            steps {
                echo "logging into Docker Hub"
                withCredentials([string(credentialsId: 'docker-token', variable: 'DOCKER_PASS')]) {
                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    '''
                }
            }
        }

        stage('Push Image') {
            steps {
                echo "pushing Docker image to docker hub"
                sh 'docker push dapokiya/notification:demo'
            }
        }

        stage('Deploy') {
            steps {
                echo "deploying application to kubernetes cluster"
                sh '''
                kubectl apply -f k8s/deployment.yml --validate=false
                kubectl apply -f k8s/service.yml --validate=false
                '''
            }
        }

        stage('Done') {
            steps {
                echo "deployment completed successfully!"
            }
        }
    }
}