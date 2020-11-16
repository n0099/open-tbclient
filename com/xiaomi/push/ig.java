package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes18.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f577a;

    /* renamed from: a  reason: collision with other field name */
    public ib f578a;

    /* renamed from: a  reason: collision with other field name */
    public String f579a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f581a;

    /* renamed from: b  reason: collision with other field name */
    public String f583b;

    /* renamed from: c  reason: collision with other field name */
    public String f585c;

    /* renamed from: d  reason: collision with other field name */
    public String f586d;

    /* renamed from: e  reason: collision with other field name */
    public String f587e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f576a = new jn("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4976a = new jf("", (byte) 12, 2);
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
    private BitSet f580a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f582a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f584b = true;

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
            int compareTo = Boolean.valueOf(m414a()).compareTo(Boolean.valueOf(igVar.m414a()));
            if (compareTo == 0) {
                if (!m414a() || (a11 = iy.a(this.f578a, igVar.f578a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f579a, igVar.f579a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f583b, igVar.f583b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f585c, igVar.f585c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f581a, igVar.f581a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f586d, igVar.f586d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f587e, igVar.f587e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f582a, igVar.f582a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f584b, igVar.f584b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f577a, igVar.f577a)) == 0) {
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
        this.f579a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f581a = list;
        return this;
    }

    public String a() {
        return this.f585c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        if (this.f579a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f583b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f585c == null) {
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
                m412a();
                return;
            }
            switch (m488a.f781a) {
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f578a = new ib();
                        this.f578a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f579a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f583b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f585c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f581a = new ArrayList(m489a.f782a);
                        for (int i2 = 0; i2 < m489a.f782a; i2++) {
                            this.f581a.add(jiVar.m493a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f586d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 9:
                    if (m488a.f5000a == 11) {
                        this.f587e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 2) {
                        this.f582a = jiVar.m497a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 2) {
                        this.f584b = jiVar.m497a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 12:
                    if (m488a.f5000a == 10) {
                        this.f577a = jiVar.m487a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m413a(String str) {
        if (this.f581a == null) {
            this.f581a = new ArrayList();
        }
        this.f581a.add(str);
    }

    public void a(boolean z) {
        this.f580a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a() {
        return this.f578a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m414a = m414a();
        boolean m414a2 = igVar.m414a();
        if ((m414a || m414a2) && !(m414a && m414a2 && this.f578a.m401a(igVar.f578a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f579a.equals(igVar.f579a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f583b.equals(igVar.f583b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f585c.equals(igVar.f585c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f581a.equals(igVar.f581a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f586d.equals(igVar.f586d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f587e.equals(igVar.f587e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f582a == igVar.f582a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f584b == igVar.f584b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f577a == igVar.f577a);
    }

    public ig b(String str) {
        this.f583b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m412a();
        jiVar.a(f576a);
        if (this.f578a != null && m414a()) {
            jiVar.a(f4976a);
            this.f578a.b(jiVar);
            jiVar.b();
        }
        if (this.f579a != null) {
            jiVar.a(b);
            jiVar.a(this.f579a);
            jiVar.b();
        }
        if (this.f583b != null) {
            jiVar.a(c);
            jiVar.a(this.f583b);
            jiVar.b();
        }
        if (this.f585c != null) {
            jiVar.a(d);
            jiVar.a(this.f585c);
            jiVar.b();
        }
        if (this.f581a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f581a.size()));
            for (String str : this.f581a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f586d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f586d);
            jiVar.b();
        }
        if (this.f587e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f587e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f582a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f584b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f577a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f580a.set(1, z);
    }

    public boolean b() {
        return this.f579a != null;
    }

    public ig c(String str) {
        this.f585c = str;
        return this;
    }

    public void c(boolean z) {
        this.f580a.set(2, z);
    }

    public boolean c() {
        return this.f583b != null;
    }

    public ig d(String str) {
        this.f586d = str;
        return this;
    }

    public boolean d() {
        return this.f585c != null;
    }

    public ig e(String str) {
        this.f587e = str;
        return this;
    }

    public boolean e() {
        return this.f581a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m415a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f586d != null;
    }

    public boolean g() {
        return this.f587e != null;
    }

    public boolean h() {
        return this.f580a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f580a.get(1);
    }

    public boolean j() {
        return this.f580a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m414a()) {
            sb.append("target:");
            if (this.f578a == null) {
                sb.append("null");
            } else {
                sb.append(this.f578a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f579a == null) {
            sb.append("null");
        } else {
            sb.append(this.f579a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f583b == null) {
            sb.append("null");
        } else {
            sb.append(this.f583b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f585c == null) {
            sb.append("null");
        } else {
            sb.append(this.f585c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f581a == null) {
                sb.append("null");
            } else {
                sb.append(this.f581a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f586d == null) {
                sb.append("null");
            } else {
                sb.append(this.f586d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f587e == null) {
                sb.append("null");
            } else {
                sb.append(this.f587e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f582a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f584b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f577a);
        }
        sb.append(")");
        return sb.toString();
    }
}
