package com.yy.mediaframework.facedetection;

import android.hardware.Camera;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.CameraUtils;
import com.yy.mediaframework.YYCamera;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class CameraPreviewCallbackHost implements Camera.PreviewCallback {
    private static final String TAG = "CameraPreviewCallbackHost";
    private int previewHeight;
    private int previewWidth;
    private ArrayList<PreviewFrameCallback> mCameraPreviewClientList = new ArrayList<>();
    private IYMFPreviewFrameCallback mYMFPreviewFrameCallback = null;
    private Object syncLock = new Object();
    private YMFVideoFrame mYMFVideoFrame = new YMFVideoFrame();
    private long mIndex = 0;
    private AtomicBoolean mCameraNV21DataUsed = new AtomicBoolean(true);

    public void updatePreviewSize(int i, int i2) {
        this.previewHeight = i2;
        this.previewWidth = i;
    }

    public void setYMFPreviewFrameCallback(IYMFPreviewFrameCallback iYMFPreviewFrameCallback) {
        synchronized (this.syncLock) {
            YMFLog.info(this, "[Preview ]", "CameraPreviewCallbackHost setYMFPreviewFrameCallback");
            this.mYMFPreviewFrameCallback = iYMFPreviewFrameCallback;
        }
    }

    public void registerCallback(PreviewFrameCallback previewFrameCallback) {
        synchronized (this.syncLock) {
            if (!this.mCameraPreviewClientList.contains(previewFrameCallback)) {
                this.mCameraPreviewClientList.add(previewFrameCallback);
            }
        }
    }

    public void unregisterCallback(PreviewFrameCallback previewFrameCallback) {
        synchronized (this.syncLock) {
            if (this.mCameraPreviewClientList.contains(previewFrameCallback)) {
                this.mCameraPreviewClientList.remove(previewFrameCallback);
            }
        }
    }

    public void setPreviewCallbackWithBuffer() {
        YMFLog.info(this, "[Preview ]", "CameraPreviewCallbackHost setPreviewCallbackWithBuffer");
        YYCamera.getInstance().setPreviewCallbackWithBuffer(this);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (!CameraUtils.queryCameraBufferHashCode(bArr.hashCode())) {
            YMFLog.warn(this, "[CCapture]", " cameraDataBuffer is old");
            return;
        }
        synchronized (this.syncLock) {
            try {
                this.mIndex++;
                this.mYMFVideoFrame.mImageFormat = 17;
                this.mYMFVideoFrame.mYUVCaptureBuffer = bArr;
                this.mYMFVideoFrame.mYuvWidth = camera.getParameters().getPreviewSize().width;
                this.mYMFVideoFrame.mYuvHeight = camera.getParameters().getPreviewSize().height;
                this.mYMFVideoFrame.mCamera = camera;
                this.mYMFVideoFrame.mIndex = this.mIndex;
                this.mYMFVideoFrame.mWillBeRendered = this.mCameraNV21DataUsed;
                if (this.mCameraPreviewClientList != null && this.mCameraPreviewClientList.size() > 0) {
                    Iterator<PreviewFrameCallback> it = this.mCameraPreviewClientList.iterator();
                    while (it.hasNext()) {
                        PreviewFrameCallback next = it.next();
                        if (next != null) {
                            if (next instanceof IYMFPreviewFrameCallback) {
                                ((IYMFPreviewFrameCallback) next).onPreviewFrameAvailable(this.mYMFVideoFrame);
                            } else {
                                next.onPreviewFrameAvailable(17, bArr, camera.getParameters().getPreviewSize().width, camera.getParameters().getPreviewSize().height, camera);
                            }
                        }
                    }
                }
                if (this.mYMFPreviewFrameCallback != null) {
                    this.mYMFPreviewFrameCallback.onPreviewFrameAvailable(this.mYMFVideoFrame);
                }
            } catch (Exception e) {
                YMFLog.error(this, "[Preview ]", " ui code error " + e.toString());
            }
        }
        CameraInterface.getInstance().addCallbackBuffer(bArr);
    }
}
