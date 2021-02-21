package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@com.facebook.common.internal.d
/* loaded from: classes15.dex */
public class WebpTranscoderImpl implements c {
    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.c
    public boolean d(com.facebook.c.c cVar) {
        if (cVar == com.facebook.c.b.pGs) {
            return Build.VERSION.SDK_INT >= 14;
        } else if (cVar == com.facebook.c.b.pGt || cVar == com.facebook.c.b.pGu || cVar == com.facebook.c.b.pGv) {
            return com.facebook.common.g.c.pAf;
        } else {
            if (cVar != com.facebook.c.b.pGw) {
                throw new IllegalArgumentException("Image format is not a WebP.");
            }
            return false;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        b.erR();
        nativeTranscodeWebpToJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i);
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void e(InputStream inputStream, OutputStream outputStream) throws IOException {
        b.erR();
        nativeTranscodeWebpToPng((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream));
    }
}
