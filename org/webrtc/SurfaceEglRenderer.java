package org.webrtc;

import android.view.SurfaceHolder;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
/* loaded from: classes8.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    public static final String TAG = "SurfaceEglRenderer";
    public int frameRotation;
    public boolean isFirstFrameRendered;
    public boolean isRenderingPaused;
    public final Object layoutLock;
    public RendererCommon.RendererEvents rendererEvents;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;

    public SurfaceEglRenderer(String str) {
        super(str);
        this.layoutLock = new Object();
    }

    private void logD(String str) {
        Logging.d(TAG, this.name + ": " + str);
    }

    private void updateFrameDimensionsAndReportEvents(VideoFrame videoFrame) {
        synchronized (this.layoutLock) {
            if (this.isRenderingPaused) {
                return;
            }
            if (!this.isFirstFrameRendered) {
                this.isFirstFrameRendered = true;
                logD("Reporting first rendered frame.");
                if (this.rendererEvents != null) {
                    this.rendererEvents.onFirstFrameRendered();
                }
            }
            if (this.rotatedFrameWidth != videoFrame.getRotatedWidth() || this.rotatedFrameHeight != videoFrame.getRotatedHeight() || this.frameRotation != videoFrame.getRotation()) {
                logD("Reporting frame resolution changed to " + videoFrame.getBuffer().getWidth() + "x" + videoFrame.getBuffer().getHeight() + " with rotation " + videoFrame.getRotation());
                if (this.rendererEvents != null) {
                    this.rendererEvents.onFrameResolutionChanged(videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation());
                }
                this.rotatedFrameWidth = videoFrame.getRotatedWidth();
                this.rotatedFrameHeight = videoFrame.getRotatedHeight();
                this.frameRotation = videoFrame.getRotation();
            }
        }
    }

    @Override // org.webrtc.EglRenderer
    public void disableFpsReduction() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = false;
        }
        super.disableFpsReduction();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        synchronized (this.layoutLock) {
            this.isFirstFrameRendered = false;
            this.rotatedFrameWidth = 0;
            this.rotatedFrameHeight = 0;
            this.frameRotation = 0;
        }
        super.init(context, iArr, glDrawer);
    }

    @Override // org.webrtc.EglRenderer
    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        init(context, (RendererCommon.RendererEvents) null, iArr, glDrawer);
    }

    @Override // org.webrtc.EglRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        updateFrameDimensionsAndReportEvents(videoFrame);
        super.onFrame(videoFrame);
    }

    @Override // org.webrtc.EglRenderer
    public void pauseVideo() {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = true;
        }
        super.pauseVideo();
    }

    @Override // org.webrtc.EglRenderer
    public void setFpsReduction(float f2) {
        synchronized (this.layoutLock) {
            this.isRenderingPaused = f2 == 0.0f;
        }
        super.setFpsReduction(f2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        ThreadUtils.checkIsOnMainThread();
        logD("surfaceChanged: format: " + i2 + " size: " + i3 + "x" + i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.getClass();
        releaseEglSurface(new Runnable() { // from class: org.webrtc._$$Lambda$5k6tNlswoNAjCdgttrkQIe8VHVs
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
    }
}
