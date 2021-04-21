package d.b.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.h0.a.s0.g.f.b.a0;
import d.b.h0.a.s0.g.f.b.b0;
import d.b.h0.a.s0.g.f.b.c0;
import d.b.h0.a.s0.g.f.b.d0;
import d.b.h0.a.s0.g.f.b.e0;
import d.b.h0.a.s0.g.f.b.f;
import d.b.h0.a.s0.g.f.b.f0;
import d.b.h0.a.s0.g.f.b.g;
import d.b.h0.a.s0.g.f.b.g0;
import d.b.h0.a.s0.g.f.b.h;
import d.b.h0.a.s0.g.f.b.i;
import d.b.h0.a.s0.g.f.b.j;
import d.b.h0.a.s0.g.f.b.k;
import d.b.h0.a.s0.g.f.b.l;
import d.b.h0.a.s0.g.f.b.m;
import d.b.h0.a.s0.g.f.b.n;
import d.b.h0.a.s0.g.f.b.o;
import d.b.h0.a.s0.g.f.b.p;
import d.b.h0.a.s0.g.f.b.q;
import d.b.h0.a.s0.g.f.b.r;
import d.b.h0.a.s0.g.f.b.s;
import d.b.h0.a.s0.g.f.b.t;
import d.b.h0.a.s0.g.f.b.u;
import d.b.h0.a.s0.g.f.b.v;
import d.b.h0.a.s0.g.f.b.w;
import d.b.h0.a.s0.g.f.b.x;
import d.b.h0.a.s0.g.f.b.y;
import d.b.h0.a.s0.g.f.b.z;
import d.b.h0.a.s0.g.h.b;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.s0.b<d.b.h0.a.s0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f46552h;

    /* loaded from: classes2.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.b.h0.a.s0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f46552h = aVar;
        bVar.M(aVar);
        this.f46506a.a(new d.b.h0.a.s0.g.f.b.a());
        this.f46506a.a(new d.b.h0.a.s0.g.f.b.b());
        this.f46506a.a(new d.b.h0.a.s0.g.f.b.c());
        this.f46506a.a(new d.b.h0.a.s0.g.f.b.e());
        this.f46506a.a(new g());
        this.f46506a.a(new h());
        this.f46506a.a(new i());
        this.f46506a.a(new j());
        this.f46506a.a(new k());
        this.f46506a.a(new l());
        this.f46506a.a(new d.b.h0.a.s0.g.f.b.d());
        this.f46506a.a(new f());
        this.f46506a.a(new m());
        this.f46506a.a(new n());
        this.f46506a.a(new o());
        this.f46506a.a(new q());
        this.f46506a.a(new p());
        this.f46506a.a(new r());
        this.f46506a.a(new s());
        this.f46506a.a(new t());
        this.f46506a.a(new u());
        this.f46506a.a(new v());
        this.f46506a.a(new w());
        this.f46506a.a(new x());
        this.f46506a.a(new y());
        this.f46506a.a(new z());
        this.f46506a.a(new a0());
        this.f46506a.a(new b0());
        this.f46506a.a(new c0());
        this.f46506a.a(new d0());
        this.f46506a.a(new e0());
        this.f46506a.a(new g0());
        this.f46506a.a(new f0());
    }

    @Override // d.b.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.b.h0.a.s0.g.h.b) this.f46508c).A()) {
            d.b.h0.a.c0.c.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.b.h0.a.c0.c.g("InlineRtcRoomController", "authorize type：" + ((d.b.h0.a.s0.g.h.b) this.f46508c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
