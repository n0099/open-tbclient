package d.f.c;

import android.view.Surface;
/* loaded from: classes6.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public Surface f66984c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66985d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f66984c = surface;
        this.f66985d = z;
    }

    public void f(a aVar) {
        Surface surface = this.f66984c;
        if (surface != null) {
            this.f66979a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f66984c;
        if (surface != null) {
            if (this.f66985d) {
                surface.release();
            }
            this.f66984c = null;
        }
    }
}
