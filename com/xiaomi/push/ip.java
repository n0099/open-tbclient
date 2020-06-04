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
    public hy f687a;

    /* renamed from: a  reason: collision with other field name */
    public ib f688a;

    /* renamed from: a  reason: collision with other field name */
    public String f689a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f691a;

    /* renamed from: b  reason: collision with other field name */
    public String f693b;

    /* renamed from: c  reason: collision with other field name */
    public String f694c;

    /* renamed from: d  reason: collision with other field name */
    public String f695d;

    /* renamed from: e  reason: collision with other field name */
    public String f696e;

    /* renamed from: f  reason: collision with other field name */
    public String f697f;

    /* renamed from: g  reason: collision with other field name */
    public String f698g;

    /* renamed from: h  reason: collision with other field name */
    public String f699h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f686a = new jn("XmPushActionSendMessage");
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
    private BitSet f690a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f692a = true;

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
            int compareTo = Boolean.valueOf(m452a()).compareTo(Boolean.valueOf(ipVar.m452a()));
            if (compareTo == 0) {
                if (!m452a() || (a13 = iy.a(this.f689a, ipVar.f689a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m454b()).compareTo(Boolean.valueOf(ipVar.m454b()));
                    if (compareTo2 == 0) {
                        if (!m454b() || (a12 = iy.a(this.f688a, ipVar.f688a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m455c()).compareTo(Boolean.valueOf(ipVar.m455c()));
                            if (compareTo3 == 0) {
                                if (!m455c() || (a11 = iy.a(this.f693b, ipVar.f693b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m456d()).compareTo(Boolean.valueOf(ipVar.m456d()));
                                    if (compareTo4 == 0) {
                                        if (!m456d() || (a10 = iy.a(this.f694c, ipVar.f694c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m457e()).compareTo(Boolean.valueOf(ipVar.m457e()));
                                            if (compareTo5 == 0) {
                                                if (!m457e() || (a9 = iy.a(this.f695d, ipVar.f695d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m458f()).compareTo(Boolean.valueOf(ipVar.m458f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m458f() || (a8 = iy.a(this.f696e, ipVar.f696e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f697f, ipVar.f697f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f687a, ipVar.f687a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f692a, ipVar.f692a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f691a, ipVar.f691a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f698g, ipVar.f698g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f699h, ipVar.f699h)) == 0) {
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
        return this.f687a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m450a() {
        return this.f693b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m451a() {
        if (this.f693b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f694c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m486a();
        while (true) {
            jf m482a = jiVar.m482a();
            if (m482a.a == 0) {
                jiVar.f();
                m451a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a == 11) {
                        this.f689a = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 2:
                    if (m482a.a == 12) {
                        this.f688a = new ib();
                        this.f688a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 3:
                    if (m482a.a == 11) {
                        this.f693b = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 4:
                    if (m482a.a == 11) {
                        this.f694c = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 5:
                    if (m482a.a == 11) {
                        this.f695d = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 6:
                    if (m482a.a == 11) {
                        this.f696e = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 7:
                    if (m482a.a == 11) {
                        this.f697f = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 8:
                    if (m482a.a == 12) {
                        this.f687a = new hy();
                        this.f687a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 9:
                    if (m482a.a == 2) {
                        this.f692a = jiVar.m491a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 10:
                    if (m482a.a == 13) {
                        jh m484a = jiVar.m484a();
                        this.f691a = new HashMap(m484a.f779a * 2);
                        for (int i2 = 0; i2 < m484a.f779a; i2++) {
                            this.f691a.put(jiVar.m487a(), jiVar.m487a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 11:
                    if (m482a.a == 11) {
                        this.f698g = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 12:
                    if (m482a.a == 11) {
                        this.f699h = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m482a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f690a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a() {
        return this.f689a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m453a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m452a = m452a();
        boolean m452a2 = ipVar.m452a();
        if ((m452a || m452a2) && !(m452a && m452a2 && this.f689a.equals(ipVar.f689a))) {
            return false;
        }
        boolean m454b = m454b();
        boolean m454b2 = ipVar.m454b();
        if ((m454b || m454b2) && !(m454b && m454b2 && this.f688a.m395a(ipVar.f688a))) {
            return false;
        }
        boolean m455c = m455c();
        boolean m455c2 = ipVar.m455c();
        if ((m455c || m455c2) && !(m455c && m455c2 && this.f693b.equals(ipVar.f693b))) {
            return false;
        }
        boolean m456d = m456d();
        boolean m456d2 = ipVar.m456d();
        if ((m456d || m456d2) && !(m456d && m456d2 && this.f694c.equals(ipVar.f694c))) {
            return false;
        }
        boolean m457e = m457e();
        boolean m457e2 = ipVar.m457e();
        if ((m457e || m457e2) && !(m457e && m457e2 && this.f695d.equals(ipVar.f695d))) {
            return false;
        }
        boolean m458f = m458f();
        boolean m458f2 = ipVar.m458f();
        if ((m458f || m458f2) && !(m458f && m458f2 && this.f696e.equals(ipVar.f696e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f697f.equals(ipVar.f697f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f687a.m369a(ipVar.f687a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f692a == ipVar.f692a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f691a.equals(ipVar.f691a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f698g.equals(ipVar.f698g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f699h.equals(ipVar.f699h));
    }

    public String b() {
        return this.f694c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m451a();
        jiVar.a(f686a);
        if (this.f689a != null && m452a()) {
            jiVar.a(a);
            jiVar.a(this.f689a);
            jiVar.b();
        }
        if (this.f688a != null && m454b()) {
            jiVar.a(b);
            this.f688a.b(jiVar);
            jiVar.b();
        }
        if (this.f693b != null) {
            jiVar.a(c);
            jiVar.a(this.f693b);
            jiVar.b();
        }
        if (this.f694c != null) {
            jiVar.a(d);
            jiVar.a(this.f694c);
            jiVar.b();
        }
        if (this.f695d != null && m457e()) {
            jiVar.a(e);
            jiVar.a(this.f695d);
            jiVar.b();
        }
        if (this.f696e != null && m458f()) {
            jiVar.a(f);
            jiVar.a(this.f696e);
            jiVar.b();
        }
        if (this.f697f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f697f);
            jiVar.b();
        }
        if (this.f687a != null && h()) {
            jiVar.a(h);
            this.f687a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f692a);
            jiVar.b();
        }
        if (this.f691a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f691a.size()));
            for (Map.Entry<String, String> entry : this.f691a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f698g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f698g);
            jiVar.b();
        }
        if (this.f699h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f699h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m490a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m454b() {
        return this.f688a != null;
    }

    public String c() {
        return this.f696e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m455c() {
        return this.f693b != null;
    }

    public String d() {
        return this.f697f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m456d() {
        return this.f694c != null;
    }

    public String e() {
        return this.f698g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m457e() {
        return this.f695d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m453a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f699h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m458f() {
        return this.f696e != null;
    }

    public boolean g() {
        return this.f697f != null;
    }

    public boolean h() {
        return this.f687a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f690a.get(0);
    }

    public boolean j() {
        return this.f691a != null;
    }

    public boolean k() {
        return this.f698g != null;
    }

    public boolean l() {
        return this.f699h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m452a()) {
            sb.append("debug:");
            if (this.f689a == null) {
                sb.append("null");
            } else {
                sb.append(this.f689a);
            }
            z2 = false;
        }
        if (m454b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f688a == null) {
                sb.append("null");
            } else {
                sb.append(this.f688a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f693b == null) {
            sb.append("null");
        } else {
            sb.append(this.f693b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f694c == null) {
            sb.append("null");
        } else {
            sb.append(this.f694c);
        }
        if (m457e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f695d == null) {
                sb.append("null");
            } else {
                sb.append(this.f695d);
            }
        }
        if (m458f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f696e == null) {
                sb.append("null");
            } else {
                sb.append(this.f696e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f697f == null) {
                sb.append("null");
            } else {
                sb.append(this.f697f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f687a == null) {
                sb.append("null");
            } else {
                sb.append(this.f687a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f692a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f691a == null) {
                sb.append("null");
            } else {
                sb.append(this.f691a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f698g == null) {
                sb.append("null");
            } else {
                sb.append(this.f698g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f699h == null) {
                sb.append("null");
            } else {
                sb.append(this.f699h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
