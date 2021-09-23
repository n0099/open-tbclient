package com.google.ar.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class Camera {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f70547a;

    public Camera() {
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
        this.f70547a = 0L;
    }

    public static native long nativeAcquireCamera(long j2, long j3);

    private native long nativeCreateCameraIntrinsics(long j2);

    private native c.i.c.a.a nativeDisplayOrientedPose(long j2, long j3);

    private native void nativeGetImageIntrinsics(long j2, long j3, long j4);

    private native c.i.c.a.a nativeGetPose(long j2, long j3);

    private native void nativeGetProjectionMatrix(long j2, long j3, float[] fArr, int i2, float f2, float f3);

    private native void nativeGetTextureIntrinsics(long j2, long j3, long j4);

    private native int nativeGetTrackingFailureReason(long j2, long j3);

    private native int nativeGetTrackingState(long j2, long j3);

    private native void nativeGetViewMatrix(long j2, long j3, float[] fArr, int i2);

    public static native void nativeReleaseCamera(long j2);

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Camera) && ((Camera) obj).f70547a == this.f70547a : invokeL.booleanValue;
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j2 = this.f70547a;
            if (j2 != 0) {
                nativeReleaseCamera(j2);
            }
            super.finalize();
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Long.valueOf(this.f70547a).hashCode() : invokeV.intValue;
    }
}
