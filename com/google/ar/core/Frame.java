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
/* loaded from: classes2.dex */
public class Frame {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Session f63094a;

    /* renamed from: b  reason: collision with root package name */
    public final LightEstimate f63095b;

    /* renamed from: c  reason: collision with root package name */
    public long f63096c;

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

    public Frame(Session session) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {session};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f63096c = 0L;
        this.f63094a = session;
        this.f63096c = nativeCreateFrame(session.f63102a);
        this.f63095b = new LightEstimate(session);
    }

    private native long nativeAcquireCameraImage(long j, long j2);

    private native long nativeAcquireImageMetadata(long j, long j2);

    private native long[] nativeAcquireUpdatedAnchors(long j, long j2);

    public static native long nativeCreateFrame(long j);

    public static native void nativeDestroyFrame(long j);

    private native long nativeGetAndroidCameraTimestamp(long j, long j2);

    private native b.i.c.a.a nativeGetAndroidSensorPose(long j, long j2);

    private native void nativeGetLightEstimate(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2);

    private native boolean nativeHasDisplayGeometryChanged(long j, long j2);

    private native void nativeTransformCoordinates2dFloatArrayOrBuffer(long j, long j2, int i2, Object obj, int i3, Object obj2);

    private native void nativeTransformDisplayUvCoords(long j, long j2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.f63096c;
            if (j != 0) {
                nativeDestroyFrame(j);
            }
            super.finalize();
        }
    }

    public native long nativeAcquirePointCloud(long j, long j2);

    public native long[] nativeAcquireUpdatedTrackables(long j, long j2, int i2);

    public native long[] nativeHitTest(long j, long j2, float f2, float f3);

    public native long[] nativeHitTestRay(long j, long j2, float[] fArr, int i2, float[] fArr2, int i3);

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
        this.f63096c = 0L;
        this.f63096c = 0L;
    }
}
