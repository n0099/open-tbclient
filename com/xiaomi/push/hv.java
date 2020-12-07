package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes18.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f472a;

    /* renamed from: a  reason: collision with other field name */
    public hs f473a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f474a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f475a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f471a = new jn("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4734a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f472a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m353a()).compareTo(Boolean.valueOf(hvVar.m353a()));
            if (compareTo == 0) {
                if (!m353a() || (a4 = iy.a(this.f472a, hvVar.f472a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f475a, hvVar.f475a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f473a, hvVar.f473a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hvVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m351a() {
        return this.f473a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m352a() {
        if (this.f475a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!m353a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m352a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 8) {
                        this.f472a = jiVar.m476a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 2:
                    if (m478a.f4770a == 15) {
                        jg m479a = jiVar.m479a();
                        this.f475a = new ArrayList(m479a.f780a);
                        for (int i = 0; i < m479a.f780a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f475a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                case 3:
                    if (m478a.f4770a == 8) {
                        this.f473a = hs.a(jiVar.m476a());
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f474a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m353a() {
        return this.f474a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m354a(hv hvVar) {
        if (hvVar != null && this.f472a == hvVar.f472a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f475a.equals(hvVar.f475a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f473a.equals(hvVar.f473a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m352a();
        jiVar.a(f471a);
        jiVar.a(f4734a);
        jiVar.a(this.f472a);
        jiVar.b();
        if (this.f475a != null) {
            jiVar.a(b);
            jiVar.a(new jg((byte) 12, this.f475a.size()));
            for (hx hxVar : this.f475a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f473a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f473a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean b() {
        return this.f475a != null;
    }

    public boolean c() {
        return this.f473a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m354a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f472a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f475a == null) {
            sb.append("null");
        } else {
            sb.append(this.f475a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f473a == null) {
                sb.append("null");
            } else {
                sb.append(this.f473a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
