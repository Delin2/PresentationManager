//Dennis Lin
//109426873
//dennis.lin@stonybrook.edu
//HOMEWORK 2
//CSE 214
//Vladimir Yevseenko 

package presentationmanager;

public class SlideListNode {
    
    private Slide data;
    private SlideListNode next;
    private SlideListNode prev;
   
    public SlideListNode(Slide initData)throws IllegalArgumentException{
        if(initData == null)
            throw new IllegalArgumentException ();
        this.data = initData;
    }
    
    public Slide getData(){
        return data;
    }
    
    public void setData(Slide newData){
        if(data != null){
            data = newData;
        }else throw new IllegalArgumentException("Your Data is invalid");
    }
    
    public SlideListNode getNext(){
        return next;
    }
    
    public void setNext(SlideListNode newNext){
        next = newNext;
    }
    
    public SlideListNode getPrev(){
        return prev;
    }
    
    public void setPrev(SlideListNode newPrev){
        prev = newPrev;
    }
}
