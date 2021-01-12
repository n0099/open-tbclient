package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f526a;

    /* renamed from: a  reason: collision with other field name */
    public String f527a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f528a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f529a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f530a;

    /* renamed from: b  reason: collision with other field name */
    public long f531b;

    /* renamed from: b  reason: collision with other field name */
    public String f532b;

    /* renamed from: c  reason: collision with other field name */
    public String f533c;

    /* renamed from: d  reason: collision with other field name */
    public String f534d;

    /* renamed from: e  reason: collision with other field name */
    public String f535e;

    /* renamed from: f  reason: collision with other field name */
    public String f536f;

    /* renamed from: g  reason: collision with other field name */
    public String f537g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f525a = new jn("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14098a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14099b = new jf("", Constants.GZIP_CAST_TYPE, 2);
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
            int compareTo = Boolean.valueOf(m375a()).compareTo(Boolean.valueOf(hqVar.m375a()));
            if (compareTo == 0) {
                if (!m375a() || (a12 = iy.a(this.f527a, hqVar.f527a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m377b()).compareTo(Boolean.valueOf(hqVar.m377b()));
                    if (compareTo2 == 0) {
                        if (!m377b() || (a11 = iy.a(this.f532b, hqVar.f532b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m378c()).compareTo(Boolean.valueOf(hqVar.m378c()));
                            if (compareTo3 == 0) {
                                if (!m378c() || (a10 = iy.a(this.f533c, hqVar.f533c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m379d()).compareTo(Boolean.valueOf(hqVar.m379d()));
                                    if (compareTo4 == 0) {
                                        if (!m379d() || (a9 = iy.a(this.f526a, hqVar.f526a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m380e()).compareTo(Boolean.valueOf(hqVar.m380e()));
                                            if (compareTo5 == 0) {
                                                if (!m380e() || (a8 = iy.a(this.f531b, hqVar.f531b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f530a, hqVar.f530a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f534d, hqVar.f534d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f535e, hqVar.f535e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f536f, hqVar.f536f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f529a, hqVar.f529a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f537g, hqVar.f537g)) == 0) {
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
        return this.f531b;
    }

    public hq a(long j2) {
        this.f526a = j2;
        m374a(true);
        return this;
    }

    public hq a(String str) {
        this.f527a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f530a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m372a() {
        return this.f527a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m373a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                m373a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a == 11) {
                        this.f527a = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 2:
                    if (m511a.f14171a == 11) {
                        this.f532b = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 3:
                    if (m511a.f14171a == 11) {
                        this.f533c = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 4:
                    if (m511a.f14171a == 10) {
                        this.f526a = jiVar.m510a();
                        m374a(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 5:
                    if (m511a.f14171a == 10) {
                        this.f531b = jiVar.m510a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 6:
                    if (m511a.f14171a == 2) {
                        this.f530a = jiVar.m520a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 7:
                    if (m511a.f14171a == 11) {
                        this.f534d = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 8:
                    if (m511a.f14171a == 11) {
                        this.f535e = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 9:
                    if (m511a.f14171a == 11) {
                        this.f536f = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 10:
                    if (m511a.f14171a == 13) {
                        jh m513a = jiVar.m513a();
                        this.f529a = new HashMap(m513a.f859a * 2);
                        for (int i2 = 0; i2 < m513a.f859a; i2++) {
                            this.f529a.put(jiVar.m516a(), jiVar.m516a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 11:
                    if (m511a.f14171a == 11) {
                        this.f537g = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m374a(boolean z) {
        this.f528a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a() {
        return this.f527a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m376a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m375a = m375a();
        boolean m375a2 = hqVar.m375a();
        if ((m375a || m375a2) && !(m375a && m375a2 && this.f527a.equals(hqVar.f527a))) {
            return false;
        }
        boolean m377b = m377b();
        boolean m377b2 = hqVar.m377b();
        if ((m377b || m377b2) && !(m377b && m377b2 && this.f532b.equals(hqVar.f532b))) {
            return false;
        }
        boolean m378c = m378c();
        boolean m378c2 = hqVar.m378c();
        if ((m378c || m378c2) && !(m378c && m378c2 && this.f533c.equals(hqVar.f533c))) {
            return false;
        }
        boolean m379d = m379d();
        boolean m379d2 = hqVar.m379d();
        if ((m379d || m379d2) && !(m379d && m379d2 && this.f526a == hqVar.f526a)) {
            return false;
        }
        boolean m380e = m380e();
        boolean m380e2 = hqVar.m380e();
        if ((m380e || m380e2) && !(m380e && m380e2 && this.f531b == hqVar.f531b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f530a == hqVar.f530a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f534d.equals(hqVar.f534d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f535e.equals(hqVar.f535e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f536f.equals(hqVar.f536f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f529a.equals(hqVar.f529a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f537g.equals(hqVar.f537g));
    }

    public hq b(long j2) {
        this.f531b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f532b = str;
        return this;
    }

    public String b() {
        return this.f533c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m373a();
        jiVar.a(f525a);
        if (this.f527a != null && m375a()) {
            jiVar.a(f14098a);
            jiVar.a(this.f527a);
            jiVar.b();
        }
        if (this.f532b != null && m377b()) {
            jiVar.a(f14099b);
            jiVar.a(this.f532b);
            jiVar.b();
        }
        if (this.f533c != null && m378c()) {
            jiVar.a(c);
            jiVar.a(this.f533c);
            jiVar.b();
        }
        if (m379d()) {
            jiVar.a(d);
            jiVar.a(this.f526a);
            jiVar.b();
        }
        if (m380e()) {
            jiVar.a(e);
            jiVar.a(this.f531b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f530a);
            jiVar.b();
        }
        if (this.f534d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f534d);
            jiVar.b();
        }
        if (this.f535e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f535e);
            jiVar.b();
        }
        if (this.f536f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f536f);
            jiVar.b();
        }
        if (this.f529a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f529a.size()));
            for (Map.Entry<String, String> entry : this.f529a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f537g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f537g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f528a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m377b() {
        return this.f532b != null;
    }

    public hq c(String str) {
        this.f533c = str;
        return this;
    }

    public String c() {
        return this.f535e;
    }

    public void c(boolean z) {
        this.f528a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m378c() {
        return this.f533c != null;
    }

    public hq d(String str) {
        this.f534d = str;
        return this;
    }

    public String d() {
        return this.f536f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m379d() {
        return this.f528a.get(0);
    }

    public hq e(String str) {
        this.f535e = str;
        return this;
    }

    public String e() {
        return this.f537g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m380e() {
        return this.f528a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m376a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f536f = str;
        return this;
    }

    public boolean f() {
        return this.f528a.get(2);
    }

    public hq g(String str) {
        this.f537g = str;
        return this;
    }

    public boolean g() {
        return this.f534d != null;
    }

    public boolean h() {
        return this.f535e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f536f != null;
    }

    public boolean j() {
        return this.f529a != null;
    }

    public boolean k() {
        return this.f537g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m375a()) {
            sb.append("channel:");
            if (this.f527a == null) {
                sb.append("null");
            } else {
                sb.append(this.f527a);
            }
            z2 = false;
        }
        if (m377b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f532b == null) {
                sb.append("null");
            } else {
                sb.append(this.f532b);
            }
            z2 = false;
        }
        if (m378c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f533c == null) {
                sb.append("null");
            } else {
                sb.append(this.f533c);
            }
            z2 = false;
        }
        if (m379d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f526a);
            z2 = false;
        }
        if (m380e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f531b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f530a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f534d == null) {
                sb.append("null");
            } else {
                sb.append(this.f534d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f535e == null) {
                sb.append("null");
            } else {
                sb.append(this.f535e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f536f == null) {
                sb.append("null");
            } else {
                sb.append(this.f536f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f529a == null) {
                sb.append("null");
            } else {
                sb.append(this.f529a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f537g == null) {
                sb.append("null");
            } else {
                sb.append(this.f537g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
