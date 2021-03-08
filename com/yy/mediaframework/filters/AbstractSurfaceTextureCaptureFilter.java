package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class AbstractSurfaceTextureCaptureFilter extends AbstractYYMediaFilter implements SurfaceTexture.OnFrameAvailableListener {
    private static final int MSG_CAPTURE = 0;
    protected Context mContext;
    VideoLiveFilterContext mFilterContext;
    private HandlerThread mHandlerThread;
    private Handler mWorkerHandler;
    public int mCaptureTextureId = -1;
    public SurfaceTexture mCaptureSurfaceTexture = null;
    public long mTextureCreatedThreadId = -1;
    AtomicBoolean mInited = new AtomicBoolean(false);
    private long mLastTimeStamp = 0;
    private int mCount = 0;
    private long mLastAndoridPtsNanos = 0;
    private long mLastYYPtsMillions = 0;
    private int mTimerInterval = 33;
    private long feedFrameCounter = 0;
    private long feedCurrentTime = 0;
    private long lastPrintTime = 0;
    private List<Long> mCaptureRateList = new ArrayList();
    private long maxDealTime = 0;
    private long averageDealTime = 0;
    private List<Long> mCaptureAverageDealTimeList = new ArrayList();
    private List<Long> mCaptureMaxDealTimeList = new ArrayList();
    private RectF mScreenCropArea = null;
    private AtomicBoolean mStopFlag = new AtomicBoolean(true);
    private AtomicBoolean mNewFrameArrived = new AtomicBoolean(false);

    public AbstractSurfaceTextureCaptureFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = null;
        YMFLog.info(this, "[SCapture]", "new AbstractSurfaceTextureCaptureFilter...");
        this.mFilterContext = videoLiveFilterContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(15)
    public void doInit() {
        YMFLog.info(this, "[SCapture]", "AbstractSurfaceTextureCaptureFilter doInit begin");
        synchronized (this.mInited) {
            if (!this.mInited.get()) {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                this.mCaptureTextureId = iArr[0];
                GLES20.glBindTexture(36197, this.mCaptureTextureId);
                GLES20.glTexParameterf(36197, 10241, 9729.0f);
                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
                this.mCaptureSurfaceTexture = new SurfaceTexture(this.mCaptureTextureId);
                this.mFilterContext.mVirtualDisplayWidth = this.mFilterContext.getScreenRecordConfig().getWidth();
                this.mFilterContext.mVirtualDisplayHeight = this.mFilterContext.getScreenRecordConfig().getHeight();
                this.mCaptureSurfaceTexture.setDefaultBufferSize(this.mFilterContext.mVirtualDisplayWidth, this.mFilterContext.mVirtualDisplayHeight);
                this.mCaptureSurfaceTexture.setOnFrameAvailableListener(this);
                this.mTextureCreatedThreadId = Thread.currentThread().getId();
                YMFLog.info(this, "[SCapture]", "screenRecord fps:" + this.mFilterContext.getVideoEncoderConfig().mFrameRate);
                this.mTimerInterval = 1000 / this.mFilterContext.getVideoEncoderConfig().mFrameRate;
                this.mHandlerThread = new HandlerThread("YY_yyvideolib_Screen_Thread");
                this.mHandlerThread.start();
                this.mWorkerHandler = new WorkerHandler(this, this.mHandlerThread.getLooper());
                this.mInited.set(true);
                this.mInited.notifyAll();
                YMFLog.info(this, "[SCapture]", "AbstractSurfaceTextureCaptureFilter doInit done, surface texture width:" + this.mFilterContext.mVirtualDisplayWidth + " height:" + this.mFilterContext.mVirtualDisplayHeight);
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class WorkerHandler extends Handler {
        private WeakReference<AbstractSurfaceTextureCaptureFilter> mWeakFilter;

        public WorkerHandler(AbstractSurfaceTextureCaptureFilter abstractSurfaceTextureCaptureFilter, Looper looper) {
            super(looper);
            this.mWeakFilter = new WeakReference<>(abstractSurfaceTextureCaptureFilter);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            AbstractSurfaceTextureCaptureFilter abstractSurfaceTextureCaptureFilter = this.mWeakFilter.get();
            if (abstractSurfaceTextureCaptureFilter != null) {
                switch (i) {
                    case 0:
                        abstractSurfaceTextureCaptureFilter.handlerScreenCaptureLoop();
                        return;
                    default:
                        return;
                }
            }
            YMFLog.warn(IMediaFilter.TAG, "[SCapture]", "captureFilter is null");
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[SCapture]", "AbstractSurfaceTextureCaptureFilter deInit begin");
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doDeInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractSurfaceTextureCaptureFilter.this.doDeInit();
                }
            });
        }
        if (this.mWorkerHandler != null) {
            this.mWorkerHandler.removeCallbacksAndMessages(null);
            this.mWorkerHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.getLooper().quit();
            this.mHandlerThread = null;
        }
        YMFLog.info(this, "[SCapture]", "AbstractSurfaceTextureCaptureFilter deInit done");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(16)
    public void doDeInit() {
        if (!this.mInited.getAndSet(false)) {
            YMFLog.info(this, "[SCapture]", "doDeInit: no Initalized state, so return");
            return;
        }
        YMFLog.info(this, "[SCapture]", "doDeInit begin");
        if (this.mCaptureTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mCaptureTextureId}, 0);
            this.mCaptureTextureId = -1;
        }
        if (this.mCaptureSurfaceTexture != null) {
            this.mCaptureSurfaceTexture.detachFromGLContext();
            this.mCaptureSurfaceTexture.release();
            this.mCaptureSurfaceTexture = null;
        }
        stopCapture();
        YMFLog.info(this, "[SCapture]", "doDeInit done");
    }

    public void updateScreenSize() {
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter updateScreenSize begin");
        this.mCaptureSurfaceTexture.setOnFrameAvailableListener(null);
        this.mNewFrameArrived.set(false);
        if (this.mCaptureTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mCaptureTextureId}, 0);
            this.mCaptureTextureId = -1;
        }
        if (this.mCaptureSurfaceTexture != null) {
            this.mCaptureSurfaceTexture.detachFromGLContext();
            this.mCaptureSurfaceTexture.release();
            this.mCaptureSurfaceTexture = null;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mCaptureTextureId = iArr[0];
        GLES20.glBindTexture(36197, this.mCaptureTextureId);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        this.mCaptureSurfaceTexture = new SurfaceTexture(this.mCaptureTextureId);
        this.mFilterContext.mVirtualDisplayWidth = this.mFilterContext.getScreenRecordConfig().getWidth();
        this.mFilterContext.mVirtualDisplayHeight = this.mFilterContext.getScreenRecordConfig().getHeight();
        this.mCaptureSurfaceTexture.setDefaultBufferSize(this.mFilterContext.mVirtualDisplayWidth, this.mFilterContext.mVirtualDisplayHeight);
        this.mCaptureSurfaceTexture.setOnFrameAvailableListener(this);
        this.mNewFrameArrived.set(false);
        YMFLog.info(this, "[SCapture]", "updateScreenSize surface texture width:" + this.mFilterContext.mVirtualDisplayWidth + " height:" + this.mFilterContext.mVirtualDisplayHeight);
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mCaptureSurfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(SurfaceTexture surfaceTexture) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mInited.get() || !surfaceTexture.equals(this.mCaptureSurfaceTexture)) {
            YMFLog.error(this, "[SCapture]", "handleFrameAvailble, not same surfaceTexture or not initialized");
        } else if (this.mNewFrameArrived.get()) {
            long tickCountLong = TimeUtil.getTickCountLong();
            long j = tickCountLong - this.mLastTimeStamp;
            this.mLastTimeStamp = tickCountLong;
            surfaceTexture.updateTexImage();
            YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
            if (this.mLastTimeStamp == 0) {
                alloc.mAndoridPtsNanos = surfaceTexture.getTimestamp();
                alloc.mYYPtsMillions = TimeUtil.getTickCountLong();
            } else {
                alloc.mAndoridPtsNanos = this.mLastAndoridPtsNanos + (TimeUtils.NANOS_PER_MS * j);
                alloc.mYYPtsMillions = j + this.mLastYYPtsMillions;
            }
            alloc.mWidth = this.mFilterContext.mVirtualDisplayWidth;
            alloc.mHeight = this.mFilterContext.mVirtualDisplayHeight;
            this.mLastAndoridPtsNanos = alloc.mAndoridPtsNanos;
            this.mLastYYPtsMillions = alloc.mYYPtsMillions;
            if (this.mFilterContext.mVirtualDisplayWidth != this.mFilterContext.getScreenRecordConfig().getWidth() || this.mFilterContext.mVirtualDisplayHeight != this.mFilterContext.getScreenRecordConfig().getHeight()) {
                updateScreenSize();
                return;
            }
            alloc.mResMode = this.mFilterContext.getCameraPreviewConfig().getResMode();
            alloc.mImageFormat = 17;
            alloc.mCameraFacing = 0;
            alloc.mOrientation = 0;
            surfaceTexture.getTransformMatrix(alloc.mMainTransformer);
            alloc.mMasterTextureId = this.mCaptureTextureId;
            alloc.mTextureTarget = 36197;
            alloc.mTextureCreatedThreadId = this.mTextureCreatedThreadId;
            alloc.mEncodeWidth = this.mFilterContext.getVideoEncoderConfig().getEncodeWidth();
            alloc.mEncodeHeight = this.mFilterContext.getVideoEncoderConfig().getEncodeHeight();
            alloc.mEncoderType = this.mFilterContext.getVideoEncoderConfig().mEncodeType;
            alloc.mScreenCropArea = this.mScreenCropArea;
            if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
                YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
            }
            deliverToDownStream(alloc);
            alloc.decRef();
            printScreenRecordFrameRate(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mNewFrameArrived.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerScreenCaptureLoop() {
        if (!this.mStopFlag.get()) {
            this.mWorkerHandler.removeMessages(0);
            this.mWorkerHandler.sendEmptyMessageDelayed(0, 1000 / this.mFilterContext.getVideoEncoderConfig().mFrameRate);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter.2
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractSurfaceTextureCaptureFilter.this.mCaptureSurfaceTexture != null) {
                    AbstractSurfaceTextureCaptureFilter.this.handleFrameAvailable(AbstractSurfaceTextureCaptureFilter.this.mCaptureSurfaceTexture);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            YMFLog.info(this, "[SCapture]", "handlerScreenCaptureLoop:" + e.toString());
        }
    }

    public void startCapture() {
        YMFLog.info(this, "[SCapture]", "startCapture...");
        if (this.mStopFlag.get()) {
            this.mStopFlag.set(false);
            if (!this.mStopFlag.get() && this.mWorkerHandler != null) {
                this.mWorkerHandler.sendEmptyMessageDelayed(0, 1000 / this.mFilterContext.getVideoEncoderConfig().mFrameRate);
            }
        }
    }

    public void stopCapture() {
        YMFLog.info(this, "[SCapture]", "stopCapture...");
        this.mStopFlag.set(true);
        if (this.mWorkerHandler != null) {
            this.mWorkerHandler.removeCallbacksAndMessages(null);
        }
    }

    private void printScreenRecordFrameRate(long j) {
        try {
            this.feedFrameCounter++;
            this.feedCurrentTime = System.currentTimeMillis();
            this.maxDealTime = this.maxDealTime < j ? j : this.maxDealTime;
            this.averageDealTime += j;
            if (this.feedCurrentTime - this.lastPrintTime >= 1000) {
                this.mCaptureRateList.add(Long.valueOf(this.feedFrameCounter));
                this.mCaptureAverageDealTimeList.add(Long.valueOf(this.averageDealTime / this.feedFrameCounter));
                this.mCaptureMaxDealTimeList.add(Long.valueOf(this.maxDealTime));
                if (this.mCaptureRateList.size() >= 5) {
                    printFrameRate("ScreenCapture", this.mCaptureRateList, this.mCaptureAverageDealTimeList, this.mCaptureMaxDealTimeList);
                    this.mCaptureRateList.clear();
                    this.mCaptureMaxDealTimeList.clear();
                    this.mCaptureAverageDealTimeList.clear();
                }
                this.feedFrameCounter = 0L;
                this.lastPrintTime = this.feedCurrentTime;
                this.maxDealTime = 0L;
                this.averageDealTime = 0L;
            }
        } catch (Exception e) {
            YMFLog.error(this, "[SCapture]", "printScreenRecordFrameRate exception:" + e.toString());
        }
    }

    private void printFrameRate(String str, List<Long> list, List<Long> list2, List<Long> list3) {
        if (list != null) {
            String str2 = " ";
            for (int i = 0; i < list.size(); i++) {
                str2 = str2 + list.get(i) + ":" + list2.get(i) + ":" + list3.get(i) + ", ";
            }
            YMFLog.info(this, "[SCapture]", "handleFrameAvailable feed data frame rate:[" + str2 + "] tyoe:[" + str + "] gpu:" + this.mFilterContext.mHasBeautyProcess);
        }
    }

    public void setScreenCropArea(RectF rectF) {
        YMFLog.info(this, "[SCapture]", "setScreenCropArea, rectF:" + rectF);
        this.mScreenCropArea = rectF;
    }
}
