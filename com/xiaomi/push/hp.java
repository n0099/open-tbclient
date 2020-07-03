package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
            int compareTo = Boolean.valueOf(m338a()).compareTo(Boolean.valueOf(hpVar.m338a()));
            if (compareTo == 0) {
                if (!m338a() || (a2 = iy.a(this.f450a, hpVar.f450a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m337a() {
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
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m337a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f450a = new ArrayList(m480a.f784a);
                        for (int i = 0; i < m480a.f784a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f450a.add(hqVar);
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
    public boolean m338a() {
        return this.f450a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m338a = m338a();
        boolean m338a2 = hpVar.m338a();
        return !(m338a || m338a2) || (m338a && m338a2 && this.f450a.equals(hpVar.f450a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m337a();
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
        jiVar.m487a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m339a((hp) obj);
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
