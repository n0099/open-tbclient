package d.a.m0.v.i.a;

import com.baidu.pyramid.annotation.Service;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.m0.a.p.d.i0;
import d.a.m0.a.y0.g.h.b;
import d.a.m0.v.i.a.c.c;
@Service
/* loaded from: classes3.dex */
public class a implements i0 {
    @Override // d.a.m0.a.p.d.i0
    public b a(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.m0.v.i.a.b.b();
    }

    @Override // d.a.m0.a.p.d.i0
    public d.a.m0.a.y0.k.g.a b(ZeusPluginFactory.Invoker invoker, String str) {
        return new c(invoker, str);
    }

    @Override // d.a.m0.a.p.d.i0
    public d.a.m0.a.y0.k.g.a c(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.m0.v.i.a.c.b(invoker, str);
    }

    @Override // d.a.m0.a.p.d.i0
    public d.a.m0.a.y0.g.h.a d(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.m0.v.i.a.b.a();
    }

    @Override // d.a.m0.a.p.d.i0
    public d.a.m0.a.y0.f.a e(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.m0.v.k.a(invoker, str);
    }
}
