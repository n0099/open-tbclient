package com.yy.videoplayer.utils;
/* loaded from: classes6.dex */
public class ImageUtil {
    public static native int I420ToARGB(byte[] bArr, int i, int i2, byte[] bArr2, boolean z);

    public static native int NV12ToARGB(byte[] bArr, int i, int i2, byte[] bArr2, boolean z);

    public static native void NV12ToYUV420(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void NV12ToYUV420WithStride(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public static native int NV21ToARGB(byte[] bArr, int i, int i2, byte[] bArr2, boolean z);

    public static native void NV21ToYUV420(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void YUV420ToYUV420WithStride(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public static native int YV12ToARGB(byte[] bArr, int i, int i2, byte[] bArr2, boolean z);

    public static String getImageFormatName(int i) {
        switch (i) {
            case 0:
                return "NV21";
            case 1:
                return "NV12";
            case 2:
                return "I420";
            case 3:
                return "YV12";
            case 36:
                return "RGBA";
            default:
                return "";
        }
    }
}
