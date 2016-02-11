# Scala thoughts

- _What's easy to do in Scala? What's not?_
I think the easiest (and best) thing about Scala is how easy it is to draw from knowledge in different programming styles. For example, Scala lets you combine functional programming and OOP easier than any other language I've tried. It's really intuitive to use maps and filters and the like, and I think it's really easy to write readable code. I actually like the fact that there are no return statements.

In Scala, it's hard to get away with not specifying types. I could also imagine it being hard to do some elements of imperative programming, like looping, but I haven't had enough exposure just yet to say that with certainty.

- _What is/are your favorite language design choice(s) that the designers of Scala made? Why?_
As I said in the previous section, ease of use in combining functional and OO programming is really quite good. I like the simplicity of the syntax in not having return statements, and I like how easy it is to define and use stuff. Most of our code was one-liner-y, so it's hard to say what will happen in larger programs, but I like how easy it is to perform and keep track of multiple operations at once.

- _What is/are your least favorite language design choice(s)? Why? And why do you think the designers made that / those choice(s)?_
I don't think this is a design thing, but the error messages I got were *really* frustrating and I wish there were better ones. I imagine this is a mix of Scala and ScalaIDE which contributes to this problem, but I find it really frustrating. I also think that some elements of imperative programming could be done better -- looping and the like. Maybe it's just a lack of exposure issue, but I did find that rather frustrating.

I'm also yet to be convinced of the efficacy of the classes structure. I am still trying to wrap my head around traits and abstract classes and objects within classes and apply methods and all of that jazz. Possibly with time, this will all make sense, but at the moment (and for the level of simplicity that we used it) it just seems like a lot of slightly different ways to say basically the same thing. I hope to learn more about this design decision soon.

- _What Scala features would you like to learn more about?_
Definitely the classes! This is the thing I've come away from feeling most vague. Also, in today (Wednesday)'s class, we went briefly over some weird stuff as relates to ints and doubles, and this got me thinking that type systems are also really interesting here. I saw the type Any which is really similar to Haskell, and read online about Unit which acts similar to Java's void, but how is the whole structure set up? I'd love to learn more about it.