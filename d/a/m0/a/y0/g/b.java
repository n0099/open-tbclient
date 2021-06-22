package d.a.m0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.m0.a.y0.g.f.b.a0;
import d.a.m0.a.y0.g.f.b.b0;
import d.a.m0.a.y0.g.f.b.c0;
import d.a.m0.a.y0.g.f.b.d0;
import d.a.m0.a.y0.g.f.b.e0;
import d.a.m0.a.y0.g.f.b.f;
import d.a.m0.a.y0.g.f.b.f0;
import d.a.m0.a.y0.g.f.b.g;
import d.a.m0.a.y0.g.f.b.g0;
import d.a.m0.a.y0.g.f.b.h;
import d.a.m0.a.y0.g.f.b.h0;
import d.a.m0.a.y0.g.f.b.i;
import d.a.m0.a.y0.g.f.b.j;
import d.a.m0.a.y0.g.f.b.k;
import d.a.m0.a.y0.g.f.b.l;
import d.a.m0.a.y0.g.f.b.m;
import d.a.m0.a.y0.g.f.b.n;
import d.a.m0.a.y0.g.f.b.o;
import d.a.m0.a.y0.g.f.b.p;
import d.a.m0.a.y0.g.f.b.q;
import d.a.m0.a.y0.g.f.b.r;
import d.a.m0.a.y0.g.f.b.s;
import d.a.m0.a.y0.g.f.b.t;
import d.a.m0.a.y0.g.f.b.u;
import d.a.m0.a.y0.g.f.b.v;
import d.a.m0.a.y0.g.f.b.w;
import d.a.m0.a.y0.g.f.b.x;
import d.a.m0.a.y0.g.f.b.y;
import d.a.m0.a.y0.g.f.b.z;
import d.a.m0.a.y0.g.h.b;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.y0.b<d.a.m0.a.y0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f49603h;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.a.m0.a.y0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f49603h = aVar;
        bVar.a0(aVar);
        this.f49555a.a(new d.a.m0.a.y0.g.f.b.a());
        this.f49555a.a(new d.a.m0.a.y0.g.f.b.b());
        this.f49555a.a(new d.a.m0.a.y0.g.f.b.c());
        this.f49555a.a(new d.a.m0.a.y0.g.f.b.e());
        this.f49555a.a(new g());
        this.f49555a.a(new h());
        this.f49555a.a(new i());
        this.f49555a.a(new j());
        this.f49555a.a(new k());
        this.f49555a.a(new l());
        this.f49555a.a(new d.a.m0.a.y0.g.f.b.d());
        this.f49555a.a(new f());
        this.f49555a.a(new n());
        this.f49555a.a(new o());
        this.f49555a.a(new p());
        this.f49555a.a(new r());
        this.f49555a.a(new q());
        this.f49555a.a(new s());
        this.f49555a.a(new t());
        this.f49555a.a(new u());
        this.f49555a.a(new v());
        this.f49555a.a(new w());
        this.f49555a.a(new x());
        this.f49555a.a(new y());
        this.f49555a.a(new z());
        this.f49555a.a(new a0());
        this.f49555a.a(new b0());
        this.f49555a.a(new c0());
        this.f49555a.a(new d0());
        this.f49555a.a(new e0());
        this.f49555a.a(new f0());
        this.f49555a.a(new h0());
        this.f49555a.a(new g0());
        this.f49555a.a(new m());
    }

    @Override // d.a.m0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.m0.a.y0.g.h.b) this.f49557c).p()) {
            d.a.m0.a.e0.d.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.a.m0.a.e0.d.g("InlineRtcRoomController", "authorize type：" + ((d.a.m0.a.y0.g.h.b) this.f49557c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
