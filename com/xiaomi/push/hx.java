package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f483a;

    /* renamed from: a  reason: collision with other field name */
    public long f484a;

    /* renamed from: a  reason: collision with other field name */
    public String f485a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f486a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f487a;

    /* renamed from: b  reason: collision with other field name */
    public int f488b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f489b;

    /* renamed from: c  reason: collision with other field name */
    public int f490c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f482a = new jn("OnlineConfigItem");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f483a;
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
            int compareTo = Boolean.valueOf(m359a()).compareTo(Boolean.valueOf(hxVar.m359a()));
            if (compareTo == 0) {
                if (!m359a() || (a8 = iy.a(this.f483a, hxVar.f483a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m361b()).compareTo(Boolean.valueOf(hxVar.m361b()));
                    if (compareTo2 == 0) {
                        if (!m361b() || (a7 = iy.a(this.f488b, hxVar.f488b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m362c()).compareTo(Boolean.valueOf(hxVar.m362c()));
                            if (compareTo3 == 0) {
                                if (!m362c() || (a6 = iy.a(this.f487a, hxVar.f487a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f490c, hxVar.f490c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f484a, hxVar.f484a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f485a, hxVar.f485a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f489b, hxVar.f489b)) == 0) {
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
    public long m356a() {
        return this.f484a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m357a() {
        return this.f485a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m358a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m358a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f483a = jiVar.m477a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f488b = jiVar.m477a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f487a = jiVar.m488a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f490c = jiVar.m477a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f484a = jiVar.m478a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f485a = jiVar.m484a();
                        break;
                    }
                case 7:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f489b = jiVar.m488a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f486a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a() {
        return this.f486a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m360a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m359a = m359a();
        boolean m359a2 = hxVar.m359a();
        if ((m359a || m359a2) && !(m359a && m359a2 && this.f483a == hxVar.f483a)) {
            return false;
        }
        boolean m361b = m361b();
        boolean m361b2 = hxVar.m361b();
        if ((m361b || m361b2) && !(m361b && m361b2 && this.f488b == hxVar.f488b)) {
            return false;
        }
        boolean m362c = m362c();
        boolean m362c2 = hxVar.m362c();
        if ((m362c || m362c2) && !(m362c && m362c2 && this.f487a == hxVar.f487a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f490c == hxVar.f490c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f484a == hxVar.f484a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f485a.equals(hxVar.f485a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f489b == hxVar.f489b);
    }

    public int b() {
        return this.f488b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m358a();
        jiVar.a(f482a);
        if (m359a()) {
            jiVar.a(a);
            jiVar.a(this.f483a);
            jiVar.b();
        }
        if (m361b()) {
            jiVar.a(b);
            jiVar.a(this.f488b);
            jiVar.b();
        }
        if (m362c()) {
            jiVar.a(c);
            jiVar.a(this.f487a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f490c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f484a);
            jiVar.b();
        }
        if (this.f485a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f485a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f489b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f486a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m361b() {
        return this.f486a.get(1);
    }

    public int c() {
        return this.f490c;
    }

    public void c(boolean z) {
        this.f486a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m362c() {
        return this.f486a.get(2);
    }

    public void d(boolean z) {
        this.f486a.set(3, z);
    }

    public boolean d() {
        return this.f486a.get(3);
    }

    public void e(boolean z) {
        this.f486a.set(4, z);
    }

    public boolean e() {
        return this.f486a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m360a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f486a.set(5, z);
    }

    public boolean f() {
        return this.f485a != null;
    }

    public boolean g() {
        return this.f489b;
    }

    public boolean h() {
        return this.f486a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m359a()) {
            sb.append("key:");
            sb.append(this.f483a);
            z2 = false;
        }
        if (m361b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f488b);
            z2 = false;
        }
        if (m362c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f487a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f490c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f484a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f485a == null) {
                sb.append("null");
            } else {
                sb.append(this.f485a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f489b);
        }
        sb.append(")");
        return sb.toString();
    }
}
