package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f65986a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f65987b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f65986a = aVar;
    }

    public void a(Object obj) {
        if (this.f65987b == EGL14.EGL_NO_SURFACE) {
            this.f65987b = this.f65986a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f65986a.d(this.f65987b);
    }

    public void c() {
        this.f65986a.f(this.f65987b);
        this.f65987b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f65986a.g(this.f65987b, j);
    }

    public boolean e() {
        boolean h2 = this.f65986a.h(this.f65987b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
