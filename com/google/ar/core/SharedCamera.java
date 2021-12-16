package com.google.ar.core;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class SharedCamera {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    private native void nativeSharedCameraCaptureSessionActive(long j2, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionClosed(long j2, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionConfigureFailed(long j2, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionConfigured(long j2, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionReady(long j2, CameraCaptureSession cameraCaptureSession);

    private native ImageReader nativeSharedCameraGetImageReader(long j2, CameraDevice cameraDevice);

    private native ImageReader nativeSharedCameraGetImageReaderMotionTracking(long j2, CameraDevice cameraDevice);

    private native Surface nativeSharedCameraGetSurface(long j2, CameraDevice cameraDevice);

    private native SurfaceTexture nativeSharedCameraGetSurfaceTexture(long j2, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnClosed(long j2, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnDisconnected(long j2, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnOpened(long j2, CameraDevice cameraDevice);

    private native void nativeSharedCameraSetAppSurfaces(long j2, String str, List<Surface> list);

    private native void nativeSharedCameraSetCaptureCallback(long j2, CameraCaptureSession.CaptureCallback captureCallback, Handler handler);
}
