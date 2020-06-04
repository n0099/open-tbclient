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
            int compareTo = Boolean.valueOf(m404a()).compareTo(Boolean.valueOf(cif.m404a()));
            if (compareTo == 0) {
                if (!m404a() || (a2 = iy.a(this.f571a, cif.f571a)) == 0) {
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
        jiVar.m486a();
        while (true) {
            jf m482a = jiVar.m482a();
            if (m482a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a == 15) {
                        jg m483a = jiVar.m483a();
                        this.f571a = new ArrayList(m483a.f778a);
                        for (int i = 0; i < m483a.f778a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f571a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m482a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a() {
        return this.f571a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m404a = m404a();
        boolean m404a2 = cif.m404a();
        return !(m404a || m404a2) || (m404a && m404a2 && this.f571a.equals(cif.f571a));
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
        jiVar.m490a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m405a((Cif) obj);
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
