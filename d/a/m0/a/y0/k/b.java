package d.a.m0.a.y0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import d.a.m0.a.y0.k.e.e;
import d.a.m0.a.y0.k.e.f;
import d.a.m0.a.y0.k.e.g;
import d.a.m0.a.y0.k.e.h;
import d.a.m0.a.y0.k.e.i;
import d.a.m0.a.y0.k.e.j;
import d.a.m0.a.y0.k.e.l;
import d.a.m0.a.y0.k.e.m;
import d.a.m0.a.y0.k.e.n;
import d.a.m0.a.y0.k.e.o;
import d.a.m0.a.y0.k.e.p;
import d.a.m0.a.y0.k.e.q;
import d.a.m0.a.y0.k.e.r;
import d.a.m0.a.y0.k.e.s;
import d.a.m0.a.y0.k.e.t;
import d.a.m0.a.y0.k.e.u;
import d.a.m0.a.y0.k.e.v;
import d.a.m0.a.y0.k.g.a;
/* loaded from: classes3.dex */
public final class b extends d.a.m0.a.y0.b<d.a.m0.a.y0.k.g.a> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49660i = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0979a f49661h;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0979a {
        public a() {
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void a(int i2) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void b(int i2) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void c(String str) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.m0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void d(@NonNull String str) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void e(String str) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onPlayed", null);
            }
            d.a.m0.a.u.e.o.k.e().k(str, true);
            d.a.m0.a.u.e.o.k.e().j(str);
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void f() {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void onEnded() {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void onError(int i2) {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void onPrepared() {
            if (b.this.f49556b != null) {
                b.this.f49556b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.a.m0.a.y0.k.g.a.InterfaceC0979a
        public void onRelease(String str) {
            if (b.f49660i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            d.a.m0.a.u.e.o.k.e().p(str);
        }
    }

    public b(@NonNull d.a.m0.a.y0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f49661h = aVar2;
        aVar.i0(aVar2);
        this.f49555a.a(new d.a.m0.a.y0.k.e.a());
        this.f49555a.a(new d.a.m0.a.y0.k.e.b());
        this.f49555a.a(new d.a.m0.a.y0.k.e.c());
        this.f49555a.a(new f());
        this.f49555a.a(new e());
        this.f49555a.a(new d.a.m0.a.y0.k.e.d());
        this.f49555a.a(new g());
        this.f49555a.a(new h());
        this.f49555a.a(new i());
        this.f49555a.a(new j());
        this.f49555a.a(new l());
        this.f49555a.a(new m());
        this.f49555a.a(new n());
        this.f49555a.a(new o());
        this.f49555a.a(new q());
        this.f49555a.a(new r());
        this.f49555a.a(new s());
        this.f49555a.a(new u());
        this.f49555a.a(new v());
        this.f49555a.a(new p());
        this.f49555a.a(new d.a.m0.a.y0.k.e.k());
        this.f49555a.a(new t());
    }
}
