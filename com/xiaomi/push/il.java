package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f613a;

    /* renamed from: a  reason: collision with other field name */
    public ib f614a;

    /* renamed from: a  reason: collision with other field name */
    public String f615a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f616a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f617a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f618a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f619a;

    /* renamed from: b  reason: collision with other field name */
    public String f620b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f621b;

    /* renamed from: c  reason: collision with other field name */
    public String f622c;

    /* renamed from: d  reason: collision with other field name */
    public String f623d;

    /* renamed from: e  reason: collision with other field name */
    public String f624e;

    /* renamed from: f  reason: collision with other field name */
    public String f625f;

    /* renamed from: g  reason: collision with other field name */
    public String f626g;

    /* renamed from: h  reason: collision with other field name */
    public String f627h;

    /* renamed from: i  reason: collision with other field name */
    public String f628i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f612a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4751a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f617a = new BitSet(3);
        this.f619a = true;
        this.f621b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f620b = str;
        this.f619a = z;
        m428a(true);
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
            int compareTo = Boolean.valueOf(m429a()).compareTo(Boolean.valueOf(ilVar.m429a()));
            if (compareTo == 0) {
                if (!m429a() || (a16 = iy.a(this.f615a, ilVar.f615a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m432b()).compareTo(Boolean.valueOf(ilVar.m432b()));
                    if (compareTo2 == 0) {
                        if (!m432b() || (a15 = iy.a(this.f614a, ilVar.f614a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m433c()).compareTo(Boolean.valueOf(ilVar.m433c()));
                            if (compareTo3 == 0) {
                                if (!m433c() || (a14 = iy.a(this.f620b, ilVar.f620b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f622c, ilVar.f622c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f623d, ilVar.f623d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f619a, ilVar.f619a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f624e, ilVar.f624e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f618a, ilVar.f618a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f625f, ilVar.f625f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f626g, ilVar.f626g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f627h, ilVar.f627h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f628i, ilVar.f628i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f616a, ilVar.f616a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f613a, ilVar.f613a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f621b, ilVar.f621b)) == 0) {
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
        this.f620b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f616a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f618a = map;
        return this;
    }

    public il a(boolean z) {
        this.f619a = z;
        m428a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f620b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m426a() {
        return this.f618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m427a() {
        if (this.f620b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m427a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 11) {
                        this.f615a = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 2:
                    if (m478a.f4770a == 12) {
                        this.f614a = new ib();
                        this.f614a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 3:
                    if (m478a.f4770a == 11) {
                        this.f620b = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 4:
                    if (m478a.f4770a == 11) {
                        this.f622c = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 5:
                    if (m478a.f4770a == 11) {
                        this.f623d = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 6:
                    if (m478a.f4770a == 2) {
                        this.f619a = jiVar.m487a();
                        m428a(true);
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 7:
                    if (m478a.f4770a == 11) {
                        this.f624e = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 8:
                    if (m478a.f4770a == 13) {
                        jh m480a = jiVar.m480a();
                        this.f618a = new HashMap(m480a.f781a * 2);
                        for (int i2 = 0; i2 < m480a.f781a; i2++) {
                            this.f618a.put(jiVar.m483a(), jiVar.m483a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 9:
                    if (m478a.f4770a == 11) {
                        this.f625f = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 10:
                    if (m478a.f4770a == 11) {
                        this.f626g = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
                case 12:
                    if (m478a.f4770a == 11) {
                        this.f627h = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 13:
                    if (m478a.f4770a == 11) {
                        this.f628i = jiVar.m483a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 14:
                    if (m478a.f4770a == 11) {
                        this.f616a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 15:
                    if (m478a.f4770a == 10) {
                        this.f613a = jiVar.m477a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 20:
                    if (m478a.f4770a == 2) {
                        this.f621b = jiVar.m487a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f618a == null) {
            this.f618a = new HashMap();
        }
        this.f618a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m428a(boolean z) {
        this.f617a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a() {
        return this.f615a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m429a = m429a();
        boolean m429a2 = ilVar.m429a();
        if ((m429a || m429a2) && !(m429a && m429a2 && this.f615a.equals(ilVar.f615a))) {
            return false;
        }
        boolean m432b = m432b();
        boolean m432b2 = ilVar.m432b();
        if ((m432b || m432b2) && !(m432b && m432b2 && this.f614a.m391a(ilVar.f614a))) {
            return false;
        }
        boolean m433c = m433c();
        boolean m433c2 = ilVar.m433c();
        if ((m433c || m433c2) && !(m433c && m433c2 && this.f620b.equals(ilVar.f620b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f622c.equals(ilVar.f622c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f623d.equals(ilVar.f623d))) || this.f619a != ilVar.f619a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f624e.equals(ilVar.f624e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f618a.equals(ilVar.f618a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f625f.equals(ilVar.f625f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f626g.equals(ilVar.f626g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f627h.equals(ilVar.f627h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f628i.equals(ilVar.f628i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f616a.equals(ilVar.f616a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f613a == ilVar.f613a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f621b == ilVar.f621b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m431a() {
        a(iy.a(this.f616a));
        return this.f616a.array();
    }

    public il b(String str) {
        this.f622c = str;
        return this;
    }

    public String b() {
        return this.f622c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m427a();
        jiVar.a(f612a);
        if (this.f615a != null && m429a()) {
            jiVar.a(f4751a);
            jiVar.a(this.f615a);
            jiVar.b();
        }
        if (this.f614a != null && m432b()) {
            jiVar.a(b);
            this.f614a.b(jiVar);
            jiVar.b();
        }
        if (this.f620b != null) {
            jiVar.a(c);
            jiVar.a(this.f620b);
            jiVar.b();
        }
        if (this.f622c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f622c);
            jiVar.b();
        }
        if (this.f623d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f623d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f619a);
        jiVar.b();
        if (this.f624e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f624e);
            jiVar.b();
        }
        if (this.f618a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f618a.size()));
            for (Map.Entry<String, String> entry : this.f618a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f625f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f625f);
            jiVar.b();
        }
        if (this.f626g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f626g);
            jiVar.b();
        }
        if (this.f627h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f627h);
            jiVar.b();
        }
        if (this.f628i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f628i);
            jiVar.b();
        }
        if (this.f616a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f616a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f613a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f621b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public void b(boolean z) {
        this.f617a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m432b() {
        return this.f614a != null;
    }

    public il c(String str) {
        this.f623d = str;
        return this;
    }

    public String c() {
        return this.f625f;
    }

    public void c(boolean z) {
        this.f617a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m433c() {
        return this.f620b != null;
    }

    public il d(String str) {
        this.f625f = str;
        return this;
    }

    public boolean d() {
        return this.f622c != null;
    }

    public boolean e() {
        return this.f623d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m430a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f617a.get(0);
    }

    public boolean g() {
        return this.f624e != null;
    }

    public boolean h() {
        return this.f618a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f625f != null;
    }

    public boolean j() {
        return this.f626g != null;
    }

    public boolean k() {
        return this.f627h != null;
    }

    public boolean l() {
        return this.f628i != null;
    }

    public boolean m() {
        return this.f616a != null;
    }

    public boolean n() {
        return this.f617a.get(1);
    }

    public boolean o() {
        return this.f617a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m429a()) {
            sb.append("debug:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                sb.append(this.f615a);
            }
            z2 = false;
        }
        if (m432b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f614a == null) {
                sb.append("null");
            } else {
                sb.append(this.f614a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f620b == null) {
            sb.append("null");
        } else {
            sb.append(this.f620b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f622c == null) {
                sb.append("null");
            } else {
                sb.append(this.f622c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f623d == null) {
                sb.append("null");
            } else {
                sb.append(this.f623d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f619a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f624e == null) {
                sb.append("null");
            } else {
                sb.append(this.f624e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f618a == null) {
                sb.append("null");
            } else {
                sb.append(this.f618a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f625f == null) {
                sb.append("null");
            } else {
                sb.append(this.f625f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f626g == null) {
                sb.append("null");
            } else {
                sb.append(this.f626g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f627h == null) {
                sb.append("null");
            } else {
                sb.append(this.f627h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f628i == null) {
                sb.append("null");
            } else {
                sb.append(this.f628i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                iy.a(this.f616a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f613a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f621b);
        }
        sb.append(")");
        return sb.toString();
    }
}
