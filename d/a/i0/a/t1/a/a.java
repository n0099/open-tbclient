package d.a.i0.a.t1.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import d.a.i0.a.a1.e;
import d.a.i0.a.h0.j.b;
import d.a.i0.a.h0.m.j;
import d.a.i0.a.v2.j0;
import d.a.i0.n.f.c;
import d.a.i0.n.h.h;
import d.a.i0.n.o.f;
import d.a.i0.t.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {

    /* renamed from: g  reason: collision with root package name */
    public b<Boolean> f44559g;

    /* renamed from: h  reason: collision with root package name */
    public String f44560h;

    /* renamed from: i  reason: collision with root package name */
    public String f44561i;
    public long j;
    public c<h> k = new C0813a();

    /* renamed from: d.a.i0.a.t1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0813a extends d.a.i0.n.f.b<h> {
        public C0813a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            return e.C0550e.h().getAbsolutePath();
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(h hVar, d.a.i0.n.h.a aVar) {
            super.e(hVar, aVar);
            if (aVar != null) {
                d.a.i0.a.t1.d.a.a("plugin download error: " + aVar.toString());
            }
            a.this.f44559g.a(Boolean.FALSE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            super.i(hVar);
            if (hVar == null) {
                d.a.i0.a.t1.d.a.a("download finish, plugin is null");
                a.this.f44559g.a(Boolean.FALSE);
            } else if (!j0.a(new File(hVar.f47830a), hVar.m)) {
                d.a.i0.a.t1.d.a.a("download finish, check zip sign failure");
                a.this.f44559g.a(Boolean.FALSE);
            } else {
                File t = e.t(hVar.f47836g, String.valueOf(hVar.f47838i));
                d.k(t);
                if (t != null && t.exists()) {
                    boolean T = d.T(hVar.f47830a, t.getAbsolutePath());
                    hVar.f47832c = hVar.b();
                    hVar.f47833d = hVar.b();
                    d.a.i0.n.g.a.h().l(hVar);
                    d.j(hVar.f47830a);
                    d.a.i0.a.t1.d.a.a("download finish, unZipSuccess = " + T);
                    a.this.f44559g.a(Boolean.valueOf(T));
                    return;
                }
                d.a.i0.a.t1.d.a.a("download finish, create file failure, name = " + hVar.f47836g + " ; version = " + hVar.f47838i);
                a.this.f44559g.a(Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            super.c(hVar);
            if (hVar != null) {
                d.a.i0.a.t1.d.a.a("plugin download start: bundleId = " + hVar.f47836g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            super.f(hVar);
        }
    }

    public a(String str, String str2, long j, b<Boolean> bVar) {
        this.f44559g = bVar;
        this.f44560h = str;
        this.f44561i = str2;
        this.j = j;
    }

    @Override // d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        h i2;
        super.B(aVar);
        if (aVar != null) {
            if (aVar.f47826a == 1010 && (i2 = d.a.i0.a.t1.b.a.i(this.f44560h, this.f44561i, this.j)) != null) {
                i2.f47833d = i2.b();
                d.a.i0.n.g.a.h().v(i2);
            }
            d.a.i0.a.t1.d.a.a("fetch plugin error: " + aVar.toString());
        } else {
            d.a.i0.a.t1.d.a.a("fetch plugin error");
        }
        this.f44559g.a(Boolean.FALSE);
    }

    @Override // d.a.i0.n.f.g
    public void D() {
        super.D();
        d.a.i0.a.t1.d.a.a("fetch plugin success");
    }

    @Override // d.a.i0.n.f.g
    public void E() {
        super.E();
        d.a.i0.a.t1.d.a.a("no package");
        this.f44559g.a(Boolean.FALSE);
    }

    @Override // d.a.i0.n.f.g
    public void F(f fVar) {
        super.F(fVar);
    }

    @Override // d.a.i0.n.f.g
    public c<h> w() {
        return this.k;
    }
}
