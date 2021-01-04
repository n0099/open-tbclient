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
    public int f613a;

    /* renamed from: a  reason: collision with other field name */
    public long f614a;

    /* renamed from: a  reason: collision with other field name */
    public ib f615a;

    /* renamed from: a  reason: collision with other field name */
    public ip f616a;

    /* renamed from: a  reason: collision with other field name */
    public String f617a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f619a;

    /* renamed from: a  reason: collision with other field name */
    public short f620a;

    /* renamed from: b  reason: collision with other field name */
    public String f622b;

    /* renamed from: b  reason: collision with other field name */
    public short f623b;

    /* renamed from: c  reason: collision with other field name */
    public String f624c;

    /* renamed from: d  reason: collision with other field name */
    public String f625d;

    /* renamed from: e  reason: collision with other field name */
    public String f626e;

    /* renamed from: f  reason: collision with other field name */
    public String f627f;

    /* renamed from: g  reason: collision with other field name */
    public String f628g;

    /* renamed from: h  reason: collision with other field name */
    public String f629h;

    /* renamed from: i  reason: collision with other field name */
    public String f630i;

    /* renamed from: j  reason: collision with other field name */
    public String f631j;

    /* renamed from: k  reason: collision with other field name */
    public String f632k;

    /* renamed from: l  reason: collision with other field name */
    public String f633l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f612a = new jn("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14423a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14424b = new jf("", (byte) 12, 2);
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
    private BitSet f618a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f621a = false;

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
            int compareTo = Boolean.valueOf(m418a()).compareTo(Boolean.valueOf(icVar.m418a()));
            if (compareTo == 0) {
                if (!m418a() || (a21 = iy.a(this.f617a, icVar.f617a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(icVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = iy.a(this.f615a, icVar.f615a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = iy.a(this.f622b, icVar.f622b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = iy.a(this.f624c, icVar.f624c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = iy.a(this.f614a, icVar.f614a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = iy.a(this.f625d, icVar.f625d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = iy.a(this.f626e, icVar.f626e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = iy.a(this.f616a, icVar.f616a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = iy.a(this.f627f, icVar.f627f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = iy.a(this.f628g, icVar.f628g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(icVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = iy.a(this.f621a, icVar.f621a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(icVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = iy.a(this.f629h, icVar.f629h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(icVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = iy.a(this.f630i, icVar.f630i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(icVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = iy.a(this.f631j, icVar.f631j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(icVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = iy.a(this.f620a, icVar.f620a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(icVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = iy.a(this.f623b, icVar.f623b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(icVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = iy.a(this.f632k, icVar.f632k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(icVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = iy.a(this.f633l, icVar.f633l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(icVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = iy.a(this.f613a, icVar.f613a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(icVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = iy.a(this.f619a, icVar.f619a)) == 0) {
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
        this.f614a = j2;
        a(true);
        return this;
    }

    public ic a(String str) {
        this.f622b = str;
        return this;
    }

    public ic a(short s2) {
        this.f620a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f622b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f624c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 11) {
                        this.f617a = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 2:
                    if (m504a.f14470a == 12) {
                        this.f615a = new ib();
                        this.f615a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 3:
                    if (m504a.f14470a == 11) {
                        this.f622b = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 4:
                    if (m504a.f14470a == 11) {
                        this.f624c = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 5:
                    if (m504a.f14470a == 10) {
                        this.f614a = jiVar.m503a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 6:
                    if (m504a.f14470a == 11) {
                        this.f625d = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 7:
                    if (m504a.f14470a == 11) {
                        this.f626e = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 8:
                    if (m504a.f14470a == 12) {
                        this.f616a = new ip();
                        this.f616a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 9:
                    if (m504a.f14470a == 11) {
                        this.f627f = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 10:
                    if (m504a.f14470a == 11) {
                        this.f628g = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 11:
                    if (m504a.f14470a == 2) {
                        this.f621a = jiVar.m513a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 12:
                    if (m504a.f14470a == 11) {
                        this.f629h = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 13:
                    if (m504a.f14470a == 11) {
                        this.f630i = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 14:
                    if (m504a.f14470a == 11) {
                        this.f631j = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 15:
                    if (m504a.f14470a == 6) {
                        this.f620a = jiVar.m511a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 16:
                    if (m504a.f14470a == 6) {
                        this.f623b = jiVar.m511a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
                case 20:
                    if (m504a.f14470a == 11) {
                        this.f632k = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 21:
                    if (m504a.f14470a == 11) {
                        this.f633l = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 22:
                    if (m504a.f14470a == 8) {
                        this.f613a = jiVar.m502a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 23:
                    if (m504a.f14470a == 13) {
                        jh m506a = jiVar.m506a();
                        this.f619a = new HashMap(m506a.f859a * 2);
                        for (int i2 = 0; i2 < m506a.f859a; i2++) {
                            this.f619a.put(jiVar.m509a(), jiVar.m509a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f618a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m418a() {
        return this.f617a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m419a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m418a = m418a();
        boolean m418a2 = icVar.m418a();
        if ((m418a || m418a2) && !(m418a && m418a2 && this.f617a.equals(icVar.f617a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = icVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f615a.m417a(icVar.f615a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = icVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f622b.equals(icVar.f622b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f624c.equals(icVar.f624c))) || this.f614a != icVar.f614a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f625d.equals(icVar.f625d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f626e.equals(icVar.f626e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f616a.m475a(icVar.f616a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f627f.equals(icVar.f627f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f628g.equals(icVar.f628g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = icVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f621a == icVar.f621a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = icVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f629h.equals(icVar.f629h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = icVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f630i.equals(icVar.f630i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = icVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f631j.equals(icVar.f631j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = icVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f620a == icVar.f620a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = icVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f623b == icVar.f623b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = icVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f632k.equals(icVar.f632k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = icVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f633l.equals(icVar.f633l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = icVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f613a == icVar.f613a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = icVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f619a.equals(icVar.f619a));
    }

    public ic b(String str) {
        this.f624c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f612a);
        if (this.f617a != null && m418a()) {
            jiVar.a(f14423a);
            jiVar.a(this.f617a);
            jiVar.b();
        }
        if (this.f615a != null && b()) {
            jiVar.a(f14424b);
            this.f615a.b(jiVar);
            jiVar.b();
        }
        if (this.f622b != null) {
            jiVar.a(c);
            jiVar.a(this.f622b);
            jiVar.b();
        }
        if (this.f624c != null) {
            jiVar.a(d);
            jiVar.a(this.f624c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f614a);
        jiVar.b();
        if (this.f625d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f625d);
            jiVar.b();
        }
        if (this.f626e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f626e);
            jiVar.b();
        }
        if (this.f616a != null && h()) {
            jiVar.a(h);
            this.f616a.b(jiVar);
            jiVar.b();
        }
        if (this.f627f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f627f);
            jiVar.b();
        }
        if (this.f628g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f628g);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f621a);
            jiVar.b();
        }
        if (this.f629h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f629h);
            jiVar.b();
        }
        if (this.f630i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f630i);
            jiVar.b();
        }
        if (this.f631j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f631j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f620a);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f623b);
            jiVar.b();
        }
        if (this.f632k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f632k);
            jiVar.b();
        }
        if (this.f633l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f633l);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f613a);
            jiVar.b();
        }
        if (this.f619a != null && t()) {
            jiVar.a(t);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f619a.size()));
            for (Map.Entry<String, String> entry : this.f619a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public void b(boolean z) {
        this.f618a.set(1, z);
    }

    public boolean b() {
        return this.f615a != null;
    }

    public ic c(String str) {
        this.f625d = str;
        return this;
    }

    public void c(boolean z) {
        this.f618a.set(2, z);
    }

    public boolean c() {
        return this.f622b != null;
    }

    public ic d(String str) {
        this.f626e = str;
        return this;
    }

    public void d(boolean z) {
        this.f618a.set(3, z);
    }

    public boolean d() {
        return this.f624c != null;
    }

    public void e(boolean z) {
        this.f618a.set(4, z);
    }

    public boolean e() {
        return this.f618a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m419a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f625d != null;
    }

    public boolean g() {
        return this.f626e != null;
    }

    public boolean h() {
        return this.f616a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f627f != null;
    }

    public boolean j() {
        return this.f628g != null;
    }

    public boolean k() {
        return this.f618a.get(1);
    }

    public boolean l() {
        return this.f629h != null;
    }

    public boolean m() {
        return this.f630i != null;
    }

    public boolean n() {
        return this.f631j != null;
    }

    public boolean o() {
        return this.f618a.get(2);
    }

    public boolean p() {
        return this.f618a.get(3);
    }

    public boolean q() {
        return this.f632k != null;
    }

    public boolean r() {
        return this.f633l != null;
    }

    public boolean s() {
        return this.f618a.get(4);
    }

    public boolean t() {
        return this.f619a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m418a()) {
            sb.append("debug:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                sb.append(this.f617a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                sb.append(this.f615a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f622b == null) {
            sb.append("null");
        } else {
            sb.append(this.f622b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f624c == null) {
            sb.append("null");
        } else {
            sb.append(this.f624c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f614a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f625d == null) {
                sb.append("null");
            } else {
                sb.append(this.f625d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f626e == null) {
                sb.append("null");
            } else {
                sb.append(this.f626e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f627f == null) {
                sb.append("null");
            } else {
                sb.append(this.f627f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f628g == null) {
                sb.append("null");
            } else {
                sb.append(this.f628g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f621a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f629h == null) {
                sb.append("null");
            } else {
                sb.append(this.f629h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f630i == null) {
                sb.append("null");
            } else {
                sb.append(this.f630i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f631j == null) {
                sb.append("null");
            } else {
                sb.append(this.f631j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f620a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f623b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f632k == null) {
                sb.append("null");
            } else {
                sb.append(this.f632k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f633l == null) {
                sb.append("null");
            } else {
                sb.append(this.f633l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f613a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f619a == null) {
                sb.append("null");
            } else {
                sb.append(this.f619a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
