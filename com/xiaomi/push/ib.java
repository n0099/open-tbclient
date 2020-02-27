package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f599a;

    /* renamed from: a  reason: collision with other field name */
    public hv f600a;

    /* renamed from: a  reason: collision with other field name */
    public String f601a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f603a;

    /* renamed from: b  reason: collision with other field name */
    public String f605b;

    /* renamed from: c  reason: collision with other field name */
    public String f606c;

    /* renamed from: d  reason: collision with other field name */
    public String f607d;

    /* renamed from: e  reason: collision with other field name */
    public String f608e;

    /* renamed from: f  reason: collision with other field name */
    public String f609f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f598a = new jh("XmPushActionCommandResult");
    private static final iz a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz e = new iz("", (byte) 10, 7);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz h = new iz("", (byte) 15, 10);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 12);
    private static final iz j = new iz("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f602a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f604a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
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
        if (getClass().equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m398a()).compareTo(Boolean.valueOf(ibVar.m398a()));
            if (compareTo == 0) {
                if (!m398a() || (a11 = is.a(this.f600a, ibVar.f600a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m400b()).compareTo(Boolean.valueOf(ibVar.m400b()));
                    if (compareTo2 == 0) {
                        if (!m400b() || (a10 = is.a(this.f601a, ibVar.f601a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f605b, ibVar.f605b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f606c, ibVar.f606c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f599a, ibVar.f599a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f607d, ibVar.f607d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f608e, ibVar.f608e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f603a, ibVar.f603a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f609f, ibVar.f609f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f604a, ibVar.f604a)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ibVar.getClass().getName());
    }

    public String a() {
        return this.f606c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m396a() {
        return this.f603a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m397a() {
        if (this.f601a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f605b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f606c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m397a();
                return;
            }
            switch (m468a.f789a) {
                case 2:
                    if (m468a.a == 12) {
                        this.f600a = new hv();
                        this.f600a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 11) {
                        this.f601a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 4:
                    if (m468a.a == 11) {
                        this.f605b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 5:
                    if (m468a.a == 11) {
                        this.f606c = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 7:
                    if (m468a.a == 10) {
                        this.f599a = jcVar.m467a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 8:
                    if (m468a.a == 11) {
                        this.f607d = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 9:
                    if (m468a.a == 11) {
                        this.f608e = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 10:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f603a = new ArrayList(m469a.f792a);
                        for (int i2 = 0; i2 < m469a.f792a; i2++) {
                            this.f603a.add(jcVar.m473a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 12:
                    if (m468a.a == 11) {
                        this.f609f = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 13:
                    if (m468a.a == 2) {
                        this.f604a = jcVar.m477a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f602a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a() {
        return this.f600a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m398a = m398a();
        boolean m398a2 = ibVar.m398a();
        if ((m398a || m398a2) && !(m398a && m398a2 && this.f600a.m378a(ibVar.f600a))) {
            return false;
        }
        boolean m400b = m400b();
        boolean m400b2 = ibVar.m400b();
        if ((m400b || m400b2) && !(m400b && m400b2 && this.f601a.equals(ibVar.f601a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f605b.equals(ibVar.f605b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f606c.equals(ibVar.f606c))) || this.f599a != ibVar.f599a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f607d.equals(ibVar.f607d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f608e.equals(ibVar.f608e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f603a.equals(ibVar.f603a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f609f.equals(ibVar.f609f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f604a == ibVar.f604a);
    }

    public String b() {
        return this.f609f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m397a();
        jcVar.a(f598a);
        if (this.f600a != null && m398a()) {
            jcVar.a(a);
            this.f600a.b(jcVar);
            jcVar.b();
        }
        if (this.f601a != null) {
            jcVar.a(b);
            jcVar.a(this.f601a);
            jcVar.b();
        }
        if (this.f605b != null) {
            jcVar.a(c);
            jcVar.a(this.f605b);
            jcVar.b();
        }
        if (this.f606c != null) {
            jcVar.a(d);
            jcVar.a(this.f606c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f599a);
        jcVar.b();
        if (this.f607d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f607d);
            jcVar.b();
        }
        if (this.f608e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f608e);
            jcVar.b();
        }
        if (this.f603a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f603a.size()));
            for (String str : this.f603a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f609f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f609f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f604a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f602a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m400b() {
        return this.f601a != null;
    }

    public boolean c() {
        return this.f605b != null;
    }

    public boolean d() {
        return this.f606c != null;
    }

    public boolean e() {
        return this.f602a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m399a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f607d != null;
    }

    public boolean g() {
        return this.f608e != null;
    }

    public boolean h() {
        return this.f603a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f609f != null;
    }

    public boolean j() {
        return this.f602a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m398a()) {
            sb.append("target:");
            if (this.f600a == null) {
                sb.append("null");
            } else {
                sb.append(this.f600a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f601a == null) {
            sb.append("null");
        } else {
            sb.append(this.f601a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f605b == null) {
            sb.append("null");
        } else {
            sb.append(this.f605b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f606c == null) {
            sb.append("null");
        } else {
            sb.append(this.f606c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f599a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f607d == null) {
                sb.append("null");
            } else {
                sb.append(this.f607d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f608e == null) {
                sb.append("null");
            } else {
                sb.append(this.f608e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f603a == null) {
                sb.append("null");
            } else {
                sb.append(this.f603a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f609f == null) {
                sb.append("null");
            } else {
                sb.append(this.f609f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f604a);
        }
        sb.append(")");
        return sb.toString();
    }
}
