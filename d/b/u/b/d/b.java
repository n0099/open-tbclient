package d.b.u.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f65644c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f65645a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f65646b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f65645a = aVar;
    }

    public void a(Object obj) {
        if (this.f65646b == EGL14.EGL_NO_SURFACE) {
            this.f65646b = this.f65645a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f65646b)) {
            return;
        }
        aVar.e(this.f65646b);
    }

    public void c() {
        this.f65645a.g(this.f65646b);
        this.f65646b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f65645a.h(this.f65646b, j);
    }

    public boolean e() {
        boolean i = this.f65645a.i(this.f65646b);
        if (!i) {
            Log.d(f65644c, "WARNING: swapBuffers() failed");
        }
        return i;
    }
}
