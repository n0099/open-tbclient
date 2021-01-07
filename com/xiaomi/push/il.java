package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class il implements ix<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f692a;

    /* renamed from: a  reason: collision with other field name */
    public ib f693a;

    /* renamed from: a  reason: collision with other field name */
    public String f694a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f695a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f696a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f697a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f698a;

    /* renamed from: b  reason: collision with other field name */
    public String f699b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f700b;

    /* renamed from: c  reason: collision with other field name */
    public String f701c;

    /* renamed from: d  reason: collision with other field name */
    public String f702d;

    /* renamed from: e  reason: collision with other field name */
    public String f703e;

    /* renamed from: f  reason: collision with other field name */
    public String f704f;

    /* renamed from: g  reason: collision with other field name */
    public String f705g;

    /* renamed from: h  reason: collision with other field name */
    public String f706h;

    /* renamed from: i  reason: collision with other field name */
    public String f707i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f691a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14439a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14440b = new jf("", (byte) 12, 2);
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
        this.f696a = new BitSet(3);
        this.f698a = true;
        this.f700b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f699b = str;
        this.f698a = z;
        m465a(true);
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
            int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(ilVar.m466a()));
            if (compareTo == 0) {
                if (!m466a() || (a16 = iy.a(this.f694a, ilVar.f694a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m469b()).compareTo(Boolean.valueOf(ilVar.m469b()));
                    if (compareTo2 == 0) {
                        if (!m469b() || (a15 = iy.a(this.f693a, ilVar.f693a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m470c()).compareTo(Boolean.valueOf(ilVar.m470c()));
                            if (compareTo3 == 0) {
                                if (!m470c() || (a14 = iy.a(this.f699b, ilVar.f699b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f701c, ilVar.f701c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f702d, ilVar.f702d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f698a, ilVar.f698a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f703e, ilVar.f703e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f697a, ilVar.f697a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f704f, ilVar.f704f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f705g, ilVar.f705g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f706h, ilVar.f706h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f707i, ilVar.f707i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f695a, ilVar.f695a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f692a, ilVar.f692a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f700b, ilVar.f700b)) == 0) {
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
        this.f699b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f695a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f697a = map;
        return this;
    }

    public il a(boolean z) {
        this.f698a = z;
        m465a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f699b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m463a() {
        return this.f697a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m464a() {
        if (this.f699b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m464a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f694a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f693a = new ib();
                        this.f693a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f699b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f701c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f702d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 2) {
                        this.f698a = jiVar.m524a();
                        m465a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f703e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f697a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f697a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f704f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 11) {
                        this.f705g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 12:
                    if (m515a.f14471a == 11) {
                        this.f706h = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 13:
                    if (m515a.f14471a == 11) {
                        this.f707i = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 14:
                    if (m515a.f14471a == 11) {
                        this.f695a = jiVar.m521a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 15:
                    if (m515a.f14471a == 10) {
                        this.f692a = jiVar.m514a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 20:
                    if (m515a.f14471a == 2) {
                        this.f700b = jiVar.m524a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f697a == null) {
            this.f697a = new HashMap();
        }
        this.f697a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m465a(boolean z) {
        this.f696a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f694a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m466a = m466a();
        boolean m466a2 = ilVar.m466a();
        if ((m466a || m466a2) && !(m466a && m466a2 && this.f694a.equals(ilVar.f694a))) {
            return false;
        }
        boolean m469b = m469b();
        boolean m469b2 = ilVar.m469b();
        if ((m469b || m469b2) && !(m469b && m469b2 && this.f693a.m428a(ilVar.f693a))) {
            return false;
        }
        boolean m470c = m470c();
        boolean m470c2 = ilVar.m470c();
        if ((m470c || m470c2) && !(m470c && m470c2 && this.f699b.equals(ilVar.f699b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f701c.equals(ilVar.f701c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f702d.equals(ilVar.f702d))) || this.f698a != ilVar.f698a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f703e.equals(ilVar.f703e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f697a.equals(ilVar.f697a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f704f.equals(ilVar.f704f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f705g.equals(ilVar.f705g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f706h.equals(ilVar.f706h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f707i.equals(ilVar.f707i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f695a.equals(ilVar.f695a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f692a == ilVar.f692a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f700b == ilVar.f700b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m468a() {
        a(iy.a(this.f695a));
        return this.f695a.array();
    }

    public il b(String str) {
        this.f701c = str;
        return this;
    }

    public String b() {
        return this.f701c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m464a();
        jiVar.a(f691a);
        if (this.f694a != null && m466a()) {
            jiVar.a(f14439a);
            jiVar.a(this.f694a);
            jiVar.b();
        }
        if (this.f693a != null && m469b()) {
            jiVar.a(f14440b);
            this.f693a.b(jiVar);
            jiVar.b();
        }
        if (this.f699b != null) {
            jiVar.a(c);
            jiVar.a(this.f699b);
            jiVar.b();
        }
        if (this.f701c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f701c);
            jiVar.b();
        }
        if (this.f702d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f702d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f698a);
        jiVar.b();
        if (this.f703e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f703e);
            jiVar.b();
        }
        if (this.f697a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f697a.size()));
            for (Map.Entry<String, String> entry : this.f697a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f704f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f704f);
            jiVar.b();
        }
        if (this.f705g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f705g);
            jiVar.b();
        }
        if (this.f706h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f706h);
            jiVar.b();
        }
        if (this.f707i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f707i);
            jiVar.b();
        }
        if (this.f695a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f695a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f692a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f700b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f696a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m469b() {
        return this.f693a != null;
    }

    public il c(String str) {
        this.f702d = str;
        return this;
    }

    public String c() {
        return this.f704f;
    }

    public void c(boolean z) {
        this.f696a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m470c() {
        return this.f699b != null;
    }

    public il d(String str) {
        this.f704f = str;
        return this;
    }

    public boolean d() {
        return this.f701c != null;
    }

    public boolean e() {
        return this.f702d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m467a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f696a.get(0);
    }

    public boolean g() {
        return this.f703e != null;
    }

    public boolean h() {
        return this.f697a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f704f != null;
    }

    public boolean j() {
        return this.f705g != null;
    }

    public boolean k() {
        return this.f706h != null;
    }

    public boolean l() {
        return this.f707i != null;
    }

    public boolean m() {
        return this.f695a != null;
    }

    public boolean n() {
        return this.f696a.get(1);
    }

    public boolean o() {
        return this.f696a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m466a()) {
            sb.append("debug:");
            if (this.f694a == null) {
                sb.append("null");
            } else {
                sb.append(this.f694a);
            }
            z2 = false;
        }
        if (m469b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f699b == null) {
            sb.append("null");
        } else {
            sb.append(this.f699b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f701c == null) {
                sb.append("null");
            } else {
                sb.append(this.f701c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f702d == null) {
                sb.append("null");
            } else {
                sb.append(this.f702d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f698a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f703e == null) {
                sb.append("null");
            } else {
                sb.append(this.f703e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f697a == null) {
                sb.append("null");
            } else {
                sb.append(this.f697a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f704f == null) {
                sb.append("null");
            } else {
                sb.append(this.f704f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f705g == null) {
                sb.append("null");
            } else {
                sb.append(this.f705g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f706h == null) {
                sb.append("null");
            } else {
                sb.append(this.f706h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f707i == null) {
                sb.append("null");
            } else {
                sb.append(this.f707i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f695a == null) {
                sb.append("null");
            } else {
                iy.a(this.f695a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f692a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f700b);
        }
        sb.append(")");
        return sb.toString();
    }
}
