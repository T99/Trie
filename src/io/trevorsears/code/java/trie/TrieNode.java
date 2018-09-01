/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:09 PM -- August 27th, 2018.
 * Classpath: io.trevorsears.code.java.trie.TrieNode
 */

package io.trevorsears.code.java.trie;

import java.util.ArrayList;
import java.util.TreeMap;

class TrieNode<V> {
	
	private TrieNode<V> parent;
	private Character character;
	private String current;
	private V value = null;
	private TreeMap<Character, TrieNode<V>> children = new TreeMap<>();
	
	TrieNode(Character character, TrieNode<V> parent) {
		
		this.parent = parent;
		this.character = character;
		
	}
	
	Character getCharacter() {
		
		return character;
		
	}
	
	String getTrieBranch() {
		
		TrieNode<V> currentNode = this;
		StringBuilder trieBranch = new StringBuilder();
		
		do {
			
			trieBranch.insert(0, character.toString());
			currentNode = getParent();
			
		} while (currentNode.getCharacter() != null);
		
		return trieBranch.toString();
		
	}
	
	boolean removeValue() {
		
		if (this.value == null) return false;
		else {
			
			this.value = null;
			return true;
			
		}
		
	}
	
	void setValue(V value) {
		
		this.value = value;
		
	}
	
	
	
	boolean hasValue() {
		
		return !(value == null);
		
	}
	
	V getValue() {
		
		return value;
		
	}
	
	TrieNode<V> getParent() {
		
		if (this.parent != null) return parent;
		else return null;
		
	}
	
	void addChild(TrieNode<V> child) {
		
		children.put(child.getCharacter(), child);
		
	}
	
	TrieNode<V> getChild(Character character) {
		
		return children.getOrDefault(character, null);
		
	}
	
	boolean removeChild(Character character) {
		
		if (children.containsKey(character)) {
			
			children.remove(character);
			return true;
			
		} else return false;
		
	}
	
	boolean hasChild(Character character) {
		
		return children.containsKey(character);
		
	}
	
	boolean hasChildren() {
		
		return !children.isEmpty();
		
	}
	
	ArrayList<TrieNode<V>> getChildArray() {
		
		if (children.isEmpty()) return new ArrayList<>();
		return new ArrayList<>(children.values());
		
	}
	
}