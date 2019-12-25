package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
@com.facebook.common.internal.d
/* loaded from: classes9.dex */
public class NativeBlurFilter {
    @com.facebook.common.internal.d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);

    static {
        a.load();
    }
}
