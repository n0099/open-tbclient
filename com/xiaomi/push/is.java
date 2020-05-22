package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f721a;

    /* renamed from: a  reason: collision with other field name */
    public ib f722a;

    /* renamed from: a  reason: collision with other field name */
    public String f723a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f724a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f725a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f726b;

    /* renamed from: c  reason: collision with other field name */
    public String f727c;

    /* renamed from: d  reason: collision with other field name */
    public String f728d;

    /* renamed from: e  reason: collision with other field name */
    public String f729e;

    /* renamed from: f  reason: collision with other field name */
    public String f730f;

    /* renamed from: g  reason: collision with other field name */
    public String f731g;

    /* renamed from: h  reason: collision with other field name */
    public String f732h;

    /* renamed from: i  reason: collision with other field name */
    public String f733i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f720a = new jn("XmPushActionUnRegistration");
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
            int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(isVar.m466a()));
            if (compareTo == 0) {
                if (!m466a() || (a13 = iy.a(this.f723a, isVar.f723a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f722a, isVar.f722a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f726b, isVar.f726b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f727c, isVar.f727c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f728d, isVar.f728d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f729e, isVar.f729e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f730f, isVar.f730f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f731g, isVar.f731g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f732h, isVar.f732h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f733i, isVar.f733i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f725a, isVar.f725a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f721a, isVar.f721a)) == 0) {
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
        this.f726b = str;
        return this;
    }

    public void a() {
        if (this.f726b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f727c == null) {
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
                a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f723a = jiVar.m488a();
                        break;
                    }
                case 2:
                    if (m483a.a != 12) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f722a = new ib();
                        this.f722a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f726b = jiVar.m488a();
                        break;
                    }
                case 4:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f727c = jiVar.m488a();
                        break;
                    }
                case 5:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f728d = jiVar.m488a();
                        break;
                    }
                case 6:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f729e = jiVar.m488a();
                        break;
                    }
                case 7:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f730f = jiVar.m488a();
                        break;
                    }
                case 8:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f731g = jiVar.m488a();
                        break;
                    }
                case 9:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f732h = jiVar.m488a();
                        break;
                    }
                case 10:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f733i = jiVar.m488a();
                        break;
                    }
                case 11:
                    if (m483a.a != 2) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f725a = jiVar.m492a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f721a = jiVar.m482a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f724a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f723a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m466a = m466a();
        boolean m466a2 = isVar.m466a();
        if ((m466a || m466a2) && !(m466a && m466a2 && this.f723a.equals(isVar.f723a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f722a.m396a(isVar.f722a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f726b.equals(isVar.f726b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f727c.equals(isVar.f727c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f728d.equals(isVar.f728d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f729e.equals(isVar.f729e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f730f.equals(isVar.f730f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f731g.equals(isVar.f731g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f732h.equals(isVar.f732h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f733i.equals(isVar.f733i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f725a == isVar.f725a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f721a == isVar.f721a);
    }

    public is b(String str) {
        this.f727c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f720a);
        if (this.f723a != null && m466a()) {
            jiVar.a(a);
            jiVar.a(this.f723a);
            jiVar.b();
        }
        if (this.f722a != null && b()) {
            jiVar.a(b);
            this.f722a.b(jiVar);
            jiVar.b();
        }
        if (this.f726b != null) {
            jiVar.a(c);
            jiVar.a(this.f726b);
            jiVar.b();
        }
        if (this.f727c != null) {
            jiVar.a(d);
            jiVar.a(this.f727c);
            jiVar.b();
        }
        if (this.f728d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f728d);
            jiVar.b();
        }
        if (this.f729e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f729e);
            jiVar.b();
        }
        if (this.f730f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f730f);
            jiVar.b();
        }
        if (this.f731g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f731g);
            jiVar.b();
        }
        if (this.f732h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f732h);
            jiVar.b();
        }
        if (this.f733i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f733i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f725a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f721a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f724a.set(1, z);
    }

    public boolean b() {
        return this.f722a != null;
    }

    public is c(String str) {
        this.f728d = str;
        return this;
    }

    public boolean c() {
        return this.f726b != null;
    }

    public is d(String str) {
        this.f730f = str;
        return this;
    }

    public boolean d() {
        return this.f727c != null;
    }

    public is e(String str) {
        this.f731g = str;
        return this;
    }

    public boolean e() {
        return this.f728d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m467a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f729e != null;
    }

    public boolean g() {
        return this.f730f != null;
    }

    public boolean h() {
        return this.f731g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f732h != null;
    }

    public boolean j() {
        return this.f733i != null;
    }

    public boolean k() {
        return this.f724a.get(0);
    }

    public boolean l() {
        return this.f724a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m466a()) {
            sb.append("debug:");
            if (this.f723a == null) {
                sb.append("null");
            } else {
                sb.append(this.f723a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f722a == null) {
                sb.append("null");
            } else {
                sb.append(this.f722a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f726b == null) {
            sb.append("null");
        } else {
            sb.append(this.f726b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f727c == null) {
            sb.append("null");
        } else {
            sb.append(this.f727c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f728d == null) {
                sb.append("null");
            } else {
                sb.append(this.f728d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f729e == null) {
                sb.append("null");
            } else {
                sb.append(this.f729e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f730f == null) {
                sb.append("null");
            } else {
                sb.append(this.f730f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f731g == null) {
                sb.append("null");
            } else {
                sb.append(this.f731g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f732h == null) {
                sb.append("null");
            } else {
                sb.append(this.f732h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f733i == null) {
                sb.append("null");
            } else {
                sb.append(this.f733i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f725a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f721a);
        }
        sb.append(")");
        return sb.toString();
    }
}
