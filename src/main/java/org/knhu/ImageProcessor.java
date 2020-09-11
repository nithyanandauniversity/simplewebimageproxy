package org.knhu;

import com.criteo.vips.VipsImage;
import com.criteo.vips.enums.VipsImageFormat;

import java.awt.*;

public class ImageProcessor {

    public static byte[] get(byte[] contents) {
        var image = new VipsImage(contents, contents.length);
        image.resize(new Dimension(400, 400), true);
        return image.writeToArray(VipsImageFormat.WEBP, false);
    }
}
