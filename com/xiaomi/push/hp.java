package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f446a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f445a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4728a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f446a == null) {
            return 0;
        }
        return this.f446a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m337a()).compareTo(Boolean.valueOf(hpVar.m337a()));
            if (compareTo == 0) {
                if (!m337a() || (a2 = iy.a(this.f446a, hpVar.f446a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m336a() {
        if (this.f446a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f446a == null) {
            this.f446a = new ArrayList();
        }
        this.f446a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                m336a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 15) {
                        jg m479a = jiVar.m479a();
                        this.f446a = new ArrayList(m479a.f780a);
                        for (int i = 0; i < m479a.f780a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f446a.add(hqVar);
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
    public boolean m337a() {
        return this.f446a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m338a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m337a = m337a();
        boolean m337a2 = hpVar.m337a();
        return !(m337a || m337a2) || (m337a && m337a2 && this.f446a.equals(hpVar.f446a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m336a();
        jiVar.a(f445a);
        if (this.f446a != null) {
            jiVar.a(f4728a);
            jiVar.a(new jg((byte) 12, this.f446a.size()));
            for (hq hqVar : this.f446a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m338a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f446a == null) {
            sb.append("null");
        } else {
            sb.append(this.f446a);
        }
        sb.append(")");
        return sb.toString();
    }
}
