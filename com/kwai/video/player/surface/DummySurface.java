package com.kwai.video.player.surface;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(17)
/* loaded from: classes7.dex */
public final class DummySurface extends Surface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DummySurface";
    public static int secureMode;
    public static boolean secureModeInitialized;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean secure;
    public final DummySurfaceThread thread;
    public boolean threadReleased;

    /* renamed from: com.kwai.video.player.surface.DummySurface$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_INIT = 1;
        public static final int MSG_RELEASE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public EGLSurfaceTexture eglSurfaceTexture;
        @NonNull
        public Handler handler;
        @Nullable
        public Error initError;
        @Nullable
        public RuntimeException initException;
        @Nullable
        public DummySurface surface;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DummySurfaceThread() {
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
        }

        private void initInternal(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
                Assertions.checkNotNull(this.eglSurfaceTexture);
                this.eglSurfaceTexture.init(i2);
                this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i2 != 0, null);
            }
        }

        private void releaseInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                Assertions.checkNotNull(this.eglSurfaceTexture);
                this.eglSurfaceTexture.release();
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                try {
                    if (i2 != 1) {
                        if (i2 != 2) {
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
                    try {
                        initInternal(message.arg1);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e2) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                        this.initError = e2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e3) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                        this.initException = e3;
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

        public DummySurface init(int i2) {
            InterceptResult invokeI;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                start();
                this.handler = new Handler(getLooper(), this);
                this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
                synchronized (this) {
                    z = false;
                    this.handler.obtainMessage(1, i2, 0).sendToTarget();
                    while (this.surface == null && this.initException == null && this.initError == null) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
                RuntimeException runtimeException = this.initException;
                if (runtimeException == null) {
                    Error error = this.initError;
                    if (error == null) {
                        return (DummySurface) Assertions.checkNotNull(this.surface);
                    }
                    throw error;
                }
                throw runtimeException;
            }
            return (DummySurface) invokeI.objValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Assertions.checkNotNull(this.handler);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && Build.VERSION.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static int getSecureMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            synchronized (DummySurface.class) {
                if (!secureModeInitialized) {
                    secureMode = getSecureMode(context);
                    secureModeInitialized = true;
                }
                z = secureMode != 0;
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
            Assertions.checkState(!z || isSecureSupported(context));
            return new DummySurfaceThread().init(z ? secureMode : 0);
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
                    this.thread.release();
                    this.threadReleased = true;
                }
            }
            Log.i("DummySurface", "DummySurface released");
        }
    }
}
