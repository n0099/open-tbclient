package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes8.dex */
public class Cif implements ir<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f625a;

    /* renamed from: a  reason: collision with other field name */
    public hv f626a;

    /* renamed from: a  reason: collision with other field name */
    public String f627a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f628a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f629a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f630a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f631a;

    /* renamed from: b  reason: collision with other field name */
    public String f632b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f633b;

    /* renamed from: c  reason: collision with other field name */
    public String f634c;

    /* renamed from: d  reason: collision with other field name */
    public String f635d;

    /* renamed from: e  reason: collision with other field name */
    public String f636e;

    /* renamed from: f  reason: collision with other field name */
    public String f637f;

    /* renamed from: g  reason: collision with other field name */
    public String f638g;

    /* renamed from: h  reason: collision with other field name */
    public String f639h;

    /* renamed from: i  reason: collision with other field name */
    public String f640i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f624a = new jh("XmPushActionNotification");
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
        this.f629a = new BitSet(3);
        this.f631a = true;
        this.f633b = false;
    }

    public Cif(String str, boolean z) {
        this();
        this.f632b = str;
        this.f631a = z;
        m418a(true);
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
            int compareTo = Boolean.valueOf(m419a()).compareTo(Boolean.valueOf(cif.m419a()));
            if (compareTo == 0) {
                if (!m419a() || (a16 = is.a(this.f627a, cif.f627a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m422b()).compareTo(Boolean.valueOf(cif.m422b()));
                    if (compareTo2 == 0) {
                        if (!m422b() || (a15 = is.a(this.f626a, cif.f626a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m423c()).compareTo(Boolean.valueOf(cif.m423c()));
                            if (compareTo3 == 0) {
                                if (!m423c() || (a14 = is.a(this.f632b, cif.f632b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a13 = is.a(this.f634c, cif.f634c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a12 = is.a(this.f635d, cif.f635d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a11 = is.a(this.f631a, cif.f631a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a10 = is.a(this.f636e, cif.f636e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a9 = is.a(this.f630a, cif.f630a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a8 = is.a(this.f637f, cif.f637f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a7 = is.a(this.f638g, cif.f638g)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a6 = is.a(this.f639h, cif.f639h)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a5 = is.a(this.f640i, cif.f640i)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a4 = is.a(this.f628a, cif.f628a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a3 = is.a(this.f625a, cif.f625a)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a2 = is.a(this.f633b, cif.f633b)) == 0) {
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
        this.f632b = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f628a = byteBuffer;
        return this;
    }

    public Cif a(Map<String, String> map) {
        this.f630a = map;
        return this;
    }

    public Cif a(boolean z) {
        this.f631a = z;
        m418a(true);
        return this;
    }

    public Cif a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f632b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m416a() {
        return this.f630a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m417a() {
        if (this.f632b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!f()) {
                    throw new jd("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                m417a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a == 11) {
                        this.f627a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 2:
                    if (m468a.a == 12) {
                        this.f626a = new hv();
                        this.f626a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 11) {
                        this.f632b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 4:
                    if (m468a.a == 11) {
                        this.f634c = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 5:
                    if (m468a.a == 11) {
                        this.f635d = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 6:
                    if (m468a.a == 2) {
                        this.f631a = jcVar.m477a();
                        m418a(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 7:
                    if (m468a.a == 11) {
                        this.f636e = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 8:
                    if (m468a.a == 13) {
                        jb m470a = jcVar.m470a();
                        this.f630a = new HashMap(m470a.f793a * 2);
                        for (int i2 = 0; i2 < m470a.f793a; i2++) {
                            this.f630a.put(jcVar.m473a(), jcVar.m473a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 9:
                    if (m468a.a == 11) {
                        this.f637f = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 10:
                    if (m468a.a == 11) {
                        this.f638g = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 12:
                    if (m468a.a == 11) {
                        this.f639h = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 13:
                    if (m468a.a == 11) {
                        this.f640i = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 14:
                    if (m468a.a == 11) {
                        this.f628a = jcVar.m474a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 15:
                    if (m468a.a == 10) {
                        this.f625a = jcVar.m467a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 20:
                    if (m468a.a == 2) {
                        this.f633b = jcVar.m477a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f630a == null) {
            this.f630a = new HashMap();
        }
        this.f630a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m418a(boolean z) {
        this.f629a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m419a() {
        return this.f627a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m420a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m419a = m419a();
        boolean m419a2 = cif.m419a();
        if ((m419a || m419a2) && !(m419a && m419a2 && this.f627a.equals(cif.f627a))) {
            return false;
        }
        boolean m422b = m422b();
        boolean m422b2 = cif.m422b();
        if ((m422b || m422b2) && !(m422b && m422b2 && this.f626a.m378a(cif.f626a))) {
            return false;
        }
        boolean m423c = m423c();
        boolean m423c2 = cif.m423c();
        if ((m423c || m423c2) && !(m423c && m423c2 && this.f632b.equals(cif.f632b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = cif.d();
        if ((d2 || d3) && !(d2 && d3 && this.f634c.equals(cif.f634c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = cif.e();
        if (((e2 || e3) && !(e2 && e3 && this.f635d.equals(cif.f635d))) || this.f631a != cif.f631a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = cif.g();
        if ((g2 || g3) && !(g2 && g3 && this.f636e.equals(cif.f636e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = cif.h();
        if ((h2 || h3) && !(h2 && h3 && this.f630a.equals(cif.f630a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = cif.i();
        if ((i2 || i3) && !(i2 && i3 && this.f637f.equals(cif.f637f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = cif.j();
        if ((j2 || j3) && !(j2 && j3 && this.f638g.equals(cif.f638g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = cif.k();
        if ((k2 || k3) && !(k2 && k3 && this.f639h.equals(cif.f639h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = cif.l();
        if ((l2 || l3) && !(l2 && l3 && this.f640i.equals(cif.f640i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = cif.m();
        if ((m2 || m3) && !(m2 && m3 && this.f628a.equals(cif.f628a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = cif.n();
        if ((n2 || n3) && !(n2 && n3 && this.f625a == cif.f625a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = cif.o();
        return !(o2 || o3) || (o2 && o3 && this.f633b == cif.f633b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m421a() {
        a(is.a(this.f628a));
        return this.f628a.array();
    }

    public Cif b(String str) {
        this.f634c = str;
        return this;
    }

    public String b() {
        return this.f634c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m417a();
        jcVar.a(f624a);
        if (this.f627a != null && m419a()) {
            jcVar.a(a);
            jcVar.a(this.f627a);
            jcVar.b();
        }
        if (this.f626a != null && m422b()) {
            jcVar.a(b);
            this.f626a.b(jcVar);
            jcVar.b();
        }
        if (this.f632b != null) {
            jcVar.a(c);
            jcVar.a(this.f632b);
            jcVar.b();
        }
        if (this.f634c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f634c);
            jcVar.b();
        }
        if (this.f635d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f635d);
            jcVar.b();
        }
        jcVar.a(f);
        jcVar.a(this.f631a);
        jcVar.b();
        if (this.f636e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f636e);
            jcVar.b();
        }
        if (this.f630a != null && h()) {
            jcVar.a(h);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f630a.size()));
            for (Map.Entry<String, String> entry : this.f630a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f637f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f637f);
            jcVar.b();
        }
        if (this.f638g != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f638g);
            jcVar.b();
        }
        if (this.f639h != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f639h);
            jcVar.b();
        }
        if (this.f640i != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f640i);
            jcVar.b();
        }
        if (this.f628a != null && m()) {
            jcVar.a(m);
            jcVar.a(this.f628a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f625a);
            jcVar.b();
        }
        if (o()) {
            jcVar.a(o);
            jcVar.a(this.f633b);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f629a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m422b() {
        return this.f626a != null;
    }

    public Cif c(String str) {
        this.f635d = str;
        return this;
    }

    public String c() {
        return this.f637f;
    }

    public void c(boolean z) {
        this.f629a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m423c() {
        return this.f632b != null;
    }

    public Cif d(String str) {
        this.f637f = str;
        return this;
    }

    public boolean d() {
        return this.f634c != null;
    }

    public boolean e() {
        return this.f635d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m420a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f629a.get(0);
    }

    public boolean g() {
        return this.f636e != null;
    }

    public boolean h() {
        return this.f630a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f637f != null;
    }

    public boolean j() {
        return this.f638g != null;
    }

    public boolean k() {
        return this.f639h != null;
    }

    public boolean l() {
        return this.f640i != null;
    }

    public boolean m() {
        return this.f628a != null;
    }

    public boolean n() {
        return this.f629a.get(1);
    }

    public boolean o() {
        return this.f629a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (m419a()) {
            sb.append("debug:");
            if (this.f627a == null) {
                sb.append("null");
            } else {
                sb.append(this.f627a);
            }
            z2 = false;
        }
        if (m422b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f626a == null) {
                sb.append("null");
            } else {
                sb.append(this.f626a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f632b == null) {
            sb.append("null");
        } else {
            sb.append(this.f632b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f634c == null) {
                sb.append("null");
            } else {
                sb.append(this.f634c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f635d == null) {
                sb.append("null");
            } else {
                sb.append(this.f635d);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f631a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f636e == null) {
                sb.append("null");
            } else {
                sb.append(this.f636e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f630a == null) {
                sb.append("null");
            } else {
                sb.append(this.f630a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f637f == null) {
                sb.append("null");
            } else {
                sb.append(this.f637f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f638g == null) {
                sb.append("null");
            } else {
                sb.append(this.f638g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f639h == null) {
                sb.append("null");
            } else {
                sb.append(this.f639h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f640i == null) {
                sb.append("null");
            } else {
                sb.append(this.f640i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.f628a == null) {
                sb.append("null");
            } else {
                is.a(this.f628a, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f625a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f633b);
        }
        sb.append(")");
        return sb.toString();
    }
}
