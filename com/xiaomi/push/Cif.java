package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes5.dex */
public class Cif implements ir<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f629a;

    /* renamed from: a  reason: collision with other field name */
    public hv f630a;

    /* renamed from: a  reason: collision with other field name */
    public String f631a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f632a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f633a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f634a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f635a;

    /* renamed from: b  reason: collision with other field name */
    public String f636b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f637b;

    /* renamed from: c  reason: collision with other field name */
    public String f638c;

    /* renamed from: d  reason: collision with other field name */
    public String f639d;

    /* renamed from: e  reason: collision with other field name */
    public String f640e;

    /* renamed from: f  reason: collision with other field name */
    public String f641f;

    /* renamed from: g  reason: collision with other field name */
    public String f642g;

    /* renamed from: h  reason: collision with other field name */
    public String f643h;

    /* renamed from: i  reason: collision with other field name */
    public String f644i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f628a = new jh("XmPushActionNotification");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", (byte) 2, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 13, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 12);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 13);
    private static final iz m = new iz("", Constants.GZIP_CAST_TYPE, 14);
    private static final iz n = new iz("", (byte) 10, 15);
    private static final iz o = new iz("", (byte) 2, 20);

    public Cif() {
        this.f633a = new BitSet(3);
        this.f635a = true;
        this.f637b = false;
    }

    public Cif(String str, boolean z) {
        this();
        this.f636b = str;
        this.f635a = z;
        m404a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
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
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(cif.m405a()));
            if (compareTo == 0) {
                if (!m405a() || (a16 = is.a(this.f631a, cif.f631a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m408b()).compareTo(Boolean.valueOf(cif.m408b()));
                    if (compareTo2 == 0) {
                        if (!m408b() || (a15 = is.a(this.f630a, cif.f630a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m409c()).compareTo(Boolean.valueOf(cif.m409c()));
                            if (compareTo3 == 0) {
                                if (!m409c() || (a14 = is.a(this.f636b, cif.f636b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = is.a(this.f638c, cif.f638c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = is.a(this.f639d, cif.f639d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = is.a(this.f635a, cif.f635a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = is.a(this.f640e, cif.f640e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = is.a(this.f634a, cif.f634a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = is.a(this.f641f, cif.f641f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = is.a(this.f642g, cif.f642g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = is.a(this.f643h, cif.f643h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = is.a(this.f644i, cif.f644i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = is.a(this.f632a, cif.f632a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = is.a(this.f629a, cif.f629a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = is.a(this.f637b, cif.f637b)) == 0) {
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
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(String str) {
        this.f636b = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f632a = byteBuffer;
        return this;
    }

    public Cif a(Map<String, String> map) {
        this.f634a = map;
        return this;
    }

    public Cif a(boolean z) {
        this.f635a = z;
        m404a(true);
        return this;
    }

    public Cif a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f636b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m402a() {
        return this.f634a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m403a() {
        if (this.f636b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!f()) {
                    throw new jd("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m403a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f631a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f630a = new hv();
                        this.f630a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f636b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f638c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f639d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 2) {
                        this.f635a = jcVar.m463a();
                        m404a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f640e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f634a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f634a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 11) {
                        this.f641f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 11) {
                        this.f642g = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 12:
                    if (m454a.a == 11) {
                        this.f643h = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 13:
                    if (m454a.a == 11) {
                        this.f644i = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 14:
                    if (m454a.a == 11) {
                        this.f632a = jcVar.m460a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 15:
                    if (m454a.a == 10) {
                        this.f629a = jcVar.m453a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 20:
                    if (m454a.a == 2) {
                        this.f637b = jcVar.m463a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f634a == null) {
            this.f634a = new HashMap();
        }
        this.f634a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m404a(boolean z) {
        this.f633a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f631a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m405a = m405a();
        boolean m405a2 = cif.m405a();
        if ((m405a || m405a2) && !(m405a && m405a2 && this.f631a.equals(cif.f631a))) {
            return false;
        }
        boolean m408b = m408b();
        boolean m408b2 = cif.m408b();
        if ((m408b || m408b2) && !(m408b && m408b2 && this.f630a.m364a(cif.f630a))) {
            return false;
        }
        boolean m409c = m409c();
        boolean m409c2 = cif.m409c();
        if ((m409c || m409c2) && !(m409c && m409c2 && this.f636b.equals(cif.f636b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cif.d();
        if ((d2 || d3) && !(d2 && d3 && this.f638c.equals(cif.f638c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cif.e();
        if (((e2 || e3) && !(e2 && e3 && this.f639d.equals(cif.f639d))) || this.f635a != cif.f635a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cif.g();
        if ((g2 || g3) && !(g2 && g3 && this.f640e.equals(cif.f640e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cif.h();
        if ((h2 || h3) && !(h2 && h3 && this.f634a.equals(cif.f634a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cif.i();
        if ((i2 || i3) && !(i2 && i3 && this.f641f.equals(cif.f641f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cif.j();
        if ((j2 || j3) && !(j2 && j3 && this.f642g.equals(cif.f642g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = cif.k();
        if ((k2 || k3) && !(k2 && k3 && this.f643h.equals(cif.f643h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = cif.l();
        if ((l2 || l3) && !(l2 && l3 && this.f644i.equals(cif.f644i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = cif.m();
        if ((m2 || m3) && !(m2 && m3 && this.f632a.equals(cif.f632a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = cif.n();
        if ((n2 || n3) && !(n2 && n3 && this.f629a == cif.f629a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = cif.o();
        return !(o2 || o3) || (o2 && o3 && this.f637b == cif.f637b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m407a() {
        a(is.a(this.f632a));
        return this.f632a.array();
    }

    public Cif b(String str) {
        this.f638c = str;
        return this;
    }

    public String b() {
        return this.f638c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m403a();
        jcVar.a(f628a);
        if (this.f631a != null && m405a()) {
            jcVar.a(a);
            jcVar.a(this.f631a);
            jcVar.b();
        }
        if (this.f630a != null && m408b()) {
            jcVar.a(b);
            this.f630a.b(jcVar);
            jcVar.b();
        }
        if (this.f636b != null) {
            jcVar.a(c);
            jcVar.a(this.f636b);
            jcVar.b();
        }
        if (this.f638c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f638c);
            jcVar.b();
        }
        if (this.f639d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f639d);
            jcVar.b();
        }
        jcVar.a(f);
        jcVar.a(this.f635a);
        jcVar.b();
        if (this.f640e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f640e);
            jcVar.b();
        }
        if (this.f634a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f634a.size()));
            for (Map.Entry<String, String> entry : this.f634a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f641f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f641f);
            jcVar.b();
        }
        if (this.f642g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f642g);
            jcVar.b();
        }
        if (this.f643h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f643h);
            jcVar.b();
        }
        if (this.f644i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f644i);
            jcVar.b();
        }
        if (this.f632a != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f632a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f629a);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f637b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f633a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m408b() {
        return this.f630a != null;
    }

    public Cif c(String str) {
        this.f639d = str;
        return this;
    }

    public String c() {
        return this.f641f;
    }

    public void c(boolean z) {
        this.f633a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m409c() {
        return this.f636b != null;
    }

    public Cif d(String str) {
        this.f641f = str;
        return this;
    }

    public boolean d() {
        return this.f638c != null;
    }

    public boolean e() {
        return this.f639d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m406a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f633a.get(0);
    }

    public boolean g() {
        return this.f640e != null;
    }

    public boolean h() {
        return this.f634a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f641f != null;
    }

    public boolean j() {
        return this.f642g != null;
    }

    public boolean k() {
        return this.f643h != null;
    }

    public boolean l() {
        return this.f644i != null;
    }

    public boolean m() {
        return this.f632a != null;
    }

    public boolean n() {
        return this.f633a.get(1);
    }

    public boolean o() {
        return this.f633a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m405a()) {
            sb.append("debug:");
            if (this.f631a == null) {
                sb.append("null");
            } else {
                sb.append(this.f631a);
            }
            z2 = false;
        }
        if (m408b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f630a == null) {
                sb.append("null");
            } else {
                sb.append(this.f630a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f636b == null) {
            sb.append("null");
        } else {
            sb.append(this.f636b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f638c == null) {
                sb.append("null");
            } else {
                sb.append(this.f638c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f639d == null) {
                sb.append("null");
            } else {
                sb.append(this.f639d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f635a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f640e == null) {
                sb.append("null");
            } else {
                sb.append(this.f640e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f634a == null) {
                sb.append("null");
            } else {
                sb.append(this.f634a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f641f == null) {
                sb.append("null");
            } else {
                sb.append(this.f641f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f642g == null) {
                sb.append("null");
            } else {
                sb.append(this.f642g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f643h == null) {
                sb.append("null");
            } else {
                sb.append(this.f643h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f644i == null) {
                sb.append("null");
            } else {
                sb.append(this.f644i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f632a == null) {
                sb.append("null");
            } else {
                is.a(this.f632a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f629a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f637b);
        }
        sb.append(")");
        return sb.toString();
    }
}
