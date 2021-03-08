package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Surface;
import com.yy.mediaframework.screenlive.ScreenSurfaceCallback;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class ScreenCaptureFilter extends AbstractSurfaceTextureCaptureFilter {
    protected Surface mScreenSurface;
    private ScreenSurfaceCallback mScreenSurfaceCallback;

    public ScreenCaptureFilter(VideoLiveFilterContext videoLiveFilterContext, Context context) {
        super(videoLiveFilterContext);
        this.mScreenSurface = null;
        this.mScreenSurfaceCallback = null;
        this.mContext = context;
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter construct");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter
    @TargetApi(15)
    public void doInit() {
        super.doInit();
        this.mScreenSurface = new Surface(this.mCaptureSurfaceTexture);
        YMFLog.info(this, "[SCapture]", "create surface " + (this.mScreenSurface.isValid() ? "success" : " fail"));
        surfaceCreated(this.mScreenSurface);
    }

    public void init() {
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter init begin");
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ScreenCaptureFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    ScreenCaptureFilter.this.doInit();
                }
            });
        }
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter init done");
    }

    @Override // com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter, com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter deInit begin");
        surfaceDestroyed(this.mScreenSurface);
        if (this.mScreenSurface != null) {
            this.mScreenSurface.release();
            this.mScreenSurface = null;
        }
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doDeInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ScreenCaptureFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    ScreenCaptureFilter.this.doDeInit();
                }
            });
        }
        YMFLog.info(this, "[SCapture]", "ScreenCaptureFilter deInit done");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter
    @TargetApi(16)
    public void doDeInit() {
        super.doDeInit();
    }

    @Override // com.yy.mediaframework.filters.AbstractSurfaceTextureCaptureFilter
    public void updateScreenSize() {
        super.updateScreenSize();
        if (this.mScreenSurfaceCallback != null && this.mScreenSurface != null) {
            YMFLog.info(this, "[SCapture]", "updateScreenSize notify");
            if (this.mScreenSurfaceCallback != null) {
                this.mScreenSurfaceCallback.detachSurface();
            }
            if (this.mScreenSurface != null) {
                this.mScreenSurface.release();
            }
            this.mScreenSurface = new Surface(this.mCaptureSurfaceTexture);
            if (this.mScreenSurfaceCallback != null) {
                this.mScreenSurfaceCallback.attachSurface(this.mScreenSurface);
            }
            this.mScreenSurfaceCallback.surfaceChange(this.mScreenSurface);
        }
        YMFLog.info(this, "[SCapture]", "updateScreenSize done");
    }

    public void addScreenSurfaceCallback(ScreenSurfaceCallback screenSurfaceCallback) {
        YMFLog.info(this, "[SCapture]", "addScreenSurfaceCallback:" + screenSurfaceCallback);
        this.mScreenSurfaceCallback = screenSurfaceCallback;
        if (this.mScreenSurface != null) {
            surfaceCreated(this.mScreenSurface);
        }
    }

    private void surfaceCreated(Surface surface) {
        YMFLog.info(this, "[SCapture]", "surfaceCreated mScreenSurfaceCallback:" + this.mScreenSurfaceCallback);
        if (this.mScreenSurfaceCallback != null) {
            YMFLog.info(this, "[SCapture]", "surfaceCreated notify");
            this.mScreenSurfaceCallback.surfaceCreated(surface);
        }
    }

    private void surfaceDestroyed(Surface surface) {
        YMFLog.info(this, "[SCapture]", "surfaceDestroyed");
        if (this.mScreenSurfaceCallback != null) {
            YMFLog.info(this, "[SCapture]", "surfaceDestroyed notify");
            this.mScreenSurfaceCallback.surfaceDestroyed(surface);
        }
    }
}
