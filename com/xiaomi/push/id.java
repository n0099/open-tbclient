package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f636a;

    /* renamed from: a  reason: collision with other field name */
    public String f637a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f639a;

    /* renamed from: b  reason: collision with other field name */
    public String f640b;

    /* renamed from: c  reason: collision with other field name */
    public String f641c;

    /* renamed from: d  reason: collision with other field name */
    public String f642d;

    /* renamed from: e  reason: collision with other field name */
    public String f643e;

    /* renamed from: f  reason: collision with other field name */
    public String f644f;

    /* renamed from: g  reason: collision with other field name */
    public String f645g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f634a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14128a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14129b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 10, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 13, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f638a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f635a = 0;

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
            int compareTo = Boolean.valueOf(m428a()).compareTo(Boolean.valueOf(idVar.m428a()));
            if (compareTo == 0) {
                if (!m428a() || (a11 = iy.a(this.f637a, idVar.f637a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f636a, idVar.f636a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f640b, idVar.f640b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f641c, idVar.f641c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f642d, idVar.f642d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f635a, idVar.f635a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f643e, idVar.f643e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f639a, idVar.f639a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f644f, idVar.f644f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f645g, idVar.f645g)) == 0) {
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
        return this.f640b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m426a() {
        return this.f639a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m427a() {
        if (this.f640b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m427a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a == 11) {
                        this.f637a = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 2:
                    if (m510a.f14173a == 12) {
                        this.f636a = new ib();
                        this.f636a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 3:
                    if (m510a.f14173a == 11) {
                        this.f640b = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 4:
                    if (m510a.f14173a == 11) {
                        this.f641c = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 5:
                    if (m510a.f14173a == 11) {
                        this.f642d = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
                case 7:
                    if (m510a.f14173a == 10) {
                        this.f635a = jiVar.m509a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 8:
                    if (m510a.f14173a == 11) {
                        this.f643e = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 9:
                    if (m510a.f14173a == 13) {
                        jh m512a = jiVar.m512a();
                        this.f639a = new HashMap(m512a.f859a * 2);
                        for (int i2 = 0; i2 < m512a.f859a; i2++) {
                            this.f639a.put(jiVar.m515a(), jiVar.m515a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 10:
                    if (m510a.f14173a == 11) {
                        this.f644f = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 11:
                    if (m510a.f14173a == 11) {
                        this.f645g = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f638a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m428a() {
        return this.f637a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m428a = m428a();
        boolean m428a2 = idVar.m428a();
        if ((m428a || m428a2) && !(m428a && m428a2 && this.f637a.equals(idVar.f637a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f636a.m423a(idVar.f636a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f640b.equals(idVar.f640b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f641c.equals(idVar.f641c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f642d.equals(idVar.f642d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f635a == idVar.f635a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f643e.equals(idVar.f643e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f639a.equals(idVar.f639a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f644f.equals(idVar.f644f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f645g.equals(idVar.f645g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m427a();
        jiVar.a(f634a);
        if (this.f637a != null && m428a()) {
            jiVar.a(f14128a);
            jiVar.a(this.f637a);
            jiVar.b();
        }
        if (this.f636a != null && b()) {
            jiVar.a(f14129b);
            this.f636a.b(jiVar);
            jiVar.b();
        }
        if (this.f640b != null) {
            jiVar.a(c);
            jiVar.a(this.f640b);
            jiVar.b();
        }
        if (this.f641c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f641c);
            jiVar.b();
        }
        if (this.f642d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f642d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f635a);
            jiVar.b();
        }
        if (this.f643e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f643e);
            jiVar.b();
        }
        if (this.f639a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f639a.size()));
            for (Map.Entry<String, String> entry : this.f639a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f644f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f644f);
            jiVar.b();
        }
        if (this.f645g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f645g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public boolean b() {
        return this.f636a != null;
    }

    public boolean c() {
        return this.f640b != null;
    }

    public boolean d() {
        return this.f641c != null;
    }

    public boolean e() {
        return this.f642d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m429a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f638a.get(0);
    }

    public boolean g() {
        return this.f643e != null;
    }

    public boolean h() {
        return this.f639a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f644f != null;
    }

    public boolean j() {
        return this.f645g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m428a()) {
            sb.append("debug:");
            if (this.f637a == null) {
                sb.append("null");
            } else {
                sb.append(this.f637a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f636a == null) {
                sb.append("null");
            } else {
                sb.append(this.f636a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f640b == null) {
            sb.append("null");
        } else {
            sb.append(this.f640b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f641c == null) {
                sb.append("null");
            } else {
                sb.append(this.f641c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f642d == null) {
                sb.append("null");
            } else {
                sb.append(this.f642d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f635a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f643e == null) {
                sb.append("null");
            } else {
                sb.append(this.f643e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f639a == null) {
                sb.append("null");
            } else {
                sb.append(this.f639a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f644f == null) {
                sb.append("null");
            } else {
                sb.append(this.f644f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f645g == null) {
                sb.append("null");
            } else {
                sb.append(this.f645g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
