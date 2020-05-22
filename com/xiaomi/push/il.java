package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f611a;

    /* renamed from: a  reason: collision with other field name */
    public ib f612a;

    /* renamed from: a  reason: collision with other field name */
    public String f613a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f614a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f615a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f616a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f617a;

    /* renamed from: b  reason: collision with other field name */
    public String f618b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f619b;

    /* renamed from: c  reason: collision with other field name */
    public String f620c;

    /* renamed from: d  reason: collision with other field name */
    public String f621d;

    /* renamed from: e  reason: collision with other field name */
    public String f622e;

    /* renamed from: f  reason: collision with other field name */
    public String f623f;

    /* renamed from: g  reason: collision with other field name */
    public String f624g;

    /* renamed from: h  reason: collision with other field name */
    public String f625h;

    /* renamed from: i  reason: collision with other field name */
    public String f626i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f610a = new jn("XmPushActionNotification");
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
        this.f615a = new BitSet(3);
        this.f617a = true;
        this.f619b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f618b = str;
        this.f617a = z;
        m433a(true);
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
            int compareTo = Boolean.valueOf(m434a()).compareTo(Boolean.valueOf(ilVar.m434a()));
            if (compareTo == 0) {
                if (!m434a() || (a16 = iy.a(this.f613a, ilVar.f613a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m437b()).compareTo(Boolean.valueOf(ilVar.m437b()));
                    if (compareTo2 == 0) {
                        if (!m437b() || (a15 = iy.a(this.f612a, ilVar.f612a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m438c()).compareTo(Boolean.valueOf(ilVar.m438c()));
                            if (compareTo3 == 0) {
                                if (!m438c() || (a14 = iy.a(this.f618b, ilVar.f618b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f620c, ilVar.f620c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f621d, ilVar.f621d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f617a, ilVar.f617a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f622e, ilVar.f622e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f616a, ilVar.f616a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f623f, ilVar.f623f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f624g, ilVar.f624g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f625h, ilVar.f625h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f626i, ilVar.f626i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f614a, ilVar.f614a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f611a, ilVar.f611a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f619b, ilVar.f619b)) == 0) {
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
        this.f618b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f614a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f616a = map;
        return this;
    }

    public il a(boolean z) {
        this.f617a = z;
        m433a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f618b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m431a() {
        return this.f616a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m432a() {
        if (this.f618b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m432a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a == 11) {
                        this.f613a = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 2:
                    if (m483a.a == 12) {
                        this.f612a = new ib();
                        this.f612a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 3:
                    if (m483a.a == 11) {
                        this.f618b = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 4:
                    if (m483a.a == 11) {
                        this.f620c = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 5:
                    if (m483a.a == 11) {
                        this.f621d = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 6:
                    if (m483a.a == 2) {
                        this.f617a = jiVar.m492a();
                        m433a(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 7:
                    if (m483a.a == 11) {
                        this.f622e = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 8:
                    if (m483a.a == 13) {
                        jh m485a = jiVar.m485a();
                        this.f616a = new HashMap(m485a.f779a * 2);
                        for (int i2 = 0; i2 < m485a.f779a; i2++) {
                            this.f616a.put(jiVar.m488a(), jiVar.m488a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 9:
                    if (m483a.a == 11) {
                        this.f623f = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 10:
                    if (m483a.a == 11) {
                        this.f624g = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m483a.a);
                    break;
                case 12:
                    if (m483a.a == 11) {
                        this.f625h = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 13:
                    if (m483a.a == 11) {
                        this.f626i = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 14:
                    if (m483a.a == 11) {
                        this.f614a = jiVar.m489a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 15:
                    if (m483a.a == 10) {
                        this.f611a = jiVar.m482a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 20:
                    if (m483a.a == 2) {
                        this.f619b = jiVar.m492a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f616a == null) {
            this.f616a = new HashMap();
        }
        this.f616a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m433a(boolean z) {
        this.f615a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a() {
        return this.f613a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m434a = m434a();
        boolean m434a2 = ilVar.m434a();
        if ((m434a || m434a2) && !(m434a && m434a2 && this.f613a.equals(ilVar.f613a))) {
            return false;
        }
        boolean m437b = m437b();
        boolean m437b2 = ilVar.m437b();
        if ((m437b || m437b2) && !(m437b && m437b2 && this.f612a.m396a(ilVar.f612a))) {
            return false;
        }
        boolean m438c = m438c();
        boolean m438c2 = ilVar.m438c();
        if ((m438c || m438c2) && !(m438c && m438c2 && this.f618b.equals(ilVar.f618b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f620c.equals(ilVar.f620c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f621d.equals(ilVar.f621d))) || this.f617a != ilVar.f617a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f622e.equals(ilVar.f622e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f616a.equals(ilVar.f616a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f623f.equals(ilVar.f623f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f624g.equals(ilVar.f624g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f625h.equals(ilVar.f625h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f626i.equals(ilVar.f626i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f614a.equals(ilVar.f614a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f611a == ilVar.f611a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f619b == ilVar.f619b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m436a() {
        a(iy.a(this.f614a));
        return this.f614a.array();
    }

    public il b(String str) {
        this.f620c = str;
        return this;
    }

    public String b() {
        return this.f620c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m432a();
        jiVar.a(f610a);
        if (this.f613a != null && m434a()) {
            jiVar.a(a);
            jiVar.a(this.f613a);
            jiVar.b();
        }
        if (this.f612a != null && m437b()) {
            jiVar.a(b);
            this.f612a.b(jiVar);
            jiVar.b();
        }
        if (this.f618b != null) {
            jiVar.a(c);
            jiVar.a(this.f618b);
            jiVar.b();
        }
        if (this.f620c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f620c);
            jiVar.b();
        }
        if (this.f621d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f621d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f617a);
        jiVar.b();
        if (this.f622e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f622e);
            jiVar.b();
        }
        if (this.f616a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f616a.size()));
            for (Map.Entry<String, String> entry : this.f616a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f623f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f623f);
            jiVar.b();
        }
        if (this.f624g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f624g);
            jiVar.b();
        }
        if (this.f625h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f625h);
            jiVar.b();
        }
        if (this.f626i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f626i);
            jiVar.b();
        }
        if (this.f614a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f614a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f611a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f619b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f615a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m437b() {
        return this.f612a != null;
    }

    public il c(String str) {
        this.f621d = str;
        return this;
    }

    public String c() {
        return this.f623f;
    }

    public void c(boolean z) {
        this.f615a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m438c() {
        return this.f618b != null;
    }

    public il d(String str) {
        this.f623f = str;
        return this;
    }

    public boolean d() {
        return this.f620c != null;
    }

    public boolean e() {
        return this.f621d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m435a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f615a.get(0);
    }

    public boolean g() {
        return this.f622e != null;
    }

    public boolean h() {
        return this.f616a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f623f != null;
    }

    public boolean j() {
        return this.f624g != null;
    }

    public boolean k() {
        return this.f625h != null;
    }

    public boolean l() {
        return this.f626i != null;
    }

    public boolean m() {
        return this.f614a != null;
    }

    public boolean n() {
        return this.f615a.get(1);
    }

    public boolean o() {
        return this.f615a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m434a()) {
            sb.append("debug:");
            if (this.f613a == null) {
                sb.append("null");
            } else {
                sb.append(this.f613a);
            }
            z2 = false;
        }
        if (m437b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f612a == null) {
                sb.append("null");
            } else {
                sb.append(this.f612a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f618b == null) {
            sb.append("null");
        } else {
            sb.append(this.f618b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f620c == null) {
                sb.append("null");
            } else {
                sb.append(this.f620c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f621d == null) {
                sb.append("null");
            } else {
                sb.append(this.f621d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f617a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f622e == null) {
                sb.append("null");
            } else {
                sb.append(this.f622e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f623f == null) {
                sb.append("null");
            } else {
                sb.append(this.f623f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f624g == null) {
                sb.append("null");
            } else {
                sb.append(this.f624g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f625h == null) {
                sb.append("null");
            } else {
                sb.append(this.f625h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f626i == null) {
                sb.append("null");
            } else {
                sb.append(this.f626i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f614a == null) {
                sb.append("null");
            } else {
                iy.a(this.f614a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f611a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f619b);
        }
        sb.append(")");
        return sb.toString();
    }
}
