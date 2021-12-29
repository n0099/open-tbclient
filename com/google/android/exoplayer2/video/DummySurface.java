package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.google.android.material.internal.ManufacturerUtils;
import org.webrtc.EglBase10;
@TargetApi(17)
/* loaded from: classes3.dex */
public final class DummySurface extends Surface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    public static final String TAG = "DummySurface";
    public static boolean secureSupported;
    public static boolean secureSupportedInitialized;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean secure;
    public final b thread;
    public boolean threadReleased;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f56511e;

        /* renamed from: f  reason: collision with root package name */
        public EGLDisplay f56512f;

        /* renamed from: g  reason: collision with root package name */
        public EGLContext f56513g;

        /* renamed from: h  reason: collision with root package name */
        public EGLSurface f56514h;

        /* renamed from: i  reason: collision with root package name */
        public Handler f56515i;

        /* renamed from: j  reason: collision with root package name */
        public SurfaceTexture f56516j;

        /* renamed from: k  reason: collision with root package name */
        public Error f56517k;
        public RuntimeException l;
        public DummySurface m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super("dummySurface");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
            this.f56511e = new int[1];
        }

        public DummySurface a(boolean z) {
            InterceptResult invokeZ;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                start();
                this.f56515i = new Handler(getLooper(), this);
                synchronized (this) {
                    z2 = false;
                    this.f56515i.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                    while (this.m == null && this.l == null && this.f56517k == null) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                RuntimeException runtimeException = this.l;
                if (runtimeException == null) {
                    Error error = this.f56517k;
                    if (error == null) {
                        return this.m;
                    }
                    throw error;
                }
                throw runtimeException;
            }
            return (DummySurface) invokeZ.objValue;
        }

        public final void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.f56512f = eglGetDisplay;
                c.i.b.a.i0.a.g(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                c.i.b.a.i0.a.g(EGL14.eglInitialize(this.f56512f, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                c.i.b.a.i0.a.g(EGL14.eglChooseConfig(this.f56512f, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.f56512f, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344} : new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                this.f56513g = eglCreateContext;
                c.i.b.a.i0.a.g(eglCreateContext != null, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f56512f, eGLConfig, z ? new int[]{12375, 1, 12374, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                this.f56514h = eglCreatePbufferSurface;
                c.i.b.a.i0.a.g(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                EGLDisplay eGLDisplay = this.f56512f;
                EGLSurface eGLSurface = this.f56514h;
                c.i.b.a.i0.a.g(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f56513g), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.f56511e, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f56511e[0]);
                this.f56516j = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.m = new DummySurface(this, this.f56516j, z, null);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f56515i.sendEmptyMessage(3);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, com.google.android.exoplayer2.video.DummySurface, android.opengl.EGLDisplay] */
        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    if (this.f56516j != null) {
                        this.f56516j.release();
                        GLES20.glDeleteTextures(1, this.f56511e, 0);
                    }
                } finally {
                    EGLSurface eGLSurface = this.f56514h;
                    if (eGLSurface != null) {
                        EGL14.eglDestroySurface(this.f56512f, eGLSurface);
                    }
                    EGLContext eGLContext = this.f56513g;
                    if (eGLContext != null) {
                        EGL14.eglDestroyContext(this.f56512f, eGLContext);
                    }
                    this.f56514h = null;
                    this.f56513g = null;
                    this.f56512f = null;
                    this.m = null;
                    this.f56516j = null;
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                int i2 = message.what;
                try {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.f56516j.updateTexImage();
                            return true;
                        } else if (i2 != 3) {
                            return true;
                        } else {
                            try {
                                d();
                            } catch (Throwable unused) {
                            }
                            quit();
                            return true;
                        }
                    }
                    try {
                        try {
                            b(message.arg1 != 0);
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e2) {
                            this.l = e2;
                            synchronized (this) {
                                notify();
                            }
                        }
                    } catch (Error e3) {
                        this.f56517k = e3;
                        synchronized (this) {
                            notify();
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return invokeL.booleanValue;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.f56515i.sendEmptyMessage(2);
            }
        }
    }

    public /* synthetic */ DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z, a aVar) {
        this(bVar, surfaceTexture, z);
    }

    public static void assertApiLevel17OrHigher() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && v.a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    public static boolean enableSecureDummySurfaceV24(Context context) {
        InterceptResult invokeL;
        String eglQueryString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (v.a >= 26 || !ManufacturerUtils.SAMSUNG.equals(v.f30702c)) {
                return (v.a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (DummySurface.class) {
                if (!secureSupportedInitialized) {
                    secureSupported = v.a >= 24 && enableSecureDummySurfaceV24(context);
                    secureSupportedInitialized = true;
                }
                z = secureSupported;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static DummySurface newInstanceV17(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, context, z)) == null) {
            assertApiLevel17OrHigher();
            c.i.b.a.i0.a.f(!z || isSecureSupported(context));
            return new b().a(z);
        }
        return (DummySurface) invokeLZ.objValue;
    }

    @Override // android.view.Surface
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.release();
            synchronized (this.thread) {
                if (!this.threadReleased) {
                    this.thread.c();
                    this.threadReleased = true;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, surfaceTexture, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SurfaceTexture) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.thread = bVar;
        this.secure = z;
    }
}
