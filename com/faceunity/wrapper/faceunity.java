package com.faceunity.wrapper;
/* loaded from: classes5.dex */
public class faceunity {
    private static boolean azF = false;
    static int[] kpQ = new int[2];
    static int[] kpR = new int[1];

    public static native int fuAvatarBindItems(int i, int[] iArr, int[] iArr2);

    public static native int fuAvatarToImage(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr);

    public static native int fuAvatarToTexture(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuAvatarToTextureWithTrans(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, int i, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuAvatarUnbindItems(int i, int[] iArr);

    public static native int fuBeautifyImage(int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuBindItems(int i, int[] iArr);

    public static native int fuCheckDebugItem(byte[] bArr);

    public static native int fuClearReadbackRelated();

    public static native void fuCreateEGLContext();

    public static native int fuCreateItemFromPackage(byte[] bArr);

    public static native void fuDestroyAllItems();

    public static native void fuDestroyItem(int i);

    public static native void fuDisableBoostWithEGLImage();

    public static native void fuDone();

    public static native int fuDualInputToTexture(long j, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, byte[] bArr2);

    public static native int fuDualInputToTextureMasked(byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2);

    public static native int fuGetFaceInfo(int i, String str, float[] fArr);

    public static native int fuGetModuleCode(int i);

    public static native int fuGetSystemError();

    public static native String fuGetSystemErrorString(int i);

    public static native String fuGetVersion();

    public static native int fuHasFace();

    public static native int fuIsTracking();

    public static native double fuItemGetParam(int i, String str);

    public static native String fuItemGetParamString(int i, String str);

    public static native byte[] fuItemGetParamu8v(int i, String str);

    public static native int fuItemSetParam(int i, String str, double d);

    public static native int fuItemSetParam(int i, String str, String str2);

    public static native int fuItemSetParam(int i, String str, double[] dArr);

    public static native int fuItemSetParamu8v(int i, String str, byte[] bArr, int i2);

    public static native int fuLoadAnimModel(byte[] bArr);

    public static native int fuLoadExtendedARData(byte[] bArr);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native void fuReleaseEGLContext();

    public static native int fuRenderI420ImageToTexture(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderNV21ImageToTexture(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToI420Image(long j, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToI420Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, byte[] bArr2);

    public static native int fuRenderToI420ImageMasked(byte[] bArr, int i, int i2, int i3, int[] iArr, int[] iArr2);

    public static native int fuRenderToNV21Image(long j, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToNV21Image(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, byte[] bArr2);

    public static native int fuRenderToNV21ImageMasked(byte[] bArr, int i, int i2, int i3, int[] iArr, int[] iArr2);

    public static native int fuRenderToRgbaImage(long j, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i, int i2, int i3, int[] iArr);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, byte[] bArr2);

    public static native int fuRenderToTexture(int i, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToTexture(int i, int i2, int i3, int i4, int[] iArr, int i5, byte[] bArr, int i6, int i7);

    public static native int fuRenderToYUVImage(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7);

    public static native int fuSetDefaultOrientation(int i);

    public static native void fuSetDefaultRotationMode(int i);

    public static native void fuSetExpressionCalibration(int i);

    public static native void fuSetFocalLengthScale(float f);

    public static native int fuSetMaxFaces(int i);

    public static native void fuSetQualityTradeoff(float f);

    public static native void fuSetStrictTracking(int i);

    public static native int fuSetup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void fuTrackFace(byte[] bArr, int i, int i2, int i3);

    public static native int fuUnbindAllItems(int i);

    static {
        System.loadLibrary("nama");
    }
}
