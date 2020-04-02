/*
  __AUTHOR__: Pedro Luis González Roa
  __STUDENT ID__: A01651517
  __PROBLEM #__: 67
  __DIAGRAM__: https://drive.google.com/file/d/1Pb5SPlQfuGBtulM4p7lCR-S8EeaWffOa/view?usp=sharing
*/
import java.util.Stack

// Problem 67
interface Tree<out T>

data class Node<out T>(val value: T, val left: Tree<T> = End, val right: Tree<T> = End) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " $left $right"
        return "T($value$children)"
    }
}

val End = object : Tree<Nothing>{
    override fun toString() = "."
}

fun main(args: Array<String>){
  var tree = string2Tree(args[0]);
  println("final: " + tree);
}

fun string2Tree(string:String): Tree<String>{
  var actual: Tree<String> = End;
  var prev: Tree<String> = End;
  var actual_string: String = "";
  var aux: String;
  var stack: Stack<String> =Stack<String>();
  var node_stack: Stack<Tree<String>> = Stack<Tree<String>>();
  var child: Boolean = false;

  for(letter in string){
    if(letter == '('){
      child = true;
      stack.push(actual_string);
      stack.push("(");
      actual_string = "";
    }else if(letter == ','){
      node_stack.push(Node(actual_string));
      actual_string = "";
      stack.push(",");
      actual = End;
    }else if(letter == ')'){
      if(actual == End && actual_string != ""){
        actual = Node(actual_string);
      }
      aux = stack.pop();
      while(aux != "("){
        if(aux == ","){
          prev = node_stack.pop()
        }
        aux = stack.pop()
      }
      actual = Node(stack.pop(), prev, actual)
      println(actual);
      prev = End;
    }else{
      actual_string += letter;
    }
  }
  if(!child){
    return Node(actual_string);
  }
  return actual;
}
