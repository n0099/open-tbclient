package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
@DoNotStrip
/* loaded from: classes6.dex */
public class NativeBlurFilter {
    static {
        NativeFiltersLoader.load();
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i2, int i3) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        nativeIterativeBoxBlur(bitmap, i2, i3);
    }

    @DoNotStrip
    public static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
