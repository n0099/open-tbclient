package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hw implements ir<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f548a;

    /* renamed from: a  reason: collision with other field name */
    public long f549a;

    /* renamed from: a  reason: collision with other field name */
    public hv f550a;

    /* renamed from: a  reason: collision with other field name */
    public ij f551a;

    /* renamed from: a  reason: collision with other field name */
    public String f552a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f554a;

    /* renamed from: a  reason: collision with other field name */
    public short f555a;

    /* renamed from: b  reason: collision with other field name */
    public String f557b;

    /* renamed from: b  reason: collision with other field name */
    public short f558b;

    /* renamed from: c  reason: collision with other field name */
    public String f559c;

    /* renamed from: d  reason: collision with other field name */
    public String f560d;

    /* renamed from: e  reason: collision with other field name */
    public String f561e;

    /* renamed from: f  reason: collision with other field name */
    public String f562f;

    /* renamed from: g  reason: collision with other field name */
    public String f563g;

    /* renamed from: h  reason: collision with other field name */
    public String f564h;

    /* renamed from: i  reason: collision with other field name */
    public String f565i;

    /* renamed from: j  reason: collision with other field name */
    public String f566j;

    /* renamed from: k  reason: collision with other field name */
    public String f567k;

    /* renamed from: l  reason: collision with other field name */
    public String f568l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f547a = new jh("XmPushActionAckMessage");
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
    private BitSet f553a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f556a = false;

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
            int compareTo = Boolean.valueOf(m374a()).compareTo(Boolean.valueOf(hwVar.m374a()));
            if (compareTo == 0) {
                if (!m374a() || (a21 = is.a(this.f552a, hwVar.f552a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = is.a(this.f550a, hwVar.f550a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = is.a(this.f557b, hwVar.f557b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = is.a(this.f559c, hwVar.f559c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = is.a(this.f549a, hwVar.f549a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = is.a(this.f560d, hwVar.f560d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = is.a(this.f561e, hwVar.f561e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = is.a(this.f551a, hwVar.f551a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = is.a(this.f562f, hwVar.f562f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = is.a(this.f563g, hwVar.f563g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = is.a(this.f556a, hwVar.f556a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = is.a(this.f564h, hwVar.f564h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = is.a(this.f565i, hwVar.f565i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = is.a(this.f566j, hwVar.f566j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hwVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = is.a(this.f555a, hwVar.f555a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hwVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = is.a(this.f558b, hwVar.f558b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hwVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = is.a(this.f567k, hwVar.f567k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hwVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = is.a(this.f568l, hwVar.f568l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hwVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = is.a(this.f548a, hwVar.f548a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hwVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = is.a(this.f554a, hwVar.f554a)) == 0) {
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
        this.f549a = j2;
        a(true);
        return this;
    }

    public hw a(String str) {
        this.f557b = str;
        return this;
    }

    public hw a(short s2) {
        this.f555a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f557b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f559c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f552a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f550a = new hv();
                        this.f550a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f557b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f559c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 10) {
                        this.f549a = jcVar.m462a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 11) {
                        this.f560d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f561e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 12) {
                        this.f551a = new ij();
                        this.f551a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 11) {
                        this.f562f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 11) {
                        this.f563g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 2) {
                        this.f556a = jcVar.m472a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 11) {
                        this.f564h = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 13:
                    if (m463a.a == 11) {
                        this.f565i = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 14:
                    if (m463a.a == 11) {
                        this.f566j = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 15:
                    if (m463a.a == 6) {
                        this.f555a = jcVar.m470a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 16:
                    if (m463a.a == 6) {
                        this.f558b = jcVar.m470a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 20:
                    if (m463a.a == 11) {
                        this.f567k = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 21:
                    if (m463a.a == 11) {
                        this.f568l = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 22:
                    if (m463a.a == 8) {
                        this.f548a = jcVar.m461a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 23:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f554a = new HashMap(m465a.f795a * 2);
                        for (int i2 = 0; i2 < m465a.f795a; i2++) {
                            this.f554a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f553a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m374a() {
        return this.f552a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m374a = m374a();
        boolean m374a2 = hwVar.m374a();
        if ((m374a || m374a2) && !(m374a && m374a2 && this.f552a.equals(hwVar.f552a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f550a.m373a(hwVar.f550a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f557b.equals(hwVar.f557b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f559c.equals(hwVar.f559c))) || this.f549a != hwVar.f549a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f560d.equals(hwVar.f560d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f561e.equals(hwVar.f561e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f551a.m434a(hwVar.f551a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f562f.equals(hwVar.f562f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f563g.equals(hwVar.f563g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f556a == hwVar.f556a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f564h.equals(hwVar.f564h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f565i.equals(hwVar.f565i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hwVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f566j.equals(hwVar.f566j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hwVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f555a == hwVar.f555a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hwVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f558b == hwVar.f558b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hwVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f567k.equals(hwVar.f567k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hwVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f568l.equals(hwVar.f568l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hwVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f548a == hwVar.f548a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hwVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f554a.equals(hwVar.f554a));
    }

    public hw b(String str) {
        this.f559c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f547a);
        if (this.f552a != null && m374a()) {
            jcVar.a(a);
            jcVar.a(this.f552a);
            jcVar.b();
        }
        if (this.f550a != null && b()) {
            jcVar.a(b);
            this.f550a.b(jcVar);
            jcVar.b();
        }
        if (this.f557b != null) {
            jcVar.a(c);
            jcVar.a(this.f557b);
            jcVar.b();
        }
        if (this.f559c != null) {
            jcVar.a(d);
            jcVar.a(this.f559c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f549a);
        jcVar.b();
        if (this.f560d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f560d);
            jcVar.b();
        }
        if (this.f561e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f561e);
            jcVar.b();
        }
        if (this.f551a != null && h()) {
            jcVar.a(h);
            this.f551a.b(jcVar);
            jcVar.b();
        }
        if (this.f562f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f562f);
            jcVar.b();
        }
        if (this.f563g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f563g);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f556a);
            jcVar.b();
        }
        if (this.f564h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f564h);
            jcVar.b();
        }
        if (this.f565i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f565i);
            jcVar.b();
        }
        if (this.f566j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f566j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f555a);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f558b);
            jcVar.b();
        }
        if (this.f567k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f567k);
            jcVar.b();
        }
        if (this.f568l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f568l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f548a);
            jcVar.b();
        }
        if (this.f554a != null && t()) {
            jcVar.a(t);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f554a.size()));
            for (Map.Entry<String, String> entry : this.f554a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f553a.set(1, z);
    }

    public boolean b() {
        return this.f550a != null;
    }

    public hw c(String str) {
        this.f560d = str;
        return this;
    }

    public void c(boolean z) {
        this.f553a.set(2, z);
    }

    public boolean c() {
        return this.f557b != null;
    }

    public hw d(String str) {
        this.f561e = str;
        return this;
    }

    public void d(boolean z) {
        this.f553a.set(3, z);
    }

    public boolean d() {
        return this.f559c != null;
    }

    public void e(boolean z) {
        this.f553a.set(4, z);
    }

    public boolean e() {
        return this.f553a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m375a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f560d != null;
    }

    public boolean g() {
        return this.f561e != null;
    }

    public boolean h() {
        return this.f551a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f562f != null;
    }

    public boolean j() {
        return this.f563g != null;
    }

    public boolean k() {
        return this.f553a.get(1);
    }

    public boolean l() {
        return this.f564h != null;
    }

    public boolean m() {
        return this.f565i != null;
    }

    public boolean n() {
        return this.f566j != null;
    }

    public boolean o() {
        return this.f553a.get(2);
    }

    public boolean p() {
        return this.f553a.get(3);
    }

    public boolean q() {
        return this.f567k != null;
    }

    public boolean r() {
        return this.f568l != null;
    }

    public boolean s() {
        return this.f553a.get(4);
    }

    public boolean t() {
        return this.f554a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m374a()) {
            sb.append("debug:");
            if (this.f552a == null) {
                sb.append("null");
            } else {
                sb.append(this.f552a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f550a == null) {
                sb.append("null");
            } else {
                sb.append(this.f550a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f557b == null) {
            sb.append("null");
        } else {
            sb.append(this.f557b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f559c == null) {
            sb.append("null");
        } else {
            sb.append(this.f559c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f549a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f560d == null) {
                sb.append("null");
            } else {
                sb.append(this.f560d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f561e == null) {
                sb.append("null");
            } else {
                sb.append(this.f561e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f551a == null) {
                sb.append("null");
            } else {
                sb.append(this.f551a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f562f == null) {
                sb.append("null");
            } else {
                sb.append(this.f562f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f563g == null) {
                sb.append("null");
            } else {
                sb.append(this.f563g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f556a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f564h == null) {
                sb.append("null");
            } else {
                sb.append(this.f564h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f565i == null) {
                sb.append("null");
            } else {
                sb.append(this.f565i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f566j == null) {
                sb.append("null");
            } else {
                sb.append(this.f566j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f555a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f558b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f567k == null) {
                sb.append("null");
            } else {
                sb.append(this.f567k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f568l == null) {
                sb.append("null");
            } else {
                sb.append(this.f568l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f548a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f554a == null) {
                sb.append("null");
            } else {
                sb.append(this.f554a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
