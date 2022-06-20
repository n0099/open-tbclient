package com.repackage;

import android.media.MediaRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.webrtc.CameraVideoCapturer;
/* compiled from: CameraVideoCapturer.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class ou9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static void $default$addMediaRecorderToCamera(CameraVideoCapturer cameraVideoCapturer, MediaRecorder mediaRecorder, CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cameraVideoCapturer, mediaRecorder, mediaRecorderHandler) == null) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
    }

    @Deprecated
    public static void $default$removeMediaRecorderFromCamera(CameraVideoCapturer cameraVideoCapturer, CameraVideoCapturer.MediaRecorderHandler mediaRecorderHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cameraVideoCapturer, mediaRecorderHandler) == null) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
    }
}
