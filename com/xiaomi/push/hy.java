package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hy implements ix<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f567a;

    /* renamed from: a  reason: collision with other field name */
    public hz f568a;

    /* renamed from: a  reason: collision with other field name */
    public ib f569a;

    /* renamed from: a  reason: collision with other field name */
    public String f570a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f571a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f572a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f573b;

    /* renamed from: b  reason: collision with other field name */
    public String f574b;

    /* renamed from: c  reason: collision with other field name */
    public long f575c;

    /* renamed from: c  reason: collision with other field name */
    public String f576c;

    /* renamed from: d  reason: collision with other field name */
    public String f577d;

    /* renamed from: e  reason: collision with other field name */
    public String f578e;

    /* renamed from: f  reason: collision with other field name */
    public String f579f;

    /* renamed from: g  reason: collision with other field name */
    public String f580g;

    /* renamed from: h  reason: collision with other field name */
    public String f581h;

    /* renamed from: i  reason: collision with other field name */
    public String f582i;

    /* renamed from: j  reason: collision with other field name */
    public String f583j;

    /* renamed from: k  reason: collision with other field name */
    public String f584k;

    /* renamed from: l  reason: collision with other field name */
    public String f585l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f566a = new jn("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14414a = new jf("", (byte) 12, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14415b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", (byte) 10, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);
    private static final jf l = new jf("", (byte) 12, 12);
    private static final jf m = new jf("", Constants.GZIP_CAST_TYPE, 13);
    private static final jf n = new jf("", (byte) 2, 14);
    private static final jf o = new jf("", Constants.GZIP_CAST_TYPE, 15);
    private static final jf p = new jf("", (byte) 10, 16);
    private static final jf q = new jf("", Constants.GZIP_CAST_TYPE, 20);
    private static final jf r = new jf("", Constants.GZIP_CAST_TYPE, 21);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
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
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m401a()).compareTo(Boolean.valueOf(hyVar.m401a()));
            if (compareTo == 0) {
                if (!m401a() || (a19 = iy.a(this.f569a, hyVar.f569a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m403b()).compareTo(Boolean.valueOf(hyVar.m403b()));
                    if (compareTo2 == 0) {
                        if (!m403b() || (a18 = iy.a(this.f570a, hyVar.f570a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m404c()).compareTo(Boolean.valueOf(hyVar.m404c()));
                            if (compareTo3 == 0) {
                                if (!m404c() || (a17 = iy.a(this.f574b, hyVar.f574b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f576c, hyVar.f576c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f567a, hyVar.f567a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f573b, hyVar.f573b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f577d, hyVar.f577d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f578e, hyVar.f578e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f579f, hyVar.f579f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f580g, hyVar.f580g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hyVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f581h, hyVar.f581h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hyVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f568a, hyVar.f568a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hyVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f582i, hyVar.f582i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hyVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f572a, hyVar.f572a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hyVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f583j, hyVar.f583j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hyVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f575c, hyVar.f575c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hyVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f584k, hyVar.f584k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hyVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f585l, hyVar.f585l)) == 0) {
                                                                                                                                                            return 0;
                                                                                                                                                        }
                                                                                                                                                        return a2;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a3;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a4;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a5;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a6;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a7;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a8;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a9;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a10;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a11;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a12;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a13;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a14;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a15;
                                            }
                                            return compareTo5;
                                        }
                                        return a16;
                                    }
                                    return compareTo4;
                                }
                                return a17;
                            }
                            return compareTo3;
                        }
                        return a18;
                    }
                    return compareTo2;
                }
                return a19;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public long a() {
        return this.f567a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m399a() {
        return this.f570a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m400a() {
        if (this.f570a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f574b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f576c == null) {
            throw new jj("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m400a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f569a = new ib();
                        this.f569a.a(jiVar);
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f570a = jiVar.m520a();
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f574b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f576c = jiVar.m520a();
                        break;
                    }
                case 5:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f567a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f573b = jiVar.m514a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f577d = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f578e = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f579f = jiVar.m520a();
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f580g = jiVar.m520a();
                        break;
                    }
                case 11:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f581h = jiVar.m520a();
                        break;
                    }
                case 12:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f568a = new hz();
                        this.f568a.a(jiVar);
                        break;
                    }
                case 13:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f582i = jiVar.m520a();
                        break;
                    }
                case 14:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f572a = jiVar.m524a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f583j = jiVar.m520a();
                        break;
                    }
                case 16:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f575c = jiVar.m514a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 20:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f584k = jiVar.m520a();
                        break;
                    }
                case 21:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f585l = jiVar.m520a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f571a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a() {
        return this.f569a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m402a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m401a = m401a();
        boolean m401a2 = hyVar.m401a();
        if ((m401a || m401a2) && !(m401a && m401a2 && this.f569a.m428a(hyVar.f569a))) {
            return false;
        }
        boolean m403b = m403b();
        boolean m403b2 = hyVar.m403b();
        if ((m403b || m403b2) && !(m403b && m403b2 && this.f570a.equals(hyVar.f570a))) {
            return false;
        }
        boolean m404c = m404c();
        boolean m404c2 = hyVar.m404c();
        if ((m404c || m404c2) && !(m404c && m404c2 && this.f574b.equals(hyVar.f574b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f576c.equals(hyVar.f576c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f567a == hyVar.f567a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f573b == hyVar.f573b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f577d.equals(hyVar.f577d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f578e.equals(hyVar.f578e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f579f.equals(hyVar.f579f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f580g.equals(hyVar.f580g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hyVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f581h.equals(hyVar.f581h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hyVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f568a.m411a(hyVar.f568a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hyVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f582i.equals(hyVar.f582i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hyVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f572a == hyVar.f572a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hyVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f583j.equals(hyVar.f583j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hyVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f575c == hyVar.f575c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hyVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f584k.equals(hyVar.f584k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hyVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f585l.equals(hyVar.f585l));
    }

    public String b() {
        return this.f574b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m400a();
        jiVar.a(f566a);
        if (this.f569a != null && m401a()) {
            jiVar.a(f14414a);
            this.f569a.b(jiVar);
            jiVar.b();
        }
        if (this.f570a != null) {
            jiVar.a(f14415b);
            jiVar.a(this.f570a);
            jiVar.b();
        }
        if (this.f574b != null) {
            jiVar.a(c);
            jiVar.a(this.f574b);
            jiVar.b();
        }
        if (this.f576c != null) {
            jiVar.a(d);
            jiVar.a(this.f576c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f567a);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f573b);
            jiVar.b();
        }
        if (this.f577d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f577d);
            jiVar.b();
        }
        if (this.f578e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f578e);
            jiVar.b();
        }
        if (this.f579f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f579f);
            jiVar.b();
        }
        if (this.f580g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f580g);
            jiVar.b();
        }
        if (this.f581h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f581h);
            jiVar.b();
        }
        if (this.f568a != null && l()) {
            jiVar.a(l);
            this.f568a.b(jiVar);
            jiVar.b();
        }
        if (this.f582i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f582i);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f572a);
            jiVar.b();
        }
        if (this.f583j != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f583j);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f575c);
            jiVar.b();
        }
        if (this.f584k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f584k);
            jiVar.b();
        }
        if (this.f585l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f585l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f571a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m403b() {
        return this.f570a != null;
    }

    public String c() {
        return this.f576c;
    }

    public void c(boolean z) {
        this.f571a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m404c() {
        return this.f574b != null;
    }

    public void d(boolean z) {
        this.f571a.set(3, z);
    }

    public boolean d() {
        return this.f576c != null;
    }

    public boolean e() {
        return this.f571a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m402a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f571a.get(1);
    }

    public boolean g() {
        return this.f577d != null;
    }

    public boolean h() {
        return this.f578e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f579f != null;
    }

    public boolean j() {
        return this.f580g != null;
    }

    public boolean k() {
        return this.f581h != null;
    }

    public boolean l() {
        return this.f568a != null;
    }

    public boolean m() {
        return this.f582i != null;
    }

    public boolean n() {
        return this.f571a.get(2);
    }

    public boolean o() {
        return this.f583j != null;
    }

    public boolean p() {
        return this.f571a.get(3);
    }

    public boolean q() {
        return this.f584k != null;
    }

    public boolean r() {
        return this.f585l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m401a()) {
            sb.append("to:");
            if (this.f569a == null) {
                sb.append("null");
            } else {
                sb.append(this.f569a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f570a == null) {
            sb.append("null");
        } else {
            sb.append(this.f570a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f574b == null) {
            sb.append("null");
        } else {
            sb.append(this.f574b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f576c == null) {
            sb.append("null");
        } else {
            sb.append(this.f576c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f567a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f573b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f577d == null) {
                sb.append("null");
            } else {
                sb.append(this.f577d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f578e == null) {
                sb.append("null");
            } else {
                sb.append(this.f578e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f579f == null) {
                sb.append("null");
            } else {
                sb.append(this.f579f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f580g == null) {
                sb.append("null");
            } else {
                sb.append(this.f580g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f581h == null) {
                sb.append("null");
            } else {
                sb.append(this.f581h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f568a == null) {
                sb.append("null");
            } else {
                sb.append(this.f568a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f582i == null) {
                sb.append("null");
            } else {
                sb.append(this.f582i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f572a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f583j == null) {
                sb.append("null");
            } else {
                sb.append(this.f583j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f575c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f584k == null) {
                sb.append("null");
            } else {
                sb.append(this.f584k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f585l == null) {
                sb.append("null");
            } else {
                sb.append(this.f585l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
