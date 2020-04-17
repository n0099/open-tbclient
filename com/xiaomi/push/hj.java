package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f459a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f458a = new jh("ClientUploadData");
    private static final iz a = new iz("", (byte) 15, 1);

    public int a() {
        if (this.f459a == null) {
            return 0;
        }
        return this.f459a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m336a()).compareTo(Boolean.valueOf(hjVar.m336a()));
            if (compareTo == 0) {
                if (!m336a() || (a2 = is.a(this.f459a, hjVar.f459a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m335a() {
        if (this.f459a == null) {
            throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hk hkVar) {
        if (this.f459a == null) {
            this.f459a = new ArrayList();
        }
        this.f459a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m335a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f459a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            hk hkVar = new hk();
                            hkVar.a(jcVar);
                            this.f459a.add(hkVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m336a() {
        return this.f459a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m337a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m336a = m336a();
        boolean m336a2 = hjVar.m336a();
        return !(m336a || m336a2) || (m336a && m336a2 && this.f459a.equals(hjVar.f459a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m335a();
        jcVar.a(f458a);
        if (this.f459a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f459a.size()));
            for (hk hkVar : this.f459a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m337a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f459a == null) {
            sb.append("null");
        } else {
            sb.append(this.f459a);
        }
        sb.append(")");
        return sb.toString();
    }
}
