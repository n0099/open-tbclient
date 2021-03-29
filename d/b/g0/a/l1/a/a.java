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
    public b<Boolean> f45170g;

    /* renamed from: h  reason: collision with root package name */
    public String f45171h;
    public String i;
    public c<h> j = new C0727a();

    /* renamed from: d.b.g0.a.l1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0727a extends d.b.g0.l.h.b<h> {
        public C0727a() {
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
        /* renamed from: n */
        public void l(h hVar, d.b.g0.l.k.a aVar) {
            super.l(hVar, aVar);
            if (aVar != null) {
                d.b.g0.a.l1.d.a.a("plugin download error: " + aVar.toString());
            }
            a.this.f45170g.a(Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(h hVar) {
            super.b(hVar);
            if (hVar == null) {
                d.b.g0.a.l1.d.a.a("download finish, plugin is null");
                a.this.f45170g.a(Boolean.FALSE);
            } else if (!e0.a(new File(hVar.f48917a), hVar.m)) {
                d.b.g0.a.l1.d.a.a("download finish, check zip sign failure");
                a.this.f45170g.a(Boolean.FALSE);
            } else {
                File l = d.l(hVar.f48923g, String.valueOf(d.b.g0.a.b2.b.h(hVar.j)));
                d.b.g0.p.d.h(l);
                if (l != null && l.exists()) {
                    boolean F = d.b.g0.p.d.F(hVar.f48917a, l.getAbsolutePath());
                    hVar.f48919c = hVar.b();
                    hVar.f48920d = hVar.b();
                    d.b.g0.l.i.a.h().l(hVar);
                    d.b.g0.p.d.g(hVar.f48917a);
                    d.b.g0.a.l1.d.a.a("download finish, unZipSuccess = " + F);
                    a.this.f45170g.a(Boolean.valueOf(F));
                    return;
                }
                d.b.g0.a.l1.d.a.a("download finish, create file failure, name = " + hVar.f48923g + " ; version = " + hVar.i);
                a.this.f45170g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(h hVar) {
            super.i(hVar);
            if (hVar != null) {
                d.b.g0.a.l1.d.a.a("plugin download start: bundleId = " + hVar.f48923g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void o(h hVar) {
            super.o(hVar);
        }
    }

    public a(String str, String str2, b<Boolean> bVar) {
        this.f45170g = bVar;
        this.f45171h = str;
        this.i = str2;
    }

    @Override // d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        h p;
        super.C(aVar);
        if (aVar != null) {
            if (aVar.f48914a == 1010 && (p = d.b.g0.l.i.a.h().p(this.f45171h, this.i)) != null) {
                p.f48920d = p.b();
                d.b.g0.l.i.a.h().t(p);
            }
            d.b.g0.a.l1.d.a.a("fetch plugin error: " + aVar.toString());
        } else {
            d.b.g0.a.l1.d.a.a("fetch plugin error");
        }
        this.f45170g.a(Boolean.FALSE);
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.l1.d.a.a("fetch plugin success");
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        d.b.g0.a.l1.d.a.a("no package");
        this.f45170g.a(Boolean.FALSE);
    }

    @Override // d.b.g0.l.h.g
    public void G(f fVar) {
        super.G(fVar);
    }

    @Override // d.b.g0.l.h.g
    public c<h> x() {
        return this.j;
    }
}
