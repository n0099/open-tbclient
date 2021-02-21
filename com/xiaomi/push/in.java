package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f738a;

    /* renamed from: a  reason: collision with other field name */
    public long f739a;

    /* renamed from: a  reason: collision with other field name */
    public ib f740a;

    /* renamed from: a  reason: collision with other field name */
    public String f741a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f742a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f743b;

    /* renamed from: b  reason: collision with other field name */
    public long f744b;

    /* renamed from: b  reason: collision with other field name */
    public String f745b;

    /* renamed from: c  reason: collision with other field name */
    public long f746c;

    /* renamed from: c  reason: collision with other field name */
    public String f747c;

    /* renamed from: d  reason: collision with other field name */
    public String f748d;

    /* renamed from: e  reason: collision with other field name */
    public String f749e;

    /* renamed from: f  reason: collision with other field name */
    public String f750f;

    /* renamed from: g  reason: collision with other field name */
    public String f751g;

    /* renamed from: h  reason: collision with other field name */
    public String f752h;

    /* renamed from: i  reason: collision with other field name */
    public String f753i;

    /* renamed from: j  reason: collision with other field name */
    public String f754j;

    /* renamed from: k  reason: collision with other field name */
    public String f755k;

    /* renamed from: l  reason: collision with other field name */
    public String f756l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f737a = new jn("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14145a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14146b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf j = new jf("", (byte) 10, 11);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 13);
    private static final jf m = new jf("", (byte) 10, 14);
    private static final jf n = new jf("", Constants.GZIP_CAST_TYPE, 15);
    private static final jf o = new jf("", (byte) 8, 16);
    private static final jf p = new jf("", Constants.GZIP_CAST_TYPE, 17);
    private static final jf q = new jf("", (byte) 8, 18);
    private static final jf r = new jf("", Constants.GZIP_CAST_TYPE, 19);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
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
        if (getClass().equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m473a()).compareTo(Boolean.valueOf(inVar.m473a()));
            if (compareTo == 0) {
                if (!m473a() || (a19 = iy.a(this.f741a, inVar.f741a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m475b()).compareTo(Boolean.valueOf(inVar.m475b()));
                    if (compareTo2 == 0) {
                        if (!m475b() || (a18 = iy.a(this.f740a, inVar.f740a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f745b, inVar.f745b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f747c, inVar.f747c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f739a, inVar.f739a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f748d, inVar.f748d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f749e, inVar.f749e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f750f, inVar.f750f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f751g, inVar.f751g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f744b, inVar.f744b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f752h, inVar.f752h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f753i, inVar.f753i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f746c, inVar.f746c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f754j, inVar.f754j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f738a, inVar.f738a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f755k, inVar.f755k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f743b, inVar.f743b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f756l, inVar.f756l)) == 0) {
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
        return getClass().getName().compareTo(inVar.getClass().getName());
    }

    public long a() {
        return this.f739a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m471a() {
        return this.f745b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m472a() {
        if (this.f745b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f747c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m472a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f741a = jiVar.m515a();
                        break;
                    }
                case 2:
                    if (m510a.f14173a != 12) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f740a = new ib();
                        this.f740a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f745b = jiVar.m515a();
                        break;
                    }
                case 4:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f747c = jiVar.m515a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
                case 6:
                    if (m510a.f14173a != 10) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f739a = jiVar.m509a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f748d = jiVar.m515a();
                        break;
                    }
                case 8:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f749e = jiVar.m515a();
                        break;
                    }
                case 9:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f750f = jiVar.m515a();
                        break;
                    }
                case 10:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f751g = jiVar.m515a();
                        break;
                    }
                case 11:
                    if (m510a.f14173a != 10) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f744b = jiVar.m509a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f752h = jiVar.m515a();
                        break;
                    }
                case 13:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f753i = jiVar.m515a();
                        break;
                    }
                case 14:
                    if (m510a.f14173a != 10) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f746c = jiVar.m509a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f754j = jiVar.m515a();
                        break;
                    }
                case 16:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f738a = jiVar.m508a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f755k = jiVar.m515a();
                        break;
                    }
                case 18:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f743b = jiVar.m508a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f756l = jiVar.m515a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f742a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a() {
        return this.f741a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m473a = m473a();
        boolean m473a2 = inVar.m473a();
        if ((m473a || m473a2) && !(m473a && m473a2 && this.f741a.equals(inVar.f741a))) {
            return false;
        }
        boolean m475b = m475b();
        boolean m475b2 = inVar.m475b();
        if ((m475b || m475b2) && !(m475b && m475b2 && this.f740a.m423a(inVar.f740a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f745b.equals(inVar.f745b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f747c.equals(inVar.f747c))) || this.f739a != inVar.f739a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f748d.equals(inVar.f748d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f749e.equals(inVar.f749e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f750f.equals(inVar.f750f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f751g.equals(inVar.f751g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f744b == inVar.f744b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f752h.equals(inVar.f752h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f753i.equals(inVar.f753i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f746c == inVar.f746c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f754j.equals(inVar.f754j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f738a == inVar.f738a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f755k.equals(inVar.f755k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f743b == inVar.f743b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f756l.equals(inVar.f756l));
    }

    public String b() {
        return this.f751g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m472a();
        jiVar.a(f737a);
        if (this.f741a != null && m473a()) {
            jiVar.a(f14145a);
            jiVar.a(this.f741a);
            jiVar.b();
        }
        if (this.f740a != null && m475b()) {
            jiVar.a(f14146b);
            this.f740a.b(jiVar);
            jiVar.b();
        }
        if (this.f745b != null) {
            jiVar.a(c);
            jiVar.a(this.f745b);
            jiVar.b();
        }
        if (this.f747c != null) {
            jiVar.a(d);
            jiVar.a(this.f747c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f739a);
        jiVar.b();
        if (this.f748d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f748d);
            jiVar.b();
        }
        if (this.f749e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f749e);
            jiVar.b();
        }
        if (this.f750f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f750f);
            jiVar.b();
        }
        if (this.f751g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f751g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f744b);
            jiVar.b();
        }
        if (this.f752h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f752h);
            jiVar.b();
        }
        if (this.f753i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f753i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f746c);
            jiVar.b();
        }
        if (this.f754j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f754j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f738a);
            jiVar.b();
        }
        if (this.f755k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f755k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f743b);
            jiVar.b();
        }
        if (this.f756l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f756l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public void b(boolean z) {
        this.f742a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m475b() {
        return this.f740a != null;
    }

    public void c(boolean z) {
        this.f742a.set(2, z);
    }

    public boolean c() {
        return this.f745b != null;
    }

    public void d(boolean z) {
        this.f742a.set(3, z);
    }

    public boolean d() {
        return this.f747c != null;
    }

    public void e(boolean z) {
        this.f742a.set(4, z);
    }

    public boolean e() {
        return this.f742a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m474a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f748d != null;
    }

    public boolean g() {
        return this.f749e != null;
    }

    public boolean h() {
        return this.f750f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f751g != null;
    }

    public boolean j() {
        return this.f742a.get(1);
    }

    public boolean k() {
        return this.f752h != null;
    }

    public boolean l() {
        return this.f753i != null;
    }

    public boolean m() {
        return this.f742a.get(2);
    }

    public boolean n() {
        return this.f754j != null;
    }

    public boolean o() {
        return this.f742a.get(3);
    }

    public boolean p() {
        return this.f755k != null;
    }

    public boolean q() {
        return this.f742a.get(4);
    }

    public boolean r() {
        return this.f756l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m473a()) {
            sb.append("debug:");
            if (this.f741a == null) {
                sb.append("null");
            } else {
                sb.append(this.f741a);
            }
            z2 = false;
        }
        if (m475b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f740a == null) {
                sb.append("null");
            } else {
                sb.append(this.f740a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f745b == null) {
            sb.append("null");
        } else {
            sb.append(this.f745b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f747c == null) {
            sb.append("null");
        } else {
            sb.append(this.f747c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f739a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f748d == null) {
                sb.append("null");
            } else {
                sb.append(this.f748d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f749e == null) {
                sb.append("null");
            } else {
                sb.append(this.f749e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f750f == null) {
                sb.append("null");
            } else {
                sb.append(this.f750f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f751g == null) {
                sb.append("null");
            } else {
                sb.append(this.f751g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f744b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f752h == null) {
                sb.append("null");
            } else {
                sb.append(this.f752h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f753i == null) {
                sb.append("null");
            } else {
                sb.append(this.f753i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f746c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f754j == null) {
                sb.append("null");
            } else {
                sb.append(this.f754j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f738a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f755k == null) {
                sb.append("null");
            } else {
                sb.append(this.f755k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f743b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f756l == null) {
                sb.append("null");
            } else {
                sb.append(this.f756l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
