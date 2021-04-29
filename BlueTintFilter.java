
import java.awt.Color;
/**
 * 
 * A filter to bring out different kinds of blue
 * @author Kyle Balao
 * @version 04/29/21
 */
public class BlueTintFilter extends Filter {
    /**
     * Constructor for objects of class BlueTintFilter.
     * 
     * @param name The name of the filter.
     */
    public BlueTintFilter(String name) {
        super(name);
    }
    
     /**
     * Apply this filter to an image.
     * 
     * @param image The image to be changed by this filter.
     */
    public void apply(OFImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        Color black = new Color(0, 0, 0);
        Color mediumBlue = new Color (0, 0,150);
        Color blue = new Color (0, 0, 255);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                int b = pixel.getBlue();
                if (b < 150) {
                    image.setPixel(x, y, black);
                } else if (b > 85 || b <= 150) {
                    image.setPixel(x, y, mediumBlue);
                } else {
                    image.setPixel(x, y, blue);
                }
            }
        }
    }
}
