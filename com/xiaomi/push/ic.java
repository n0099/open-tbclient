package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ic implements ix<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f614a;

    /* renamed from: a  reason: collision with other field name */
    public long f615a;

    /* renamed from: a  reason: collision with other field name */
    public ib f616a;

    /* renamed from: a  reason: collision with other field name */
    public ip f617a;

    /* renamed from: a  reason: collision with other field name */
    public String f618a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f620a;

    /* renamed from: a  reason: collision with other field name */
    public short f621a;

    /* renamed from: b  reason: collision with other field name */
    public String f623b;

    /* renamed from: b  reason: collision with other field name */
    public short f624b;

    /* renamed from: c  reason: collision with other field name */
    public String f625c;

    /* renamed from: d  reason: collision with other field name */
    public String f626d;

    /* renamed from: e  reason: collision with other field name */
    public String f627e;

    /* renamed from: f  reason: collision with other field name */
    public String f628f;

    /* renamed from: g  reason: collision with other field name */
    public String f629g;

    /* renamed from: h  reason: collision with other field name */
    public String f630h;

    /* renamed from: i  reason: collision with other field name */
    public String f631i;

    /* renamed from: j  reason: collision with other field name */
    public String f632j;

    /* renamed from: k  reason: collision with other field name */
    public String f633k;

    /* renamed from: l  reason: collision with other field name */
    public String f634l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f613a = new jn("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14424a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14425b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 12, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", (byte) 2, 11);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf m = new jf("", Constants.GZIP_CAST_TYPE, 13);
    private static final jf n = new jf("", Constants.GZIP_CAST_TYPE, 14);
    private static final jf o = new jf("", (byte) 6, 15);
    private static final jf p = new jf("", (byte) 6, 16);
    private static final jf q = new jf("", Constants.GZIP_CAST_TYPE, 20);
    private static final jf r = new jf("", Constants.GZIP_CAST_TYPE, 21);
    private static final jf s = new jf("", (byte) 8, 22);
    private static final jf t = new jf("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f619a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f622a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
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
        int a20;
        int a21;
        if (getClass().equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m429a()).compareTo(Boolean.valueOf(icVar.m429a()));
            if (compareTo == 0) {
                if (!m429a() || (a21 = iy.a(this.f618a, icVar.f618a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(icVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = iy.a(this.f616a, icVar.f616a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = iy.a(this.f623b, icVar.f623b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = iy.a(this.f625c, icVar.f625c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = iy.a(this.f615a, icVar.f615a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = iy.a(this.f626d, icVar.f626d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = iy.a(this.f627e, icVar.f627e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = iy.a(this.f617a, icVar.f617a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = iy.a(this.f628f, icVar.f628f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = iy.a(this.f629g, icVar.f629g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(icVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = iy.a(this.f622a, icVar.f622a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(icVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = iy.a(this.f630h, icVar.f630h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(icVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = iy.a(this.f631i, icVar.f631i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(icVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = iy.a(this.f632j, icVar.f632j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(icVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = iy.a(this.f621a, icVar.f621a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(icVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = iy.a(this.f624b, icVar.f624b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(icVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = iy.a(this.f633k, icVar.f633k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(icVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = iy.a(this.f634l, icVar.f634l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(icVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = iy.a(this.f614a, icVar.f614a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(icVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = iy.a(this.f620a, icVar.f620a)) == 0) {
                                                                                                                                                                            return 0;
                                                                                                                                                                        }
                                                                                                                                                                        return a2;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a3;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a4;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a5;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a6;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a7;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a8;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a9;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a10;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a11;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a12;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a13;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a14;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a15;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a16;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a17;
                                            }
                                            return compareTo5;
                                        }
                                        return a18;
                                    }
                                    return compareTo4;
                                }
                                return a19;
                            }
                            return compareTo3;
                        }
                        return a20;
                    }
                    return compareTo2;
                }
                return a21;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(icVar.getClass().getName());
    }

    public ic a(long j2) {
        this.f615a = j2;
        a(true);
        return this;
    }

    public ic a(String str) {
        this.f623b = str;
        return this;
    }

    public ic a(short s2) {
        this.f621a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f623b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f625c == null) {
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
                if (!e()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f618a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f616a = new ib();
                        this.f616a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f623b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f625c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 10) {
                        this.f615a = jiVar.m514a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 11) {
                        this.f626d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f627e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 12) {
                        this.f617a = new ip();
                        this.f617a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f628f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 11) {
                        this.f629g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 2) {
                        this.f622a = jiVar.m524a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 11) {
                        this.f630h = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 13:
                    if (m515a.f14471a == 11) {
                        this.f631i = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 14:
                    if (m515a.f14471a == 11) {
                        this.f632j = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 15:
                    if (m515a.f14471a == 6) {
                        this.f621a = jiVar.m522a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 16:
                    if (m515a.f14471a == 6) {
                        this.f624b = jiVar.m522a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 20:
                    if (m515a.f14471a == 11) {
                        this.f633k = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 21:
                    if (m515a.f14471a == 11) {
                        this.f634l = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 22:
                    if (m515a.f14471a == 8) {
                        this.f614a = jiVar.m513a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 23:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f620a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f620a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f619a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a() {
        return this.f618a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m429a = m429a();
        boolean m429a2 = icVar.m429a();
        if ((m429a || m429a2) && !(m429a && m429a2 && this.f618a.equals(icVar.f618a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = icVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f616a.m428a(icVar.f616a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = icVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f623b.equals(icVar.f623b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f625c.equals(icVar.f625c))) || this.f615a != icVar.f615a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f626d.equals(icVar.f626d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f627e.equals(icVar.f627e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f617a.m486a(icVar.f617a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f628f.equals(icVar.f628f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f629g.equals(icVar.f629g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = icVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f622a == icVar.f622a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = icVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f630h.equals(icVar.f630h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = icVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f631i.equals(icVar.f631i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = icVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f632j.equals(icVar.f632j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = icVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f621a == icVar.f621a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = icVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f624b == icVar.f624b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = icVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f633k.equals(icVar.f633k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = icVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f634l.equals(icVar.f634l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = icVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f614a == icVar.f614a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = icVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f620a.equals(icVar.f620a));
    }

    public ic b(String str) {
        this.f625c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f613a);
        if (this.f618a != null && m429a()) {
            jiVar.a(f14424a);
            jiVar.a(this.f618a);
            jiVar.b();
        }
        if (this.f616a != null && b()) {
            jiVar.a(f14425b);
            this.f616a.b(jiVar);
            jiVar.b();
        }
        if (this.f623b != null) {
            jiVar.a(c);
            jiVar.a(this.f623b);
            jiVar.b();
        }
        if (this.f625c != null) {
            jiVar.a(d);
            jiVar.a(this.f625c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f615a);
        jiVar.b();
        if (this.f626d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f626d);
            jiVar.b();
        }
        if (this.f627e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f627e);
            jiVar.b();
        }
        if (this.f617a != null && h()) {
            jiVar.a(h);
            this.f617a.b(jiVar);
            jiVar.b();
        }
        if (this.f628f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f628f);
            jiVar.b();
        }
        if (this.f629g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f629g);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f622a);
            jiVar.b();
        }
        if (this.f630h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f630h);
            jiVar.b();
        }
        if (this.f631i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f631i);
            jiVar.b();
        }
        if (this.f632j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f632j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f621a);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f624b);
            jiVar.b();
        }
        if (this.f633k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f633k);
            jiVar.b();
        }
        if (this.f634l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f634l);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f614a);
            jiVar.b();
        }
        if (this.f620a != null && t()) {
            jiVar.a(t);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f620a.size()));
            for (Map.Entry<String, String> entry : this.f620a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f619a.set(1, z);
    }

    public boolean b() {
        return this.f616a != null;
    }

    public ic c(String str) {
        this.f626d = str;
        return this;
    }

    public void c(boolean z) {
        this.f619a.set(2, z);
    }

    public boolean c() {
        return this.f623b != null;
    }

    public ic d(String str) {
        this.f627e = str;
        return this;
    }

    public void d(boolean z) {
        this.f619a.set(3, z);
    }

    public boolean d() {
        return this.f625c != null;
    }

    public void e(boolean z) {
        this.f619a.set(4, z);
    }

    public boolean e() {
        return this.f619a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m430a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f626d != null;
    }

    public boolean g() {
        return this.f627e != null;
    }

    public boolean h() {
        return this.f617a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f628f != null;
    }

    public boolean j() {
        return this.f629g != null;
    }

    public boolean k() {
        return this.f619a.get(1);
    }

    public boolean l() {
        return this.f630h != null;
    }

    public boolean m() {
        return this.f631i != null;
    }

    public boolean n() {
        return this.f632j != null;
    }

    public boolean o() {
        return this.f619a.get(2);
    }

    public boolean p() {
        return this.f619a.get(3);
    }

    public boolean q() {
        return this.f633k != null;
    }

    public boolean r() {
        return this.f634l != null;
    }

    public boolean s() {
        return this.f619a.get(4);
    }

    public boolean t() {
        return this.f620a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m429a()) {
            sb.append("debug:");
            if (this.f618a == null) {
                sb.append("null");
            } else {
                sb.append(this.f618a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f623b == null) {
            sb.append("null");
        } else {
            sb.append(this.f623b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f625c == null) {
            sb.append("null");
        } else {
            sb.append(this.f625c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f615a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f626d == null) {
                sb.append("null");
            } else {
                sb.append(this.f626d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f627e == null) {
                sb.append("null");
            } else {
                sb.append(this.f627e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                sb.append(this.f617a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f628f == null) {
                sb.append("null");
            } else {
                sb.append(this.f628f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f629g == null) {
                sb.append("null");
            } else {
                sb.append(this.f629g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f622a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f630h == null) {
                sb.append("null");
            } else {
                sb.append(this.f630h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f631i == null) {
                sb.append("null");
            } else {
                sb.append(this.f631i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f632j == null) {
                sb.append("null");
            } else {
                sb.append(this.f632j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f621a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f624b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f633k == null) {
                sb.append("null");
            } else {
                sb.append(this.f633k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f634l == null) {
                sb.append("null");
            } else {
                sb.append(this.f634l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f614a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f620a == null) {
                sb.append("null");
            } else {
                sb.append(this.f620a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
