package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("model1",1)));//1
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("model2",2)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("model3",3)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("model4",4)));

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.addCar(new Car(userService.listUsers().get(0),"model1",1));
      userService.addCar(new Car(userService.listUsers().get(1),"model2",2));
      userService.addCar(new Car(userService.listUsers().get(2),"model3",3));
      userService.addCar(new Car(userService.listUsers().get(3),"model4",4));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      User userX = userService.getUserCar("model3",3);
      System.out.println("User - id="+userX.getId()+", name="+userX.getFirstName()+", lastname="+userX.getLastName());
      context.close();
   }
}
