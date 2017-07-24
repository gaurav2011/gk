package com.lightbend.akka.sample

import akka.actor.{Actor,ActorSystem, Props}

class ActorStop extends Actor{
  def receive = {
    case message:String => println("Message received: "+message)
    case _ => println("Unknown message")
  }
  override def postStop(){
    println("Actor stoped")
  }
}

object ActorStop{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem")
    val actor = actorSystem.actorOf(Props[ActorExample], "RootActor")
    actor ! "Hello"
    actorSystem.stop(actor)
  }
}
