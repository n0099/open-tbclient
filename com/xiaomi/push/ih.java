package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes9.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f588a;

    /* renamed from: a  reason: collision with other field name */
    public ib f589a;

    /* renamed from: a  reason: collision with other field name */
    public String f590a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f592a;

    /* renamed from: b  reason: collision with other field name */
    public String f594b;

    /* renamed from: c  reason: collision with other field name */
    public String f595c;

    /* renamed from: d  reason: collision with other field name */
    public String f596d;

    /* renamed from: e  reason: collision with other field name */
    public String f597e;

    /* renamed from: f  reason: collision with other field name */
    public String f598f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f587a = new jn("XmPushActionCommandResult");
    private static final jf a = new jf("", (byte) 12, 2);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 10, 7);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 15, 10);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf j = new jf("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f591a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f593a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (getClass().equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(ihVar.m410a()));
            if (compareTo == 0) {
                if (!m410a() || (a11 = iy.a(this.f589a, ihVar.f589a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m412b()).compareTo(Boolean.valueOf(ihVar.m412b()));
                    if (compareTo2 == 0) {
                        if (!m412b() || (a10 = iy.a(this.f590a, ihVar.f590a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f594b, ihVar.f594b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f595c, ihVar.f595c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f588a, ihVar.f588a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f596d, ihVar.f596d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f597e, ihVar.f597e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f592a, ihVar.f592a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f598f, ihVar.f598f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f593a, ihVar.f593a)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ihVar.getClass().getName());
    }

    public String a() {
        return this.f595c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m408a() {
        return this.f592a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m409a() {
        if (this.f590a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f594b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f595c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m409a();
                return;
            }
            switch (m480a.f780a) {
                case 2:
                    if (m480a.a == 12) {
                        this.f589a = new ib();
                        this.f589a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 11) {
                        this.f590a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 4:
                    if (m480a.a == 11) {
                        this.f594b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 5:
                    if (m480a.a == 11) {
                        this.f595c = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m480a.a);
                    break;
                case 7:
                    if (m480a.a == 10) {
                        this.f588a = jiVar.m479a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 8:
                    if (m480a.a == 11) {
                        this.f596d = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 9:
                    if (m480a.a == 11) {
                        this.f597e = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 10:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f592a = new ArrayList(m481a.f781a);
                        for (int i2 = 0; i2 < m481a.f781a; i2++) {
                            this.f592a.add(jiVar.m485a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 12:
                    if (m480a.a == 11) {
                        this.f598f = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 13:
                    if (m480a.a == 2) {
                        this.f593a = jiVar.m489a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f591a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a() {
        return this.f589a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m410a = m410a();
        boolean m410a2 = ihVar.m410a();
        if ((m410a || m410a2) && !(m410a && m410a2 && this.f589a.m393a(ihVar.f589a))) {
            return false;
        }
        boolean m412b = m412b();
        boolean m412b2 = ihVar.m412b();
        if ((m412b || m412b2) && !(m412b && m412b2 && this.f590a.equals(ihVar.f590a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f594b.equals(ihVar.f594b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f595c.equals(ihVar.f595c))) || this.f588a != ihVar.f588a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f596d.equals(ihVar.f596d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f597e.equals(ihVar.f597e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f592a.equals(ihVar.f592a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f598f.equals(ihVar.f598f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f593a == ihVar.f593a);
    }

    public String b() {
        return this.f598f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m409a();
        jiVar.a(f587a);
        if (this.f589a != null && m410a()) {
            jiVar.a(a);
            this.f589a.b(jiVar);
            jiVar.b();
        }
        if (this.f590a != null) {
            jiVar.a(b);
            jiVar.a(this.f590a);
            jiVar.b();
        }
        if (this.f594b != null) {
            jiVar.a(c);
            jiVar.a(this.f594b);
            jiVar.b();
        }
        if (this.f595c != null) {
            jiVar.a(d);
            jiVar.a(this.f595c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f588a);
        jiVar.b();
        if (this.f596d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f596d);
            jiVar.b();
        }
        if (this.f597e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f597e);
            jiVar.b();
        }
        if (this.f592a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f592a.size()));
            for (String str : this.f592a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f598f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f598f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f593a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f591a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m412b() {
        return this.f590a != null;
    }

    public boolean c() {
        return this.f594b != null;
    }

    public boolean d() {
        return this.f595c != null;
    }

    public boolean e() {
        return this.f591a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m411a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f596d != null;
    }

    public boolean g() {
        return this.f597e != null;
    }

    public boolean h() {
        return this.f592a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f598f != null;
    }

    public boolean j() {
        return this.f591a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m410a()) {
            sb.append("target:");
            if (this.f589a == null) {
                sb.append("null");
            } else {
                sb.append(this.f589a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f590a == null) {
            sb.append("null");
        } else {
            sb.append(this.f590a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f594b == null) {
            sb.append("null");
        } else {
            sb.append(this.f594b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f595c == null) {
            sb.append("null");
        } else {
            sb.append(this.f595c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f588a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f596d == null) {
                sb.append("null");
            } else {
                sb.append(this.f596d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f597e == null) {
                sb.append("null");
            } else {
                sb.append(this.f597e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f592a == null) {
                sb.append("null");
            } else {
                sb.append(this.f592a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f598f == null) {
                sb.append("null");
            } else {
                sb.append(this.f598f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f593a);
        }
        sb.append(")");
        return sb.toString();
    }
}
