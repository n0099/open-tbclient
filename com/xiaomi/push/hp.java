package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f444a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f443a = new jn("ClientUploadData");
    private static final jf a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f444a == null) {
            return 0;
        }
        return this.f444a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m342a()).compareTo(Boolean.valueOf(hpVar.m342a()));
            if (compareTo == 0) {
                if (!m342a() || (a2 = iy.a(this.f444a, hpVar.f444a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m341a() {
        if (this.f444a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f444a == null) {
            this.f444a = new ArrayList();
        }
        this.f444a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                m341a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a == 15) {
                        jg m484a = jiVar.m484a();
                        this.f444a = new ArrayList(m484a.f778a);
                        for (int i = 0; i < m484a.f778a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f444a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m342a() {
        return this.f444a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m343a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m342a = m342a();
        boolean m342a2 = hpVar.m342a();
        return !(m342a || m342a2) || (m342a && m342a2 && this.f444a.equals(hpVar.f444a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m341a();
        jiVar.a(f443a);
        if (this.f444a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f444a.size()));
            for (hq hqVar : this.f444a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m343a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f444a == null) {
            sb.append("null");
        } else {
            sb.append(this.f444a);
        }
        sb.append(")");
        return sb.toString();
    }
}
