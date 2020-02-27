package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ih implements ir<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f672a;

    /* renamed from: a  reason: collision with other field name */
    public long f673a;

    /* renamed from: a  reason: collision with other field name */
    public hv f674a;

    /* renamed from: a  reason: collision with other field name */
    public String f675a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f676a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f677b;

    /* renamed from: b  reason: collision with other field name */
    public long f678b;

    /* renamed from: b  reason: collision with other field name */
    public String f679b;

    /* renamed from: c  reason: collision with other field name */
    public long f680c;

    /* renamed from: c  reason: collision with other field name */
    public String f681c;

    /* renamed from: d  reason: collision with other field name */
    public String f682d;

    /* renamed from: e  reason: collision with other field name */
    public String f683e;

    /* renamed from: f  reason: collision with other field name */
    public String f684f;

    /* renamed from: g  reason: collision with other field name */
    public String f685g;

    /* renamed from: h  reason: collision with other field name */
    public String f686h;

    /* renamed from: i  reason: collision with other field name */
    public String f687i;

    /* renamed from: j  reason: collision with other field name */
    public String f688j;

    /* renamed from: k  reason: collision with other field name */
    public String f689k;

    /* renamed from: l  reason: collision with other field name */
    public String f690l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f671a = new jh("XmPushActionRegistrationResult");
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
            int compareTo = Boolean.valueOf(m431a()).compareTo(Boolean.valueOf(ihVar.m431a()));
            if (compareTo == 0) {
                if (!m431a() || (a19 = is.a(this.f675a, ihVar.f675a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m433b()).compareTo(Boolean.valueOf(ihVar.m433b()));
                    if (compareTo2 == 0) {
                        if (!m433b() || (a18 = is.a(this.f674a, ihVar.f674a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = is.a(this.f679b, ihVar.f679b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f681c, ihVar.f681c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f673a, ihVar.f673a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f682d, ihVar.f682d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f683e, ihVar.f683e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f684f, ihVar.f684f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f685g, ihVar.f685g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f678b, ihVar.f678b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f686h, ihVar.f686h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f687i, ihVar.f687i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f680c, ihVar.f680c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f688j, ihVar.f688j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f672a, ihVar.f672a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f689k, ihVar.f689k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f677b, ihVar.f677b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f690l, ihVar.f690l)) == 0) {
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
        return this.f673a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m429a() {
        return this.f679b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m430a() {
        if (this.f679b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f681c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m430a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f675a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f674a = new hv();
                        this.f674a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f679b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f681c = jcVar.m473a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 6:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f673a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f682d = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f683e = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f684f = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f685g = jcVar.m473a();
                        break;
                    }
                case 11:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f678b = jcVar.m467a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f686h = jcVar.m473a();
                        break;
                    }
                case 13:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f687i = jcVar.m473a();
                        break;
                    }
                case 14:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f680c = jcVar.m467a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f688j = jcVar.m473a();
                        break;
                    }
                case 16:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f672a = jcVar.m466a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f689k = jcVar.m473a();
                        break;
                    }
                case 18:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f677b = jcVar.m466a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f690l = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f676a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        return this.f675a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m431a = m431a();
        boolean m431a2 = ihVar.m431a();
        if ((m431a || m431a2) && !(m431a && m431a2 && this.f675a.equals(ihVar.f675a))) {
            return false;
        }
        boolean m433b = m433b();
        boolean m433b2 = ihVar.m433b();
        if ((m433b || m433b2) && !(m433b && m433b2 && this.f674a.m378a(ihVar.f674a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f679b.equals(ihVar.f679b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f681c.equals(ihVar.f681c))) || this.f673a != ihVar.f673a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f682d.equals(ihVar.f682d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f683e.equals(ihVar.f683e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f684f.equals(ihVar.f684f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f685g.equals(ihVar.f685g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f678b == ihVar.f678b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f686h.equals(ihVar.f686h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f687i.equals(ihVar.f687i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f680c == ihVar.f680c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f688j.equals(ihVar.f688j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f672a == ihVar.f672a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f689k.equals(ihVar.f689k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f677b == ihVar.f677b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f690l.equals(ihVar.f690l));
    }

    public String b() {
        return this.f685g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m430a();
        jcVar.a(f671a);
        if (this.f675a != null && m431a()) {
            jcVar.a(a);
            jcVar.a(this.f675a);
            jcVar.b();
        }
        if (this.f674a != null && m433b()) {
            jcVar.a(b);
            this.f674a.b(jcVar);
            jcVar.b();
        }
        if (this.f679b != null) {
            jcVar.a(c);
            jcVar.a(this.f679b);
            jcVar.b();
        }
        if (this.f681c != null) {
            jcVar.a(d);
            jcVar.a(this.f681c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f673a);
        jcVar.b();
        if (this.f682d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f682d);
            jcVar.b();
        }
        if (this.f683e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f683e);
            jcVar.b();
        }
        if (this.f684f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f684f);
            jcVar.b();
        }
        if (this.f685g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f685g);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f678b);
            jcVar.b();
        }
        if (this.f686h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f686h);
            jcVar.b();
        }
        if (this.f687i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f687i);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f680c);
            jcVar.b();
        }
        if (this.f688j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f688j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f672a);
            jcVar.b();
        }
        if (this.f689k != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f689k);
            jcVar.b();
        }
        if (q()) {
            jcVar.a(q);
            jcVar.a(this.f677b);
            jcVar.b();
        }
        if (this.f690l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f690l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f676a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m433b() {
        return this.f674a != null;
    }

    public void c(boolean z) {
        this.f676a.set(2, z);
    }

    public boolean c() {
        return this.f679b != null;
    }

    public void d(boolean z) {
        this.f676a.set(3, z);
    }

    public boolean d() {
        return this.f681c != null;
    }

    public void e(boolean z) {
        this.f676a.set(4, z);
    }

    public boolean e() {
        return this.f676a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m432a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f682d != null;
    }

    public boolean g() {
        return this.f683e != null;
    }

    public boolean h() {
        return this.f684f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f685g != null;
    }

    public boolean j() {
        return this.f676a.get(1);
    }

    public boolean k() {
        return this.f686h != null;
    }

    public boolean l() {
        return this.f687i != null;
    }

    public boolean m() {
        return this.f676a.get(2);
    }

    public boolean n() {
        return this.f688j != null;
    }

    public boolean o() {
        return this.f676a.get(3);
    }

    public boolean p() {
        return this.f689k != null;
    }

    public boolean q() {
        return this.f676a.get(4);
    }

    public boolean r() {
        return this.f690l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m431a()) {
            sb.append("debug:");
            if (this.f675a == null) {
                sb.append("null");
            } else {
                sb.append(this.f675a);
            }
            z2 = false;
        }
        if (m433b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f674a == null) {
                sb.append("null");
            } else {
                sb.append(this.f674a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f679b == null) {
            sb.append("null");
        } else {
            sb.append(this.f679b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f681c == null) {
            sb.append("null");
        } else {
            sb.append(this.f681c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f673a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f682d == null) {
                sb.append("null");
            } else {
                sb.append(this.f682d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f683e == null) {
                sb.append("null");
            } else {
                sb.append(this.f683e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f684f == null) {
                sb.append("null");
            } else {
                sb.append(this.f684f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f685g == null) {
                sb.append("null");
            } else {
                sb.append(this.f685g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f678b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f686h == null) {
                sb.append("null");
            } else {
                sb.append(this.f686h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f687i == null) {
                sb.append("null");
            } else {
                sb.append(this.f687i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f680c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f688j == null) {
                sb.append("null");
            } else {
                sb.append(this.f688j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f672a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f689k == null) {
                sb.append("null");
            } else {
                sb.append(this.f689k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f677b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f690l == null) {
                sb.append("null");
            } else {
                sb.append(this.f690l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
