package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f69955a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f69956b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f69955a = aVar;
    }

    public void a(Object obj) {
        if (this.f69956b == EGL14.EGL_NO_SURFACE) {
            this.f69956b = this.f69955a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f69955a.d(this.f69956b);
    }

    public void c() {
        this.f69955a.f(this.f69956b);
        this.f69956b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f69955a.g(this.f69956b, j);
    }

    public boolean e() {
        boolean h2 = this.f69955a.h(this.f69956b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
