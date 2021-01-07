package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f527a;

    /* renamed from: a  reason: collision with other field name */
    public String f528a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f529a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f530a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f531a;

    /* renamed from: b  reason: collision with other field name */
    public long f532b;

    /* renamed from: b  reason: collision with other field name */
    public String f533b;

    /* renamed from: c  reason: collision with other field name */
    public String f534c;

    /* renamed from: d  reason: collision with other field name */
    public String f535d;

    /* renamed from: e  reason: collision with other field name */
    public String f536e;

    /* renamed from: f  reason: collision with other field name */
    public String f537f;

    /* renamed from: g  reason: collision with other field name */
    public String f538g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f526a = new jn("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14398a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14399b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", (byte) 10, 4);
    private static final jf e = new jf("", (byte) 10, 5);
    private static final jf f = new jf("", (byte) 2, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", (byte) 13, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
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
        int a12;
        if (getClass().equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(m379a()).compareTo(Boolean.valueOf(hqVar.m379a()));
            if (compareTo == 0) {
                if (!m379a() || (a12 = iy.a(this.f528a, hqVar.f528a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m381b()).compareTo(Boolean.valueOf(hqVar.m381b()));
                    if (compareTo2 == 0) {
                        if (!m381b() || (a11 = iy.a(this.f533b, hqVar.f533b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m382c()).compareTo(Boolean.valueOf(hqVar.m382c()));
                            if (compareTo3 == 0) {
                                if (!m382c() || (a10 = iy.a(this.f534c, hqVar.f534c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m383d()).compareTo(Boolean.valueOf(hqVar.m383d()));
                                    if (compareTo4 == 0) {
                                        if (!m383d() || (a9 = iy.a(this.f527a, hqVar.f527a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m384e()).compareTo(Boolean.valueOf(hqVar.m384e()));
                                            if (compareTo5 == 0) {
                                                if (!m384e() || (a8 = iy.a(this.f532b, hqVar.f532b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f531a, hqVar.f531a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f535d, hqVar.f535d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f536e, hqVar.f536e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f537f, hqVar.f537f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f530a, hqVar.f530a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f538g, hqVar.f538g)) == 0) {
                                                                                                    return 0;
                                                                                                }
                                                                                                return a2;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a3;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a4;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a5;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a6;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a7;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a8;
                                            }
                                            return compareTo5;
                                        }
                                        return a9;
                                    }
                                    return compareTo4;
                                }
                                return a10;
                            }
                            return compareTo3;
                        }
                        return a11;
                    }
                    return compareTo2;
                }
                return a12;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hqVar.getClass().getName());
    }

    public long a() {
        return this.f532b;
    }

    public hq a(long j2) {
        this.f527a = j2;
        m378a(true);
        return this;
    }

    public hq a(String str) {
        this.f528a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f531a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m376a() {
        return this.f528a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m377a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m377a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f528a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 11) {
                        this.f533b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f534c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 10) {
                        this.f527a = jiVar.m514a();
                        m378a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 10) {
                        this.f532b = jiVar.m514a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 2) {
                        this.f531a = jiVar.m524a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f535d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 11) {
                        this.f536e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f537f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f530a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f530a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 11) {
                        this.f538g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m378a(boolean z) {
        this.f529a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m379a() {
        return this.f528a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m379a = m379a();
        boolean m379a2 = hqVar.m379a();
        if ((m379a || m379a2) && !(m379a && m379a2 && this.f528a.equals(hqVar.f528a))) {
            return false;
        }
        boolean m381b = m381b();
        boolean m381b2 = hqVar.m381b();
        if ((m381b || m381b2) && !(m381b && m381b2 && this.f533b.equals(hqVar.f533b))) {
            return false;
        }
        boolean m382c = m382c();
        boolean m382c2 = hqVar.m382c();
        if ((m382c || m382c2) && !(m382c && m382c2 && this.f534c.equals(hqVar.f534c))) {
            return false;
        }
        boolean m383d = m383d();
        boolean m383d2 = hqVar.m383d();
        if ((m383d || m383d2) && !(m383d && m383d2 && this.f527a == hqVar.f527a)) {
            return false;
        }
        boolean m384e = m384e();
        boolean m384e2 = hqVar.m384e();
        if ((m384e || m384e2) && !(m384e && m384e2 && this.f532b == hqVar.f532b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f531a == hqVar.f531a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f535d.equals(hqVar.f535d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f536e.equals(hqVar.f536e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f537f.equals(hqVar.f537f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f530a.equals(hqVar.f530a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f538g.equals(hqVar.f538g));
    }

    public hq b(long j2) {
        this.f532b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f533b = str;
        return this;
    }

    public String b() {
        return this.f534c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m377a();
        jiVar.a(f526a);
        if (this.f528a != null && m379a()) {
            jiVar.a(f14398a);
            jiVar.a(this.f528a);
            jiVar.b();
        }
        if (this.f533b != null && m381b()) {
            jiVar.a(f14399b);
            jiVar.a(this.f533b);
            jiVar.b();
        }
        if (this.f534c != null && m382c()) {
            jiVar.a(c);
            jiVar.a(this.f534c);
            jiVar.b();
        }
        if (m383d()) {
            jiVar.a(d);
            jiVar.a(this.f527a);
            jiVar.b();
        }
        if (m384e()) {
            jiVar.a(e);
            jiVar.a(this.f532b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f531a);
            jiVar.b();
        }
        if (this.f535d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f535d);
            jiVar.b();
        }
        if (this.f536e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f536e);
            jiVar.b();
        }
        if (this.f537f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f537f);
            jiVar.b();
        }
        if (this.f530a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f530a.size()));
            for (Map.Entry<String, String> entry : this.f530a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f538g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f538g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f529a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m381b() {
        return this.f533b != null;
    }

    public hq c(String str) {
        this.f534c = str;
        return this;
    }

    public String c() {
        return this.f536e;
    }

    public void c(boolean z) {
        this.f529a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m382c() {
        return this.f534c != null;
    }

    public hq d(String str) {
        this.f535d = str;
        return this;
    }

    public String d() {
        return this.f537f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m383d() {
        return this.f529a.get(0);
    }

    public hq e(String str) {
        this.f536e = str;
        return this;
    }

    public String e() {
        return this.f538g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m384e() {
        return this.f529a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m380a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f537f = str;
        return this;
    }

    public boolean f() {
        return this.f529a.get(2);
    }

    public hq g(String str) {
        this.f538g = str;
        return this;
    }

    public boolean g() {
        return this.f535d != null;
    }

    public boolean h() {
        return this.f536e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f537f != null;
    }

    public boolean j() {
        return this.f530a != null;
    }

    public boolean k() {
        return this.f538g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m379a()) {
            sb.append("channel:");
            if (this.f528a == null) {
                sb.append("null");
            } else {
                sb.append(this.f528a);
            }
            z2 = false;
        }
        if (m381b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f533b == null) {
                sb.append("null");
            } else {
                sb.append(this.f533b);
            }
            z2 = false;
        }
        if (m382c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f534c == null) {
                sb.append("null");
            } else {
                sb.append(this.f534c);
            }
            z2 = false;
        }
        if (m383d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f527a);
            z2 = false;
        }
        if (m384e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f532b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f531a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f535d == null) {
                sb.append("null");
            } else {
                sb.append(this.f535d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f536e == null) {
                sb.append("null");
            } else {
                sb.append(this.f536e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f537f == null) {
                sb.append("null");
            } else {
                sb.append(this.f537f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f530a == null) {
                sb.append("null");
            } else {
                sb.append(this.f530a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f538g == null) {
                sb.append("null");
            } else {
                sb.append(this.f538g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
