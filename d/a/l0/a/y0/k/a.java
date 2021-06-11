package d.a.l0.a.y0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.l0.a.k;
import d.a.l0.a.y0.k.e.e;
import d.a.l0.a.y0.k.e.f;
import d.a.l0.a.y0.k.e.g;
import d.a.l0.a.y0.k.e.h;
import d.a.l0.a.y0.k.e.i;
import d.a.l0.a.y0.k.e.j;
import d.a.l0.a.y0.k.e.l;
import d.a.l0.a.y0.k.e.m;
import d.a.l0.a.y0.k.e.n;
import d.a.l0.a.y0.k.e.o;
import d.a.l0.a.y0.k.e.p;
import d.a.l0.a.y0.k.e.q;
import d.a.l0.a.y0.k.e.r;
import d.a.l0.a.y0.k.e.t;
import d.a.l0.a.y0.k.e.u;
import d.a.l0.a.y0.k.e.v;
import d.a.l0.a.y0.k.g.a;
/* loaded from: classes3.dex */
public final class a extends d.a.l0.a.y0.b<d.a.l0.a.y0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49549i = k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0976a f49550h;

    /* renamed from: d.a.l0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0974a implements a.InterfaceC0976a {
        public C0974a() {
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void a(int i2) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void b(int i2) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void c(String str) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.l0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void d(@NonNull String str) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void e(String str) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onPlayed", null);
            }
            d.a.l0.a.u.e.o.k.e().k(str, true);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void f() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onEnded() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onError(int i2) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onPrepared() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onRelease(String str) {
            d.a.l0.a.u.e.o.k.e().p(str);
        }
    }

    public a(@NonNull d.a.l0.a.y0.k.g.a aVar) {
        super(aVar);
        C0974a c0974a = new C0974a();
        this.f49550h = c0974a;
        aVar.i0(c0974a);
        d.a.l0.a.u.e.o.k.e().b(aVar);
        this.f49447a.a(new d.a.l0.a.y0.k.e.a());
        this.f49447a.a(new d.a.l0.a.y0.k.e.b());
        this.f49447a.a(new d.a.l0.a.y0.k.e.c());
        this.f49447a.a(new f());
        this.f49447a.a(new e());
        this.f49447a.a(new d.a.l0.a.y0.k.e.d());
        this.f49447a.a(new g());
        this.f49447a.a(new h());
        this.f49447a.a(new i());
        this.f49447a.a(new j());
        this.f49447a.a(new l());
        this.f49447a.a(new m());
        this.f49447a.a(new n());
        this.f49447a.a(new o());
        this.f49447a.a(new q());
        this.f49447a.a(new r());
        this.f49447a.a(new u());
        this.f49447a.a(new v());
        this.f49447a.a(new p());
        this.f49447a.a(new d.a.l0.a.y0.k.e.k());
        this.f49447a.a(new t());
    }

    @Override // d.a.l0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (w(command)) {
            if (f49549i) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    public final boolean w(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, m.f49557b)) {
            if (f49549i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int a2 = ((d.a.l0.a.y0.k.g.a) this.f49449c).a();
        if (f49549i && a2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.a.l0.a.y0.k.g.a) this.f49449c).a() + " command=> " + str);
        }
        return a2 == 2;
    }
}
