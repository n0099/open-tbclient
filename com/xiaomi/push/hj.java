package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f461a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f460a = new jh("ClientUploadData");
    private static final iz a = new iz("", (byte) 15, 1);

    public int a() {
        if (this.f461a == null) {
            return 0;
        }
        return this.f461a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m328a()).compareTo(Boolean.valueOf(hjVar.m328a()));
            if (compareTo == 0) {
                if (!m328a() || (a2 = is.a(this.f461a, hjVar.f461a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m327a() {
        if (this.f461a == null) {
            throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hk hkVar) {
        if (this.f461a == null) {
            this.f461a = new ArrayList();
        }
        this.f461a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m327a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f461a = new ArrayList(m464a.f794a);
                        for (int i = 0; i < m464a.f794a; i++) {
                            hk hkVar = new hk();
                            hkVar.a(jcVar);
                            this.f461a.add(hkVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m328a() {
        return this.f461a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m329a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m328a = m328a();
        boolean m328a2 = hjVar.m328a();
        return !(m328a || m328a2) || (m328a && m328a2 && this.f461a.equals(hjVar.f461a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m327a();
        jcVar.a(f460a);
        if (this.f461a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f461a.size()));
            for (hk hkVar : this.f461a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m329a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f461a == null) {
            sb.append("null");
        } else {
            sb.append(this.f461a);
        }
        sb.append(")");
        return sb.toString();
    }
}
