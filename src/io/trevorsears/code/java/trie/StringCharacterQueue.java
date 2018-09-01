/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 6:30 PM -- August 27th, 2018.
 * Classpath: io.trevorsears.code.java.trie.StringCharacterQueue
 */

package io.trevorsears.code.java.trie;

class StringCharacterQueue {
	
	private int index = 0;
	private String iterationContent;
	
	StringCharacterQueue(String iterationContent) {
		
		this.iterationContent = iterationContent;
		
	}
	
	boolean hasNext() {
		
		return index <= iterationContent.length() - 1;
		
	}
	
	Character getNext() {
		
		if (index <= iterationContent.length() - 1) {
			
			Character result = iterationContent.substring(index, index + 1).charAt(0);
			index++;
			return result;
			
			
		} else return null;
		
	}
	
}