package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes12.dex */
public class b {
    private static boolean lGi;

    public static synchronized void diA() {
        synchronized (b.class) {
            if (!lGi) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lGi = true;
            }
        }
    }
}
