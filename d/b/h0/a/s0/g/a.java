package d.b.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.h0.a.s0.g.f.a.f;
import d.b.h0.a.s0.g.f.a.g;
import d.b.h0.a.s0.g.f.a.h;
import d.b.h0.a.s0.g.f.a.i;
import d.b.h0.a.s0.g.h.a;
/* loaded from: classes2.dex */
public class a extends d.b.h0.a.s0.b<d.b.h0.a.s0.g.h.a> {

    /* renamed from: d.b.h0.a.s0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0817a implements a.InterfaceC0818a {
        public C0817a(a aVar) {
        }
    }

    public a(@NonNull d.b.h0.a.s0.g.h.a aVar) {
        super(aVar);
        e();
        this.f46506a.a(new d.b.h0.a.s0.g.f.a.d());
        this.f46506a.a(new d.b.h0.a.s0.g.f.a.e());
        this.f46506a.a(new f());
        this.f46506a.a(new g());
        this.f46506a.a(new h());
        this.f46506a.a(new d.b.h0.a.s0.g.f.a.a());
        this.f46506a.a(new i());
        this.f46506a.a(new d.b.h0.a.s0.g.f.a.b());
        this.f46506a.a(new d.b.h0.a.s0.g.f.a.c());
    }

    public final void e() {
        ((d.b.h0.a.s0.g.h.a) this.f46508c).w(new C0817a(this));
    }

    @Override // d.b.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.b.h0.a.s0.g.h.a) this.f46508c).A()) {
            d.b.h0.a.c0.c.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.b.h0.a.c0.c.g("InlineRtcItemController", "authorize type：" + ((d.b.h0.a.s0.g.h.a) this.f46508c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
