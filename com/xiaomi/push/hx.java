package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f558a;

    /* renamed from: a  reason: collision with other field name */
    public long f559a;

    /* renamed from: a  reason: collision with other field name */
    public String f560a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f561a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f562a;

    /* renamed from: b  reason: collision with other field name */
    public int f563b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f564b;

    /* renamed from: c  reason: collision with other field name */
    public int f565c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f557a = new jn("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14412a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14413b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f558a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(m395a()).compareTo(Boolean.valueOf(hxVar.m395a()));
            if (compareTo == 0) {
                if (!m395a() || (a8 = iy.a(this.f558a, hxVar.f558a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m397b()).compareTo(Boolean.valueOf(hxVar.m397b()));
                    if (compareTo2 == 0) {
                        if (!m397b() || (a7 = iy.a(this.f563b, hxVar.f563b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m398c()).compareTo(Boolean.valueOf(hxVar.m398c()));
                            if (compareTo3 == 0) {
                                if (!m398c() || (a6 = iy.a(this.f562a, hxVar.f562a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f565c, hxVar.f565c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f559a, hxVar.f559a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f560a, hxVar.f560a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f564b, hxVar.f564b)) == 0) {
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
        return getClass().getName().compareTo(hxVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m392a() {
        return this.f559a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m393a() {
        return this.f560a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m394a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m394a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f558a = jiVar.m513a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f563b = jiVar.m513a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f562a = jiVar.m524a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f565c = jiVar.m513a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f559a = jiVar.m514a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f560a = jiVar.m520a();
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f564b = jiVar.m524a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f561a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m395a() {
        return this.f561a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m396a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m395a = m395a();
        boolean m395a2 = hxVar.m395a();
        if ((m395a || m395a2) && !(m395a && m395a2 && this.f558a == hxVar.f558a)) {
            return false;
        }
        boolean m397b = m397b();
        boolean m397b2 = hxVar.m397b();
        if ((m397b || m397b2) && !(m397b && m397b2 && this.f563b == hxVar.f563b)) {
            return false;
        }
        boolean m398c = m398c();
        boolean m398c2 = hxVar.m398c();
        if ((m398c || m398c2) && !(m398c && m398c2 && this.f562a == hxVar.f562a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f565c == hxVar.f565c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f559a == hxVar.f559a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f560a.equals(hxVar.f560a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f564b == hxVar.f564b);
    }

    public int b() {
        return this.f563b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m394a();
        jiVar.a(f557a);
        if (m395a()) {
            jiVar.a(f14412a);
            jiVar.a(this.f558a);
            jiVar.b();
        }
        if (m397b()) {
            jiVar.a(f14413b);
            jiVar.a(this.f563b);
            jiVar.b();
        }
        if (m398c()) {
            jiVar.a(c);
            jiVar.a(this.f562a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f565c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f559a);
            jiVar.b();
        }
        if (this.f560a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f560a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f564b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f561a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m397b() {
        return this.f561a.get(1);
    }

    public int c() {
        return this.f565c;
    }

    public void c(boolean z) {
        this.f561a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m398c() {
        return this.f561a.get(2);
    }

    public void d(boolean z) {
        this.f561a.set(3, z);
    }

    public boolean d() {
        return this.f561a.get(3);
    }

    public void e(boolean z) {
        this.f561a.set(4, z);
    }

    public boolean e() {
        return this.f561a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m396a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f561a.set(5, z);
    }

    public boolean f() {
        return this.f560a != null;
    }

    public boolean g() {
        return this.f564b;
    }

    public boolean h() {
        return this.f561a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m395a()) {
            sb.append("key:");
            sb.append(this.f558a);
            z2 = false;
        }
        if (m397b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f563b);
            z2 = false;
        }
        if (m398c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f562a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f565c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f559a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f560a == null) {
                sb.append("null");
            } else {
                sb.append(this.f560a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f564b);
        }
        sb.append(")");
        return sb.toString();
    }
}
