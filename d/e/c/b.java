package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f66832a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f66833b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f66832a = aVar;
    }

    public void a(Object obj) {
        if (this.f66833b == EGL14.EGL_NO_SURFACE) {
            this.f66833b = this.f66832a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f66832a.d(this.f66833b);
    }

    public void c() {
        this.f66832a.f(this.f66833b);
        this.f66833b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f66832a.g(this.f66833b, j);
    }

    public boolean e() {
        boolean h2 = this.f66832a.h(this.f66833b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
