package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.nio.ByteBuffer;
@com.facebook.common.internal.d
/* loaded from: classes12.dex */
public class Bitmaps {
    @com.facebook.common.internal.d
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);

    @com.facebook.common.internal.d
    private static native ByteBuffer nativeGetByteBuffer(Bitmap bitmap, long j, long j2);

    @com.facebook.common.internal.d
    private static native void nativePinBitmap(Bitmap bitmap);

    @com.facebook.common.internal.d
    private static native void nativeReleaseByteBuffer(Bitmap bitmap);

    static {
        a.load();
    }

    public static void ad(Bitmap bitmap) {
        g.checkNotNull(bitmap);
        nativePinBitmap(bitmap);
    }

    public static void c(Bitmap bitmap, Bitmap bitmap2) {
        g.checkArgument(bitmap2.getConfig() == bitmap.getConfig());
        g.checkArgument(bitmap.isMutable());
        g.checkArgument(bitmap.getWidth() == bitmap2.getWidth());
        g.checkArgument(bitmap.getHeight() == bitmap2.getHeight());
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @TargetApi(19)
    public static void a(Bitmap bitmap, int i, int i2, Bitmap.Config config) {
        g.checkArgument(bitmap.getAllocationByteCount() >= (i * i2) * com.facebook.d.a.e(config));
        bitmap.reconfigure(i, i2, config);
    }
}
