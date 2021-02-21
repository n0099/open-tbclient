package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f524a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f523a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14099a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f524a == null) {
            return 0;
        }
        return this.f524a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m369a()).compareTo(Boolean.valueOf(hpVar.m369a()));
            if (compareTo == 0) {
                if (!m369a() || (a2 = iy.a(this.f524a, hpVar.f524a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m368a() {
        if (this.f524a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f524a == null) {
            this.f524a = new ArrayList();
        }
        this.f524a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m368a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a == 15) {
                        jg m511a = jiVar.m511a();
                        this.f524a = new ArrayList(m511a.f858a);
                        for (int i = 0; i < m511a.f858a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f524a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m369a() {
        return this.f524a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m370a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m369a = m369a();
        boolean m369a2 = hpVar.m369a();
        return !(m369a || m369a2) || (m369a && m369a2 && this.f524a.equals(hpVar.f524a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m368a();
        jiVar.a(f523a);
        if (this.f524a != null) {
            jiVar.a(f14099a);
            jiVar.a(new jg((byte) 12, this.f524a.size()));
            for (hq hqVar : this.f524a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m370a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f524a == null) {
            sb.append("null");
        } else {
            sb.append(this.f524a);
        }
        sb.append(")");
        return sb.toString();
    }
}
