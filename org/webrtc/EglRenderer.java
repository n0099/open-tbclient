package org.webrtc;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
/* loaded from: classes7.dex */
public class EglRenderer implements VideoSink {
    public static final long LOG_INTERVAL_SEC = 4;
    public static final String TAG = "EglRenderer";
    @Nullable
    public RendererCommon.GlDrawer drawer;
    @Nullable
    public EglBase eglBase;
    public int framesDropped;
    public int framesReceived;
    public int framesRendered;
    public float layoutAspectRatio;
    public long minRenderPeriodNs;
    public boolean mirror;
    public final String name;
    public long nextFrameTimeNs;
    @Nullable
    public VideoFrame pendingFrame;
    public long renderSwapBufferTimeNs;
    @Nullable
    public Handler renderThreadHandler;
    public long renderTimeNs;
    public long statisticsStartTimeNs;
    public boolean usePresentationTimeStamp;
    public final Object handlerLock = new Object();
    public final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList<>();
    public final Object fpsReductionLock = new Object();
    public final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
    public final Matrix drawMatrix = new Matrix();
    public final Object frameLock = new Object();
    public final Object layoutLock = new Object();
    public final Object statisticsLock = new Object();
    public final GlTextureFrameBuffer bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
    public final Runnable logStatisticsRunnable = new Runnable() { // from class: org.webrtc.EglRenderer.1
        @Override // java.lang.Runnable
        public void run() {
            EglRenderer.this.logStatistics();
            synchronized (EglRenderer.this.handlerLock) {
                if (EglRenderer.this.renderThreadHandler != null) {
                    EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
                    EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                }
            }
        }
    };
    public final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation();

    /* loaded from: classes7.dex */
    public class EglSurfaceCreation implements Runnable {
        public Object surface;

        public EglSurfaceCreation() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.surface != null && EglRenderer.this.eglBase != null && !EglRenderer.this.eglBase.hasSurface()) {
                    if (this.surface instanceof Surface) {
                        EglRenderer.this.eglBase.createSurface((Surface) this.surface);
                    } else if (!(this.surface instanceof SurfaceTexture)) {
                        throw new IllegalStateException("Invalid surface: " + this.surface);
                    } else {
                        EglRenderer.this.eglBase.createSurface((SurfaceTexture) this.surface);
                    }
                    EglRenderer.this.eglBase.makeCurrent();
                    GLES20.glPixelStorei(3317, 1);
                }
            }
        }

        public void setSurface(Object obj) {
            synchronized (this) {
                this.surface = obj;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f2, RendererCommon.GlDrawer glDrawer, boolean z) {
            this.listener = frameListener;
            this.scale = f2;
            this.drawer = glDrawer;
            this.applyFpsReduction = z;
        }
    }

    /* loaded from: classes7.dex */
    public static class HandlerWithExceptionCallback extends Handler {
        public final Runnable exceptionCallback;

        public HandlerWithExceptionCallback(Looper looper, Runnable runnable) {
            super(looper);
            this.exceptionCallback = runnable;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e2) {
                Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e2);
                this.exceptionCallback.run();
                throw e2;
            }
        }
    }

    public EglRenderer(String str) {
        this.name = str;
    }

    private String averageTimeAsString(long j, int i2) {
        if (i2 <= 0) {
            return AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        }
        return TimeUnit.NANOSECONDS.toMicros(j / i2) + " us";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSurfaceOnRenderThread(float f2, float f3, float f4, float f5) {
        EglBase eglBase = this.eglBase;
        if (eglBase == null || !eglBase.hasSurface()) {
            return;
        }
        logD("clearSurface");
        GLES20.glClearColor(f2, f3, f4, f5);
        GLES20.glClear(16384);
        this.eglBase.swapBuffers();
    }

    private void createEglSurfaceInternal(Object obj) {
        this.eglSurfaceCreationRunnable.setSurface(obj);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    public static /* synthetic */ void lambda$addFrameListener$3(EglRenderer eglRenderer, RendererCommon.GlDrawer glDrawer, FrameListener frameListener, float f2, boolean z) {
        if (glDrawer == null) {
            glDrawer = eglRenderer.drawer;
        }
        eglRenderer.frameListeners.add(new FrameListenerAndParams(frameListener, f2, glDrawer, z));
    }

    public static /* synthetic */ void lambda$init$0(EglRenderer eglRenderer, EglBase.Context context, int[] iArr) {
        EglBase create;
        if (context == null) {
            eglRenderer.logD("EglBase10.create context");
            create = EglBase_CC.createEgl10(iArr);
        } else {
            eglRenderer.logD("EglBase.create shared context");
            create = EglBase_CC.create(context, iArr);
        }
        eglRenderer.eglBase = create;
    }

    public static /* synthetic */ void lambda$release$1(EglRenderer eglRenderer, CountDownLatch countDownLatch) {
        RendererCommon.GlDrawer glDrawer = eglRenderer.drawer;
        if (glDrawer != null) {
            glDrawer.release();
            eglRenderer.drawer = null;
        }
        eglRenderer.frameDrawer.release();
        eglRenderer.bitmapTextureFramebuffer.release();
        if (eglRenderer.eglBase != null) {
            eglRenderer.logD("eglBase detach and release.");
            eglRenderer.eglBase.detachCurrent();
            eglRenderer.eglBase.release();
            eglRenderer.eglBase = null;
        }
        eglRenderer.frameListeners.clear();
        countDownLatch.countDown();
    }

    public static /* synthetic */ void lambda$release$2(EglRenderer eglRenderer, Looper looper) {
        eglRenderer.logD("Quitting render thread.");
        looper.quit();
    }

    public static /* synthetic */ void lambda$releaseEglSurface$5(EglRenderer eglRenderer, Runnable runnable) {
        EglBase eglBase = eglRenderer.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            eglRenderer.eglBase.releaseSurface();
        }
        runnable.run();
    }

    public static /* synthetic */ void lambda$removeFrameListener$4(EglRenderer eglRenderer, CountDownLatch countDownLatch, FrameListener frameListener) {
        countDownLatch.countDown();
        Iterator<FrameListenerAndParams> it = eglRenderer.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == frameListener) {
                it.remove();
            }
        }
    }

    private void logD(String str) {
        Logging.d(TAG, this.name + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logStatistics() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        long nanoTime = System.nanoTime();
        synchronized (this.statisticsLock) {
            long j = nanoTime - this.statisticsStartTimeNs;
            if (j <= 0) {
                return;
            }
            float nanos = ((float) (this.framesRendered * TimeUnit.SECONDS.toNanos(1L))) / ((float) j);
            logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + decimalFormat.format(nanos) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
            resetStatistics(nanoTime);
        }
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z) {
        FrameListener frameListener;
        Bitmap bitmap;
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        if (this.mirror) {
            this.drawMatrix.preScale(-1.0f, 1.0f);
        }
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            FrameListenerAndParams next = it.next();
            if (z || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * videoFrame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * videoFrame.getRotatedHeight());
                if (rotatedWidth == 0 || rotatedHeight == 0) {
                    frameListener = next.listener;
                    bitmap = null;
                } else {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, allocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    bitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                    bitmap.copyPixelsFromBuffer(allocateDirect);
                    frameListener = next.listener;
                }
                frameListener.onFrame(bitmap);
            }
        }
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler != null) {
                this.renderThreadHandler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread() {
        boolean z;
        float f2;
        float f3;
        float f4;
        synchronized (this.frameLock) {
            if (this.pendingFrame == null) {
                return;
            }
            VideoFrame videoFrame = this.pendingFrame;
            this.pendingFrame = null;
            EglBase eglBase = this.eglBase;
            if (eglBase == null || !eglBase.hasSurface()) {
                logD("Dropping frame - No surface");
            } else {
                synchronized (this.fpsReductionLock) {
                    if (this.minRenderPeriodNs != Long.MAX_VALUE) {
                        if (this.minRenderPeriodNs > 0) {
                            long nanoTime = System.nanoTime();
                            if (nanoTime < this.nextFrameTimeNs) {
                                logD("Skipping frame rendering - fps reduction is active.");
                            } else {
                                long j = this.nextFrameTimeNs + this.minRenderPeriodNs;
                                this.nextFrameTimeNs = j;
                                this.nextFrameTimeNs = Math.max(j, nanoTime);
                            }
                        }
                        z = true;
                    }
                    z = false;
                }
                long nanoTime2 = System.nanoTime();
                float rotatedWidth = videoFrame.getRotatedWidth() / videoFrame.getRotatedHeight();
                synchronized (this.layoutLock) {
                    f2 = this.layoutAspectRatio != 0.0f ? this.layoutAspectRatio : rotatedWidth;
                }
                if (rotatedWidth > f2) {
                    f4 = f2 / rotatedWidth;
                    f3 = 1.0f;
                } else {
                    f3 = rotatedWidth / f2;
                    f4 = 1.0f;
                }
                this.drawMatrix.reset();
                this.drawMatrix.preTranslate(0.5f, 0.5f);
                if (this.mirror) {
                    this.drawMatrix.preScale(-1.0f, 1.0f);
                }
                this.drawMatrix.preScale(f4, f3);
                this.drawMatrix.preTranslate(-0.5f, -0.5f);
                if (z) {
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                    long nanoTime3 = System.nanoTime();
                    if (this.usePresentationTimeStamp) {
                        this.eglBase.swapBuffers(videoFrame.getTimestampNs());
                    } else {
                        this.eglBase.swapBuffers();
                    }
                    long nanoTime4 = System.nanoTime();
                    synchronized (this.statisticsLock) {
                        this.framesRendered++;
                        this.renderTimeNs += nanoTime4 - nanoTime2;
                        this.renderSwapBufferTimeNs += nanoTime4 - nanoTime3;
                    }
                }
                notifyCallbacks(videoFrame, z);
            }
            videoFrame.release();
        }
    }

    private void resetStatistics(long j) {
        synchronized (this.statisticsLock) {
            this.statisticsStartTimeNs = j;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0L;
            this.renderSwapBufferTimeNs = 0L;
        }
    }

    public void addFrameListener(FrameListener frameListener, float f2) {
        addFrameListener(frameListener, f2, null, false);
    }

    public void addFrameListener(FrameListener frameListener, float f2, RendererCommon.GlDrawer glDrawer) {
        addFrameListener(frameListener, f2, glDrawer, false);
    }

    public void addFrameListener(final FrameListener frameListener, final float f2, @Nullable final RendererCommon.GlDrawer glDrawer, final boolean z) {
        postToRenderThread(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$RQnwmlnL5c18V7FwaqbMl6FsQRo
            @Override // java.lang.Runnable
            public final void run() {
                EglRenderer.lambda$addFrameListener$3(EglRenderer.this, glDrawer, frameListener, f2, z);
            }
        });
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void clearImage(final float f2, final float f3, final float f4, final float f5) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$rAPTAEHKQxRxBFU3vvHmF68TV5E
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.clearSurfaceOnRenderThread(f2, f3, f4, f5);
                }
            });
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void init(@Nullable EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        init(context, iArr, glDrawer, false);
    }

    public void init(@Nullable final EglBase.Context context, final int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler != null) {
                throw new IllegalStateException(this.name + "Already initialized");
            }
            logD("Initializing EglRenderer");
            this.drawer = glDrawer;
            this.usePresentationTimeStamp = z;
            HandlerThread handlerThread = new HandlerThread(this.name + TAG);
            handlerThread.start();
            HandlerWithExceptionCallback handlerWithExceptionCallback = new HandlerWithExceptionCallback(handlerThread.getLooper(), new Runnable() { // from class: org.webrtc.EglRenderer.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (EglRenderer.this.handlerLock) {
                        EglRenderer.this.renderThreadHandler = null;
                    }
                }
            });
            this.renderThreadHandler = handlerWithExceptionCallback;
            ThreadUtils.invokeAtFrontUninterruptibly(handlerWithExceptionCallback, new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$A5MPsBufyTiKpmjvPS46Dr9iaHs
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.lambda$init$0(EglRenderer.this, context, iArr);
                }
            });
            this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
            resetStatistics(System.nanoTime());
            this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        boolean z;
        synchronized (this.statisticsLock) {
            this.framesReceived++;
        }
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Dropping frame - Not initialized or already released.");
                return;
            }
            synchronized (this.frameLock) {
                z = this.pendingFrame != null;
                if (z) {
                    this.pendingFrame.release();
                }
                this.pendingFrame = videoFrame;
                videoFrame.retain();
                this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$vWDJEj1GWjHSjwoQQjEEK_IVOJE
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.renderFrameOnRenderThread();
                    }
                });
            }
            if (z) {
                synchronized (this.statisticsLock) {
                    this.framesDropped++;
                }
            }
        }
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void printStackTrace() {
        synchronized (this.handlerLock) {
            Thread thread = this.renderThreadHandler == null ? null : this.renderThreadHandler.getLooper().getThread();
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logD("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logD(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void release() {
        logD("Releasing.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Already released");
                return;
            }
            this.renderThreadHandler.removeCallbacks(this.logStatisticsRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$MFF8Cl7oJsgEmXm7UI2GkKtNTYY
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.lambda$release$1(EglRenderer.this, countDownLatch);
                }
            });
            final Looper looper = this.renderThreadHandler.getLooper();
            this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$0TOf6TQvvPy5g4d42QjmzelnDZI
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.lambda$release$2(EglRenderer.this, looper);
                }
            });
            this.renderThreadHandler = null;
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            synchronized (this.frameLock) {
                if (this.pendingFrame != null) {
                    this.pendingFrame.release();
                    this.pendingFrame = null;
                }
            }
            logD("Releasing done.");
        }
    }

    public void releaseEglSurface(final Runnable runnable) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                runnable.run();
                return;
            }
            this.renderThreadHandler.removeCallbacks(this.eglSurfaceCreationRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$ZLNzG80KHUk0Ad58984FOsNt9s8
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.lambda$releaseEglSurface$5(EglRenderer.this, runnable);
                }
            });
        }
    }

    public void removeFrameListener(final FrameListener frameListener) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread()) {
                throw new RuntimeException("removeFrameListener must not be called on the render thread.");
            }
            postToRenderThread(new Runnable() { // from class: org.webrtc._$$Lambda$EglRenderer$6uTxCXz4FQA7p26IUV3iP2Ty5gk
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.lambda$removeFrameListener$4(EglRenderer.this, countDownLatch, frameListener);
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        }
    }

    public void setFpsReduction(float f2) {
        logD("setFpsReduction: " + f2);
        synchronized (this.fpsReductionLock) {
            long j = this.minRenderPeriodNs;
            if (f2 <= 0.0f) {
                this.minRenderPeriodNs = Long.MAX_VALUE;
            } else {
                this.minRenderPeriodNs = ((float) TimeUnit.SECONDS.toNanos(1L)) / f2;
            }
            if (this.minRenderPeriodNs != j) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void setLayoutAspectRatio(float f2) {
        logD("setLayoutAspectRatio: " + f2);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = f2;
        }
    }

    public void setMirror(boolean z) {
        logD("setMirror: " + z);
        synchronized (this.layoutLock) {
            this.mirror = z;
        }
    }
}
