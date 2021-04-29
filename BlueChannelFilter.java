
import java.awt.Color;
/**
 * 
 * items that have a high blue value for the pixel data appear as white
 * while lower blue values show black and middle blue values show gray
 * 
 * @author Kyle Balao
 * @version 04/29/21
 */
public class BlueChannelFilter extends Filter {
    /**
     * Constructor for objects of class BlueChannelFilter.
     * 
     * @param name The name of the filter.
     */
    public BlueChannelFilter(String name) {
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
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                int g = pixel.getGreen();
                if (g < 85) {
                    image.setPixel(x, y, Color.black);
                } else if (g > 85 || g < 170) {
                    image.setPixel(x, y, Color.gray);
                } else {
                    image.setPixel(x, y, Color.white);
                }
            }
        }
    }
}
