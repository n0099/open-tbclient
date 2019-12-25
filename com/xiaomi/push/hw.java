package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class hw implements ir<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f550a;

    /* renamed from: a  reason: collision with other field name */
    public long f551a;

    /* renamed from: a  reason: collision with other field name */
    public hv f552a;

    /* renamed from: a  reason: collision with other field name */
    public ij f553a;

    /* renamed from: a  reason: collision with other field name */
    public String f554a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f556a;

    /* renamed from: a  reason: collision with other field name */
    public short f557a;

    /* renamed from: b  reason: collision with other field name */
    public String f559b;

    /* renamed from: b  reason: collision with other field name */
    public short f560b;

    /* renamed from: c  reason: collision with other field name */
    public String f561c;

    /* renamed from: d  reason: collision with other field name */
    public String f562d;

    /* renamed from: e  reason: collision with other field name */
    public String f563e;

    /* renamed from: f  reason: collision with other field name */
    public String f564f;

    /* renamed from: g  reason: collision with other field name */
    public String f565g;

    /* renamed from: h  reason: collision with other field name */
    public String f566h;

    /* renamed from: i  reason: collision with other field name */
    public String f567i;

    /* renamed from: j  reason: collision with other field name */
    public String f568j;

    /* renamed from: k  reason: collision with other field name */
    public String f569k;

    /* renamed from: l  reason: collision with other field name */
    public String f570l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f549a = new jh("XmPushActionAckMessage");
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
    private BitSet f555a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f558a = false;

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
            int compareTo = Boolean.valueOf(m365a()).compareTo(Boolean.valueOf(hwVar.m365a()));
            if (compareTo == 0) {
                if (!m365a() || (a21 = is.a(this.f554a, hwVar.f554a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = is.a(this.f552a, hwVar.f552a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = is.a(this.f559b, hwVar.f559b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = is.a(this.f561c, hwVar.f561c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = is.a(this.f551a, hwVar.f551a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = is.a(this.f562d, hwVar.f562d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = is.a(this.f563e, hwVar.f563e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = is.a(this.f553a, hwVar.f553a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = is.a(this.f564f, hwVar.f564f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = is.a(this.f565g, hwVar.f565g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = is.a(this.f558a, hwVar.f558a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = is.a(this.f566h, hwVar.f566h)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = is.a(this.f567i, hwVar.f567i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = is.a(this.f568j, hwVar.f568j)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hwVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = is.a(this.f557a, hwVar.f557a)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hwVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = is.a(this.f560b, hwVar.f560b)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hwVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = is.a(this.f569k, hwVar.f569k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hwVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = is.a(this.f570l, hwVar.f570l)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hwVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = is.a(this.f550a, hwVar.f550a)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hwVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = is.a(this.f556a, hwVar.f556a)) == 0) {
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
        this.f551a = j2;
        a(true);
        return this;
    }

    public hw a(String str) {
        this.f559b = str;
        return this;
    }

    public hw a(short s2) {
        this.f557a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f559b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f561c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f554a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f552a = new hv();
                        this.f552a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f559b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f561c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 10) {
                        this.f551a = jcVar.m453a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 11) {
                        this.f562d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f563e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 12) {
                        this.f553a = new ij();
                        this.f553a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 11) {
                        this.f564f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 11) {
                        this.f565g = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 2) {
                        this.f558a = jcVar.m463a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 11) {
                        this.f566h = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 13:
                    if (m454a.a == 11) {
                        this.f567i = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 14:
                    if (m454a.a == 11) {
                        this.f568j = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 15:
                    if (m454a.a == 6) {
                        this.f557a = jcVar.m461a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 16:
                    if (m454a.a == 6) {
                        this.f560b = jcVar.m461a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 20:
                    if (m454a.a == 11) {
                        this.f569k = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 21:
                    if (m454a.a == 11) {
                        this.f570l = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 22:
                    if (m454a.a == 8) {
                        this.f550a = jcVar.m452a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 23:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f556a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f556a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f555a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a() {
        return this.f554a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m365a = m365a();
        boolean m365a2 = hwVar.m365a();
        if ((m365a || m365a2) && !(m365a && m365a2 && this.f554a.equals(hwVar.f554a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f552a.m364a(hwVar.f552a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f559b.equals(hwVar.f559b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f561c.equals(hwVar.f561c))) || this.f551a != hwVar.f551a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f562d.equals(hwVar.f562d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f563e.equals(hwVar.f563e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f553a.m425a(hwVar.f553a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f564f.equals(hwVar.f564f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f565g.equals(hwVar.f565g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f558a == hwVar.f558a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f566h.equals(hwVar.f566h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f567i.equals(hwVar.f567i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hwVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f568j.equals(hwVar.f568j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hwVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f557a == hwVar.f557a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hwVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f560b == hwVar.f560b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hwVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f569k.equals(hwVar.f569k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hwVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f570l.equals(hwVar.f570l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hwVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f550a == hwVar.f550a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hwVar.t();
        return !(t2 || t3) || (t2 && t3 && this.f556a.equals(hwVar.f556a));
    }

    public hw b(String str) {
        this.f561c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f549a);
        if (this.f554a != null && m365a()) {
            jcVar.a(a);
            jcVar.a(this.f554a);
            jcVar.b();
        }
        if (this.f552a != null && b()) {
            jcVar.a(b);
            this.f552a.b(jcVar);
            jcVar.b();
        }
        if (this.f559b != null) {
            jcVar.a(c);
            jcVar.a(this.f559b);
            jcVar.b();
        }
        if (this.f561c != null) {
            jcVar.a(d);
            jcVar.a(this.f561c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f551a);
        jcVar.b();
        if (this.f562d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f562d);
            jcVar.b();
        }
        if (this.f563e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f563e);
            jcVar.b();
        }
        if (this.f553a != null && h()) {
            jcVar.a(h);
            this.f553a.b(jcVar);
            jcVar.b();
        }
        if (this.f564f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f564f);
            jcVar.b();
        }
        if (this.f565g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f565g);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f558a);
            jcVar.b();
        }
        if (this.f566h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f566h);
            jcVar.b();
        }
        if (this.f567i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f567i);
            jcVar.b();
        }
        if (this.f568j != null && n()) {
            jcVar.a(n);
            jcVar.a(this.f568j);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f557a);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f560b);
            jcVar.b();
        }
        if (this.f569k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f569k);
            jcVar.b();
        }
        if (this.f570l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f570l);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f550a);
            jcVar.b();
        }
        if (this.f556a != null && t()) {
            jcVar.a(t);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f556a.size()));
            for (Map.Entry<String, String> entry : this.f556a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f555a.set(1, z);
    }

    public boolean b() {
        return this.f552a != null;
    }

    public hw c(String str) {
        this.f562d = str;
        return this;
    }

    public void c(boolean z) {
        this.f555a.set(2, z);
    }

    public boolean c() {
        return this.f559b != null;
    }

    public hw d(String str) {
        this.f563e = str;
        return this;
    }

    public void d(boolean z) {
        this.f555a.set(3, z);
    }

    public boolean d() {
        return this.f561c != null;
    }

    public void e(boolean z) {
        this.f555a.set(4, z);
    }

    public boolean e() {
        return this.f555a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m366a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f562d != null;
    }

    public boolean g() {
        return this.f563e != null;
    }

    public boolean h() {
        return this.f553a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f564f != null;
    }

    public boolean j() {
        return this.f565g != null;
    }

    public boolean k() {
        return this.f555a.get(1);
    }

    public boolean l() {
        return this.f566h != null;
    }

    public boolean m() {
        return this.f567i != null;
    }

    public boolean n() {
        return this.f568j != null;
    }

    public boolean o() {
        return this.f555a.get(2);
    }

    public boolean p() {
        return this.f555a.get(3);
    }

    public boolean q() {
        return this.f569k != null;
    }

    public boolean r() {
        return this.f570l != null;
    }

    public boolean s() {
        return this.f555a.get(4);
    }

    public boolean t() {
        return this.f556a != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (m365a()) {
            sb.append("debug:");
            if (this.f554a == null) {
                sb.append("null");
            } else {
                sb.append(this.f554a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f552a == null) {
                sb.append("null");
            } else {
                sb.append(this.f552a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f559b == null) {
            sb.append("null");
        } else {
            sb.append(this.f559b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f561c == null) {
            sb.append("null");
        } else {
            sb.append(this.f561c);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f551a);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f562d == null) {
                sb.append("null");
            } else {
                sb.append(this.f562d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f563e == null) {
                sb.append("null");
            } else {
                sb.append(this.f563e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f553a == null) {
                sb.append("null");
            } else {
                sb.append(this.f553a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f564f == null) {
                sb.append("null");
            } else {
                sb.append(this.f564f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f565g == null) {
                sb.append("null");
            } else {
                sb.append(this.f565g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f558a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f566h == null) {
                sb.append("null");
            } else {
                sb.append(this.f566h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.f567i == null) {
                sb.append("null");
            } else {
                sb.append(this.f567i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f568j == null) {
                sb.append("null");
            } else {
                sb.append(this.f568j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f557a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f560b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f569k == null) {
                sb.append("null");
            } else {
                sb.append(this.f569k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f570l == null) {
                sb.append("null");
            } else {
                sb.append(this.f570l);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f550a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f556a == null) {
                sb.append("null");
            } else {
                sb.append(this.f556a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
