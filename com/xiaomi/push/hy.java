package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hy implements ix<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f486a;

    /* renamed from: a  reason: collision with other field name */
    public hz f487a;

    /* renamed from: a  reason: collision with other field name */
    public ib f488a;

    /* renamed from: a  reason: collision with other field name */
    public String f489a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f490a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f491a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f492b;

    /* renamed from: b  reason: collision with other field name */
    public String f493b;

    /* renamed from: c  reason: collision with other field name */
    public long f494c;

    /* renamed from: c  reason: collision with other field name */
    public String f495c;

    /* renamed from: d  reason: collision with other field name */
    public String f496d;

    /* renamed from: e  reason: collision with other field name */
    public String f497e;

    /* renamed from: f  reason: collision with other field name */
    public String f498f;

    /* renamed from: g  reason: collision with other field name */
    public String f499g;

    /* renamed from: h  reason: collision with other field name */
    public String f500h;

    /* renamed from: i  reason: collision with other field name */
    public String f501i;

    /* renamed from: j  reason: collision with other field name */
    public String f502j;

    /* renamed from: k  reason: collision with other field name */
    public String f503k;

    /* renamed from: l  reason: collision with other field name */
    public String f504l;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f485a = new jn("PushMessage");
    private static final jf a = new jf("", (byte) 12, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
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
            int compareTo = Boolean.valueOf(m367a()).compareTo(Boolean.valueOf(hyVar.m367a()));
            if (compareTo == 0) {
                if (!m367a() || (a19 = iy.a(this.f488a, hyVar.f488a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m369b()).compareTo(Boolean.valueOf(hyVar.m369b()));
                    if (compareTo2 == 0) {
                        if (!m369b() || (a18 = iy.a(this.f489a, hyVar.f489a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m370c()).compareTo(Boolean.valueOf(hyVar.m370c()));
                            if (compareTo3 == 0) {
                                if (!m370c() || (a17 = iy.a(this.f493b, hyVar.f493b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = iy.a(this.f495c, hyVar.f495c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = iy.a(this.f486a, hyVar.f486a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = iy.a(this.f492b, hyVar.f492b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = iy.a(this.f496d, hyVar.f496d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = iy.a(this.f497e, hyVar.f497e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = iy.a(this.f498f, hyVar.f498f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = iy.a(this.f499g, hyVar.f499g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hyVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = iy.a(this.f500h, hyVar.f500h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hyVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = iy.a(this.f487a, hyVar.f487a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hyVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = iy.a(this.f501i, hyVar.f501i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hyVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = iy.a(this.f491a, hyVar.f491a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hyVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = iy.a(this.f502j, hyVar.f502j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hyVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = iy.a(this.f494c, hyVar.f494c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hyVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = iy.a(this.f503k, hyVar.f503k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hyVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = iy.a(this.f504l, hyVar.f504l)) == 0) {
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
        return this.f486a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m365a() {
        return this.f489a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m366a() {
        if (this.f489a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f493b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f495c == null) {
            throw new jj("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                m366a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a != 12) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f488a = new ib();
                        this.f488a.a(jiVar);
                        break;
                    }
                case 2:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f489a = jiVar.m486a();
                        break;
                    }
                case 3:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f493b = jiVar.m486a();
                        break;
                    }
                case 4:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f495c = jiVar.m486a();
                        break;
                    }
                case 5:
                    if (m481a.a != 10) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f486a = jiVar.m480a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m481a.a != 10) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f492b = jiVar.m480a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f496d = jiVar.m486a();
                        break;
                    }
                case 8:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f497e = jiVar.m486a();
                        break;
                    }
                case 9:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f498f = jiVar.m486a();
                        break;
                    }
                case 10:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f499g = jiVar.m486a();
                        break;
                    }
                case 11:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f500h = jiVar.m486a();
                        break;
                    }
                case 12:
                    if (m481a.a != 12) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f487a = new hz();
                        this.f487a.a(jiVar);
                        break;
                    }
                case 13:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f501i = jiVar.m486a();
                        break;
                    }
                case 14:
                    if (m481a.a != 2) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f491a = jiVar.m490a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f502j = jiVar.m486a();
                        break;
                    }
                case 16:
                    if (m481a.a != 10) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f494c = jiVar.m480a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m481a.a);
                    break;
                case 20:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f503k = jiVar.m486a();
                        break;
                    }
                case 21:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f504l = jiVar.m486a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f490a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m367a() {
        return this.f488a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m368a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m367a = m367a();
        boolean m367a2 = hyVar.m367a();
        if ((m367a || m367a2) && !(m367a && m367a2 && this.f488a.m394a(hyVar.f488a))) {
            return false;
        }
        boolean m369b = m369b();
        boolean m369b2 = hyVar.m369b();
        if ((m369b || m369b2) && !(m369b && m369b2 && this.f489a.equals(hyVar.f489a))) {
            return false;
        }
        boolean m370c = m370c();
        boolean m370c2 = hyVar.m370c();
        if ((m370c || m370c2) && !(m370c && m370c2 && this.f493b.equals(hyVar.f493b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f495c.equals(hyVar.f495c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f486a == hyVar.f486a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f492b == hyVar.f492b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f496d.equals(hyVar.f496d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f497e.equals(hyVar.f497e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f498f.equals(hyVar.f498f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f499g.equals(hyVar.f499g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hyVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f500h.equals(hyVar.f500h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hyVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f487a.m377a(hyVar.f487a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hyVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f501i.equals(hyVar.f501i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hyVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f491a == hyVar.f491a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hyVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f502j.equals(hyVar.f502j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hyVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f494c == hyVar.f494c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hyVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f503k.equals(hyVar.f503k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hyVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f504l.equals(hyVar.f504l));
    }

    public String b() {
        return this.f493b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m366a();
        jiVar.a(f485a);
        if (this.f488a != null && m367a()) {
            jiVar.a(a);
            this.f488a.b(jiVar);
            jiVar.b();
        }
        if (this.f489a != null) {
            jiVar.a(b);
            jiVar.a(this.f489a);
            jiVar.b();
        }
        if (this.f493b != null) {
            jiVar.a(c);
            jiVar.a(this.f493b);
            jiVar.b();
        }
        if (this.f495c != null) {
            jiVar.a(d);
            jiVar.a(this.f495c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f486a);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f492b);
            jiVar.b();
        }
        if (this.f496d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f496d);
            jiVar.b();
        }
        if (this.f497e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f497e);
            jiVar.b();
        }
        if (this.f498f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f498f);
            jiVar.b();
        }
        if (this.f499g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f499g);
            jiVar.b();
        }
        if (this.f500h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f500h);
            jiVar.b();
        }
        if (this.f487a != null && l()) {
            jiVar.a(l);
            this.f487a.b(jiVar);
            jiVar.b();
        }
        if (this.f501i != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f501i);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f491a);
            jiVar.b();
        }
        if (this.f502j != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f502j);
            jiVar.b();
        }
        if (p()) {
            jiVar.a(p);
            jiVar.a(this.f494c);
            jiVar.b();
        }
        if (this.f503k != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f503k);
            jiVar.b();
        }
        if (this.f504l != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f504l);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public void b(boolean z) {
        this.f490a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m369b() {
        return this.f489a != null;
    }

    public String c() {
        return this.f495c;
    }

    public void c(boolean z) {
        this.f490a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m370c() {
        return this.f493b != null;
    }

    public void d(boolean z) {
        this.f490a.set(3, z);
    }

    public boolean d() {
        return this.f495c != null;
    }

    public boolean e() {
        return this.f490a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m368a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f490a.get(1);
    }

    public boolean g() {
        return this.f496d != null;
    }

    public boolean h() {
        return this.f497e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f498f != null;
    }

    public boolean j() {
        return this.f499g != null;
    }

    public boolean k() {
        return this.f500h != null;
    }

    public boolean l() {
        return this.f487a != null;
    }

    public boolean m() {
        return this.f501i != null;
    }

    public boolean n() {
        return this.f490a.get(2);
    }

    public boolean o() {
        return this.f502j != null;
    }

    public boolean p() {
        return this.f490a.get(3);
    }

    public boolean q() {
        return this.f503k != null;
    }

    public boolean r() {
        return this.f504l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m367a()) {
            sb.append("to:");
            if (this.f488a == null) {
                sb.append("null");
            } else {
                sb.append(this.f488a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f489a == null) {
            sb.append("null");
        } else {
            sb.append(this.f489a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f493b == null) {
            sb.append("null");
        } else {
            sb.append(this.f493b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f495c == null) {
            sb.append("null");
        } else {
            sb.append(this.f495c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f486a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f492b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f496d == null) {
                sb.append("null");
            } else {
                sb.append(this.f496d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f497e == null) {
                sb.append("null");
            } else {
                sb.append(this.f497e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f498f == null) {
                sb.append("null");
            } else {
                sb.append(this.f498f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f499g == null) {
                sb.append("null");
            } else {
                sb.append(this.f499g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f500h == null) {
                sb.append("null");
            } else {
                sb.append(this.f500h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f487a == null) {
                sb.append("null");
            } else {
                sb.append(this.f487a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f501i == null) {
                sb.append("null");
            } else {
                sb.append(this.f501i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f491a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f502j == null) {
                sb.append("null");
            } else {
                sb.append(this.f502j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f494c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f503k == null) {
                sb.append("null");
            } else {
                sb.append(this.f503k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f504l == null) {
                sb.append("null");
            } else {
                sb.append(this.f504l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
