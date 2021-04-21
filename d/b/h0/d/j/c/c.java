package d.b.h0.d.j.c;

import com.baidu.pyramid.annotation.Service;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.h0.a.p.c.z0;
@Service
/* loaded from: classes3.dex */
public class c implements z0 {
    @Override // d.b.h0.a.p.c.z0
    public d.b.h0.l.o.b a() {
        return b.b().a();
    }

    @Override // d.b.h0.a.p.c.z0
    public boolean b() {
        return !b.b().c();
    }

    @Override // d.b.h0.a.p.c.z0
    public boolean c() {
        return b() || d.b.h0.a.j0.i.c.f45553d.j(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
    }

    @Override // d.b.h0.a.p.c.z0
    public void d(boolean z, d.b.h0.a.e0.u.c cVar) {
        b.b().b(z, cVar);
    }
}
