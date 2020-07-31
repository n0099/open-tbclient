package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes9.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f473a;

    /* renamed from: a  reason: collision with other field name */
    public hs f474a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f475a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f476a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f472a = new jn("NormalConfig");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f473a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m355a()).compareTo(Boolean.valueOf(hvVar.m355a()));
            if (compareTo == 0) {
                if (!m355a() || (a4 = iy.a(this.f473a, hvVar.f473a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f476a, hvVar.f476a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f474a, hvVar.f474a)) == 0) {
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
    public hs m353a() {
        return this.f474a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m354a() {
        if (this.f476a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!m355a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m354a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a == 8) {
                        this.f473a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 2:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f476a = new ArrayList(m481a.f781a);
                        for (int i = 0; i < m481a.f781a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f476a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 8) {
                        this.f474a = hs.a(jiVar.m478a());
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f475a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m355a() {
        return this.f475a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m356a(hv hvVar) {
        if (hvVar != null && this.f473a == hvVar.f473a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f476a.equals(hvVar.f476a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f474a.equals(hvVar.f474a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m354a();
        jiVar.a(f472a);
        jiVar.a(a);
        jiVar.a(this.f473a);
        jiVar.b();
        if (this.f476a != null) {
            jiVar.a(b);
            jiVar.a(new jg((byte) 12, this.f476a.size()));
            for (hx hxVar : this.f476a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f474a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f474a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public boolean b() {
        return this.f476a != null;
    }

    public boolean c() {
        return this.f474a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m356a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f473a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f476a == null) {
            sb.append("null");
        } else {
            sb.append(this.f476a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f474a == null) {
                sb.append("null");
            } else {
                sb.append(this.f474a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
