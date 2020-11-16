package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f662a;

    /* renamed from: a  reason: collision with other field name */
    public long f663a;

    /* renamed from: a  reason: collision with other field name */
    public ib f664a;

    /* renamed from: a  reason: collision with other field name */
    public String f665a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f666a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f667b;

    /* renamed from: b  reason: collision with other field name */
    public long f668b;

    /* renamed from: b  reason: collision with other field name */
    public String f669b;

    /* renamed from: c  reason: collision with other field name */
    public long f670c;

    /* renamed from: c  reason: collision with other field name */
    public String f671c;

    /* renamed from: d  reason: collision with other field name */
    public String f672d;

    /* renamed from: e  reason: collision with other field name */
    public String f673e;

    /* renamed from: f  reason: collision with other field name */
    public String f674f;

    /* renamed from: g  reason: collision with other field name */
    public String f675g;

    /* renamed from: h  reason: collision with other field name */
    public String f676h;

    /* renamed from: i  reason: collision with other field name */
    public String f677i;

    /* renamed from: j  reason: collision with other field name */
    public String f678j;

    /* renamed from: k  reason: collision with other field name */
    public String f679k;

    /* renamed from: l  reason: collision with other field name */
    public String f680l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f661a = new jn("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4983a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m451a()).compareTo(Boolean.valueOf(inVar.m451a()));
            if (compareTo == 0) {
                if (!m451a() || (a19 = iy.a(this.f665a, inVar.f665a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m453b()).compareTo(Boolean.valueOf(inVar.m453b()));
                    if (compareTo2 == 0) {
                        if (!m453b() || (a18 = iy.a(this.f664a, inVar.f664a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f669b, inVar.f669b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f671c, inVar.f671c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f663a, inVar.f663a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f672d, inVar.f672d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f673e, inVar.f673e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f674f, inVar.f674f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f675g, inVar.f675g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f668b, inVar.f668b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f676h, inVar.f676h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f677i, inVar.f677i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f670c, inVar.f670c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f678j, inVar.f678j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f662a, inVar.f662a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f679k, inVar.f679k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f667b, inVar.f667b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f680l, inVar.f680l)) == 0) {
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
        return this.f663a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m449a() {
        return this.f669b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m450a() {
        if (this.f669b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f671c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m450a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f665a = jiVar.m493a();
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f664a = new ib();
                        this.f664a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f669b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f671c = jiVar.m493a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 6:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f663a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f672d = jiVar.m493a();
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f673e = jiVar.m493a();
                        break;
                    }
                case 9:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f674f = jiVar.m493a();
                        break;
                    }
                case 10:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f675g = jiVar.m493a();
                        break;
                    }
                case 11:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f668b = jiVar.m487a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f676h = jiVar.m493a();
                        break;
                    }
                case 13:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f677i = jiVar.m493a();
                        break;
                    }
                case 14:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f670c = jiVar.m487a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f678j = jiVar.m493a();
                        break;
                    }
                case 16:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f662a = jiVar.m486a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f679k = jiVar.m493a();
                        break;
                    }
                case 18:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f667b = jiVar.m486a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f680l = jiVar.m493a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f666a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a() {
        return this.f665a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m451a = m451a();
        boolean m451a2 = inVar.m451a();
        if ((m451a || m451a2) && !(m451a && m451a2 && this.f665a.equals(inVar.f665a))) {
            return false;
        }
        boolean m453b = m453b();
        boolean m453b2 = inVar.m453b();
        if ((m453b || m453b2) && !(m453b && m453b2 && this.f664a.m401a(inVar.f664a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f669b.equals(inVar.f669b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f671c.equals(inVar.f671c))) || this.f663a != inVar.f663a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f672d.equals(inVar.f672d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f673e.equals(inVar.f673e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f674f.equals(inVar.f674f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f675g.equals(inVar.f675g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f668b == inVar.f668b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f676h.equals(inVar.f676h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f677i.equals(inVar.f677i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f670c == inVar.f670c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f678j.equals(inVar.f678j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f662a == inVar.f662a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f679k.equals(inVar.f679k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f667b == inVar.f667b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f680l.equals(inVar.f680l));
    }

    public String b() {
        return this.f675g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m450a();
        jiVar.a(f661a);
        if (this.f665a != null && m451a()) {
            jiVar.a(f4983a);
            jiVar.a(this.f665a);
            jiVar.b();
        }
        if (this.f664a != null && m453b()) {
            jiVar.a(b);
            this.f664a.b(jiVar);
            jiVar.b();
        }
        if (this.f669b != null) {
            jiVar.a(c);
            jiVar.a(this.f669b);
            jiVar.b();
        }
        if (this.f671c != null) {
            jiVar.a(d);
            jiVar.a(this.f671c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f663a);
        jiVar.b();
        if (this.f672d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f672d);
            jiVar.b();
        }
        if (this.f673e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f673e);
            jiVar.b();
        }
        if (this.f674f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f674f);
            jiVar.b();
        }
        if (this.f675g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f675g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f668b);
            jiVar.b();
        }
        if (this.f676h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f676h);
            jiVar.b();
        }
        if (this.f677i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f677i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f670c);
            jiVar.b();
        }
        if (this.f678j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f678j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f662a);
            jiVar.b();
        }
        if (this.f679k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f679k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f667b);
            jiVar.b();
        }
        if (this.f680l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f680l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f666a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m453b() {
        return this.f664a != null;
    }

    public void c(boolean z) {
        this.f666a.set(2, z);
    }

    public boolean c() {
        return this.f669b != null;
    }

    public void d(boolean z) {
        this.f666a.set(3, z);
    }

    public boolean d() {
        return this.f671c != null;
    }

    public void e(boolean z) {
        this.f666a.set(4, z);
    }

    public boolean e() {
        return this.f666a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m452a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f672d != null;
    }

    public boolean g() {
        return this.f673e != null;
    }

    public boolean h() {
        return this.f674f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f675g != null;
    }

    public boolean j() {
        return this.f666a.get(1);
    }

    public boolean k() {
        return this.f676h != null;
    }

    public boolean l() {
        return this.f677i != null;
    }

    public boolean m() {
        return this.f666a.get(2);
    }

    public boolean n() {
        return this.f678j != null;
    }

    public boolean o() {
        return this.f666a.get(3);
    }

    public boolean p() {
        return this.f679k != null;
    }

    public boolean q() {
        return this.f666a.get(4);
    }

    public boolean r() {
        return this.f680l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m451a()) {
            sb.append("debug:");
            if (this.f665a == null) {
                sb.append("null");
            } else {
                sb.append(this.f665a);
            }
            z2 = false;
        }
        if (m453b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f664a == null) {
                sb.append("null");
            } else {
                sb.append(this.f664a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f669b == null) {
            sb.append("null");
        } else {
            sb.append(this.f669b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f671c == null) {
            sb.append("null");
        } else {
            sb.append(this.f671c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f663a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f672d == null) {
                sb.append("null");
            } else {
                sb.append(this.f672d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f673e == null) {
                sb.append("null");
            } else {
                sb.append(this.f673e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f674f == null) {
                sb.append("null");
            } else {
                sb.append(this.f674f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f675g == null) {
                sb.append("null");
            } else {
                sb.append(this.f675g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f668b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f676h == null) {
                sb.append("null");
            } else {
                sb.append(this.f676h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f677i == null) {
                sb.append("null");
            } else {
                sb.append(this.f677i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f670c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f678j == null) {
                sb.append("null");
            } else {
                sb.append(this.f678j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f662a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f679k == null) {
                sb.append("null");
            } else {
                sb.append(this.f679k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f667b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f680l == null) {
                sb.append("null");
            } else {
                sb.append(this.f680l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
