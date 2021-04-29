
import java.awt.Color;
/**
 * 
 * A filter to bring out different kinds of green
 * @author Kyle Balao
 * @version 04/29/21
 */
public class GreenTintFilter extends Filter {
    /**
     * Constructor for objects of class GreenTintFilter.
     * 
     * @param name The name of the filter.
     */
    public GreenTintFilter(String name) {
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
        Color mediumGreen = new Color (0, 150, 0);
        Color green = new Color (0, 255, 0);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                int g = pixel.getGreen();
                if (g < 150) {
                    image.setPixel(x, y, black);
                } else if (g > 85 || g <= 150) {
                    image.setPixel(x, y, mediumGreen);
                } else {
                    image.setPixel(x, y, green);
                }
            }
        }
    }
}
