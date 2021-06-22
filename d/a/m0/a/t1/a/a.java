package d.a.m0.a.t1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.m0.a.a1.e;
import d.a.m0.a.h0.j.b;
import d.a.m0.a.h0.m.j;
import d.a.m0.a.v2.j0;
import d.a.m0.n.f.c;
import d.a.m0.n.h.h;
import d.a.m0.n.o.f;
import d.a.m0.t.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f48517g;

    /* renamed from: h  reason: collision with root package name */
    public String f48518h;

    /* renamed from: i  reason: collision with root package name */
    public String f48519i;
    public long j;
    public c<h> k = new C0883a();

    /* renamed from: d.a.m0.a.t1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0883a extends d.a.m0.n.f.b<h> {
        public C0883a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            return e.C0620e.h().getAbsolutePath();
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(h hVar, d.a.m0.n.h.a aVar) {
            super.e(hVar, aVar);
            if (aVar != null) {
                d.a.m0.a.t1.d.a.a("plugin download error: " + aVar.toString());
            }
            a.this.f48517g.a(Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            super.i(hVar);
            if (hVar == null) {
                d.a.m0.a.t1.d.a.a("download finish, plugin is null");
                a.this.f48517g.a(Boolean.FALSE);
            } else if (!j0.a(new File(hVar.f51788a), hVar.m)) {
                d.a.m0.a.t1.d.a.a("download finish, check zip sign failure");
                a.this.f48517g.a(Boolean.FALSE);
            } else {
                File t = e.t(hVar.f51794g, String.valueOf(hVar.f51796i));
                d.k(t);
                if (t != null && t.exists()) {
                    boolean T = d.T(hVar.f51788a, t.getAbsolutePath());
                    hVar.f51790c = hVar.b();
                    hVar.f51791d = hVar.b();
                    d.a.m0.n.g.a.h().l(hVar);
                    d.j(hVar.f51788a);
                    d.a.m0.a.t1.d.a.a("download finish, unZipSuccess = " + T);
                    a.this.f48517g.a(Boolean.valueOf(T));
                    return;
                }
                d.a.m0.a.t1.d.a.a("download finish, create file failure, name = " + hVar.f51794g + " ; version = " + hVar.f51796i);
                a.this.f48517g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            super.c(hVar);
            if (hVar != null) {
                d.a.m0.a.t1.d.a.a("plugin download start: bundleId = " + hVar.f51794g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            super.f(hVar);
        }
    }

    public a(String str, String str2, long j, b<Boolean> bVar) {
        this.f48517g = bVar;
        this.f48518h = str;
        this.f48519i = str2;
        this.j = j;
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        h i2;
        super.B(aVar);
        if (aVar != null) {
            if (aVar.f51784a == 1010 && (i2 = d.a.m0.a.t1.b.a.i(this.f48518h, this.f48519i, this.j)) != null) {
                i2.f51791d = i2.b();
                d.a.m0.n.g.a.h().v(i2);
            }
            d.a.m0.a.t1.d.a.a("fetch plugin error: " + aVar.toString());
        } else {
            d.a.m0.a.t1.d.a.a("fetch plugin error");
        }
        this.f48517g.a(Boolean.FALSE);
    }

    @Override // d.a.m0.n.f.g
    public void D() {
        super.D();
        d.a.m0.a.t1.d.a.a("fetch plugin success");
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        d.a.m0.a.t1.d.a.a("no package");
        this.f48517g.a(Boolean.FALSE);
    }

    @Override // d.a.m0.n.f.g
    public void F(f fVar) {
        super.F(fVar);
    }

    @Override // d.a.m0.n.f.g
    public c<h> w() {
        return this.k;
    }
}
