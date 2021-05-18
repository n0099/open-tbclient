package d.a.u.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64676c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f64677a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f64678b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f64677a = aVar;
    }

    public void a(Object obj) {
        if (this.f64678b == EGL14.EGL_NO_SURFACE) {
            this.f64678b = this.f64677a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f64678b)) {
            return;
        }
        aVar.e(this.f64678b);
    }

    public void c() {
        this.f64677a.g(this.f64678b);
        this.f64678b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f64677a.h(this.f64678b, j);
    }

    public boolean e() {
        boolean i2 = this.f64677a.i(this.f64678b);
        if (!i2) {
            Log.d(f64676c, "WARNING: swapBuffers() failed");
        }
        return i2;
    }
}
