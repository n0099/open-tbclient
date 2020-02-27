package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hx implements ir<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f569a;

    /* renamed from: a  reason: collision with other field name */
    public String f570a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f572a;

    /* renamed from: b  reason: collision with other field name */
    public String f573b;

    /* renamed from: c  reason: collision with other field name */
    public String f574c;

    /* renamed from: d  reason: collision with other field name */
    public String f575d;

    /* renamed from: e  reason: collision with other field name */
    public String f576e;

    /* renamed from: f  reason: collision with other field name */
    public String f577f;

    /* renamed from: g  reason: collision with other field name */
    public String f578g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f567a = new jh("XmPushActionAckNotification");
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
    private BitSet f571a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f568a = 0;

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
            int compareTo = Boolean.valueOf(m383a()).compareTo(Boolean.valueOf(hxVar.m383a()));
            if (compareTo == 0) {
                if (!m383a() || (a11 = is.a(this.f570a, hxVar.f570a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f569a, hxVar.f569a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f573b, hxVar.f573b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f574c, hxVar.f574c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f575d, hxVar.f575d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f568a, hxVar.f568a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f576e, hxVar.f576e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f572a, hxVar.f572a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f577f, hxVar.f577f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f578g, hxVar.f578g)) == 0) {
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
        return this.f573b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m381a() {
        return this.f572a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m382a() {
        if (this.f573b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m382a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a == 11) {
                        this.f570a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 2:
                    if (m468a.a == 12) {
                        this.f569a = new hv();
                        this.f569a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 11) {
                        this.f573b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 4:
                    if (m468a.a == 11) {
                        this.f574c = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 5:
                    if (m468a.a == 11) {
                        this.f575d = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 6:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 7:
                    if (m468a.a == 10) {
                        this.f568a = jcVar.m467a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 8:
                    if (m468a.a == 11) {
                        this.f576e = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 9:
                    if (m468a.a == 13) {
                        jb m470a = jcVar.m470a();
                        this.f572a = new HashMap(m470a.f793a * 2);
                        for (int i2 = 0; i2 < m470a.f793a; i2++) {
                            this.f572a.put(jcVar.m473a(), jcVar.m473a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 10:
                    if (m468a.a == 11) {
                        this.f577f = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 11:
                    if (m468a.a == 11) {
                        this.f578g = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f571a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a() {
        return this.f570a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m384a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m383a = m383a();
        boolean m383a2 = hxVar.m383a();
        if ((m383a || m383a2) && !(m383a && m383a2 && this.f570a.equals(hxVar.f570a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hxVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f569a.m378a(hxVar.f569a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f573b.equals(hxVar.f573b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f574c.equals(hxVar.f574c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f575d.equals(hxVar.f575d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f568a == hxVar.f568a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f576e.equals(hxVar.f576e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f572a.equals(hxVar.f572a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f577f.equals(hxVar.f577f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f578g.equals(hxVar.f578g));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m382a();
        jcVar.a(f567a);
        if (this.f570a != null && m383a()) {
            jcVar.a(a);
            jcVar.a(this.f570a);
            jcVar.b();
        }
        if (this.f569a != null && b()) {
            jcVar.a(b);
            this.f569a.b(jcVar);
            jcVar.b();
        }
        if (this.f573b != null) {
            jcVar.a(c);
            jcVar.a(this.f573b);
            jcVar.b();
        }
        if (this.f574c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f574c);
            jcVar.b();
        }
        if (this.f575d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f575d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f568a);
            jcVar.b();
        }
        if (this.f576e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f576e);
            jcVar.b();
        }
        if (this.f572a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f572a.size()));
            for (Map.Entry<String, String> entry : this.f572a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f577f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f577f);
            jcVar.b();
        }
        if (this.f578g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f578g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public boolean b() {
        return this.f569a != null;
    }

    public boolean c() {
        return this.f573b != null;
    }

    public boolean d() {
        return this.f574c != null;
    }

    public boolean e() {
        return this.f575d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m384a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f571a.get(0);
    }

    public boolean g() {
        return this.f576e != null;
    }

    public boolean h() {
        return this.f572a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f577f != null;
    }

    public boolean j() {
        return this.f578g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m383a()) {
            sb.append("debug:");
            if (this.f570a == null) {
                sb.append("null");
            } else {
                sb.append(this.f570a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f569a == null) {
                sb.append("null");
            } else {
                sb.append(this.f569a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f573b == null) {
            sb.append("null");
        } else {
            sb.append(this.f573b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f574c == null) {
                sb.append("null");
            } else {
                sb.append(this.f574c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f575d == null) {
                sb.append("null");
            } else {
                sb.append(this.f575d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f568a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f576e == null) {
                sb.append("null");
            } else {
                sb.append(this.f576e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f572a == null) {
                sb.append("null");
            } else {
                sb.append(this.f572a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f577f == null) {
                sb.append("null");
            } else {
                sb.append(this.f577f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f578g == null) {
                sb.append("null");
            } else {
                sb.append(this.f578g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
