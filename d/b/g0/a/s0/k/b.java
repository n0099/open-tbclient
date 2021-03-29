package d.b.g0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
import d.b.g0.a.s0.k.e.q;
import d.b.g0.a.s0.k.e.r;
import d.b.g0.a.s0.k.e.s;
import d.b.g0.a.s0.k.e.t;
import d.b.g0.a.s0.k.g.a;
import d.b.g0.a.t.c.m.j;
/* loaded from: classes2.dex */
public final class b extends d.b.g0.a.s0.b<d.b.g0.a.s0.k.g.a> {
    public static final boolean i = k.f45051a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0793a f45885h;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0793a {
        public a() {
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void a(int i) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void b(String str) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void c(int i) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void d(@NonNull String str) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void e(String str) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onPlayed", null);
            }
            j.c().h(str, true);
            j.c().g(str);
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void f() {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void onEnded() {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void onError(int i) {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onError", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void onPrepared() {
            if (b.this.f45786b != null) {
                b.this.f45786b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.b.g0.a.s0.k.g.a.InterfaceC0793a
        public void onRelease(String str) {
            if (b.i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            j.c().l(str);
        }
    }

    public b(@NonNull d.b.g0.a.s0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f45885h = aVar2;
        aVar.a0(aVar2);
        j.c().b(aVar);
        this.f45785a.a(new d.b.g0.a.s0.k.e.a());
        this.f45785a.a(new d.b.g0.a.s0.k.e.b());
        this.f45785a.a(new d.b.g0.a.s0.k.e.c());
        this.f45785a.a(new d.b.g0.a.s0.k.e.d());
        this.f45785a.a(new e());
        this.f45785a.a(new f());
        this.f45785a.a(new g());
        this.f45785a.a(new h());
        this.f45785a.a(new d.b.g0.a.s0.k.e.j());
        this.f45785a.a(new d.b.g0.a.s0.k.e.k());
        this.f45785a.a(new l());
        this.f45785a.a(new m());
        this.f45785a.a(new o());
        this.f45785a.a(new p());
        this.f45785a.a(new q());
        this.f45785a.a(new s());
        this.f45785a.a(new t());
        this.f45785a.a(new n());
        this.f45785a.a(new i());
        this.f45785a.a(new r());
    }
}
