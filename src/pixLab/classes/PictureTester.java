package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Dylan Robson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture koala = new Picture("koala.jpg");
	  koala.explore();
	  koala.mirrorRightToLeft();
	  koala.explore();
  }
  
  public static void testMirrorBottomToTop()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontalBottomToTop();
	  caterpillar.explore();
  }
  
  
  /** Method to test mirrorDiagonal */
  public static void testMirorDiagonal()
  {
	  Picture koala = new Picture("koala.jpg");
	  koala.explore();
	  koala.mirrorDiagonal();
	  koala.explore();
  }
  
  public static void testMirorDiagonalBottomRightToTopLeft()
  {
	  Picture koala = new Picture("koala.jpg");
	  koala.explore();
	  koala.mirrorDiagonalBottomRightToTopLeft();
	  koala.explore();
	  koala.write("koalamirror.jpg");
  }
  
  public static void testMirrorSnowman()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorSnowman();
	  snowman.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGulls();
	  gull.explore();
  }
  /**
   * Method to test keepOnlyBlue
   */
  public static void testKeepOnlyBlue()
  {
	   Picture blueMark = new Picture("blue-mark.jpg");
	   blueMark.explore();
	   blueMark.zeroBlue();
	   blueMark.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.myCollage();
	  canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testBetterEdgeDetection()
  {
	  Picture swan = new Picture("swan.jpg");
	  swan.betterEdgeDetection(10);
	  swan.explore();
  }
  
  public static void testFullRandomRed()
  {
	  Picture ayy = new Picture("ayylmao.jpg");
	  ayy.explore();
	  ayy.fullRandomRed();
	  ayy.explore();
  }
  
  public static void testFiveFilters()
  {
	  Picture ayy = new Picture("ayylmao.jpg");
	  ayy.zeroBlue();
	  ayy.mirrorRightToLeft();
	  ayy.mirrorVertical();
	  ayy.addMessage("Ayyy lmao", 100, 100);
	  ayy.copy(new Picture("caterpillar.jpg"), 200, 200);
	  ayy.write("ayylmaofivefilters.jpg");
	  ayy.explore();
	  
  }
  
  public static void testCopyPortion()
  {
	  Picture wall = new Picture("wall.jpg");
	  Picture fromPic = new Picture("ayylmao.jpg");
	  wall.explore();
	  wall.copyPortion(fromPic, 20, 154, 20, 320);
	  wall.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
   // testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testBetterEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testMirrorBottomToTop();
	//testMirorDiagonal();
	//  testMirorDiagonalBottomRightToTopLeft();
	  //testMirrorSnowman();
    testMyCollage();
    //testFiveFilters();
    //testFullRandomRed();
    //testCopyPortion();
  }
}