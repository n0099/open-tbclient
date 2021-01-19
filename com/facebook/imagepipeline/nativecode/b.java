package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes14.dex */
public class b {
    private static boolean pnj;

    public static synchronized void epq() {
        synchronized (b.class) {
            if (!pnj) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                pnj = true;
            }
        }
    }
}
