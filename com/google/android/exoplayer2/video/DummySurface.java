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
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.google.android.material.internal.ManufacturerUtils;
import org.webrtc.EglBase10;
@TargetApi(17)
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class b extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f63978e;

        /* renamed from: f  reason: collision with root package name */
        public EGLDisplay f63979f;

        /* renamed from: g  reason: collision with root package name */
        public EGLContext f63980g;

        /* renamed from: h  reason: collision with root package name */
        public EGLSurface f63981h;

        /* renamed from: i  reason: collision with root package name */
        public Handler f63982i;
        public SurfaceTexture j;
        public Error k;
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
            this.f63978e = new int[1];
        }

        public DummySurface a(boolean z) {
            InterceptResult invokeZ;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                start();
                this.f63982i = new Handler(getLooper(), this);
                synchronized (this) {
                    z2 = false;
                    this.f63982i.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                    while (this.m == null && this.l == null && this.k == null) {
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
                    Error error = this.k;
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
                this.f63979f = eglGetDisplay;
                b.h.b.a.i0.a.g(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                b.h.b.a.i0.a.g(EGL14.eglInitialize(this.f63979f, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                b.h.b.a.i0.a.g(EGL14.eglChooseConfig(this.f63979f, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.f63979f, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344} : new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                this.f63980g = eglCreateContext;
                b.h.b.a.i0.a.g(eglCreateContext != null, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f63979f, eGLConfig, z ? new int[]{12375, 1, 12374, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                this.f63981h = eglCreatePbufferSurface;
                b.h.b.a.i0.a.g(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                EGLDisplay eGLDisplay = this.f63979f;
                EGLSurface eGLSurface = this.f63981h;
                b.h.b.a.i0.a.g(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f63980g), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.f63978e, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f63978e[0]);
                this.j = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.m = new DummySurface(this, this.j, z, null);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f63982i.sendEmptyMessage(3);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, com.google.android.exoplayer2.video.DummySurface, android.opengl.EGLDisplay] */
        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    if (this.j != null) {
                        this.j.release();
                        GLES20.glDeleteTextures(1, this.f63978e, 0);
                    }
                } finally {
                    EGLSurface eGLSurface = this.f63981h;
                    if (eGLSurface != null) {
                        EGL14.eglDestroySurface(this.f63979f, eGLSurface);
                    }
                    EGLContext eGLContext = this.f63980g;
                    if (eGLContext != null) {
                        EGL14.eglDestroyContext(this.f63979f, eGLContext);
                    }
                    this.f63981h = null;
                    this.f63980g = null;
                    this.f63979f = null;
                    this.m = null;
                    this.j = null;
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
                            this.j.updateTexImage();
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
                        this.k = e3;
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
                this.f63982i.sendEmptyMessage(2);
            }
        }
    }

    public /* synthetic */ DummySurface(b bVar, SurfaceTexture surfaceTexture, boolean z, a aVar) {
        this(bVar, surfaceTexture, z);
    }

    public static void assertApiLevel17OrHigher() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && v.f33519a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    public static boolean enableSecureDummySurfaceV24(Context context) {
        InterceptResult invokeL;
        String eglQueryString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (v.f33519a >= 26 || !ManufacturerUtils.SAMSUNG.equals(v.f33521c)) {
                return (v.f33519a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
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
                    secureSupported = v.f33519a >= 24 && enableSecureDummySurfaceV24(context);
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            assertApiLevel17OrHigher();
            b.h.b.a.i0.a.f(!z || isSecureSupported(context));
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
