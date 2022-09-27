package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
/* loaded from: classes9.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SurfaceViewRenderer";
    public transient /* synthetic */ FieldHolder $fh;
    public final SurfaceEglRenderer eglRenderer;
    public boolean enableFixedSize;
    public RendererCommon.RendererEvents rendererEvents;
    public final String resourceName;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    public int surfaceHeight;
    public int surfaceWidth;
    public final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewRenderer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        getHolder().addCallback(this);
        getHolder().addCallback(this.eglRenderer);
    }

    private String getResourceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                return getResources().getResourceEntryName(getId());
            } catch (Resources.NotFoundException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    private void logD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            Logging.d(TAG, this.resourceName + ": " + str);
        }
    }

    private void postOrRun(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, runnable) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private void updateSurfaceSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ThreadUtils.checkIsOnMainThread();
            if (this.enableFixedSize && this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0 && getWidth() != 0 && getHeight() != 0) {
                float width = getWidth() / getHeight();
                int i = this.rotatedFrameWidth;
                int i2 = this.rotatedFrameHeight;
                if (i / i2 > width) {
                    i = (int) (i2 * width);
                } else {
                    i2 = (int) (i / width);
                }
                int min = Math.min(getWidth(), i);
                int min2 = Math.min(getHeight(), i2);
                logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + min + "x" + min2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
                if (min == this.surfaceWidth && min2 == this.surfaceHeight) {
                    return;
                }
                this.surfaceWidth = min;
                this.surfaceHeight = min2;
                getHolder().setFixedSize(min, min2);
                return;
            }
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            getHolder().setSizeFromLayout();
        }
    }

    public /* synthetic */ void a(int i, int i2) {
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
        updateSurfaceSize();
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{frameListener, Float.valueOf(f), glDrawer}) == null) {
            this.eglRenderer.addFrameListener(frameListener, f, glDrawer);
        }
    }

    public void clearImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.eglRenderer.clearImage();
        }
    }

    public void disableFpsReduction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.eglRenderer.disableFpsReduction();
        }
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, rendererEvents) == null) {
            init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (rendererEvents = this.rendererEvents) == null) {
            return;
        }
        rendererEvents.onFirstFrameRendered();
    }

    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoFrame) == null) {
            this.eglRenderer.onFrame(videoFrame);
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i, i2, i3) == null) {
            RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
            if (rendererEvents != null) {
                rendererEvents.onFrameResolutionChanged(i, i2, i3);
            }
            final int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            postOrRun(new Runnable() { // from class: com.baidu.tieba.lw9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SurfaceViewRenderer.this.a(i4, i);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.eglRenderer.setLayoutAspectRatio((i3 - i) / (i4 - i2));
            updateSurfaceSize();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            ThreadUtils.checkIsOnMainThread();
            Point measure = this.videoLayoutMeasure.measure(i, i2, this.rotatedFrameWidth, this.rotatedFrameHeight);
            setMeasuredDimension(measure.x, measure.y);
            logD("onMeasure(). New size: " + measure.x + "x" + measure.y);
        }
    }

    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.eglRenderer.pauseVideo();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.eglRenderer.release();
        }
    }

    public void removeFrameListener(EglRenderer.FrameListener frameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameListener) == null) {
            this.eglRenderer.removeFrameListener(frameListener);
        }
    }

    public void setEnableHardwareScaler(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.enableFixedSize = z;
            updateSurfaceSize();
        }
    }

    public void setFpsReduction(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.eglRenderer.setFpsReduction(f);
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.eglRenderer.setMirror(z);
        }
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scalingType) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.videoLayoutMeasure.setScalingType(scalingType);
            requestLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048596, this, surfaceHolder, i, i2, i3) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, surfaceHolder) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            updateSurfaceSize();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, surfaceHolder) == null) {
        }
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameListener, f) == null) {
            this.eglRenderer.addFrameListener(frameListener, f);
        }
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, rendererEvents, iArr, glDrawer) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.rendererEvents = rendererEvents;
            this.rotatedFrameWidth = 0;
            this.rotatedFrameHeight = 0;
            this.eglRenderer.init(context, this, iArr, glDrawer);
        }
    }

    public void setScalingType(RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, scalingType, scalingType2) == null) {
            ThreadUtils.checkIsOnMainThread();
            this.videoLayoutMeasure.setScalingType(scalingType, scalingType2);
            requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        getHolder().addCallback(this);
        getHolder().addCallback(this.eglRenderer);
    }
}
