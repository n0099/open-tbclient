package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
@TargetApi(21)
/* loaded from: classes2.dex */
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPLAY_FLAGS = 3;
    public static final int VIRTUAL_DISPLAY_DPI = 400;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public CapturerObserver capturerObserver;
    public int height;
    public boolean isDisposed;
    @Nullable
    public MediaProjection mediaProjection;
    public final MediaProjection.Callback mediaProjectionCallback;
    @Nullable
    public MediaProjectionManager mediaProjectionManager;
    public final Intent mediaProjectionPermissionResultData;
    public long numCapturedFrames;
    @Nullable
    public SurfaceTextureHelper surfaceTextureHelper;
    @Nullable
    public VirtualDisplay virtualDisplay;
    public int width;

    public ScreenCapturerAndroid(Intent intent, MediaProjection.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mediaProjectionPermissionResultData = intent;
        this.mediaProjectionCallback = callback;
    }

    private void checkNotDisposed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.isDisposed) {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVirtualDisplay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.surfaceTextureHelper.setTextureSize(this.width, this.height);
            this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, 400, 3, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            synchronized (this) {
                checkNotDisposed();
                this.width = i2;
                this.height = i3;
                if (this.virtualDisplay == null) {
                    return;
                }
                ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable(this) { // from class: org.webrtc.ScreenCapturerAndroid.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ScreenCapturerAndroid this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
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
                            this.this$0.virtualDisplay.release();
                            this.this$0.createVirtualDisplay();
                        }
                    }
                });
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.isDisposed = true;
            }
        }
    }

    public long getNumCapturedFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.numCapturedFrames : invokeV.longValue;
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, surfaceTextureHelper, context, capturerObserver) == null) {
            synchronized (this) {
                checkNotDisposed();
                if (capturerObserver != null) {
                    this.capturerObserver = capturerObserver;
                    if (surfaceTextureHelper != null) {
                        this.surfaceTextureHelper = surfaceTextureHelper;
                        this.mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
                    } else {
                        throw new RuntimeException("surfaceTextureHelper not set.");
                    }
                } else {
                    throw new RuntimeException("capturerObserver not set.");
                }
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoFrame) == null) {
            this.numCapturedFrames++;
            this.capturerObserver.onFrameCaptured(videoFrame);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void startCapture(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            synchronized (this) {
                checkNotDisposed();
                this.width = i2;
                this.height = i3;
                MediaProjection mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
                this.mediaProjection = mediaProjection;
                mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
                createVirtualDisplay();
                this.capturerObserver.onCapturerStarted(true);
                this.surfaceTextureHelper.startListening(this);
            }
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void stopCapture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                checkNotDisposed();
                ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable(this) { // from class: org.webrtc.ScreenCapturerAndroid.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ScreenCapturerAndroid this$0;

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
                            this.this$0.surfaceTextureHelper.stopListening();
                            this.this$0.capturerObserver.onCapturerStopped();
                            if (this.this$0.virtualDisplay != null) {
                                this.this$0.virtualDisplay.release();
                                this.this$0.virtualDisplay = null;
                            }
                            if (this.this$0.mediaProjection != null) {
                                this.this$0.mediaProjection.unregisterCallback(this.this$0.mediaProjectionCallback);
                                this.this$0.mediaProjection.stop();
                                this.this$0.mediaProjection = null;
                            }
                        }
                    }
                });
            }
        }
    }
}
