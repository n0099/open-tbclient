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
    public hs f701a;

    /* renamed from: a  reason: collision with other field name */
    public hv f702a;

    /* renamed from: a  reason: collision with other field name */
    public String f703a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f705a;

    /* renamed from: b  reason: collision with other field name */
    public String f707b;

    /* renamed from: c  reason: collision with other field name */
    public String f708c;

    /* renamed from: d  reason: collision with other field name */
    public String f709d;

    /* renamed from: e  reason: collision with other field name */
    public String f710e;

    /* renamed from: f  reason: collision with other field name */
    public String f711f;

    /* renamed from: g  reason: collision with other field name */
    public String f712g;

    /* renamed from: h  reason: collision with other field name */
    public String f713h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f700a = new jh("XmPushActionSendMessage");
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
    private BitSet f704a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f706a = true;

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
            int compareTo = Boolean.valueOf(m441a()).compareTo(Boolean.valueOf(ijVar.m441a()));
            if (compareTo == 0) {
                if (!m441a() || (a13 = is.a(this.f703a, ijVar.f703a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m443b()).compareTo(Boolean.valueOf(ijVar.m443b()));
                    if (compareTo2 == 0) {
                        if (!m443b() || (a12 = is.a(this.f702a, ijVar.f702a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m444c()).compareTo(Boolean.valueOf(ijVar.m444c()));
                            if (compareTo3 == 0) {
                                if (!m444c() || (a11 = is.a(this.f707b, ijVar.f707b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m445d()).compareTo(Boolean.valueOf(ijVar.m445d()));
                                    if (compareTo4 == 0) {
                                        if (!m445d() || (a10 = is.a(this.f708c, ijVar.f708c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m446e()).compareTo(Boolean.valueOf(ijVar.m446e()));
                                            if (compareTo5 == 0) {
                                                if (!m446e() || (a9 = is.a(this.f709d, ijVar.f709d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m447f()).compareTo(Boolean.valueOf(ijVar.m447f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m447f() || (a8 = is.a(this.f710e, ijVar.f710e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f711f, ijVar.f711f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f701a, ijVar.f701a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f706a, ijVar.f706a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f705a, ijVar.f705a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f712g, ijVar.f712g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f713h, ijVar.f713h)) == 0) {
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
        return this.f701a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m439a() {
        return this.f707b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m440a() {
        if (this.f707b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f708c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m440a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 11) {
                        this.f703a = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 12) {
                        this.f702a = new hv();
                        this.f702a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 11) {
                        this.f707b = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 4:
                    if (m471a.a == 11) {
                        this.f708c = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 5:
                    if (m471a.a == 11) {
                        this.f709d = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 6:
                    if (m471a.a == 11) {
                        this.f710e = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 7:
                    if (m471a.a == 11) {
                        this.f711f = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 8:
                    if (m471a.a == 12) {
                        this.f701a = new hs();
                        this.f701a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 9:
                    if (m471a.a == 2) {
                        this.f706a = jcVar.m480a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 10:
                    if (m471a.a == 13) {
                        jb m473a = jcVar.m473a();
                        this.f705a = new HashMap(m473a.f793a * 2);
                        for (int i2 = 0; i2 < m473a.f793a; i2++) {
                            this.f705a.put(jcVar.m476a(), jcVar.m476a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 11:
                    if (m471a.a == 11) {
                        this.f712g = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 12:
                    if (m471a.a == 11) {
                        this.f713h = jcVar.m476a();
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

    public void a(boolean z) {
        this.f704a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a() {
        return this.f703a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m441a = m441a();
        boolean m441a2 = ijVar.m441a();
        if ((m441a || m441a2) && !(m441a && m441a2 && this.f703a.equals(ijVar.f703a))) {
            return false;
        }
        boolean m443b = m443b();
        boolean m443b2 = ijVar.m443b();
        if ((m443b || m443b2) && !(m443b && m443b2 && this.f702a.m381a(ijVar.f702a))) {
            return false;
        }
        boolean m444c = m444c();
        boolean m444c2 = ijVar.m444c();
        if ((m444c || m444c2) && !(m444c && m444c2 && this.f707b.equals(ijVar.f707b))) {
            return false;
        }
        boolean m445d = m445d();
        boolean m445d2 = ijVar.m445d();
        if ((m445d || m445d2) && !(m445d && m445d2 && this.f708c.equals(ijVar.f708c))) {
            return false;
        }
        boolean m446e = m446e();
        boolean m446e2 = ijVar.m446e();
        if ((m446e || m446e2) && !(m446e && m446e2 && this.f709d.equals(ijVar.f709d))) {
            return false;
        }
        boolean m447f = m447f();
        boolean m447f2 = ijVar.m447f();
        if ((m447f || m447f2) && !(m447f && m447f2 && this.f710e.equals(ijVar.f710e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f711f.equals(ijVar.f711f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f701a.m364a(ijVar.f701a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f706a == ijVar.f706a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f705a.equals(ijVar.f705a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f712g.equals(ijVar.f712g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f713h.equals(ijVar.f713h));
    }

    public String b() {
        return this.f708c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m440a();
        jcVar.a(f700a);
        if (this.f703a != null && m441a()) {
            jcVar.a(a);
            jcVar.a(this.f703a);
            jcVar.b();
        }
        if (this.f702a != null && m443b()) {
            jcVar.a(b);
            this.f702a.b(jcVar);
            jcVar.b();
        }
        if (this.f707b != null) {
            jcVar.a(c);
            jcVar.a(this.f707b);
            jcVar.b();
        }
        if (this.f708c != null) {
            jcVar.a(d);
            jcVar.a(this.f708c);
            jcVar.b();
        }
        if (this.f709d != null && m446e()) {
            jcVar.a(e);
            jcVar.a(this.f709d);
            jcVar.b();
        }
        if (this.f710e != null && m447f()) {
            jcVar.a(f);
            jcVar.a(this.f710e);
            jcVar.b();
        }
        if (this.f711f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f711f);
            jcVar.b();
        }
        if (this.f701a != null && h()) {
            jcVar.a(h);
            this.f701a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f706a);
            jcVar.b();
        }
        if (this.f705a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f705a.size()));
            for (Map.Entry<String, String> entry : this.f705a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f712g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f712g);
            jcVar.b();
        }
        if (this.f713h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f713h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m443b() {
        return this.f702a != null;
    }

    public String c() {
        return this.f710e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m444c() {
        return this.f707b != null;
    }

    public String d() {
        return this.f711f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m445d() {
        return this.f708c != null;
    }

    public String e() {
        return this.f712g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m446e() {
        return this.f709d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m442a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f713h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m447f() {
        return this.f710e != null;
    }

    public boolean g() {
        return this.f711f != null;
    }

    public boolean h() {
        return this.f701a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f704a.get(0);
    }

    public boolean j() {
        return this.f705a != null;
    }

    public boolean k() {
        return this.f712g != null;
    }

    public boolean l() {
        return this.f713h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m441a()) {
            sb.append("debug:");
            if (this.f703a == null) {
                sb.append("null");
            } else {
                sb.append(this.f703a);
            }
            z2 = false;
        }
        if (m443b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f702a == null) {
                sb.append("null");
            } else {
                sb.append(this.f702a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f707b == null) {
            sb.append("null");
        } else {
            sb.append(this.f707b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f708c == null) {
            sb.append("null");
        } else {
            sb.append(this.f708c);
        }
        if (m446e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f709d == null) {
                sb.append("null");
            } else {
                sb.append(this.f709d);
            }
        }
        if (m447f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f710e == null) {
                sb.append("null");
            } else {
                sb.append(this.f710e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f711f == null) {
                sb.append("null");
            } else {
                sb.append(this.f711f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f701a == null) {
                sb.append("null");
            } else {
                sb.append(this.f701a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f706a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f712g == null) {
                sb.append("null");
            } else {
                sb.append(this.f712g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f713h == null) {
                sb.append("null");
            } else {
                sb.append(this.f713h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
