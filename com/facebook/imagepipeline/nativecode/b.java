package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes13.dex */
public class b {
    private static boolean mHn;

    public static synchronized void dyq() {
        synchronized (b.class) {
            if (!mHn) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                mHn = true;
            }
        }
    }
}
