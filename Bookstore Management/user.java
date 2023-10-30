package bookstore;

public class User {
	enum UserType{
		CUSTOMER,
		USER,
		ADMIN
	}
private String Username;
private String Password;
private UserType Type;

public User(String Username, String Password, UserType Type) {
	setUsername(Username);
	setPassword(Password);
	setType(Type);
}

public String getUsername() {
	return Username;
}

public void setUsername(String name) {
	Username = name;
}

public String getPassword() {
	return Password;
}

public void setPassword(String Password) {
	this.Password = Password;
}

public UserType getType() {
	return Type;
}

public void setType(UserType type) {
	Type = type;
}
