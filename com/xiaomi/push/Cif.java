package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes8.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f571a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f570a = new jn("XmPushActionCollectData");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m403a()).compareTo(Boolean.valueOf(cif.m403a()));
            if (compareTo == 0) {
                if (!m403a() || (a2 = iy.a(this.f571a, cif.f571a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f571a = list;
        return this;
    }

    public void a() {
        if (this.f571a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a == 15) {
                        jg m482a = jiVar.m482a();
                        this.f571a = new ArrayList(m482a.f778a);
                        for (int i = 0; i < m482a.f778a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f571a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m481a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m403a() {
        return this.f571a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m403a = m403a();
        boolean m403a2 = cif.m403a();
        return !(m403a || m403a2) || (m403a && m403a2 && this.f571a.equals(cif.f571a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f570a);
        if (this.f571a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f571a.size()));
            for (hu huVar : this.f571a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m404a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f571a == null) {
            sb.append("null");
        } else {
            sb.append(this.f571a);
        }
        sb.append(")");
        return sb.toString();
    }
}
