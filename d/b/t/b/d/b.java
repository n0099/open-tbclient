package d.b.t.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f65380c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f65381a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f65382b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f65381a = aVar;
    }

    public void a(Object obj) {
        if (this.f65382b == EGL14.EGL_NO_SURFACE) {
            this.f65382b = this.f65381a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f65382b)) {
            return;
        }
        aVar.e(this.f65382b);
    }

    public void c() {
        this.f65381a.g(this.f65382b);
        this.f65382b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f65381a.h(this.f65382b, j);
    }

    public boolean e() {
        boolean i = this.f65381a.i(this.f65382b);
        if (!i) {
            Log.d(f65380c, "WARNING: swapBuffers() failed");
        }
        return i;
    }
}
