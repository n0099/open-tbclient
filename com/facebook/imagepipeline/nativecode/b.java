package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes13.dex */
public class b {
    private static boolean lGW;

    public static synchronized void djR() {
        synchronized (b.class) {
            if (!lGW) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lGW = true;
            }
        }
    }
}
