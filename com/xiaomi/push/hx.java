package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f481a;

    /* renamed from: a  reason: collision with other field name */
    public long f482a;

    /* renamed from: a  reason: collision with other field name */
    public String f483a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f484a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f485a;

    /* renamed from: b  reason: collision with other field name */
    public int f486b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f487b;

    /* renamed from: c  reason: collision with other field name */
    public int f488c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f480a = new jn("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4966a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f481a;
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
            int compareTo = Boolean.valueOf(m368a()).compareTo(Boolean.valueOf(hxVar.m368a()));
            if (compareTo == 0) {
                if (!m368a() || (a8 = iy.a(this.f481a, hxVar.f481a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m370b()).compareTo(Boolean.valueOf(hxVar.m370b()));
                    if (compareTo2 == 0) {
                        if (!m370b() || (a7 = iy.a(this.f486b, hxVar.f486b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m371c()).compareTo(Boolean.valueOf(hxVar.m371c()));
                            if (compareTo3 == 0) {
                                if (!m371c() || (a6 = iy.a(this.f485a, hxVar.f485a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f488c, hxVar.f488c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f482a, hxVar.f482a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f483a, hxVar.f483a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f487b, hxVar.f487b)) == 0) {
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
    public long m365a() {
        return this.f482a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m366a() {
        return this.f483a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m367a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m367a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f481a = jiVar.m486a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f486b = jiVar.m486a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f485a = jiVar.m497a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f488c = jiVar.m486a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f482a = jiVar.m487a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f483a = jiVar.m493a();
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f487b = jiVar.m497a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f484a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m368a() {
        return this.f484a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m369a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m368a = m368a();
        boolean m368a2 = hxVar.m368a();
        if ((m368a || m368a2) && !(m368a && m368a2 && this.f481a == hxVar.f481a)) {
            return false;
        }
        boolean m370b = m370b();
        boolean m370b2 = hxVar.m370b();
        if ((m370b || m370b2) && !(m370b && m370b2 && this.f486b == hxVar.f486b)) {
            return false;
        }
        boolean m371c = m371c();
        boolean m371c2 = hxVar.m371c();
        if ((m371c || m371c2) && !(m371c && m371c2 && this.f485a == hxVar.f485a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f488c == hxVar.f488c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f482a == hxVar.f482a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f483a.equals(hxVar.f483a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f487b == hxVar.f487b);
    }

    public int b() {
        return this.f486b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m367a();
        jiVar.a(f480a);
        if (m368a()) {
            jiVar.a(f4966a);
            jiVar.a(this.f481a);
            jiVar.b();
        }
        if (m370b()) {
            jiVar.a(b);
            jiVar.a(this.f486b);
            jiVar.b();
        }
        if (m371c()) {
            jiVar.a(c);
            jiVar.a(this.f485a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f488c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f482a);
            jiVar.b();
        }
        if (this.f483a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f483a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f487b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f484a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m370b() {
        return this.f484a.get(1);
    }

    public int c() {
        return this.f488c;
    }

    public void c(boolean z) {
        this.f484a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m371c() {
        return this.f484a.get(2);
    }

    public void d(boolean z) {
        this.f484a.set(3, z);
    }

    public boolean d() {
        return this.f484a.get(3);
    }

    public void e(boolean z) {
        this.f484a.set(4, z);
    }

    public boolean e() {
        return this.f484a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m369a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f484a.set(5, z);
    }

    public boolean f() {
        return this.f483a != null;
    }

    public boolean g() {
        return this.f487b;
    }

    public boolean h() {
        return this.f484a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m368a()) {
            sb.append("key:");
            sb.append(this.f481a);
            z2 = false;
        }
        if (m370b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f486b);
            z2 = false;
        }
        if (m371c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f485a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f488c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f482a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f483a == null) {
                sb.append("null");
            } else {
                sb.append(this.f483a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f487b);
        }
        sb.append(")");
        return sb.toString();
    }
}
