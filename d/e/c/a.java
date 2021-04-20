package d.e.c;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f66829a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f66830b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f66831c;

    public a(EGLContext eGLContext, int i) {
        EGLConfig c2;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f66829a = eGLDisplay;
        this.f66830b = EGL14.EGL_NO_CONTEXT;
        this.f66831c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f66829a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0 && (c2 = c(i, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f66829a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f66831c = c2;
                            this.f66830b = eglCreateContext;
                        }
                    }
                    if (this.f66830b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig c3 = c(i, 2);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f66829a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.f66831c = c3;
                            this.f66830b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f66829a, this.f66830b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f66829a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public EGLSurface b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f66829a, this.f66831c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig c(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f66829a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Log.w("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public void d(EGLSurface eGLSurface) {
        if (this.f66829a == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f66829a, eGLSurface, eGLSurface, this.f66830b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void e() {
        EGLDisplay eGLDisplay = this.f66829a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f66829a, this.f66830b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f66829a);
        }
        this.f66829a = EGL14.EGL_NO_DISPLAY;
        this.f66830b = EGL14.EGL_NO_CONTEXT;
        this.f66831c = null;
    }

    public void f(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f66829a, eGLSurface);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f66829a != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                e();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f66829a, eGLSurface, j);
    }

    public boolean h(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f66829a, eGLSurface);
    }
}
