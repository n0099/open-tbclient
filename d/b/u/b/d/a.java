package d.b.u.b.d;

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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f65640d = "a";

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f65641a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f65642b;

    /* renamed from: c  reason: collision with root package name */
    public EGLConfig f65643c;

    public a(EGLContext eGLContext, int i) {
        this(eGLContext, i, false);
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
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f65641a, this.f65643c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final EGLConfig c(int i, int i2, boolean z) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, z ? 16 : 0, 12326, 0, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[14] = 12610;
            iArr[15] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f65641a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            String str = f65640d;
            Log.w(str, "unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        return eGLConfigArr[0];
    }

    public boolean d(EGLSurface eGLSurface) {
        return this.f65642b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void e(EGLSurface eGLSurface) {
        if (this.f65641a == EGL14.EGL_NO_DISPLAY) {
            Log.d(f65640d, "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f65641a, eGLSurface, eGLSurface, this.f65642b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f65641a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f65641a, this.f65642b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f65641a);
        }
        this.f65641a = EGL14.EGL_NO_DISPLAY;
        this.f65642b = EGL14.EGL_NO_CONTEXT;
        this.f65643c = null;
    }

    public void finalize() throws Throwable {
        try {
            if (this.f65641a != EGL14.EGL_NO_DISPLAY) {
                Log.w(f65640d, "WARNING: EGLCore was not explicitly released -- state may be leaked");
                f();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f65641a, eGLSurface);
    }

    public void h(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f65641a, eGLSurface, j);
    }

    public boolean i(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f65641a, eGLSurface);
    }

    public a(EGLContext eGLContext, int i, boolean z) {
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f65641a = eGLDisplay;
        this.f65642b = EGL14.EGL_NO_CONTEXT;
        this.f65643c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f65641a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0) {
                        Log.d(f65640d, "Trying GLES 3");
                        EGLConfig c2 = c(i, 3, z);
                        if (c2 != null) {
                            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f65641a, c2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                            if (EGL14.eglGetError() == 12288) {
                                this.f65643c = c2;
                                this.f65642b = eglCreateContext;
                            }
                        }
                    }
                    if (this.f65642b == EGL14.EGL_NO_CONTEXT) {
                        Log.d(f65640d, "Trying GLES 2");
                        EGLConfig c3 = c(i, 2, z);
                        if (c3 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f65641a, c3, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.f65643c = c3;
                            this.f65642b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f65641a, this.f65642b, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    String str = f65640d;
                    Log.d(str, "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.f65641a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }
}
