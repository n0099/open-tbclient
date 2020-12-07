package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes18.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f573a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f572a = new jn("XmPushActionCollectData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4745a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m400a()).compareTo(Boolean.valueOf(cif.m400a()));
            if (compareTo == 0) {
                if (!m400a() || (a2 = iy.a(this.f573a, cif.f573a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f573a = list;
        return this;
    }

    public void a() {
        if (this.f573a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 15) {
                        jg m479a = jiVar.m479a();
                        this.f573a = new ArrayList(m479a.f780a);
                        for (int i = 0; i < m479a.f780a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f573a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a() {
        return this.f573a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m400a = m400a();
        boolean m400a2 = cif.m400a();
        return !(m400a || m400a2) || (m400a && m400a2 && this.f573a.equals(cif.f573a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f572a);
        if (this.f573a != null) {
            jiVar.a(f4745a);
            jiVar.a(new jg((byte) 12, this.f573a.size()));
            for (hu huVar : this.f573a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m401a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f573a == null) {
            sb.append("null");
        } else {
            sb.append(this.f573a);
        }
        sb.append(")");
        return sb.toString();
    }
}
