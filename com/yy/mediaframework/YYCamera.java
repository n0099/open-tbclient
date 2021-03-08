package com.yy.mediaframework;

import android.hardware.Camera;
import android.view.MotionEvent;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.CameraUtils;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public class YYCamera {
    public static final int DISPLAY_ROTATION_LANDSCAPE = 90;
    public static final int DISPLAY_ROTATION_LANDSCAPE_UPSIDEDOWN = 270;
    public static final int DISPLAY_ROTATION_PORTRAIT = 0;
    public static final int DISPLAY_ROTATION_PORTRAIT_UPSIDEDOWN = 180;
    private static final byte[] SYNC_FLAG = new byte[1];
    private static final String TAG = "YYCamera";
    private static volatile YYCamera mInstance;
    private CameraInterface mCameraInterface = CameraInterface.getInstance();
    private int mCameraState;

    public static YYCamera getInstance() {
        if (mInstance == null) {
            synchronized (SYNC_FLAG) {
                if (mInstance == null) {
                    mInstance = new YYCamera();
                }
            }
        }
        return mInstance;
    }

    private YYCamera() {
    }

    public int startPreview(final int i, final int i2, final int i3, final CameraUtils.CameraFacing cameraFacing, final int i4, final CameraInterface.CameraResolutionMode cameraResolutionMode) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.1
            @Override // java.lang.Runnable
            public void run() {
                int i5 = 0;
                YMFLog.info(this, "[Preview ]", "startPreview...");
                YMFLiveUsrBehaviorStat.getInstance().notifyCameraCaptureState(true);
                YMFLiveStatisticManager.getInstance().reset();
                switch (i4) {
                    case 1:
                        i5 = 90;
                        break;
                    case 2:
                        i5 = 180;
                        break;
                    case 3:
                        i5 = 270;
                        break;
                }
                YYCamera.this.mCameraState = YYCamera.this.mCameraInterface.openCamera(i, i2, i3, cameraFacing, cameraResolutionMode, i5);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "startpreview barrier.await exception:" + e.toString());
        }
        return this.mCameraState;
    }

    public int startDualCameraLive(final int i, final int i2, final int i3, final PictureInPictureDisplayInfo pictureInPictureDisplayInfo) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.2
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[CCapture]", "startDualCameraLive, width:" + i + " ,height:" + i2 + " ,fps:" + i3);
                YYCamera.this.mCameraInterface.openDualCamera(i, i2, i3, pictureInPictureDisplayInfo);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            return 0;
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "startDualCameraLive exception:" + e.toString());
            return 0;
        }
    }

    public void changePreviewParameter(final int i, final int i2, final int i3, final CameraUtils.CameraFacing cameraFacing, final int i4, final CameraInterface.CameraResolutionMode cameraResolutionMode) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.3
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Preview ]", "changePreviewParameter...");
                YYCamera.this.mCameraInterface.restart(i, i2, i3, cameraFacing, i4, cameraResolutionMode);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "changePreviewParameter exception:" + e.toString());
        }
    }

    public void changePreviewParameter(final int i, final int i2, final int i3, final CameraUtils.CameraFacing cameraFacing, final CameraInterface.CameraResolutionMode cameraResolutionMode) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.4
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Preview ]", "changePreviewParameter...");
                YYCamera.this.mCameraInterface.restart(i, i2, i3, cameraFacing, cameraResolutionMode);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "changePreviewParameter exception:" + e.toString());
        }
    }

    public void setPreviewCallbackWithBuffer(final Camera.PreviewCallback previewCallback) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.5
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Preview ]", "setPreviewCallbackWithBuffer...");
                YYCamera.this.mCameraInterface.setPreviewCallbackWithBuffer(previewCallback);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "setPreviewCallbackWithBuffer exception:" + e.toString());
        }
    }

    public void stopPreview() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.6
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Preview ]", "stopPreview...");
                YYCamera.this.mCameraInterface.releaseCamera();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "stopPreview exception:" + e.toString());
        }
    }

    public void switchCamera() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.7
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[CCapture]", "switchCamera...");
                YYCamera.this.mCameraInterface.switchCamera();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "switchCamera exception:" + e.toString());
        }
    }

    public boolean isCameraOpen() {
        boolean isCameraOpened = this.mCameraInterface.isCameraOpened();
        YMFLog.info(this, "[CCapture]", "isCameraOpen:" + isCameraOpened);
        return isCameraOpened;
    }

    public Camera.Size getPreviewSize() {
        final Camera.Size[] sizeArr = new Camera.Size[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.8
            @Override // java.lang.Runnable
            public void run() {
                sizeArr[0] = YYCamera.this.mCameraInterface.getPreviewSize();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "getPreviewSize exception:" + e.toString());
        }
        return sizeArr[0];
    }

    public void setCameraFlashMode(final boolean z) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.9
            @Override // java.lang.Runnable
            public void run() {
                YYCamera.this.mCameraInterface.setCameraFlashMode(z);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "setCameraFlashMode exception:" + e.toString());
        }
    }

    public void handleFocusMetering(final MotionEvent motionEvent) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.10
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[CCapture]", "handleFocusMetering...");
                YYCamera.this.mCameraInterface.handleFocusMetering(motionEvent);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "handleFocusMetering exception:" + e.toString());
        }
    }

    public boolean isCameraFront() {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.11
            @Override // java.lang.Runnable
            public void run() {
                zArr[0] = YYCamera.this.mCameraInterface.getCameraFacing() == CameraUtils.CameraFacing.FacingFront;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "isCameraFront exception:" + e.toString());
        }
        return zArr[0];
    }

    public float getMaxZoom() {
        final float[] fArr = new float[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.12
            @Override // java.lang.Runnable
            public void run() {
                fArr[0] = YYCamera.this.mCameraInterface.getMaxZoom();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "getMaxZoom exception:" + e.toString());
        }
        return fArr[0];
    }

    public boolean isZoomSupport() {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.13
            @Override // java.lang.Runnable
            public void run() {
                zArr[0] = YYCamera.this.mCameraInterface.isZoomSupport();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "isZoomSupport exception:" + e.toString());
        }
        return zArr[0];
    }

    public float setZoom(final float f) {
        final float[] fArr = new float[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.14
            @Override // java.lang.Runnable
            public void run() {
                fArr[0] = YYCamera.this.mCameraInterface.setZoom((int) (f * 100.0f));
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "setZoom exception:" + e.toString());
        }
        return fArr[0];
    }

    public void releaseCamera() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.15
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[CCapture]", "releaseCamera...");
                YYCamera.this.mCameraInterface.releaseCamera();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "releaseCamera exception:" + e.toString());
        }
    }

    public void closeDualCamera() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.16
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[CCapture]", "closeDualCamera...");
                YYCamera.this.mCameraInterface.closeDualCamera();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "closeDualCamera exception:" + e.toString());
        }
    }

    public CameraUtils.CameraFacing getCameraFacing() {
        final CameraUtils.CameraFacing[] cameraFacingArr = new CameraUtils.CameraFacing[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.YYCamera.17
            @Override // java.lang.Runnable
            public void run() {
                cameraFacingArr[0] = YYCamera.this.mCameraInterface.getCameraFacing();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[CCapture]", "getCameraFacing exception:" + e.toString());
        }
        return cameraFacingArr[0];
    }

    public boolean isCameraManualFocusPositionSupported() {
        try {
            return this.mCameraInterface.isCameraManualFocusPositionSupported();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCameraManualExposurePositionSupported() {
        try {
            return this.mCameraInterface.isCameraManualExposurePositionSupported();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int setCameraFocusPosition(float f, float f2) {
        try {
            return this.mCameraInterface.setCameraFocusPosition(f, f2);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int setCameraExposurePosition(float f, float f2) {
        try {
            return this.mCameraInterface.setCameraExposurePosition(f, f2);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean isTorchSupported() {
        try {
            return this.mCameraInterface.isTorchSupported();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCameraTorchOn(boolean z) {
        try {
            return this.mCameraInterface.setCameraFlashMode(z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        try {
            return this.mCameraInterface.isCameraAutoFocusFaceModeSupported();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        try {
            return this.mCameraInterface.setCameraAutoFocusFaceModeEnabled(z);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getCameraOrientation() {
        int displayRotation = this.mCameraInterface.getDisplayRotation();
        switch (displayRotation) {
            case 0:
                return 0;
            case 90:
                return 1;
            case 180:
                return 2;
            case 270:
                return 3;
            default:
                return displayRotation;
        }
    }

    public void resumeCameraAutoFocusFace(boolean z) {
        try {
            this.mCameraInterface.resumeCameraAutoFocusFace(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resumeZoomValue(float f) {
        try {
            this.mCameraInterface.changeCurZoomValue(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
