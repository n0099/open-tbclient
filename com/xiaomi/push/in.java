package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f664a;

    /* renamed from: a  reason: collision with other field name */
    public long f665a;

    /* renamed from: a  reason: collision with other field name */
    public ib f666a;

    /* renamed from: a  reason: collision with other field name */
    public String f667a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f668a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f669b;

    /* renamed from: b  reason: collision with other field name */
    public long f670b;

    /* renamed from: b  reason: collision with other field name */
    public String f671b;

    /* renamed from: c  reason: collision with other field name */
    public long f672c;

    /* renamed from: c  reason: collision with other field name */
    public String f673c;

    /* renamed from: d  reason: collision with other field name */
    public String f674d;

    /* renamed from: e  reason: collision with other field name */
    public String f675e;

    /* renamed from: f  reason: collision with other field name */
    public String f676f;

    /* renamed from: g  reason: collision with other field name */
    public String f677g;

    /* renamed from: h  reason: collision with other field name */
    public String f678h;

    /* renamed from: i  reason: collision with other field name */
    public String f679i;

    /* renamed from: j  reason: collision with other field name */
    public String f680j;

    /* renamed from: k  reason: collision with other field name */
    public String f681k;

    /* renamed from: l  reason: collision with other field name */
    public String f682l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f663a = new jn("XmPushActionRegistrationResult");
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
            int compareTo = Boolean.valueOf(m443a()).compareTo(Boolean.valueOf(inVar.m443a()));
            if (compareTo == 0) {
                if (!m443a() || (a19 = iy.a(this.f667a, inVar.f667a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m445b()).compareTo(Boolean.valueOf(inVar.m445b()));
                    if (compareTo2 == 0) {
                        if (!m445b() || (a18 = iy.a(this.f666a, inVar.f666a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f671b, inVar.f671b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f673c, inVar.f673c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f665a, inVar.f665a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f674d, inVar.f674d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f675e, inVar.f675e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f676f, inVar.f676f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f677g, inVar.f677g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f670b, inVar.f670b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f678h, inVar.f678h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f679i, inVar.f679i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f672c, inVar.f672c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f680j, inVar.f680j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f664a, inVar.f664a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f681k, inVar.f681k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f669b, inVar.f669b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f682l, inVar.f682l)) == 0) {
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
        return this.f665a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m441a() {
        return this.f671b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m442a() {
        if (this.f671b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f673c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m442a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f667a = jiVar.m485a();
                        break;
                    }
                case 2:
                    if (m480a.a != 12) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f666a = new ib();
                        this.f666a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f671b = jiVar.m485a();
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f673c = jiVar.m485a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m480a.a);
                    break;
                case 6:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f665a = jiVar.m479a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f674d = jiVar.m485a();
                        break;
                    }
                case 8:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f675e = jiVar.m485a();
                        break;
                    }
                case 9:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f676f = jiVar.m485a();
                        break;
                    }
                case 10:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f677g = jiVar.m485a();
                        break;
                    }
                case 11:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f670b = jiVar.m479a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f678h = jiVar.m485a();
                        break;
                    }
                case 13:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f679i = jiVar.m485a();
                        break;
                    }
                case 14:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f672c = jiVar.m479a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f680j = jiVar.m485a();
                        break;
                    }
                case 16:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f664a = jiVar.m478a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f681k = jiVar.m485a();
                        break;
                    }
                case 18:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f669b = jiVar.m478a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f682l = jiVar.m485a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f668a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a() {
        return this.f667a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m443a = m443a();
        boolean m443a2 = inVar.m443a();
        if ((m443a || m443a2) && !(m443a && m443a2 && this.f667a.equals(inVar.f667a))) {
            return false;
        }
        boolean m445b = m445b();
        boolean m445b2 = inVar.m445b();
        if ((m445b || m445b2) && !(m445b && m445b2 && this.f666a.m393a(inVar.f666a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f671b.equals(inVar.f671b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f673c.equals(inVar.f673c))) || this.f665a != inVar.f665a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f674d.equals(inVar.f674d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f675e.equals(inVar.f675e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f676f.equals(inVar.f676f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f677g.equals(inVar.f677g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f670b == inVar.f670b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f678h.equals(inVar.f678h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f679i.equals(inVar.f679i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f672c == inVar.f672c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f680j.equals(inVar.f680j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f664a == inVar.f664a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f681k.equals(inVar.f681k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f669b == inVar.f669b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f682l.equals(inVar.f682l));
    }

    public String b() {
        return this.f677g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m442a();
        jiVar.a(f663a);
        if (this.f667a != null && m443a()) {
            jiVar.a(a);
            jiVar.a(this.f667a);
            jiVar.b();
        }
        if (this.f666a != null && m445b()) {
            jiVar.a(b);
            this.f666a.b(jiVar);
            jiVar.b();
        }
        if (this.f671b != null) {
            jiVar.a(c);
            jiVar.a(this.f671b);
            jiVar.b();
        }
        if (this.f673c != null) {
            jiVar.a(d);
            jiVar.a(this.f673c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f665a);
        jiVar.b();
        if (this.f674d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f674d);
            jiVar.b();
        }
        if (this.f675e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f675e);
            jiVar.b();
        }
        if (this.f676f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f676f);
            jiVar.b();
        }
        if (this.f677g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f677g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f670b);
            jiVar.b();
        }
        if (this.f678h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f678h);
            jiVar.b();
        }
        if (this.f679i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f679i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f672c);
            jiVar.b();
        }
        if (this.f680j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f680j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f664a);
            jiVar.b();
        }
        if (this.f681k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f681k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f669b);
            jiVar.b();
        }
        if (this.f682l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f682l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f668a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m445b() {
        return this.f666a != null;
    }

    public void c(boolean z) {
        this.f668a.set(2, z);
    }

    public boolean c() {
        return this.f671b != null;
    }

    public void d(boolean z) {
        this.f668a.set(3, z);
    }

    public boolean d() {
        return this.f673c != null;
    }

    public void e(boolean z) {
        this.f668a.set(4, z);
    }

    public boolean e() {
        return this.f668a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m444a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f674d != null;
    }

    public boolean g() {
        return this.f675e != null;
    }

    public boolean h() {
        return this.f676f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f677g != null;
    }

    public boolean j() {
        return this.f668a.get(1);
    }

    public boolean k() {
        return this.f678h != null;
    }

    public boolean l() {
        return this.f679i != null;
    }

    public boolean m() {
        return this.f668a.get(2);
    }

    public boolean n() {
        return this.f680j != null;
    }

    public boolean o() {
        return this.f668a.get(3);
    }

    public boolean p() {
        return this.f681k != null;
    }

    public boolean q() {
        return this.f668a.get(4);
    }

    public boolean r() {
        return this.f682l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m443a()) {
            sb.append("debug:");
            if (this.f667a == null) {
                sb.append("null");
            } else {
                sb.append(this.f667a);
            }
            z2 = false;
        }
        if (m445b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f666a == null) {
                sb.append("null");
            } else {
                sb.append(this.f666a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f671b == null) {
            sb.append("null");
        } else {
            sb.append(this.f671b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f673c == null) {
            sb.append("null");
        } else {
            sb.append(this.f673c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f665a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f674d == null) {
                sb.append("null");
            } else {
                sb.append(this.f674d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f675e == null) {
                sb.append("null");
            } else {
                sb.append(this.f675e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f676f == null) {
                sb.append("null");
            } else {
                sb.append(this.f676f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f677g == null) {
                sb.append("null");
            } else {
                sb.append(this.f677g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f670b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f678h == null) {
                sb.append("null");
            } else {
                sb.append(this.f678h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f679i == null) {
                sb.append("null");
            } else {
                sb.append(this.f679i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f672c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f680j == null) {
                sb.append("null");
            } else {
                sb.append(this.f680j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f664a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f681k == null) {
                sb.append("null");
            } else {
                sb.append(this.f681k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f669b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f682l == null) {
                sb.append("null");
            } else {
                sb.append(this.f682l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
