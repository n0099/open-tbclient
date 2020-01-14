package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class im implements ir<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f738a;

    /* renamed from: a  reason: collision with other field name */
    public hv f739a;

    /* renamed from: a  reason: collision with other field name */
    public String f740a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f741a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f742a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f743b;

    /* renamed from: c  reason: collision with other field name */
    public String f744c;

    /* renamed from: d  reason: collision with other field name */
    public String f745d;

    /* renamed from: e  reason: collision with other field name */
    public String f746e;

    /* renamed from: f  reason: collision with other field name */
    public String f747f;

    /* renamed from: g  reason: collision with other field name */
    public String f748g;

    /* renamed from: h  reason: collision with other field name */
    public String f749h;

    /* renamed from: i  reason: collision with other field name */
    public String f750i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f737a = new jh("XmPushActionUnRegistration");
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
            int compareTo = Boolean.valueOf(m446a()).compareTo(Boolean.valueOf(imVar.m446a()));
            if (compareTo == 0) {
                if (!m446a() || (a13 = is.a(this.f740a, imVar.f740a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = is.a(this.f739a, imVar.f739a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = is.a(this.f743b, imVar.f743b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = is.a(this.f744c, imVar.f744c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = is.a(this.f745d, imVar.f745d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = is.a(this.f746e, imVar.f746e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f747f, imVar.f747f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f748g, imVar.f748g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f749h, imVar.f749h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f750i, imVar.f750i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f742a, imVar.f742a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f738a, imVar.f738a)) == 0) {
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
        this.f743b = str;
        return this;
    }

    public void a() {
        if (this.f743b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f744c == null) {
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
                a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f740a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f739a = new hv();
                        this.f739a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f743b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f744c = jcVar.m468a();
                        break;
                    }
                case 5:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f745d = jcVar.m468a();
                        break;
                    }
                case 6:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f746e = jcVar.m468a();
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f747f = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f748g = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f749h = jcVar.m468a();
                        break;
                    }
                case 10:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f750i = jcVar.m468a();
                        break;
                    }
                case 11:
                    if (m463a.a != 2) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f742a = jcVar.m472a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f738a = jcVar.m462a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f741a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a() {
        return this.f740a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m446a = m446a();
        boolean m446a2 = imVar.m446a();
        if ((m446a || m446a2) && !(m446a && m446a2 && this.f740a.equals(imVar.f740a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f739a.m373a(imVar.f739a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f743b.equals(imVar.f743b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f744c.equals(imVar.f744c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f745d.equals(imVar.f745d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f746e.equals(imVar.f746e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f747f.equals(imVar.f747f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f748g.equals(imVar.f748g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f749h.equals(imVar.f749h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f750i.equals(imVar.f750i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f742a == imVar.f742a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f738a == imVar.f738a);
    }

    public im b(String str) {
        this.f744c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f737a);
        if (this.f740a != null && m446a()) {
            jcVar.a(a);
            jcVar.a(this.f740a);
            jcVar.b();
        }
        if (this.f739a != null && b()) {
            jcVar.a(b);
            this.f739a.b(jcVar);
            jcVar.b();
        }
        if (this.f743b != null) {
            jcVar.a(c);
            jcVar.a(this.f743b);
            jcVar.b();
        }
        if (this.f744c != null) {
            jcVar.a(d);
            jcVar.a(this.f744c);
            jcVar.b();
        }
        if (this.f745d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f745d);
            jcVar.b();
        }
        if (this.f746e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f746e);
            jcVar.b();
        }
        if (this.f747f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f747f);
            jcVar.b();
        }
        if (this.f748g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f748g);
            jcVar.b();
        }
        if (this.f749h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f749h);
            jcVar.b();
        }
        if (this.f750i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f750i);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f742a);
            jcVar.b();
        }
        if (l()) {
            jcVar.a(l);
            jcVar.a(this.f738a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f741a.set(1, z);
    }

    public boolean b() {
        return this.f739a != null;
    }

    public im c(String str) {
        this.f745d = str;
        return this;
    }

    public boolean c() {
        return this.f743b != null;
    }

    public im d(String str) {
        this.f747f = str;
        return this;
    }

    public boolean d() {
        return this.f744c != null;
    }

    public im e(String str) {
        this.f748g = str;
        return this;
    }

    public boolean e() {
        return this.f745d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m447a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f746e != null;
    }

    public boolean g() {
        return this.f747f != null;
    }

    public boolean h() {
        return this.f748g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f749h != null;
    }

    public boolean j() {
        return this.f750i != null;
    }

    public boolean k() {
        return this.f741a.get(0);
    }

    public boolean l() {
        return this.f741a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m446a()) {
            sb.append("debug:");
            if (this.f740a == null) {
                sb.append("null");
            } else {
                sb.append(this.f740a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f739a == null) {
                sb.append("null");
            } else {
                sb.append(this.f739a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f743b == null) {
            sb.append("null");
        } else {
            sb.append(this.f743b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f744c == null) {
            sb.append("null");
        } else {
            sb.append(this.f744c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f745d == null) {
                sb.append("null");
            } else {
                sb.append(this.f745d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f746e == null) {
                sb.append("null");
            } else {
                sb.append(this.f746e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f747f == null) {
                sb.append("null");
            } else {
                sb.append(this.f747f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f748g == null) {
                sb.append("null");
            } else {
                sb.append(this.f748g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f749h == null) {
                sb.append("null");
            } else {
                sb.append(this.f749h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f750i == null) {
                sb.append("null");
            } else {
                sb.append(this.f750i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f742a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f738a);
        }
        sb.append(")");
        return sb.toString();
    }
}
