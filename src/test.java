import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.enumeration.YeelightEffect;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws YeelightSocketException, YeelightResultErrorException, AWTException, InterruptedException {

        String ip = "192.168.1.12";
        int port = 55443;
        YeelightEffect effectType = YeelightEffect.SMOOTH;
        int effectDuration = 500;

        YeelightDevice device = new YeelightDevice(ip, port, effectType, effectDuration);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Robot robot = new Robot();
        Color pixelColor;
        device.setPower(true);
        boolean allume = false;
        int instruction = 1;

        while (true) {
            pixelColor = robot.getPixelColor((int) width / 2, (int) (height / 2));
            System.out.println(pixelColor);

            int red = pixelColor.getRed();
            int green = pixelColor.getGreen();
            int blue = pixelColor.getBlue();

            if (red == 0 && green == 0 && blue == 0) {
                System.out.println("darck pixel");
                device.setBrightness(0);
                instruction += 1;
            } else if (red == green && green == blue) {
                while (pixelColor.getRed() > 255) {
                    pixelColor = new Color(pixelColor.getRed() - 1, pixelColor.getGreen() - 1, pixelColor.getBlue() - 1);
                }
                device.setBrightness((int)pixelColor.getRed()/4);
                device.setRGB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue());
            } else {
                device.setBrightness(40);
                device.setRGB(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue());
                instruction += 2;
            }

            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println(instruction);
        }

    }

    public Color getScreenAverageColor() throws AWTException {
        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        //Robot who get pixel
        Robot robot = new Robot();
        robot.getPixelColor(0, 0);

        return Color.ORANGE;
    }
}
