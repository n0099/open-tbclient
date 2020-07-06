package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hy implements ix<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f493a;

    /* renamed from: a  reason: collision with other field name */
    public hz f494a;

    /* renamed from: a  reason: collision with other field name */
    public ib f495a;

    /* renamed from: a  reason: collision with other field name */
    public String f496a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f497a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f498a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f499b;

    /* renamed from: b  reason: collision with other field name */
    public String f500b;

    /* renamed from: c  reason: collision with other field name */
    public long f501c;

    /* renamed from: c  reason: collision with other field name */
    public String f502c;

    /* renamed from: d  reason: collision with other field name */
    public String f503d;

    /* renamed from: e  reason: collision with other field name */
    public String f504e;

    /* renamed from: f  reason: collision with other field name */
    public String f505f;

    /* renamed from: g  reason: collision with other field name */
    public String f506g;

    /* renamed from: h  reason: collision with other field name */
    public String f507h;

    /* renamed from: i  reason: collision with other field name */
    public String f508i;

    /* renamed from: j  reason: collision with other field name */
    public String f509j;

    /* renamed from: k  reason: collision with other field name */
    public String f510k;

    /* renamed from: l  reason: collision with other field name */
    public String f511l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f492a = new jn("PushMessage");
    private static final jf a = new jf("", (byte) 12, 1);
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
            int compareTo = Boolean.valueOf(m365a()).compareTo(Boolean.valueOf(hyVar.m365a()));
            if (compareTo == 0) {
                if (!m365a() || (a19 = iy.a(this.f495a, hyVar.f495a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m367b()).compareTo(Boolean.valueOf(hyVar.m367b()));
                    if (compareTo2 == 0) {
                        if (!m367b() || (a18 = iy.a(this.f496a, hyVar.f496a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m368c()).compareTo(Boolean.valueOf(hyVar.m368c()));
                            if (compareTo3 == 0) {
                                if (!m368c() || (a17 = iy.a(this.f500b, hyVar.f500b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f502c, hyVar.f502c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f493a, hyVar.f493a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f499b, hyVar.f499b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f503d, hyVar.f503d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f504e, hyVar.f504e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f505f, hyVar.f505f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f506g, hyVar.f506g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hyVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f507h, hyVar.f507h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hyVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f494a, hyVar.f494a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hyVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f508i, hyVar.f508i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hyVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f498a, hyVar.f498a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hyVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f509j, hyVar.f509j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hyVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f501c, hyVar.f501c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hyVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f510k, hyVar.f510k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hyVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f511l, hyVar.f511l)) == 0) {
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
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m363a() {
        return this.f496a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m364a() {
        if (this.f496a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f500b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f502c == null) {
            throw new jj("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m364a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f495a = new ib();
                        this.f495a.a(jiVar);
                        break;
                    }
                case 2:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f496a = jiVar.m484a();
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f500b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f502c = jiVar.m484a();
                        break;
                    }
                case 5:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f493a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f499b = jiVar.m478a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f503d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f504e = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f505f = jiVar.m484a();
                        break;
                    }
                case 10:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f506g = jiVar.m484a();
                        break;
                    }
                case 11:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f507h = jiVar.m484a();
                        break;
                    }
                case 12:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f494a = new hz();
                        this.f494a.a(jiVar);
                        break;
                    }
                case 13:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f508i = jiVar.m484a();
                        break;
                    }
                case 14:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f498a = jiVar.m488a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f509j = jiVar.m484a();
                        break;
                    }
                case 16:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f501c = jiVar.m478a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 20:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f510k = jiVar.m484a();
                        break;
                    }
                case 21:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f511l = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f497a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a() {
        return this.f495a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m365a = m365a();
        boolean m365a2 = hyVar.m365a();
        if ((m365a || m365a2) && !(m365a && m365a2 && this.f495a.m392a(hyVar.f495a))) {
            return false;
        }
        boolean m367b = m367b();
        boolean m367b2 = hyVar.m367b();
        if ((m367b || m367b2) && !(m367b && m367b2 && this.f496a.equals(hyVar.f496a))) {
            return false;
        }
        boolean m368c = m368c();
        boolean m368c2 = hyVar.m368c();
        if ((m368c || m368c2) && !(m368c && m368c2 && this.f500b.equals(hyVar.f500b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f502c.equals(hyVar.f502c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f493a == hyVar.f493a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f499b == hyVar.f499b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f503d.equals(hyVar.f503d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f504e.equals(hyVar.f504e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f505f.equals(hyVar.f505f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f506g.equals(hyVar.f506g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hyVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f507h.equals(hyVar.f507h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hyVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f494a.m375a(hyVar.f494a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hyVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f508i.equals(hyVar.f508i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hyVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f498a == hyVar.f498a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hyVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f509j.equals(hyVar.f509j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hyVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f501c == hyVar.f501c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hyVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f510k.equals(hyVar.f510k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hyVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f511l.equals(hyVar.f511l));
    }

    public String b() {
        return this.f500b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m364a();
        jiVar.a(f492a);
        if (this.f495a != null && m365a()) {
            jiVar.a(a);
            this.f495a.b(jiVar);
            jiVar.b();
        }
        if (this.f496a != null) {
            jiVar.a(b);
            jiVar.a(this.f496a);
            jiVar.b();
        }
        if (this.f500b != null) {
            jiVar.a(c);
            jiVar.a(this.f500b);
            jiVar.b();
        }
        if (this.f502c != null) {
            jiVar.a(d);
            jiVar.a(this.f502c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f493a);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f499b);
            jiVar.b();
        }
        if (this.f503d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f503d);
            jiVar.b();
        }
        if (this.f504e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f504e);
            jiVar.b();
        }
        if (this.f505f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f505f);
            jiVar.b();
        }
        if (this.f506g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f506g);
            jiVar.b();
        }
        if (this.f507h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f507h);
            jiVar.b();
        }
        if (this.f494a != null && l()) {
            jiVar.a(l);
            this.f494a.b(jiVar);
            jiVar.b();
        }
        if (this.f508i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f508i);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f498a);
            jiVar.b();
        }
        if (this.f509j != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f509j);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f501c);
            jiVar.b();
        }
        if (this.f510k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f510k);
            jiVar.b();
        }
        if (this.f511l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f511l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f497a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m367b() {
        return this.f496a != null;
    }

    public String c() {
        return this.f502c;
    }

    public void c(boolean z) {
        this.f497a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m368c() {
        return this.f500b != null;
    }

    public void d(boolean z) {
        this.f497a.set(3, z);
    }

    public boolean d() {
        return this.f502c != null;
    }

    public boolean e() {
        return this.f497a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m366a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f497a.get(1);
    }

    public boolean g() {
        return this.f503d != null;
    }

    public boolean h() {
        return this.f504e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f505f != null;
    }

    public boolean j() {
        return this.f506g != null;
    }

    public boolean k() {
        return this.f507h != null;
    }

    public boolean l() {
        return this.f494a != null;
    }

    public boolean m() {
        return this.f508i != null;
    }

    public boolean n() {
        return this.f497a.get(2);
    }

    public boolean o() {
        return this.f509j != null;
    }

    public boolean p() {
        return this.f497a.get(3);
    }

    public boolean q() {
        return this.f510k != null;
    }

    public boolean r() {
        return this.f511l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m365a()) {
            sb.append("to:");
            if (this.f495a == null) {
                sb.append("null");
            } else {
                sb.append(this.f495a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f496a == null) {
            sb.append("null");
        } else {
            sb.append(this.f496a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f500b == null) {
            sb.append("null");
        } else {
            sb.append(this.f500b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f502c == null) {
            sb.append("null");
        } else {
            sb.append(this.f502c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f493a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f499b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f503d == null) {
                sb.append("null");
            } else {
                sb.append(this.f503d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f504e == null) {
                sb.append("null");
            } else {
                sb.append(this.f504e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f505f == null) {
                sb.append("null");
            } else {
                sb.append(this.f505f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f506g == null) {
                sb.append("null");
            } else {
                sb.append(this.f506g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f507h == null) {
                sb.append("null");
            } else {
                sb.append(this.f507h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f494a == null) {
                sb.append("null");
            } else {
                sb.append(this.f494a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f508i == null) {
                sb.append("null");
            } else {
                sb.append(this.f508i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f498a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f509j == null) {
                sb.append("null");
            } else {
                sb.append(this.f509j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f501c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f510k == null) {
                sb.append("null");
            } else {
                sb.append(this.f510k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f511l == null) {
                sb.append("null");
            } else {
                sb.append(this.f511l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
