package com.faceunity.wrapper;
/* loaded from: classes.dex */
public class faceunity {
    private static boolean hFf = false;
    static int[] ijO = new int[2];
    static int[] ijP = new int[1];

    public static native int fuAvatarBindItems(int i, int[] iArr, int[] iArr2);

    public static native int fuAvatarToTexture(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuAvatarUnbindItems(int i, int[] iArr);

    public static native int fuBeautifyImage(int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native void fuCreateEGLContext();

    public static native int fuCreateItemFromPackage(byte[] bArr);

    public static native void fuDestroyAllItems();

    public static native void fuDestroyItem(int i);

    public static native void fuDisableBoostWithEGLImage();

    public static native void fuDone();

    public static native int fuDualInputToTexture(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, byte[] bArr2);

    public static native int fuDualInputToTextureMasked(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2);

    public static native int fuGetFaceInfo(int i, String str, float[] fArr);

    public static native String fuGetVersion();

    public static native int fuIsTracking();

    public static native double fuItemGetParam(int i, String str);

    public static native String fuItemGetParamString(int i, String str);

    public static native int fuItemSetParam(int i, String str, double d);

    public static native int fuItemSetParam(int i, String str, String str2);

    public static native int fuItemSetParam(int i, String str, double[] dArr);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native void fuReleaseEGLContext();

    public static native int fuRenderI420ImageToTexture(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderNV21ImageToTexture(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, byte[] bArr2);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, byte[] bArr2);

    public static native int fuSetMaxFaces(int i);

    public static native int fuSetup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void fuTrackFace(byte[] bArr, int i, int i2, int i3);

    static {
        System.loadLibrary("nama");
    }
}
