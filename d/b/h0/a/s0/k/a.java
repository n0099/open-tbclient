package d.b.h0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.b.h0.a.k;
import d.b.h0.a.s0.k.e.e;
import d.b.h0.a.s0.k.e.f;
import d.b.h0.a.s0.k.e.g;
import d.b.h0.a.s0.k.e.h;
import d.b.h0.a.s0.k.e.i;
import d.b.h0.a.s0.k.e.l;
import d.b.h0.a.s0.k.e.m;
import d.b.h0.a.s0.k.e.n;
import d.b.h0.a.s0.k.e.o;
import d.b.h0.a.s0.k.e.p;
import d.b.h0.a.s0.k.e.r;
import d.b.h0.a.s0.k.e.s;
import d.b.h0.a.s0.k.e.t;
import d.b.h0.a.s0.k.g.a;
import d.b.h0.a.t.c.m.j;
/* loaded from: classes2.dex */
public final class a extends d.b.h0.a.s0.b<d.b.h0.a.s0.k.g.a> {
    public static final boolean i = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0825a f46604h;

    /* renamed from: d.b.h0.a.s0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0823a implements a.InterfaceC0825a {
        public C0823a() {
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void a(int i) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void b(String str) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void c(int i) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void d(@NonNull String str) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void e(String str) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onPlayed", null);
            }
            j.c().h(str, true);
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void f() {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onEnded() {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onError(int i) {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onError", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onPrepared() {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onRelease(String str) {
            j.c().l(str);
        }
    }

    public a(@NonNull d.b.h0.a.s0.k.g.a aVar) {
        super(aVar);
        C0823a c0823a = new C0823a();
        this.f46604h = c0823a;
        aVar.a0(c0823a);
        j.c().b(aVar);
        this.f46506a.a(new d.b.h0.a.s0.k.e.a());
        this.f46506a.a(new d.b.h0.a.s0.k.e.b());
        this.f46506a.a(new d.b.h0.a.s0.k.e.c());
        this.f46506a.a(new d.b.h0.a.s0.k.e.d());
        this.f46506a.a(new e());
        this.f46506a.a(new f());
        this.f46506a.a(new g());
        this.f46506a.a(new h());
        this.f46506a.a(new d.b.h0.a.s0.k.e.j());
        this.f46506a.a(new d.b.h0.a.s0.k.e.k());
        this.f46506a.a(new l());
        this.f46506a.a(new m());
        this.f46506a.a(new o());
        this.f46506a.a(new p());
        this.f46506a.a(new s());
        this.f46506a.a(new t());
        this.f46506a.a(new n());
        this.f46506a.a(new i());
        this.f46506a.a(new r());
    }

    @Override // d.b.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
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
        if (command != null && TextUtils.equals(command.what, d.b.h0.a.s0.k.e.k.f46610b)) {
            if (i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int a2 = ((d.b.h0.a.s0.k.g.a) this.f46508c).a();
        if (i && a2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.b.h0.a.s0.k.g.a) this.f46508c).a() + " command=> " + str);
        }
        return a2 == 2;
    }
}
