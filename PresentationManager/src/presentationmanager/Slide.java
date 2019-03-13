//Dennis Lin
//109426873
//dennis.lin@stonybrook.edu
//HOMEWORK 2
//CSE 214
//Vladimir Yevseenko 

package presentationmanager;

public class Slide {
    
    public static final int MAX_BULLETS = 5;
    
    private String title;
    private String[] bullets;
    private double duration;
    private int NumBullets = 0;
    
    /**
     * Constructor 
     * @param title
     * @param bullets
     * @param duration 
     */
    public Slide(String title, String[] bullets, double duration){
        this.title = title;
        this.bullets = bullets;
        this.duration = duration;
        for (String s : this.bullets)
            if (s != null)
                NumBullets++;
    }
    
    /**
     * Public getter method for the title member variable.
     * @return title
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * Public setter method for the title member variable.
     * @param newTitle 
     */
    public void setTitle(String newTitle){
        this.title = newTitle;
    } 
    
    /**
     * Public getter method for the duration 
     * @return duration
     */
    public double getDuration(){
        return duration;
    }
    
    /**
     * Public setter method for the duration member variable.
     * @param newDuration 
     */
    public void setDuration(double newDuration){
        this.duration = newDuration;
    }
    
    /**
     * Gets the total number of bullet point in the Slide.
     * @return number of bullets
     */
    public int getNumBullets(){
        return this.NumBullets;
    }
    
    /**
     * Gets the bullet point at index i.
     * @param i
     * @return the bullet
     * @throws IllegalArgumentException 
     */
    public String getBullet(int i)throws IllegalArgumentException{
        if(i < 1 || i > MAX_BULLETS)
            throw new IllegalArgumentException();
        else
            return bullets[i-1];
    }
    
    /**
     * Sets bullet as the i'th bullet point for bullets. If bullet is null, this method erases the bullet point at index i and pushes all bullet points greater than i back one index.
     * @param bullet
     * @param i
     * @throws IllegalArgumentException 
     */
    public void setBullet(String bullet, int i)throws IllegalArgumentException{    
        if(i < 1 && i > MAX_BULLETS)
            throw new IllegalArgumentException();
        else{
            for(int j = 0;j < MAX_BULLETS -1; j++)
                bullets[j] = bullets[j+1];                
        NumBullets--;
        }
    }
    
    public void printslide(){
        System.out.println(this);
    }
    
    @Override
    public String toString(){
        //String Bullets = "";
        String longline = "==============================================";
        System.out.println(longline);
        System.out.println(getTitle());
        System.out.println(longline);
        for(int i= 0; i < MAX_BULLETS; i++){
            if (bullets[i] == null)
                continue;
            System.out.print(i);
            System.out.println(bullets[i]);
           
        }
        System.out.println(longline);        
        return "";
    }
    
}

