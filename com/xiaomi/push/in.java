package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes3.dex */
public class in implements ir<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f748a;

    /* renamed from: a  reason: collision with other field name */
    public hv f749a;

    /* renamed from: a  reason: collision with other field name */
    public String f750a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f751a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f752b;

    /* renamed from: b  reason: collision with other field name */
    public String f753b;

    /* renamed from: c  reason: collision with other field name */
    public long f754c;

    /* renamed from: c  reason: collision with other field name */
    public String f755c;

    /* renamed from: d  reason: collision with other field name */
    public String f756d;

    /* renamed from: e  reason: collision with other field name */
    public String f757e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f747a = new jh("XmPushActionUnRegistrationResult");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz h = new iz("", (byte) 10, 9);
    private static final iz i = new iz("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m437a()).compareTo(Boolean.valueOf(inVar.m437a()));
            if (compareTo == 0) {
                if (!m437a() || (a10 = is.a(this.f750a, inVar.f750a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = is.a(this.f749a, inVar.f749a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f753b, inVar.f753b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f755c, inVar.f755c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f748a, inVar.f748a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f756d, inVar.f756d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f757e, inVar.f757e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f752b, inVar.f752b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f754c, inVar.f754c)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a3;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a4;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a5;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a6;
                                            }
                                            return compareTo5;
                                        }
                                        return a7;
                                    }
                                    return compareTo4;
                                }
                                return a8;
                            }
                            return compareTo3;
                        }
                        return a9;
                    }
                    return compareTo2;
                }
                return a10;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(inVar.getClass().getName());
    }

    public String a() {
        return this.f757e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m436a() {
        if (this.f753b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f755c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m436a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f750a = jcVar.m456a();
                        break;
                    }
                case 2:
                    if (m451a.a != 12) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f749a = new hv();
                        this.f749a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f753b = jcVar.m456a();
                        break;
                    }
                case 4:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f755c = jcVar.m456a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m451a.a);
                    break;
                case 6:
                    if (m451a.a != 10) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f748a = jcVar.m450a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f756d = jcVar.m456a();
                        break;
                    }
                case 8:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f757e = jcVar.m456a();
                        break;
                    }
                case 9:
                    if (m451a.a != 10) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f752b = jcVar.m450a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m451a.a != 10) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f754c = jcVar.m450a();
                        c(true);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f751a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a() {
        return this.f750a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m438a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m437a = m437a();
        boolean m437a2 = inVar.m437a();
        if ((m437a || m437a2) && !(m437a && m437a2 && this.f750a.equals(inVar.f750a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f749a.m361a(inVar.f749a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f753b.equals(inVar.f753b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f755c.equals(inVar.f755c))) || this.f748a != inVar.f748a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f756d.equals(inVar.f756d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f757e.equals(inVar.f757e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f752b == inVar.f752b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f754c == inVar.f754c);
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m436a();
        jcVar.a(f747a);
        if (this.f750a != null && m437a()) {
            jcVar.a(a);
            jcVar.a(this.f750a);
            jcVar.b();
        }
        if (this.f749a != null && b()) {
            jcVar.a(b);
            this.f749a.b(jcVar);
            jcVar.b();
        }
        if (this.f753b != null) {
            jcVar.a(c);
            jcVar.a(this.f753b);
            jcVar.b();
        }
        if (this.f755c != null) {
            jcVar.a(d);
            jcVar.a(this.f755c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f748a);
        jcVar.b();
        if (this.f756d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f756d);
            jcVar.b();
        }
        if (this.f757e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f757e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f752b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f754c);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public void b(boolean z) {
        this.f751a.set(1, z);
    }

    public boolean b() {
        return this.f749a != null;
    }

    public void c(boolean z) {
        this.f751a.set(2, z);
    }

    public boolean c() {
        return this.f753b != null;
    }

    public boolean d() {
        return this.f755c != null;
    }

    public boolean e() {
        return this.f751a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m438a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f756d != null;
    }

    public boolean g() {
        return this.f757e != null;
    }

    public boolean h() {
        return this.f751a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f751a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m437a()) {
            sb.append("debug:");
            if (this.f750a == null) {
                sb.append("null");
            } else {
                sb.append(this.f750a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f749a == null) {
                sb.append("null");
            } else {
                sb.append(this.f749a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f753b == null) {
            sb.append("null");
        } else {
            sb.append(this.f753b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f755c == null) {
            sb.append("null");
        } else {
            sb.append(this.f755c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f748a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f756d == null) {
                sb.append("null");
            } else {
                sb.append(this.f756d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f757e == null) {
                sb.append("null");
            } else {
                sb.append(this.f757e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f752b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f754c);
        }
        sb.append(")");
        return sb.toString();
    }
}
