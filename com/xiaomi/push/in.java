package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f660a;

    /* renamed from: a  reason: collision with other field name */
    public long f661a;

    /* renamed from: a  reason: collision with other field name */
    public ib f662a;

    /* renamed from: a  reason: collision with other field name */
    public String f663a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f664a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f665b;

    /* renamed from: b  reason: collision with other field name */
    public long f666b;

    /* renamed from: b  reason: collision with other field name */
    public String f667b;

    /* renamed from: c  reason: collision with other field name */
    public long f668c;

    /* renamed from: c  reason: collision with other field name */
    public String f669c;

    /* renamed from: d  reason: collision with other field name */
    public String f670d;

    /* renamed from: e  reason: collision with other field name */
    public String f671e;

    /* renamed from: f  reason: collision with other field name */
    public String f672f;

    /* renamed from: g  reason: collision with other field name */
    public String f673g;

    /* renamed from: h  reason: collision with other field name */
    public String f674h;

    /* renamed from: i  reason: collision with other field name */
    public String f675i;

    /* renamed from: j  reason: collision with other field name */
    public String f676j;

    /* renamed from: k  reason: collision with other field name */
    public String f677k;

    /* renamed from: l  reason: collision with other field name */
    public String f678l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f659a = new jn("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4753a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m441a()).compareTo(Boolean.valueOf(inVar.m441a()));
            if (compareTo == 0) {
                if (!m441a() || (a19 = iy.a(this.f663a, inVar.f663a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m443b()).compareTo(Boolean.valueOf(inVar.m443b()));
                    if (compareTo2 == 0) {
                        if (!m443b() || (a18 = iy.a(this.f662a, inVar.f662a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f667b, inVar.f667b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f669c, inVar.f669c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f661a, inVar.f661a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f670d, inVar.f670d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f671e, inVar.f671e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f672f, inVar.f672f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f673g, inVar.f673g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f666b, inVar.f666b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f674h, inVar.f674h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f675i, inVar.f675i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f668c, inVar.f668c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f676j, inVar.f676j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f660a, inVar.f660a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f677k, inVar.f677k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f665b, inVar.f665b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f678l, inVar.f678l)) == 0) {
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
        return this.f661a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m439a() {
        return this.f667b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m440a() {
        if (this.f667b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f669c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m440a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f663a = jiVar.m483a();
                        break;
                    }
                case 2:
                    if (m478a.f4770a != 12) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f662a = new ib();
                        this.f662a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f667b = jiVar.m483a();
                        break;
                    }
                case 4:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f669c = jiVar.m483a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
                case 6:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f661a = jiVar.m477a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f670d = jiVar.m483a();
                        break;
                    }
                case 8:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f671e = jiVar.m483a();
                        break;
                    }
                case 9:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f672f = jiVar.m483a();
                        break;
                    }
                case 10:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f673g = jiVar.m483a();
                        break;
                    }
                case 11:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f666b = jiVar.m477a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f674h = jiVar.m483a();
                        break;
                    }
                case 13:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f675i = jiVar.m483a();
                        break;
                    }
                case 14:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f668c = jiVar.m477a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f676j = jiVar.m483a();
                        break;
                    }
                case 16:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f660a = jiVar.m476a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f677k = jiVar.m483a();
                        break;
                    }
                case 18:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f665b = jiVar.m476a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f678l = jiVar.m483a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f664a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a() {
        return this.f663a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m441a = m441a();
        boolean m441a2 = inVar.m441a();
        if ((m441a || m441a2) && !(m441a && m441a2 && this.f663a.equals(inVar.f663a))) {
            return false;
        }
        boolean m443b = m443b();
        boolean m443b2 = inVar.m443b();
        if ((m443b || m443b2) && !(m443b && m443b2 && this.f662a.m391a(inVar.f662a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f667b.equals(inVar.f667b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f669c.equals(inVar.f669c))) || this.f661a != inVar.f661a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f670d.equals(inVar.f670d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f671e.equals(inVar.f671e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f672f.equals(inVar.f672f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f673g.equals(inVar.f673g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f666b == inVar.f666b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f674h.equals(inVar.f674h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f675i.equals(inVar.f675i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f668c == inVar.f668c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f676j.equals(inVar.f676j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f660a == inVar.f660a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f677k.equals(inVar.f677k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f665b == inVar.f665b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f678l.equals(inVar.f678l));
    }

    public String b() {
        return this.f673g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m440a();
        jiVar.a(f659a);
        if (this.f663a != null && m441a()) {
            jiVar.a(f4753a);
            jiVar.a(this.f663a);
            jiVar.b();
        }
        if (this.f662a != null && m443b()) {
            jiVar.a(b);
            this.f662a.b(jiVar);
            jiVar.b();
        }
        if (this.f667b != null) {
            jiVar.a(c);
            jiVar.a(this.f667b);
            jiVar.b();
        }
        if (this.f669c != null) {
            jiVar.a(d);
            jiVar.a(this.f669c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f661a);
        jiVar.b();
        if (this.f670d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f670d);
            jiVar.b();
        }
        if (this.f671e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f671e);
            jiVar.b();
        }
        if (this.f672f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f672f);
            jiVar.b();
        }
        if (this.f673g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f673g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f666b);
            jiVar.b();
        }
        if (this.f674h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f674h);
            jiVar.b();
        }
        if (this.f675i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f675i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f668c);
            jiVar.b();
        }
        if (this.f676j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f676j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f660a);
            jiVar.b();
        }
        if (this.f677k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f677k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f665b);
            jiVar.b();
        }
        if (this.f678l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f678l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public void b(boolean z) {
        this.f664a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m443b() {
        return this.f662a != null;
    }

    public void c(boolean z) {
        this.f664a.set(2, z);
    }

    public boolean c() {
        return this.f667b != null;
    }

    public void d(boolean z) {
        this.f664a.set(3, z);
    }

    public boolean d() {
        return this.f669c != null;
    }

    public void e(boolean z) {
        this.f664a.set(4, z);
    }

    public boolean e() {
        return this.f664a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m442a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f670d != null;
    }

    public boolean g() {
        return this.f671e != null;
    }

    public boolean h() {
        return this.f672f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f673g != null;
    }

    public boolean j() {
        return this.f664a.get(1);
    }

    public boolean k() {
        return this.f674h != null;
    }

    public boolean l() {
        return this.f675i != null;
    }

    public boolean m() {
        return this.f664a.get(2);
    }

    public boolean n() {
        return this.f676j != null;
    }

    public boolean o() {
        return this.f664a.get(3);
    }

    public boolean p() {
        return this.f677k != null;
    }

    public boolean q() {
        return this.f664a.get(4);
    }

    public boolean r() {
        return this.f678l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m441a()) {
            sb.append("debug:");
            if (this.f663a == null) {
                sb.append("null");
            } else {
                sb.append(this.f663a);
            }
            z2 = false;
        }
        if (m443b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f662a == null) {
                sb.append("null");
            } else {
                sb.append(this.f662a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f667b == null) {
            sb.append("null");
        } else {
            sb.append(this.f667b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f669c == null) {
            sb.append("null");
        } else {
            sb.append(this.f669c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f661a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f670d == null) {
                sb.append("null");
            } else {
                sb.append(this.f670d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f671e == null) {
                sb.append("null");
            } else {
                sb.append(this.f671e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f672f == null) {
                sb.append("null");
            } else {
                sb.append(this.f672f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f673g == null) {
                sb.append("null");
            } else {
                sb.append(this.f673g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f666b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f674h == null) {
                sb.append("null");
            } else {
                sb.append(this.f674h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f675i == null) {
                sb.append("null");
            } else {
                sb.append(this.f675i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f668c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f676j == null) {
                sb.append("null");
            } else {
                sb.append(this.f676j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f660a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f677k == null) {
                sb.append("null");
            } else {
                sb.append(this.f677k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f665b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f678l == null) {
                sb.append("null");
            } else {
                sb.append(this.f678l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
