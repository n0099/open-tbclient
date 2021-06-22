package d.e.c;

import android.view.Surface;
/* loaded from: classes6.dex */
public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public Surface f69960c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69961d;

    public e(a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f69960c = surface;
        this.f69961d = z;
    }

    public void f(a aVar) {
        Surface surface = this.f69960c;
        if (surface != null) {
            this.f69955a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f69960c;
        if (surface != null) {
            if (this.f69961d) {
                surface.release();
            }
            this.f69960c = null;
        }
    }
}
