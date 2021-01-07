package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f816a;

    /* renamed from: a  reason: collision with other field name */
    public ib f817a;

    /* renamed from: a  reason: collision with other field name */
    public String f818a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f819a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f820b;

    /* renamed from: b  reason: collision with other field name */
    public String f821b;

    /* renamed from: c  reason: collision with other field name */
    public long f822c;

    /* renamed from: c  reason: collision with other field name */
    public String f823c;

    /* renamed from: d  reason: collision with other field name */
    public String f824d;

    /* renamed from: e  reason: collision with other field name */
    public String f825e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f815a = new jn("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14455a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14456b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m501a()).compareTo(Boolean.valueOf(itVar.m501a()));
            if (compareTo == 0) {
                if (!m501a() || (a10 = iy.a(this.f818a, itVar.f818a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f817a, itVar.f817a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f821b, itVar.f821b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f823c, itVar.f823c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f816a, itVar.f816a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f824d, itVar.f824d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f825e, itVar.f825e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f820b, itVar.f820b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f822c, itVar.f822c)) == 0) {
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
        return this.f825e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m500a() {
        if (this.f821b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f823c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m500a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f818a = jiVar.m520a();
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f817a = new ib();
                        this.f817a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f821b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f823c = jiVar.m520a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 6:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f816a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f824d = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f825e = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f820b = jiVar.m514a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f822c = jiVar.m514a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f819a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m501a() {
        return this.f818a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m502a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m501a = m501a();
        boolean m501a2 = itVar.m501a();
        if ((m501a || m501a2) && !(m501a && m501a2 && this.f818a.equals(itVar.f818a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f817a.m428a(itVar.f817a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f821b.equals(itVar.f821b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f823c.equals(itVar.f823c))) || this.f816a != itVar.f816a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f824d.equals(itVar.f824d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f825e.equals(itVar.f825e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f820b == itVar.f820b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f822c == itVar.f822c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m500a();
        jiVar.a(f815a);
        if (this.f818a != null && m501a()) {
            jiVar.a(f14455a);
            jiVar.a(this.f818a);
            jiVar.b();
        }
        if (this.f817a != null && b()) {
            jiVar.a(f14456b);
            this.f817a.b(jiVar);
            jiVar.b();
        }
        if (this.f821b != null) {
            jiVar.a(c);
            jiVar.a(this.f821b);
            jiVar.b();
        }
        if (this.f823c != null) {
            jiVar.a(d);
            jiVar.a(this.f823c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f816a);
        jiVar.b();
        if (this.f824d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f824d);
            jiVar.b();
        }
        if (this.f825e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f825e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f820b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f822c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f819a.set(1, z);
    }

    public boolean b() {
        return this.f817a != null;
    }

    public void c(boolean z) {
        this.f819a.set(2, z);
    }

    public boolean c() {
        return this.f821b != null;
    }

    public boolean d() {
        return this.f823c != null;
    }

    public boolean e() {
        return this.f819a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m502a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f824d != null;
    }

    public boolean g() {
        return this.f825e != null;
    }

    public boolean h() {
        return this.f819a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f819a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m501a()) {
            sb.append("debug:");
            if (this.f818a == null) {
                sb.append("null");
            } else {
                sb.append(this.f818a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f817a == null) {
                sb.append("null");
            } else {
                sb.append(this.f817a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f821b == null) {
            sb.append("null");
        } else {
            sb.append(this.f821b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f823c == null) {
            sb.append("null");
        } else {
            sb.append(this.f823c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f816a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f824d == null) {
                sb.append("null");
            } else {
                sb.append(this.f824d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f825e == null) {
                sb.append("null");
            } else {
                sb.append(this.f825e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f820b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f822c);
        }
        sb.append(")");
        return sb.toString();
    }
}
