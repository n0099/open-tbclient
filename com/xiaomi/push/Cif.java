package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes12.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f570a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f569a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4973a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m407a()).compareTo(Boolean.valueOf(cif.m407a()));
            if (compareTo == 0) {
                if (!m407a() || (a2 = iy.a(this.f570a, cif.f570a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f570a = list;
        return this;
    }

    public void a() {
        if (this.f570a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f570a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f570a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a() {
        return this.f570a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m408a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m407a = m407a();
        boolean m407a2 = cif.m407a();
        return !(m407a || m407a2) || (m407a && m407a2 && this.f570a.equals(cif.f570a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f569a);
        if (this.f570a != null) {
            jiVar.a(f4973a);
            jiVar.a(new jg((byte) 12, this.f570a.size()));
            for (hu huVar : this.f570a) {
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
        if (this.f570a == null) {
            sb.append("null");
        } else {
            sb.append(this.f570a);
        }
        sb.append(")");
        return sb.toString();
    }
}
