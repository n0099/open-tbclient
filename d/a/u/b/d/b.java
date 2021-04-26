package d.a.u.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f63989c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f63990a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f63991b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f63990a = aVar;
    }

    public void a(Object obj) {
        if (this.f63991b == EGL14.EGL_NO_SURFACE) {
            this.f63991b = this.f63990a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f63991b)) {
            return;
        }
        aVar.e(this.f63991b);
    }

    public void c() {
        this.f63990a.g(this.f63991b);
        this.f63991b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f63990a.h(this.f63991b, j);
    }

    public boolean e() {
        boolean i2 = this.f63990a.i(this.f63991b);
        if (!i2) {
            Log.d(f63989c, "WARNING: swapBuffers() failed");
        }
        return i2;
    }
}
