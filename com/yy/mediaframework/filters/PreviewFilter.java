package com.yy.mediaframework.filters;

import android.opengl.GLES20;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.gles.Drawable2d;
import com.yy.mediaframework.gles.EglFactory;
import com.yy.mediaframework.gles.FullFrameRect;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gles.IWindowSurface;
import com.yy.mediaframework.gles.Texture2dProgram;
import com.yy.mediaframework.model.AbstractSurfaceInfo;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.GLUtil;
import com.yy.mediaframework.utils.VideoEntities;
import com.yy.mediaframework.utils.VideoSizeUtils;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class PreviewFilter extends AbstractYYMediaFilter {
    private static final String TAG = "PreviewFilter";
    private VideoLiveFilterContext mFilterContext;
    private ScreenShotFilter mScreenShotFilter;
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private boolean mLastMirrorFlag = true;
    private boolean mFirstFrameRenderd = false;
    private AbstractSurfaceInfo mSurfaceInfo = null;
    private Constant.ScaleMode mScaleMode = Constant.ScaleMode.AspectFill;
    private IWindowSurface mPreviewWindowSurface = null;
    private FullFrameRect mPreviewScreen = null;
    private VideoEntities.VideoSizes mVideoSizes = new VideoEntities.VideoSizes();
    private int mViewPortX = 0;
    private int mViewPortY = 0;
    private int mViewPortW = 0;
    private int mViewPortH = 0;
    private int mClearCount = 0;
    private long feedFrameCounter = 0;
    private long feedCurrentTime = 0;
    private long lastRenderTime = 0;
    private boolean hasCatchException = false;
    private int mInputWidth = 0;
    private int mInputHeight = 0;
    private int mClipWidth = 0;
    private int mClipHeight = 0;
    private YYMediaSample mSample = new YYMediaSample();
    private AtomicBoolean mDrawBlackScreen = new AtomicBoolean(false);
    private boolean mCurrentDrawBlack = true;
    private boolean mVideoPreviewStatusFlag = true;

    public PreviewFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
        this.mScreenShotFilter = new ScreenShotFilter(videoLiveFilterContext);
    }

    public void init(int i, int i2) {
        if (this.mInited.get()) {
            YMFLog.info(this, "[Preview ]", "Init previewFilter: intialized state now, so return");
            return;
        }
        YMFLog.info(this, "[Preview ]", "Init PreviewFilter begin.");
        this.mPreviewScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_WITH_EXTRA_TXT_2), Drawable2d.Prefab.FULL_RECTANGLE, GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS), GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS));
        setPreviewFlipY();
        setOutputSize(i, i2);
        this.mInited.set(true);
        YMFLog.info(this, "[Preview ]", "Init PreviewFilter done.");
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        if (!this.mInited.getAndSet(false)) {
            YMFLog.info(this, "[Preview ]", "DeInit PreviewFilter: no Initialied state now, so return");
            return;
        }
        YMFLog.info(this, "[Preview ]", "DeInit PreviewFilter");
        releasePreviewStaffs();
        if (this.mPreviewScreen != null) {
            this.mPreviewScreen.release(true);
            this.mPreviewScreen = null;
            this.mInputWidth = 0;
            this.mInputHeight = 0;
            this.mClipWidth = 0;
            this.mClipHeight = 0;
        }
        if (this.mScreenShotFilter != null) {
            this.mScreenShotFilter.deInit();
        }
    }

    public void reSetPreviewState() {
        this.mFirstFrameRenderd = false;
    }

    private void checkVideoSize() {
        if (this.mImageWidth != this.mVideoSizes.mVideoWidth || this.mImageHeight != this.mVideoSizes.mVideoHeight) {
            this.mVideoSizes.mVideoHeight = this.mImageHeight;
            this.mVideoSizes.mVideoWidth = this.mImageWidth;
            updateVideoPosition();
        }
    }

    public void setScaleMode(Constant.ScaleMode scaleMode) {
        this.mScaleMode = scaleMode;
        YMFLog.info(this, "[Preview ]", "PreviewFilter setScaleMode:" + scaleMode);
        updateVideoPosition();
    }

    public void drawBlackScreen(boolean z) {
        YMFLog.info(this, "[Preview ]", "drawBlackScreen " + z);
        this.mDrawBlackScreen.set(z);
        if (Thread.currentThread().getId() == this.mFilterContext.getGlManager().getThreadId()) {
            handleDrawBlackScreen();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.PreviewFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    PreviewFilter.this.handleDrawBlackScreen();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDrawBlackScreen() {
        if (this.mDrawBlackScreen.get()) {
            this.mFilterContext.mSurfaceDestoryStateLock.lock();
            if (this.mPreviewWindowSurface != null && !this.mFilterContext.mSurfaceDestoryState.get()) {
                try {
                    this.mPreviewWindowSurface.makeCurrent();
                    if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                        GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight);
                    } else {
                        GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mViewWidth, this.mVideoSizes.mViewHeight);
                    }
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    this.mPreviewWindowSurface.swapBuffers();
                    this.mCurrentDrawBlack = true;
                } catch (Throwable th) {
                    YMFLog.error(this, "[Preview ]", "handleDrawBlackScreen:" + th.getMessage());
                    this.mFilterContext.mSurfaceDestoryStateLock.unlock();
                    releasePreviewStaffs();
                    return;
                }
            }
            this.mFilterContext.mSurfaceDestoryStateLock.unlock();
            this.mVideoPreviewStatusFlag = true;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mInited.get()) {
            this.mSample.assigne(yYMediaSample);
            yYMediaSample.addRef();
            if (checkImageSizeUpdated(yYMediaSample.mClipWidth, yYMediaSample.mClipHeight, true)) {
                checkVideoSize();
            }
            if (this.mScreenShotFilter != null) {
                this.mScreenShotFilter.init(yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
            }
            if (this.mFilterContext != null) {
                if (this.mCurrentDrawBlack && this.mDrawBlackScreen.get()) {
                    yYMediaSample.decRef();
                    yYMediaSample.decRef();
                } else {
                    this.mFilterContext.mSurfaceDestoryStateLock.lock();
                    if (this.mPreviewWindowSurface != null && !this.mFilterContext.mSurfaceDestoryState.get()) {
                        try {
                            this.mFilterContext.mViewState = 0;
                            this.mPreviewWindowSurface.makeCurrent();
                            drawVideo(yYMediaSample, true);
                            if (!this.mFirstFrameRenderd) {
                                YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameRendered();
                                this.mFirstFrameRenderd = true;
                            }
                            if (this.mFilterContext.mDeliverCallback != null && this.mVideoPreviewStatusFlag) {
                                this.mFilterContext.mDeliverCallback.onRenderFirstFrame();
                                this.mVideoPreviewStatusFlag = false;
                            }
                            this.mPreviewWindowSurface.swapBuffers();
                            this.mCurrentDrawBlack = false;
                            if (!this.hasCatchException) {
                                this.feedFrameCounter++;
                                this.feedCurrentTime = System.currentTimeMillis();
                                if (this.feedCurrentTime - this.lastRenderTime >= 1000) {
                                    VideoDataStat.getInstance().setPreviewFrameRate(this.feedFrameCounter);
                                    this.lastRenderTime = this.feedCurrentTime;
                                    this.feedFrameCounter = 0L;
                                }
                            }
                        } catch (Throwable th) {
                            YMFLog.error(this, "[Preview ]", "processMediaSample exception:" + th.getMessage());
                            this.mFilterContext.mSurfaceDestoryStateLock.unlock();
                            this.hasCatchException = true;
                            releasePreviewStaffs();
                            yYMediaSample.decRef();
                        }
                    } else {
                        this.mFilterContext.mViewState = 4;
                    }
                }
            }
            this.mFilterContext.mSurfaceDestoryStateLock.unlock();
            addDownStream(this.mScreenShotFilter);
            if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_EXTERNAL) {
                yYMediaSample.decRef();
            } else {
                deliverToDownStream(yYMediaSample);
                yYMediaSample.decRef();
            }
        }
        return false;
    }

    public void drawVideo(YYMediaSample yYMediaSample, boolean z) {
        if (z) {
            if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight);
            } else {
                GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mViewWidth, this.mVideoSizes.mViewHeight);
            }
        } else {
            GLES20.glViewport(0, 0, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (checkClipRatioChanged(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight)) {
            YMFLog.info(this, "[Preview ]", "VideoSize X:" + this.mVideoSizes.mViewX + " Y:" + this.mVideoSizes.mViewY + " width:" + this.mVideoSizes.mViewWidth + " height:" + this.mVideoSizes.mViewHeight);
            YMFLog.info(this, "[Preview ]", "sample width:" + yYMediaSample.mWidth + " height:" + yYMediaSample.mHeight + " clip width:" + yYMediaSample.mClipWidth + " clip height:" + yYMediaSample.mClipHeight);
            YMFLog.warn(this, "[Preview ]", "adjustTexture preview..");
            this.mPreviewScreen.adjustTexture(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
        }
        this.mPreviewScreen.resetFlip();
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
            GLUtil.updateVertexBuffer(this.mSlaveVertexBuffer, yYMediaSample.mPictureInPictureDisplayInfo);
            flip(yYMediaSample, z);
            this.mPreviewScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, this.mSlaveVertexBuffer, GlUtil.adjustDualCameraSlaveTexture(yYMediaSample, this.mFilterContext.mCameraPreviewConfig.getWidth(), this.mFilterContext.mCameraPreviewConfig.getHeight()));
        } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
            drawPeripherals(yYMediaSample);
        } else {
            flip(yYMediaSample, z);
            this.mPreviewScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, (float[]) null, (FloatBuffer) null, z ? false : true);
        }
    }

    private void drawPeripherals(YYMediaSample yYMediaSample) {
        FloatBuffer positionBuffer = this.mFilterContext.mPeripheralsPosition.getPositionBuffer(false);
        FloatBuffer flipY = GlUtil.setFlipY(this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer());
        if (this.mFilterContext.mPeripheralsPosition.fillMode == 1) {
            positionBuffer = this.mFilterContext.mPeripheralsPosition.convertPositionBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, this.mFilterContext.mPeripheralsPosition.srcWidth, this.mFilterContext.mPeripheralsPosition.srcHeight);
            flipY = this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer();
        }
        this.mPreviewScreen.drawFrame(this.mFilterContext.getBackgroundTextureId(), yYMediaSample.mMainTransformer, -1, this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, positionBuffer, flipY);
        FloatBuffer defaultTextureBuffer = this.mFilterContext.mCameraPostion.getDefaultTextureBuffer();
        if (this.mFilterContext.mCameraPostion.fillMode == 2) {
            int i = 1;
            int i2 = 1;
            if (this.mFilterContext.mCameraPostion.dstWidth != 0 && this.mFilterContext.mCameraPostion.dstHeight != 0) {
                i = this.mFilterContext.mCameraPostion.dstWidth;
                i2 = this.mFilterContext.mCameraPostion.dstHeight;
            }
            defaultTextureBuffer = GlUtil.setFlipY(this.mFilterContext.mCameraPostion.convertTextureBuffer(i, i2, this.mFilterContext.mCameraPostion.srcWidth, this.mFilterContext.mCameraPostion.srcHeight));
        }
        this.mPreviewScreen.drawFrame(yYMediaSample.mMasterTextureId, this.mFilterContext.mCameraPostion.getPositionBuffer(false), defaultTextureBuffer, yYMediaSample.mMainTransformer, -1, -1, -1, null, null, null, false);
    }

    public void flip(YYMediaSample yYMediaSample, boolean z) {
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
            this.mPreviewScreen.resetFlip();
            if (yYMediaSample.mCameraFacing == 1) {
                if (yYMediaSample.mOrientation == 2) {
                    if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                        this.mPreviewScreen.flipXScreen();
                    }
                } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    this.mPreviewScreen.flipYScreen();
                }
            } else if (yYMediaSample.mOrientation == 2) {
                if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    this.mPreviewScreen.flipXScreen();
                }
            } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                this.mPreviewScreen.flipYScreen();
            }
        } else if (yYMediaSample.mCameraFacing == 1) {
            if (!yYMediaSample.mIsPreviewMirrorEnable) {
                this.mPreviewScreen.flipXMasterPicture();
            }
            if (!z) {
                if (!yYMediaSample.mIsPreviewMirrorEnable) {
                    this.mPreviewScreen.flipXYScreen(false);
                } else {
                    this.mPreviewScreen.flipYScreen(true);
                }
            }
        } else {
            this.mPreviewScreen.resetFlip();
            if (!z) {
                this.mPreviewScreen.flipYScreen(false);
            }
        }
    }

    public void flip(YYMediaSample yYMediaSample) {
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
            this.mPreviewScreen.resetFlip();
            if (yYMediaSample.mCameraFacing == 1) {
                if (yYMediaSample.mOrientation == 2) {
                    if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                        this.mPreviewScreen.flipXScreen();
                    }
                } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    this.mPreviewScreen.flipYScreen();
                }
            } else if (yYMediaSample.mOrientation == 2) {
                if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    this.mPreviewScreen.flipXScreen();
                }
            } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                this.mPreviewScreen.flipYScreen();
            }
        } else if (yYMediaSample.mCameraFacing == 1) {
            if (!yYMediaSample.mIsPreviewMirrorEnable) {
                this.mPreviewScreen.flipXMasterPicture();
            }
        } else {
            this.mPreviewScreen.resetFlip();
        }
    }

    private boolean checkClipRatioChanged(int i, int i2, int i3, int i4) {
        if (this.mInputWidth == i && this.mInputHeight == i2 && this.mClipWidth == i3 && this.mClipHeight == i4) {
            return false;
        }
        YMFLog.info(this, "[Preview ]", "checkClipRatioChanged inputWidth:" + i + " inputHeight:" + i2 + " clipWidth:" + i3 + " clipHeight:" + i4);
        this.mInputWidth = i;
        this.mInputHeight = i2;
        this.mClipWidth = i3;
        this.mClipHeight = i4;
        return true;
    }

    private void setPreviewFlipY() {
        if (this.mPreviewScreen != null) {
            YMFLog.info(TAG, "[Preview ]", "preview setPreviewFlipY");
            this.mPreviewScreen.setTextureFlipY(0);
            this.mPreviewScreen.setTextureFlipY(1);
            this.mPreviewScreen.setTextureFlipY(2);
        }
    }

    private void releasePreviewStaffs() {
        if (this.mFilterContext != null) {
            this.mFilterContext.mSurfaceDestoryStateLock.lock();
            if (this.mPreviewWindowSurface != null) {
                this.mFilterContext.getGlManager().resetContext();
                this.mPreviewWindowSurface.release();
                this.mPreviewWindowSurface = null;
                YMFLog.info(this, "[Preview ]", "release prview window surface!!");
            }
            this.mFilterContext.mSurfaceDestoryStateLock.unlock();
        }
    }

    private void updateVideoPosition() {
        VideoSizeUtils.Size CalcFitSize = VideoSizeUtils.CalcFitSize(this.mVideoSizes.mVideoWidth, this.mVideoSizes.mVideoHeight, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight, this.mScaleMode);
        this.mVideoSizes.mViewX = CalcFitSize.x;
        this.mVideoSizes.mViewY = CalcFitSize.y;
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
            this.mVideoSizes.mViewY = 0;
        }
        this.mVideoSizes.mViewWidth = CalcFitSize.width;
        this.mVideoSizes.mViewHeight = CalcFitSize.height;
        YMFLog.info(this, "[Preview ]", "updateVideoPosition surfaceWidth:" + this.mVideoSizes.mVideoSurfaceWidth + " surfaceHeight:" + this.mVideoSizes.mVideoSurfaceHeight);
        YMFLog.info(this, "[Preview ]", "updateVideoPosition, View.x:" + this.mVideoSizes.mViewX + " View.y:" + this.mVideoSizes.mViewY + " ViewWidth:" + this.mVideoSizes.mViewWidth + " ViewHeight:" + this.mVideoSizes.mViewHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSurfaceChanged(AbstractSurfaceInfo abstractSurfaceInfo) {
        try {
            releasePreviewStaffs();
            this.mSurfaceInfo = abstractSurfaceInfo;
            this.mPreviewWindowSurface = EglFactory.newWindowSurface(this.mFilterContext.getGlManager().getEglCore(), this.mSurfaceInfo, false);
            this.mVideoSizes.mVideoSurfaceWidth = abstractSurfaceInfo.mWidth;
            this.mVideoSizes.mVideoSurfaceHeight = abstractSurfaceInfo.mHeight;
            YMFLog.info(this, "[Preview ]", "create preview window surface!!");
            updateVideoPosition();
        } catch (Throwable th) {
            YMFLog.error(this, "[Preview ]", "handleSurfaceChanged exception:" + th.getMessage());
        }
    }

    public void setSurfaceChanged(int i, int i2) {
        this.mVideoSizes.mVideoSurfaceWidth = i;
        this.mVideoSizes.mVideoSurfaceHeight = i2;
        updateVideoPosition();
        if (this.mFilterContext != null) {
            this.mFilterContext.mSurfaceDestoryStateLock.lock();
            for (int i3 = 0; i3 < 2; i3++) {
                GLES20.glClear(16640);
                if (this.mPreviewWindowSurface != null && !this.mFilterContext.mSurfaceDestoryState.get()) {
                    try {
                        this.mPreviewWindowSurface.makeCurrent();
                        GLES20.glViewport(this.mVideoSizes.mViewX, this.mVideoSizes.mViewY, this.mVideoSizes.mVideoSurfaceWidth, this.mVideoSizes.mVideoSurfaceHeight);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                        GLES20.glClear(16640);
                        if (checkClipRatioChanged(this.mSample.mWidth, this.mSample.mHeight, this.mSample.mClipWidth, this.mSample.mClipHeight)) {
                            YMFLog.warn(this, "[Preview ]", "setSurfaceChanged adjustTexture preview..");
                            this.mPreviewScreen.adjustTexture(this.mSample.mWidth, this.mSample.mHeight, this.mSample.mClipWidth, this.mSample.mClipHeight);
                        }
                        YMFLog.info(this, "[Preview ]", "setSurfaceChanged VideoSize X:" + this.mVideoSizes.mViewX + " Y:" + this.mVideoSizes.mViewY + " width:" + this.mVideoSizes.mVideoSurfaceWidth + " height:" + this.mVideoSizes.mVideoSurfaceHeight);
                        YMFLog.info(this, "[Preview ]", "setSurfaceChanged sample width:" + this.mSample.mWidth + " height:" + this.mSample.mHeight + " clip width:" + this.mSample.mClipWidth + " clip height:" + this.mSample.mClipHeight);
                        this.mPreviewScreen.resetFlip();
                        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
                            GLUtil.updateVertexBuffer(this.mSlaveVertexBuffer, this.mSample.mPictureInPictureDisplayInfo);
                            flip(this.mSample);
                            this.mPreviewScreen.drawFrame(this.mSample.mMasterTextureId, this.mSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), this.mSample.mSlaveTextureId, this.mSample.mSlaveTransformer, this.mSlaveVertexBuffer, GlUtil.adjustDualCameraSlaveTexture(this.mSample, this.mFilterContext.mCameraPreviewConfig.getWidth(), this.mFilterContext.mCameraPreviewConfig.getHeight()));
                        } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                            drawPeripherals(this.mSample);
                        } else {
                            this.mPreviewScreen.drawFrame(this.mSample.mMasterTextureId, this.mSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), this.mSample.mSlaveTextureId, null, null);
                        }
                        this.mPreviewWindowSurface.swapBuffers();
                        YMFLog.info(this, "[Preview ]", "setSurfaceChanged preview draw frame OK just in arena model");
                    } catch (Throwable th) {
                        YMFLog.error(this, "[Preview ]", "setSurfaceChanged exception:" + th.toString());
                        this.mFilterContext.mSurfaceDestoryStateLock.unlock();
                        releasePreviewStaffs();
                    }
                }
            }
            this.mFilterContext.mSurfaceDestoryStateLock.unlock();
        }
    }

    public void onSurfaceChanged(final AbstractSurfaceInfo abstractSurfaceInfo) {
        YMFLog.info(this, "[Preview ]", "onSurfaceChanged change, width:" + abstractSurfaceInfo.mWidth + " height:" + abstractSurfaceInfo.mHeight);
        if (Thread.currentThread().getId() == this.mFilterContext.getGlManager().getThreadId()) {
            handleSurfaceChanged(abstractSurfaceInfo);
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.PreviewFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    PreviewFilter.this.handleSurfaceChanged(abstractSurfaceInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSurfaceDestroy() {
        releasePreviewStaffs();
        this.mSurfaceInfo = null;
    }

    public void onSurfaceDestroy() {
        YMFLog.info(this, "[Preview ]", "onSurfaceDestroy...");
        if (Thread.currentThread().getId() == this.mFilterContext.getGlManager().getThreadId()) {
            handleSurfaceDestroy();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.PreviewFilter.3
                @Override // java.lang.Runnable
                public void run() {
                    PreviewFilter.this.handleSurfaceDestroy();
                }
            });
        }
    }
}
