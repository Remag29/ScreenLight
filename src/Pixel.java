import java.awt.*;

public class Pixel {

    /**
     * X coordinates of the pixel
     */
    private final int x;
    /**
     * Y coordinates of the pixel
     */
    private final int y;
    /**
     * Color of the pixel
     */
    private final Color color;

    /**
     * Create a pixel object
     *
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @param color the color of the pixel
     */
    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Get the color of the pixel
     *
     * @return the color of the pixel
     */
    public Color getColor() {
        return color;
    }

    /**
     * Print the pixel on the terminal
     * @return string corresponding to the pixel
     */
    @Override
    public String toString() {
        System.out.print(this.hashCode());
        System.out.print(", x = " + x);
        System.out.print(", y = " + y);
        System.out.println(", color = " + color);
        return this.hashCode() + ", x = " + x + ", y = " + y + ", color = " + color;
    }
}
