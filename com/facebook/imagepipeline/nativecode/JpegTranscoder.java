package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.d;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@d
/* loaded from: classes2.dex */
public class JpegTranscoder {
    @d
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    static {
        a.load();
    }

    public static boolean CL(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        boolean z = false;
        g.checkArgument(i2 >= 1);
        g.checkArgument(i2 <= 16);
        g.checkArgument(i3 >= 0);
        g.checkArgument(i3 <= 100);
        g.checkArgument(CL(i));
        if (i2 != 8 || i != 0) {
            z = true;
        }
        g.checkArgument(z, "no transformation requested");
        nativeTranscodeJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i, i2, i3);
    }
}
