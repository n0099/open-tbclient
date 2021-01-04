package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f524a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f523a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14396a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f524a == null) {
            return 0;
        }
        return this.f524a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m363a()).compareTo(Boolean.valueOf(hpVar.m363a()));
            if (compareTo == 0) {
                if (!m363a() || (a2 = iy.a(this.f524a, hpVar.f524a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m362a() {
        if (this.f524a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f524a == null) {
            this.f524a = new ArrayList();
        }
        this.f524a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                m362a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 15) {
                        jg m505a = jiVar.m505a();
                        this.f524a = new ArrayList(m505a.f858a);
                        for (int i = 0; i < m505a.f858a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f524a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m363a() {
        return this.f524a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m363a = m363a();
        boolean m363a2 = hpVar.m363a();
        return !(m363a || m363a2) || (m363a && m363a2 && this.f524a.equals(hpVar.f524a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m362a();
        jiVar.a(f523a);
        if (this.f524a != null) {
            jiVar.a(f14396a);
            jiVar.a(new jg((byte) 12, this.f524a.size()));
            for (hq hqVar : this.f524a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m364a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f524a == null) {
            sb.append("null");
        } else {
            sb.append(this.f524a);
        }
        sb.append(")");
        return sb.toString();
    }
}
