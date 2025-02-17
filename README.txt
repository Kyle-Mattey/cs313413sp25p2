COMP 313/413 Project 2 Report Template

TestList.java and TestIterator.java

TODO also try with a LinkedList - does it make any difference?

Yes, switching from ArrayList to LinkedList makes a difference.
	•	Accessing elements (get(index)) is slower in LinkedList because it has to go through the list node by node, while ArrayList can just jump to the index instantly.
	•	Adding/removing elements is faster in LinkedList when working at the beginning or middle, since it doesn’t have to shift elements like ArrayList does. However, if you’re adding/removing at the end, ArrayList is just as fast.
	•	Memory usage is higher in LinkedList because each item stores extra pointers to the previous and next nodes.

So, ArrayList is better for quick lookups, while LinkedList is better if you’re constantly inserting or removing things in the middle.

TestList.java

testRemoveObject()

list.remove(5); - What does this method do?

This removes the element at index 5, NOT the actual number 5.
If the list has fewer than 6 items, this will cause an IndexOutOfBoundsException and crash the program.

list.remove(Integer.valueOf(5)); - What does this one do?

This removes the first occurrence of 5 from the list, if it exists.
If 5 isn’t in the list, nothing happens.
So, this is useful when you want to remove a specific value instead of just an item at a certain index.

TestIterator.java
	testRemove()

    i.remove(); - What happens if you use list.remove(77) instead?

    Using i.remove(); inside the iterator removes the last item that was returned by next().
    If you try to use list.remove(77); instead, it only removes the first 77 it finds in the list.
    But more importantly, calling list.remove(77) while looping with an iterator will throw a ConcurrentModificationException, because modifying a list directly while iterating is not allowed.

    So, stick with i.remove(); when working with iterators to avoid errors.

TestPerformance.java

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.
	These are examples of SIZEs you might choose, you can choose others if you wish.

	Test Execution and Running Times
    	•	The tests were run multiple times with different list sizes (10, 100, 1000, 10000).
    	•	Running times were measured using System.nanoTime(), converted to milliseconds.
    	•	The results were printed using System.out.println().

	SIZE 10
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  val1 val2 val3 val4 val5 val6  ... (fill these in in ms)
        testLinkedListAddRemove: val1 val2 val3 val4 val5 val6
		testArrayListAccess:     val1 val2 val3 val4 val5 val6
        testLinkedListAccess:    val1 val2 val3 val4 val5 val6

	SIZE 100
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  val1 val2 val3 val4 val5 val6  ... (fill these in in ms)
        testLinkedListAddRemove: val1 val2 val3 val4 val5 val6
		testArrayListAccess:     val1 val2 val3 val4 val5 val6
        testLinkedListAccess:    val1 val2 val3 val4 val5 val6

	SIZE 1000
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  val1 val2 val3 val4 val5 val6  ... (fill these in in ms)
        testLinkedListAddRemove: val1 val2 val3 val4 val5 val6
		testArrayListAccess:     val1 val2 val3 val4 val5 val6
        testLinkedListAccess:    val1 val2 val3 val4 val5 val6

	SIZE 10000
								  #1   #2   #3   #4   #5   #6 	... (as many tests as you ran)
        testArrayListAddRemove:  val1 val2 val3 val4 val5 val6  ... (fill these in in ms)
        testLinkedListAddRemove: val1 val2 val3 val4 val5 val6
		testArrayListAccess:     val1 val2 val3 val4 val5 val6
        testLinkedListAccess:    val1 val2 val3 val4 val5 val6

	listAccess - Which type of list is better to use, and why?

    ArrayList is the way to go for fast lookups.
    	•	It lets you access any item instantly (O(1)) because everything is stored in a fixed-size array.
    	•	LinkedList has to scan through the list (O(n)) to find an item, which gets slower as the list grows.

    If you need to look up elements quickly, use ArrayList.

listAddRemove - Which type of list is better to use, and why?

It depends on where you’re adding or removing elements:
	•	If you’re inserting/removing at the start or middle, LinkedList is better because there’s no shifting of elements (it just updates pointers).
	•	If you’re removing from the end, ArrayList is just as fast as LinkedList.
	•	But if you’re inserting/removing anywhere in the middle of an ArrayList, it has to shift everything over, which takes longer (O(n)).

So, LinkedList is better for frequent insertions/removals, but ArrayList is better when you just need to quickly access elements.