package d.a.w.b.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.w.b.d.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public Surface f64723d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64724e;

    public a(d.a.w.b.d.a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f64723d = surface;
        this.f64724e = z;
    }

    public void f(d.a.w.b.d.a aVar) {
        Surface surface = this.f64723d;
        if (surface != null) {
            this.f64730a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f64723d;
        if (surface != null) {
            if (this.f64724e) {
                surface.release();
            }
            this.f64723d = null;
        }
    }

    public a(d.a.w.b.d.a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        a(surfaceTexture);
    }

    public a(d.a.w.b.d.a aVar, SurfaceHolder surfaceHolder) {
        super(aVar);
        a(surfaceHolder);
    }
}
