package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes6.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f652a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f651a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14430a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m437a()).compareTo(Boolean.valueOf(cif.m437a()));
            if (compareTo == 0) {
                if (!m437a() || (a2 = iy.a(this.f652a, cif.f652a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f652a = list;
        return this;
    }

    public void a() {
        if (this.f652a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f652a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f652a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a() {
        return this.f652a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m438a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m437a = m437a();
        boolean m437a2 = cif.m437a();
        return !(m437a || m437a2) || (m437a && m437a2 && this.f652a.equals(cif.f652a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f651a);
        if (this.f652a != null) {
            jiVar.a(f14430a);
            jiVar.a(new jg((byte) 12, this.f652a.size()));
            for (hu huVar : this.f652a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m438a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f652a == null) {
            sb.append("null");
        } else {
            sb.append(this.f652a);
        }
        sb.append(")");
        return sb.toString();
    }
}
