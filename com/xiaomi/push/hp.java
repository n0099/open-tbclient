package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f525a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f524a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14397a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f525a == null) {
            return 0;
        }
        return this.f525a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m374a()).compareTo(Boolean.valueOf(hpVar.m374a()));
            if (compareTo == 0) {
                if (!m374a() || (a2 = iy.a(this.f525a, hpVar.f525a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m373a() {
        if (this.f525a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f525a == null) {
            this.f525a = new ArrayList();
        }
        this.f525a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m373a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f525a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f525a.add(hqVar);
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
    public boolean m374a() {
        return this.f525a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m374a = m374a();
        boolean m374a2 = hpVar.m374a();
        return !(m374a || m374a2) || (m374a && m374a2 && this.f525a.equals(hpVar.f525a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m373a();
        jiVar.a(f524a);
        if (this.f525a != null) {
            jiVar.a(f14397a);
            jiVar.a(new jg((byte) 12, this.f525a.size()));
            for (hq hqVar : this.f525a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m375a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f525a == null) {
            sb.append("null");
        } else {
            sb.append(this.f525a);
        }
        sb.append(")");
        return sb.toString();
    }
}
