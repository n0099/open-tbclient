package d.f.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f66979a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f66980b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f66979a = aVar;
    }

    public void a(Object obj) {
        if (this.f66980b == EGL14.EGL_NO_SURFACE) {
            this.f66980b = this.f66979a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f66979a.d(this.f66980b);
    }

    public void c() {
        this.f66979a.f(this.f66980b);
        this.f66980b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f66979a.g(this.f66980b, j);
    }

    public boolean e() {
        boolean h2 = this.f66979a.h(this.f66980b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
