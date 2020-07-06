package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f592a;

    /* renamed from: a  reason: collision with other field name */
    public ib f593a;

    /* renamed from: a  reason: collision with other field name */
    public String f594a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f596a;

    /* renamed from: b  reason: collision with other field name */
    public String f598b;

    /* renamed from: c  reason: collision with other field name */
    public String f599c;

    /* renamed from: d  reason: collision with other field name */
    public String f600d;

    /* renamed from: e  reason: collision with other field name */
    public String f601e;

    /* renamed from: f  reason: collision with other field name */
    public String f602f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f591a = new jn("XmPushActionCommandResult");
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
    private BitSet f595a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f597a = true;

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
                if (!m409a() || (a11 = iy.a(this.f593a, ihVar.f593a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m411b()).compareTo(Boolean.valueOf(ihVar.m411b()));
                    if (compareTo2 == 0) {
                        if (!m411b() || (a10 = iy.a(this.f594a, ihVar.f594a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f598b, ihVar.f598b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f599c, ihVar.f599c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f592a, ihVar.f592a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f600d, ihVar.f600d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f601e, ihVar.f601e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f596a, ihVar.f596a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f602f, ihVar.f602f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f597a, ihVar.f597a)) == 0) {
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
        return this.f599c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m407a() {
        return this.f596a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m408a() {
        if (this.f594a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f598b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f599c == null) {
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
            switch (m479a.f784a) {
                case 2:
                    if (m479a.a == 12) {
                        this.f593a = new ib();
                        this.f593a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f594a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f598b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f599c = jiVar.m484a();
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
                        this.f592a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 11) {
                        this.f600d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 11) {
                        this.f601e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f596a = new ArrayList(m480a.f785a);
                        for (int i2 = 0; i2 < m480a.f785a; i2++) {
                            this.f596a.add(jiVar.m484a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 12:
                    if (m479a.a == 11) {
                        this.f602f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 13:
                    if (m479a.a == 2) {
                        this.f597a = jiVar.m488a();
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
        this.f595a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m409a() {
        return this.f593a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m409a = m409a();
        boolean m409a2 = ihVar.m409a();
        if ((m409a || m409a2) && !(m409a && m409a2 && this.f593a.m392a(ihVar.f593a))) {
            return false;
        }
        boolean m411b = m411b();
        boolean m411b2 = ihVar.m411b();
        if ((m411b || m411b2) && !(m411b && m411b2 && this.f594a.equals(ihVar.f594a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f598b.equals(ihVar.f598b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f599c.equals(ihVar.f599c))) || this.f592a != ihVar.f592a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f600d.equals(ihVar.f600d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f601e.equals(ihVar.f601e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f596a.equals(ihVar.f596a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f602f.equals(ihVar.f602f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f597a == ihVar.f597a);
    }

    public String b() {
        return this.f602f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m408a();
        jiVar.a(f591a);
        if (this.f593a != null && m409a()) {
            jiVar.a(a);
            this.f593a.b(jiVar);
            jiVar.b();
        }
        if (this.f594a != null) {
            jiVar.a(b);
            jiVar.a(this.f594a);
            jiVar.b();
        }
        if (this.f598b != null) {
            jiVar.a(c);
            jiVar.a(this.f598b);
            jiVar.b();
        }
        if (this.f599c != null) {
            jiVar.a(d);
            jiVar.a(this.f599c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f592a);
        jiVar.b();
        if (this.f600d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f600d);
            jiVar.b();
        }
        if (this.f601e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f601e);
            jiVar.b();
        }
        if (this.f596a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f596a.size()));
            for (String str : this.f596a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f602f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f602f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f597a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f595a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m411b() {
        return this.f594a != null;
    }

    public boolean c() {
        return this.f598b != null;
    }

    public boolean d() {
        return this.f599c != null;
    }

    public boolean e() {
        return this.f595a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m410a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f600d != null;
    }

    public boolean g() {
        return this.f601e != null;
    }

    public boolean h() {
        return this.f596a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f602f != null;
    }

    public boolean j() {
        return this.f595a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m409a()) {
            sb.append("target:");
            if (this.f593a == null) {
                sb.append("null");
            } else {
                sb.append(this.f593a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f594a == null) {
            sb.append("null");
        } else {
            sb.append(this.f594a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f598b == null) {
            sb.append("null");
        } else {
            sb.append(this.f598b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f599c == null) {
            sb.append("null");
        } else {
            sb.append(this.f599c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f592a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f600d == null) {
                sb.append("null");
            } else {
                sb.append(this.f600d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f601e == null) {
                sb.append("null");
            } else {
                sb.append(this.f601e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f596a == null) {
                sb.append("null");
            } else {
                sb.append(this.f596a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f602f == null) {
                sb.append("null");
            } else {
                sb.append(this.f602f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f597a);
        }
        sb.append(")");
        return sb.toString();
    }
}
