
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import processing.core.PApplet;

public class Scouting extends PApplet {

    boolean level;
    String match;
    String team;
    String comments;

    boolean lineCrossed;
    String autoLow;
    String autoOut;
    String autoIn;
    String teleLow;
    String teleOut;
    String teleIn;
    boolean rot;
    boolean pos;
    boolean climb;
    boolean park;

    boolean done;

    int textX;
    int textY;
    int w = 1000;
    int h = 1500; 

    public static void main(String[] args) {
        PApplet.main(new String[]{Scouting.class.getName()});
    }

    public void settings() {
        size(1000, 1500);
    }

    public void setup() {
        background(255);
        textX = 50;
        textY = 0;
        autoLow = "Auto Low: ";
        autoOut = "Auto Outer: ";
        autoIn = "Auto Inner: ";
        teleLow = "TeleOp Low: ";
        teleOut = "TeleOp Outer: ";
        teleIn = "TeleOp Inner: ";
        match = "Match: ";
        team = "Team: ";
        comments = "Comments: ";
        surface.setResizable(true);
    }

    public void draw() {
        smooth();
        background(255);
        scaling();
        fill(0);
        textSize(32);
        text(match, 50, textY + 50);
        text(team, 50, textY + 100);
        text("Line Crossed: " + lineCrossed, textX, textY + 200);
        text(autoLow, textX, textY + 250);
        text(autoOut, textX, textY + 300);
        text(autoIn, textX, textY + 350);
        text(teleLow, textX, textY + 400);
        text(teleOut, textX, textY + 450);
        text(teleIn, textX, textY + 500);
        text("Rotation Ctrl: " + rot, textX, textY + 550);
        text("Position Ctrl: " + pos, textX, textY + 600);
        text("Park: " + park, textX, textY + 650);
        text("Climb: " + climb, textX, textY + 700);
        text("Level: " + level, 50, 800);
        text(comments, 50, 850, width - 50, 900);
        text("Done (once clicked you can't change anything): " + done, 50, height - 100, width-50, 50);

        if (done == true) {
            toFile();
            noLoop();
        }
    }

    public void mouseClicked() {
        if (mouseY >= textY + 175 && mouseY <= textY + 200) {
            if (lineCrossed == false) {
                lineCrossed = true;
            } else {
                if (lineCrossed == true) {
                    lineCrossed = false;
                }
            }
        }
        if (mouseY >= textY + 525 && mouseY <= textY + 550) {
            if (rot == false) {
                rot = true;
            } else {
                if (rot == true) {
                    rot = false;
                }
            }
        }
        if (mouseY >= textY + 575 && mouseY <= textY + 600) {
            if (pos == false) {
                pos = true;
            } else {
                if (pos == true) {
                    pos = false;
                }
            }
        }
        if (mouseY >= textY + 625 && mouseY <= textY + 650) {
            if (park == false) {
                park = true;
            } else {
                if (park == true) {
                    park = false;
                }
            }
        }
        if (mouseY >= textY + 675 && mouseY <= textY + 700) {
            if (climb == false) {
                climb = true;
            } else {
                if (climb == true) {
                    climb = false;
                }
            }
        }
        if (mouseY >= 775 && mouseY <= 800) {
            if (level == false) {
                level = true;
            } else {
                if (level == true) {
                    level = false;
                }
            }
        }
        if (mouseY >= height-125 && mouseY <= height) {
            if (done == false) {
                done = true;
            } else {
                if (done == true) {
                    done = false;
                }
            }
        }
    }

    public void keyPressed() {
        if (mouseY >= textY + 225 && mouseY <= textY + 250) {
            if (keyCode == BACKSPACE) {
                if (autoLow.length() > 10) {
                    autoLow = autoLow.substring(0, autoLow.length() - 1);
                }
            } else if (keyCode == DELETE) {
                autoLow = "Auto Low: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                autoLow = autoLow + key;
            }
        }
        if (mouseY >= textY + 275 && mouseY <= textY + 300) {
            if (keyCode == BACKSPACE) {
                if (autoOut.length() > 12) {
                    autoOut = autoOut.substring(0, autoOut.length() - 1);
                }
            } else if (keyCode == DELETE) {
                autoOut = "Auto Outer: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                autoOut = autoOut + key;
            }
        }
        if (mouseY >= textY + 325 && mouseY <= textY + 350) {
            if (keyCode == BACKSPACE) {
                if (autoIn.length() > 12) {
                    autoIn = autoIn.substring(0, autoIn.length() - 1);
                }
            } else if (keyCode == DELETE) {
                autoIn = "Auto Inner: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                autoIn = autoIn + key;
            }
        }
        if (mouseY >= textY + 375 && mouseY <= textY + 400) {
            if (keyCode == BACKSPACE) {
                if (teleLow.length() > 12) {
                    teleLow = teleLow.substring(0, teleLow.length() - 1);
                }
            } else if (keyCode == DELETE) {
                teleLow = "TeleOp Low: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                teleLow = teleLow + key;
            }
        }
        if (mouseY >= textY + 425 && mouseY <= textY + 450) {
            if (keyCode == BACKSPACE) {
                if (teleOut.length() > 14) {
                    teleOut = teleOut.substring(0, teleOut.length() - 1);
                }
            } else if (keyCode == DELETE) {
                teleOut = "TeleOp Outer: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                teleOut = teleOut + key;
            }
        }
        if (mouseY >= textY + 475 && mouseY <= textY + 500) {
            if (keyCode == BACKSPACE) {
                if (teleIn.length() > 14) {
                    teleIn = teleIn.substring(0, teleIn.length() - 1);
                }
            } else if (keyCode == DELETE) {
                teleIn = "TeleOp Inner: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                teleIn = teleIn + key;
            }
        }

        if (mouseY < 50) {
            if (keyCode == BACKSPACE) {
                if (match.length() > 7) {
                    match = match.substring(0, match.length() - 1);
                }
            } else if (keyCode == DELETE) {
                match = "Match: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                match = match + key;
            }
        }
        if (mouseY > 75 && mouseY < 100) {
            if (keyCode == BACKSPACE) {
                if (team.length() > 6) {
                    team = team.substring(0, team.length() - 1);
                }
            } else if (keyCode == DELETE) {
                team = "Team: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                team = team + key;
            }
        }
        if (mouseY > 825) {
            if (keyCode == BACKSPACE) {
                if (comments.length() > 10) {
                    comments = comments.substring(0, comments.length() - 1);
                }
            } else if (keyCode == DELETE) {
                comments = "Comments: ";
            } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
                comments = comments + key;
            }
        }
    }

    public void toFile() {
        try {
            File file = new File("T" + match.substring(7, match.length()) + "M" + team.substring(6, team.length()) + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(match + '\n');
            fileWriter.write(team + '\n');
            fileWriter.write("Line Crossed: " + new String(String.valueOf(lineCrossed)) + '\n');
            fileWriter.write(autoLow + '\n');
            fileWriter.write(autoOut + '\n');
            fileWriter.write(autoIn + '\n');
            fileWriter.write(teleLow + '\n');
            fileWriter.write(teleOut + '\n');
            fileWriter.write(teleIn + '\n');
            fileWriter.write("Rotation Ctrl: " + new String(String.valueOf(rot)) + '\n');
            fileWriter.write("Position Ctrl: " + new String(String.valueOf(pos)) + '\n');
            fileWriter.write("Park: " + new String(String.valueOf(park)) + '\n');
            fileWriter.write("Climb: " + new String(String.valueOf(climb)) + '\n');
            fileWriter.write("Level: " + new String(String.valueOf(level)) + '\n');
            fileWriter.write(comments);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void scaling() {
        while (w!=width || h!=height) {
            pause();
        }
        w=width;
        h=height;
    }
}
