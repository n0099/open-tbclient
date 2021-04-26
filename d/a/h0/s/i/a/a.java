package d.a.h0.s.i.a;

import com.baidu.pyramid.annotation.Service;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.h0.a.p.c.a0;
import d.a.h0.a.s0.g.h.b;
import d.a.h0.s.i.a.b.c;
@Service
/* loaded from: classes3.dex */
public class a implements a0 {
    @Override // d.a.h0.a.p.c.a0
    public b a(ZeusPluginFactory.Invoker invoker, String str) {
        return null;
    }

    @Override // d.a.h0.a.p.c.a0
    public d.a.h0.a.s0.k.g.a b(ZeusPluginFactory.Invoker invoker, String str) {
        return new c(invoker, str);
    }

    @Override // d.a.h0.a.p.c.a0
    public d.a.h0.a.s0.k.g.a c(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.h0.s.i.a.b.b(invoker, str);
    }

    @Override // d.a.h0.a.p.c.a0
    public d.a.h0.a.s0.g.h.a d(ZeusPluginFactory.Invoker invoker, String str) {
        return null;
    }

    @Override // d.a.h0.a.p.c.a0
    public d.a.h0.a.s0.f.a e(ZeusPluginFactory.Invoker invoker, String str) {
        return new d.a.h0.s.k.a(invoker, str);
    }
}
