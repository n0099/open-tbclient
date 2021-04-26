package org.webrtc;

import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class JniCommon {
    public static native void nativeAddRef(long j);

    public static native ByteBuffer nativeAllocateByteBuffer(int i2);

    public static native void nativeFreeByteBuffer(ByteBuffer byteBuffer);

    public static native void nativeReleaseRef(long j);
}
