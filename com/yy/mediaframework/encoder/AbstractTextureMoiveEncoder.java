package com.yy.mediaframework.encoder;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.os.Build;
import android.view.WindowManager;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.GlManager;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gles.Drawable2d;
import com.yy.mediaframework.gles.FullFrameRect;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gles.IEglCore;
import com.yy.mediaframework.gles.IWindowSurface;
import com.yy.mediaframework.gles.Texture2dProgram;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.GLUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class AbstractTextureMoiveEncoder {
    private static final String TAG = "AbstractTextureMoiveEncoder";
    protected static AtomicLong sEncodeIds = new AtomicLong(1);
    protected IEglCore mEglCore;
    protected VideoLiveFilterContext mFilterContext;
    GlManager mGlManager;
    protected HardEncodeListner mHardEncoderListener;
    private Constant.EncoderInputMode mInputMode;
    private int mScreenHeight;
    private int mScreenWidth;
    protected HardSurfaceEncoder mVideoEncoderImpl = null;
    protected IWindowSurface mInputWindowSurface = null;
    protected FullFrameRect mFullScreen = null;
    VideoEncoderConfig mVideoEncoderConfig = null;
    private int mEncodeWidth = 0;
    private int mEncodeHeight = 0;
    private int mInputWidth = 0;
    private int mInputHeight = 0;
    private int mClipWidth = 0;
    private int mClipHeight = 0;
    private RectF mLastScreenCropArea = new RectF();

    public AbstractTextureMoiveEncoder(VideoLiveFilterContext videoLiveFilterContext, GlManager glManager, HardEncodeListner hardEncodeListner) {
        this.mEglCore = null;
        this.mHardEncoderListener = null;
        this.mGlManager = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mFilterContext = videoLiveFilterContext;
        this.mGlManager = glManager;
        this.mEglCore = this.mGlManager.getEglCore();
        this.mHardEncoderListener = hardEncodeListner;
        Context androidContext = this.mFilterContext.getAndroidContext();
        this.mFilterContext.getAndroidContext();
        WindowManager windowManager = (WindowManager) androidContext.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            this.mScreenWidth = point.x;
            this.mScreenHeight = point.y;
        }
    }

    public void setEncoderInputMode(Constant.EncoderInputMode encoderInputMode) {
        this.mInputMode = encoderInputMode;
    }

    public long startEncode(VideoEncoderConfig videoEncoderConfig) {
        long incrementAndGet = sEncodeIds.incrementAndGet();
        this.mVideoEncoderConfig = videoEncoderConfig;
        try {
            if (this.mVideoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264) {
                this.mVideoEncoderImpl = new H264SurfaceEncoder(incrementAndGet);
            } else {
                this.mVideoEncoderImpl = new H265SurfaceEncoder(incrementAndGet);
            }
            if (this.mVideoEncoderImpl.init(videoEncoderConfig, this.mHardEncoderListener, this.mInputMode)) {
                if (this.mInputMode == Constant.EncoderInputMode.SURFACE) {
                    this.mFullScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_WITH_EXTRA_TXT_2), Drawable2d.Prefab.FULL_RECTANGLE, GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS), GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS));
                    setEncoderFlipY();
                    this.mInputWindowSurface = this.mEglCore.createWindowSurface(this.mVideoEncoderImpl.getInputSurface(), true);
                }
                YMFLog.info(this, "[Encoder ]", "start video encoder success");
                return incrementAndGet;
            }
            YMFLog.error(this, "[Encoder ]", "videocodec init fail");
            releaseEncoder();
            return -1L;
        } catch (Throwable th) {
            releaseEncoder();
            YMFLog.error(this, "[Encoder ]", "start video encoder fail, exception: " + th.getMessage());
            return -1L;
        }
    }

    @TargetApi(8)
    public void encodeFrame(YYMediaSample yYMediaSample, int i, int i2) {
        encodeFrame(yYMediaSample, i, i2, -1, null);
    }

    public void encodeFrame(YYMediaSample yYMediaSample) {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.feedEncoder(yYMediaSample);
            onEncodedFrameFinished(yYMediaSample.mYYPtsMillions);
        }
    }

    @TargetApi(8)
    public void encodeFrame(YYMediaSample yYMediaSample, int i, int i2, int i3, FloatBuffer floatBuffer) {
        YMFLiveStatisticManager.getInstance().beginEncode(yYMediaSample.mStreamId, yYMediaSample.mYYPtsMillions);
        if (this.mFilterContext != null) {
            try {
                this.mInputWindowSurface.makeCurrent();
                GLES20.glViewport(0, 0, this.mVideoEncoderConfig.getEncodeWidth(), this.mVideoEncoderConfig.getEncodeHeight());
                GLES20.glClear(16640);
                if (yYMediaSample.mScreenCropArea != null && !yYMediaSample.mScreenCropArea.equals(this.mLastScreenCropArea)) {
                    YMFLog.info(this, "[Encoder ]", "hard-ScreenLiveSession sample.mScreenCropArea:" + yYMediaSample.mScreenCropArea);
                    this.mLastScreenCropArea.set(yYMediaSample.mScreenCropArea);
                    if (this.mEncodeWidth != yYMediaSample.mEncodeWidth && this.mEncodeHeight != yYMediaSample.mEncodeHeight) {
                        YMFLog.info(this, "[Encoder ]", "hard-ScreenLiveSession adjustTextureArea...");
                        this.mFullScreen.adjustTextureArea(yYMediaSample.mScreenCropArea, this.mScreenWidth, this.mScreenHeight, false);
                    } else {
                        YMFLog.warn(this, "[Encoder ]", "hard-screen clip ratio and encode ratio not change at the same time...");
                    }
                } else if (yYMediaSample.mScreenCropArea == null && !yYMediaSample.mUseExternalVideoFrame && checkClipRatioChanged(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight)) {
                    YMFLog.info(this, "[Encoder ]", "hard-VideoLiveSession adjustTexture...");
                    this.mFullScreen.adjustTexture(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
                }
                if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
                    flip(yYMediaSample);
                    GLUtil.updateVertexBuffer(floatBuffer, yYMediaSample.mPictureInPictureDisplayInfo);
                    this.mFullScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, floatBuffer, GlUtil.adjustDualCameraSlaveTexture(yYMediaSample, this.mFilterContext.mCameraPreviewConfig.getWidth(), this.mFilterContext.mCameraPreviewConfig.getHeight()));
                } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_NORMAL || this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_SCREEN_RECORD || this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_EXTERNAL) {
                    flip(yYMediaSample);
                    if (yYMediaSample.mUseExternalVideoFrame) {
                        this.mFullScreen.adjustVertex(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight, yYMediaSample.mExternalFrameScaleMode);
                    }
                    this.mFullScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, i, i2, -1, null, null);
                } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                    drawPeripherals(yYMediaSample);
                }
                this.mInputWindowSurface.setPresentationTime(yYMediaSample.mYYPtsMillions * 1000 * 1000);
                this.mInputWindowSurface.swapBuffers();
            } catch (Throwable th) {
                YMFLog.error(this, "[Encoder ]", "encodeFrame exception:" + th.getMessage());
            }
        }
        onEncodedFrameFinished(yYMediaSample.mYYPtsMillions);
    }

    private void drawPeripherals(YYMediaSample yYMediaSample) {
        FloatBuffer positionBuffer = this.mFilterContext.mPeripheralsPosition.getPositionBuffer(false);
        FloatBuffer flipY = GlUtil.setFlipY(this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer());
        if (this.mFilterContext.mPeripheralsPosition.fillMode == 1) {
            positionBuffer = this.mFilterContext.mPeripheralsPosition.convertPositionBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, this.mFilterContext.mPeripheralsPosition.srcWidth, this.mFilterContext.mPeripheralsPosition.srcHeight);
            flipY = this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer();
        }
        this.mFullScreen.drawFrame(this.mFilterContext.getBackgroundTextureId(), yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, positionBuffer, flipY);
        if (this.mFilterContext.mPeripheralsOrientation != 1) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            this.mFullScreen.drawFrame(this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.mCameraPostion.getDefaultVertexBuffer(), this.mFilterContext.mCameraPostion.getDefaultTextureBuffer(), yYMediaSample.mMainTransformer, -1, -1, -1, null, null, null);
            GLES20.glDisable(3042);
        }
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
        this.mFullScreen.drawFrame(yYMediaSample.mMasterTextureId, this.mFilterContext.mCameraPostion.getPositionBuffer(false), (yYMediaSample.mCameraFacing != 1 || yYMediaSample.mIsMirrorEnable) ? defaultTextureBuffer : GlUtil.setFlipX(defaultTextureBuffer), yYMediaSample.mMainTransformer, -1, -1, -1, null, null, null);
    }

    public void flip(YYMediaSample yYMediaSample) {
        resetFlip();
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
            if (yYMediaSample.mCameraFacing == 1) {
                if (yYMediaSample.mOrientation == 2) {
                    if (yYMediaSample.mOrginalCameraFacing == yYMediaSample.mCameraFacing) {
                        if (!yYMediaSample.mIsMirrorEnable) {
                            flipXMasterPicture();
                        }
                    } else if (!yYMediaSample.mIsMirrorEnable) {
                        flipXSlavePicture();
                    } else {
                        flipXScreen();
                    }
                } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    if (!yYMediaSample.mIsMirrorEnable) {
                        flipYScreenXMaster();
                    } else {
                        flipYScreen();
                    }
                } else if (!yYMediaSample.mIsMirrorEnable) {
                    flipXMasterPicture();
                }
            } else if (yYMediaSample.mOrientation == 2) {
                if (yYMediaSample.mOrginalCameraFacing == yYMediaSample.mCameraFacing) {
                    if (!yYMediaSample.mIsMirrorEnable) {
                        flipXSlavePicture();
                    }
                } else if (!yYMediaSample.mIsMirrorEnable) {
                    flipXMasterPicture();
                } else {
                    flipXScreen();
                }
            } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                if (!yYMediaSample.mIsMirrorEnable) {
                    flipYScreenXSlave();
                } else {
                    flipYScreen();
                }
            } else if (!yYMediaSample.mIsMirrorEnable) {
                flipXSlavePicture();
            }
        } else if (yYMediaSample.mCameraFacing == 1 && !yYMediaSample.mIsMirrorEnable) {
            flipXMasterPicture();
        }
    }

    private boolean checkClipRatioChanged(int i, int i2, int i3, int i4) {
        if (this.mInputWidth == i && this.mInputHeight == i2 && this.mClipWidth == i3 && this.mClipHeight == i4) {
            return false;
        }
        YMFLog.info(this, "[Encoder ]", "inputWidth:" + i + " inputHeight:" + i2 + " clipWidth:" + i3 + " clipHeight:" + i4);
        this.mInputWidth = i;
        this.mInputHeight = i2;
        this.mClipWidth = i3;
        this.mClipHeight = i4;
        return true;
    }

    public void stopEncoder() {
    }

    public void releaseEncoder() {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.drainEncoder(0L, true);
            this.mVideoEncoderImpl.deInit();
            this.mVideoEncoderImpl = null;
        }
        if (this.mInputWindowSurface != null) {
            this.mGlManager.resetContext();
            this.mInputWindowSurface.release();
            this.mInputWindowSurface = null;
        }
        if (this.mFullScreen != null) {
            this.mFullScreen.release(true);
            this.mFullScreen = null;
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.mClipWidth = 0;
        this.mClipHeight = 0;
    }

    public void resetFlip() {
        this.mFullScreen.resetFlip();
    }

    public void flipXMasterPicture() {
        this.mFullScreen.flipXMasterPicture();
    }

    public void flipXSlavePicture() {
        this.mFullScreen.flipXSlavePicture();
    }

    public void flipYScreen() {
        this.mFullScreen.flipYScreen();
    }

    public void flipYScreenXMaster() {
        this.mFullScreen.flipYScreenXMaster();
    }

    public void flipYScreenXSlave() {
        this.mFullScreen.flipYScreenXSlave();
    }

    public void flipXScreen() {
        this.mFullScreen.flipXScreen();
    }

    public void setEncoderFlipX(int i) {
        if (this.mFullScreen != null) {
            YMFLog.info(this, "[Encoder ]", "encoder setEncoderFlipX");
            this.mFullScreen.setTextureFlipX(0);
        }
    }

    private void setEncoderFlipY() {
        if (this.mFullScreen != null) {
            YMFLog.info(this, "[Encoder ]", "encoder setEncoderFlipY");
            this.mFullScreen.setTextureFlipY(0);
            this.mFullScreen.setTextureFlipY(1);
            this.mFullScreen.setTextureFlipY(2);
        }
    }

    public void adjustBitRate(int i) {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.adjustBitRate(i);
        }
    }

    public void requestSyncFrame() {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.requestSyncFrame();
        }
    }

    public void onEncodedFrameFinished(long j) {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.drainEncoder(j, false);
        }
    }

    public String getMediaFormat() {
        return this.mVideoEncoderImpl != null ? this.mVideoEncoderImpl.getFormat() : "";
    }

    public void recoverCachedPtsList(long j) {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.recoverCachedPtsList(j);
        }
    }

    public void createGlElementEnv() {
        if (this.mInputMode != Constant.EncoderInputMode.SURFACE) {
            YMFLog.info(this, "[Encoder ]", "createGlElementEnv nothing  buffer encoder ");
        } else if (this.mFilterContext.isUseYuvCapture()) {
            YMFLog.info(this, "[Encoder ]", "createGlElementEnv nothing  yuv  capture ");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.mFullScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_WITH_EXTRA_TXT_2), Drawable2d.Prefab.FULL_RECTANGLE, GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS), GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS));
            setEncoderFlipY();
            this.mInputWindowSurface = this.mEglCore.createWindowSurface(this.mVideoEncoderImpl.getInputSurface(), true);
            YMFLog.info(this, "[Encoder ]", "createGlElementEnv success, cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void destoryGlElementEnvOnly() {
        YMFLog.info(this, "[Encoder ]", "destoryGlElementEnvOnly  begin");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().getHandler().post(new Runnable() { // from class: com.yy.mediaframework.encoder.AbstractTextureMoiveEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AbstractTextureMoiveEncoder.this.mInputWindowSurface != null) {
                            AbstractTextureMoiveEncoder.this.mGlManager.resetContext();
                            AbstractTextureMoiveEncoder.this.mInputWindowSurface.release();
                            AbstractTextureMoiveEncoder.this.mInputWindowSurface = null;
                        }
                        if (AbstractTextureMoiveEncoder.this.mFullScreen != null) {
                            AbstractTextureMoiveEncoder.this.mFullScreen.release(true);
                            AbstractTextureMoiveEncoder.this.mFullScreen = null;
                        }
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        YMFLog.error(this, "[Encoder ]", "destoryGlElementEnvOnly exception:" + e.toString());
                    }
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Encoder ]", "destoryGlElementEnvOnly  .barrier.await exception:" + e.toString());
            }
        } else {
            try {
                if (this.mInputWindowSurface != null) {
                    this.mGlManager.resetContext();
                    this.mInputWindowSurface.release();
                    this.mInputWindowSurface = null;
                }
                if (this.mFullScreen != null) {
                    this.mFullScreen.release(true);
                    this.mFullScreen = null;
                }
            } catch (Exception e2) {
                YMFLog.error(this, "[Encoder ]", "releaseEncoderAsync exception:" + e2.toString());
            }
        }
        YMFLog.info(this, "[Encoder ]", "destoryGlElementEnvOnly success");
    }

    public long startEncoerAsync(VideoEncoderConfig videoEncoderConfig) {
        long incrementAndGet = sEncodeIds.incrementAndGet();
        this.mVideoEncoderConfig = videoEncoderConfig;
        try {
            if (this.mVideoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264) {
                this.mVideoEncoderImpl = new H264SurfaceEncoder(incrementAndGet);
            } else {
                this.mVideoEncoderImpl = new H265SurfaceEncoder(incrementAndGet);
            }
            if (!this.mVideoEncoderImpl.init(videoEncoderConfig, this.mHardEncoderListener, this.mInputMode)) {
                YMFLog.error(this, "[Encoder ]", "videocodec init fail");
                releaseEncoderAsync();
                return -1L;
            }
            return incrementAndGet;
        } catch (Throwable th) {
            releaseEncoderAsync();
            YMFLog.error(this, "[Encoder ]", "start video encoder exception:" + th.getMessage());
            return -1L;
        }
    }

    public void releaseEncoderAsync() {
        if (this.mVideoEncoderImpl != null) {
            this.mVideoEncoderImpl.deInit();
            this.mVideoEncoderImpl = null;
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.mClipWidth = 0;
        this.mClipHeight = 0;
        YMFLog.info(this, "[Encoder ]", "releaseEncoderAsync done");
    }

    public boolean getCacheEncodedData() {
        if (this.mVideoEncoderImpl != null) {
            return this.mVideoEncoderImpl.getCacheEncodedData();
        }
        YMFLog.info(this, "[Encoder ]", "getCacheEncodedData mVideoEncoderImpl == null!");
        return false;
    }
}
