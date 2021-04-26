package d.a.h0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.h0.a.k;
import d.a.h0.a.s0.k.e.e;
import d.a.h0.a.s0.k.e.f;
import d.a.h0.a.s0.k.e.g;
import d.a.h0.a.s0.k.e.h;
import d.a.h0.a.s0.k.e.i;
import d.a.h0.a.s0.k.e.l;
import d.a.h0.a.s0.k.e.m;
import d.a.h0.a.s0.k.e.n;
import d.a.h0.a.s0.k.e.o;
import d.a.h0.a.s0.k.e.p;
import d.a.h0.a.s0.k.e.r;
import d.a.h0.a.s0.k.e.s;
import d.a.h0.a.s0.k.e.t;
import d.a.h0.a.s0.k.g.a;
import d.a.h0.a.t.c.m.j;
/* loaded from: classes2.dex */
public final class a extends d.a.h0.a.s0.b<d.a.h0.a.s0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f43973i = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0764a f43974h;

    /* renamed from: d.a.h0.a.s0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0762a implements a.InterfaceC0764a {
        public C0762a() {
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void a(int i2) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void b(int i2) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void c(String str) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void d(@NonNull String str) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onNetStatus", str);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void e(String str) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onPlayed", null);
            }
            j.c().h(str, true);
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void f() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onEnded() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onEnded", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onError(int i2) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onPrepared() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onPrepared", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onRelease(String str) {
            j.c().l(str);
        }
    }

    public a(@NonNull d.a.h0.a.s0.k.g.a aVar) {
        super(aVar);
        C0762a c0762a = new C0762a();
        this.f43974h = c0762a;
        aVar.c0(c0762a);
        j.c().b(aVar);
        this.f43871a.a(new d.a.h0.a.s0.k.e.a());
        this.f43871a.a(new d.a.h0.a.s0.k.e.b());
        this.f43871a.a(new d.a.h0.a.s0.k.e.c());
        this.f43871a.a(new d.a.h0.a.s0.k.e.d());
        this.f43871a.a(new e());
        this.f43871a.a(new f());
        this.f43871a.a(new g());
        this.f43871a.a(new h());
        this.f43871a.a(new d.a.h0.a.s0.k.e.j());
        this.f43871a.a(new d.a.h0.a.s0.k.e.k());
        this.f43871a.a(new l());
        this.f43871a.a(new m());
        this.f43871a.a(new o());
        this.f43871a.a(new p());
        this.f43871a.a(new s());
        this.f43871a.a(new t());
        this.f43871a.a(new n());
        this.f43871a.a(new i());
        this.f43871a.a(new r());
    }

    @Override // d.a.h0.a.s0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (w(command)) {
            if (f43973i) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    public final boolean w(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, d.a.h0.a.s0.k.e.k.f43981b)) {
            if (f43973i) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
            }
            return false;
        }
        int c2 = ((d.a.h0.a.s0.k.g.a) this.f43873c).c();
        if (f43973i && c2 != 1) {
            String str = command == null ? "" : command.what;
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.a.h0.a.s0.k.g.a) this.f43873c).c() + " command=> " + str);
        }
        return c2 == 2;
    }
}
