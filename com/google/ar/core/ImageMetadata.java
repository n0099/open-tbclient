package com.google.ar.core;

import android.util.Rational;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ImageMetadata {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    public ImageMetadata() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
    }

    private native void nativeDestroyMetadataEntry(long j2, long j3);

    private native long[] nativeGetAllKeys(long j2, long j3);

    private native byte[] nativeGetByteArrayFromMetadataEntry(long j2, long j3);

    private native byte nativeGetByteFromMetadataEntry(long j2, long j3);

    private native double[] nativeGetDoubleArrayFromMetadataEntry(long j2, long j3);

    private native double nativeGetDoubleFromMetadataEntry(long j2, long j3);

    private native float[] nativeGetFloatArrayFromMetadataEntry(long j2, long j3);

    private native float nativeGetFloatFromMetadataEntry(long j2, long j3);

    private native int[] nativeGetIntArrayFromMetadataEntry(long j2, long j3);

    private native int nativeGetIntFromMetadataEntry(long j2, long j3);

    private native long[] nativeGetLongArrayFromMetadataEntry(long j2, long j3);

    private native long nativeGetLongFromMetadataEntry(long j2, long j3);

    private native long nativeGetMetadataEntry(long j2, long j3, int i2);

    private native int nativeGetMetadataEntryValueCount(long j2, long j3);

    private native int nativeGetMetadataEntryValueType(long j2, long j3);

    private native Rational[] nativeGetRationalArrayFromMetadataEntry(long j2, long j3);

    private native Rational nativeGetRationalFromMetadataEntry(long j2, long j3);

    public static native void nativeLoadSymbols();

    public static native void nativeReleaseImageMetadata(long j2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.a;
            if (j2 != 0) {
                nativeReleaseImageMetadata(j2);
            }
            super.finalize();
        }
    }
}
