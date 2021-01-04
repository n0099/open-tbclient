package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes6.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f651a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f650a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14429a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m426a()).compareTo(Boolean.valueOf(cif.m426a()));
            if (compareTo == 0) {
                if (!m426a() || (a2 = iy.a(this.f651a, cif.f651a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f651a = list;
        return this;
    }

    public void a() {
        if (this.f651a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 15) {
                        jg m505a = jiVar.m505a();
                        this.f651a = new ArrayList(m505a.f858a);
                        for (int i = 0; i < m505a.f858a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f651a.add(huVar);
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
    public boolean m426a() {
        return this.f651a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m427a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m426a = m426a();
        boolean m426a2 = cif.m426a();
        return !(m426a || m426a2) || (m426a && m426a2 && this.f651a.equals(cif.f651a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f650a);
        if (this.f651a != null) {
            jiVar.a(f14429a);
            jiVar.a(new jg((byte) 12, this.f651a.size()));
            for (hu huVar : this.f651a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m427a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f651a == null) {
            sb.append("null");
        } else {
            sb.append(this.f651a);
        }
        sb.append(")");
        return sb.toString();
    }
}
