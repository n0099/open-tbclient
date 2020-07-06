package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f694a;

    /* renamed from: a  reason: collision with other field name */
    public ib f695a;

    /* renamed from: a  reason: collision with other field name */
    public String f696a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f698a;

    /* renamed from: b  reason: collision with other field name */
    public String f700b;

    /* renamed from: c  reason: collision with other field name */
    public String f701c;

    /* renamed from: d  reason: collision with other field name */
    public String f702d;

    /* renamed from: e  reason: collision with other field name */
    public String f703e;

    /* renamed from: f  reason: collision with other field name */
    public String f704f;

    /* renamed from: g  reason: collision with other field name */
    public String f705g;

    /* renamed from: h  reason: collision with other field name */
    public String f706h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f693a = new jn("XmPushActionSendMessage");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 12, 8);
    private static final jf i = new jf("", (byte) 2, 9);
    private static final jf j = new jf("", (byte) 13, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f697a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f699a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ip ipVar) {
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
        int a13;
        if (getClass().equals(ipVar.getClass())) {
            int compareTo = Boolean.valueOf(m449a()).compareTo(Boolean.valueOf(ipVar.m449a()));
            if (compareTo == 0) {
                if (!m449a() || (a13 = iy.a(this.f696a, ipVar.f696a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m451b()).compareTo(Boolean.valueOf(ipVar.m451b()));
                    if (compareTo2 == 0) {
                        if (!m451b() || (a12 = iy.a(this.f695a, ipVar.f695a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m452c()).compareTo(Boolean.valueOf(ipVar.m452c()));
                            if (compareTo3 == 0) {
                                if (!m452c() || (a11 = iy.a(this.f700b, ipVar.f700b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m453d()).compareTo(Boolean.valueOf(ipVar.m453d()));
                                    if (compareTo4 == 0) {
                                        if (!m453d() || (a10 = iy.a(this.f701c, ipVar.f701c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m454e()).compareTo(Boolean.valueOf(ipVar.m454e()));
                                            if (compareTo5 == 0) {
                                                if (!m454e() || (a9 = iy.a(this.f702d, ipVar.f702d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m455f()).compareTo(Boolean.valueOf(ipVar.m455f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m455f() || (a8 = iy.a(this.f703e, ipVar.f703e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f704f, ipVar.f704f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f694a, ipVar.f694a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f699a, ipVar.f699a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f698a, ipVar.f698a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f705g, ipVar.f705g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f706h, ipVar.f706h)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a2;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a3;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a4;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a5;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a7;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a8;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a9;
                                            }
                                            return compareTo5;
                                        }
                                        return a10;
                                    }
                                    return compareTo4;
                                }
                                return a11;
                            }
                            return compareTo3;
                        }
                        return a12;
                    }
                    return compareTo2;
                }
                return a13;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ipVar.getClass().getName());
    }

    public hy a() {
        return this.f694a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m447a() {
        return this.f700b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m448a() {
        if (this.f700b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f701c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m448a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f696a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f695a = new ib();
                        this.f695a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f700b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f701c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f702d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 11) {
                        this.f703e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f704f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 12) {
                        this.f694a = new hy();
                        this.f694a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 2) {
                        this.f699a = jiVar.m488a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f698a = new HashMap(m481a.f786a * 2);
                        for (int i2 = 0; i2 < m481a.f786a; i2++) {
                            this.f698a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 11) {
                        this.f705g = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 12:
                    if (m479a.a == 11) {
                        this.f706h = jiVar.m484a();
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

    public void a(boolean z) {
        this.f697a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a() {
        return this.f696a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m450a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m449a = m449a();
        boolean m449a2 = ipVar.m449a();
        if ((m449a || m449a2) && !(m449a && m449a2 && this.f696a.equals(ipVar.f696a))) {
            return false;
        }
        boolean m451b = m451b();
        boolean m451b2 = ipVar.m451b();
        if ((m451b || m451b2) && !(m451b && m451b2 && this.f695a.m392a(ipVar.f695a))) {
            return false;
        }
        boolean m452c = m452c();
        boolean m452c2 = ipVar.m452c();
        if ((m452c || m452c2) && !(m452c && m452c2 && this.f700b.equals(ipVar.f700b))) {
            return false;
        }
        boolean m453d = m453d();
        boolean m453d2 = ipVar.m453d();
        if ((m453d || m453d2) && !(m453d && m453d2 && this.f701c.equals(ipVar.f701c))) {
            return false;
        }
        boolean m454e = m454e();
        boolean m454e2 = ipVar.m454e();
        if ((m454e || m454e2) && !(m454e && m454e2 && this.f702d.equals(ipVar.f702d))) {
            return false;
        }
        boolean m455f = m455f();
        boolean m455f2 = ipVar.m455f();
        if ((m455f || m455f2) && !(m455f && m455f2 && this.f703e.equals(ipVar.f703e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f704f.equals(ipVar.f704f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f694a.m366a(ipVar.f694a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f699a == ipVar.f699a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f698a.equals(ipVar.f698a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f705g.equals(ipVar.f705g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f706h.equals(ipVar.f706h));
    }

    public String b() {
        return this.f701c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m448a();
        jiVar.a(f693a);
        if (this.f696a != null && m449a()) {
            jiVar.a(a);
            jiVar.a(this.f696a);
            jiVar.b();
        }
        if (this.f695a != null && m451b()) {
            jiVar.a(b);
            this.f695a.b(jiVar);
            jiVar.b();
        }
        if (this.f700b != null) {
            jiVar.a(c);
            jiVar.a(this.f700b);
            jiVar.b();
        }
        if (this.f701c != null) {
            jiVar.a(d);
            jiVar.a(this.f701c);
            jiVar.b();
        }
        if (this.f702d != null && m454e()) {
            jiVar.a(e);
            jiVar.a(this.f702d);
            jiVar.b();
        }
        if (this.f703e != null && m455f()) {
            jiVar.a(f);
            jiVar.a(this.f703e);
            jiVar.b();
        }
        if (this.f704f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f704f);
            jiVar.b();
        }
        if (this.f694a != null && h()) {
            jiVar.a(h);
            this.f694a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f699a);
            jiVar.b();
        }
        if (this.f698a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f698a.size()));
            for (Map.Entry<String, String> entry : this.f698a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f705g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f705g);
            jiVar.b();
        }
        if (this.f706h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f706h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m451b() {
        return this.f695a != null;
    }

    public String c() {
        return this.f703e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m452c() {
        return this.f700b != null;
    }

    public String d() {
        return this.f704f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m453d() {
        return this.f701c != null;
    }

    public String e() {
        return this.f705g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m454e() {
        return this.f702d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m450a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f706h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m455f() {
        return this.f703e != null;
    }

    public boolean g() {
        return this.f704f != null;
    }

    public boolean h() {
        return this.f694a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f697a.get(0);
    }

    public boolean j() {
        return this.f698a != null;
    }

    public boolean k() {
        return this.f705g != null;
    }

    public boolean l() {
        return this.f706h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m449a()) {
            sb.append("debug:");
            if (this.f696a == null) {
                sb.append("null");
            } else {
                sb.append(this.f696a);
            }
            z2 = false;
        }
        if (m451b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f695a == null) {
                sb.append("null");
            } else {
                sb.append(this.f695a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f700b == null) {
            sb.append("null");
        } else {
            sb.append(this.f700b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f701c == null) {
            sb.append("null");
        } else {
            sb.append(this.f701c);
        }
        if (m454e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f702d == null) {
                sb.append("null");
            } else {
                sb.append(this.f702d);
            }
        }
        if (m455f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f703e == null) {
                sb.append("null");
            } else {
                sb.append(this.f703e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f704f == null) {
                sb.append("null");
            } else {
                sb.append(this.f704f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f694a == null) {
                sb.append("null");
            } else {
                sb.append(this.f694a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f699a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f698a == null) {
                sb.append("null");
            } else {
                sb.append(this.f698a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f705g == null) {
                sb.append("null");
            } else {
                sb.append(this.f705g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f706h == null) {
                sb.append("null");
            } else {
                sb.append(this.f706h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
