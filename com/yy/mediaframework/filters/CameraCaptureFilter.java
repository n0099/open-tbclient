package com.yy.mediaframework.filters;

import android.annotation.SuppressLint;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.facedetection.IYMFPreviewFrameCallback;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class CameraCaptureFilter extends AbstractYYMediaFilter implements SurfaceTexture.OnFrameAvailableListener, IYMFPreviewFrameCallback {
    private static final int MAX_BUFFER_COUNT = 1;
    private static final String TAG = "CameraCaptureFilter";
    public SurfaceTexture[] mCaptureSurfaceTextures;
    public int[] mCaptureTexturesIds;
    private int mExpectDataLen;
    VideoLiveFilterContext mFilterContext;
    public long mTextureCreatedThreadId = -1;
    AtomicBoolean mInited = new AtomicBoolean(false);
    private long mCurrentFrameTimeDeltaTickcountNanos = 0;
    public float[] mSlaveTransformer = new float[16];
    private long feedFrameCounter = 0;
    private long feedCurrentTime = 0;
    private long lastPrintTime = 0;
    private List<Long> mCaptureRateList = new ArrayList();
    private long maxDealTime = 0;
    private long averageDealTime = 0;
    private long mDropCount = 0;
    private long mLastTick = 0;
    private List<Long> mDropCountList = new ArrayList();
    private List<Long> mCaptureAverageDealTimeList = new ArrayList();
    private List<Long> mCaptureMaxDealTimeList = new ArrayList();
    private byte[] mCameraNV21Data = null;
    private long mYuvCaptureYYPtsMillions = 0;
    private long mIndex = 0;
    private AtomicBoolean mCameraNV21DataUsed = null;
    private AtomicInteger mCameraFps = new AtomicInteger(0);
    private int mWidth = 0;
    private int mHeight = 0;
    private ReentrantLock mCaptureLock = new ReentrantLock(true);
    private YMFImageBuffer[] mNv21Buffer = new YMFImageBuffer[1];
    private HashMap<Long, YYMediaSample> mSampleMap = new HashMap<>();
    private long mSampleCaptureIndex = 0;
    private long mSampleRenderIndex = 0;

    static /* synthetic */ long access$208(CameraCaptureFilter cameraCaptureFilter) {
        long j = cameraCaptureFilter.mSampleRenderIndex;
        cameraCaptureFilter.mSampleRenderIndex = 1 + j;
        return j;
    }

    public CameraCaptureFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = null;
        this.mFilterContext = videoLiveFilterContext;
        YMFLog.info(this, "[CCapture]", "CameraCaptureFilter construct");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInit() {
        YMFLog.info(this, "[CCapture]", "CameraCaptureFilter doInit begin");
        synchronized (this.mInited) {
            if (!this.mInited.get()) {
                if (CameraInterface.getInstance().isDualCameraSupported()) {
                    this.mCaptureTexturesIds = new int[2];
                    this.mCaptureSurfaceTextures = new SurfaceTexture[2];
                } else {
                    this.mCaptureTexturesIds = new int[1];
                    this.mCaptureSurfaceTextures = new SurfaceTexture[1];
                }
                GLES20.glGenTextures(this.mCaptureSurfaceTextures.length, this.mCaptureTexturesIds, 0);
                for (int i = 0; i < this.mCaptureTexturesIds.length; i++) {
                    GLES20.glBindTexture(36197, this.mCaptureTexturesIds[i]);
                    GLES20.glTexParameterf(36197, 10241, 9729.0f);
                    GLES20.glTexParameterf(36197, 10240, 9729.0f);
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    this.mCaptureSurfaceTextures[i] = new SurfaceTexture(this.mCaptureTexturesIds[i]);
                    this.mCaptureSurfaceTextures[i].setDefaultBufferSize(this.mFilterContext.getCameraPreviewConfig().getWidth(), this.mFilterContext.getCameraPreviewConfig().getHeight());
                    YMFLog.info(this, "[CCapture]", "setDefaultBufferSize:" + this.mFilterContext.getCameraPreviewConfig().getWidth() + "*" + this.mFilterContext.getCameraPreviewConfig().getHeight() + " texture:" + this.mCaptureSurfaceTextures[i]);
                    this.mCaptureSurfaceTextures[i].setOnFrameAvailableListener(this);
                }
                this.mTextureCreatedThreadId = Thread.currentThread().getId();
                YMFLiveStatisticManager.getInstance().setGpuDeviceName(GlUtil.getGpuVendor());
                this.mCameraNV21Data = null;
                this.mInited.set(true);
                this.mInited.notifyAll();
                this.mYuvCaptureYYPtsMillions = 0L;
                YMFLog.info(this, "[CCapture]", "CameraCaptureFilter doInit done");
            }
        }
    }

    public void init() {
        YMFLog.info(this, "[CCapture]", "CameraCaptureFilter init begin");
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraCaptureFilter.this.doInit();
                }
            });
        }
        YMFLog.info(this, "[CCapture]", "CameraCaptureFilter init done");
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doDeInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    CameraCaptureFilter.this.doDeInit();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeInit() {
        synchronized (this.mInited) {
            if (!this.mInited.get()) {
                YMFLog.info(this, "[CCapture]", "doDeInit: no Initalized state, so return");
                return;
            }
            YMFLog.info(this, "[CCapture]", "doDeInit begin");
            CameraInterface.getInstance().reSetPreviewSurfaceTexture(this.mCaptureSurfaceTextures);
            for (SurfaceTexture surfaceTexture : this.mCaptureSurfaceTextures) {
                surfaceTexture.release();
            }
            if (this.mCaptureTexturesIds.length > 0) {
                GLES20.glDeleteTextures(this.mCaptureSurfaceTextures.length, this.mCaptureTexturesIds, 0);
            }
            this.mCameraNV21Data = null;
            this.mInited.set(false);
            this.mInited.notifyAll();
            YMFLog.info(this, "[CCapture]", "doDeInit done");
        }
    }

    public SurfaceTexture[] getCaptureSurfaceTextures() {
        return this.mCaptureSurfaceTextures;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(SurfaceTexture surfaceTexture) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mInited.get() || (!surfaceTexture.equals(this.mCaptureSurfaceTextures[0]) && !surfaceTexture.equals(this.mCaptureSurfaceTextures[1]))) {
            YMFLog.error(this, "[CCapture]", "handleFrameAvailble, not same surfaceTexture or not initialized");
            return;
        }
        surfaceTexture.updateTexImage();
        if (this.mFilterContext.getPictureInPictureFlag() && this.mCaptureSurfaceTextures.length > 1 && this.mCaptureSurfaceTextures[1].equals(surfaceTexture)) {
            surfaceTexture.getTransformMatrix(this.mSlaveTransformer);
            return;
        }
        if (this.mCurrentFrameTimeDeltaTickcountNanos == 0 && surfaceTexture.getTimestamp() != 0) {
            this.mCurrentFrameTimeDeltaTickcountNanos = surfaceTexture.getTimestamp() - (TimeUtil.getTickCountLong() * TimeUtils.NANOS_PER_MS);
            YMFLog.info(this, "[CCapture]", "onFrameAvailable timestamp:" + surfaceTexture.getTimestamp() + " tickcount:" + TimeUtil.getTickCountLong() + " delta:" + this.mCurrentFrameTimeDeltaTickcountNanos);
        }
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mWidth = this.mFilterContext.getCameraPreviewConfig().getWidth();
        alloc.mHeight = this.mFilterContext.getCameraPreviewConfig().getHeight();
        alloc.mAndoridPtsNanos = surfaceTexture.getTimestamp();
        alloc.mYYPtsMillions = this.mCurrentFrameTimeDeltaTickcountNanos == 0 ? TimeUtil.getTickCountLong() : (alloc.mAndoridPtsNanos - this.mCurrentFrameTimeDeltaTickcountNanos) / TimeUtils.NANOS_PER_MS;
        alloc.mResMode = this.mFilterContext.getCameraPreviewConfig().getResMode();
        alloc.mPictureInPictureDisplayInfo = CameraInterface.getInstance().getPictureInPictureDisplayInfo();
        alloc.mImageFormat = 17;
        alloc.mCameraFacing = CameraInterface.getInstance().getAndroidCameraFacing();
        if (this.mFilterContext.getCaptureReplaceImageFlag()) {
            alloc.mCameraFacing = 0;
        }
        alloc.mOrginalCameraFacing = CameraInterface.getInstance().getOrginalCameraFacing();
        alloc.mOrientation = this.mFilterContext.mAndroidContext.getResources().getConfiguration().orientation;
        alloc.mVideoStabilization = this.mFilterContext.getVideoEncoderConfig().videoStabilization;
        surfaceTexture.getTransformMatrix(alloc.mMainTransformer);
        if (this.mFilterContext.getPictureInPictureFlag()) {
            if (alloc.mOrginalCameraFacing == alloc.mCameraFacing) {
                alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
                alloc.mSlaveTextureId = this.mCaptureTexturesIds[1];
            } else {
                alloc.mMasterTextureId = this.mCaptureTexturesIds[1];
                alloc.mSlaveTextureId = this.mCaptureTexturesIds[0];
            }
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_DUALCAMERA);
            alloc.mSlaveTransformer = this.mSlaveTransformer;
        } else {
            alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
            alloc.mSlaveTextureId = -1;
            alloc.mSlaveTransformer = null;
        }
        if (this.mFilterContext.getMirrorFlag()) {
            alloc.mIsMirrorEnable = true;
        } else {
            alloc.mIsMirrorEnable = false;
        }
        if (this.mFilterContext.getPreviwMirrorFlag()) {
            alloc.mIsPreviewMirrorEnable = true;
        } else {
            alloc.mIsPreviewMirrorEnable = false;
        }
        alloc.mTextureTarget = 36197;
        alloc.mTextureCreatedThreadId = this.mTextureCreatedThreadId;
        alloc.mEncodeWidth = this.mFilterContext.getVideoEncoderConfig().getEncodeWidth();
        alloc.mEncodeHeight = this.mFilterContext.getVideoEncoderConfig().getEncodeHeight();
        alloc.mEncoderType = this.mFilterContext.getVideoEncoderConfig().mEncodeType;
        alloc.mScreenCropArea = null;
        alloc.mImageFormat = 70;
        alloc.mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
        alloc.mUseGPUBeauty = this.mFilterContext.mHasBeautyProcess;
        YMFLiveStatisticManager.getInstance().beginCalcPureCap2PreProcessLatency();
        YMFLiveStatisticManager.getInstance().setCameraCaptureFrameRate();
        YMFLiveStatisticManager.getInstance().beginCapture2Encode(alloc.mYYPtsMillions);
        YMFLiveStatisticManager.getInstance().setVideoPtsMaxDiff(alloc.mYYPtsMillions);
        if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
            YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
        }
        deliverToDownStream(alloc);
        alloc.decRef();
        calculateCameraCaptureFrameRate(System.currentTimeMillis() - currentTimeMillis);
    }

    private void handleFrameAvailable(byte[] bArr, int i, int i2, long j) {
        if (this.mInited.get()) {
            YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
            alloc.mDataBytes = bArr;
            alloc.mIndex = j;
            alloc.mIsYUVBuffer = true;
            alloc.mMasterTextureId = -1;
            alloc.mSlaveTextureId = -1;
            alloc.mTextureTarget = -1;
            alloc.mScreenCropArea = null;
            alloc.mYYPtsMillions = this.mYuvCaptureYYPtsMillions;
            alloc.mImageFormat = 0;
            alloc.mCameraFacing = CameraInterface.getInstance().getAndroidCameraFacing();
            alloc.mDataMirror = false;
            if (alloc.mCameraFacing == 0) {
                alloc.mIsMirrorEnable = false;
                alloc.mIsPreviewMirrorEnable = false;
            }
            CameraInterface cameraInterface = CameraInterface.getInstance();
            alloc.mWidth = i;
            alloc.mHeight = i2;
            alloc.mCameraRotate = cameraInterface.getRotation();
            alloc.mSwapWidthHeight = alloc.mCameraRotate == 90 || alloc.mCameraRotate == 270;
            if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
                YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
            }
            if (this.mFilterContext.isYuvTextureMode() || this.mFilterContext.isUseYuvCapture()) {
                alloc.mCameraNV21DataUsed = this.mCameraNV21DataUsed;
                if (this.mFilterContext.getCaptureReplaceImageFlag()) {
                    alloc.mCameraFacing = 0;
                }
                alloc.mOrginalCameraFacing = CameraInterface.getInstance().getOrginalCameraFacing();
                alloc.mPictureInPictureDisplayInfo = CameraInterface.getInstance().getPictureInPictureDisplayInfo();
                if (this.mFilterContext.getPictureInPictureFlag()) {
                    if (alloc.mOrginalCameraFacing == alloc.mCameraFacing) {
                        alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
                        alloc.mSlaveTextureId = this.mCaptureTexturesIds[1];
                    } else {
                        alloc.mMasterTextureId = this.mCaptureTexturesIds[1];
                        alloc.mSlaveTextureId = this.mCaptureTexturesIds[0];
                    }
                    this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_DUALCAMERA);
                    alloc.mSlaveTransformer = this.mSlaveTransformer;
                } else {
                    alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
                    alloc.mSlaveTextureId = -1;
                    alloc.mSlaveTransformer = null;
                }
                if (this.mFilterContext.getMirrorFlag()) {
                    alloc.mIsMirrorEnable = true;
                } else {
                    alloc.mIsMirrorEnable = false;
                }
                if (this.mFilterContext.getPreviwMirrorFlag()) {
                    alloc.mIsPreviewMirrorEnable = true;
                } else {
                    alloc.mIsPreviewMirrorEnable = false;
                }
            }
            int i3 = (int) (this.mIndex % 1);
            if (this.mNv21Buffer[i3] == null || this.mNv21Buffer[i3].mWidth != alloc.mWidth || this.mNv21Buffer[i3].mHeight != alloc.mHeight) {
                this.mNv21Buffer[i3] = new YMFImageBuffer(alloc.mWidth, alloc.mHeight, 0, true);
            }
            alloc.mNv21Buffer = this.mNv21Buffer[i3];
            System.arraycopy(bArr, 0, this.mNv21Buffer[i3].mData.array(), this.mNv21Buffer[i3].mData.arrayOffset(), alloc.mDataBytes.length);
            HashMap<Long, YYMediaSample> hashMap = this.mSampleMap;
            long j2 = this.mSampleCaptureIndex;
            this.mSampleCaptureIndex = 1 + j2;
            hashMap.put(Long.valueOf(j2), alloc);
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.3
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (CameraCaptureFilter.this.mSampleMap.containsKey(Long.valueOf(CameraCaptureFilter.this.mSampleRenderIndex))) {
                        YYMediaSample yYMediaSample = (YYMediaSample) CameraCaptureFilter.this.mSampleMap.get(Long.valueOf(CameraCaptureFilter.this.mSampleRenderIndex));
                        yYMediaSample.mUseGPUBeauty = CameraCaptureFilter.this.mFilterContext.mHasBeautyProcess;
                        yYMediaSample.mIsMirrorEnable = CameraCaptureFilter.this.mFilterContext.getMirrorFlag();
                        yYMediaSample.mResMode = CameraCaptureFilter.this.mFilterContext.getCameraPreviewConfig().getResMode();
                        yYMediaSample.mOrientation = CameraCaptureFilter.this.mFilterContext.mAndroidContext.getResources().getConfiguration().orientation;
                        yYMediaSample.mEncodeWidth = CameraCaptureFilter.this.mFilterContext.getVideoEncoderConfig().getEncodeWidth();
                        yYMediaSample.mEncodeHeight = CameraCaptureFilter.this.mFilterContext.getVideoEncoderConfig().getEncodeHeight();
                        yYMediaSample.mEncoderType = CameraCaptureFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeType;
                        yYMediaSample.mEncoderInputMode = CameraCaptureFilter.this.mFilterContext.getEncoderInputMode();
                        yYMediaSample.mIsPreviewMirrorEnable = CameraCaptureFilter.this.mFilterContext.getPreviwMirrorFlag();
                        YMFLiveStatisticManager.getInstance().beginCalcPureCap2PreProcessLatency();
                        YMFLiveStatisticManager.getInstance().beginCapture2Encode(yYMediaSample.mYYPtsMillions);
                        YMFLiveStatisticManager.getInstance().setVideoPtsMaxDiff(yYMediaSample.mYYPtsMillions);
                        YMFLiveStatisticManager.getInstance().setCameraCaptureFrameRate();
                        CameraCaptureFilter.this.deliverToDownStream(yYMediaSample);
                        if (!CameraCaptureFilter.this.mFilterContext.isYuvTextureMode()) {
                            CameraCaptureFilter.this.mCameraNV21DataUsed.set(true);
                        }
                        yYMediaSample.decRef();
                        CameraCaptureFilter.this.mSampleMap.remove(Long.valueOf(CameraCaptureFilter.this.mSampleRenderIndex));
                        CameraCaptureFilter.this.calculateCameraCaptureFrameRate(System.currentTimeMillis() - currentTimeMillis);
                        CameraCaptureFilter.access$208(CameraCaptureFilter.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvaliable() {
        if (this.mInited.get() && !this.mCameraNV21DataUsed.get()) {
            long currentTimeMillis = System.currentTimeMillis();
            YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
            this.mCaptureLock.lock();
            alloc.mDataBytes = this.mCameraNV21Data;
            alloc.mIndex = this.mIndex;
            alloc.mIsYUVBuffer = true;
            alloc.mMasterTextureId = -1;
            alloc.mSlaveTextureId = -1;
            alloc.mTextureTarget = -1;
            alloc.mScreenCropArea = null;
            alloc.mUseGPUBeauty = this.mFilterContext.mHasBeautyProcess;
            alloc.mIsMirrorEnable = this.mFilterContext.getMirrorFlag();
            alloc.mImageFormat = 0;
            alloc.mResMode = this.mFilterContext.getCameraPreviewConfig().getResMode();
            alloc.mYYPtsMillions = this.mYuvCaptureYYPtsMillions;
            alloc.mCameraFacing = CameraInterface.getInstance().getAndroidCameraFacing();
            alloc.mOrientation = this.mFilterContext.mAndroidContext.getResources().getConfiguration().orientation;
            alloc.mEncodeWidth = this.mFilterContext.getVideoEncoderConfig().getEncodeWidth();
            alloc.mEncodeHeight = this.mFilterContext.getVideoEncoderConfig().getEncodeHeight();
            alloc.mEncoderType = this.mFilterContext.getVideoEncoderConfig().mEncodeType;
            alloc.mEncoderInputMode = this.mFilterContext.getEncoderInputMode();
            alloc.mIsPreviewMirrorEnable = this.mFilterContext.getPreviwMirrorFlag();
            alloc.mDataMirror = false;
            if (alloc.mCameraFacing == 0) {
                alloc.mIsMirrorEnable = false;
                alloc.mIsPreviewMirrorEnable = false;
            }
            CameraInterface cameraInterface = CameraInterface.getInstance();
            alloc.mWidth = this.mWidth;
            alloc.mHeight = this.mHeight;
            alloc.mCameraRotate = cameraInterface.getRotation();
            alloc.mSwapWidthHeight = alloc.mCameraRotate == 90 || alloc.mCameraRotate == 270;
            if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
                YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
            }
            if (this.mFilterContext.isYuvTextureMode() || this.mFilterContext.isUseYuvCapture()) {
                alloc.mCameraNV21DataUsed = this.mCameraNV21DataUsed;
                if (this.mFilterContext.getCaptureReplaceImageFlag()) {
                    alloc.mCameraFacing = 0;
                }
                alloc.mOrginalCameraFacing = CameraInterface.getInstance().getOrginalCameraFacing();
                alloc.mPictureInPictureDisplayInfo = CameraInterface.getInstance().getPictureInPictureDisplayInfo();
                if (this.mFilterContext.getPictureInPictureFlag()) {
                    if (alloc.mOrginalCameraFacing == alloc.mCameraFacing) {
                        alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
                        alloc.mSlaveTextureId = this.mCaptureTexturesIds[1];
                    } else {
                        alloc.mMasterTextureId = this.mCaptureTexturesIds[1];
                        alloc.mSlaveTextureId = this.mCaptureTexturesIds[0];
                    }
                    this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_DUALCAMERA);
                    alloc.mSlaveTransformer = this.mSlaveTransformer;
                } else {
                    alloc.mMasterTextureId = this.mCaptureTexturesIds[0];
                    alloc.mSlaveTextureId = -1;
                    alloc.mSlaveTransformer = null;
                }
                if (this.mFilterContext.getMirrorFlag()) {
                    alloc.mIsMirrorEnable = true;
                } else {
                    alloc.mIsMirrorEnable = false;
                }
                if (this.mFilterContext.getPreviwMirrorFlag()) {
                    alloc.mIsPreviewMirrorEnable = true;
                } else {
                    alloc.mIsPreviewMirrorEnable = false;
                }
            }
            YMFLiveStatisticManager.getInstance().beginCalcPureCap2PreProcessLatency();
            YMFLiveStatisticManager.getInstance().beginCapture2Encode(alloc.mYYPtsMillions);
            YMFLiveStatisticManager.getInstance().setVideoPtsMaxDiff(alloc.mYYPtsMillions);
            this.mCaptureLock.unlock();
            deliverToDownStream(alloc);
            alloc.decRef();
            if (!this.mFilterContext.isYuvTextureMode()) {
                this.mCameraNV21DataUsed.set(true);
            }
            YMFLiveStatisticManager.getInstance().setCameraCaptureFrameRate();
            calculateCameraCaptureFrameRate(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private String transform2String(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (float f : fArr) {
            sb.append(String.valueOf(f));
            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        }
        return sb.toString();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        if (!this.mFilterContext.isUseYuvCapture() && !this.mFilterContext.isYuvTextureMode()) {
            if (this.mFilterContext.getGlManager().checkSameThread()) {
                handleFrameAvailable(surfaceTexture);
            } else {
                this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraCaptureFilter.this.handleFrameAvailable(surfaceTexture);
                    }
                });
            }
        } else if (!this.mFilterContext.isYuvTextureMode()) {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.5
                @Override // java.lang.Runnable
                public void run() {
                    surfaceTexture.updateTexImage();
                }
            });
        }
    }

    private void requireDealCameraFrame() {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            handleFrameAvaliable();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.CameraCaptureFilter.6
                @Override // java.lang.Runnable
                public void run() {
                    CameraCaptureFilter.this.handleFrameAvaliable();
                }
            });
        }
    }

    @Override // com.yy.mediaframework.facedetection.PreviewFrameCallback
    public void onPreviewFrameAvailable(int i, byte[] bArr, int i2, int i3, Camera camera) {
        if (this.mFilterContext.isUseYuvCapture() || this.mFilterContext.isYuvTextureMode()) {
            if (this.mCameraNV21DataUsed == null) {
                this.mCameraNV21DataUsed = new AtomicBoolean(true);
            }
            if (this.mCameraNV21DataUsed.get()) {
                this.mCaptureLock.lock();
                if (this.mCameraNV21Data == null || this.mCameraNV21Data.length != bArr.length) {
                    this.mWidth = i2;
                    this.mHeight = i3;
                    this.mCameraNV21Data = new byte[((this.mWidth * this.mHeight) * ImageFormat.getBitsPerPixel(17)) / 8];
                }
                this.mYuvCaptureYYPtsMillions = TimeUtil.getTickCountLong();
                System.arraycopy(bArr, 0, this.mCameraNV21Data, 0, bArr.length);
                this.mCaptureLock.unlock();
                this.mCameraNV21DataUsed.set(false);
                requireDealCameraFrame();
            }
        }
    }

    @Override // com.yy.mediaframework.facedetection.IYMFPreviewFrameCallback
    public void onPreviewFrameAvailable(YMFVideoFrame yMFVideoFrame) {
        if (yMFVideoFrame != null) {
            if (this.mFilterContext.isUseYuvCapture() || this.mFilterContext.isYuvTextureMode()) {
                this.mCameraNV21DataUsed = yMFVideoFrame.mWillBeRendered;
                if (this.mCameraNV21DataUsed.get()) {
                    this.mCameraNV21DataUsed.set(false);
                    this.mIndex = yMFVideoFrame.mIndex;
                    this.mYuvCaptureYYPtsMillions = TimeUtil.getTickCountLong();
                    handleFrameAvailable(yMFVideoFrame.mYUVCaptureBuffer, yMFVideoFrame.mYuvWidth, yMFVideoFrame.mYuvHeight, yMFVideoFrame.mIndex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateCameraCaptureFrameRate(long j) {
        try {
            this.feedFrameCounter++;
            this.feedCurrentTime = System.currentTimeMillis();
            this.maxDealTime = this.maxDealTime < j ? j : this.maxDealTime;
            this.averageDealTime += j;
            if (this.feedCurrentTime - this.lastPrintTime >= 1000) {
                this.mCameraFps.set((int) this.feedFrameCounter);
                this.mCaptureRateList.add(Long.valueOf(this.feedFrameCounter));
                this.mCaptureAverageDealTimeList.add(Long.valueOf(this.averageDealTime / this.feedFrameCounter));
                this.mCaptureMaxDealTimeList.add(Long.valueOf(this.maxDealTime));
                this.mDropCountList.add(Long.valueOf(this.mDropCount));
                if (this.mFilterContext.mDeliverCallback != null) {
                    this.mFilterContext.mDeliverCallback.onVideoFrameProcessTime((float) this.maxDealTime, ((float) this.averageDealTime) / ((float) this.feedFrameCounter));
                }
                VideoDataStat.getInstance().setCameraCaptureFrameRate(this.feedFrameCounter);
                if (this.mCaptureRateList.size() >= 5) {
                    printFrameRate("CameraCapture", this.mCaptureRateList, this.mCaptureAverageDealTimeList, this.mCaptureMaxDealTimeList, this.mDropCountList);
                    this.mCaptureRateList.clear();
                    this.mCaptureMaxDealTimeList.clear();
                    this.mCaptureAverageDealTimeList.clear();
                    this.mDropCountList.clear();
                }
                this.feedFrameCounter = 0L;
                this.lastPrintTime = this.feedCurrentTime;
                this.maxDealTime = 0L;
                this.averageDealTime = 0L;
                this.mDropCount = 0L;
            }
        } catch (Exception e) {
            YMFLog.error(this, "[CCapture]", "printCameraCaptureFrameRate exception:" + e.toString());
        }
    }

    private void printFrameRate(String str, List<Long> list, List<Long> list2, List<Long> list3, List<Long> list4) {
        if (list != null) {
            String str2 = " ";
            for (int i = 0; i < list.size(); i++) {
                str2 = str2 + list.get(i) + ":" + list2.get(i) + ":" + list3.get(i) + ":" + list4.get(i) + ", ";
            }
            YMFLog.info(this, "[CCapture]", "handleFrameAvailable feed data frame rate::[" + str2 + "] type:" + str + " yuv:" + this.mFilterContext.isUseYuvCapture() + " beauty:" + this.mFilterContext.mHasBeautyProcess + " " + this.mFilterContext.mViewState);
        }
    }

    public int getCurrentCameraFps() {
        return this.mCameraFps.get();
    }
}
