package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes5.dex */
public class b {
    private static boolean pAd;

    public static synchronized void esa() {
        synchronized (b.class) {
            if (!pAd) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                pAd = true;
            }
        }
    }
}
