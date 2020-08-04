package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f450a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f449a = new jn("ClientUploadData");
    private static final jf a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f450a == null) {
            return 0;
        }
        return this.f450a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m339a()).compareTo(Boolean.valueOf(hpVar.m339a()));
            if (compareTo == 0) {
                if (!m339a() || (a2 = iy.a(this.f450a, hpVar.f450a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m338a() {
        if (this.f450a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f450a == null) {
            this.f450a = new ArrayList();
        }
        this.f450a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m338a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f450a = new ArrayList(m481a.f784a);
                        for (int i = 0; i < m481a.f784a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f450a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        return this.f450a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m340a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m339a = m339a();
        boolean m339a2 = hpVar.m339a();
        return !(m339a || m339a2) || (m339a && m339a2 && this.f450a.equals(hpVar.f450a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m338a();
        jiVar.a(f449a);
        if (this.f450a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f450a.size()));
            for (hq hqVar : this.f450a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m340a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f450a == null) {
            sb.append("null");
        } else {
            sb.append(this.f450a);
        }
        sb.append(")");
        return sb.toString();
    }
}
