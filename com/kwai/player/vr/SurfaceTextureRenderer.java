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
/* loaded from: classes3.dex */
public class SurfaceTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private static final int MSG_DESTROYSURFACE = 2002;
    private static final int MSG_INIT = 1000;
    private static final int MSG_RENDER = 1001;
    private static final int MSG_RENDER_LOOP = 1004;
    private static final int MSG_RESIZE_VIDEO = 1002;
    private static final int MSG_RESIZE_WINDOW = 1003;
    private static final int MSG_UPDATESURFACE = 2001;
    private static final String TAG = "SurfaceTextureRenderer";
    private static final int VERTICES_DATA_POS_SIZE = 3;
    private static final int VERTICES_DATA_UV_SIZE = 2;
    private static final int mLoopDuration = 40;
    private static final int maxDelayDuration = 60;
    private int fragmentShader;
    private String fragmentShaderSource;
    protected KwaiMesh kwaiMesh;
    private Object mBindedNativeWindow;
    private Context mContext;
    private BaseConfigChooser.SimpleEGLConfigChooser mEGLConfigChooser;
    private boolean mEGLInited;
    private EGLConfig mEglConfig;
    private EGLSurface mEglSurface;
    private HandlerThread mHandlerThread;
    private KwaiMediaPlayer.IHeadTrackerListener mHeadTrackerListener;
    private int mHeight;
    private KwaiVR mKwaiVR;
    private volatile long mLastDisplayFrameTime;
    private RenderHandler mRenderHandler;
    private Surface mSurface;
    private int mTexName;
    private SurfaceTexture mTexSurfaceTexture;
    private int mWidth;
    private int mWindowHeight;
    private int mWindowWidth;
    private int program;
    private int vertexShader;
    private String vertexShaderSource;
    private volatile boolean mLoopEnd = false;
    private float[] mTransformMatrix = new float[16];
    private boolean mFirstRender = true;
    private EGL10 mEgl = null;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private int mEGLContextClientVersion = 2;
    private final HashMap<String, Integer> handleMap = new HashMap<>();
    private FpsStatistic mFpsStatistic = new FpsStatistic();
    private Object mGlRenderSync = new Object();
    private volatile boolean mWindowSizeChanged = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RenderHandler extends Handler {
        private WeakReference<SurfaceTextureRenderer> mWeakObj;

        public RenderHandler(SurfaceTextureRenderer surfaceTextureRenderer, Looper looper) {
            super(looper);
            this.mWeakObj = new WeakReference<>(surfaceTextureRenderer);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SurfaceTextureRenderer surfaceTextureRenderer = this.mWeakObj.get();
            if (surfaceTextureRenderer == null) {
                return;
            }
            switch (message.what) {
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
                case 2001:
                    break;
                case 2002:
                    surfaceTextureRenderer.destroySurfaceImpl();
                    return;
                default:
                    return;
            }
            surfaceTextureRenderer.updateSurfaceTextureImpl();
        }
    }

    public SurfaceTextureRenderer(Context context) {
        this.mContext = context;
    }

    private int createTextureObject() {
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

    private void destroyEgl() {
        if (this.mEgl != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroySurfaceImpl() {
        if (this.mEgl != null && this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE && this.mEglDisplay != null) {
            Log.i(TAG, "eglDestroySurface in");
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            this.mEglSurface = EGL10.EGL_NO_SURFACE;
            Log.i(TAG, "eglDestroySurface out");
        }
    }

    private void drawFrame() {
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
                if (this.mKwaiVR != null) {
                    this.mKwaiVR.setViewport(this.mWindowWidth, this.mWindowHeight);
                }
                if (!updateSurfaceTextureImpl()) {
                    Log.e(TAG, "updateSurfaceTextureImpl failed");
                    return;
                }
            } else {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
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
            } catch (Exception e) {
            }
            if (this.mWindowSizeChanged) {
                this.mWindowSizeChanged = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEGL() {
        Log.i(TAG, "initEGL in");
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e(TAG, "initEGL eglGetDisplay failed! " + this.mEgl.eglGetError());
        } else if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
            Log.e(TAG, "initEGL eglInitialize failed! " + this.mEgl.eglGetError());
        } else {
            this.mEGLConfigChooser = new BaseConfigChooser.SimpleEGLConfigChooser(true, this.mEGLContextClientVersion);
            this.mEglConfig = this.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
            this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, this.mEGLContextClientVersion, 12344});
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                Log.e(TAG, "initEGL eglCreateContext fail failed! " + this.mEgl.eglGetError());
                return;
            }
            this.mEGLInited = true;
            Log.i(TAG, "initEGL out");
        }
    }

    private void releaseEgl() {
        GLES20.glDeleteProgram(this.program);
        this.program = 0;
        GLES20.glDeleteShader(this.vertexShader);
        this.vertexShader = 0;
        GLES20.glDeleteShader(this.fragmentShader);
        this.fragmentShader = 0;
        this.handleMap.clear();
    }

    private void releaseImpl() {
        Log.i(TAG, "SurfaceTextureRenderer releaseImpl in");
        if (this.mRenderHandler != null) {
            this.mRenderHandler.removeMessages(1000);
            this.mRenderHandler.removeMessages(1001);
            stopDrawFrameLoop();
            this.mRenderHandler = null;
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        destroyEgl();
        if (this.mSurface != null && this.mSurface.isValid()) {
            Log.i(TAG, "Surface.release() in" + this.mSurface);
            this.mSurface.release();
            this.mSurface = null;
            Log.i(TAG, "Surface.release() out");
        }
        Log.i(TAG, "SurfaceTextureRenderer releaseImpl out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVideoImpl(int i, int i2) {
        Log.d(TAG, "resizeVideo width " + i + " height: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeWindowImpl(int i, int i2) {
        synchronized (this.mGlRenderSync) {
            if (this.mKwaiVR != null) {
                this.mWindowSizeChanged = true;
                this.mKwaiVR.setViewport(i, i2);
            }
        }
    }

    private void setupEgl() {
        releaseEgl();
        Log.i(TAG, "setupEgl in");
        try {
            this.vertexShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_vertex_shader);
            this.fragmentShaderSource = EglUtil.readTextFileFromRaw(this.mContext, R.raw.kwaiplayer_fragment_shader);
            this.vertexShader = EglUtil.loadShader(this.vertexShaderSource, 35633);
            this.fragmentShader = EglUtil.loadShader(this.fragmentShaderSource, 35632);
            this.program = EglUtil.createProgram(this.vertexShader, this.fragmentShader);
        } catch (Exception e) {
            Log.e(TAG, "throw setupEgl failed" + e.getMessage());
        }
        Log.i(TAG, "setupEgl out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncDrawFrame() {
        synchronized (this.mGlRenderSync) {
            drawFrame();
            this.mLastDisplayFrameTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerDrawFrameLoop() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateSurfaceTextureImpl() {
        boolean z = false;
        synchronized (this) {
            if (this.mEgl == null || this.mEglDisplay == null || this.mEglConfig == null) {
                Log.d(TAG, "updateSurfaceTextureImpl: failed");
            } else {
                destroySurfaceImpl();
                if (this.mBindedNativeWindow != null) {
                    try {
                        this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.mBindedNativeWindow, null);
                        if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                            Log.e(TAG, "eglCreateWindowSurface error " + this.mEgl.eglGetError());
                        } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                            setupEgl();
                            z = true;
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "throw eglCreateWindowSurface failed" + e.getMessage());
                    }
                }
            }
        }
        return z;
    }

    public SurfaceTexture createTexture() {
        this.mTexName = createTextureObject();
        this.mTexSurfaceTexture = new SurfaceTexture(this.mTexName);
        this.mTexSurfaceTexture.setOnFrameAvailableListener(this);
        return this.mTexSurfaceTexture;
    }

    public void destroyGlSurface() {
        sendMsg(2002, 0, 0);
    }

    public void drawTexture(int i, float[] fArr, float[] fArr2) {
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
        if (verticesBuffer != null) {
            verticesBuffer.position(0);
            GLES20.glEnableVertexAttribArray(getHandle("aPosition"));
            GLES20.glVertexAttribPointer(getHandle("aPosition"), 3, 5126, false, 0, (Buffer) verticesBuffer);
            FloatBuffer texCoordinateBuffer = this.kwaiMesh.getTexCoordinateBuffer(0);
            if (texCoordinateBuffer == null) {
                Log.d(TAG, "getTexCoordinateBuffer is null");
                return;
            }
            texCoordinateBuffer.position(0);
            GLES20.glEnableVertexAttribArray(getHandle("aTextureCoord"));
            GLES20.glVertexAttribPointer(getHandle("aTextureCoord"), 2, 5126, false, 0, (Buffer) texCoordinateBuffer);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
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
        int[] iArr = new int[1];
        this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12374, iArr);
        return iArr[0];
    }

    public int eglGetSurfaceWidth() {
        int[] iArr = new int[1];
        this.mEgl.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12375, iArr);
        return iArr[0];
    }

    public boolean eglIsVaild() {
        return (!this.mEGLInited || this.mEgl == null || this.mEglDisplay == null || this.mEglContext == null || this.mEglSurface == null) ? false : true;
    }

    public boolean eglSetSurfaceSize(int i, int i2) {
        if (eglIsVaild()) {
            if (i == this.mWindowWidth && i2 == this.mWindowHeight) {
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

    public int getFps() {
        return this.mFpsStatistic.getFps();
    }

    protected final int getHandle(String str) {
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

    public Surface getSurface() {
        if (this.mSurface == null) {
            this.mSurface = SurfaceUtil.create(getTexture());
        }
        if (!this.mSurface.isValid()) {
            SurfaceUtil.release(this.mSurface);
            if (Build.VERSION.SDK_INT >= 21 && this.mTexSurfaceTexture != null) {
                this.mTexSurfaceTexture.setOnFrameAvailableListener(null);
                this.mTexSurfaceTexture.release();
                this.mTexSurfaceTexture = null;
            }
            this.mSurface = SurfaceUtil.create(getTexture());
        }
        if (this.mSurface == null || !this.mSurface.isValid()) {
            Log.d(TAG, "getSurface: Surface invalid mSurface:" + this.mSurface + ",valid:" + (this.mSurface != null ? this.mSurface.isValid() : false));
            throw new RuntimeException("getSurface invalid");
        }
        Log.d(TAG, "create surface" + this.mSurface);
        return this.mSurface;
    }

    public SurfaceTexture getTexture() {
        if (this.mTexSurfaceTexture == null) {
            createTexture();
        }
        return this.mTexSurfaceTexture;
    }

    public void init() {
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("Renderer Thread");
            this.mHandlerThread.start();
        }
        if (this.mRenderHandler == null) {
            this.mRenderHandler = new RenderHandler(this, this.mHandlerThread.getLooper());
            sendMsg(1000, 0, 0);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        sendMsg(1001, 0, 0);
        if (!this.mFirstRender || this.mKwaiVR == null) {
            return;
        }
        this.mKwaiVR.setInteractiveValid();
    }

    public void release() {
        synchronized (this.mGlRenderSync) {
            if (this.mKwaiVR != null) {
                this.mKwaiVR.release();
                this.mKwaiVR = null;
                Log.d(TAG, "release mKwaiVR");
            }
            releaseImpl();
        }
    }

    public void reset() {
        this.mFpsStatistic.resetFps();
    }

    public void resizeVideo(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        Log.d(TAG, "resize width:" + i + ",height:" + i2);
        this.mWidth = i;
        this.mHeight = i2;
        sendMsg(1002, i, i2);
    }

    public void resizeWindow(int i, int i2) {
        synchronized (this.mGlRenderSync) {
            Log.i(TAG, "resizeWindow width:" + i + ",height:" + i2);
            if (this.mWindowWidth != i || this.mWindowHeight != i2) {
                Log.i(TAG, "send resizeWindow width:" + i + ",height:" + i2);
                this.mWindowWidth = i;
                this.mWindowHeight = i2;
                sendMsg(1003, i, i2);
            }
        }
    }

    public void sendMsg(int i, int i2, int i3) {
        if (this.mRenderHandler != null) {
            this.mRenderHandler.removeMessages(i);
        }
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        if (this.mRenderHandler != null) {
            this.mRenderHandler.sendMessage(message);
        }
    }

    public void setHeadTrackerListener(KwaiMediaPlayer.IHeadTrackerListener iHeadTrackerListener) {
        this.mHeadTrackerListener = iHeadTrackerListener;
    }

    public void setKwaiVR(KwaiVR kwaiVR) {
        this.mKwaiVR = kwaiVR;
        if (this.mKwaiVR != null) {
            this.kwaiMesh = this.mKwaiVR.getKwaiMesh();
        }
    }

    public void startFps() {
        this.mFpsStatistic.startFps();
    }

    public void stopDrawFrameLoop() {
        synchronized (this.mGlRenderSync) {
            this.mLoopEnd = true;
            if (this.mRenderHandler != null) {
                this.mRenderHandler.removeMessages(1004);
            }
        }
    }

    public void stopFps() {
        this.mFpsStatistic.stopFps();
    }

    public synchronized void updateNativeWindow(Object obj) {
        this.mBindedNativeWindow = obj;
        if (this.mBindedNativeWindow != null) {
            Log.i(TAG, "SurfaceTextureRenderer updateNativeWindow " + obj);
        }
        sendMsg(2001, 0, 0);
    }

    protected final void useProgram() {
        GLES20.glUseProgram(this.program);
    }
}
