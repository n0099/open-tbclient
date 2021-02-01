package com.yy.mediaframework;

import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.mediaframework.CameraUtils;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.VideoSizeUtils;
import com.yy.mediaframework.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class CameraInterface implements Runnable {
    public static final int DISPLAY_ROTATION_LANDSCAPE = 90;
    public static final int DISPLAY_ROTATION_LANDSCAPE_UPSIDEDOWN = 270;
    public static final int DISPLAY_ROTATION_PORTRAIT = 0;
    public static final int DISPLAY_ROTATION_PORTRAIT_UPSIDEDOWN = 180;
    private static final int MSG_QUIT = 0;
    private static final String TAG = "CameraInterface";
    private static volatile CameraInterface mInstance;
    public static int mSetCameraFpsParams = 0;
    private CameraUtils.CameraFacing mCameraFacing;
    private Camera.Size mCameraPreviewSize;
    private WeakReference<SurfaceTexture[]> mCameraPreviewSurfaceTextures;
    private String mDefaultMasterFocusMode;
    private String mDefaultSlaveFocusMode;
    private int mDesiredHeight;
    private int mDesiredWidth;
    private PictureInPictureDisplayInfo mDisplayInfo;
    private List<Camera.Area> mFocusArea;
    private FocusListener mFocusListener;
    private TimerTask mFocusTimerTask;
    private CameraInterfaceHandler mHandler;
    private List<Camera.Area> mMeteringArea;
    private TimerTask mMeteringTimerTask;
    private CameraUtils.CameraFacing mOriginalCameraFacing;
    private WeakReference<Camera.PreviewCallback> mPreviewCallbackRef;
    private int mPreviewFormat;
    private WeakReference<SurfaceTexture.OnFrameAvailableListener> mPreviewFrameAvailableListenerRef;
    private VideoSizeUtils.Size mPreviewYuvSize;
    private CameraResolutionMode mResolutionMode;
    private Thread mThread;
    private WeakReference<byte[]> previewCallbackBuffer;
    private Camera mMasterCamera = null;
    private Camera mSlaveCamera = null;
    private int[] mCameraFpsRange = new int[2];
    private int mDisplayRotation = 0;
    private boolean mDisplayPortrait = true;
    private int mDesiredFps = 0;
    private long mLastFaceDetectTime = System.currentTimeMillis();
    private Rect mCurrentFocusArea = null;
    private boolean isFlashOn = false;
    private WeakReference<CameraListener> mCameraListener = new WeakReference<>(null);
    private Object mCameraLock = new Object();
    private Boolean mAlreadyAttached = false;
    private AtomicBoolean mStartLock = new AtomicBoolean(false);
    private final int FOCUS_AREA_SIZE = 300;
    private final int FOCUS_AREA_SIZE_VIVO = 300;
    private boolean mFocusAreaSupported = false;
    private boolean mMeteringAreaSupported = false;
    private boolean mFaceDetectSupported = false;
    private boolean mFaceFocusEnable = false;
    private boolean mFaceFocusRestart = false;
    private boolean mMirror = false;
    private float mResumeZoomValue = 1.0f;
    private int mSurfaceViewWidth = 0;
    private int mSurfaceViewHeight = 0;
    private int mRotation = 90;
    private AtomicBoolean mIsMasterCameraOpened = new AtomicBoolean(false);
    private final AutoFocusCallback mAutoFocusCallback = new AutoFocusCallback();
    Camera.ErrorCallback errorCallback = new Camera.ErrorCallback() { // from class: com.yy.mediaframework.CameraInterface.1
        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            if (CameraInterface.this.mCameraListener != null && CameraInterface.this.mCameraListener.get() != null) {
                ((CameraListener) CameraInterface.this.mCameraListener.get()).reSetEncodingState();
            }
            if (i == 2) {
                YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_CAPTURE_USED_BY_HIGHER_PRIORITY);
            }
            YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_CAPTURE_ERROR);
            YMFLiveUsrBehaviorStat.getInstance().notifyLiveException("open_camere_error_" + i);
            if (i == 100) {
                YMFLog.error(this, "[CCapture]", "CAMERA_ERROR_SERVER_DIED received, openCamera again .");
                CameraInterface.this.openCamera(CameraInterface.this.mDesiredWidth, CameraInterface.this.mDesiredHeight, CameraInterface.this.mDesiredFps, CameraInterface.this.mCameraFacing, CameraInterface.this.mResolutionMode, CameraInterface.this.mDisplayRotation);
            } else if (i == 1) {
                YMFLog.error(this, "[CCapture]", "CAMERA_ERROR_UNKNOWN received, openCamera again .");
                CameraInterface.this.openCamera(CameraInterface.this.mDesiredWidth, CameraInterface.this.mDesiredHeight, CameraInterface.this.mDesiredFps, CameraInterface.this.mCameraFacing, CameraInterface.this.mResolutionMode, CameraInterface.this.mDisplayRotation);
            } else {
                YMFLog.error(this, "[CCapture]", "camera error:" + i);
            }
        }
    };
    Camera.FaceDetectionListener mFaceDetectListener = new Camera.FaceDetectionListener() { // from class: com.yy.mediaframework.CameraInterface.2
        @Override // android.hardware.Camera.FaceDetectionListener
        public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
            for (Camera.Face face : faceArr) {
                RectF rectF = new RectF(face.rect);
                CameraInterface.this.mMatrixDriveToView.mapRect(rectF);
                if (CameraInterface.this.mFaceFocusEnable) {
                    Rect rect = new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    CameraListener cameraListener = (CameraListener) CameraInterface.this.mCameraListener.get();
                    if (cameraListener != null) {
                        CameraInterface.this.mCurrentFocusArea = rect;
                        cameraListener.onCameraFocusAreaChanged(rect);
                        return;
                    }
                    return;
                }
            }
        }
    };
    private Camera.CameraInfo mMasterCameraInfo = new Camera.CameraInfo();
    private Camera.CameraInfo mSlaveCameraInfo = new Camera.CameraInfo();
    private Matrix mMatrix = new Matrix();
    private Matrix mMatrixDriveToView = new Matrix();
    private String mDeviceName = Build.MODEL.toLowerCase();
    private String mDeviceBrand = Build.BRAND.toLowerCase();
    private Timer mCameraTimer = new Timer();

    /* loaded from: classes4.dex */
    public enum CameraResolutionMode {
        CAMERA_RESOLUTION_PRECISE_MODE,
        CAMERA_RESOLUTION_RANGE_MODE
    }

    /* loaded from: classes4.dex */
    public interface FocusListener {
        void focusResult(boolean z);
    }

    public static CameraInterface getInstance() {
        if (mInstance == null) {
            synchronized (CameraInterface.class) {
                if (mInstance == null) {
                    mInstance = new CameraInterface();
                }
            }
        }
        return mInstance;
    }

    public CameraInterface() {
        initThread();
    }

    public void initThread() {
        YMFLog.info(this, "[CCapture]", "initThread construct start.");
        this.mThread = new Thread(this, "YYVideoLib-CameraInterface");
        this.mThread.start();
        synchronized (this.mStartLock) {
            if (!this.mStartLock.get()) {
                try {
                    this.mStartLock.wait();
                } catch (InterruptedException e) {
                    YMFLog.error(this, "[CCapture]", "GlManager construct exception:" + e.getMessage());
                }
            }
        }
        YMFLog.info(this, "[CCapture]", "initThread done.");
    }

    public void setCameraListener(CameraListener cameraListener) {
        YMFLog.info(this, "[CCapture]", "setCameraListener:" + cameraListener);
        if (cameraListener != null) {
            this.mCameraListener = new WeakReference<>(cameraListener);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Looper.prepare();
            this.mHandler = new CameraInterfaceHandler();
            synchronized (this.mStartLock) {
                this.mStartLock.set(true);
                this.mStartLock.notifyAll();
            }
            Looper.loop();
        } catch (Throwable th) {
            try {
                YMFLog.error(this, "[CCapture]", "end looper exception:" + th.getMessage() + " " + th.toString());
            } finally {
                YMFLog.info(this, "[CCapture]", "end looper!");
            }
        }
    }

    public boolean isHasPermission(Camera camera) {
        try {
            Field declaredField = camera.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(camera)).booleanValue();
        } catch (Exception e) {
            return true;
        }
    }

    public int openCamera(int i, int i2, int i3, CameraUtils.CameraFacing cameraFacing, CameraResolutionMode cameraResolutionMode, int i4) {
        CameraListener cameraListener;
        YMFLog.info(this, "[CCapture]", "openCamera desiredWidth:" + i + " ,desiredHeight:" + i2 + " cameraFacing:" + cameraFacing + " ,displayRotation:" + i4 + " ,resMode:" + cameraResolutionMode);
        synchronized (this.mCameraLock) {
            this.mResolutionMode = cameraResolutionMode;
            this.mDesiredWidth = i;
            this.mDesiredHeight = i2;
            this.mDesiredFps = i3;
            this.mCameraFacing = cameraFacing;
            this.mOriginalCameraFacing = cameraFacing;
            this.mDisplayRotation = i4;
            if (this.mMasterCamera != null) {
                releaseCamera(this.mMasterCamera);
            }
            this.mMasterCamera = openCamera(i, i2, i3, cameraFacing, this.mResolutionMode, this.mMasterCameraInfo);
            if (this.mMasterCamera != null && isHasPermission(this.mMasterCamera)) {
                this.mIsMasterCameraOpened.set(true);
                this.mDefaultMasterFocusMode = this.mMasterCamera.getParameters().getFocusMode();
                setCameraZoom(this.mMasterCamera, (int) (this.mResumeZoomValue * 100.0f));
                YMFLog.info(this, "[CCapture]", "mDefaultMasterFocusMode:" + this.mDefaultMasterFocusMode);
                if (this.mMasterCamera != null && this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null && this.mCameraPreviewSize != null) {
                    cameraListener.notifyCameraPreviewParameter(this.mCameraPreviewSize.width, this.mCameraPreviewSize.height, CameraUtils.toAndroidCameraFacing(this.mCameraFacing), this.mResolutionMode);
                }
                return 0;
            }
            if (this.mMasterCamera != null) {
                releaseCamera(this.mMasterCamera);
            }
            this.mIsMasterCameraOpened.set(false);
            return 4;
        }
    }

    public void restart(int i, int i2, int i3, CameraUtils.CameraFacing cameraFacing, int i4, CameraResolutionMode cameraResolutionMode) {
        YMFLog.info(this, "[CCapture]", "restart camera... desiredWidth:" + i + " ,desiredHeight:" + i2 + " cameraFacing" + cameraFacing + " displayRotation:" + i4);
        boolean z = this.mSlaveCamera != null;
        releaseCamera();
        this.mCameraFacing = cameraFacing;
        switch (i4) {
            case 0:
                this.mDisplayRotation = 0;
                break;
            case 1:
                this.mDisplayRotation = 90;
                break;
            case 2:
                this.mDisplayRotation = 180;
                break;
            case 3:
                this.mDisplayRotation = 270;
                break;
        }
        openCamera(i, i2, i3, this.mCameraFacing, cameraResolutionMode, this.mDisplayRotation);
        if (z) {
            openDualCamera(i, i2, i3, this.mDisplayInfo);
        }
    }

    public void restart(int i, int i2, int i3, CameraUtils.CameraFacing cameraFacing, CameraResolutionMode cameraResolutionMode) {
        YMFLog.info(this, "[CCapture]", "restart camera... desiredWidth:" + i + " ,desiredHeight:" + i2 + " cameraFacing:" + cameraFacing);
        boolean z = this.mSlaveCamera != null;
        releaseCamera();
        openCamera(i, i2, i3, this.mCameraFacing, cameraResolutionMode, this.mDisplayRotation);
        if (z) {
            openDualCamera(i, i2, i3, this.mDisplayInfo);
        }
    }

    public Camera openCamera(int i, int i2, int i3, CameraUtils.CameraFacing cameraFacing, CameraResolutionMode cameraResolutionMode, Camera.CameraInfo cameraInfo) {
        if (this.mCameraTimer == null) {
            this.mCameraTimer = new Timer();
        }
        try {
            if (!CameraUtils.isCameraAvailable(cameraFacing == CameraUtils.CameraFacing.FacingFront ? 1 : 0)) {
                YMFLog.info(this, "[CCapture]", "current facing camera not available, change facing camera.");
                cameraFacing = cameraFacing == CameraUtils.CameraFacing.FacingFront ? CameraUtils.CameraFacing.FacingBack : CameraUtils.CameraFacing.FacingFront;
                this.mCameraFacing = cameraFacing;
            }
            Camera openCamera = CameraUtils.openCamera(cameraFacing, cameraInfo);
            if (openCamera == null) {
                YMFLog.error(this, "[CCapture]", "Unable to open camera");
                return null;
            }
            Camera.Parameters parameters = openCamera.getParameters();
            CameraUtils2.chooseBestAspectPreviewSize(this.mDisplayRotation, i, i2, parameters, 0.05d, this.mResolutionMode);
            YMFLog.info(this, "[CCapture]", "chooseBestAspectPreviewSize width:" + parameters.getPreviewSize().width + ", height:" + parameters.getPreviewSize().height);
            CameraUtils.PreviewSize specialCameraPreviewSizeWithModel = CameraUtils.getSpecialCameraPreviewSizeWithModel(Build.MODEL, parameters.getPreviewSize(), cameraFacing);
            if (specialCameraPreviewSizeWithModel != null) {
                parameters.setPreviewSize(specialCameraPreviewSizeWithModel.width, specialCameraPreviewSizeWithModel.height);
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes.contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            } else if (supportedFocusModes.contains("auto")) {
                parameters.setFocusMode("auto");
            }
            if (parameters.isAutoWhiteBalanceLockSupported()) {
                parameters.setAutoWhiteBalanceLock(false);
            }
            if (parameters.isAutoExposureLockSupported()) {
                parameters.setAutoExposureLock(false);
            }
            if (Build.VERSION.SDK_INT >= 15 && parameters.isVideoStabilizationSupported()) {
                parameters.setVideoStabilization(true);
            }
            this.mFocusAreaSupported = CameraUtils.isFocusAreaSupported(parameters);
            this.mMeteringAreaSupported = CameraUtils.isMeteringAreaSupported(parameters);
            this.mFaceDetectSupported = CameraUtils.isFaceDetectionSupported(parameters);
            this.mFaceFocusEnable = false;
            this.mCameraPreviewSize = parameters.getPreviewSize();
            this.mPreviewYuvSize = new VideoSizeUtils.Size(this.mCameraPreviewSize.width, this.mCameraPreviewSize.height);
            parameters.getPreviewFpsRange(this.mCameraFpsRange);
            YMFLog.info(this, "[CCapture]", "get PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mCameraFpsRange[1] / 1000));
            if (this.mCameraFpsRange[0] <= i3 * 1000 && this.mCameraFpsRange[1] >= i3 * 1000) {
                if (UploadStreamStateParams.mCaptureFpsMode == Constant.CaptureFpsMode.AlignEncoder) {
                    parameters.setPreviewFpsRange(this.mCameraFpsRange[0], i3 * 1000);
                    YMFLog.info(this, "[CCapture]", "set PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i3);
                    mSetCameraFpsParams = i3;
                } else {
                    parameters.setPreviewFpsRange(this.mCameraFpsRange[0], this.mCameraFpsRange[1]);
                    mSetCameraFpsParams = this.mCameraFpsRange[1] / 1000;
                    YMFLog.info(this, "[CCapture]", "set PreviewFpsRange:" + (this.mCameraFpsRange[0] / 1000) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.mCameraFpsRange[1] / 1000));
                }
                if (Build.MODEL.equals("SM-G570F")) {
                    parameters.setPreviewFpsRange(this.mCameraFpsRange[0], this.mCameraFpsRange[1]);
                }
                if (Build.MODEL.equalsIgnoreCase("PBEM00") || Build.MODEL.equalsIgnoreCase("VIVO X21A")) {
                    parameters.setPreviewFpsRange(this.mCameraFpsRange[1], this.mCameraFpsRange[1]);
                    YMFLog.info(this, "[CCapture]", "set PreviewFpsRange:" + this.mCameraFpsRange[1] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mCameraFpsRange[1]);
                    mSetCameraFpsParams = this.mCameraFpsRange[1] / 1000;
                }
                openCamera.setParameters(parameters);
            }
            YMFLog.info(this, "[CCapture]", "getPreviewSize width:" + this.mCameraPreviewSize.width + ", height:" + this.mCameraPreviewSize.height);
            if (this.mDisplayRotation == 0 || this.mDisplayRotation == 180) {
                if (this.mCameraPreviewSize.width > this.mCameraPreviewSize.height) {
                    this.mCameraPreviewSize.height = this.mCameraPreviewSize.width + this.mCameraPreviewSize.height;
                    this.mCameraPreviewSize.width = this.mCameraPreviewSize.height - this.mCameraPreviewSize.width;
                    this.mCameraPreviewSize.height -= this.mCameraPreviewSize.width;
                }
            } else if ((this.mDisplayRotation == 90 || this.mDisplayRotation == 270) && this.mCameraPreviewSize.width < this.mCameraPreviewSize.height) {
                this.mCameraPreviewSize.height = this.mCameraPreviewSize.width + this.mCameraPreviewSize.height;
                this.mCameraPreviewSize.width = this.mCameraPreviewSize.height - this.mCameraPreviewSize.width;
                this.mCameraPreviewSize.height -= this.mCameraPreviewSize.width;
            }
            YMFLog.info(this, "[CCapture]", "openCamera width:" + this.mCameraPreviewSize.width + ", height:" + this.mCameraPreviewSize.height + ", displayRotation:" + this.mDisplayRotation);
            if (parameters.getSupportedPreviewFormats().contains(17) && parameters.getPreviewFormat() != 17) {
                parameters.setPreviewFormat(17);
            }
            this.mPreviewFormat = parameters.getPreviewFormat();
            openCamera.setParameters(parameters);
            CameraUtils.setCameraDisplayOrientation(this.mDisplayRotation, openCamera, cameraInfo);
            setMirror(this.mMirror);
            openCamera.setErrorCallback(this.errorCallback);
            this.mDefaultMasterFocusMode = openCamera.getParameters().getFocusMode();
            return openCamera;
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "openCamera exception:" + th);
            return null;
        }
    }

    @Deprecated
    public boolean isDualCameraSupported() {
        return true;
    }

    public int openDualCamera(int i, int i2, int i3, PictureInPictureDisplayInfo pictureInPictureDisplayInfo) {
        int i4;
        int i5;
        int i6;
        CameraListener cameraListener;
        if (!isDualCameraSupported()) {
            YMFLog.error(this, "[CCapture]", "dont support dual camera.");
            return -1;
        }
        YMFLog.info(this, "[CCapture]", "openDualCamera.");
        this.mDisplayInfo = pictureInPictureDisplayInfo;
        if (this.mSlaveCamera != null) {
            releaseCamera(this.mSlaveCamera);
        }
        CameraUtils.CameraFacing cameraFacing = this.mCameraFacing == CameraUtils.CameraFacing.FacingFront ? CameraUtils.CameraFacing.FacingBack : CameraUtils.CameraFacing.FacingFront;
        YMFLog.info(this, "[CCapture]", "openDualCamera facing:" + cameraFacing);
        if (getPreviewSize().width <= 0 || getPreviewSize().height <= 0) {
            i4 = i2;
            i5 = i;
        } else {
            int i7 = getPreviewSize().width;
            i4 = getPreviewSize().height;
            i5 = i7;
        }
        YMFLog.info(this, "[CCapture]", "openDualCamera desiredWidth:" + i5 + " desiredHeight:" + i4);
        this.mSlaveCamera = openCamera(i5, i4, i3, cameraFacing, this.mResolutionMode, this.mSlaveCameraInfo);
        if (this.mSlaveCamera != null) {
            this.mDefaultSlaveFocusMode = this.mSlaveCamera.getParameters().getFocusMode();
            YMFLog.info(this, "[CCapture]", "mDefaultSlaveFocusMode:" + this.mDefaultSlaveFocusMode);
        }
        if (this.mSlaveCamera != null) {
            i6 = 0;
        } else {
            YMFLog.error(this, "[CCapture]", "open rear camera failed.");
            i6 = -1;
        }
        if (i6 != -1) {
            if (this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null) {
                cameraListener.onDualOpen(true);
            }
            if (this.mAlreadyAttached.booleanValue() && this.mCameraPreviewSurfaceTextures != null && this.mCameraPreviewSurfaceTextures.get() != null && this.mPreviewFrameAvailableListenerRef != null && this.mPreviewFrameAvailableListenerRef.get() != null) {
                setCameraPreviewTexture(this.mSlaveCamera, this.mCameraPreviewSurfaceTextures.get()[1], this.mPreviewFrameAvailableListenerRef.get());
            }
        }
        if (cameraFacing == CameraUtils.CameraFacing.FacingFront) {
            if (this.mMasterCamera != null) {
                this.mMasterCamera.setPreviewCallbackWithBuffer(null);
            }
            addCallbackBuffer(this.mSlaveCamera, this.previewCallbackBuffer);
        }
        resetPreviewCallBack();
        return i6;
    }

    public void closeDualCamera() {
        CameraListener cameraListener;
        synchronized (this.mCameraLock) {
            releaseCamera(this.mSlaveCamera);
            this.mSlaveCamera = null;
            releaseCamera(this.mMasterCamera);
            this.mMasterCamera = null;
            openCamera(this.mDesiredWidth, this.mDesiredHeight, this.mDesiredFps, this.mCameraFacing, this.mResolutionMode, this.mDisplayRotation);
            if (this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null) {
                cameraListener.onDualOpen(false);
            }
        }
    }

    public void switchCamera() {
        CameraListener cameraListener;
        CameraListener cameraListener2;
        this.mFaceFocusEnable = false;
        if (isDualCameraSupported() && this.mSlaveCamera != null && this.mMasterCamera != null) {
            if (this.mCameraListener != null && (cameraListener2 = this.mCameraListener.get()) != null) {
                cameraListener2.onDualPictureSwitch();
            }
            this.mCameraFacing = this.mCameraFacing == CameraUtils.CameraFacing.FacingBack ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack;
            return;
        }
        if (this.mMasterCamera != null) {
            releaseCamera(this.mMasterCamera);
        }
        CameraUtils.CameraFacing cameraFacing = this.mCameraFacing == CameraUtils.CameraFacing.FacingBack ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack;
        this.mCameraFacing = cameraFacing;
        this.mOriginalCameraFacing = cameraFacing;
        this.mMasterCamera = openCamera(this.mDesiredWidth, this.mDesiredHeight, this.mDesiredFps, this.mCameraFacing, this.mResolutionMode, this.mMasterCameraInfo);
        if (this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null && this.mCameraPreviewSize != null) {
            cameraListener.notifyCameraPreviewParameter(this.mCameraPreviewSize.width, this.mCameraPreviewSize.height, CameraUtils.toAndroidCameraFacing(this.mCameraFacing), this.mResolutionMode);
        }
        reattachPreviewSurfaceTexture();
        resetPreviewCallBack();
    }

    public boolean isZoomSupport() {
        boolean isZoomSupport;
        synchronized (this.mCameraLock) {
            isZoomSupport = this.mOriginalCameraFacing == this.mCameraFacing ? isZoomSupport(this.mMasterCamera) : isZoomSupport(this.mSlaveCamera);
        }
        return isZoomSupport;
    }

    private boolean isZoomSupport(Camera camera) {
        if (camera == null) {
            YMFLog.error(this, "[CCapture]", "camera is null");
            return false;
        }
        try {
            Camera.Parameters parameters = this.mMasterCamera.getParameters();
            if (parameters == null || !parameters.isZoomSupported()) {
                return false;
            }
            List<Integer> zoomRatios = parameters.getZoomRatios();
            boolean z = zoomRatios != null && zoomRatios.size() > 0 && zoomRatios.size() == parameters.getMaxZoom() + 1;
            YMFLog.info(this, "[CCapture]", "isZoomSupport:" + z + ", getZoomRatios:" + zoomRatios);
            return z;
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "isZoomSupport exception:" + th);
            return false;
        }
    }

    public float getMaxZoom() {
        Camera.Parameters parameters;
        synchronized (this.mCameraLock) {
            if (this.mMasterCamera != null && (parameters = this.mMasterCamera.getParameters()) != null) {
                int maxZoom = parameters.getMaxZoom();
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0 && maxZoom == zoomRatios.size() - 1) {
                    YMFLog.info(this, "[CCapture]", "getMaxZoom:" + maxZoom + "， maxZoomRatio:" + zoomRatios.get(zoomRatios.size() - 1));
                    float intValue = zoomRatios.get(maxZoom).intValue() / 100.0f;
                    if ((this.mDeviceBrand.contains(RomUtils.MANUFACTURER_OPPO) || this.mDeviceBrand.contains(RomUtils.MANUFACTURER_VIVO)) && intValue > 5.0f) {
                        intValue = 5.0f;
                    }
                    return intValue;
                }
            }
            return 1.0f;
        }
    }

    public float setZoom(int i) {
        float f;
        synchronized (this.mCameraLock) {
            if (this.mOriginalCameraFacing == this.mCameraFacing) {
                this.mResumeZoomValue = setCameraZoom(this.mMasterCamera, i);
            } else {
                this.mResumeZoomValue = setCameraZoom(this.mSlaveCamera, i);
            }
            f = this.mResumeZoomValue;
        }
        return f;
    }

    private float setCameraZoom(Camera camera, int i) {
        List<Integer> zoomRatios;
        int i2;
        if (camera == null) {
            YMFLog.error(this, "[CCapture]", "camera is null");
            return 5.0f;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters != null && (zoomRatios = parameters.getZoomRatios()) != null && i >= 0) {
                int i3 = 0;
                Iterator<Integer> it = zoomRatios.iterator();
                while (true) {
                    i2 = i3;
                    if (!it.hasNext() || it.next().intValue() >= i || i2 == zoomRatios.size() - 1) {
                        break;
                    }
                    i3 = i2 + 1;
                }
                if (i2 != parameters.getZoom()) {
                    parameters.setZoom(i2);
                    camera.setParameters(parameters);
                }
                float intValue = zoomRatios.get(i2).intValue();
                YMFLog.info(this, "[CCapture]", "setZoom:" + i + ", zoomidx: " + i2 + ", zoomRatio:" + intValue);
                return intValue / 100.0f;
            }
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "setZoom exception:" + th.toString());
        }
        return 1.0f;
    }

    public void switchCameraFacing() {
        if (this.mMasterCamera != null) {
            this.mCameraFacing = this.mCameraFacing == CameraUtils.CameraFacing.FacingBack ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack;
            YMFLog.info(this, "[CCapture]", "switchCameraFacing:" + this.mCameraFacing);
        }
    }

    public boolean isTorchSupported() {
        boolean isTorchSupported;
        synchronized (this.mCameraLock) {
            Camera.Parameters parameters = null;
            if (this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingFront) {
                if (this.mSlaveCamera != null) {
                    parameters = this.mSlaveCamera.getParameters();
                }
            } else if (this.mMasterCamera != null) {
                parameters = this.mMasterCamera.getParameters();
            }
            isTorchSupported = CameraUtils.isTorchSupported(parameters);
        }
        return isTorchSupported;
    }

    public boolean setCameraFlashMode(boolean z) {
        boolean cameraFlashMode;
        synchronized (this.mCameraLock) {
            YMFLog.info(this, "[CCapture]", "setCameraFlashMode.");
            if (this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingFront) {
                cameraFlashMode = setCameraFlashMode(this.mSlaveCamera, z);
            } else {
                cameraFlashMode = setCameraFlashMode(this.mMasterCamera, z);
            }
        }
        return cameraFlashMode;
    }

    private boolean setCameraFlashMode(Camera camera, boolean z) {
        boolean z2 = false;
        if (camera == null) {
            return false;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (!CameraUtils.isTorchSupported(parameters)) {
                return false;
            }
            parameters.setFlashMode(z ? "torch" : "off");
            camera.setParameters(parameters);
            this.isFlashOn = z;
            z2 = true;
            return true;
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "setCameraFlashMode exception:" + th);
            return z2;
        }
    }

    public void releaseCamera() {
        CameraListener cameraListener;
        synchronized (this.mCameraLock) {
            releaseCamera(this.mMasterCamera);
            this.mMasterCamera = null;
            releaseCamera(this.mSlaveCamera);
            this.mSlaveCamera = null;
            this.mIsMasterCameraOpened.set(false);
        }
        if (this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null) {
            cameraListener.onDualOpen(false);
        }
    }

    private int releaseCamera(Camera camera) {
        boolean z;
        int i;
        synchronized (this.mCameraLock) {
            if (this.mCameraTimer != null) {
                this.mCameraTimer.cancel();
                this.mCameraTimer = null;
            }
            if (this.mMeteringTimerTask != null) {
                this.mMeteringTimerTask.cancel();
                this.mMeteringTimerTask = null;
            }
            if (this.mFocusTimerTask != null) {
                this.mFocusTimerTask.cancel();
                this.mFocusTimerTask = null;
            }
            if (camera != null) {
                camera.stopPreview();
                camera.setPreviewCallbackWithBuffer(null);
                CameraUtils.setCameraBufferHashCode(0L);
                camera.release();
                mSetCameraFpsParams = 0;
                this.mAlreadyAttached = false;
                YMFLog.info(this, "[CCapture]", "releaseCamera done " + this.mAlreadyAttached);
                z = false;
            } else {
                z = false;
            }
            i = z ? -1 : 0;
        }
        return i;
    }

    public void startPreviewWithSurfaceTexture(SurfaceTexture[] surfaceTextureArr, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        YMFLog.info(this, "[CCapture]", "startPreviewWithSurfaceTexture mCameraFacing:" + this.mCameraFacing + " surfaces[0]:" + surfaceTextureArr[0]);
        synchronized (this.mCameraLock) {
            if (this.mMasterCamera == null || this.mAlreadyAttached.booleanValue()) {
                YMFLog.error(this, "[CCapture]", "master camera not available, should openCamera first or is preview:" + this.mAlreadyAttached);
                return;
            }
            setCameraPreviewTexture(this.mMasterCamera, surfaceTextureArr[0], onFrameAvailableListener);
            this.mCameraPreviewSurfaceTextures = new WeakReference<>(surfaceTextureArr);
            this.mPreviewFrameAvailableListenerRef = new WeakReference<>(onFrameAvailableListener);
            this.mAlreadyAttached = true;
            if (this.mSlaveCamera == null) {
                YMFLog.info(this, "[CCapture]", "slave camera not available, should openCamera first!");
            } else {
                setCameraPreviewTexture(this.mSlaveCamera, surfaceTextureArr[1], onFrameAvailableListener);
            }
        }
    }

    private void setCameraPreviewTexture(Camera camera, SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        try {
            if (camera == null) {
                YMFLog.error(this, "[CCapture]", "camera not available, should openCamera first!");
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
                camera.setPreviewTexture(surfaceTexture);
                camera.startPreview();
                if (this.mFaceFocusRestart) {
                    setCameraAutoFocusFaceModeEnabled(true);
                    this.mFaceFocusRestart = false;
                }
            }
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "setCameraPreviewTexture exception:" + th.toString());
        }
    }

    public void addCallbackBuffer(byte[] bArr) {
        if (bArr == null) {
            YMFLog.error(this, "[CCapture]", "invalid callbackBuffer");
            return;
        }
        this.previewCallbackBuffer = new WeakReference<>(bArr);
        synchronized (this.mCameraLock) {
            if (bArr.length == 0 || bArr.length != getCurrentPreviewBufferSize()) {
                YMFLog.error(this, "[CCapture]", "invalid callbackBuffer");
                return;
            }
            if (this.mSlaveCamera != null && this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingBack) {
                this.mSlaveCamera.addCallbackBuffer(bArr);
                CameraUtils.setCameraBufferHashCode(bArr.hashCode());
            } else {
                this.mMasterCamera.addCallbackBuffer(bArr);
                CameraUtils.setCameraBufferHashCode(bArr.hashCode());
            }
        }
    }

    private void addCallbackBuffer(Camera camera, WeakReference<byte[]> weakReference) {
        if (camera != null && weakReference != null && weakReference.get() != null && weakReference.get().length != 0 && weakReference.get().length == getCurrentPreviewBufferSize()) {
            camera.addCallbackBuffer(weakReference.get());
            CameraUtils.setCameraBufferHashCode(weakReference.get().hashCode());
        }
    }

    public void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        synchronized (this.mCameraLock) {
            if (this.mSlaveCamera != null && this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingBack) {
                if (this.mCameraFacing == CameraUtils.CameraFacing.FacingFront) {
                    this.mMasterCamera.setPreviewCallbackWithBuffer(null);
                    setPreviewCallbackWithBuffer(this.mSlaveCamera, previewCallback);
                }
            } else {
                setPreviewCallbackWithBuffer(this.mMasterCamera, previewCallback);
            }
        }
    }

    private void setPreviewCallbackWithBuffer(Camera camera, Camera.PreviewCallback previewCallback) {
        if (camera == null) {
            YMFLog.error(this, "[CCapture]", "invalid camera.");
            return;
        }
        int bitsPerPixel = ((this.mCameraPreviewSize.width * this.mCameraPreviewSize.height) * ImageFormat.getBitsPerPixel(17)) / 8;
        for (int i = 0; i < 3; i++) {
            byte[] bArr = new byte[bitsPerPixel];
            camera.addCallbackBuffer(bArr);
            CameraUtils.setCameraBufferHashCode(bArr.hashCode());
        }
        camera.setPreviewCallbackWithBuffer(previewCallback);
        this.mPreviewCallbackRef = new WeakReference<>(previewCallback);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        synchronized (this.mCameraLock) {
            if (this.mSlaveCamera != null && this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingBack) {
                this.mSlaveCamera.setPreviewCallback(previewCallback);
                this.mMasterCamera.setPreviewCallback(null);
                this.mPreviewCallbackRef = new WeakReference<>(previewCallback);
            } else if (this.mMasterCamera != null) {
                this.mMasterCamera.setPreviewCallback(previewCallback);
                this.mPreviewCallbackRef = new WeakReference<>(previewCallback);
            }
        }
    }

    public void reattachPreviewSurfaceTexture() {
        String str;
        YMFLog.info(this, "[CCapture]", "reattachPreviewSurfaceTexture");
        synchronized (this) {
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.mPreviewFrameAvailableListenerRef != null ? this.mPreviewFrameAvailableListenerRef.get() : null;
            if (onFrameAvailableListener == null) {
                str = "reattachPreviewSurfaceTexture error! mCameraPreviewSurfaceTextures get null";
            } else {
                SurfaceTexture[] surfaceTextureArr = this.mCameraPreviewSurfaceTextures != null ? this.mCameraPreviewSurfaceTextures.get() : null;
                if (surfaceTextureArr == null) {
                    str = "reattachPreviewSurfaceTexture error! mCameraPreviewSurfaceTextures get null";
                } else {
                    startPreviewWithSurfaceTexture(surfaceTextureArr, onFrameAvailableListener);
                    return;
                }
            }
            StringBuilder append = new StringBuilder().append("reattachPreviewSurfaceTexture exception:");
            if (str == null) {
                str = "unknown";
            }
            YMFLog.error(this, "[CCapture]", append.append(str).toString());
        }
    }

    public void reSetPreviewSurfaceTexture(SurfaceTexture[] surfaceTextureArr) {
        synchronized (this) {
            SurfaceTexture[] surfaceTextureArr2 = this.mCameraPreviewSurfaceTextures != null ? this.mCameraPreviewSurfaceTextures.get() : null;
            if (surfaceTextureArr2 != null && surfaceTextureArr2[0].equals(surfaceTextureArr[0])) {
                this.mCameraPreviewSurfaceTextures = null;
                this.mPreviewFrameAvailableListenerRef = null;
                YMFLog.info(this, "[CCapture]", "clean reattachPreviewSurfaceTexture WeakReference:" + surfaceTextureArr[0]);
            }
        }
    }

    public void resetPreviewCallBack() {
        YMFLog.info(this, "[CCapture]", "resetPreviewCallBack");
        if (this.mPreviewCallbackRef != null && this.mPreviewCallbackRef.get() != null) {
            setPreviewCallbackWithBuffer(this.mPreviewCallbackRef.get());
        } else {
            YMFLog.error(this, "[CCapture]", "resetPreviewCallBack error! mPreviewCallbackRef:" + this.mCameraPreviewSurfaceTextures);
        }
    }

    public Camera.Size getPreviewSize() {
        return this.mCameraPreviewSize;
    }

    public VideoSizeUtils.Size getPreviewYuvSize() {
        return this.mPreviewYuvSize;
    }

    public int getPreviewFormat() {
        return this.mPreviewFormat;
    }

    public CameraUtils.CameraFacing getCameraFacing() {
        return this.mCameraFacing;
    }

    public int getOrginalCameraFacing() {
        return this.mOriginalCameraFacing == CameraUtils.CameraFacing.FacingFront ? 1 : 0;
    }

    public CameraResolutionMode getResolutionMode() {
        return this.mResolutionMode;
    }

    public int getAndroidCameraFacing() {
        return this.mCameraFacing == CameraUtils.CameraFacing.FacingFront ? 1 : 0;
    }

    public boolean isCameraOpened() {
        return this.mIsMasterCameraOpened.get();
    }

    public Camera.CameraInfo getCameraInfo() {
        return (this.mSlaveCamera == null || this.mOriginalCameraFacing != CameraUtils.CameraFacing.FacingBack) ? this.mMasterCameraInfo : this.mSlaveCameraInfo;
    }

    public int getDisplayRotation() {
        return this.mDisplayRotation;
    }

    public int getCurrentPreviewBufferSize() {
        synchronized (this.mCameraLock) {
            if (this.mMasterCamera != null && this.mCameraPreviewSize != null) {
                return ((this.mCameraPreviewSize.width * this.mCameraPreviewSize.height) * ImageFormat.getBitsPerPixel(17)) / 8;
            }
            return 0;
        }
    }

    public PictureInPictureDisplayInfo getPictureInPictureDisplayInfo() {
        return this.mDisplayInfo;
    }

    public void setFocusListen(FocusListener focusListener) {
        this.mFocusListener = focusListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class AutoFocusCallback implements Camera.AutoFocusCallback {
        private AutoFocusCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, final Camera camera) {
            YMFLog.info(this, "[CCapture]", "onAutoFocus...focused:" + z);
            if (CameraInterface.this.mFocusListener != null) {
                CameraInterface.this.mFocusListener.focusResult(z);
            }
            if (CameraInterface.this.mCameraTimer != null) {
                CameraInterface.this.mFocusTimerTask = new TimerTask() { // from class: com.yy.mediaframework.CameraInterface.AutoFocusCallback.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.CameraInterface.AutoFocusCallback.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    YMFLog.info(this, "[CCapture]", "reset camera focus mode:" + CameraInterface.this.mDefaultMasterFocusMode);
                                    Camera.Parameters parameters = camera.getParameters();
                                    parameters.setFocusMode(CameraInterface.this.mDefaultMasterFocusMode);
                                    camera.setParameters(parameters);
                                } catch (Exception e) {
                                    YMFLog.error(this, "[CCapture]", "onAutoFocus exception:" + e.toString());
                                }
                            }
                        });
                    }
                };
                CameraInterface.this.mCameraTimer.schedule(CameraInterface.this.mFocusTimerTask, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    }

    private int setFocusMetering(int i, int i2) {
        final Camera camera;
        int i3;
        this.mMirror = this.mCameraFacing == CameraUtils.CameraFacing.FacingFront;
        this.mCurrentFocusArea = null;
        if (this.mMeteringTimerTask != null) {
            this.mMeteringTimerTask.cancel();
            this.mMeteringTimerTask = null;
        }
        if (this.mFocusTimerTask != null) {
            this.mFocusTimerTask.cancel();
            this.mFocusTimerTask = null;
        }
        if (this.mSlaveCamera == null || this.mCameraFacing == this.mOriginalCameraFacing) {
            camera = this.mMasterCamera;
        } else {
            camera = this.mSlaveCamera;
        }
        setCameraAutoFocusFaceModeEnabled(false);
        if (camera != null) {
            try {
                final Camera.Parameters parameters = camera.getParameters();
                this.mFocusAreaSupported = CameraUtils.isFocusAreaSupported(parameters);
                this.mMeteringAreaSupported = CameraUtils.isMeteringAreaSupported(parameters);
                setMatrix();
                if (this.mFocusArea != null || this.mMeteringArea != null) {
                    resetFocusMeteringArea(camera);
                }
                camera.cancelAutoFocus();
                if (this.mFocusAreaSupported) {
                    this.mFocusArea = new ArrayList();
                    this.mFocusArea.add(new Camera.Area(new android.graphics.Rect(), 1000));
                    calculateTapArea(i, i2, 1.0f, this.mFocusArea.get(0).rect);
                    parameters.setFocusAreas(this.mFocusArea);
                } else {
                    YMFLog.warn(this, "[CCapture]", "focus areas not supported");
                }
                if (this.mMeteringAreaSupported) {
                    if (this.mMeteringArea == null) {
                        this.mMeteringArea = new ArrayList();
                        this.mMeteringArea.add(new Camera.Area(new android.graphics.Rect(), 800));
                        calculateTapArea(i, i2, 1.0f, this.mMeteringArea.get(0).rect);
                        parameters.setMeteringAreas(this.mMeteringArea);
                    }
                } else {
                    YMFLog.warn(this, "[CCapture]", "metering areas not supported");
                }
                if (parameters.getSupportedFocusModes().contains("auto")) {
                    parameters.setFocusMode("auto");
                    YMFLog.info(this, "[CCapture]", "set FOCUS_MODE_AUTO, " + this.mDeviceName);
                }
                camera.setParameters(parameters);
                if (!this.mFocusAreaSupported || camera == null || this.mPreviewCallbackRef == null) {
                    i3 = 0;
                } else {
                    try {
                        camera.autoFocus(this.mAutoFocusCallback);
                        i3 = 0;
                    } catch (Exception e) {
                        YMFLog.error(this, "[CCapture]", "auto focus error!");
                        i3 = -1;
                    }
                }
                if ((this.mDeviceName.toLowerCase().contains(RomUtils.MANUFACTURER_OPPO) || this.mDeviceName.toLowerCase().contains(RomUtils.MANUFACTURER_VIVO)) && this.mCameraTimer != null) {
                    this.mMeteringTimerTask = new TimerTask() { // from class: com.yy.mediaframework.CameraInterface.3
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            YMFLog.info(this, "[CCapture]", "reset metering area to null...");
                            try {
                                parameters.setMeteringAreas(null);
                                camera.setParameters(parameters);
                            } catch (RuntimeException e2) {
                                YMFLog.error(this, "[CCapture]", "meteringCamera setParameters not supported:" + parameters.flatten());
                                YMFLog.error(this, "[CCapture]", "meteringCamera setParameters exception:" + e2.getMessage());
                            }
                        }
                    };
                    this.mCameraTimer.schedule(this.mMeteringTimerTask, 20000L);
                }
            } catch (Exception e2) {
                YMFLog.warn(this, "[CCapture]", "handleFocusMetering exception: " + e2.getMessage());
                return -1;
            }
        } else {
            i3 = -1;
        }
        return i3;
    }

    public int setCameraFocusPosition(float f, float f2) {
        CameraListener cameraListener;
        int focusMetering = setFocusMetering(Math.round(f), Math.round(f2));
        if (focusMetering == 0 && this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null) {
            try {
                Iterator<Camera.Area> it = this.mFocusArea.iterator();
                if (it.hasNext()) {
                    RectF rectF = new RectF(it.next().rect);
                    this.mMatrixDriveToView.mapRect(rectF);
                    cameraListener.onCameraFocusAreaChanged(new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            } catch (Exception e) {
                YMFLog.error(this, "[CCapture]", "setCameraFocusPosition exception:" + e.toString());
            }
        }
        return focusMetering;
    }

    public int setCameraExposurePosition(float f, float f2) {
        CameraListener cameraListener;
        int focusMetering = setFocusMetering(Math.round(f), Math.round(f2));
        if (focusMetering == 0 && this.mCameraListener != null && (cameraListener = this.mCameraListener.get()) != null) {
            try {
                Iterator<Camera.Area> it = this.mMeteringArea.iterator();
                if (it.hasNext()) {
                    RectF rectF = new RectF(it.next().rect);
                    this.mMatrixDriveToView.mapRect(rectF);
                    cameraListener.onCameraExposureAreaChanged(new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            } catch (Exception e) {
                YMFLog.error(this, "[CCapture]", "setCameraExposurePosition exception:" + e.toString());
            }
        }
        return focusMetering;
    }

    public void handleFocusMetering(MotionEvent motionEvent) {
        setFocusMetering(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
    }

    private void resetFocusMeteringArea(Camera camera) {
        this.mFocusArea = null;
        this.mMeteringArea = null;
        if (camera != null) {
            YMFLog.info(this, "[CCapture]", "resetFocusMeteringArea");
            Camera.Parameters parameters = camera.getParameters();
            if (this.mFocusAreaSupported) {
                parameters.setFocusAreas(this.mFocusArea);
            }
            if (this.mMeteringAreaSupported) {
                parameters.setMeteringAreas(this.mMeteringArea);
            }
            camera.setParameters(parameters);
        }
    }

    private void calculateTapArea(int i, int i2, float f, android.graphics.Rect rect) {
        int i3;
        int i4;
        if (this.mDeviceName.contains(RomUtils.MANUFACTURER_VIVO) || this.mDeviceName.contains(RomUtils.MANUFACTURER_OPPO)) {
            i3 = (int) (300.0f * f);
            i4 = (int) (300.0f * f);
        } else {
            i3 = (int) (300.0f * f);
            i4 = (int) (300.0f * f);
        }
        int clamp = CameraUtils.clamp(i - (i3 / 2), 0, this.mSurfaceViewWidth - i3);
        int clamp2 = CameraUtils.clamp(i2 - (i4 / 2), 0, this.mSurfaceViewHeight - i4);
        RectF rectF = new RectF(clamp, clamp2, i3 + clamp, i4 + clamp2);
        this.mMatrix.mapRect(rectF);
        CameraUtils.rectFToRect(rectF, rect);
    }

    public void setSurfaceViewSize(int i, int i2) {
        YMFLog.info(this, "[CCapture]", "setSurfaceViewSize...");
        if (this.mSurfaceViewWidth != i || this.mSurfaceViewHeight != i2) {
            this.mSurfaceViewWidth = i;
            this.mSurfaceViewHeight = i2;
            setMatrix();
        }
    }

    private void setMirror(boolean z) {
        this.mMirror = z;
        setMatrix();
    }

    private void setMatrix() {
        if (this.mSurfaceViewWidth != 0 && this.mSurfaceViewHeight != 0) {
            Matrix matrix = new Matrix();
            CameraUtils.prepareMatrix(matrix, this.mMirror, this.mRotation, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            this.mMatrixDriveToView = matrix;
            matrix.invert(this.mMatrix);
        }
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getDesiredFps() {
        return this.mDesiredFps;
    }

    public String getSettingDPI() {
        return this.mDesiredWidth + Config.EVENT_HEAT_X + this.mDesiredHeight;
    }

    public int getCameraPreviewDesiredWidth() {
        return this.mDesiredWidth;
    }

    public int getCameraPreviewDesiredHeight() {
        return this.mDesiredHeight;
    }

    public boolean post(Runnable runnable) {
        try {
            if (this.mHandler.getLooper() == null) {
                return false;
            }
            return this.mHandler.post(runnable);
        } catch (Throwable th) {
            YMFLog.error(this, "[CCapture]", "CameraInterfaceHandle PostRunnable exception:" + th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class CameraInterfaceHandler extends Handler {
        private WeakReference<CameraInterface> mWeakWay;

        private CameraInterfaceHandler(CameraInterface cameraInterface) {
            this.mWeakWay = new WeakReference<>(cameraInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                    removeCallbacksAndMessages(null);
                    YMFLog.info(this, "[CCapture]", "message quit");
                }
            } else if (this.mWeakWay.get() == null) {
                YMFLog.warn(this, "[CCapture]", "handleMessage: stateManager is null");
            }
        }
    }

    public boolean isCameraManualFocusPositionSupported() {
        return this.mFocusAreaSupported;
    }

    public boolean isCameraManualExposurePositionSupported() {
        return this.mMeteringAreaSupported;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mFaceDetectSupported;
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        Camera camera;
        if (this.mSlaveCamera == null || this.mCameraFacing == this.mOriginalCameraFacing) {
            camera = this.mMasterCamera;
        } else {
            camera = this.mSlaveCamera;
        }
        if (camera != null) {
            try {
                if (isCameraAutoFocusFaceModeSupported()) {
                    if (!z) {
                        if (this.mFaceFocusEnable) {
                            camera.setFaceDetectionListener(null);
                            camera.stopFaceDetection();
                            this.mFaceFocusEnable = false;
                        }
                    } else if (!this.mFaceFocusEnable) {
                        this.mMirror = this.mCameraFacing == CameraUtils.CameraFacing.FacingFront;
                        setMirror(this.mMirror);
                        this.mCurrentFocusArea = null;
                        camera.setFaceDetectionListener(this.mFaceDetectListener);
                        camera.startFaceDetection();
                        this.mFaceFocusEnable = true;
                    }
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                this.mFaceFocusEnable = false;
                return -1;
            }
        }
        return -1;
    }

    public void resumeCameraAutoFocusFace(boolean z) {
        YMFLog.info(this, "[CCapture]", "resume focus: " + this.mFaceFocusEnable);
        this.mFaceFocusRestart = this.mFaceFocusEnable & z;
    }

    public void changeCurZoomValue(float f) {
        this.mResumeZoomValue = f;
    }
}
