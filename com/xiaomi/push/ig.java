package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes9.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f576a;

    /* renamed from: a  reason: collision with other field name */
    public ib f577a;

    /* renamed from: a  reason: collision with other field name */
    public String f578a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f580a;

    /* renamed from: b  reason: collision with other field name */
    public String f582b;

    /* renamed from: c  reason: collision with other field name */
    public String f584c;

    /* renamed from: d  reason: collision with other field name */
    public String f585d;

    /* renamed from: e  reason: collision with other field name */
    public String f586e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f575a = new jn("XmPushActionCommand");
    private static final jf a = new jf("", (byte) 12, 2);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 15, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 2, 10);
    private static final jf i = new jf("", (byte) 2, 11);
    private static final jf j = new jf("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f579a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f581a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f583b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
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
        if (getClass().equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m406a()).compareTo(Boolean.valueOf(igVar.m406a()));
            if (compareTo == 0) {
                if (!m406a() || (a11 = iy.a(this.f577a, igVar.f577a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f578a, igVar.f578a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f582b, igVar.f582b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f584c, igVar.f584c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f580a, igVar.f580a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f585d, igVar.f585d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f586e, igVar.f586e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f581a, igVar.f581a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f583b, igVar.f583b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f576a, igVar.f576a)) == 0) {
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
        return getClass().getName().compareTo(igVar.getClass().getName());
    }

    public ig a(String str) {
        this.f578a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f580a = list;
        return this;
    }

    public String a() {
        return this.f584c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m404a() {
        if (this.f578a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f582b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f584c == null) {
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
                m404a();
                return;
            }
            switch (m480a.f780a) {
                case 2:
                    if (m480a.a == 12) {
                        this.f577a = new ib();
                        this.f577a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 11) {
                        this.f578a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 4:
                    if (m480a.a == 11) {
                        this.f582b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 5:
                    if (m480a.a == 11) {
                        this.f584c = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 6:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f580a = new ArrayList(m481a.f781a);
                        for (int i2 = 0; i2 < m481a.f781a; i2++) {
                            this.f580a.add(jiVar.m485a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 7:
                    if (m480a.a == 11) {
                        this.f585d = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m480a.a);
                    break;
                case 9:
                    if (m480a.a == 11) {
                        this.f586e = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 10:
                    if (m480a.a == 2) {
                        this.f581a = jiVar.m489a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 11:
                    if (m480a.a == 2) {
                        this.f583b = jiVar.m489a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 12:
                    if (m480a.a == 10) {
                        this.f576a = jiVar.m479a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m405a(String str) {
        if (this.f580a == null) {
            this.f580a = new ArrayList();
        }
        this.f580a.add(str);
    }

    public void a(boolean z) {
        this.f579a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a() {
        return this.f577a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m406a = m406a();
        boolean m406a2 = igVar.m406a();
        if ((m406a || m406a2) && !(m406a && m406a2 && this.f577a.m393a(igVar.f577a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f578a.equals(igVar.f578a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f582b.equals(igVar.f582b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f584c.equals(igVar.f584c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f580a.equals(igVar.f580a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f585d.equals(igVar.f585d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f586e.equals(igVar.f586e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f581a == igVar.f581a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f583b == igVar.f583b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f576a == igVar.f576a);
    }

    public ig b(String str) {
        this.f582b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m404a();
        jiVar.a(f575a);
        if (this.f577a != null && m406a()) {
            jiVar.a(a);
            this.f577a.b(jiVar);
            jiVar.b();
        }
        if (this.f578a != null) {
            jiVar.a(b);
            jiVar.a(this.f578a);
            jiVar.b();
        }
        if (this.f582b != null) {
            jiVar.a(c);
            jiVar.a(this.f582b);
            jiVar.b();
        }
        if (this.f584c != null) {
            jiVar.a(d);
            jiVar.a(this.f584c);
            jiVar.b();
        }
        if (this.f580a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f580a.size()));
            for (String str : this.f580a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f585d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f585d);
            jiVar.b();
        }
        if (this.f586e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f586e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f581a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f583b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f576a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f579a.set(1, z);
    }

    public boolean b() {
        return this.f578a != null;
    }

    public ig c(String str) {
        this.f584c = str;
        return this;
    }

    public void c(boolean z) {
        this.f579a.set(2, z);
    }

    public boolean c() {
        return this.f582b != null;
    }

    public ig d(String str) {
        this.f585d = str;
        return this;
    }

    public boolean d() {
        return this.f584c != null;
    }

    public ig e(String str) {
        this.f586e = str;
        return this;
    }

    public boolean e() {
        return this.f580a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m407a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f585d != null;
    }

    public boolean g() {
        return this.f586e != null;
    }

    public boolean h() {
        return this.f579a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f579a.get(1);
    }

    public boolean j() {
        return this.f579a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m406a()) {
            sb.append("target:");
            if (this.f577a == null) {
                sb.append("null");
            } else {
                sb.append(this.f577a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f578a == null) {
            sb.append("null");
        } else {
            sb.append(this.f578a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f582b == null) {
            sb.append("null");
        } else {
            sb.append(this.f582b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f584c == null) {
            sb.append("null");
        } else {
            sb.append(this.f584c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f580a == null) {
                sb.append("null");
            } else {
                sb.append(this.f580a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f585d == null) {
                sb.append("null");
            } else {
                sb.append(this.f585d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f586e == null) {
                sb.append("null");
            } else {
                sb.append(this.f586e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f581a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f583b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f576a);
        }
        sb.append(")");
        return sb.toString();
    }
}
