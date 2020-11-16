package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes18.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f575a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f574a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4975a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(cif.m410a()));
            if (compareTo == 0) {
                if (!m410a() || (a2 = iy.a(this.f575a, cif.f575a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f575a = list;
        return this;
    }

    public void a() {
        if (this.f575a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f575a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f575a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
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
    public boolean m410a() {
        return this.f575a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m410a = m410a();
        boolean m410a2 = cif.m410a();
        return !(m410a || m410a2) || (m410a && m410a2 && this.f575a.equals(cif.f575a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f574a);
        if (this.f575a != null) {
            jiVar.a(f4975a);
            jiVar.a(new jg((byte) 12, this.f575a.size()));
            for (hu huVar : this.f575a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m411a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f575a == null) {
            sb.append("null");
        } else {
            sb.append(this.f575a);
        }
        sb.append(")");
        return sb.toString();
    }
}
