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
            int compareTo = Boolean.valueOf(m414a()).compareTo(Boolean.valueOf(ieVar.m414a()));
            if (compareTo == 0) {
                if (!m414a() || (a2 = is.a(this.f623a, ieVar.f623a)) == 0) {
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
    public void m413a() {
        if (this.f623a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m413a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f623a = new ArrayList(m469a.f792a);
                        for (int i = 0; i < m469a.f792a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f623a.add(hpVar);
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
    public boolean m414a() {
        return this.f623a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m414a = m414a();
        boolean m414a2 = ieVar.m414a();
        return !(m414a || m414a2) || (m414a && m414a2 && this.f623a.equals(ieVar.f623a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m413a();
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
        jcVar.m476a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m415a((ie) obj);
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
