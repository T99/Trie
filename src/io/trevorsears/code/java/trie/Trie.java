/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:09 PM -- August 27th, 2018.
 * Classpath: io.trevorsears.code.java.trie.Trie
 */

package io.trevorsears.code.java.trie;

import java.util.ArrayList;

public class Trie<V> {
	
	private TrieNode<V> rootNode;
	
	public Trie() {
		
		rootNode = new TrieNode<V>(null, null);
		
	}
	
	public void add(String string, V value) {
		
		StringCharacterQueue stringCharacterQueue = new StringCharacterQueue(string);
		TrieNode<V> currentNode = rootNode;
		
		while (stringCharacterQueue.hasNext()) {
			
			Character currentCharacter = stringCharacterQueue.getNext();
			
			if (currentNode.hasChild(currentCharacter)) currentNode = currentNode.getChild(currentCharacter);
			else {
				
				TrieNode<V> nextNode = new TrieNode<V>(currentCharacter, currentNode);
				currentNode.addChild(nextNode);
				currentNode = nextNode;
				
			}
			
		}
		
		currentNode.setValue(value);
	
	}
	
	public boolean remove(String string) {
		
		TrieNode<V> currentNode = searchForNode(string);
		
		if (currentNode == null) return false;
		else if (!currentNode.hasValue()) return false;
		else {
			
			currentNode.removeValue();
			
			if (currentNode.hasChildren()) return true;
			else {
				
				while (!currentNode.hasValue() && !currentNode.hasChildren()) {
					
					TrieNode<V> parentNode = currentNode.getParent();
					parentNode.removeChild(currentNode.getCharacter());
					currentNode = parentNode;
					
				}
				
				return true;
				
			}
			
		}
		
	}
	
	private TrieNode<V> searchForNode(String query) {
		
		StringCharacterQueue stringCharacterQueue = new StringCharacterQueue(query);
		TrieNode<V> currentNode = rootNode;
		
		while(stringCharacterQueue.hasNext()) {
			
			Character currentCharacter = stringCharacterQueue.getNext();
			
			if (currentNode.hasChild(currentCharacter)) currentNode = currentNode.getChild(currentCharacter);
			else return null;
			
		}
		
		return currentNode;
		
	}
	
	public ArrayList<V> search(String query) {
		
		TrieNode<V> rootNode = searchForNode(query);
		
		if (rootNode == null) {
			
			return new ArrayList<>(0);
			
		} else {
			
			return getAllValuesIn(rootNode);
			
		}
		
	}
	
	private ArrayList<V> getAllValuesIn(TrieNode<V> node) {
		
		ArrayList<V> values = new ArrayList<>();
		TrieNode<V> currentNode = node;
		if (node.hasValue()) values.add(node.getValue());
		
		if (node.hasChildren()) {
			
			for (TrieNode<V> nodes : node.getChildArray()) {
				
				values.addAll(getAllValuesIn(nodes));
				
			}
			
		}
		
		return values;
		
	}
	
}