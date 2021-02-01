package com.yy.videoplayer.decoder;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.View;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.decoder.HardDecRender;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
import com.yy.videoplayer.decoder.VideoSizeUtils;
import com.yy.videoplayer.decoder.gles_decoder.EglCore;
import com.yy.videoplayer.decoder.gles_decoder.FullFrameRect;
import com.yy.videoplayer.decoder.gles_decoder.GlUtil;
import com.yy.videoplayer.decoder.gles_decoder.Texture2dProgram;
import com.yy.videoplayer.decoder.gles_decoder.WindowSurface;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.VideoEntities;
import com.yy.videoplayer.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class HardDecodeWayGpu implements SurfaceTexture.OnFrameAvailableListener, HardDecRender.IDecoderDataOutCallBack, HardDecodeWay, Runnable {
    private static final int MSG_END_OF_STREAM = 7;
    private static final int MSG_GET_SCREENSHOT = 4;
    private static final int MSG_QUIT = 8;
    private static final int MSG_SETVIDEINFOCALLBACK = 11;
    private static final int MSG_VIDEO_CONFIG = 5;
    private static final int MSG_VIDEO_DATA = 6;
    private static final int MSG_VIDEO_SURFACE_CHANGED = 1;
    private static final int MSG_VIDEO_SURFACE_CREATED = 10;
    private static final int MSG_VIDEO_SURFACE_DESTROYED = 2;
    private static final int MSG_VIDEO_SURFACE_REDRAW = 3;
    private static final int MSG_VSYNC_ARRIVED = 9;
    private static final String TAG = "HardDecodeWayGpu";
    private static final int VIDEO_DATA_LOG = 500;
    static final int kNofifySizeGap = 15;
    static final long kNotifyTimeGap = 500;
    private Surface mDecoderSurface;
    private SurfaceTexture mDecoderSurfaceTexture;
    private EglCore mEglCore;
    private EGLSurface mEnvSurface;
    private int mFrameHeight;
    private int mFrameWidth;
    private RenderHandler mHandler;
    private Surface mNewDecoderSurface;
    private SurfaceTexture mNewDecoderSurfaceTexture;
    private PlayNotify mPlayNotify;
    private float[] mSrcTransform;
    private SurfaceScaleInfo mSurfaceScaleInfo;
    private long mTempPts;
    private Thread mThread;
    private float[] mTmpTransform;
    private float[] mTransform;
    private FullFrameRect mVideoScreen;
    private Surface mVideoSurface;
    private WindowSurface mVideoWindowSurface;
    private long mVideoDataCnt = 0;
    private boolean mRecIFrame = false;
    private HardDecRender mOuterDecoder = null;
    private AtomicLong mOuterOutPts = new AtomicLong(0);
    private int mDecoderTextureId = -1;
    private VideoEntities.VideoSizes mVideoSizes = new VideoEntities.VideoSizes();
    private boolean mIsDecoderNeedReconfig = false;
    private AtomicBoolean mReady = new AtomicBoolean(false);
    private AtomicBoolean mSurfaceDestoryedState = new AtomicBoolean(false);
    private final Object mStartLock = new Object();
    private final Object mQuitLock = new Object();
    private final Object mScreenShotLock = new Object();
    private final Object mSurfaceDestroyLock = new Object();
    private int mFrames = -1;
    private boolean mFirstFrameOut = false;
    private boolean mFirstFrameRendered = false;
    private boolean mFirstFrameDecodered = false;
    private long mFirstFrameTs = 0;
    private long mUserGroupId = 0;
    private long mStreamId = 0;
    private long mVsyncTime = 0;
    private long mDiff = 0;
    private long mFramePtsDiff = 0;
    private long mVsyncTimeDiff = 0;
    private long mBasicVsync = 0;
    private long mPreVsync = 0;
    private long mPreFramePts = 0;
    private long mSum = 0;
    private int mFrameCnt = 0;
    private int mRenderCnt = 0;
    private long mCurTime = 0;
    private long mLastTime = 0;
    private int mDecodeCnt = 0;
    private long mCurTime1 = 0;
    private long mLastTime1 = 0;
    private boolean mFirstFrameSeeFlag = false;
    private SmoothnessCounter mSmoothnessCounter = new SmoothnessCounter(5000);
    private ArrayList<VideoRenderNotify> mVideoRenderNotifys = new ArrayList<>();
    private IVideoInfoCallback mVideoInfoCallback = null;
    private Hashtable<Long, Long> mDecoderTimeStampMap = new Hashtable<>();
    private boolean mIsVrStream = false;
    private ReentrantLock mSurfaceDestoryedLock = new ReentrantLock(true);
    private long mLastDecodedTimeStampTime = 0;
    private boolean mIgnoreStatistic = false;
    private int mViewState = 1;
    long vsyncT = 0;
    long vsyncCnt = 0;
    private HardDecRender mNewOutDecoder = null;
    private int mNewWidth = 0;
    private int mNewHeight = 0;
    private HandlerThread mAsyncHandlerThread = null;
    private Handler mAsyncHandler = null;
    private AtomicBoolean mUsedNewOutDecoder = new AtomicBoolean(false);
    private Queue<VideoEntities.VideoData> mDecodingQueue = new ConcurrentLinkedQueue();
    private int mNewDecoderTextureId = -1;
    private boolean mNewDecodedOutFirstFrame = false;

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public VideoDecoderCenterExt.HardDecoderStaffVersion getHardDecodeType() {
        return VideoDecoderCenterExt.HardDecoderStaffVersion.GPURENDER;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long getUserGroupId() {
        return this.mUserGroupId;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "setVideoInfoCallback");
            this.mHandler.sendMessage(this.mHandler.obtainMessage(11, iVideoInfoCallback));
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Start() {
        YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu Start...");
        this.mAsyncHandlerThread = new HandlerThread("YY_yylivesdk_HardDecodeWayGpu_AsyncThread");
        this.mAsyncHandlerThread.start();
        this.mAsyncHandler = new Handler(this.mAsyncHandlerThread.getLooper());
        this.mThread = new Thread(this);
        this.mThread.setName("YY_yylivesdk_HardDecodeWayGpu_Thread");
        synchronized (this.mStartLock) {
            this.mThread.start();
            this.mStartLock.wait(kNotifyTimeGap);
        }
        YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu Start done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class VideoHeaderInfo {
        public byte[] header;
        public int height;
        public String mime;
        public int width;

        private VideoHeaderInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ScreenShotInfo {
        public int height;
        public boolean isSuccess;
        public Buffer pixelBuffer;
        public int width;

        private ScreenShotInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SurfaceScaleInfo {
        public int height;
        public VideoConstant.OrientationType orientationType;
        public int parentHeight;
        public int parentWidth;
        public int rotateAngle;
        public VideoConstant.ScaleMode scaleMode;
        public Surface surface;
        public View videoView;
        public int width;

        private SurfaceScaleInfo() {
            this.width = 64;
            this.height = 64;
            this.parentWidth = 64;
            this.parentHeight = 64;
            this.rotateAngle = 0;
            this.orientationType = VideoConstant.OrientationType.Normal;
            this.scaleMode = VideoConstant.ScaleMode.AspectFit;
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public boolean IsDecoderNeedReconfig() {
        return this.mIsDecoderNeedReconfig;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void SetPlayNotify(PlayNotify playNotify) {
        this.mPlayNotify = playNotify;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void SetVideoIds(long j, long j2) {
        YMFLog.info(this, "[Decoder ]", "SetVideoIds userGroupId:" + j + ", streamId:" + j2);
        this.mUserGroupId = j;
        this.mStreamId = j2;
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceCreated() {
        notifyViewStateChange(0);
        if (this.mReady.get()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
        }
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceRedraw() {
        if (this.mReady.get()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        }
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceChanged(View view, Surface surface, int i, int i2, int i3, int i4, int i5, VideoConstant.OrientationType orientationType, VideoConstant.ScaleMode scaleMode) {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "OnSurfaceChanged width:" + i + " height:" + i2 + " parentWidth:" + i3 + " parentHeight:" + i4);
            SurfaceScaleInfo surfaceScaleInfo = new SurfaceScaleInfo();
            surfaceScaleInfo.videoView = view;
            surfaceScaleInfo.surface = surface;
            surfaceScaleInfo.width = i;
            surfaceScaleInfo.height = i2;
            surfaceScaleInfo.parentWidth = i3;
            surfaceScaleInfo.parentHeight = i4;
            surfaceScaleInfo.rotateAngle = i5;
            surfaceScaleInfo.orientationType = orientationType;
            surfaceScaleInfo.scaleMode = scaleMode;
            notifyViewStateChange(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, surfaceScaleInfo));
        }
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceDestroyed(Surface surface) {
        if (this.mReady.get()) {
            this.mHandler.removeMessages(9);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, surface));
            tryLockSurfaceDestoryLock();
            this.mSurfaceDestoryedState.set(true);
            tryUnlockSurfaceDestroyLock();
            YMFLog.info(this, "[Decoder ]", "OnSurfaceDestroyed mSurfaceDestoryedState true");
        } else {
            YMFLog.error(this, "[Decoder ]", "OnSurfaceDestroyed mReady == false!");
        }
        YMFPlayerStatisticManager.getInstance().reset();
        StateMonitor.NotifyClearPts(this.mStreamId);
        notifyViewStateChange(1);
    }

    private void notifyViewStateChange(int i) {
        if (this.mViewState != i) {
            this.mViewState = i;
            if (this.mViewState == 0) {
                this.mIgnoreStatistic = true;
            }
            YYVideoLibMgr.instance().onViewStateNotify(this.mStreamId, this.mViewState);
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void OnStreamEnd() {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "OnStreamEnd");
            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public Bitmap GetScreenShot() {
        Bitmap bitmap = null;
        ScreenShotInfo screenShotInfo = new ScreenShotInfo();
        screenShotInfo.isSuccess = false;
        if (this.mReady.get()) {
            synchronized (this.mScreenShotLock) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(4, screenShotInfo));
                this.mScreenShotLock.wait(kNotifyTimeGap);
            }
        }
        if (screenShotInfo.isSuccess) {
            bitmap = Bitmap.createBitmap(screenShotInfo.width, screenShotInfo.height, Bitmap.Config.ARGB_8888);
            if (bitmap != null) {
                bitmap.copyPixelsFromBuffer(screenShotInfo.pixelBuffer);
            } else {
                YMFLog.error(this, "[Decoder ]", "Bitmap.createBitmap failed!");
            }
        }
        YMFLog.info(this, "[Decoder ]", "GetScreenShot isSuccess:" + screenShotInfo.isSuccess + " width:" + screenShotInfo.width + " height:" + screenShotInfo.height);
        return bitmap;
    }

    private String bin2hex(byte[] bArr) {
        String str = null;
        int length = bArr == null ? 0 : bArr.length;
        for (int i = 0; i < length; i++) {
            str = str != null ? str + String.format("%02x ", Byte.valueOf(bArr[i])) : String.format("%02x ", Byte.valueOf(bArr[i]));
        }
        return str;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void onCreateRenderAhead(int i, int i2, String str) {
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void OnVideoConfig(final byte[] bArr, final int i, final int i2, final String str) {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "OnVideoConfig width:" + i + " height:" + i2 + " mime:" + str + " streamId:" + this.mStreamId + " data:" + bin2hex(bArr));
            if (this.mOuterDecoder == null) {
                if ("video/hevc".equals(str)) {
                    this.mOuterDecoder = new H265DecRender(this.mDecoderSurface, i, i2, this.mUserGroupId, this.mStreamId);
                    StateMonitor.NotifyCreateRender(this.mStreamId, 1);
                } else if ("video/avc".equals(str)) {
                    this.mOuterDecoder = new H264DecRender(this.mDecoderSurface, i, i2, this.mUserGroupId, this.mStreamId);
                    StateMonitor.NotifyCreateRender(this.mStreamId, 0);
                } else if ("video/x-vnd.on2.vp8".equals(str)) {
                    this.mOuterDecoder = new VP8DecRender(this.mDecoderSurface, i, i2);
                }
                this.mOuterDecoder.setStreamId(this.mStreamId);
            } else if (((i < i2 && this.mFrameWidth < this.mFrameHeight) || (i >= i2 && this.mFrameWidth >= this.mFrameHeight)) && this.mFirstFrameOut) {
                if (this.mAsyncHandler != null) {
                    if (this.mDecodingQueue.size() != 0) {
                        YMFLog.warn(this, "[Decoder ]", "createDecoderAsync clean mDecodingQueue");
                        this.mDecodingQueue.clear();
                    }
                    this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HardDecodeWayGpu.this.createDecoderAsync(bArr, i, i2, str);
                        }
                    });
                    this.mNewDecodedOutFirstFrame = false;
                    this.mUsedNewOutDecoder.set(true);
                    return;
                }
            } else {
                if (this.mAsyncHandler != null) {
                    if (this.mDecodingQueue.size() != 0) {
                        YMFLog.warn(this, "[Decoder ]", "createDecoderAsync clean mDecodingQueue");
                        this.mDecodingQueue.clear();
                    }
                    this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.2
                        @Override // java.lang.Runnable
                        public void run() {
                            HardDecodeWayGpu.this.destoryAsyncEnv();
                        }
                    });
                }
                this.mUsedNewOutDecoder.set(false);
                this.mOuterDecoder.reset(this.mDecoderSurface, i, i2);
            }
            this.mRecIFrame = false;
            this.mVideoDataCnt = 0L;
            this.mOuterOutPts.set(0L);
            this.mFrames = 0;
            this.mIsDecoderNeedReconfig = false;
            this.mFirstFrameOut = false;
            this.mVideoRenderNotifys.clear();
            this.mOuterDecoder.PushFrame(this.mDecoderSurface, bArr, null, 0L, true);
            this.mOuterDecoder.ConfigDone();
            if (this.mOuterDecoder.GetAndClearExceptionFlag()) {
                this.mIsDecoderNeedReconfig = true;
                this.mOuterDecoder.EndofStream();
            }
            VideoHeaderInfo videoHeaderInfo = new VideoHeaderInfo();
            videoHeaderInfo.header = bArr;
            videoHeaderInfo.width = i;
            videoHeaderInfo.height = i2;
            videoHeaderInfo.mime = str;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, videoHeaderInfo));
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long OnVideoDataArrived(byte[] bArr, long j, VideoConstant.ExtraData extraData) {
        if (this.mReady.get()) {
            long j2 = this.mVideoDataCnt;
            this.mVideoDataCnt = 1 + j2;
            if (j2 % kNotifyTimeGap == 0 || ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50)) {
                YMFLog.info(this, "[Decoder ]", "OnVideoDataArrived streamId:" + this.mStreamId + ", pts:" + j);
            }
            if (this.mUsedNewOutDecoder.get() && !this.mNewDecodedOutFirstFrame) {
                VideoEntities.VideoData videoData = new VideoEntities.VideoData();
                videoData.data = bArr;
                videoData.pts = j;
                this.mDecodingQueue.add(videoData);
                if (this.mAsyncHandler != null) {
                    this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.3
                        @Override // java.lang.Runnable
                        public void run() {
                            HardDecodeWayGpu.this.decodeFrameAsync();
                        }
                    });
                    handleGetCacheFrame();
                }
            } else if (this.mUsedNewOutDecoder.get() && this.mNewDecodedOutFirstFrame) {
                changeToNewDecoder();
            }
            if (!this.mUsedNewOutDecoder.get()) {
                handleOuterVideoData(bArr, j);
                return -1L;
            }
            return -1L;
        }
        YMFLog.warn(this, "[Decoder ]", "mReady false, OnVideoDataArrived streamId:" + this.mStreamId + ", pts:" + j);
        return -1L;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Quit() {
        if (this.mReady.get()) {
            synchronized (this.mQuitLock) {
                if (this.mOuterDecoder != null) {
                    StateMonitor.NotifyReleaseRender(this.mStreamId);
                    this.mOuterDecoder.release();
                    this.mOuterDecoder.EndofStream();
                    this.mOuterDecoder = null;
                }
                if (this.mAsyncHandler != null) {
                    this.mAsyncHandler.removeCallbacksAndMessages(null);
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (HardDecodeWayGpu.this.mUsedNewOutDecoder.get() && HardDecodeWayGpu.this.mNewOutDecoder != null) {
                                HardDecodeWayGpu.this.mNewOutDecoder.release();
                                HardDecodeWayGpu.this.mNewOutDecoder.EndofStream();
                                HardDecodeWayGpu.this.mNewOutDecoder = null;
                            }
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (Exception e) {
                        YMFLog.error(this, "[Decoder ]", "HardDecodeWayGpu Quit syncFlag.await():" + e.toString());
                    }
                    this.mAsyncHandlerThread.quit();
                    this.mAsyncHandlerThread = null;
                    this.mAsyncHandler = null;
                }
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                this.mQuitLock.wait(kNotifyTimeGap);
                YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu Quit");
            }
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVrStream(boolean z) {
        YMFLog.info(this, "[Decoder ]", "vrStream:" + z);
        this.mIsVrStream = z;
    }

    private void handleOuterVideoData(byte[] bArr, long j) {
        int i;
        if (this.mIsDecoderNeedReconfig) {
            YMFLog.warn(this, "[Decoder ]", "handleOuterVideoData mIsDecoderNeedReconfig true streamId:" + this.mStreamId + ", pts:" + j);
            return;
        }
        this.mFrames++;
        if (this.mOuterDecoder != null) {
            if ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50) {
                if (this.mOuterDecoder instanceof VP8DecRender) {
                    i = 0;
                } else if (bArr == null) {
                    i = 255;
                } else if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 1) {
                    i = bArr[3] & 31;
                } else if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1) {
                    i = bArr[4] & 31;
                } else {
                    i = -1;
                }
                if (i == 5) {
                    this.mRecIFrame = true;
                }
                YMFLog.info(this, "[Decoder ]", "handleOuterVideoData streamId:" + this.mStreamId + ", frames:" + this.mFrames + ", type:" + i + ", len:" + (bArr == null ? 0 : bArr.length) + ", pts:" + j);
            }
            this.mOuterOutPts.set(this.mOuterDecoder.PushFrame(this.mDecoderSurface, bArr, null, j, false));
            if (this.mOuterOutPts.get() <= 0) {
                if (this.mOuterDecoder.GetAndClearExceptionFlag()) {
                    YMFLog.warn(this, "[Decoder ]", "handleOuterVideoData decoder exception! Need to recconfig!");
                    this.mIsDecoderNeedReconfig = true;
                    this.mOuterDecoder.EndofStream();
                    return;
                }
                return;
            }
            if (this.mDecoderTimeStampMap.size() <= 100) {
                this.mDecoderTimeStampMap.put(Long.valueOf(this.mOuterOutPts.get()), Long.valueOf(TimeUtil.getTickCountLong()));
            } else {
                YMFLog.info(this, "[Decoder ]", "handleOuterVideoData mDecoderTimeStampMap full ");
                this.mDecoderTimeStampMap.clear();
            }
            if (!this.mFirstFrameOut) {
                StateMonitor.instance().NotifyDecodeDelayFrameCountInfo(this.mStreamId, this.mFrames);
                YMFLog.info(this, "[Decoder ]", "handleOuterVideoData first frame out, frames:" + this.mFrames);
            }
            this.mFirstFrameOut = true;
            this.mLastDecodedTimeStampTime = TimeUtil.getTickCountLong();
            this.mDecodeCnt++;
            this.mCurTime1 = TimeUtil.getTickCountLong();
            if (this.mLastTime1 == 0) {
                this.mLastTime1 = this.mCurTime1;
            }
            if (this.mCurTime1 - this.mLastTime1 >= 1000) {
                StateMonitor.NotifyDecoderFrameRateOUT(this.mStreamId, this.mDecodeCnt);
                this.mLastTime1 = this.mCurTime1;
                this.mDecodeCnt = 0;
                return;
            }
            return;
        }
        YMFLog.error(this, "[Decoder ]", "handleOuterVideoData mOuterDecoder:" + this.mOuterDecoder);
    }

    private void InitEGL() {
        this.mEglCore = new EglCore(null, 0);
        this.mEnvSurface = this.mEglCore.createOffscreenSurface(VideoConstant.THUMBNAIL_WIDTH, 240);
        this.mEglCore.makeCurrent(this.mEnvSurface);
        this.mVideoScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
        this.mDecoderTextureId = genExtTexture();
        this.mDecoderSurfaceTexture = new SurfaceTexture(this.mDecoderTextureId);
        this.mDecoderSurfaceTexture.setOnFrameAvailableListener(this);
        this.mDecoderSurface = new Surface(this.mDecoderSurfaceTexture);
        this.mSrcTransform = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        Matrix.rotateM(this.mSrcTransform, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        Matrix.translateM(this.mSrcTransform, 0, 0.0f, -1.0f, 0.0f);
        this.mTransform = new float[16];
        this.mTmpTransform = new float[16];
        System.arraycopy(this.mSrcTransform, 0, this.mTransform, 0, 16);
        this.mVideoRenderNotifys.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int genExtTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("genExtTexture OES");
        return iArr[0];
    }

    private int genTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        return iArr[0];
    }

    private void DeInitEGL() {
        tryLockSurfaceDestoryLock();
        if (this.mUsedNewOutDecoder.get()) {
            if (this.mNewDecoderSurface != null) {
                this.mNewDecoderSurface.release();
                this.mNewDecoderSurface = null;
            }
            if (this.mNewDecoderSurfaceTexture != null) {
                this.mNewDecoderSurfaceTexture.release();
                this.mNewDecoderSurfaceTexture = null;
            }
            if (this.mNewDecoderTextureId > 0) {
                GLES20.glDeleteTextures(1, new int[]{this.mNewDecoderTextureId}, 0);
                this.mNewDecoderTextureId = -1;
            }
        }
        if (this.mSurfaceScaleInfo != null) {
            this.mSurfaceScaleInfo.videoView = null;
            this.mSurfaceScaleInfo.surface = null;
            this.mSurfaceScaleInfo = null;
        }
        releaseDecoderStaffs();
        if (this.mVideoScreen != null) {
            this.mVideoScreen.release(true);
            this.mVideoScreen = null;
        }
        if (this.mVideoWindowSurface != null) {
            this.mVideoWindowSurface.release();
            this.mVideoWindowSurface = null;
        }
        if (this.mEnvSurface != null) {
            this.mEglCore.makeNothingCurrent();
            this.mEglCore.releaseSurface(this.mEnvSurface);
            this.mEnvSurface = null;
        }
        tryUnlockSurfaceDestroyLock();
        if (this.mEglCore != null) {
            this.mEglCore.release();
            this.mEglCore = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [696=5] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        try {
            Looper.prepare();
            this.mHandler = new RenderHandler(this);
            this.mIsDecoderNeedReconfig = true;
            this.mReady.set(true);
            InitEGL();
            YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu construct done GLThread");
            synchronized (this.mStartLock) {
                this.mStartLock.notifyAll();
            }
            Looper.loop();
            this.mReady.set(false);
            YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu end GLThread");
            try {
                DeInitEGL();
            } catch (Throwable th) {
                YMFLog.error(this, "[Decoder ]", "HardDecodeWayGpu DeInitEGL exception:" + th.getMessage());
            }
            synchronized (this.mQuitLock) {
                this.mQuitLock.notifyAll();
            }
        } catch (Throwable th2) {
            try {
                YMFLog.error(this, "[Decoder ]", "HardDecodeWayGpu end looper exception:" + th2.getMessage() + " " + th2.toString());
                YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu end GLThread");
                try {
                    DeInitEGL();
                } catch (Throwable th3) {
                    YMFLog.error(this, "[Decoder ]", "HardDecodeWayGpu DeInitEGL exception:" + th3.getMessage());
                }
                synchronized (this.mQuitLock) {
                    this.mQuitLock.notifyAll();
                }
            } catch (Throwable th4) {
                YMFLog.info(this, "[Decoder ]", "HardDecodeWayGpu end GLThread");
                try {
                    DeInitEGL();
                } catch (Throwable th5) {
                    YMFLog.error(this, "[Decoder ]", "HardDecodeWayGpu DeInitEGL exception:" + th5.getMessage());
                }
                synchronized (this.mQuitLock) {
                    this.mQuitLock.notifyAll();
                    throw th4;
                }
            }
        }
    }

    public void renderFrame() {
        this.vsyncCnt++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.vsyncT > 6000) {
            this.vsyncT = currentTimeMillis;
            YMFLog.info(this, "[Decoder ]", "vsync count in 6 seconds " + this.vsyncCnt);
            this.vsyncCnt = 0L;
        }
        updateSurfaceTexture();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        long currentTimeMillis = System.currentTimeMillis();
        surfaceTexture.updateTexImage();
        if (this.mFirstFrameOut) {
            if (this.mVideoSizes.mVideoWidth != this.mFrameWidth || this.mVideoSizes.mVideoHeight != this.mFrameHeight) {
                this.mVideoSizes.mVideoWidth = this.mFrameWidth;
                this.mVideoSizes.mVideoHeight = this.mFrameHeight;
                updateDisplayRegion();
            }
            renderFrame();
        }
        if (this.mVideoWindowSurface != null) {
            notifyVideoRender(surfaceTexture.getTimestamp() / TimeUtils.NANOS_PER_MS);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetScreenShot(ScreenShotInfo screenShotInfo) {
        try {
            screenShotInfo.isSuccess = false;
            screenShotInfo.width = this.mVideoSizes.mVideoWidth;
            screenShotInfo.height = this.mVideoSizes.mVideoHeight;
            screenShotInfo.pixelBuffer = ByteBuffer.allocateDirect(screenShotInfo.width * screenShotInfo.height * 4);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            int genTexture = genTexture(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight);
            GLES20.glViewport(0, 0, this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, genTexture, 0);
            float[] fArr = new float[16];
            Matrix.rotateM(fArr, 0, this.mSrcTransform, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            if (!this.mIsVrStream) {
                this.mVideoScreen.drawFrame(this.mDecoderTextureId, fArr, -1);
            }
            GLES20.glReadPixels(0, 0, this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, 6408, 5121, screenShotInfo.pixelBuffer);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            GLES20.glDeleteTextures(1, new int[]{genTexture}, 0);
            screenShotInfo.isSuccess = true;
        } catch (Throwable th) {
            YMFLog.error(this, "[Decoder ]", "handleGetScreenShot exception:" + th.getMessage());
        }
        synchronized (this.mScreenShotLock) {
            this.mScreenShotLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryLockSurfaceDestoryLock() {
        if (this.mSurfaceDestoryedLock.getHoldCount() == 0) {
            this.mSurfaceDestoryedLock.lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUnlockSurfaceDestroyLock() {
        while (this.mSurfaceDestoryedLock.getHoldCount() != 0) {
            try {
                this.mSurfaceDestoryedLock.unlock();
            } catch (IllegalMonitorStateException e) {
                YMFLog.warn(this, "[Decoder ]", "tryUnlockSurfaceDestroyLock exception:" + e.toString());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00bd -> B:23:0x008e). Please submit an issue!!! */
    public void handleVideoSurfaceChanged(SurfaceScaleInfo surfaceScaleInfo) {
        tryLockSurfaceDestoryLock();
        YMFLog.info(this, "[Decoder ]", "handleVideoSurfaceChanged , streamId:" + this.mStreamId + " surface:" + surfaceScaleInfo.surface);
        if (this.mSurfaceDestoryedState.get()) {
            tryUnlockSurfaceDestroyLock();
            YMFLog.info(this, "[Decoder ]", "handleVideoSurfaceChanged mSurfaceDestoryedState:" + this.mSurfaceDestoryedState.get());
            return;
        }
        if (this.mVideoSurface != surfaceScaleInfo.surface) {
            if (this.mVideoWindowSurface != null) {
                this.mEglCore.makeCurrent(this.mEnvSurface);
                this.mVideoWindowSurface.release();
                this.mVideoWindowSurface = null;
            }
            try {
                if (surfaceScaleInfo.surface.isValid()) {
                    this.mVideoWindowSurface = new WindowSurface(this.mEglCore, surfaceScaleInfo.surface, false);
                    this.mVideoWindowSurface.makeCurrent();
                    this.mVideoSurface = surfaceScaleInfo.surface;
                } else {
                    YMFLog.error(this, "[Decoder ]", "surface may be destroyed");
                }
            } catch (Throwable th) {
                tryUnlockSurfaceDestroyLock();
                YMFLog.error(this, "[Decoder ]", "handleVideoSurfaceChanged exception:" + th.getMessage());
            }
        }
        tryUnlockSurfaceDestroyLock();
        this.mVideoSizes.mVideoSurfaceWidth = surfaceScaleInfo.width;
        this.mVideoSizes.mVideoSurfaceHeight = surfaceScaleInfo.height;
        this.mSurfaceScaleInfo = surfaceScaleInfo;
        updateDisplayRegion();
        if (this.mDecoderSurfaceTexture != null && this.mFirstFrameRendered) {
            handleOnVideoFrameAvailable(this.mDecoderSurfaceTexture, 0L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if ((r9.mVideoSizes.mVideoWidth < r9.mVideoSizes.mVideoHeight) != (r9.mVideoSizes.mVideoSurfaceWidth < r9.mVideoSizes.mVideoSurfaceHeight)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateDisplayRegion() {
        VideoSizeUtils.Size CalcFitSize;
        if (this.mSurfaceScaleInfo != null) {
            if (this.mSurfaceScaleInfo.orientationType != VideoConstant.OrientationType.Force) {
                if (this.mSurfaceScaleInfo.orientationType == VideoConstant.OrientationType.Auto) {
                }
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight, this.mSurfaceScaleInfo.scaleMode);
                this.mVideoSizes.mViewX = CalcFitSize.x;
                this.mVideoSizes.mViewY = CalcFitSize.y;
                this.mVideoSizes.mViewWidth = CalcFitSize.width;
                this.mVideoSizes.mViewHeight = CalcFitSize.height;
            }
            if (this.mSurfaceScaleInfo.rotateAngle != 0 && this.mSurfaceScaleInfo.rotateAngle != 180) {
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight, this.mSurfaceScaleInfo.scaleMode);
            } else {
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight, this.mSurfaceScaleInfo.scaleMode);
            }
            Matrix.translateM(this.mTransform, 0, this.mSrcTransform, 0, 0.5f, 0.5f, 0.0f);
            Matrix.rotateM(this.mTransform, 0, this.mSurfaceScaleInfo.rotateAngle, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(this.mTransform, 0, -0.5f, -0.5f, 0.0f);
            this.mVideoSizes.mViewX = CalcFitSize.x;
            this.mVideoSizes.mViewY = CalcFitSize.y;
            this.mVideoSizes.mViewWidth = CalcFitSize.width;
            this.mVideoSizes.mViewHeight = CalcFitSize.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceDestroyed(Surface surface) {
        tryLockSurfaceDestoryLock();
        YMFLog.info(this, "[Decoder ]", "handleVideoSurfaceDestroyed , streamId:" + this.mStreamId + " surface:" + surface);
        if (this.mVideoWindowSurface != null) {
            this.mVideoWindowSurface.checkCurrentEgl();
            this.mEglCore.makeCurrent(this.mEnvSurface);
            this.mVideoWindowSurface.release();
            this.mVideoWindowSurface = null;
        }
        this.mVideoSurface = null;
        if (this.mSurfaceScaleInfo != null) {
            this.mSurfaceScaleInfo.videoView = null;
            this.mSurfaceScaleInfo.surface = null;
        }
        tryUnlockSurfaceDestroyLock();
        synchronized (this.mSurfaceDestroyLock) {
            this.mSurfaceDestroyLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceCreated() {
        this.mSurfaceDestoryedState.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceRedraw() {
        if (this.mDecoderSurfaceTexture != null && this.mFirstFrameRendered) {
            handleOnVideoFrameAvailable(this.mDecoderSurfaceTexture, 0L);
        }
    }

    private void onVideoRenderNotify(long j, long j2, long j3, long j4, long j5, boolean z) {
        if (this.mVideoRenderNotifys != null) {
            this.mVideoRenderNotifys.add(new VideoRenderNotify(j, j2, j3, j4, j5, z));
            Iterator<VideoRenderNotify> it = this.mVideoRenderNotifys.iterator();
            if (it.hasNext()) {
                if (j3 - it.next().mPts >= kNotifyTimeGap || this.mVideoRenderNotifys.size() >= 15 || !this.mFirstFrameDecodered) {
                    if (!this.mFirstFrameDecodered) {
                        YMFLog.info(this, "[Decoder ]", "first frame finish decode");
                        this.mFirstFrameDecodered = true;
                    }
                    YYVideoLibMgr.instance().onVideoRenderNotify(this.mVideoRenderNotifys);
                    this.mVideoRenderNotifys.clear();
                }
            }
        }
    }

    private void handleOnVideoFrameAvailable(SurfaceTexture surfaceTexture, long j) {
        tryLockSurfaceDestoryLock();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSmoothnessCounter.RenderOneFrame(this.mStreamId, currentTimeMillis)) {
            YYVideoLibMgr.instance().onCoefficientOfVariationOfRenderInterval(this.mUserGroupId, this.mStreamId, this.mSmoothnessCounter.GetIntervalMilliTs(), this.mSmoothnessCounter.ComputeCoefficientOfVariationAndReset());
        }
        if (!this.mFirstFrameRendered) {
            YMFLog.info(this, "[Decoder ]", "handleOnVideoFrameAvailable notify first frame out, frames:" + this.mFrames);
            YYVideoLibMgr.instance().onFirstFrameRenderNotify(this.mUserGroupId, this.mStreamId, currentTimeMillis, currentTimeMillis - this.mFirstFrameTs, this.mFrames);
        }
        if (surfaceTexture == this.mDecoderSurfaceTexture && this.mVideoWindowSurface != null) {
            StateMonitor.NotifyPts(this.mStreamId, j);
            try {
                if (this.mPlayNotify != null) {
                    this.mPlayNotify.DrawNotify();
                }
                if (!this.mFirstFrameSeeFlag) {
                    YYVideoLibMgr.instance().onFirstFrameSeeNotify(this.mStreamId, j, this.mFrameWidth, this.mFrameHeight);
                    this.mFirstFrameSeeFlag = true;
                }
                if (this.mUsedNewOutDecoder.get()) {
                    YMFLog.info(this, "[Decoder ]", "handleOnVideoFrameAvailable real render:" + j);
                }
                this.mDecoderSurfaceTexture.getTransformMatrix(this.mTmpTransform);
                if (!Arrays.equals(this.mSrcTransform, this.mTmpTransform)) {
                    System.arraycopy(this.mTmpTransform, 0, this.mSrcTransform, 0, 16);
                    System.arraycopy(this.mSrcTransform, 0, this.mTransform, 0, 16);
                    updateDisplayRegion();
                }
                if (!this.mSurfaceDestoryedState.get()) {
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GlUtil.checkGlErrorNoException("glClearColor");
                    GLES20.glClear(16640);
                    GlUtil.checkGlErrorNoException("glClear");
                    GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mViewWidth, this.mVideoSizes.mViewHeight);
                    GlUtil.checkGlErrorNoException("glViewport");
                    if (!this.mIsVrStream) {
                        this.mVideoScreen.drawFrame(this.mDecoderTextureId, this.mTransform, -1);
                    }
                    this.mVideoWindowSurface.swapBuffers();
                    if (this.mVideoInfoCallback != null) {
                        this.mVideoInfoCallback.onUpdatePts(this.mStreamId, j);
                    }
                }
                if (!this.mFirstFrameRendered) {
                    StateMonitor.instance();
                    StateMonitor.NotifyFirstFrameRendered(this.mStreamId, TimeUtil.getTickCount());
                    YMFLog.info(this, "[Decoder ]", "handleOnVideoFrameAvailable first frame render cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                }
                this.mRenderCnt++;
                this.mCurTime = TimeUtil.getTickCountLong();
                if (this.mLastTime == 0) {
                    this.mLastTime = this.mCurTime;
                }
                if (this.mCurTime - this.mLastTime >= 1000) {
                    StateMonitor.instance().NotifyRenderFrameRate(this.mStreamId, this.mRenderCnt);
                    this.mLastTime = this.mCurTime;
                    this.mRenderCnt = 0;
                }
            } catch (Throwable th) {
                tryUnlockSurfaceDestroyLock();
                YMFLog.error(this, "[Decoder ]", "handleOnVideoFrameAvailable exception:" + th.getMessage());
                handleVideoSurfaceDestroyed(null);
            }
        } else if (!this.mFirstFrameRendered) {
            YMFLog.info(this, "[Decoder ]", "handleOnVideoFrameAvailable Frame Loss, eaten frames:" + this.mFrames);
        }
        this.mFirstFrameRendered = true;
        tryUnlockSurfaceDestroyLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoConfig(VideoHeaderInfo videoHeaderInfo) {
        YMFLog.info(this, "[Decoder ]", "handleVideoConfig width:" + videoHeaderInfo.width + ", height:" + videoHeaderInfo.height + ", mine:" + videoHeaderInfo.mime + ", streamId:" + this.mStreamId);
        this.mFrameWidth = videoHeaderInfo.width;
        this.mFrameHeight = videoHeaderInfo.height;
        this.mFirstFrameTs = System.currentTimeMillis();
        this.mFrames = 0;
        this.mFirstFrameDecodered = false;
        this.mSmoothnessCounter.ResetToInitialState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseDecoderStaffs() {
        if (this.mDecoderSurface != null) {
            this.mDecoderSurface.release();
            this.mDecoderSurface = null;
        }
        if (this.mDecoderSurfaceTexture != null) {
            this.mDecoderSurfaceTexture.release();
            this.mDecoderSurfaceTexture = null;
        }
        if (this.mDecoderTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mDecoderTextureId}, 0);
            this.mDecoderTextureId = -1;
        }
        YMFLog.info(this, "[Decoder ]", "releaseDecoderStaffs...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndofStream() {
        YMFLog.info(this, "[Decoder ]", "handleEndofStream...");
        this.mFirstFrameRendered = false;
        this.mFirstFrameDecodered = false;
    }

    private void updateSurfaceTexture() {
        decodeAnalysis();
        handleOnVideoFrameAvailable(this.mDecoderSurfaceTexture, this.mDecoderSurfaceTexture.getTimestamp() / TimeUtils.NANOS_PER_MS);
    }

    private void notifyVideoRender(long j) {
        if (j != 0) {
            try {
                if (j != this.mTempPts && this.mVideoWindowSurface != null && this.mDecoderTimeStampMap.get(Long.valueOf(j)) != null) {
                    this.mTempPts = j;
                    Iterator<Map.Entry<Long, Long>> it = this.mDecoderTimeStampMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Long, Long> next = it.next();
                        if (next.getKey().longValue() == j) {
                            onVideoRenderNotify(this.mUserGroupId, this.mStreamId, j, TimeUtil.getTickCountLong(), next.getValue().longValue(), this.mIgnoreStatistic);
                            this.mIgnoreStatistic = false;
                            it.remove();
                        } else if (next.getKey().longValue() < j) {
                            it.remove();
                        }
                    }
                    return;
                }
            } catch (Exception e) {
                YMFLog.info(this, "[Decoder ]", "notifyVideoRender exception:" + e.toString());
                return;
            }
        }
        if (this.mOuterOutPts.get() != this.mTempPts && this.mOuterOutPts.get() != 0) {
            onVideoRenderNotify(this.mUserGroupId, this.mStreamId, this.mOuterOutPts.get(), TimeUtil.getTickCountLong(), this.mLastDecodedTimeStampTime, this.mIgnoreStatistic);
            if (this.mIgnoreStatistic) {
                YMFLog.info(this, "[Decoder ]", "IgnoreStat mStreamId:" + this.mStreamId + " pts:" + j);
                this.mIgnoreStatistic = false;
            }
            this.mTempPts = this.mOuterOutPts.get();
            this.mDecoderTimeStampMap.remove(Long.valueOf(this.mOuterOutPts.get()));
        }
    }

    private void decodeAnalysis() {
        if (this.mBasicVsync == 0) {
            this.mBasicVsync = System.currentTimeMillis();
            this.mPreVsync = this.mBasicVsync;
            this.mPreFramePts = this.mDecoderSurfaceTexture.getTimestamp() / TimeUtils.NANOS_PER_MS;
            this.mSum = 0L;
            this.mFrameCnt = 0;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mVsyncTime = currentTimeMillis;
        if (currentTimeMillis - this.mBasicVsync >= 6000) {
            this.mBasicVsync = 0L;
        }
        this.mVsyncTimeDiff = this.mVsyncTime - this.mPreVsync;
        this.mFramePtsDiff = (this.mDecoderSurfaceTexture.getTimestamp() / TimeUtils.NANOS_PER_MS) - this.mPreFramePts;
        this.mDiff = Math.abs(this.mVsyncTimeDiff - this.mFramePtsDiff);
        if (this.mDiff > 300) {
            YMFLog.info(this, "[Decoder ]", "Vsync or pts exception,Vsync diff:" + this.mVsyncTimeDiff + " Frame diff:" + this.mFramePtsDiff + " Diff:" + this.mDiff);
        } else {
            this.mSum += this.mDiff;
            this.mFrameCnt++;
            if ((this.mSum * 1.0d) / this.mFrameCnt > 150.0d) {
                YMFLog.info(this, "[Decoder ]", "Vsync or pts exception,diff:" + this.mDiff);
            }
        }
        this.mPreVsync = this.mVsyncTime;
        this.mPreFramePts = this.mDecoderSurfaceTexture.getTimestamp() / TimeUtils.NANOS_PER_MS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class RenderHandler extends Handler {
        private WeakReference<HardDecodeWayGpu> mWeakWay;

        public RenderHandler(HardDecodeWayGpu hardDecodeWayGpu) {
            this.mWeakWay = new WeakReference<>(hardDecodeWayGpu);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (8 == i) {
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                    return;
                }
                return;
            }
            HardDecodeWayGpu hardDecodeWayGpu = this.mWeakWay.get();
            if (hardDecodeWayGpu != null) {
                try {
                    switch (i) {
                        case 1:
                            hardDecodeWayGpu.handleVideoSurfaceChanged((SurfaceScaleInfo) message.obj);
                            break;
                        case 2:
                            hardDecodeWayGpu.handleVideoSurfaceDestroyed((Surface) message.obj);
                            break;
                        case 3:
                            hardDecodeWayGpu.handleVideoSurfaceRedraw();
                            break;
                        case 4:
                            hardDecodeWayGpu.handleGetScreenShot((ScreenShotInfo) message.obj);
                            break;
                        case 5:
                            hardDecodeWayGpu.handleVideoConfig((VideoHeaderInfo) message.obj);
                            break;
                        case 6:
                        case 8:
                        case 9:
                        default:
                            return;
                        case 7:
                            hardDecodeWayGpu.handleEndofStream();
                            break;
                        case 10:
                            hardDecodeWayGpu.handleVideoSurfaceCreated();
                            break;
                        case 11:
                            hardDecodeWayGpu.handleSetVideoInfoCallback((IVideoInfoCallback) message.obj);
                            break;
                    }
                    return;
                } catch (Exception e) {
                    YMFLog.error(this, "[Decoder ]", "handleMessage exception:" + YMFLog.stackTraceOf(e));
                    return;
                } finally {
                    hardDecodeWayGpu.tryUnlockSurfaceDestroyLock();
                }
            }
            YMFLog.warn(this, "[Decoder ]", "handleMessage: hardDecodeWay is null");
        }
    }

    public void handleSetVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
        YMFLog.info(this, "[Decoder ]", " handleSetVideoInfoCallback");
        this.mVideoInfoCallback = iVideoInfoCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destoryGLEnv() {
        if (this.mNewDecoderSurface != null) {
            this.mNewDecoderSurface.release();
            this.mNewDecoderSurface = null;
        }
        if (this.mNewDecoderSurfaceTexture != null) {
            this.mNewDecoderSurfaceTexture.release();
            this.mNewDecoderSurfaceTexture = null;
        }
        if (this.mNewDecoderTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mNewDecoderTextureId}, 0);
            this.mNewDecoderTextureId = -1;
        }
        YMFLog.info(this, "[Decoder ]", "destoryGLEnv...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destoryAsyncEnv() {
        if (this.mNewDecoderTextureId != -1) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.5
                @Override // java.lang.Runnable
                public void run() {
                    HardDecodeWayGpu.this.destoryGLEnv();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "[destoryAsyncEnv syncFlag.await exception:" + e.toString());
            }
        }
        if (this.mNewOutDecoder != null) {
            this.mNewOutDecoder.release();
            this.mNewOutDecoder = null;
        }
        YMFLog.error(this, "[Decoder ]", "destoryAsyncEnv end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDecoderAsync(byte[] bArr, int i, int i2, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mNewDecoderTextureId == -1) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (this.mHandler.getLooper().getThread().equals(Thread.currentThread()) || this.mHandler.getLooper().getThread().equals(this.mAsyncHandlerThread.getLooper().getThread())) {
                YMFLog.error(this, "[Decoder ]", "createDecoderAsync thread same");
            }
            this.mHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.6
                @Override // java.lang.Runnable
                public void run() {
                    HardDecodeWayGpu.this.mNewDecoderTextureId = HardDecodeWayGpu.this.genExtTexture();
                    HardDecodeWayGpu.this.mNewDecoderSurfaceTexture = new SurfaceTexture(HardDecodeWayGpu.this.mNewDecoderTextureId);
                    HardDecodeWayGpu.this.mNewDecoderSurface = new Surface(HardDecodeWayGpu.this.mNewDecoderSurfaceTexture);
                    if (HardDecodeWayGpu.this.mNewDecoderSurface.isValid()) {
                        YMFLog.info(this, "[Decoder ]", "createDecoderAsync create new surface");
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "createDecoderAsync syncFlag.await exception:" + e.toString());
            }
        }
        if (this.mNewOutDecoder == null) {
            if ("video/hevc".equals(str)) {
                this.mNewOutDecoder = new H265DecRender(this.mNewDecoderSurface, i, i2, this.mUserGroupId, this.mStreamId);
                StateMonitor.NotifyCreateRender(this.mStreamId, 1);
            } else if ("video/avc".equals(str)) {
                this.mNewOutDecoder = new H264DecRender(this.mNewDecoderSurface, i, i2, this.mUserGroupId, this.mStreamId);
                StateMonitor.NotifyCreateRender(this.mStreamId, 0);
            } else if ("video/x-vnd.on2.vp8".equals(str)) {
                this.mNewOutDecoder = new VP8DecRender(this.mNewDecoderSurface, i, i2);
            }
            this.mNewOutDecoder.setStreamId(this.mStreamId);
            this.mNewOutDecoder.setDecoderDataOutCallBack(this);
        } else {
            this.mNewOutDecoder.reset(this.mNewDecoderSurface, i, i2);
        }
        this.mRecIFrame = false;
        this.mVideoDataCnt = 0L;
        this.mIsDecoderNeedReconfig = false;
        this.mNewOutDecoder.PushFrame(this.mNewDecoderSurface, bArr, null, 0L, true);
        this.mNewOutDecoder.ConfigDone();
        if (this.mNewOutDecoder.GetAndClearExceptionFlag()) {
            YMFLog.error(this, "[Decoder ]", "createDecoderAsync mNewOutDecoder exception");
            this.mIsDecoderNeedReconfig = true;
            this.mNewOutDecoder.EndofStream();
        }
        this.mNewWidth = i;
        this.mNewHeight = i2;
        this.mNewDecodedOutFirstFrame = false;
        YMFLog.info(this, "[Decoder ]", "createDecoderAsync: width:" + i + ", height:" + i2 + ", mine:" + str + ", streamId:" + this.mStreamId + " cost Time:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeFrameAsync() {
        int i;
        if (this.mDecodingQueue.size() == 0) {
            YMFLog.error(this, "[Decoder ]", "someThing wrong ,the mDecodingQueue.size == 0! ");
            return;
        }
        VideoEntities.VideoData peek = this.mDecodingQueue.peek();
        if (peek != null) {
            if (this.mIsDecoderNeedReconfig) {
                YMFLog.warn(this, "[Decoder ]", "decodeFrameAsync mIsDecoderNeedReconfig true streamId:" + this.mStreamId + ", pts:" + peek.pts);
                return;
            }
            this.mFrames++;
            if (this.mNewOutDecoder != null) {
                if ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50) {
                    if (this.mOuterDecoder instanceof VP8DecRender) {
                        i = 0;
                    } else if (peek.data == null) {
                        i = 255;
                    } else if (peek.data[0] == 0 && peek.data[1] == 0 && peek.data[2] == 1) {
                        i = peek.data[3] & 31;
                    } else if (peek.data[0] == 0 && peek.data[1] == 0 && peek.data[2] == 0 && peek.data[3] == 1) {
                        i = peek.data[4] & 31;
                    } else {
                        i = -1;
                    }
                    if (i == 5) {
                        this.mRecIFrame = true;
                    }
                    YMFLog.info(this, "[Decoder ]", "handleOuterVideoData streamId:" + this.mStreamId + ", frames:" + this.mFrames + ", type:" + i + ", len:" + (peek.data == null ? 0 : peek.data.length) + ", pts:" + peek.pts);
                }
                this.mOuterOutPts.set(this.mNewOutDecoder.PushFrame(this.mNewDecoderSurface, peek.data, null, peek.pts, false));
                this.mDecodingQueue.poll();
                if (this.mOuterOutPts.get() <= 0) {
                    if (this.mNewOutDecoder.GetAndClearExceptionFlag()) {
                        YMFLog.warn(this, "[Decoder ]", "decodeFrameAsync decoder exception! Need to recconfig!");
                        this.mIsDecoderNeedReconfig = true;
                        this.mNewOutDecoder.EndofStream();
                        return;
                    }
                    return;
                }
                if (this.mDecoderTimeStampMap.size() <= 100) {
                    this.mDecoderTimeStampMap.put(Long.valueOf(this.mOuterOutPts.get()), Long.valueOf(TimeUtil.getTickCountLong()));
                } else {
                    YMFLog.info(this, "[Decoder ]", "decodeFrameAsync mDecoderTimeStampMap full ");
                    this.mDecoderTimeStampMap.clear();
                }
                if (!this.mFirstFrameOut) {
                    StateMonitor.instance().NotifyDecodeDelayFrameCountInfo(this.mStreamId, this.mFrames);
                    YMFLog.info(this, "[Decoder ]", "decodeFrameAsync first frame out, frames:" + this.mFrames);
                }
                this.mLastDecodedTimeStampTime = TimeUtil.getTickCountLong();
                this.mDecodeCnt++;
                this.mCurTime1 = TimeUtil.getTickCountLong();
                if (this.mLastTime1 == 0) {
                    this.mLastTime1 = this.mCurTime1;
                }
                if (this.mCurTime1 - this.mLastTime1 >= 1000) {
                    StateMonitor.NotifyDecoderFrameRateOUT(this.mStreamId, this.mDecodeCnt);
                    this.mLastTime1 = this.mCurTime1;
                    this.mDecodeCnt = 0;
                }
            }
        }
    }

    private void handleGetCacheFrame() {
        if (this.mOuterDecoder != null) {
            this.mOuterOutPts.set(this.mOuterDecoder.getCacheFrame());
            if (this.mOuterOutPts.get() <= 0) {
                if (this.mOuterDecoder.GetAndClearExceptionFlag()) {
                    YMFLog.warn(this, "[Decoder ]", "handleGetCacheFrame decoder exception! error error!");
                    this.mIsDecoderNeedReconfig = true;
                    this.mOuterDecoder.EndofStream();
                    return;
                }
                return;
            }
            if (this.mDecoderTimeStampMap.size() <= 100) {
                this.mDecoderTimeStampMap.put(Long.valueOf(this.mOuterOutPts.get()), Long.valueOf(TimeUtil.getTickCountLong()));
            } else {
                YMFLog.info(this, "[Decoder ]", "handleGetCacheFrame mDecoderTimeStampMap full ");
                this.mDecoderTimeStampMap.clear();
            }
            this.mLastDecodedTimeStampTime = TimeUtil.getTickCountLong();
            this.mDecodeCnt++;
            this.mCurTime1 = TimeUtil.getTickCountLong();
            if (this.mLastTime1 == 0) {
                this.mLastTime1 = this.mCurTime1;
            }
            if (this.mCurTime1 - this.mLastTime1 >= 1000) {
                StateMonitor.NotifyDecoderFrameRateOUT(this.mStreamId, this.mDecodeCnt);
                this.mLastTime1 = this.mCurTime1;
                this.mDecodeCnt = 0;
            }
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender.IDecoderDataOutCallBack
    public void onFirstDecodedDataOut() {
        YMFLog.info(this, "[Decoder ]", "newOuterDecoder onFirstDecodedDataOut");
        changeGlEnv();
        this.mNewDecodedOutFirstFrame = true;
    }

    private void changeToNewDecoder() {
        Exception e;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        YMFLog.info(this, "[Decoder ]", "changeToNewDecoder mDecodingQueue.size:" + this.mDecodingQueue.size());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.7
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Decoder ]", "changeToNewDecoder mAsyncHandler idle size:" + HardDecodeWayGpu.this.mDecodingQueue.size());
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            int i2 = 0;
            while (this.mDecodingQueue.size() != 0) {
                try {
                    Thread.sleep(5L);
                    i = i2 + 1;
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    if (i2 % 30 == 0) {
                        YMFLog.error(this, "[Decoder ]", "changeToNewDecoder sleep 150ms -> " + this.mDecodingQueue.size());
                    }
                    i2 = i;
                } catch (Exception e3) {
                    e = e3;
                    i2 = i;
                    YMFLog.error(this, "[Decoder ]", "changeToNewDecoder sleep exception:" + e.toString());
                }
            }
            final HardDecRender hardDecRender = this.mOuterDecoder;
            this.mNewOutDecoder.setDecoderDataOutCallBack(null);
            this.mOuterDecoder = this.mNewOutDecoder;
            this.mNewOutDecoder = null;
            this.mAsyncHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.8
                @Override // java.lang.Runnable
                public void run() {
                    hardDecRender.release();
                }
            });
            this.mUsedNewOutDecoder.set(false);
            YMFLog.info(this, "[Decoder ]", "changeToNewDecoder end mDecodingQueue.size:" + this.mDecodingQueue.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e4) {
            YMFLog.error(this, "[Decoder ]", "onFirstDecodedDataOut syncFlag.await exception:" + e4.toString());
        }
    }

    private void changeGlEnv() {
        YMFLog.info(this, "[Decoder ]", "changeGlEnv begin");
        if (this.mDecoderSurfaceTexture != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWayGpu.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HardDecodeWayGpu.this.tryLockSurfaceDestoryLock();
                        HardDecodeWayGpu.this.mDecoderSurfaceTexture.setOnFrameAvailableListener(null);
                        HardDecodeWayGpu.this.mNewDecoderSurfaceTexture.setOnFrameAvailableListener(this);
                        HardDecodeWayGpu.this.releaseDecoderStaffs();
                        HardDecodeWayGpu.this.mDecoderSurfaceTexture = HardDecodeWayGpu.this.mNewDecoderSurfaceTexture;
                        HardDecodeWayGpu.this.mDecoderSurface = HardDecodeWayGpu.this.mNewDecoderSurface;
                        HardDecodeWayGpu.this.mDecoderTextureId = HardDecodeWayGpu.this.mNewDecoderTextureId;
                        HardDecodeWayGpu.this.mNewDecoderSurface = null;
                        HardDecodeWayGpu.this.mNewDecoderSurfaceTexture = null;
                        HardDecodeWayGpu.this.mNewDecoderTextureId = -1;
                        HardDecodeWayGpu.this.mFrameWidth = HardDecodeWayGpu.this.mNewWidth;
                        HardDecodeWayGpu.this.mFrameHeight = HardDecodeWayGpu.this.mNewHeight;
                        HardDecodeWayGpu.this.tryUnlockSurfaceDestroyLock();
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        YMFLog.error(this, "[Decoder ]", "changeGlEnv exception:" + e.toString());
                    }
                }
            });
            try {
                countDownLatch.await();
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "onFirstDecodedDataOut syncFlag.await exception:" + e.toString());
                return;
            }
        }
        YMFLog.info(this, "[Decoder ]", "changeGlEnv end");
    }
}
