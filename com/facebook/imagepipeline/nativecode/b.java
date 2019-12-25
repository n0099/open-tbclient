package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes11.dex */
public class b {
    private static boolean lCK;

    public static synchronized void dhz() {
        synchronized (b.class) {
            if (!lCK) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                lCK = true;
            }
        }
    }
}
