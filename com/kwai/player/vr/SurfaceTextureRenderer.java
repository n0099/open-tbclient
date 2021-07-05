package com.kwai.player.vr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
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
import com.baidu.wallet.core.StatusCode;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import com.kwai.player.vr.BaseConfigChooser;
import com.kwai.video.player.R;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase10;
/* loaded from: classes7.dex */
public class SurfaceTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_DESTROYSURFACE = 2002;
    public static final int MSG_INIT = 1000;
    public static final int MSG_RENDER = 1001;
    public static final int MSG_RENDER_LOOP = 1004;
    public static final int MSG_RESIZE_VIDEO = 1002;
    public static final int MSG_RESIZE_WINDOW = 1003;
    public static final int MSG_UPDATESURFACE = 2001;
    public static final String TAG = "SurfaceTextureRenderer";
    public static final int VERTICES_DATA_POS_SIZE = 3;
    public static final int VERTICES_DATA_UV_SIZE = 2;
    public static final int mLoopDuration = 40;
    public static final int maxDelayDuration = 60;
    public transient /* synthetic */ FieldHolder $fh;
    public int fragmentShader;
    public String fragmentShaderSource;
    public final HashMap<String, Integer> handleMap;
    public KwaiMesh kwaiMesh;
    public Object mBindedNativeWindow;
    public Context mContext;
    public BaseConfigChooser.SimpleEGLConfigChooser mEGLConfigChooser;
    public int mEGLContextClientVersion;
    public boolean mEGLInited;
    public EGL10 mEgl;
    public EGLConfig mEglConfig;
    public EGLContext mEglContext;
    public EGLDisplay mEglDisplay;
    public EGLSurface mEglSurface;
    public boolean mFirstRender;
    public FpsStatistic mFpsStatistic;
    public Object mGlRenderSync;
    public HandlerThread mHandlerThread;
    public KwaiMediaPlayer.IHeadTrackerListener mHeadTrackerListener;
    public int mHeight;
    public KwaiVR mKwaiVR;
    public volatile long mLastDisplayFrameTime;
    public volatile boolean mLoopEnd;
    public RenderHandler mRenderHandler;
    public Surface mSurface;
    public int mTexName;
    public SurfaceTexture mTexSurfaceTexture;
    public float[] mTransformMatrix;
    public int mWidth;
    public int mWindowHeight;
    public volatile boolean mWindowSizeChanged;
    public int mWindowWidth;
    public int program;
    public int vertexShader;
    public String vertexShaderSource;

    /* loaded from: classes7.dex */
    public static class RenderHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SurfaceTextureRenderer> mWeakObj;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RenderHandler(SurfaceTextureRenderer surfaceTextureRenderer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {surfaceTextureRenderer, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakObj = new WeakReference<>(surfaceTextureRenderer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceTextureRenderer surfaceTextureRenderer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (surfaceTextureRenderer = this.mWeakObj.get()) == null) {
                return;
            }
            int i2 = message.what;
            if (i2 != 2001) {
                if (i2 == 2002) {
                    surfaceTextureRenderer.destroySurfaceImpl();
                    return;
                }
                switch (i2) {
                    case 1000:
                        surfaceTextureRenderer.initEGL();
                        return;
                    case 1001:
                        surfaceTextureRenderer.syncDrawFrame();
                        return;
                    case 1002:
                        surfaceTextureRenderer.resizeVideoImpl(message.arg1, message.arg2);
                        return;
                    case 1003:
                        surfaceTextureRenderer.resizeWindowImpl(message.arg1, message.arg2);
                        break;
                    case 1004:
                        surfaceTextureRenderer.timerDrawFrameLoop();
                        return;
                    default:
                        return;
                }
            }
            surfaceTextureRenderer.updateSurfaceTextureImpl();
        }
    }

    public SurfaceTextureRenderer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoopEnd = false;
        this.mTransformMatrix = new float[16];
        this.mFirstRender = true;
        this.mEgl = null;
        this.mEglDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEglContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLContextClientVersion = 2;
        this.handleMap = new HashMap<>();
        this.mFpsStatistic = new FpsStatistic();
        this.mGlRenderSync = new Object();
        this.mWindowSizeChanged = false;
        this.mContext = context;
    }

    private int createTextureObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameterf(36197, 10242, 33071.0f);
            GLES20.glTexParameterf(36197, 10243, 33071.0f);
            GLES20.glBindTexture(36197, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    private void destroyEgl() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.mEgl == null) {
            return;
        }
        releaseEgl();
        destroySurfaceImpl();
        if (this.mEglContext != null) {
            Log.i(TAG, "eglDestroyContext in");
            this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            this.mEglContext = null;
            Log.i(TAG, "eglDestroyContext out");
        }
        if (this.mEglDisplay != null) {
            Log.i(TAG, "eglTerminate in");
            this.mEgl.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = null;
            Log.i(TAG, "eglTerminate out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroySurfaceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                if (this.mEgl != null && this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE && this.mEglDisplay != null) {
                    Log.i(TAG, "eglDestroySurface in");
                    this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                    this.mEglSurface = EGL10.EGL_NO_SURFACE;
                    Log.i(TAG, "eglDestroySurface out");
                }
            }
        }
    }

    private void drawFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!eglIsVaild()) {
                Log.d(TAG, "Egl init failed");
            } else if (this.mKwaiVR == null) {
                Log.e(TAG, "KwaiVR init failed");
            } else {
                if (this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                    updateSurfaceTextureImpl();
                }
                if (this.mFirstRender) {
                    this.mFirstRender = false;
                    this.mLoopEnd = false;
                    timerDrawFrameLoop();
                    startFps();
                }
                if (!eglSetSurfaceSize(this.mWidth, this.mHeight)) {
                    Log.e(TAG, "eglSetSurfaceSize failed");
                    return;
                }
                if (this.mWindowSizeChanged) {
                    KwaiVR kwaiVR = this.mKwaiVR;
                    if (kwaiVR != null) {
                        kwaiVR.setViewport(this.mWindowWidth, this.mWindowHeight);
                    }
                    if (!updateSurfaceTextureImpl()) {
                        Log.e(TAG, "updateSurfaceTextureImpl failed");
                        return;
                    }
                } else {
                    EGL10 egl10 = this.mEgl;
                    EGLDisplay eGLDisplay = this.mEglDisplay;
                    EGLSurface eGLSurface = this.mEglSurface;
                    egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
                }
                try {
                    if (this.mTexSurfaceTexture != null) {
                        this.mTexSurfaceTexture.updateTexImage();
                        this.mTexSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
                        this.mFpsStatistic.onFrame();
                        synchronized (this.mGlRenderSync) {
                            float[] mVPMatrix = this.mKwaiVR.getMVPMatrix();
                            float[] orientation = this.mKwaiVR.getOrientation();
                            if (this.mHeadTrackerListener != null) {
                                this.mHeadTrackerListener.onHeadTracker(orientation[0], orientation[1], orientation[2]);
                            }
                            drawTexture(this.mTexName, mVPMatrix, this.mTransformMatrix);
                        }
                    }
                    this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
                } catch (Exception unused) {
                }
                if (this.mWindowSizeChanged) {
                    this.mWindowSizeChanged = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEGL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Log.i(TAG, "initEGL in");
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                Log.e(TAG, "initEGL eglGetDisplay failed! " + this.mEgl.eglGetError());
            } else if (!this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                Log.e(TAG, "initEGL eglInitialize failed! " + this.mEgl.eglGetError());
            } else {
                BaseConfigChooser.SimpleEGLConfigChooser simpleEGLConfigChooser = new BaseConfigChooser.SimpleEGLConfigChooser(true, this.mEGLContextClientVersion);
                this.mEGLConfigChooser = simpleEGLConfigChooser;
                EGLConfig chooseConfig = simpleEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                this.mEglConfig = chooseConfig;
                EGLContext eglCreateContext = this.mEgl.eglCreateContext(this.mEglDisplay, chooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, this.mEGLContextClientVersion, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
                this.mEglContext = eglCreateContext;
                if (this.mEglDisplay != EGL10.EGL_NO_DISPLAY && eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                    this.mEGLInited = true;
                    Log.i(TAG, "initEGL out");
                    return;
                }
                Log.e(TAG, "initEGL eglCreateContext fail failed! " + this.mEgl.eglGetError());
            }
        }
    }

    private void releaseEgl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            GLES20.glDeleteProgram(this.program);
            this.program = 0;
            GLES20.glDeleteShader(this.vertexShader);
            this.vertexShader = 0;
            GLES20.glDeleteShader(this.fragmentShader);
            this.fragmentShader = 0;
            this.handleMap.clear();
        }
    }

    private void releaseImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            Log.i(TAG, "SurfaceTextureRenderer releaseImpl in");
            RenderHandler renderHandler = this.mRenderHandler;
            if (renderHandler != null) {
                renderHandler.removeMessages(1000);
                this.mRenderHandler.removeMessages(1001);
                stopDrawFrameLoop();
                this.mRenderHandler = null;
            }
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mHandlerThread = null;
            }
            destroyEgl();
            Surface surface = this.mSurface;
            if (surface != null && surface.isValid()) {
                Log.i(TAG, "Surface.release() in" + this.mSurface);
                this.mSurface.release();
                this.mSurface = null;
                Log.i(TAG, "Surface.release() out");
            }
            Log.i(TAG, "SurfaceTextureRenderer releaseImpl out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVideoImpl(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i2, i3) == null) {
            Log.d(TAG, "resizeVideo width " + i2 + " height: " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeWindowImpl(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65552, this, i2, i3) == null) {
            synchronized (this.mGlRenderSync) {
                if (this.mKwaiVR != null) {
                    this.mWindowSizeChanged = true;
                    this.mKwaiVR.setViewport(i2, i3);
                }
            }
        }
    }

    private void setupEgl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            releaseEgl();
            Log.i(TAG, "setupEgl in");
            try {
                this.vertexShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_vertex_shader);
                this.fragmentShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_fragment_shader);
                this.vertexShader = EglUtil.loadShader(this.vertexShaderSource, 35633);
                int loadShader = EglUtil.loadShader(this.fragmentShaderSource, 35632);
                this.fragmentShader = loadShader;
                this.program = EglUtil.createProgram(this.vertexShader, loadShader);
            } catch (Exception e2) {
                Log.e(TAG, "throw setupEgl failed" + e2.getMessage());
            }
            Log.i(TAG, "setupEgl out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncDrawFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (this.mGlRenderSync) {
                drawFrame();
                this.mLastDisplayFrameTime = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerDrawFrameLoop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (System.currentTimeMillis() - this.mLastDisplayFrameTime > 60) {
                syncDrawFrame();
                Log.d(TAG, "timerDrawFrameLoop draw frame");
            }
            synchronized (this.mGlRenderSync) {
                if (this.mRenderHandler != null && !this.mLoopEnd) {
                    this.mRenderHandler.sendEmptyMessageDelayed(1004, 40L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateSurfaceTextureImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            synchronized (this) {
                if (this.mEgl != null && this.mEglDisplay != null && this.mEglConfig != null) {
                    destroySurfaceImpl();
                    if (this.mBindedNativeWindow == null) {
                        return false;
                    }
                    try {
                        EGLSurface eglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.mBindedNativeWindow, null);
                        this.mEglSurface = eglCreateWindowSurface;
                        if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eglCreateWindowSurface, eglCreateWindowSurface, this.mEglContext)) {
                                setupEgl();
                                return true;
                            }
                            return false;
                        }
                        Log.e(TAG, "eglCreateWindowSurface error " + this.mEgl.eglGetError());
                        return false;
                    } catch (Exception e2) {
                        Log.e(TAG, "throw eglCreateWindowSurface failed" + e2.getMessage());
                        return false;
                    }
                }
                Log.d(TAG, "updateSurfaceTextureImpl: failed");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public SurfaceTexture createTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mTexName = createTextureObject();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTexName);
            this.mTexSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            return this.mTexSurfaceTexture;
        }
        return (SurfaceTexture) invokeV.objValue;
    }

    public void destroyGlSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMsg(2002, 0, 0);
        }
    }

    public void drawTexture(int i2, float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, fArr, fArr2) == null) {
            if (this.kwaiMesh == null) {
                Log.e(TAG, "kwaiMesh is null");
                return;
            }
            GLES20.glViewport(0, 0, this.mWindowWidth, this.mWindowHeight);
            GLES20.glClear(16384);
            useProgram();
            GLES20.glUniformMatrix4fv(getHandle("uMVPMatrix"), 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(getHandle("uSTMatrix"), 1, false, fArr2, 0);
            FloatBuffer verticesBuffer = this.kwaiMesh.getVerticesBuffer(0);
            if (verticesBuffer == null) {
                return;
            }
            verticesBuffer.position(0);
            GLES20.glEnableVertexAttribArray(getHandle("aPosition"));
            GLES20.glVertexAttribPointer(getHandle("aPosition"), 3, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) verticesBuffer);
            FloatBuffer texCoordinateBuffer = this.kwaiMesh.getTexCoordinateBuffer(0);
            if (texCoordinateBuffer == null) {
                Log.d(TAG, "getTexCoordinateBuffer is null");
                return;
            }
            texCoordinateBuffer.position(0);
            GLES20.glEnableVertexAttribArray(getHandle("aTextureCoord"));
            GLES20.glVertexAttribPointer(getHandle("aTextureCoord"), 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) texCoordinateBuffer);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(getHandle("texture"), 0);
            if (this.kwaiMesh.getIndicesBuffer() != null) {
                this.kwaiMesh.getIndicesBuffer().position(0);
                GLES20.glDrawElements(4, this.kwaiMesh.getNumIndices(), 5123, this.kwaiMesh.getIndicesBuffer());
            }
            GLES20.glDisableVertexAttribArray(getHandle("aPosition"));
            GLES20.glDisableVertexAttribArray(getHandle("aTextureCoord"));
            GLES20.glBindBuffer(34962, 0);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public int eglGetSurfaceHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[1];
            this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12374, iArr);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public int eglGetSurfaceWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int[] iArr = new int[1];
            this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12375, iArr);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public boolean eglIsVaild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (!this.mEGLInited || this.mEgl == null || this.mEglDisplay == null || this.mEglContext == null || this.mEglSurface == null) ? false : true : invokeV.booleanValue;
    }

    public boolean eglSetSurfaceSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            if (eglIsVaild()) {
                if (i2 == this.mWindowWidth && i3 == this.mWindowHeight) {
                    return true;
                }
                int eglGetSurfaceWidth = eglGetSurfaceWidth();
                int eglGetSurfaceHeight = eglGetSurfaceHeight();
                if (eglGetSurfaceWidth != this.mWindowWidth || eglGetSurfaceHeight != this.mWindowHeight) {
                    this.mWindowSizeChanged = true;
                    this.mWindowWidth = eglGetSurfaceWidth;
                    this.mWindowHeight = eglGetSurfaceHeight;
                    Log.d(TAG, "eglSetSurfaceSize window " + this.mWindowWidth + "*" + this.mWindowHeight);
                }
                return (this.mWindowWidth == 0 || this.mWindowHeight == 0) ? false : true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFpsStatistic.getFps() : invokeV.intValue;
    }

    public final int getHandle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Integer num = this.handleMap.get(str);
            if (num != null) {
                return num.intValue();
            }
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.program, str);
            if (glGetAttribLocation == -1) {
                glGetAttribLocation = GLES20.glGetUniformLocation(this.program, str);
            }
            if (glGetAttribLocation == -1) {
                Log.e(TAG, "Could not get attrib or uniform location for " + str);
            }
            this.handleMap.put(str, Integer.valueOf(glGetAttribLocation));
            return glGetAttribLocation;
        }
        return invokeL.intValue;
    }

    public Surface getSurface() {
        InterceptResult invokeV;
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mSurface == null) {
                this.mSurface = SurfaceUtil.create(getTexture());
            }
            if (!this.mSurface.isValid()) {
                SurfaceUtil.release(this.mSurface);
                if (Build.VERSION.SDK_INT >= 21 && (surfaceTexture = this.mTexSurfaceTexture) != null) {
                    surfaceTexture.setOnFrameAvailableListener(null);
                    this.mTexSurfaceTexture.release();
                    this.mTexSurfaceTexture = null;
                }
                this.mSurface = SurfaceUtil.create(getTexture());
            }
            Surface surface = this.mSurface;
            if (surface != null && surface.isValid()) {
                Log.d(TAG, "create surface" + this.mSurface);
                return this.mSurface;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getSurface: Surface invalid mSurface:");
            sb.append(this.mSurface);
            sb.append(",valid:");
            Surface surface2 = this.mSurface;
            sb.append(surface2 != null ? surface2.isValid() : false);
            Log.d(TAG, sb.toString());
            throw new RuntimeException("getSurface invalid");
        }
        return (Surface) invokeV.objValue;
    }

    public SurfaceTexture getTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mTexSurfaceTexture == null) {
                createTexture();
            }
            return this.mTexSurfaceTexture;
        }
        return (SurfaceTexture) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.mHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("Renderer Thread");
                this.mHandlerThread = handlerThread;
                handlerThread.start();
            }
            if (this.mRenderHandler == null) {
                this.mRenderHandler = new RenderHandler(this, this.mHandlerThread.getLooper());
                sendMsg(1000, 0, 0);
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        KwaiVR kwaiVR;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) {
            sendMsg(1001, 0, 0);
            if (!this.mFirstRender || (kwaiVR = this.mKwaiVR) == null) {
                return;
            }
            kwaiVR.setInteractiveValid();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.mGlRenderSync) {
                if (this.mKwaiVR != null) {
                    this.mKwaiVR.release();
                    this.mKwaiVR = null;
                    Log.d(TAG, "release mKwaiVR");
                }
                releaseImpl();
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mFpsStatistic.resetFps();
        }
    }

    public void resizeVideo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || i2 < 0 || i3 < 0) {
            return;
        }
        if (this.mWidth == i2 && this.mHeight == i3) {
            return;
        }
        Log.d(TAG, "resize width:" + i2 + ",height:" + i3);
        this.mWidth = i2;
        this.mHeight = i3;
        sendMsg(1002, i2, i3);
    }

    public void resizeWindow(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            synchronized (this.mGlRenderSync) {
                Log.i(TAG, "resizeWindow width:" + i2 + ",height:" + i3);
                if (this.mWindowWidth != i2 || this.mWindowHeight != i3) {
                    Log.i(TAG, "send resizeWindow width:" + i2 + ",height:" + i3);
                    this.mWindowWidth = i2;
                    this.mWindowHeight = i3;
                    sendMsg(1003, i2, i3);
                }
            }
        }
    }

    public void sendMsg(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048593, this, i2, i3, i4) == null) {
            RenderHandler renderHandler = this.mRenderHandler;
            if (renderHandler != null) {
                renderHandler.removeMessages(i2);
            }
            Message message = new Message();
            message.what = i2;
            message.arg1 = i3;
            message.arg2 = i4;
            RenderHandler renderHandler2 = this.mRenderHandler;
            if (renderHandler2 != null) {
                renderHandler2.sendMessage(message);
            }
        }
    }

    public void setHeadTrackerListener(KwaiMediaPlayer.IHeadTrackerListener iHeadTrackerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iHeadTrackerListener) == null) {
            this.mHeadTrackerListener = iHeadTrackerListener;
        }
    }

    public void setKwaiVR(KwaiVR kwaiVR) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, kwaiVR) == null) {
            this.mKwaiVR = kwaiVR;
            if (kwaiVR != null) {
                this.kwaiMesh = kwaiVR.getKwaiMesh();
            }
        }
    }

    public void startFps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mFpsStatistic.startFps();
        }
    }

    public void stopDrawFrameLoop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.mGlRenderSync) {
                this.mLoopEnd = true;
                if (this.mRenderHandler != null) {
                    this.mRenderHandler.removeMessages(1004);
                }
            }
        }
    }

    public void stopFps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mFpsStatistic.stopFps();
        }
    }

    public synchronized void updateNativeWindow(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            synchronized (this) {
                this.mBindedNativeWindow = obj;
                if (obj != null) {
                    Log.i(TAG, "SurfaceTextureRenderer updateNativeWindow " + obj);
                }
                sendMsg(2001, 0, 0);
            }
        }
    }

    public final void useProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            GLES20.glUseProgram(this.program);
        }
    }
}
