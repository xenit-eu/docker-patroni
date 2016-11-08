pipeline {
  agent any

  stages {
    stage ('Checkout') {
      steps {
        println "********** GIT_BRANCH: [" + env.BRANCH_NAME + "]"
        println "********** BUILD_NUMBER: [" + env.BUILD_NUMBER + "]"
        checkout scm
      }
    }
    stage ('Test') {
      steps {
        sh "./gradlew test -i -PbuildNumber=" + env.BUILD_NUMBER + " -PgitBranch=" + env.BRANCH_NAME
      }
      post {
        success {
          junit 'build/test-results/**/*.xml'
          publishHTML target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'build/reports/tests/test',
              reportFiles: 'index.html',
              reportName: 'Test Report'
            ]
        }
      }
    }
    stage ('Publishing') {
      steps {
        sh "./gradlew pushDockerImage --i -PbuildNumber=" + env.BUILD_NUMBER + " -PgitBranch=" + env.BRANCH_NAME
      }
    }
  }
  post {
    always {
        sh "./gradlew composeDown"
    }
  }
}