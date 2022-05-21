import java.awt.*;

public class ScreenLight {

    public static void main(String[] args) throws AWTException {

        PixelSelection list = getPixelPoints(2, 2);
        System.out.println(list.getColorAverage());
    }

    public static PixelSelection getPixelPoints(int line, int column) throws AWTException {

        // Get screen dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        // Init robot who get pixel color
        Robot robot = new Robot();

        // Init pixelSelection object
        PixelSelection pixelList = new PixelSelection();

        // Get integer between each point
        int heightIncrement = (int) (height / (line + 1));
        int widthIncrement = (int) (width / (column + 1));

        // Save each pixel
        for (int linePosition = 1; linePosition <= line; linePosition++) {
            for (int columnPosition = 1; columnPosition <= column; columnPosition++) {
                pixelList.addPixel(heightIncrement * linePosition, widthIncrement * columnPosition, robot.getPixelColor(heightIncrement * linePosition, widthIncrement * columnPosition));
                System.out.println(pixelList.getPixel(pixelList.size() - 1));
            }
        }
        return pixelList;
    }
}
