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
    public long f615a;

    /* renamed from: a  reason: collision with other field name */
    public ib f616a;

    /* renamed from: a  reason: collision with other field name */
    public String f617a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f618a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f619a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f620a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f621a;

    /* renamed from: b  reason: collision with other field name */
    public String f622b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f623b;

    /* renamed from: c  reason: collision with other field name */
    public String f624c;

    /* renamed from: d  reason: collision with other field name */
    public String f625d;

    /* renamed from: e  reason: collision with other field name */
    public String f626e;

    /* renamed from: f  reason: collision with other field name */
    public String f627f;

    /* renamed from: g  reason: collision with other field name */
    public String f628g;

    /* renamed from: h  reason: collision with other field name */
    public String f629h;

    /* renamed from: i  reason: collision with other field name */
    public String f630i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f614a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4981a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f619a = new BitSet(3);
        this.f621a = true;
        this.f623b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f622b = str;
        this.f621a = z;
        m438a(true);
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
            int compareTo = Boolean.valueOf(m439a()).compareTo(Boolean.valueOf(ilVar.m439a()));
            if (compareTo == 0) {
                if (!m439a() || (a16 = iy.a(this.f617a, ilVar.f617a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m442b()).compareTo(Boolean.valueOf(ilVar.m442b()));
                    if (compareTo2 == 0) {
                        if (!m442b() || (a15 = iy.a(this.f616a, ilVar.f616a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m443c()).compareTo(Boolean.valueOf(ilVar.m443c()));
                            if (compareTo3 == 0) {
                                if (!m443c() || (a14 = iy.a(this.f622b, ilVar.f622b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f624c, ilVar.f624c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f625d, ilVar.f625d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f621a, ilVar.f621a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f626e, ilVar.f626e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f620a, ilVar.f620a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f627f, ilVar.f627f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f628g, ilVar.f628g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f629h, ilVar.f629h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f630i, ilVar.f630i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f618a, ilVar.f618a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f615a, ilVar.f615a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f623b, ilVar.f623b)) == 0) {
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
        this.f622b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f618a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f620a = map;
        return this;
    }

    public il a(boolean z) {
        this.f621a = z;
        m438a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f622b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m436a() {
        return this.f620a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m437a() {
        if (this.f622b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m437a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f617a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f616a = new ib();
                        this.f616a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f622b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f624c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f625d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 2) {
                        this.f621a = jiVar.m497a();
                        m438a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f626e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f620a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f620a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 11) {
                        this.f627f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 11) {
                        this.f628g = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 12:
                    if (m488a.f5000a == 11) {
                        this.f629h = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 13:
                    if (m488a.f5000a == 11) {
                        this.f630i = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 14:
                    if (m488a.f5000a == 11) {
                        this.f618a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 15:
                    if (m488a.f5000a == 10) {
                        this.f615a = jiVar.m487a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 20:
                    if (m488a.f5000a == 2) {
                        this.f623b = jiVar.m497a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f620a == null) {
            this.f620a = new HashMap();
        }
        this.f620a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m438a(boolean z) {
        this.f619a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m439a() {
        return this.f617a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m439a = m439a();
        boolean m439a2 = ilVar.m439a();
        if ((m439a || m439a2) && !(m439a && m439a2 && this.f617a.equals(ilVar.f617a))) {
            return false;
        }
        boolean m442b = m442b();
        boolean m442b2 = ilVar.m442b();
        if ((m442b || m442b2) && !(m442b && m442b2 && this.f616a.m401a(ilVar.f616a))) {
            return false;
        }
        boolean m443c = m443c();
        boolean m443c2 = ilVar.m443c();
        if ((m443c || m443c2) && !(m443c && m443c2 && this.f622b.equals(ilVar.f622b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f624c.equals(ilVar.f624c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f625d.equals(ilVar.f625d))) || this.f621a != ilVar.f621a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f626e.equals(ilVar.f626e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f620a.equals(ilVar.f620a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f627f.equals(ilVar.f627f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f628g.equals(ilVar.f628g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f629h.equals(ilVar.f629h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f630i.equals(ilVar.f630i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f618a.equals(ilVar.f618a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f615a == ilVar.f615a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f623b == ilVar.f623b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m441a() {
        a(iy.a(this.f618a));
        return this.f618a.array();
    }

    public il b(String str) {
        this.f624c = str;
        return this;
    }

    public String b() {
        return this.f624c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m437a();
        jiVar.a(f614a);
        if (this.f617a != null && m439a()) {
            jiVar.a(f4981a);
            jiVar.a(this.f617a);
            jiVar.b();
        }
        if (this.f616a != null && m442b()) {
            jiVar.a(b);
            this.f616a.b(jiVar);
            jiVar.b();
        }
        if (this.f622b != null) {
            jiVar.a(c);
            jiVar.a(this.f622b);
            jiVar.b();
        }
        if (this.f624c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f624c);
            jiVar.b();
        }
        if (this.f625d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f625d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f621a);
        jiVar.b();
        if (this.f626e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f626e);
            jiVar.b();
        }
        if (this.f620a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f620a.size()));
            for (Map.Entry<String, String> entry : this.f620a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f627f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f627f);
            jiVar.b();
        }
        if (this.f628g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f628g);
            jiVar.b();
        }
        if (this.f629h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f629h);
            jiVar.b();
        }
        if (this.f630i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f630i);
            jiVar.b();
        }
        if (this.f618a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f618a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f615a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f623b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f619a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m442b() {
        return this.f616a != null;
    }

    public il c(String str) {
        this.f625d = str;
        return this;
    }

    public String c() {
        return this.f627f;
    }

    public void c(boolean z) {
        this.f619a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m443c() {
        return this.f622b != null;
    }

    public il d(String str) {
        this.f627f = str;
        return this;
    }

    public boolean d() {
        return this.f624c != null;
    }

    public boolean e() {
        return this.f625d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m440a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f619a.get(0);
    }

    public boolean g() {
        return this.f626e != null;
    }

    public boolean h() {
        return this.f620a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f627f != null;
    }

    public boolean j() {
        return this.f628g != null;
    }

    public boolean k() {
        return this.f629h != null;
    }

    public boolean l() {
        return this.f630i != null;
    }

    public boolean m() {
        return this.f618a != null;
    }

    public boolean n() {
        return this.f619a.get(1);
    }

    public boolean o() {
        return this.f619a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m439a()) {
            sb.append("debug:");
            if (this.f617a == null) {
                sb.append("null");
            } else {
                sb.append(this.f617a);
            }
            z2 = false;
        }
        if (m442b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f616a == null) {
                sb.append("null");
            } else {
                sb.append(this.f616a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f622b == null) {
            sb.append("null");
        } else {
            sb.append(this.f622b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f624c == null) {
                sb.append("null");
            } else {
                sb.append(this.f624c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f625d == null) {
                sb.append("null");
            } else {
                sb.append(this.f625d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f621a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f626e == null) {
                sb.append("null");
            } else {
                sb.append(this.f626e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f620a == null) {
                sb.append("null");
            } else {
                sb.append(this.f620a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f627f == null) {
                sb.append("null");
            } else {
                sb.append(this.f627f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f628g == null) {
                sb.append("null");
            } else {
                sb.append(this.f628g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f629h == null) {
                sb.append("null");
            } else {
                sb.append(this.f629h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f630i == null) {
                sb.append("null");
            } else {
                sb.append(this.f630i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f618a == null) {
                sb.append("null");
            } else {
                iy.a(this.f618a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f615a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f623b);
        }
        sb.append(")");
        return sb.toString();
    }
}
