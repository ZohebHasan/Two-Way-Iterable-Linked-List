package cse214hw1;

import java.util.Iterator;

public class test {
    public static void main(String[] args) {

/*     TODO 2. Implementing the CollectionType methods: [15 points]
        Testing: boolean add(E element)
        Testing: boolean remove(E element)
        DoublyLinkedList<String> lst = new DoublyLinkedList<>(); lst.add("a"); lst.add("b"); lst.add("c"); lst.add("b"); lst.remove("b");
        Expected: ["a", "c", "b"]; Obtained [a,b,c,b]. [-1]
        Testing: int size()
        Testing: boolean isEmpty()
        Testing: boolean contains(E element)
        "for (int i = 30; i > 0; i--) lst.add(Integer.toString(i)); lst.contains("5")" returns false. [-2]
        Obtained: 11 out of 15
*/

//        DoublyLinkedList<String> lst = new DoublyLinkedList<>();
////        lst.add("a");
////        lst.add("b");
////        lst.add("c");
////        lst.add("b");
////        lst.remove("b");
////        System.out.println(lst.toString());
//
//        for (int i = 30; i > 0; i--)
//             lst.add(Integer.toString(i));
//        System.out.println(lst.contains("5"));

/*     TODO 3. Implementing the ListAbstractType methods: [15 points]
         Testing: E get(int index)
         Testing: E set(int index, E element)
         Testing: void add(int index, E element)
         add(0,0) to empty list of integers throws java.lang.NullPointerException: Cannot read field "next" because
         "temp" is null. [-1]
         add(2,4) to [0, 1, 9] throws java.lang.NullPointerException: Cannot read field "next" because "temp"
         is null. [-1]
         On lst = ["same", "same", "same", "same"], calling add(lst.size(), "different") results in exception
         java.lang.NullPointerException: Cannot read field "next" because "temp" is null;  [-2]
         Testing: void remove(int index)
         Obtained: 11 out of 15
*/
//
//        DoublyLinkedList lst = new DoublyLinkedList<>();
//        lst.add(0);
//        lst.add(1);
//        lst.add(9);
//        System.out.println(lst.toString());
//        lst.add(2,4); //Cmpiles //Apply
//        System.out.println(lst.toString());

//        DoublyLinkedList<String> lst = new DoublyLinkedList<>();
//        lst.add("same");
//        lst.add("same");
//        lst.add("same");
//        lst.add("same");
//        lst.add(lst.size(), "different");
//        System.out.println(lst.toString());

/*     TODO 4. Implementing a two-way iterator: [15 points]
        Testing: 'E next()' and 'boolean hasNext()'
        Testing: 'E previous()' and 'boolean hasPrevious()'
        Iterating over [1.12, 1.13, 1.25, 1.5] from its end in reverse order using previous() and
        hasPrevious() throws exception java.lang.NullPointerException: Cannot invoke
        "cse214hw1.DoublyLinkedList$Node.getPrev()"
        because "this.current" is null; [-3]
        On the list [1.0, 1.1, 1.2] with iterator 'it', calling 'set(-1.0)' after a single call to
        'it.next()' yields [1.0,-1.0,1.2];
        expected [-1.0, 1.1, 1.2]. [-1.5]
        Obtained: 10.500000 out of 15
 */

        DoublyLinkedList lst = new DoublyLinkedList<>();
        lst.add(1.12);
        lst.add(1.13);
        lst.add(1.25);
        lst.add(1.5);
        System.out.println(lst.toString());
        TwoWayListIterator it = lst.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next()); //should print
//        System.out.println(it.next()); //should print
//        it.set(-1.0); //appeal
//        System.out.println(lst.toString());
//
//
//        System.out.println(it.next()); //should print
//        System.out.println(it.next()); //should print
//        System.out.println(it.next()); //should print
//        System.out.println(it.next()); //should print



        System.out.println(it.hasPrevious()); //Compiles
//        System.out.println(it.previous()); //Compiles
//        System.out.println(it.previous()); //Compiles
//        System.out.println(it.previous()); //Compiles
//        if (it.hasPrevious()) {
//            System.out.println("Im here");
//            System.out.println(it.previous()); //should print
//        }
//        if(lst.iterator().hasPrevious()) {
//            System.out.println("Im here2");
//            System.out.println(lst.iterator().previous());//should print
//        }
//        if(lst.iterator().hasPrevious()) {
//            System.out.println("Im here3");
//            System.out.println(lst.iterator().previous()); //should not print
//        }
//        if(it.hasPrevious())
//            System.out.println(it.previous()); //should not print


//        while(it.hasPrevious()) //Compiles
////            System.out.println("I'm here");
//            System.out.println(it.previous()); //Compiles
//       it.set(-1.0); //compiles
//       System.out.println(lst.toString());
        }
    }

