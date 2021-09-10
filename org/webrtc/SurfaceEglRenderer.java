package org.webrtc;

import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
/* loaded from: classes2.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SurfaceEglRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public int frameRotation;
    public boolean isFirstFrameRendered;
    public boolean isRenderingPaused;
    public final Object layoutLock;
    public RendererCommon.RendererEvents rendererEvents;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceEglRenderer(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.layoutLock = new Object();
    }

    private void logD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            Logging.d(TAG, this.name + ": " + str);
        }
    }

    private void updateFrameDimensionsAndReportEvents(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, videoFrame) == null) {
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
    }

    @Override // org.webrtc.EglRenderer
    public void disableFpsReduction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = false;
            }
            super.disableFpsReduction();
        }
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rendererEvents, iArr, glDrawer) == null) {
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
    }

    @Override // org.webrtc.EglRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoFrame) == null) {
            updateFrameDimensionsAndReportEvents(videoFrame);
            super.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.EglRenderer
    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = true;
            }
            super.pauseVideo();
        }
    }

    @Override // org.webrtc.EglRenderer
    public void setFpsReduction(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = f2 == 0.0f;
            }
            super.setFpsReduction(f2);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, surfaceHolder, i2, i3, i4) == null) {
            ThreadUtils.checkIsOnMainThread();
            logD("surfaceChanged: format: " + i2 + " size: " + i3 + "x" + i4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) {
            ThreadUtils.checkIsOnMainThread();
            createEglSurface(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) {
            ThreadUtils.checkIsOnMainThread();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            countDownLatch.getClass();
            releaseEglSurface(new Runnable() { // from class: h.c.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        countDownLatch.countDown();
                    }
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        }
    }

    @Override // org.webrtc.EglRenderer
    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, iArr, glDrawer) == null) {
            init(context, (RendererCommon.RendererEvents) null, iArr, glDrawer);
        }
    }
}
