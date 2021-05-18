package d.a.i0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.i0.a.y0.g.f.a.f;
import d.a.i0.a.y0.g.f.a.g;
import d.a.i0.a.y0.g.f.a.h;
import d.a.i0.a.y0.g.f.a.i;
import d.a.i0.a.y0.g.h.a;
/* loaded from: classes.dex */
public class a extends d.a.i0.a.y0.b<d.a.i0.a.y0.g.h.a> {

    /* renamed from: d.a.i0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0901a implements a.InterfaceC0902a {
        public C0901a(a aVar) {
        }
    }

    public a(@NonNull d.a.i0.a.y0.g.h.a aVar) {
        super(aVar);
        e();
        this.f45597a.a(new d.a.i0.a.y0.g.f.a.d());
        this.f45597a.a(new d.a.i0.a.y0.g.f.a.e());
        this.f45597a.a(new f());
        this.f45597a.a(new g());
        this.f45597a.a(new h());
        this.f45597a.a(new d.a.i0.a.y0.g.f.a.a());
        this.f45597a.a(new i());
        this.f45597a.a(new d.a.i0.a.y0.g.f.a.b());
        this.f45597a.a(new d.a.i0.a.y0.g.f.a.c());
    }

    public final void e() {
        ((d.a.i0.a.y0.g.h.a) this.f45599c).o(new C0901a(this));
    }

    @Override // d.a.i0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.i0.a.y0.g.h.a) this.f45599c).q()) {
            d.a.i0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        d.a.i0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((d.a.i0.a.y0.g.h.a) this.f45599c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
