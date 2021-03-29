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
    public EGLDisplay f65984a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f65985b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f65986c;

    public a(EGLContext eGLContext, int i) {
        EGLConfig c2;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f65984a = eGLDisplay;
        this.f65985b = EGL14.EGL_NO_CONTEXT;
        this.f65986c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f65984a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0 && (c2 = c(i, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f65984a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f65986c = c2;
                            this.f65985b = eglCreateContext;
                        }
                    }
                    if (this.f65985b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig c3 = c(i, 2);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f65984a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.f65986c = c3;
                            this.f65985b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f65984a, this.f65985b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f65984a = null;
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
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f65984a, this.f65986c, obj, new int[]{12344}, 0);
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
        if (!EGL14.eglChooseConfig(this.f65984a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Log.w("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public void d(EGLSurface eGLSurface) {
        if (this.f65984a == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f65984a, eGLSurface, eGLSurface, this.f65985b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void e() {
        EGLDisplay eGLDisplay = this.f65984a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f65984a, this.f65985b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f65984a);
        }
        this.f65984a = EGL14.EGL_NO_DISPLAY;
        this.f65985b = EGL14.EGL_NO_CONTEXT;
        this.f65986c = null;
    }

    public void f(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f65984a, eGLSurface);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f65984a != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                e();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f65984a, eGLSurface, j);
    }

    public boolean h(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f65984a, eGLSurface);
    }
}
