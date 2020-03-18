package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hx implements ir<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f568a;

    /* renamed from: a  reason: collision with other field name */
    public String f569a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f571a;

    /* renamed from: b  reason: collision with other field name */
    public String f572b;

    /* renamed from: c  reason: collision with other field name */
    public String f573c;

    /* renamed from: d  reason: collision with other field name */
    public String f574d;

    /* renamed from: e  reason: collision with other field name */
    public String f575e;

    /* renamed from: f  reason: collision with other field name */
    public String f576f;

    /* renamed from: g  reason: collision with other field name */
    public String f577g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f566a = new jh("XmPushActionAckNotification");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", (byte) 10, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz h = new iz("", (byte) 13, 9);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f570a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f567a = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
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
        if (getClass().equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(m381a()).compareTo(Boolean.valueOf(hxVar.m381a()));
            if (compareTo == 0) {
                if (!m381a() || (a11 = is.a(this.f569a, hxVar.f569a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f568a, hxVar.f568a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f572b, hxVar.f572b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f573c, hxVar.f573c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f574d, hxVar.f574d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f567a, hxVar.f567a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f575e, hxVar.f575e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f571a, hxVar.f571a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f576f, hxVar.f576f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f577g, hxVar.f577g)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hxVar.getClass().getName());
    }

    public String a() {
        return this.f572b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m379a() {
        return this.f571a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m380a() {
        if (this.f572b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                m380a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a == 11) {
                        this.f569a = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 2:
                    if (m466a.a == 12) {
                        this.f568a = new hv();
                        this.f568a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 3:
                    if (m466a.a == 11) {
                        this.f572b = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 4:
                    if (m466a.a == 11) {
                        this.f573c = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 5:
                    if (m466a.a == 11) {
                        this.f574d = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 6:
                default:
                    jf.a(jcVar, m466a.a);
                    break;
                case 7:
                    if (m466a.a == 10) {
                        this.f567a = jcVar.m465a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 8:
                    if (m466a.a == 11) {
                        this.f575e = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 9:
                    if (m466a.a == 13) {
                        jb m468a = jcVar.m468a();
                        this.f571a = new HashMap(m468a.f792a * 2);
                        for (int i2 = 0; i2 < m468a.f792a; i2++) {
                            this.f571a.put(jcVar.m471a(), jcVar.m471a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 10:
                    if (m466a.a == 11) {
                        this.f576f = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 11:
                    if (m466a.a == 11) {
                        this.f577g = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f570a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a() {
        return this.f569a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m382a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m381a = m381a();
        boolean m381a2 = hxVar.m381a();
        if ((m381a || m381a2) && !(m381a && m381a2 && this.f569a.equals(hxVar.f569a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hxVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f568a.m376a(hxVar.f568a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f572b.equals(hxVar.f572b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f573c.equals(hxVar.f573c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f574d.equals(hxVar.f574d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f567a == hxVar.f567a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f575e.equals(hxVar.f575e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f571a.equals(hxVar.f571a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f576f.equals(hxVar.f576f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f577g.equals(hxVar.f577g));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m380a();
        jcVar.a(f566a);
        if (this.f569a != null && m381a()) {
            jcVar.a(a);
            jcVar.a(this.f569a);
            jcVar.b();
        }
        if (this.f568a != null && b()) {
            jcVar.a(b);
            this.f568a.b(jcVar);
            jcVar.b();
        }
        if (this.f572b != null) {
            jcVar.a(c);
            jcVar.a(this.f572b);
            jcVar.b();
        }
        if (this.f573c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f573c);
            jcVar.b();
        }
        if (this.f574d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f574d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f567a);
            jcVar.b();
        }
        if (this.f575e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f575e);
            jcVar.b();
        }
        if (this.f571a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f571a.size()));
            for (Map.Entry<String, String> entry : this.f571a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f576f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f576f);
            jcVar.b();
        }
        if (this.f577g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f577g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean b() {
        return this.f568a != null;
    }

    public boolean c() {
        return this.f572b != null;
    }

    public boolean d() {
        return this.f573c != null;
    }

    public boolean e() {
        return this.f574d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m382a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f570a.get(0);
    }

    public boolean g() {
        return this.f575e != null;
    }

    public boolean h() {
        return this.f571a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f576f != null;
    }

    public boolean j() {
        return this.f577g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m381a()) {
            sb.append("debug:");
            if (this.f569a == null) {
                sb.append("null");
            } else {
                sb.append(this.f569a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f568a == null) {
                sb.append("null");
            } else {
                sb.append(this.f568a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f572b == null) {
            sb.append("null");
        } else {
            sb.append(this.f572b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f573c == null) {
                sb.append("null");
            } else {
                sb.append(this.f573c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f574d == null) {
                sb.append("null");
            } else {
                sb.append(this.f574d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f567a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f575e == null) {
                sb.append("null");
            } else {
                sb.append(this.f575e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f571a == null) {
                sb.append("null");
            } else {
                sb.append(this.f571a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f576f == null) {
                sb.append("null");
            } else {
                sb.append(this.f576f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f577g == null) {
                sb.append("null");
            } else {
                sb.append(this.f577g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
