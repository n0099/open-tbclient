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
    public static final boolean f45875i = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0920a f45876h;

    /* renamed from: d.a.l0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0918a implements a.InterfaceC0920a {
        public C0918a() {
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void a(int i2) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void b(int i2) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void c(String str) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.l0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void d(@NonNull String str) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void e(String str) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onPlayed", null);
            }
            d.a.l0.a.u.e.o.k.e().k(str, true);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void f() {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onEnded() {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onError(int i2) {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onPrepared() {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onRelease(String str) {
            d.a.l0.a.u.e.o.k.e().p(str);
        }
    }

    public a(@NonNull d.a.l0.a.y0.k.g.a aVar) {
        super(aVar);
        C0918a c0918a = new C0918a();
        this.f45876h = c0918a;
        aVar.l0(c0918a);
        d.a.l0.a.u.e.o.k.e().b(aVar);
        this.f45773a.a(new d.a.l0.a.y0.k.e.a());
        this.f45773a.a(new d.a.l0.a.y0.k.e.b());
        this.f45773a.a(new d.a.l0.a.y0.k.e.c());
        this.f45773a.a(new f());
        this.f45773a.a(new e());
        this.f45773a.a(new d.a.l0.a.y0.k.e.d());
        this.f45773a.a(new g());
        this.f45773a.a(new h());
        this.f45773a.a(new i());
        this.f45773a.a(new j());
        this.f45773a.a(new l());
        this.f45773a.a(new m());
        this.f45773a.a(new n());
        this.f45773a.a(new o());
        this.f45773a.a(new q());
        this.f45773a.a(new r());
        this.f45773a.a(new u());
        this.f45773a.a(new v());
        this.f45773a.a(new p());
        this.f45773a.a(new d.a.l0.a.y0.k.e.k());
        this.f45773a.a(new t());
    }

    @Override // d.a.l0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (w(command)) {
            if (f45875i) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    public final boolean w(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, m.f45883b)) {
            if (f45875i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int a2 = ((d.a.l0.a.y0.k.g.a) this.f45775c).a();
        if (f45875i && a2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.a.l0.a.y0.k.g.a) this.f45775c).a() + " command=> " + str);
        }
        return a2 == 2;
    }
}
