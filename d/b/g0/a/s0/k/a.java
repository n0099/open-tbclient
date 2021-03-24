package d.b.g0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.g0.a.k;
import d.b.g0.a.s0.k.e.e;
import d.b.g0.a.s0.k.e.f;
import d.b.g0.a.s0.k.e.g;
import d.b.g0.a.s0.k.e.h;
import d.b.g0.a.s0.k.e.i;
import d.b.g0.a.s0.k.e.l;
import d.b.g0.a.s0.k.e.m;
import d.b.g0.a.s0.k.e.n;
import d.b.g0.a.s0.k.e.o;
import d.b.g0.a.s0.k.e.p;
import d.b.g0.a.s0.k.e.r;
import d.b.g0.a.s0.k.e.s;
import d.b.g0.a.s0.k.e.t;
import d.b.g0.a.s0.k.g.a;
import d.b.g0.a.t.c.m.j;
/* loaded from: classes3.dex */
public final class a extends d.b.g0.a.s0.b<d.b.g0.a.s0.k.g.a> {
    public static final boolean i = k.f45050a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0792a f45882h;

    /* renamed from: d.b.g0.a.s0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0790a implements a.InterfaceC0792a {
        public C0790a() {
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void a(int i) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void b(String str) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void c(int i) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void d(@NonNull String str) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void e(String str) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onPlayed", null);
            }
            j.c().h(str, true);
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void f() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void onEnded() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void onError(int i) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onError", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void onPrepared() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0792a
        public void onRelease(String str) {
            j.c().l(str);
        }
    }

    public a(@NonNull d.b.g0.a.s0.k.g.a aVar) {
        super(aVar);
        C0790a c0790a = new C0790a();
        this.f45882h = c0790a;
        aVar.a0(c0790a);
        j.c().b(aVar);
        this.f45784a.a(new d.b.g0.a.s0.k.e.a());
        this.f45784a.a(new d.b.g0.a.s0.k.e.b());
        this.f45784a.a(new d.b.g0.a.s0.k.e.c());
        this.f45784a.a(new d.b.g0.a.s0.k.e.d());
        this.f45784a.a(new e());
        this.f45784a.a(new f());
        this.f45784a.a(new g());
        this.f45784a.a(new h());
        this.f45784a.a(new d.b.g0.a.s0.k.e.j());
        this.f45784a.a(new d.b.g0.a.s0.k.e.k());
        this.f45784a.a(new l());
        this.f45784a.a(new m());
        this.f45784a.a(new o());
        this.f45784a.a(new p());
        this.f45784a.a(new s());
        this.f45784a.a(new t());
        this.f45784a.a(new n());
        this.f45784a.a(new i());
        this.f45784a.a(new r());
    }

    @Override // d.b.g0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (w(command)) {
            if (i) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    public final boolean w(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, d.b.g0.a.s0.k.e.k.f45888b)) {
            if (i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int a2 = ((d.b.g0.a.s0.k.g.a) this.f45786c).a();
        if (i && a2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.b.g0.a.s0.k.g.a) this.f45786c).a() + " command=> " + str);
        }
        return a2 == 2;
    }
}
