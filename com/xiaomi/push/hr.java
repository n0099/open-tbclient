package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f492a;

    /* renamed from: a  reason: collision with other field name */
    public long f493a;

    /* renamed from: a  reason: collision with other field name */
    public String f494a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f495a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f496a;

    /* renamed from: b  reason: collision with other field name */
    public int f497b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f498b;

    /* renamed from: c  reason: collision with other field name */
    public int f499c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f491a = new jh("OnlineConfigItem");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f492a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hr hrVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(hrVar.getClass())) {
            int compareTo = Boolean.valueOf(m357a()).compareTo(Boolean.valueOf(hrVar.m357a()));
            if (compareTo == 0) {
                if (!m357a() || (a8 = is.a(this.f492a, hrVar.f492a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m359b()).compareTo(Boolean.valueOf(hrVar.m359b()));
                    if (compareTo2 == 0) {
                        if (!m359b() || (a7 = is.a(this.f497b, hrVar.f497b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m360c()).compareTo(Boolean.valueOf(hrVar.m360c()));
                            if (compareTo3 == 0) {
                                if (!m360c() || (a6 = is.a(this.f496a, hrVar.f496a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f499c, hrVar.f499c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f493a, hrVar.f493a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f494a, hrVar.f494a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = is.a(this.f498b, hrVar.f498b)) == 0) {
                                                                    return 0;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hrVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m354a() {
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m355a() {
        return this.f494a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m356a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m356a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a != 8) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f492a = jcVar.m469a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m471a.a != 8) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f497b = jcVar.m469a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m471a.a != 2) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f496a = jcVar.m480a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m471a.a != 8) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f499c = jcVar.m469a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f493a = jcVar.m470a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f494a = jcVar.m476a();
                        break;
                    }
                case 7:
                    if (m471a.a != 2) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f498b = jcVar.m480a();
                        f(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f495a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a() {
        return this.f495a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m358a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m357a = m357a();
        boolean m357a2 = hrVar.m357a();
        if ((m357a || m357a2) && !(m357a && m357a2 && this.f492a == hrVar.f492a)) {
            return false;
        }
        boolean m359b = m359b();
        boolean m359b2 = hrVar.m359b();
        if ((m359b || m359b2) && !(m359b && m359b2 && this.f497b == hrVar.f497b)) {
            return false;
        }
        boolean m360c = m360c();
        boolean m360c2 = hrVar.m360c();
        if ((m360c || m360c2) && !(m360c && m360c2 && this.f496a == hrVar.f496a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f499c == hrVar.f499c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f493a == hrVar.f493a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f494a.equals(hrVar.f494a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        return !(h || h2) || (h && h2 && this.f498b == hrVar.f498b);
    }

    public int b() {
        return this.f497b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m356a();
        jcVar.a(f491a);
        if (m357a()) {
            jcVar.a(a);
            jcVar.a(this.f492a);
            jcVar.b();
        }
        if (m359b()) {
            jcVar.a(b);
            jcVar.a(this.f497b);
            jcVar.b();
        }
        if (m360c()) {
            jcVar.a(c);
            jcVar.a(this.f496a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.a(this.f499c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f493a);
            jcVar.b();
        }
        if (this.f494a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f494a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f498b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public void b(boolean z) {
        this.f495a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m359b() {
        return this.f495a.get(1);
    }

    public int c() {
        return this.f499c;
    }

    public void c(boolean z) {
        this.f495a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m360c() {
        return this.f495a.get(2);
    }

    public void d(boolean z) {
        this.f495a.set(3, z);
    }

    public boolean d() {
        return this.f495a.get(3);
    }

    public void e(boolean z) {
        this.f495a.set(4, z);
    }

    public boolean e() {
        return this.f495a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m358a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f495a.set(5, z);
    }

    public boolean f() {
        return this.f494a != null;
    }

    public boolean g() {
        return this.f498b;
    }

    public boolean h() {
        return this.f495a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m357a()) {
            sb.append("key:");
            sb.append(this.f492a);
            z2 = false;
        }
        if (m359b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f497b);
            z2 = false;
        }
        if (m360c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f496a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f499c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f493a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f494a == null) {
                sb.append("null");
            } else {
                sb.append(this.f494a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f498b);
        }
        sb.append(")");
        return sb.toString();
    }
}
