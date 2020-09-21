package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes9.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f572a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f571a = new jn("XmPushActionCollectData");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m407a()).compareTo(Boolean.valueOf(cif.m407a()));
            if (compareTo == 0) {
                if (!m407a() || (a2 = iy.a(this.f572a, cif.f572a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f572a = list;
        return this;
    }

    public void a() {
        if (this.f572a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f572a = new ArrayList(m486a.f779a);
                        for (int i = 0; i < m486a.f779a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f572a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a() {
        return this.f572a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m408a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m407a = m407a();
        boolean m407a2 = cif.m407a();
        return !(m407a || m407a2) || (m407a && m407a2 && this.f572a.equals(cif.f572a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f571a);
        if (this.f572a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f572a.size()));
            for (hu huVar : this.f572a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m408a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f572a == null) {
            sb.append("null");
        } else {
            sb.append(this.f572a);
        }
        sb.append(")");
        return sb.toString();
    }
}
