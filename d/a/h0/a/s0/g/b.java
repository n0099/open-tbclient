package d.a.h0.a.s0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.h0.a.s0.g.f.b.a0;
import d.a.h0.a.s0.g.f.b.b0;
import d.a.h0.a.s0.g.f.b.c0;
import d.a.h0.a.s0.g.f.b.d0;
import d.a.h0.a.s0.g.f.b.e0;
import d.a.h0.a.s0.g.f.b.f;
import d.a.h0.a.s0.g.f.b.f0;
import d.a.h0.a.s0.g.f.b.g;
import d.a.h0.a.s0.g.f.b.g0;
import d.a.h0.a.s0.g.f.b.h;
import d.a.h0.a.s0.g.f.b.i;
import d.a.h0.a.s0.g.f.b.j;
import d.a.h0.a.s0.g.f.b.k;
import d.a.h0.a.s0.g.f.b.l;
import d.a.h0.a.s0.g.f.b.m;
import d.a.h0.a.s0.g.f.b.n;
import d.a.h0.a.s0.g.f.b.o;
import d.a.h0.a.s0.g.f.b.p;
import d.a.h0.a.s0.g.f.b.q;
import d.a.h0.a.s0.g.f.b.r;
import d.a.h0.a.s0.g.f.b.s;
import d.a.h0.a.s0.g.f.b.t;
import d.a.h0.a.s0.g.f.b.u;
import d.a.h0.a.s0.g.f.b.v;
import d.a.h0.a.s0.g.f.b.w;
import d.a.h0.a.s0.g.f.b.x;
import d.a.h0.a.s0.g.f.b.y;
import d.a.h0.a.s0.g.f.b.z;
import d.a.h0.a.s0.g.h.b;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.s0.b<d.a.h0.a.s0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f43919h;

    /* loaded from: classes2.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.a.h0.a.s0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f43919h = aVar;
        bVar.V(aVar);
        this.f43871a.a(new d.a.h0.a.s0.g.f.b.a());
        this.f43871a.a(new d.a.h0.a.s0.g.f.b.b());
        this.f43871a.a(new d.a.h0.a.s0.g.f.b.c());
        this.f43871a.a(new d.a.h0.a.s0.g.f.b.e());
        this.f43871a.a(new g());
        this.f43871a.a(new h());
        this.f43871a.a(new i());
        this.f43871a.a(new j());
        this.f43871a.a(new k());
        this.f43871a.a(new l());
        this.f43871a.a(new d.a.h0.a.s0.g.f.b.d());
        this.f43871a.a(new f());
        this.f43871a.a(new m());
        this.f43871a.a(new n());
        this.f43871a.a(new o());
        this.f43871a.a(new q());
        this.f43871a.a(new p());
        this.f43871a.a(new r());
        this.f43871a.a(new s());
        this.f43871a.a(new t());
        this.f43871a.a(new u());
        this.f43871a.a(new v());
        this.f43871a.a(new w());
        this.f43871a.a(new x());
        this.f43871a.a(new y());
        this.f43871a.a(new z());
        this.f43871a.a(new a0());
        this.f43871a.a(new b0());
        this.f43871a.a(new c0());
        this.f43871a.a(new d0());
        this.f43871a.a(new e0());
        this.f43871a.a(new g0());
        this.f43871a.a(new f0());
    }

    @Override // d.a.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.h0.a.s0.g.h.b) this.f43873c).p()) {
            d.a.h0.a.c0.c.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.a.h0.a.c0.c.g("InlineRtcRoomController", "authorize type：" + ((d.a.h0.a.s0.g.h.b) this.f43873c).c() + " command：" + str);
        super.sendCommand(command);
    }
}
