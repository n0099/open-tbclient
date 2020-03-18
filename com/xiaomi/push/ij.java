package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
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
            int compareTo = Boolean.valueOf(m436a()).compareTo(Boolean.valueOf(ijVar.m436a()));
            if (compareTo == 0) {
                if (!m436a() || (a13 = is.a(this.f702a, ijVar.f702a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m438b()).compareTo(Boolean.valueOf(ijVar.m438b()));
                    if (compareTo2 == 0) {
                        if (!m438b() || (a12 = is.a(this.f701a, ijVar.f701a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m439c()).compareTo(Boolean.valueOf(ijVar.m439c()));
                            if (compareTo3 == 0) {
                                if (!m439c() || (a11 = is.a(this.f706b, ijVar.f706b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m440d()).compareTo(Boolean.valueOf(ijVar.m440d()));
                                    if (compareTo4 == 0) {
                                        if (!m440d() || (a10 = is.a(this.f707c, ijVar.f707c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m441e()).compareTo(Boolean.valueOf(ijVar.m441e()));
                                            if (compareTo5 == 0) {
                                                if (!m441e() || (a9 = is.a(this.f708d, ijVar.f708d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m442f()).compareTo(Boolean.valueOf(ijVar.m442f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m442f() || (a8 = is.a(this.f709e, ijVar.f709e)) == 0) {
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
    public String m434a() {
        return this.f706b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m435a() {
        if (this.f706b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f707c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                m435a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a == 11) {
                        this.f702a = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 2:
                    if (m466a.a == 12) {
                        this.f701a = new hv();
                        this.f701a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 3:
                    if (m466a.a == 11) {
                        this.f706b = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 4:
                    if (m466a.a == 11) {
                        this.f707c = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 5:
                    if (m466a.a == 11) {
                        this.f708d = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 6:
                    if (m466a.a == 11) {
                        this.f709e = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 7:
                    if (m466a.a == 11) {
                        this.f710f = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 8:
                    if (m466a.a == 12) {
                        this.f700a = new hs();
                        this.f700a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 9:
                    if (m466a.a == 2) {
                        this.f705a = jcVar.m475a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 10:
                    if (m466a.a == 13) {
                        jb m468a = jcVar.m468a();
                        this.f704a = new HashMap(m468a.f792a * 2);
                        for (int i2 = 0; i2 < m468a.f792a; i2++) {
                            this.f704a.put(jcVar.m471a(), jcVar.m471a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 11:
                    if (m466a.a == 11) {
                        this.f711g = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 12:
                    if (m466a.a == 11) {
                        this.f712h = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m466a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f703a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a() {
        return this.f702a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m436a = m436a();
        boolean m436a2 = ijVar.m436a();
        if ((m436a || m436a2) && !(m436a && m436a2 && this.f702a.equals(ijVar.f702a))) {
            return false;
        }
        boolean m438b = m438b();
        boolean m438b2 = ijVar.m438b();
        if ((m438b || m438b2) && !(m438b && m438b2 && this.f701a.m376a(ijVar.f701a))) {
            return false;
        }
        boolean m439c = m439c();
        boolean m439c2 = ijVar.m439c();
        if ((m439c || m439c2) && !(m439c && m439c2 && this.f706b.equals(ijVar.f706b))) {
            return false;
        }
        boolean m440d = m440d();
        boolean m440d2 = ijVar.m440d();
        if ((m440d || m440d2) && !(m440d && m440d2 && this.f707c.equals(ijVar.f707c))) {
            return false;
        }
        boolean m441e = m441e();
        boolean m441e2 = ijVar.m441e();
        if ((m441e || m441e2) && !(m441e && m441e2 && this.f708d.equals(ijVar.f708d))) {
            return false;
        }
        boolean m442f = m442f();
        boolean m442f2 = ijVar.m442f();
        if ((m442f || m442f2) && !(m442f && m442f2 && this.f709e.equals(ijVar.f709e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f710f.equals(ijVar.f710f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f700a.m359a(ijVar.f700a))) {
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
        m435a();
        jcVar.a(f699a);
        if (this.f702a != null && m436a()) {
            jcVar.a(a);
            jcVar.a(this.f702a);
            jcVar.b();
        }
        if (this.f701a != null && m438b()) {
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
        if (this.f708d != null && m441e()) {
            jcVar.a(e);
            jcVar.a(this.f708d);
            jcVar.b();
        }
        if (this.f709e != null && m442f()) {
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
        jcVar.m474a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m438b() {
        return this.f701a != null;
    }

    public String c() {
        return this.f709e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m439c() {
        return this.f706b != null;
    }

    public String d() {
        return this.f710f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m440d() {
        return this.f707c != null;
    }

    public String e() {
        return this.f711g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m441e() {
        return this.f708d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m437a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f712h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m442f() {
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
        if (m436a()) {
            sb.append("debug:");
            if (this.f702a == null) {
                sb.append("null");
            } else {
                sb.append(this.f702a);
            }
            z2 = false;
        }
        if (m438b()) {
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
        if (m441e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f708d == null) {
                sb.append("null");
            } else {
                sb.append(this.f708d);
            }
        }
        if (m442f()) {
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
