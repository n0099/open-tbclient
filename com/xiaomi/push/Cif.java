package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes8.dex */
public class Cif implements ix<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f577a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f576a = new jn("XmPushActionCollectData");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m401a()).compareTo(Boolean.valueOf(cif.m401a()));
            if (compareTo == 0) {
                if (!m401a() || (a2 = iy.a(this.f577a, cif.f577a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public Cif a(List<hu> list) {
        this.f577a = list;
        return this;
    }

    public void a() {
        if (this.f577a == null) {
            throw new jj("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f577a = new ArrayList(m480a.f784a);
                        for (int i = 0; i < m480a.f784a; i++) {
                            hu huVar = new hu();
                            huVar.a(jiVar);
                            this.f577a.add(huVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a() {
        return this.f577a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m402a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m401a = m401a();
        boolean m401a2 = cif.m401a();
        return !(m401a || m401a2) || (m401a && m401a2 && this.f577a.equals(cif.f577a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f576a);
        if (this.f577a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f577a.size()));
            for (hu huVar : this.f577a) {
                huVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m402a((Cif) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f577a == null) {
            sb.append("null");
        } else {
            sb.append(this.f577a);
        }
        sb.append(")");
        return sb.toString();
    }
}
