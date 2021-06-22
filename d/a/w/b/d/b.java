package d.a.w.b.d;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f68551c = "b";

    /* renamed from: a  reason: collision with root package name */
    public a f68552a;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f68553b = EGL14.EGL_NO_SURFACE;

    public b(a aVar) {
        this.f68552a = aVar;
    }

    public void a(Object obj) {
        if (this.f68553b == EGL14.EGL_NO_SURFACE) {
            this.f68553b = this.f68552a.b(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b(a aVar) {
        if (aVar.d(this.f68553b)) {
            return;
        }
        aVar.e(this.f68553b);
    }

    public void c() {
        this.f68552a.g(this.f68553b);
        this.f68553b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.f68552a.h(this.f68553b, j);
    }

    public boolean e() {
        boolean i2 = this.f68552a.i(this.f68553b);
        if (!i2) {
            Log.d(f68551c, "WARNING: swapBuffers() failed");
        }
        return i2;
    }
}
