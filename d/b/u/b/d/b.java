package d.b.u.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64685c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f64686a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f64687b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f64686a = aVar;
    }

    public void a(Object obj) {
        if (this.f64687b == EGL14.EGL_NO_SURFACE) {
            this.f64687b = this.f64686a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f64687b)) {
            return;
        }
        aVar.e(this.f64687b);
    }

    public void c() {
        this.f64686a.g(this.f64687b);
        this.f64687b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f64686a.h(this.f64687b, j);
    }

    public boolean e() {
        boolean i = this.f64686a.i(this.f64687b);
        if (!i) {
            Log.d(f64685c, "WARNING: swapBuffers() failed");
        }
        return i;
    }
}
