package d.b.g0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.s0.g.f.a.f;
import d.b.g0.a.s0.g.f.a.g;
import d.b.g0.a.s0.g.f.a.h;
import d.b.g0.a.s0.g.f.a.i;
import d.b.g0.a.s0.g.h.a;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.s0.b<d.b.g0.a.s0.g.h.a> {

    /* renamed from: d.b.g0.a.s0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0785a implements a.InterfaceC0786a {
        public C0785a(a aVar) {
        }
    }

    public a(@NonNull d.b.g0.a.s0.g.h.a aVar) {
        super(aVar);
        e();
        this.f45785a.a(new d.b.g0.a.s0.g.f.a.d());
        this.f45785a.a(new d.b.g0.a.s0.g.f.a.e());
        this.f45785a.a(new f());
        this.f45785a.a(new g());
        this.f45785a.a(new h());
        this.f45785a.a(new d.b.g0.a.s0.g.f.a.a());
        this.f45785a.a(new i());
        this.f45785a.a(new d.b.g0.a.s0.g.f.a.b());
        this.f45785a.a(new d.b.g0.a.s0.g.f.a.c());
    }

    public final void e() {
        ((d.b.g0.a.s0.g.h.a) this.f45787c).w(new C0785a(this));
    }

    @Override // d.b.g0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.b.g0.a.s0.g.h.a) this.f45787c).A()) {
            d.b.g0.a.c0.c.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.b.g0.a.c0.c.g("InlineRtcItemController", "authorize type：" + ((d.b.g0.a.s0.g.h.a) this.f45787c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
