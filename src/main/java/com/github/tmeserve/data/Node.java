package com.github.tmeserve.data;

import org.bukkit.entity.Player;

// I used this website to make this linked list
// https://www.devglan.com/datastructure/circular-linked-list-java

public class Node
{
    private Player data;
    private Node nextNode;

    public Node(Player data)
    {
        this.data = data;
    }

    public Player getData() { return this.data; }

    public void setData(Player data) { this.data = data; }

    public Node getNextNode() { return nextNode; }

    public void setNextNode(Node nextNode) { this.nextNode = nextNode; }

}
