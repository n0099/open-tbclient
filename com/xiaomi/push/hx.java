package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f480a;

    /* renamed from: a  reason: collision with other field name */
    public long f481a;

    /* renamed from: a  reason: collision with other field name */
    public String f482a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f483a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f484a;

    /* renamed from: b  reason: collision with other field name */
    public int f485b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f486b;

    /* renamed from: c  reason: collision with other field name */
    public int f487c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f479a = new jn("OnlineConfigItem");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f480a;
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
            int compareTo = Boolean.valueOf(m360a()).compareTo(Boolean.valueOf(hxVar.m360a()));
            if (compareTo == 0) {
                if (!m360a() || (a8 = iy.a(this.f480a, hxVar.f480a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m362b()).compareTo(Boolean.valueOf(hxVar.m362b()));
                    if (compareTo2 == 0) {
                        if (!m362b() || (a7 = iy.a(this.f485b, hxVar.f485b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m363c()).compareTo(Boolean.valueOf(hxVar.m363c()));
                            if (compareTo3 == 0) {
                                if (!m363c() || (a6 = iy.a(this.f484a, hxVar.f484a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f487c, hxVar.f487c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f481a, hxVar.f481a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f482a, hxVar.f482a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f486b, hxVar.f486b)) == 0) {
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
    public long m357a() {
        return this.f481a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m358a() {
        return this.f482a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m359a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m359a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f480a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f485b = jiVar.m478a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m480a.a != 2) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f484a = jiVar.m489a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f487c = jiVar.m478a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f481a = jiVar.m479a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f482a = jiVar.m485a();
                        break;
                    }
                case 7:
                    if (m480a.a != 2) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f486b = jiVar.m489a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f483a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m360a() {
        return this.f483a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m361a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m360a = m360a();
        boolean m360a2 = hxVar.m360a();
        if ((m360a || m360a2) && !(m360a && m360a2 && this.f480a == hxVar.f480a)) {
            return false;
        }
        boolean m362b = m362b();
        boolean m362b2 = hxVar.m362b();
        if ((m362b || m362b2) && !(m362b && m362b2 && this.f485b == hxVar.f485b)) {
            return false;
        }
        boolean m363c = m363c();
        boolean m363c2 = hxVar.m363c();
        if ((m363c || m363c2) && !(m363c && m363c2 && this.f484a == hxVar.f484a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f487c == hxVar.f487c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f481a == hxVar.f481a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f482a.equals(hxVar.f482a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f486b == hxVar.f486b);
    }

    public int b() {
        return this.f485b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m359a();
        jiVar.a(f479a);
        if (m360a()) {
            jiVar.a(a);
            jiVar.a(this.f480a);
            jiVar.b();
        }
        if (m362b()) {
            jiVar.a(b);
            jiVar.a(this.f485b);
            jiVar.b();
        }
        if (m363c()) {
            jiVar.a(c);
            jiVar.a(this.f484a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f487c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f481a);
            jiVar.b();
        }
        if (this.f482a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f482a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f486b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f483a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m362b() {
        return this.f483a.get(1);
    }

    public int c() {
        return this.f487c;
    }

    public void c(boolean z) {
        this.f483a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m363c() {
        return this.f483a.get(2);
    }

    public void d(boolean z) {
        this.f483a.set(3, z);
    }

    public boolean d() {
        return this.f483a.get(3);
    }

    public void e(boolean z) {
        this.f483a.set(4, z);
    }

    public boolean e() {
        return this.f483a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m361a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f483a.set(5, z);
    }

    public boolean f() {
        return this.f482a != null;
    }

    public boolean g() {
        return this.f486b;
    }

    public boolean h() {
        return this.f483a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m360a()) {
            sb.append("key:");
            sb.append(this.f480a);
            z2 = false;
        }
        if (m362b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f485b);
            z2 = false;
        }
        if (m363c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f484a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f487c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f481a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f482a == null) {
                sb.append("null");
            } else {
                sb.append(this.f482a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f486b);
        }
        sb.append(")");
        return sb.toString();
    }
}
