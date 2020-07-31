package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f690a;

    /* renamed from: a  reason: collision with other field name */
    public ib f691a;

    /* renamed from: a  reason: collision with other field name */
    public String f692a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f694a;

    /* renamed from: b  reason: collision with other field name */
    public String f696b;

    /* renamed from: c  reason: collision with other field name */
    public String f697c;

    /* renamed from: d  reason: collision with other field name */
    public String f698d;

    /* renamed from: e  reason: collision with other field name */
    public String f699e;

    /* renamed from: f  reason: collision with other field name */
    public String f700f;

    /* renamed from: g  reason: collision with other field name */
    public String f701g;

    /* renamed from: h  reason: collision with other field name */
    public String f702h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f689a = new jn("XmPushActionSendMessage");
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
    private BitSet f693a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f695a = true;

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
            int compareTo = Boolean.valueOf(m450a()).compareTo(Boolean.valueOf(ipVar.m450a()));
            if (compareTo == 0) {
                if (!m450a() || (a13 = iy.a(this.f692a, ipVar.f692a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m452b()).compareTo(Boolean.valueOf(ipVar.m452b()));
                    if (compareTo2 == 0) {
                        if (!m452b() || (a12 = iy.a(this.f691a, ipVar.f691a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m453c()).compareTo(Boolean.valueOf(ipVar.m453c()));
                            if (compareTo3 == 0) {
                                if (!m453c() || (a11 = iy.a(this.f696b, ipVar.f696b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m454d()).compareTo(Boolean.valueOf(ipVar.m454d()));
                                    if (compareTo4 == 0) {
                                        if (!m454d() || (a10 = iy.a(this.f697c, ipVar.f697c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m455e()).compareTo(Boolean.valueOf(ipVar.m455e()));
                                            if (compareTo5 == 0) {
                                                if (!m455e() || (a9 = iy.a(this.f698d, ipVar.f698d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m456f()).compareTo(Boolean.valueOf(ipVar.m456f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m456f() || (a8 = iy.a(this.f699e, ipVar.f699e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f700f, ipVar.f700f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f690a, ipVar.f690a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f695a, ipVar.f695a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f694a, ipVar.f694a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f701g, ipVar.f701g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f702h, ipVar.f702h)) == 0) {
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
        return this.f690a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m448a() {
        return this.f696b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m449a() {
        if (this.f696b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f697c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m449a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a == 11) {
                        this.f692a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 2:
                    if (m480a.a == 12) {
                        this.f691a = new ib();
                        this.f691a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 11) {
                        this.f696b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 4:
                    if (m480a.a == 11) {
                        this.f697c = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 5:
                    if (m480a.a == 11) {
                        this.f698d = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 6:
                    if (m480a.a == 11) {
                        this.f699e = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 7:
                    if (m480a.a == 11) {
                        this.f700f = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 8:
                    if (m480a.a == 12) {
                        this.f690a = new hy();
                        this.f690a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 9:
                    if (m480a.a == 2) {
                        this.f695a = jiVar.m489a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 10:
                    if (m480a.a == 13) {
                        jh m482a = jiVar.m482a();
                        this.f694a = new HashMap(m482a.f782a * 2);
                        for (int i2 = 0; i2 < m482a.f782a; i2++) {
                            this.f694a.put(jiVar.m485a(), jiVar.m485a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 11:
                    if (m480a.a == 11) {
                        this.f701g = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 12:
                    if (m480a.a == 11) {
                        this.f702h = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f693a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m450a() {
        return this.f692a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m450a = m450a();
        boolean m450a2 = ipVar.m450a();
        if ((m450a || m450a2) && !(m450a && m450a2 && this.f692a.equals(ipVar.f692a))) {
            return false;
        }
        boolean m452b = m452b();
        boolean m452b2 = ipVar.m452b();
        if ((m452b || m452b2) && !(m452b && m452b2 && this.f691a.m393a(ipVar.f691a))) {
            return false;
        }
        boolean m453c = m453c();
        boolean m453c2 = ipVar.m453c();
        if ((m453c || m453c2) && !(m453c && m453c2 && this.f696b.equals(ipVar.f696b))) {
            return false;
        }
        boolean m454d = m454d();
        boolean m454d2 = ipVar.m454d();
        if ((m454d || m454d2) && !(m454d && m454d2 && this.f697c.equals(ipVar.f697c))) {
            return false;
        }
        boolean m455e = m455e();
        boolean m455e2 = ipVar.m455e();
        if ((m455e || m455e2) && !(m455e && m455e2 && this.f698d.equals(ipVar.f698d))) {
            return false;
        }
        boolean m456f = m456f();
        boolean m456f2 = ipVar.m456f();
        if ((m456f || m456f2) && !(m456f && m456f2 && this.f699e.equals(ipVar.f699e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f700f.equals(ipVar.f700f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f690a.m367a(ipVar.f690a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f695a == ipVar.f695a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f694a.equals(ipVar.f694a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f701g.equals(ipVar.f701g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f702h.equals(ipVar.f702h));
    }

    public String b() {
        return this.f697c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m449a();
        jiVar.a(f689a);
        if (this.f692a != null && m450a()) {
            jiVar.a(a);
            jiVar.a(this.f692a);
            jiVar.b();
        }
        if (this.f691a != null && m452b()) {
            jiVar.a(b);
            this.f691a.b(jiVar);
            jiVar.b();
        }
        if (this.f696b != null) {
            jiVar.a(c);
            jiVar.a(this.f696b);
            jiVar.b();
        }
        if (this.f697c != null) {
            jiVar.a(d);
            jiVar.a(this.f697c);
            jiVar.b();
        }
        if (this.f698d != null && m455e()) {
            jiVar.a(e);
            jiVar.a(this.f698d);
            jiVar.b();
        }
        if (this.f699e != null && m456f()) {
            jiVar.a(f);
            jiVar.a(this.f699e);
            jiVar.b();
        }
        if (this.f700f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f700f);
            jiVar.b();
        }
        if (this.f690a != null && h()) {
            jiVar.a(h);
            this.f690a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f695a);
            jiVar.b();
        }
        if (this.f694a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f694a.size()));
            for (Map.Entry<String, String> entry : this.f694a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f701g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f701g);
            jiVar.b();
        }
        if (this.f702h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f702h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m452b() {
        return this.f691a != null;
    }

    public String c() {
        return this.f699e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m453c() {
        return this.f696b != null;
    }

    public String d() {
        return this.f700f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m454d() {
        return this.f697c != null;
    }

    public String e() {
        return this.f701g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m455e() {
        return this.f698d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m451a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f702h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m456f() {
        return this.f699e != null;
    }

    public boolean g() {
        return this.f700f != null;
    }

    public boolean h() {
        return this.f690a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f693a.get(0);
    }

    public boolean j() {
        return this.f694a != null;
    }

    public boolean k() {
        return this.f701g != null;
    }

    public boolean l() {
        return this.f702h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m450a()) {
            sb.append("debug:");
            if (this.f692a == null) {
                sb.append("null");
            } else {
                sb.append(this.f692a);
            }
            z2 = false;
        }
        if (m452b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f691a == null) {
                sb.append("null");
            } else {
                sb.append(this.f691a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f696b == null) {
            sb.append("null");
        } else {
            sb.append(this.f696b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f697c == null) {
            sb.append("null");
        } else {
            sb.append(this.f697c);
        }
        if (m455e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f698d == null) {
                sb.append("null");
            } else {
                sb.append(this.f698d);
            }
        }
        if (m456f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f699e == null) {
                sb.append("null");
            } else {
                sb.append(this.f699e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f700f == null) {
                sb.append("null");
            } else {
                sb.append(this.f700f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f690a == null) {
                sb.append("null");
            } else {
                sb.append(this.f690a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f695a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f694a == null) {
                sb.append("null");
            } else {
                sb.append(this.f694a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f701g == null) {
                sb.append("null");
            } else {
                sb.append(this.f701g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f702h == null) {
                sb.append("null");
            } else {
                sb.append(this.f702h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
