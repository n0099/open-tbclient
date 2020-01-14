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
        if (cVar == com.facebook.c.b.lOL) {
            return Build.VERSION.SDK_INT >= 14;
        } else if (cVar == com.facebook.c.b.lOM || cVar == com.facebook.c.b.lON || cVar == com.facebook.c.b.lOO) {
            return com.facebook.common.g.c.sIsExtendedWebpSupported;
        } else {
            if (cVar != com.facebook.c.b.lOP) {
                throw new IllegalArgumentException("Image format is not a WebP.");
            }
            return false;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        b.diC();
        nativeTranscodeWebpToJpeg((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream), i);
    }

    @Override // com.facebook.imagepipeline.nativecode.c
    public void f(InputStream inputStream, OutputStream outputStream) throws IOException {
        b.diC();
        nativeTranscodeWebpToPng((InputStream) g.checkNotNull(inputStream), (OutputStream) g.checkNotNull(outputStream));
    }
}
