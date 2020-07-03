package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f603a;

    /* renamed from: a  reason: collision with other field name */
    public hz f604a;

    /* renamed from: a  reason: collision with other field name */
    public ib f605a;

    /* renamed from: a  reason: collision with other field name */
    public String f606a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f607a;

    /* renamed from: b  reason: collision with other field name */
    public String f610b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f602a = new jn("XmPushActionContainer");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f608a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f609a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f611b = true;

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
            int compareTo = Boolean.valueOf(m416a()).compareTo(Boolean.valueOf(iiVar.m416a()));
            if (compareTo == 0) {
                if (!m416a() || (a9 = iy.a(this.f603a, iiVar.f603a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f609a, iiVar.f609a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f611b, iiVar.f611b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f607a, iiVar.f607a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f606a, iiVar.f606a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f610b, iiVar.f610b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f605a, iiVar.f605a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f604a, iiVar.f604a)) == 0) {
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
        return this.f603a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m412a() {
        return this.f604a;
    }

    public ii a(hm hmVar) {
        this.f603a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f604a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f605a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f606a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f607a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f609a = z;
        m415a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m413a() {
        return this.f606a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m414a() {
        if (this.f603a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f607a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f605a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m414a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a != 8) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f603a = hm.a(jiVar.m477a());
                        break;
                    }
                case 2:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f609a = jiVar.m488a();
                        m415a(true);
                        break;
                    }
                case 3:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f611b = jiVar.m488a();
                        m419b(true);
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f607a = jiVar.m485a();
                        break;
                    }
                case 5:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f606a = jiVar.m484a();
                        break;
                    }
                case 6:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f610b = jiVar.m484a();
                        break;
                    }
                case 7:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f605a = new ib();
                        this.f605a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f604a = new hz();
                        this.f604a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m415a(boolean z) {
        this.f608a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m416a() {
        return this.f603a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m417a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m416a = m416a();
        boolean m416a2 = iiVar.m416a();
        if (((!m416a && !m416a2) || (m416a && m416a2 && this.f603a.equals(iiVar.f603a))) && this.f609a == iiVar.f609a && this.f611b == iiVar.f611b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f607a.equals(iiVar.f607a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f606a.equals(iiVar.f606a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f610b.equals(iiVar.f610b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f605a.m392a(iiVar.f605a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f604a.m375a(iiVar.f604a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m418a() {
        a(iy.a(this.f607a));
        return this.f607a.array();
    }

    public ii b(String str) {
        this.f610b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f611b = z;
        m419b(true);
        return this;
    }

    public String b() {
        return this.f610b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m414a();
        jiVar.a(f602a);
        if (this.f603a != null) {
            jiVar.a(a);
            jiVar.a(this.f603a.a());
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f609a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f611b);
        jiVar.b();
        if (this.f607a != null) {
            jiVar.a(d);
            jiVar.a(this.f607a);
            jiVar.b();
        }
        if (this.f606a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f606a);
            jiVar.b();
        }
        if (this.f610b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f610b);
            jiVar.b();
        }
        if (this.f605a != null) {
            jiVar.a(g);
            this.f605a.b(jiVar);
            jiVar.b();
        }
        if (this.f604a != null && i()) {
            jiVar.a(h);
            this.f604a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m419b(boolean z) {
        this.f608a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m420b() {
        return this.f609a;
    }

    public boolean c() {
        return this.f608a.get(0);
    }

    public boolean d() {
        return this.f608a.get(1);
    }

    public boolean e() {
        return this.f607a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m417a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f606a != null;
    }

    public boolean g() {
        return this.f610b != null;
    }

    public boolean h() {
        return this.f605a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f604a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f603a == null) {
            sb.append("null");
        } else {
            sb.append(this.f603a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f609a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f611b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f607a == null) {
            sb.append("null");
        } else {
            iy.a(this.f607a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f606a == null) {
                sb.append("null");
            } else {
                sb.append(this.f606a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f610b == null) {
                sb.append("null");
            } else {
                sb.append(this.f610b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f605a == null) {
            sb.append("null");
        } else {
            sb.append(this.f605a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f604a == null) {
                sb.append("null");
            } else {
                sb.append(this.f604a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
