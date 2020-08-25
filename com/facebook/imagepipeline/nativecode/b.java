package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes20.dex */
public class b {
    private static boolean njq;

    public static synchronized void dND() {
        synchronized (b.class) {
            if (!njq) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                njq = true;
            }
        }
    }
}
