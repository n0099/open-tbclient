package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hx implements ir<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f572a;

    /* renamed from: a  reason: collision with other field name */
    public String f573a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f575a;

    /* renamed from: b  reason: collision with other field name */
    public String f576b;

    /* renamed from: c  reason: collision with other field name */
    public String f577c;

    /* renamed from: d  reason: collision with other field name */
    public String f578d;

    /* renamed from: e  reason: collision with other field name */
    public String f579e;

    /* renamed from: f  reason: collision with other field name */
    public String f580f;

    /* renamed from: g  reason: collision with other field name */
    public String f581g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f570a = new jh("XmPushActionAckNotification");
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
    private BitSet f574a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f571a = 0;

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
            int compareTo = Boolean.valueOf(m378a()).compareTo(Boolean.valueOf(hxVar.m378a()));
            if (compareTo == 0) {
                if (!m378a() || (a11 = is.a(this.f573a, hxVar.f573a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f572a, hxVar.f572a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f576b, hxVar.f576b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f577c, hxVar.f577c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f578d, hxVar.f578d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f571a, hxVar.f571a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f579e, hxVar.f579e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f575a, hxVar.f575a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f580f, hxVar.f580f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f581g, hxVar.f581g)) == 0) {
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
        return this.f576b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m376a() {
        return this.f575a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m377a() {
        if (this.f576b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m377a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f573a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f572a = new hv();
                        this.f572a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f576b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f577c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f578d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 7:
                    if (m463a.a == 10) {
                        this.f571a = jcVar.m462a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 11) {
                        this.f579e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f575a = new HashMap(m465a.f796a * 2);
                        for (int i2 = 0; i2 < m465a.f796a; i2++) {
                            this.f575a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 11) {
                        this.f580f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 11) {
                        this.f581g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f574a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m378a() {
        return this.f573a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m379a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m378a = m378a();
        boolean m378a2 = hxVar.m378a();
        if ((m378a || m378a2) && !(m378a && m378a2 && this.f573a.equals(hxVar.f573a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hxVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f572a.m373a(hxVar.f572a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f576b.equals(hxVar.f576b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f577c.equals(hxVar.f577c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f578d.equals(hxVar.f578d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f571a == hxVar.f571a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f579e.equals(hxVar.f579e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f575a.equals(hxVar.f575a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f580f.equals(hxVar.f580f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f581g.equals(hxVar.f581g));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m377a();
        jcVar.a(f570a);
        if (this.f573a != null && m378a()) {
            jcVar.a(a);
            jcVar.a(this.f573a);
            jcVar.b();
        }
        if (this.f572a != null && b()) {
            jcVar.a(b);
            this.f572a.b(jcVar);
            jcVar.b();
        }
        if (this.f576b != null) {
            jcVar.a(c);
            jcVar.a(this.f576b);
            jcVar.b();
        }
        if (this.f577c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f577c);
            jcVar.b();
        }
        if (this.f578d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f578d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f571a);
            jcVar.b();
        }
        if (this.f579e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f579e);
            jcVar.b();
        }
        if (this.f575a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f575a.size()));
            for (Map.Entry<String, String> entry : this.f575a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f580f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f580f);
            jcVar.b();
        }
        if (this.f581g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f581g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f572a != null;
    }

    public boolean c() {
        return this.f576b != null;
    }

    public boolean d() {
        return this.f577c != null;
    }

    public boolean e() {
        return this.f578d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m379a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f574a.get(0);
    }

    public boolean g() {
        return this.f579e != null;
    }

    public boolean h() {
        return this.f575a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f580f != null;
    }

    public boolean j() {
        return this.f581g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m378a()) {
            sb.append("debug:");
            if (this.f573a == null) {
                sb.append("null");
            } else {
                sb.append(this.f573a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f572a == null) {
                sb.append("null");
            } else {
                sb.append(this.f572a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f576b == null) {
            sb.append("null");
        } else {
            sb.append(this.f576b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f577c == null) {
                sb.append("null");
            } else {
                sb.append(this.f577c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f578d == null) {
                sb.append("null");
            } else {
                sb.append(this.f578d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f571a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f579e == null) {
                sb.append("null");
            } else {
                sb.append(this.f579e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f575a == null) {
                sb.append("null");
            } else {
                sb.append(this.f575a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f580f == null) {
                sb.append("null");
            } else {
                sb.append(this.f580f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f581g == null) {
                sb.append("null");
            } else {
                sb.append(this.f581g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
