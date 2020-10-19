package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes17.dex */
public class b {
    private static boolean nJb;

    public static synchronized void dVv() {
        synchronized (b.class) {
            if (!nJb) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                nJb = true;
            }
        }
    }
}
