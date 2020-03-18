package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes13.dex */
public class b {
    private static boolean lIN;

    public static synchronized void dkp() {
        synchronized (b.class) {
            if (!lIN) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lIN = true;
            }
        }
    }
}
