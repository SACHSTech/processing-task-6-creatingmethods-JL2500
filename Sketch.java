import processing.core.PApplet;

public class Sketch extends PApplet {
	
  public void settings() {
    width = 800;
    height = 400;
    size(width, height);
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {

    // Draws a pattern of smiley faces around the screen
    for (int i = 50; i < width; i += 100) {
      for (int j = 50; j < height; j += 100) {
        int smileyColour = faceColour(i, j);
        drawSmileyFace(i, j, 50, smileyColour);
      }
    }

    // Draws a pattern of houses in the middle of the smiley faces
    for (int k = 50; k < width - 50; k += 100) {
      for (int l = 50; l < height - 50; l += 100) {
        drawHouse(k + 40, l + 40, 25);
      }
    }

  }
  
  /**
  * Draws a smiley face given the parameters
  *
  * @param x  The x coordinate of where the face is drawn
  * @param y  The y coordinate of where the face is drawn
  * @param diameter  How big the smiley face is
  * @param colour  The stroke colour of the face
  *
  */  
  void drawSmileyFace(float x, float y, float diameter, int colour) {
    noFill();
    stroke(colour);
    ellipse(x, y, diameter, diameter);

    noStroke();
    fill(0);
    float eyeSize = diameter / 10;
    ellipse(x - diameter / 5, y - diameter / 10, eyeSize, eyeSize);
    ellipse(x + diameter / 5, y - diameter / 10, eyeSize, eyeSize);

    noFill();
    stroke(0);
    float smileSize = (diameter * 3) / 5 ;
    arc(x, y, smileSize, smileSize, radians(0), radians(180));
  }
  
  /**
  * Draws a house given the parameters
  *
  * @param houseX  The x coordinate of where the house is drawn
  * @param houseY  The y coordinate of where the house is drawn
  * @param houseWidth  How wide the house is
  *
  */  
  void drawHouse(float houseX, float houseY, float houseWidth) {
    fill(255, 204, 0);
    rect(houseX, houseY, houseWidth, houseWidth);
    triangle(houseX, houseY, houseX + houseWidth / 2, houseY - houseWidth / 2, houseX + houseWidth, houseY);
  }

  /**
  * Given x and y of drawing, returns a colour based on its location
  *
  * @param x  The x coordinate of where the drawing is
  * @param y  The y coordinate of where the drawing is
  * @return Returns red, black, or blue, depending on location
  *
  */  
  int faceColour(int x, int y) {
    float section = map(x, 0, width, 0, 3);

    if (section < 1) {
        return color(255, 0, 0); 
    } else if (section < 2) {
        return color(0); 
    } else {
        return color(0, 0, 255); 
    }
  }
}