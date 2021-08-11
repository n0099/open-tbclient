package com.google.ar.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class Frame {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69852a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1863843292, "Lcom/google/ar/core/Frame;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1863843292, "Lcom/google/ar/core/Frame;");
                return;
            }
        }
        new ArrayList();
        new ArrayList();
    }

    public Frame() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69852a = 0L;
        this.f69852a = 0L;
    }

    private native long nativeAcquireCameraImage(long j2, long j3);

    private native long nativeAcquireImageMetadata(long j2, long j3);

    private native long[] nativeAcquireUpdatedAnchors(long j2, long j3);

    public static native long nativeCreateFrame(long j2);

    public static native void nativeDestroyFrame(long j2);

    private native long nativeGetAndroidCameraTimestamp(long j2, long j3);

    private native c.i.c.a.a nativeGetAndroidSensorPose(long j2, long j3);

    private native void nativeGetLightEstimate(long j2, long j3, long j4);

    private native long nativeGetTimestamp(long j2, long j3);

    private native boolean nativeHasDisplayGeometryChanged(long j2, long j3);

    private native void nativeTransformCoordinates2dFloatArrayOrBuffer(long j2, long j3, int i2, Object obj, int i3, Object obj2);

    private native void nativeTransformDisplayUvCoords(long j2, long j3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.f69852a;
            if (j2 != 0) {
                nativeDestroyFrame(j2);
            }
            super.finalize();
        }
    }

    public native long nativeAcquirePointCloud(long j2, long j3);

    public native long[] nativeAcquireUpdatedTrackables(long j2, long j3, int i2);

    public native long[] nativeHitTest(long j2, long j3, float f2, float f3);

    public native long[] nativeHitTestRay(long j2, long j3, float[] fArr, int i2, float[] fArr2, int i3);
}
