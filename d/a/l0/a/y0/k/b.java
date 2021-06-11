package d.a.l0.a.y0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
import d.a.l0.a.y0.k.e.s;
import d.a.l0.a.y0.k.e.t;
import d.a.l0.a.y0.k.e.u;
import d.a.l0.a.y0.k.e.v;
import d.a.l0.a.y0.k.g.a;
/* loaded from: classes3.dex */
public final class b extends d.a.l0.a.y0.b<d.a.l0.a.y0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49552i = k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0976a f49553h;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0976a {
        public a() {
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void a(int i2) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void b(int i2) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void c(String str) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.l0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void d(@NonNull String str) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void e(String str) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onPlayed", null);
            }
            d.a.l0.a.u.e.o.k.e().k(str, true);
            d.a.l0.a.u.e.o.k.e().j(str);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void f() {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onEnded() {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onError(int i2) {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onPrepared() {
            if (b.this.f49448b != null) {
                b.this.f49448b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0976a
        public void onRelease(String str) {
            if (b.f49552i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            d.a.l0.a.u.e.o.k.e().p(str);
        }
    }

    public b(@NonNull d.a.l0.a.y0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f49553h = aVar2;
        aVar.i0(aVar2);
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
        this.f49447a.a(new s());
        this.f49447a.a(new u());
        this.f49447a.a(new v());
        this.f49447a.a(new p());
        this.f49447a.a(new d.a.l0.a.y0.k.e.k());
        this.f49447a.a(new t());
    }
}
