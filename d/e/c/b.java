package d.e.c;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f66077a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f66078b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f66077a = aVar;
    }

    public void a(Object obj) {
        if (this.f66078b == EGL14.EGL_NO_SURFACE) {
            this.f66078b = this.f66077a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.f66077a.d(this.f66078b);
    }

    public void c() {
        this.f66077a.f(this.f66078b);
        this.f66078b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f66077a.g(this.f66078b, j);
    }

    public boolean e() {
        boolean h2 = this.f66077a.h(this.f66078b);
        if (!h2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return h2;
    }
}
