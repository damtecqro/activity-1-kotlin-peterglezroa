/*
  __AUTHOR__: Pedro Luis González Roa
  __STUDENT ID__: A01651517
  __PROBLEM #__: 09
  __DIAGRAM__ : https://drive.google.com/file/d/1Pb5SPlQfuGBtulM4p7lCR-S8EeaWffOa/view?usp=sharing
*/
// Problem 09
fun main(args: Array<String>){
  println("Problema 09:\n");
  var list : List<Char> = emptyList();
  var actual : Char = ' ';
  for(letter in args[0]){
    if(letter != actual){
      actual = letter;
      list += actual;
    }
  }
  for(letter in list){
    print(letter + " ");
  } 
  println();
}
