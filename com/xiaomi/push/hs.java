package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hs implements ir<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f501a;

    /* renamed from: a  reason: collision with other field name */
    public ht f502a;

    /* renamed from: a  reason: collision with other field name */
    public hv f503a;

    /* renamed from: a  reason: collision with other field name */
    public String f504a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f505a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f506a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f507b;

    /* renamed from: b  reason: collision with other field name */
    public String f508b;

    /* renamed from: c  reason: collision with other field name */
    public long f509c;

    /* renamed from: c  reason: collision with other field name */
    public String f510c;

    /* renamed from: d  reason: collision with other field name */
    public String f511d;

    /* renamed from: e  reason: collision with other field name */
    public String f512e;

    /* renamed from: f  reason: collision with other field name */
    public String f513f;

    /* renamed from: g  reason: collision with other field name */
    public String f514g;

    /* renamed from: h  reason: collision with other field name */
    public String f515h;

    /* renamed from: i  reason: collision with other field name */
    public String f516i;

    /* renamed from: j  reason: collision with other field name */
    public String f517j;

    /* renamed from: k  reason: collision with other field name */
    public String f518k;

    /* renamed from: l  reason: collision with other field name */
    public String f519l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f500a = new jh("PushMessage");
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
            int compareTo = Boolean.valueOf(m363a()).compareTo(Boolean.valueOf(hsVar.m363a()));
            if (compareTo == 0) {
                if (!m363a() || (a19 = is.a(this.f503a, hsVar.f503a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m365b()).compareTo(Boolean.valueOf(hsVar.m365b()));
                    if (compareTo2 == 0) {
                        if (!m365b() || (a18 = is.a(this.f504a, hsVar.f504a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m366c()).compareTo(Boolean.valueOf(hsVar.m366c()));
                            if (compareTo3 == 0) {
                                if (!m366c() || (a17 = is.a(this.f508b, hsVar.f508b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f510c, hsVar.f510c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f501a, hsVar.f501a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f507b, hsVar.f507b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f511d, hsVar.f511d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f512e, hsVar.f512e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f513f, hsVar.f513f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f514g, hsVar.f514g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f515h, hsVar.f515h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f502a, hsVar.f502a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f516i, hsVar.f516i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f506a, hsVar.f506a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f517j, hsVar.f517j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f509c, hsVar.f509c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f518k, hsVar.f518k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f519l, hsVar.f519l)) == 0) {
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
        return this.f501a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m361a() {
        return this.f504a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m362a() {
        if (this.f504a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f508b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f510c == null) {
            throw new jd("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m362a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a != 12) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f503a = new hv();
                        this.f503a.a(jcVar);
                        break;
                    }
                case 2:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f504a = jcVar.m476a();
                        break;
                    }
                case 3:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f508b = jcVar.m476a();
                        break;
                    }
                case 4:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f510c = jcVar.m476a();
                        break;
                    }
                case 5:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f501a = jcVar.m470a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f507b = jcVar.m470a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f511d = jcVar.m476a();
                        break;
                    }
                case 8:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f512e = jcVar.m476a();
                        break;
                    }
                case 9:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f513f = jcVar.m476a();
                        break;
                    }
                case 10:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f514g = jcVar.m476a();
                        break;
                    }
                case 11:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f515h = jcVar.m476a();
                        break;
                    }
                case 12:
                    if (m471a.a != 12) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f502a = new ht();
                        this.f502a.a(jcVar);
                        break;
                    }
                case 13:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f516i = jcVar.m476a();
                        break;
                    }
                case 14:
                    if (m471a.a != 2) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f506a = jcVar.m480a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f517j = jcVar.m476a();
                        break;
                    }
                case 16:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f509c = jcVar.m470a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m471a.a);
                    break;
                case 20:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f518k = jcVar.m476a();
                        break;
                    }
                case 21:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f519l = jcVar.m476a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f505a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m363a() {
        return this.f503a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m363a = m363a();
        boolean m363a2 = hsVar.m363a();
        if ((m363a || m363a2) && !(m363a && m363a2 && this.f503a.m381a(hsVar.f503a))) {
            return false;
        }
        boolean m365b = m365b();
        boolean m365b2 = hsVar.m365b();
        if ((m365b || m365b2) && !(m365b && m365b2 && this.f504a.equals(hsVar.f504a))) {
            return false;
        }
        boolean m366c = m366c();
        boolean m366c2 = hsVar.m366c();
        if ((m366c || m366c2) && !(m366c && m366c2 && this.f508b.equals(hsVar.f508b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f510c.equals(hsVar.f510c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f501a == hsVar.f501a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f507b == hsVar.f507b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f511d.equals(hsVar.f511d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f512e.equals(hsVar.f512e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f513f.equals(hsVar.f513f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f514g.equals(hsVar.f514g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f515h.equals(hsVar.f515h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f502a.m373a(hsVar.f502a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f516i.equals(hsVar.f516i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f506a == hsVar.f506a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f517j.equals(hsVar.f517j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f509c == hsVar.f509c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f518k.equals(hsVar.f518k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f519l.equals(hsVar.f519l));
    }

    public String b() {
        return this.f508b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m362a();
        jcVar.a(f500a);
        if (this.f503a != null && m363a()) {
            jcVar.a(a);
            this.f503a.b(jcVar);
            jcVar.b();
        }
        if (this.f504a != null) {
            jcVar.a(b);
            jcVar.a(this.f504a);
            jcVar.b();
        }
        if (this.f508b != null) {
            jcVar.a(c);
            jcVar.a(this.f508b);
            jcVar.b();
        }
        if (this.f510c != null) {
            jcVar.a(d);
            jcVar.a(this.f510c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f501a);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f507b);
            jcVar.b();
        }
        if (this.f511d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f511d);
            jcVar.b();
        }
        if (this.f512e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f512e);
            jcVar.b();
        }
        if (this.f513f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f513f);
            jcVar.b();
        }
        if (this.f514g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f514g);
            jcVar.b();
        }
        if (this.f515h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f515h);
            jcVar.b();
        }
        if (this.f502a != null && l()) {
            jcVar.a(l);
            this.f502a.b(jcVar);
            jcVar.b();
        }
        if (this.f516i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f516i);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f506a);
            jcVar.b();
        }
        if (this.f517j != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f517j);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f509c);
            jcVar.b();
        }
        if (this.f518k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f518k);
            jcVar.b();
        }
        if (this.f519l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f519l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public void b(boolean z) {
        this.f505a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m365b() {
        return this.f504a != null;
    }

    public String c() {
        return this.f510c;
    }

    public void c(boolean z) {
        this.f505a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m366c() {
        return this.f508b != null;
    }

    public void d(boolean z) {
        this.f505a.set(3, z);
    }

    public boolean d() {
        return this.f510c != null;
    }

    public boolean e() {
        return this.f505a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m364a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f505a.get(1);
    }

    public boolean g() {
        return this.f511d != null;
    }

    public boolean h() {
        return this.f512e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f513f != null;
    }

    public boolean j() {
        return this.f514g != null;
    }

    public boolean k() {
        return this.f515h != null;
    }

    public boolean l() {
        return this.f502a != null;
    }

    public boolean m() {
        return this.f516i != null;
    }

    public boolean n() {
        return this.f505a.get(2);
    }

    public boolean o() {
        return this.f517j != null;
    }

    public boolean p() {
        return this.f505a.get(3);
    }

    public boolean q() {
        return this.f518k != null;
    }

    public boolean r() {
        return this.f519l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m363a()) {
            sb.append("to:");
            if (this.f503a == null) {
                sb.append("null");
            } else {
                sb.append(this.f503a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f504a == null) {
            sb.append("null");
        } else {
            sb.append(this.f504a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f508b == null) {
            sb.append("null");
        } else {
            sb.append(this.f508b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f510c == null) {
            sb.append("null");
        } else {
            sb.append(this.f510c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f501a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f507b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f511d == null) {
                sb.append("null");
            } else {
                sb.append(this.f511d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f512e == null) {
                sb.append("null");
            } else {
                sb.append(this.f512e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f513f == null) {
                sb.append("null");
            } else {
                sb.append(this.f513f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f514g == null) {
                sb.append("null");
            } else {
                sb.append(this.f514g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f515h == null) {
                sb.append("null");
            } else {
                sb.append(this.f515h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f502a == null) {
                sb.append("null");
            } else {
                sb.append(this.f502a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f516i == null) {
                sb.append("null");
            } else {
                sb.append(this.f516i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f506a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f517j == null) {
                sb.append("null");
            } else {
                sb.append(this.f517j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f509c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f518k == null) {
                sb.append("null");
            } else {
                sb.append(this.f518k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f519l == null) {
                sb.append("null");
            } else {
                sb.append(this.f519l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
