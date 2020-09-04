package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes20.dex */
public class b {
    private static boolean njI;

    public static synchronized void dNM() {
        synchronized (b.class) {
            if (!njI) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                njI = true;
            }
        }
    }
}
