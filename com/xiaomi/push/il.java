package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f612a;

    /* renamed from: a  reason: collision with other field name */
    public ib f613a;

    /* renamed from: a  reason: collision with other field name */
    public String f614a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f615a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f616a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f617a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f618a;

    /* renamed from: b  reason: collision with other field name */
    public String f619b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f620b;

    /* renamed from: c  reason: collision with other field name */
    public String f621c;

    /* renamed from: d  reason: collision with other field name */
    public String f622d;

    /* renamed from: e  reason: collision with other field name */
    public String f623e;

    /* renamed from: f  reason: collision with other field name */
    public String f624f;

    /* renamed from: g  reason: collision with other field name */
    public String f625g;

    /* renamed from: h  reason: collision with other field name */
    public String f626h;

    /* renamed from: i  reason: collision with other field name */
    public String f627i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f611a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8444a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f616a = new BitSet(3);
        this.f618a = true;
        this.f620b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f619b = str;
        this.f618a = z;
        m439a(true);
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
            int compareTo = Boolean.valueOf(m440a()).compareTo(Boolean.valueOf(ilVar.m440a()));
            if (compareTo == 0) {
                if (!m440a() || (a16 = iy.a(this.f614a, ilVar.f614a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m443b()).compareTo(Boolean.valueOf(ilVar.m443b()));
                    if (compareTo2 == 0) {
                        if (!m443b() || (a15 = iy.a(this.f613a, ilVar.f613a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m444c()).compareTo(Boolean.valueOf(ilVar.m444c()));
                            if (compareTo3 == 0) {
                                if (!m444c() || (a14 = iy.a(this.f619b, ilVar.f619b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f621c, ilVar.f621c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f622d, ilVar.f622d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f618a, ilVar.f618a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f623e, ilVar.f623e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f617a, ilVar.f617a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f624f, ilVar.f624f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f625g, ilVar.f625g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f626h, ilVar.f626h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f627i, ilVar.f627i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f615a, ilVar.f615a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f612a, ilVar.f612a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f620b, ilVar.f620b)) == 0) {
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
        this.f619b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f615a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f617a = map;
        return this;
    }

    public il a(boolean z) {
        this.f618a = z;
        m439a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f619b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m437a() {
        return this.f617a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m438a() {
        if (this.f619b == null) {
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
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m438a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 11) {
                        this.f614a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 2:
                    if (m489a.f8463a == 12) {
                        this.f613a = new ib();
                        this.f613a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 3:
                    if (m489a.f8463a == 11) {
                        this.f619b = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 4:
                    if (m489a.f8463a == 11) {
                        this.f621c = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 5:
                    if (m489a.f8463a == 11) {
                        this.f622d = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 6:
                    if (m489a.f8463a == 2) {
                        this.f618a = jiVar.m498a();
                        m439a(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 7:
                    if (m489a.f8463a == 11) {
                        this.f623e = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 8:
                    if (m489a.f8463a == 13) {
                        jh m491a = jiVar.m491a();
                        this.f617a = new HashMap(m491a.f780a * 2);
                        for (int i2 = 0; i2 < m491a.f780a; i2++) {
                            this.f617a.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 9:
                    if (m489a.f8463a == 11) {
                        this.f624f = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 10:
                    if (m489a.f8463a == 11) {
                        this.f625g = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
                case 12:
                    if (m489a.f8463a == 11) {
                        this.f626h = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 13:
                    if (m489a.f8463a == 11) {
                        this.f627i = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 14:
                    if (m489a.f8463a == 11) {
                        this.f615a = jiVar.m495a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 15:
                    if (m489a.f8463a == 10) {
                        this.f612a = jiVar.m488a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 20:
                    if (m489a.f8463a == 2) {
                        this.f620b = jiVar.m498a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f617a == null) {
            this.f617a = new HashMap();
        }
        this.f617a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m439a(boolean z) {
        this.f616a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a() {
        return this.f614a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m440a = m440a();
        boolean m440a2 = ilVar.m440a();
        if ((m440a || m440a2) && !(m440a && m440a2 && this.f614a.equals(ilVar.f614a))) {
            return false;
        }
        boolean m443b = m443b();
        boolean m443b2 = ilVar.m443b();
        if ((m443b || m443b2) && !(m443b && m443b2 && this.f613a.m402a(ilVar.f613a))) {
            return false;
        }
        boolean m444c = m444c();
        boolean m444c2 = ilVar.m444c();
        if ((m444c || m444c2) && !(m444c && m444c2 && this.f619b.equals(ilVar.f619b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f621c.equals(ilVar.f621c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f622d.equals(ilVar.f622d))) || this.f618a != ilVar.f618a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f623e.equals(ilVar.f623e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f617a.equals(ilVar.f617a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f624f.equals(ilVar.f624f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f625g.equals(ilVar.f625g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f626h.equals(ilVar.f626h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f627i.equals(ilVar.f627i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f615a.equals(ilVar.f615a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f612a == ilVar.f612a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f620b == ilVar.f620b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m442a() {
        a(iy.a(this.f615a));
        return this.f615a.array();
    }

    public il b(String str) {
        this.f621c = str;
        return this;
    }

    public String b() {
        return this.f621c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m438a();
        jiVar.a(f611a);
        if (this.f614a != null && m440a()) {
            jiVar.a(f8444a);
            jiVar.a(this.f614a);
            jiVar.b();
        }
        if (this.f613a != null && m443b()) {
            jiVar.a(b);
            this.f613a.b(jiVar);
            jiVar.b();
        }
        if (this.f619b != null) {
            jiVar.a(c);
            jiVar.a(this.f619b);
            jiVar.b();
        }
        if (this.f621c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f621c);
            jiVar.b();
        }
        if (this.f622d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f622d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f618a);
        jiVar.b();
        if (this.f623e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f623e);
            jiVar.b();
        }
        if (this.f617a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f617a.size()));
            for (Map.Entry<String, String> entry : this.f617a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f624f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f624f);
            jiVar.b();
        }
        if (this.f625g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f625g);
            jiVar.b();
        }
        if (this.f626h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f626h);
            jiVar.b();
        }
        if (this.f627i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f627i);
            jiVar.b();
        }
        if (this.f615a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f615a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f612a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f620b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public void b(boolean z) {
        this.f616a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m443b() {
        return this.f613a != null;
    }

    public il c(String str) {
        this.f622d = str;
        return this;
    }

    public String c() {
        return this.f624f;
    }

    public void c(boolean z) {
        this.f616a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m444c() {
        return this.f619b != null;
    }

    public il d(String str) {
        this.f624f = str;
        return this;
    }

    public boolean d() {
        return this.f621c != null;
    }

    public boolean e() {
        return this.f622d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m441a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f616a.get(0);
    }

    public boolean g() {
        return this.f623e != null;
    }

    public boolean h() {
        return this.f617a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f624f != null;
    }

    public boolean j() {
        return this.f625g != null;
    }

    public boolean k() {
        return this.f626h != null;
    }

    public boolean l() {
        return this.f627i != null;
    }

    public boolean m() {
        return this.f615a != null;
    }

    public boolean n() {
        return this.f616a.get(1);
    }

    public boolean o() {
        return this.f616a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m440a()) {
            sb.append("debug:");
            if (this.f614a == null) {
                sb.append("null");
            } else {
                sb.append(this.f614a);
            }
            z2 = false;
        }
        if (m443b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f613a == null) {
                sb.append("null");
            } else {
                sb.append(this.f613a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f619b == null) {
            sb.append("null");
        } else {
            sb.append(this.f619b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f621c == null) {
                sb.append("null");
            } else {
                sb.append(this.f621c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f622d == null) {
                sb.append("null");
            } else {
                sb.append(this.f622d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f618a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f623e == null) {
                sb.append("null");
            } else {
                sb.append(this.f623e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                sb.append(this.f617a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f624f == null) {
                sb.append("null");
            } else {
                sb.append(this.f624f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f625g == null) {
                sb.append("null");
            } else {
                sb.append(this.f625g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f626h == null) {
                sb.append("null");
            } else {
                sb.append(this.f626h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f627i == null) {
                sb.append("null");
            } else {
                sb.append(this.f627i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                iy.a(this.f615a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f612a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f620b);
        }
        sb.append(")");
        return sb.toString();
    }
}
