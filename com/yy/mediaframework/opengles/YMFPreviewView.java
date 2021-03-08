package com.yy.mediaframework.opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.baidu.fsg.face.base.b.c;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.CameraUtils;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.VideoSizeUtils;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import com.yy.mediaframework.watermark.WaterMarkTexture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class YMFPreviewView extends GLSurfaceView implements GLSurfaceView.Renderer, SurfaceHolder.Callback, IMediaFilter, VideoLiveFilterContext.waterMarkUpdate {
    private static final String TAG = "YMFPreviewView";
    private long feedCurrentTime;
    private long feedFrameCounter;
    private long lastRenderTime;
    private int mCameraFacing;
    private int mClipHeight;
    private int mClipWidth;
    private AtomicBoolean mDataArrive;
    private AtomicBoolean mDrawBlockFrame;
    private boolean mEncodeMirror;
    private VideoLiveFilterContext mFilterContext;
    private boolean mFirstFrameRenderd;
    private int mImageYuvFormat;
    private AtomicBoolean mInited;
    private boolean mPreviewMirror;
    private IRender mRender;
    private ReentrantLock mRenderLock;
    private Constant.ScaleMode mScaleMode;
    private VideoSizeUtils.Size mSize;
    private boolean mSurfaceCreated;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private YMFImageBuffer mVideoFrame;
    private int mVideoHeight;
    private int mVideoWidth;
    private YMFTexture mWaterMarkInputTexture;
    private WaterMarkTexture mWaterMarkTexture;

    public YMFPreviewView(Context context) {
        super(context);
        this.mSurfaceCreated = false;
        this.mPreviewMirror = false;
        this.mEncodeMirror = true;
        this.mRender = null;
        this.mVideoFrame = null;
        this.mWaterMarkInputTexture = null;
        this.mWaterMarkTexture = null;
        this.mSize = new VideoSizeUtils.Size();
        this.mRenderLock = new ReentrantLock(true);
        this.mInited = new AtomicBoolean(false);
        this.mDataArrive = new AtomicBoolean(false);
        this.mScaleMode = Constant.ScaleMode.AspectFit;
        this.mFirstFrameRenderd = false;
        this.mDrawBlockFrame = new AtomicBoolean(false);
        this.mCameraFacing = -1;
        this.feedFrameCounter = 0L;
        this.feedCurrentTime = 0L;
        this.lastRenderTime = 0L;
        init();
    }

    public void drawBlackScreen(boolean z) {
        this.mDrawBlockFrame.set(z);
        YMFLog.info(this, TAG, " drawBlackScreen " + z);
    }

    public YMFPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSurfaceCreated = false;
        this.mPreviewMirror = false;
        this.mEncodeMirror = true;
        this.mRender = null;
        this.mVideoFrame = null;
        this.mWaterMarkInputTexture = null;
        this.mWaterMarkTexture = null;
        this.mSize = new VideoSizeUtils.Size();
        this.mRenderLock = new ReentrantLock(true);
        this.mInited = new AtomicBoolean(false);
        this.mDataArrive = new AtomicBoolean(false);
        this.mScaleMode = Constant.ScaleMode.AspectFit;
        this.mFirstFrameRenderd = false;
        this.mDrawBlockFrame = new AtomicBoolean(false);
        this.mCameraFacing = -1;
        this.feedFrameCounter = 0L;
        this.feedCurrentTime = 0L;
        this.lastRenderTime = 0L;
        init();
    }

    public void reSetPreviewState() {
        this.mFirstFrameRenderd = false;
    }

    private void init() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new ConfigChooser(5, 6, 5, 0, 0, 0));
        setRenderer(this);
        setRenderMode(0);
        getHolder().addCallback(this);
        YMFLog.info(this, "[Preview ]", "init finish.");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed start.");
        this.mRenderLock.lock();
        this.mSurfaceCreated = false;
        this.mRenderLock.unlock();
        postToGlThread(new Runnable() { // from class: com.yy.mediaframework.opengles.YMFPreviewView.1
            @Override // java.lang.Runnable
            public void run() {
                YMFPreviewView.this.releaseRender();
                YMFPreviewView.this.destroyWaterMark();
            }
        });
        super.surfaceDestroyed(surfaceHolder);
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed done.");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        YMFLog.info(this, "[Preview ]", "onSurfaceCreated .");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.mRenderLock.lock();
        this.mSurfaceCreated = true;
        if (this.mSurfaceWidth != i || this.mSurfaceHeight != i2) {
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            updateDrawPosition();
        }
        YMFLog.info(this, "[Preview ]", "onSurfaceChanged width:" + i + " height:" + i2);
        this.mRenderLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseRender() {
        if (this.mRender != null) {
            this.mRender.release();
            this.mRender = null;
        }
        this.mInited.set(false);
        YMFLog.info(this, "[Preview ]", "releaseRender.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFlipHorizontal(boolean z) {
        if (this.mRender != null) {
            this.mRender.flipReset();
            this.mRender.flipResetWater();
            this.mRender.flipVertical();
            this.mRender.flipVerticalWater();
            if (z) {
                this.mRender.flipHorizontal();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean createRender(int i, int i2, int i3, boolean z, boolean z2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        this.mRender = new YMFRender(YMFRender.imageFormatToProgramType(i3));
        if (z2) {
            setFlipHorizontal(z);
        } else {
            setFlipHorizontal(false);
        }
        YMFLog.info(this, "[Preview ]", "initRender width:" + i + " height:" + i2 + " format:" + ImageUtil.getImageFormatName(i3) + " mirror:" + z);
        return true;
    }

    public void postToGlThread(Runnable runnable) {
        queueEvent(runnable);
    }

    public void setVideoFilterContext(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyWaterMark() {
        if (this.mWaterMarkTexture != null) {
            this.mWaterMarkTexture.destroy();
            this.mWaterMarkTexture = null;
        }
        if (this.mWaterMarkInputTexture != null) {
            this.mWaterMarkInputTexture.release();
            this.mWaterMarkInputTexture = null;
        }
    }

    @Override // com.yy.mediaframework.filters.VideoLiveFilterContext.waterMarkUpdate
    public void onWaterMarkUpdate(final WaterMark waterMark) {
        postToGlThread(new Runnable() { // from class: com.yy.mediaframework.opengles.YMFPreviewView.2
            @Override // java.lang.Runnable
            public void run() {
                YMFPreviewView.this.destroyWaterMark();
                if (waterMark != null) {
                    YMFPreviewView.this.mWaterMarkTexture = new WaterMarkTexture(waterMark);
                    YMFPreviewView.this.mWaterMarkInputTexture = new YMFTexture(YMFPreviewView.this.mWaterMarkTexture.mWaterMarkTextureId, 3553, YMFPreviewView.this.mWaterMarkTexture.mWatermarkWidth, YMFPreviewView.this.mWaterMarkTexture.mWatermarkHeight, 6408, 33985);
                }
                YMFLog.info(this, "[Preview ]", "set water marker:" + (waterMark == null ? "disable" : c.l));
            }
        });
    }

    private void prepareWaterMark() {
        if (this.mWaterMarkInputTexture != null) {
            this.mRender.prepareWaterTexture(this.mWaterMarkInputTexture);
        } else {
            this.mRender.prepareWaterTexture(null);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        this.mRenderLock.lock();
        GlUtil.checkGlError(" onDrawFrame enter ");
        if (this.mInited.get() && this.mVideoFrame != null && this.mRender != null && this.mDataArrive.get()) {
            gl10.glViewport(this.mSize.x, this.mSize.y, this.mSize.width, this.mSize.height);
            if (this.mScaleMode.compareTo(Constant.ScaleMode.AspectFit) == 0) {
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                gl10.glClear(16384);
            }
            if (this.mDrawBlockFrame.get()) {
                this.mRenderLock.unlock();
                return;
            }
            if (this.mRender.prepareInputImageData(this.mVideoFrame)) {
                prepareWaterMark();
                this.mRender.render();
                if (this.mFilterContext.mDeliverCallback != null && !this.mFirstFrameRenderd) {
                    this.mFilterContext.mDeliverCallback.onRenderFirstFrame();
                    this.mFirstFrameRenderd = true;
                }
                this.feedFrameCounter++;
                this.feedCurrentTime = System.currentTimeMillis();
                if (this.feedCurrentTime - this.lastRenderTime >= 1000) {
                    VideoDataStat.getInstance().setPreviewFrameRate(this.feedFrameCounter);
                    this.lastRenderTime = this.feedCurrentTime;
                    this.feedFrameCounter = 0L;
                }
            }
            this.mDataArrive.set(false);
        }
        GlUtil.checkGlError(" onDrawFrame out ");
        this.mRenderLock.unlock();
    }

    private void updateDrawPosition() {
        this.mSize = VideoSizeUtils.CalcFitSize(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight, this.mScaleMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDrawPositionByClip() {
        this.mSize = VideoSizeUtils.CalcFitSize(this.mClipWidth, this.mClipHeight, this.mSurfaceWidth, this.mSurfaceHeight, this.mScaleMode);
    }

    public YMFImageBuffer selectDataSource(YYMediaSample yYMediaSample) {
        switch (yYMediaSample.mImageFormat) {
            case 0:
                return yYMediaSample.mNV21;
            case 1:
                return yYMediaSample.mNV12;
            case 2:
                return yYMediaSample.mI420;
            case 3:
                return yYMediaSample.mYV12;
            case 36:
                return yYMediaSample.mRGBA;
            default:
                return null;
        }
    }

    private boolean checkFromat(int i) {
        return i == 1 || i == 2 || i == 0 || i == 3 || i == 36;
    }

    private boolean checkRenderUpdate(int i, int i2, int i3) {
        return (this.mInited.get() && this.mRender != null && this.mVideoFrame != null && i3 == this.mImageYuvFormat && this.mVideoWidth == i && this.mVideoHeight == i2) ? false : true;
    }

    private boolean checkMirrorUpdate(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mIsMirrorEnable == this.mEncodeMirror && yYMediaSample.mIsPreviewMirrorEnable == this.mPreviewMirror && this.mCameraFacing == yYMediaSample.mCameraFacing) {
            return false;
        }
        if (yYMediaSample.mCameraFacing == CameraUtils.CameraFacing.FacingFront.ordinal()) {
            this.mEncodeMirror = yYMediaSample.mIsMirrorEnable;
            this.mPreviewMirror = yYMediaSample.mIsPreviewMirrorEnable;
            this.mCameraFacing = yYMediaSample.mCameraFacing;
        } else {
            this.mEncodeMirror = false;
            this.mPreviewMirror = false;
            this.mCameraFacing = yYMediaSample.mCameraFacing;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareVideoFrame(int i, int i2, int i3) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mImageYuvFormat = i3;
        this.mVideoFrame = new YMFImageBuffer(this.mVideoWidth, this.mVideoHeight, i3, true);
        this.mDataArrive.set(false);
        updateDrawPosition();
    }

    public void setScaleMode(Constant.ScaleMode scaleMode) {
        this.mScaleMode = scaleMode;
        updateDrawPosition();
    }

    private void updateRender(YYMediaSample yYMediaSample, final int i, final int i2, final int i3) {
        final boolean checkRenderUpdate = checkRenderUpdate(i, i2, i3);
        final boolean checkMirrorUpdate = checkMirrorUpdate(yYMediaSample);
        boolean z = yYMediaSample.mIsPreviewMirrorEnable != yYMediaSample.mDataMirror;
        final boolean z2 = yYMediaSample.mCameraFacing == 1;
        final boolean z3 = (checkMirrorUpdate && yYMediaSample.mCameraFacing == 0) ? false : z;
        if (checkRenderUpdate || checkMirrorUpdate) {
            postToGlThread(new Runnable() { // from class: com.yy.mediaframework.opengles.YMFPreviewView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (checkRenderUpdate) {
                        YMFPreviewView.this.releaseRender();
                        if (i != YMFPreviewView.this.mVideoWidth || i2 != YMFPreviewView.this.mVideoHeight || i3 != YMFPreviewView.this.mImageYuvFormat) {
                            YMFPreviewView.this.prepareVideoFrame(i, i2, i3);
                        }
                        if (!YMFPreviewView.this.mInited.get() && YMFPreviewView.this.mSurfaceCreated && YMFPreviewView.this.createRender(YMFPreviewView.this.mVideoWidth, YMFPreviewView.this.mVideoHeight, YMFPreviewView.this.mImageYuvFormat, z3, z2)) {
                            YMFPreviewView.this.mInited.set(true);
                        }
                    }
                    if (checkMirrorUpdate && YMFPreviewView.this.mRender != null) {
                        YMFLog.info(this, "[Preview ]", "mirror update:" + YMFPreviewView.this.mPreviewMirror + " -> " + z3);
                        YMFPreviewView.this.setFlipHorizontal(z3);
                    }
                }
            });
        }
    }

    private void updateClipInfo(YYMediaSample yYMediaSample) {
        if (this.mClipWidth != yYMediaSample.mClipWidth || this.mClipHeight != yYMediaSample.mClipHeight) {
            this.mClipWidth = yYMediaSample.mClipWidth;
            this.mClipHeight = yYMediaSample.mClipHeight;
            final int i = this.mClipWidth;
            final int i2 = this.mClipHeight;
            postToGlThread(new Runnable() { // from class: com.yy.mediaframework.opengles.YMFPreviewView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (YMFPreviewView.this.mInited.get() && YMFPreviewView.this.mRender != null) {
                        YMFLog.info(this, "[Preview ]", "clip " + i + Config.EVENT_HEAT_X + i2);
                        YMFPreviewView.this.mRender.clip(YMFPreviewView.this.mVideoWidth, YMFPreviewView.this.mVideoHeight, i, i2);
                        YMFPreviewView.this.updateDrawPositionByClip();
                    }
                }
            });
        }
    }

    @Override // com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        this.mFilterContext.mViewState = getVisibility();
        if (this.mSurfaceCreated) {
            if (yYMediaSample == null || !checkFromat(yYMediaSample.mImageFormat)) {
                YMFLog.error(this, "[Preview ]", "Invalid sample.");
                return false;
            }
            YMFImageBuffer selectDataSource = selectDataSource(yYMediaSample);
            if (selectDataSource == null || selectDataSource.mData == null) {
                return false;
            }
            updateRender(yYMediaSample, selectDataSource.mWidth, selectDataSource.mHeight, selectDataSource.mFormat);
            if (!yYMediaSample.mCliped && yYMediaSample.mUseGPUBeauty) {
                updateClipInfo(yYMediaSample);
            }
            this.mRenderLock.lock();
            this.mFilterContext.getScreenShot().takeScreenShot(yYMediaSample);
            if (this.mVideoFrame != null && this.mVideoFrame.mData != null) {
                this.mDataArrive.set(this.mVideoFrame.deepCopy(selectDataSource));
            }
            if (this.mDataArrive.get()) {
                requestRender();
            }
            this.mRenderLock.unlock();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private int EGL_OPENGL_ES2_BIT;
        private int mAlphaSize;
        private int mBlueSize;
        private int[] mConfigAttr;
        private int[] mDefaultValue;
        private int mDepthSize;
        private int mGreenSize;
        private int mRedSize;
        private int mStencilSize;

        private ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.EGL_OPENGL_ES2_BIT = 4;
            this.mDefaultValue = new int[1];
            this.mConfigAttr = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.mConfigAttr, null, 0, iArr);
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                egl10.eglChooseConfig(eGLDisplay, this.mConfigAttr, eGLConfigArr, i, iArr);
                return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            }
            return null;
        }

        private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mDefaultValue)) {
                return this.mDefaultValue[0];
            }
            return i2;
        }
    }
}
