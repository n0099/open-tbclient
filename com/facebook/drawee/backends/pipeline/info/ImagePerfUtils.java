package com.facebook.drawee.backends.pipeline.info;
/* loaded from: classes6.dex */
public class ImagePerfUtils {
    public static String toString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "unknown" : "error" : "canceled" : "success" : "intermediate_available" : "origin_available" : "requested";
    }
}
