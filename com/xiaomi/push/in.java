package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class in implements ix<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f657a;

    /* renamed from: a  reason: collision with other field name */
    public long f658a;

    /* renamed from: a  reason: collision with other field name */
    public ib f659a;

    /* renamed from: a  reason: collision with other field name */
    public String f660a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f661a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f662b;

    /* renamed from: b  reason: collision with other field name */
    public long f663b;

    /* renamed from: b  reason: collision with other field name */
    public String f664b;

    /* renamed from: c  reason: collision with other field name */
    public long f665c;

    /* renamed from: c  reason: collision with other field name */
    public String f666c;

    /* renamed from: d  reason: collision with other field name */
    public String f667d;

    /* renamed from: e  reason: collision with other field name */
    public String f668e;

    /* renamed from: f  reason: collision with other field name */
    public String f669f;

    /* renamed from: g  reason: collision with other field name */
    public String f670g;

    /* renamed from: h  reason: collision with other field name */
    public String f671h;

    /* renamed from: i  reason: collision with other field name */
    public String f672i;

    /* renamed from: j  reason: collision with other field name */
    public String f673j;

    /* renamed from: k  reason: collision with other field name */
    public String f674k;

    /* renamed from: l  reason: collision with other field name */
    public String f675l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f656a = new jn("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4981a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(inVar.m448a()));
            if (compareTo == 0) {
                if (!m448a() || (a19 = iy.a(this.f660a, inVar.f660a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m450b()).compareTo(Boolean.valueOf(inVar.m450b()));
                    if (compareTo2 == 0) {
                        if (!m450b() || (a18 = iy.a(this.f659a, inVar.f659a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a17 = iy.a(this.f664b, inVar.f664b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f666c, inVar.f666c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f658a, inVar.f658a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f667d, inVar.f667d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f668e, inVar.f668e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f669f, inVar.f669f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f670g, inVar.f670g)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f663b, inVar.f663b)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f671h, inVar.f671h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f672i, inVar.f672i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(inVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f665c, inVar.f665c)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(inVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f673j, inVar.f673j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(inVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f657a, inVar.f657a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(inVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f674k, inVar.f674k)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(inVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f662b, inVar.f662b)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(inVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f675l, inVar.f675l)) == 0) {
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
        return this.f658a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m446a() {
        return this.f664b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a() {
        if (this.f664b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f666c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m447a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f660a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f659a = new ib();
                        this.f659a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f664b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f666c = jiVar.m490a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 6:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f658a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f667d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f668e = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f669f = jiVar.m490a();
                        break;
                    }
                case 10:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f670g = jiVar.m490a();
                        break;
                    }
                case 11:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f663b = jiVar.m484a();
                        b(true);
                        break;
                    }
                case 12:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f671h = jiVar.m490a();
                        break;
                    }
                case 13:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f672i = jiVar.m490a();
                        break;
                    }
                case 14:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f665c = jiVar.m484a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f673j = jiVar.m490a();
                        break;
                    }
                case 16:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f657a = jiVar.m483a();
                        d(true);
                        break;
                    }
                case 17:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f674k = jiVar.m490a();
                        break;
                    }
                case 18:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f662b = jiVar.m483a();
                        e(true);
                        break;
                    }
                case 19:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f675l = jiVar.m490a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f661a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f660a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m448a = m448a();
        boolean m448a2 = inVar.m448a();
        if ((m448a || m448a2) && !(m448a && m448a2 && this.f660a.equals(inVar.f660a))) {
            return false;
        }
        boolean m450b = m450b();
        boolean m450b2 = inVar.m450b();
        if ((m450b || m450b2) && !(m450b && m450b2 && this.f659a.m398a(inVar.f659a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f664b.equals(inVar.f664b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f666c.equals(inVar.f666c))) || this.f658a != inVar.f658a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f667d.equals(inVar.f667d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f668e.equals(inVar.f668e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f669f.equals(inVar.f669f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f670g.equals(inVar.f670g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f663b == inVar.f663b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f671h.equals(inVar.f671h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f672i.equals(inVar.f672i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = inVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f665c == inVar.f665c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = inVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f673j.equals(inVar.f673j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = inVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f657a == inVar.f657a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = inVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f674k.equals(inVar.f674k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = inVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f662b == inVar.f662b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = inVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f675l.equals(inVar.f675l));
    }

    public String b() {
        return this.f670g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m447a();
        jiVar.a(f656a);
        if (this.f660a != null && m448a()) {
            jiVar.a(f4981a);
            jiVar.a(this.f660a);
            jiVar.b();
        }
        if (this.f659a != null && m450b()) {
            jiVar.a(b);
            this.f659a.b(jiVar);
            jiVar.b();
        }
        if (this.f664b != null) {
            jiVar.a(c);
            jiVar.a(this.f664b);
            jiVar.b();
        }
        if (this.f666c != null) {
            jiVar.a(d);
            jiVar.a(this.f666c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f658a);
        jiVar.b();
        if (this.f667d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f667d);
            jiVar.b();
        }
        if (this.f668e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f668e);
            jiVar.b();
        }
        if (this.f669f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f669f);
            jiVar.b();
        }
        if (this.f670g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f670g);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f663b);
            jiVar.b();
        }
        if (this.f671h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f671h);
            jiVar.b();
        }
        if (this.f672i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f672i);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f665c);
            jiVar.b();
        }
        if (this.f673j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f673j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f657a);
            jiVar.b();
        }
        if (this.f674k != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f674k);
            jiVar.b();
        }
        if (q()) {
            jiVar.a(q);
            jiVar.a(this.f662b);
            jiVar.b();
        }
        if (this.f675l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f675l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f661a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m450b() {
        return this.f659a != null;
    }

    public void c(boolean z) {
        this.f661a.set(2, z);
    }

    public boolean c() {
        return this.f664b != null;
    }

    public void d(boolean z) {
        this.f661a.set(3, z);
    }

    public boolean d() {
        return this.f666c != null;
    }

    public void e(boolean z) {
        this.f661a.set(4, z);
    }

    public boolean e() {
        return this.f661a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m449a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f667d != null;
    }

    public boolean g() {
        return this.f668e != null;
    }

    public boolean h() {
        return this.f669f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f670g != null;
    }

    public boolean j() {
        return this.f661a.get(1);
    }

    public boolean k() {
        return this.f671h != null;
    }

    public boolean l() {
        return this.f672i != null;
    }

    public boolean m() {
        return this.f661a.get(2);
    }

    public boolean n() {
        return this.f673j != null;
    }

    public boolean o() {
        return this.f661a.get(3);
    }

    public boolean p() {
        return this.f674k != null;
    }

    public boolean q() {
        return this.f661a.get(4);
    }

    public boolean r() {
        return this.f675l != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (m448a()) {
            sb.append("debug:");
            if (this.f660a == null) {
                sb.append("null");
            } else {
                sb.append(this.f660a);
            }
            z2 = false;
        }
        if (m450b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f659a == null) {
                sb.append("null");
            } else {
                sb.append(this.f659a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f664b == null) {
            sb.append("null");
        } else {
            sb.append(this.f664b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f666c == null) {
            sb.append("null");
        } else {
            sb.append(this.f666c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f658a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f667d == null) {
                sb.append("null");
            } else {
                sb.append(this.f667d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f668e == null) {
                sb.append("null");
            } else {
                sb.append(this.f668e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f669f == null) {
                sb.append("null");
            } else {
                sb.append(this.f669f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f670g == null) {
                sb.append("null");
            } else {
                sb.append(this.f670g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f663b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f671h == null) {
                sb.append("null");
            } else {
                sb.append(this.f671h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.f672i == null) {
                sb.append("null");
            } else {
                sb.append(this.f672i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f665c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f673j == null) {
                sb.append("null");
            } else {
                sb.append(this.f673j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f657a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.f674k == null) {
                sb.append("null");
            } else {
                sb.append(this.f674k);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f662b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            if (this.f675l == null) {
                sb.append("null");
            } else {
                sb.append(this.f675l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
