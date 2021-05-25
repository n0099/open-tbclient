package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class hv implements iq<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f562a;

    /* renamed from: a  reason: collision with other field name */
    public long f563a;

    /* renamed from: a  reason: collision with other field name */
    public hu f564a;

    /* renamed from: a  reason: collision with other field name */
    public ii f565a;

    /* renamed from: a  reason: collision with other field name */
    public String f566a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f568a;

    /* renamed from: a  reason: collision with other field name */
    public short f569a;

    /* renamed from: b  reason: collision with other field name */
    public String f571b;

    /* renamed from: b  reason: collision with other field name */
    public short f572b;

    /* renamed from: c  reason: collision with other field name */
    public String f573c;

    /* renamed from: d  reason: collision with other field name */
    public String f574d;

    /* renamed from: e  reason: collision with other field name */
    public String f575e;

    /* renamed from: f  reason: collision with other field name */
    public String f576f;

    /* renamed from: g  reason: collision with other field name */
    public String f577g;

    /* renamed from: h  reason: collision with other field name */
    public String f578h;

    /* renamed from: i  reason: collision with other field name */
    public String f579i;

    /* renamed from: j  reason: collision with other field name */
    public String f580j;

    /* renamed from: k  reason: collision with other field name */
    public String f581k;

    /* renamed from: l  reason: collision with other field name */
    public String f582l;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f561a = new jg("XmPushActionAckMessage");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f37805a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f37806b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f37807c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f37808d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f37809e = new iy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f37810f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f37811g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f37812h = new iy("", StandardMessageCodec.LIST, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f37813i = new iy("", (byte) 11, 9);
    public static final iy j = new iy("", (byte) 11, 10);
    public static final iy k = new iy("", (byte) 2, 11);
    public static final iy l = new iy("", (byte) 11, 12);
    public static final iy m = new iy("", (byte) 11, 13);
    public static final iy n = new iy("", (byte) 11, 14);
    public static final iy o = new iy("", (byte) 6, 15);
    public static final iy p = new iy("", (byte) 6, 16);
    public static final iy q = new iy("", (byte) 11, 20);
    public static final iy r = new iy("", (byte) 11, 21);
    public static final iy s = new iy("", (byte) 8, 22);
    public static final iy t = new iy("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f567a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f570a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
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
        if (hv.class.equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m407a()).compareTo(Boolean.valueOf(hvVar.m407a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m407a() || (a21 = ir.a(this.f566a, hvVar.f566a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a20 = ir.a(this.f564a, hvVar.f564a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a19 = ir.a(this.f571b, hvVar.f571b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = ir.a(this.f573c, hvVar.f573c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = ir.a(this.f563a, hvVar.f563a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = ir.a(this.f574d, hvVar.f574d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hvVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = ir.a(this.f575e, hvVar.f575e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hvVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = ir.a(this.f565a, hvVar.f565a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hvVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = ir.a(this.f576f, hvVar.f576f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hvVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = ir.a(this.f577g, hvVar.f577g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hvVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = ir.a(this.f570a, hvVar.f570a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hvVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = ir.a(this.f578h, hvVar.f578h)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hvVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = ir.a(this.f579i, hvVar.f579i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hvVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = ir.a(this.f580j, hvVar.f580j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hvVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = ir.a(this.f569a, hvVar.f569a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hvVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = ir.a(this.f572b, hvVar.f572b)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hvVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = ir.a(this.f581k, hvVar.f581k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hvVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = ir.a(this.f582l, hvVar.f582l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hvVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = ir.a(this.f562a, hvVar.f562a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hvVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = ir.a(this.f568a, hvVar.f568a)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return a3;
                                                                                }
                                                                                return a4;
                                                                            }
                                                                            return a5;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return a7;
                                                                }
                                                                return a8;
                                                            }
                                                            return a9;
                                                        }
                                                        return a10;
                                                    }
                                                    return a11;
                                                }
                                                return a12;
                                            }
                                            return a13;
                                        }
                                        return a14;
                                    }
                                    return a15;
                                }
                                return a16;
                            }
                            return a17;
                        }
                        return a18;
                    }
                    return a19;
                }
                return a20;
            }
            return a21;
        }
        return hv.class.getName().compareTo(hvVar.getClass().getName());
    }

    public hv a(long j2) {
        this.f563a = j2;
        a(true);
        return this;
    }

    public hv a(String str) {
        this.f571b = str;
        return this;
    }

    public hv a(short s2) {
        this.f569a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f571b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f573c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f37969a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (m507a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f566a = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f564a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f571b = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f573c = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f563a = jbVar.m506a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f574d = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f575e = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ii iiVar = new ii();
                        this.f565a = iiVar;
                        iiVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f576f = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f577g = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f570a = jbVar.m516a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f578h = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f579i = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f580j = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f569a = jbVar.m514a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f572b = jbVar.m514a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f581k = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f582l = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f562a = jbVar.m505a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        ja m509a = jbVar.m509a();
                        this.f568a = new HashMap(m509a.f811a * 2);
                        for (int i2 = 0; i2 < m509a.f811a; i2++) {
                            this.f568a.put(jbVar.m512a(), jbVar.m512a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        this.f567a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a() {
        return this.f566a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m408a(hv hvVar) {
        if (hvVar == null) {
            return false;
        }
        boolean m407a = m407a();
        boolean m407a2 = hvVar.m407a();
        if ((m407a || m407a2) && !(m407a && m407a2 && this.f566a.equals(hvVar.f566a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hvVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f564a.m406a(hvVar.f564a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hvVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f571b.equals(hvVar.f571b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hvVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f573c.equals(hvVar.f573c))) || this.f563a != hvVar.f563a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hvVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f574d.equals(hvVar.f574d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hvVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f575e.equals(hvVar.f575e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hvVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f565a.m476a(hvVar.f565a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hvVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f576f.equals(hvVar.f576f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hvVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f577g.equals(hvVar.f577g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hvVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f570a == hvVar.f570a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hvVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f578h.equals(hvVar.f578h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hvVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f579i.equals(hvVar.f579i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hvVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f580j.equals(hvVar.f580j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hvVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f569a == hvVar.f569a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hvVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f572b == hvVar.f572b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hvVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f581k.equals(hvVar.f581k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hvVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f582l.equals(hvVar.f582l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hvVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f562a == hvVar.f562a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hvVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f568a.equals(hvVar.f568a);
        }
        return true;
    }

    public hv b(String str) {
        this.f573c = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f561a);
        if (this.f566a != null && m407a()) {
            jbVar.a(f37805a);
            jbVar.a(this.f566a);
            jbVar.b();
        }
        if (this.f564a != null && b()) {
            jbVar.a(f37806b);
            this.f564a.b(jbVar);
            jbVar.b();
        }
        if (this.f571b != null) {
            jbVar.a(f37807c);
            jbVar.a(this.f571b);
            jbVar.b();
        }
        if (this.f573c != null) {
            jbVar.a(f37808d);
            jbVar.a(this.f573c);
            jbVar.b();
        }
        jbVar.a(f37809e);
        jbVar.a(this.f563a);
        jbVar.b();
        if (this.f574d != null && f()) {
            jbVar.a(f37810f);
            jbVar.a(this.f574d);
            jbVar.b();
        }
        if (this.f575e != null && g()) {
            jbVar.a(f37811g);
            jbVar.a(this.f575e);
            jbVar.b();
        }
        if (this.f565a != null && h()) {
            jbVar.a(f37812h);
            this.f565a.b(jbVar);
            jbVar.b();
        }
        if (this.f576f != null && i()) {
            jbVar.a(f37813i);
            jbVar.a(this.f576f);
            jbVar.b();
        }
        if (this.f577g != null && j()) {
            jbVar.a(j);
            jbVar.a(this.f577g);
            jbVar.b();
        }
        if (k()) {
            jbVar.a(k);
            jbVar.a(this.f570a);
            jbVar.b();
        }
        if (this.f578h != null && l()) {
            jbVar.a(l);
            jbVar.a(this.f578h);
            jbVar.b();
        }
        if (this.f579i != null && m()) {
            jbVar.a(m);
            jbVar.a(this.f579i);
            jbVar.b();
        }
        if (this.f580j != null && n()) {
            jbVar.a(n);
            jbVar.a(this.f580j);
            jbVar.b();
        }
        if (o()) {
            jbVar.a(o);
            jbVar.a(this.f569a);
            jbVar.b();
        }
        if (p()) {
            jbVar.a(p);
            jbVar.a(this.f572b);
            jbVar.b();
        }
        if (this.f581k != null && q()) {
            jbVar.a(q);
            jbVar.a(this.f581k);
            jbVar.b();
        }
        if (this.f582l != null && r()) {
            jbVar.a(r);
            jbVar.a(this.f582l);
            jbVar.b();
        }
        if (s()) {
            jbVar.a(s);
            jbVar.a(this.f562a);
            jbVar.b();
        }
        if (this.f568a != null && t()) {
            jbVar.a(t);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f568a.size()));
            for (Map.Entry<String, String> entry : this.f568a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m515a();
    }

    public void b(boolean z) {
        this.f567a.set(1, z);
    }

    public boolean b() {
        return this.f564a != null;
    }

    public hv c(String str) {
        this.f574d = str;
        return this;
    }

    public void c(boolean z) {
        this.f567a.set(2, z);
    }

    public boolean c() {
        return this.f571b != null;
    }

    public hv d(String str) {
        this.f575e = str;
        return this;
    }

    public void d(boolean z) {
        this.f567a.set(3, z);
    }

    public boolean d() {
        return this.f573c != null;
    }

    public void e(boolean z) {
        this.f567a.set(4, z);
    }

    public boolean e() {
        return this.f567a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m408a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f574d != null;
    }

    public boolean g() {
        return this.f575e != null;
    }

    public boolean h() {
        return this.f565a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f576f != null;
    }

    public boolean j() {
        return this.f577g != null;
    }

    public boolean k() {
        return this.f567a.get(1);
    }

    public boolean l() {
        return this.f578h != null;
    }

    public boolean m() {
        return this.f579i != null;
    }

    public boolean n() {
        return this.f580j != null;
    }

    public boolean o() {
        return this.f567a.get(2);
    }

    public boolean p() {
        return this.f567a.get(3);
    }

    public boolean q() {
        return this.f581k != null;
    }

    public boolean r() {
        return this.f582l != null;
    }

    public boolean s() {
        return this.f567a.get(4);
    }

    public boolean t() {
        return this.f568a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m407a()) {
            sb.append("debug:");
            String str = this.f566a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f564a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f571b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f573c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f563a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f574d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str5 = this.f575e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("request:");
            ii iiVar = this.f565a;
            if (iiVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(iiVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f576f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f577g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isOnline:");
            sb.append(this.f570a);
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f578h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("callbackUrl:");
            String str9 = this.f579i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str10 = this.f580j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceStatus:");
            sb.append((int) this.f569a);
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("geoMsgStatus:");
            sb.append((int) this.f572b);
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str11 = this.f581k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str12 = this.f582l;
            if (str12 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f562a);
        }
        if (t()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f568a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
