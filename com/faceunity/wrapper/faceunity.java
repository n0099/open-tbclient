package com.faceunity.wrapper;
/* loaded from: classes.dex */
public class faceunity {
    private static boolean hoQ = false;
    static int[] hMc = new int[2];
    static int[] hMd = new int[1];

    public static native int fuBeautifyImage(int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuCreateItemFromPackage(byte[] bArr);

    public static native void fuDestroyItem(int i);

    public static native int fuDualInputToTexture(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuIsTracking();

    public static native int fuItemSetParam(int i, String str, double d);

    public static native int fuItemSetParam(int i, String str, String str2);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuSetMaxFaces(int i);

    public static native int fuSetup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    static {
        System.loadLibrary("nama");
    }
}
