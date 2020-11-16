package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f601a;

    /* renamed from: a  reason: collision with other field name */
    public hz f602a;

    /* renamed from: a  reason: collision with other field name */
    public ib f603a;

    /* renamed from: a  reason: collision with other field name */
    public String f604a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f605a;

    /* renamed from: b  reason: collision with other field name */
    public String f608b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f600a = new jn("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4978a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f606a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f607a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f609b = true;

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
            int compareTo = Boolean.valueOf(m425a()).compareTo(Boolean.valueOf(iiVar.m425a()));
            if (compareTo == 0) {
                if (!m425a() || (a9 = iy.a(this.f601a, iiVar.f601a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f607a, iiVar.f607a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f609b, iiVar.f609b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f605a, iiVar.f605a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f604a, iiVar.f604a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f608b, iiVar.f608b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f603a, iiVar.f603a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f602a, iiVar.f602a)) == 0) {
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
        return this.f601a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m421a() {
        return this.f602a;
    }

    public ii a(hm hmVar) {
        this.f601a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f602a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f603a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f604a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f605a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f607a = z;
        m424a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m422a() {
        return this.f604a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m423a() {
        if (this.f601a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f605a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f603a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m423a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 8) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f601a = hm.a(jiVar.m486a());
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f607a = jiVar.m497a();
                        m424a(true);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f609b = jiVar.m497a();
                        m428b(true);
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f605a = jiVar.m494a();
                        break;
                    }
                case 5:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f604a = jiVar.m493a();
                        break;
                    }
                case 6:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f608b = jiVar.m493a();
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f603a = new ib();
                        this.f603a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f602a = new hz();
                        this.f602a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m424a(boolean z) {
        this.f606a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a() {
        return this.f601a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m426a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m425a = m425a();
        boolean m425a2 = iiVar.m425a();
        if (((!m425a && !m425a2) || (m425a && m425a2 && this.f601a.equals(iiVar.f601a))) && this.f607a == iiVar.f607a && this.f609b == iiVar.f609b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f605a.equals(iiVar.f605a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f604a.equals(iiVar.f604a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f608b.equals(iiVar.f608b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f603a.m401a(iiVar.f603a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f602a.m384a(iiVar.f602a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m427a() {
        a(iy.a(this.f605a));
        return this.f605a.array();
    }

    public ii b(String str) {
        this.f608b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f609b = z;
        m428b(true);
        return this;
    }

    public String b() {
        return this.f608b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m423a();
        jiVar.a(f600a);
        if (this.f601a != null) {
            jiVar.a(f4978a);
            jiVar.a(this.f601a.a());
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f607a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f609b);
        jiVar.b();
        if (this.f605a != null) {
            jiVar.a(d);
            jiVar.a(this.f605a);
            jiVar.b();
        }
        if (this.f604a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f604a);
            jiVar.b();
        }
        if (this.f608b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f608b);
            jiVar.b();
        }
        if (this.f603a != null) {
            jiVar.a(g);
            this.f603a.b(jiVar);
            jiVar.b();
        }
        if (this.f602a != null && i()) {
            jiVar.a(h);
            this.f602a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m428b(boolean z) {
        this.f606a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m429b() {
        return this.f607a;
    }

    public boolean c() {
        return this.f606a.get(0);
    }

    public boolean d() {
        return this.f606a.get(1);
    }

    public boolean e() {
        return this.f605a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m426a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f604a != null;
    }

    public boolean g() {
        return this.f608b != null;
    }

    public boolean h() {
        return this.f603a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f602a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f601a == null) {
            sb.append("null");
        } else {
            sb.append(this.f601a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f607a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f609b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f605a == null) {
            sb.append("null");
        } else {
            iy.a(this.f605a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f604a == null) {
                sb.append("null");
            } else {
                sb.append(this.f604a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f608b == null) {
                sb.append("null");
            } else {
                sb.append(this.f608b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f603a == null) {
            sb.append("null");
        } else {
            sb.append(this.f603a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f602a == null) {
                sb.append("null");
            } else {
                sb.append(this.f602a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
