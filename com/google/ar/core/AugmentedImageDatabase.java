package com.google.ar.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class AugmentedImageDatabase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    private native int nativeAddImage(long j2, long j3, String str, ByteBuffer byteBuffer, int i2, int i3, int i4);

    private native int nativeAddImageWithPhysicalSize(long j2, long j3, String str, ByteBuffer byteBuffer, int i2, int i3, int i4, float f2);

    public static native long nativeCreate(long j2);

    public static native long nativeDeserialize(long j2, ByteBuffer byteBuffer);

    private native int nativeGetNumImages(long j2, long j3);

    private native void nativeReleaseDatabase(long j2);

    private native ByteBuffer nativeSerialize(long j2, long j3);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.a;
            if (j2 != 0) {
                nativeReleaseDatabase(j2);
            }
            super.finalize();
        }
    }
}
