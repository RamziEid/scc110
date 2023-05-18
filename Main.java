import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        //play music
        MusicPlayer musicPlayer = new MusicPlayer();


        // Create a new GameArena with a width of 900 pixels and height of 600 pixels
        GameArena arena = new GameArena(900, 600);

        //creating the pink rectangle
        Rectangle pinkRectangle = new Rectangle(50, 50, 800, 500, "PINK");
        arena.addRectangle(pinkRectangle);

        //White rectangle
        Rectangle whiteRectangle = new Rectangle(65, 65, 770, 470, "WHITE");
        arena.addRectangle(whiteRectangle);


        // Create lines

        Line firstMiddleLine = new Line(450, 50, 450, 250, 1, "PINK");
        arena.addLine(firstMiddleLine);
        Line secondMiddleLine = new Line(450, 550, 450, 350, 1, "PINK");
        arena.addLine(secondMiddleLine);

        //creating the goals with grey color lines
        Line leftGoal = new Line(70, 200, 70, 400, 10, "GREY", 2);
        arena.addLine(leftGoal);
        Line rightGoal = new Line(830, 200, 830, 400, 10, "GREY", 2);
        arena.addLine(rightGoal);


        // Create the circles in the middle
        Ball middlePinkCircle = new Ball(450, 300, 100, "PINK");
        arena.addBall(middlePinkCircle);
        Ball middleWhiteCircle = new Ball(450, 300, 98, "WHITE");
        arena.addBall(middleWhiteCircle);

        //creating the hockey Puck and put in the middle
        Ball hockeyPuck = new Ball(450, 300, 25, "BLACK");
        arena.addBall(hockeyPuck);

        //create the left ball
        Ball leftPinkBall = new Ball(200, 300, 75, "PINK");
        arena.addBall(leftPinkBall);

        //create the right ball
        Ball rightPinkBall = new Ball(700, 300, 75, "PINK");
        arena.addBall(rightPinkBall);

        //creating the text
        //main text which updated every time the players score
        Text welcomeText = new Text("Welcome to Air Hockey", 20, 65, 35, "WHITE");
        arena.addText(welcomeText);

        Text musicText = new Text("T music OFF / Y music ON", 15, 90, 590, "WHITE");
        arena.addText(musicText);

        //text to show the score
        Text rightScore = new Text("0", 30, 870, 300, "WHITE");
        arena.addText(rightScore);
        Text leftScore = new Text("0", 30, 20, 300, "WHITE");
        arena.addText(leftScore);

        //variable to control the music
        boolean musicOn = true;


        //define the initial value of score
        int rightGoalScore = 0;
        int leftGoalScore = 0;


        // Define the initial velocity of the
        double xvelocity = 0;
        double yvelocity = 0;
        // Define the initial speed
        double speed = 15;

        //play the opening music

        musicPlayer.playMusic("fanfare.wav");
        // Update game logic
        while (true) {

            //adding on / off for the music
            if (arena.letterPressed('T')) {
                musicOn = false;
            }
            if (arena.letterPressed('Y')) {
                musicOn = true;
            }

            // Move left pink ball using W, S, D, and A
            double lettersBallR = leftPinkBall.getSize();
            double lettersBallX = leftPinkBall.getXPosition();
            double lettersBallY = leftPinkBall.getYPosition();

            //hold M to make opponent's controls become inverted
            if (arena.letterPressed('M')) {
                if (arena.letterPressed('D')) {
                    if (lettersBallX - lettersBallR + 35 <= whiteRectangle.getXPosition()) {
                        leftPinkBall.setXPosition(whiteRectangle.getXPosition() + lettersBallR);
                    } else {
                        leftPinkBall.setXPosition(lettersBallX - 10);
                    }
                }

                if (arena.letterPressed('A')) {
                    if (lettersBallX + lettersBallR - 35 >= (double) arena.getArenaWidth() / 2) {
                        leftPinkBall.setXPosition((double) arena.getArenaWidth() / 2 - lettersBallR);
                    } else {
                        leftPinkBall.setXPosition(lettersBallX + 10);
                    }
                }

                if (arena.letterPressed('S')) {
                    if (lettersBallY - lettersBallR + 35 <= whiteRectangle.getYPosition()) {
                        leftPinkBall.setYPosition(whiteRectangle.getYPosition() + lettersBallR);
                    } else {
                        leftPinkBall.setYPosition(lettersBallY - 10);
                    }
                }


                if (arena.letterPressed('W')) {
                    if (lettersBallY + lettersBallR - 40 >= arena.getArenaHeight() - whiteRectangle.getYPosition()) {
                        leftPinkBall.setYPosition(arena.getArenaHeight() - whiteRectangle.getYPosition() - lettersBallR);
                    } else {
                        leftPinkBall.setYPosition(lettersBallY + 10);
                    }
                }
            } else {
                if (arena.letterPressed('A')) {
                    if (lettersBallX - lettersBallR + 35 <= whiteRectangle.getXPosition()) {
                        leftPinkBall.setXPosition(whiteRectangle.getXPosition() + lettersBallR);
                    } else {
                        leftPinkBall.setXPosition(lettersBallX - 10);
                    }
                }

                if (arena.letterPressed('D')) {
                    if (lettersBallX + lettersBallR - 35 >= (double) arena.getArenaWidth() / 2) {
                        leftPinkBall.setXPosition((double) arena.getArenaWidth() / 2 - lettersBallR);
                    } else {
                        leftPinkBall.setXPosition(lettersBallX + 10);
                    }
                }

                if (arena.letterPressed('W')) {
                    if (lettersBallY - lettersBallR + 35 <= whiteRectangle.getYPosition()) {
                        leftPinkBall.setYPosition(whiteRectangle.getYPosition() + lettersBallR);
                    } else {
                        leftPinkBall.setYPosition(lettersBallY - 10);
                    }
                }


                if (arena.letterPressed('S')) {
                    if (lettersBallY + lettersBallR - 40 >= arena.getArenaHeight() - whiteRectangle.getYPosition()) {
                        leftPinkBall.setYPosition(arena.getArenaHeight() - whiteRectangle.getYPosition() - lettersBallR);
                    } else {
                        leftPinkBall.setYPosition(lettersBallY + 10);
                    }
                }

            }


            // Move right pink ball using arrows
            double arrowsBallR = rightPinkBall.getSize();
            double arrowsBallX = rightPinkBall.getXPosition();
            double arrowsBallY = rightPinkBall.getYPosition();


            //hold shift to make opponent's controls become inverted
            if (arena.shiftPressed()) {

                if (arena.rightPressed()) {
                    if (arrowsBallX - arrowsBallR + 35 <= whiteRectangle.getXPosition() + whiteRectangle.getWidth() / 2) {
                        rightPinkBall.setXPosition(whiteRectangle.getXPosition() + whiteRectangle.getWidth() / 2 + arrowsBallR);
                    } else {
                        rightPinkBall.setXPosition(arrowsBallX - 10);
                    }
                }

                if (arena.leftPressed()) {
                    if (arrowsBallX + arrowsBallR - 35 >= whiteRectangle.getXPosition() + whiteRectangle.getWidth()) {
                        rightPinkBall.setXPosition(whiteRectangle.getXPosition() + whiteRectangle.getWidth() - arrowsBallR);
                    } else {
                        rightPinkBall.setXPosition(arrowsBallX + 10);
                    }
                }


                if (arena.downPressed()) {
                    if (arrowsBallY - arrowsBallR + 35 <= whiteRectangle.getYPosition()) {
                        rightPinkBall.setYPosition(whiteRectangle.getYPosition() + arrowsBallR);
                    } else {
                        rightPinkBall.setYPosition(arrowsBallY - 10);
                    }
                }

                if (arena.upPressed()) {
                    if (arrowsBallY + arrowsBallR - 40 >= arena.getArenaHeight() - whiteRectangle.getYPosition()) {
                        rightPinkBall.setYPosition(arena.getArenaHeight() - whiteRectangle.getYPosition() - arrowsBallR);
                    } else {
                        rightPinkBall.setYPosition(arrowsBallY + 10);
                    }
                }
            } else {
                if (arena.leftPressed()) {
                    if (arrowsBallX - arrowsBallR + 35 <= whiteRectangle.getXPosition() + whiteRectangle.getWidth() / 2) {
                        rightPinkBall.setXPosition(whiteRectangle.getXPosition() + whiteRectangle.getWidth() / 2 + arrowsBallR);
                    } else {
                        rightPinkBall.setXPosition(arrowsBallX - 10);
                    }
                }

                if (arena.rightPressed()) {
                    if (arrowsBallX + arrowsBallR - 35 >= whiteRectangle.getXPosition() + whiteRectangle.getWidth()) {
                        rightPinkBall.setXPosition(whiteRectangle.getXPosition() + whiteRectangle.getWidth() - arrowsBallR);
                    } else {
                        rightPinkBall.setXPosition(arrowsBallX + 10);
                    }
                }


                if (arena.upPressed()) {
                    if (arrowsBallY - arrowsBallR + 35 <= whiteRectangle.getYPosition()) {
                        rightPinkBall.setYPosition(whiteRectangle.getYPosition() + arrowsBallR);
                    } else {
                        rightPinkBall.setYPosition(arrowsBallY - 10);
                    }
                }
                if (arena.downPressed()) {
                    if (arrowsBallY + arrowsBallR - 40 >= arena.getArenaHeight() - whiteRectangle.getYPosition()) {
                        rightPinkBall.setYPosition(arena.getArenaHeight() - whiteRectangle.getYPosition() - arrowsBallR);
                    } else {
                        rightPinkBall.setYPosition(arrowsBallY + 10);
                    }
                }
            }

            // Update the velocity and direction of the hockey puck based on collisions

            if (hockeyPuck.collides(leftPinkBall)) {
                if (musicOn == true) {
                    musicPlayer.playMusic("hit.wav");
                }
                double angle = Math.atan2(hockeyPuck.getYPosition() - leftPinkBall.getYPosition(), hockeyPuck.getXPosition() - leftPinkBall.getXPosition());
                xvelocity = speed * Math.cos(angle);
                yvelocity = speed * Math.sin(angle);
            } else if (hockeyPuck.collides(rightPinkBall)) {
                if (musicOn == true) {
                    musicPlayer.playMusic("hit.wav");
                }
                double angle = Math.atan2(hockeyPuck.getYPosition() - rightPinkBall.getYPosition(), hockeyPuck.getXPosition() - rightPinkBall.getXPosition());
                xvelocity = speed * Math.cos(angle);
                yvelocity = speed * Math.sin(angle);
            }

            // Move the hockey puck
            hockeyPuck.move(xvelocity, yvelocity);

            // If the next position is outside the white rectangle, bounce the ball off the edge of the rectangle
            if (!whiteRectangle.contains(hockeyPuck.getXPosition(), hockeyPuck.getYPosition())) {
                if (hockeyPuck.getXPosition() < whiteRectangle.getXPosition() + hockeyPuck.getSize()) {
                    xvelocity = Math.abs(xvelocity);
                } else if (hockeyPuck.getXPosition() > whiteRectangle.getXPosition() + whiteRectangle.getWidth() - hockeyPuck.getSize()) {
                    xvelocity = -Math.abs(xvelocity);
                }
                if (hockeyPuck.getYPosition() < whiteRectangle.getYPosition() + hockeyPuck.getSize()) {
                    yvelocity = Math.abs(yvelocity);
                } else if (hockeyPuck.getYPosition() > whiteRectangle.getYPosition() + whiteRectangle.getHeight() - hockeyPuck.getSize()) {
                    yvelocity = -Math.abs(yvelocity);
                }
                //playing music and bounce back the hockey puck
                if (musicOn == true) {
                    musicPlayer.playMusic("bounce.wav");
                }
                hockeyPuck.move(xvelocity, yvelocity);
            }

            //update the score if the ball touches the goal lines
            if (hockeyPuck.lineContact(leftGoal)) {
                rightGoalScore += 1;
                rightScore.setText(String.valueOf(rightGoalScore));
                if (musicOn == true) {
                    musicPlayer.playMusic("applause.wav");
                }
                welcomeText.setColour("GREEN");
                welcomeText.setText("Player 1 wins the round!");
                //reset balls locations and speed
                xvelocity = 0;
                yvelocity = 0;
                hockeyPuck.setXPosition(400);
                hockeyPuck.setYPosition(300);
                rightPinkBall.setXPosition(700);
                rightPinkBall.setYPosition(300);
                leftPinkBall.setXPosition(200);
                leftPinkBall.setYPosition(300);
            } else if (hockeyPuck.lineContact(rightGoal)) {
                leftGoalScore += 1;
                leftScore.setText(String.valueOf(leftGoalScore));
                if (musicOn == true) {
                    musicPlayer.playMusic("applause.wav");
                }
                welcomeText.setColour("YELLOW");
                welcomeText.setText("Player 2 wins the round!");
                //reset balls locations and speed
                xvelocity = 0;
                yvelocity = 0;
                hockeyPuck.setXPosition(500);
                hockeyPuck.setYPosition(300);
                rightPinkBall.setXPosition(700);
                rightPinkBall.setYPosition(300);
                leftPinkBall.setXPosition(200);
                leftPinkBall.setYPosition(300);
            }

            //check if any player scores 6 points to announce the winner and reset the scores
            if (leftGoalScore == 6) {
                //the left player wins the game
                welcomeText.setColour("WHITE");
                rightGoalScore = 0;
                leftGoalScore = 0;
                if (musicOn == true) {
                    musicPlayer.playMusic("drumroll.wav");
                }
                welcomeText.setText("Player 1 wins with 6 points! Press SPACE to start a new game");
                rightScore.setText("0");
                leftScore.setText("0");


            } else if (rightGoalScore == 6) {
                //the right player wins the game
                welcomeText.setColour("WHITE");
                rightGoalScore = 0;
                leftGoalScore = 0;
                if (musicOn == true) {
                    musicPlayer.playMusic("drumroll.wav");
                }
                welcomeText.setText("Player 2 wins with 6 points! Press SPACE to start a new game");
                rightScore.setText("0");
                leftScore.setText("0");


            }
            //starting a new game if the player presses space, resetting everything
            //we could link it to the score, if the score is 6 then we could reset the game.
            if (arena.spacePressed()) {
                rightGoalScore = 0;
                leftGoalScore = 0;
                xvelocity = 0;
                yvelocity = 0;
                if (musicOn == true) {
                    musicPlayer.playMusic("fanfare.wav");
                }
                welcomeText.setColour("WHITE");
                welcomeText.setText("Welcome to Air Hockey!");
                hockeyPuck.setXPosition(450);
                hockeyPuck.setYPosition(300);
                rightPinkBall.setXPosition(700);
                rightPinkBall.setYPosition(300);
                leftPinkBall.setXPosition(200);
                leftPinkBall.setYPosition(300);
                rightScore.setText("0");
                leftScore.setText("0");
            }
            arena.pause();
        }


    }

}

