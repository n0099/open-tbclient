package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.su9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoFrame;
/* loaded from: classes8.dex */
public class SurfaceTextureHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SurfaceTextureHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public final EglBase eglBase;
    public int frameRotation;
    public final Handler handler;
    public boolean hasPendingTexture;
    public boolean isQuitting;
    public volatile boolean isTextureInUse;
    @Nullable
    public VideoSink listener;
    public final int oesTextureId;
    @Nullable
    public VideoSink pendingListener;
    public final Runnable setListenerRunnable;
    public final SurfaceTexture surfaceTexture;
    public int textureHeight;
    public int textureWidth;
    @Nullable
    public final TimestampAligner timestampAligner;
    public final YuvConverter yuvConverter;

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, str, context, z)) == null) {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<SurfaceTextureHelper>(context, handler, z, str) { // from class: org.webrtc.SurfaceTextureHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean val$alignTimestamps;
                public final /* synthetic */ Handler val$handler;
                public final /* synthetic */ EglBase.Context val$sharedContext;
                public final /* synthetic */ String val$threadName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, handler, Boolean.valueOf(z), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$sharedContext = context;
                    this.val$handler = handler;
                    this.val$alignTimestamps = z;
                    this.val$threadName = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                @Nullable
                public SurfaceTextureHelper call() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        try {
                            return new SurfaceTextureHelper(this.val$sharedContext, this.val$handler, this.val$alignTimestamps);
                        } catch (RuntimeException e) {
                            Logging.e(SurfaceTextureHelper.TAG, this.val$threadName + " create failure", e);
                            return null;
                        }
                    }
                    return (SurfaceTextureHelper) invokeV.objValue;
                }
            });
        }
        return (SurfaceTextureHelper) invokeLLZ.objValue;
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.handler.getLooper().getThread() == Thread.currentThread()) {
                if (!this.isTextureInUse && this.isQuitting) {
                    this.yuvConverter.release();
                    GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
                    this.surfaceTexture.release();
                    this.eglBase.release();
                    this.handler.getLooper().quit();
                    TimestampAligner timestampAligner = this.timestampAligner;
                    if (timestampAligner != null) {
                        timestampAligner.dispose();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unexpected release.");
            }
            throw new IllegalStateException("Wrong thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.handler.post(new Runnable() { // from class: com.baidu.tieba.eu9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.this.d();
                    }
                }
            });
        }
    }

    @TargetApi(21)
    public static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, surfaceTexture, onFrameAvailableListener, handler) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
        }
    }

    private void tryDeliverTextureFrame() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.handler.getLooper().getThread() == Thread.currentThread()) {
                if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
                    return;
                }
                this.isTextureInUse = true;
                this.hasPendingTexture = false;
                updateTexImage();
                float[] fArr = new float[16];
                this.surfaceTexture.getTransformMatrix(fArr);
                long timestamp = this.surfaceTexture.getTimestamp();
                TimestampAligner timestampAligner = this.timestampAligner;
                if (timestampAligner != null) {
                    timestamp = timestampAligner.translateTimestamp(timestamp);
                }
                int i2 = this.textureWidth;
                if (i2 != 0 && (i = this.textureHeight) != 0) {
                    VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(i2, i, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, new Runnable() { // from class: com.baidu.tieba.du9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                SurfaceTextureHelper.this.returnTextureFrame();
                            }
                        }
                    }), this.frameRotation, timestamp);
                    this.listener.onFrame(videoFrame);
                    videoFrame.release();
                    return;
                }
                throw new RuntimeException("Texture size has not been set.");
            }
            throw new IllegalStateException("Wrong thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            synchronized (EglBase.lock) {
                this.surfaceTexture.updateTexImage();
            }
        }
    }

    public /* synthetic */ void a() {
        this.isQuitting = true;
        if (this.isTextureInUse) {
            return;
        }
        release();
    }

    public /* synthetic */ void c(SurfaceTexture surfaceTexture) {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    public /* synthetic */ void d() {
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            tryDeliverTextureFrame();
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Logging.d(TAG, "dispose()");
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: com.baidu.tieba.cu9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.this.a();
                    }
                }
            });
        }
    }

    public /* synthetic */ void e(int i) {
        this.frameRotation = i;
    }

    public /* synthetic */ void f(int i, int i2) {
        this.textureWidth = i;
        this.textureHeight = i2;
    }

    public /* synthetic */ void g() {
        this.listener = null;
        this.pendingListener = null;
    }

    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public SurfaceTexture getSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.surfaceTexture : (SurfaceTexture) invokeV.objValue;
    }

    public boolean isTextureInUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isTextureInUse : invokeV.booleanValue;
    }

    public void setFrameRotation(final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.handler.post(new Runnable() { // from class: com.baidu.tieba.au9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.this.e(i);
                    }
                }
            });
        }
    }

    public void setTextureSize(final int i, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            if (i <= 0) {
                throw new IllegalArgumentException("Texture width must be positive, but was " + i);
            } else if (i2 > 0) {
                this.surfaceTexture.setDefaultBufferSize(i, i2);
                this.handler.post(new Runnable() { // from class: com.baidu.tieba.fu9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SurfaceTextureHelper.this.f(i, i2);
                        }
                    }
                });
            } else {
                throw new IllegalArgumentException("Texture height must be positive, but was " + i2);
            }
        }
    }

    public void startListening(VideoSink videoSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, videoSink) == null) {
            if (this.listener == null && this.pendingListener == null) {
                this.pendingListener = videoSink;
                this.handler.post(this.setListenerRunnable);
                return;
            }
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
    }

    public void stopListening() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Logging.d(TAG, "stopListening()");
            this.handler.removeCallbacks(this.setListenerRunnable);
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: com.baidu.tieba.bu9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.this.g();
                    }
                }
            });
        }
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, textureBuffer)) == null) ? textureBuffer.toI420() : (VideoFrame.I420Buffer) invokeL.objValue;
    }

    public SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.yuvConverter = new YuvConverter();
        this.setListenerRunnable = new Runnable(this) { // from class: org.webrtc.SurfaceTextureHelper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SurfaceTextureHelper this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    Logging.d(SurfaceTextureHelper.TAG, "Setting listener to " + this.this$0.pendingListener);
                    SurfaceTextureHelper surfaceTextureHelper = this.this$0;
                    surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                    this.this$0.pendingListener = null;
                    if (this.this$0.hasPendingTexture) {
                        this.this$0.updateTexImage();
                        this.this$0.hasPendingTexture = false;
                    }
                }
            }
        };
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            this.handler = handler;
            this.timestampAligner = z ? new TimestampAligner() : null;
            EglBase c = su9.c(context, EglBase.CONFIG_PIXEL_BUFFER);
            this.eglBase = c;
            try {
                c.createDummyPbufferSurface();
                this.eglBase.makeCurrent();
                this.oesTextureId = GlUtil.generateTexture(36197);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.oesTextureId);
                this.surfaceTexture = surfaceTexture;
                setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.tieba.zt9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture2) == null) {
                            SurfaceTextureHelper.this.c(surfaceTexture2);
                        }
                    }
                }, handler);
                return;
            } catch (RuntimeException e) {
                this.eglBase.release();
                handler.getLooper().quit();
                throw e;
            }
        }
        throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, context)) == null) ? create(str, context, false) : (SurfaceTextureHelper) invokeLL.objValue;
    }
}
