package d.a.m0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.m0.a.y0.g.f.a.f;
import d.a.m0.a.y0.g.f.a.g;
import d.a.m0.a.y0.g.f.a.h;
import d.a.m0.a.y0.g.f.a.i;
import d.a.m0.a.y0.g.h.a;
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.y0.b<d.a.m0.a.y0.g.h.a> {

    /* renamed from: d.a.m0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0971a implements a.InterfaceC0972a {
        public C0971a(a aVar) {
        }
    }

    public a(@NonNull d.a.m0.a.y0.g.h.a aVar) {
        super(aVar);
        e();
        this.f49555a.a(new d.a.m0.a.y0.g.f.a.d());
        this.f49555a.a(new d.a.m0.a.y0.g.f.a.e());
        this.f49555a.a(new f());
        this.f49555a.a(new g());
        this.f49555a.a(new h());
        this.f49555a.a(new d.a.m0.a.y0.g.f.a.a());
        this.f49555a.a(new i());
        this.f49555a.a(new d.a.m0.a.y0.g.f.a.b());
        this.f49555a.a(new d.a.m0.a.y0.g.f.a.c());
    }

    public final void e() {
        ((d.a.m0.a.y0.g.h.a) this.f49557c).n(new C0971a(this));
    }

    @Override // d.a.m0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.m0.a.y0.g.h.a) this.f49557c).p()) {
            d.a.m0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.a.m0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((d.a.m0.a.y0.g.h.a) this.f49557c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
