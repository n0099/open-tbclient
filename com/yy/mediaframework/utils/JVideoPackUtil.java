package com.yy.mediaframework.utils;
/* loaded from: classes6.dex */
public class JVideoPackUtil {
    public static native void nativeClassInit();

    public static native byte[] packHeader(byte[] bArr, int i, byte[] bArr2, int i2);

    public static native byte[] unpackFrame(byte[] bArr, int i);

    public static native byte[] unpackHeader(byte[] bArr, int i);

    static {
        nativeClassInit();
    }
}
