package com.yy.transvod.net;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class NetRequestHandler {
    public static native void onNetComplete(long j, int i);

    public static native void onNetCompleteStream(long j, long j2, int i);

    public static native void onNetData(long j, ByteBuffer byteBuffer);

    public static native void onNetDataStream(long j, long j2, ByteBuffer byteBuffer);

    public static native void onNetDateInByteArray(long j, byte[] bArr);

    public static native void onNetError(long j, int i);

    public static native void onNetErrorStream(long j, long j2, int i, int i2);

    public static native void onNetFileLength(long j, long j2);

    public static native void onNetStatIntValue(long j, int i, int i2);

    public static native void onNetStatStringValue(long j, int i, String str);

    public static native void onNetStatus(long j, long j2, int i);

    public static native void onStreamCreate(long j, long j2);
}
