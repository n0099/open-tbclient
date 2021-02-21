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
    private static final jf f14132a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m432a()).compareTo(Boolean.valueOf(cif.m432a()));
            if (compareTo == 0) {
                if (!m432a() || (a2 = iy.a(this.f651a, cif.f651a)) == 0) {
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
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a == 15) {
                        jg m511a = jiVar.m511a();
                        this.f651a = new ArrayList(m511a.f858a);
                        for (int i = 0; i < m511a.f858a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f651a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
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
    public boolean m432a() {
        return this.f651a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m432a = m432a();
        boolean m432a2 = cif.m432a();
        return !(m432a || m432a2) || (m432a && m432a2 && this.f651a.equals(cif.f651a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f650a);
        if (this.f651a != null) {
            jiVar.a(f14132a);
            jiVar.a(new jg((byte) 12, this.f651a.size()));
            for (hu huVar : this.f651a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m433a((Cif) obj);
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
