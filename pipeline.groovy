pipeline {
  agent any
  triggers{
    githubPush()
  }
  stages {
    stage('build'){
      steps {
        sh 'docker build -t 4277-node-image-jenkins .'
      }
    }
    stage('run'){
      steps{
        sh 'docker run -d -p 5000:3001 4277-node-image-jenkins'
      }
    }
    stage('final'){
      steps{
        sh 'docker ps'
      }
    }
  }
}
