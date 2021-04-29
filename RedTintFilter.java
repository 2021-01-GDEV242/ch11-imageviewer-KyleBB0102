
import java.awt.Color;
/**
 * 
 * A filter to bring out different kinds of red
 * @author Kyle Balao
 * @version 04/29/21
 */
public class RedTintFilter extends Filter {
    /**
     * Constructor for objects of class RedTintFilter.
     * 
     * @param name The name of the filter.
     */
    public RedTintFilter(String name) {
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
        Color mediumRed = new Color (150, 0,0);
        Color red = new Color (255, 0, 0);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                int r = pixel.getRed();
                if (r < 150) {
                    image.setPixel(x, y, black);
                } else if (r > 85 || r <= 150) {
                    image.setPixel(x, y, mediumRed);
                } else {
                    image.setPixel(x, y, red);
                }
            }
        }
    }
}
