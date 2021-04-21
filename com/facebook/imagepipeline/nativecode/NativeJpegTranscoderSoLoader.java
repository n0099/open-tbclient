package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.soloader.SoLoaderProxy;
/* loaded from: classes6.dex */
public class NativeJpegTranscoderSoLoader {
    public static boolean sInitialized;

    public static synchronized void ensure() {
        synchronized (NativeJpegTranscoderSoLoader.class) {
            if (!sInitialized) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        SoLoaderProxy.loadLibrary("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                SoLoaderProxy.loadLibrary("native-imagetranscoder");
                sInitialized = true;
            }
        }
    }
}
