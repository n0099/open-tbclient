package com.yy.mediaframework.screenlive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.yy.mediaframework.AbstractLiveSession;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.filters.ClipFilter;
import com.yy.mediaframework.filters.GlLoadImageFilter;
import com.yy.mediaframework.filters.ImageCaptureFilter;
import com.yy.mediaframework.filters.ScreenCaptureFilter;
import com.yy.mediaframework.filters.VideoEndPointFilter;
import com.yy.mediaframework.screenshot.ScreenShot;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class ScreenLiveSession extends AbstractLiveSession {
    private ClipFilter mCliperFilter;
    private VideoEndPointFilter mEndPointFilter;
    private GlLoadImageFilter mGlLoadImageFilter;
    protected ImageCaptureFilter mImageCaptureFilter;
    private ScreenCaptureFilter mScreenCaptureFilter;

    public ScreenLiveSession(Context context) {
        super(context);
        this.mScreenCaptureFilter = null;
        this.mImageCaptureFilter = null;
        this.mCliperFilter = null;
        this.mGlLoadImageFilter = null;
        this.mEndPointFilter = null;
        YMFLog.info(this, "[Procedur]", " new ScreenLiveSession...");
        this.mFilterContext.setScreenShot(new ScreenShot(context, this.mFilterContext));
        this.mScreenCaptureFilter = new ScreenCaptureFilter(this.mFilterContext, context.getApplicationContext());
        this.mCliperFilter = new ClipFilter();
        this.mGlLoadImageFilter = new GlLoadImageFilter();
        this.mImageCaptureFilter = new ImageCaptureFilter(this.mFilterContext, 3);
        this.mEndPointFilter = new VideoEndPointFilter(this.mFilterContext);
        this.mPreprocessFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter));
        this.mScreenCaptureFilter.addDownStream(this.mPreprocessFilter).addDownStream(this.mEndPointFilter);
        this.mImageCaptureFilter.addDownStream(this.mGlLoadImageFilter.addDownStream(this.mCliperFilter));
        this.mFilterContext.getGlManager().registerFilter(this.mScreenCaptureFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mImageCaptureFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mGlLoadImageFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mCliperFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEndPointFilter);
    }

    public void startScreenCapture() {
        YMFLog.info(this, "[SCapture]", "startScreenCapture....");
        this.mScreenCaptureFilter.init();
        this.mImageCaptureFilter.init();
    }

    @Override // com.yy.mediaframework.AbstractLiveSession, com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        super.stopAndRelease();
        YMFLog.info(this, "[SCapture]", "ScreenLiveSession stopAndRelease======#######$$$$$$$");
    }

    public void setCaptureResolution(final int i, final int i2) {
        YMFLog.info(this, "[SCapture]", "setCaptureResolution, width:" + i + " ,height:" + i2);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSession.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSession.this.mFilterContext.getScreenRecordConfig().setScreenSize(i, i2);
            }
        });
    }

    public void addScreenSurfaceCallback(final ScreenSurfaceCallback screenSurfaceCallback) {
        YMFLog.info(this, "[SCapture]", "addScreenSurfaceCallback:" + screenSurfaceCallback);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSession.2
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenLiveSession.this.mScreenCaptureFilter != null) {
                    ScreenLiveSession.this.mScreenCaptureFilter.addScreenSurfaceCallback(screenSurfaceCallback);
                }
            }
        });
    }

    public void imageFrameAvailable(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (this.mImageCaptureFilter != null) {
            byteBuffer.position(0);
            this.mImageCaptureFilter.onImageAvailable(byteBuffer, i, i2, i3);
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
        this.mFilterContext.getScreenShot().setCallback(screenShotCallback);
    }

    public void setPrivacyMote(boolean z) {
        YMFLog.info(this, "[SCapture]", "ScreenLiveSession isPrivacyMote:" + z);
        if (!z) {
            this.mScreenCaptureFilter.startCapture();
        } else {
            this.mScreenCaptureFilter.stopCapture();
        }
    }

    public void setScreenCropArea(RectF rectF) {
        YMFLog.info(this, "[SCapture]", "ScreenLiveSession setScreenCropArea...rectF:" + rectF + " ,mScreenCaptureFilter:" + this.mScreenCaptureFilter);
        if (this.mScreenCaptureFilter != null) {
            this.mScreenCaptureFilter.setScreenCropArea(rectF);
        }
    }

    public void setDeltaYYPtsMillions(final long j) {
        YMFLog.info(this, "[Encoder ]", "ScreenLiveSession setDeltaYYPtsMillions:" + j);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSession.3
            @Override // java.lang.Runnable
            public void run() {
                YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setWaterMark(Bitmap bitmap, int i, int i2) {
    }
}
