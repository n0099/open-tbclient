package d.a.w.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f64729c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f64730a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f64731b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f64730a = aVar;
    }

    public void a(Object obj) {
        if (this.f64731b == EGL14.EGL_NO_SURFACE) {
            this.f64731b = this.f64730a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f64731b)) {
            return;
        }
        aVar.e(this.f64731b);
    }

    public void c() {
        this.f64730a.g(this.f64731b);
        this.f64731b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f64730a.h(this.f64731b, j);
    }

    public boolean e() {
        boolean i2 = this.f64730a.i(this.f64731b);
        if (!i2) {
            Log.d(f64729c, "WARNING: swapBuffers() failed");
        }
        return i2;
    }
}
