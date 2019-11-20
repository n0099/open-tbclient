package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ij implements ir<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hs f700a;

    /* renamed from: a  reason: collision with other field name */
    public hv f701a;

    /* renamed from: a  reason: collision with other field name */
    public String f702a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f704a;

    /* renamed from: b  reason: collision with other field name */
    public String f706b;

    /* renamed from: c  reason: collision with other field name */
    public String f707c;

    /* renamed from: d  reason: collision with other field name */
    public String f708d;

    /* renamed from: e  reason: collision with other field name */
    public String f709e;

    /* renamed from: f  reason: collision with other field name */
    public String f710f;

    /* renamed from: g  reason: collision with other field name */
    public String f711g;

    /* renamed from: h  reason: collision with other field name */
    public String f712h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f699a = new jh("XmPushActionSendMessage");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 12, 8);
    private static final iz i = new iz("", (byte) 2, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 11);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f703a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f705a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
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
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m421a()).compareTo(Boolean.valueOf(ijVar.m421a()));
            if (compareTo == 0) {
                if (!m421a() || (a13 = is.a(this.f702a, ijVar.f702a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m423b()).compareTo(Boolean.valueOf(ijVar.m423b()));
                    if (compareTo2 == 0) {
                        if (!m423b() || (a12 = is.a(this.f701a, ijVar.f701a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m424c()).compareTo(Boolean.valueOf(ijVar.m424c()));
                            if (compareTo3 == 0) {
                                if (!m424c() || (a11 = is.a(this.f706b, ijVar.f706b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m425d()).compareTo(Boolean.valueOf(ijVar.m425d()));
                                    if (compareTo4 == 0) {
                                        if (!m425d() || (a10 = is.a(this.f707c, ijVar.f707c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m426e()).compareTo(Boolean.valueOf(ijVar.m426e()));
                                            if (compareTo5 == 0) {
                                                if (!m426e() || (a9 = is.a(this.f708d, ijVar.f708d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m427f()).compareTo(Boolean.valueOf(ijVar.m427f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m427f() || (a8 = is.a(this.f709e, ijVar.f709e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f710f, ijVar.f710f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f700a, ijVar.f700a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f705a, ijVar.f705a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f704a, ijVar.f704a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f711g, ijVar.f711g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f712h, ijVar.f712h)) == 0) {
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
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public hs a() {
        return this.f700a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m419a() {
        return this.f706b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m420a() {
        if (this.f706b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f707c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                m420a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 11) {
                        this.f702a = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 2:
                    if (m451a.a == 12) {
                        this.f701a = new hv();
                        this.f701a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 3:
                    if (m451a.a == 11) {
                        this.f706b = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 4:
                    if (m451a.a == 11) {
                        this.f707c = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 5:
                    if (m451a.a == 11) {
                        this.f708d = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 6:
                    if (m451a.a == 11) {
                        this.f709e = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 7:
                    if (m451a.a == 11) {
                        this.f710f = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 8:
                    if (m451a.a == 12) {
                        this.f700a = new hs();
                        this.f700a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 9:
                    if (m451a.a == 2) {
                        this.f705a = jcVar.m460a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 10:
                    if (m451a.a == 13) {
                        jb m453a = jcVar.m453a();
                        this.f704a = new HashMap(m453a.f792a * 2);
                        for (int i2 = 0; i2 < m453a.f792a; i2++) {
                            this.f704a.put(jcVar.m456a(), jcVar.m456a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 11:
                    if (m451a.a == 11) {
                        this.f711g = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 12:
                    if (m451a.a == 11) {
                        this.f712h = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f703a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a() {
        return this.f702a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m422a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m421a = m421a();
        boolean m421a2 = ijVar.m421a();
        if ((m421a || m421a2) && !(m421a && m421a2 && this.f702a.equals(ijVar.f702a))) {
            return false;
        }
        boolean m423b = m423b();
        boolean m423b2 = ijVar.m423b();
        if ((m423b || m423b2) && !(m423b && m423b2 && this.f701a.m361a(ijVar.f701a))) {
            return false;
        }
        boolean m424c = m424c();
        boolean m424c2 = ijVar.m424c();
        if ((m424c || m424c2) && !(m424c && m424c2 && this.f706b.equals(ijVar.f706b))) {
            return false;
        }
        boolean m425d = m425d();
        boolean m425d2 = ijVar.m425d();
        if ((m425d || m425d2) && !(m425d && m425d2 && this.f707c.equals(ijVar.f707c))) {
            return false;
        }
        boolean m426e = m426e();
        boolean m426e2 = ijVar.m426e();
        if ((m426e || m426e2) && !(m426e && m426e2 && this.f708d.equals(ijVar.f708d))) {
            return false;
        }
        boolean m427f = m427f();
        boolean m427f2 = ijVar.m427f();
        if ((m427f || m427f2) && !(m427f && m427f2 && this.f709e.equals(ijVar.f709e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f710f.equals(ijVar.f710f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f700a.m344a(ijVar.f700a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f705a == ijVar.f705a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f704a.equals(ijVar.f704a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f711g.equals(ijVar.f711g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f712h.equals(ijVar.f712h));
    }

    public String b() {
        return this.f707c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m420a();
        jcVar.a(f699a);
        if (this.f702a != null && m421a()) {
            jcVar.a(a);
            jcVar.a(this.f702a);
            jcVar.b();
        }
        if (this.f701a != null && m423b()) {
            jcVar.a(b);
            this.f701a.b(jcVar);
            jcVar.b();
        }
        if (this.f706b != null) {
            jcVar.a(c);
            jcVar.a(this.f706b);
            jcVar.b();
        }
        if (this.f707c != null) {
            jcVar.a(d);
            jcVar.a(this.f707c);
            jcVar.b();
        }
        if (this.f708d != null && m426e()) {
            jcVar.a(e);
            jcVar.a(this.f708d);
            jcVar.b();
        }
        if (this.f709e != null && m427f()) {
            jcVar.a(f);
            jcVar.a(this.f709e);
            jcVar.b();
        }
        if (this.f710f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f710f);
            jcVar.b();
        }
        if (this.f700a != null && h()) {
            jcVar.a(h);
            this.f700a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f705a);
            jcVar.b();
        }
        if (this.f704a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f704a.size()));
            for (Map.Entry<String, String> entry : this.f704a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f711g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f711g);
            jcVar.b();
        }
        if (this.f712h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f712h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m423b() {
        return this.f701a != null;
    }

    public String c() {
        return this.f709e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m424c() {
        return this.f706b != null;
    }

    public String d() {
        return this.f710f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m425d() {
        return this.f707c != null;
    }

    public String e() {
        return this.f711g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m426e() {
        return this.f708d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m422a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f712h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m427f() {
        return this.f709e != null;
    }

    public boolean g() {
        return this.f710f != null;
    }

    public boolean h() {
        return this.f700a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f703a.get(0);
    }

    public boolean j() {
        return this.f704a != null;
    }

    public boolean k() {
        return this.f711g != null;
    }

    public boolean l() {
        return this.f712h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m421a()) {
            sb.append("debug:");
            if (this.f702a == null) {
                sb.append("null");
            } else {
                sb.append(this.f702a);
            }
            z2 = false;
        }
        if (m423b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f701a == null) {
                sb.append("null");
            } else {
                sb.append(this.f701a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f706b == null) {
            sb.append("null");
        } else {
            sb.append(this.f706b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f707c == null) {
            sb.append("null");
        } else {
            sb.append(this.f707c);
        }
        if (m426e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f708d == null) {
                sb.append("null");
            } else {
                sb.append(this.f708d);
            }
        }
        if (m427f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f709e == null) {
                sb.append("null");
            } else {
                sb.append(this.f709e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f710f == null) {
                sb.append("null");
            } else {
                sb.append(this.f710f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f700a == null) {
                sb.append("null");
            } else {
                sb.append(this.f700a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f705a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f704a == null) {
                sb.append("null");
            } else {
                sb.append(this.f704a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f711g == null) {
                sb.append("null");
            } else {
                sb.append(this.f711g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f712h == null) {
                sb.append("null");
            } else {
                sb.append(this.f712h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
