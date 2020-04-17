package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f461a;

    /* renamed from: a  reason: collision with other field name */
    public String f462a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f463a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f464a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f465a;

    /* renamed from: b  reason: collision with other field name */
    public long f466b;

    /* renamed from: b  reason: collision with other field name */
    public String f467b;

    /* renamed from: c  reason: collision with other field name */
    public String f468c;

    /* renamed from: d  reason: collision with other field name */
    public String f469d;

    /* renamed from: e  reason: collision with other field name */
    public String f470e;

    /* renamed from: f  reason: collision with other field name */
    public String f471f;

    /* renamed from: g  reason: collision with other field name */
    public String f472g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f460a = new jh("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m341a()).compareTo(Boolean.valueOf(hkVar.m341a()));
            if (compareTo == 0) {
                if (!m341a() || (a12 = is.a(this.f462a, hkVar.f462a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m343b()).compareTo(Boolean.valueOf(hkVar.m343b()));
                    if (compareTo2 == 0) {
                        if (!m343b() || (a11 = is.a(this.f467b, hkVar.f467b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m344c()).compareTo(Boolean.valueOf(hkVar.m344c()));
                            if (compareTo3 == 0) {
                                if (!m344c() || (a10 = is.a(this.f468c, hkVar.f468c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m345d()).compareTo(Boolean.valueOf(hkVar.m345d()));
                                    if (compareTo4 == 0) {
                                        if (!m345d() || (a9 = is.a(this.f461a, hkVar.f461a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m346e()).compareTo(Boolean.valueOf(hkVar.m346e()));
                                            if (compareTo5 == 0) {
                                                if (!m346e() || (a8 = is.a(this.f466b, hkVar.f466b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = is.a(this.f465a, hkVar.f465a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = is.a(this.f469d, hkVar.f469d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = is.a(this.f470e, hkVar.f470e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = is.a(this.f471f, hkVar.f471f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = is.a(this.f464a, hkVar.f464a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = is.a(this.f472g, hkVar.f472g)) == 0) {
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
        return this.f466b;
    }

    public hk a(long j2) {
        this.f461a = j2;
        m340a(true);
        return this;
    }

    public hk a(String str) {
        this.f462a = str;
        return this;
    }

    public hk a(boolean z) {
        this.f465a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m338a() {
        return this.f462a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m339a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m339a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 11) {
                        this.f462a = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 11) {
                        this.f467b = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 11) {
                        this.f468c = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 4:
                    if (m471a.a == 10) {
                        this.f461a = jcVar.m470a();
                        m340a(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 5:
                    if (m471a.a == 10) {
                        this.f466b = jcVar.m470a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 6:
                    if (m471a.a == 2) {
                        this.f465a = jcVar.m480a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 7:
                    if (m471a.a == 11) {
                        this.f469d = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 8:
                    if (m471a.a == 11) {
                        this.f470e = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 9:
                    if (m471a.a == 11) {
                        this.f471f = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 10:
                    if (m471a.a == 13) {
                        jb m473a = jcVar.m473a();
                        this.f464a = new HashMap(m473a.f793a * 2);
                        for (int i2 = 0; i2 < m473a.f793a; i2++) {
                            this.f464a.put(jcVar.m476a(), jcVar.m476a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 11:
                    if (m471a.a == 11) {
                        this.f472g = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m340a(boolean z) {
        this.f463a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m341a() {
        return this.f462a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m342a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m341a = m341a();
        boolean m341a2 = hkVar.m341a();
        if ((m341a || m341a2) && !(m341a && m341a2 && this.f462a.equals(hkVar.f462a))) {
            return false;
        }
        boolean m343b = m343b();
        boolean m343b2 = hkVar.m343b();
        if ((m343b || m343b2) && !(m343b && m343b2 && this.f467b.equals(hkVar.f467b))) {
            return false;
        }
        boolean m344c = m344c();
        boolean m344c2 = hkVar.m344c();
        if ((m344c || m344c2) && !(m344c && m344c2 && this.f468c.equals(hkVar.f468c))) {
            return false;
        }
        boolean m345d = m345d();
        boolean m345d2 = hkVar.m345d();
        if ((m345d || m345d2) && !(m345d && m345d2 && this.f461a == hkVar.f461a)) {
            return false;
        }
        boolean m346e = m346e();
        boolean m346e2 = hkVar.m346e();
        if ((m346e || m346e2) && !(m346e && m346e2 && this.f466b == hkVar.f466b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f465a == hkVar.f465a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f469d.equals(hkVar.f469d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f470e.equals(hkVar.f470e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f471f.equals(hkVar.f471f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f464a.equals(hkVar.f464a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f472g.equals(hkVar.f472g));
    }

    public hk b(long j2) {
        this.f466b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f467b = str;
        return this;
    }

    public String b() {
        return this.f468c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m339a();
        jcVar.a(f460a);
        if (this.f462a != null && m341a()) {
            jcVar.a(a);
            jcVar.a(this.f462a);
            jcVar.b();
        }
        if (this.f467b != null && m343b()) {
            jcVar.a(b);
            jcVar.a(this.f467b);
            jcVar.b();
        }
        if (this.f468c != null && m344c()) {
            jcVar.a(c);
            jcVar.a(this.f468c);
            jcVar.b();
        }
        if (m345d()) {
            jcVar.a(d);
            jcVar.a(this.f461a);
            jcVar.b();
        }
        if (m346e()) {
            jcVar.a(e);
            jcVar.a(this.f466b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f465a);
            jcVar.b();
        }
        if (this.f469d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f469d);
            jcVar.b();
        }
        if (this.f470e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f470e);
            jcVar.b();
        }
        if (this.f471f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f471f);
            jcVar.b();
        }
        if (this.f464a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f464a.size()));
            for (Map.Entry<String, String> entry : this.f464a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f472g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f472g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public void b(boolean z) {
        this.f463a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m343b() {
        return this.f467b != null;
    }

    public hk c(String str) {
        this.f468c = str;
        return this;
    }

    public String c() {
        return this.f470e;
    }

    public void c(boolean z) {
        this.f463a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m344c() {
        return this.f468c != null;
    }

    public hk d(String str) {
        this.f469d = str;
        return this;
    }

    public String d() {
        return this.f471f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m345d() {
        return this.f463a.get(0);
    }

    public hk e(String str) {
        this.f470e = str;
        return this;
    }

    public String e() {
        return this.f472g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m346e() {
        return this.f463a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m342a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f471f = str;
        return this;
    }

    public boolean f() {
        return this.f463a.get(2);
    }

    public hk g(String str) {
        this.f472g = str;
        return this;
    }

    public boolean g() {
        return this.f469d != null;
    }

    public boolean h() {
        return this.f470e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f471f != null;
    }

    public boolean j() {
        return this.f464a != null;
    }

    public boolean k() {
        return this.f472g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m341a()) {
            sb.append("channel:");
            if (this.f462a == null) {
                sb.append("null");
            } else {
                sb.append(this.f462a);
            }
            z2 = false;
        }
        if (m343b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f467b == null) {
                sb.append("null");
            } else {
                sb.append(this.f467b);
            }
            z2 = false;
        }
        if (m344c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f468c == null) {
                sb.append("null");
            } else {
                sb.append(this.f468c);
            }
            z2 = false;
        }
        if (m345d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f461a);
            z2 = false;
        }
        if (m346e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f466b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f465a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f469d == null) {
                sb.append("null");
            } else {
                sb.append(this.f469d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f470e == null) {
                sb.append("null");
            } else {
                sb.append(this.f470e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f471f == null) {
                sb.append("null");
            } else {
                sb.append(this.f471f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f464a == null) {
                sb.append("null");
            } else {
                sb.append(this.f464a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f472g == null) {
                sb.append("null");
            } else {
                sb.append(this.f472g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
