package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.common.internal.g;
import java.nio.ByteBuffer;
@d
/* loaded from: classes2.dex */
public class Bitmaps {
    @d
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);

    @d
    private static native ByteBuffer nativeGetByteBuffer(Bitmap bitmap, long j, long j2);

    @d
    private static native void nativePinBitmap(Bitmap bitmap);

    @d
    private static native void nativeReleaseByteBuffer(Bitmap bitmap);

    static {
        a.load();
    }

    public static void aa(Bitmap bitmap) {
        g.checkNotNull(bitmap);
        nativePinBitmap(bitmap);
    }
}
