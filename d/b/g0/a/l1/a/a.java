package d.b.g0.a.l1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.b.g0.a.e0.n.b;
import d.b.g0.a.e0.p.j;
import d.b.g0.a.i2.e0;
import d.b.g0.a.u0.d;
import d.b.g0.l.h.c;
import d.b.g0.l.k.h;
import d.b.g0.l.r.f;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends j {

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f45562g;

    /* renamed from: h  reason: collision with root package name */
    public String f45563h;
    public String i;
    public c<h> j = new C0739a();

    /* renamed from: d.b.g0.a.l1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0739a extends d.b.g0.l.h.b<h> {
        public C0739a() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return a.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(h hVar) {
            return d.e.g().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(h hVar, d.b.g0.l.k.a aVar) {
            super.l(hVar, aVar);
            if (aVar != null) {
                d.b.g0.a.l1.d.a.a("plugin download error: " + aVar.toString());
            }
            a.this.f45562g.a(Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(h hVar) {
            super.b(hVar);
            if (hVar == null) {
                d.b.g0.a.l1.d.a.a("download finish, plugin is null");
                a.this.f45562g.a(Boolean.FALSE);
            } else if (!e0.a(new File(hVar.f49309a), hVar.m)) {
                d.b.g0.a.l1.d.a.a("download finish, check zip sign failure");
                a.this.f45562g.a(Boolean.FALSE);
            } else {
                File l = d.l(hVar.f49315g, String.valueOf(d.b.g0.a.b2.b.h(hVar.j)));
                d.b.g0.p.d.h(l);
                if (l != null && l.exists()) {
                    boolean F = d.b.g0.p.d.F(hVar.f49309a, l.getAbsolutePath());
                    hVar.f49311c = hVar.b();
                    hVar.f49312d = hVar.b();
                    d.b.g0.l.i.a.h().l(hVar);
                    d.b.g0.p.d.g(hVar.f49309a);
                    d.b.g0.a.l1.d.a.a("download finish, unZipSuccess = " + F);
                    a.this.f45562g.a(Boolean.valueOf(F));
                    return;
                }
                d.b.g0.a.l1.d.a.a("download finish, create file failure, name = " + hVar.f49315g + " ; version = " + hVar.i);
                a.this.f45562g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(h hVar) {
            super.i(hVar);
            if (hVar != null) {
                d.b.g0.a.l1.d.a.a("plugin download start: bundleId = " + hVar.f49315g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(h hVar) {
            super.n(hVar);
        }
    }

    public a(String str, String str2, b<Boolean> bVar) {
        this.f45562g = bVar;
        this.f45563h = str;
        this.i = str2;
    }

    @Override // d.b.g0.l.h.g
    public void B(d.b.g0.l.k.a aVar) {
        h p;
        super.B(aVar);
        if (aVar != null) {
            if (aVar.f49306a == 1010 && (p = d.b.g0.l.i.a.h().p(this.f45563h, this.i)) != null) {
                p.f49312d = p.b();
                d.b.g0.l.i.a.h().t(p);
            }
            d.b.g0.a.l1.d.a.a("fetch plugin error: " + aVar.toString());
        } else {
            d.b.g0.a.l1.d.a.a("fetch plugin error");
        }
        this.f45562g.a(Boolean.FALSE);
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        super.D();
        d.b.g0.a.l1.d.a.a("fetch plugin success");
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.l1.d.a.a("no package");
        this.f45562g.a(Boolean.FALSE);
    }

    @Override // d.b.g0.l.h.g
    public void F(f fVar) {
        super.F(fVar);
    }

    @Override // d.b.g0.l.h.g
    public c<h> w() {
        return this.j;
    }
}
