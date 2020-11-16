package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f725a;

    /* renamed from: a  reason: collision with other field name */
    public ib f726a;

    /* renamed from: a  reason: collision with other field name */
    public String f727a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f728a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f729a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f730b;

    /* renamed from: c  reason: collision with other field name */
    public String f731c;

    /* renamed from: d  reason: collision with other field name */
    public String f732d;

    /* renamed from: e  reason: collision with other field name */
    public String f733e;

    /* renamed from: f  reason: collision with other field name */
    public String f734f;

    /* renamed from: g  reason: collision with other field name */
    public String f735g;

    /* renamed from: h  reason: collision with other field name */
    public String f736h;

    /* renamed from: i  reason: collision with other field name */
    public String f737i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f724a = new jn("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4988a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m471a()).compareTo(Boolean.valueOf(isVar.m471a()));
            if (compareTo == 0) {
                if (!m471a() || (a13 = iy.a(this.f727a, isVar.f727a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f726a, isVar.f726a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f730b, isVar.f730b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f731c, isVar.f731c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f732d, isVar.f732d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f733e, isVar.f733e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f734f, isVar.f734f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f735g, isVar.f735g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f736h, isVar.f736h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f737i, isVar.f737i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f729a, isVar.f729a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f725a, isVar.f725a)) == 0) {
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
        this.f730b = str;
        return this;
    }

    public void a() {
        if (this.f730b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f731c == null) {
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
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f727a = jiVar.m493a();
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f726a = new ib();
                        this.f726a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f730b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f731c = jiVar.m493a();
                        break;
                    }
                case 5:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f732d = jiVar.m493a();
                        break;
                    }
                case 6:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f733e = jiVar.m493a();
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f734f = jiVar.m493a();
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f735g = jiVar.m493a();
                        break;
                    }
                case 9:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f736h = jiVar.m493a();
                        break;
                    }
                case 10:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f737i = jiVar.m493a();
                        break;
                    }
                case 11:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f729a = jiVar.m497a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f725a = jiVar.m487a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f728a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a() {
        return this.f727a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m471a = m471a();
        boolean m471a2 = isVar.m471a();
        if ((m471a || m471a2) && !(m471a && m471a2 && this.f727a.equals(isVar.f727a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f726a.m401a(isVar.f726a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f730b.equals(isVar.f730b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f731c.equals(isVar.f731c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f732d.equals(isVar.f732d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f733e.equals(isVar.f733e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f734f.equals(isVar.f734f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f735g.equals(isVar.f735g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f736h.equals(isVar.f736h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f737i.equals(isVar.f737i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f729a == isVar.f729a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f725a == isVar.f725a);
    }

    public is b(String str) {
        this.f731c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f724a);
        if (this.f727a != null && m471a()) {
            jiVar.a(f4988a);
            jiVar.a(this.f727a);
            jiVar.b();
        }
        if (this.f726a != null && b()) {
            jiVar.a(b);
            this.f726a.b(jiVar);
            jiVar.b();
        }
        if (this.f730b != null) {
            jiVar.a(c);
            jiVar.a(this.f730b);
            jiVar.b();
        }
        if (this.f731c != null) {
            jiVar.a(d);
            jiVar.a(this.f731c);
            jiVar.b();
        }
        if (this.f732d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f732d);
            jiVar.b();
        }
        if (this.f733e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f733e);
            jiVar.b();
        }
        if (this.f734f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f734f);
            jiVar.b();
        }
        if (this.f735g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f735g);
            jiVar.b();
        }
        if (this.f736h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f736h);
            jiVar.b();
        }
        if (this.f737i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f737i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f729a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f725a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f728a.set(1, z);
    }

    public boolean b() {
        return this.f726a != null;
    }

    public is c(String str) {
        this.f732d = str;
        return this;
    }

    public boolean c() {
        return this.f730b != null;
    }

    public is d(String str) {
        this.f734f = str;
        return this;
    }

    public boolean d() {
        return this.f731c != null;
    }

    public is e(String str) {
        this.f735g = str;
        return this;
    }

    public boolean e() {
        return this.f732d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m472a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f733e != null;
    }

    public boolean g() {
        return this.f734f != null;
    }

    public boolean h() {
        return this.f735g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f736h != null;
    }

    public boolean j() {
        return this.f737i != null;
    }

    public boolean k() {
        return this.f728a.get(0);
    }

    public boolean l() {
        return this.f728a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m471a()) {
            sb.append("debug:");
            if (this.f727a == null) {
                sb.append("null");
            } else {
                sb.append(this.f727a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f726a == null) {
                sb.append("null");
            } else {
                sb.append(this.f726a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f730b == null) {
            sb.append("null");
        } else {
            sb.append(this.f730b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f731c == null) {
            sb.append("null");
        } else {
            sb.append(this.f731c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f732d == null) {
                sb.append("null");
            } else {
                sb.append(this.f732d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f733e == null) {
                sb.append("null");
            } else {
                sb.append(this.f733e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f734f == null) {
                sb.append("null");
            } else {
                sb.append(this.f734f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f735g == null) {
                sb.append("null");
            } else {
                sb.append(this.f735g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f736h == null) {
                sb.append("null");
            } else {
                sb.append(this.f736h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f737i == null) {
                sb.append("null");
            } else {
                sb.append(this.f737i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f729a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f725a);
        }
        sb.append(")");
        return sb.toString();
    }
}
