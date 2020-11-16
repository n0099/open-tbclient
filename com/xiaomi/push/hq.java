package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f450a;

    /* renamed from: a  reason: collision with other field name */
    public String f451a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f452a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f453a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f454a;

    /* renamed from: b  reason: collision with other field name */
    public long f455b;

    /* renamed from: b  reason: collision with other field name */
    public String f456b;

    /* renamed from: c  reason: collision with other field name */
    public String f457c;

    /* renamed from: d  reason: collision with other field name */
    public String f458d;

    /* renamed from: e  reason: collision with other field name */
    public String f459e;

    /* renamed from: f  reason: collision with other field name */
    public String f460f;

    /* renamed from: g  reason: collision with other field name */
    public String f461g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f449a = new jn("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4959a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m352a()).compareTo(Boolean.valueOf(hqVar.m352a()));
            if (compareTo == 0) {
                if (!m352a() || (a12 = iy.a(this.f451a, hqVar.f451a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m354b()).compareTo(Boolean.valueOf(hqVar.m354b()));
                    if (compareTo2 == 0) {
                        if (!m354b() || (a11 = iy.a(this.f456b, hqVar.f456b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m355c()).compareTo(Boolean.valueOf(hqVar.m355c()));
                            if (compareTo3 == 0) {
                                if (!m355c() || (a10 = iy.a(this.f457c, hqVar.f457c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m356d()).compareTo(Boolean.valueOf(hqVar.m356d()));
                                    if (compareTo4 == 0) {
                                        if (!m356d() || (a9 = iy.a(this.f450a, hqVar.f450a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m357e()).compareTo(Boolean.valueOf(hqVar.m357e()));
                                            if (compareTo5 == 0) {
                                                if (!m357e() || (a8 = iy.a(this.f455b, hqVar.f455b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f454a, hqVar.f454a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f458d, hqVar.f458d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f459e, hqVar.f459e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f460f, hqVar.f460f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f453a, hqVar.f453a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f461g, hqVar.f461g)) == 0) {
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
        return this.f455b;
    }

    public hq a(long j2) {
        this.f450a = j2;
        m351a(true);
        return this;
    }

    public hq a(String str) {
        this.f451a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f454a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m349a() {
        return this.f451a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m350a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m350a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f451a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 11) {
                        this.f456b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f457c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 10) {
                        this.f450a = jiVar.m487a();
                        m351a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 10) {
                        this.f455b = jiVar.m487a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 2) {
                        this.f454a = jiVar.m497a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f458d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 11) {
                        this.f459e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 11) {
                        this.f460f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f453a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f453a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 11) {
                        this.f461g = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m351a(boolean z) {
        this.f452a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m352a() {
        return this.f451a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m353a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m352a = m352a();
        boolean m352a2 = hqVar.m352a();
        if ((m352a || m352a2) && !(m352a && m352a2 && this.f451a.equals(hqVar.f451a))) {
            return false;
        }
        boolean m354b = m354b();
        boolean m354b2 = hqVar.m354b();
        if ((m354b || m354b2) && !(m354b && m354b2 && this.f456b.equals(hqVar.f456b))) {
            return false;
        }
        boolean m355c = m355c();
        boolean m355c2 = hqVar.m355c();
        if ((m355c || m355c2) && !(m355c && m355c2 && this.f457c.equals(hqVar.f457c))) {
            return false;
        }
        boolean m356d = m356d();
        boolean m356d2 = hqVar.m356d();
        if ((m356d || m356d2) && !(m356d && m356d2 && this.f450a == hqVar.f450a)) {
            return false;
        }
        boolean m357e = m357e();
        boolean m357e2 = hqVar.m357e();
        if ((m357e || m357e2) && !(m357e && m357e2 && this.f455b == hqVar.f455b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f454a == hqVar.f454a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f458d.equals(hqVar.f458d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f459e.equals(hqVar.f459e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f460f.equals(hqVar.f460f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f453a.equals(hqVar.f453a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f461g.equals(hqVar.f461g));
    }

    public hq b(long j2) {
        this.f455b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f456b = str;
        return this;
    }

    public String b() {
        return this.f457c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m350a();
        jiVar.a(f449a);
        if (this.f451a != null && m352a()) {
            jiVar.a(f4959a);
            jiVar.a(this.f451a);
            jiVar.b();
        }
        if (this.f456b != null && m354b()) {
            jiVar.a(b);
            jiVar.a(this.f456b);
            jiVar.b();
        }
        if (this.f457c != null && m355c()) {
            jiVar.a(c);
            jiVar.a(this.f457c);
            jiVar.b();
        }
        if (m356d()) {
            jiVar.a(d);
            jiVar.a(this.f450a);
            jiVar.b();
        }
        if (m357e()) {
            jiVar.a(e);
            jiVar.a(this.f455b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f454a);
            jiVar.b();
        }
        if (this.f458d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f458d);
            jiVar.b();
        }
        if (this.f459e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f459e);
            jiVar.b();
        }
        if (this.f460f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f460f);
            jiVar.b();
        }
        if (this.f453a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f453a.size()));
            for (Map.Entry<String, String> entry : this.f453a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f461g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f461g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f452a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m354b() {
        return this.f456b != null;
    }

    public hq c(String str) {
        this.f457c = str;
        return this;
    }

    public String c() {
        return this.f459e;
    }

    public void c(boolean z) {
        this.f452a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m355c() {
        return this.f457c != null;
    }

    public hq d(String str) {
        this.f458d = str;
        return this;
    }

    public String d() {
        return this.f460f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m356d() {
        return this.f452a.get(0);
    }

    public hq e(String str) {
        this.f459e = str;
        return this;
    }

    public String e() {
        return this.f461g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m357e() {
        return this.f452a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m353a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f460f = str;
        return this;
    }

    public boolean f() {
        return this.f452a.get(2);
    }

    public hq g(String str) {
        this.f461g = str;
        return this;
    }

    public boolean g() {
        return this.f458d != null;
    }

    public boolean h() {
        return this.f459e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f460f != null;
    }

    public boolean j() {
        return this.f453a != null;
    }

    public boolean k() {
        return this.f461g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m352a()) {
            sb.append("channel:");
            if (this.f451a == null) {
                sb.append("null");
            } else {
                sb.append(this.f451a);
            }
            z2 = false;
        }
        if (m354b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f456b == null) {
                sb.append("null");
            } else {
                sb.append(this.f456b);
            }
            z2 = false;
        }
        if (m355c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f457c == null) {
                sb.append("null");
            } else {
                sb.append(this.f457c);
            }
            z2 = false;
        }
        if (m356d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f450a);
            z2 = false;
        }
        if (m357e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f455b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f454a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f458d == null) {
                sb.append("null");
            } else {
                sb.append(this.f458d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f459e == null) {
                sb.append("null");
            } else {
                sb.append(this.f459e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f460f == null) {
                sb.append("null");
            } else {
                sb.append(this.f460f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f453a == null) {
                sb.append("null");
            } else {
                sb.append(this.f453a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f461g == null) {
                sb.append("null");
            } else {
                sb.append(this.f461g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
