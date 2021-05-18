package d.a.i0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.i0.a.y0.g.f.b.a0;
import d.a.i0.a.y0.g.f.b.b0;
import d.a.i0.a.y0.g.f.b.c0;
import d.a.i0.a.y0.g.f.b.d0;
import d.a.i0.a.y0.g.f.b.e0;
import d.a.i0.a.y0.g.f.b.f;
import d.a.i0.a.y0.g.f.b.f0;
import d.a.i0.a.y0.g.f.b.g;
import d.a.i0.a.y0.g.f.b.g0;
import d.a.i0.a.y0.g.f.b.h;
import d.a.i0.a.y0.g.f.b.h0;
import d.a.i0.a.y0.g.f.b.i;
import d.a.i0.a.y0.g.f.b.j;
import d.a.i0.a.y0.g.f.b.k;
import d.a.i0.a.y0.g.f.b.l;
import d.a.i0.a.y0.g.f.b.m;
import d.a.i0.a.y0.g.f.b.n;
import d.a.i0.a.y0.g.f.b.o;
import d.a.i0.a.y0.g.f.b.p;
import d.a.i0.a.y0.g.f.b.q;
import d.a.i0.a.y0.g.f.b.r;
import d.a.i0.a.y0.g.f.b.s;
import d.a.i0.a.y0.g.f.b.t;
import d.a.i0.a.y0.g.f.b.u;
import d.a.i0.a.y0.g.f.b.v;
import d.a.i0.a.y0.g.f.b.w;
import d.a.i0.a.y0.g.f.b.x;
import d.a.i0.a.y0.g.f.b.y;
import d.a.i0.a.y0.g.f.b.z;
import d.a.i0.a.y0.g.h.b;
/* loaded from: classes.dex */
public class b extends d.a.i0.a.y0.b<d.a.i0.a.y0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f45645h;

    /* loaded from: classes.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.a.i0.a.y0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f45645h = aVar;
        bVar.d0(aVar);
        this.f45597a.a(new d.a.i0.a.y0.g.f.b.a());
        this.f45597a.a(new d.a.i0.a.y0.g.f.b.b());
        this.f45597a.a(new d.a.i0.a.y0.g.f.b.c());
        this.f45597a.a(new d.a.i0.a.y0.g.f.b.e());
        this.f45597a.a(new g());
        this.f45597a.a(new h());
        this.f45597a.a(new i());
        this.f45597a.a(new j());
        this.f45597a.a(new k());
        this.f45597a.a(new l());
        this.f45597a.a(new d.a.i0.a.y0.g.f.b.d());
        this.f45597a.a(new f());
        this.f45597a.a(new n());
        this.f45597a.a(new o());
        this.f45597a.a(new p());
        this.f45597a.a(new r());
        this.f45597a.a(new q());
        this.f45597a.a(new s());
        this.f45597a.a(new t());
        this.f45597a.a(new u());
        this.f45597a.a(new v());
        this.f45597a.a(new w());
        this.f45597a.a(new x());
        this.f45597a.a(new y());
        this.f45597a.a(new z());
        this.f45597a.a(new a0());
        this.f45597a.a(new b0());
        this.f45597a.a(new c0());
        this.f45597a.a(new d0());
        this.f45597a.a(new e0());
        this.f45597a.a(new f0());
        this.f45597a.a(new h0());
        this.f45597a.a(new g0());
        this.f45597a.a(new m());
    }

    @Override // d.a.i0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.i0.a.y0.g.h.b) this.f45599c).q()) {
            d.a.i0.a.e0.d.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.a.i0.a.e0.d.g("InlineRtcRoomController", "authorize type：" + ((d.a.i0.a.y0.g.h.b) this.f45599c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
