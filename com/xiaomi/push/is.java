package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f720a;

    /* renamed from: a  reason: collision with other field name */
    public ib f721a;

    /* renamed from: a  reason: collision with other field name */
    public String f722a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f723a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f724a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f725b;

    /* renamed from: c  reason: collision with other field name */
    public String f726c;

    /* renamed from: d  reason: collision with other field name */
    public String f727d;

    /* renamed from: e  reason: collision with other field name */
    public String f728e;

    /* renamed from: f  reason: collision with other field name */
    public String f729f;

    /* renamed from: g  reason: collision with other field name */
    public String f730g;

    /* renamed from: h  reason: collision with other field name */
    public String f731h;

    /* renamed from: i  reason: collision with other field name */
    public String f732i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f719a = new jn("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4986a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m468a()).compareTo(Boolean.valueOf(isVar.m468a()));
            if (compareTo == 0) {
                if (!m468a() || (a13 = iy.a(this.f722a, isVar.f722a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f721a, isVar.f721a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f725b, isVar.f725b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f726c, isVar.f726c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f727d, isVar.f727d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f728e, isVar.f728e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f729f, isVar.f729f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f730g, isVar.f730g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f731h, isVar.f731h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f732i, isVar.f732i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f724a, isVar.f724a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f720a, isVar.f720a)) == 0) {
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
        this.f725b = str;
        return this;
    }

    public void a() {
        if (this.f725b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f726c == null) {
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
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f722a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f721a = new ib();
                        this.f721a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f725b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f726c = jiVar.m490a();
                        break;
                    }
                case 5:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f727d = jiVar.m490a();
                        break;
                    }
                case 6:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f728e = jiVar.m490a();
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f729f = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f730g = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f731h = jiVar.m490a();
                        break;
                    }
                case 10:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f732i = jiVar.m490a();
                        break;
                    }
                case 11:
                    if (m485a.f4998a != 2) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f724a = jiVar.m494a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f720a = jiVar.m484a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f723a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a() {
        return this.f722a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m468a = m468a();
        boolean m468a2 = isVar.m468a();
        if ((m468a || m468a2) && !(m468a && m468a2 && this.f722a.equals(isVar.f722a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f721a.m398a(isVar.f721a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f725b.equals(isVar.f725b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f726c.equals(isVar.f726c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f727d.equals(isVar.f727d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f728e.equals(isVar.f728e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f729f.equals(isVar.f729f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f730g.equals(isVar.f730g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f731h.equals(isVar.f731h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f732i.equals(isVar.f732i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f724a == isVar.f724a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f720a == isVar.f720a);
    }

    public is b(String str) {
        this.f726c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f719a);
        if (this.f722a != null && m468a()) {
            jiVar.a(f4986a);
            jiVar.a(this.f722a);
            jiVar.b();
        }
        if (this.f721a != null && b()) {
            jiVar.a(b);
            this.f721a.b(jiVar);
            jiVar.b();
        }
        if (this.f725b != null) {
            jiVar.a(c);
            jiVar.a(this.f725b);
            jiVar.b();
        }
        if (this.f726c != null) {
            jiVar.a(d);
            jiVar.a(this.f726c);
            jiVar.b();
        }
        if (this.f727d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f727d);
            jiVar.b();
        }
        if (this.f728e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f728e);
            jiVar.b();
        }
        if (this.f729f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f729f);
            jiVar.b();
        }
        if (this.f730g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f730g);
            jiVar.b();
        }
        if (this.f731h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f731h);
            jiVar.b();
        }
        if (this.f732i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f732i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f724a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f720a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f723a.set(1, z);
    }

    public boolean b() {
        return this.f721a != null;
    }

    public is c(String str) {
        this.f727d = str;
        return this;
    }

    public boolean c() {
        return this.f725b != null;
    }

    public is d(String str) {
        this.f729f = str;
        return this;
    }

    public boolean d() {
        return this.f726c != null;
    }

    public is e(String str) {
        this.f730g = str;
        return this;
    }

    public boolean e() {
        return this.f727d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m469a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f728e != null;
    }

    public boolean g() {
        return this.f729f != null;
    }

    public boolean h() {
        return this.f730g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f731h != null;
    }

    public boolean j() {
        return this.f732i != null;
    }

    public boolean k() {
        return this.f723a.get(0);
    }

    public boolean l() {
        return this.f723a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m468a()) {
            sb.append("debug:");
            if (this.f722a == null) {
                sb.append("null");
            } else {
                sb.append(this.f722a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f721a == null) {
                sb.append("null");
            } else {
                sb.append(this.f721a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f725b == null) {
            sb.append("null");
        } else {
            sb.append(this.f725b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f726c == null) {
            sb.append("null");
        } else {
            sb.append(this.f726c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f727d == null) {
                sb.append("null");
            } else {
                sb.append(this.f727d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f728e == null) {
                sb.append("null");
            } else {
                sb.append(this.f728e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f729f == null) {
                sb.append("null");
            } else {
                sb.append(this.f729f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f730g == null) {
                sb.append("null");
            } else {
                sb.append(this.f730g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f731h == null) {
                sb.append("null");
            } else {
                sb.append(this.f731h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f732i == null) {
                sb.append("null");
            } else {
                sb.append(this.f732i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f724a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f720a);
        }
        sb.append(")");
        return sb.toString();
    }
}
