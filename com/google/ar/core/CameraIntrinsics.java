package com.google.ar.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CameraIntrinsics {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f70549a;

    public CameraIntrinsics() {
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
        this.f70549a = 0L;
        this.f70549a = 0L;
    }

    private native long nativeCreateIntrinsics(long j2, float f2, float f3, float f4, float f5, int i2, int i3);

    private native void nativeDestroyCameraIntrinsics(long j2);

    private native void nativeGetFocalLength(long j2, long j3, float[] fArr, int i2);

    private native void nativeGetImageDimensions(long j2, long j3, int[] iArr, int i2);

    private native void nativeGetPrincipalPoint(long j2, long j3, float[] fArr, int i2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.f70549a;
            if (j2 != 0) {
                nativeDestroyCameraIntrinsics(j2);
            }
            super.finalize();
        }
    }
}
