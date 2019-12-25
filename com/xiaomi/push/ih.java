package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ih implements ir<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f676a;

    /* renamed from: a  reason: collision with other field name */
    public long f677a;

    /* renamed from: a  reason: collision with other field name */
    public hv f678a;

    /* renamed from: a  reason: collision with other field name */
    public String f679a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f680a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f681b;

    /* renamed from: b  reason: collision with other field name */
    public long f682b;

    /* renamed from: b  reason: collision with other field name */
    public String f683b;

    /* renamed from: c  reason: collision with other field name */
    public long f684c;

    /* renamed from: c  reason: collision with other field name */
    public String f685c;

    /* renamed from: d  reason: collision with other field name */
    public String f686d;

    /* renamed from: e  reason: collision with other field name */
    public String f687e;

    /* renamed from: f  reason: collision with other field name */
    public String f688f;

    /* renamed from: g  reason: collision with other field name */
    public String f689g;

    /* renamed from: h  reason: collision with other field name */
    public String f690h;

    /* renamed from: i  reason: collision with other field name */
    public String f691i;

    /* renamed from: j  reason: collision with other field name */
    public String f692j;

    /* renamed from: k  reason: collision with other field name */
    public String f693k;

    /* renamed from: l  reason: collision with other field name */
    public String f694l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f675a = new jh("XmPushActionRegistrationResult");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz j = new iz("", (byte) 10, 11);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 12);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 13);
    private static final iz m = new iz("", (byte) 10, 14);
    private static final iz n = new iz("", Constants.GZIP_CAST_TYPE, 15);
    private static final iz o = new iz("", (byte) 8, 16);
    private static final iz p = new iz("", Constants.GZIP_CAST_TYPE, 17);
    private static final iz q = new iz("", (byte) 8, 18);
    private static final iz r = new iz("", Constants.GZIP_CAST_TYPE, 19);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
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
        if (getClass().equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m417a()).compareTo(Boolean.valueOf(ihVar.m417a()));
            if (compareTo == 0) {
                if (!m417a() || (a19 = is.a(this.f679a, ihVar.f679a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m419b()).compareTo(Boolean.valueOf(ihVar.m419b()));
                    if (compareTo2 == 0) {
                        if (!m419b() || (a18 = is.a(this.f678a, ihVar.f678a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = is.a(this.f683b, ihVar.f683b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f685c, ihVar.f685c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f677a, ihVar.f677a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f686d, ihVar.f686d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f687e, ihVar.f687e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f688f, ihVar.f688f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f689g, ihVar.f689g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f682b, ihVar.f682b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f690h, ihVar.f690h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f691i, ihVar.f691i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f684c, ihVar.f684c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f692j, ihVar.f692j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f676a, ihVar.f676a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f693k, ihVar.f693k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f681b, ihVar.f681b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f694l, ihVar.f694l)) == 0) {
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
        return getClass().getName().compareTo(ihVar.getClass().getName());
    }

    public long a() {
        return this.f677a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m415a() {
        return this.f683b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m416a() {
        if (this.f683b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f685c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m416a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f679a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f678a = new hv();
                        this.f678a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f683b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f685c = jcVar.m459a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 6:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f677a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f686d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f687e = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f688f = jcVar.m459a();
                        break;
                    }
                case 10:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f689g = jcVar.m459a();
                        break;
                    }
                case 11:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f682b = jcVar.m453a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f690h = jcVar.m459a();
                        break;
                    }
                case 13:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f691i = jcVar.m459a();
                        break;
                    }
                case 14:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f684c = jcVar.m453a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f692j = jcVar.m459a();
                        break;
                    }
                case 16:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f676a = jcVar.m452a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f693k = jcVar.m459a();
                        break;
                    }
                case 18:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f681b = jcVar.m452a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f694l = jcVar.m459a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f680a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m417a() {
        return this.f679a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m418a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m417a = m417a();
        boolean m417a2 = ihVar.m417a();
        if ((m417a || m417a2) && !(m417a && m417a2 && this.f679a.equals(ihVar.f679a))) {
            return false;
        }
        boolean m419b = m419b();
        boolean m419b2 = ihVar.m419b();
        if ((m419b || m419b2) && !(m419b && m419b2 && this.f678a.m364a(ihVar.f678a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f683b.equals(ihVar.f683b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f685c.equals(ihVar.f685c))) || this.f677a != ihVar.f677a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f686d.equals(ihVar.f686d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f687e.equals(ihVar.f687e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f688f.equals(ihVar.f688f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f689g.equals(ihVar.f689g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f682b == ihVar.f682b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f690h.equals(ihVar.f690h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f691i.equals(ihVar.f691i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f684c == ihVar.f684c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f692j.equals(ihVar.f692j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f676a == ihVar.f676a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f693k.equals(ihVar.f693k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f681b == ihVar.f681b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f694l.equals(ihVar.f694l));
    }

    public String b() {
        return this.f689g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m416a();
        jcVar.a(f675a);
        if (this.f679a != null && m417a()) {
            jcVar.a(a);
            jcVar.a(this.f679a);
            jcVar.b();
        }
        if (this.f678a != null && m419b()) {
            jcVar.a(b);
            this.f678a.b(jcVar);
            jcVar.b();
        }
        if (this.f683b != null) {
            jcVar.a(c);
            jcVar.a(this.f683b);
            jcVar.b();
        }
        if (this.f685c != null) {
            jcVar.a(d);
            jcVar.a(this.f685c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f677a);
        jcVar.b();
        if (this.f686d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f686d);
            jcVar.b();
        }
        if (this.f687e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f687e);
            jcVar.b();
        }
        if (this.f688f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f688f);
            jcVar.b();
        }
        if (this.f689g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f689g);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f682b);
            jcVar.b();
        }
        if (this.f690h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f690h);
            jcVar.b();
        }
        if (this.f691i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f691i);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f684c);
            jcVar.b();
        }
        if (this.f692j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f692j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f676a);
            jcVar.b();
        }
        if (this.f693k != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f693k);
            jcVar.b();
        }
        if (q()) {
            jcVar.a(q);
            jcVar.a(this.f681b);
            jcVar.b();
        }
        if (this.f694l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f694l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f680a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m419b() {
        return this.f678a != null;
    }

    public void c(boolean z) {
        this.f680a.set(2, z);
    }

    public boolean c() {
        return this.f683b != null;
    }

    public void d(boolean z) {
        this.f680a.set(3, z);
    }

    public boolean d() {
        return this.f685c != null;
    }

    public void e(boolean z) {
        this.f680a.set(4, z);
    }

    public boolean e() {
        return this.f680a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m418a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f686d != null;
    }

    public boolean g() {
        return this.f687e != null;
    }

    public boolean h() {
        return this.f688f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f689g != null;
    }

    public boolean j() {
        return this.f680a.get(1);
    }

    public boolean k() {
        return this.f690h != null;
    }

    public boolean l() {
        return this.f691i != null;
    }

    public boolean m() {
        return this.f680a.get(2);
    }

    public boolean n() {
        return this.f692j != null;
    }

    public boolean o() {
        return this.f680a.get(3);
    }

    public boolean p() {
        return this.f693k != null;
    }

    public boolean q() {
        return this.f680a.get(4);
    }

    public boolean r() {
        return this.f694l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m417a()) {
            sb.append("debug:");
            if (this.f679a == null) {
                sb.append("null");
            } else {
                sb.append(this.f679a);
            }
            z2 = false;
        }
        if (m419b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f678a == null) {
                sb.append("null");
            } else {
                sb.append(this.f678a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f683b == null) {
            sb.append("null");
        } else {
            sb.append(this.f683b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f685c == null) {
            sb.append("null");
        } else {
            sb.append(this.f685c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f677a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f686d == null) {
                sb.append("null");
            } else {
                sb.append(this.f686d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f687e == null) {
                sb.append("null");
            } else {
                sb.append(this.f687e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f688f == null) {
                sb.append("null");
            } else {
                sb.append(this.f688f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f689g == null) {
                sb.append("null");
            } else {
                sb.append(this.f689g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f682b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f690h == null) {
                sb.append("null");
            } else {
                sb.append(this.f690h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f691i == null) {
                sb.append("null");
            } else {
                sb.append(this.f691i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f684c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f692j == null) {
                sb.append("null");
            } else {
                sb.append(this.f692j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f676a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f693k == null) {
                sb.append("null");
            } else {
                sb.append(this.f693k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f681b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f694l == null) {
                sb.append("null");
            } else {
                sb.append(this.f694l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
