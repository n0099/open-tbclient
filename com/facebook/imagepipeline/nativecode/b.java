package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes18.dex */
public class b {
    private static boolean oLr;

    public static synchronized void ejg() {
        synchronized (b.class) {
            if (!oLr) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                oLr = true;
            }
        }
    }
}
