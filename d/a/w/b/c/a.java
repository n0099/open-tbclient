package d.a.w.b.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.w.b.d.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public Surface f68441d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68442e;

    public a(d.a.w.b.d.a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f68441d = surface;
        this.f68442e = z;
    }

    public void f(d.a.w.b.d.a aVar) {
        Surface surface = this.f68441d;
        if (surface != null) {
            this.f68448a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f68441d;
        if (surface != null) {
            if (this.f68442e) {
                surface.release();
            }
            this.f68441d = null;
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
