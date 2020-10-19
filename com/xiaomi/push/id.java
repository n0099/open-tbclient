package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f558a;

    /* renamed from: a  reason: collision with other field name */
    public String f559a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f561a;

    /* renamed from: b  reason: collision with other field name */
    public String f562b;

    /* renamed from: c  reason: collision with other field name */
    public String f563c;

    /* renamed from: d  reason: collision with other field name */
    public String f564d;

    /* renamed from: e  reason: collision with other field name */
    public String f565e;

    /* renamed from: f  reason: collision with other field name */
    public String f566f;

    /* renamed from: g  reason: collision with other field name */
    public String f567g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f556a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4973a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 10, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 13, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f560a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f557a = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
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
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m404a()).compareTo(Boolean.valueOf(idVar.m404a()));
            if (compareTo == 0) {
                if (!m404a() || (a11 = iy.a(this.f559a, idVar.f559a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f558a, idVar.f558a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f562b, idVar.f562b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f563c, idVar.f563c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f564d, idVar.f564d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f557a, idVar.f557a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f565e, idVar.f565e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f561a, idVar.f561a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f566f, idVar.f566f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f567g, idVar.f567g)) == 0) {
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
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public String a() {
        return this.f562b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m402a() {
        return this.f561a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m403a() {
        if (this.f562b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m403a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 11) {
                        this.f559a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 2:
                    if (m486a.f5000a == 12) {
                        this.f558a = new ib();
                        this.f558a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 3:
                    if (m486a.f5000a == 11) {
                        this.f562b = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 4:
                    if (m486a.f5000a == 11) {
                        this.f563c = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 5:
                    if (m486a.f5000a == 11) {
                        this.f564d = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
                case 7:
                    if (m486a.f5000a == 10) {
                        this.f557a = jiVar.m485a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 8:
                    if (m486a.f5000a == 11) {
                        this.f565e = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 9:
                    if (m486a.f5000a == 13) {
                        jh m488a = jiVar.m488a();
                        this.f561a = new HashMap(m488a.f781a * 2);
                        for (int i2 = 0; i2 < m488a.f781a; i2++) {
                            this.f561a.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 10:
                    if (m486a.f5000a == 11) {
                        this.f566f = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 11:
                    if (m486a.f5000a == 11) {
                        this.f567g = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f560a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a() {
        return this.f559a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m404a = m404a();
        boolean m404a2 = idVar.m404a();
        if ((m404a || m404a2) && !(m404a && m404a2 && this.f559a.equals(idVar.f559a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f558a.m399a(idVar.f558a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f562b.equals(idVar.f562b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f563c.equals(idVar.f563c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f564d.equals(idVar.f564d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f557a == idVar.f557a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f565e.equals(idVar.f565e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f561a.equals(idVar.f561a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f566f.equals(idVar.f566f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f567g.equals(idVar.f567g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m403a();
        jiVar.a(f556a);
        if (this.f559a != null && m404a()) {
            jiVar.a(f4973a);
            jiVar.a(this.f559a);
            jiVar.b();
        }
        if (this.f558a != null && b()) {
            jiVar.a(b);
            this.f558a.b(jiVar);
            jiVar.b();
        }
        if (this.f562b != null) {
            jiVar.a(c);
            jiVar.a(this.f562b);
            jiVar.b();
        }
        if (this.f563c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f563c);
            jiVar.b();
        }
        if (this.f564d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f564d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f557a);
            jiVar.b();
        }
        if (this.f565e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f565e);
            jiVar.b();
        }
        if (this.f561a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f561a.size()));
            for (Map.Entry<String, String> entry : this.f561a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f566f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f566f);
            jiVar.b();
        }
        if (this.f567g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f567g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public boolean b() {
        return this.f558a != null;
    }

    public boolean c() {
        return this.f562b != null;
    }

    public boolean d() {
        return this.f563c != null;
    }

    public boolean e() {
        return this.f564d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m405a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f560a.get(0);
    }

    public boolean g() {
        return this.f565e != null;
    }

    public boolean h() {
        return this.f561a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f566f != null;
    }

    public boolean j() {
        return this.f567g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m404a()) {
            sb.append("debug:");
            if (this.f559a == null) {
                sb.append("null");
            } else {
                sb.append(this.f559a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f558a == null) {
                sb.append("null");
            } else {
                sb.append(this.f558a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f562b == null) {
            sb.append("null");
        } else {
            sb.append(this.f562b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f563c == null) {
                sb.append("null");
            } else {
                sb.append(this.f563c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f564d == null) {
                sb.append("null");
            } else {
                sb.append(this.f564d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f557a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f565e == null) {
                sb.append("null");
            } else {
                sb.append(this.f565e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f561a == null) {
                sb.append("null");
            } else {
                sb.append(this.f561a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f566f == null) {
                sb.append("null");
            } else {
                sb.append(this.f566f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f567g == null) {
                sb.append("null");
            } else {
                sb.append(this.f567g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
