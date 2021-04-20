package d.b.z.k.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
/* loaded from: classes2.dex */
public class a {
    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap b(FileDescriptor fileDescriptor, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        int a2 = a(options, i, i2);
        options.inSampleSize = a2;
        options.inJustDecodeBounds = false;
        if (a2 <= 1) {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }
}
