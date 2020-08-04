package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@com.facebook.common.internal.d
/* loaded from: classes12.dex */
public class WebpTranscoderImpl implements c {
    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.c
    public boolean d(com.facebook.c.c cVar) {
        if (cVar == com.facebook.c.b.mYl) {
            return Build.VERSION.SDK_INT >= 14;
        } else if (cVar == com.facebook.c.b.mYm || cVar == com.facebook.c.b.mYn || cVar == com.facebook.c.b.mYo) {
            return com.facebook.common.g.c.mRF;
        } else {
            if (cVar != com.facebook.c.b.mYp) {
                throw new IllegalArgumentException("Image format is not a WebP.");
            }
            return false;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        b.dBD();
        nativeTranscodeWebpToJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i);
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void f(InputStream inputStream, OutputStream outputStream) throws IOException {
        b.dBD();
        nativeTranscodeWebpToPng((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream));
    }
}
