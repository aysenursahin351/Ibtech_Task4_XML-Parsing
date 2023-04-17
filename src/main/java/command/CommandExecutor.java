package command;
import java.lang.reflect.Method;
import dao.CommandDao;
import model.Command;
import xbag.XBag;

public class CommandExecutor {
	public void executeCommand(String commandName, Object object) throws Exception {
	    try {
	        CommandDao commandDao = new CommandDao();
	        Command command = commandDao.getCommandByName(commandName);
	        if (command == null) {
	            throw new Exception("Command not found");
	        }

	        Class<?> c = Class.forName("operation." + command.getClassName());
	        System.out.println(command.getClassName());

	        Object object1 = c.newInstance();
	        Method method = c.getDeclaredMethod(command.getMethodName(), Object.class); // Tek parametreli method seçildi
	        System.out.println(command.getMethodName());

	        method.invoke(object1, object); // Tek parametreli method çağrıldı

	        System.out.println("Command executed successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}
	
	
	public void executeBag(String commandName, XBag xBag) throws Exception {
	    try {
	        CommandDao commandDao = new CommandDao();
	        Command command = commandDao.getCommandByName(commandName);
	        if (command == null) {
	            throw new Exception("Command not found");
	        }

	        Class<?> c = Class.forName("operation." + command.getClassName());
	        System.out.println(command.getClassName());

	        Object object1 = c.newInstance();
	        Method method = c.getDeclaredMethod(command.getMethodName(), XBag.class);
	        System.out.println(command.getMethodName());

	        method.invoke(object1, xBag);

	        System.out.println("Command executed successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}




}
