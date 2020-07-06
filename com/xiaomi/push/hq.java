package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f453a;

    /* renamed from: a  reason: collision with other field name */
    public String f454a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f455a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f456a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f457a;

    /* renamed from: b  reason: collision with other field name */
    public long f458b;

    /* renamed from: b  reason: collision with other field name */
    public String f459b;

    /* renamed from: c  reason: collision with other field name */
    public String f460c;

    /* renamed from: d  reason: collision with other field name */
    public String f461d;

    /* renamed from: e  reason: collision with other field name */
    public String f462e;

    /* renamed from: f  reason: collision with other field name */
    public String f463f;

    /* renamed from: g  reason: collision with other field name */
    public String f464g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f452a = new jn("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m343a()).compareTo(Boolean.valueOf(hqVar.m343a()));
            if (compareTo == 0) {
                if (!m343a() || (a12 = iy.a(this.f454a, hqVar.f454a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m345b()).compareTo(Boolean.valueOf(hqVar.m345b()));
                    if (compareTo2 == 0) {
                        if (!m345b() || (a11 = iy.a(this.f459b, hqVar.f459b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m346c()).compareTo(Boolean.valueOf(hqVar.m346c()));
                            if (compareTo3 == 0) {
                                if (!m346c() || (a10 = iy.a(this.f460c, hqVar.f460c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m347d()).compareTo(Boolean.valueOf(hqVar.m347d()));
                                    if (compareTo4 == 0) {
                                        if (!m347d() || (a9 = iy.a(this.f453a, hqVar.f453a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m348e()).compareTo(Boolean.valueOf(hqVar.m348e()));
                                            if (compareTo5 == 0) {
                                                if (!m348e() || (a8 = iy.a(this.f458b, hqVar.f458b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f457a, hqVar.f457a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f461d, hqVar.f461d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f462e, hqVar.f462e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f463f, hqVar.f463f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f456a, hqVar.f456a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f464g, hqVar.f464g)) == 0) {
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
        return this.f458b;
    }

    public hq a(long j2) {
        this.f453a = j2;
        m342a(true);
        return this;
    }

    public hq a(String str) {
        this.f454a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f457a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m340a() {
        return this.f454a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m341a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m341a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f454a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 11) {
                        this.f459b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f460c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 10) {
                        this.f453a = jiVar.m478a();
                        m342a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 10) {
                        this.f458b = jiVar.m478a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 2) {
                        this.f457a = jiVar.m488a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f461d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 11) {
                        this.f462e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 11) {
                        this.f463f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f456a = new HashMap(m481a.f786a * 2);
                        for (int i2 = 0; i2 < m481a.f786a; i2++) {
                            this.f456a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 11) {
                        this.f464g = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m342a(boolean z) {
        this.f455a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m343a() {
        return this.f454a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m343a = m343a();
        boolean m343a2 = hqVar.m343a();
        if ((m343a || m343a2) && !(m343a && m343a2 && this.f454a.equals(hqVar.f454a))) {
            return false;
        }
        boolean m345b = m345b();
        boolean m345b2 = hqVar.m345b();
        if ((m345b || m345b2) && !(m345b && m345b2 && this.f459b.equals(hqVar.f459b))) {
            return false;
        }
        boolean m346c = m346c();
        boolean m346c2 = hqVar.m346c();
        if ((m346c || m346c2) && !(m346c && m346c2 && this.f460c.equals(hqVar.f460c))) {
            return false;
        }
        boolean m347d = m347d();
        boolean m347d2 = hqVar.m347d();
        if ((m347d || m347d2) && !(m347d && m347d2 && this.f453a == hqVar.f453a)) {
            return false;
        }
        boolean m348e = m348e();
        boolean m348e2 = hqVar.m348e();
        if ((m348e || m348e2) && !(m348e && m348e2 && this.f458b == hqVar.f458b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f457a == hqVar.f457a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f461d.equals(hqVar.f461d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f462e.equals(hqVar.f462e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f463f.equals(hqVar.f463f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f456a.equals(hqVar.f456a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f464g.equals(hqVar.f464g));
    }

    public hq b(long j2) {
        this.f458b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f459b = str;
        return this;
    }

    public String b() {
        return this.f460c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m341a();
        jiVar.a(f452a);
        if (this.f454a != null && m343a()) {
            jiVar.a(a);
            jiVar.a(this.f454a);
            jiVar.b();
        }
        if (this.f459b != null && m345b()) {
            jiVar.a(b);
            jiVar.a(this.f459b);
            jiVar.b();
        }
        if (this.f460c != null && m346c()) {
            jiVar.a(c);
            jiVar.a(this.f460c);
            jiVar.b();
        }
        if (m347d()) {
            jiVar.a(d);
            jiVar.a(this.f453a);
            jiVar.b();
        }
        if (m348e()) {
            jiVar.a(e);
            jiVar.a(this.f458b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f457a);
            jiVar.b();
        }
        if (this.f461d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f461d);
            jiVar.b();
        }
        if (this.f462e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f462e);
            jiVar.b();
        }
        if (this.f463f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f463f);
            jiVar.b();
        }
        if (this.f456a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f456a.size()));
            for (Map.Entry<String, String> entry : this.f456a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f464g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f464g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f455a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m345b() {
        return this.f459b != null;
    }

    public hq c(String str) {
        this.f460c = str;
        return this;
    }

    public String c() {
        return this.f462e;
    }

    public void c(boolean z) {
        this.f455a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m346c() {
        return this.f460c != null;
    }

    public hq d(String str) {
        this.f461d = str;
        return this;
    }

    public String d() {
        return this.f463f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m347d() {
        return this.f455a.get(0);
    }

    public hq e(String str) {
        this.f462e = str;
        return this;
    }

    public String e() {
        return this.f464g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m348e() {
        return this.f455a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m344a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f463f = str;
        return this;
    }

    public boolean f() {
        return this.f455a.get(2);
    }

    public hq g(String str) {
        this.f464g = str;
        return this;
    }

    public boolean g() {
        return this.f461d != null;
    }

    public boolean h() {
        return this.f462e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f463f != null;
    }

    public boolean j() {
        return this.f456a != null;
    }

    public boolean k() {
        return this.f464g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m343a()) {
            sb.append("channel:");
            if (this.f454a == null) {
                sb.append("null");
            } else {
                sb.append(this.f454a);
            }
            z2 = false;
        }
        if (m345b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f459b == null) {
                sb.append("null");
            } else {
                sb.append(this.f459b);
            }
            z2 = false;
        }
        if (m346c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f460c == null) {
                sb.append("null");
            } else {
                sb.append(this.f460c);
            }
            z2 = false;
        }
        if (m347d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f453a);
            z2 = false;
        }
        if (m348e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f458b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f457a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f461d == null) {
                sb.append("null");
            } else {
                sb.append(this.f461d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f462e == null) {
                sb.append("null");
            } else {
                sb.append(this.f462e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f463f == null) {
                sb.append("null");
            } else {
                sb.append(this.f463f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f456a == null) {
                sb.append("null");
            } else {
                sb.append(this.f456a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f464g == null) {
                sb.append("null");
            } else {
                sb.append(this.f464g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
