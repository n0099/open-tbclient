package com.yy.mediaframework.gpuimage.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.view.WindowManager;
import com.yy.mediaframework.PictureInPictureDisplayInfo;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gles.Drawable2d;
import com.yy.mediaframework.gles.FullFrameRect;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gles.Texture2dProgram;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.GLUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class GlTextureBlender {
    private static final String TAG = "GlTextureBlender";
    Drawable2d.Prefab mDrawable2d;
    VideoLiveFilterContext mFilterContext;
    private int mScreenHeight;
    private int mScreenWidth;
    private FloatBuffer mSlaveVertexBuffer;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mInputWidth = 0;
    private int mInputHeight = 0;
    private int mClipWidth = 0;
    private int mClipHeight = 0;
    private int mEncodeWidth = 0;
    private int mEncodeHeight = 0;
    private int mOffScreenFrameBuffer = -1;
    private int mOffScreenTextureId = -1;
    private boolean mFlipHorizontal = false;
    private boolean mFlipVertical = false;
    private FullFrameRect mOffScreen = null;
    final float[] SLAVE_VEX_RIGHT_BOTTOM = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, -1.0f};
    public int fakeTextureId = -1;
    private RectF mLastScreenCropArea = new RectF();

    public GlTextureBlender(VideoLiveFilterContext videoLiveFilterContext) {
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mFilterContext = videoLiveFilterContext;
        init(this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
        this.mSlaveVertexBuffer = ByteBuffer.allocateDirect(this.SLAVE_VEX_RIGHT_BOTTOM.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSlaveVertexBuffer.put(this.SLAVE_VEX_RIGHT_BOTTOM).position(0);
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

    public GlTextureBlender(VideoLiveFilterContext videoLiveFilterContext, int i, int i2) {
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mFilterContext = videoLiveFilterContext;
        init(i, i2);
        this.mSlaveVertexBuffer = ByteBuffer.allocateDirect(this.SLAVE_VEX_RIGHT_BOTTOM.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mSlaveVertexBuffer.put(this.SLAVE_VEX_RIGHT_BOTTOM).position(0);
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

    private void init(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mOffScreenTextureId = GLUtil.genTexture(3553, this.mWidth, this.mHeight);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mOffScreenFrameBuffer = iArr[0];
        GLES20.glBindFramebuffer(36160, this.mOffScreenFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffScreenTextureId, 0);
        this.mOffScreen = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_WITH_EXTRA_TXT_2), Drawable2d.Prefab.FULL_RECTANGLE, GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS), GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS));
        setEncoderFlipY();
        fakeWatermarkBackground(i, i2);
    }

    private void fakeWatermarkBackground(int i, int i2) {
        this.fakeTextureId = createTextureFromBitmap(createColorBitmap(i, i2));
    }

    private Bitmap createColorBitmap(int i, int i2) {
        YMFLog.info(this, "[Beauty  ]", "createColorBitmap");
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawColor(0);
        return createBitmap;
    }

    private int createTextureFromBitmap(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    private void setEncoderFlipY() {
        if (this.mOffScreen != null) {
            YMFLog.info(this, "[Encoder ]", "encoder setEncoderFlipY");
            this.mOffScreen.setTextureFlipY(3);
        }
    }

    private void checkImageSize(int i, int i2) {
        if (this.mWidth != i || this.mHeight != i2) {
            destroy();
            init(i, i2);
        }
    }

    public int blend(YYMediaSample yYMediaSample, int i, int i2, boolean z) {
        checkImageSize(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
        if (this.mFilterContext != null) {
            try {
                GLES20.glBindFramebuffer(36160, this.mOffScreenFrameBuffer);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffScreenTextureId, 0);
                GLES20.glViewport(0, 0, yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                if (yYMediaSample.mScreenCropArea != null && !yYMediaSample.mScreenCropArea.equals(this.mLastScreenCropArea)) {
                    YMFLog.info(this, "[Beauty  ]", "soft-ScreenLiveSession sample.mScreenCropArea:" + yYMediaSample.mScreenCropArea);
                    this.mLastScreenCropArea.set(yYMediaSample.mScreenCropArea);
                    if (this.mEncodeWidth != yYMediaSample.mEncodeWidth && this.mEncodeHeight != yYMediaSample.mEncodeHeight) {
                        YMFLog.info(this, "[Beauty  ]", "soft-ScreenLiveSession adjustTextureArea...");
                        this.mOffScreen.adjustTextureArea(yYMediaSample.mScreenCropArea, this.mScreenWidth, this.mScreenHeight, true);
                    } else {
                        YMFLog.warn(this, "[Beauty  ]", "soft-screen clip ratio and encode ratio not change at the same time...");
                    }
                } else if (yYMediaSample.mScreenCropArea == null && !yYMediaSample.mUseExternalVideoFrame && checkClipRatioChanged(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight)) {
                    YMFLog.info(this, "[Beauty  ]", "soft-VideoLiveSession adjustTexture..");
                    this.mOffScreen.adjustTexture(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
                }
                if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
                    flip(yYMediaSample);
                    updateVertexBuffer(this.mSlaveVertexBuffer, yYMediaSample.mPictureInPictureDisplayInfo);
                    this.mOffScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, i, i2, yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, this.mSlaveVertexBuffer, GlUtil.adjustDualCameraSlaveTexture(yYMediaSample, this.mFilterContext.mCameraPreviewConfig.getWidth(), this.mFilterContext.mCameraPreviewConfig.getHeight()));
                } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_PERIPHERALS) {
                    drawPeripherals(yYMediaSample);
                } else {
                    flip(yYMediaSample);
                    if (yYMediaSample.mUseExternalVideoFrame) {
                        this.mOffScreen.adjustVertex(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mClipWidth, yYMediaSample.mClipHeight, yYMediaSample.mExternalFrameScaleMode);
                    }
                    this.mOffScreen.drawFrame(yYMediaSample.mMasterTextureId, yYMediaSample.mMainTransformer, i, i2, -1, null, null);
                }
                GLES20.glBindFramebuffer(36160, 0);
            } catch (Throwable th) {
                YMFLog.error(this, "[Beauty  ]", "blend exception:" + th.getMessage());
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        return this.mOffScreenTextureId;
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

    private void drawPeripherals(YYMediaSample yYMediaSample) {
        FloatBuffer floatBuffer;
        FloatBuffer positionBuffer = this.mFilterContext.mPeripheralsPosition.getPositionBuffer(false);
        FloatBuffer flipY = GlUtil.setFlipY(this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer());
        if (this.mFilterContext.mPeripheralsPosition.fillMode == 1) {
            FloatBuffer convertPositionBuffer = this.mFilterContext.mPeripheralsPosition.convertPositionBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, this.mFilterContext.mPeripheralsPosition.srcWidth, this.mFilterContext.mPeripheralsPosition.srcHeight);
            flipY = this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer();
            floatBuffer = convertPositionBuffer;
        } else {
            floatBuffer = positionBuffer;
        }
        this.mOffScreen.drawFrame(this.mFilterContext.getBackgroundTextureId(), yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, yYMediaSample.mSlaveTransformer, GlUtil.setFlipY(floatBuffer), flipY);
        if (this.mFilterContext.mPeripheralsOrientation != 1 && this.fakeTextureId > -1) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            this.mOffScreen.drawFrame(this.fakeTextureId, this.mFilterContext.mPeripheralsPosition.getDefaultVertexBuffer(), this.mFilterContext.mPeripheralsPosition.getDefaultTextureBuffer(), yYMediaSample.mMainTransformer, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), -1, null, null, null, false);
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
        this.mOffScreen.drawFrame(yYMediaSample.mMasterTextureId, this.mFilterContext.mCameraPostion.getPositionBuffer(true), (yYMediaSample.mCameraFacing != 1 || yYMediaSample.mIsMirrorEnable) ? defaultTextureBuffer : GlUtil.setFlipX(defaultTextureBuffer), yYMediaSample.mMainTransformer, -1, -1, -1, null, null, null, false);
    }

    public void flip(YYMediaSample yYMediaSample) {
        this.mOffScreen.resetFlip();
        if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_DUALCAMERA) {
            if (yYMediaSample.mCameraFacing == 1) {
                if (yYMediaSample.mOrientation == 2) {
                    if (yYMediaSample.mOrginalCameraFacing == yYMediaSample.mCameraFacing) {
                        if (!yYMediaSample.mIsMirrorEnable) {
                            this.mOffScreen.flipXMasterPicture();
                        }
                    } else if (!yYMediaSample.mIsMirrorEnable) {
                        this.mOffScreen.flipXSlavePicture();
                    } else {
                        this.mOffScreen.flipXScreen();
                    }
                } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                    if (!yYMediaSample.mIsMirrorEnable) {
                        this.mOffScreen.flipYScreenXMaster();
                    } else {
                        this.mOffScreen.flipYScreen();
                    }
                } else if (!yYMediaSample.mIsMirrorEnable) {
                    this.mOffScreen.flipXMasterPicture();
                }
            } else if (yYMediaSample.mOrientation == 2) {
                if (yYMediaSample.mOrginalCameraFacing == yYMediaSample.mCameraFacing) {
                    if (!yYMediaSample.mIsMirrorEnable) {
                        this.mOffScreen.flipXSlavePicture();
                    }
                } else if (!yYMediaSample.mIsMirrorEnable) {
                    this.mOffScreen.flipXMasterPicture();
                } else {
                    this.mOffScreen.flipXScreen();
                }
            } else if (yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
                if (!yYMediaSample.mIsMirrorEnable) {
                    this.mOffScreen.flipYScreenXSlave();
                } else {
                    this.mOffScreen.flipYScreen();
                }
            } else if (!yYMediaSample.mIsMirrorEnable) {
                this.mOffScreen.flipXSlavePicture();
            }
        } else if (yYMediaSample.mCameraFacing == 1 && !yYMediaSample.mIsMirrorEnable) {
            this.mOffScreen.flipXMasterPicture();
        }
    }

    public void updateVertexBuffer(FloatBuffer floatBuffer, PictureInPictureDisplayInfo pictureInPictureDisplayInfo) {
        if (pictureInPictureDisplayInfo == null) {
            YMFLog.error(this, "[Util    ]", "updateVertexBuffer, invalid PictureInPictureDisplayInfo");
            return;
        }
        floatBuffer.put(0, 1.0f - pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(1, pictureInPictureDisplayInfo.bottomOffset + pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(2, 1.0f);
        floatBuffer.put(3, pictureInPictureDisplayInfo.bottomOffset + pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(4, 1.0f - pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(5, pictureInPictureDisplayInfo.bottomOffset);
        floatBuffer.put(6, 1.0f);
        floatBuffer.put(7, pictureInPictureDisplayInfo.bottomOffset);
    }

    private String transform2String(FloatBuffer floatBuffer) {
        StringBuilder sb = new StringBuilder("vertex buffer::");
        for (int i = 0; i < floatBuffer.capacity(); i++) {
            sb.append(floatBuffer.get(i) + " ");
        }
        return sb.toString();
    }

    public int blend(int i, float[] fArr, int i2, int i3, int i4, int i5) {
        checkImageSize(i4, i5);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, this.mOffScreenFrameBuffer);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffScreenTextureId, 0);
        this.mOffScreen.drawFrame(i, fArr, i2, i3, -1, null, null);
        GLES20.glBindFramebuffer(36160, 0);
        return this.mOffScreenTextureId;
    }

    public void destroy() {
        if (this.mOffScreenTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mOffScreenTextureId}, 0);
            this.mOffScreenTextureId = -1;
        }
        if (this.mOffScreenFrameBuffer > 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mOffScreenFrameBuffer}, 0);
            this.mOffScreenFrameBuffer = -1;
        }
        if (this.mOffScreen != null) {
            this.mOffScreen.release(true);
            this.mOffScreen = null;
        }
        if (this.fakeTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.fakeTextureId}, 0);
            this.fakeTextureId = -1;
        }
    }
}
