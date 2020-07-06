package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@com.facebook.common.internal.d
/* loaded from: classes13.dex */
public class WebpTranscoderImpl implements c {
    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.c
    public boolean d(com.facebook.c.c cVar) {
        if (cVar == com.facebook.c.b.mQb) {
            return Build.VERSION.SDK_INT >= 14;
        } else if (cVar == com.facebook.c.b.mQc || cVar == com.facebook.c.b.mQd || cVar == com.facebook.c.b.mQe) {
            return com.facebook.common.g.c.mJA;
        } else {
            if (cVar != com.facebook.c.b.mQf) {
                throw new IllegalArgumentException("Image format is not a WebP.");
            }
            return false;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        b.dyq();
        nativeTranscodeWebpToJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i);
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void f(InputStream inputStream, OutputStream outputStream) throws IOException {
        b.dyq();
        nativeTranscodeWebpToPng((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream));
    }
}
