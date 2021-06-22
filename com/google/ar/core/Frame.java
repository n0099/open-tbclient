package com.google.ar.core;

import java.nio.FloatBuffer;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class Frame {

    /* renamed from: a  reason: collision with root package name */
    public long f30937a;

    static {
        new ArrayList();
        new ArrayList();
    }

    public Frame() {
        this.f30937a = 0L;
        this.f30937a = 0L;
    }

    private native long nativeAcquireCameraImage(long j, long j2);

    private native long nativeAcquireImageMetadata(long j, long j2);

    private native long[] nativeAcquireUpdatedAnchors(long j, long j2);

    public static native long nativeCreateFrame(long j);

    public static native void nativeDestroyFrame(long j);

    private native long nativeGetAndroidCameraTimestamp(long j, long j2);

    private native d.g.b.a.a nativeGetAndroidSensorPose(long j, long j2);

    private native void nativeGetLightEstimate(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2);

    private native boolean nativeHasDisplayGeometryChanged(long j, long j2);

    private native void nativeTransformCoordinates2dFloatArrayOrBuffer(long j, long j2, int i2, Object obj, int i3, Object obj2);

    private native void nativeTransformDisplayUvCoords(long j, long j2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public void finalize() {
        long j = this.f30937a;
        if (j != 0) {
            nativeDestroyFrame(j);
        }
        super.finalize();
    }

    public native long nativeAcquirePointCloud(long j, long j2);

    public native long[] nativeAcquireUpdatedTrackables(long j, long j2, int i2);

    public native long[] nativeHitTest(long j, long j2, float f2, float f3);

    public native long[] nativeHitTestRay(long j, long j2, float[] fArr, int i2, float[] fArr2, int i3);
}
