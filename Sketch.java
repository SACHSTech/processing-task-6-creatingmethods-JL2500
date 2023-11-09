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

    for (int i = 50; i < width; i += 100) {
      for (int j = 50; j < height; j += 100) {
        int smileyColour = faceColour(i, j);
        drawSmileyFace(i, j, 50, smileyColour);
      }
    }

    for (int k = 50; k < width - 50; k += 100) {
      for (int l = 50; l < height - 50; l += 100) {
        drawHouse(k + 40, l + 40, 25, 25);
      }
    }

  }
  
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
  
  void drawHouse(float houseX, float houseY, float houseWidth, float houseHeight) {
    fill(255, 204, 0);
    rect(houseX, houseY, houseWidth, houseHeight);
    triangle(houseX, houseY, houseX + houseWidth / 2, houseY - houseHeight / 2, houseX + houseWidth, houseY);
  }

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