package d.a.l0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.l0.a.y0.g.f.b.a0;
import d.a.l0.a.y0.g.f.b.b0;
import d.a.l0.a.y0.g.f.b.c0;
import d.a.l0.a.y0.g.f.b.d0;
import d.a.l0.a.y0.g.f.b.e0;
import d.a.l0.a.y0.g.f.b.f;
import d.a.l0.a.y0.g.f.b.f0;
import d.a.l0.a.y0.g.f.b.g;
import d.a.l0.a.y0.g.f.b.g0;
import d.a.l0.a.y0.g.f.b.h;
import d.a.l0.a.y0.g.f.b.h0;
import d.a.l0.a.y0.g.f.b.i;
import d.a.l0.a.y0.g.f.b.j;
import d.a.l0.a.y0.g.f.b.k;
import d.a.l0.a.y0.g.f.b.l;
import d.a.l0.a.y0.g.f.b.m;
import d.a.l0.a.y0.g.f.b.n;
import d.a.l0.a.y0.g.f.b.o;
import d.a.l0.a.y0.g.f.b.p;
import d.a.l0.a.y0.g.f.b.q;
import d.a.l0.a.y0.g.f.b.r;
import d.a.l0.a.y0.g.f.b.s;
import d.a.l0.a.y0.g.f.b.t;
import d.a.l0.a.y0.g.f.b.u;
import d.a.l0.a.y0.g.f.b.v;
import d.a.l0.a.y0.g.f.b.w;
import d.a.l0.a.y0.g.f.b.x;
import d.a.l0.a.y0.g.f.b.y;
import d.a.l0.a.y0.g.f.b.z;
import d.a.l0.a.y0.g.h.b;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.y0.b<d.a.l0.a.y0.g.h.b> {

    /* renamed from: h  reason: collision with root package name */
    public b.a f45821h;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a(b bVar) {
        }
    }

    public b(@NonNull d.a.l0.a.y0.g.h.b bVar) {
        super(bVar);
        a aVar = new a(this);
        this.f45821h = aVar;
        bVar.d0(aVar);
        this.f45773a.a(new d.a.l0.a.y0.g.f.b.a());
        this.f45773a.a(new d.a.l0.a.y0.g.f.b.b());
        this.f45773a.a(new d.a.l0.a.y0.g.f.b.c());
        this.f45773a.a(new d.a.l0.a.y0.g.f.b.e());
        this.f45773a.a(new g());
        this.f45773a.a(new h());
        this.f45773a.a(new i());
        this.f45773a.a(new j());
        this.f45773a.a(new k());
        this.f45773a.a(new l());
        this.f45773a.a(new d.a.l0.a.y0.g.f.b.d());
        this.f45773a.a(new f());
        this.f45773a.a(new n());
        this.f45773a.a(new o());
        this.f45773a.a(new p());
        this.f45773a.a(new r());
        this.f45773a.a(new q());
        this.f45773a.a(new s());
        this.f45773a.a(new t());
        this.f45773a.a(new u());
        this.f45773a.a(new v());
        this.f45773a.a(new w());
        this.f45773a.a(new x());
        this.f45773a.a(new y());
        this.f45773a.a(new z());
        this.f45773a.a(new a0());
        this.f45773a.a(new b0());
        this.f45773a.a(new c0());
        this.f45773a.a(new d0());
        this.f45773a.a(new e0());
        this.f45773a.a(new f0());
        this.f45773a.a(new h0());
        this.f45773a.a(new g0());
        this.f45773a.a(new m());
    }

    @Override // d.a.l0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((d.a.l0.a.y0.g.h.b) this.f45775c).q()) {
            d.a.l0.a.e0.d.g("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        d.a.l0.a.e0.d.g("InlineRtcRoomController", "authorize type：" + ((d.a.l0.a.y0.g.h.b) this.f45775c).a() + " command：" + str);
        super.sendCommand(command);
    }
}
