package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
@d
/* loaded from: classes2.dex */
public class NativeBlurFilter {
    @d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);

    static {
        a.load();
    }
}
