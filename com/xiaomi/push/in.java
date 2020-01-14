package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class in implements ir<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f752a;

    /* renamed from: a  reason: collision with other field name */
    public hv f753a;

    /* renamed from: a  reason: collision with other field name */
    public String f754a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f755a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f756b;

    /* renamed from: b  reason: collision with other field name */
    public String f757b;

    /* renamed from: c  reason: collision with other field name */
    public long f758c;

    /* renamed from: c  reason: collision with other field name */
    public String f759c;

    /* renamed from: d  reason: collision with other field name */
    public String f760d;

    /* renamed from: e  reason: collision with other field name */
    public String f761e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f751a = new jh("XmPushActionUnRegistrationResult");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz h = new iz("", (byte) 10, 9);
    private static final iz i = new iz("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m449a()).compareTo(Boolean.valueOf(inVar.m449a()));
            if (compareTo == 0) {
                if (!m449a() || (a10 = is.a(this.f754a, inVar.f754a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = is.a(this.f753a, inVar.f753a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f757b, inVar.f757b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f759c, inVar.f759c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f752a, inVar.f752a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f760d, inVar.f760d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f761e, inVar.f761e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f756b, inVar.f756b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f758c, inVar.f758c)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a3;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a4;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a5;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a6;
                                            }
                                            return compareTo5;
                                        }
                                        return a7;
                                    }
                                    return compareTo4;
                                }
                                return a8;
                            }
                            return compareTo3;
                        }
                        return a9;
                    }
                    return compareTo2;
                }
                return a10;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(inVar.getClass().getName());
    }

    public String a() {
        return this.f761e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m448a() {
        if (this.f757b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f759c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m448a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f754a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f753a = new hv();
                        this.f753a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f757b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f759c = jcVar.m468a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 6:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f752a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f760d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f761e = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f756b = jcVar.m462a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f758c = jcVar.m462a();
                        c(true);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f755a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a() {
        return this.f754a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m450a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m449a = m449a();
        boolean m449a2 = inVar.m449a();
        if ((m449a || m449a2) && !(m449a && m449a2 && this.f754a.equals(inVar.f754a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f753a.m373a(inVar.f753a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f757b.equals(inVar.f757b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f759c.equals(inVar.f759c))) || this.f752a != inVar.f752a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f760d.equals(inVar.f760d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f761e.equals(inVar.f761e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f756b == inVar.f756b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f758c == inVar.f758c);
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m448a();
        jcVar.a(f751a);
        if (this.f754a != null && m449a()) {
            jcVar.a(a);
            jcVar.a(this.f754a);
            jcVar.b();
        }
        if (this.f753a != null && b()) {
            jcVar.a(b);
            this.f753a.b(jcVar);
            jcVar.b();
        }
        if (this.f757b != null) {
            jcVar.a(c);
            jcVar.a(this.f757b);
            jcVar.b();
        }
        if (this.f759c != null) {
            jcVar.a(d);
            jcVar.a(this.f759c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f752a);
        jcVar.b();
        if (this.f760d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f760d);
            jcVar.b();
        }
        if (this.f761e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f761e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f756b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f758c);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f755a.set(1, z);
    }

    public boolean b() {
        return this.f753a != null;
    }

    public void c(boolean z) {
        this.f755a.set(2, z);
    }

    public boolean c() {
        return this.f757b != null;
    }

    public boolean d() {
        return this.f759c != null;
    }

    public boolean e() {
        return this.f755a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m450a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f760d != null;
    }

    public boolean g() {
        return this.f761e != null;
    }

    public boolean h() {
        return this.f755a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f755a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m449a()) {
            sb.append("debug:");
            if (this.f754a == null) {
                sb.append("null");
            } else {
                sb.append(this.f754a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f753a == null) {
                sb.append("null");
            } else {
                sb.append(this.f753a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f757b == null) {
            sb.append("null");
        } else {
            sb.append(this.f757b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f759c == null) {
            sb.append("null");
        } else {
            sb.append(this.f759c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f752a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f760d == null) {
                sb.append("null");
            } else {
                sb.append(this.f760d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f761e == null) {
                sb.append("null");
            } else {
                sb.append(this.f761e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f756b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f758c);
        }
        sb.append(")");
        return sb.toString();
    }
}
