package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f727a;

    /* renamed from: a  reason: collision with other field name */
    public ib f728a;

    /* renamed from: a  reason: collision with other field name */
    public String f729a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f730a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f731a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f732b;

    /* renamed from: c  reason: collision with other field name */
    public String f733c;

    /* renamed from: d  reason: collision with other field name */
    public String f734d;

    /* renamed from: e  reason: collision with other field name */
    public String f735e;

    /* renamed from: f  reason: collision with other field name */
    public String f736f;

    /* renamed from: g  reason: collision with other field name */
    public String f737g;

    /* renamed from: h  reason: collision with other field name */
    public String f738h;

    /* renamed from: i  reason: collision with other field name */
    public String f739i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f726a = new jn("XmPushActionUnRegistration");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m463a()).compareTo(Boolean.valueOf(isVar.m463a()));
            if (compareTo == 0) {
                if (!m463a() || (a13 = iy.a(this.f729a, isVar.f729a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f728a, isVar.f728a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f732b, isVar.f732b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f733c, isVar.f733c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f734d, isVar.f734d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f735e, isVar.f735e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f736f, isVar.f736f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f737g, isVar.f737g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f738h, isVar.f738h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f739i, isVar.f739i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f731a, isVar.f731a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f727a, isVar.f727a)) == 0) {
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
        this.f732b = str;
        return this;
    }

    public void a() {
        if (this.f732b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f733c == null) {
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
                a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f729a = jiVar.m485a();
                        break;
                    }
                case 2:
                    if (m480a.a != 12) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f728a = new ib();
                        this.f728a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f732b = jiVar.m485a();
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f733c = jiVar.m485a();
                        break;
                    }
                case 5:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f734d = jiVar.m485a();
                        break;
                    }
                case 6:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f735e = jiVar.m485a();
                        break;
                    }
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f736f = jiVar.m485a();
                        break;
                    }
                case 8:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f737g = jiVar.m485a();
                        break;
                    }
                case 9:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f738h = jiVar.m485a();
                        break;
                    }
                case 10:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f739i = jiVar.m485a();
                        break;
                    }
                case 11:
                    if (m480a.a != 2) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f731a = jiVar.m489a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f727a = jiVar.m479a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f730a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a() {
        return this.f729a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m464a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m463a = m463a();
        boolean m463a2 = isVar.m463a();
        if ((m463a || m463a2) && !(m463a && m463a2 && this.f729a.equals(isVar.f729a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f728a.m393a(isVar.f728a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f732b.equals(isVar.f732b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f733c.equals(isVar.f733c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f734d.equals(isVar.f734d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f735e.equals(isVar.f735e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f736f.equals(isVar.f736f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f737g.equals(isVar.f737g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f738h.equals(isVar.f738h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f739i.equals(isVar.f739i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f731a == isVar.f731a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f727a == isVar.f727a);
    }

    public is b(String str) {
        this.f733c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f726a);
        if (this.f729a != null && m463a()) {
            jiVar.a(a);
            jiVar.a(this.f729a);
            jiVar.b();
        }
        if (this.f728a != null && b()) {
            jiVar.a(b);
            this.f728a.b(jiVar);
            jiVar.b();
        }
        if (this.f732b != null) {
            jiVar.a(c);
            jiVar.a(this.f732b);
            jiVar.b();
        }
        if (this.f733c != null) {
            jiVar.a(d);
            jiVar.a(this.f733c);
            jiVar.b();
        }
        if (this.f734d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f734d);
            jiVar.b();
        }
        if (this.f735e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f735e);
            jiVar.b();
        }
        if (this.f736f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f736f);
            jiVar.b();
        }
        if (this.f737g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f737g);
            jiVar.b();
        }
        if (this.f738h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f738h);
            jiVar.b();
        }
        if (this.f739i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f739i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f731a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f727a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f730a.set(1, z);
    }

    public boolean b() {
        return this.f728a != null;
    }

    public is c(String str) {
        this.f734d = str;
        return this;
    }

    public boolean c() {
        return this.f732b != null;
    }

    public is d(String str) {
        this.f736f = str;
        return this;
    }

    public boolean d() {
        return this.f733c != null;
    }

    public is e(String str) {
        this.f737g = str;
        return this;
    }

    public boolean e() {
        return this.f734d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m464a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f735e != null;
    }

    public boolean g() {
        return this.f736f != null;
    }

    public boolean h() {
        return this.f737g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f738h != null;
    }

    public boolean j() {
        return this.f739i != null;
    }

    public boolean k() {
        return this.f730a.get(0);
    }

    public boolean l() {
        return this.f730a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m463a()) {
            sb.append("debug:");
            if (this.f729a == null) {
                sb.append("null");
            } else {
                sb.append(this.f729a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f728a == null) {
                sb.append("null");
            } else {
                sb.append(this.f728a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f732b == null) {
            sb.append("null");
        } else {
            sb.append(this.f732b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f733c == null) {
            sb.append("null");
        } else {
            sb.append(this.f733c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f734d == null) {
                sb.append("null");
            } else {
                sb.append(this.f734d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f735e == null) {
                sb.append("null");
            } else {
                sb.append(this.f735e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f736f == null) {
                sb.append("null");
            } else {
                sb.append(this.f736f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f737g == null) {
                sb.append("null");
            } else {
                sb.append(this.f737g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f738h == null) {
                sb.append("null");
            } else {
                sb.append(this.f738h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f739i == null) {
                sb.append("null");
            } else {
                sb.append(this.f739i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f731a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f727a);
        }
        sb.append(")");
        return sb.toString();
    }
}
