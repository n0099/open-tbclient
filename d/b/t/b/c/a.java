package d.b.t.b.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.b.t.b.d.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d  reason: collision with root package name */
    public Surface f65374d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65375e;

    public a(d.b.t.b.d.a aVar, Surface surface, boolean z) {
        super(aVar);
        a(surface);
        this.f65374d = surface;
        this.f65375e = z;
    }

    public void f(d.b.t.b.d.a aVar) {
        Surface surface = this.f65374d;
        if (surface != null) {
            this.f65381a = aVar;
            a(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void g() {
        c();
        Surface surface = this.f65374d;
        if (surface != null) {
            if (this.f65375e) {
                surface.release();
            }
            this.f65374d = null;
        }
    }

    public a(d.b.t.b.d.a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        a(surfaceTexture);
    }

    public a(d.b.t.b.d.a aVar, SurfaceHolder surfaceHolder) {
        super(aVar);
        a(surfaceHolder);
    }
}
