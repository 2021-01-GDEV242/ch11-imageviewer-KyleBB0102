
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
/**
 * An image filter to make the image show the original colors in the top left 
 * a red tint at the top right, a green tint in the bottom left and a blue
 * tint in the bottom right, it also includes a little twist
 * 
 * red will be flipped horizontally, green will be flipped vertically and
 * blue will be flip both ways
 *
 * @author Kyle Balao
 * @version 04/29/21
 */
public class FlippedWarholFilter extends Filter
{
     /**
     * Constructor for objects of class FlippedWarholFilter
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
    {
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
        
        int halfHeight = height/2;
        int halfWidth = width/2;
        
        Color black = new Color(0, 0, 0);
        
        Color mediumRed = new Color (150, 0,0);
        Color red = new Color (255, 0, 0);
        
        Color mediumGreen = new Color (0, 150, 0);
        Color green = new Color (0, 255, 0);
        
        Color mediumBlue = new Color (0, 0,150);
        Color blue = new Color (0, 0, 255);
        
         for(int y = 0; y < halfHeight; y++){
            for(int x = 0; x < halfWidth; x++){
                Color pixel = image.getPixel(x,y);
            }
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(halfWidth - 1 - x, y));
                image.setPixel(halfWidth - 1 - x, y, pixel);
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
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                 Color pixel = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(x, halfHeight - 1 - y));
                image.setPixel(x, halfHeight - 1 - y, pixel);
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
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(halfWidth - 1 - x, halfHeight - 1 - y));
                image.setPixel(halfWidth - 1 - x, halfHeight - 1 - y, pixel);
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