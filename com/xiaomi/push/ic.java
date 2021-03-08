package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ic implements ix<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f534a;

    /* renamed from: a  reason: collision with other field name */
    public long f535a;

    /* renamed from: a  reason: collision with other field name */
    public ib f536a;

    /* renamed from: a  reason: collision with other field name */
    public ip f537a;

    /* renamed from: a  reason: collision with other field name */
    public String f538a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f540a;

    /* renamed from: a  reason: collision with other field name */
    public short f541a;

    /* renamed from: b  reason: collision with other field name */
    public String f543b;

    /* renamed from: b  reason: collision with other field name */
    public short f544b;

    /* renamed from: c  reason: collision with other field name */
    public String f545c;

    /* renamed from: d  reason: collision with other field name */
    public String f546d;

    /* renamed from: e  reason: collision with other field name */
    public String f547e;

    /* renamed from: f  reason: collision with other field name */
    public String f548f;

    /* renamed from: g  reason: collision with other field name */
    public String f549g;

    /* renamed from: h  reason: collision with other field name */
    public String f550h;

    /* renamed from: i  reason: collision with other field name */
    public String f551i;

    /* renamed from: j  reason: collision with other field name */
    public String f552j;

    /* renamed from: k  reason: collision with other field name */
    public String f553k;

    /* renamed from: l  reason: collision with other field name */
    public String f554l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f533a = new jn("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8435a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
    private BitSet f539a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f542a = false;

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
            int compareTo = Boolean.valueOf(m403a()).compareTo(Boolean.valueOf(icVar.m403a()));
            if (compareTo == 0) {
                if (!m403a() || (a21 = iy.a(this.f538a, icVar.f538a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(icVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = iy.a(this.f536a, icVar.f536a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(icVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = iy.a(this.f543b, icVar.f543b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = iy.a(this.f545c, icVar.f545c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = iy.a(this.f535a, icVar.f535a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = iy.a(this.f546d, icVar.f546d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = iy.a(this.f547e, icVar.f547e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = iy.a(this.f537a, icVar.f537a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = iy.a(this.f548f, icVar.f548f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = iy.a(this.f549g, icVar.f549g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(icVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = iy.a(this.f542a, icVar.f542a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(icVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = iy.a(this.f550h, icVar.f550h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(icVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = iy.a(this.f551i, icVar.f551i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(icVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = iy.a(this.f552j, icVar.f552j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(icVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = iy.a(this.f541a, icVar.f541a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(icVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = iy.a(this.f544b, icVar.f544b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(icVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = iy.a(this.f553k, icVar.f553k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(icVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = iy.a(this.f554l, icVar.f554l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(icVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = iy.a(this.f534a, icVar.f534a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(icVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = iy.a(this.f540a, icVar.f540a)) == 0) {
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
        this.f535a = j2;
        a(true);
        return this;
    }

    public ic a(String str) {
        this.f543b = str;
        return this;
    }

    public ic a(short s2) {
        this.f541a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f543b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f545c == null) {
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
                if (!e()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 11) {
                        this.f538a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 2:
                    if (m489a.f8463a == 12) {
                        this.f536a = new ib();
                        this.f536a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 3:
                    if (m489a.f8463a == 11) {
                        this.f543b = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 4:
                    if (m489a.f8463a == 11) {
                        this.f545c = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 5:
                    if (m489a.f8463a == 10) {
                        this.f535a = jiVar.m488a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 6:
                    if (m489a.f8463a == 11) {
                        this.f546d = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 7:
                    if (m489a.f8463a == 11) {
                        this.f547e = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 8:
                    if (m489a.f8463a == 12) {
                        this.f537a = new ip();
                        this.f537a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 9:
                    if (m489a.f8463a == 11) {
                        this.f548f = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 10:
                    if (m489a.f8463a == 11) {
                        this.f549g = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 11:
                    if (m489a.f8463a == 2) {
                        this.f542a = jiVar.m498a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 12:
                    if (m489a.f8463a == 11) {
                        this.f550h = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 13:
                    if (m489a.f8463a == 11) {
                        this.f551i = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 14:
                    if (m489a.f8463a == 11) {
                        this.f552j = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 15:
                    if (m489a.f8463a == 6) {
                        this.f541a = jiVar.m496a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 16:
                    if (m489a.f8463a == 6) {
                        this.f544b = jiVar.m496a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
                case 20:
                    if (m489a.f8463a == 11) {
                        this.f553k = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 21:
                    if (m489a.f8463a == 11) {
                        this.f554l = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 22:
                    if (m489a.f8463a == 8) {
                        this.f534a = jiVar.m487a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 23:
                    if (m489a.f8463a == 13) {
                        jh m491a = jiVar.m491a();
                        this.f540a = new HashMap(m491a.f780a * 2);
                        for (int i2 = 0; i2 < m491a.f780a; i2++) {
                            this.f540a.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f539a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m403a() {
        return this.f538a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m403a = m403a();
        boolean m403a2 = icVar.m403a();
        if ((m403a || m403a2) && !(m403a && m403a2 && this.f538a.equals(icVar.f538a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = icVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f536a.m402a(icVar.f536a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = icVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f543b.equals(icVar.f543b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f545c.equals(icVar.f545c))) || this.f535a != icVar.f535a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f546d.equals(icVar.f546d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f547e.equals(icVar.f547e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f537a.m460a(icVar.f537a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f548f.equals(icVar.f548f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f549g.equals(icVar.f549g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = icVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f542a == icVar.f542a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = icVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f550h.equals(icVar.f550h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = icVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f551i.equals(icVar.f551i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = icVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f552j.equals(icVar.f552j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = icVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f541a == icVar.f541a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = icVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f544b == icVar.f544b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = icVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f553k.equals(icVar.f553k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = icVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f554l.equals(icVar.f554l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = icVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f534a == icVar.f534a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = icVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f540a.equals(icVar.f540a));
    }

    public ic b(String str) {
        this.f545c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f533a);
        if (this.f538a != null && m403a()) {
            jiVar.a(f8435a);
            jiVar.a(this.f538a);
            jiVar.b();
        }
        if (this.f536a != null && b()) {
            jiVar.a(b);
            this.f536a.b(jiVar);
            jiVar.b();
        }
        if (this.f543b != null) {
            jiVar.a(c);
            jiVar.a(this.f543b);
            jiVar.b();
        }
        if (this.f545c != null) {
            jiVar.a(d);
            jiVar.a(this.f545c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f535a);
        jiVar.b();
        if (this.f546d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f546d);
            jiVar.b();
        }
        if (this.f547e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f547e);
            jiVar.b();
        }
        if (this.f537a != null && h()) {
            jiVar.a(h);
            this.f537a.b(jiVar);
            jiVar.b();
        }
        if (this.f548f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f548f);
            jiVar.b();
        }
        if (this.f549g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f549g);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f542a);
            jiVar.b();
        }
        if (this.f550h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f550h);
            jiVar.b();
        }
        if (this.f551i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f551i);
            jiVar.b();
        }
        if (this.f552j != null && n()) {
            jiVar.a(n);
            jiVar.a(this.f552j);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f541a);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f544b);
            jiVar.b();
        }
        if (this.f553k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f553k);
            jiVar.b();
        }
        if (this.f554l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f554l);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f534a);
            jiVar.b();
        }
        if (this.f540a != null && t()) {
            jiVar.a(t);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f540a.size()));
            for (Map.Entry<String, String> entry : this.f540a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public void b(boolean z) {
        this.f539a.set(1, z);
    }

    public boolean b() {
        return this.f536a != null;
    }

    public ic c(String str) {
        this.f546d = str;
        return this;
    }

    public void c(boolean z) {
        this.f539a.set(2, z);
    }

    public boolean c() {
        return this.f543b != null;
    }

    public ic d(String str) {
        this.f547e = str;
        return this;
    }

    public void d(boolean z) {
        this.f539a.set(3, z);
    }

    public boolean d() {
        return this.f545c != null;
    }

    public void e(boolean z) {
        this.f539a.set(4, z);
    }

    public boolean e() {
        return this.f539a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m404a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f546d != null;
    }

    public boolean g() {
        return this.f547e != null;
    }

    public boolean h() {
        return this.f537a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f548f != null;
    }

    public boolean j() {
        return this.f549g != null;
    }

    public boolean k() {
        return this.f539a.get(1);
    }

    public boolean l() {
        return this.f550h != null;
    }

    public boolean m() {
        return this.f551i != null;
    }

    public boolean n() {
        return this.f552j != null;
    }

    public boolean o() {
        return this.f539a.get(2);
    }

    public boolean p() {
        return this.f539a.get(3);
    }

    public boolean q() {
        return this.f553k != null;
    }

    public boolean r() {
        return this.f554l != null;
    }

    public boolean s() {
        return this.f539a.get(4);
    }

    public boolean t() {
        return this.f540a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m403a()) {
            sb.append("debug:");
            if (this.f538a == null) {
                sb.append("null");
            } else {
                sb.append(this.f538a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f536a == null) {
                sb.append("null");
            } else {
                sb.append(this.f536a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f543b == null) {
            sb.append("null");
        } else {
            sb.append(this.f543b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f545c == null) {
            sb.append("null");
        } else {
            sb.append(this.f545c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f535a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f546d == null) {
                sb.append("null");
            } else {
                sb.append(this.f546d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f547e == null) {
                sb.append("null");
            } else {
                sb.append(this.f547e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f537a == null) {
                sb.append("null");
            } else {
                sb.append(this.f537a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f548f == null) {
                sb.append("null");
            } else {
                sb.append(this.f548f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f549g == null) {
                sb.append("null");
            } else {
                sb.append(this.f549g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f542a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f550h == null) {
                sb.append("null");
            } else {
                sb.append(this.f550h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f551i == null) {
                sb.append("null");
            } else {
                sb.append(this.f551i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f552j == null) {
                sb.append("null");
            } else {
                sb.append(this.f552j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f541a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f544b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f553k == null) {
                sb.append("null");
            } else {
                sb.append(this.f553k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f554l == null) {
                sb.append("null");
            } else {
                sb.append(this.f554l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f534a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f540a == null) {
                sb.append("null");
            } else {
                sb.append(this.f540a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
