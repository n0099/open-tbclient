package com.thunder.livesdk.video;

import android.hardware.Camera;
import com.thunder.livesdk.ThunderBridgeLib;
import com.yy.mediaframework.facedetection.IYMFPreviewFrameCallback;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
/* loaded from: classes6.dex */
public class VideoFrameYuvCapture implements IYMFPreviewFrameCallback {
    private static volatile VideoFrameYuvCapture instance;
    private static Object syncLock = new Object();
    private IVideoCaptureObserver mVideoCaptureFrameObserver = null;
    ThunderVideoFrame mVideoFrame = new ThunderVideoFrame();

    public static VideoFrameYuvCapture getInstance() {
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new VideoFrameYuvCapture();
                }
            }
        }
        return instance;
    }

    private VideoFrameYuvCapture() {
    }

    public void enableVideoCapture(IVideoCaptureObserver iVideoCaptureObserver) {
        if (iVideoCaptureObserver != null) {
            this.mVideoCaptureFrameObserver = iVideoCaptureObserver;
            ThunderBridgeLib.getInstance().addPreviewFrameCallback(this);
            return;
        }
        ThunderBridgeLib.getInstance().removePreviewFrameCallback(this);
        this.mVideoCaptureFrameObserver = null;
    }

    @Override // com.yy.mediaframework.facedetection.PreviewFrameCallback
    public void onPreviewFrameAvailable(int i, byte[] bArr, int i2, int i3, Camera camera) {
        if (this.mVideoCaptureFrameObserver != null) {
            this.mVideoCaptureFrameObserver.onCaptureVideoFrame(i2, i3, bArr, bArr.length, i);
        }
    }

    @Override // com.yy.mediaframework.facedetection.IYMFPreviewFrameCallback
    public void onPreviewFrameAvailable(YMFVideoFrame yMFVideoFrame) {
        if (this.mVideoCaptureFrameObserver != null) {
            if (this.mVideoCaptureFrameObserver instanceof ThunderVideoCaptureObserver) {
                this.mVideoFrame.setVideoFrame(yMFVideoFrame);
                ((ThunderVideoCaptureObserver) this.mVideoCaptureFrameObserver).onCaptureVideoFrame(this.mVideoFrame);
                return;
            }
            this.mVideoCaptureFrameObserver.onCaptureVideoFrame(yMFVideoFrame.mYuvWidth, yMFVideoFrame.mYuvHeight, yMFVideoFrame.mYUVCaptureBuffer, yMFVideoFrame.mYUVCaptureBuffer.length, yMFVideoFrame.mImageFormat);
        }
    }
}
