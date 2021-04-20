package d.e.c;

import android.view.Surface;
/* loaded from: classes6.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public Surface f66837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66838d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f66837c = surface;
        this.f66838d = z;
    }

    public void f(a aVar) {
        Surface surface = this.f66837c;
        if (surface != null) {
            this.f66832a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f66837c;
        if (surface != null) {
            if (this.f66838d) {
                surface.release();
            }
            this.f66837c = null;
        }
    }
}
