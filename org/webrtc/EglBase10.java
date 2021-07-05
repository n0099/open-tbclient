package org.webrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import javax.annotation.Nullable;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase;
/* loaded from: classes10.dex */
public class EglBase10 implements EglBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    public transient /* synthetic */ FieldHolder $fh;
    public final EGL10 egl;
    @Nullable
    public EGLConfig eglConfig;
    public EGLContext eglContext;
    public EGLDisplay eglDisplay;
    public EGLSurface eglSurface;

    /* loaded from: classes10.dex */
    public static class Context implements EglBase.Context {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final EGLContext eglContext;

        public Context(EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eGLContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.eglContext = eGLContext;
        }

        @Override // org.webrtc.EglBase.Context
        public long getNativeEglContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }
    }

    public EglBase10(Context context, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.eglSurface = EGL10.EGL_NO_SURFACE;
        this.egl = (EGL10) EGLContext.getEGL();
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        EGLConfig eglConfig = getEglConfig(eglDisplay, iArr);
        this.eglConfig = eglConfig;
        this.eglContext = createEglContext(context, this.eglDisplay, eglConfig);
    }

    private void checkIsNotReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.eglDisplay == EGL10.EGL_NO_DISPLAY || this.eglContext == EGL10.EGL_NO_CONTEXT || this.eglConfig == null) {
                throw new RuntimeException("This object has been released");
            }
        }
    }

    private EGLContext createEglContext(@Nullable Context context, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        InterceptResult invokeLLL;
        EGLContext eglCreateContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, eGLDisplay, eGLConfig)) == null) {
            if (context == null || context.eglContext != EGL10.EGL_NO_CONTEXT) {
                EGLContext eGLContext = context == null ? EGL10.EGL_NO_CONTEXT : context.eglContext;
                synchronized (EglBase.lock) {
                    eglCreateContext = this.egl.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
                }
                if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                    return eglCreateContext;
                }
                throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(this.egl.eglGetError()));
            }
            throw new RuntimeException("Invalid sharedContext");
        }
        return (EGLContext) invokeLLL.objValue;
    }

    private void createSurfaceInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, obj) == null) {
            if (!(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture)) {
                throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
            }
            checkIsNotReleased();
            if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
                throw new RuntimeException("Already has an EGLSurface");
            }
            EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
            this.eglSurface = eglCreateWindowSurface;
            if (eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                return;
            }
            throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(this.egl.eglGetError()));
        }
    }

    private EGLConfig getEglConfig(EGLDisplay eGLDisplay, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, eGLDisplay, iArr)) == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            if (!this.egl.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2)) {
                throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
            } else if (iArr2[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (eGLConfig != null) {
                    return eGLConfig;
                }
                throw new RuntimeException("eglChooseConfig returned null");
            } else {
                throw new RuntimeException("Unable to find any matching EGL config");
            }
        }
        return (EGLConfig) invokeLL.objValue;
    }

    private EGLDisplay getEglDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            EGLDisplay eglGetDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("Unable to get EGL10 display: 0x" + Integer.toHexString(this.egl.eglGetError()));
            } else if (this.egl.eglInitialize(eglGetDisplay, new int[2])) {
                return eglGetDisplay;
            } else {
                throw new RuntimeException("Unable to initialize EGL10: 0x" + Integer.toHexString(this.egl.eglGetError()));
            }
        }
        return (EGLDisplay) invokeV.objValue;
    }

    @Override // org.webrtc.EglBase
    public void createDummyPbufferSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            createPbufferSurface(1, 1);
        }
    }

    @Override // org.webrtc.EglBase
    public void createPbufferSurface(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            checkIsNotReleased();
            if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
                throw new RuntimeException("Already has an EGLSurface");
            }
            EGLSurface eglCreatePbufferSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, i2, 12374, i3, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
            this.eglSurface = eglCreatePbufferSurface;
            if (eglCreatePbufferSurface != EGL10.EGL_NO_SURFACE) {
                return;
            }
            throw new RuntimeException("Failed to create pixel buffer surface with size " + i2 + "x" + i3 + ": 0x" + Integer.toHexString(this.egl.eglGetError()));
        }
    }

    @Override // org.webrtc.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            createSurfaceInternal(surfaceTexture);
        }
    }

    @Override // org.webrtc.EglBase
    public void createSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            createSurfaceInternal(new SurfaceHolder(this, surface) { // from class: org.webrtc.EglBase10.1FakeSurfaceHolder
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final Surface surface;
                public final /* synthetic */ EglBase10 this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surface};
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
                    this.surface = surface;
                }

                @Override // android.view.SurfaceHolder
                public void addCallback(SurfaceHolder.Callback callback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, callback) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public Surface getSurface() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.surface : (Surface) invokeV.objValue;
                }

                @Override // android.view.SurfaceHolder
                @Nullable
                public Rect getSurfaceFrame() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (Rect) invokeV.objValue;
                }

                @Override // android.view.SurfaceHolder
                public boolean isCreating() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // android.view.SurfaceHolder
                @Nullable
                public Canvas lockCanvas() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        return null;
                    }
                    return (Canvas) invokeV.objValue;
                }

                @Override // android.view.SurfaceHolder
                @Nullable
                public Canvas lockCanvas(Rect rect) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, rect)) == null) {
                        return null;
                    }
                    return (Canvas) invokeL.objValue;
                }

                @Override // android.view.SurfaceHolder
                public void removeCallback(SurfaceHolder.Callback callback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, callback) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public void setFixedSize(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048583, this, i2, i3) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public void setFormat(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public void setKeepScreenOn(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048585, this, z) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public void setSizeFromLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                @Deprecated
                public void setType(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048587, this, i2) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder
                public void unlockCanvasAndPost(Canvas canvas) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048588, this, canvas) == null) {
                    }
                }
            });
        }
    }

    @Override // org.webrtc.EglBase
    public void detachCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (EglBase.lock) {
                if (!this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
                    throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            }
        }
    }

    @Override // org.webrtc.EglBase
    public EglBase.Context getEglBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Context(this.eglContext) : (EglBase.Context) invokeV.objValue;
    }

    @Override // org.webrtc.EglBase
    public boolean hasSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.eglSurface != EGL10.EGL_NO_SURFACE : invokeV.booleanValue;
    }

    @Override // org.webrtc.EglBase
    public void makeCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            checkIsNotReleased();
            if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
                throw new RuntimeException("No EGLSurface - can't make current");
            }
            synchronized (EglBase.lock) {
                if (!this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
                    throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            checkIsNotReleased();
            releaseSurface();
            detachCurrent();
            this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
            this.egl.eglTerminate(this.eglDisplay);
            this.eglContext = EGL10.EGL_NO_CONTEXT;
            this.eglDisplay = EGL10.EGL_NO_DISPLAY;
            this.eglConfig = null;
        }
    }

    @Override // org.webrtc.EglBase
    public void releaseSurface() {
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (eGLSurface = this.eglSurface) == EGL10.EGL_NO_SURFACE) {
            return;
        }
        this.egl.eglDestroySurface(this.eglDisplay, eGLSurface);
        this.eglSurface = EGL10.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public int surfaceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int[] iArr = new int[1];
            this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.EglBase
    public int surfaceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int[] iArr = new int[1];
            this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            checkIsNotReleased();
            if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
                throw new RuntimeException("No EGLSurface - can't swap buffers");
            }
            synchronized (EglBase.lock) {
                this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            swapBuffers();
        }
    }
}
