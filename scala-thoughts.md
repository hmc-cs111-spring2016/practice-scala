## General Reflections

After completing the assignment, I feel as though I have a much better grasp of Scala. I have never paid quite so much attention to the process of learning a new language. When we create our own DSLs, hopefully this awareness will make it easier for us to see things from the perspective of the user. I certainly put a lot more thought into how I used various Scala resources.


## Helpful Tools

Throughout the assignment, the Scala documentation was my most consulted resource. I found the documentation to be thorough, especially the section on collections. It especially came in handy for the list comprehension exercises in the first lab. I did not have much background with list comprehensions from previous computer science classes, so the documentation was especially useful in showing me what functions were already available in Scala.

The other resource that I ended up using quite a bit was Stack Overflow. Whenever I had a question about how to do something slightly unclear in Scala, I could almost always find someone who had a similar problem on Stack Overflow. This was especially useful if I got errors that were unclear and I couldn't find the specific issue in the documentation. I also found the links to pattern matching articles in the assignment to be very helpful. 


## Ease of Use
_What's easy to do in Scala? What's not?_

Though there are many of them, list comprehensions were surprisingly easy to learn in Scala. I first looked at some of the definitions in the documentation, especially for things like `++`, and was a bit daunted. However, I quickly learned to read the documentation and found that it was helpful to have multiple names for the name function. Even though it requires a bit of thought to chain the different functions together, the end result is very readable and usually quite succinct. 

I found pattern matching to be hit-or-miss in Scala. I think that it was generally easy to do, but in OptionExercise I found it quite frustrating to do pattern matching with the `Option` type. My solution had a case checking for type `Some(Some(value))
` which I do not find very readable. It was hard to think of a workaround for that, so I kept it in due to time constraints.

## Scala Language Design Choices
_What is/are your favorite language design choice(s) that the designers of Scala made? Why?_
_What is/are your least favorite language design choice(s)? Why? And why do you think the designers made that / those choice(s)?_

I really like the fact that some functions have different names but do the same things. This is just `size` and `length` in a lot of languages, but it seems as though there are more instances of this in Scala. As a user, it is nice to be able to say different things and get the same result. I don't think that every user would like this functionality, but for me it is not overdone. We discussed in class how the designers possibly made that decision to appeal to more mathematically-minded users. I think that this is a great example of how to be conscious of the user and the domain in which your language is used.

One design choice that I'm uncertain about is the number of various formats in which functions can be written. Part of me likes the flexibility of being able to write the same things using spaces, periods, parentheses, or some combination of all those things. However, another part of me wants to rebel against the sheer number of ways to represent the same thing. I think that some of my code was less readable (and certainly less elegant) at the end of the assignment because I had combined different styles within the same function. I'm sure that the designers chose this to provide the user with a lot of flexibility. Perhaps they wanted to appeal to a broader range of users or increase the functionality of more operations. For me, this became too much and I feel as though I sacrificed elegance in some parts of my code. 

## Future Progress in Scala
_What Scala features would you like to learn more about?_

I am very curious to learn more about classes and objects in Scala. Most of my experience is with Object Oriented languages like Java, so thinking about Scala in this format might make more sense to me than doing functional programming. I am also eager to learn more design patterns that will be used in the creation of our DSLs. Knowing these patterns will help me think more about how certain languages are designed and the different components that will go into our own implementations.
