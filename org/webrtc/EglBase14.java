package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
@TargetApi(18)
/* loaded from: classes3.dex */
public class EglBase14 implements EglBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CURRENT_SDK_VERSION;
    public static final int EGLExt_SDK_VERSION = 18;
    public static final String TAG = "EglBase14";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public EGLConfig eglConfig;
    public EGLContext eglContext;
    public EGLDisplay eglDisplay;
    public EGLSurface eglSurface;

    /* loaded from: classes3.dex */
    public static class Context implements EglBase.Context {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final EGLContext egl14Context;

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
            this.egl14Context = eGLContext;
        }

        @Override // org.webrtc.EglBase.Context
        @TargetApi(21)
        public long getNativeEglContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? EglBase14.CURRENT_SDK_VERSION >= 21 ? this.egl14Context.getNativeHandle() : this.egl14Context.getHandle() : invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-545736632, "Lorg/webrtc/EglBase14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-545736632, "Lorg/webrtc/EglBase14;");
                return;
            }
        }
        CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
    }

    public EglBase14(Context context, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        EGLConfig eglConfig = getEglConfig(eglDisplay, iArr);
        this.eglConfig = eglConfig;
        this.eglContext = createEglContext(context, this.eglDisplay, eglConfig);
    }

    private void checkIsNotReleased() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.eglDisplay == EGL14.EGL_NO_DISPLAY || this.eglContext == EGL14.EGL_NO_CONTEXT || this.eglConfig == null) {
                throw new RuntimeException("This object has been released");
            }
        }
    }

    public static EGLContext createEglContext(@Nullable Context context, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        InterceptResult invokeLLL;
        EGLContext eGLContext;
        EGLContext eglCreateContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, eGLDisplay, eGLConfig)) == null) {
            if (context != null && context.egl14Context == EGL14.EGL_NO_CONTEXT) {
                throw new RuntimeException("Invalid sharedContext");
            }
            int[] iArr = {EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            if (context != null) {
                eGLContext = context.egl14Context;
            } else {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            synchronized (EglBase.lock) {
                eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
            }
            if (eglCreateContext != EGL14.EGL_NO_CONTEXT) {
                return eglCreateContext;
            }
            throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        return (EGLContext) invokeLLL.objValue;
    }

    private void createSurfaceInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, obj) == null) {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
                throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
            }
            checkIsNotReleased();
            if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
                EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344}, 0);
                this.eglSurface = eglCreateWindowSurface;
                if (eglCreateWindowSurface != EGL14.EGL_NO_SURFACE) {
                    return;
                }
                throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
            throw new RuntimeException("Already has an EGLSurface");
        }
    }

    public static EGLConfig getEglConfig(EGLDisplay eGLDisplay, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, eGLDisplay, iArr)) == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
                if (iArr2[0] > 0) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    if (eGLConfig != null) {
                        return eGLConfig;
                    }
                    throw new RuntimeException("eglChooseConfig returned null");
                }
                throw new RuntimeException("Unable to find any matching EGL config");
            }
            throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        return (EGLConfig) invokeLL.objValue;
    }

    public static EGLDisplay getEglDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    return eglGetDisplay;
                }
                throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
            throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        return (EGLDisplay) invokeV.objValue;
    }

    public static boolean isEGL14Supported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SDK version: ");
            sb.append(CURRENT_SDK_VERSION);
            sb.append(". isEGL14Supported: ");
            sb.append(CURRENT_SDK_VERSION >= 18);
            Logging.d(TAG, sb.toString());
            return CURRENT_SDK_VERSION >= 18;
        }
        return invokeV.booleanValue;
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
            if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, i2, 12374, i3, 12344}, 0);
                this.eglSurface = eglCreatePbufferSurface;
                if (eglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
                    return;
                }
                throw new RuntimeException("Failed to create pixel buffer surface with size " + i2 + "x" + i3 + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
            throw new RuntimeException("Already has an EGLSurface");
        }
    }

    @Override // org.webrtc.EglBase
    public void createSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            createSurfaceInternal(surface);
        }
    }

    @Override // org.webrtc.EglBase
    public void detachCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (EglBase.lock) {
                if (!EGL14.eglMakeCurrent(this.eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
                    throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
                }
            }
        }
    }

    @Override // org.webrtc.EglBase
    public boolean hasSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.eglSurface != EGL14.EGL_NO_SURFACE : invokeV.booleanValue;
    }

    @Override // org.webrtc.EglBase
    public void makeCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            checkIsNotReleased();
            if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
                synchronized (EglBase.lock) {
                    if (!EGL14.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
                        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
                    }
                }
                return;
            }
            throw new RuntimeException("No EGLSurface - can't make current");
        }
    }

    @Override // org.webrtc.EglBase
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            checkIsNotReleased();
            releaseSurface();
            detachCurrent();
            EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.eglDisplay);
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            this.eglConfig = null;
        }
    }

    @Override // org.webrtc.EglBase
    public void releaseSurface() {
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eGLSurface = this.eglSurface) == EGL14.EGL_NO_SURFACE) {
            return;
        }
        EGL14.eglDestroySurface(this.eglDisplay, eGLSurface);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public int surfaceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.EglBase
    public int surfaceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            checkIsNotReleased();
            if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
                synchronized (EglBase.lock) {
                    EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                }
                return;
            }
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
    }

    @Override // org.webrtc.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            createSurfaceInternal(surfaceTexture);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.webrtc.EglBase
    public Context getEglBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new Context(this.eglContext) : (Context) invokeV.objValue;
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            checkIsNotReleased();
            if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
                synchronized (EglBase.lock) {
                    EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, j);
                    EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                }
                return;
            }
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
    }
}
