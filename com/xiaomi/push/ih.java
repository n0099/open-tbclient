package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes18.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f589a;

    /* renamed from: a  reason: collision with other field name */
    public ib f590a;

    /* renamed from: a  reason: collision with other field name */
    public String f591a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f593a;

    /* renamed from: b  reason: collision with other field name */
    public String f595b;

    /* renamed from: c  reason: collision with other field name */
    public String f596c;

    /* renamed from: d  reason: collision with other field name */
    public String f597d;

    /* renamed from: e  reason: collision with other field name */
    public String f598e;

    /* renamed from: f  reason: collision with other field name */
    public String f599f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f588a = new jn("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4977a = new jf("", (byte) 12, 2);
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
    private BitSet f592a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f594a = true;

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
            int compareTo = Boolean.valueOf(m418a()).compareTo(Boolean.valueOf(ihVar.m418a()));
            if (compareTo == 0) {
                if (!m418a() || (a11 = iy.a(this.f590a, ihVar.f590a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m420b()).compareTo(Boolean.valueOf(ihVar.m420b()));
                    if (compareTo2 == 0) {
                        if (!m420b() || (a10 = iy.a(this.f591a, ihVar.f591a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f595b, ihVar.f595b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f596c, ihVar.f596c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f589a, ihVar.f589a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f597d, ihVar.f597d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f598e, ihVar.f598e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f593a, ihVar.f593a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f599f, ihVar.f599f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f594a, ihVar.f594a)) == 0) {
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
        return this.f596c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m416a() {
        return this.f593a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m417a() {
        if (this.f591a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f595b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f596c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m417a();
                return;
            }
            switch (m488a.f781a) {
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f590a = new ib();
                        this.f590a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f591a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f595b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f596c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 7:
                    if (m488a.f5000a == 10) {
                        this.f589a = jiVar.m487a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 11) {
                        this.f597d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 11) {
                        this.f598e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f593a = new ArrayList(m489a.f782a);
                        for (int i2 = 0; i2 < m489a.f782a; i2++) {
                            this.f593a.add(jiVar.m493a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 12:
                    if (m488a.f5000a == 11) {
                        this.f599f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 13:
                    if (m488a.f5000a == 2) {
                        this.f594a = jiVar.m497a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f592a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m418a() {
        return this.f590a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m419a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m418a = m418a();
        boolean m418a2 = ihVar.m418a();
        if ((m418a || m418a2) && !(m418a && m418a2 && this.f590a.m401a(ihVar.f590a))) {
            return false;
        }
        boolean m420b = m420b();
        boolean m420b2 = ihVar.m420b();
        if ((m420b || m420b2) && !(m420b && m420b2 && this.f591a.equals(ihVar.f591a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f595b.equals(ihVar.f595b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f596c.equals(ihVar.f596c))) || this.f589a != ihVar.f589a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f597d.equals(ihVar.f597d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f598e.equals(ihVar.f598e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f593a.equals(ihVar.f593a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f599f.equals(ihVar.f599f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f594a == ihVar.f594a);
    }

    public String b() {
        return this.f599f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m417a();
        jiVar.a(f588a);
        if (this.f590a != null && m418a()) {
            jiVar.a(f4977a);
            this.f590a.b(jiVar);
            jiVar.b();
        }
        if (this.f591a != null) {
            jiVar.a(b);
            jiVar.a(this.f591a);
            jiVar.b();
        }
        if (this.f595b != null) {
            jiVar.a(c);
            jiVar.a(this.f595b);
            jiVar.b();
        }
        if (this.f596c != null) {
            jiVar.a(d);
            jiVar.a(this.f596c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f589a);
        jiVar.b();
        if (this.f597d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f597d);
            jiVar.b();
        }
        if (this.f598e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f598e);
            jiVar.b();
        }
        if (this.f593a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f593a.size()));
            for (String str : this.f593a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f599f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f599f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f594a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f592a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m420b() {
        return this.f591a != null;
    }

    public boolean c() {
        return this.f595b != null;
    }

    public boolean d() {
        return this.f596c != null;
    }

    public boolean e() {
        return this.f592a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m419a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f597d != null;
    }

    public boolean g() {
        return this.f598e != null;
    }

    public boolean h() {
        return this.f593a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f599f != null;
    }

    public boolean j() {
        return this.f592a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m418a()) {
            sb.append("target:");
            if (this.f590a == null) {
                sb.append("null");
            } else {
                sb.append(this.f590a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f591a == null) {
            sb.append("null");
        } else {
            sb.append(this.f591a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f595b == null) {
            sb.append("null");
        } else {
            sb.append(this.f595b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f596c == null) {
            sb.append("null");
        } else {
            sb.append(this.f596c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f589a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f597d == null) {
                sb.append("null");
            } else {
                sb.append(this.f597d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f598e == null) {
                sb.append("null");
            } else {
                sb.append(this.f598e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f593a == null) {
                sb.append("null");
            } else {
                sb.append(this.f593a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f599f == null) {
                sb.append("null");
            } else {
                sb.append(this.f599f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f594a);
        }
        sb.append(")");
        return sb.toString();
    }
}
