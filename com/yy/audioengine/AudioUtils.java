package com.yy.audioengine;
/* loaded from: classes4.dex */
public class AudioUtils {
    private static native byte[] nativeAdtsHeader(int i, int i2, int i3);

    private static native long nativeGetAudioFileTime(String str);

    private static native String nativeGetDeviceInfo();

    private static native long nativeGetTickCount();

    private static native void nativeRunTestCase();

    private static native boolean nativeTransAudioFileToWav(String str, String str2, long j);

    private static native byte[] nativeTransPCM2AAC(byte[] bArr, int i, int i2);

    private static native byte[] nativeTransYYStreamToAAc(byte[] bArr);

    private static native short[] nativeWavShowInfo(String str, int i, int i2);

    public static long getTickCount() {
        return nativeGetTickCount();
    }

    public static byte[] adtsHeader(int i, int i2, int i3) {
        return nativeAdtsHeader(i, i2, i3);
    }

    public static short[] wavShowInfo(String str, int i, int i2) {
        return nativeWavShowInfo(str, i, i2);
    }

    public static boolean transAudioFileToWav(String str, String str2, long j) {
        return nativeTransAudioFileToWav(str, str2, j);
    }

    public static byte[] transPCM2AAC(byte[] bArr, int i, int i2) {
        return nativeTransPCM2AAC(bArr, i, i2);
    }

    public static long getAudioFileTime(String str) {
        return nativeGetAudioFileTime(str);
    }

    public static void runTestCase() {
        nativeRunTestCase();
    }

    public static String getDeviceInfo() {
        return nativeGetDeviceInfo();
    }

    public static byte[] transYYStreamToAAc(byte[] bArr) {
        return nativeTransYYStreamToAAc(bArr);
    }
}
