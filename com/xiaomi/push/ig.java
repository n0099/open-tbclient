package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ig implements ix<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f654a;

    /* renamed from: a  reason: collision with other field name */
    public ib f655a;

    /* renamed from: a  reason: collision with other field name */
    public String f656a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f658a;

    /* renamed from: b  reason: collision with other field name */
    public String f660b;

    /* renamed from: c  reason: collision with other field name */
    public String f662c;

    /* renamed from: d  reason: collision with other field name */
    public String f663d;

    /* renamed from: e  reason: collision with other field name */
    public String f664e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f653a = new jn("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14431a = new jf("", (byte) 12, 2);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14432b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 15, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 2, 10);
    private static final jf i = new jf("", (byte) 2, 11);
    private static final jf j = new jf("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f657a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f659a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f661b = true;

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
            int compareTo = Boolean.valueOf(m441a()).compareTo(Boolean.valueOf(igVar.m441a()));
            if (compareTo == 0) {
                if (!m441a() || (a11 = iy.a(this.f655a, igVar.f655a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f656a, igVar.f656a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f660b, igVar.f660b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f662c, igVar.f662c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f658a, igVar.f658a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f663d, igVar.f663d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f664e, igVar.f664e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f659a, igVar.f659a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f661b, igVar.f661b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f654a, igVar.f654a)) == 0) {
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
        this.f656a = str;
        return this;
    }

    public ig a(List<String> list) {
        this.f658a = list;
        return this;
    }

    public String a() {
        return this.f662c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m439a() {
        if (this.f656a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f660b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f662c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m439a();
                return;
            }
            switch (m515a.f858a) {
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f655a = new ib();
                        this.f655a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f656a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f660b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f662c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f658a = new ArrayList(m516a.f859a);
                        for (int i2 = 0; i2 < m516a.f859a; i2++) {
                            this.f658a.add(jiVar.m520a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f663d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f664e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 2) {
                        this.f659a = jiVar.m524a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 2) {
                        this.f661b = jiVar.m524a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 10) {
                        this.f654a = jiVar.m514a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m440a(String str) {
        if (this.f658a == null) {
            this.f658a = new ArrayList();
        }
        this.f658a.add(str);
    }

    public void a(boolean z) {
        this.f657a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a() {
        return this.f655a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m441a = m441a();
        boolean m441a2 = igVar.m441a();
        if ((m441a || m441a2) && !(m441a && m441a2 && this.f655a.m428a(igVar.f655a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f656a.equals(igVar.f656a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f660b.equals(igVar.f660b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f662c.equals(igVar.f662c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f658a.equals(igVar.f658a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f663d.equals(igVar.f663d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f664e.equals(igVar.f664e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f659a == igVar.f659a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f661b == igVar.f661b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f654a == igVar.f654a);
    }

    public ig b(String str) {
        this.f660b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m439a();
        jiVar.a(f653a);
        if (this.f655a != null && m441a()) {
            jiVar.a(f14431a);
            this.f655a.b(jiVar);
            jiVar.b();
        }
        if (this.f656a != null) {
            jiVar.a(f14432b);
            jiVar.a(this.f656a);
            jiVar.b();
        }
        if (this.f660b != null) {
            jiVar.a(c);
            jiVar.a(this.f660b);
            jiVar.b();
        }
        if (this.f662c != null) {
            jiVar.a(d);
            jiVar.a(this.f662c);
            jiVar.b();
        }
        if (this.f658a != null && e()) {
            jiVar.a(e);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f658a.size()));
            for (String str : this.f658a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f663d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f663d);
            jiVar.b();
        }
        if (this.f664e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f664e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f659a);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f661b);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f654a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f657a.set(1, z);
    }

    public boolean b() {
        return this.f656a != null;
    }

    public ig c(String str) {
        this.f662c = str;
        return this;
    }

    public void c(boolean z) {
        this.f657a.set(2, z);
    }

    public boolean c() {
        return this.f660b != null;
    }

    public ig d(String str) {
        this.f663d = str;
        return this;
    }

    public boolean d() {
        return this.f662c != null;
    }

    public ig e(String str) {
        this.f664e = str;
        return this;
    }

    public boolean e() {
        return this.f658a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m442a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f663d != null;
    }

    public boolean g() {
        return this.f664e != null;
    }

    public boolean h() {
        return this.f657a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f657a.get(1);
    }

    public boolean j() {
        return this.f657a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m441a()) {
            sb.append("target:");
            if (this.f655a == null) {
                sb.append("null");
            } else {
                sb.append(this.f655a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f656a == null) {
            sb.append("null");
        } else {
            sb.append(this.f656a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f660b == null) {
            sb.append("null");
        } else {
            sb.append(this.f660b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f662c == null) {
            sb.append("null");
        } else {
            sb.append(this.f662c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f658a == null) {
                sb.append("null");
            } else {
                sb.append(this.f658a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f663d == null) {
                sb.append("null");
            } else {
                sb.append(this.f663d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f664e == null) {
                sb.append("null");
            } else {
                sb.append(this.f664e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f659a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f661b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f654a);
        }
        sb.append(")");
        return sb.toString();
    }
}
