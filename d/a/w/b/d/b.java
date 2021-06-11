package d.a.w.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f68447c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f68448a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f68449b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f68448a = aVar;
    }

    public void a(Object obj) {
        if (this.f68449b == EGL14.EGL_NO_SURFACE) {
            this.f68449b = this.f68448a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f68449b)) {
            return;
        }
        aVar.e(this.f68449b);
    }

    public void c() {
        this.f68448a.g(this.f68449b);
        this.f68449b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f68448a.h(this.f68449b, j);
    }

    public boolean e() {
        boolean i2 = this.f68448a.i(this.f68449b);
        if (!i2) {
            Log.d(f68447c, "WARNING: swapBuffers() failed");
        }
        return i2;
    }
}
