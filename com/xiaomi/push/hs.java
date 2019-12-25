package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class hs implements ir<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f505a;

    /* renamed from: a  reason: collision with other field name */
    public ht f506a;

    /* renamed from: a  reason: collision with other field name */
    public hv f507a;

    /* renamed from: a  reason: collision with other field name */
    public String f508a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f509a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f510a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f511b;

    /* renamed from: b  reason: collision with other field name */
    public String f512b;

    /* renamed from: c  reason: collision with other field name */
    public long f513c;

    /* renamed from: c  reason: collision with other field name */
    public String f514c;

    /* renamed from: d  reason: collision with other field name */
    public String f515d;

    /* renamed from: e  reason: collision with other field name */
    public String f516e;

    /* renamed from: f  reason: collision with other field name */
    public String f517f;

    /* renamed from: g  reason: collision with other field name */
    public String f518g;

    /* renamed from: h  reason: collision with other field name */
    public String f519h;

    /* renamed from: i  reason: collision with other field name */
    public String f520i;

    /* renamed from: j  reason: collision with other field name */
    public String f521j;

    /* renamed from: k  reason: collision with other field name */
    public String f522k;

    /* renamed from: l  reason: collision with other field name */
    public String f523l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f504a = new jh("PushMessage");
    private static final iz a = new iz("", (byte) 12, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 10, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 11);
    private static final iz l = new iz("", (byte) 12, 12);
    private static final iz m = new iz("", Constants.GZIP_CAST_TYPE, 13);
    private static final iz n = new iz("", (byte) 2, 14);
    private static final iz o = new iz("", Constants.GZIP_CAST_TYPE, 15);
    private static final iz p = new iz("", (byte) 10, 16);
    private static final iz q = new iz("", Constants.GZIP_CAST_TYPE, 20);
    private static final iz r = new iz("", Constants.GZIP_CAST_TYPE, 21);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
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
        if (getClass().equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(m346a()).compareTo(Boolean.valueOf(hsVar.m346a()));
            if (compareTo == 0) {
                if (!m346a() || (a19 = is.a(this.f507a, hsVar.f507a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m348b()).compareTo(Boolean.valueOf(hsVar.m348b()));
                    if (compareTo2 == 0) {
                        if (!m348b() || (a18 = is.a(this.f508a, hsVar.f508a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m349c()).compareTo(Boolean.valueOf(hsVar.m349c()));
                            if (compareTo3 == 0) {
                                if (!m349c() || (a17 = is.a(this.f512b, hsVar.f512b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f514c, hsVar.f514c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f505a, hsVar.f505a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f511b, hsVar.f511b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f515d, hsVar.f515d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f516e, hsVar.f516e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f517f, hsVar.f517f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f518g, hsVar.f518g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f519h, hsVar.f519h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f506a, hsVar.f506a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f520i, hsVar.f520i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f510a, hsVar.f510a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f521j, hsVar.f521j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f513c, hsVar.f513c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f522k, hsVar.f522k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f523l, hsVar.f523l)) == 0) {
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
        return getClass().getName().compareTo(hsVar.getClass().getName());
    }

    public long a() {
        return this.f505a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m344a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m345a() {
        if (this.f508a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f512b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f514c == null) {
            throw new jd("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m345a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f507a = new hv();
                        this.f507a.a(jcVar);
                        break;
                    }
                case 2:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f508a = jcVar.m459a();
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f512b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f514c = jcVar.m459a();
                        break;
                    }
                case 5:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f505a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f511b = jcVar.m453a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f515d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f516e = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f517f = jcVar.m459a();
                        break;
                    }
                case 10:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f518g = jcVar.m459a();
                        break;
                    }
                case 11:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f519h = jcVar.m459a();
                        break;
                    }
                case 12:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f506a = new ht();
                        this.f506a.a(jcVar);
                        break;
                    }
                case 13:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f520i = jcVar.m459a();
                        break;
                    }
                case 14:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f510a = jcVar.m463a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f521j = jcVar.m459a();
                        break;
                    }
                case 16:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f513c = jcVar.m453a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 20:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f522k = jcVar.m459a();
                        break;
                    }
                case 21:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f523l = jcVar.m459a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f509a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m346a() {
        return this.f507a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m346a = m346a();
        boolean m346a2 = hsVar.m346a();
        if ((m346a || m346a2) && !(m346a && m346a2 && this.f507a.m364a(hsVar.f507a))) {
            return false;
        }
        boolean m348b = m348b();
        boolean m348b2 = hsVar.m348b();
        if ((m348b || m348b2) && !(m348b && m348b2 && this.f508a.equals(hsVar.f508a))) {
            return false;
        }
        boolean m349c = m349c();
        boolean m349c2 = hsVar.m349c();
        if ((m349c || m349c2) && !(m349c && m349c2 && this.f512b.equals(hsVar.f512b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f514c.equals(hsVar.f514c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f505a == hsVar.f505a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f511b == hsVar.f511b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f515d.equals(hsVar.f515d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f516e.equals(hsVar.f516e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f517f.equals(hsVar.f517f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f518g.equals(hsVar.f518g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f519h.equals(hsVar.f519h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f506a.m356a(hsVar.f506a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f520i.equals(hsVar.f520i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f510a == hsVar.f510a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f521j.equals(hsVar.f521j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f513c == hsVar.f513c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f522k.equals(hsVar.f522k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f523l.equals(hsVar.f523l));
    }

    public String b() {
        return this.f512b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m345a();
        jcVar.a(f504a);
        if (this.f507a != null && m346a()) {
            jcVar.a(a);
            this.f507a.b(jcVar);
            jcVar.b();
        }
        if (this.f508a != null) {
            jcVar.a(b);
            jcVar.a(this.f508a);
            jcVar.b();
        }
        if (this.f512b != null) {
            jcVar.a(c);
            jcVar.a(this.f512b);
            jcVar.b();
        }
        if (this.f514c != null) {
            jcVar.a(d);
            jcVar.a(this.f514c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f505a);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f511b);
            jcVar.b();
        }
        if (this.f515d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f515d);
            jcVar.b();
        }
        if (this.f516e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f516e);
            jcVar.b();
        }
        if (this.f517f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f517f);
            jcVar.b();
        }
        if (this.f518g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f518g);
            jcVar.b();
        }
        if (this.f519h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f519h);
            jcVar.b();
        }
        if (this.f506a != null && l()) {
            jcVar.a(l);
            this.f506a.b(jcVar);
            jcVar.b();
        }
        if (this.f520i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f520i);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f510a);
            jcVar.b();
        }
        if (this.f521j != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f521j);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f513c);
            jcVar.b();
        }
        if (this.f522k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f522k);
            jcVar.b();
        }
        if (this.f523l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f523l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f509a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m348b() {
        return this.f508a != null;
    }

    public String c() {
        return this.f514c;
    }

    public void c(boolean z) {
        this.f509a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m349c() {
        return this.f512b != null;
    }

    public void d(boolean z) {
        this.f509a.set(3, z);
    }

    public boolean d() {
        return this.f514c != null;
    }

    public boolean e() {
        return this.f509a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m347a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f509a.get(1);
    }

    public boolean g() {
        return this.f515d != null;
    }

    public boolean h() {
        return this.f516e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f517f != null;
    }

    public boolean j() {
        return this.f518g != null;
    }

    public boolean k() {
        return this.f519h != null;
    }

    public boolean l() {
        return this.f506a != null;
    }

    public boolean m() {
        return this.f520i != null;
    }

    public boolean n() {
        return this.f509a.get(2);
    }

    public boolean o() {
        return this.f521j != null;
    }

    public boolean p() {
        return this.f509a.get(3);
    }

    public boolean q() {
        return this.f522k != null;
    }

    public boolean r() {
        return this.f523l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m346a()) {
            sb.append("to:");
            if (this.f507a == null) {
                sb.append("null");
            } else {
                sb.append(this.f507a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f508a == null) {
            sb.append("null");
        } else {
            sb.append(this.f508a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f512b == null) {
            sb.append("null");
        } else {
            sb.append(this.f512b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f514c == null) {
            sb.append("null");
        } else {
            sb.append(this.f514c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f505a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f511b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f515d == null) {
                sb.append("null");
            } else {
                sb.append(this.f515d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f516e == null) {
                sb.append("null");
            } else {
                sb.append(this.f516e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f517f == null) {
                sb.append("null");
            } else {
                sb.append(this.f517f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f518g == null) {
                sb.append("null");
            } else {
                sb.append(this.f518g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f519h == null) {
                sb.append("null");
            } else {
                sb.append(this.f519h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f506a == null) {
                sb.append("null");
            } else {
                sb.append(this.f506a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f520i == null) {
                sb.append("null");
            } else {
                sb.append(this.f520i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f510a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f521j == null) {
                sb.append("null");
            } else {
                sb.append(this.f521j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f513c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f522k == null) {
                sb.append("null");
            } else {
                sb.append(this.f522k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f523l == null) {
                sb.append("null");
            } else {
                sb.append(this.f523l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
