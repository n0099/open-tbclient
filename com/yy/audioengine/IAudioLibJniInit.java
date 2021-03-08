package com.yy.audioengine;

import android.content.Context;
/* loaded from: classes6.dex */
public class IAudioLibJniInit {
    private static Context mContext;

    private static native void nativeEnableOpenSlEsInputJavaOutput(Context context, boolean z);

    private static native void nativeEnableOpenSlEsOutputNewLogic(Context context, boolean z);

    private static native void nativeInitLib(Context context);

    private static native void nativeSetAndroidAudioLayer(Context context, int i);

    private static native void nativeSetAndroidOpenSlEsParam(Context context, int i, int i2, int i3, int i4, int i5);

    private static native void nativeSetAudioAdaptationConfig(Context context, int[] iArr);

    private static native void nativeSetAudioKaraokeCompValue(Context context, int i);

    private static native void nativeUseAndroidOpenSlEs(Context context, boolean z);

    public static void initLib(Context context) {
        mContext = context;
        nativeInitLib(context);
    }

    public static void enableAndroidOpenSlEs(boolean z) {
        nativeUseAndroidOpenSlEs(mContext, z);
    }

    public static void enableOpenSlEsInputJavaOutput(boolean z) {
        nativeEnableOpenSlEsInputJavaOutput(mContext, z);
    }

    public static void enableOpenSlEsOutputNewLogic(boolean z) {
        nativeEnableOpenSlEsOutputNewLogic(mContext, z);
    }

    public static void setAndroidOpenSlEsParam(int i, int i2, int i3, int i4, int i5) {
        nativeSetAndroidOpenSlEsParam(mContext, i, i2, i3, i4, i5);
    }

    public static void setAudioAdaptationConfig(int[] iArr) {
        if (iArr != null) {
            nativeSetAudioAdaptationConfig(mContext, iArr);
        }
    }

    public static void setAudioKaraokeCompValue(int i) {
        nativeSetAudioKaraokeCompValue(mContext, i);
    }

    public static void setAndroidAudioLayer(int i) {
        nativeSetAndroidAudioLayer(mContext, i);
    }

    public static void enableLog(boolean z, String str) {
    }
}
