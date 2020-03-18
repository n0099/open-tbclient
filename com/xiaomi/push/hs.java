package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hs implements ir<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f500a;

    /* renamed from: a  reason: collision with other field name */
    public ht f501a;

    /* renamed from: a  reason: collision with other field name */
    public hv f502a;

    /* renamed from: a  reason: collision with other field name */
    public String f503a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f504a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f505a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f506b;

    /* renamed from: b  reason: collision with other field name */
    public String f507b;

    /* renamed from: c  reason: collision with other field name */
    public long f508c;

    /* renamed from: c  reason: collision with other field name */
    public String f509c;

    /* renamed from: d  reason: collision with other field name */
    public String f510d;

    /* renamed from: e  reason: collision with other field name */
    public String f511e;

    /* renamed from: f  reason: collision with other field name */
    public String f512f;

    /* renamed from: g  reason: collision with other field name */
    public String f513g;

    /* renamed from: h  reason: collision with other field name */
    public String f514h;

    /* renamed from: i  reason: collision with other field name */
    public String f515i;

    /* renamed from: j  reason: collision with other field name */
    public String f516j;

    /* renamed from: k  reason: collision with other field name */
    public String f517k;

    /* renamed from: l  reason: collision with other field name */
    public String f518l;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f499a = new jh("PushMessage");
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
            int compareTo = Boolean.valueOf(m358a()).compareTo(Boolean.valueOf(hsVar.m358a()));
            if (compareTo == 0) {
                if (!m358a() || (a19 = is.a(this.f502a, hsVar.f502a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m360b()).compareTo(Boolean.valueOf(hsVar.m360b()));
                    if (compareTo2 == 0) {
                        if (!m360b() || (a18 = is.a(this.f503a, hsVar.f503a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m361c()).compareTo(Boolean.valueOf(hsVar.m361c()));
                            if (compareTo3 == 0) {
                                if (!m361c() || (a17 = is.a(this.f507b, hsVar.f507b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a16 = is.a(this.f509c, hsVar.f509c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a15 = is.a(this.f500a, hsVar.f500a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a14 = is.a(this.f506b, hsVar.f506b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a13 = is.a(this.f510d, hsVar.f510d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a12 = is.a(this.f511e, hsVar.f511e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a11 = is.a(this.f512f, hsVar.f512f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a10 = is.a(this.f513g, hsVar.f513g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a9 = is.a(this.f514h, hsVar.f514h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a8 = is.a(this.f501a, hsVar.f501a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a7 = is.a(this.f515i, hsVar.f515i)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a6 = is.a(this.f505a, hsVar.f505a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a5 = is.a(this.f516j, hsVar.f516j)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a4 = is.a(this.f508c, hsVar.f508c)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a3 = is.a(this.f517k, hsVar.f517k)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a2 = is.a(this.f518l, hsVar.f518l)) == 0) {
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
        return this.f500a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m356a() {
        return this.f503a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m357a() {
        if (this.f503a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f507b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f509c == null) {
            throw new jd("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                m357a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a != 12) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f502a = new hv();
                        this.f502a.a(jcVar);
                        break;
                    }
                case 2:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f503a = jcVar.m471a();
                        break;
                    }
                case 3:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f507b = jcVar.m471a();
                        break;
                    }
                case 4:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f509c = jcVar.m471a();
                        break;
                    }
                case 5:
                    if (m466a.a != 10) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f500a = jcVar.m465a();
                        a(true);
                        break;
                    }
                case 6:
                    if (m466a.a != 10) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f506b = jcVar.m465a();
                        b(true);
                        break;
                    }
                case 7:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f510d = jcVar.m471a();
                        break;
                    }
                case 8:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f511e = jcVar.m471a();
                        break;
                    }
                case 9:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f512f = jcVar.m471a();
                        break;
                    }
                case 10:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f513g = jcVar.m471a();
                        break;
                    }
                case 11:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f514h = jcVar.m471a();
                        break;
                    }
                case 12:
                    if (m466a.a != 12) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f501a = new ht();
                        this.f501a.a(jcVar);
                        break;
                    }
                case 13:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f515i = jcVar.m471a();
                        break;
                    }
                case 14:
                    if (m466a.a != 2) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f505a = jcVar.m475a();
                        c(true);
                        break;
                    }
                case 15:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f516j = jcVar.m471a();
                        break;
                    }
                case 16:
                    if (m466a.a != 10) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f508c = jcVar.m465a();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m466a.a);
                    break;
                case 20:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f517k = jcVar.m471a();
                        break;
                    }
                case 21:
                    if (m466a.a != 11) {
                        jf.a(jcVar, m466a.a);
                        break;
                    } else {
                        this.f518l = jcVar.m471a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f504a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m358a() {
        return this.f502a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m358a = m358a();
        boolean m358a2 = hsVar.m358a();
        if ((m358a || m358a2) && !(m358a && m358a2 && this.f502a.m376a(hsVar.f502a))) {
            return false;
        }
        boolean m360b = m360b();
        boolean m360b2 = hsVar.m360b();
        if ((m360b || m360b2) && !(m360b && m360b2 && this.f503a.equals(hsVar.f503a))) {
            return false;
        }
        boolean m361c = m361c();
        boolean m361c2 = hsVar.m361c();
        if ((m361c || m361c2) && !(m361c && m361c2 && this.f507b.equals(hsVar.f507b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f509c.equals(hsVar.f509c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f500a == hsVar.f500a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f506b == hsVar.f506b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f510d.equals(hsVar.f510d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f511e.equals(hsVar.f511e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f512f.equals(hsVar.f512f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f513g.equals(hsVar.f513g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f514h.equals(hsVar.f514h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f501a.m368a(hsVar.f501a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f515i.equals(hsVar.f515i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f505a == hsVar.f505a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f516j.equals(hsVar.f516j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f508c == hsVar.f508c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f517k.equals(hsVar.f517k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        return !(r2 || r3) || (r2 && r3 && this.f518l.equals(hsVar.f518l));
    }

    public String b() {
        return this.f507b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m357a();
        jcVar.a(f499a);
        if (this.f502a != null && m358a()) {
            jcVar.a(a);
            this.f502a.b(jcVar);
            jcVar.b();
        }
        if (this.f503a != null) {
            jcVar.a(b);
            jcVar.a(this.f503a);
            jcVar.b();
        }
        if (this.f507b != null) {
            jcVar.a(c);
            jcVar.a(this.f507b);
            jcVar.b();
        }
        if (this.f509c != null) {
            jcVar.a(d);
            jcVar.a(this.f509c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f500a);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f506b);
            jcVar.b();
        }
        if (this.f510d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f510d);
            jcVar.b();
        }
        if (this.f511e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f511e);
            jcVar.b();
        }
        if (this.f512f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f512f);
            jcVar.b();
        }
        if (this.f513g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f513g);
            jcVar.b();
        }
        if (this.f514h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f514h);
            jcVar.b();
        }
        if (this.f501a != null && l()) {
            jcVar.a(l);
            this.f501a.b(jcVar);
            jcVar.b();
        }
        if (this.f515i != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f515i);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f505a);
            jcVar.b();
        }
        if (this.f516j != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f516j);
            jcVar.b();
        }
        if (p()) {
            jcVar.a(p);
            jcVar.a(this.f508c);
            jcVar.b();
        }
        if (this.f517k != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f517k);
            jcVar.b();
        }
        if (this.f518l != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f518l);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public void b(boolean z) {
        this.f504a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m360b() {
        return this.f503a != null;
    }

    public String c() {
        return this.f509c;
    }

    public void c(boolean z) {
        this.f504a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m361c() {
        return this.f507b != null;
    }

    public void d(boolean z) {
        this.f504a.set(3, z);
    }

    public boolean d() {
        return this.f509c != null;
    }

    public boolean e() {
        return this.f504a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m359a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f504a.get(1);
    }

    public boolean g() {
        return this.f510d != null;
    }

    public boolean h() {
        return this.f511e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f512f != null;
    }

    public boolean j() {
        return this.f513g != null;
    }

    public boolean k() {
        return this.f514h != null;
    }

    public boolean l() {
        return this.f501a != null;
    }

    public boolean m() {
        return this.f515i != null;
    }

    public boolean n() {
        return this.f504a.get(2);
    }

    public boolean o() {
        return this.f516j != null;
    }

    public boolean p() {
        return this.f504a.get(3);
    }

    public boolean q() {
        return this.f517k != null;
    }

    public boolean r() {
        return this.f518l != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (m358a()) {
            sb.append("to:");
            if (this.f502a == null) {
                sb.append("null");
            } else {
                sb.append(this.f502a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f503a == null) {
            sb.append("null");
        } else {
            sb.append(this.f503a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f507b == null) {
            sb.append("null");
        } else {
            sb.append(this.f507b);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f509c == null) {
            sb.append("null");
        } else {
            sb.append(this.f509c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f500a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f506b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f510d == null) {
                sb.append("null");
            } else {
                sb.append(this.f510d);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f511e == null) {
                sb.append("null");
            } else {
                sb.append(this.f511e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f512f == null) {
                sb.append("null");
            } else {
                sb.append(this.f512f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f513g == null) {
                sb.append("null");
            } else {
                sb.append(this.f513g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f514h == null) {
                sb.append("null");
            } else {
                sb.append(this.f514h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f501a == null) {
                sb.append("null");
            } else {
                sb.append(this.f501a);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f515i == null) {
                sb.append("null");
            } else {
                sb.append(this.f515i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f505a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f516j == null) {
                sb.append("null");
            } else {
                sb.append(this.f516j);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f508c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f517k == null) {
                sb.append("null");
            } else {
                sb.append(this.f517k);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f518l == null) {
                sb.append("null");
            } else {
                sb.append(this.f518l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
