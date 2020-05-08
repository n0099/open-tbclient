package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f556a;

    /* renamed from: a  reason: collision with other field name */
    public String f557a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f559a;

    /* renamed from: b  reason: collision with other field name */
    public String f560b;

    /* renamed from: c  reason: collision with other field name */
    public String f561c;

    /* renamed from: d  reason: collision with other field name */
    public String f562d;

    /* renamed from: e  reason: collision with other field name */
    public String f563e;

    /* renamed from: f  reason: collision with other field name */
    public String f564f;

    /* renamed from: g  reason: collision with other field name */
    public String f565g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f554a = new jn("XmPushActionAckNotification");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f558a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f555a = 0;

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
            int compareTo = Boolean.valueOf(m399a()).compareTo(Boolean.valueOf(idVar.m399a()));
            if (compareTo == 0) {
                if (!m399a() || (a11 = iy.a(this.f557a, idVar.f557a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f556a, idVar.f556a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f560b, idVar.f560b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f561c, idVar.f561c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f562d, idVar.f562d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f555a, idVar.f555a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f563e, idVar.f563e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f559a, idVar.f559a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f564f, idVar.f564f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f565g, idVar.f565g)) == 0) {
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
        return this.f560b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m397a() {
        return this.f559a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m398a() {
        if (this.f560b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                m398a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a == 11) {
                        this.f557a = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 2:
                    if (m481a.a == 12) {
                        this.f556a = new ib();
                        this.f556a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 3:
                    if (m481a.a == 11) {
                        this.f560b = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 4:
                    if (m481a.a == 11) {
                        this.f561c = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 5:
                    if (m481a.a == 11) {
                        this.f562d = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m481a.a);
                    break;
                case 7:
                    if (m481a.a == 10) {
                        this.f555a = jiVar.m480a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 8:
                    if (m481a.a == 11) {
                        this.f563e = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 9:
                    if (m481a.a == 13) {
                        jh m483a = jiVar.m483a();
                        this.f559a = new HashMap(m483a.f779a * 2);
                        for (int i2 = 0; i2 < m483a.f779a; i2++) {
                            this.f559a.put(jiVar.m486a(), jiVar.m486a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 10:
                    if (m481a.a == 11) {
                        this.f564f = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 11:
                    if (m481a.a == 11) {
                        this.f565g = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f558a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a() {
        return this.f557a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m399a = m399a();
        boolean m399a2 = idVar.m399a();
        if ((m399a || m399a2) && !(m399a && m399a2 && this.f557a.equals(idVar.f557a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f556a.m394a(idVar.f556a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f560b.equals(idVar.f560b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f561c.equals(idVar.f561c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f562d.equals(idVar.f562d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f555a == idVar.f555a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f563e.equals(idVar.f563e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f559a.equals(idVar.f559a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f564f.equals(idVar.f564f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f565g.equals(idVar.f565g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m398a();
        jiVar.a(f554a);
        if (this.f557a != null && m399a()) {
            jiVar.a(a);
            jiVar.a(this.f557a);
            jiVar.b();
        }
        if (this.f556a != null && b()) {
            jiVar.a(b);
            this.f556a.b(jiVar);
            jiVar.b();
        }
        if (this.f560b != null) {
            jiVar.a(c);
            jiVar.a(this.f560b);
            jiVar.b();
        }
        if (this.f561c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f561c);
            jiVar.b();
        }
        if (this.f562d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f562d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f555a);
            jiVar.b();
        }
        if (this.f563e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f563e);
            jiVar.b();
        }
        if (this.f559a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f559a.size()));
            for (Map.Entry<String, String> entry : this.f559a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f564f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f564f);
            jiVar.b();
        }
        if (this.f565g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f565g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean b() {
        return this.f556a != null;
    }

    public boolean c() {
        return this.f560b != null;
    }

    public boolean d() {
        return this.f561c != null;
    }

    public boolean e() {
        return this.f562d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m400a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f558a.get(0);
    }

    public boolean g() {
        return this.f563e != null;
    }

    public boolean h() {
        return this.f559a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f564f != null;
    }

    public boolean j() {
        return this.f565g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m399a()) {
            sb.append("debug:");
            if (this.f557a == null) {
                sb.append("null");
            } else {
                sb.append(this.f557a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f556a == null) {
                sb.append("null");
            } else {
                sb.append(this.f556a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f560b == null) {
            sb.append("null");
        } else {
            sb.append(this.f560b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f561c == null) {
                sb.append("null");
            } else {
                sb.append(this.f561c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f562d == null) {
                sb.append("null");
            } else {
                sb.append(this.f562d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f555a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f563e == null) {
                sb.append("null");
            } else {
                sb.append(this.f563e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f559a == null) {
                sb.append("null");
            } else {
                sb.append(this.f559a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f564f == null) {
                sb.append("null");
            } else {
                sb.append(this.f564f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f565g == null) {
                sb.append("null");
            } else {
                sb.append(this.f565g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
