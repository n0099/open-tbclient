package d.a.u.b.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.u.b.d.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public Surface f63983d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63984e;

    public a(d.a.u.b.d.a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f63983d = surface;
        this.f63984e = z;
    }

    public void f(d.a.u.b.d.a aVar) {
        Surface surface = this.f63983d;
        if (surface != null) {
            this.f63990a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f63983d;
        if (surface != null) {
            if (this.f63984e) {
                surface.release();
            }
            this.f63983d = null;
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
