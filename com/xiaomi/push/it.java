package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f815a;

    /* renamed from: a  reason: collision with other field name */
    public ib f816a;

    /* renamed from: a  reason: collision with other field name */
    public String f817a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f818a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f819b;

    /* renamed from: b  reason: collision with other field name */
    public String f820b;

    /* renamed from: c  reason: collision with other field name */
    public long f821c;

    /* renamed from: c  reason: collision with other field name */
    public String f822c;

    /* renamed from: d  reason: collision with other field name */
    public String f823d;

    /* renamed from: e  reason: collision with other field name */
    public String f824e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f814a = new jn("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14155a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14156b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 10, 9);
    private static final jf i = new jf("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(it itVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(itVar.getClass())) {
            int compareTo = Boolean.valueOf(m497a()).compareTo(Boolean.valueOf(itVar.m497a()));
            if (compareTo == 0) {
                if (!m497a() || (a10 = iy.a(this.f817a, itVar.f817a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f816a, itVar.f816a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f820b, itVar.f820b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f822c, itVar.f822c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f815a, itVar.f815a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f823d, itVar.f823d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f824e, itVar.f824e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f819b, itVar.f819b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f821c, itVar.f821c)) == 0) {
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
        return getClass().getName().compareTo(itVar.getClass().getName());
    }

    public String a() {
        return this.f824e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m496a() {
        if (this.f820b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f822c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m496a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f817a = jiVar.m516a();
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 12) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f816a = new ib();
                        this.f816a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f820b = jiVar.m516a();
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f822c = jiVar.m516a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
                case 6:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f815a = jiVar.m510a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f823d = jiVar.m516a();
                        break;
                    }
                case 8:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f824e = jiVar.m516a();
                        break;
                    }
                case 9:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f819b = jiVar.m510a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f821c = jiVar.m510a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f818a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m497a() {
        return this.f817a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m498a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m497a = m497a();
        boolean m497a2 = itVar.m497a();
        if ((m497a || m497a2) && !(m497a && m497a2 && this.f817a.equals(itVar.f817a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f816a.m424a(itVar.f816a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f820b.equals(itVar.f820b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f822c.equals(itVar.f822c))) || this.f815a != itVar.f815a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f823d.equals(itVar.f823d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f824e.equals(itVar.f824e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f819b == itVar.f819b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f821c == itVar.f821c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m496a();
        jiVar.a(f814a);
        if (this.f817a != null && m497a()) {
            jiVar.a(f14155a);
            jiVar.a(this.f817a);
            jiVar.b();
        }
        if (this.f816a != null && b()) {
            jiVar.a(f14156b);
            this.f816a.b(jiVar);
            jiVar.b();
        }
        if (this.f820b != null) {
            jiVar.a(c);
            jiVar.a(this.f820b);
            jiVar.b();
        }
        if (this.f822c != null) {
            jiVar.a(d);
            jiVar.a(this.f822c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f815a);
        jiVar.b();
        if (this.f823d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f823d);
            jiVar.b();
        }
        if (this.f824e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f824e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f819b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f821c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f818a.set(1, z);
    }

    public boolean b() {
        return this.f816a != null;
    }

    public void c(boolean z) {
        this.f818a.set(2, z);
    }

    public boolean c() {
        return this.f820b != null;
    }

    public boolean d() {
        return this.f822c != null;
    }

    public boolean e() {
        return this.f818a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m498a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f823d != null;
    }

    public boolean g() {
        return this.f824e != null;
    }

    public boolean h() {
        return this.f818a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f818a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m497a()) {
            sb.append("debug:");
            if (this.f817a == null) {
                sb.append("null");
            } else {
                sb.append(this.f817a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f816a == null) {
                sb.append("null");
            } else {
                sb.append(this.f816a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f820b == null) {
            sb.append("null");
        } else {
            sb.append(this.f820b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f822c == null) {
            sb.append("null");
        } else {
            sb.append(this.f822c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f815a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f823d == null) {
                sb.append("null");
            } else {
                sb.append(this.f823d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f824e == null) {
                sb.append("null");
            } else {
                sb.append(this.f824e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f819b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f821c);
        }
        sb.append(")");
        return sb.toString();
    }
}
