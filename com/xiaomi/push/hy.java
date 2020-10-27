package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class hy implements ix<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f485a;

    /* renamed from: a  reason: collision with other field name */
    public hz f486a;

    /* renamed from: a  reason: collision with other field name */
    public ib f487a;

    /* renamed from: a  reason: collision with other field name */
    public String f488a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f489a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f490a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f491b;

    /* renamed from: b  reason: collision with other field name */
    public String f492b;

    /* renamed from: c  reason: collision with other field name */
    public long f493c;

    /* renamed from: c  reason: collision with other field name */
    public String f494c;

    /* renamed from: d  reason: collision with other field name */
    public String f495d;

    /* renamed from: e  reason: collision with other field name */
    public String f496e;

    /* renamed from: f  reason: collision with other field name */
    public String f497f;

    /* renamed from: g  reason: collision with other field name */
    public String f498g;

    /* renamed from: h  reason: collision with other field name */
    public String f499h;

    /* renamed from: i  reason: collision with other field name */
    public String f500i;

    /* renamed from: j  reason: collision with other field name */
    public String f501j;

    /* renamed from: k  reason: collision with other field name */
    public String f502k;

    /* renamed from: l  reason: collision with other field name */
    public String f503l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f484a = new jn("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4965a = new jf("", (byte) 12, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", (byte) 10, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);
    private static final jf l = new jf("", (byte) 12, 12);
    private static final jf m = new jf("", Constants.GZIP_CAST_TYPE, 13);
    private static final jf n = new jf("", (byte) 2, 14);
    private static final jf o = new jf("", Constants.GZIP_CAST_TYPE, 15);
    private static final jf p = new jf("", (byte) 10, 16);
    private static final jf q = new jf("", Constants.GZIP_CAST_TYPE, 20);
    private static final jf r = new jf("", Constants.GZIP_CAST_TYPE, 21);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m371a()).compareTo(Boolean.valueOf(hyVar.m371a()));
            if (compareTo == 0) {
                if (!m371a() || (a19 = iy.a(this.f487a, hyVar.f487a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m373b()).compareTo(Boolean.valueOf(hyVar.m373b()));
                    if (compareTo2 == 0) {
                        if (!m373b() || (a18 = iy.a(this.f488a, hyVar.f488a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m374c()).compareTo(Boolean.valueOf(hyVar.m374c()));
                            if (compareTo3 == 0) {
                                if (!m374c() || (a17 = iy.a(this.f492b, hyVar.f492b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f494c, hyVar.f494c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f485a, hyVar.f485a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f491b, hyVar.f491b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f495d, hyVar.f495d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f496e, hyVar.f496e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f497f, hyVar.f497f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f498g, hyVar.f498g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hyVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f499h, hyVar.f499h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hyVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f486a, hyVar.f486a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hyVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f500i, hyVar.f500i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hyVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f490a, hyVar.f490a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hyVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f501j, hyVar.f501j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hyVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f493c, hyVar.f493c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hyVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f502k, hyVar.f502k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hyVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f503l, hyVar.f503l)) == 0) {
                                                                                                                                                            return 0;
                                                                                                                                                        }
                                                                                                                                                        return a2;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a3;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a4;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a5;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a6;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a7;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a8;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a9;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a10;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a11;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a12;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a13;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a14;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a15;
                                            }
                                            return compareTo5;
                                        }
                                        return a16;
                                    }
                                    return compareTo4;
                                }
                                return a17;
                            }
                            return compareTo3;
                        }
                        return a18;
                    }
                    return compareTo2;
                }
                return a19;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public long a() {
        return this.f485a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m369a() {
        return this.f488a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m370a() {
        if (this.f488a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f492b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f494c == null) {
            throw new jj("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m370a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f487a = new ib();
                        this.f487a.a(jiVar);
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f488a = jiVar.m490a();
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f492b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f494c = jiVar.m490a();
                        break;
                    }
                case 5:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f485a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f491b = jiVar.m484a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f495d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f496e = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f497f = jiVar.m490a();
                        break;
                    }
                case 10:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f498g = jiVar.m490a();
                        break;
                    }
                case 11:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f499h = jiVar.m490a();
                        break;
                    }
                case 12:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f486a = new hz();
                        this.f486a.a(jiVar);
                        break;
                    }
                case 13:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f500i = jiVar.m490a();
                        break;
                    }
                case 14:
                    if (m485a.f4998a != 2) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f490a = jiVar.m494a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f501j = jiVar.m490a();
                        break;
                    }
                case 16:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f493c = jiVar.m484a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 20:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f502k = jiVar.m490a();
                        break;
                    }
                case 21:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f503l = jiVar.m490a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f489a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m371a() {
        return this.f487a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m372a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m371a = m371a();
        boolean m371a2 = hyVar.m371a();
        if ((m371a || m371a2) && !(m371a && m371a2 && this.f487a.m398a(hyVar.f487a))) {
            return false;
        }
        boolean m373b = m373b();
        boolean m373b2 = hyVar.m373b();
        if ((m373b || m373b2) && !(m373b && m373b2 && this.f488a.equals(hyVar.f488a))) {
            return false;
        }
        boolean m374c = m374c();
        boolean m374c2 = hyVar.m374c();
        if ((m374c || m374c2) && !(m374c && m374c2 && this.f492b.equals(hyVar.f492b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f494c.equals(hyVar.f494c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f485a == hyVar.f485a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f491b == hyVar.f491b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f495d.equals(hyVar.f495d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f496e.equals(hyVar.f496e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f497f.equals(hyVar.f497f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f498g.equals(hyVar.f498g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hyVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f499h.equals(hyVar.f499h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hyVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f486a.m381a(hyVar.f486a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hyVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f500i.equals(hyVar.f500i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hyVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f490a == hyVar.f490a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hyVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f501j.equals(hyVar.f501j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hyVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f493c == hyVar.f493c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hyVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f502k.equals(hyVar.f502k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hyVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f503l.equals(hyVar.f503l));
    }

    public String b() {
        return this.f492b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m370a();
        jiVar.a(f484a);
        if (this.f487a != null && m371a()) {
            jiVar.a(f4965a);
            this.f487a.b(jiVar);
            jiVar.b();
        }
        if (this.f488a != null) {
            jiVar.a(b);
            jiVar.a(this.f488a);
            jiVar.b();
        }
        if (this.f492b != null) {
            jiVar.a(c);
            jiVar.a(this.f492b);
            jiVar.b();
        }
        if (this.f494c != null) {
            jiVar.a(d);
            jiVar.a(this.f494c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f485a);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f491b);
            jiVar.b();
        }
        if (this.f495d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f495d);
            jiVar.b();
        }
        if (this.f496e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f496e);
            jiVar.b();
        }
        if (this.f497f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f497f);
            jiVar.b();
        }
        if (this.f498g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f498g);
            jiVar.b();
        }
        if (this.f499h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f499h);
            jiVar.b();
        }
        if (this.f486a != null && l()) {
            jiVar.a(l);
            this.f486a.b(jiVar);
            jiVar.b();
        }
        if (this.f500i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f500i);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f490a);
            jiVar.b();
        }
        if (this.f501j != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f501j);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f493c);
            jiVar.b();
        }
        if (this.f502k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f502k);
            jiVar.b();
        }
        if (this.f503l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f503l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f489a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m373b() {
        return this.f488a != null;
    }

    public String c() {
        return this.f494c;
    }

    public void c(boolean z) {
        this.f489a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m374c() {
        return this.f492b != null;
    }

    public void d(boolean z) {
        this.f489a.set(3, z);
    }

    public boolean d() {
        return this.f494c != null;
    }

    public boolean e() {
        return this.f489a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m372a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f489a.get(1);
    }

    public boolean g() {
        return this.f495d != null;
    }

    public boolean h() {
        return this.f496e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f497f != null;
    }

    public boolean j() {
        return this.f498g != null;
    }

    public boolean k() {
        return this.f499h != null;
    }

    public boolean l() {
        return this.f486a != null;
    }

    public boolean m() {
        return this.f500i != null;
    }

    public boolean n() {
        return this.f489a.get(2);
    }

    public boolean o() {
        return this.f501j != null;
    }

    public boolean p() {
        return this.f489a.get(3);
    }

    public boolean q() {
        return this.f502k != null;
    }

    public boolean r() {
        return this.f503l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m371a()) {
            sb.append("to:");
            if (this.f487a == null) {
                sb.append("null");
            } else {
                sb.append(this.f487a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f488a == null) {
            sb.append("null");
        } else {
            sb.append(this.f488a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f492b == null) {
            sb.append("null");
        } else {
            sb.append(this.f492b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f494c == null) {
            sb.append("null");
        } else {
            sb.append(this.f494c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f485a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f491b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f495d == null) {
                sb.append("null");
            } else {
                sb.append(this.f495d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f496e == null) {
                sb.append("null");
            } else {
                sb.append(this.f496e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f497f == null) {
                sb.append("null");
            } else {
                sb.append(this.f497f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f498g == null) {
                sb.append("null");
            } else {
                sb.append(this.f498g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f499h == null) {
                sb.append("null");
            } else {
                sb.append(this.f499h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f486a == null) {
                sb.append("null");
            } else {
                sb.append(this.f486a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f500i == null) {
                sb.append("null");
            } else {
                sb.append(this.f500i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f490a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f501j == null) {
                sb.append("null");
            } else {
                sb.append(this.f501j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f493c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f502k == null) {
                sb.append("null");
            } else {
                sb.append(this.f502k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f503l == null) {
                sb.append("null");
            } else {
                sb.append(this.f503l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
