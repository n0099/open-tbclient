package com.yy.mediaframework.opengles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.ViewCompat;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class YMFPreviewCanvasView extends SurfaceView implements SurfaceHolder.Callback, IMediaFilter {
    private static final String TAG = "YMFPreviewCanvasView";

    /* renamed from: b  reason: collision with root package name */
    public byte[] f14396b;
    private long feedCurrentTime;
    private long feedFrameCounter;
    private boolean hasCatchException;
    private long lastRenderTime;
    private Bitmap mBitmap;
    private int mBitmapCanvasH;
    private int mBitmapCanvasW;
    private int mBitmapCanvasX;
    private int mBitmapCanvasY;
    private AtomicBoolean mDrawBlockFrame;
    private VideoLiveFilterContext mFilterContext;
    private boolean mFirstFrameRenderd;
    private int mLogNum;
    private int mOriginDataHeight;
    private int mOriginDataWidth;
    private YMFImageBuffer mRGBABuffer;
    private ReentrantLock mRenderLock;
    private Constant.ScaleMode mScaleMode;
    private AtomicBoolean mSurfaceCreated;
    private int mSurfaceHeight;
    private int mSurfaceWidth;

    public YMFPreviewCanvasView(Context context) {
        super(context);
        this.mOriginDataWidth = 0;
        this.mOriginDataHeight = 0;
        this.mScaleMode = Constant.ScaleMode.AspectFit;
        this.mBitmap = null;
        this.feedFrameCounter = 0L;
        this.feedCurrentTime = 0L;
        this.lastRenderTime = 0L;
        this.hasCatchException = false;
        this.mBitmapCanvasX = 0;
        this.mBitmapCanvasY = 0;
        this.mBitmapCanvasW = 0;
        this.mBitmapCanvasH = 0;
        this.mSurfaceCreated = new AtomicBoolean(false);
        this.mRenderLock = new ReentrantLock(true);
        this.mFirstFrameRenderd = false;
        this.mDrawBlockFrame = new AtomicBoolean(false);
        this.mLogNum = 0;
    }

    public void setVideoLiveFilterContext(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    public void reSetPreviewState() {
        this.mFirstFrameRenderd = false;
    }

    private void checkUpdata(YMFImageBuffer yMFImageBuffer) {
        if (this.mRGBABuffer == null || this.mRGBABuffer.mWidth != yMFImageBuffer.mWidth || this.mRGBABuffer.mHeight != yMFImageBuffer.mHeight) {
            this.mRGBABuffer = new YMFImageBuffer(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, 36, true);
        }
        if (this.mBitmap == null || this.mBitmap.getWidth() != yMFImageBuffer.mWidth || this.mBitmap.getHeight() != yMFImageBuffer.mHeight) {
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
            this.mBitmap = Bitmap.createBitmap(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, Bitmap.Config.ARGB_8888);
        }
    }

    public void drawBlackScreen(boolean z) {
        this.mDrawBlockFrame.set(z);
        try {
            final SurfaceHolder holder = getHolder();
            YMFLog.info(this, TAG, " drawBlackScreen " + z);
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.opengles.YMFPreviewCanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Canvas lockCanvas = holder.lockCanvas();
                        lockCanvas.drawColor(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.CLEAR);
                        holder.unlockCanvasAndPost(lockCanvas);
                    } catch (Exception e) {
                        YMFLog.error(this, "[Preproce]", "drawBlackScreen " + e.toString());
                    }
                }
            });
        } catch (Exception e) {
            YMFLog.error(this, "[Preproce]", "drawBlackScreen 2 " + e.toString());
        }
    }

    public boolean prepareVideoDataRgba(YYMediaSample yYMediaSample) {
        checkUpdata(yYMediaSample.mRGBA);
        yYMediaSample.mRGBA.mData.rewind();
        this.mBitmap.copyPixelsFromBuffer(yYMediaSample.mRGBA.mData);
        return true;
    }

    public boolean prepareVideoDataI420(YYMediaSample yYMediaSample) {
        checkUpdata(yYMediaSample.mI420);
        yYMediaSample.mI420.mData.rewind();
        this.mRGBABuffer.mData.rewind();
        int I420ToABGR = ImageUtil.I420ToABGR(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, this.mRGBABuffer.mData.array(), YMFImageBuffer.offset(), false);
        if (I420ToABGR != 0) {
            YMFLog.error(this, "[Preproce]", "I420ToABGR failed, return " + I420ToABGR);
            return false;
        }
        this.mRGBABuffer.mData.rewind();
        this.mBitmap.copyPixelsFromBuffer(this.mRGBABuffer.mData);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [230=5] */
    @Override // com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        ReentrantLock reentrantLock;
        this.mFilterContext.mViewState = getVisibility();
        if (((yYMediaSample.mImageFormat != 2 || yYMediaSample.mI420 == null || yYMediaSample.mI420.mData == null) && (yYMediaSample.mImageFormat != 36 || yYMediaSample.mRGBA == null || yYMediaSample.mRGBA.mData == null)) || !this.mSurfaceCreated.get()) {
            return false;
        }
        yYMediaSample.addRef();
        if (yYMediaSample.mImageFormat == 2) {
            this.mOriginDataWidth = yYMediaSample.mI420.mWidth;
            this.mOriginDataHeight = yYMediaSample.mI420.mHeight;
        } else if (yYMediaSample.mImageFormat == 36) {
            this.mOriginDataWidth = yYMediaSample.mRGBA.mWidth;
            this.mOriginDataHeight = yYMediaSample.mRGBA.mHeight;
        }
        try {
            this.mRenderLock.lock();
            this.mFilterContext.getScreenShot().takeScreenShot(yYMediaSample);
            calcFitSize();
            if (yYMediaSample.mImageFormat == 2) {
                if (!prepareVideoDataI420(yYMediaSample)) {
                    return false;
                }
            } else if (yYMediaSample.mImageFormat == 36 && !prepareVideoDataRgba(yYMediaSample)) {
                return false;
            }
            Canvas lockCanvas = getHolder().lockCanvas();
            if (lockCanvas == null) {
                int i = this.mLogNum;
                this.mLogNum = i + 1;
                if (i % 100 == 0) {
                    YMFLog.warn(this, "[Preview ]", "canvas == null");
                    return false;
                }
            }
            lockCanvas.drawColor(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.CLEAR);
            if (!this.mDrawBlockFrame.get()) {
                Rect rect = new Rect(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                Rect rect2 = new Rect(this.mBitmapCanvasX, this.mBitmapCanvasY, this.mBitmapCanvasX + this.mBitmapCanvasW, this.mBitmapCanvasY + this.mBitmapCanvasH);
                if (yYMediaSample.mIsPreviewMirrorEnable != yYMediaSample.mDataMirror && yYMediaSample.mCameraFacing == 1) {
                    lockCanvas.scale(-1.0f, 1.0f, this.mSurfaceWidth / 2, 0.0f);
                }
                lockCanvas.drawBitmap(this.mBitmap, rect, rect2, (Paint) null);
                if (yYMediaSample.mIsPreviewMirrorEnable != yYMediaSample.mDataMirror && yYMediaSample.mCameraFacing == 1) {
                    lockCanvas.scale(-1.0f, 1.0f, this.mSurfaceWidth / 2, 0.0f);
                }
                WaterMark watermark = this.mFilterContext.getWatermark();
                if (watermark != null) {
                    double d = (1.0d * this.mBitmapCanvasW) / this.mFilterContext.getVideoEncoderConfig().mEncodeWidth;
                    double d2 = (1.0d * this.mBitmapCanvasH) / this.mFilterContext.getVideoEncoderConfig().mEncodeHeight;
                    lockCanvas.drawBitmap(watermark.bitmap, new Rect(0, 0, watermark.bitmap.getWidth(), watermark.bitmap.getHeight()), new Rect(this.mBitmapCanvasX + ((int) (watermark.offsetX * d)), this.mBitmapCanvasY + ((int) (watermark.offsetY * d2)), ((int) ((d * watermark.bitmap.getWidth()) + 0.5d)) + this.mBitmapCanvasX + ((int) (watermark.offsetX * d)), this.mBitmapCanvasY + ((int) (watermark.offsetY * d2)) + ((int) ((d2 * watermark.bitmap.getHeight()) + 0.5d))), (Paint) null);
                }
                if (this.mFilterContext.mDeliverCallback != null && !this.mFirstFrameRenderd) {
                    this.mFilterContext.mDeliverCallback.onRenderFirstFrame();
                    this.mFirstFrameRenderd = true;
                }
            }
            getHolder().unlockCanvasAndPost(lockCanvas);
        } catch (Exception e) {
            this.hasCatchException = true;
            YMFLog.error(this, "[Preview ]", "draw error:" + e.toString());
        } finally {
            this.mRenderLock.unlock();
        }
        if (!this.hasCatchException) {
            this.feedFrameCounter++;
            this.feedCurrentTime = System.currentTimeMillis();
            if (this.feedCurrentTime - this.lastRenderTime >= 1000) {
                VideoDataStat.getInstance().setPreviewFrameRate(this.feedFrameCounter);
                this.lastRenderTime = this.feedCurrentTime;
                this.feedFrameCounter = 0L;
            }
        }
        yYMediaSample.decRef();
        return true;
    }

    public void deInit() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        this.mBitmapCanvasX = 0;
        this.mBitmapCanvasY = 0;
        this.mBitmapCanvasW = 0;
        this.mBitmapCanvasH = 0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mRenderLock.lock();
        this.mSurfaceCreated.set(true);
        if (this.mSurfaceWidth != i2 || this.mSurfaceHeight != i3) {
            this.mSurfaceWidth = i2;
            this.mSurfaceHeight = i3;
        }
        YMFLog.info(this, "[Preview ]", "onSurfaceChanged width:" + i2 + " height:" + i3);
        this.mRenderLock.unlock();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mRenderLock.lock();
        this.mSurfaceCreated.set(false);
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed ");
        this.mRenderLock.unlock();
    }

    public void setScaleMode(Constant.ScaleMode scaleMode) {
        YMFLog.info(this, "[Preview ]", "setScaleMode mode:" + scaleMode);
        this.mScaleMode = scaleMode;
    }

    private void calcFitSize() {
        if (this.mSurfaceWidth != 0 || this.mSurfaceHeight != 0) {
            if (this.mScaleMode == Constant.ScaleMode.AspectFill) {
                if (this.mSurfaceWidth * this.mOriginDataHeight > this.mSurfaceHeight * this.mOriginDataWidth) {
                    double d = (this.mOriginDataHeight * 1.0d) / this.mOriginDataWidth;
                    this.mBitmapCanvasX = 0;
                    this.mBitmapCanvasY = (this.mSurfaceHeight - ((int) ((this.mSurfaceWidth * d) + 0.5d))) / 2;
                    this.mBitmapCanvasW = this.mSurfaceWidth;
                    this.mBitmapCanvasH = (int) ((d * this.mSurfaceWidth) + 0.5d);
                    return;
                }
                double d2 = (this.mOriginDataWidth * 1.0d) / this.mOriginDataHeight;
                this.mBitmapCanvasX = (this.mSurfaceWidth - ((int) ((this.mSurfaceHeight * d2) + 0.5d))) / 2;
                this.mBitmapCanvasY = 0;
                this.mBitmapCanvasW = (int) ((d2 * this.mSurfaceHeight) + 0.5d);
                this.mBitmapCanvasH = this.mSurfaceHeight;
            } else if (this.mScaleMode == Constant.ScaleMode.AspectFit) {
                if (this.mSurfaceWidth * this.mOriginDataHeight < this.mSurfaceHeight * this.mOriginDataWidth) {
                    double d3 = (this.mSurfaceWidth * 1.0d) / this.mOriginDataWidth;
                    this.mBitmapCanvasX = 0;
                    this.mBitmapCanvasY = (this.mSurfaceHeight - ((int) ((this.mOriginDataHeight * d3) + 0.5d))) / 2;
                    this.mBitmapCanvasW = this.mSurfaceWidth;
                    this.mBitmapCanvasH = (int) ((d3 * this.mOriginDataHeight) + 0.5d);
                    return;
                }
                double d4 = (this.mSurfaceHeight * 1.0d) / this.mOriginDataHeight;
                this.mBitmapCanvasX = (this.mSurfaceWidth - ((int) ((this.mOriginDataWidth * d4) + 0.5d))) / 2;
                this.mBitmapCanvasY = 0;
                this.mBitmapCanvasW = (int) ((d4 * this.mOriginDataWidth) + 0.5d);
                this.mBitmapCanvasH = this.mSurfaceHeight;
            } else if (this.mScaleMode == Constant.ScaleMode.ScacleToFill) {
                this.mBitmapCanvasX = 0;
                this.mBitmapCanvasY = 0;
                this.mBitmapCanvasW = this.mSurfaceWidth;
                this.mBitmapCanvasH = this.mSurfaceHeight;
            }
        }
    }
}
