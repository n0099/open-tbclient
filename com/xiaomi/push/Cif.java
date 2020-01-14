package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes6.dex */
public class Cif implements ir<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f628a;

    /* renamed from: a  reason: collision with other field name */
    public hv f629a;

    /* renamed from: a  reason: collision with other field name */
    public String f630a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f631a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f632a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f633a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f634a;

    /* renamed from: b  reason: collision with other field name */
    public String f635b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f636b;

    /* renamed from: c  reason: collision with other field name */
    public String f637c;

    /* renamed from: d  reason: collision with other field name */
    public String f638d;

    /* renamed from: e  reason: collision with other field name */
    public String f639e;

    /* renamed from: f  reason: collision with other field name */
    public String f640f;

    /* renamed from: g  reason: collision with other field name */
    public String f641g;

    /* renamed from: h  reason: collision with other field name */
    public String f642h;

    /* renamed from: i  reason: collision with other field name */
    public String f643i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f627a = new jh("XmPushActionNotification");
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
        this.f632a = new BitSet(3);
        this.f634a = true;
        this.f636b = false;
    }

    public Cif(String str, boolean z) {
        this();
        this.f635b = str;
        this.f634a = z;
        m413a(true);
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
            int compareTo = Boolean.valueOf(m414a()).compareTo(Boolean.valueOf(cif.m414a()));
            if (compareTo == 0) {
                if (!m414a() || (a16 = is.a(this.f630a, cif.f630a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m417b()).compareTo(Boolean.valueOf(cif.m417b()));
                    if (compareTo2 == 0) {
                        if (!m417b() || (a15 = is.a(this.f629a, cif.f629a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m418c()).compareTo(Boolean.valueOf(cif.m418c()));
                            if (compareTo3 == 0) {
                                if (!m418c() || (a14 = is.a(this.f635b, cif.f635b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = is.a(this.f637c, cif.f637c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = is.a(this.f638d, cif.f638d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = is.a(this.f634a, cif.f634a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = is.a(this.f639e, cif.f639e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = is.a(this.f633a, cif.f633a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = is.a(this.f640f, cif.f640f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = is.a(this.f641g, cif.f641g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = is.a(this.f642h, cif.f642h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = is.a(this.f643i, cif.f643i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = is.a(this.f631a, cif.f631a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = is.a(this.f628a, cif.f628a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = is.a(this.f636b, cif.f636b)) == 0) {
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
        this.f635b = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f631a = byteBuffer;
        return this;
    }

    public Cif a(Map<String, String> map) {
        this.f633a = map;
        return this;
    }

    public Cif a(boolean z) {
        this.f634a = z;
        m413a(true);
        return this;
    }

    public Cif a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f635b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m411a() {
        return this.f633a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        if (this.f635b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!f()) {
                    throw new jd("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m412a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f630a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f629a = new hv();
                        this.f629a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f635b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f637c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f638d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 2) {
                        this.f634a = jcVar.m472a();
                        m413a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f639e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f633a = new HashMap(m465a.f796a * 2);
                        for (int i2 = 0; i2 < m465a.f796a; i2++) {
                            this.f633a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 11) {
                        this.f640f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 11) {
                        this.f641g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 12:
                    if (m463a.a == 11) {
                        this.f642h = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 13:
                    if (m463a.a == 11) {
                        this.f643i = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 14:
                    if (m463a.a == 11) {
                        this.f631a = jcVar.m469a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 15:
                    if (m463a.a == 10) {
                        this.f628a = jcVar.m462a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 20:
                    if (m463a.a == 2) {
                        this.f636b = jcVar.m472a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f633a == null) {
            this.f633a = new HashMap();
        }
        this.f633a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m413a(boolean z) {
        this.f632a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a() {
        return this.f630a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m414a = m414a();
        boolean m414a2 = cif.m414a();
        if ((m414a || m414a2) && !(m414a && m414a2 && this.f630a.equals(cif.f630a))) {
            return false;
        }
        boolean m417b = m417b();
        boolean m417b2 = cif.m417b();
        if ((m417b || m417b2) && !(m417b && m417b2 && this.f629a.m373a(cif.f629a))) {
            return false;
        }
        boolean m418c = m418c();
        boolean m418c2 = cif.m418c();
        if ((m418c || m418c2) && !(m418c && m418c2 && this.f635b.equals(cif.f635b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cif.d();
        if ((d2 || d3) && !(d2 && d3 && this.f637c.equals(cif.f637c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cif.e();
        if (((e2 || e3) && !(e2 && e3 && this.f638d.equals(cif.f638d))) || this.f634a != cif.f634a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cif.g();
        if ((g2 || g3) && !(g2 && g3 && this.f639e.equals(cif.f639e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cif.h();
        if ((h2 || h3) && !(h2 && h3 && this.f633a.equals(cif.f633a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cif.i();
        if ((i2 || i3) && !(i2 && i3 && this.f640f.equals(cif.f640f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cif.j();
        if ((j2 || j3) && !(j2 && j3 && this.f641g.equals(cif.f641g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = cif.k();
        if ((k2 || k3) && !(k2 && k3 && this.f642h.equals(cif.f642h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = cif.l();
        if ((l2 || l3) && !(l2 && l3 && this.f643i.equals(cif.f643i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = cif.m();
        if ((m2 || m3) && !(m2 && m3 && this.f631a.equals(cif.f631a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = cif.n();
        if ((n2 || n3) && !(n2 && n3 && this.f628a == cif.f628a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = cif.o();
        return !(o2 || o3) || (o2 && o3 && this.f636b == cif.f636b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m416a() {
        a(is.a(this.f631a));
        return this.f631a.array();
    }

    public Cif b(String str) {
        this.f637c = str;
        return this;
    }

    public String b() {
        return this.f637c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m412a();
        jcVar.a(f627a);
        if (this.f630a != null && m414a()) {
            jcVar.a(a);
            jcVar.a(this.f630a);
            jcVar.b();
        }
        if (this.f629a != null && m417b()) {
            jcVar.a(b);
            this.f629a.b(jcVar);
            jcVar.b();
        }
        if (this.f635b != null) {
            jcVar.a(c);
            jcVar.a(this.f635b);
            jcVar.b();
        }
        if (this.f637c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f637c);
            jcVar.b();
        }
        if (this.f638d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f638d);
            jcVar.b();
        }
        jcVar.a(f);
        jcVar.a(this.f634a);
        jcVar.b();
        if (this.f639e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f639e);
            jcVar.b();
        }
        if (this.f633a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f633a.size()));
            for (Map.Entry<String, String> entry : this.f633a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f640f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f640f);
            jcVar.b();
        }
        if (this.f641g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f641g);
            jcVar.b();
        }
        if (this.f642h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f642h);
            jcVar.b();
        }
        if (this.f643i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f643i);
            jcVar.b();
        }
        if (this.f631a != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f631a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f628a);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f636b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f632a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m417b() {
        return this.f629a != null;
    }

    public Cif c(String str) {
        this.f638d = str;
        return this;
    }

    public String c() {
        return this.f640f;
    }

    public void c(boolean z) {
        this.f632a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m418c() {
        return this.f635b != null;
    }

    public Cif d(String str) {
        this.f640f = str;
        return this;
    }

    public boolean d() {
        return this.f637c != null;
    }

    public boolean e() {
        return this.f638d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m415a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f632a.get(0);
    }

    public boolean g() {
        return this.f639e != null;
    }

    public boolean h() {
        return this.f633a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f640f != null;
    }

    public boolean j() {
        return this.f641g != null;
    }

    public boolean k() {
        return this.f642h != null;
    }

    public boolean l() {
        return this.f643i != null;
    }

    public boolean m() {
        return this.f631a != null;
    }

    public boolean n() {
        return this.f632a.get(1);
    }

    public boolean o() {
        return this.f632a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m414a()) {
            sb.append("debug:");
            if (this.f630a == null) {
                sb.append("null");
            } else {
                sb.append(this.f630a);
            }
            z2 = false;
        }
        if (m417b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f629a == null) {
                sb.append("null");
            } else {
                sb.append(this.f629a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f635b == null) {
            sb.append("null");
        } else {
            sb.append(this.f635b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f637c == null) {
                sb.append("null");
            } else {
                sb.append(this.f637c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f638d == null) {
                sb.append("null");
            } else {
                sb.append(this.f638d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f634a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f639e == null) {
                sb.append("null");
            } else {
                sb.append(this.f639e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f633a == null) {
                sb.append("null");
            } else {
                sb.append(this.f633a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f640f == null) {
                sb.append("null");
            } else {
                sb.append(this.f640f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f641g == null) {
                sb.append("null");
            } else {
                sb.append(this.f641g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f642h == null) {
                sb.append("null");
            } else {
                sb.append(this.f642h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f643i == null) {
                sb.append("null");
            } else {
                sb.append(this.f643i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f631a == null) {
                sb.append("null");
            } else {
                is.a(this.f631a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f628a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f636b);
        }
        sb.append(")");
        return sb.toString();
    }
}
