pipeline{
	agent any
	//agent {docker {image 'maven:3.6.3'}}
	environment{
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	stages{
		stage('Checkout'){
			steps{
				sh 'mvn --version'
				sh 'docker version'
				echo 'Build'
				echo "PATH - $PATH"
				echo "JOB_NAME - $env.JOB_NAME"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "BUILD_TAG - $env.BUILD_TAG"
				echo "BUILD_URL - $env.BUILD_URL"
							
			}
		}
		stage('Compile'){
			steps{
				//sh "mvn clean compile"
				echo 'Build'
			}
		}
		
		stage('Test'){
			steps{
				//sh "mvn Test"
				echo 'Test'
			}
		}
		stage('Integration Test'){
			steps{
				//sh "mvn failsafe:integration-test failsafe:verify"
				echo 'Integration Test'
			}
		}
		stage('Build Docker Image'){
			steps{
				script{
					dockerImage=docker.build("saynotoet/todo-service:${env.BUILD_TAG}")
				}
				echo 'Docker Image Created'
			}
		}
		stage('Push Docker Image'){
			steps{
				script{
					docker.withRegistry('','dockerHubId'){
						dockerImage.push()
						dockerImage.push('latest')
					}
				}
				echo 'Docker Image pushed'
			}
		}		
	}
	post{
	
		always{
			echo 'Build Completed !!!'
		}
		success{
			echo 'Successfully completed Build'
		}
		failure{
			echo 'Build did not succeed'
		}
	}
}