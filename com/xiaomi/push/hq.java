package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f446a;

    /* renamed from: a  reason: collision with other field name */
    public String f447a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f448a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f449a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f450a;

    /* renamed from: b  reason: collision with other field name */
    public long f451b;

    /* renamed from: b  reason: collision with other field name */
    public String f452b;

    /* renamed from: c  reason: collision with other field name */
    public String f453c;

    /* renamed from: d  reason: collision with other field name */
    public String f454d;

    /* renamed from: e  reason: collision with other field name */
    public String f455e;

    /* renamed from: f  reason: collision with other field name */
    public String f456f;

    /* renamed from: g  reason: collision with other field name */
    public String f457g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f445a = new jn("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m347a()).compareTo(Boolean.valueOf(hqVar.m347a()));
            if (compareTo == 0) {
                if (!m347a() || (a12 = iy.a(this.f447a, hqVar.f447a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m349b()).compareTo(Boolean.valueOf(hqVar.m349b()));
                    if (compareTo2 == 0) {
                        if (!m349b() || (a11 = iy.a(this.f452b, hqVar.f452b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m350c()).compareTo(Boolean.valueOf(hqVar.m350c()));
                            if (compareTo3 == 0) {
                                if (!m350c() || (a10 = iy.a(this.f453c, hqVar.f453c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m351d()).compareTo(Boolean.valueOf(hqVar.m351d()));
                                    if (compareTo4 == 0) {
                                        if (!m351d() || (a9 = iy.a(this.f446a, hqVar.f446a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m352e()).compareTo(Boolean.valueOf(hqVar.m352e()));
                                            if (compareTo5 == 0) {
                                                if (!m352e() || (a8 = iy.a(this.f451b, hqVar.f451b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f450a, hqVar.f450a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f454d, hqVar.f454d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f455e, hqVar.f455e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f456f, hqVar.f456f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f449a, hqVar.f449a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f457g, hqVar.f457g)) == 0) {
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
        return this.f451b;
    }

    public hq a(long j2) {
        this.f446a = j2;
        m346a(true);
        return this;
    }

    public hq a(String str) {
        this.f447a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f450a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m344a() {
        return this.f447a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m345a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                m345a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a == 11) {
                        this.f447a = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 2:
                    if (m483a.a == 11) {
                        this.f452b = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 3:
                    if (m483a.a == 11) {
                        this.f453c = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 4:
                    if (m483a.a == 10) {
                        this.f446a = jiVar.m482a();
                        m346a(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 5:
                    if (m483a.a == 10) {
                        this.f451b = jiVar.m482a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 6:
                    if (m483a.a == 2) {
                        this.f450a = jiVar.m492a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 7:
                    if (m483a.a == 11) {
                        this.f454d = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 8:
                    if (m483a.a == 11) {
                        this.f455e = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 9:
                    if (m483a.a == 11) {
                        this.f456f = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 10:
                    if (m483a.a == 13) {
                        jh m485a = jiVar.m485a();
                        this.f449a = new HashMap(m485a.f779a * 2);
                        for (int i2 = 0; i2 < m485a.f779a; i2++) {
                            this.f449a.put(jiVar.m488a(), jiVar.m488a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 11:
                    if (m483a.a == 11) {
                        this.f457g = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m346a(boolean z) {
        this.f448a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a() {
        return this.f447a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m347a = m347a();
        boolean m347a2 = hqVar.m347a();
        if ((m347a || m347a2) && !(m347a && m347a2 && this.f447a.equals(hqVar.f447a))) {
            return false;
        }
        boolean m349b = m349b();
        boolean m349b2 = hqVar.m349b();
        if ((m349b || m349b2) && !(m349b && m349b2 && this.f452b.equals(hqVar.f452b))) {
            return false;
        }
        boolean m350c = m350c();
        boolean m350c2 = hqVar.m350c();
        if ((m350c || m350c2) && !(m350c && m350c2 && this.f453c.equals(hqVar.f453c))) {
            return false;
        }
        boolean m351d = m351d();
        boolean m351d2 = hqVar.m351d();
        if ((m351d || m351d2) && !(m351d && m351d2 && this.f446a == hqVar.f446a)) {
            return false;
        }
        boolean m352e = m352e();
        boolean m352e2 = hqVar.m352e();
        if ((m352e || m352e2) && !(m352e && m352e2 && this.f451b == hqVar.f451b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f450a == hqVar.f450a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f454d.equals(hqVar.f454d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f455e.equals(hqVar.f455e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f456f.equals(hqVar.f456f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f449a.equals(hqVar.f449a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f457g.equals(hqVar.f457g));
    }

    public hq b(long j2) {
        this.f451b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f452b = str;
        return this;
    }

    public String b() {
        return this.f453c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m345a();
        jiVar.a(f445a);
        if (this.f447a != null && m347a()) {
            jiVar.a(a);
            jiVar.a(this.f447a);
            jiVar.b();
        }
        if (this.f452b != null && m349b()) {
            jiVar.a(b);
            jiVar.a(this.f452b);
            jiVar.b();
        }
        if (this.f453c != null && m350c()) {
            jiVar.a(c);
            jiVar.a(this.f453c);
            jiVar.b();
        }
        if (m351d()) {
            jiVar.a(d);
            jiVar.a(this.f446a);
            jiVar.b();
        }
        if (m352e()) {
            jiVar.a(e);
            jiVar.a(this.f451b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f450a);
            jiVar.b();
        }
        if (this.f454d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f454d);
            jiVar.b();
        }
        if (this.f455e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f455e);
            jiVar.b();
        }
        if (this.f456f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f456f);
            jiVar.b();
        }
        if (this.f449a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f449a.size()));
            for (Map.Entry<String, String> entry : this.f449a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f457g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f457g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f448a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m349b() {
        return this.f452b != null;
    }

    public hq c(String str) {
        this.f453c = str;
        return this;
    }

    public String c() {
        return this.f455e;
    }

    public void c(boolean z) {
        this.f448a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m350c() {
        return this.f453c != null;
    }

    public hq d(String str) {
        this.f454d = str;
        return this;
    }

    public String d() {
        return this.f456f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m351d() {
        return this.f448a.get(0);
    }

    public hq e(String str) {
        this.f455e = str;
        return this;
    }

    public String e() {
        return this.f457g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m352e() {
        return this.f448a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m348a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f456f = str;
        return this;
    }

    public boolean f() {
        return this.f448a.get(2);
    }

    public hq g(String str) {
        this.f457g = str;
        return this;
    }

    public boolean g() {
        return this.f454d != null;
    }

    public boolean h() {
        return this.f455e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f456f != null;
    }

    public boolean j() {
        return this.f449a != null;
    }

    public boolean k() {
        return this.f457g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m347a()) {
            sb.append("channel:");
            if (this.f447a == null) {
                sb.append("null");
            } else {
                sb.append(this.f447a);
            }
            z2 = false;
        }
        if (m349b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f452b == null) {
                sb.append("null");
            } else {
                sb.append(this.f452b);
            }
            z2 = false;
        }
        if (m350c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f453c == null) {
                sb.append("null");
            } else {
                sb.append(this.f453c);
            }
            z2 = false;
        }
        if (m351d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f446a);
            z2 = false;
        }
        if (m352e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f451b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f450a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f454d == null) {
                sb.append("null");
            } else {
                sb.append(this.f454d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f455e == null) {
                sb.append("null");
            } else {
                sb.append(this.f455e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f456f == null) {
                sb.append("null");
            } else {
                sb.append(this.f456f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f449a == null) {
                sb.append("null");
            } else {
                sb.append(this.f449a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f457g == null) {
                sb.append("null");
            } else {
                sb.append(this.f457g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
