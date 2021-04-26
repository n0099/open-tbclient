package com.faceunity.wrapper;
/* loaded from: classes6.dex */
public class faceunity {
    static {
        System.loadLibrary("nama");
    }

    @Deprecated
    public static native int fuAvatarBindItems(int i2, int[] iArr, int[] iArr2);

    public static native int fuAvatarToImage(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, int i8, byte[] bArr);

    public static native int fuAvatarToTexture(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    public static native int fuAvatarToTextureWithTrans(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    @Deprecated
    public static native int fuAvatarUnbindItems(int i2, int[] iArr);

    public static native int fuBeautifyImage(int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuBindItems(int i2, int[] iArr);

    public static native int fuCheckDebugItem(byte[] bArr);

    public static native int fuClearReadbackRelated();

    public static native void fuCreateEGLContext();

    public static native int fuCreateItemFromPackage(byte[] bArr);

    public static native int fuCreateTexForItem(int i2, String str, byte[] bArr, int i3, int i4);

    public static native int fuDeleteTexForItem(int i2, String str);

    public static native void fuDestroyAllItems();

    public static native void fuDestroyItem(int i2);

    public static native void fuDisableBoostWithEGLImage();

    public static native void fuDone();

    public static native int fuDualInputToTexture(long j, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, byte[] bArr2);

    public static native int fuDualInputToTextureMasked(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2);

    public static native int fuGetFaceInfo(int i2, String str, float[] fArr);

    public static native int fuGetModuleCode(int i2);

    public static native int fuGetSystemError();

    public static native String fuGetSystemErrorString(int i2);

    public static native String fuGetVersion();

    public static native int fuHasFace();

    public static native int fuIsTracking();

    public static native double fuItemGetParam(int i2, String str);

    public static native String fuItemGetParamString(int i2, String str);

    public static native byte[] fuItemGetParamu8v(int i2, String str);

    public static native int fuItemSetParam(int i2, String str, double d2);

    public static native int fuItemSetParam(int i2, String str, String str2);

    public static native int fuItemSetParam(int i2, String str, double[] dArr);

    public static native int fuItemSetParamu8v(int i2, String str, byte[] bArr, int i3);

    public static native int fuLoadAnimModel(byte[] bArr);

    public static native int fuLoadExtendedARData(byte[] bArr);

    public static native int fuLoadTongueModel(byte[] bArr);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native void fuReleaseEGLContext();

    public static native int fuRenderI420ImageToTexture(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderNV21ImageToTexture(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToI420Image(long j, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToI420ImageMasked(byte[] bArr, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    public static native int fuRenderToNV21Image(long j, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToNV21ImageMasked(byte[] bArr, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    public static native int fuRenderToRgbaImage(long j, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToTexture(int i2, int i3, int i4, int i5, int[] iArr, int i6);

    public static native int fuRenderToTexture(int i2, int i3, int i4, int i5, int[] iArr, int i6, byte[] bArr, int i7, int i8);

    public static native int fuRenderToYUVImage(long j, long j2, long j3, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8);

    public static native int fuSetAsyncTrackFace(int i2);

    public static native int fuSetDefaultOrientation(int i2);

    public static native void fuSetDefaultRotationMode(int i2);

    public static native void fuSetExpressionCalibration(int i2);

    public static native void fuSetFocalLengthScale(float f2);

    public static native int fuSetMaxFaces(int i2);

    public static native void fuSetQualityTradeoff(float f2);

    public static native void fuSetStrictTracking(int i2);

    public static native int fuSetup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void fuTrackFace(byte[] bArr, int i2, int i3, int i4);

    public static native int fuUnBindItems(int i2, int[] iArr);

    public static native int fuUnbindAllItems(int i2);
}
