package com.google.ar.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class AugmentedImageDatabase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    private native int nativeAddImage(long j, long j2, String str, ByteBuffer byteBuffer, int i, int i2, int i3);

    private native int nativeAddImageWithPhysicalSize(long j, long j2, String str, ByteBuffer byteBuffer, int i, int i2, int i3, float f);

    public static native long nativeCreate(long j);

    public static native long nativeDeserialize(long j, ByteBuffer byteBuffer);

    private native int nativeGetNumImages(long j, long j2);

    private native void nativeReleaseDatabase(long j);

    private native ByteBuffer nativeSerialize(long j, long j2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.a;
            if (j != 0) {
                nativeReleaseDatabase(j);
            }
            super.finalize();
        }
    }
}
