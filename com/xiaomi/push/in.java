package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f665a;

    /* renamed from: a  reason: collision with other field name */
    public long f666a;

    /* renamed from: a  reason: collision with other field name */
    public ib f667a;

    /* renamed from: a  reason: collision with other field name */
    public String f668a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f669a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f670b;

    /* renamed from: b  reason: collision with other field name */
    public long f671b;

    /* renamed from: b  reason: collision with other field name */
    public String f672b;

    /* renamed from: c  reason: collision with other field name */
    public long f673c;

    /* renamed from: c  reason: collision with other field name */
    public String f674c;

    /* renamed from: d  reason: collision with other field name */
    public String f675d;

    /* renamed from: e  reason: collision with other field name */
    public String f676e;

    /* renamed from: f  reason: collision with other field name */
    public String f677f;

    /* renamed from: g  reason: collision with other field name */
    public String f678g;

    /* renamed from: h  reason: collision with other field name */
    public String f679h;

    /* renamed from: i  reason: collision with other field name */
    public String f680i;

    /* renamed from: j  reason: collision with other field name */
    public String f681j;

    /* renamed from: k  reason: collision with other field name */
    public String f682k;

    /* renamed from: l  reason: collision with other field name */
    public String f683l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f664a = new jn("XmPushActionRegistrationResult");
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
            int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(inVar.m442a()));
            if (compareTo == 0) {
                if (!m442a() || (a19 = iy.a(this.f668a, inVar.f668a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m444b()).compareTo(Boolean.valueOf(inVar.m444b()));
                    if (compareTo2 == 0) {
                        if (!m444b() || (a18 = iy.a(this.f667a, inVar.f667a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f672b, inVar.f672b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f674c, inVar.f674c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f666a, inVar.f666a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f675d, inVar.f675d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f676e, inVar.f676e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f677f, inVar.f677f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f678g, inVar.f678g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f671b, inVar.f671b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f679h, inVar.f679h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f680i, inVar.f680i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f673c, inVar.f673c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f681j, inVar.f681j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f665a, inVar.f665a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f682k, inVar.f682k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f670b, inVar.f670b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f683l, inVar.f683l)) == 0) {
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
        return this.f666a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m440a() {
        return this.f672b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m441a() {
        if (this.f672b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f674c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m441a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f668a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f667a = new ib();
                        this.f667a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f672b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f674c = jiVar.m484a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 6:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f666a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f675d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f676e = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f677f = jiVar.m484a();
                        break;
                    }
                case 10:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f678g = jiVar.m484a();
                        break;
                    }
                case 11:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f671b = jiVar.m478a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f679h = jiVar.m484a();
                        break;
                    }
                case 13:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f680i = jiVar.m484a();
                        break;
                    }
                case 14:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f673c = jiVar.m478a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f681j = jiVar.m484a();
                        break;
                    }
                case 16:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f665a = jiVar.m477a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f682k = jiVar.m484a();
                        break;
                    }
                case 18:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f670b = jiVar.m477a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f683l = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f669a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        return this.f668a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m442a = m442a();
        boolean m442a2 = inVar.m442a();
        if ((m442a || m442a2) && !(m442a && m442a2 && this.f668a.equals(inVar.f668a))) {
            return false;
        }
        boolean m444b = m444b();
        boolean m444b2 = inVar.m444b();
        if ((m444b || m444b2) && !(m444b && m444b2 && this.f667a.m392a(inVar.f667a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f672b.equals(inVar.f672b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f674c.equals(inVar.f674c))) || this.f666a != inVar.f666a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f675d.equals(inVar.f675d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f676e.equals(inVar.f676e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f677f.equals(inVar.f677f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f678g.equals(inVar.f678g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f671b == inVar.f671b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f679h.equals(inVar.f679h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f680i.equals(inVar.f680i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f673c == inVar.f673c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f681j.equals(inVar.f681j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f665a == inVar.f665a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f682k.equals(inVar.f682k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f670b == inVar.f670b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f683l.equals(inVar.f683l));
    }

    public String b() {
        return this.f678g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m441a();
        jiVar.a(f664a);
        if (this.f668a != null && m442a()) {
            jiVar.a(a);
            jiVar.a(this.f668a);
            jiVar.b();
        }
        if (this.f667a != null && m444b()) {
            jiVar.a(b);
            this.f667a.b(jiVar);
            jiVar.b();
        }
        if (this.f672b != null) {
            jiVar.a(c);
            jiVar.a(this.f672b);
            jiVar.b();
        }
        if (this.f674c != null) {
            jiVar.a(d);
            jiVar.a(this.f674c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f666a);
        jiVar.b();
        if (this.f675d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f675d);
            jiVar.b();
        }
        if (this.f676e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f676e);
            jiVar.b();
        }
        if (this.f677f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f677f);
            jiVar.b();
        }
        if (this.f678g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f678g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f671b);
            jiVar.b();
        }
        if (this.f679h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f679h);
            jiVar.b();
        }
        if (this.f680i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f680i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f673c);
            jiVar.b();
        }
        if (this.f681j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f681j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f665a);
            jiVar.b();
        }
        if (this.f682k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f682k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f670b);
            jiVar.b();
        }
        if (this.f683l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f683l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f669a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m444b() {
        return this.f667a != null;
    }

    public void c(boolean z) {
        this.f669a.set(2, z);
    }

    public boolean c() {
        return this.f672b != null;
    }

    public void d(boolean z) {
        this.f669a.set(3, z);
    }

    public boolean d() {
        return this.f674c != null;
    }

    public void e(boolean z) {
        this.f669a.set(4, z);
    }

    public boolean e() {
        return this.f669a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m443a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f675d != null;
    }

    public boolean g() {
        return this.f676e != null;
    }

    public boolean h() {
        return this.f677f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f678g != null;
    }

    public boolean j() {
        return this.f669a.get(1);
    }

    public boolean k() {
        return this.f679h != null;
    }

    public boolean l() {
        return this.f680i != null;
    }

    public boolean m() {
        return this.f669a.get(2);
    }

    public boolean n() {
        return this.f681j != null;
    }

    public boolean o() {
        return this.f669a.get(3);
    }

    public boolean p() {
        return this.f682k != null;
    }

    public boolean q() {
        return this.f669a.get(4);
    }

    public boolean r() {
        return this.f683l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m442a()) {
            sb.append("debug:");
            if (this.f668a == null) {
                sb.append("null");
            } else {
                sb.append(this.f668a);
            }
            z2 = false;
        }
        if (m444b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f667a == null) {
                sb.append("null");
            } else {
                sb.append(this.f667a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f672b == null) {
            sb.append("null");
        } else {
            sb.append(this.f672b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f674c == null) {
            sb.append("null");
        } else {
            sb.append(this.f674c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f666a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f675d == null) {
                sb.append("null");
            } else {
                sb.append(this.f675d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f676e == null) {
                sb.append("null");
            } else {
                sb.append(this.f676e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f677f == null) {
                sb.append("null");
            } else {
                sb.append(this.f677f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f678g == null) {
                sb.append("null");
            } else {
                sb.append(this.f678g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f671b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f679h == null) {
                sb.append("null");
            } else {
                sb.append(this.f679h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f680i == null) {
                sb.append("null");
            } else {
                sb.append(this.f680i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f673c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f681j == null) {
                sb.append("null");
            } else {
                sb.append(this.f681j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f665a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f682k == null) {
                sb.append("null");
            } else {
                sb.append(this.f682k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f670b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f683l == null) {
                sb.append("null");
            } else {
                sb.append(this.f683l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
