package d.a.h0.h.a.m;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* loaded from: classes3.dex */
public class b {
    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        if (bitmap == null || i2 <= 0 || i3 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
