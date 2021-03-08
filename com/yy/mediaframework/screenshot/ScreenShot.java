package com.yy.mediaframework.screenshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gpuimage.adapter.GlTextureImageReader;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class ScreenShot {
    private Context mContext;
    private int mState;
    private VideoLiveFilterContext mVideoLiveFilterContext;
    private ScreenShotCallback mScreenShotCallback = null;
    private GlTextureImageReader mImageReader = null;
    private Object mSyncObject = new Object();
    private boolean mSupportCaptureWaterMark = false;
    private boolean mInit = false;
    private int mWidth = 0;
    private int mHeight = 0;

    public ScreenShot(Context context, VideoLiveFilterContext videoLiveFilterContext) {
        this.mContext = null;
        this.mVideoLiveFilterContext = null;
        this.mContext = context.getApplicationContext();
        this.mVideoLiveFilterContext = videoLiveFilterContext;
    }

    public void deInit() {
        if (this.mImageReader != null) {
            this.mImageReader.destroy();
            this.mImageReader = null;
            this.mScreenShotCallback = null;
        }
    }

    public boolean getScreenState() {
        return this.mScreenShotCallback != null;
    }

    public boolean processMediaSample(YYMediaSample yYMediaSample) {
        if (this.mState == 2) {
            YMFLog.info(this, "[SCapture]", "processMediaSample take snapshot, width:" + yYMediaSample.mWidth + " height:" + yYMediaSample.mHeight);
        }
        if (this.mScreenShotCallback != null) {
            take2(yYMediaSample.mWidth, yYMediaSample.mHeight);
            return false;
        }
        return false;
    }

    public boolean takeScreenShot(YYMediaSample yYMediaSample) {
        boolean z = true;
        if (this.mState == 2) {
            YMFLog.info(this, "[SCapture]", "processMediaSample take snapshot, width:" + yYMediaSample.mWidth + " height:" + yYMediaSample.mHeight);
            if (this.mScreenShotCallback != null && yYMediaSample != null) {
                if (yYMediaSample.mIsPreviewMirrorEnable == yYMediaSample.mDataMirror || yYMediaSample.mCameraFacing != 1) {
                    z = false;
                }
                switch (yYMediaSample.mImageFormat) {
                    case 0:
                        takeWithBuffer(yYMediaSample.mNV21, yYMediaSample.mImageFormat, z);
                        break;
                    case 1:
                        takeWithBuffer(yYMediaSample.mNV12, yYMediaSample.mImageFormat, z);
                        break;
                    case 2:
                        takeWithBuffer(yYMediaSample.mI420, yYMediaSample.mImageFormat, z);
                        break;
                    case 36:
                        takeWithBuffer(yYMediaSample.mRGBA, yYMediaSample.mImageFormat, z);
                        break;
                    case 69:
                    case 70:
                        take2(yYMediaSample.mClipWidth, yYMediaSample.mClipHeight);
                        break;
                }
            }
        }
        return false;
    }

    private YMFImageBuffer convertToRgba(YMFImageBuffer yMFImageBuffer, int i) {
        YMFImageBuffer yMFImageBuffer2 = new YMFImageBuffer(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, 36, true);
        switch (i) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                ImageUtil.I420ToABGR(yMFImageBuffer.mData.array(), yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, yMFImageBuffer2.mData.array(), YMFImageBuffer.offset(), false);
                return yMFImageBuffer2;
            case 36:
                return yMFImageBuffer;
            default:
                return yMFImageBuffer2;
        }
    }

    private void takeWithBuffer(YMFImageBuffer yMFImageBuffer, int i, boolean z) {
        try {
            this.mState = 1;
            YMFLog.info(this, "[Preview ]", "takeWithBuffer begin format " + i + "," + z);
            YMFImageBuffer convertToRgba = convertToRgba(yMFImageBuffer, i);
            if (convertToRgba == null) {
                throw new RuntimeException("imageFormat error");
            }
            Bitmap createBitmap = Bitmap.createBitmap(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            WaterMark watermark = this.mVideoLiveFilterContext.getWatermark();
            if (z) {
                canvas.scale(-1.0f, 1.0f, convertToRgba.mWidth / 2, 0.0f);
            } else {
                canvas.scale(1.0f, 1.0f, convertToRgba.mWidth / 2, 0.0f);
            }
            convertToRgba.mData.rewind();
            createBitmap.copyPixelsFromBuffer(convertToRgba.mData);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            createBitmap.setHasAlpha(true);
            if (watermark != null) {
                if (z) {
                    canvas.scale(-1.0f, 1.0f, convertToRgba.mWidth / 2, 0.0f);
                } else {
                    canvas.scale(1.0f, 1.0f, convertToRgba.mWidth / 2, 0.0f);
                }
                canvas.drawBitmap(watermark.bitmap, watermark.offsetX, watermark.offsetY, paint);
            }
            this.mState = 0;
            notifyBitmap(createBitmap);
        } catch (Exception e) {
            YMFLog.error(this, "[Preview ]", "takeWithBuffer error " + e.toString());
            notifyError(e);
        }
    }

    private void takeWithPbo(YYMediaSample yYMediaSample) {
        if (this.mState == 2) {
            this.mState = 1;
            try {
                if (this.mImageReader == null) {
                    this.mImageReader = new GlTextureImageReader(this.mContext, yYMediaSample.mWidth, yYMediaSample.mHeight);
                }
                this.mImageReader.checkImageSize(yYMediaSample.mWidth, yYMediaSample.mHeight);
                byte[] read = this.mImageReader.read(yYMediaSample.mMasterTextureId, yYMediaSample.mWidth, yYMediaSample.mHeight);
                if (read != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(read);
                    Bitmap createBitmap = Bitmap.createBitmap(yYMediaSample.mWidth, yYMediaSample.mHeight, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(wrap);
                    this.mState = 0;
                    notifyBitmap(createBitmap);
                }
            } catch (Throwable th) {
                YMFLog.error(this, "[SCapture]", "takeWithPbo exception: " + th.toString());
                notifyError(th);
            }
        }
    }

    public void setCallback(ScreenShotCallback screenShotCallback) {
        synchronized (this.mSyncObject) {
            if (screenShotCallback != null) {
                this.mScreenShotCallback = screenShotCallback;
                if (this.mState == 0) {
                    this.mState = 2;
                }
            }
        }
    }

    public void take(GL10 gl10, int i, int i2) {
        if (this.mState == 2) {
            this.mState = 1;
            try {
                int[] iArr = new int[i * i2];
                int[] iArr2 = new int[i * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                gl10.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                for (int i3 = 0; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i; i4++) {
                        int i5 = iArr[(i3 * i) + i4];
                        iArr2[(((i2 - i3) - 1) * i) + i4] = (i5 & (-16711936)) | ((i5 << 16) & 16711680) | ((i5 >> 16) & 255);
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
                this.mState = 0;
                notifyBitmap(createBitmap);
            } catch (Throwable th) {
                notifyError(th);
            }
        }
    }

    public void take(int i, int i2) {
        if (this.mState == 2) {
            this.mState = 1;
            try {
                int[] iArr = new int[i * i2];
                int[] iArr2 = new int[i * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                for (int i3 = 0; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i; i4++) {
                        int i5 = iArr[(i3 * i) + i4];
                        iArr2[(((i2 - i3) - 1) * i) + i4] = (i5 & (-16711936)) | ((i5 << 16) & 16711680) | ((i5 >> 16) & 255);
                    }
                }
                new Matrix().postScale(1.0f, -1.0f);
                Bitmap createBitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
                this.mState = 0;
                notifyBitmap(createBitmap);
            } catch (Throwable th) {
                notifyError(th);
            }
        }
    }

    public void take2(int i, int i2) {
        if (this.mState == 2) {
            this.mState = 1;
            try {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
                allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocateDirect);
                if (this.mScreenShotCallback != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    notifyBitmap(createBitmap);
                }
                this.mState = 0;
            } catch (Throwable th) {
                notifyError(th);
            }
            this.mScreenShotCallback = null;
        }
    }

    public void take2RGBA(int i, int i2) {
        if (this.mState == 2) {
            this.mState = 1;
            try {
                YMFLog.info(this, "[SCapture]", "faceShot start...");
                byte[] bArr = new byte[i * i2 * 4];
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bArr.length);
                wrap.position(0);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                this.mState = 0;
            } catch (Throwable th) {
                notifyError(th);
            }
        }
    }

    public void notifyBitmap(Bitmap bitmap) {
        if (this.mScreenShotCallback != null) {
            this.mScreenShotCallback.onTaked(bitmap);
        } else {
            YMFLog.error(this, "[SCapture]", "ScreenShotCallback  == null");
        }
    }

    public void notifyError(Throwable th) {
        if (this.mScreenShotCallback != null) {
            this.mScreenShotCallback.onError(th);
            YMFLog.info(this, "[SCapture]", "screenshot exception:" + th.toString());
        }
    }
}
