package com.google.ar.core;

import java.nio.FloatBuffer;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class Frame {
    public final Session a;
    public final LightEstimate b;
    public long c;

    private native long nativeAcquireCameraImage(long j, long j2);

    private native long nativeAcquireImageMetadata(long j, long j2);

    private native long[] nativeAcquireUpdatedAnchors(long j, long j2);

    public static native long nativeCreateFrame(long j);

    public static native void nativeDestroyFrame(long j);

    private native long nativeGetAndroidCameraTimestamp(long j, long j2);

    private native Pose nativeGetAndroidSensorPose(long j, long j2);

    private native void nativeGetLightEstimate(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2);

    private native boolean nativeHasDisplayGeometryChanged(long j, long j2);

    private native void nativeTransformCoordinates2dFloatArrayOrBuffer(long j, long j2, int i, Object obj, int i2, Object obj2);

    private native void nativeTransformDisplayUvCoords(long j, long j2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public native long nativeAcquirePointCloud(long j, long j2);

    public native long[] nativeAcquireUpdatedTrackables(long j, long j2, int i);

    public native long[] nativeHitTest(long j, long j2, float f, float f2);

    public native long[] nativeHitTestRay(long j, long j2, float[] fArr, int i, float[] fArr2, int i2);

    static {
        new ArrayList();
        new ArrayList();
    }

    public Frame() {
        this.c = 0L;
        this.c = 0L;
    }

    public void finalize() {
        long j = this.c;
        if (j != 0) {
            nativeDestroyFrame(j);
        }
        super.finalize();
    }

    public Frame(Session session) {
        this.c = 0L;
        this.a = session;
        this.c = nativeCreateFrame(session.a);
        this.b = new LightEstimate(session);
    }
}
