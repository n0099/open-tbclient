package com.google.android.exoplayer2.video;

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
import android.util.Log;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.internal.ManufacturerUtils;
import org.webrtc.EglBase10;
/* loaded from: classes7.dex */
public final class DummySurface extends Surface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    public static final String TAG = "DummySurface";
    public static boolean secureSupported;
    public static boolean secureSupportedInitialized;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean secure;
    public final DummySurfaceThread thread;
    public boolean threadReleased;

    /* renamed from: com.google.android.exoplayer2.video.DummySurface$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class DummySurfaceThread extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_INIT = 1;
        public static final int MSG_RELEASE = 3;
        public static final int MSG_UPDATE_TEXTURE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public EGLContext context;
        public EGLDisplay display;
        public Handler handler;
        public Error initError;
        public RuntimeException initException;
        public EGLSurface pbuffer;
        public DummySurface surface;
        public SurfaceTexture surfaceTexture;
        public final int[] textureIdHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DummySurfaceThread() {
            super("dummySurface");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.textureIdHolder = new int[1];
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.handler.sendEmptyMessage(3);
            }
        }

        private void initInternal(boolean z) {
            boolean z2;
            boolean z3;
            int[] iArr;
            boolean z4;
            int[] iArr2;
            boolean z5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.display = eglGetDisplay;
                if (eglGetDisplay != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkState(z2, "eglGetDisplay failed");
                int[] iArr3 = new int[2];
                Assertions.checkState(EGL14.eglInitialize(this.display, iArr3, 0, iArr3, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr4 = new int[1];
                if (EGL14.eglChooseConfig(this.display, new int[]{12352, 4, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.checkState(z3, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (z) {
                    iArr = new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
                } else {
                    iArr = new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.display, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                this.context = eglCreateContext;
                if (eglCreateContext != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.checkState(z4, "eglCreateContext failed");
                if (z) {
                    iArr2 = new int[]{12375, 1, 12374, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
                } else {
                    iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                }
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.display, eGLConfig, iArr2, 0);
                this.pbuffer = eglCreatePbufferSurface;
                if (eglCreatePbufferSurface != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assertions.checkState(z5, "eglCreatePbufferSurface failed");
                EGLDisplay eGLDisplay = this.display;
                EGLSurface eGLSurface = this.pbuffer;
                Assertions.checkState(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.context), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.textureIdHolder, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
                this.surfaceTexture = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.surface = new DummySurface(this, this.surfaceTexture, z, null);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, com.google.android.exoplayer2.video.DummySurface, android.opengl.EGLDisplay] */
        private void releaseInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                try {
                    if (this.surfaceTexture != null) {
                        this.surfaceTexture.release();
                        GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
                    }
                } finally {
                    EGLSurface eGLSurface = this.pbuffer;
                    if (eGLSurface != null) {
                        EGL14.eglDestroySurface(this.display, eGLSurface);
                    }
                    EGLContext eGLContext = this.context;
                    if (eGLContext != null) {
                        EGL14.eglDestroyContext(this.display, eGLContext);
                    }
                    this.pbuffer = null;
                    this.context = null;
                    this.display = null;
                    this.surface = null;
                    this.surfaceTexture = null;
                }
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                try {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                return true;
                            }
                            try {
                                releaseInternal();
                            } finally {
                                try {
                                    return true;
                                } finally {
                                }
                            }
                            return true;
                        }
                        this.surfaceTexture.updateTexImage();
                        return true;
                    }
                    try {
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        initInternal(z);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e) {
                        Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e);
                        this.initError = e;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e2) {
                        Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                        this.initException = e2;
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

        public DummySurface init(boolean z) {
            InterceptResult invokeZ;
            boolean z2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                start();
                this.handler = new Handler(getLooper(), this);
                synchronized (this) {
                    Handler handler = this.handler;
                    z2 = false;
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    handler.obtainMessage(1, i, 0).sendToTarget();
                    while (this.surface == null && this.initException == null && this.initError == null) {
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
                RuntimeException runtimeException = this.initException;
                if (runtimeException == null) {
                    Error error = this.initError;
                    if (error == null) {
                        return this.surface;
                    }
                    throw error;
                }
                throw runtimeException;
            }
            return (DummySurface) invokeZ.objValue;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dummySurfaceThread, surfaceTexture, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SurfaceTexture) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    public /* synthetic */ DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z, AnonymousClass1 anonymousClass1) {
        this(dummySurfaceThread, surfaceTexture, z);
    }

    public static void assertApiLevel17OrHigher() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || Util.SDK_INT >= 17) {
            return;
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    @Override // android.view.Surface
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.release();
            synchronized (this.thread) {
                if (!this.threadReleased) {
                    this.thread.release();
                    this.threadReleased = true;
                }
            }
        }
    }

    public static boolean enableSecureDummySurfaceV24(Context context) {
        InterceptResult invokeL;
        String eglQueryString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (Util.SDK_INT < 26 && ManufacturerUtils.SAMSUNG.equals(Util.MANUFACTURER)) {
                return false;
            }
            if ((Util.SDK_INT < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (DummySurface.class) {
                if (!secureSupportedInitialized) {
                    if (Util.SDK_INT >= 24 && enableSecureDummySurfaceV24(context)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    secureSupported = z2;
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
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, context, z)) == null) {
            assertApiLevel17OrHigher();
            if (z && !isSecureSupported(context)) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.checkState(z2);
            return new DummySurfaceThread().init(z);
        }
        return (DummySurface) invokeLZ.objValue;
    }
}
