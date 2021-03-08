package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes5.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f572a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f571a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8438a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m411a()).compareTo(Boolean.valueOf(cif.m411a()));
            if (compareTo == 0) {
                if (!m411a() || (a2 = iy.a(this.f572a, cif.f572a)) == 0) {
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
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 15) {
                        jg m490a = jiVar.m490a();
                        this.f572a = new ArrayList(m490a.f779a);
                        for (int i = 0; i < m490a.f779a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f572a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a() {
        return this.f572a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m412a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m411a = m411a();
        boolean m411a2 = cif.m411a();
        return !(m411a || m411a2) || (m411a && m411a2 && this.f572a.equals(cif.f572a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f571a);
        if (this.f572a != null) {
            jiVar.a(f8438a);
            jiVar.a(new jg((byte) 12, this.f572a.size()));
            for (hu huVar : this.f572a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m412a((Cif) obj);
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
