package d.b.g0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.s0.g.f.b.a0;
import d.b.g0.a.s0.g.f.b.b0;
import d.b.g0.a.s0.g.f.b.c0;
import d.b.g0.a.s0.g.f.b.d0;
import d.b.g0.a.s0.g.f.b.e0;
import d.b.g0.a.s0.g.f.b.f;
import d.b.g0.a.s0.g.f.b.f0;
import d.b.g0.a.s0.g.f.b.g;
import d.b.g0.a.s0.g.f.b.g0;
import d.b.g0.a.s0.g.f.b.h;
import d.b.g0.a.s0.g.f.b.i;
import d.b.g0.a.s0.g.f.b.j;
import d.b.g0.a.s0.g.f.b.k;
import d.b.g0.a.s0.g.f.b.l;
import d.b.g0.a.s0.g.f.b.m;
import d.b.g0.a.s0.g.f.b.n;
import d.b.g0.a.s0.g.f.b.o;
import d.b.g0.a.s0.g.f.b.p;
import d.b.g0.a.s0.g.f.b.q;
import d.b.g0.a.s0.g.f.b.r;
import d.b.g0.a.s0.g.f.b.s;
import d.b.g0.a.s0.g.f.b.t;
import d.b.g0.a.s0.g.f.b.u;
import d.b.g0.a.s0.g.f.b.v;
import d.b.g0.a.s0.g.f.b.w;
import d.b.g0.a.s0.g.f.b.x;
import d.b.g0.a.s0.g.f.b.y;
import d.b.g0.a.s0.g.f.b.z;
import d.b.g0.a.s0.g.h.b;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.s0.b<d.b.g0.a.s0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f46223h;

    /* loaded from: classes2.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.b.g0.a.s0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f46223h = aVar;
        bVar.M(aVar);
        this.f46177a.a(new d.b.g0.a.s0.g.f.b.a());
        this.f46177a.a(new d.b.g0.a.s0.g.f.b.b());
        this.f46177a.a(new d.b.g0.a.s0.g.f.b.c());
        this.f46177a.a(new d.b.g0.a.s0.g.f.b.e());
        this.f46177a.a(new g());
        this.f46177a.a(new h());
        this.f46177a.a(new i());
        this.f46177a.a(new j());
        this.f46177a.a(new k());
        this.f46177a.a(new l());
        this.f46177a.a(new d.b.g0.a.s0.g.f.b.d());
        this.f46177a.a(new f());
        this.f46177a.a(new m());
        this.f46177a.a(new n());
        this.f46177a.a(new o());
        this.f46177a.a(new q());
        this.f46177a.a(new p());
        this.f46177a.a(new r());
        this.f46177a.a(new s());
        this.f46177a.a(new t());
        this.f46177a.a(new u());
        this.f46177a.a(new v());
        this.f46177a.a(new w());
        this.f46177a.a(new x());
        this.f46177a.a(new y());
        this.f46177a.a(new z());
        this.f46177a.a(new a0());
        this.f46177a.a(new b0());
        this.f46177a.a(new c0());
        this.f46177a.a(new d0());
        this.f46177a.a(new e0());
        this.f46177a.a(new g0());
        this.f46177a.a(new f0());
    }

    @Override // d.b.g0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.b.g0.a.s0.g.h.b) this.f46179c).A()) {
            d.b.g0.a.c0.c.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.b.g0.a.c0.c.g("InlineRtcRoomController", "authorize type：" + ((d.b.g0.a.s0.g.h.b) this.f46179c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
