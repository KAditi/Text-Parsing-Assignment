# Text-Parsing-Assignment
Create a simple Maven Java-8 project on your own GitHub as a public repository.
Create a TextTokenizer class with a method that takes a java.lang.CharSequence as a parameter and returns a list of TextToken instances.
The TextToken class should implement all required methods of java.lang.CharSequence (default methods like chars() and codePoints() do not need to be implemented)
The TextToken class should also implement additional methods that will:
Return the String value of the token
Return the first index and last index of the token relative to the original java.lang.CharSequence passed as a parameter to TextTokenizer above.
Return an indication whether the token value is only numeric, only alphabetic, or both alphabetic and numeric.
Each instance of TextToken instantiated by TextTokenizer should *only* encapsulate one sequence of one or more numbers and/or alphabetic characters.
Once created, instances of TextToken should be immutable.
Performance is key. Minimizing garbage collection is also ideal.
Use JUnit to create unit test cases and ensure full code coverage with both positive and negative test cases.
Bonus: Include in unit tests an example of passing each TextToken to java.util.regex.Pattern.matches(String, CharSequence).
