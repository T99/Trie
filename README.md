# Trie - String storage data structure
A generically-typed trie data structure.
Pronounced 'try' (not 'tree'!), a trie is a node-based/tree-type data structure that allows for extremely fast additions and deletions from what is effectively a map of string(s) to values.

Take the following ascii-art representation:
```

                               C                                   | - CAR      
                   -------------------------                       | - CART     
                  /                         \                      | - CARTS    
               A                               R                   | - CAT      
          -----------                     -----------              | - CATTY     All of the words
         /           \                   /           \             | - CATS     to the right of the
       R               T               A               O           | - CRATE    trie are words that
     -----           -----           -----           -----         | - CRAZE      are retrievable
    /     \         /     \         /     \         /     \        | - CRAZY       from the trie.
   T       P       T       S       T       Z       W       O       | - CROW     
  ---     ---     ---     ---     ---     ---     ---     ---      | - CROWN    
  /               /               /       / \     / \     / \      | - CROWS    
 S               Y               E       E   Y   N   S   N   K     | - CROON    
---             ---             ---     --- --- --- --- --- ---    | - CROOK    

```

The above structure is a visual representation of a trie. It stores strings in a tree as you can see above. A structure such as this can be invaluable when storing and searching extremely large numbers of strings. I was able to return 34 results for the query 'crash' in ~1ms from a list of 1,049,937 strings.
