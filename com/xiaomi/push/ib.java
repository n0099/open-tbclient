package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes3.dex */
public class ib implements ir<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f598a;

    /* renamed from: a  reason: collision with other field name */
    public hv f599a;

    /* renamed from: a  reason: collision with other field name */
    public String f600a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f602a;

    /* renamed from: b  reason: collision with other field name */
    public String f604b;

    /* renamed from: c  reason: collision with other field name */
    public String f605c;

    /* renamed from: d  reason: collision with other field name */
    public String f606d;

    /* renamed from: e  reason: collision with other field name */
    public String f607e;

    /* renamed from: f  reason: collision with other field name */
    public String f608f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f597a = new jh("XmPushActionCommandResult");
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
    private BitSet f601a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f603a = true;

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
            int compareTo = Boolean.valueOf(m381a()).compareTo(Boolean.valueOf(ibVar.m381a()));
            if (compareTo == 0) {
                if (!m381a() || (a11 = is.a(this.f599a, ibVar.f599a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m383b()).compareTo(Boolean.valueOf(ibVar.m383b()));
                    if (compareTo2 == 0) {
                        if (!m383b() || (a10 = is.a(this.f600a, ibVar.f600a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f604b, ibVar.f604b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f605c, ibVar.f605c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f598a, ibVar.f598a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f606d, ibVar.f606d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f607e, ibVar.f607e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f602a, ibVar.f602a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f608f, ibVar.f608f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f603a, ibVar.f603a)) == 0) {
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
        return this.f605c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m379a() {
        return this.f602a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m380a() {
        if (this.f600a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f604b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f605c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                if (!e()) {
                    throw new jd("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m380a();
                return;
            }
            switch (m451a.f788a) {
                case 2:
                    if (m451a.a == 12) {
                        this.f599a = new hv();
                        this.f599a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 3:
                    if (m451a.a == 11) {
                        this.f600a = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 4:
                    if (m451a.a == 11) {
                        this.f604b = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 5:
                    if (m451a.a == 11) {
                        this.f605c = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jf.a(jcVar, m451a.a);
                    break;
                case 7:
                    if (m451a.a == 10) {
                        this.f598a = jcVar.m450a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 8:
                    if (m451a.a == 11) {
                        this.f606d = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 9:
                    if (m451a.a == 11) {
                        this.f607e = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 10:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f602a = new ArrayList(m452a.f791a);
                        for (int i2 = 0; i2 < m452a.f791a; i2++) {
                            this.f602a.add(jcVar.m456a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 12:
                    if (m451a.a == 11) {
                        this.f608f = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 13:
                    if (m451a.a == 2) {
                        this.f603a = jcVar.m460a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f601a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a() {
        return this.f599a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m382a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m381a = m381a();
        boolean m381a2 = ibVar.m381a();
        if ((m381a || m381a2) && !(m381a && m381a2 && this.f599a.m361a(ibVar.f599a))) {
            return false;
        }
        boolean m383b = m383b();
        boolean m383b2 = ibVar.m383b();
        if ((m383b || m383b2) && !(m383b && m383b2 && this.f600a.equals(ibVar.f600a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ibVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f604b.equals(ibVar.f604b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f605c.equals(ibVar.f605c))) || this.f598a != ibVar.f598a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ibVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f606d.equals(ibVar.f606d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f607e.equals(ibVar.f607e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f602a.equals(ibVar.f602a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f608f.equals(ibVar.f608f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f603a == ibVar.f603a);
    }

    public String b() {
        return this.f608f;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m380a();
        jcVar.a(f597a);
        if (this.f599a != null && m381a()) {
            jcVar.a(a);
            this.f599a.b(jcVar);
            jcVar.b();
        }
        if (this.f600a != null) {
            jcVar.a(b);
            jcVar.a(this.f600a);
            jcVar.b();
        }
        if (this.f604b != null) {
            jcVar.a(c);
            jcVar.a(this.f604b);
            jcVar.b();
        }
        if (this.f605c != null) {
            jcVar.a(d);
            jcVar.a(this.f605c);
            jcVar.b();
        }
        jcVar.a(e);
        jcVar.a(this.f598a);
        jcVar.b();
        if (this.f606d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f606d);
            jcVar.b();
        }
        if (this.f607e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f607e);
            jcVar.b();
        }
        if (this.f602a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f602a.size()));
            for (String str : this.f602a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f608f != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f608f);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f603a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public void b(boolean z) {
        this.f601a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m383b() {
        return this.f600a != null;
    }

    public boolean c() {
        return this.f604b != null;
    }

    public boolean d() {
        return this.f605c != null;
    }

    public boolean e() {
        return this.f601a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m382a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f606d != null;
    }

    public boolean g() {
        return this.f607e != null;
    }

    public boolean h() {
        return this.f602a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f608f != null;
    }

    public boolean j() {
        return this.f601a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m381a()) {
            sb.append("target:");
            if (this.f599a == null) {
                sb.append("null");
            } else {
                sb.append(this.f599a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f600a == null) {
            sb.append("null");
        } else {
            sb.append(this.f600a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f604b == null) {
            sb.append("null");
        } else {
            sb.append(this.f604b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f605c == null) {
            sb.append("null");
        } else {
            sb.append(this.f605c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f598a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f606d == null) {
                sb.append("null");
            } else {
                sb.append(this.f606d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f607e == null) {
                sb.append("null");
            } else {
                sb.append(this.f607e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f602a == null) {
                sb.append("null");
            } else {
                sb.append(this.f602a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f608f == null) {
                sb.append("null");
            } else {
                sb.append(this.f608f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f603a);
        }
        sb.append(")");
        return sb.toString();
    }
}
