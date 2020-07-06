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
    public long f618a;

    /* renamed from: a  reason: collision with other field name */
    public ib f619a;

    /* renamed from: a  reason: collision with other field name */
    public String f620a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f621a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f622a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f623a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f624a;

    /* renamed from: b  reason: collision with other field name */
    public String f625b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f626b;

    /* renamed from: c  reason: collision with other field name */
    public String f627c;

    /* renamed from: d  reason: collision with other field name */
    public String f628d;

    /* renamed from: e  reason: collision with other field name */
    public String f629e;

    /* renamed from: f  reason: collision with other field name */
    public String f630f;

    /* renamed from: g  reason: collision with other field name */
    public String f631g;

    /* renamed from: h  reason: collision with other field name */
    public String f632h;

    /* renamed from: i  reason: collision with other field name */
    public String f633i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f617a = new jn("XmPushActionNotification");
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
        this.f622a = new BitSet(3);
        this.f624a = true;
        this.f626b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f625b = str;
        this.f624a = z;
        m429a(true);
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
            int compareTo = Boolean.valueOf(m430a()).compareTo(Boolean.valueOf(ilVar.m430a()));
            if (compareTo == 0) {
                if (!m430a() || (a16 = iy.a(this.f620a, ilVar.f620a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m433b()).compareTo(Boolean.valueOf(ilVar.m433b()));
                    if (compareTo2 == 0) {
                        if (!m433b() || (a15 = iy.a(this.f619a, ilVar.f619a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m434c()).compareTo(Boolean.valueOf(ilVar.m434c()));
                            if (compareTo3 == 0) {
                                if (!m434c() || (a14 = iy.a(this.f625b, ilVar.f625b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f627c, ilVar.f627c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f628d, ilVar.f628d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f624a, ilVar.f624a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f629e, ilVar.f629e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f623a, ilVar.f623a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f630f, ilVar.f630f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f631g, ilVar.f631g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f632h, ilVar.f632h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f633i, ilVar.f633i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f621a, ilVar.f621a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f618a, ilVar.f618a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f626b, ilVar.f626b)) == 0) {
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
        this.f625b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f621a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f623a = map;
        return this;
    }

    public il a(boolean z) {
        this.f624a = z;
        m429a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f625b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m427a() {
        return this.f623a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m428a() {
        if (this.f625b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m428a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f620a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f619a = new ib();
                        this.f619a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f625b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f627c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f628d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 2) {
                        this.f624a = jiVar.m488a();
                        m429a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f629e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f623a = new HashMap(m481a.f786a * 2);
                        for (int i2 = 0; i2 < m481a.f786a; i2++) {
                            this.f623a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 11) {
                        this.f630f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 11) {
                        this.f631g = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 12:
                    if (m479a.a == 11) {
                        this.f632h = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 13:
                    if (m479a.a == 11) {
                        this.f633i = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 14:
                    if (m479a.a == 11) {
                        this.f621a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 15:
                    if (m479a.a == 10) {
                        this.f618a = jiVar.m478a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 20:
                    if (m479a.a == 2) {
                        this.f626b = jiVar.m488a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f623a == null) {
            this.f623a = new HashMap();
        }
        this.f623a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m429a(boolean z) {
        this.f622a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a() {
        return this.f620a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m430a = m430a();
        boolean m430a2 = ilVar.m430a();
        if ((m430a || m430a2) && !(m430a && m430a2 && this.f620a.equals(ilVar.f620a))) {
            return false;
        }
        boolean m433b = m433b();
        boolean m433b2 = ilVar.m433b();
        if ((m433b || m433b2) && !(m433b && m433b2 && this.f619a.m392a(ilVar.f619a))) {
            return false;
        }
        boolean m434c = m434c();
        boolean m434c2 = ilVar.m434c();
        if ((m434c || m434c2) && !(m434c && m434c2 && this.f625b.equals(ilVar.f625b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f627c.equals(ilVar.f627c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f628d.equals(ilVar.f628d))) || this.f624a != ilVar.f624a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f629e.equals(ilVar.f629e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f623a.equals(ilVar.f623a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f630f.equals(ilVar.f630f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f631g.equals(ilVar.f631g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f632h.equals(ilVar.f632h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f633i.equals(ilVar.f633i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f621a.equals(ilVar.f621a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f618a == ilVar.f618a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f626b == ilVar.f626b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m432a() {
        a(iy.a(this.f621a));
        return this.f621a.array();
    }

    public il b(String str) {
        this.f627c = str;
        return this;
    }

    public String b() {
        return this.f627c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m428a();
        jiVar.a(f617a);
        if (this.f620a != null && m430a()) {
            jiVar.a(a);
            jiVar.a(this.f620a);
            jiVar.b();
        }
        if (this.f619a != null && m433b()) {
            jiVar.a(b);
            this.f619a.b(jiVar);
            jiVar.b();
        }
        if (this.f625b != null) {
            jiVar.a(c);
            jiVar.a(this.f625b);
            jiVar.b();
        }
        if (this.f627c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f627c);
            jiVar.b();
        }
        if (this.f628d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f628d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f624a);
        jiVar.b();
        if (this.f629e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f629e);
            jiVar.b();
        }
        if (this.f623a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f623a.size()));
            for (Map.Entry<String, String> entry : this.f623a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f630f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f630f);
            jiVar.b();
        }
        if (this.f631g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f631g);
            jiVar.b();
        }
        if (this.f632h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f632h);
            jiVar.b();
        }
        if (this.f633i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f633i);
            jiVar.b();
        }
        if (this.f621a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f621a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f618a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f626b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f622a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m433b() {
        return this.f619a != null;
    }

    public il c(String str) {
        this.f628d = str;
        return this;
    }

    public String c() {
        return this.f630f;
    }

    public void c(boolean z) {
        this.f622a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m434c() {
        return this.f625b != null;
    }

    public il d(String str) {
        this.f630f = str;
        return this;
    }

    public boolean d() {
        return this.f627c != null;
    }

    public boolean e() {
        return this.f628d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m431a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f622a.get(0);
    }

    public boolean g() {
        return this.f629e != null;
    }

    public boolean h() {
        return this.f623a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f630f != null;
    }

    public boolean j() {
        return this.f631g != null;
    }

    public boolean k() {
        return this.f632h != null;
    }

    public boolean l() {
        return this.f633i != null;
    }

    public boolean m() {
        return this.f621a != null;
    }

    public boolean n() {
        return this.f622a.get(1);
    }

    public boolean o() {
        return this.f622a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m430a()) {
            sb.append("debug:");
            if (this.f620a == null) {
                sb.append("null");
            } else {
                sb.append(this.f620a);
            }
            z2 = false;
        }
        if (m433b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f619a == null) {
                sb.append("null");
            } else {
                sb.append(this.f619a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f625b == null) {
            sb.append("null");
        } else {
            sb.append(this.f625b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f627c == null) {
                sb.append("null");
            } else {
                sb.append(this.f627c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f628d == null) {
                sb.append("null");
            } else {
                sb.append(this.f628d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f624a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f629e == null) {
                sb.append("null");
            } else {
                sb.append(this.f629e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f623a == null) {
                sb.append("null");
            } else {
                sb.append(this.f623a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f630f == null) {
                sb.append("null");
            } else {
                sb.append(this.f630f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f631g == null) {
                sb.append("null");
            } else {
                sb.append(this.f631g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f632h == null) {
                sb.append("null");
            } else {
                sb.append(this.f632h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f633i == null) {
                sb.append("null");
            } else {
                sb.append(this.f633i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f621a == null) {
                sb.append("null");
            } else {
                iy.a(this.f621a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f618a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f626b);
        }
        sb.append(")");
        return sb.toString();
    }
}
