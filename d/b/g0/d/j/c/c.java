package d.b.g0.d.j.c;

import com.baidu.pyramid.annotation.Service;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.g0.a.p.c.z0;
@Service
/* loaded from: classes3.dex */
public class c implements z0 {
    @Override // d.b.g0.a.p.c.z0
    public d.b.g0.l.o.b a() {
        return b.b().a();
    }

    @Override // d.b.g0.a.p.c.z0
    public boolean b() {
        return !b.b().c();
    }

    @Override // d.b.g0.a.p.c.z0
    public boolean c() {
        return b() || d.b.g0.a.j0.i.c.f44832d.j(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
    }

    @Override // d.b.g0.a.p.c.z0
    public void d(boolean z, d.b.g0.a.e0.u.c cVar) {
        b.b().b(z, cVar);
    }
}
