package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f557a;

    /* renamed from: a  reason: collision with other field name */
    public String f558a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f560a;

    /* renamed from: b  reason: collision with other field name */
    public String f561b;

    /* renamed from: c  reason: collision with other field name */
    public String f562c;

    /* renamed from: d  reason: collision with other field name */
    public String f563d;

    /* renamed from: e  reason: collision with other field name */
    public String f564e;

    /* renamed from: f  reason: collision with other field name */
    public String f565f;

    /* renamed from: g  reason: collision with other field name */
    public String f566g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f555a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8436a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f559a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f556a = 0;

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
            int compareTo = Boolean.valueOf(m407a()).compareTo(Boolean.valueOf(idVar.m407a()));
            if (compareTo == 0) {
                if (!m407a() || (a11 = iy.a(this.f558a, idVar.f558a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f557a, idVar.f557a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f561b, idVar.f561b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f562c, idVar.f562c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f563d, idVar.f563d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f556a, idVar.f556a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f564e, idVar.f564e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f560a, idVar.f560a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f565f, idVar.f565f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f566g, idVar.f566g)) == 0) {
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
        return this.f561b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m405a() {
        return this.f560a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m406a() {
        if (this.f561b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                m406a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 11) {
                        this.f558a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 2:
                    if (m489a.f8463a == 12) {
                        this.f557a = new ib();
                        this.f557a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 3:
                    if (m489a.f8463a == 11) {
                        this.f561b = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 4:
                    if (m489a.f8463a == 11) {
                        this.f562c = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 5:
                    if (m489a.f8463a == 11) {
                        this.f563d = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
                case 7:
                    if (m489a.f8463a == 10) {
                        this.f556a = jiVar.m488a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 8:
                    if (m489a.f8463a == 11) {
                        this.f564e = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 9:
                    if (m489a.f8463a == 13) {
                        jh m491a = jiVar.m491a();
                        this.f560a = new HashMap(m491a.f780a * 2);
                        for (int i2 = 0; i2 < m491a.f780a; i2++) {
                            this.f560a.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 10:
                    if (m489a.f8463a == 11) {
                        this.f565f = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 11:
                    if (m489a.f8463a == 11) {
                        this.f566g = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f559a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a() {
        return this.f558a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m408a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m407a = m407a();
        boolean m407a2 = idVar.m407a();
        if ((m407a || m407a2) && !(m407a && m407a2 && this.f558a.equals(idVar.f558a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f557a.m402a(idVar.f557a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f561b.equals(idVar.f561b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f562c.equals(idVar.f562c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f563d.equals(idVar.f563d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f556a == idVar.f556a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f564e.equals(idVar.f564e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f560a.equals(idVar.f560a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f565f.equals(idVar.f565f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f566g.equals(idVar.f566g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m406a();
        jiVar.a(f555a);
        if (this.f558a != null && m407a()) {
            jiVar.a(f8436a);
            jiVar.a(this.f558a);
            jiVar.b();
        }
        if (this.f557a != null && b()) {
            jiVar.a(b);
            this.f557a.b(jiVar);
            jiVar.b();
        }
        if (this.f561b != null) {
            jiVar.a(c);
            jiVar.a(this.f561b);
            jiVar.b();
        }
        if (this.f562c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f562c);
            jiVar.b();
        }
        if (this.f563d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f563d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f556a);
            jiVar.b();
        }
        if (this.f564e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f564e);
            jiVar.b();
        }
        if (this.f560a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f560a.size()));
            for (Map.Entry<String, String> entry : this.f560a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f565f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f565f);
            jiVar.b();
        }
        if (this.f566g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f566g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean b() {
        return this.f557a != null;
    }

    public boolean c() {
        return this.f561b != null;
    }

    public boolean d() {
        return this.f562c != null;
    }

    public boolean e() {
        return this.f563d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m408a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f559a.get(0);
    }

    public boolean g() {
        return this.f564e != null;
    }

    public boolean h() {
        return this.f560a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f565f != null;
    }

    public boolean j() {
        return this.f566g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m407a()) {
            sb.append("debug:");
            if (this.f558a == null) {
                sb.append("null");
            } else {
                sb.append(this.f558a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f557a == null) {
                sb.append("null");
            } else {
                sb.append(this.f557a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f561b == null) {
            sb.append("null");
        } else {
            sb.append(this.f561b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f562c == null) {
                sb.append("null");
            } else {
                sb.append(this.f562c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f563d == null) {
                sb.append("null");
            } else {
                sb.append(this.f563d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f556a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f564e == null) {
                sb.append("null");
            } else {
                sb.append(this.f564e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f560a == null) {
                sb.append("null");
            } else {
                sb.append(this.f560a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f565f == null) {
                sb.append("null");
            } else {
                sb.append(this.f565f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f566g == null) {
                sb.append("null");
            } else {
                sb.append(this.f566g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
