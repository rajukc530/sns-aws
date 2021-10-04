# SNS-AWS EMAIL

# Add email subcription:    
Method - POST   
URL - http://localhost:8080/addSubscription/{myemail@gmail.com}

  
# Publish message:   
Method - POST   
URL - http://localhost:8080/sendNotification   
Sample request body -   
   	{   
    		"subject": "Springboot sns email email",   
    		"message": "Dummy message"   
   	}   
