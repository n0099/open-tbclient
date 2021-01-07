package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f802a;

    /* renamed from: a  reason: collision with other field name */
    public ib f803a;

    /* renamed from: a  reason: collision with other field name */
    public String f804a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f805a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f806a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f807b;

    /* renamed from: c  reason: collision with other field name */
    public String f808c;

    /* renamed from: d  reason: collision with other field name */
    public String f809d;

    /* renamed from: e  reason: collision with other field name */
    public String f810e;

    /* renamed from: f  reason: collision with other field name */
    public String f811f;

    /* renamed from: g  reason: collision with other field name */
    public String f812g;

    /* renamed from: h  reason: collision with other field name */
    public String f813h;

    /* renamed from: i  reason: collision with other field name */
    public String f814i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f801a = new jn("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14453a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14454b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", (byte) 2, 11);
    private static final jf l = new jf("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(is isVar) {
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
        if (getClass().equals(isVar.getClass())) {
            int compareTo = Boolean.valueOf(m498a()).compareTo(Boolean.valueOf(isVar.m498a()));
            if (compareTo == 0) {
                if (!m498a() || (a13 = iy.a(this.f804a, isVar.f804a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f803a, isVar.f803a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f807b, isVar.f807b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f808c, isVar.f808c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f809d, isVar.f809d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f810e, isVar.f810e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f811f, isVar.f811f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f812g, isVar.f812g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f813h, isVar.f813h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f814i, isVar.f814i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f806a, isVar.f806a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f802a, isVar.f802a)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a2;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a3;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a4;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a5;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a7;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a8;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a9;
                                            }
                                            return compareTo5;
                                        }
                                        return a10;
                                    }
                                    return compareTo4;
                                }
                                return a11;
                            }
                            return compareTo3;
                        }
                        return a12;
                    }
                    return compareTo2;
                }
                return a13;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(isVar.getClass().getName());
    }

    public is a(String str) {
        this.f807b = str;
        return this;
    }

    public void a() {
        if (this.f807b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f808c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f804a = jiVar.m520a();
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f803a = new ib();
                        this.f803a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f807b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f808c = jiVar.m520a();
                        break;
                    }
                case 5:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f809d = jiVar.m520a();
                        break;
                    }
                case 6:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f810e = jiVar.m520a();
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f811f = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f812g = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f813h = jiVar.m520a();
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f814i = jiVar.m520a();
                        break;
                    }
                case 11:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f806a = jiVar.m524a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f802a = jiVar.m514a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f805a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m498a() {
        return this.f804a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m499a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m498a = m498a();
        boolean m498a2 = isVar.m498a();
        if ((m498a || m498a2) && !(m498a && m498a2 && this.f804a.equals(isVar.f804a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f803a.m428a(isVar.f803a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f807b.equals(isVar.f807b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f808c.equals(isVar.f808c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f809d.equals(isVar.f809d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f810e.equals(isVar.f810e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f811f.equals(isVar.f811f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f812g.equals(isVar.f812g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f813h.equals(isVar.f813h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f814i.equals(isVar.f814i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f806a == isVar.f806a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f802a == isVar.f802a);
    }

    public is b(String str) {
        this.f808c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f801a);
        if (this.f804a != null && m498a()) {
            jiVar.a(f14453a);
            jiVar.a(this.f804a);
            jiVar.b();
        }
        if (this.f803a != null && b()) {
            jiVar.a(f14454b);
            this.f803a.b(jiVar);
            jiVar.b();
        }
        if (this.f807b != null) {
            jiVar.a(c);
            jiVar.a(this.f807b);
            jiVar.b();
        }
        if (this.f808c != null) {
            jiVar.a(d);
            jiVar.a(this.f808c);
            jiVar.b();
        }
        if (this.f809d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f809d);
            jiVar.b();
        }
        if (this.f810e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f810e);
            jiVar.b();
        }
        if (this.f811f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f811f);
            jiVar.b();
        }
        if (this.f812g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f812g);
            jiVar.b();
        }
        if (this.f813h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f813h);
            jiVar.b();
        }
        if (this.f814i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f814i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f806a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f802a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f805a.set(1, z);
    }

    public boolean b() {
        return this.f803a != null;
    }

    public is c(String str) {
        this.f809d = str;
        return this;
    }

    public boolean c() {
        return this.f807b != null;
    }

    public is d(String str) {
        this.f811f = str;
        return this;
    }

    public boolean d() {
        return this.f808c != null;
    }

    public is e(String str) {
        this.f812g = str;
        return this;
    }

    public boolean e() {
        return this.f809d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m499a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f810e != null;
    }

    public boolean g() {
        return this.f811f != null;
    }

    public boolean h() {
        return this.f812g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f813h != null;
    }

    public boolean j() {
        return this.f814i != null;
    }

    public boolean k() {
        return this.f805a.get(0);
    }

    public boolean l() {
        return this.f805a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m498a()) {
            sb.append("debug:");
            if (this.f804a == null) {
                sb.append("null");
            } else {
                sb.append(this.f804a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f803a == null) {
                sb.append("null");
            } else {
                sb.append(this.f803a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f807b == null) {
            sb.append("null");
        } else {
            sb.append(this.f807b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f808c == null) {
            sb.append("null");
        } else {
            sb.append(this.f808c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f809d == null) {
                sb.append("null");
            } else {
                sb.append(this.f809d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f810e == null) {
                sb.append("null");
            } else {
                sb.append(this.f810e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f811f == null) {
                sb.append("null");
            } else {
                sb.append(this.f811f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f812g == null) {
                sb.append("null");
            } else {
                sb.append(this.f812g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f813h == null) {
                sb.append("null");
            } else {
                sb.append(this.f813h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f814i == null) {
                sb.append("null");
            } else {
                sb.append(this.f814i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f806a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f802a);
        }
        sb.append(")");
        return sb.toString();
    }
}
