package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f623a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f622a = new jh("XmPushActionNormalConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m417a()).compareTo(Boolean.valueOf(ieVar.m417a()));
            if (compareTo == 0) {
                if (!m417a() || (a2 = is.a(this.f623a, ieVar.f623a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f623a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m416a() {
        if (this.f623a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m416a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f623a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f623a.add(hpVar);
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
    public boolean m417a() {
        return this.f623a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m418a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m417a = m417a();
        boolean m417a2 = ieVar.m417a();
        return !(m417a || m417a2) || (m417a && m417a2 && this.f623a.equals(ieVar.f623a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m416a();
        jcVar.a(f622a);
        if (this.f623a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f623a.size()));
            for (hp hpVar : this.f623a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m418a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f623a == null) {
            sb.append("null");
        } else {
            sb.append(this.f623a);
        }
        sb.append(")");
        return sb.toString();
    }
}
