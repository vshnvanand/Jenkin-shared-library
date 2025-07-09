def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId:'dockerhubcred', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubuser')]){
   
    sh "docker login -u ${dockerhubuser} -p ${dockerhubPass}"
   
  }

  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
 
}
