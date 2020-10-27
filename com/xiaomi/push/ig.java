package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes12.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f572a;

    /* renamed from: a  reason: collision with other field name */
    public ib f573a;

    /* renamed from: a  reason: collision with other field name */
    public String f574a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f576a;

    /* renamed from: b  reason: collision with other field name */
    public String f578b;

    /* renamed from: c  reason: collision with other field name */
    public String f580c;

    /* renamed from: d  reason: collision with other field name */
    public String f581d;

    /* renamed from: e  reason: collision with other field name */
    public String f582e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f571a = new jn("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4974a = new jf("", (byte) 12, 2);
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
    private BitSet f575a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f577a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f579b = true;

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
            int compareTo = Boolean.valueOf(m411a()).compareTo(Boolean.valueOf(igVar.m411a()));
            if (compareTo == 0) {
                if (!m411a() || (a11 = iy.a(this.f573a, igVar.f573a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f574a, igVar.f574a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f578b, igVar.f578b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f580c, igVar.f580c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f576a, igVar.f576a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f581d, igVar.f581d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f582e, igVar.f582e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f577a, igVar.f577a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f579b, igVar.f579b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f572a, igVar.f572a)) == 0) {
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
        this.f574a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f576a = list;
        return this;
    }

    public String a() {
        return this.f580c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m409a() {
        if (this.f574a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f578b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f580c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m409a();
                return;
            }
            switch (m485a.f776a) {
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f573a = new ib();
                        this.f573a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f574a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f578b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f580c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f576a = new ArrayList(m486a.f777a);
                        for (int i2 = 0; i2 < m486a.f777a; i2++) {
                            this.f576a.add(jiVar.m490a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f581d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 9:
                    if (m485a.f4998a == 11) {
                        this.f582e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 2) {
                        this.f577a = jiVar.m494a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 11:
                    if (m485a.f4998a == 2) {
                        this.f579b = jiVar.m494a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 12:
                    if (m485a.f4998a == 10) {
                        this.f572a = jiVar.m484a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m410a(String str) {
        if (this.f576a == null) {
            this.f576a = new ArrayList();
        }
        this.f576a.add(str);
    }

    public void a(boolean z) {
        this.f575a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a() {
        return this.f573a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m412a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m411a = m411a();
        boolean m411a2 = igVar.m411a();
        if ((m411a || m411a2) && !(m411a && m411a2 && this.f573a.m398a(igVar.f573a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f574a.equals(igVar.f574a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f578b.equals(igVar.f578b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f580c.equals(igVar.f580c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f576a.equals(igVar.f576a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f581d.equals(igVar.f581d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f582e.equals(igVar.f582e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f577a == igVar.f577a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f579b == igVar.f579b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f572a == igVar.f572a);
    }

    public ig b(String str) {
        this.f578b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m409a();
        jiVar.a(f571a);
        if (this.f573a != null && m411a()) {
            jiVar.a(f4974a);
            this.f573a.b(jiVar);
            jiVar.b();
        }
        if (this.f574a != null) {
            jiVar.a(b);
            jiVar.a(this.f574a);
            jiVar.b();
        }
        if (this.f578b != null) {
            jiVar.a(c);
            jiVar.a(this.f578b);
            jiVar.b();
        }
        if (this.f580c != null) {
            jiVar.a(d);
            jiVar.a(this.f580c);
            jiVar.b();
        }
        if (this.f576a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f576a.size()));
            for (String str : this.f576a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f581d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f581d);
            jiVar.b();
        }
        if (this.f582e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f582e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f577a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f579b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f572a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f575a.set(1, z);
    }

    public boolean b() {
        return this.f574a != null;
    }

    public ig c(String str) {
        this.f580c = str;
        return this;
    }

    public void c(boolean z) {
        this.f575a.set(2, z);
    }

    public boolean c() {
        return this.f578b != null;
    }

    public ig d(String str) {
        this.f581d = str;
        return this;
    }

    public boolean d() {
        return this.f580c != null;
    }

    public ig e(String str) {
        this.f582e = str;
        return this;
    }

    public boolean e() {
        return this.f576a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m412a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f581d != null;
    }

    public boolean g() {
        return this.f582e != null;
    }

    public boolean h() {
        return this.f575a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f575a.get(1);
    }

    public boolean j() {
        return this.f575a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m411a()) {
            sb.append("target:");
            if (this.f573a == null) {
                sb.append("null");
            } else {
                sb.append(this.f573a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f574a == null) {
            sb.append("null");
        } else {
            sb.append(this.f574a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f578b == null) {
            sb.append("null");
        } else {
            sb.append(this.f578b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f580c == null) {
            sb.append("null");
        } else {
            sb.append(this.f580c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f576a == null) {
                sb.append("null");
            } else {
                sb.append(this.f576a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f581d == null) {
                sb.append("null");
            } else {
                sb.append(this.f581d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f582e == null) {
                sb.append("null");
            } else {
                sb.append(this.f582e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f577a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f579b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f572a);
        }
        sb.append(")");
        return sb.toString();
    }
}
