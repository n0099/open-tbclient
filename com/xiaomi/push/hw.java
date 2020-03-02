package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hw implements ir<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f545a;

    /* renamed from: a  reason: collision with other field name */
    public long f546a;

    /* renamed from: a  reason: collision with other field name */
    public hv f547a;

    /* renamed from: a  reason: collision with other field name */
    public ij f548a;

    /* renamed from: a  reason: collision with other field name */
    public String f549a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f551a;

    /* renamed from: a  reason: collision with other field name */
    public short f552a;

    /* renamed from: b  reason: collision with other field name */
    public String f554b;

    /* renamed from: b  reason: collision with other field name */
    public short f555b;

    /* renamed from: c  reason: collision with other field name */
    public String f556c;

    /* renamed from: d  reason: collision with other field name */
    public String f557d;

    /* renamed from: e  reason: collision with other field name */
    public String f558e;

    /* renamed from: f  reason: collision with other field name */
    public String f559f;

    /* renamed from: g  reason: collision with other field name */
    public String f560g;

    /* renamed from: h  reason: collision with other field name */
    public String f561h;

    /* renamed from: i  reason: collision with other field name */
    public String f562i;

    /* renamed from: j  reason: collision with other field name */
    public String f563j;

    /* renamed from: k  reason: collision with other field name */
    public String f564k;

    /* renamed from: l  reason: collision with other field name */
    public String f565l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f544a = new jh("XmPushActionAckMessage");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 12, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", (byte) 2, 11);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 12);
    private static final iz m = new iz("", Constants.GZIP_CAST_TYPE, 13);
    private static final iz n = new iz("", Constants.GZIP_CAST_TYPE, 14);
    private static final iz o = new iz("", (byte) 6, 15);
    private static final iz p = new iz("", (byte) 6, 16);
    private static final iz q = new iz("", Constants.GZIP_CAST_TYPE, 20);
    private static final iz r = new iz("", Constants.GZIP_CAST_TYPE, 21);
    private static final iz s = new iz("", (byte) 8, 22);
    private static final iz t = new iz("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f550a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f553a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
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
        if (getClass().equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(m379a()).compareTo(Boolean.valueOf(hwVar.m379a()));
            if (compareTo == 0) {
                if (!m379a() || (a21 = is.a(this.f549a, hwVar.f549a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = is.a(this.f547a, hwVar.f547a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = is.a(this.f554b, hwVar.f554b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = is.a(this.f556c, hwVar.f556c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = is.a(this.f546a, hwVar.f546a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = is.a(this.f557d, hwVar.f557d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = is.a(this.f558e, hwVar.f558e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = is.a(this.f548a, hwVar.f548a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = is.a(this.f559f, hwVar.f559f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = is.a(this.f560g, hwVar.f560g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = is.a(this.f553a, hwVar.f553a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = is.a(this.f561h, hwVar.f561h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = is.a(this.f562i, hwVar.f562i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = is.a(this.f563j, hwVar.f563j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hwVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = is.a(this.f552a, hwVar.f552a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hwVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = is.a(this.f555b, hwVar.f555b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hwVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = is.a(this.f564k, hwVar.f564k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hwVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = is.a(this.f565l, hwVar.f565l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hwVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = is.a(this.f545a, hwVar.f545a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hwVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = is.a(this.f551a, hwVar.f551a)) == 0) {
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
        return getClass().getName().compareTo(hwVar.getClass().getName());
    }

    public hw a(long j2) {
        this.f546a = j2;
        a(true);
        return this;
    }

    public hw a(String str) {
        this.f554b = str;
        return this;
    }

    public hw a(short s2) {
        this.f552a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f554b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f556c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a == 11) {
                        this.f549a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 2:
                    if (m468a.a == 12) {
                        this.f547a = new hv();
                        this.f547a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 11) {
                        this.f554b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 4:
                    if (m468a.a == 11) {
                        this.f556c = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 5:
                    if (m468a.a == 10) {
                        this.f546a = jcVar.m467a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 6:
                    if (m468a.a == 11) {
                        this.f557d = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 7:
                    if (m468a.a == 11) {
                        this.f558e = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 8:
                    if (m468a.a == 12) {
                        this.f548a = new ij();
                        this.f548a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 9:
                    if (m468a.a == 11) {
                        this.f559f = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 10:
                    if (m468a.a == 11) {
                        this.f560g = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 11:
                    if (m468a.a == 2) {
                        this.f553a = jcVar.m477a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 12:
                    if (m468a.a == 11) {
                        this.f561h = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 13:
                    if (m468a.a == 11) {
                        this.f562i = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 14:
                    if (m468a.a == 11) {
                        this.f563j = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 15:
                    if (m468a.a == 6) {
                        this.f552a = jcVar.m475a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 16:
                    if (m468a.a == 6) {
                        this.f555b = jcVar.m475a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 20:
                    if (m468a.a == 11) {
                        this.f564k = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 21:
                    if (m468a.a == 11) {
                        this.f565l = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 22:
                    if (m468a.a == 8) {
                        this.f545a = jcVar.m466a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 23:
                    if (m468a.a == 13) {
                        jb m470a = jcVar.m470a();
                        this.f551a = new HashMap(m470a.f792a * 2);
                        for (int i2 = 0; i2 < m470a.f792a; i2++) {
                            this.f551a.put(jcVar.m473a(), jcVar.m473a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f550a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m379a() {
        return this.f549a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m379a = m379a();
        boolean m379a2 = hwVar.m379a();
        if ((m379a || m379a2) && !(m379a && m379a2 && this.f549a.equals(hwVar.f549a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f547a.m378a(hwVar.f547a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f554b.equals(hwVar.f554b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f556c.equals(hwVar.f556c))) || this.f546a != hwVar.f546a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f557d.equals(hwVar.f557d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f558e.equals(hwVar.f558e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f548a.m439a(hwVar.f548a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f559f.equals(hwVar.f559f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f560g.equals(hwVar.f560g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f553a == hwVar.f553a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f561h.equals(hwVar.f561h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f562i.equals(hwVar.f562i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hwVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f563j.equals(hwVar.f563j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hwVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f552a == hwVar.f552a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hwVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f555b == hwVar.f555b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hwVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f564k.equals(hwVar.f564k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hwVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f565l.equals(hwVar.f565l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hwVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f545a == hwVar.f545a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hwVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f551a.equals(hwVar.f551a));
    }

    public hw b(String str) {
        this.f556c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f544a);
        if (this.f549a != null && m379a()) {
            jcVar.a(a);
            jcVar.a(this.f549a);
            jcVar.b();
        }
        if (this.f547a != null && b()) {
            jcVar.a(b);
            this.f547a.b(jcVar);
            jcVar.b();
        }
        if (this.f554b != null) {
            jcVar.a(c);
            jcVar.a(this.f554b);
            jcVar.b();
        }
        if (this.f556c != null) {
            jcVar.a(d);
            jcVar.a(this.f556c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f546a);
        jcVar.b();
        if (this.f557d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f557d);
            jcVar.b();
        }
        if (this.f558e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f558e);
            jcVar.b();
        }
        if (this.f548a != null && h()) {
            jcVar.a(h);
            this.f548a.b(jcVar);
            jcVar.b();
        }
        if (this.f559f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f559f);
            jcVar.b();
        }
        if (this.f560g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f560g);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f553a);
            jcVar.b();
        }
        if (this.f561h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f561h);
            jcVar.b();
        }
        if (this.f562i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f562i);
            jcVar.b();
        }
        if (this.f563j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f563j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f552a);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f555b);
            jcVar.b();
        }
        if (this.f564k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f564k);
            jcVar.b();
        }
        if (this.f565l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f565l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f545a);
            jcVar.b();
        }
        if (this.f551a != null && t()) {
            jcVar.a(t);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f551a.size()));
            for (Map.Entry<String, String> entry : this.f551a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f550a.set(1, z);
    }

    public boolean b() {
        return this.f547a != null;
    }

    public hw c(String str) {
        this.f557d = str;
        return this;
    }

    public void c(boolean z) {
        this.f550a.set(2, z);
    }

    public boolean c() {
        return this.f554b != null;
    }

    public hw d(String str) {
        this.f558e = str;
        return this;
    }

    public void d(boolean z) {
        this.f550a.set(3, z);
    }

    public boolean d() {
        return this.f556c != null;
    }

    public void e(boolean z) {
        this.f550a.set(4, z);
    }

    public boolean e() {
        return this.f550a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m380a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f557d != null;
    }

    public boolean g() {
        return this.f558e != null;
    }

    public boolean h() {
        return this.f548a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f559f != null;
    }

    public boolean j() {
        return this.f560g != null;
    }

    public boolean k() {
        return this.f550a.get(1);
    }

    public boolean l() {
        return this.f561h != null;
    }

    public boolean m() {
        return this.f562i != null;
    }

    public boolean n() {
        return this.f563j != null;
    }

    public boolean o() {
        return this.f550a.get(2);
    }

    public boolean p() {
        return this.f550a.get(3);
    }

    public boolean q() {
        return this.f564k != null;
    }

    public boolean r() {
        return this.f565l != null;
    }

    public boolean s() {
        return this.f550a.get(4);
    }

    public boolean t() {
        return this.f551a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m379a()) {
            sb.append("debug:");
            if (this.f549a == null) {
                sb.append("null");
            } else {
                sb.append(this.f549a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f547a == null) {
                sb.append("null");
            } else {
                sb.append(this.f547a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f554b == null) {
            sb.append("null");
        } else {
            sb.append(this.f554b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f556c == null) {
            sb.append("null");
        } else {
            sb.append(this.f556c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f546a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f557d == null) {
                sb.append("null");
            } else {
                sb.append(this.f557d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f558e == null) {
                sb.append("null");
            } else {
                sb.append(this.f558e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f548a == null) {
                sb.append("null");
            } else {
                sb.append(this.f548a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f559f == null) {
                sb.append("null");
            } else {
                sb.append(this.f559f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f560g == null) {
                sb.append("null");
            } else {
                sb.append(this.f560g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f553a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f561h == null) {
                sb.append("null");
            } else {
                sb.append(this.f561h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f562i == null) {
                sb.append("null");
            } else {
                sb.append(this.f562i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f563j == null) {
                sb.append("null");
            } else {
                sb.append(this.f563j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f552a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f555b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f564k == null) {
                sb.append("null");
            } else {
                sb.append(this.f564k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f565l == null) {
                sb.append("null");
            } else {
                sb.append(this.f565l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f545a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f551a == null) {
                sb.append("null");
            } else {
                sb.append(this.f551a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
