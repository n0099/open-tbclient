package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes15.dex */
public class b {
    private static boolean pxy;

    public static synchronized void erJ() {
        synchronized (b.class) {
            if (!pxy) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                pxy = true;
            }
        }
    }
}
