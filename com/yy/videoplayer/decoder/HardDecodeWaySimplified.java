package com.yy.videoplayer.decoder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.IYMFDecoderListener;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.YMFStreamManager;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
import com.yy.videoplayer.decoder.VideoSizeUtils;
import com.yy.videoplayer.render.YMFImageBuffer;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.VideoEntities;
import com.yy.videoplayer.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class HardDecodeWaySimplified implements HardDecodeWay, Runnable {
    private static final int MSG_END_OF_STREAM = 7;
    private static final int MSG_GET_SCREENSHOT = 4;
    private static final int MSG_QUIT = 8;
    private static final int MSG_SETVIDEINFOCALLBACK = 9;
    private static final int MSG_VIDEO_CONFIG = 5;
    private static final int MSG_VIDEO_DATA = 6;
    private static final int MSG_VIDEO_SURFACE_CHANGED = 1;
    private static final int MSG_VIDEO_SURFACE_DESTROYED = 2;
    private static final int MSG_VIDEO_SURFACE_REDRAW = 3;
    private static final String TAG = "HardDecodeWaySimplified";
    private static final int VIDEO_DATA_LOG = 5000;
    static final int kNofifySizeGap = 15;
    static final long kNotifyTimeGap = 500;
    private HardDecRender mDecoder;
    private IYMFDecoderListener mDecoderListener;
    private RenderHandler mHandler;
    private PlayNotify mPlayNotify;
    private RawH264Data[] mRawDataBuf;
    private Thread mThread;
    private VideoHeaderInfo mVideoHeaderInfo;
    private Surface mVideoSurface;
    private long mVideoDataCnt = 0;
    private boolean mRecIFrame = false;
    private VideoEntities.VideoSizes mVideoSizes = new VideoEntities.VideoSizes();
    private SurfaceScaleInfo mSurfaceScaleInfo = new SurfaceScaleInfo();
    private boolean mIsDecoderNeedReconfig = false;
    private AtomicBoolean mReady = new AtomicBoolean(false);
    private final Object mStartLock = new Object();
    private final Object mQuitLock = new Object();
    private final Object mScreenShotLock = new Object();
    private final Object mSurfaceDestroyLock = new Object();
    private final int MAX_SUPPORTED_GOP_SIZE = 200;
    private int mRawDataCount = 0;
    private int mFrames = -1;
    private boolean mFirstFrameOut = false;
    private long mFirstFrameTs = 0;
    private long mUserGroupId = 0;
    private long mStreamId = 0;
    private SmoothnessCounter mSmoothnessCounter = new SmoothnessCounter(5000);
    private ArrayList<VideoRenderNotify> mVideoRenderNotifys = new ArrayList<>();
    private int mRenderCnt = 0;
    private long mCurTime = 0;
    private long mLastTime = 0;
    private IVideoInfoCallback mVideoInfoCallback = null;
    private AtomicBoolean mSurfaceDestoryedState = new AtomicBoolean(false);
    private ReentrantLock mSurfaceDestoryedLock = new ReentrantLock(true);
    private Handler mUiHandler = null;
    private YMFImageBuffer mImage = null;
    private boolean mIgnoreStatistic = false;
    private int mViewState = 1;

    private void tryLockSurfaceDestoryLock() {
        if (this.mSurfaceDestoryedLock.getHoldCount() == 0) {
            this.mSurfaceDestoryedLock.lock();
        }
    }

    public void setDecoderListener(IYMFDecoderListener iYMFDecoderListener) {
        this.mDecoderListener = iYMFDecoderListener;
    }

    private void tryUnlockSurfaceDestroyLock() {
        while (this.mSurfaceDestoryedLock.getHoldCount() != 0) {
            try {
                this.mSurfaceDestoryedLock.unlock();
            } catch (IllegalMonitorStateException e) {
                YMFLog.warn(this, "[Decoder ]", "tryUnlockSurfaceDestroyLock more than once, exception:" + e.toString());
                return;
            }
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public VideoDecoderCenterExt.HardDecoderStaffVersion getHardDecodeType() {
        return VideoDecoderCenterExt.HardDecoderStaffVersion.SIMPLIFIED;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long getUserGroupId() {
        return this.mUserGroupId;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
        if (this.mReady.get()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(9, iVideoInfoCallback));
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Start() {
        YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified Start...");
        this.mThread = new Thread(this);
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mThread.setName("YY_yylivesdk_HardDecodeWaySimplified_Thread");
        synchronized (this.mStartLock) {
            this.mThread.start();
            this.mStartLock.wait(kNotifyTimeGap);
        }
        YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified Start done");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class RawH264Data {
        public byte[] data;
        public long pts;

        private RawH264Data() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class VideoHeaderInfo {
        public byte[] header;
        public int height;
        public String mime;
        public int width;

        private VideoHeaderInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ScreenShotInfo {
        public int height;
        public boolean isSuccess;
        public Buffer pixelBuffer;
        public int width;

        private ScreenShotInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
            this.mVideoSizes.mVideoSurfaceWidth = surfaceScaleInfo.width;
            this.mVideoSizes.mVideoSurfaceHeight = surfaceScaleInfo.height;
            this.mVideoSizes.mVideoParentWidth = surfaceScaleInfo.parentWidth;
            this.mVideoSizes.mVideoParentHeight = surfaceScaleInfo.parentHeight;
            this.mSurfaceScaleInfo.videoView = surfaceScaleInfo.videoView;
            this.mSurfaceScaleInfo.surface = surfaceScaleInfo.surface;
            if (!IsScaleInfoEqual(this.mSurfaceScaleInfo, surfaceScaleInfo)) {
                this.mSurfaceScaleInfo = surfaceScaleInfo;
                updateDisplayRegion();
            }
            tryLockSurfaceDestoryLock();
            this.mSurfaceDestoryedState.set(false);
            tryUnlockSurfaceDestroyLock();
            notifyViewStateChange(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, surfaceScaleInfo));
        }
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceCreated() {
        notifyViewStateChange(0);
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceDestroyed(Surface surface) {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "OnSurfaceDestroyed");
            tryLockSurfaceDestoryLock();
            this.mSurfaceDestoryedState.set(true);
            tryUnlockSurfaceDestroyLock();
            this.mHandler.removeMessages(6);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, surface));
            notifyViewStateChange(1);
            YMFPlayerStatisticManager.getInstance().reset();
        }
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

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void onCreateRenderAhead(int i, int i2, String str) {
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void OnVideoConfig(byte[] bArr, int i, int i2, String str) {
        if (this.mReady.get()) {
            YMFLog.info(this, "[Decoder ]", "OnVideoConfig width:" + i + " height:" + i2 + " mime:" + str + ", streamId:" + this.mStreamId);
            YMFStreamManager.instance().addStream(this.mStreamId, this);
            if (this.mImage == null) {
                this.mImage = new YMFImageBuffer(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, 36, false);
                this.mImage.mHardware = true;
                this.mImage.mDirectHardRender = true;
            }
            this.mDecoderListener.onDecodedFrameAvailable(this.mStreamId, this.mImage);
            VideoHeaderInfo videoHeaderInfo = new VideoHeaderInfo();
            videoHeaderInfo.header = bArr;
            videoHeaderInfo.width = i;
            videoHeaderInfo.height = i2;
            videoHeaderInfo.mime = str;
            this.mVideoHeaderInfo = videoHeaderInfo;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, videoHeaderInfo));
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long OnVideoDataArrived(byte[] bArr, long j, VideoConstant.ExtraData extraData) {
        if (this.mReady.get()) {
            long j2 = this.mVideoDataCnt;
            this.mVideoDataCnt = 1 + j2;
            if (j2 % 5000 == 0 || ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50)) {
                YMFLog.info(this, "[Decoder ]", "OnVideoDataArrived streamId:" + this.mStreamId + ", pts:" + j);
            }
            VideoEntities.VideoData videoData = new VideoEntities.VideoData();
            videoData.data = bArr;
            videoData.pts = j;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(6, videoData));
            return -1L;
        }
        return -1L;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Quit() {
        if (this.mReady.get()) {
            synchronized (this.mQuitLock) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                this.mQuitLock.wait(kNotifyTimeGap);
                YMFLog.info(this, "[Decoder ]", "Quit");
            }
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVrStream(boolean z) {
    }

    private void Init() {
        this.mVideoRenderNotifys.clear();
        this.mRawDataBuf = new RawH264Data[200];
        for (int i = 0; i < 200; i++) {
            this.mRawDataBuf[i] = new RawH264Data();
        }
    }

    private void DeInit() {
        if (this.mSurfaceScaleInfo != null) {
            this.mSurfaceScaleInfo.videoView = null;
            this.mSurfaceScaleInfo.surface = null;
            this.mSurfaceScaleInfo = null;
        }
        for (int i = 0; i < this.mRawDataCount; i++) {
            this.mRawDataBuf[i].data = null;
        }
        this.mRawDataBuf = null;
        this.mRawDataCount = 0;
        releaseDecoderStaffs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [413=5] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        try {
            Looper.prepare();
            this.mHandler = new RenderHandler(this);
            Init();
            this.mReady.set(true);
            YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified construct thread done");
            synchronized (this.mStartLock) {
                this.mStartLock.notifyAll();
            }
            Looper.loop();
            this.mReady.set(false);
            YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified construct thread done");
            try {
                DeInit();
            } catch (Throwable th) {
                YMFLog.error(this, "[Decoder ]", "HardDecodeWaySimplified DeInit exception: " + th.getMessage());
            }
            synchronized (this.mQuitLock) {
                this.mQuitLock.notifyAll();
            }
        } catch (Throwable th2) {
            try {
                YMFLog.error(this, "[Decoder ]", "HardDecodeWaySimplified init exception:" + th2.getMessage());
                YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified construct thread done");
                try {
                    DeInit();
                } catch (Throwable th3) {
                    YMFLog.error(this, "[Decoder ]", "HardDecodeWaySimplified DeInit exception: " + th3.getMessage());
                }
                synchronized (this.mQuitLock) {
                    this.mQuitLock.notifyAll();
                }
            } catch (Throwable th4) {
                YMFLog.info(this, "[Decoder ]", "HardDecodeWaySimplified construct thread done");
                try {
                    DeInit();
                } catch (Throwable th5) {
                    YMFLog.error(this, "[Decoder ]", "HardDecodeWaySimplified DeInit exception: " + th5.getMessage());
                }
                synchronized (this.mQuitLock) {
                    this.mQuitLock.notifyAll();
                    throw th4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetScreenShot(ScreenShotInfo screenShotInfo) {
        try {
            screenShotInfo.isSuccess = false;
            YMFLog.error(this, "[Decoder ]", "handleGetScreenShot Not Supported");
        } catch (Throwable th) {
            YMFLog.error(this, "[Decoder ]", "handleGetScreenShot exception:" + th.getMessage());
        }
        synchronized (this.mScreenShotLock) {
            this.mScreenShotLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceChanged(SurfaceScaleInfo surfaceScaleInfo) {
        if (this.mVideoSurface != surfaceScaleInfo.surface) {
            releaseDecoderStaffs();
            try {
                if (this.mVideoHeaderInfo != null) {
                    if (this.mVideoHeaderInfo.mime.compareTo("video/avc") == 0) {
                        this.mDecoder = new H264DecRender(surfaceScaleInfo.surface);
                    } else if (this.mVideoHeaderInfo.mime.compareTo("video/hevc") == 0) {
                        this.mDecoder = new H265DecRender(surfaceScaleInfo.surface, this.mVideoHeaderInfo.width, this.mVideoHeaderInfo.height);
                    }
                    this.mDecoder.setStreamId(this.mStreamId);
                    this.mVideoSurface = surfaceScaleInfo.surface;
                    this.mVideoSizes.mVideoSurfaceWidth = surfaceScaleInfo.width;
                    this.mVideoSizes.mVideoSurfaceHeight = surfaceScaleInfo.height;
                    this.mVideoSizes.mVideoParentWidth = surfaceScaleInfo.parentWidth;
                    this.mVideoSizes.mVideoParentHeight = surfaceScaleInfo.parentHeight;
                    this.mSurfaceScaleInfo = surfaceScaleInfo;
                    handleVideoConfig(this.mVideoHeaderInfo);
                }
            } catch (Throwable th) {
                YMFLog.error(this, "[Decoder ]", "handleVideoSurfaceChanged exception:" + th.getMessage());
            }
        }
    }

    private boolean IsScaleInfoEqual(SurfaceScaleInfo surfaceScaleInfo, SurfaceScaleInfo surfaceScaleInfo2) {
        return surfaceScaleInfo.parentHeight == surfaceScaleInfo2.parentHeight && surfaceScaleInfo.parentWidth == surfaceScaleInfo2.parentWidth && surfaceScaleInfo.orientationType == surfaceScaleInfo2.orientationType && surfaceScaleInfo.scaleMode == surfaceScaleInfo2.scaleMode && surfaceScaleInfo.rotateAngle == surfaceScaleInfo2.rotateAngle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if ((r5.mVideoSizes.mVideoWidth < r5.mVideoSizes.mVideoHeight) != (r5.mVideoSizes.mVideoParentWidth < r5.mVideoSizes.mVideoParentHeight)) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateDisplayRegion() {
        VideoSizeUtils.Size CalcFitSize;
        if (this.mSurfaceScaleInfo != null && this.mVideoHeaderInfo != null) {
            if (this.mSurfaceScaleInfo.orientationType != VideoConstant.OrientationType.Force) {
                if (this.mSurfaceScaleInfo.orientationType == VideoConstant.OrientationType.Auto) {
                }
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoParentWidth, this.mVideoSizes.mVideoParentHeight, this.mSurfaceScaleInfo.scaleMode);
                this.mVideoSizes.mViewX = CalcFitSize.x;
                this.mVideoSizes.mViewY = CalcFitSize.y;
                this.mVideoSizes.mViewWidth = CalcFitSize.width;
                this.mVideoSizes.mViewHeight = CalcFitSize.height;
                if (this.mSurfaceScaleInfo.videoView == null && this.mUiHandler != null) {
                    this.mUiHandler.post(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecodeWaySimplified.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View view;
                            SurfaceScaleInfo surfaceScaleInfo = HardDecodeWaySimplified.this.mSurfaceScaleInfo;
                            if (surfaceScaleInfo != null && (view = surfaceScaleInfo.videoView) != null) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                                layoutParams.leftMargin = HardDecodeWaySimplified.this.mVideoSizes.mViewX;
                                layoutParams.rightMargin = HardDecodeWaySimplified.this.mVideoSizes.mVideoParentWidth - (HardDecodeWaySimplified.this.mVideoSizes.mViewX + HardDecodeWaySimplified.this.mVideoSizes.mViewWidth);
                                layoutParams.width = HardDecodeWaySimplified.this.mVideoSizes.mViewWidth;
                                layoutParams.topMargin = HardDecodeWaySimplified.this.mVideoSizes.mViewY;
                                layoutParams.bottomMargin = HardDecodeWaySimplified.this.mVideoSizes.mVideoParentHeight - (HardDecodeWaySimplified.this.mVideoSizes.mViewY + HardDecodeWaySimplified.this.mVideoSizes.mViewHeight);
                                layoutParams.height = HardDecodeWaySimplified.this.mVideoSizes.mViewHeight;
                                YMFLog.info(this, "[Decoder ]", "updateDisplayRegion set sizes viewX:%d, viewY:%d, viewWidth:%d, viewHeight:%d", Integer.valueOf(HardDecodeWaySimplified.this.mVideoSizes.mViewX), Integer.valueOf(HardDecodeWaySimplified.this.mVideoSizes.mViewY), Integer.valueOf(HardDecodeWaySimplified.this.mVideoSizes.mViewWidth), Integer.valueOf(HardDecodeWaySimplified.this.mVideoSizes.mViewHeight));
                                view.setLayoutParams(layoutParams);
                                if (Build.VERSION.SDK_INT >= 18) {
                                    view.setClipBounds(new Rect(layoutParams.leftMargin < 0 ? -layoutParams.leftMargin : 0, layoutParams.topMargin < 0 ? -layoutParams.topMargin : 0, layoutParams.rightMargin < 0 ? layoutParams.width + layoutParams.rightMargin : layoutParams.width, layoutParams.bottomMargin < 0 ? layoutParams.bottomMargin + layoutParams.height : layoutParams.height));
                                }
                            }
                        }
                    });
                    return;
                }
            }
            if (this.mSurfaceScaleInfo.rotateAngle != 0 && this.mSurfaceScaleInfo.rotateAngle != 180) {
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoParentWidth, this.mVideoSizes.mVideoParentHeight, this.mSurfaceScaleInfo.scaleMode);
            } else {
                CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoParentWidth, this.mVideoSizes.mVideoParentHeight, this.mSurfaceScaleInfo.scaleMode);
            }
            this.mVideoSizes.mViewX = CalcFitSize.x;
            this.mVideoSizes.mViewY = CalcFitSize.y;
            this.mVideoSizes.mViewWidth = CalcFitSize.width;
            this.mVideoSizes.mViewHeight = CalcFitSize.height;
            if (this.mSurfaceScaleInfo.videoView == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceDestroyed(Surface surface) {
        releaseDecoderStaffs();
        this.mVideoSurface = null;
        if (this.mSurfaceScaleInfo != null) {
            this.mSurfaceScaleInfo.videoView = null;
            this.mSurfaceScaleInfo.surface = null;
        }
        synchronized (this.mSurfaceDestroyLock) {
            this.mSurfaceDestroyLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoSurfaceRedraw() {
    }

    private void onVideoRenderNotify(long j, long j2, long j3, long j4, long j5, boolean z) {
        if (this.mVideoRenderNotifys != null) {
            this.mVideoRenderNotifys.add(new VideoRenderNotify(j, j2, j3, j4, j5, z));
            Iterator<VideoRenderNotify> it = this.mVideoRenderNotifys.iterator();
            if (it.hasNext()) {
                if (j3 - it.next().mPts >= kNotifyTimeGap || this.mVideoRenderNotifys.size() >= 15) {
                    YYVideoLibMgr.instance().onVideoRenderNotify(this.mVideoRenderNotifys);
                    this.mVideoRenderNotifys.clear();
                }
            }
        }
    }

    private void handleOnVideoFrameDraw(long j) {
        if (j > 0) {
            onVideoRenderNotify(this.mUserGroupId, this.mStreamId, j, TimeUtil.getTickCountLong(), TimeUtil.getTickCountLong(), this.mIgnoreStatistic);
            if (this.mIgnoreStatistic) {
                YMFLog.info(this, "[Decoder ]", "IgnoreStat mStreamId:" + this.mStreamId + " pts:" + j);
                this.mIgnoreStatistic = false;
            }
            this.mRenderCnt++;
            this.mCurTime = TimeUtil.getTickCountLong();
            if (this.mCurTime - this.mLastTime >= 1000) {
                StateMonitor.instance().NotifyRenderFrameRate(this.mStreamId, this.mRenderCnt);
                this.mLastTime = this.mCurTime;
                this.mRenderCnt = 0;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSmoothnessCounter.RenderOneFrame(this.mStreamId, currentTimeMillis)) {
            YYVideoLibMgr.instance().onCoefficientOfVariationOfRenderInterval(this.mUserGroupId, this.mStreamId, this.mSmoothnessCounter.GetIntervalMilliTs(), this.mSmoothnessCounter.ComputeCoefficientOfVariationAndReset());
        }
        if (!this.mFirstFrameOut) {
            YYVideoLibMgr.instance().onFirstFrameRenderNotify(this.mUserGroupId, this.mStreamId, currentTimeMillis, currentTimeMillis - this.mFirstFrameTs, this.mFrames);
        }
        if (this.mPlayNotify != null) {
            this.mPlayNotify.DrawNotify();
        }
        if (!this.mFirstFrameOut) {
            StateMonitor.instance().NotifyDecodeDelayFrameCountInfo(this.mStreamId, this.mFrames);
            YMFLog.info(this, "[Decoder ]", "handleOnVideoFrameAvailable draw, eaten frames:" + this.mFrames);
        }
        if (this.mVideoInfoCallback != null) {
            this.mVideoInfoCallback.onUpdatePts(this.mStreamId, j);
        }
        this.mFirstFrameOut = true;
    }

    private String bin2hex(byte[] bArr) {
        String str = null;
        int length = bArr == null ? 0 : bArr.length;
        for (int i = 0; i < length; i++) {
            str = str != null ? str + String.format("%02x ", Byte.valueOf(bArr[i])) : String.format("%02x ", Byte.valueOf(bArr[i]));
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoConfig(VideoHeaderInfo videoHeaderInfo) {
        YMFLog.info(this, "[Decoder ]", "handleVideoConfig: width:" + videoHeaderInfo.width + ", height:" + videoHeaderInfo.height + ", mine:" + videoHeaderInfo.mime + ", streamId:" + this.mStreamId + ", data:" + bin2hex(videoHeaderInfo.header));
        this.mVideoSizes.mVideoWidth = videoHeaderInfo.width;
        this.mVideoSizes.mVideoHeight = videoHeaderInfo.height;
        if (this.mDecoder != null) {
            this.mFirstFrameTs = System.currentTimeMillis();
            updateDisplayRegion();
            tryLockSurfaceDestoryLock();
            if (!this.mSurfaceDestoryedState.get()) {
                this.mDecoder.reset(this.mVideoSurface, videoHeaderInfo.width, videoHeaderInfo.height);
                this.mDecoder.PushFrame(this.mVideoSurface, videoHeaderInfo.header, null, 0L, true);
                this.mDecoder.ConfigDone();
                this.mFrames = 0;
                this.mFirstFrameOut = false;
                this.mIsDecoderNeedReconfig = false;
                this.mRecIFrame = false;
                this.mVideoDataCnt = 0L;
            }
            tryUnlockSurfaceDestroyLock();
            if (this.mDecoder.GetAndClearExceptionFlag()) {
                this.mIsDecoderNeedReconfig = true;
                this.mDecoder.EndofStream();
                return;
            }
            this.mSmoothnessCounter.ResetToInitialState();
            tryLockSurfaceDestoryLock();
            if (!this.mSurfaceDestoryedState.get()) {
                for (int i = 0; i < this.mRawDataCount; i++) {
                    if (!processVideoData(this.mRawDataBuf[i].data, this.mRawDataBuf[i].pts)) {
                        tryUnlockSurfaceDestroyLock();
                        return;
                    }
                }
            }
            tryUnlockSurfaceDestroyLock();
        }
    }

    private void releaseDecoderStaffs() {
        if (this.mDecoder != null) {
            this.mDecoder.release();
            this.mDecoder = null;
        }
        this.mFrames = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoData(byte[] bArr, long j) {
        if ((bArr[4] & 31) == 5) {
            for (int i = 0; i < this.mRawDataCount; i++) {
                this.mRawDataBuf[i].data = null;
            }
            this.mRawDataCount = 0;
        }
        if (this.mImage == null) {
            this.mImage = new YMFImageBuffer(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, 36, false);
            this.mImage.mHardware = true;
            this.mImage.mDirectHardRender = true;
        }
        this.mDecoderListener.onDecodedFrameAvailable(this.mStreamId, this.mImage);
        if (this.mRawDataCount < 200) {
            this.mRawDataBuf[this.mRawDataCount].data = bArr;
            this.mRawDataBuf[this.mRawDataCount].pts = j;
            this.mRawDataCount++;
        }
        if (this.mDecoder != null && !this.mIsDecoderNeedReconfig) {
            tryLockSurfaceDestoryLock();
            if (!this.mSurfaceDestoryedState.get()) {
                processVideoData(bArr, j);
            }
            tryUnlockSurfaceDestroyLock();
        }
    }

    private boolean processVideoData(byte[] bArr, long j) {
        int i;
        this.mFrames++;
        if (this.mDecoder != null) {
            if (!this.mFirstFrameOut && this.mFrames <= 50) {
                if (bArr == null) {
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
                YMFLog.info(this, "[Decoder ]", "processVideoData streamId:" + this.mStreamId + ", frames:" + this.mFrames + ", type:" + i + ", len:" + (bArr == null ? 0 : bArr.length) + ", pts:" + j);
            }
            long PushFrame = this.mDecoder.PushFrame(this.mVideoSurface, bArr, null, j, false);
            if (PushFrame > 0) {
                System.currentTimeMillis();
                handleOnVideoFrameDraw(PushFrame);
            } else if (this.mDecoder.GetAndClearExceptionFlag()) {
                this.mIsDecoderNeedReconfig = true;
                this.mDecoder.EndofStream();
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndofStream() {
        this.mFirstFrameOut = false;
        this.mVideoHeaderInfo = null;
        if (this.mDecoder != null) {
            this.mDecoder.EndofStream();
        }
    }

    /* loaded from: classes6.dex */
    private static class RenderHandler extends Handler {
        private WeakReference<HardDecodeWaySimplified> mWeakWay;

        public RenderHandler(HardDecodeWaySimplified hardDecodeWaySimplified) {
            this.mWeakWay = new WeakReference<>(hardDecodeWaySimplified);
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
            HardDecodeWaySimplified hardDecodeWaySimplified = this.mWeakWay.get();
            if (hardDecodeWaySimplified != null) {
                switch (i) {
                    case 1:
                        hardDecodeWaySimplified.handleVideoSurfaceChanged((SurfaceScaleInfo) message.obj);
                        return;
                    case 2:
                        hardDecodeWaySimplified.handleVideoSurfaceDestroyed((Surface) message.obj);
                        return;
                    case 3:
                        hardDecodeWaySimplified.handleVideoSurfaceRedraw();
                        return;
                    case 4:
                        hardDecodeWaySimplified.handleGetScreenShot((ScreenShotInfo) message.obj);
                        return;
                    case 5:
                        hardDecodeWaySimplified.handleVideoConfig((VideoHeaderInfo) message.obj);
                        return;
                    case 6:
                        VideoEntities.VideoData videoData = (VideoEntities.VideoData) message.obj;
                        hardDecodeWaySimplified.handleVideoData(videoData.data, videoData.pts);
                        return;
                    case 7:
                        hardDecodeWaySimplified.handleEndofStream();
                        return;
                    case 8:
                    default:
                        return;
                    case 9:
                        hardDecodeWaySimplified.handleSetVideoInfoCallback((IVideoInfoCallback) message.obj);
                        return;
                }
            }
            YMFLog.warn(this, "[Decoder ]", "handleMessage: hardDecodeWay is null");
        }
    }

    public void handleSetVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
        this.mVideoInfoCallback = iVideoInfoCallback;
    }
}
