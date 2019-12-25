package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class in implements ir<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f753a;

    /* renamed from: a  reason: collision with other field name */
    public hv f754a;

    /* renamed from: a  reason: collision with other field name */
    public String f755a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f756a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f757b;

    /* renamed from: b  reason: collision with other field name */
    public String f758b;

    /* renamed from: c  reason: collision with other field name */
    public long f759c;

    /* renamed from: c  reason: collision with other field name */
    public String f760c;

    /* renamed from: d  reason: collision with other field name */
    public String f761d;

    /* renamed from: e  reason: collision with other field name */
    public String f762e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f752a = new jh("XmPushActionUnRegistrationResult");
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
            int compareTo = Boolean.valueOf(m440a()).compareTo(Boolean.valueOf(inVar.m440a()));
            if (compareTo == 0) {
                if (!m440a() || (a10 = is.a(this.f755a, inVar.f755a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = is.a(this.f754a, inVar.f754a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f758b, inVar.f758b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f760c, inVar.f760c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f753a, inVar.f753a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f761d, inVar.f761d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f762e, inVar.f762e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f757b, inVar.f757b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f759c, inVar.f759c)) == 0) {
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
        return this.f762e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m439a() {
        if (this.f758b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f760c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m439a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f755a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f754a = new hv();
                        this.f754a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f758b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f760c = jcVar.m459a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 6:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f753a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f761d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f762e = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f757b = jcVar.m453a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f759c = jcVar.m453a();
                        c(true);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f756a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a() {
        return this.f755a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m440a = m440a();
        boolean m440a2 = inVar.m440a();
        if ((m440a || m440a2) && !(m440a && m440a2 && this.f755a.equals(inVar.f755a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f754a.m364a(inVar.f754a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f758b.equals(inVar.f758b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f760c.equals(inVar.f760c))) || this.f753a != inVar.f753a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f761d.equals(inVar.f761d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f762e.equals(inVar.f762e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f757b == inVar.f757b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f759c == inVar.f759c);
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m439a();
        jcVar.a(f752a);
        if (this.f755a != null && m440a()) {
            jcVar.a(a);
            jcVar.a(this.f755a);
            jcVar.b();
        }
        if (this.f754a != null && b()) {
            jcVar.a(b);
            this.f754a.b(jcVar);
            jcVar.b();
        }
        if (this.f758b != null) {
            jcVar.a(c);
            jcVar.a(this.f758b);
            jcVar.b();
        }
        if (this.f760c != null) {
            jcVar.a(d);
            jcVar.a(this.f760c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f753a);
        jcVar.b();
        if (this.f761d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f761d);
            jcVar.b();
        }
        if (this.f762e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f762e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f757b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f759c);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f756a.set(1, z);
    }

    public boolean b() {
        return this.f754a != null;
    }

    public void c(boolean z) {
        this.f756a.set(2, z);
    }

    public boolean c() {
        return this.f758b != null;
    }

    public boolean d() {
        return this.f760c != null;
    }

    public boolean e() {
        return this.f756a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m441a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f761d != null;
    }

    public boolean g() {
        return this.f762e != null;
    }

    public boolean h() {
        return this.f756a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f756a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m440a()) {
            sb.append("debug:");
            if (this.f755a == null) {
                sb.append("null");
            } else {
                sb.append(this.f755a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f754a == null) {
                sb.append("null");
            } else {
                sb.append(this.f754a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f758b == null) {
            sb.append("null");
        } else {
            sb.append(this.f758b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f760c == null) {
            sb.append("null");
        } else {
            sb.append(this.f760c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f753a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f761d == null) {
                sb.append("null");
            } else {
                sb.append(this.f761d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f762e == null) {
                sb.append("null");
            } else {
                sb.append(this.f762e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f757b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f759c);
        }
        sb.append(")");
        return sb.toString();
    }
}
