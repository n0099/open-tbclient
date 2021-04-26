package d.a.h0.a.s0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
import d.a.h0.a.s0.k.e.q;
import d.a.h0.a.s0.k.e.r;
import d.a.h0.a.s0.k.e.s;
import d.a.h0.a.s0.k.e.t;
import d.a.h0.a.s0.k.g.a;
import d.a.h0.a.t.c.m.j;
/* loaded from: classes2.dex */
public final class b extends d.a.h0.a.s0.b<d.a.h0.a.s0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f43976i = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0764a f43977h;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0764a {
        public a() {
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void a(int i2) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void b(int i2) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void c(String str) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j.c().h(str, false);
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void d(@NonNull String str) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void e(String str) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onPlayed", null);
            }
            j.c().h(str, true);
            j.c().g(str);
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void f() {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onEnded() {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onError(int i2) {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onPrepared() {
            if (b.this.f43872b != null) {
                b.this.f43872b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.a.h0.a.s0.k.g.a.InterfaceC0764a
        public void onRelease(String str) {
            if (b.f43976i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            j.c().l(str);
        }
    }

    public b(@NonNull d.a.h0.a.s0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f43977h = aVar2;
        aVar.c0(aVar2);
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
        this.f43871a.a(new q());
        this.f43871a.a(new s());
        this.f43871a.a(new t());
        this.f43871a.a(new n());
        this.f43871a.a(new i());
        this.f43871a.a(new r());
    }
}
