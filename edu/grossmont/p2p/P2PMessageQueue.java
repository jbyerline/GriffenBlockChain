package edu.grossmont.p2p;

/**
 * Created by rgillespie on 8/6/2018.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    public synchronized void enqueue(P2PMessage oMessage){

		if ( head == null && tail == null){
			head = oMessage;
			head.next = null;
			tail = oMessage;
			tail.next = null;
		}

		else{
			P2PMessage tempPerson = new P2PMessage();
			tempPerson.next = tail.next;
			tempPerson.setMessage(tail.getMessage());
			tail = oMessage;
			tail.next = tempPerson;
		}
    }


    public synchronized P2PMessage dequeue(){

		P2PMessage tempValue = new P2PMessage();
		tempValue = head;
		if ( head == null && tail == null){
			//System.out.println(" You cannot dequeue an empty queue");
		}

		else if( head == tail){

			head = null;
			tail = null;

		}

		else if(tail.next == head){

			head = tail;
			tail.next = null;
			head.next = null;

		}

		else{
			P2PMessage tempPerson = new P2PMessage();
			tempPerson.next = tail.next;
			tempPerson.setMessage(tail.getMessage());

			while(tempPerson.next != head){
				tempPerson = tempPerson.next;
			}
			head = tempPerson;
			head.next = null;

		}
		return tempValue;
    }


    public boolean hasNodes(){


		if(head != null){
			return true;
		}
		else {
			return false;
		}

    }
}
