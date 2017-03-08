package pl.itse.example;

public class User implements IUser {

	@Log
	@Override
	public String getName() {

		return "John Smith";
	}


	@Override
	public void simulateException() throws Exception {
		throw new Exception("Simulate an error");
	}

}
