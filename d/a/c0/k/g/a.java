package d.a.c0.k.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
/* loaded from: classes2.dex */
public class a {
    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static Bitmap b(FileDescriptor fileDescriptor, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        int a2 = a(options, i2, i3);
        options.inSampleSize = a2;
        options.inJustDecodeBounds = false;
        if (a2 <= 1) {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }
}
