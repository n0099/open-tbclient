package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f691a;

    /* renamed from: a  reason: collision with other field name */
    public ib f692a;

    /* renamed from: a  reason: collision with other field name */
    public String f693a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f695a;

    /* renamed from: b  reason: collision with other field name */
    public String f697b;

    /* renamed from: c  reason: collision with other field name */
    public String f698c;

    /* renamed from: d  reason: collision with other field name */
    public String f699d;

    /* renamed from: e  reason: collision with other field name */
    public String f700e;

    /* renamed from: f  reason: collision with other field name */
    public String f701f;

    /* renamed from: g  reason: collision with other field name */
    public String f702g;

    /* renamed from: h  reason: collision with other field name */
    public String f703h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f690a = new jn("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4985a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f694a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f696a = true;

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
            int compareTo = Boolean.valueOf(m458a()).compareTo(Boolean.valueOf(ipVar.m458a()));
            if (compareTo == 0) {
                if (!m458a() || (a13 = iy.a(this.f693a, ipVar.f693a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m460b()).compareTo(Boolean.valueOf(ipVar.m460b()));
                    if (compareTo2 == 0) {
                        if (!m460b() || (a12 = iy.a(this.f692a, ipVar.f692a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m461c()).compareTo(Boolean.valueOf(ipVar.m461c()));
                            if (compareTo3 == 0) {
                                if (!m461c() || (a11 = iy.a(this.f697b, ipVar.f697b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m462d()).compareTo(Boolean.valueOf(ipVar.m462d()));
                                    if (compareTo4 == 0) {
                                        if (!m462d() || (a10 = iy.a(this.f698c, ipVar.f698c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m463e()).compareTo(Boolean.valueOf(ipVar.m463e()));
                                            if (compareTo5 == 0) {
                                                if (!m463e() || (a9 = iy.a(this.f699d, ipVar.f699d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m464f()).compareTo(Boolean.valueOf(ipVar.m464f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m464f() || (a8 = iy.a(this.f700e, ipVar.f700e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f701f, ipVar.f701f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f691a, ipVar.f691a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f696a, ipVar.f696a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f695a, ipVar.f695a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f702g, ipVar.f702g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f703h, ipVar.f703h)) == 0) {
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
        return this.f691a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m456a() {
        return this.f697b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m457a() {
        if (this.f697b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f698c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m457a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f693a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f692a = new ib();
                        this.f692a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f697b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f698c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f699d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 11) {
                        this.f700e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f701f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 12) {
                        this.f691a = new hy();
                        this.f691a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 2) {
                        this.f696a = jiVar.m497a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f695a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f695a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 11) {
                        this.f702g = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 12:
                    if (m488a.f5000a == 11) {
                        this.f703h = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f694a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m458a() {
        return this.f693a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m458a = m458a();
        boolean m458a2 = ipVar.m458a();
        if ((m458a || m458a2) && !(m458a && m458a2 && this.f693a.equals(ipVar.f693a))) {
            return false;
        }
        boolean m460b = m460b();
        boolean m460b2 = ipVar.m460b();
        if ((m460b || m460b2) && !(m460b && m460b2 && this.f692a.m401a(ipVar.f692a))) {
            return false;
        }
        boolean m461c = m461c();
        boolean m461c2 = ipVar.m461c();
        if ((m461c || m461c2) && !(m461c && m461c2 && this.f697b.equals(ipVar.f697b))) {
            return false;
        }
        boolean m462d = m462d();
        boolean m462d2 = ipVar.m462d();
        if ((m462d || m462d2) && !(m462d && m462d2 && this.f698c.equals(ipVar.f698c))) {
            return false;
        }
        boolean m463e = m463e();
        boolean m463e2 = ipVar.m463e();
        if ((m463e || m463e2) && !(m463e && m463e2 && this.f699d.equals(ipVar.f699d))) {
            return false;
        }
        boolean m464f = m464f();
        boolean m464f2 = ipVar.m464f();
        if ((m464f || m464f2) && !(m464f && m464f2 && this.f700e.equals(ipVar.f700e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f701f.equals(ipVar.f701f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f691a.m375a(ipVar.f691a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f696a == ipVar.f696a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f695a.equals(ipVar.f695a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f702g.equals(ipVar.f702g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f703h.equals(ipVar.f703h));
    }

    public String b() {
        return this.f698c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m457a();
        jiVar.a(f690a);
        if (this.f693a != null && m458a()) {
            jiVar.a(f4985a);
            jiVar.a(this.f693a);
            jiVar.b();
        }
        if (this.f692a != null && m460b()) {
            jiVar.a(b);
            this.f692a.b(jiVar);
            jiVar.b();
        }
        if (this.f697b != null) {
            jiVar.a(c);
            jiVar.a(this.f697b);
            jiVar.b();
        }
        if (this.f698c != null) {
            jiVar.a(d);
            jiVar.a(this.f698c);
            jiVar.b();
        }
        if (this.f699d != null && m463e()) {
            jiVar.a(e);
            jiVar.a(this.f699d);
            jiVar.b();
        }
        if (this.f700e != null && m464f()) {
            jiVar.a(f);
            jiVar.a(this.f700e);
            jiVar.b();
        }
        if (this.f701f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f701f);
            jiVar.b();
        }
        if (this.f691a != null && h()) {
            jiVar.a(h);
            this.f691a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f696a);
            jiVar.b();
        }
        if (this.f695a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f695a.size()));
            for (Map.Entry<String, String> entry : this.f695a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f702g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f702g);
            jiVar.b();
        }
        if (this.f703h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f703h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m460b() {
        return this.f692a != null;
    }

    public String c() {
        return this.f700e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m461c() {
        return this.f697b != null;
    }

    public String d() {
        return this.f701f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m462d() {
        return this.f698c != null;
    }

    public String e() {
        return this.f702g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m463e() {
        return this.f699d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m459a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f703h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m464f() {
        return this.f700e != null;
    }

    public boolean g() {
        return this.f701f != null;
    }

    public boolean h() {
        return this.f691a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f694a.get(0);
    }

    public boolean j() {
        return this.f695a != null;
    }

    public boolean k() {
        return this.f702g != null;
    }

    public boolean l() {
        return this.f703h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m458a()) {
            sb.append("debug:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
            z2 = false;
        }
        if (m460b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f692a == null) {
                sb.append("null");
            } else {
                sb.append(this.f692a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f697b == null) {
            sb.append("null");
        } else {
            sb.append(this.f697b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f698c == null) {
            sb.append("null");
        } else {
            sb.append(this.f698c);
        }
        if (m463e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f699d == null) {
                sb.append("null");
            } else {
                sb.append(this.f699d);
            }
        }
        if (m464f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f700e == null) {
                sb.append("null");
            } else {
                sb.append(this.f700e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f701f == null) {
                sb.append("null");
            } else {
                sb.append(this.f701f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f691a == null) {
                sb.append("null");
            } else {
                sb.append(this.f691a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f696a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f695a == null) {
                sb.append("null");
            } else {
                sb.append(this.f695a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f702g == null) {
                sb.append("null");
            } else {
                sb.append(this.f702g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f703h == null) {
                sb.append("null");
            } else {
                sb.append(this.f703h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
