package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f447a;

    /* renamed from: a  reason: collision with other field name */
    public String f448a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f449a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f450a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f451a;

    /* renamed from: b  reason: collision with other field name */
    public long f452b;

    /* renamed from: b  reason: collision with other field name */
    public String f453b;

    /* renamed from: c  reason: collision with other field name */
    public String f454c;

    /* renamed from: d  reason: collision with other field name */
    public String f455d;

    /* renamed from: e  reason: collision with other field name */
    public String f456e;

    /* renamed from: f  reason: collision with other field name */
    public String f457f;

    /* renamed from: g  reason: collision with other field name */
    public String f458g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f446a = new jn("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m349a()).compareTo(Boolean.valueOf(hqVar.m349a()));
            if (compareTo == 0) {
                if (!m349a() || (a12 = iy.a(this.f448a, hqVar.f448a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m351b()).compareTo(Boolean.valueOf(hqVar.m351b()));
                    if (compareTo2 == 0) {
                        if (!m351b() || (a11 = iy.a(this.f453b, hqVar.f453b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m352c()).compareTo(Boolean.valueOf(hqVar.m352c()));
                            if (compareTo3 == 0) {
                                if (!m352c() || (a10 = iy.a(this.f454c, hqVar.f454c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m353d()).compareTo(Boolean.valueOf(hqVar.m353d()));
                                    if (compareTo4 == 0) {
                                        if (!m353d() || (a9 = iy.a(this.f447a, hqVar.f447a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m354e()).compareTo(Boolean.valueOf(hqVar.m354e()));
                                            if (compareTo5 == 0) {
                                                if (!m354e() || (a8 = iy.a(this.f452b, hqVar.f452b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f451a, hqVar.f451a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f455d, hqVar.f455d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f456e, hqVar.f456e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f457f, hqVar.f457f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f450a, hqVar.f450a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f458g, hqVar.f458g)) == 0) {
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
        return this.f452b;
    }

    public hq a(long j2) {
        this.f447a = j2;
        m348a(true);
        return this;
    }

    public hq a(String str) {
        this.f448a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f451a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m346a() {
        return this.f448a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m347a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                m347a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.a == 11) {
                        this.f448a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 2:
                    if (m485a.a == 11) {
                        this.f453b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 3:
                    if (m485a.a == 11) {
                        this.f454c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 4:
                    if (m485a.a == 10) {
                        this.f447a = jiVar.m484a();
                        m348a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 5:
                    if (m485a.a == 10) {
                        this.f452b = jiVar.m484a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 6:
                    if (m485a.a == 2) {
                        this.f451a = jiVar.m494a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 7:
                    if (m485a.a == 11) {
                        this.f455d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 8:
                    if (m485a.a == 11) {
                        this.f456e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 9:
                    if (m485a.a == 11) {
                        this.f457f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 10:
                    if (m485a.a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f450a = new HashMap(m487a.f780a * 2);
                        for (int i2 = 0; i2 < m487a.f780a; i2++) {
                            this.f450a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 11:
                    if (m485a.a == 11) {
                        this.f458g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a(boolean z) {
        this.f449a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a() {
        return this.f448a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m350a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m349a = m349a();
        boolean m349a2 = hqVar.m349a();
        if ((m349a || m349a2) && !(m349a && m349a2 && this.f448a.equals(hqVar.f448a))) {
            return false;
        }
        boolean m351b = m351b();
        boolean m351b2 = hqVar.m351b();
        if ((m351b || m351b2) && !(m351b && m351b2 && this.f453b.equals(hqVar.f453b))) {
            return false;
        }
        boolean m352c = m352c();
        boolean m352c2 = hqVar.m352c();
        if ((m352c || m352c2) && !(m352c && m352c2 && this.f454c.equals(hqVar.f454c))) {
            return false;
        }
        boolean m353d = m353d();
        boolean m353d2 = hqVar.m353d();
        if ((m353d || m353d2) && !(m353d && m353d2 && this.f447a == hqVar.f447a)) {
            return false;
        }
        boolean m354e = m354e();
        boolean m354e2 = hqVar.m354e();
        if ((m354e || m354e2) && !(m354e && m354e2 && this.f452b == hqVar.f452b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f451a == hqVar.f451a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f455d.equals(hqVar.f455d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f456e.equals(hqVar.f456e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f457f.equals(hqVar.f457f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f450a.equals(hqVar.f450a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f458g.equals(hqVar.f458g));
    }

    public hq b(long j2) {
        this.f452b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f453b = str;
        return this;
    }

    public String b() {
        return this.f454c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m347a();
        jiVar.a(f446a);
        if (this.f448a != null && m349a()) {
            jiVar.a(a);
            jiVar.a(this.f448a);
            jiVar.b();
        }
        if (this.f453b != null && m351b()) {
            jiVar.a(b);
            jiVar.a(this.f453b);
            jiVar.b();
        }
        if (this.f454c != null && m352c()) {
            jiVar.a(c);
            jiVar.a(this.f454c);
            jiVar.b();
        }
        if (m353d()) {
            jiVar.a(d);
            jiVar.a(this.f447a);
            jiVar.b();
        }
        if (m354e()) {
            jiVar.a(e);
            jiVar.a(this.f452b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f451a);
            jiVar.b();
        }
        if (this.f455d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f455d);
            jiVar.b();
        }
        if (this.f456e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f456e);
            jiVar.b();
        }
        if (this.f457f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f457f);
            jiVar.b();
        }
        if (this.f450a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f450a.size()));
            for (Map.Entry<String, String> entry : this.f450a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f458g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f458g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f449a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m351b() {
        return this.f453b != null;
    }

    public hq c(String str) {
        this.f454c = str;
        return this;
    }

    public String c() {
        return this.f456e;
    }

    public void c(boolean z) {
        this.f449a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m352c() {
        return this.f454c != null;
    }

    public hq d(String str) {
        this.f455d = str;
        return this;
    }

    public String d() {
        return this.f457f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m353d() {
        return this.f449a.get(0);
    }

    public hq e(String str) {
        this.f456e = str;
        return this;
    }

    public String e() {
        return this.f458g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m354e() {
        return this.f449a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m350a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f457f = str;
        return this;
    }

    public boolean f() {
        return this.f449a.get(2);
    }

    public hq g(String str) {
        this.f458g = str;
        return this;
    }

    public boolean g() {
        return this.f455d != null;
    }

    public boolean h() {
        return this.f456e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f457f != null;
    }

    public boolean j() {
        return this.f450a != null;
    }

    public boolean k() {
        return this.f458g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m349a()) {
            sb.append("channel:");
            if (this.f448a == null) {
                sb.append("null");
            } else {
                sb.append(this.f448a);
            }
            z2 = false;
        }
        if (m351b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f453b == null) {
                sb.append("null");
            } else {
                sb.append(this.f453b);
            }
            z2 = false;
        }
        if (m352c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f454c == null) {
                sb.append("null");
            } else {
                sb.append(this.f454c);
            }
            z2 = false;
        }
        if (m353d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f447a);
            z2 = false;
        }
        if (m354e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f452b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f451a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f455d == null) {
                sb.append("null");
            } else {
                sb.append(this.f455d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f456e == null) {
                sb.append("null");
            } else {
                sb.append(this.f456e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f457f == null) {
                sb.append("null");
            } else {
                sb.append(this.f457f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f450a == null) {
                sb.append("null");
            } else {
                sb.append(this.f450a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f458g == null) {
                sb.append("null");
            } else {
                sb.append(this.f458g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
