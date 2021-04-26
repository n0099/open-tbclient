package d.a.h0.a.l1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.h0.a.e0.n.b;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import d.a.h0.a.u0.d;
import d.a.h0.l.h.c;
import d.a.h0.l.k.h;
import d.a.h0.l.r.f;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f43225g;

    /* renamed from: h  reason: collision with root package name */
    public String f43226h;

    /* renamed from: i  reason: collision with root package name */
    public String f43227i;
    public c<h> j = new C0698a();

    /* renamed from: d.a.h0.a.l1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0698a extends d.a.h0.l.h.b<h> {
        public C0698a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(h hVar) {
            return d.e.g().getAbsolutePath();
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(h hVar, d.a.h0.l.k.a aVar) {
            super.f(hVar, aVar);
            if (aVar != null) {
                d.a.h0.a.l1.d.a.a("plugin download error: " + aVar.toString());
            }
            a.this.f43225g.a(Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(h hVar) {
            super.i(hVar);
            if (hVar == null) {
                d.a.h0.a.l1.d.a.a("download finish, plugin is null");
                a.this.f43225g.a(Boolean.FALSE);
            } else if (!e0.a(new File(hVar.f47147a), hVar.m)) {
                d.a.h0.a.l1.d.a.a("download finish, check zip sign failure");
                a.this.f43225g.a(Boolean.FALSE);
            } else {
                File l = d.l(hVar.f47153g, String.valueOf(d.a.h0.a.b2.b.h(hVar.j)));
                d.a.h0.p.d.h(l);
                if (l != null && l.exists()) {
                    boolean F = d.a.h0.p.d.F(hVar.f47147a, l.getAbsolutePath());
                    hVar.f47149c = hVar.b();
                    hVar.f47150d = hVar.b();
                    d.a.h0.l.i.a.h().l(hVar);
                    d.a.h0.p.d.g(hVar.f47147a);
                    d.a.h0.a.l1.d.a.a("download finish, unZipSuccess = " + F);
                    a.this.f43225g.a(Boolean.valueOf(F));
                    return;
                }
                d.a.h0.a.l1.d.a.a("download finish, create file failure, name = " + hVar.f47153g + " ; version = " + hVar.f47155i);
                a.this.f43225g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(h hVar) {
            super.d(hVar);
            if (hVar != null) {
                d.a.h0.a.l1.d.a.a("plugin download start: bundleId = " + hVar.f47153g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(h hVar) {
            super.g(hVar);
        }
    }

    public a(String str, String str2, b<Boolean> bVar) {
        this.f43225g = bVar;
        this.f43226h = str;
        this.f43227i = str2;
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        h p;
        super.B(aVar);
        if (aVar != null) {
            if (aVar.f47144a == 1010 && (p = d.a.h0.l.i.a.h().p(this.f43226h, this.f43227i)) != null) {
                p.f47150d = p.b();
                d.a.h0.l.i.a.h().t(p);
            }
            d.a.h0.a.l1.d.a.a("fetch plugin error: " + aVar.toString());
        } else {
            d.a.h0.a.l1.d.a.a("fetch plugin error");
        }
        this.f43225g.a(Boolean.FALSE);
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        super.D();
        d.a.h0.a.l1.d.a.a("fetch plugin success");
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        d.a.h0.a.l1.d.a.a("no package");
        this.f43225g.a(Boolean.FALSE);
    }

    @Override // d.a.h0.l.h.g
    public void F(f fVar) {
        super.F(fVar);
    }

    @Override // d.a.h0.l.h.g
    public c<h> w() {
        return this.j;
    }
}
