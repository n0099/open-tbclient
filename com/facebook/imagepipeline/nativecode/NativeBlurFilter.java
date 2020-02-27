package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
@com.facebook.common.internal.d
/* loaded from: classes12.dex */
public class NativeBlurFilter {
    @com.facebook.common.internal.d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);

    static {
        a.load();
    }

    public static void h(Bitmap bitmap, int i, int i2) {
        g.checkNotNull(bitmap);
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        nativeIterativeBoxBlur(bitmap, i, i2);
    }
}
