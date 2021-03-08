package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f722a;

    /* renamed from: a  reason: collision with other field name */
    public ib f723a;

    /* renamed from: a  reason: collision with other field name */
    public String f724a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f725a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f726a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f727b;

    /* renamed from: c  reason: collision with other field name */
    public String f728c;

    /* renamed from: d  reason: collision with other field name */
    public String f729d;

    /* renamed from: e  reason: collision with other field name */
    public String f730e;

    /* renamed from: f  reason: collision with other field name */
    public String f731f;

    /* renamed from: g  reason: collision with other field name */
    public String f732g;

    /* renamed from: h  reason: collision with other field name */
    public String f733h;

    /* renamed from: i  reason: collision with other field name */
    public String f734i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f721a = new jn("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8451a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m472a()).compareTo(Boolean.valueOf(isVar.m472a()));
            if (compareTo == 0) {
                if (!m472a() || (a13 = iy.a(this.f724a, isVar.f724a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f723a, isVar.f723a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f727b, isVar.f727b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f728c, isVar.f728c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f729d, isVar.f729d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f730e, isVar.f730e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f731f, isVar.f731f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f732g, isVar.f732g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f733h, isVar.f733h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f734i, isVar.f734i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f726a, isVar.f726a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f722a, isVar.f722a)) == 0) {
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
        this.f727b = str;
        return this;
    }

    public void a() {
        if (this.f727b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f728c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f724a = jiVar.m494a();
                        break;
                    }
                case 2:
                    if (m489a.f8463a != 12) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f723a = new ib();
                        this.f723a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f727b = jiVar.m494a();
                        break;
                    }
                case 4:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f728c = jiVar.m494a();
                        break;
                    }
                case 5:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f729d = jiVar.m494a();
                        break;
                    }
                case 6:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f730e = jiVar.m494a();
                        break;
                    }
                case 7:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f731f = jiVar.m494a();
                        break;
                    }
                case 8:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f732g = jiVar.m494a();
                        break;
                    }
                case 9:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f733h = jiVar.m494a();
                        break;
                    }
                case 10:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f734i = jiVar.m494a();
                        break;
                    }
                case 11:
                    if (m489a.f8463a != 2) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f726a = jiVar.m498a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m489a.f8463a != 10) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f722a = jiVar.m488a();
                        b(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f725a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a() {
        return this.f724a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m472a = m472a();
        boolean m472a2 = isVar.m472a();
        if ((m472a || m472a2) && !(m472a && m472a2 && this.f724a.equals(isVar.f724a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f723a.m402a(isVar.f723a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f727b.equals(isVar.f727b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f728c.equals(isVar.f728c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f729d.equals(isVar.f729d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f730e.equals(isVar.f730e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f731f.equals(isVar.f731f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f732g.equals(isVar.f732g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f733h.equals(isVar.f733h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f734i.equals(isVar.f734i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f726a == isVar.f726a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f722a == isVar.f722a);
    }

    public is b(String str) {
        this.f728c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f721a);
        if (this.f724a != null && m472a()) {
            jiVar.a(f8451a);
            jiVar.a(this.f724a);
            jiVar.b();
        }
        if (this.f723a != null && b()) {
            jiVar.a(b);
            this.f723a.b(jiVar);
            jiVar.b();
        }
        if (this.f727b != null) {
            jiVar.a(c);
            jiVar.a(this.f727b);
            jiVar.b();
        }
        if (this.f728c != null) {
            jiVar.a(d);
            jiVar.a(this.f728c);
            jiVar.b();
        }
        if (this.f729d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f729d);
            jiVar.b();
        }
        if (this.f730e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f730e);
            jiVar.b();
        }
        if (this.f731f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f731f);
            jiVar.b();
        }
        if (this.f732g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f732g);
            jiVar.b();
        }
        if (this.f733h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f733h);
            jiVar.b();
        }
        if (this.f734i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f734i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f726a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f722a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public void b(boolean z) {
        this.f725a.set(1, z);
    }

    public boolean b() {
        return this.f723a != null;
    }

    public is c(String str) {
        this.f729d = str;
        return this;
    }

    public boolean c() {
        return this.f727b != null;
    }

    public is d(String str) {
        this.f731f = str;
        return this;
    }

    public boolean d() {
        return this.f728c != null;
    }

    public is e(String str) {
        this.f732g = str;
        return this;
    }

    public boolean e() {
        return this.f729d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m473a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f730e != null;
    }

    public boolean g() {
        return this.f731f != null;
    }

    public boolean h() {
        return this.f732g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f733h != null;
    }

    public boolean j() {
        return this.f734i != null;
    }

    public boolean k() {
        return this.f725a.get(0);
    }

    public boolean l() {
        return this.f725a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m472a()) {
            sb.append("debug:");
            if (this.f724a == null) {
                sb.append("null");
            } else {
                sb.append(this.f724a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f723a == null) {
                sb.append("null");
            } else {
                sb.append(this.f723a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f727b == null) {
            sb.append("null");
        } else {
            sb.append(this.f727b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f728c == null) {
            sb.append("null");
        } else {
            sb.append(this.f728c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f729d == null) {
                sb.append("null");
            } else {
                sb.append(this.f729d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f730e == null) {
                sb.append("null");
            } else {
                sb.append(this.f730e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f731f == null) {
                sb.append("null");
            } else {
                sb.append(this.f731f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f732g == null) {
                sb.append("null");
            } else {
                sb.append(this.f732g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f733h == null) {
                sb.append("null");
            } else {
                sb.append(this.f733h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f734i == null) {
                sb.append("null");
            } else {
                sb.append(this.f734i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f726a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f722a);
        }
        sb.append(")");
        return sb.toString();
    }
}
