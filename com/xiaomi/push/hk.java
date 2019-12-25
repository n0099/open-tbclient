package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class hk implements ir<hk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f465a;

    /* renamed from: a  reason: collision with other field name */
    public String f466a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f467a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f468a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f469a;

    /* renamed from: b  reason: collision with other field name */
    public long f470b;

    /* renamed from: b  reason: collision with other field name */
    public String f471b;

    /* renamed from: c  reason: collision with other field name */
    public String f472c;

    /* renamed from: d  reason: collision with other field name */
    public String f473d;

    /* renamed from: e  reason: collision with other field name */
    public String f474e;

    /* renamed from: f  reason: collision with other field name */
    public String f475f;

    /* renamed from: g  reason: collision with other field name */
    public String f476g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f464a = new jh("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m324a()).compareTo(Boolean.valueOf(hkVar.m324a()));
            if (compareTo == 0) {
                if (!m324a() || (a12 = is.a(this.f466a, hkVar.f466a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m326b()).compareTo(Boolean.valueOf(hkVar.m326b()));
                    if (compareTo2 == 0) {
                        if (!m326b() || (a11 = is.a(this.f471b, hkVar.f471b)) == 0) {
                            int compareTo3 = Boolean.valueOf(m327c()).compareTo(Boolean.valueOf(hkVar.m327c()));
                            if (compareTo3 == 0) {
                                if (!m327c() || (a10 = is.a(this.f472c, hkVar.f472c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m328d()).compareTo(Boolean.valueOf(hkVar.m328d()));
                                    if (compareTo4 == 0) {
                                        if (!m328d() || (a9 = is.a(this.f465a, hkVar.f465a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m329e()).compareTo(Boolean.valueOf(hkVar.m329e()));
                                            if (compareTo5 == 0) {
                                                if (!m329e() || (a8 = is.a(this.f470b, hkVar.f470b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = is.a(this.f469a, hkVar.f469a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = is.a(this.f473d, hkVar.f473d)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = is.a(this.f474e, hkVar.f474e)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = is.a(this.f475f, hkVar.f475f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = is.a(this.f468a, hkVar.f468a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hkVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = is.a(this.f476g, hkVar.f476g)) == 0) {
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
        return this.f470b;
    }

    public hk a(long j2) {
        this.f465a = j2;
        m323a(true);
        return this;
    }

    public hk a(String str) {
        this.f466a = str;
        return this;
    }

    public hk a(boolean z) {
        this.f469a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m321a() {
        return this.f466a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m322a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m322a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f466a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 11) {
                        this.f471b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f472c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 10) {
                        this.f465a = jcVar.m453a();
                        m323a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 10) {
                        this.f470b = jcVar.m453a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 2) {
                        this.f469a = jcVar.m463a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f473d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 11) {
                        this.f474e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 11) {
                        this.f475f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f468a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f468a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 11) {
                        this.f476g = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m323a(boolean z) {
        this.f467a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m324a() {
        return this.f466a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m325a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean m324a = m324a();
        boolean m324a2 = hkVar.m324a();
        if ((m324a || m324a2) && !(m324a && m324a2 && this.f466a.equals(hkVar.f466a))) {
            return false;
        }
        boolean m326b = m326b();
        boolean m326b2 = hkVar.m326b();
        if ((m326b || m326b2) && !(m326b && m326b2 && this.f471b.equals(hkVar.f471b))) {
            return false;
        }
        boolean m327c = m327c();
        boolean m327c2 = hkVar.m327c();
        if ((m327c || m327c2) && !(m327c && m327c2 && this.f472c.equals(hkVar.f472c))) {
            return false;
        }
        boolean m328d = m328d();
        boolean m328d2 = hkVar.m328d();
        if ((m328d || m328d2) && !(m328d && m328d2 && this.f465a == hkVar.f465a)) {
            return false;
        }
        boolean m329e = m329e();
        boolean m329e2 = hkVar.m329e();
        if ((m329e || m329e2) && !(m329e && m329e2 && this.f470b == hkVar.f470b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hkVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f469a == hkVar.f469a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hkVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f473d.equals(hkVar.f473d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f474e.equals(hkVar.f474e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f475f.equals(hkVar.f475f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f468a.equals(hkVar.f468a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hkVar.k();
        return !(k2 || k3) || (k2 && k3 && this.f476g.equals(hkVar.f476g));
    }

    public hk b(long j2) {
        this.f470b = j2;
        b(true);
        return this;
    }

    public hk b(String str) {
        this.f471b = str;
        return this;
    }

    public String b() {
        return this.f472c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m322a();
        jcVar.a(f464a);
        if (this.f466a != null && m324a()) {
            jcVar.a(a);
            jcVar.a(this.f466a);
            jcVar.b();
        }
        if (this.f471b != null && m326b()) {
            jcVar.a(b);
            jcVar.a(this.f471b);
            jcVar.b();
        }
        if (this.f472c != null && m327c()) {
            jcVar.a(c);
            jcVar.a(this.f472c);
            jcVar.b();
        }
        if (m328d()) {
            jcVar.a(d);
            jcVar.a(this.f465a);
            jcVar.b();
        }
        if (m329e()) {
            jcVar.a(e);
            jcVar.a(this.f470b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f469a);
            jcVar.b();
        }
        if (this.f473d != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f473d);
            jcVar.b();
        }
        if (this.f474e != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f474e);
            jcVar.b();
        }
        if (this.f475f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f475f);
            jcVar.b();
        }
        if (this.f468a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f468a.size()));
            for (Map.Entry<String, String> entry : this.f468a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f476g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f476g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f467a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m326b() {
        return this.f471b != null;
    }

    public hk c(String str) {
        this.f472c = str;
        return this;
    }

    public String c() {
        return this.f474e;
    }

    public void c(boolean z) {
        this.f467a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m327c() {
        return this.f472c != null;
    }

    public hk d(String str) {
        this.f473d = str;
        return this;
    }

    public String d() {
        return this.f475f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m328d() {
        return this.f467a.get(0);
    }

    public hk e(String str) {
        this.f474e = str;
        return this;
    }

    public String e() {
        return this.f476g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m329e() {
        return this.f467a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m325a((hk) obj);
        }
        return false;
    }

    public hk f(String str) {
        this.f475f = str;
        return this;
    }

    public boolean f() {
        return this.f467a.get(2);
    }

    public hk g(String str) {
        this.f476g = str;
        return this;
    }

    public boolean g() {
        return this.f473d != null;
    }

    public boolean h() {
        return this.f474e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f475f != null;
    }

    public boolean j() {
        return this.f468a != null;
    }

    public boolean k() {
        return this.f476g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (m324a()) {
            sb.append("channel:");
            if (this.f466a == null) {
                sb.append("null");
            } else {
                sb.append(this.f466a);
            }
            z2 = false;
        }
        if (m326b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("data:");
            if (this.f471b == null) {
                sb.append("null");
            } else {
                sb.append(this.f471b);
            }
            z2 = false;
        }
        if (m327c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.f472c == null) {
                sb.append("null");
            } else {
                sb.append(this.f472c);
            }
            z2 = false;
        }
        if (m328d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f465a);
            z2 = false;
        }
        if (m329e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f470b);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f469a);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.f473d == null) {
                sb.append("null");
            } else {
                sb.append(this.f473d);
            }
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.f474e == null) {
                sb.append("null");
            } else {
                sb.append(this.f474e);
            }
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.f475f == null) {
                sb.append("null");
            } else {
                sb.append(this.f475f);
            }
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.f468a == null) {
                sb.append("null");
            } else {
                sb.append(this.f468a);
            }
        } else {
            z = z2;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            if (this.f476g == null) {
                sb.append("null");
            } else {
                sb.append(this.f476g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
