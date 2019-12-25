package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class hr implements ir<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f496a;

    /* renamed from: a  reason: collision with other field name */
    public long f497a;

    /* renamed from: a  reason: collision with other field name */
    public String f498a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f499a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f500a;

    /* renamed from: b  reason: collision with other field name */
    public int f501b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f502b;

    /* renamed from: c  reason: collision with other field name */
    public int f503c;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f495a = new jh("OnlineConfigItem");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", (byte) 2, 3);
    private static final iz d = new iz("", (byte) 8, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", (byte) 2, 7);

    public int a() {
        return this.f496a;
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
            int compareTo = Boolean.valueOf(m340a()).compareTo(Boolean.valueOf(hrVar.m340a()));
            if (compareTo == 0) {
                if (!m340a() || (a8 = is.a(this.f496a, hrVar.f496a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m342b()).compareTo(Boolean.valueOf(hrVar.m342b()));
                    if (compareTo2 == 0) {
                        if (!m342b() || (a7 = is.a(this.f501b, hrVar.f501b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m343c()).compareTo(Boolean.valueOf(hrVar.m343c()));
                            if (compareTo3 == 0) {
                                if (!m343c() || (a6 = is.a(this.f500a, hrVar.f500a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = is.a(this.f503c, hrVar.f503c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = is.a(this.f497a, hrVar.f497a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = is.a(this.f498a, hrVar.f498a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = is.a(this.f502b, hrVar.f502b)) == 0) {
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
    public long m337a() {
        return this.f497a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m338a() {
        return this.f498a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m339a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m339a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f496a = jcVar.m452a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f501b = jcVar.m452a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f500a = jcVar.m463a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m454a.a != 8) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f503c = jcVar.m452a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f497a = jcVar.m453a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f498a = jcVar.m459a();
                        break;
                    }
                case 7:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f502b = jcVar.m463a();
                        f(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f499a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m340a() {
        return this.f499a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m341a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m340a = m340a();
        boolean m340a2 = hrVar.m340a();
        if ((m340a || m340a2) && !(m340a && m340a2 && this.f496a == hrVar.f496a)) {
            return false;
        }
        boolean m342b = m342b();
        boolean m342b2 = hrVar.m342b();
        if ((m342b || m342b2) && !(m342b && m342b2 && this.f501b == hrVar.f501b)) {
            return false;
        }
        boolean m343c = m343c();
        boolean m343c2 = hrVar.m343c();
        if ((m343c || m343c2) && !(m343c && m343c2 && this.f500a == hrVar.f500a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f503c == hrVar.f503c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f497a == hrVar.f497a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f498a.equals(hrVar.f498a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hrVar.h();
        return !(h || h2) || (h && h2 && this.f502b == hrVar.f502b);
    }

    public int b() {
        return this.f501b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m339a();
        jcVar.a(f495a);
        if (m340a()) {
            jcVar.a(a);
            jcVar.a(this.f496a);
            jcVar.b();
        }
        if (m342b()) {
            jcVar.a(b);
            jcVar.a(this.f501b);
            jcVar.b();
        }
        if (m343c()) {
            jcVar.a(c);
            jcVar.a(this.f500a);
            jcVar.b();
        }
        if (d()) {
            jcVar.a(d);
            jcVar.a(this.f503c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f497a);
            jcVar.b();
        }
        if (this.f498a != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f498a);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(g);
            jcVar.a(this.f502b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f499a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m342b() {
        return this.f499a.get(1);
    }

    public int c() {
        return this.f503c;
    }

    public void c(boolean z) {
        this.f499a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m343c() {
        return this.f499a.get(2);
    }

    public void d(boolean z) {
        this.f499a.set(3, z);
    }

    public boolean d() {
        return this.f499a.get(3);
    }

    public void e(boolean z) {
        this.f499a.set(4, z);
    }

    public boolean e() {
        return this.f499a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m341a((hr) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f499a.set(5, z);
    }

    public boolean f() {
        return this.f498a != null;
    }

    public boolean g() {
        return this.f502b;
    }

    public boolean h() {
        return this.f499a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m340a()) {
            sb.append("key:");
            sb.append(this.f496a);
            z2 = false;
        }
        if (m342b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f501b);
            z2 = false;
        }
        if (m343c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f500a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f503c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f497a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f498a == null) {
                sb.append("null");
            } else {
                sb.append(this.f498a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f502b);
        }
        sb.append(")");
        return sb.toString();
    }
}
