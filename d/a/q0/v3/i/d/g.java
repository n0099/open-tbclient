package d.a.q0.v3.i.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f66107a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f66108b;

    /* renamed from: c  reason: collision with root package name */
    public EGLSurface f66109c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f66110d;

    public g(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (surface != null) {
            this.f66110d = surface;
            b();
            return;
        }
        throw null;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = false;
            while (true) {
                int eglGetError = EGL14.eglGetError();
                if (eglGetError == 12288) {
                    break;
                }
                Log.e("InputSurface", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                z = true;
            }
            if (z) {
                throw new RuntimeException("EGL error encountered (see log)");
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f66107a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    this.f66107a = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f66107a, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, 12352, 4, 12610, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.f66108b = EGL14.eglCreateContext(this.f66107a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                    a("eglCreateContext");
                    if (this.f66108b != null) {
                        this.f66109c = EGL14.eglCreateWindowSurface(this.f66107a, eGLConfigArr[0], this.f66110d, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                        a("eglCreateWindowSurface");
                        if (this.f66109c == null) {
                            throw new RuntimeException("surface was null");
                        }
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EGLDisplay eGLDisplay = this.f66107a;
            EGLSurface eGLSurface = this.f66109c;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f66108b)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (EGL14.eglGetCurrentContext().equals(this.f66108b)) {
                EGLDisplay eGLDisplay = this.f66107a;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGL14.eglDestroySurface(this.f66107a, this.f66109c);
            EGL14.eglDestroyContext(this.f66107a, this.f66108b);
            this.f66110d.release();
            this.f66107a = null;
            this.f66108b = null;
            this.f66109c = null;
            this.f66110d = null;
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.f66107a, this.f66109c, j);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EGL14.eglSwapBuffers(this.f66107a, this.f66109c) : invokeV.booleanValue;
    }
}
