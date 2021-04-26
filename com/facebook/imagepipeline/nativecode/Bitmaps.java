package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
@DoNotStrip
/* loaded from: classes6.dex */
public class Bitmaps {
    static {
        ImagePipelineNativeLoader.load();
    }

    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Preconditions.checkArgument(bitmap2.getConfig() == bitmap.getConfig());
        Preconditions.checkArgument(bitmap.isMutable());
        Preconditions.checkArgument(bitmap.getWidth() == bitmap2.getWidth());
        Preconditions.checkArgument(bitmap.getHeight() == bitmap2.getHeight());
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    public static native void nativeCopyBitmap(Bitmap bitmap, int i2, Bitmap bitmap2, int i3, int i4);
}
