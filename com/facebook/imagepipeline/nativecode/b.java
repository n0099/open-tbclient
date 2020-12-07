package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes6.dex */
public class b {
    private static boolean paz;

    public static synchronized void eoW() {
        synchronized (b.class) {
            if (!paz) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                paz = true;
            }
        }
    }
}
