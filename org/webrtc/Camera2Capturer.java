package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import javax.annotation.Nullable;
import org.webrtc.CameraSession;
import org.webrtc.CameraVideoCapturer;
@TargetApi(21)
/* loaded from: classes8.dex */
public class Camera2Capturer extends CameraCapturer {
    @Nullable
    public final CameraManager cameraManager;
    public final Context context;

    public Camera2Capturer(Context context, String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        super(str, cameraEventsHandler, new Camera2Enumerator(context));
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA);
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void changeCaptureFormat(int i2, int i3, int i4) {
        super.changeCaptureFormat(i2, i3, i4);
    }

    @Override // org.webrtc.CameraCapturer
    public void createCameraSession(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, SurfaceTextureHelper surfaceTextureHelper, String str, int i2, int i3, int i4) {
        Camera2Session.create(createSessionCallback, events, context, this.cameraManager, surfaceTextureHelper, str, i2, i3, i4);
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void dispose() {
        super.dispose();
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void initialize(@Nullable SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        super.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ boolean isScreencast() {
        return super.isScreencast();
    }

    @Override // org.webrtc.CameraCapturer
    public /* bridge */ /* synthetic */ void printStackTrace() {
        super.printStackTrace();
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void startCapture(int i2, int i3, int i4) {
        super.startCapture(i2, i3, i4);
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.VideoCapturer
    public /* bridge */ /* synthetic */ void stopCapture() {
        super.stopCapture();
    }

    @Override // org.webrtc.CameraCapturer, org.webrtc.CameraVideoCapturer
    public /* bridge */ /* synthetic */ void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        super.switchCamera(cameraSwitchHandler);
    }
}
