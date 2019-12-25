package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f463a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f462a = new jh("ClientUploadData");
    private static final iz a = new iz("", (byte) 15, 1);

    public int a() {
        if (this.f463a == null) {
            return 0;
        }
        return this.f463a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m319a()).compareTo(Boolean.valueOf(hjVar.m319a()));
            if (compareTo == 0) {
                if (!m319a() || (a2 = is.a(this.f463a, hjVar.f463a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m318a() {
        if (this.f463a == null) {
            throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hk hkVar) {
        if (this.f463a == null) {
            this.f463a = new ArrayList();
        }
        this.f463a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m318a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f463a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            hk hkVar = new hk();
                            hkVar.a(jcVar);
                            this.f463a.add(hkVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m319a() {
        return this.f463a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m320a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m319a = m319a();
        boolean m319a2 = hjVar.m319a();
        return !(m319a || m319a2) || (m319a && m319a2 && this.f463a.equals(hjVar.f463a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m318a();
        jcVar.a(f462a);
        if (this.f463a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f463a.size()));
            for (hk hkVar : this.f463a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m320a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f463a == null) {
            sb.append("null");
        } else {
            sb.append(this.f463a);
        }
        sb.append(")");
        return sb.toString();
    }
}
