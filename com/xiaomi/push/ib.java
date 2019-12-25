package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes5.dex */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f603a;

    /* renamed from: a  reason: collision with other field name */
    public hv f604a;

    /* renamed from: a  reason: collision with other field name */
    public String f605a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f607a;

    /* renamed from: b  reason: collision with other field name */
    public String f609b;

    /* renamed from: c  reason: collision with other field name */
    public String f610c;

    /* renamed from: d  reason: collision with other field name */
    public String f611d;

    /* renamed from: e  reason: collision with other field name */
    public String f612e;

    /* renamed from: f  reason: collision with other field name */
    public String f613f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f602a = new jh("XmPushActionCommandResult");
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
    private BitSet f606a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f608a = true;

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
            int compareTo = Boolean.valueOf(m384a()).compareTo(Boolean.valueOf(ibVar.m384a()));
            if (compareTo == 0) {
                if (!m384a() || (a11 = is.a(this.f604a, ibVar.f604a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m386b()).compareTo(Boolean.valueOf(ibVar.m386b()));
                    if (compareTo2 == 0) {
                        if (!m386b() || (a10 = is.a(this.f605a, ibVar.f605a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f609b, ibVar.f609b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f610c, ibVar.f610c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f603a, ibVar.f603a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f611d, ibVar.f611d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f612e, ibVar.f612e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f607a, ibVar.f607a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f613f, ibVar.f613f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f608a, ibVar.f608a)) == 0) {
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
        return this.f610c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m382a() {
        return this.f607a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m383a() {
        if (this.f605a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f609b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f610c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m383a();
                return;
            }
            switch (m454a.f793a) {
                case 2:
                    if (m454a.a == 12) {
                        this.f604a = new hv();
                        this.f604a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f605a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f609b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f610c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 7:
                    if (m454a.a == 10) {
                        this.f603a = jcVar.m453a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 11) {
                        this.f611d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 11) {
                        this.f612e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f607a = new ArrayList(m455a.f796a);
                        for (int i2 = 0; i2 < m455a.f796a; i2++) {
                            this.f607a.add(jcVar.m459a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 11) {
                        this.f613f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 13:
                    if (m454a.a == 2) {
                        this.f608a = jcVar.m463a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f606a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m384a() {
        return this.f604a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m385a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m384a = m384a();
        boolean m384a2 = ibVar.m384a();
        if ((m384a || m384a2) && !(m384a && m384a2 && this.f604a.m364a(ibVar.f604a))) {
            return false;
        }
        boolean m386b = m386b();
        boolean m386b2 = ibVar.m386b();
        if ((m386b || m386b2) && !(m386b && m386b2 && this.f605a.equals(ibVar.f605a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f609b.equals(ibVar.f609b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f610c.equals(ibVar.f610c))) || this.f603a != ibVar.f603a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f611d.equals(ibVar.f611d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f612e.equals(ibVar.f612e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f607a.equals(ibVar.f607a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f613f.equals(ibVar.f613f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f608a == ibVar.f608a);
    }

    public String b() {
        return this.f613f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m383a();
        jcVar.a(f602a);
        if (this.f604a != null && m384a()) {
            jcVar.a(a);
            this.f604a.b(jcVar);
            jcVar.b();
        }
        if (this.f605a != null) {
            jcVar.a(b);
            jcVar.a(this.f605a);
            jcVar.b();
        }
        if (this.f609b != null) {
            jcVar.a(c);
            jcVar.a(this.f609b);
            jcVar.b();
        }
        if (this.f610c != null) {
            jcVar.a(d);
            jcVar.a(this.f610c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f603a);
        jcVar.b();
        if (this.f611d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f611d);
            jcVar.b();
        }
        if (this.f612e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f612e);
            jcVar.b();
        }
        if (this.f607a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f607a.size()));
            for (String str : this.f607a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f613f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f613f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f608a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f606a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m386b() {
        return this.f605a != null;
    }

    public boolean c() {
        return this.f609b != null;
    }

    public boolean d() {
        return this.f610c != null;
    }

    public boolean e() {
        return this.f606a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m385a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f611d != null;
    }

    public boolean g() {
        return this.f612e != null;
    }

    public boolean h() {
        return this.f607a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f613f != null;
    }

    public boolean j() {
        return this.f606a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m384a()) {
            sb.append("target:");
            if (this.f604a == null) {
                sb.append("null");
            } else {
                sb.append(this.f604a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f605a == null) {
            sb.append("null");
        } else {
            sb.append(this.f605a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f609b == null) {
            sb.append("null");
        } else {
            sb.append(this.f609b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f610c == null) {
            sb.append("null");
        } else {
            sb.append(this.f610c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f603a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f611d == null) {
                sb.append("null");
            } else {
                sb.append(this.f611d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f612e == null) {
                sb.append("null");
            } else {
                sb.append(this.f612e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f607a == null) {
                sb.append("null");
            } else {
                sb.append(this.f607a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f613f == null) {
                sb.append("null");
            } else {
                sb.append(this.f613f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f608a);
        }
        sb.append(")");
        return sb.toString();
    }
}
