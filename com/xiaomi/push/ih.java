package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ih implements ir<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f671a;

    /* renamed from: a  reason: collision with other field name */
    public long f672a;

    /* renamed from: a  reason: collision with other field name */
    public hv f673a;

    /* renamed from: a  reason: collision with other field name */
    public String f674a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f675a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f676b;

    /* renamed from: b  reason: collision with other field name */
    public long f677b;

    /* renamed from: b  reason: collision with other field name */
    public String f678b;

    /* renamed from: c  reason: collision with other field name */
    public long f679c;

    /* renamed from: c  reason: collision with other field name */
    public String f680c;

    /* renamed from: d  reason: collision with other field name */
    public String f681d;

    /* renamed from: e  reason: collision with other field name */
    public String f682e;

    /* renamed from: f  reason: collision with other field name */
    public String f683f;

    /* renamed from: g  reason: collision with other field name */
    public String f684g;

    /* renamed from: h  reason: collision with other field name */
    public String f685h;

    /* renamed from: i  reason: collision with other field name */
    public String f686i;

    /* renamed from: j  reason: collision with other field name */
    public String f687j;

    /* renamed from: k  reason: collision with other field name */
    public String f688k;

    /* renamed from: l  reason: collision with other field name */
    public String f689l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f670a = new jh("XmPushActionRegistrationResult");
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
                if (!m431a() || (a19 = is.a(this.f674a, ihVar.f674a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m433b()).compareTo(Boolean.valueOf(ihVar.m433b()));
                    if (compareTo2 == 0) {
                        if (!m433b() || (a18 = is.a(this.f673a, ihVar.f673a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = is.a(this.f678b, ihVar.f678b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f680c, ihVar.f680c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f672a, ihVar.f672a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f681d, ihVar.f681d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f682e, ihVar.f682e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f683f, ihVar.f683f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f684g, ihVar.f684g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f677b, ihVar.f677b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f685h, ihVar.f685h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f686i, ihVar.f686i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f679c, ihVar.f679c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f687j, ihVar.f687j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f671a, ihVar.f671a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f688k, ihVar.f688k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f676b, ihVar.f676b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f689l, ihVar.f689l)) == 0) {
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
        return this.f672a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m429a() {
        return this.f678b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m430a() {
        if (this.f678b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f680c == null) {
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
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f674a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f673a = new hv();
                        this.f673a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f678b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f680c = jcVar.m473a();
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
                        this.f672a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f681d = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f682e = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f683f = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f684g = jcVar.m473a();
                        break;
                    }
                case 11:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f677b = jcVar.m467a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f685h = jcVar.m473a();
                        break;
                    }
                case 13:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f686i = jcVar.m473a();
                        break;
                    }
                case 14:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f679c = jcVar.m467a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f687j = jcVar.m473a();
                        break;
                    }
                case 16:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f671a = jcVar.m466a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f688k = jcVar.m473a();
                        break;
                    }
                case 18:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f676b = jcVar.m466a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f689l = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f675a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        return this.f674a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m431a = m431a();
        boolean m431a2 = ihVar.m431a();
        if ((m431a || m431a2) && !(m431a && m431a2 && this.f674a.equals(ihVar.f674a))) {
            return false;
        }
        boolean m433b = m433b();
        boolean m433b2 = ihVar.m433b();
        if ((m433b || m433b2) && !(m433b && m433b2 && this.f673a.m378a(ihVar.f673a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f678b.equals(ihVar.f678b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f680c.equals(ihVar.f680c))) || this.f672a != ihVar.f672a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f681d.equals(ihVar.f681d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f682e.equals(ihVar.f682e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f683f.equals(ihVar.f683f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f684g.equals(ihVar.f684g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f677b == ihVar.f677b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f685h.equals(ihVar.f685h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f686i.equals(ihVar.f686i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f679c == ihVar.f679c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f687j.equals(ihVar.f687j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f671a == ihVar.f671a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f688k.equals(ihVar.f688k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f676b == ihVar.f676b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f689l.equals(ihVar.f689l));
    }

    public String b() {
        return this.f684g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m430a();
        jcVar.a(f670a);
        if (this.f674a != null && m431a()) {
            jcVar.a(a);
            jcVar.a(this.f674a);
            jcVar.b();
        }
        if (this.f673a != null && m433b()) {
            jcVar.a(b);
            this.f673a.b(jcVar);
            jcVar.b();
        }
        if (this.f678b != null) {
            jcVar.a(c);
            jcVar.a(this.f678b);
            jcVar.b();
        }
        if (this.f680c != null) {
            jcVar.a(d);
            jcVar.a(this.f680c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f672a);
        jcVar.b();
        if (this.f681d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f681d);
            jcVar.b();
        }
        if (this.f682e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f682e);
            jcVar.b();
        }
        if (this.f683f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f683f);
            jcVar.b();
        }
        if (this.f684g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f684g);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f677b);
            jcVar.b();
        }
        if (this.f685h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f685h);
            jcVar.b();
        }
        if (this.f686i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f686i);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f679c);
            jcVar.b();
        }
        if (this.f687j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f687j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f671a);
            jcVar.b();
        }
        if (this.f688k != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f688k);
            jcVar.b();
        }
        if (q()) {
            jcVar.a(q);
            jcVar.a(this.f676b);
            jcVar.b();
        }
        if (this.f689l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f689l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f675a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m433b() {
        return this.f673a != null;
    }

    public void c(boolean z) {
        this.f675a.set(2, z);
    }

    public boolean c() {
        return this.f678b != null;
    }

    public void d(boolean z) {
        this.f675a.set(3, z);
    }

    public boolean d() {
        return this.f680c != null;
    }

    public void e(boolean z) {
        this.f675a.set(4, z);
    }

    public boolean e() {
        return this.f675a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m432a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f681d != null;
    }

    public boolean g() {
        return this.f682e != null;
    }

    public boolean h() {
        return this.f683f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f684g != null;
    }

    public boolean j() {
        return this.f675a.get(1);
    }

    public boolean k() {
        return this.f685h != null;
    }

    public boolean l() {
        return this.f686i != null;
    }

    public boolean m() {
        return this.f675a.get(2);
    }

    public boolean n() {
        return this.f687j != null;
    }

    public boolean o() {
        return this.f675a.get(3);
    }

    public boolean p() {
        return this.f688k != null;
    }

    public boolean q() {
        return this.f675a.get(4);
    }

    public boolean r() {
        return this.f689l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m431a()) {
            sb.append("debug:");
            if (this.f674a == null) {
                sb.append("null");
            } else {
                sb.append(this.f674a);
            }
            z2 = false;
        }
        if (m433b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f673a == null) {
                sb.append("null");
            } else {
                sb.append(this.f673a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f678b == null) {
            sb.append("null");
        } else {
            sb.append(this.f678b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f680c == null) {
            sb.append("null");
        } else {
            sb.append(this.f680c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f672a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f681d == null) {
                sb.append("null");
            } else {
                sb.append(this.f681d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f682e == null) {
                sb.append("null");
            } else {
                sb.append(this.f682e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f683f == null) {
                sb.append("null");
            } else {
                sb.append(this.f683f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f684g == null) {
                sb.append("null");
            } else {
                sb.append(this.f684g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f677b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f685h == null) {
                sb.append("null");
            } else {
                sb.append(this.f685h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f686i == null) {
                sb.append("null");
            } else {
                sb.append(this.f686i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f679c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f687j == null) {
                sb.append("null");
            } else {
                sb.append(this.f687j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f671a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f688k == null) {
                sb.append("null");
            } else {
                sb.append(this.f688k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f676b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f689l == null) {
                sb.append("null");
            } else {
                sb.append(this.f689l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
