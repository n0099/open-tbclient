package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* loaded from: classes12.dex */
public class b {
    private static boolean mPv;

    public static synchronized void dBD() {
        synchronized (b.class) {
            if (!mPv) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.common.e.a.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError e) {
                    }
                }
                com.facebook.common.e.a.loadLibrary("static-webp");
                mPv = true;
            }
        }
    }
}
