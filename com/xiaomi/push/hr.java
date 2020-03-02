package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f491a;

    /* renamed from: a  reason: collision with other field name */
    public long f492a;

    /* renamed from: a  reason: collision with other field name */
    public String f493a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f494a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f495a;

    /* renamed from: b  reason: collision with other field name */
    public int f496b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f497b;

    /* renamed from: c  reason: collision with other field name */
    public int f498c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f490a = new jh("OnlineConfigItem");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f491a;
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
            int compareTo = Boolean.valueOf(m354a()).compareTo(Boolean.valueOf(hrVar.m354a()));
            if (compareTo == 0) {
                if (!m354a() || (a8 = is.a(this.f491a, hrVar.f491a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m356b()).compareTo(Boolean.valueOf(hrVar.m356b()));
                    if (compareTo2 == 0) {
                        if (!m356b() || (a7 = is.a(this.f496b, hrVar.f496b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m357c()).compareTo(Boolean.valueOf(hrVar.m357c()));
                            if (compareTo3 == 0) {
                                if (!m357c() || (a6 = is.a(this.f495a, hrVar.f495a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f498c, hrVar.f498c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f492a, hrVar.f492a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f493a, hrVar.f493a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = is.a(this.f497b, hrVar.f497b)) == 0) {
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
    public long m351a() {
        return this.f492a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m352a() {
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m353a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m353a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f491a = jcVar.m466a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f496b = jcVar.m466a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f495a = jcVar.m477a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f498c = jcVar.m466a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f492a = jcVar.m467a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f493a = jcVar.m473a();
                        break;
                    }
                case 7:
                    if (m468a.a != 2) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f497b = jcVar.m477a();
                        f(true);
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
        this.f494a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m354a() {
        return this.f494a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m355a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m354a = m354a();
        boolean m354a2 = hrVar.m354a();
        if ((m354a || m354a2) && !(m354a && m354a2 && this.f491a == hrVar.f491a)) {
            return false;
        }
        boolean m356b = m356b();
        boolean m356b2 = hrVar.m356b();
        if ((m356b || m356b2) && !(m356b && m356b2 && this.f496b == hrVar.f496b)) {
            return false;
        }
        boolean m357c = m357c();
        boolean m357c2 = hrVar.m357c();
        if ((m357c || m357c2) && !(m357c && m357c2 && this.f495a == hrVar.f495a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f498c == hrVar.f498c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f492a == hrVar.f492a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f493a.equals(hrVar.f493a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        return !(h || h2) || (h && h2 && this.f497b == hrVar.f497b);
    }

    public int b() {
        return this.f496b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m353a();
        jcVar.a(f490a);
        if (m354a()) {
            jcVar.a(a);
            jcVar.a(this.f491a);
            jcVar.b();
        }
        if (m356b()) {
            jcVar.a(b);
            jcVar.a(this.f496b);
            jcVar.b();
        }
        if (m357c()) {
            jcVar.a(c);
            jcVar.a(this.f495a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.a(this.f498c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f492a);
            jcVar.b();
        }
        if (this.f493a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f493a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f497b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f494a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m356b() {
        return this.f494a.get(1);
    }

    public int c() {
        return this.f498c;
    }

    public void c(boolean z) {
        this.f494a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m357c() {
        return this.f494a.get(2);
    }

    public void d(boolean z) {
        this.f494a.set(3, z);
    }

    public boolean d() {
        return this.f494a.get(3);
    }

    public void e(boolean z) {
        this.f494a.set(4, z);
    }

    public boolean e() {
        return this.f494a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m355a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f494a.set(5, z);
    }

    public boolean f() {
        return this.f493a != null;
    }

    public boolean g() {
        return this.f497b;
    }

    public boolean h() {
        return this.f494a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m354a()) {
            sb.append("key:");
            sb.append(this.f491a);
            z2 = false;
        }
        if (m356b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f496b);
            z2 = false;
        }
        if (m357c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f495a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f498c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f492a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f493a == null) {
                sb.append("null");
            } else {
                sb.append(this.f493a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f497b);
        }
        sb.append(")");
        return sb.toString();
    }
}
