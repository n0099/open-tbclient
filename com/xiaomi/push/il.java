package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f614a;

    /* renamed from: a  reason: collision with other field name */
    public ib f615a;

    /* renamed from: a  reason: collision with other field name */
    public String f616a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f617a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f618a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f619a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f620a;

    /* renamed from: b  reason: collision with other field name */
    public String f621b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f622b;

    /* renamed from: c  reason: collision with other field name */
    public String f623c;

    /* renamed from: d  reason: collision with other field name */
    public String f624d;

    /* renamed from: e  reason: collision with other field name */
    public String f625e;

    /* renamed from: f  reason: collision with other field name */
    public String f626f;

    /* renamed from: g  reason: collision with other field name */
    public String f627g;

    /* renamed from: h  reason: collision with other field name */
    public String f628h;

    /* renamed from: i  reason: collision with other field name */
    public String f629i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f613a = new jn("XmPushActionNotification");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 2, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 13, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 13);
    private static final jf m = new jf("", Constants.GZIP_CAST_TYPE, 14);
    private static final jf n = new jf("", (byte) 10, 15);
    private static final jf o = new jf("", (byte) 2, 20);

    public il() {
        this.f618a = new BitSet(3);
        this.f620a = true;
        this.f622b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f621b = str;
        this.f620a = z;
        m435a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
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
        int a14;
        int a15;
        int a16;
        if (getClass().equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m436a()).compareTo(Boolean.valueOf(ilVar.m436a()));
            if (compareTo == 0) {
                if (!m436a() || (a16 = iy.a(this.f616a, ilVar.f616a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m439b()).compareTo(Boolean.valueOf(ilVar.m439b()));
                    if (compareTo2 == 0) {
                        if (!m439b() || (a15 = iy.a(this.f615a, ilVar.f615a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m440c()).compareTo(Boolean.valueOf(ilVar.m440c()));
                            if (compareTo3 == 0) {
                                if (!m440c() || (a14 = iy.a(this.f621b, ilVar.f621b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f623c, ilVar.f623c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f624d, ilVar.f624d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f620a, ilVar.f620a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f625e, ilVar.f625e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f619a, ilVar.f619a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f626f, ilVar.f626f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f627g, ilVar.f627g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f628h, ilVar.f628h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f629i, ilVar.f629i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f617a, ilVar.f617a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f614a, ilVar.f614a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f622b, ilVar.f622b)) == 0) {
                                                                                                                                    return 0;
                                                                                                                                }
                                                                                                                                return a2;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a3;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a4;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a5;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a6;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a7;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a8;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a9;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a10;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a11;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a12;
                                            }
                                            return compareTo5;
                                        }
                                        return a13;
                                    }
                                    return compareTo4;
                                }
                                return a14;
                            }
                            return compareTo3;
                        }
                        return a15;
                    }
                    return compareTo2;
                }
                return a16;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ilVar.getClass().getName());
    }

    public il a(String str) {
        this.f621b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f617a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f619a = map;
        return this;
    }

    public il a(boolean z) {
        this.f620a = z;
        m435a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f621b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m433a() {
        return this.f619a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m434a() {
        if (this.f621b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m434a();
                return;
            }
            switch (m485a.f780a) {
                case 1:
                    if (m485a.a == 11) {
                        this.f616a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 2:
                    if (m485a.a == 12) {
                        this.f615a = new ib();
                        this.f615a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 3:
                    if (m485a.a == 11) {
                        this.f621b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 4:
                    if (m485a.a == 11) {
                        this.f623c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 5:
                    if (m485a.a == 11) {
                        this.f624d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 6:
                    if (m485a.a == 2) {
                        this.f620a = jiVar.m494a();
                        m435a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 7:
                    if (m485a.a == 11) {
                        this.f625e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 8:
                    if (m485a.a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f619a = new HashMap(m487a.f782a * 2);
                        for (int i2 = 0; i2 < m487a.f782a; i2++) {
                            this.f619a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 9:
                    if (m485a.a == 11) {
                        this.f626f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 10:
                    if (m485a.a == 11) {
                        this.f627g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m485a.a);
                    break;
                case 12:
                    if (m485a.a == 11) {
                        this.f628h = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 13:
                    if (m485a.a == 11) {
                        this.f629i = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 14:
                    if (m485a.a == 11) {
                        this.f617a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 15:
                    if (m485a.a == 10) {
                        this.f614a = jiVar.m484a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 20:
                    if (m485a.a == 2) {
                        this.f622b = jiVar.m494a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f619a == null) {
            this.f619a = new HashMap();
        }
        this.f619a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m435a(boolean z) {
        this.f618a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a() {
        return this.f616a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m436a = m436a();
        boolean m436a2 = ilVar.m436a();
        if ((m436a || m436a2) && !(m436a && m436a2 && this.f616a.equals(ilVar.f616a))) {
            return false;
        }
        boolean m439b = m439b();
        boolean m439b2 = ilVar.m439b();
        if ((m439b || m439b2) && !(m439b && m439b2 && this.f615a.m398a(ilVar.f615a))) {
            return false;
        }
        boolean m440c = m440c();
        boolean m440c2 = ilVar.m440c();
        if ((m440c || m440c2) && !(m440c && m440c2 && this.f621b.equals(ilVar.f621b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f623c.equals(ilVar.f623c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f624d.equals(ilVar.f624d))) || this.f620a != ilVar.f620a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f625e.equals(ilVar.f625e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f619a.equals(ilVar.f619a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f626f.equals(ilVar.f626f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f627g.equals(ilVar.f627g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f628h.equals(ilVar.f628h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f629i.equals(ilVar.f629i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f617a.equals(ilVar.f617a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f614a == ilVar.f614a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f622b == ilVar.f622b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m438a() {
        a(iy.a(this.f617a));
        return this.f617a.array();
    }

    public il b(String str) {
        this.f623c = str;
        return this;
    }

    public String b() {
        return this.f623c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m434a();
        jiVar.a(f613a);
        if (this.f616a != null && m436a()) {
            jiVar.a(a);
            jiVar.a(this.f616a);
            jiVar.b();
        }
        if (this.f615a != null && m439b()) {
            jiVar.a(b);
            this.f615a.b(jiVar);
            jiVar.b();
        }
        if (this.f621b != null) {
            jiVar.a(c);
            jiVar.a(this.f621b);
            jiVar.b();
        }
        if (this.f623c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f623c);
            jiVar.b();
        }
        if (this.f624d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f624d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f620a);
        jiVar.b();
        if (this.f625e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f625e);
            jiVar.b();
        }
        if (this.f619a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f619a.size()));
            for (Map.Entry<String, String> entry : this.f619a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f626f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f626f);
            jiVar.b();
        }
        if (this.f627g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f627g);
            jiVar.b();
        }
        if (this.f628h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f628h);
            jiVar.b();
        }
        if (this.f629i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f629i);
            jiVar.b();
        }
        if (this.f617a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f617a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f614a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f622b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f618a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m439b() {
        return this.f615a != null;
    }

    public il c(String str) {
        this.f624d = str;
        return this;
    }

    public String c() {
        return this.f626f;
    }

    public void c(boolean z) {
        this.f618a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m440c() {
        return this.f621b != null;
    }

    public il d(String str) {
        this.f626f = str;
        return this;
    }

    public boolean d() {
        return this.f623c != null;
    }

    public boolean e() {
        return this.f624d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m437a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f618a.get(0);
    }

    public boolean g() {
        return this.f625e != null;
    }

    public boolean h() {
        return this.f619a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f626f != null;
    }

    public boolean j() {
        return this.f627g != null;
    }

    public boolean k() {
        return this.f628h != null;
    }

    public boolean l() {
        return this.f629i != null;
    }

    public boolean m() {
        return this.f617a != null;
    }

    public boolean n() {
        return this.f618a.get(1);
    }

    public boolean o() {
        return this.f618a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m436a()) {
            sb.append("debug:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
            z2 = false;
        }
        if (m439b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                sb.append(this.f615a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f621b == null) {
            sb.append("null");
        } else {
            sb.append(this.f621b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f623c == null) {
                sb.append("null");
            } else {
                sb.append(this.f623c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f624d == null) {
                sb.append("null");
            } else {
                sb.append(this.f624d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f620a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f625e == null) {
                sb.append("null");
            } else {
                sb.append(this.f625e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f619a == null) {
                sb.append("null");
            } else {
                sb.append(this.f619a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f626f == null) {
                sb.append("null");
            } else {
                sb.append(this.f626f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f627g == null) {
                sb.append("null");
            } else {
                sb.append(this.f627g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f628h == null) {
                sb.append("null");
            } else {
                sb.append(this.f628h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f629i == null) {
                sb.append("null");
            } else {
                sb.append(this.f629i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                iy.a(this.f617a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f614a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f622b);
        }
        sb.append(")");
        return sb.toString();
    }
}
