package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes10.dex */
public class b {
    private static boolean ntH;

    public static synchronized void dRK() {
        synchronized (b.class) {
            if (!ntH) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                ntH = true;
            }
        }
    }
}
