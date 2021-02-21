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
    public long f691a;

    /* renamed from: a  reason: collision with other field name */
    public ib f692a;

    /* renamed from: a  reason: collision with other field name */
    public String f693a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f694a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f695a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f696a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f697a;

    /* renamed from: b  reason: collision with other field name */
    public String f698b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f699b;

    /* renamed from: c  reason: collision with other field name */
    public String f700c;

    /* renamed from: d  reason: collision with other field name */
    public String f701d;

    /* renamed from: e  reason: collision with other field name */
    public String f702e;

    /* renamed from: f  reason: collision with other field name */
    public String f703f;

    /* renamed from: g  reason: collision with other field name */
    public String f704g;

    /* renamed from: h  reason: collision with other field name */
    public String f705h;

    /* renamed from: i  reason: collision with other field name */
    public String f706i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f690a = new jn("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14141a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14142b = new jf("", (byte) 12, 2);
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
        this.f695a = new BitSet(3);
        this.f697a = true;
        this.f699b = false;
    }

    public il(String str, boolean z) {
        this();
        this.f698b = str;
        this.f697a = z;
        m460a(true);
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
            int compareTo = Boolean.valueOf(m461a()).compareTo(Boolean.valueOf(ilVar.m461a()));
            if (compareTo == 0) {
                if (!m461a() || (a16 = iy.a(this.f693a, ilVar.f693a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m464b()).compareTo(Boolean.valueOf(ilVar.m464b()));
                    if (compareTo2 == 0) {
                        if (!m464b() || (a15 = iy.a(this.f692a, ilVar.f692a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m465c()).compareTo(Boolean.valueOf(ilVar.m465c()));
                            if (compareTo3 == 0) {
                                if (!m465c() || (a14 = iy.a(this.f698b, ilVar.f698b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = iy.a(this.f700c, ilVar.f700c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = iy.a(this.f701d, ilVar.f701d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = iy.a(this.f697a, ilVar.f697a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = iy.a(this.f702e, ilVar.f702e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = iy.a(this.f696a, ilVar.f696a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = iy.a(this.f703f, ilVar.f703f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = iy.a(this.f704g, ilVar.f704g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = iy.a(this.f705h, ilVar.f705h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = iy.a(this.f706i, ilVar.f706i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ilVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = iy.a(this.f694a, ilVar.f694a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ilVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = iy.a(this.f691a, ilVar.f691a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ilVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = iy.a(this.f699b, ilVar.f699b)) == 0) {
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
        this.f698b = str;
        return this;
    }

    public il a(ByteBuffer byteBuffer) {
        this.f694a = byteBuffer;
        return this;
    }

    public il a(Map<String, String> map) {
        this.f696a = map;
        return this;
    }

    public il a(boolean z) {
        this.f697a = z;
        m460a(true);
        return this;
    }

    public il a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f698b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m458a() {
        return this.f696a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m459a() {
        if (this.f698b == null) {
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
                if (!f()) {
                    throw new jj("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m459a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a == 11) {
                        this.f693a = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 2:
                    if (m510a.f14173a == 12) {
                        this.f692a = new ib();
                        this.f692a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 3:
                    if (m510a.f14173a == 11) {
                        this.f698b = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 4:
                    if (m510a.f14173a == 11) {
                        this.f700c = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 5:
                    if (m510a.f14173a == 11) {
                        this.f701d = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 6:
                    if (m510a.f14173a == 2) {
                        this.f697a = jiVar.m519a();
                        m460a(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 7:
                    if (m510a.f14173a == 11) {
                        this.f702e = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 8:
                    if (m510a.f14173a == 13) {
                        jh m512a = jiVar.m512a();
                        this.f696a = new HashMap(m512a.f859a * 2);
                        for (int i2 = 0; i2 < m512a.f859a; i2++) {
                            this.f696a.put(jiVar.m515a(), jiVar.m515a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 9:
                    if (m510a.f14173a == 11) {
                        this.f703f = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 10:
                    if (m510a.f14173a == 11) {
                        this.f704g = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
                case 12:
                    if (m510a.f14173a == 11) {
                        this.f705h = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 13:
                    if (m510a.f14173a == 11) {
                        this.f706i = jiVar.m515a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 14:
                    if (m510a.f14173a == 11) {
                        this.f694a = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 15:
                    if (m510a.f14173a == 10) {
                        this.f691a = jiVar.m509a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                case 20:
                    if (m510a.f14173a == 2) {
                        this.f699b = jiVar.m519a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f696a == null) {
            this.f696a = new HashMap();
        }
        this.f696a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m460a(boolean z) {
        this.f695a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m461a() {
        return this.f693a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m461a = m461a();
        boolean m461a2 = ilVar.m461a();
        if ((m461a || m461a2) && !(m461a && m461a2 && this.f693a.equals(ilVar.f693a))) {
            return false;
        }
        boolean m464b = m464b();
        boolean m464b2 = ilVar.m464b();
        if ((m464b || m464b2) && !(m464b && m464b2 && this.f692a.m423a(ilVar.f692a))) {
            return false;
        }
        boolean m465c = m465c();
        boolean m465c2 = ilVar.m465c();
        if ((m465c || m465c2) && !(m465c && m465c2 && this.f698b.equals(ilVar.f698b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f700c.equals(ilVar.f700c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f701d.equals(ilVar.f701d))) || this.f697a != ilVar.f697a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f702e.equals(ilVar.f702e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f696a.equals(ilVar.f696a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f703f.equals(ilVar.f703f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f704g.equals(ilVar.f704g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f705h.equals(ilVar.f705h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f706i.equals(ilVar.f706i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ilVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f694a.equals(ilVar.f694a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ilVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f691a == ilVar.f691a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ilVar.o();
        return !(o2 || o3) || (o2 && o3 && this.f699b == ilVar.f699b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m463a() {
        a(iy.a(this.f694a));
        return this.f694a.array();
    }

    public il b(String str) {
        this.f700c = str;
        return this;
    }

    public String b() {
        return this.f700c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m459a();
        jiVar.a(f690a);
        if (this.f693a != null && m461a()) {
            jiVar.a(f14141a);
            jiVar.a(this.f693a);
            jiVar.b();
        }
        if (this.f692a != null && m464b()) {
            jiVar.a(f14142b);
            this.f692a.b(jiVar);
            jiVar.b();
        }
        if (this.f698b != null) {
            jiVar.a(c);
            jiVar.a(this.f698b);
            jiVar.b();
        }
        if (this.f700c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f700c);
            jiVar.b();
        }
        if (this.f701d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f701d);
            jiVar.b();
        }
        jiVar.a(f);
        jiVar.a(this.f697a);
        jiVar.b();
        if (this.f702e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f702e);
            jiVar.b();
        }
        if (this.f696a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f696a.size()));
            for (Map.Entry<String, String> entry : this.f696a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f703f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f703f);
            jiVar.b();
        }
        if (this.f704g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f704g);
            jiVar.b();
        }
        if (this.f705h != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f705h);
            jiVar.b();
        }
        if (this.f706i != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f706i);
            jiVar.b();
        }
        if (this.f694a != null && m()) {
            jiVar.a(m);
            jiVar.a(this.f694a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f691a);
            jiVar.b();
        }
        if (o()) {
            jiVar.a(o);
            jiVar.a(this.f699b);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public void b(boolean z) {
        this.f695a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m464b() {
        return this.f692a != null;
    }

    public il c(String str) {
        this.f701d = str;
        return this;
    }

    public String c() {
        return this.f703f;
    }

    public void c(boolean z) {
        this.f695a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m465c() {
        return this.f698b != null;
    }

    public il d(String str) {
        this.f703f = str;
        return this;
    }

    public boolean d() {
        return this.f700c != null;
    }

    public boolean e() {
        return this.f701d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m462a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f695a.get(0);
    }

    public boolean g() {
        return this.f702e != null;
    }

    public boolean h() {
        return this.f696a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f703f != null;
    }

    public boolean j() {
        return this.f704g != null;
    }

    public boolean k() {
        return this.f705h != null;
    }

    public boolean l() {
        return this.f706i != null;
    }

    public boolean m() {
        return this.f694a != null;
    }

    public boolean n() {
        return this.f695a.get(1);
    }

    public boolean o() {
        return this.f695a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m461a()) {
            sb.append("debug:");
            if (this.f693a == null) {
                sb.append("null");
            } else {
                sb.append(this.f693a);
            }
            z2 = false;
        }
        if (m464b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f692a == null) {
                sb.append("null");
            } else {
                sb.append(this.f692a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f698b == null) {
            sb.append("null");
        } else {
            sb.append(this.f698b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f700c == null) {
                sb.append("null");
            } else {
                sb.append(this.f700c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f701d == null) {
                sb.append("null");
            } else {
                sb.append(this.f701d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f697a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f702e == null) {
                sb.append("null");
            } else {
                sb.append(this.f702e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f696a == null) {
                sb.append("null");
            } else {
                sb.append(this.f696a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f703f == null) {
                sb.append("null");
            } else {
                sb.append(this.f703f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f704g == null) {
                sb.append("null");
            } else {
                sb.append(this.f704g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f705h == null) {
                sb.append("null");
            } else {
                sb.append(this.f705h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f706i == null) {
                sb.append("null");
            } else {
                sb.append(this.f706i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f694a == null) {
                sb.append("null");
            } else {
                iy.a(this.f694a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f691a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f699b);
        }
        sb.append(")");
        return sb.toString();
    }
}
