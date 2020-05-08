package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes13.dex */
public class b {
    private static boolean lQm;

    public static synchronized void dmb() {
        synchronized (b.class) {
            if (!lQm) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lQm = true;
            }
        }
    }
}
