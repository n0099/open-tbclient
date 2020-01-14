package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f602a;

    /* renamed from: a  reason: collision with other field name */
    public hv f603a;

    /* renamed from: a  reason: collision with other field name */
    public String f604a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f606a;

    /* renamed from: b  reason: collision with other field name */
    public String f608b;

    /* renamed from: c  reason: collision with other field name */
    public String f609c;

    /* renamed from: d  reason: collision with other field name */
    public String f610d;

    /* renamed from: e  reason: collision with other field name */
    public String f611e;

    /* renamed from: f  reason: collision with other field name */
    public String f612f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f601a = new jh("XmPushActionCommandResult");
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
    private BitSet f605a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f607a = true;

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
            int compareTo = Boolean.valueOf(m393a()).compareTo(Boolean.valueOf(ibVar.m393a()));
            if (compareTo == 0) {
                if (!m393a() || (a11 = is.a(this.f603a, ibVar.f603a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m395b()).compareTo(Boolean.valueOf(ibVar.m395b()));
                    if (compareTo2 == 0) {
                        if (!m395b() || (a10 = is.a(this.f604a, ibVar.f604a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f608b, ibVar.f608b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f609c, ibVar.f609c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f602a, ibVar.f602a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f610d, ibVar.f610d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f611e, ibVar.f611e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f606a, ibVar.f606a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f612f, ibVar.f612f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f607a, ibVar.f607a)) == 0) {
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
        return this.f609c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m391a() {
        return this.f606a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m392a() {
        if (this.f604a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f608b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f609c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m392a();
                return;
            }
            switch (m463a.f792a) {
                case 2:
                    if (m463a.a == 12) {
                        this.f603a = new hv();
                        this.f603a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f604a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f608b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f609c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 7:
                    if (m463a.a == 10) {
                        this.f602a = jcVar.m462a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 11) {
                        this.f610d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 11) {
                        this.f611e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f606a = new ArrayList(m464a.f795a);
                        for (int i2 = 0; i2 < m464a.f795a; i2++) {
                            this.f606a.add(jcVar.m468a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 11) {
                        this.f612f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 13:
                    if (m463a.a == 2) {
                        this.f607a = jcVar.m472a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f605a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m393a() {
        return this.f603a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m394a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m393a = m393a();
        boolean m393a2 = ibVar.m393a();
        if ((m393a || m393a2) && !(m393a && m393a2 && this.f603a.m373a(ibVar.f603a))) {
            return false;
        }
        boolean m395b = m395b();
        boolean m395b2 = ibVar.m395b();
        if ((m395b || m395b2) && !(m395b && m395b2 && this.f604a.equals(ibVar.f604a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f608b.equals(ibVar.f608b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f609c.equals(ibVar.f609c))) || this.f602a != ibVar.f602a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f610d.equals(ibVar.f610d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f611e.equals(ibVar.f611e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f606a.equals(ibVar.f606a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f612f.equals(ibVar.f612f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f607a == ibVar.f607a);
    }

    public String b() {
        return this.f612f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m392a();
        jcVar.a(f601a);
        if (this.f603a != null && m393a()) {
            jcVar.a(a);
            this.f603a.b(jcVar);
            jcVar.b();
        }
        if (this.f604a != null) {
            jcVar.a(b);
            jcVar.a(this.f604a);
            jcVar.b();
        }
        if (this.f608b != null) {
            jcVar.a(c);
            jcVar.a(this.f608b);
            jcVar.b();
        }
        if (this.f609c != null) {
            jcVar.a(d);
            jcVar.a(this.f609c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f602a);
        jcVar.b();
        if (this.f610d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f610d);
            jcVar.b();
        }
        if (this.f611e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f611e);
            jcVar.b();
        }
        if (this.f606a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f606a.size()));
            for (String str : this.f606a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f612f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f612f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f607a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f605a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m395b() {
        return this.f604a != null;
    }

    public boolean c() {
        return this.f608b != null;
    }

    public boolean d() {
        return this.f609c != null;
    }

    public boolean e() {
        return this.f605a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m394a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f610d != null;
    }

    public boolean g() {
        return this.f611e != null;
    }

    public boolean h() {
        return this.f606a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f612f != null;
    }

    public boolean j() {
        return this.f605a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m393a()) {
            sb.append("target:");
            if (this.f603a == null) {
                sb.append("null");
            } else {
                sb.append(this.f603a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f604a == null) {
            sb.append("null");
        } else {
            sb.append(this.f604a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f608b == null) {
            sb.append("null");
        } else {
            sb.append(this.f608b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f609c == null) {
            sb.append("null");
        } else {
            sb.append(this.f609c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f602a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f610d == null) {
                sb.append("null");
            } else {
                sb.append(this.f610d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f611e == null) {
                sb.append("null");
            } else {
                sb.append(this.f611e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f606a == null) {
                sb.append("null");
            } else {
                sb.append(this.f606a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f612f == null) {
                sb.append("null");
            } else {
                sb.append(this.f612f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f607a);
        }
        sb.append(")");
        return sb.toString();
    }
}
