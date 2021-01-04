package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
@d
/* loaded from: classes5.dex */
public class NativeRoundingFilter {
    @d
    private static native void nativeToCircleFilter(Bitmap bitmap);

    static {
        a.load();
    }
}
