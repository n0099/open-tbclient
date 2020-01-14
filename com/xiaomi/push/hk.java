package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f464a;

    /* renamed from: a  reason: collision with other field name */
    public String f465a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f466a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f467a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f468a;

    /* renamed from: b  reason: collision with other field name */
    public long f469b;

    /* renamed from: b  reason: collision with other field name */
    public String f470b;

    /* renamed from: c  reason: collision with other field name */
    public String f471c;

    /* renamed from: d  reason: collision with other field name */
    public String f472d;

    /* renamed from: e  reason: collision with other field name */
    public String f473e;

    /* renamed from: f  reason: collision with other field name */
    public String f474f;

    /* renamed from: g  reason: collision with other field name */
    public String f475g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f463a = new jh("ClientUploadDataItem");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", (byte) 10, 4);
    private static final iz e = new iz("", (byte) 10, 5);
    private static final iz f = new iz("", (byte) 2, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 11);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hk hkVar) {
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
        if (getClass().equals(hkVar.getClass())) {
            int compareTo = Boolean.valueOf(m333a()).compareTo(Boolean.valueOf(hkVar.m333a()));
            if (compareTo == 0) {
                if (!m333a() || (a12 = is.a(this.f465a, hkVar.f465a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m335b()).compareTo(Boolean.valueOf(hkVar.m335b()));
                    if (compareTo2 == 0) {
                        if (!m335b() || (a11 = is.a(this.f470b, hkVar.f470b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m336c()).compareTo(Boolean.valueOf(hkVar.m336c()));
                            if (compareTo3 == 0) {
                                if (!m336c() || (a10 = is.a(this.f471c, hkVar.f471c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m337d()).compareTo(Boolean.valueOf(hkVar.m337d()));
                                    if (compareTo4 == 0) {
                                        if (!m337d() || (a9 = is.a(this.f464a, hkVar.f464a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m338e()).compareTo(Boolean.valueOf(hkVar.m338e()));
                                            if (compareTo5 == 0) {
                                                if (!m338e() || (a8 = is.a(this.f469b, hkVar.f469b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = is.a(this.f468a, hkVar.f468a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = is.a(this.f472d, hkVar.f472d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = is.a(this.f473e, hkVar.f473e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = is.a(this.f474f, hkVar.f474f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = is.a(this.f467a, hkVar.f467a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = is.a(this.f475g, hkVar.f475g)) == 0) {
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
        return getClass().getName().compareTo(hkVar.getClass().getName());
    }

    public long a() {
        return this.f469b;
    }

    public hk a(long j2) {
        this.f464a = j2;
        m332a(true);
        return this;
    }

    public hk a(String str) {
        this.f465a = str;
        return this;
    }

    public hk a(boolean z) {
        this.f468a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m330a() {
        return this.f465a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m331a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m331a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f465a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 11) {
                        this.f470b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f471c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 10) {
                        this.f464a = jcVar.m462a();
                        m332a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 10) {
                        this.f469b = jcVar.m462a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 2) {
                        this.f468a = jcVar.m472a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f472d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 11) {
                        this.f473e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 11) {
                        this.f474f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f467a = new HashMap(m465a.f796a * 2);
                        for (int i2 = 0; i2 < m465a.f796a; i2++) {
                            this.f467a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 11) {
                        this.f475g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m332a(boolean z) {
        this.f466a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m333a() {
        return this.f465a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m334a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m333a = m333a();
        boolean m333a2 = hkVar.m333a();
        if ((m333a || m333a2) && !(m333a && m333a2 && this.f465a.equals(hkVar.f465a))) {
            return false;
        }
        boolean m335b = m335b();
        boolean m335b2 = hkVar.m335b();
        if ((m335b || m335b2) && !(m335b && m335b2 && this.f470b.equals(hkVar.f470b))) {
            return false;
        }
        boolean m336c = m336c();
        boolean m336c2 = hkVar.m336c();
        if ((m336c || m336c2) && !(m336c && m336c2 && this.f471c.equals(hkVar.f471c))) {
            return false;
        }
        boolean m337d = m337d();
        boolean m337d2 = hkVar.m337d();
        if ((m337d || m337d2) && !(m337d && m337d2 && this.f464a == hkVar.f464a)) {
            return false;
        }
        boolean m338e = m338e();
        boolean m338e2 = hkVar.m338e();
        if ((m338e || m338e2) && !(m338e && m338e2 && this.f469b == hkVar.f469b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f468a == hkVar.f468a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f472d.equals(hkVar.f472d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f473e.equals(hkVar.f473e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f474f.equals(hkVar.f474f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f467a.equals(hkVar.f467a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f475g.equals(hkVar.f475g));
    }

    public hk b(long j2) {
        this.f469b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f470b = str;
        return this;
    }

    public String b() {
        return this.f471c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m331a();
        jcVar.a(f463a);
        if (this.f465a != null && m333a()) {
            jcVar.a(a);
            jcVar.a(this.f465a);
            jcVar.b();
        }
        if (this.f470b != null && m335b()) {
            jcVar.a(b);
            jcVar.a(this.f470b);
            jcVar.b();
        }
        if (this.f471c != null && m336c()) {
            jcVar.a(c);
            jcVar.a(this.f471c);
            jcVar.b();
        }
        if (m337d()) {
            jcVar.a(d);
            jcVar.a(this.f464a);
            jcVar.b();
        }
        if (m338e()) {
            jcVar.a(e);
            jcVar.a(this.f469b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f468a);
            jcVar.b();
        }
        if (this.f472d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f472d);
            jcVar.b();
        }
        if (this.f473e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f473e);
            jcVar.b();
        }
        if (this.f474f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f474f);
            jcVar.b();
        }
        if (this.f467a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f467a.size()));
            for (Map.Entry<String, String> entry : this.f467a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f475g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f475g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f466a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m335b() {
        return this.f470b != null;
    }

    public hk c(String str) {
        this.f471c = str;
        return this;
    }

    public String c() {
        return this.f473e;
    }

    public void c(boolean z) {
        this.f466a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m336c() {
        return this.f471c != null;
    }

    public hk d(String str) {
        this.f472d = str;
        return this;
    }

    public String d() {
        return this.f474f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m337d() {
        return this.f466a.get(0);
    }

    public hk e(String str) {
        this.f473e = str;
        return this;
    }

    public String e() {
        return this.f475g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m338e() {
        return this.f466a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m334a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f474f = str;
        return this;
    }

    public boolean f() {
        return this.f466a.get(2);
    }

    public hk g(String str) {
        this.f475g = str;
        return this;
    }

    public boolean g() {
        return this.f472d != null;
    }

    public boolean h() {
        return this.f473e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f474f != null;
    }

    public boolean j() {
        return this.f467a != null;
    }

    public boolean k() {
        return this.f475g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m333a()) {
            sb.append("channel:");
            if (this.f465a == null) {
                sb.append("null");
            } else {
                sb.append(this.f465a);
            }
            z2 = false;
        }
        if (m335b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f470b == null) {
                sb.append("null");
            } else {
                sb.append(this.f470b);
            }
            z2 = false;
        }
        if (m336c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f471c == null) {
                sb.append("null");
            } else {
                sb.append(this.f471c);
            }
            z2 = false;
        }
        if (m337d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f464a);
            z2 = false;
        }
        if (m338e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f469b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f468a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f472d == null) {
                sb.append("null");
            } else {
                sb.append(this.f472d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f473e == null) {
                sb.append("null");
            } else {
                sb.append(this.f473e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f474f == null) {
                sb.append("null");
            } else {
                sb.append(this.f474f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f467a == null) {
                sb.append("null");
            } else {
                sb.append(this.f467a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f475g == null) {
                sb.append("null");
            } else {
                sb.append(this.f475g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
