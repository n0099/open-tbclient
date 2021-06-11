package d.e.c;

import android.view.Surface;
/* loaded from: classes6.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public Surface f69856c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69857d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f69856c = surface;
        this.f69857d = z;
    }

    public void f(a aVar) {
        Surface surface = this.f69856c;
        if (surface != null) {
            this.f69851a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f69856c;
        if (surface != null) {
            if (this.f69857d) {
                surface.release();
            }
            this.f69856c = null;
        }
    }
}
