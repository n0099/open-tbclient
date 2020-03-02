package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class im implements ir<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f734a;

    /* renamed from: a  reason: collision with other field name */
    public hv f735a;

    /* renamed from: a  reason: collision with other field name */
    public String f736a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f737a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f738a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f739b;

    /* renamed from: c  reason: collision with other field name */
    public String f740c;

    /* renamed from: d  reason: collision with other field name */
    public String f741d;

    /* renamed from: e  reason: collision with other field name */
    public String f742e;

    /* renamed from: f  reason: collision with other field name */
    public String f743f;

    /* renamed from: g  reason: collision with other field name */
    public String f744g;

    /* renamed from: h  reason: collision with other field name */
    public String f745h;

    /* renamed from: i  reason: collision with other field name */
    public String f746i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f733a = new jh("XmPushActionUnRegistration");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", (byte) 2, 11);
    private static final iz l = new iz("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (getClass().equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m451a()).compareTo(Boolean.valueOf(imVar.m451a()));
            if (compareTo == 0) {
                if (!m451a() || (a13 = is.a(this.f736a, imVar.f736a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = is.a(this.f735a, imVar.f735a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = is.a(this.f739b, imVar.f739b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = is.a(this.f740c, imVar.f740c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = is.a(this.f741d, imVar.f741d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = is.a(this.f742e, imVar.f742e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f743f, imVar.f743f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f744g, imVar.f744g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f745h, imVar.f745h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f746i, imVar.f746i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f738a, imVar.f738a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f734a, imVar.f734a)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a2;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a3;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a4;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a5;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a7;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a8;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a9;
                                            }
                                            return compareTo5;
                                        }
                                        return a10;
                                    }
                                    return compareTo4;
                                }
                                return a11;
                            }
                            return compareTo3;
                        }
                        return a12;
                    }
                    return compareTo2;
                }
                return a13;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(imVar.getClass().getName());
    }

    public im a(String str) {
        this.f739b = str;
        return this;
    }

    public void a() {
        if (this.f739b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f740c == null) {
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
                a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f736a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f735a = new hv();
                        this.f735a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f739b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f740c = jcVar.m473a();
                        break;
                    }
                case 5:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f741d = jcVar.m473a();
                        break;
                    }
                case 6:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f742e = jcVar.m473a();
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f743f = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f744g = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f745h = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f746i = jcVar.m473a();
                        break;
                    }
                case 11:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f738a = jcVar.m477a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f734a = jcVar.m467a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f737a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a() {
        return this.f736a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m451a = m451a();
        boolean m451a2 = imVar.m451a();
        if ((m451a || m451a2) && !(m451a && m451a2 && this.f736a.equals(imVar.f736a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f735a.m378a(imVar.f735a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f739b.equals(imVar.f739b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f740c.equals(imVar.f740c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f741d.equals(imVar.f741d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f742e.equals(imVar.f742e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f743f.equals(imVar.f743f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f744g.equals(imVar.f744g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f745h.equals(imVar.f745h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f746i.equals(imVar.f746i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f738a == imVar.f738a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f734a == imVar.f734a);
    }

    public im b(String str) {
        this.f740c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f733a);
        if (this.f736a != null && m451a()) {
            jcVar.a(a);
            jcVar.a(this.f736a);
            jcVar.b();
        }
        if (this.f735a != null && b()) {
            jcVar.a(b);
            this.f735a.b(jcVar);
            jcVar.b();
        }
        if (this.f739b != null) {
            jcVar.a(c);
            jcVar.a(this.f739b);
            jcVar.b();
        }
        if (this.f740c != null) {
            jcVar.a(d);
            jcVar.a(this.f740c);
            jcVar.b();
        }
        if (this.f741d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f741d);
            jcVar.b();
        }
        if (this.f742e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f742e);
            jcVar.b();
        }
        if (this.f743f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f743f);
            jcVar.b();
        }
        if (this.f744g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f744g);
            jcVar.b();
        }
        if (this.f745h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f745h);
            jcVar.b();
        }
        if (this.f746i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f746i);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f738a);
            jcVar.b();
        }
        if (l()) {
            jcVar.a(l);
            jcVar.a(this.f734a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f737a.set(1, z);
    }

    public boolean b() {
        return this.f735a != null;
    }

    public im c(String str) {
        this.f741d = str;
        return this;
    }

    public boolean c() {
        return this.f739b != null;
    }

    public im d(String str) {
        this.f743f = str;
        return this;
    }

    public boolean d() {
        return this.f740c != null;
    }

    public im e(String str) {
        this.f744g = str;
        return this;
    }

    public boolean e() {
        return this.f741d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m452a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f742e != null;
    }

    public boolean g() {
        return this.f743f != null;
    }

    public boolean h() {
        return this.f744g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f745h != null;
    }

    public boolean j() {
        return this.f746i != null;
    }

    public boolean k() {
        return this.f737a.get(0);
    }

    public boolean l() {
        return this.f737a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m451a()) {
            sb.append("debug:");
            if (this.f736a == null) {
                sb.append("null");
            } else {
                sb.append(this.f736a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f735a == null) {
                sb.append("null");
            } else {
                sb.append(this.f735a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f739b == null) {
            sb.append("null");
        } else {
            sb.append(this.f739b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f740c == null) {
            sb.append("null");
        } else {
            sb.append(this.f740c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f741d == null) {
                sb.append("null");
            } else {
                sb.append(this.f741d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f742e == null) {
                sb.append("null");
            } else {
                sb.append(this.f742e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f743f == null) {
                sb.append("null");
            } else {
                sb.append(this.f743f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f744g == null) {
                sb.append("null");
            } else {
                sb.append(this.f744g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f745h == null) {
                sb.append("null");
            } else {
                sb.append(this.f745h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f746i == null) {
                sb.append("null");
            } else {
                sb.append(this.f746i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f738a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f734a);
        }
        sb.append(")");
        return sb.toString();
    }
}
