package com.github.tmeserve.data;

import org.bukkit.entity.Player;

// I used this website to make this linked list
// https://www.devglan.com/datastructure/circular-linked-list-java

public class CircularLinkedList
{
    private Node head;
    private Node tail;

    public void insert(Player data)
    {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else
            tail.setNextNode(newNode);
        
            tail = newNode;
            tail.setNextNode(head);
    }

    public boolean search(Player data)
    {

        if (head == null)
            return false;
        else
        {
            Node currentNode = head;
            while (currentNode.getNextNode() != head)
            {
                if (currentNode.getData() == data)
                    return true;
                
                currentNode = currentNode.getNextNode();
            }
        }
        
        return false;
    }

    public void delete(Player data)
    {
        Node currentNode = head;
        if (head != null)
        {
            if (currentNode.getData() == data)
            {
                head = currentNode.getNextNode();
                tail.setNextNode(head);
            }
            else
            {
                while (currentNode.getNextNode() != head)
                {
                    if (currentNode.getNextNode().getData() == data)
                    {
                        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                        break;
                    }
                    currentNode = currentNode.getNextNode();
                }
            }
        }
    }

    public String traverse()
    {
        String toReturn = "";
        if (head != null)
        {
            Node currentNode = head;
            while (currentNode.getNextNode() != head)
            {
                toReturn += currentNode.getData().getName() + " ";
                currentNode = currentNode.getNextNode();
            }

            toReturn += tail.getData().getName();
        }
        return toReturn;
    }

}
