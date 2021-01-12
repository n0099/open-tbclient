package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f550a;

    /* renamed from: a  reason: collision with other field name */
    public hs f551a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f552a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f553a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f549a = new jn("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14108a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14109b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f550a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m386a()).compareTo(Boolean.valueOf(hvVar.m386a()));
            if (compareTo == 0) {
                if (!m386a() || (a4 = iy.a(this.f550a, hvVar.f550a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f553a, hvVar.f553a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f551a, hvVar.f551a)) == 0) {
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
    public hs m384a() {
        return this.f551a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m385a() {
        if (this.f553a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!m386a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m385a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a == 8) {
                        this.f550a = jiVar.m509a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 2:
                    if (m511a.f14171a == 15) {
                        jg m512a = jiVar.m512a();
                        this.f553a = new ArrayList(m512a.f858a);
                        for (int i = 0; i < m512a.f858a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f553a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                case 3:
                    if (m511a.f14171a == 8) {
                        this.f551a = hs.a(jiVar.m509a());
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f552a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m386a() {
        return this.f552a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m387a(hv hvVar) {
        if (hvVar != null && this.f550a == hvVar.f550a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f553a.equals(hvVar.f553a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f551a.equals(hvVar.f551a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m385a();
        jiVar.a(f549a);
        jiVar.a(f14108a);
        jiVar.a(this.f550a);
        jiVar.b();
        if (this.f553a != null) {
            jiVar.a(f14109b);
            jiVar.a(new jg((byte) 12, this.f553a.size()));
            for (hx hxVar : this.f553a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f551a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f551a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public boolean b() {
        return this.f553a != null;
    }

    public boolean c() {
        return this.f551a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m387a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f550a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f553a == null) {
            sb.append("null");
        } else {
            sb.append(this.f553a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f551a == null) {
                sb.append("null");
            } else {
                sb.append(this.f551a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
