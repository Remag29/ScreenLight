import java.awt.*;
import java.util.LinkedList;

public class PixelSelection {

    private final LinkedList<Pixel> pixellist;

    public PixelSelection() {
        this.pixellist = new LinkedList<>();
    }

    public Pixel getPixel(int index) {
        return this.pixellist.get(index);
    }

    public void addPixel(int x, int y, Color color) {
        this.pixellist.add(new Pixel(x, y, color));
    }

    public Color getColorAverage() {
        int r = 0, g = 0, b = 0;
        for (Pixel pixel :
                this.pixellist) {
            r += pixel.getColor().getRed();
            g += pixel.getColor().getGreen();
            b += pixel.getColor().getBlue();
        }
        r /= pixellist.size();
        g /= pixellist.size();
        b /= pixellist.size();

        return new Color(r, g, b);
    }

    public int size() {
        return this.pixellist.size();
    }

    @Override
    public String toString() {
        String string = "";
        for (int pixel = 0; pixel < this.pixellist.size(); pixel++) {
            string += this.getPixel(pixel).toString();
            string += "\n\r";
        }
        return string;
    }
}
