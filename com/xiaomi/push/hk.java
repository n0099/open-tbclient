package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f460a;

    /* renamed from: a  reason: collision with other field name */
    public String f461a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f462a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f463a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f464a;

    /* renamed from: b  reason: collision with other field name */
    public long f465b;

    /* renamed from: b  reason: collision with other field name */
    public String f466b;

    /* renamed from: c  reason: collision with other field name */
    public String f467c;

    /* renamed from: d  reason: collision with other field name */
    public String f468d;

    /* renamed from: e  reason: collision with other field name */
    public String f469e;

    /* renamed from: f  reason: collision with other field name */
    public String f470f;

    /* renamed from: g  reason: collision with other field name */
    public String f471g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f459a = new jh("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m338a()).compareTo(Boolean.valueOf(hkVar.m338a()));
            if (compareTo == 0) {
                if (!m338a() || (a12 = is.a(this.f461a, hkVar.f461a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m340b()).compareTo(Boolean.valueOf(hkVar.m340b()));
                    if (compareTo2 == 0) {
                        if (!m340b() || (a11 = is.a(this.f466b, hkVar.f466b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m341c()).compareTo(Boolean.valueOf(hkVar.m341c()));
                            if (compareTo3 == 0) {
                                if (!m341c() || (a10 = is.a(this.f467c, hkVar.f467c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m342d()).compareTo(Boolean.valueOf(hkVar.m342d()));
                                    if (compareTo4 == 0) {
                                        if (!m342d() || (a9 = is.a(this.f460a, hkVar.f460a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m343e()).compareTo(Boolean.valueOf(hkVar.m343e()));
                                            if (compareTo5 == 0) {
                                                if (!m343e() || (a8 = is.a(this.f465b, hkVar.f465b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = is.a(this.f464a, hkVar.f464a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = is.a(this.f468d, hkVar.f468d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = is.a(this.f469e, hkVar.f469e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = is.a(this.f470f, hkVar.f470f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = is.a(this.f463a, hkVar.f463a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = is.a(this.f471g, hkVar.f471g)) == 0) {
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
        return this.f465b;
    }

    public hk a(long j2) {
        this.f460a = j2;
        m337a(true);
        return this;
    }

    public hk a(String str) {
        this.f461a = str;
        return this;
    }

    public hk a(boolean z) {
        this.f464a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m335a() {
        return this.f461a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m336a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m336a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a == 11) {
                        this.f461a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 2:
                    if (m468a.a == 11) {
                        this.f466b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 11) {
                        this.f467c = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 4:
                    if (m468a.a == 10) {
                        this.f460a = jcVar.m467a();
                        m337a(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 5:
                    if (m468a.a == 10) {
                        this.f465b = jcVar.m467a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 6:
                    if (m468a.a == 2) {
                        this.f464a = jcVar.m477a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 7:
                    if (m468a.a == 11) {
                        this.f468d = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 8:
                    if (m468a.a == 11) {
                        this.f469e = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 9:
                    if (m468a.a == 11) {
                        this.f470f = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 10:
                    if (m468a.a == 13) {
                        jb m470a = jcVar.m470a();
                        this.f463a = new HashMap(m470a.f792a * 2);
                        for (int i2 = 0; i2 < m470a.f792a; i2++) {
                            this.f463a.put(jcVar.m473a(), jcVar.m473a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 11:
                    if (m468a.a == 11) {
                        this.f471g = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m337a(boolean z) {
        this.f462a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m338a() {
        return this.f461a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m338a = m338a();
        boolean m338a2 = hkVar.m338a();
        if ((m338a || m338a2) && !(m338a && m338a2 && this.f461a.equals(hkVar.f461a))) {
            return false;
        }
        boolean m340b = m340b();
        boolean m340b2 = hkVar.m340b();
        if ((m340b || m340b2) && !(m340b && m340b2 && this.f466b.equals(hkVar.f466b))) {
            return false;
        }
        boolean m341c = m341c();
        boolean m341c2 = hkVar.m341c();
        if ((m341c || m341c2) && !(m341c && m341c2 && this.f467c.equals(hkVar.f467c))) {
            return false;
        }
        boolean m342d = m342d();
        boolean m342d2 = hkVar.m342d();
        if ((m342d || m342d2) && !(m342d && m342d2 && this.f460a == hkVar.f460a)) {
            return false;
        }
        boolean m343e = m343e();
        boolean m343e2 = hkVar.m343e();
        if ((m343e || m343e2) && !(m343e && m343e2 && this.f465b == hkVar.f465b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f464a == hkVar.f464a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f468d.equals(hkVar.f468d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f469e.equals(hkVar.f469e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f470f.equals(hkVar.f470f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f463a.equals(hkVar.f463a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f471g.equals(hkVar.f471g));
    }

    public hk b(long j2) {
        this.f465b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f466b = str;
        return this;
    }

    public String b() {
        return this.f467c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m336a();
        jcVar.a(f459a);
        if (this.f461a != null && m338a()) {
            jcVar.a(a);
            jcVar.a(this.f461a);
            jcVar.b();
        }
        if (this.f466b != null && m340b()) {
            jcVar.a(b);
            jcVar.a(this.f466b);
            jcVar.b();
        }
        if (this.f467c != null && m341c()) {
            jcVar.a(c);
            jcVar.a(this.f467c);
            jcVar.b();
        }
        if (m342d()) {
            jcVar.a(d);
            jcVar.a(this.f460a);
            jcVar.b();
        }
        if (m343e()) {
            jcVar.a(e);
            jcVar.a(this.f465b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f464a);
            jcVar.b();
        }
        if (this.f468d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f468d);
            jcVar.b();
        }
        if (this.f469e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f469e);
            jcVar.b();
        }
        if (this.f470f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f470f);
            jcVar.b();
        }
        if (this.f463a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f463a.size()));
            for (Map.Entry<String, String> entry : this.f463a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f471g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f471g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f462a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m340b() {
        return this.f466b != null;
    }

    public hk c(String str) {
        this.f467c = str;
        return this;
    }

    public String c() {
        return this.f469e;
    }

    public void c(boolean z) {
        this.f462a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m341c() {
        return this.f467c != null;
    }

    public hk d(String str) {
        this.f468d = str;
        return this;
    }

    public String d() {
        return this.f470f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m342d() {
        return this.f462a.get(0);
    }

    public hk e(String str) {
        this.f469e = str;
        return this;
    }

    public String e() {
        return this.f471g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m343e() {
        return this.f462a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m339a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f470f = str;
        return this;
    }

    public boolean f() {
        return this.f462a.get(2);
    }

    public hk g(String str) {
        this.f471g = str;
        return this;
    }

    public boolean g() {
        return this.f468d != null;
    }

    public boolean h() {
        return this.f469e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f470f != null;
    }

    public boolean j() {
        return this.f463a != null;
    }

    public boolean k() {
        return this.f471g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m338a()) {
            sb.append("channel:");
            if (this.f461a == null) {
                sb.append("null");
            } else {
                sb.append(this.f461a);
            }
            z2 = false;
        }
        if (m340b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f466b == null) {
                sb.append("null");
            } else {
                sb.append(this.f466b);
            }
            z2 = false;
        }
        if (m341c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f467c == null) {
                sb.append("null");
            } else {
                sb.append(this.f467c);
            }
            z2 = false;
        }
        if (m342d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f460a);
            z2 = false;
        }
        if (m343e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f465b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f464a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f468d == null) {
                sb.append("null");
            } else {
                sb.append(this.f468d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f469e == null) {
                sb.append("null");
            } else {
                sb.append(this.f469e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f470f == null) {
                sb.append("null");
            } else {
                sb.append(this.f470f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f463a == null) {
                sb.append("null");
            } else {
                sb.append(this.f463a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f471g == null) {
                sb.append("null");
            } else {
                sb.append(this.f471g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
