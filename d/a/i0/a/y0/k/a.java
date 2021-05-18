package d.a.i0.a.y0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.i0.a.k;
import d.a.i0.a.y0.k.e.e;
import d.a.i0.a.y0.k.e.f;
import d.a.i0.a.y0.k.e.g;
import d.a.i0.a.y0.k.e.h;
import d.a.i0.a.y0.k.e.i;
import d.a.i0.a.y0.k.e.j;
import d.a.i0.a.y0.k.e.l;
import d.a.i0.a.y0.k.e.m;
import d.a.i0.a.y0.k.e.n;
import d.a.i0.a.y0.k.e.o;
import d.a.i0.a.y0.k.e.p;
import d.a.i0.a.y0.k.e.q;
import d.a.i0.a.y0.k.e.r;
import d.a.i0.a.y0.k.e.t;
import d.a.i0.a.y0.k.e.u;
import d.a.i0.a.y0.k.e.v;
import d.a.i0.a.y0.k.g.a;
/* loaded from: classes3.dex */
public final class a extends d.a.i0.a.y0.b<d.a.i0.a.y0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45699i = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0909a f45700h;

    /* renamed from: d.a.i0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0907a implements a.InterfaceC0909a {
        public C0907a() {
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void a(int i2) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void b(int i2) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void c(String str) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.i0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void d(@NonNull String str) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void e(String str) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onPlayed", null);
            }
            d.a.i0.a.u.e.o.k.e().k(str, true);
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void f() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void onEnded() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void onError(int i2) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void onPrepared() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.a.i0.a.y0.k.g.a.InterfaceC0909a
        public void onRelease(String str) {
            d.a.i0.a.u.e.o.k.e().p(str);
        }
    }

    public a(@NonNull d.a.i0.a.y0.k.g.a aVar) {
        super(aVar);
        C0907a c0907a = new C0907a();
        this.f45700h = c0907a;
        aVar.l0(c0907a);
        d.a.i0.a.u.e.o.k.e().b(aVar);
        this.f45597a.a(new d.a.i0.a.y0.k.e.a());
        this.f45597a.a(new d.a.i0.a.y0.k.e.b());
        this.f45597a.a(new d.a.i0.a.y0.k.e.c());
        this.f45597a.a(new f());
        this.f45597a.a(new e());
        this.f45597a.a(new d.a.i0.a.y0.k.e.d());
        this.f45597a.a(new g());
        this.f45597a.a(new h());
        this.f45597a.a(new i());
        this.f45597a.a(new j());
        this.f45597a.a(new l());
        this.f45597a.a(new m());
        this.f45597a.a(new n());
        this.f45597a.a(new o());
        this.f45597a.a(new q());
        this.f45597a.a(new r());
        this.f45597a.a(new u());
        this.f45597a.a(new v());
        this.f45597a.a(new p());
        this.f45597a.a(new d.a.i0.a.y0.k.e.k());
        this.f45597a.a(new t());
    }

    @Override // d.a.i0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (w(command)) {
            if (f45699i) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    public final boolean w(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, m.f45707b)) {
            if (f45699i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int a2 = ((d.a.i0.a.y0.k.g.a) this.f45599c).a();
        if (f45699i && a2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.a.i0.a.y0.k.g.a) this.f45599c).a() + " command=> " + str);
        }
        return a2 == 2;
    }
}
