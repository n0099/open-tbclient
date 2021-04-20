package d.b.i0.q3.j.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.baidu.searchbox.afx.recode.InputSurface;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f60663a;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f60664b;

    /* renamed from: c  reason: collision with root package name */
    public EGLSurface f60665c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f60666d;

    public g(Surface surface) {
        if (surface != null) {
            this.f60666d = surface;
            b();
            return;
        }
        throw null;
    }

    public final void a(String str) {
        boolean z = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(InputSurface.TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public final void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f60663a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                this.f60663a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.f60663a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.f60664b = EGL14.eglCreateContext(this.f60663a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                a("eglCreateContext");
                if (this.f60664b != null) {
                    this.f60665c = EGL14.eglCreateWindowSurface(this.f60663a, eGLConfigArr[0], this.f60666d, new int[]{12344}, 0);
                    a("eglCreateWindowSurface");
                    if (this.f60665c == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void c() {
        EGLDisplay eGLDisplay = this.f60663a;
        EGLSurface eGLSurface = this.f60665c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f60664b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void d() {
        if (EGL14.eglGetCurrentContext().equals(this.f60664b)) {
            EGLDisplay eGLDisplay = this.f60663a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f60663a, this.f60665c);
        EGL14.eglDestroyContext(this.f60663a, this.f60664b);
        this.f60666d.release();
        this.f60663a = null;
        this.f60664b = null;
        this.f60665c = null;
        this.f60666d = null;
    }

    public void e(long j) {
        EGLExt.eglPresentationTimeANDROID(this.f60663a, this.f60665c, j);
    }

    public boolean f() {
        return EGL14.eglSwapBuffers(this.f60663a, this.f60665c);
    }
}
