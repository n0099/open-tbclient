package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class hj implements ir<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f458a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f457a = new jh("ClientUploadData");
    private static final iz a = new iz("", (byte) 15, 1);

    public int a() {
        if (this.f458a == null) {
            return 0;
        }
        return this.f458a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m316a()).compareTo(Boolean.valueOf(hjVar.m316a()));
            if (compareTo == 0) {
                if (!m316a() || (a2 = is.a(this.f458a, hjVar.f458a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m315a() {
        if (this.f458a == null) {
            throw new jd("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hk hkVar) {
        if (this.f458a == null) {
            this.f458a = new ArrayList();
        }
        this.f458a.add(hkVar);
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                m315a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f458a = new ArrayList(m452a.f791a);
                        for (int i = 0; i < m452a.f791a; i++) {
                            hk hkVar = new hk();
                            hkVar.a(jcVar);
                            this.f458a.add(hkVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m316a() {
        return this.f458a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m317a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m316a = m316a();
        boolean m316a2 = hjVar.m316a();
        return !(m316a || m316a2) || (m316a && m316a2 && this.f458a.equals(hjVar.f458a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m315a();
        jcVar.a(f457a);
        if (this.f458a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f458a.size()));
            for (hk hkVar : this.f458a) {
                hkVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m317a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f458a == null) {
            sb.append("null");
        } else {
            sb.append(this.f458a);
        }
        sb.append(")");
        return sb.toString();
    }
}
