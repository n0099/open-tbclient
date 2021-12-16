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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import h.c.i0;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;
/* loaded from: classes4.dex */
public class EglRenderer implements VideoSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long LOG_INTERVAL_SEC = 4;
    public static final String TAG = "EglRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public final GlTextureFrameBuffer bitmapTextureFramebuffer;
    public final Matrix drawMatrix;
    @Nullable
    public RendererCommon.GlDrawer drawer;
    @Nullable
    public EglBase eglBase;
    public final EglSurfaceCreation eglSurfaceCreationRunnable;
    public final Object fpsReductionLock;
    public final VideoFrameDrawer frameDrawer;
    public final ArrayList<FrameListenerAndParams> frameListeners;
    public final Object frameLock;
    public int framesDropped;
    public int framesReceived;
    public int framesRendered;
    public final Object handlerLock;
    public float layoutAspectRatio;
    public final Object layoutLock;
    public final Runnable logStatisticsRunnable;
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
    public final Object statisticsLock;
    public long statisticsStartTimeNs;
    public boolean usePresentationTimeStamp;

    /* loaded from: classes4.dex */
    public class EglSurfaceCreation implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object surface;
        public final /* synthetic */ EglRenderer this$0;

        public EglSurfaceCreation(EglRenderer eglRenderer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eglRenderer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eglRenderer;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.surface != null && this.this$0.eglBase != null && !this.this$0.eglBase.hasSurface()) {
                        if (this.surface instanceof Surface) {
                            this.this$0.eglBase.createSurface((Surface) this.surface);
                        } else if (this.surface instanceof SurfaceTexture) {
                            this.this$0.eglBase.createSurface((SurfaceTexture) this.surface);
                        } else {
                            throw new IllegalStateException("Invalid surface: " + this.surface);
                        }
                        this.this$0.eglBase.makeCurrent();
                        GLES20.glPixelStorei(3317, 1);
                    }
                }
            }
        }

        public synchronized void setSurface(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                synchronized (this) {
                    this.surface = obj;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public static class FrameListenerAndParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f2, RendererCommon.GlDrawer glDrawer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameListener, Float.valueOf(f2), glDrawer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.listener = frameListener;
            this.scale = f2;
            this.drawer = glDrawer;
            this.applyFpsReduction = z;
        }
    }

    /* loaded from: classes4.dex */
    public static class HandlerWithExceptionCallback extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Runnable exceptionCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerWithExceptionCallback(Looper looper, Runnable runnable) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.exceptionCallback = runnable;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    super.dispatchMessage(message);
                } catch (Exception e2) {
                    Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e2);
                    this.exceptionCallback.run();
                    throw e2;
                }
            }
        }
    }

    public EglRenderer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList<>();
        this.fpsReductionLock = new Object();
        this.frameDrawer = new VideoFrameDrawer();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(GeneratedTexture.FORMAT);
        this.logStatisticsRunnable = new Runnable(this) { // from class: org.webrtc.EglRenderer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EglRenderer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.logStatistics();
                    synchronized (this.this$0.handlerLock) {
                        if (this.this$0.renderThreadHandler != null) {
                            this.this$0.renderThreadHandler.removeCallbacks(this.this$0.logStatisticsRunnable);
                            this.this$0.renderThreadHandler.postDelayed(this.this$0.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                        }
                    }
                }
            }
        };
        this.eglSurfaceCreationRunnable = new EglSurfaceCreation();
        this.name = str;
    }

    private String averageTimeAsString(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (i2 <= 0) {
                return "NA";
            }
            return TimeUnit.NANOSECONDS.toMicros(j2 / i2) + " us";
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearSurfaceOnRenderThread */
    public void b(float f2, float f3, float f4, float f5) {
        EglBase eglBase;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && (eglBase = this.eglBase) != null && eglBase.hasSurface()) {
            logD("clearSurface");
            GLES20.glClearColor(f2, f3, f4, f5);
            GLES20.glClear(16384);
            this.eglBase.swapBuffers();
        }
    }

    private void createEglSurfaceInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, obj) == null) {
            this.eglSurfaceCreationRunnable.setSurface(obj);
            postToRenderThread(this.eglSurfaceCreationRunnable);
        }
    }

    private void logD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            Logging.d(TAG, this.name + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            long nanoTime = System.nanoTime();
            synchronized (this.statisticsLock) {
                long j2 = nanoTime - this.statisticsStartTimeNs;
                if (j2 <= 0) {
                    return;
                }
                float nanos = ((float) (this.framesRendered * TimeUnit.SECONDS.toNanos(1L))) / ((float) j2);
                logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j2) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + decimalFormat.format(nanos) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
                resetStatistics(nanoTime);
            }
        }
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65549, this, videoFrame, z) == null) || this.frameListeners.isEmpty()) {
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
                if (rotatedWidth != 0 && rotatedHeight != 0) {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, GeneratedTexture.FORMAT, 5121, allocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    next.listener.onFrame(createBitmap);
                } else {
                    next.listener.onFrame(null);
                }
            }
        }
    }

    private void postToRenderThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, runnable) == null) {
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler != null) {
                    this.renderThreadHandler.post(runnable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread() {
        boolean z;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            synchronized (this.frameLock) {
                if (this.pendingFrame == null) {
                    return;
                }
                VideoFrame videoFrame = this.pendingFrame;
                this.pendingFrame = null;
                EglBase eglBase = this.eglBase;
                if (eglBase != null && eglBase.hasSurface()) {
                    synchronized (this.fpsReductionLock) {
                        if (this.minRenderPeriodNs != Long.MAX_VALUE) {
                            if (this.minRenderPeriodNs > 0) {
                                long nanoTime = System.nanoTime();
                                if (nanoTime < this.nextFrameTimeNs) {
                                    logD("Skipping frame rendering - fps reduction is active.");
                                } else {
                                    long j2 = this.nextFrameTimeNs + this.minRenderPeriodNs;
                                    this.nextFrameTimeNs = j2;
                                    this.nextFrameTimeNs = Math.max(j2, nanoTime);
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
                    videoFrame.release();
                    return;
                }
                logD("Dropping frame - No surface");
                videoFrame.release();
            }
        }
    }

    private void resetStatistics(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65552, this, j2) == null) {
            synchronized (this.statisticsLock) {
                this.statisticsStartTimeNs = j2;
                this.framesReceived = 0;
                this.framesDropped = 0;
                this.framesRendered = 0;
                this.renderTimeNs = 0L;
                this.renderSwapBufferTimeNs = 0L;
            }
        }
    }

    public /* synthetic */ void a(RendererCommon.GlDrawer glDrawer, FrameListener frameListener, float f2, boolean z) {
        if (glDrawer == null) {
            glDrawer = this.drawer;
        }
        this.frameListeners.add(new FrameListenerAndParams(frameListener, f2, glDrawer, z));
    }

    public void addFrameListener(FrameListener frameListener, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameListener, f2) == null) {
            addFrameListener(frameListener, f2, null, false);
        }
    }

    public /* synthetic */ void c(EglBase.Context context, int[] iArr) {
        if (context == null) {
            logD("EglBase10.create context");
            this.eglBase = i0.d(iArr);
            return;
        }
        logD("EglBase.create shared context");
        this.eglBase = i0.c(context, iArr);
    }

    public void clearImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            clearImage(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void createEglSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, surface) == null) {
            createEglSurfaceInternal(surface);
        }
    }

    public /* synthetic */ void d(CountDownLatch countDownLatch) {
        RendererCommon.GlDrawer glDrawer = this.drawer;
        if (glDrawer != null) {
            glDrawer.release();
            this.drawer = null;
        }
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase != null) {
            logD("eglBase detach and release.");
            this.eglBase.detachCurrent();
            this.eglBase.release();
            this.eglBase = null;
        }
        this.frameListeners.clear();
        countDownLatch.countDown();
    }

    public void disableFpsReduction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            setFpsReduction(Float.POSITIVE_INFINITY);
        }
    }

    public /* synthetic */ void e(Looper looper) {
        logD("Quitting render thread.");
        looper.quit();
    }

    public /* synthetic */ void f(Runnable runnable) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            this.eglBase.releaseSurface();
        }
        runnable.run();
    }

    public /* synthetic */ void g(CountDownLatch countDownLatch, FrameListener frameListener) {
        countDownLatch.countDown();
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == frameListener) {
                it.remove();
            }
        }
    }

    public void init(@Nullable final EglBase.Context context, final int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, iArr, glDrawer, Boolean.valueOf(z)}) == null) {
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler == null) {
                    logD("Initializing EglRenderer");
                    this.drawer = glDrawer;
                    this.usePresentationTimeStamp = z;
                    HandlerThread handlerThread = new HandlerThread(this.name + TAG);
                    handlerThread.start();
                    HandlerWithExceptionCallback handlerWithExceptionCallback = new HandlerWithExceptionCallback(handlerThread.getLooper(), new Runnable(this) { // from class: org.webrtc.EglRenderer.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ EglRenderer this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                synchronized (this.this$0.handlerLock) {
                                    this.this$0.renderThreadHandler = null;
                                }
                            }
                        }
                    });
                    this.renderThreadHandler = handlerWithExceptionCallback;
                    ThreadUtils.invokeAtFrontUninterruptibly(handlerWithExceptionCallback, new Runnable() { // from class: h.c.i
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                EglRenderer.this.c(context, iArr);
                            }
                        }
                    });
                    this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
                    resetStatistics(System.nanoTime());
                    this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                } else {
                    throw new IllegalStateException(this.name + "Already initialized");
                }
            }
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoFrame) == null) {
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
                    this.renderThreadHandler.post(new Runnable() { // from class: h.c.n
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                EglRenderer.this.renderFrameOnRenderThread();
                            }
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
    }

    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setFpsReduction(0.0f);
        }
    }

    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            logD("Releasing.");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler == null) {
                    logD("Already released");
                    return;
                }
                this.renderThreadHandler.removeCallbacks(this.logStatisticsRunnable);
                this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: h.c.j
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            EglRenderer.this.d(countDownLatch);
                        }
                    }
                });
                final Looper looper = this.renderThreadHandler.getLooper();
                this.renderThreadHandler.post(new Runnable() { // from class: h.c.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            EglRenderer.this.e(looper);
                        }
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
    }

    public void releaseEglSurface(final Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, runnable) == null) {
            this.eglSurfaceCreationRunnable.setSurface(null);
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler != null) {
                    this.renderThreadHandler.removeCallbacks(this.eglSurfaceCreationRunnable);
                    this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: h.c.l
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                EglRenderer.this.f(runnable);
                            }
                        }
                    });
                    return;
                }
                runnable.run();
            }
        }
    }

    public void removeFrameListener(final FrameListener frameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, frameListener) == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler == null) {
                    return;
                }
                if (Thread.currentThread() != this.renderThreadHandler.getLooper().getThread()) {
                    postToRenderThread(new Runnable() { // from class: h.c.h
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                EglRenderer.this.g(countDownLatch, frameListener);
                            }
                        }
                    });
                    ThreadUtils.awaitUninterruptibly(countDownLatch);
                    return;
                }
                throw new RuntimeException("removeFrameListener must not be called on the render thread.");
            }
        }
    }

    public void setFpsReduction(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            logD("setFpsReduction: " + f2);
            synchronized (this.fpsReductionLock) {
                long j2 = this.minRenderPeriodNs;
                if (f2 <= 0.0f) {
                    this.minRenderPeriodNs = Long.MAX_VALUE;
                } else {
                    this.minRenderPeriodNs = ((float) TimeUnit.SECONDS.toNanos(1L)) / f2;
                }
                if (this.minRenderPeriodNs != j2) {
                    this.nextFrameTimeNs = System.nanoTime();
                }
            }
        }
    }

    public void setLayoutAspectRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            logD("setLayoutAspectRatio: " + f2);
            synchronized (this.layoutLock) {
                this.layoutAspectRatio = f2;
            }
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            logD("setMirror: " + z);
            synchronized (this.layoutLock) {
                this.mirror = z;
            }
        }
    }

    public void addFrameListener(FrameListener frameListener, float f2, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{frameListener, Float.valueOf(f2), glDrawer}) == null) {
            addFrameListener(frameListener, f2, glDrawer, false);
        }
    }

    public void clearImage(final float f2, final float f3, final float f4, final float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            synchronized (this.handlerLock) {
                if (this.renderThreadHandler == null) {
                    return;
                }
                this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: h.c.m
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            EglRenderer.this.b(f2, f3, f4, f5);
                        }
                    }
                });
            }
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture) == null) {
            createEglSurfaceInternal(surfaceTexture);
        }
    }

    public void addFrameListener(final FrameListener frameListener, final float f2, @Nullable final RendererCommon.GlDrawer glDrawer, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{frameListener, Float.valueOf(f2), glDrawer, Boolean.valueOf(z)}) == null) {
            postToRenderThread(new Runnable() { // from class: h.c.k
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EglRenderer.this.a(glDrawer, frameListener, f2, z);
                    }
                }
            });
        }
    }

    public void init(@Nullable EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, iArr, glDrawer) == null) {
            init(context, iArr, glDrawer, false);
        }
    }
}
