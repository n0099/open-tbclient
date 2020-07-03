package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f591a;

    /* renamed from: a  reason: collision with other field name */
    public ib f592a;

    /* renamed from: a  reason: collision with other field name */
    public String f593a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f595a;

    /* renamed from: b  reason: collision with other field name */
    public String f597b;

    /* renamed from: c  reason: collision with other field name */
    public String f598c;

    /* renamed from: d  reason: collision with other field name */
    public String f599d;

    /* renamed from: e  reason: collision with other field name */
    public String f600e;

    /* renamed from: f  reason: collision with other field name */
    public String f601f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f590a = new jn("XmPushActionCommandResult");
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
    private BitSet f594a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f596a = true;

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
            int compareTo = Boolean.valueOf(m409a()).compareTo(Boolean.valueOf(ihVar.m409a()));
            if (compareTo == 0) {
                if (!m409a() || (a11 = iy.a(this.f592a, ihVar.f592a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m411b()).compareTo(Boolean.valueOf(ihVar.m411b()));
                    if (compareTo2 == 0) {
                        if (!m411b() || (a10 = iy.a(this.f593a, ihVar.f593a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f597b, ihVar.f597b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f598c, ihVar.f598c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f591a, ihVar.f591a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f599d, ihVar.f599d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f600e, ihVar.f600e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f595a, ihVar.f595a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f601f, ihVar.f601f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f596a, ihVar.f596a)) == 0) {
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
        return this.f598c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m407a() {
        return this.f595a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m408a() {
        if (this.f593a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f597b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f598c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m408a();
                return;
            }
            switch (m479a.f783a) {
                case 2:
                    if (m479a.a == 12) {
                        this.f592a = new ib();
                        this.f592a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f593a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f597b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f598c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 7:
                    if (m479a.a == 10) {
                        this.f591a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 11) {
                        this.f599d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 11) {
                        this.f600e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f595a = new ArrayList(m480a.f784a);
                        for (int i2 = 0; i2 < m480a.f784a; i2++) {
                            this.f595a.add(jiVar.m484a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 12:
                    if (m479a.a == 11) {
                        this.f601f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 13:
                    if (m479a.a == 2) {
                        this.f596a = jiVar.m488a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f594a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m409a() {
        return this.f592a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m409a = m409a();
        boolean m409a2 = ihVar.m409a();
        if ((m409a || m409a2) && !(m409a && m409a2 && this.f592a.m392a(ihVar.f592a))) {
            return false;
        }
        boolean m411b = m411b();
        boolean m411b2 = ihVar.m411b();
        if ((m411b || m411b2) && !(m411b && m411b2 && this.f593a.equals(ihVar.f593a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f597b.equals(ihVar.f597b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f598c.equals(ihVar.f598c))) || this.f591a != ihVar.f591a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f599d.equals(ihVar.f599d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f600e.equals(ihVar.f600e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f595a.equals(ihVar.f595a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f601f.equals(ihVar.f601f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f596a == ihVar.f596a);
    }

    public String b() {
        return this.f601f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m408a();
        jiVar.a(f590a);
        if (this.f592a != null && m409a()) {
            jiVar.a(a);
            this.f592a.b(jiVar);
            jiVar.b();
        }
        if (this.f593a != null) {
            jiVar.a(b);
            jiVar.a(this.f593a);
            jiVar.b();
        }
        if (this.f597b != null) {
            jiVar.a(c);
            jiVar.a(this.f597b);
            jiVar.b();
        }
        if (this.f598c != null) {
            jiVar.a(d);
            jiVar.a(this.f598c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f591a);
        jiVar.b();
        if (this.f599d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f599d);
            jiVar.b();
        }
        if (this.f600e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f600e);
            jiVar.b();
        }
        if (this.f595a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f595a.size()));
            for (String str : this.f595a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f601f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f601f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f596a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f594a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m411b() {
        return this.f593a != null;
    }

    public boolean c() {
        return this.f597b != null;
    }

    public boolean d() {
        return this.f598c != null;
    }

    public boolean e() {
        return this.f594a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m410a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f599d != null;
    }

    public boolean g() {
        return this.f600e != null;
    }

    public boolean h() {
        return this.f595a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f601f != null;
    }

    public boolean j() {
        return this.f594a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m409a()) {
            sb.append("target:");
            if (this.f592a == null) {
                sb.append("null");
            } else {
                sb.append(this.f592a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f593a == null) {
            sb.append("null");
        } else {
            sb.append(this.f593a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f597b == null) {
            sb.append("null");
        } else {
            sb.append(this.f597b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f598c == null) {
            sb.append("null");
        } else {
            sb.append(this.f598c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f591a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f599d == null) {
                sb.append("null");
            } else {
                sb.append(this.f599d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f600e == null) {
                sb.append("null");
            } else {
                sb.append(this.f600e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f595a == null) {
                sb.append("null");
            } else {
                sb.append(this.f595a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f601f == null) {
                sb.append("null");
            } else {
                sb.append(this.f601f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f596a);
        }
        sb.append(")");
        return sb.toString();
    }
}
