package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f653a;

    /* renamed from: a  reason: collision with other field name */
    public ib f654a;

    /* renamed from: a  reason: collision with other field name */
    public String f655a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f657a;

    /* renamed from: b  reason: collision with other field name */
    public String f659b;

    /* renamed from: c  reason: collision with other field name */
    public String f661c;

    /* renamed from: d  reason: collision with other field name */
    public String f662d;

    /* renamed from: e  reason: collision with other field name */
    public String f663e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f652a = new jn("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14133a = new jf("", (byte) 12, 2);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14134b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 15, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 2, 10);
    private static final jf i = new jf("", (byte) 2, 11);
    private static final jf j = new jf("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f656a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f658a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f660b = true;

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
            int compareTo = Boolean.valueOf(m436a()).compareTo(Boolean.valueOf(igVar.m436a()));
            if (compareTo == 0) {
                if (!m436a() || (a11 = iy.a(this.f654a, igVar.f654a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f655a, igVar.f655a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f659b, igVar.f659b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f661c, igVar.f661c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f657a, igVar.f657a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f662d, igVar.f662d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f663e, igVar.f663e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f658a, igVar.f658a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f660b, igVar.f660b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f653a, igVar.f653a)) == 0) {
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
        this.f655a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f657a = list;
        return this;
    }

    public String a() {
        return this.f661c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m434a() {
        if (this.f655a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f659b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f661c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m434a();
                return;
            }
            switch (m510a.f857a) {
                case 2:
                    if (m510a.f14173a == 12) {
                        this.f654a = new ib();
                        this.f654a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 3:
                    if (m510a.f14173a == 11) {
                        this.f655a = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 4:
                    if (m510a.f14173a == 11) {
                        this.f659b = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 5:
                    if (m510a.f14173a == 11) {
                        this.f661c = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 6:
                    if (m510a.f14173a == 15) {
                        jg m511a = jiVar.m511a();
                        this.f657a = new ArrayList(m511a.f858a);
                        for (int i2 = 0; i2 < m511a.f858a; i2++) {
                            this.f657a.add(jiVar.m515a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 7:
                    if (m510a.f14173a == 11) {
                        this.f662d = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
                case 9:
                    if (m510a.f14173a == 11) {
                        this.f663e = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 10:
                    if (m510a.f14173a == 2) {
                        this.f658a = jiVar.m519a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 11:
                    if (m510a.f14173a == 2) {
                        this.f660b = jiVar.m519a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 12:
                    if (m510a.f14173a == 10) {
                        this.f653a = jiVar.m509a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m435a(String str) {
        if (this.f657a == null) {
            this.f657a = new ArrayList();
        }
        this.f657a.add(str);
    }

    public void a(boolean z) {
        this.f656a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a() {
        return this.f654a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m436a = m436a();
        boolean m436a2 = igVar.m436a();
        if ((m436a || m436a2) && !(m436a && m436a2 && this.f654a.m423a(igVar.f654a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f655a.equals(igVar.f655a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f659b.equals(igVar.f659b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f661c.equals(igVar.f661c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f657a.equals(igVar.f657a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f662d.equals(igVar.f662d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f663e.equals(igVar.f663e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f658a == igVar.f658a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f660b == igVar.f660b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f653a == igVar.f653a);
    }

    public ig b(String str) {
        this.f659b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m434a();
        jiVar.a(f652a);
        if (this.f654a != null && m436a()) {
            jiVar.a(f14133a);
            this.f654a.b(jiVar);
            jiVar.b();
        }
        if (this.f655a != null) {
            jiVar.a(f14134b);
            jiVar.a(this.f655a);
            jiVar.b();
        }
        if (this.f659b != null) {
            jiVar.a(c);
            jiVar.a(this.f659b);
            jiVar.b();
        }
        if (this.f661c != null) {
            jiVar.a(d);
            jiVar.a(this.f661c);
            jiVar.b();
        }
        if (this.f657a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f657a.size()));
            for (String str : this.f657a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f662d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f662d);
            jiVar.b();
        }
        if (this.f663e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f663e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f658a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f660b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f653a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public void b(boolean z) {
        this.f656a.set(1, z);
    }

    public boolean b() {
        return this.f655a != null;
    }

    public ig c(String str) {
        this.f661c = str;
        return this;
    }

    public void c(boolean z) {
        this.f656a.set(2, z);
    }

    public boolean c() {
        return this.f659b != null;
    }

    public ig d(String str) {
        this.f662d = str;
        return this;
    }

    public boolean d() {
        return this.f661c != null;
    }

    public ig e(String str) {
        this.f663e = str;
        return this;
    }

    public boolean e() {
        return this.f657a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m437a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f662d != null;
    }

    public boolean g() {
        return this.f663e != null;
    }

    public boolean h() {
        return this.f656a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f656a.get(1);
    }

    public boolean j() {
        return this.f656a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m436a()) {
            sb.append("target:");
            if (this.f654a == null) {
                sb.append("null");
            } else {
                sb.append(this.f654a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f655a == null) {
            sb.append("null");
        } else {
            sb.append(this.f655a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f659b == null) {
            sb.append("null");
        } else {
            sb.append(this.f659b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f661c == null) {
            sb.append("null");
        } else {
            sb.append(this.f661c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f657a == null) {
                sb.append("null");
            } else {
                sb.append(this.f657a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f662d == null) {
                sb.append("null");
            } else {
                sb.append(this.f662d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f663e == null) {
                sb.append("null");
            } else {
                sb.append(this.f663e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f658a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f660b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f653a);
        }
        sb.append(")");
        return sb.toString();
    }
}
