package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f452a;

    /* renamed from: a  reason: collision with other field name */
    public String f453a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f454a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f455a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f456a;

    /* renamed from: b  reason: collision with other field name */
    public long f457b;

    /* renamed from: b  reason: collision with other field name */
    public String f458b;

    /* renamed from: c  reason: collision with other field name */
    public String f459c;

    /* renamed from: d  reason: collision with other field name */
    public String f460d;

    /* renamed from: e  reason: collision with other field name */
    public String f461e;

    /* renamed from: f  reason: collision with other field name */
    public String f462f;

    /* renamed from: g  reason: collision with other field name */
    public String f463g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f451a = new jn("ClientUploadDataItem");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
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
            int compareTo = Boolean.valueOf(m344a()).compareTo(Boolean.valueOf(hqVar.m344a()));
            if (compareTo == 0) {
                if (!m344a() || (a12 = iy.a(this.f453a, hqVar.f453a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m346b()).compareTo(Boolean.valueOf(hqVar.m346b()));
                    if (compareTo2 == 0) {
                        if (!m346b() || (a11 = iy.a(this.f458b, hqVar.f458b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m347c()).compareTo(Boolean.valueOf(hqVar.m347c()));
                            if (compareTo3 == 0) {
                                if (!m347c() || (a10 = iy.a(this.f459c, hqVar.f459c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m348d()).compareTo(Boolean.valueOf(hqVar.m348d()));
                                    if (compareTo4 == 0) {
                                        if (!m348d() || (a9 = iy.a(this.f452a, hqVar.f452a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m349e()).compareTo(Boolean.valueOf(hqVar.m349e()));
                                            if (compareTo5 == 0) {
                                                if (!m349e() || (a8 = iy.a(this.f457b, hqVar.f457b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f456a, hqVar.f456a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f460d, hqVar.f460d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f461e, hqVar.f461e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f462f, hqVar.f462f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f455a, hqVar.f455a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f463g, hqVar.f463g)) == 0) {
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
        return this.f457b;
    }

    public hq a(long j2) {
        this.f452a = j2;
        m343a(true);
        return this;
    }

    public hq a(String str) {
        this.f453a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f456a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m341a() {
        return this.f453a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m342a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m342a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a == 11) {
                        this.f453a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 2:
                    if (m480a.a == 11) {
                        this.f458b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 11) {
                        this.f459c = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 4:
                    if (m480a.a == 10) {
                        this.f452a = jiVar.m479a();
                        m343a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 5:
                    if (m480a.a == 10) {
                        this.f457b = jiVar.m479a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 6:
                    if (m480a.a == 2) {
                        this.f456a = jiVar.m489a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 7:
                    if (m480a.a == 11) {
                        this.f460d = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 8:
                    if (m480a.a == 11) {
                        this.f461e = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 9:
                    if (m480a.a == 11) {
                        this.f462f = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 10:
                    if (m480a.a == 13) {
                        jh m482a = jiVar.m482a();
                        this.f455a = new HashMap(m482a.f785a * 2);
                        for (int i2 = 0; i2 < m482a.f785a; i2++) {
                            this.f455a.put(jiVar.m485a(), jiVar.m485a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 11:
                    if (m480a.a == 11) {
                        this.f463g = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m343a(boolean z) {
        this.f454a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a() {
        return this.f453a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m345a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m344a = m344a();
        boolean m344a2 = hqVar.m344a();
        if ((m344a || m344a2) && !(m344a && m344a2 && this.f453a.equals(hqVar.f453a))) {
            return false;
        }
        boolean m346b = m346b();
        boolean m346b2 = hqVar.m346b();
        if ((m346b || m346b2) && !(m346b && m346b2 && this.f458b.equals(hqVar.f458b))) {
            return false;
        }
        boolean m347c = m347c();
        boolean m347c2 = hqVar.m347c();
        if ((m347c || m347c2) && !(m347c && m347c2 && this.f459c.equals(hqVar.f459c))) {
            return false;
        }
        boolean m348d = m348d();
        boolean m348d2 = hqVar.m348d();
        if ((m348d || m348d2) && !(m348d && m348d2 && this.f452a == hqVar.f452a)) {
            return false;
        }
        boolean m349e = m349e();
        boolean m349e2 = hqVar.m349e();
        if ((m349e || m349e2) && !(m349e && m349e2 && this.f457b == hqVar.f457b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f456a == hqVar.f456a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f460d.equals(hqVar.f460d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f461e.equals(hqVar.f461e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f462f.equals(hqVar.f462f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f455a.equals(hqVar.f455a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f463g.equals(hqVar.f463g));
    }

    public hq b(long j2) {
        this.f457b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f458b = str;
        return this;
    }

    public String b() {
        return this.f459c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m342a();
        jiVar.a(f451a);
        if (this.f453a != null && m344a()) {
            jiVar.a(a);
            jiVar.a(this.f453a);
            jiVar.b();
        }
        if (this.f458b != null && m346b()) {
            jiVar.a(b);
            jiVar.a(this.f458b);
            jiVar.b();
        }
        if (this.f459c != null && m347c()) {
            jiVar.a(c);
            jiVar.a(this.f459c);
            jiVar.b();
        }
        if (m348d()) {
            jiVar.a(d);
            jiVar.a(this.f452a);
            jiVar.b();
        }
        if (m349e()) {
            jiVar.a(e);
            jiVar.a(this.f457b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f456a);
            jiVar.b();
        }
        if (this.f460d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f460d);
            jiVar.b();
        }
        if (this.f461e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f461e);
            jiVar.b();
        }
        if (this.f462f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f462f);
            jiVar.b();
        }
        if (this.f455a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f455a.size()));
            for (Map.Entry<String, String> entry : this.f455a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f463g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f463g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f454a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m346b() {
        return this.f458b != null;
    }

    public hq c(String str) {
        this.f459c = str;
        return this;
    }

    public String c() {
        return this.f461e;
    }

    public void c(boolean z) {
        this.f454a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m347c() {
        return this.f459c != null;
    }

    public hq d(String str) {
        this.f460d = str;
        return this;
    }

    public String d() {
        return this.f462f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m348d() {
        return this.f454a.get(0);
    }

    public hq e(String str) {
        this.f461e = str;
        return this;
    }

    public String e() {
        return this.f463g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m349e() {
        return this.f454a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m345a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f462f = str;
        return this;
    }

    public boolean f() {
        return this.f454a.get(2);
    }

    public hq g(String str) {
        this.f463g = str;
        return this;
    }

    public boolean g() {
        return this.f460d != null;
    }

    public boolean h() {
        return this.f461e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f462f != null;
    }

    public boolean j() {
        return this.f455a != null;
    }

    public boolean k() {
        return this.f463g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m344a()) {
            sb.append("channel:");
            if (this.f453a == null) {
                sb.append("null");
            } else {
                sb.append(this.f453a);
            }
            z2 = false;
        }
        if (m346b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f458b == null) {
                sb.append("null");
            } else {
                sb.append(this.f458b);
            }
            z2 = false;
        }
        if (m347c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f459c == null) {
                sb.append("null");
            } else {
                sb.append(this.f459c);
            }
            z2 = false;
        }
        if (m348d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f452a);
            z2 = false;
        }
        if (m349e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f457b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f456a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f460d == null) {
                sb.append("null");
            } else {
                sb.append(this.f460d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f461e == null) {
                sb.append("null");
            } else {
                sb.append(this.f461e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f462f == null) {
                sb.append("null");
            } else {
                sb.append(this.f462f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f455a == null) {
                sb.append("null");
            } else {
                sb.append(this.f455a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f463g == null) {
                sb.append("null");
            } else {
                sb.append(this.f463g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
