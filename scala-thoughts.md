**On what's easy:**
-Easy to write clean-looking code that you can feel good + confident about.  Though I think that's just a general trait of functional languages.
-Easy to do complex things to lists/collections with not very much code.  I'm tempted to revisit old Java programs I've written and see how much cleaner + shorter I can make them in Scala.
-Easy to write syntactically.  Because there are a bunch of different ways to do things (syntactically), I found that my first attempt would usually work.  Having a lot of ways to write the same code is something I was against before this assignment, but I'm not sure I feel that way now.

**On what's hard:**
-It'll take a while to get comfortable with some of the higher-order functions.
-Curly braces add up quickly.. Can be difficult to quickly read + understand methods/functions that have lots of them.  {{{}}{{}}{}}}  !!!

**On pattern matching:**
-At first I didn't like that I needed to use the 'match' keyword to start pattern matching, but it ends up being much more concise than rewriting the function name + parameters for each pattern (like you would in SML).  
-Really don't like the indentation of if/else statements inside a 'case'.  I did it SML-style (check ListManipulation01 oddElements to see what I'm talking about), but maybe there's a better way to write it in Scala.

**What I'd like to learn more about**
-Would like to learn more about + memorize higher-order functions.  They remind me a lot of Rubik's Cube algorithms.  You can solve the cube with just ~7 algorithms, but there are hundreds (literally) more that exist.  The more you memorize, the faster you can solve the cube.  With ~40 of these higher-order functions down, I bet most problems involving collections become trivial to solve.
-Would like to learn more about companion objects, multiple inheritance, overloading, overriding.

**Miscellaneous thoughts:**
-Didn't really understand what Steele meant by overloading operators, but I can see the usefulness after overloading the ‘+’ operator for the Euro.  
-Way more list manipulation functions than I ever thought were possible.  I'll often find myself wanting to write straightforward list recursion + pattern matching functions, but then I'll feel guilty for not being efficient/"Scala-y".
-Going off the above, how can we even say that code is "Scala-y" if a huge part of Scala is its flexibile/modifiable syntax?  My instinct is to think that "Scala-y" solutions to the practice labs are ones that have few LOC and use high order collection methods whenever possible, but maybe I'm wrong about that.
-Give that Scala accepts all legal Java code (it does, right?), then why not just replace all uses of Java with Scala?  You might not want to port old/large Java programs, but when starting a program from scratch it seems like it'd make sense to always go the Scala route.
