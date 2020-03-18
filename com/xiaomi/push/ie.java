package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f622a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f621a = new jh("XmPushActionNormalConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m412a()).compareTo(Boolean.valueOf(ieVar.m412a()));
            if (compareTo == 0) {
                if (!m412a() || (a2 = is.a(this.f622a, ieVar.f622a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f622a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m411a() {
        if (this.f622a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                m411a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a == 15) {
                        ja m467a = jcVar.m467a();
                        this.f622a = new ArrayList(m467a.f791a);
                        for (int i = 0; i < m467a.f791a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f622a.add(hpVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m466a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m412a() {
        return this.f622a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m413a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m412a = m412a();
        boolean m412a2 = ieVar.m412a();
        return !(m412a || m412a2) || (m412a && m412a2 && this.f622a.equals(ieVar.f622a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m411a();
        jcVar.a(f621a);
        if (this.f622a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f622a.size()));
            for (hp hpVar : this.f622a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m413a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f622a == null) {
            sb.append("null");
        } else {
            sb.append(this.f622a);
        }
        sb.append(")");
        return sb.toString();
    }
}
