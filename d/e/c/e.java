package d.e.c;

import android.view.Surface;
/* loaded from: classes6.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public Surface f65992c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65993d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f65992c = surface;
        this.f65993d = z;
    }

    public void f(a aVar) {
        Surface surface = this.f65992c;
        if (surface != null) {
            this.f65987a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f65992c;
        if (surface != null) {
            if (this.f65993d) {
                surface.release();
            }
            this.f65992c = null;
        }
    }
}
