package com.faceunity.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes11.dex */
public final class EglCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    public static final String TAG = "Grafika";
    public transient /* synthetic */ FieldHolder $fh;
    public EGLConfig mEGLConfig;
    public EGLContext mEGLContext;
    public EGLDisplay mEGLDisplay;
    public int mGlVersion;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EglCore() {
        this(null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((EGLContext) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void checkEglError(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private EGLConfig getConfig(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            int[] iArr = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12352, i3 >= 3 ? 68 : 4, 12344, 0, 12344};
            if ((i2 & 1) != 0) {
                iArr[10] = 12610;
                iArr[11] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                String str = "unable to find RGB8888 / " + i3 + " EGLConfig";
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeII.objValue;
    }

    public static void logCurrent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            String str2 = "Current EGL (" + str + "): display=" + EGL14.eglGetCurrentDisplay() + ", context=" + EGL14.eglGetCurrentContext() + ", surface=" + EGL14.eglGetCurrentSurface(12377);
        }
    }

    public EGLSurface createOffscreenSurface(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i2, 12374, i3, 12344}, 0);
            checkEglError("eglCreatePbufferSurface");
            if (eglCreatePbufferSurface != null) {
                return eglCreatePbufferSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeII.objValue;
    }

    public EGLSurface createWindowSurface(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
                throw new RuntimeException("invalid surface: " + obj);
            }
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
            checkEglError("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeL.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    release();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public int getGlVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mGlVersion : invokeV.intValue;
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eGLSurface)) == null) ? this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377)) : invokeL.booleanValue;
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eGLSurface) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
            if (!EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void makeNothingCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public String queryString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? EGL14.eglQueryString(this.mEGLDisplay, i2) : (String) invokeI.objValue;
    }

    public int querySurface(EGLSurface eGLSurface, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, eGLSurface, i2)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i2, iArr, 0);
            return iArr[0];
        }
        return invokeLI.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.mEGLDisplay);
            }
            this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
            this.mEGLContext = EGL14.EGL_NO_CONTEXT;
            this.mEGLConfig = null;
        }
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eGLSurface) == null) {
            EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface);
        }
    }

    public void setPresentationTime(EGLSurface eGLSurface, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, eGLSurface, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j);
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, eGLSurface)) == null) ? EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface) : invokeL.booleanValue;
    }

    public EglCore(EGLContext eGLContext, int i2) {
        int[] iArr;
        EGLConfig config;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = eGLDisplay;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr2 = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1)) {
                    if ((i2 & 2) != 0 && (config = getConfig(i2, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.mEGLConfig = config;
                            this.mEGLContext = eglCreateContext;
                            this.mGlVersion = 3;
                        }
                    }
                    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig config2 = getConfig(i2, 2);
                        if (config2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            checkEglError("eglCreateContext");
                            this.mEGLConfig = config2;
                            this.mEGLContext = eglCreateContext2;
                            this.mGlVersion = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, EglBase10.EGL_CONTEXT_CLIENT_VERSION, new int[1], 0);
                    String str = "EGLContext created, client version " + iArr[0];
                    return;
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eGLSurface, eGLSurface2) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
            if (!EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
                throw new RuntimeException("eglMakeCurrent(draw,read) failed");
            }
        }
    }
}
