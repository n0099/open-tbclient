package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f689a;

    /* renamed from: a  reason: collision with other field name */
    public ib f690a;

    /* renamed from: a  reason: collision with other field name */
    public String f691a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f693a;

    /* renamed from: b  reason: collision with other field name */
    public String f695b;

    /* renamed from: c  reason: collision with other field name */
    public String f696c;

    /* renamed from: d  reason: collision with other field name */
    public String f697d;

    /* renamed from: e  reason: collision with other field name */
    public String f698e;

    /* renamed from: f  reason: collision with other field name */
    public String f699f;

    /* renamed from: g  reason: collision with other field name */
    public String f700g;

    /* renamed from: h  reason: collision with other field name */
    public String f701h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f688a = new jn("XmPushActionSendMessage");

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
    private BitSet f692a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f694a = true;

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
            int compareTo = Boolean.valueOf(m456a()).compareTo(Boolean.valueOf(ipVar.m456a()));
            if (compareTo == 0) {
                if (!m456a() || (a13 = iy.a(this.f691a, ipVar.f691a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m458b()).compareTo(Boolean.valueOf(ipVar.m458b()));
                    if (compareTo2 == 0) {
                        if (!m458b() || (a12 = iy.a(this.f690a, ipVar.f690a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m459c()).compareTo(Boolean.valueOf(ipVar.m459c()));
                            if (compareTo3 == 0) {
                                if (!m459c() || (a11 = iy.a(this.f695b, ipVar.f695b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m460d()).compareTo(Boolean.valueOf(ipVar.m460d()));
                                    if (compareTo4 == 0) {
                                        if (!m460d() || (a10 = iy.a(this.f696c, ipVar.f696c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m461e()).compareTo(Boolean.valueOf(ipVar.m461e()));
                                            if (compareTo5 == 0) {
                                                if (!m461e() || (a9 = iy.a(this.f697d, ipVar.f697d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m462f()).compareTo(Boolean.valueOf(ipVar.m462f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m462f() || (a8 = iy.a(this.f698e, ipVar.f698e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f699f, ipVar.f699f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f689a, ipVar.f689a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f694a, ipVar.f694a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f693a, ipVar.f693a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f700g, ipVar.f700g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f701h, ipVar.f701h)) == 0) {
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
        return this.f689a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m454a() {
        return this.f695b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m455a() {
        if (this.f695b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f696c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m455a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 11) {
                        this.f691a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 2:
                    if (m486a.f5000a == 12) {
                        this.f690a = new ib();
                        this.f690a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 3:
                    if (m486a.f5000a == 11) {
                        this.f695b = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 4:
                    if (m486a.f5000a == 11) {
                        this.f696c = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 5:
                    if (m486a.f5000a == 11) {
                        this.f697d = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 6:
                    if (m486a.f5000a == 11) {
                        this.f698e = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 7:
                    if (m486a.f5000a == 11) {
                        this.f699f = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 8:
                    if (m486a.f5000a == 12) {
                        this.f689a = new hy();
                        this.f689a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 9:
                    if (m486a.f5000a == 2) {
                        this.f694a = jiVar.m495a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 10:
                    if (m486a.f5000a == 13) {
                        jh m488a = jiVar.m488a();
                        this.f693a = new HashMap(m488a.f781a * 2);
                        for (int i2 = 0; i2 < m488a.f781a; i2++) {
                            this.f693a.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 11:
                    if (m486a.f5000a == 11) {
                        this.f700g = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 12:
                    if (m486a.f5000a == 11) {
                        this.f701h = jiVar.m491a();
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

    public void a(boolean z) {
        this.f692a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a() {
        return this.f691a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m456a = m456a();
        boolean m456a2 = ipVar.m456a();
        if ((m456a || m456a2) && !(m456a && m456a2 && this.f691a.equals(ipVar.f691a))) {
            return false;
        }
        boolean m458b = m458b();
        boolean m458b2 = ipVar.m458b();
        if ((m458b || m458b2) && !(m458b && m458b2 && this.f690a.m399a(ipVar.f690a))) {
            return false;
        }
        boolean m459c = m459c();
        boolean m459c2 = ipVar.m459c();
        if ((m459c || m459c2) && !(m459c && m459c2 && this.f695b.equals(ipVar.f695b))) {
            return false;
        }
        boolean m460d = m460d();
        boolean m460d2 = ipVar.m460d();
        if ((m460d || m460d2) && !(m460d && m460d2 && this.f696c.equals(ipVar.f696c))) {
            return false;
        }
        boolean m461e = m461e();
        boolean m461e2 = ipVar.m461e();
        if ((m461e || m461e2) && !(m461e && m461e2 && this.f697d.equals(ipVar.f697d))) {
            return false;
        }
        boolean m462f = m462f();
        boolean m462f2 = ipVar.m462f();
        if ((m462f || m462f2) && !(m462f && m462f2 && this.f698e.equals(ipVar.f698e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f699f.equals(ipVar.f699f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f689a.m373a(ipVar.f689a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f694a == ipVar.f694a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f693a.equals(ipVar.f693a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f700g.equals(ipVar.f700g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f701h.equals(ipVar.f701h));
    }

    public String b() {
        return this.f696c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m455a();
        jiVar.a(f688a);
        if (this.f691a != null && m456a()) {
            jiVar.a(f4985a);
            jiVar.a(this.f691a);
            jiVar.b();
        }
        if (this.f690a != null && m458b()) {
            jiVar.a(b);
            this.f690a.b(jiVar);
            jiVar.b();
        }
        if (this.f695b != null) {
            jiVar.a(c);
            jiVar.a(this.f695b);
            jiVar.b();
        }
        if (this.f696c != null) {
            jiVar.a(d);
            jiVar.a(this.f696c);
            jiVar.b();
        }
        if (this.f697d != null && m461e()) {
            jiVar.a(e);
            jiVar.a(this.f697d);
            jiVar.b();
        }
        if (this.f698e != null && m462f()) {
            jiVar.a(f);
            jiVar.a(this.f698e);
            jiVar.b();
        }
        if (this.f699f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f699f);
            jiVar.b();
        }
        if (this.f689a != null && h()) {
            jiVar.a(h);
            this.f689a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f694a);
            jiVar.b();
        }
        if (this.f693a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f693a.size()));
            for (Map.Entry<String, String> entry : this.f693a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f700g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f700g);
            jiVar.b();
        }
        if (this.f701h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f701h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m458b() {
        return this.f690a != null;
    }

    public String c() {
        return this.f698e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m459c() {
        return this.f695b != null;
    }

    public String d() {
        return this.f699f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m460d() {
        return this.f696c != null;
    }

    public String e() {
        return this.f700g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m461e() {
        return this.f697d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m457a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f701h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m462f() {
        return this.f698e != null;
    }

    public boolean g() {
        return this.f699f != null;
    }

    public boolean h() {
        return this.f689a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f692a.get(0);
    }

    public boolean j() {
        return this.f693a != null;
    }

    public boolean k() {
        return this.f700g != null;
    }

    public boolean l() {
        return this.f701h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m456a()) {
            sb.append("debug:");
            if (this.f691a == null) {
                sb.append("null");
            } else {
                sb.append(this.f691a);
            }
            z2 = false;
        }
        if (m458b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f690a == null) {
                sb.append("null");
            } else {
                sb.append(this.f690a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f695b == null) {
            sb.append("null");
        } else {
            sb.append(this.f695b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f696c == null) {
            sb.append("null");
        } else {
            sb.append(this.f696c);
        }
        if (m461e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f697d == null) {
                sb.append("null");
            } else {
                sb.append(this.f697d);
            }
        }
        if (m462f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f698e == null) {
                sb.append("null");
            } else {
                sb.append(this.f698e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f699f == null) {
                sb.append("null");
            } else {
                sb.append(this.f699f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f689a == null) {
                sb.append("null");
            } else {
                sb.append(this.f689a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f694a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f700g == null) {
                sb.append("null");
            } else {
                sb.append(this.f700g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f701h == null) {
                sb.append("null");
            } else {
                sb.append(this.f701h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
