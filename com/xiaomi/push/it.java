package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f735a;

    /* renamed from: a  reason: collision with other field name */
    public ib f736a;

    /* renamed from: a  reason: collision with other field name */
    public String f737a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f738a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f739b;

    /* renamed from: b  reason: collision with other field name */
    public String f740b;

    /* renamed from: c  reason: collision with other field name */
    public long f741c;

    /* renamed from: c  reason: collision with other field name */
    public String f742c;

    /* renamed from: d  reason: collision with other field name */
    public String f743d;

    /* renamed from: e  reason: collision with other field name */
    public String f744e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f734a = new jn("XmPushActionUnRegistrationResult");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m469a()).compareTo(Boolean.valueOf(itVar.m469a()));
            if (compareTo == 0) {
                if (!m469a() || (a10 = iy.a(this.f737a, itVar.f737a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f736a, itVar.f736a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f740b, itVar.f740b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f742c, itVar.f742c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f735a, itVar.f735a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f743d, itVar.f743d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f744e, itVar.f744e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f739b, itVar.f739b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f741c, itVar.f741c)) == 0) {
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
        return this.f744e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m468a() {
        if (this.f740b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f742c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m468a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f737a = jiVar.m488a();
                        break;
                    }
                case 2:
                    if (m483a.a != 12) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f736a = new ib();
                        this.f736a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f740b = jiVar.m488a();
                        break;
                    }
                case 4:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f742c = jiVar.m488a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m483a.a);
                    break;
                case 6:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f735a = jiVar.m482a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f743d = jiVar.m488a();
                        break;
                    }
                case 8:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f744e = jiVar.m488a();
                        break;
                    }
                case 9:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f739b = jiVar.m482a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m483a.a != 10) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f741c = jiVar.m482a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f738a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a() {
        return this.f737a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m469a = m469a();
        boolean m469a2 = itVar.m469a();
        if ((m469a || m469a2) && !(m469a && m469a2 && this.f737a.equals(itVar.f737a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f736a.m396a(itVar.f736a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f740b.equals(itVar.f740b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f742c.equals(itVar.f742c))) || this.f735a != itVar.f735a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f743d.equals(itVar.f743d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f744e.equals(itVar.f744e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f739b == itVar.f739b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f741c == itVar.f741c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m468a();
        jiVar.a(f734a);
        if (this.f737a != null && m469a()) {
            jiVar.a(a);
            jiVar.a(this.f737a);
            jiVar.b();
        }
        if (this.f736a != null && b()) {
            jiVar.a(b);
            this.f736a.b(jiVar);
            jiVar.b();
        }
        if (this.f740b != null) {
            jiVar.a(c);
            jiVar.a(this.f740b);
            jiVar.b();
        }
        if (this.f742c != null) {
            jiVar.a(d);
            jiVar.a(this.f742c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f735a);
        jiVar.b();
        if (this.f743d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f743d);
            jiVar.b();
        }
        if (this.f744e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f744e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f739b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f741c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f738a.set(1, z);
    }

    public boolean b() {
        return this.f736a != null;
    }

    public void c(boolean z) {
        this.f738a.set(2, z);
    }

    public boolean c() {
        return this.f740b != null;
    }

    public boolean d() {
        return this.f742c != null;
    }

    public boolean e() {
        return this.f738a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m470a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f743d != null;
    }

    public boolean g() {
        return this.f744e != null;
    }

    public boolean h() {
        return this.f738a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f738a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m469a()) {
            sb.append("debug:");
            if (this.f737a == null) {
                sb.append("null");
            } else {
                sb.append(this.f737a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f736a == null) {
                sb.append("null");
            } else {
                sb.append(this.f736a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f740b == null) {
            sb.append("null");
        } else {
            sb.append(this.f740b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f742c == null) {
            sb.append("null");
        } else {
            sb.append(this.f742c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f735a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f743d == null) {
                sb.append("null");
            } else {
                sb.append(this.f743d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f744e == null) {
                sb.append("null");
            } else {
                sb.append(this.f744e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f739b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f741c);
        }
        sb.append(")");
        return sb.toString();
    }
}
