package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
@DoNotStrip
/* loaded from: classes6.dex */
public class NativeRoundingFilter {
    static {
        NativeFiltersLoader.load();
    }

    @DoNotStrip
    public static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z);

    public static void toCircle(Bitmap bitmap) {
        toCircle(bitmap, false);
    }

    public static void toCircleWithBorder(Bitmap bitmap, int i2, int i3, boolean z) {
        Preconditions.checkNotNull(bitmap);
        nativeToCircleWithBorderFilter(bitmap, i2, i3, z);
    }

    public static void toCircle(Bitmap bitmap, boolean z) {
        Preconditions.checkNotNull(bitmap);
        nativeToCircleFilter(bitmap, z);
    }
}
