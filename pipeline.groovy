pipeline {
  agent any
  triggers{
    githubPush()
  }
  stages {
    stage('build'){
      steps {
        sh 'docker build -t ravishaaaan/4277-node-app-image .'
      }
    }
    stage('run'){
      steps{
        sh 'docker run -d -p 5000:3000 ravishaaaan/4277-node-app-image'
      }
    }
    stage('final'){
      steps{
        sh 'docker ps'
      }
    }
    stage('push'){
      steps{
        script{
          withCredentials([string(credentialsId: 'docker-pwd', variable: 'docker')]) {
    sh 'docker login -u ravishaaaan -p ${docker}'
  }
    sh 'docker push ravishaaaan/4277-node-app-image'
        }
      }
    }
  }
}