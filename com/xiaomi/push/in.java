package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f658a;

    /* renamed from: a  reason: collision with other field name */
    public long f659a;

    /* renamed from: a  reason: collision with other field name */
    public ib f660a;

    /* renamed from: a  reason: collision with other field name */
    public String f661a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f662a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f663b;

    /* renamed from: b  reason: collision with other field name */
    public long f664b;

    /* renamed from: b  reason: collision with other field name */
    public String f665b;

    /* renamed from: c  reason: collision with other field name */
    public long f666c;

    /* renamed from: c  reason: collision with other field name */
    public String f667c;

    /* renamed from: d  reason: collision with other field name */
    public String f668d;

    /* renamed from: e  reason: collision with other field name */
    public String f669e;

    /* renamed from: f  reason: collision with other field name */
    public String f670f;

    /* renamed from: g  reason: collision with other field name */
    public String f671g;

    /* renamed from: h  reason: collision with other field name */
    public String f672h;

    /* renamed from: i  reason: collision with other field name */
    public String f673i;

    /* renamed from: j  reason: collision with other field name */
    public String f674j;

    /* renamed from: k  reason: collision with other field name */
    public String f675k;

    /* renamed from: l  reason: collision with other field name */
    public String f676l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f657a = new jn("XmPushActionRegistrationResult");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m446a()).compareTo(Boolean.valueOf(inVar.m446a()));
            if (compareTo == 0) {
                if (!m446a() || (a19 = iy.a(this.f661a, inVar.f661a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m448b()).compareTo(Boolean.valueOf(inVar.m448b()));
                    if (compareTo2 == 0) {
                        if (!m448b() || (a18 = iy.a(this.f660a, inVar.f660a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f665b, inVar.f665b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f667c, inVar.f667c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f659a, inVar.f659a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f668d, inVar.f668d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f669e, inVar.f669e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f670f, inVar.f670f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f671g, inVar.f671g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f664b, inVar.f664b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f672h, inVar.f672h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f673i, inVar.f673i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f666c, inVar.f666c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f674j, inVar.f674j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f658a, inVar.f658a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f675k, inVar.f675k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f663b, inVar.f663b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f676l, inVar.f676l)) == 0) {
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
        return this.f659a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m444a() {
        return this.f665b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m445a() {
        if (this.f665b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f667c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m445a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f661a = jiVar.m488a();
                        break;
                    }
                case 2:
                    if (m483a.a != 12) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f660a = new ib();
                        this.f660a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f665b = jiVar.m488a();
                        break;
                    }
                case 4:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f667c = jiVar.m488a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m483a.a);
                    break;
                case 6:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f659a = jiVar.m482a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f668d = jiVar.m488a();
                        break;
                    }
                case 8:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f669e = jiVar.m488a();
                        break;
                    }
                case 9:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f670f = jiVar.m488a();
                        break;
                    }
                case 10:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f671g = jiVar.m488a();
                        break;
                    }
                case 11:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f664b = jiVar.m482a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f672h = jiVar.m488a();
                        break;
                    }
                case 13:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f673i = jiVar.m488a();
                        break;
                    }
                case 14:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f666c = jiVar.m482a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f674j = jiVar.m488a();
                        break;
                    }
                case 16:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f658a = jiVar.m481a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f675k = jiVar.m488a();
                        break;
                    }
                case 18:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f663b = jiVar.m481a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f676l = jiVar.m488a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f662a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a() {
        return this.f661a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m446a = m446a();
        boolean m446a2 = inVar.m446a();
        if ((m446a || m446a2) && !(m446a && m446a2 && this.f661a.equals(inVar.f661a))) {
            return false;
        }
        boolean m448b = m448b();
        boolean m448b2 = inVar.m448b();
        if ((m448b || m448b2) && !(m448b && m448b2 && this.f660a.m396a(inVar.f660a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f665b.equals(inVar.f665b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f667c.equals(inVar.f667c))) || this.f659a != inVar.f659a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f668d.equals(inVar.f668d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f669e.equals(inVar.f669e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f670f.equals(inVar.f670f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f671g.equals(inVar.f671g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f664b == inVar.f664b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f672h.equals(inVar.f672h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f673i.equals(inVar.f673i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f666c == inVar.f666c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f674j.equals(inVar.f674j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f658a == inVar.f658a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f675k.equals(inVar.f675k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f663b == inVar.f663b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f676l.equals(inVar.f676l));
    }

    public String b() {
        return this.f671g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m445a();
        jiVar.a(f657a);
        if (this.f661a != null && m446a()) {
            jiVar.a(a);
            jiVar.a(this.f661a);
            jiVar.b();
        }
        if (this.f660a != null && m448b()) {
            jiVar.a(b);
            this.f660a.b(jiVar);
            jiVar.b();
        }
        if (this.f665b != null) {
            jiVar.a(c);
            jiVar.a(this.f665b);
            jiVar.b();
        }
        if (this.f667c != null) {
            jiVar.a(d);
            jiVar.a(this.f667c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f659a);
        jiVar.b();
        if (this.f668d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f668d);
            jiVar.b();
        }
        if (this.f669e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f669e);
            jiVar.b();
        }
        if (this.f670f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f670f);
            jiVar.b();
        }
        if (this.f671g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f671g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f664b);
            jiVar.b();
        }
        if (this.f672h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f672h);
            jiVar.b();
        }
        if (this.f673i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f673i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f666c);
            jiVar.b();
        }
        if (this.f674j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f674j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f658a);
            jiVar.b();
        }
        if (this.f675k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f675k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f663b);
            jiVar.b();
        }
        if (this.f676l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f676l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f662a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m448b() {
        return this.f660a != null;
    }

    public void c(boolean z) {
        this.f662a.set(2, z);
    }

    public boolean c() {
        return this.f665b != null;
    }

    public void d(boolean z) {
        this.f662a.set(3, z);
    }

    public boolean d() {
        return this.f667c != null;
    }

    public void e(boolean z) {
        this.f662a.set(4, z);
    }

    public boolean e() {
        return this.f662a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m447a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f668d != null;
    }

    public boolean g() {
        return this.f669e != null;
    }

    public boolean h() {
        return this.f670f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f671g != null;
    }

    public boolean j() {
        return this.f662a.get(1);
    }

    public boolean k() {
        return this.f672h != null;
    }

    public boolean l() {
        return this.f673i != null;
    }

    public boolean m() {
        return this.f662a.get(2);
    }

    public boolean n() {
        return this.f674j != null;
    }

    public boolean o() {
        return this.f662a.get(3);
    }

    public boolean p() {
        return this.f675k != null;
    }

    public boolean q() {
        return this.f662a.get(4);
    }

    public boolean r() {
        return this.f676l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m446a()) {
            sb.append("debug:");
            if (this.f661a == null) {
                sb.append("null");
            } else {
                sb.append(this.f661a);
            }
            z2 = false;
        }
        if (m448b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f660a == null) {
                sb.append("null");
            } else {
                sb.append(this.f660a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f665b == null) {
            sb.append("null");
        } else {
            sb.append(this.f665b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f667c == null) {
            sb.append("null");
        } else {
            sb.append(this.f667c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f659a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f668d == null) {
                sb.append("null");
            } else {
                sb.append(this.f668d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f669e == null) {
                sb.append("null");
            } else {
                sb.append(this.f669e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f670f == null) {
                sb.append("null");
            } else {
                sb.append(this.f670f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f671g == null) {
                sb.append("null");
            } else {
                sb.append(this.f671g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f664b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f672h == null) {
                sb.append("null");
            } else {
                sb.append(this.f672h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f673i == null) {
                sb.append("null");
            } else {
                sb.append(this.f673i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f666c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f674j == null) {
                sb.append("null");
            } else {
                sb.append(this.f674j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f658a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f675k == null) {
                sb.append("null");
            } else {
                sb.append(this.f675k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f663b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f676l == null) {
                sb.append("null");
            } else {
                sb.append(this.f676l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
