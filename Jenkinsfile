pipeline {
    agent any
    stages {

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
                 sh 'echo dckr_pat_JzpPChavTe-u_fPCkCu1j8vFikE | docker login -u dapokiya --password-stdin'
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
