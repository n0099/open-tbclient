package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class hx implements ix<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f479a;

    /* renamed from: a  reason: collision with other field name */
    public long f480a;

    /* renamed from: a  reason: collision with other field name */
    public String f481a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f482a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f483a;

    /* renamed from: b  reason: collision with other field name */
    public int f484b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f485b;

    /* renamed from: c  reason: collision with other field name */
    public int f486c;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f478a = new jn("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4736a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", (byte) 8, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 2, 7);

    public int a() {
        return this.f479a;
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
            int compareTo = Boolean.valueOf(m358a()).compareTo(Boolean.valueOf(hxVar.m358a()));
            if (compareTo == 0) {
                if (!m358a() || (a8 = iy.a(this.f479a, hxVar.f479a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m360b()).compareTo(Boolean.valueOf(hxVar.m360b()));
                    if (compareTo2 == 0) {
                        if (!m360b() || (a7 = iy.a(this.f484b, hxVar.f484b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m361c()).compareTo(Boolean.valueOf(hxVar.m361c()));
                            if (compareTo3 == 0) {
                                if (!m361c() || (a6 = iy.a(this.f483a, hxVar.f483a)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f486c, hxVar.f486c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f480a, hxVar.f480a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f481a, hxVar.f481a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a2 = iy.a(this.f485b, hxVar.f485b)) == 0) {
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
    public long m355a() {
        return this.f480a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m356a() {
        return this.f481a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m357a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                m357a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f479a = jiVar.m476a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f484b = jiVar.m476a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m478a.f4770a != 2) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f483a = jiVar.m487a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m478a.f4770a != 8) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f486c = jiVar.m476a();
                        d(true);
                        break;
                    }
                case 5:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f480a = jiVar.m477a();
                        e(true);
                        break;
                    }
                case 6:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f481a = jiVar.m483a();
                        break;
                    }
                case 7:
                    if (m478a.f4770a != 2) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f485b = jiVar.m487a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f482a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m358a() {
        return this.f482a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m359a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m358a = m358a();
        boolean m358a2 = hxVar.m358a();
        if ((m358a || m358a2) && !(m358a && m358a2 && this.f479a == hxVar.f479a)) {
            return false;
        }
        boolean m360b = m360b();
        boolean m360b2 = hxVar.m360b();
        if ((m360b || m360b2) && !(m360b && m360b2 && this.f484b == hxVar.f484b)) {
            return false;
        }
        boolean m361c = m361c();
        boolean m361c2 = hxVar.m361c();
        if ((m361c || m361c2) && !(m361c && m361c2 && this.f483a == hxVar.f483a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f486c == hxVar.f486c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f480a == hxVar.f480a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f481a.equals(hxVar.f481a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hxVar.h();
        return !(h || h2) || (h && h2 && this.f485b == hxVar.f485b);
    }

    public int b() {
        return this.f484b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m357a();
        jiVar.a(f478a);
        if (m358a()) {
            jiVar.a(f4736a);
            jiVar.a(this.f479a);
            jiVar.b();
        }
        if (m360b()) {
            jiVar.a(b);
            jiVar.a(this.f484b);
            jiVar.b();
        }
        if (m361c()) {
            jiVar.a(c);
            jiVar.a(this.f483a);
            jiVar.b();
        }
        if (d()) {
            jiVar.a(d);
            jiVar.a(this.f486c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f480a);
            jiVar.b();
        }
        if (this.f481a != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f481a);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(g);
            jiVar.a(this.f485b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public void b(boolean z) {
        this.f482a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m360b() {
        return this.f482a.get(1);
    }

    public int c() {
        return this.f486c;
    }

    public void c(boolean z) {
        this.f482a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m361c() {
        return this.f482a.get(2);
    }

    public void d(boolean z) {
        this.f482a.set(3, z);
    }

    public boolean d() {
        return this.f482a.get(3);
    }

    public void e(boolean z) {
        this.f482a.set(4, z);
    }

    public boolean e() {
        return this.f482a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m359a((hx) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f482a.set(5, z);
    }

    public boolean f() {
        return this.f481a != null;
    }

    public boolean g() {
        return this.f485b;
    }

    public boolean h() {
        return this.f482a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (m358a()) {
            sb.append("key:");
            sb.append(this.f479a);
            z2 = false;
        }
        if (m360b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f484b);
            z2 = false;
        }
        if (m361c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f483a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f486c);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f480a);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f481a == null) {
                sb.append("null");
            } else {
                sb.append(this.f481a);
            }
        } else {
            z = z2;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f485b);
        }
        sb.append(")");
        return sb.toString();
    }
}
