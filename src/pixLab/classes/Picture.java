package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.math.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  ///// colors /////
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /**
   * Method to set every value except blue to 0
   */
  public void keepOnlyBlue()
  {
	    Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  
  
  ///// mirrors /////
  
  /** Method that mirrors the picture around a 
    * vertical axis in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
   * vertical axis in the center of the picture
   * from right to left */
  public void mirrorRightToLeft()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  int width = pixels[0].length;
	  
	  for (int row = pixels.length - 1; row >= 0; row--)
	  {
		  for (int col = width / 2 - 1; col >= 0; col--)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  /** Method that mirrors the picture across a 
   * horizontal axis in the center of the picture
   * from bottom to top */
  public void mirrorHorizontalBottomToTop()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  
	  int height = pixels.length;
	  
	  //loop over columns
	  //inside the columns loop over half the rows
	  //change top pixel to the bottom's color
	  
	  for (int col = 0; col < pixels[0].length; col++)
	  {
		  for (int row = height / 2 - 1; row >= 0; row-- )
		  {
		    topPixel = pixels[row][col];
			bottomPixel = pixels[height-row-1][col];
			topPixel.setColor(bottomPixel.getColor());
		  }
	  }
	  
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorSnowman()
  {
	  int mirrorPoint = 208;
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 158; row < mirrorPoint; row++)
	    {
	      for (int col = 95; col < 295; col++)
	      {
	        topPixel = pixels[row][col];      
	        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    }
  }
  
  public void mirrorGulls()
  {
	  int mirrorPoint = 350;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 230; row < 330; row++)
	    {
	      for (int col = 230; col < mirrorPoint; col++)
	      {
	    		leftPixel = pixels[row][col];      
	 	        rightPixel = pixels[row + 25][mirrorPoint - col + mirrorPoint];
	 	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  
  public void mirrorDiagonal()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topRight = null;
	  Pixel botLeft = null;
	  
	  for (int row = 0; row <  pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  if (row != col && row < pixels[0].length && col < pixels.length)
			  {
				  topRight = pixels[row][col];
				  botLeft = pixels[col][row];
				  
				  botLeft.setColor(topRight.getColor());
			  }
		  }
	  }
  }
  
  /** Part 2 */
  public void mirrorDiagonalBottomRightToTopLeft()
  {
	  Pixel botRight = null;
	  Pixel topLeft = null;
	  
	  Pixel [][] pixels = this.getPixels2D();
	  int mirrorPoint = Math.min(pixels.length, pixels[0].length) - 1;
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  if (row + col != mirrorPoint && row < pixels[0].length && col < pixels.length)
			  {
				  topLeft = pixels[row][col];
				  botRight = pixels[mirrorPoint - col][mirrorPoint - row];
				  
				  topLeft.setColor(botRight.getColor());
			  }
		  }
	  }
	  
  }
  
  ///// others /////
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copyPortion(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
	  	Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPic.getPixels2D();
	    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length && toRow < endRow; fromRow++, toRow++)
	    {
	      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length && toCol < endCol; fromCol++, toCol++)
	      {
	        fromPixel = fromPixels[fromRow][fromCol];
	        toPixel = toPixels[toRow][toCol];
	        toPixel.setColor(fromPixel.getColor());
	      }
	    }   
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
	    Picture ayy = new Picture("ayylmao.jpg");
	    Picture arch = new Picture("arch.jpg");
	    Picture ayyRed = new Picture("ayylmao.jpg");
	    //ayyRed.fullRandomRed(Color.RED);
	    
	    ayy.zeroBlue();
	    this.copy(ayy, 0, 0);
	    this.copy(arch, 100, 247);
	    this.copyPortion(ayyRed, 20, 154, 200, 320);
	    this.mirrorVertical();
	    this.write("collage.jpg");
	    
  }

  
  /**
   * Change some percentage of an images pixels to a diff color, with Math.random and a specified color to change
   * could use to have say the yellow bird all pixelated with rainbow pixels. 
   * 
   * TODO : Need to add param with color to change from and color to 
   * change to
   */
  public void fullRandomColor(Color colorToChange, Color colorToChangeTo)
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for (Pixel [] row : currentPicture)
	  {
		  for (Pixel currentPixel : row)
		  {
			  
			// if (currentPixel.getcolor == specified color passed by param)
//			  if (currentPixel.getBlue() == colorToChange.getBlue()
//					  && currentPixel.getRed() == colorToChange.getRed() 
//					  && currentPixel.getGreen() == colorToChange.getGreen())
			  if (currentPixel.colorDistance(colorToChange) > 60 && currentPixel.colorDistance(colorToChange) < 70)
			  {
//					int red = (int) (Math.random() * 256);  
//					int green = (int) (Math.random() * 256);  
//					int blue = (int) (Math.random() * 256);  
					
				  int red = colorToChangeTo.getRed();
				  int green = colorToChangeTo.getGreen();
				  int blue = colorToChangeTo.getBlue();
				  
				  currentPixel.setColor(new Color(red, green, blue)); 
			  }
		  }
	  }
  }
  
  public void glitchAyy()
  {
	  Picture eye = new Picture("sqeye.png");
	  Picture cody = new Picture("cody.png");
	  this.copyPortion(eye, 100, 130, 370, 470);
	  this.copyPortion(eye, 120, 150, 325, 425);
	  //this.fullRandomColor(new Color(255,211,1), new Color(195,48,148));

	  //cody.getBufferedImage().createGraphics().drawRoundRect(0, 0, 10, 10, 5, 5);
	 
	  cody.addMessage("Yasssss", 15, 80);
	  this.copyPortion(cody, 200, 400, 500, 585);
	  
	
	  this.blackToWhitePixelated();
	  
	  this.randomSmear();
	  this.write("glitchArt_trippyDrippy.png");
	  
	  
  }
  
  /**
   * Method to shift pixels either up/down a row or left/right a collumn.
   * Params: startRow, endRow, startCol, endCol, shiftRow, shiftCol, noiseAmount int
   */
  public void pixelShift()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			 // pixels[row][col].setColor();
		  }
	  }
	// pixels[row + shiftRow][col + shiftCol]  
  }
  
  
  
  
  // Method to set orange bird to grayscale. Loop over all pixels, then test that the pixel is orange
  // with like: r > 175 && r < 260 && g > 0 && g < 100 && b >= 0 and b < 10; then set the color to a 
  // shifted gray color
  
  
  // change all black to white? thatd be cool too
  public void blackToWhitePixelated()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	int red = pixelObj.getRed();
	    	int green = pixelObj.getGreen();
	    	int blue = pixelObj.getBlue();

	 
	    	if (red < 5 && green < 5 && blue < 5 )
	        	
	        {
	        	pixelObj.setColor(Color.WHITE);
	        	
	        }
	      }
	    }
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist)
        {
        	leftPixel.setColor(Color.BLACK);
        } else {
            leftPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  public void randomSmear()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < pixels.length -1; row++)
	  {
		  for (int col = 0; col < pixels[0].length -1; col++)
		  {
			  double random = Math.random();
			  // About a 10% chance of having a given pixel be "smeared", can be adjusted.
			  if (random < .02)
			  {
				  pixels[row][col].setColor(Color.MAGENTA);
			  }
			  else if (random > .98)
			  {
				  pixels[row][col].setColor(Color.WHITE);
			  }  
		  }
	  }
  }
  
  public void betterEdgeDetection(int edgeDist) 
  {
	  Pixel basePixel = null;
	  Pixel rightPixel = null;
	  Pixel botPixel = null;
	  
	  Pixel [][] pixels = this.getPixels2D();
	  
	  Color rightColor = null;
	  Color botColor = null;
	  for (int row = 0; row < pixels.length -1; row++)
	  {
		  for (int col = 0; col < pixels[0].length -1; col++)
		  {
			  basePixel = pixels[row][col];
		      rightPixel = pixels[row][col+1];
		      botPixel = pixels[row+1][col];
		      
		      rightColor = rightPixel.getColor();
		      botColor = botPixel.getColor();
		      if (basePixel.colorDistance(rightColor) > edgeDist && basePixel.colorDistance(botColor) > edgeDist)
		      {
		    	  basePixel.setColor(Color.BLACK);
		      } else {
		    	  basePixel.setColor(Color.WHITE);
		      }
		  }
	  }
  }
  
  public void valentinesMeme()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < pixels.length - 1; row++)
	  {
		  for (int col = 0; col < pixels[0].length - 1; col++)
		  {
			  if (pixels[row][col].getRed() > 240 && pixels[row][col].getGreen() > 240)
			  {
				  pixels[row][col].setColor(Color.RED);
			  }
		  }
	  }
	  this.addMessage("I", 65, 71);
	  this.addMessage("S", 90, 116);
	  this.addMessage("JAVA", 140, 50);
	  this.addMessage("if (<3 > 3) { print(\"iluvu\")}", 30, 25);
	  this.write("valentinesMemeHearts.jpg");
	  
	  
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    
  }
  
  public void encode(Picture hiddenPicture)
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  Pixel [][] hiddenData = hiddenPicture.getPixels2D();
	  
	  Pixel hiddenPixel = null; 
	  Pixel currentPixel = null;
	  
	  for(int row = 0; row < currentPicture.length; row++)
	  {
		  for(int col = 0; col < currentPicture[0].length; col++)
		  {
			  hiddenPixel = hiddenData[row][col];
			  currentPixel = currentPicture[row][col];
			  
			  if(hiddenPixel.getRed() == 255 && hiddenPixel.getGreen() == 255 && hiddenPixel.getBlue() == 255)
			  {
				  int currentRed = currentPixel.getRed();
				  if(currentRed % 2 == 0)
				  {
					  currentPixel.setRed(currentRed + 1);
				  }
			  }
			  else
			  {
				  int currentRed = currentPixel.getRed();
				  if(currentRed % 2 != 0)
				  {
					  currentPixel.setRed(currentRed - 1);
				  }
			  }
		  }
	  }
	  this.write("encrypted.png");
	  this.explore();
  }
  
  public void decode()
  {
	  Pixel[][] decoded = this.getPixels2D();
	  Pixel currentPixel = null;
	  
	  for(int row = 0; row < decoded.length; row++)
	  {
		  for(int col = 0; col < decoded[0].length; col++)
		  {
			  currentPixel = decoded[row][col];
			  int currentRed = currentPixel.getRed();
			  if(currentRed % 2 == 0)
			  {
				  currentPixel.setColor(new Color(127, 255, 0));
			  }
		  }
	  }
	  
	  this.explore();
  }
} // this } is the end of class Picture, put all new methods before this
