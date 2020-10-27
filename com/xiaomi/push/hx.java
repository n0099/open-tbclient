package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f476a;

    /* renamed from: a  reason: collision with other field name */
    public long f477a;

    /* renamed from: a  reason: collision with other field name */
    public String f478a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f479a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f480a;

    /* renamed from: b  reason: collision with other field name */
    public int f481b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f482b;

    /* renamed from: c  reason: collision with other field name */
    public int f483c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f475a = new jn("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4964a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f476a;
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
            int compareTo = Boolean.valueOf(m365a()).compareTo(Boolean.valueOf(hxVar.m365a()));
            if (compareTo == 0) {
                if (!m365a() || (a8 = iy.a(this.f476a, hxVar.f476a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m367b()).compareTo(Boolean.valueOf(hxVar.m367b()));
                    if (compareTo2 == 0) {
                        if (!m367b() || (a7 = iy.a(this.f481b, hxVar.f481b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m368c()).compareTo(Boolean.valueOf(hxVar.m368c()));
                            if (compareTo3 == 0) {
                                if (!m368c() || (a6 = iy.a(this.f480a, hxVar.f480a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f483c, hxVar.f483c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f477a, hxVar.f477a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f478a, hxVar.f478a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f482b, hxVar.f482b)) == 0) {
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
    public long m362a() {
        return this.f477a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m363a() {
        return this.f478a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m364a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m364a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f476a = jiVar.m483a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f481b = jiVar.m483a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 2) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f480a = jiVar.m494a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f483c = jiVar.m483a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f477a = jiVar.m484a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f478a = jiVar.m490a();
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 2) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f482b = jiVar.m494a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f479a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a() {
        return this.f479a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m365a = m365a();
        boolean m365a2 = hxVar.m365a();
        if ((m365a || m365a2) && !(m365a && m365a2 && this.f476a == hxVar.f476a)) {
            return false;
        }
        boolean m367b = m367b();
        boolean m367b2 = hxVar.m367b();
        if ((m367b || m367b2) && !(m367b && m367b2 && this.f481b == hxVar.f481b)) {
            return false;
        }
        boolean m368c = m368c();
        boolean m368c2 = hxVar.m368c();
        if ((m368c || m368c2) && !(m368c && m368c2 && this.f480a == hxVar.f480a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f483c == hxVar.f483c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f477a == hxVar.f477a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f478a.equals(hxVar.f478a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f482b == hxVar.f482b);
    }

    public int b() {
        return this.f481b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m364a();
        jiVar.a(f475a);
        if (m365a()) {
            jiVar.a(f4964a);
            jiVar.a(this.f476a);
            jiVar.b();
        }
        if (m367b()) {
            jiVar.a(b);
            jiVar.a(this.f481b);
            jiVar.b();
        }
        if (m368c()) {
            jiVar.a(c);
            jiVar.a(this.f480a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f483c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f477a);
            jiVar.b();
        }
        if (this.f478a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f478a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f482b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f479a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m367b() {
        return this.f479a.get(1);
    }

    public int c() {
        return this.f483c;
    }

    public void c(boolean z) {
        this.f479a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m368c() {
        return this.f479a.get(2);
    }

    public void d(boolean z) {
        this.f479a.set(3, z);
    }

    public boolean d() {
        return this.f479a.get(3);
    }

    public void e(boolean z) {
        this.f479a.set(4, z);
    }

    public boolean e() {
        return this.f479a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m366a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f479a.set(5, z);
    }

    public boolean f() {
        return this.f478a != null;
    }

    public boolean g() {
        return this.f482b;
    }

    public boolean h() {
        return this.f479a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m365a()) {
            sb.append("key:");
            sb.append(this.f476a);
            z2 = false;
        }
        if (m367b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f481b);
            z2 = false;
        }
        if (m368c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f480a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f483c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f477a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f478a == null) {
                sb.append("null");
            } else {
                sb.append(this.f478a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f482b);
        }
        sb.append(")");
        return sb.toString();
    }
}
