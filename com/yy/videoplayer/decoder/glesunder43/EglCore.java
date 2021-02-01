package com.yy.videoplayer.decoder.glesunder43;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
/* loaded from: classes4.dex */
public class EglCore {
    private static final String TAG = "EglCore";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGL10 mEgl;

    public EglCore() {
        this(null);
    }

    public EglCore(EGLConfig eGLConfig) {
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEGLDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
        if (!this.mEgl.eglInitialize(this.mEGLDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed");
        }
        this.mEGLConfig = chooseConfig(this.mEgl, this.mEGLDisplay);
    }

    private int[] filterConfigSpec(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length - 1);
        iArr2[length - 1] = 12352;
        iArr2[length] = 4;
        iArr2[length + 1] = 12344;
        return iArr2;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] filterConfigSpec = filterConfigSpec(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344, 0});
        int[] iArr = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, filterConfigSpec, null, 0, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, filterConfigSpec, eGLConfigArr, i, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        EGLConfig doChooseConfig = doChooseConfig(egl10, eGLDisplay, eGLConfigArr);
        if (doChooseConfig == null) {
            throw new IllegalArgumentException("No config chosen");
        }
        this.mEGLContext = egl10.eglCreateContext(eGLDisplay, doChooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        return doChooseConfig;
    }

    public EGLConfig doChooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
            findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
            int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
            int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
            int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
            int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
            if (findConfigAttrib == 8 && findConfigAttrib2 == 8 && findConfigAttrib3 == 8 && findConfigAttrib4 == 8) {
                return eGLConfig;
            }
        }
        return null;
    }

    private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        int[] iArr = new int[1];
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return i2;
    }

    public GL getGL() {
        return this.mEgl.eglGetCurrentContext().getGL();
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        this.mEgl.eglDestroySurface(this.mEgl.eglGetCurrentDisplay(), eGLSurface);
    }

    public EGLSurface createWindowSurface(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture) && !(obj instanceof SurfaceHolder)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        new int[1][0] = 12344;
        EGLSurface eglCreateWindowSurface = this.mEgl.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, null);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eglCreateWindowSurface;
    }

    public EGLSurface createOffscreenSurface(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = this.mEgl.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i, 12374, i2, 12344});
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface == null) {
            throw new RuntimeException("surface was null");
        }
        return eglCreatePbufferSurface;
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        if (this.mEGLDisplay == EGL11.EGL_NO_DISPLAY) {
            Log.d(TAG, "NOTE: makeCurrent w/o display");
        }
        if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        EGLDisplay eglGetCurrentDisplay = this.mEgl.eglGetCurrentDisplay();
        if (eglGetCurrentDisplay == EGL11.EGL_NO_DISPLAY) {
            Log.d(TAG, "NOTE: makeCurrent w/o display");
        }
        if (!this.mEgl.eglMakeCurrent(eglGetCurrentDisplay, eGLSurface, eGLSurface2, this.mEgl.eglGetCurrentContext())) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public void makeNothingCurrent() {
        if (!this.mEgl.eglMakeCurrent(this.mEgl.eglGetCurrentDisplay(), EGL11.EGL_NO_SURFACE, EGL11.EGL_NO_SURFACE, EGL11.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        return this.mEgl.eglSwapBuffers(this.mEgl.eglGetCurrentDisplay(), eGLSurface);
    }

    public void setPresentationTime(EGLSurface eGLSurface, long j) {
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        return this.mEGLContext.equals(this.mEgl.eglGetCurrentContext()) && eGLSurface.equals(this.mEgl.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        this.mEgl.eglQuerySurface(this.mEgl.eglGetCurrentDisplay(), eGLSurface, i, iArr);
        return iArr[0];
    }

    public String queryString(int i) {
        return this.mEgl.eglQueryString(this.mEgl.eglGetCurrentDisplay(), i);
    }

    public int getGlVersion() {
        return 2;
    }

    public void logCurrent(String str) {
        EGLDisplay eglGetCurrentDisplay = this.mEgl.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = this.mEgl.eglGetCurrentContext();
        Log.i(TAG, "Current EGL (" + str + "): display=" + eglGetCurrentDisplay + ", context=" + eglGetCurrentContext + ", surface=" + this.mEgl.eglGetCurrentSurface(12377));
    }

    public EGLSurface getCurrentSurface() {
        return this.mEgl.eglGetCurrentSurface(12377);
    }

    private void checkEglError(String str) {
        int eglGetError = this.mEgl.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void release() {
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.mEgl.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            this.mEgl.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }
}
