package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
            int compareTo = Boolean.valueOf(m333a()).compareTo(Boolean.valueOf(hjVar.m333a()));
            if (compareTo == 0) {
                if (!m333a() || (a2 = is.a(this.f458a, hjVar.f458a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m332a() {
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
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m332a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f458a = new ArrayList(m469a.f791a);
                        for (int i = 0; i < m469a.f791a; i++) {
                            hk hkVar = new hk();
                            hkVar.a(jcVar);
                            this.f458a.add(hkVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m333a() {
        return this.f458a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m334a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m333a = m333a();
        boolean m333a2 = hjVar.m333a();
        return !(m333a || m333a2) || (m333a && m333a2 && this.f458a.equals(hjVar.f458a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m332a();
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
        jcVar.m476a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m334a((hj) obj);
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
