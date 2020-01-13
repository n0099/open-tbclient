package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f494a;

    /* renamed from: a  reason: collision with other field name */
    public long f495a;

    /* renamed from: a  reason: collision with other field name */
    public String f496a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f497a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f498a;

    /* renamed from: b  reason: collision with other field name */
    public int f499b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f500b;

    /* renamed from: c  reason: collision with other field name */
    public int f501c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f493a = new jh("OnlineConfigItem");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f494a;
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
            int compareTo = Boolean.valueOf(m349a()).compareTo(Boolean.valueOf(hrVar.m349a()));
            if (compareTo == 0) {
                if (!m349a() || (a8 = is.a(this.f494a, hrVar.f494a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m351b()).compareTo(Boolean.valueOf(hrVar.m351b()));
                    if (compareTo2 == 0) {
                        if (!m351b() || (a7 = is.a(this.f499b, hrVar.f499b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m352c()).compareTo(Boolean.valueOf(hrVar.m352c()));
                            if (compareTo3 == 0) {
                                if (!m352c() || (a6 = is.a(this.f498a, hrVar.f498a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f501c, hrVar.f501c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f495a, hrVar.f495a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f496a, hrVar.f496a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = is.a(this.f500b, hrVar.f500b)) == 0) {
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
    public long m346a() {
        return this.f495a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m347a() {
        return this.f496a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m348a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f494a = jcVar.m461a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f499b = jcVar.m461a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m463a.a != 2) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f498a = jcVar.m472a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f501c = jcVar.m461a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f495a = jcVar.m462a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f496a = jcVar.m468a();
                        break;
                    }
                case 7:
                    if (m463a.a != 2) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f500b = jcVar.m472a();
                        f(true);
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
        this.f497a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a() {
        return this.f497a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m350a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m349a = m349a();
        boolean m349a2 = hrVar.m349a();
        if ((m349a || m349a2) && !(m349a && m349a2 && this.f494a == hrVar.f494a)) {
            return false;
        }
        boolean m351b = m351b();
        boolean m351b2 = hrVar.m351b();
        if ((m351b || m351b2) && !(m351b && m351b2 && this.f499b == hrVar.f499b)) {
            return false;
        }
        boolean m352c = m352c();
        boolean m352c2 = hrVar.m352c();
        if ((m352c || m352c2) && !(m352c && m352c2 && this.f498a == hrVar.f498a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f501c == hrVar.f501c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f495a == hrVar.f495a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f496a.equals(hrVar.f496a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        return !(h || h2) || (h && h2 && this.f500b == hrVar.f500b);
    }

    public int b() {
        return this.f499b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m348a();
        jcVar.a(f493a);
        if (m349a()) {
            jcVar.a(a);
            jcVar.a(this.f494a);
            jcVar.b();
        }
        if (m351b()) {
            jcVar.a(b);
            jcVar.a(this.f499b);
            jcVar.b();
        }
        if (m352c()) {
            jcVar.a(c);
            jcVar.a(this.f498a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.a(this.f501c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f495a);
            jcVar.b();
        }
        if (this.f496a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f496a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f500b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f497a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m351b() {
        return this.f497a.get(1);
    }

    public int c() {
        return this.f501c;
    }

    public void c(boolean z) {
        this.f497a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m352c() {
        return this.f497a.get(2);
    }

    public void d(boolean z) {
        this.f497a.set(3, z);
    }

    public boolean d() {
        return this.f497a.get(3);
    }

    public void e(boolean z) {
        this.f497a.set(4, z);
    }

    public boolean e() {
        return this.f497a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m350a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f497a.set(5, z);
    }

    public boolean f() {
        return this.f496a != null;
    }

    public boolean g() {
        return this.f500b;
    }

    public boolean h() {
        return this.f497a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m349a()) {
            sb.append("key:");
            sb.append(this.f494a);
            z2 = false;
        }
        if (m351b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f499b);
            z2 = false;
        }
        if (m352c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f498a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f501c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f495a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f496a == null) {
                sb.append("null");
            } else {
                sb.append(this.f496a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f500b);
        }
        sb.append(")");
        return sb.toString();
    }
}
