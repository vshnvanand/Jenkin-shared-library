def call(String Project, String ImageTag, String dockerhubUserParam){
  withCredentials([usernamePassword(credentialsId:'dockerhubcred', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubUser')]){
    echo "logging in"
    sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
    echo "log in successful"
  }
  echo "push-time"
  sh "docker push ${dockerhubUser}/${Project}:${ImageTag}"
  echo "pushing-done"
}
