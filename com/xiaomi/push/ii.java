package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f677a;

    /* renamed from: a  reason: collision with other field name */
    public hz f678a;

    /* renamed from: a  reason: collision with other field name */
    public ib f679a;

    /* renamed from: a  reason: collision with other field name */
    public String f680a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f681a;

    /* renamed from: b  reason: collision with other field name */
    public String f684b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f676a = new jn("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14137a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14138b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f682a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f683a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f685b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m447a()).compareTo(Boolean.valueOf(iiVar.m447a()));
            if (compareTo == 0) {
                if (!m447a() || (a9 = iy.a(this.f677a, iiVar.f677a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f683a, iiVar.f683a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f685b, iiVar.f685b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f681a, iiVar.f681a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f680a, iiVar.f680a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f684b, iiVar.f684b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f679a, iiVar.f679a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f678a, iiVar.f678a)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iiVar.getClass().getName());
    }

    public hm a() {
        return this.f677a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m443a() {
        return this.f678a;
    }

    public ii a(hm hmVar) {
        this.f677a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f678a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f679a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f680a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f681a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f683a = z;
        m446a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m444a() {
        return this.f680a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m445a() {
        if (this.f677a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f681a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f679a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m445a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a != 8) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f677a = hm.a(jiVar.m508a());
                        break;
                    }
                case 2:
                    if (m510a.f14173a != 2) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f683a = jiVar.m519a();
                        m446a(true);
                        break;
                    }
                case 3:
                    if (m510a.f14173a != 2) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f685b = jiVar.m519a();
                        m450b(true);
                        break;
                    }
                case 4:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f681a = jiVar.m516a();
                        break;
                    }
                case 5:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f680a = jiVar.m515a();
                        break;
                    }
                case 6:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f684b = jiVar.m515a();
                        break;
                    }
                case 7:
                    if (m510a.f14173a != 12) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f679a = new ib();
                        this.f679a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m510a.f14173a != 12) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f678a = new hz();
                        this.f678a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m446a(boolean z) {
        this.f682a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a() {
        return this.f677a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m447a = m447a();
        boolean m447a2 = iiVar.m447a();
        if (((!m447a && !m447a2) || (m447a && m447a2 && this.f677a.equals(iiVar.f677a))) && this.f683a == iiVar.f683a && this.f685b == iiVar.f685b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f681a.equals(iiVar.f681a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f680a.equals(iiVar.f680a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f684b.equals(iiVar.f684b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f679a.m423a(iiVar.f679a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f678a.m406a(iiVar.f678a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m449a() {
        a(iy.a(this.f681a));
        return this.f681a.array();
    }

    public ii b(String str) {
        this.f684b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f685b = z;
        m450b(true);
        return this;
    }

    public String b() {
        return this.f684b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m445a();
        jiVar.a(f676a);
        if (this.f677a != null) {
            jiVar.a(f14137a);
            jiVar.a(this.f677a.a());
            jiVar.b();
        }
        jiVar.a(f14138b);
        jiVar.a(this.f683a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f685b);
        jiVar.b();
        if (this.f681a != null) {
            jiVar.a(d);
            jiVar.a(this.f681a);
            jiVar.b();
        }
        if (this.f680a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f680a);
            jiVar.b();
        }
        if (this.f684b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f684b);
            jiVar.b();
        }
        if (this.f679a != null) {
            jiVar.a(g);
            this.f679a.b(jiVar);
            jiVar.b();
        }
        if (this.f678a != null && i()) {
            jiVar.a(h);
            this.f678a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m450b(boolean z) {
        this.f682a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m451b() {
        return this.f683a;
    }

    public boolean c() {
        return this.f682a.get(0);
    }

    public boolean d() {
        return this.f682a.get(1);
    }

    public boolean e() {
        return this.f681a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m448a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f680a != null;
    }

    public boolean g() {
        return this.f684b != null;
    }

    public boolean h() {
        return this.f679a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f678a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f677a == null) {
            sb.append("null");
        } else {
            sb.append(this.f677a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f683a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f685b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f681a == null) {
            sb.append("null");
        } else {
            iy.a(this.f681a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f680a == null) {
                sb.append("null");
            } else {
                sb.append(this.f680a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f684b == null) {
                sb.append("null");
            } else {
                sb.append(this.f684b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f679a == null) {
            sb.append("null");
        } else {
            sb.append(this.f679a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f678a == null) {
                sb.append("null");
            } else {
                sb.append(this.f678a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
