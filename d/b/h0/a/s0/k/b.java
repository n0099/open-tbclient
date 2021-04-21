package d.b.h0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
import d.b.h0.a.s0.k.e.q;
import d.b.h0.a.s0.k.e.r;
import d.b.h0.a.s0.k.e.s;
import d.b.h0.a.s0.k.e.t;
import d.b.h0.a.s0.k.g.a;
import d.b.h0.a.t.c.m.j;
/* loaded from: classes2.dex */
public final class b extends d.b.h0.a.s0.b<d.b.h0.a.s0.k.g.a> {
    public static final boolean i = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0825a f46606h;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0825a {
        public a() {
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void a(int i) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void b(String str) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void c(int i) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void d(@NonNull String str) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void e(String str) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onPlayed", null);
            }
            j.c().h(str, true);
            j.c().g(str);
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void f() {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onEnded() {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onError(int i) {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onError", Integer.valueOf(i));
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onPrepared() {
            if (b.this.f46507b != null) {
                b.this.f46507b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.b.h0.a.s0.k.g.a.InterfaceC0825a
        public void onRelease(String str) {
            if (b.i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            j.c().l(str);
        }
    }

    public b(@NonNull d.b.h0.a.s0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f46606h = aVar2;
        aVar.a0(aVar2);
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
        this.f46506a.a(new q());
        this.f46506a.a(new s());
        this.f46506a.a(new t());
        this.f46506a.a(new n());
        this.f46506a.a(new i());
        this.f46506a.a(new r());
    }
}
