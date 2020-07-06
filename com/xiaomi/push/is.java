package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f728a;

    /* renamed from: a  reason: collision with other field name */
    public ib f729a;

    /* renamed from: a  reason: collision with other field name */
    public String f730a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f731a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f732a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f733b;

    /* renamed from: c  reason: collision with other field name */
    public String f734c;

    /* renamed from: d  reason: collision with other field name */
    public String f735d;

    /* renamed from: e  reason: collision with other field name */
    public String f736e;

    /* renamed from: f  reason: collision with other field name */
    public String f737f;

    /* renamed from: g  reason: collision with other field name */
    public String f738g;

    /* renamed from: h  reason: collision with other field name */
    public String f739h;

    /* renamed from: i  reason: collision with other field name */
    public String f740i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f727a = new jn("XmPushActionUnRegistration");
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
            int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(isVar.m462a()));
            if (compareTo == 0) {
                if (!m462a() || (a13 = iy.a(this.f730a, isVar.f730a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f729a, isVar.f729a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f733b, isVar.f733b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f734c, isVar.f734c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f735d, isVar.f735d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f736e, isVar.f736e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f737f, isVar.f737f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f738g, isVar.f738g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f739h, isVar.f739h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f740i, isVar.f740i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f732a, isVar.f732a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f728a, isVar.f728a)) == 0) {
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
        this.f733b = str;
        return this;
    }

    public void a() {
        if (this.f733b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f734c == null) {
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
                a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f730a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f729a = new ib();
                        this.f729a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f733b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f734c = jiVar.m484a();
                        break;
                    }
                case 5:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f735d = jiVar.m484a();
                        break;
                    }
                case 6:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f736e = jiVar.m484a();
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f737f = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f738g = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f739h = jiVar.m484a();
                        break;
                    }
                case 10:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f740i = jiVar.m484a();
                        break;
                    }
                case 11:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f732a = jiVar.m488a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f728a = jiVar.m478a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f731a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        return this.f730a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m462a = m462a();
        boolean m462a2 = isVar.m462a();
        if ((m462a || m462a2) && !(m462a && m462a2 && this.f730a.equals(isVar.f730a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f729a.m392a(isVar.f729a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f733b.equals(isVar.f733b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f734c.equals(isVar.f734c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f735d.equals(isVar.f735d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f736e.equals(isVar.f736e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f737f.equals(isVar.f737f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f738g.equals(isVar.f738g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f739h.equals(isVar.f739h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f740i.equals(isVar.f740i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f732a == isVar.f732a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f728a == isVar.f728a);
    }

    public is b(String str) {
        this.f734c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f727a);
        if (this.f730a != null && m462a()) {
            jiVar.a(a);
            jiVar.a(this.f730a);
            jiVar.b();
        }
        if (this.f729a != null && b()) {
            jiVar.a(b);
            this.f729a.b(jiVar);
            jiVar.b();
        }
        if (this.f733b != null) {
            jiVar.a(c);
            jiVar.a(this.f733b);
            jiVar.b();
        }
        if (this.f734c != null) {
            jiVar.a(d);
            jiVar.a(this.f734c);
            jiVar.b();
        }
        if (this.f735d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f735d);
            jiVar.b();
        }
        if (this.f736e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f736e);
            jiVar.b();
        }
        if (this.f737f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f737f);
            jiVar.b();
        }
        if (this.f738g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f738g);
            jiVar.b();
        }
        if (this.f739h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f739h);
            jiVar.b();
        }
        if (this.f740i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f740i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f732a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f728a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f731a.set(1, z);
    }

    public boolean b() {
        return this.f729a != null;
    }

    public is c(String str) {
        this.f735d = str;
        return this;
    }

    public boolean c() {
        return this.f733b != null;
    }

    public is d(String str) {
        this.f737f = str;
        return this;
    }

    public boolean d() {
        return this.f734c != null;
    }

    public is e(String str) {
        this.f738g = str;
        return this;
    }

    public boolean e() {
        return this.f735d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m463a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f736e != null;
    }

    public boolean g() {
        return this.f737f != null;
    }

    public boolean h() {
        return this.f738g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f739h != null;
    }

    public boolean j() {
        return this.f740i != null;
    }

    public boolean k() {
        return this.f731a.get(0);
    }

    public boolean l() {
        return this.f731a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m462a()) {
            sb.append("debug:");
            if (this.f730a == null) {
                sb.append("null");
            } else {
                sb.append(this.f730a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f729a == null) {
                sb.append("null");
            } else {
                sb.append(this.f729a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f733b == null) {
            sb.append("null");
        } else {
            sb.append(this.f733b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f734c == null) {
            sb.append("null");
        } else {
            sb.append(this.f734c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f735d == null) {
                sb.append("null");
            } else {
                sb.append(this.f735d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f736e == null) {
                sb.append("null");
            } else {
                sb.append(this.f736e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f737f == null) {
                sb.append("null");
            } else {
                sb.append(this.f737f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f738g == null) {
                sb.append("null");
            } else {
                sb.append(this.f738g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f739h == null) {
                sb.append("null");
            } else {
                sb.append(this.f739h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f740i == null) {
                sb.append("null");
            } else {
                sb.append(this.f740i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f732a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f728a);
        }
        sb.append(")");
        return sb.toString();
    }
}
