package com.kwai.video.player.surface;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import org.webrtc.EglBase10;
@TargetApi(17)
/* loaded from: classes7.dex */
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] EGL_CONFIG_ATTRIBUTES;
    public static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    public static final int EGL_SURFACE_HEIGHT = 1;
    public static final int EGL_SURFACE_WIDTH = 1;
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final TextureImageListener callback;
    @Nullable
    public EGLContext context;
    @Nullable
    public EGLDisplay display;
    public final Handler handler;
    @Nullable
    public EGLSurface surface;
    @Nullable
    public SurfaceTexture texture;
    public final int[] textureIdHolder;

    /* renamed from: com.kwai.video.player.surface.EGLSurfaceTexture$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class GlException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GlException(String str) {
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
        }

        public /* synthetic */ GlException(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface SecureMode {
    }

    /* loaded from: classes7.dex */
    public interface TextureImageListener {
        void onFrameAvailable();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-441779554, "Lcom/kwai/video/player/surface/EGLSurfaceTexture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-441779554, "Lcom/kwai/video/player/surface/EGLSurfaceTexture;");
                return;
            }
        }
        EGL_CONFIG_ATTRIBUTES = new int[]{12352, 4, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, 0, ZeusMonitorType.MONITOR_TYPE_KEY_RESOURCE, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, ZeusMonitorType.MONITOR_TYPE_MULTI_PERFORMANCE_TIMING, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EGLSurfaceTexture(Handler handler) {
        this(handler, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], (TextureImageListener) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @Nullable TextureImageListener textureImageListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, textureImageListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.handler = handler;
        this.callback = textureImageListener;
        this.textureIdHolder = new int[1];
    }

    public static EGLConfig chooseEGLConfig(EGLDisplay eGLDisplay) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eGLDisplay)) == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, EGL_CONFIG_ATTRIBUTES, 0, eGLConfigArr, 0, 1, iArr, 0);
            if (!eglChooseConfig || iArr[0] <= 0 || eGLConfigArr[0] == null) {
                throw new GlException(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]), null);
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeL.objValue;
    }

    public static EGLContext createEGLContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65540, null, eGLDisplay, eGLConfig, i2)) == null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER} : new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12992, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
            if (eglCreateContext != null) {
                return eglCreateContext;
            }
            throw new GlException("eglCreateContext failed", null);
        }
        return (EGLContext) invokeLLI.objValue;
    }

    public static EGLSurface createEGLSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) {
        InterceptResult invokeLLLI;
        EGLSurface eglCreatePbufferSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(AdIconUtil.AD_TEXT_ID, null, eGLDisplay, eGLConfig, eGLContext, i2)) == null) {
            if (i2 == 1) {
                eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
            } else {
                eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER} : new int[]{12375, 1, 12374, 1, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                if (eglCreatePbufferSurface == null) {
                    throw new GlException("eglCreatePbufferSurface failed", null);
                }
            }
            if (EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eGLContext)) {
                return eglCreatePbufferSurface;
            }
            throw new GlException("eglMakeCurrent failed", null);
        }
        return (EGLSurface) invokeLLLI.objValue;
    }

    private void dispatchOnFrameAvailable() {
        TextureImageListener textureImageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (textureImageListener = this.callback) == null) {
            return;
        }
        textureImageListener.onFrameAvailable();
    }

    public static void generateTextureIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iArr) == null) {
            GLES20.glGenTextures(1, iArr, 0);
        }
    }

    public static EGLDisplay getDefaultDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            if (eglGetDisplay != null) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    return eglGetDisplay;
                }
                throw new GlException("eglInitialize failed", null);
            }
            throw new GlException("eglGetDisplay failed", null);
        }
        return (EGLDisplay) invokeV.objValue;
    }

    public SurfaceTexture getSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (SurfaceTexture) Assertions.checkNotNull(this.texture) : (SurfaceTexture) invokeV.objValue;
    }

    public void init(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            EGLDisplay defaultDisplay = getDefaultDisplay();
            this.display = defaultDisplay;
            EGLConfig chooseEGLConfig = chooseEGLConfig(defaultDisplay);
            EGLContext createEGLContext = createEGLContext(this.display, chooseEGLConfig, i2);
            this.context = createEGLContext;
            this.surface = createEGLSurface(this.display, chooseEGLConfig, createEGLContext, i2);
            generateTextureIds(this.textureIdHolder);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
            this.texture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            this.handler.post(this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, android.opengl.EGLDisplay] */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.handler.removeCallbacks(this);
            try {
                if (this.texture != null) {
                    this.texture.release();
                    GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
                }
            } finally {
                EGLDisplay eGLDisplay = this.display;
                if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGLDisplay eGLDisplay2 = this.display;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                }
                EGLSurface eGLSurface2 = this.surface;
                if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface(this.display, this.surface);
                }
                EGLContext eGLContext = this.context;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.display, eGLContext);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    EGL14.eglReleaseThread();
                }
                EGLDisplay eGLDisplay3 = this.display;
                if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglTerminate(this.display);
                }
                this.display = null;
                this.context = null;
                this.surface = null;
                this.texture = null;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dispatchOnFrameAvailable();
            SurfaceTexture surfaceTexture = this.texture;
            if (surfaceTexture != null) {
                try {
                    surfaceTexture.updateTexImage();
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
