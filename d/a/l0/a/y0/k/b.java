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
    public static final boolean f45878i = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0920a f45879h;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0920a {
        public a() {
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void a(int i2) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onStateChange", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void b(int i2) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onInfo", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void c(String str) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onPaused", null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.l0.a.u.e.o.k.e().k(str, false);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void d(@NonNull String str) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onNetStatus", str);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void e(String str) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onPlayed", null);
            }
            d.a.l0.a.u.e.o.k.e().k(str, true);
            d.a.l0.a.u.e.o.k.e().j(str);
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void f() {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onVideoSizeChanged", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onEnded() {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onEnded", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onError(int i2) {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onError", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onPrepared() {
            if (b.this.f45774b != null) {
                b.this.f45774b.onCallback(b.this, "onPrepared", null);
            }
        }

        @Override // d.a.l0.a.y0.k.g.a.InterfaceC0920a
        public void onRelease(String str) {
            if (b.f45878i) {
                Log.i("InlineVideoController", "onRelease: " + str);
            }
            d.a.l0.a.u.e.o.k.e().p(str);
        }
    }

    public b(@NonNull d.a.l0.a.y0.k.g.a aVar) {
        super(aVar);
        a aVar2 = new a();
        this.f45879h = aVar2;
        aVar.l0(aVar2);
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
        this.f45773a.a(new s());
        this.f45773a.a(new u());
        this.f45773a.a(new v());
        this.f45773a.a(new p());
        this.f45773a.a(new d.a.l0.a.y0.k.e.k());
        this.f45773a.a(new t());
    }
}
