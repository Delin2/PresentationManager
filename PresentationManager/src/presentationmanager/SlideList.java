//Dennis Lin
//109426873
//dennis.lin@stonybrook.edu
//HOMEWORK 2
//CSE 214
//Vladimir Yevseenko 
package presentationmanager;

public class SlideList {

    private SlideListNode head;
    private SlideListNode tail;
    private SlideListNode cursor;
    public static int size = 0;

    /**
     * Constructor
     */
    public SlideList() {
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * Number of slides
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Gets the reference to the Slide wrapped by the SlideListNode currently
     * referenced by cursor.
     *
     * @return the Slide at Cursor
     */
    public Slide getCursorSlide() {
        if (cursor == null) {
            return null;
        } else {
            return cursor.getData();
        }
    }

    /**
     * Reset the cursor back to head
     */
    public void resetCursorToHead() {
        cursor = head;
    }

    /**
     * moves cursor forward
     *
     * @throws EndOfListException
     */
    public void cursorForward() throws EndOfListException {
        if (cursor == tail) {
            throw new EndOfListException();
        } else {
            cursor = cursor.getNext();
        }
    }

    /**
     * moves cursor backwards
     *
     * @throws EndOfListException
     */
    public void cursorBackward() throws EndOfListException {
        if (cursor == head) {
            throw new EndOfListException();
        } else {
            cursor = cursor.getPrev();
        }
    }

    /**
     * Creates a slide and insert it before the cursor
     *
     * @param newSlide
     * @throws IllegalArgumentException
     */
    public void insertBeforeCursor(Slide newSlide) throws IllegalArgumentException {
        if (newSlide == null) {
            throw new IllegalArgumentException();
        } else if (cursor != null) {
            SlideListNode NS = new SlideListNode(newSlide);
            cursor.getPrev().setNext(NS);
            NS.setPrev(cursor.getPrev());
            NS.setNext(cursor);
            cursor.setPrev(NS);
            cursor = NS;
        } else if (cursor == null) {
            SlideListNode NS = new SlideListNode(newSlide);
            head = NS;
            tail = NS;
            cursor = NS;
        }
    }

    public Slide removeCursor() throws EndOfListException {
        Slide rC = cursor.getData();
        if (cursor == null) {
            throw new EndOfListException();
        } else if (cursor == head) {
            cursor = cursor.getNext();
            cursor.setPrev(null);
        } else if (cursor == tail) {
            cursor = cursor.getPrev();
            cursor.setNext(null);
        } else {
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
        }
        size++;
        return rC;
    }

    /**
     * Inserts the indicated Slide after the tail of the list.
     *
     * @param newSlide
     */
    public void appendToTail(Slide newSlide) throws IllegalArgumentException {
        if (newSlide == null) {
            throw new IllegalArgumentException();
        } else if (tail == null) {
            SlideListNode aT = new SlideListNode(newSlide);
            head = aT;
            tail = aT;
            cursor = aT;
        } else if (tail != null) {
            SlideListNode aT = new SlideListNode(newSlide);
            aT.setPrev(tail);
            tail.setNext(aT);
            tail = aT;
        }
        size++;
    }

    public void printSummary() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String Slides = "";
        SlideListNode temp = head;
        int i = 1;
        System.out.println("Slideshow Summary:" + "==============================================\n");
        System.out.printf("%-10s%-10s%-10s%-10s", "Slide", "Title", "Duration", "Bullets");
        System.out.println("\n==============================================\n");
        while (temp != null) {
            Slides += String.format("%-10d%-10s" + i + head.getData().getTitle()) + "\n";
            System.out.printf("%-10d%-10s" + i + head.getData().getTitle());
            System.out.println();
            i++;
        }
        return Slides;
    }
}
