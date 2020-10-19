package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class hq implements ix<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f448a;

    /* renamed from: a  reason: collision with other field name */
    public String f449a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f450a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f451a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f452a;

    /* renamed from: b  reason: collision with other field name */
    public long f453b;

    /* renamed from: b  reason: collision with other field name */
    public String f454b;

    /* renamed from: c  reason: collision with other field name */
    public String f455c;

    /* renamed from: d  reason: collision with other field name */
    public String f456d;

    /* renamed from: e  reason: collision with other field name */
    public String f457e;

    /* renamed from: f  reason: collision with other field name */
    public String f458f;

    /* renamed from: g  reason: collision with other field name */
    public String f459g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f447a = new jn("ClientUploadDataItem");

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
            int compareTo = Boolean.valueOf(m350a()).compareTo(Boolean.valueOf(hqVar.m350a()));
            if (compareTo == 0) {
                if (!m350a() || (a12 = iy.a(this.f449a, hqVar.f449a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m352b()).compareTo(Boolean.valueOf(hqVar.m352b()));
                    if (compareTo2 == 0) {
                        if (!m352b() || (a11 = iy.a(this.f454b, hqVar.f454b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m353c()).compareTo(Boolean.valueOf(hqVar.m353c()));
                            if (compareTo3 == 0) {
                                if (!m353c() || (a10 = iy.a(this.f455c, hqVar.f455c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m354d()).compareTo(Boolean.valueOf(hqVar.m354d()));
                                    if (compareTo4 == 0) {
                                        if (!m354d() || (a9 = iy.a(this.f448a, hqVar.f448a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m355e()).compareTo(Boolean.valueOf(hqVar.m355e()));
                                            if (compareTo5 == 0) {
                                                if (!m355e() || (a8 = iy.a(this.f453b, hqVar.f453b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = iy.a(this.f452a, hqVar.f452a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = iy.a(this.f456d, hqVar.f456d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = iy.a(this.f457e, hqVar.f457e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = iy.a(this.f458f, hqVar.f458f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = iy.a(this.f451a, hqVar.f451a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hqVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = iy.a(this.f459g, hqVar.f459g)) == 0) {
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
        return this.f453b;
    }

    public hq a(long j2) {
        this.f448a = j2;
        m349a(true);
        return this;
    }

    public hq a(String str) {
        this.f449a = str;
        return this;
    }

    public hq a(boolean z) {
        this.f452a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m347a() {
        return this.f449a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a() {
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m348a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 11) {
                        this.f449a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 2:
                    if (m486a.f5000a == 11) {
                        this.f454b = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 3:
                    if (m486a.f5000a == 11) {
                        this.f455c = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 4:
                    if (m486a.f5000a == 10) {
                        this.f448a = jiVar.m485a();
                        m349a(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 5:
                    if (m486a.f5000a == 10) {
                        this.f453b = jiVar.m485a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 6:
                    if (m486a.f5000a == 2) {
                        this.f452a = jiVar.m495a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 7:
                    if (m486a.f5000a == 11) {
                        this.f456d = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 8:
                    if (m486a.f5000a == 11) {
                        this.f457e = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 9:
                    if (m486a.f5000a == 11) {
                        this.f458f = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 10:
                    if (m486a.f5000a == 13) {
                        jh m488a = jiVar.m488a();
                        this.f451a = new HashMap(m488a.f781a * 2);
                        for (int i2 = 0; i2 < m488a.f781a; i2++) {
                            this.f451a.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 11:
                    if (m486a.f5000a == 11) {
                        this.f459g = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m349a(boolean z) {
        this.f450a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m350a() {
        return this.f449a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m351a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m350a = m350a();
        boolean m350a2 = hqVar.m350a();
        if ((m350a || m350a2) && !(m350a && m350a2 && this.f449a.equals(hqVar.f449a))) {
            return false;
        }
        boolean m352b = m352b();
        boolean m352b2 = hqVar.m352b();
        if ((m352b || m352b2) && !(m352b && m352b2 && this.f454b.equals(hqVar.f454b))) {
            return false;
        }
        boolean m353c = m353c();
        boolean m353c2 = hqVar.m353c();
        if ((m353c || m353c2) && !(m353c && m353c2 && this.f455c.equals(hqVar.f455c))) {
            return false;
        }
        boolean m354d = m354d();
        boolean m354d2 = hqVar.m354d();
        if ((m354d || m354d2) && !(m354d && m354d2 && this.f448a == hqVar.f448a)) {
            return false;
        }
        boolean m355e = m355e();
        boolean m355e2 = hqVar.m355e();
        if ((m355e || m355e2) && !(m355e && m355e2 && this.f453b == hqVar.f453b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f452a == hqVar.f452a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f456d.equals(hqVar.f456d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f457e.equals(hqVar.f457e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f458f.equals(hqVar.f458f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f451a.equals(hqVar.f451a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hqVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f459g.equals(hqVar.f459g));
    }

    public hq b(long j2) {
        this.f453b = j2;
        b(true);
        return this;
    }

    public hq b(String str) {
        this.f454b = str;
        return this;
    }

    public String b() {
        return this.f455c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m348a();
        jiVar.a(f447a);
        if (this.f449a != null && m350a()) {
            jiVar.a(f4959a);
            jiVar.a(this.f449a);
            jiVar.b();
        }
        if (this.f454b != null && m352b()) {
            jiVar.a(b);
            jiVar.a(this.f454b);
            jiVar.b();
        }
        if (this.f455c != null && m353c()) {
            jiVar.a(c);
            jiVar.a(this.f455c);
            jiVar.b();
        }
        if (m354d()) {
            jiVar.a(d);
            jiVar.a(this.f448a);
            jiVar.b();
        }
        if (m355e()) {
            jiVar.a(e);
            jiVar.a(this.f453b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f452a);
            jiVar.b();
        }
        if (this.f456d != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f456d);
            jiVar.b();
        }
        if (this.f457e != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f457e);
            jiVar.b();
        }
        if (this.f458f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f458f);
            jiVar.b();
        }
        if (this.f451a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f451a.size()));
            for (Map.Entry<String, String> entry : this.f451a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f459g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f459g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public void b(boolean z) {
        this.f450a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m352b() {
        return this.f454b != null;
    }

    public hq c(String str) {
        this.f455c = str;
        return this;
    }

    public String c() {
        return this.f457e;
    }

    public void c(boolean z) {
        this.f450a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m353c() {
        return this.f455c != null;
    }

    public hq d(String str) {
        this.f456d = str;
        return this;
    }

    public String d() {
        return this.f458f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m354d() {
        return this.f450a.get(0);
    }

    public hq e(String str) {
        this.f457e = str;
        return this;
    }

    public String e() {
        return this.f459g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m355e() {
        return this.f450a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m351a((hq) obj);
        }
        return false;
    }

    public hq f(String str) {
        this.f458f = str;
        return this;
    }

    public boolean f() {
        return this.f450a.get(2);
    }

    public hq g(String str) {
        this.f459g = str;
        return this;
    }

    public boolean g() {
        return this.f456d != null;
    }

    public boolean h() {
        return this.f457e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f458f != null;
    }

    public boolean j() {
        return this.f451a != null;
    }

    public boolean k() {
        return this.f459g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m350a()) {
            sb.append("channel:");
            if (this.f449a == null) {
                sb.append("null");
            } else {
                sb.append(this.f449a);
            }
            z2 = false;
        }
        if (m352b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f454b == null) {
                sb.append("null");
            } else {
                sb.append(this.f454b);
            }
            z2 = false;
        }
        if (m353c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f455c == null) {
                sb.append("null");
            } else {
                sb.append(this.f455c);
            }
            z2 = false;
        }
        if (m354d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f448a);
            z2 = false;
        }
        if (m355e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f453b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f452a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f456d == null) {
                sb.append("null");
            } else {
                sb.append(this.f456d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f457e == null) {
                sb.append("null");
            } else {
                sb.append(this.f457e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f458f == null) {
                sb.append("null");
            } else {
                sb.append(this.f458f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f451a == null) {
                sb.append("null");
            } else {
                sb.append(this.f451a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f459g == null) {
                sb.append("null");
            } else {
                sb.append(this.f459g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
