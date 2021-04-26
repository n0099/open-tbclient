package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f65391a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f65392b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f65391a = aVar;
    }

    public void a(Object obj) {
        if (this.f65392b == EGL14.EGL_NO_SURFACE) {
            this.f65392b = this.f65391a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f65391a.d(this.f65392b);
    }

    public void c() {
        this.f65391a.f(this.f65392b);
        this.f65392b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f65391a.g(this.f65392b, j);
    }

    public boolean e() {
        boolean h2 = this.f65391a.h(this.f65392b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
