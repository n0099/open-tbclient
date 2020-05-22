package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f477a;

    /* renamed from: a  reason: collision with other field name */
    public long f478a;

    /* renamed from: a  reason: collision with other field name */
    public String f479a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f480a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f481a;

    /* renamed from: b  reason: collision with other field name */
    public int f482b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f483b;

    /* renamed from: c  reason: collision with other field name */
    public int f484c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f476a = new jn("OnlineConfigItem");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f477a;
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
            int compareTo = Boolean.valueOf(m363a()).compareTo(Boolean.valueOf(hxVar.m363a()));
            if (compareTo == 0) {
                if (!m363a() || (a8 = iy.a(this.f477a, hxVar.f477a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m365b()).compareTo(Boolean.valueOf(hxVar.m365b()));
                    if (compareTo2 == 0) {
                        if (!m365b() || (a7 = iy.a(this.f482b, hxVar.f482b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m366c()).compareTo(Boolean.valueOf(hxVar.m366c()));
                            if (compareTo3 == 0) {
                                if (!m366c() || (a6 = iy.a(this.f481a, hxVar.f481a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f484c, hxVar.f484c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f478a, hxVar.f478a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f479a, hxVar.f479a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f483b, hxVar.f483b)) == 0) {
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
    public long m360a() {
        return this.f478a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m361a() {
        return this.f479a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m362a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                m362a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f477a = jiVar.m481a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f482b = jiVar.m481a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m483a.a != 2) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f481a = jiVar.m492a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f484c = jiVar.m481a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f478a = jiVar.m482a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f479a = jiVar.m488a();
                        break;
                    }
                case 7:
                    if (m483a.a != 2) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f483b = jiVar.m492a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f480a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m363a() {
        return this.f480a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m363a = m363a();
        boolean m363a2 = hxVar.m363a();
        if ((m363a || m363a2) && !(m363a && m363a2 && this.f477a == hxVar.f477a)) {
            return false;
        }
        boolean m365b = m365b();
        boolean m365b2 = hxVar.m365b();
        if ((m365b || m365b2) && !(m365b && m365b2 && this.f482b == hxVar.f482b)) {
            return false;
        }
        boolean m366c = m366c();
        boolean m366c2 = hxVar.m366c();
        if ((m366c || m366c2) && !(m366c && m366c2 && this.f481a == hxVar.f481a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f484c == hxVar.f484c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f478a == hxVar.f478a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f479a.equals(hxVar.f479a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f483b == hxVar.f483b);
    }

    public int b() {
        return this.f482b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m362a();
        jiVar.a(f476a);
        if (m363a()) {
            jiVar.a(a);
            jiVar.a(this.f477a);
            jiVar.b();
        }
        if (m365b()) {
            jiVar.a(b);
            jiVar.a(this.f482b);
            jiVar.b();
        }
        if (m366c()) {
            jiVar.a(c);
            jiVar.a(this.f481a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f484c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f478a);
            jiVar.b();
        }
        if (this.f479a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f479a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f483b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f480a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m365b() {
        return this.f480a.get(1);
    }

    public int c() {
        return this.f484c;
    }

    public void c(boolean z) {
        this.f480a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m366c() {
        return this.f480a.get(2);
    }

    public void d(boolean z) {
        this.f480a.set(3, z);
    }

    public boolean d() {
        return this.f480a.get(3);
    }

    public void e(boolean z) {
        this.f480a.set(4, z);
    }

    public boolean e() {
        return this.f480a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m364a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f480a.set(5, z);
    }

    public boolean f() {
        return this.f479a != null;
    }

    public boolean g() {
        return this.f483b;
    }

    public boolean h() {
        return this.f480a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m363a()) {
            sb.append("key:");
            sb.append(this.f477a);
            z2 = false;
        }
        if (m365b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f482b);
            z2 = false;
        }
        if (m366c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f481a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f484c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f478a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f479a == null) {
                sb.append("null");
            } else {
                sb.append(this.f479a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f483b);
        }
        sb.append(")");
        return sb.toString();
    }
}
