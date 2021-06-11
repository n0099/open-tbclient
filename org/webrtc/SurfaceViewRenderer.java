package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;
/* loaded from: classes8.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    public static final String TAG = "SurfaceViewRenderer";
    public final SurfaceEglRenderer eglRenderer;
    public boolean enableFixedSize;
    public RendererCommon.RendererEvents rendererEvents;
    public final String resourceName;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    public int surfaceHeight;
    public int surfaceWidth;
    public final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    public SurfaceViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        getHolder().addCallback(this);
        getHolder().addCallback(this.eglRenderer);
    }

    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        getHolder().addCallback(this);
        getHolder().addCallback(this.eglRenderer);
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public static /* synthetic */ void lambda$onFrameResolutionChanged$0(SurfaceViewRenderer surfaceViewRenderer, int i2, int i3) {
        surfaceViewRenderer.rotatedFrameWidth = i2;
        surfaceViewRenderer.rotatedFrameHeight = i3;
        surfaceViewRenderer.updateSurfaceSize();
        surfaceViewRenderer.requestLayout();
    }

    private void logD(String str) {
        Logging.d(TAG, this.resourceName + ": " + str);
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (!this.enableFixedSize || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            getHolder().setSizeFromLayout();
            return;
        }
        float width = getWidth() / getHeight();
        int i2 = this.rotatedFrameWidth;
        int i3 = this.rotatedFrameHeight;
        if (i2 / i3 > width) {
            i2 = (int) (i3 * width);
        } else {
            i3 = (int) (i2 / width);
        }
        int min = Math.min(getWidth(), i2);
        int min2 = Math.min(getHeight(), i3);
        logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + min + "x" + min2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if (min == this.surfaceWidth && min2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = min;
        this.surfaceHeight = min2;
        getHolder().setFixedSize(min, min2);
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f2) {
        this.eglRenderer.addFrameListener(frameListener, f2);
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f2, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.addFrameListener(frameListener, f2, glDrawer);
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(context, this, iArr, glDrawer);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    public void onFrame(VideoFrame videoFrame) {
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int i2, int i3, int i4) {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(i2, i3, i4);
        }
        final int i5 = (i4 == 0 || i4 == 180) ? i2 : i3;
        if (i4 == 0 || i4 == 180) {
            i2 = i3;
        }
        postOrRun(new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceViewRenderer$NznHhISA8bkJ9U8moGf2KoEdee4
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewRenderer.lambda$onFrameResolutionChanged$0(SurfaceViewRenderer.this, i5, i2);
            }
        });
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((i4 - i2) / (i5 - i3));
        updateSurfaceSize();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        ThreadUtils.checkIsOnMainThread();
        Point measure = this.videoLayoutMeasure.measure(i2, i3, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(measure.x, measure.y);
        logD("onMeasure(). New size: " + measure.x + "x" + measure.y);
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void removeFrameListener(EglRenderer.FrameListener frameListener) {
        this.eglRenderer.removeFrameListener(frameListener);
    }

    public void setEnableHardwareScaler(boolean z) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = z;
        updateSurfaceSize();
    }

    public void setFpsReduction(float f2) {
        this.eglRenderer.setFpsReduction(f2);
    }

    public void setMirror(boolean z) {
        this.eglRenderer.setMirror(z);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    public void setScalingType(RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType, scalingType2);
        requestLayout();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
