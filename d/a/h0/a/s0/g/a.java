package d.a.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.h0.a.s0.g.f.a.f;
import d.a.h0.a.s0.g.f.a.g;
import d.a.h0.a.s0.g.f.a.h;
import d.a.h0.a.s0.g.f.a.i;
import d.a.h0.a.s0.g.h.a;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.s0.b<d.a.h0.a.s0.g.h.a> {

    /* renamed from: d.a.h0.a.s0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0756a implements a.InterfaceC0757a {
        public C0756a(a aVar) {
        }
    }

    public a(@NonNull d.a.h0.a.s0.g.h.a aVar) {
        super(aVar);
        e();
        this.f43871a.a(new d.a.h0.a.s0.g.f.a.d());
        this.f43871a.a(new d.a.h0.a.s0.g.f.a.e());
        this.f43871a.a(new f());
        this.f43871a.a(new g());
        this.f43871a.a(new h());
        this.f43871a.a(new d.a.h0.a.s0.g.f.a.a());
        this.f43871a.a(new i());
        this.f43871a.a(new d.a.h0.a.s0.g.f.a.b());
        this.f43871a.a(new d.a.h0.a.s0.g.f.a.c());
    }

    public final void e() {
        ((d.a.h0.a.s0.g.h.a) this.f43873c).n(new C0756a(this));
    }

    @Override // d.a.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.h0.a.s0.g.h.a) this.f43873c).p()) {
            d.a.h0.a.c0.c.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.a.h0.a.c0.c.g("InlineRtcItemController", "authorize type：" + ((d.a.h0.a.s0.g.h.a) this.f43873c).c() + " command：" + str);
        super.sendCommand(command);
    }
}
