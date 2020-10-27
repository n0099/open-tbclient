package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f610a;

    /* renamed from: a  reason: collision with other field name */
    public ib f611a;

    /* renamed from: a  reason: collision with other field name */
    public String f612a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f613a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f614a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f615a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f616a;

    /* renamed from: b  reason: collision with other field name */
    public String f617b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f618b;

    /* renamed from: c  reason: collision with other field name */
    public String f619c;

    /* renamed from: d  reason: collision with other field name */
    public String f620d;

    /* renamed from: e  reason: collision with other field name */
    public String f621e;

    /* renamed from: f  reason: collision with other field name */
    public String f622f;

    /* renamed from: g  reason: collision with other field name */
    public String f623g;

    /* renamed from: h  reason: collision with other field name */
    public String f624h;

    /* renamed from: i  reason: collision with other field name */
    public String f625i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f609a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4979a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f614a = new BitSet(3);
        this.f616a = true;
        this.f618b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f617b = str;
        this.f616a = z;
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
                if (!m436a() || (a16 = iy.a(this.f612a, ilVar.f612a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m439b()).compareTo(Boolean.valueOf(ilVar.m439b()));
                    if (compareTo2 == 0) {
                        if (!m439b() || (a15 = iy.a(this.f611a, ilVar.f611a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m440c()).compareTo(Boolean.valueOf(ilVar.m440c()));
                            if (compareTo3 == 0) {
                                if (!m440c() || (a14 = iy.a(this.f617b, ilVar.f617b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f619c, ilVar.f619c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f620d, ilVar.f620d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f616a, ilVar.f616a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f621e, ilVar.f621e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f615a, ilVar.f615a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f622f, ilVar.f622f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f623g, ilVar.f623g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f624h, ilVar.f624h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f625i, ilVar.f625i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f613a, ilVar.f613a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f610a, ilVar.f610a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f618b, ilVar.f618b)) == 0) {
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
        this.f617b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f613a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f615a = map;
        return this;
    }

    public il a(boolean z) {
        this.f616a = z;
        m435a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f617b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m433a() {
        return this.f615a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m434a() {
        if (this.f617b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m434a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f612a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f611a = new ib();
                        this.f611a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f617b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f619c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f620d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 2) {
                        this.f616a = jiVar.m494a();
                        m435a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f621e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f615a = new HashMap(m487a.f778a * 2);
                        for (int i2 = 0; i2 < m487a.f778a; i2++) {
                            this.f615a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 9:
                    if (m485a.f4998a == 11) {
                        this.f622f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 11) {
                        this.f623g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 12:
                    if (m485a.f4998a == 11) {
                        this.f624h = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 13:
                    if (m485a.f4998a == 11) {
                        this.f625i = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 14:
                    if (m485a.f4998a == 11) {
                        this.f613a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 15:
                    if (m485a.f4998a == 10) {
                        this.f610a = jiVar.m484a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 20:
                    if (m485a.f4998a == 2) {
                        this.f618b = jiVar.m494a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f615a == null) {
            this.f615a = new HashMap();
        }
        this.f615a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m435a(boolean z) {
        this.f614a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a() {
        return this.f612a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m436a = m436a();
        boolean m436a2 = ilVar.m436a();
        if ((m436a || m436a2) && !(m436a && m436a2 && this.f612a.equals(ilVar.f612a))) {
            return false;
        }
        boolean m439b = m439b();
        boolean m439b2 = ilVar.m439b();
        if ((m439b || m439b2) && !(m439b && m439b2 && this.f611a.m398a(ilVar.f611a))) {
            return false;
        }
        boolean m440c = m440c();
        boolean m440c2 = ilVar.m440c();
        if ((m440c || m440c2) && !(m440c && m440c2 && this.f617b.equals(ilVar.f617b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f619c.equals(ilVar.f619c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f620d.equals(ilVar.f620d))) || this.f616a != ilVar.f616a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f621e.equals(ilVar.f621e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f615a.equals(ilVar.f615a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f622f.equals(ilVar.f622f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f623g.equals(ilVar.f623g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f624h.equals(ilVar.f624h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f625i.equals(ilVar.f625i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f613a.equals(ilVar.f613a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f610a == ilVar.f610a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f618b == ilVar.f618b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m438a() {
        a(iy.a(this.f613a));
        return this.f613a.array();
    }

    public il b(String str) {
        this.f619c = str;
        return this;
    }

    public String b() {
        return this.f619c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m434a();
        jiVar.a(f609a);
        if (this.f612a != null && m436a()) {
            jiVar.a(f4979a);
            jiVar.a(this.f612a);
            jiVar.b();
        }
        if (this.f611a != null && m439b()) {
            jiVar.a(b);
            this.f611a.b(jiVar);
            jiVar.b();
        }
        if (this.f617b != null) {
            jiVar.a(c);
            jiVar.a(this.f617b);
            jiVar.b();
        }
        if (this.f619c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f619c);
            jiVar.b();
        }
        if (this.f620d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f620d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f616a);
        jiVar.b();
        if (this.f621e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f621e);
            jiVar.b();
        }
        if (this.f615a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f615a.size()));
            for (Map.Entry<String, String> entry : this.f615a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f622f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f622f);
            jiVar.b();
        }
        if (this.f623g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f623g);
            jiVar.b();
        }
        if (this.f624h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f624h);
            jiVar.b();
        }
        if (this.f625i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f625i);
            jiVar.b();
        }
        if (this.f613a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f613a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f610a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f618b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f614a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m439b() {
        return this.f611a != null;
    }

    public il c(String str) {
        this.f620d = str;
        return this;
    }

    public String c() {
        return this.f622f;
    }

    public void c(boolean z) {
        this.f614a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m440c() {
        return this.f617b != null;
    }

    public il d(String str) {
        this.f622f = str;
        return this;
    }

    public boolean d() {
        return this.f619c != null;
    }

    public boolean e() {
        return this.f620d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m437a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f614a.get(0);
    }

    public boolean g() {
        return this.f621e != null;
    }

    public boolean h() {
        return this.f615a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f622f != null;
    }

    public boolean j() {
        return this.f623g != null;
    }

    public boolean k() {
        return this.f624h != null;
    }

    public boolean l() {
        return this.f625i != null;
    }

    public boolean m() {
        return this.f613a != null;
    }

    public boolean n() {
        return this.f614a.get(1);
    }

    public boolean o() {
        return this.f614a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m436a()) {
            sb.append("debug:");
            if (this.f612a == null) {
                sb.append("null");
            } else {
                sb.append(this.f612a);
            }
            z2 = false;
        }
        if (m439b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f611a == null) {
                sb.append("null");
            } else {
                sb.append(this.f611a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f617b == null) {
            sb.append("null");
        } else {
            sb.append(this.f617b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f619c == null) {
                sb.append("null");
            } else {
                sb.append(this.f619c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f620d == null) {
                sb.append("null");
            } else {
                sb.append(this.f620d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f616a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f621e == null) {
                sb.append("null");
            } else {
                sb.append(this.f621e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f615a == null) {
                sb.append("null");
            } else {
                sb.append(this.f615a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f622f == null) {
                sb.append("null");
            } else {
                sb.append(this.f622f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f623g == null) {
                sb.append("null");
            } else {
                sb.append(this.f623g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f624h == null) {
                sb.append("null");
            } else {
                sb.append(this.f624h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f625i == null) {
                sb.append("null");
            } else {
                sb.append(this.f625i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f613a == null) {
                sb.append("null");
            } else {
                iy.a(this.f613a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f610a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f618b);
        }
        sb.append(")");
        return sb.toString();
    }
}
