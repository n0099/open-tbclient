package d.a.l0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.l0.a.y0.g.f.a.f;
import d.a.l0.a.y0.g.f.a.g;
import d.a.l0.a.y0.g.f.a.h;
import d.a.l0.a.y0.g.f.a.i;
import d.a.l0.a.y0.g.h.a;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.y0.b<d.a.l0.a.y0.g.h.a> {

    /* renamed from: d.a.l0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0968a implements a.InterfaceC0969a {
        public C0968a(a aVar) {
        }
    }

    public a(@NonNull d.a.l0.a.y0.g.h.a aVar) {
        super(aVar);
        e();
        this.f49447a.a(new d.a.l0.a.y0.g.f.a.d());
        this.f49447a.a(new d.a.l0.a.y0.g.f.a.e());
        this.f49447a.a(new f());
        this.f49447a.a(new g());
        this.f49447a.a(new h());
        this.f49447a.a(new d.a.l0.a.y0.g.f.a.a());
        this.f49447a.a(new i());
        this.f49447a.a(new d.a.l0.a.y0.g.f.a.b());
        this.f49447a.a(new d.a.l0.a.y0.g.f.a.c());
    }

    public final void e() {
        ((d.a.l0.a.y0.g.h.a) this.f49449c).n(new C0968a(this));
    }

    @Override // d.a.l0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.l0.a.y0.g.h.a) this.f49449c).p()) {
            d.a.l0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.a.l0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((d.a.l0.a.y0.g.h.a) this.f49449c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
