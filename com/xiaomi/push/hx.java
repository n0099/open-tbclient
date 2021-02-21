package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f557a;

    /* renamed from: a  reason: collision with other field name */
    public long f558a;

    /* renamed from: a  reason: collision with other field name */
    public String f559a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f560a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f561a;

    /* renamed from: b  reason: collision with other field name */
    public int f562b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f563b;

    /* renamed from: c  reason: collision with other field name */
    public int f564c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f556a = new jn("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14114a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14115b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f557a;
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
            int compareTo = Boolean.valueOf(m390a()).compareTo(Boolean.valueOf(hxVar.m390a()));
            if (compareTo == 0) {
                if (!m390a() || (a8 = iy.a(this.f557a, hxVar.f557a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m392b()).compareTo(Boolean.valueOf(hxVar.m392b()));
                    if (compareTo2 == 0) {
                        if (!m392b() || (a7 = iy.a(this.f562b, hxVar.f562b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m393c()).compareTo(Boolean.valueOf(hxVar.m393c()));
                            if (compareTo3 == 0) {
                                if (!m393c() || (a6 = iy.a(this.f561a, hxVar.f561a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f564c, hxVar.f564c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f558a, hxVar.f558a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f559a, hxVar.f559a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f563b, hxVar.f563b)) == 0) {
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
    public long m387a() {
        return this.f558a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m388a() {
        return this.f559a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m389a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m389a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f557a = jiVar.m508a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f562b = jiVar.m508a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m510a.f14173a != 2) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f561a = jiVar.m519a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f564c = jiVar.m508a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m510a.f14173a != 10) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f558a = jiVar.m509a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f559a = jiVar.m515a();
                        break;
                    }
                case 7:
                    if (m510a.f14173a != 2) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f563b = jiVar.m519a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f560a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m390a() {
        return this.f560a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m390a = m390a();
        boolean m390a2 = hxVar.m390a();
        if ((m390a || m390a2) && !(m390a && m390a2 && this.f557a == hxVar.f557a)) {
            return false;
        }
        boolean m392b = m392b();
        boolean m392b2 = hxVar.m392b();
        if ((m392b || m392b2) && !(m392b && m392b2 && this.f562b == hxVar.f562b)) {
            return false;
        }
        boolean m393c = m393c();
        boolean m393c2 = hxVar.m393c();
        if ((m393c || m393c2) && !(m393c && m393c2 && this.f561a == hxVar.f561a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f564c == hxVar.f564c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f558a == hxVar.f558a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f559a.equals(hxVar.f559a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f563b == hxVar.f563b);
    }

    public int b() {
        return this.f562b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m389a();
        jiVar.a(f556a);
        if (m390a()) {
            jiVar.a(f14114a);
            jiVar.a(this.f557a);
            jiVar.b();
        }
        if (m392b()) {
            jiVar.a(f14115b);
            jiVar.a(this.f562b);
            jiVar.b();
        }
        if (m393c()) {
            jiVar.a(c);
            jiVar.a(this.f561a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f564c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f558a);
            jiVar.b();
        }
        if (this.f559a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f559a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f563b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public void b(boolean z) {
        this.f560a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m392b() {
        return this.f560a.get(1);
    }

    public int c() {
        return this.f564c;
    }

    public void c(boolean z) {
        this.f560a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m393c() {
        return this.f560a.get(2);
    }

    public void d(boolean z) {
        this.f560a.set(3, z);
    }

    public boolean d() {
        return this.f560a.get(3);
    }

    public void e(boolean z) {
        this.f560a.set(4, z);
    }

    public boolean e() {
        return this.f560a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m391a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f560a.set(5, z);
    }

    public boolean f() {
        return this.f559a != null;
    }

    public boolean g() {
        return this.f563b;
    }

    public boolean h() {
        return this.f560a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m390a()) {
            sb.append("key:");
            sb.append(this.f557a);
            z2 = false;
        }
        if (m392b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f562b);
            z2 = false;
        }
        if (m393c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f561a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f564c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f558a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f559a == null) {
                sb.append("null");
            } else {
                sb.append(this.f559a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f563b);
        }
        sb.append(")");
        return sb.toString();
    }
}
