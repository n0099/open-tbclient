package d.a.u.b.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.u.b.d.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public Surface f64670d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64671e;

    public a(d.a.u.b.d.a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f64670d = surface;
        this.f64671e = z;
    }

    public void f(d.a.u.b.d.a aVar) {
        Surface surface = this.f64670d;
        if (surface != null) {
            this.f64677a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f64670d;
        if (surface != null) {
            if (this.f64671e) {
                surface.release();
            }
            this.f64670d = null;
        }
    }

    public a(d.a.u.b.d.a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        a(surfaceTexture);
    }

    public a(d.a.u.b.d.a aVar, SurfaceHolder surfaceHolder) {
        super(aVar);
        a(surfaceHolder);
    }
}
