package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@com.facebook.common.internal.d
/* loaded from: classes12.dex */
public class JpegTranscoder {
    @com.facebook.common.internal.d
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    static {
        a.load();
    }

    public static boolean IH(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static boolean II(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z = false;
        g.checkArgument(i2 >= 1);
        g.checkArgument(i2 <= 16);
        g.checkArgument(i3 >= 0);
        g.checkArgument(i3 <= 100);
        g.checkArgument(IH(i));
        if (i2 != 8 || i != 0) {
            z = true;
        }
        g.checkArgument(z, "no transformation requested");
        nativeTranscodeJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i, i2, i3);
    }

    public static void b(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z = false;
        g.checkArgument(i2 >= 1);
        g.checkArgument(i2 <= 16);
        g.checkArgument(i3 >= 0);
        g.checkArgument(i3 <= 100);
        g.checkArgument(II(i));
        if (i2 != 8 || i != 1) {
            z = true;
        }
        g.checkArgument(z, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i, i2, i3);
    }
}
