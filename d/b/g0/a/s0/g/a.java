package d.b.g0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.s0.g.f.a.f;
import d.b.g0.a.s0.g.f.a.g;
import d.b.g0.a.s0.g.f.a.h;
import d.b.g0.a.s0.g.f.a.i;
import d.b.g0.a.s0.g.h.a;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.s0.b<d.b.g0.a.s0.g.h.a> {

    /* renamed from: d.b.g0.a.s0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0784a implements a.InterfaceC0785a {
        public C0784a(a aVar) {
        }
    }

    public a(@NonNull d.b.g0.a.s0.g.h.a aVar) {
        super(aVar);
        e();
        this.f45784a.a(new d.b.g0.a.s0.g.f.a.d());
        this.f45784a.a(new d.b.g0.a.s0.g.f.a.e());
        this.f45784a.a(new f());
        this.f45784a.a(new g());
        this.f45784a.a(new h());
        this.f45784a.a(new d.b.g0.a.s0.g.f.a.a());
        this.f45784a.a(new i());
        this.f45784a.a(new d.b.g0.a.s0.g.f.a.b());
        this.f45784a.a(new d.b.g0.a.s0.g.f.a.c());
    }

    public final void e() {
        ((d.b.g0.a.s0.g.h.a) this.f45786c).w(new C0784a(this));
    }

    @Override // d.b.g0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.b.g0.a.s0.g.h.a) this.f45786c).A()) {
            d.b.g0.a.c0.c.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.b.g0.a.c0.c.g("InlineRtcItemController", "authorize type：" + ((d.b.g0.a.s0.g.h.a) this.f45786c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
