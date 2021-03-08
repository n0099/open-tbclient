package com.yy.mediaframework.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.yy.mediaframework.utils.YMFLog;
@TargetApi(17)
/* loaded from: classes6.dex */
public final class EglCore implements IEglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "GlUtil";
    private boolean isShared;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglCore() {
        this(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EglCore(Object obj, int i) {
        EGLContext eGLContext;
        EGLConfig config;
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.isShared = false;
        if (!(obj instanceof EGLContext) && obj != null) {
            throw new RuntimeException("EGL already set up");
        }
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        if (obj == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
            this.isShared = false;
        } else {
            eGLContext = (EGLContext) obj;
            this.isShared = true;
        }
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            this.mEGLDisplay = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (config = getConfig(i, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.mEGLConfig = config;
                this.mEGLContext = eglCreateContext;
                this.mGlVersion = 3;
            }
        }
        if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
            EGLConfig config2 = getConfig(i, 2);
            if (config2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, eGLContext, new int[]{12440, 2, 12344}, 0);
            checkEglError("eglCreateContext");
            this.mEGLConfig = config2;
            this.mEGLContext = eglCreateContext2;
            this.mGlVersion = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, iArr2, 0);
        YMFLog.info(this, "[Util    ]", "EGLContext created, client version:" + iArr2[0]);
    }

    private EGLConfig getConfig(int i, int i2) {
        int i3 = i2 >= 3 ? 68 : 4;
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        YMFLog.warn(this, "[Util    ]", "unable to find EGLConfig:RGB8888/" + i2 + " ");
        return null;
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public void release() {
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public void makeCurrent(IEglSurfaceBase iEglSurfaceBase) {
        if (iEglSurfaceBase != null) {
            iEglSurfaceBase.makeCurrent();
        }
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public void makeCurrent(IEglSurfaceBase iEglSurfaceBase, IEglSurfaceBase iEglSurfaceBase2) {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = null;
        if (iEglSurfaceBase != null && (iEglSurfaceBase instanceof EglSurfaceBase)) {
            eGLSurface = ((EglSurfaceBase) iEglSurfaceBase).getEGLSurface();
        } else if (iEglSurfaceBase != null) {
            throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
        } else {
            eGLSurface = null;
        }
        if (iEglSurfaceBase2 != null && (iEglSurfaceBase2 instanceof EglSurfaceBase)) {
            eGLSurface2 = ((EglSurfaceBase) iEglSurfaceBase2).getEGLSurface();
        } else if (iEglSurfaceBase2 != null) {
            throw new RuntimeException("EGL version error,  readSurface is not getInstance of  EglSurfaceBase");
        }
        _makeCurrent(eGLSurface, eGLSurface2);
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public boolean swapBuffers(IEglSurfaceBase iEglSurfaceBase) {
        if (iEglSurfaceBase == null || !(iEglSurfaceBase instanceof EglSurfaceBase)) {
            throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
        }
        return swapBuffers(((EglSurfaceBase) iEglSurfaceBase).getEGLSurface());
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public void setPresentationTime(IEglSurfaceBase iEglSurfaceBase, long j) {
        if (iEglSurfaceBase != null && (iEglSurfaceBase instanceof EglSurfaceBase)) {
            _setPresentationTime(((EglSurfaceBase) iEglSurfaceBase).getEGLSurface(), j);
        } else if (iEglSurfaceBase != null) {
            throw new RuntimeException("EGL version error,  drawSurface is not getInstance of  EglSurfaceBase");
        }
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public boolean isCurrent(IEglSurfaceBase iEglSurfaceBase) {
        if (iEglSurfaceBase != null && (iEglSurfaceBase instanceof EglSurfaceBase)) {
            return _isCurrent(((EglSurfaceBase) iEglSurfaceBase).getEGLSurface());
        }
        if (iEglSurfaceBase != null) {
            throw new RuntimeException("EGL version error,  surface is not opengl.EGLSurface ");
        }
        return false;
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public int querySurface(IEglSurfaceBase iEglSurfaceBase, int i) {
        if (iEglSurfaceBase != null && (iEglSurfaceBase instanceof EglSurfaceBase)) {
            return _querySurface(((EglSurfaceBase) iEglSurfaceBase).getEGLSurface(), i);
        }
        if (iEglSurfaceBase != null) {
            throw new RuntimeException("EGL version error,  surface is not opengl.EGLSurface ");
        }
        return -1;
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public IEglSurfaceBase createSurfaceBase() {
        return new EglSurfaceBase(this);
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public IWindowSurface createWindowSurface(Surface surface, boolean z) {
        return new WindowSurface(this, surface, z);
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public IWindowSurface createWindowSurface(SurfaceHolder surfaceHolder, boolean z) {
        throw new RuntimeException("EGL version error,  android.opengl.egl don't need SurfaceHolder to create window surface");
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public IWindowSurface createWindowSurface(SurfaceTexture surfaceTexture) {
        return new WindowSurface(this, surfaceTexture);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY && !this.isShared) {
                YMFLog.warn(this, "[Util    ]", "WARNING: EglCore was not explicitly released -- state may be leaked");
                release();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseSurface(EGLSurface eGLSurface) {
        YMFLog.info(this, "[Util    ]", "releaseSurface success?:" + EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface) + " eglSurface:" + eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EGLSurface createWindowSurface(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eglCreateWindowSurface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EGLSurface createOffscreenSurface(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eglCreatePbufferSurface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _makeCurrent(EGLSurface eGLSurface) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            YMFLog.info(this, "[Util    ]", "NOTE: makeCurrent w/o display");
        }
        boolean eglMakeCurrent = EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
        checkEglError("_makeCurrent");
        if (!eglMakeCurrent) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void _makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            YMFLog.info(this, "[Util    ]", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
            YMFLog.error(this, "[Procedur]", " eglMakeCurrent:" + this.mEGLContext + " eglSurface:" + eGLSurface + "/" + eGLSurface2 + " mEGLDisplay:" + this.mEGLDisplay);
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public int _querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        YMFLog.info(this, "[Util    ]", "query surface result:" + EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i, iArr, 0));
        return iArr[0];
    }

    public boolean _isCurrent(EGLSurface eGLSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public void makeNothingCurrent() {
        boolean eglMakeCurrent = EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        checkEglError("makeNothingCurrent");
        if (!eglMakeCurrent) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
    }

    @TargetApi(18)
    public void _setPresentationTime(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j);
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public String queryString(int i) {
        return EGL14.eglQueryString(this.mEGLDisplay, i);
    }

    @Override // com.yy.mediaframework.gles.IEglCore
    public int getGlVersion() {
        return this.mGlVersion;
    }

    public static void logCurrent(String str) {
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        YMFLog.info(null, "[Util    ]", "Current EGL (" + str + ") display:" + eglGetCurrentDisplay + ", context:" + eglGetCurrentContext + ", surface:" + EGL14.eglGetCurrentSurface(12377));
    }

    private void checkEglError(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.mediaframework.gles.IEglCore
    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }
}
