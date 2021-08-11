package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
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

    public SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        this.timestampAligner = z ? new TimestampAligner() : null;
        EglBase create = EglBase_CC.create(context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = create;
        try {
            create.createDummyPbufferSurface();
            this.eglBase.makeCurrent();
            this.oesTextureId = GlUtil.generateTexture(36197);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.oesTextureId);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$7YTfC0byyd0o_zI7mNhfP12Gm0Q
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture2) == null) {
                        SurfaceTextureHelper.lambda$new$0(SurfaceTextureHelper.this, surfaceTexture2);
                    }
                }
            }, handler);
        } catch (RuntimeException e2) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e2;
        }
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, context)) == null) ? create(str, context, false) : (SurfaceTextureHelper) invokeLL.objValue;
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, str, context, z)) == null) {
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        } catch (RuntimeException e2) {
                            Logging.e(SurfaceTextureHelper.TAG, this.val$threadName + " create failure", e2);
                            return null;
                        }
                    }
                    return (SurfaceTextureHelper) invokeV.objValue;
                }
            });
        }
        return (SurfaceTextureHelper) invokeLLZ.objValue;
    }

    public static /* synthetic */ void lambda$dispose$5(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.isQuitting = true;
        if (surfaceTextureHelper.isTextureInUse) {
            return;
        }
        surfaceTextureHelper.release();
    }

    public static /* synthetic */ void lambda$new$0(SurfaceTextureHelper surfaceTextureHelper, SurfaceTexture surfaceTexture) {
        surfaceTextureHelper.hasPendingTexture = true;
        surfaceTextureHelper.tryDeliverTextureFrame();
    }

    public static /* synthetic */ void lambda$returnTextureFrame$4(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.isTextureInUse = false;
        if (surfaceTextureHelper.isQuitting) {
            surfaceTextureHelper.release();
        } else {
            surfaceTextureHelper.tryDeliverTextureFrame();
        }
    }

    public static /* synthetic */ void lambda$setTextureSize$2(SurfaceTextureHelper surfaceTextureHelper, int i2, int i3) {
        surfaceTextureHelper.textureWidth = i2;
        surfaceTextureHelper.textureHeight = i3;
    }

    public static /* synthetic */ void lambda$stopListening$1(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.listener = null;
        surfaceTextureHelper.pendingListener = null;
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (this.handler.getLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException("Wrong thread.");
            }
            if (this.isTextureInUse || !this.isQuitting) {
                throw new IllegalStateException("Unexpected release.");
            }
            this.yuvConverter.release();
            GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
            this.surfaceTexture.release();
            this.eglBase.release();
            this.handler.getLooper().quit();
            TimestampAligner timestampAligner = this.timestampAligner;
            if (timestampAligner != null) {
                timestampAligner.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.handler.post(new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$jxH_WSP9WRRQypdzvhBYUcJFCM0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.lambda$returnTextureFrame$4(SurfaceTextureHelper.this);
                    }
                }
            });
        }
    }

    @TargetApi(21)
    public static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, surfaceTexture, onFrameAvailableListener, handler) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
        }
    }

    private void tryDeliverTextureFrame() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            if (this.handler.getLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException("Wrong thread.");
            }
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
            int i3 = this.textureWidth;
            if (i3 == 0 || (i2 = this.textureHeight) == 0) {
                throw new RuntimeException("Texture size has not been set.");
            }
            VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(i3, i2, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$f5MmHIrjRN2jF8_ug65BMPrG30U
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            synchronized (EglBase.lock) {
                this.surfaceTexture.updateTexImage();
            }
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Logging.d(TAG, "dispose()");
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$_rN_9eOQ_CNGCBfz4icb_qNtPGs
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.lambda$dispose$5(SurfaceTextureHelper.this);
                    }
                }
            });
        }
    }

    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public SurfaceTexture getSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.surfaceTexture : (SurfaceTexture) invokeV.objValue;
    }

    public boolean isTextureInUse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isTextureInUse : invokeV.booleanValue;
    }

    public void setFrameRotation(final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.handler.post(new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$8I9BGYh1ysN70toph_WhdCfZCQ4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.this.frameRotation = i2;
                    }
                }
            });
        }
    }

    public void setTextureSize(final int i2, final int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Texture width must be positive, but was " + i2);
            } else if (i3 > 0) {
                this.surfaceTexture.setDefaultBufferSize(i2, i3);
                this.handler.post(new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$zvo_pspqaGa7qu1SNsn_kRedNVk
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SurfaceTextureHelper.lambda$setTextureSize$2(SurfaceTextureHelper.this, i2, i3);
                        }
                    }
                });
            } else {
                throw new IllegalArgumentException("Texture height must be positive, but was " + i3);
            }
        }
    }

    public void startListening(VideoSink videoSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, videoSink) == null) {
            if (this.listener != null || this.pendingListener != null) {
                throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
            }
            this.pendingListener = videoSink;
            this.handler.post(this.setListenerRunnable);
        }
    }

    public void stopListening() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Logging.d(TAG, "stopListening()");
            this.handler.removeCallbacks(this.setListenerRunnable);
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.webrtc._$$Lambda$SurfaceTextureHelper$Z2b9yhA_jJLZ9Hj7bJkKc8ZG0po
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceTextureHelper.lambda$stopListening$1(SurfaceTextureHelper.this);
                    }
                }
            });
        }
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textureBuffer)) == null) ? textureBuffer.toI420() : (VideoFrame.I420Buffer) invokeL.objValue;
    }
}
