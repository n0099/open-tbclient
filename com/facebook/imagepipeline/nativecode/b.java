package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes12.dex */
public class b {
    private static boolean lGn;

    public static synchronized void diC() {
        synchronized (b.class) {
            if (!lGn) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lGn = true;
            }
        }
    }
}
