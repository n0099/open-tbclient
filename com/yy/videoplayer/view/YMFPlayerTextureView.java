package com.yy.videoplayer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.TextureView;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.YMFEventManager;
import com.yy.videoplayer.YMFStreamManager;
import com.yy.videoplayer.decoder.HardDecodeWayBuffer;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.render.IRender;
import com.yy.videoplayer.render.YMFRender;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.GLUtil;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import com.yy.videoplayer.view.GLTextureView;
import com.yy.videoplayer.view.YMFPlayerController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class YMFPlayerTextureView extends GLTextureView implements Choreographer.FrameCallback, TextureView.SurfaceTextureListener, GLTextureView.Renderer {
    private static final int RENDER_DURATION_LIMIT_10 = 100;
    private static final int RENDER_DURATION_LIMIT_15 = 66;
    private static final int RENDER_DURATION_LIMIT_20 = 50;
    private static final int RENDER_DURATION_LIMIT_24 = 41;
    private static final int RENDER_DURATION_LIMIT_5 = 200;
    private static final String TAG = "YMFPlayerTextureView:";
    private static final String THREAD = "YMFTxView_GLThread";
    private String hash;
    private Bitmap mBackgroundBitmap;
    private IRender mBackgroundRender;
    private Choreographer mChoreographer;
    private boolean mCurrentDrawBlack;
    private int mCurrentDrawBlackTime;
    private AtomicBoolean mDrawBlackScreen;
    private int mDrawTime;
    private boolean mFirstFrameRendered;
    private AtomicBoolean mGlThreadReady;
    private boolean mHasRegisterVsync;
    private HashMap<Long, Boolean> mIgnoreStatistic;
    private HashMap<Long, Long> mIgnoreStatisticPtsMap;
    private long mLastRenderRequestTime;
    private int mNoRenderFrameNum;
    private WeakReference<YMFPlayerController.YMFPlayerControlProxy> mPlayerViewControllerProxy;
    private int mRenderMode;
    private AtomicBoolean mRenderReady;
    private HashMap<Long, Boolean> mStreamFirstFrameRenderedMap;
    private boolean mSurfaceCreated;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mTargetRenderDuration;
    private IRender mVideoRender;
    private int mViewState;
    private long mVsyncCnt;
    private long mVsyncT;
    private long minDeltaPts;

    public YMFPlayerTextureView(Context context) {
        super(context);
        this.hash = Integer.toHexString(System.identityHashCode(this));
        this.mTargetRenderDuration = 66;
        this.mVideoRender = null;
        this.mBackgroundRender = null;
        this.mSurfaceCreated = false;
        this.mRenderReady = new AtomicBoolean(false);
        this.mGlThreadReady = new AtomicBoolean(false);
        this.mDrawBlackScreen = new AtomicBoolean(false);
        this.mPlayerViewControllerProxy = null;
        this.mBackgroundBitmap = null;
        this.mFirstFrameRendered = false;
        this.mDrawTime = 0;
        this.mStreamFirstFrameRenderedMap = new HashMap<>();
        this.mCurrentDrawBlack = true;
        this.mCurrentDrawBlackTime = 0;
        this.mNoRenderFrameNum = 0;
        this.mViewState = 1;
        this.minDeltaPts = 0L;
        this.mIgnoreStatistic = new HashMap<>();
        this.mIgnoreStatisticPtsMap = new HashMap<>();
        this.mRenderMode = 0;
        this.mHasRegisterVsync = false;
        this.mLastRenderRequestTime = 0L;
        this.mVsyncT = 0L;
        this.mVsyncCnt = 0L;
        initEgl();
    }

    public YMFPlayerTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hash = Integer.toHexString(System.identityHashCode(this));
        this.mTargetRenderDuration = 66;
        this.mVideoRender = null;
        this.mBackgroundRender = null;
        this.mSurfaceCreated = false;
        this.mRenderReady = new AtomicBoolean(false);
        this.mGlThreadReady = new AtomicBoolean(false);
        this.mDrawBlackScreen = new AtomicBoolean(false);
        this.mPlayerViewControllerProxy = null;
        this.mBackgroundBitmap = null;
        this.mFirstFrameRendered = false;
        this.mDrawTime = 0;
        this.mStreamFirstFrameRenderedMap = new HashMap<>();
        this.mCurrentDrawBlack = true;
        this.mCurrentDrawBlackTime = 0;
        this.mNoRenderFrameNum = 0;
        this.mViewState = 1;
        this.minDeltaPts = 0L;
        this.mIgnoreStatistic = new HashMap<>();
        this.mIgnoreStatisticPtsMap = new HashMap<>();
        this.mRenderMode = 0;
        this.mHasRegisterVsync = false;
        this.mLastRenderRequestTime = 0L;
        this.mVsyncT = 0L;
        this.mVsyncCnt = 0L;
        initEgl();
    }

    public YMFPlayerTextureView(Context context, AttributeSet attributeSet, YMFPlayerController.YMFPlayerControlProxy yMFPlayerControlProxy) {
        super(context);
        this.hash = Integer.toHexString(System.identityHashCode(this));
        this.mTargetRenderDuration = 66;
        this.mVideoRender = null;
        this.mBackgroundRender = null;
        this.mSurfaceCreated = false;
        this.mRenderReady = new AtomicBoolean(false);
        this.mGlThreadReady = new AtomicBoolean(false);
        this.mDrawBlackScreen = new AtomicBoolean(false);
        this.mPlayerViewControllerProxy = null;
        this.mBackgroundBitmap = null;
        this.mFirstFrameRendered = false;
        this.mDrawTime = 0;
        this.mStreamFirstFrameRenderedMap = new HashMap<>();
        this.mCurrentDrawBlack = true;
        this.mCurrentDrawBlackTime = 0;
        this.mNoRenderFrameNum = 0;
        this.mViewState = 1;
        this.minDeltaPts = 0L;
        this.mIgnoreStatistic = new HashMap<>();
        this.mIgnoreStatisticPtsMap = new HashMap<>();
        this.mRenderMode = 0;
        this.mHasRegisterVsync = false;
        this.mLastRenderRequestTime = 0L;
        this.mVsyncT = 0L;
        this.mVsyncCnt = 0L;
        initEgl();
        this.mPlayerViewControllerProxy = new WeakReference<>(yMFPlayerControlProxy);
    }

    @TargetApi(16)
    private void initEgl() {
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoPlayerViewState(0, true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        setDebugFlags(1);
        setRenderer(this);
        setRenderMode(0);
        this.mGlThreadReady.set(true);
        this.mDrawBlackScreen.set(false);
        this.mChoreographer = Choreographer.getInstance();
        YMFLog.info(this, "[Render  ]", "initEgl");
        YMFPlayerUsrBehaviorStat.getInstance().notifyGlManagerState(0, true);
    }

    public void setRenderControlByChoreographer() {
        if (!this.mHasRegisterVsync) {
            this.mChoreographer.removeFrameCallback(this);
            this.mChoreographer.postFrameCallback(this);
            this.mHasRegisterVsync = true;
        }
    }

    private void notifyViewStateChange(int i) {
        if (this.mViewState != i) {
            this.mViewState = i;
            renderLock();
            if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null) {
                for (YMFRenderImage yMFRenderImage : this.mPlayerViewControllerProxy.get().getRenderImageMap().values()) {
                    if (yMFRenderImage != null && yMFRenderImage.mStreamId != 0) {
                        if (this.mViewState == 0) {
                            this.mIgnoreStatistic.put(Long.valueOf(yMFRenderImage.mStreamId), true);
                        }
                        YYVideoLibMgr.instance().onViewStateNotify(yMFRenderImage.mStreamId, this.mViewState);
                        HardDecodeWayBuffer decoderWithStreamId = YMFStreamManager.instance().getDecoderWithStreamId(yMFRenderImage.mStreamId);
                        if (decoderWithStreamId != null) {
                            decoderWithStreamId.setVideoPlayRender(true);
                        }
                    }
                }
            }
            renderUnlock();
        }
    }

    public void setIgnoreStatistic(long j) {
        this.mIgnoreStatistic.put(Long.valueOf(j), true);
    }

    @Override // com.yy.videoplayer.view.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "surfaceDestroyed start.");
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewOnSurface(0, false);
        YMFPlayerStatisticManager.getInstance().reset();
        notifyViewStateChange(1);
        renderLock();
        this.mSurfaceCreated = false;
        renderUnlock();
        super.surfaceDestroyed(surfaceTexture);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "surfaceDestroyed end. not detach");
        return true;
    }

    @Override // com.yy.videoplayer.view.GLTextureView.Renderer
    public void onSurfaceDestroyed() {
        releaseRender();
        this.mGlThreadReady.set(false);
    }

    @Override // com.yy.videoplayer.view.GLTextureView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "onSurfaceCreated .");
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerViewOnSurface(0, true);
        Thread.currentThread().setName(THREAD);
        this.mGlThreadReady.set(true);
        notifyViewStateChange(0);
    }

    @Override // com.yy.videoplayer.view.GLTextureView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        notifyViewStateChange(0);
        renderLock();
        this.mGlThreadReady.set(true);
        this.mSurfaceCreated = true;
        if (this.mHasRegisterVsync) {
            this.mChoreographer.removeFrameCallback(this);
            this.mChoreographer.postFrameCallback(this);
        }
        renderUnlock();
        if (this.mSurfaceWidth != i || this.mSurfaceHeight != i2) {
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
        }
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null) {
            this.mPlayerViewControllerProxy.get().updateVideoLayout(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        forceReDraw();
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "onSurfaceChanged width:" + i + " height:" + i2 + " now:" + TimeUtil.getTickCountLong());
    }

    public void forceReDraw() {
        if (this.mFirstFrameRendered) {
            this.mDrawTime = 0;
            setDataReDraw();
        }
        requestRender();
        requestRender();
    }

    public void release() {
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoPlayerViewState(0, false);
        YMFPlayerUsrBehaviorStat.getInstance().notifyGlManagerState(0, false);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "release finish.");
        this.mIgnoreStatistic.clear();
        this.mIgnoreStatisticPtsMap.clear();
        if (this.mBackgroundBitmap != null) {
            this.mBackgroundBitmap = null;
        }
    }

    private void releaseRender() {
        if (this.mVideoRender != null) {
            this.mVideoRender.release();
            this.mVideoRender = null;
        }
        if (this.mBackgroundRender != null) {
            this.mBackgroundRender.release();
            this.mBackgroundRender = null;
        }
        this.mBackgroundBitmap = null;
        this.mRenderReady.set(false);
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "releaseRender .");
    }

    public void postToGlThread(Runnable runnable) {
        if (this.mGlThreadReady.get()) {
            queueEvent(runnable);
        }
    }

    private void notifyRenderInfo(long j, long j2, long j3, int i, int i2, int i3, boolean z) {
        YMFEventManager.instance().notifyRenderEvnet(j, j2, j3, i, i2, TimeUtil.getTickCountLong(), i3, getVisibility(), z);
    }

    private void notifyRenderException(String str) {
        YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, "onDrawFrame Error ! " + str);
    }

    public void requestGlRender() {
        if (this.mHasRegisterVsync) {
            this.mChoreographer.removeFrameCallback(this);
        }
        this.mHasRegisterVsync = false;
        requestRender();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        renderLock();
        if (!this.mHasRegisterVsync) {
            renderUnlock();
            return;
        }
        this.mChoreographer.removeFrameCallback(this);
        this.mChoreographer.postFrameCallback(this);
        this.mHasRegisterVsync = true;
        if (j - this.mLastRenderRequestTime > 24000000 && this.mSurfaceCreated) {
            this.mVsyncCnt++;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mVsyncT > 6000) {
                this.mVsyncT = currentTimeMillis;
                YMFLog.info(this, "[Render  ]", "  in 6 seconds " + this.mVsyncCnt);
                this.mVsyncCnt = 0L;
            }
            requestRender();
            this.mLastRenderRequestTime = j;
        }
        renderUnlock();
    }

    @Override // com.yy.videoplayer.view.GLTextureView.Renderer
    public void onDrawFrame(GL10 gl10) {
        ConcurrentHashMap<Integer, YMFRenderImage> renderImageMap;
        GLUtil.checkGlError("onDrawFrame enter ");
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null && (renderImageMap = this.mPlayerViewControllerProxy.get().getRenderImageMap()) != null && renderImageMap.size() > 0) {
            try {
                renderLock();
                if (this.mSurfaceCreated) {
                    if (!this.mRenderReady.get() && this.mVideoRender == null) {
                        this.mVideoRender = new YMFRender(2);
                        this.mRenderReady.set(true);
                    }
                    gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    gl10.glClear(16384);
                    if (this.mRenderReady.get() && this.mVideoRender != null && this.mDrawBlackScreen.get()) {
                        renderUnlock();
                        return;
                    }
                    drawBackground(renderImageMap.get(0));
                    if (this.mRenderReady.get() && this.mSurfaceCreated) {
                        for (Map.Entry<Integer, YMFRenderImage> entry : renderImageMap.entrySet()) {
                            YMFRenderImage value = entry.getValue();
                            if (value != null && value.mRenderPrepared) {
                                drawVideo(gl10, value);
                            }
                        }
                    }
                }
                renderUnlock();
            } catch (Throwable th) {
                renderUnlock();
                notifyRenderException(th.getMessage() + " " + th.toString());
            }
        }
    }

    private void updateMultiRenderFps(YMFRenderImage yMFRenderImage) {
        if (yMFRenderImage != null && yMFRenderImage.mDecodeImage != null && yMFRenderImage.mVideoMode == VideoConstant.VideoViewMode.MultiMode) {
            if (this.minDeltaPts == 0) {
                this.minDeltaPts = yMFRenderImage.mDecodeImage.mDeltaPts;
            }
            if (yMFRenderImage.mDecodeImage.mDeltaPts < this.minDeltaPts) {
                this.minDeltaPts = yMFRenderImage.mDecodeImage.mDeltaPts;
            }
        }
    }

    private void drawBackground(YMFRenderImage yMFRenderImage) {
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null && yMFRenderImage != null) {
            if (this.mPlayerViewControllerProxy.get().getBackgroundBitmap() != this.mBackgroundBitmap) {
                if (this.mBackgroundRender != null) {
                    this.mBackgroundRender.release();
                    this.mBackgroundRender = null;
                }
                this.mBackgroundBitmap = this.mPlayerViewControllerProxy.get().getBackgroundBitmap();
                if (this.mBackgroundBitmap != null) {
                    if (this.mBackgroundRender == null) {
                        this.mBackgroundRender = new YMFRender(0);
                    }
                    this.mBackgroundRender.prepareInputBackgroundTexture(this.mBackgroundBitmap, yMFRenderImage.mBackGroundPosition.mWidth, yMFRenderImage.mBackGroundPosition.mHeight);
                }
            }
            if (this.mBackgroundBitmap != null && this.mBackgroundRender != null) {
                GLES20.glViewport(yMFRenderImage.mBackGroundPosition.mX, yMFRenderImage.mBackGroundPosition.mY, yMFRenderImage.mBackGroundPosition.mWidth, yMFRenderImage.mBackGroundPosition.mHeight);
                this.mBackgroundRender.render();
            }
        }
    }

    private void drawVideo(GL10 gl10, YMFRenderImage yMFRenderImage) {
        if (yMFRenderImage != null && yMFRenderImage.mDecodeImage != null) {
            if (yMFRenderImage.mVideoMode == VideoConstant.VideoViewMode.SingeMode) {
                drawNormal(gl10, yMFRenderImage);
            } else {
                drawMulti(gl10, yMFRenderImage);
                updateMultiRenderFps(yMFRenderImage);
            }
            this.mCurrentDrawBlack = false;
            this.mCurrentDrawBlackTime = 0;
            this.mNoRenderFrameNum = 0;
            GLUtil.checkGlError(this + " onDrawFrame out ");
        }
    }

    private void notifyRenderInfo(YMFRenderImage yMFRenderImage, int i) {
        boolean z;
        if (yMFRenderImage != null && yMFRenderImage.mDecodeImage.mNotifyRenderInfo && yMFRenderImage.mDecodeImage.mLastNotifyRenderInfoPts != yMFRenderImage.mDecodeImage.mPts && yMFRenderImage.mDecodeImage.mNeedRendered) {
            if (yMFRenderImage.mDecodeImage.mMultiIgnoreState) {
                this.mIgnoreStatistic.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), true);
            }
            if (this.mIgnoreStatistic.containsKey(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId))) {
                z = this.mIgnoreStatistic.get(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId)).booleanValue();
                this.mIgnoreStatisticPtsMap.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), Long.valueOf(yMFRenderImage.mDecodeImage.mPts));
            } else {
                if (this.mIgnoreStatisticPtsMap.containsKey(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId))) {
                    if (this.mIgnoreStatisticPtsMap.get(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId)).longValue() == yMFRenderImage.mDecodeImage.mPts) {
                        z = true;
                    } else {
                        this.mIgnoreStatisticPtsMap.remove(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId));
                    }
                }
                z = false;
            }
            notifyRenderInfo(yMFRenderImage.mDecodeImage.mStreamId, yMFRenderImage.mDecodeImage.mPts, yMFRenderImage.mDecodeImage.mDts, (yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1, (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1, i, !z ? yMFRenderImage.mDecodeImage.mIgnore : z);
            yMFRenderImage.mDecodeImage.mLastNotifyRenderInfoPts = yMFRenderImage.mDecodeImage.mPts;
            yMFRenderImage.mDecodeImage.mMultiIgnoreState = false;
            if (z) {
                YMFLog.info(this, "[Decoder ]", "IgnoreStat mStreamId:" + yMFRenderImage.mDecodeImage.mStreamId + " pts:" + yMFRenderImage.mDecodeImage.mPts);
                this.mIgnoreStatistic.put(Long.valueOf(yMFRenderImage.mDecodeImage.mStreamId), false);
            }
        }
    }

    private void drawBlack(GL10 gl10, YMFRenderImage yMFRenderImage) {
        if (!this.mCurrentDrawBlack) {
            if (yMFRenderImage.mVideoSize.width > 0 && yMFRenderImage.mVideoSize.height > 0) {
                gl10.glViewport(yMFRenderImage.mVideoSize.x, yMFRenderImage.mVideoSize.y, yMFRenderImage.mVideoSize.width, yMFRenderImage.mVideoSize.height);
            }
            gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl10.glClear(16384);
            int i = this.mCurrentDrawBlackTime;
            this.mCurrentDrawBlackTime = i + 1;
            if (i > 2) {
                this.mCurrentDrawBlack = true;
            }
            this.mFirstFrameRendered = false;
            YMFLog.warn(this, Constant.MEDIACODE_PLAYVIEW, "onDrawFrame mCurrentDrawBlack ");
        }
    }

    private void drawNormal(GL10 gl10, YMFRenderImage yMFRenderImage) {
        if (this.mRenderReady.get() && yMFRenderImage.mDecodeImage != null && this.mVideoRender != null && getDataArriveFlag().get()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (yMFRenderImage.mVideoSize.width > 0 && yMFRenderImage.mVideoSize.height > 0) {
                gl10.glViewport(yMFRenderImage.mVideoSize.x, yMFRenderImage.mVideoSize.y, yMFRenderImage.mVideoSize.width, yMFRenderImage.mVideoSize.height);
            } else {
                YMFLog.error(this, Constant.MEDIACODE_PLAYVIEW, " glViewport error, width:" + yMFRenderImage.mVideoSize.width + " height:" + yMFRenderImage.mVideoSize.height);
            }
            if (yMFRenderImage.mScaleMode.compareTo(VideoConstant.ScaleMode.AspectFit) == 0 || yMFRenderImage.mScaleMode.compareTo(VideoConstant.ScaleMode.Original) == 0) {
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                gl10.glClear(16384);
            }
            if (this.mVideoRender.prepareInputImageData(yMFRenderImage.mDecodeImage)) {
                if (yMFRenderImage.mDecodeImage.mWidth != (yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1 || yMFRenderImage.mDecodeImage.mHeight != (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1 || yMFRenderImage.mDecodeImage.mChangeRenderMode) {
                    this.mVideoRender.clip(yMFRenderImage.mDecodeImage.mWidth, yMFRenderImage.mDecodeImage.mHeight, yMFRenderImage.mDecodeImage.mCropLeft, yMFRenderImage.mDecodeImage.mCropRight, yMFRenderImage.mDecodeImage.mCropBottom, yMFRenderImage.mDecodeImage.mCropTop, yMFRenderImage.mDecodeImage.mClipWindow);
                }
                if (this.mVideoRender.checkUpdateMirrorMode(yMFRenderImage.mMirrorMode.compareTo(VideoConstant.MirrorMode.Enabled) == 0)) {
                    this.mVideoRender.flipHorizontal();
                }
                this.mVideoRender.render();
            }
            notifyRenderInfo(yMFRenderImage, (int) (System.currentTimeMillis() - currentTimeMillis));
            getDataArriveFlag().set(false);
            this.mFirstFrameRendered = true;
            int i = this.mDrawTime;
            this.mDrawTime = i + 1;
            if (i <= 1) {
                setDataReDraw();
                return;
            }
            return;
        }
        notifyNoFrameRenderStatistic(yMFRenderImage);
    }

    private void drawMulti(GL10 gl10, YMFRenderImage yMFRenderImage) {
        if (this.mRenderReady.get() && yMFRenderImage.mDecodeImage != null && this.mVideoRender != null && yMFRenderImage.mDecodeImage.mStreamStart) {
            if (yMFRenderImage.mVideoSize.width > 0 && yMFRenderImage.mVideoSize.height > 0) {
                gl10.glViewport(yMFRenderImage.mVideoSize.x, yMFRenderImage.mVideoSize.y, yMFRenderImage.mVideoSize.width, yMFRenderImage.mVideoSize.height);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mVideoRender.prepareInputImageData(yMFRenderImage.mDecodeImage)) {
                if (yMFRenderImage.mDecodeImage.mWidth != (yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1 || yMFRenderImage.mDecodeImage.mHeight != (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1 || yMFRenderImage.mDecodeImage.mChangeRenderMode) {
                    this.mVideoRender.clip(yMFRenderImage.mDecodeImage.mWidth, yMFRenderImage.mDecodeImage.mHeight, yMFRenderImage.mDecodeImage.mCropLeft, yMFRenderImage.mDecodeImage.mCropRight, yMFRenderImage.mDecodeImage.mCropBottom, yMFRenderImage.mDecodeImage.mCropTop, yMFRenderImage.mDecodeImage.mClipWindow);
                }
                if ((yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1 != yMFRenderImage.mDrawPosition.mWidth || (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1 != yMFRenderImage.mDrawPosition.mHeight) {
                    this.mVideoRender.clip((yMFRenderImage.mDecodeImage.mCropRight - yMFRenderImage.mDecodeImage.mCropLeft) + 1, (yMFRenderImage.mDecodeImage.mCropBottom - yMFRenderImage.mDecodeImage.mCropTop) + 1, yMFRenderImage.mDrawPosition.mWidth, yMFRenderImage.mDrawPosition.mHeight, yMFRenderImage.mScaleMode);
                }
                if (this.mVideoRender.checkUpdateMirrorMode(yMFRenderImage.mMirrorMode.compareTo(VideoConstant.MirrorMode.Enabled) == 0)) {
                    this.mVideoRender.flipHorizontal();
                }
                this.mVideoRender.render();
                this.mDrawTime++;
            }
            notifyRenderInfo(yMFRenderImage, (int) (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        notifyNoFrameRenderStatistic(yMFRenderImage);
    }

    private void notifyNoFrameRenderStatistic(YMFRenderImage yMFRenderImage) {
        if (yMFRenderImage != null) {
            int i = this.mNoRenderFrameNum;
            this.mNoRenderFrameNum = i + 1;
            if (i % 100 == 0) {
                YMFLog.warn(this, "onDrawFrame ", yMFRenderImage.mStreamId + "," + this.mRenderReady.get() + "," + getDataArriveFlag().get() + "," + this.mSurfaceCreated + "," + yMFRenderImage.mDecodeImage.mStreamStart + ",,pts:" + (yMFRenderImage.mDecodeImage == null ? 0L : yMFRenderImage.mDecodeImage.mPts) + ",  now:" + TimeUtil.getTickCountLong());
            }
        }
    }

    public void setLastFrameRenderBlack(boolean z) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "drawBlackScreen video" + z);
        this.mDrawBlackScreen.set(z);
        if (this.mRenderMode == 0 && this.mDrawBlackScreen.get()) {
            requestRender();
            requestRender();
        }
    }

    public void renderLock() {
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null) {
            this.mPlayerViewControllerProxy.get().getRenderLock().lock();
        }
    }

    public void renderUnlock() {
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null) {
            this.mPlayerViewControllerProxy.get().getRenderLock().unlock();
        }
    }

    public void setDataReDraw() {
        if (this.mPlayerViewControllerProxy != null && this.mPlayerViewControllerProxy.get() != null) {
            this.mPlayerViewControllerProxy.get().setDataArriveFlag();
        }
    }

    public AtomicBoolean getDataArriveFlag() {
        return (this.mPlayerViewControllerProxy == null || this.mPlayerViewControllerProxy.get() == null) ? new AtomicBoolean(false) : this.mPlayerViewControllerProxy.get().getDataArriveFlag();
    }
}
