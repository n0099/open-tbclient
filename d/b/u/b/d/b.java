package d.b.u.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64686c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f64687a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f64688b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f64687a = aVar;
    }

    public void a(Object obj) {
        if (this.f64688b == EGL14.EGL_NO_SURFACE) {
            this.f64688b = this.f64687a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f64688b)) {
            return;
        }
        aVar.e(this.f64688b);
    }

    public void c() {
        this.f64687a.g(this.f64688b);
        this.f64688b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f64687a.h(this.f64688b, j);
    }

    public boolean e() {
        boolean i = this.f64687a.i(this.f64688b);
        if (!i) {
            Log.d(f64686c, "WARNING: swapBuffers() failed");
        }
        return i;
    }
}
