package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f65987a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f65988b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f65987a = aVar;
    }

    public void a(Object obj) {
        if (this.f65988b == EGL14.EGL_NO_SURFACE) {
            this.f65988b = this.f65987a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f65987a.d(this.f65988b);
    }

    public void c() {
        this.f65987a.f(this.f65988b);
        this.f65988b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f65987a.g(this.f65988b, j);
    }

    public boolean e() {
        boolean h2 = this.f65987a.h(this.f65988b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
