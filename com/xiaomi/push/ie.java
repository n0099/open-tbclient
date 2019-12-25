package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f627a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f626a = new jh("XmPushActionNormalConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m400a()).compareTo(Boolean.valueOf(ieVar.m400a()));
            if (compareTo == 0) {
                if (!m400a() || (a2 = is.a(this.f627a, ieVar.f627a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f627a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m399a() {
        if (this.f627a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m399a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f627a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f627a.add(hpVar);
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
    public boolean m400a() {
        return this.f627a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m400a = m400a();
        boolean m400a2 = ieVar.m400a();
        return !(m400a || m400a2) || (m400a && m400a2 && this.f627a.equals(ieVar.f627a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m399a();
        jcVar.a(f626a);
        if (this.f627a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f627a.size()));
            for (hp hpVar : this.f627a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m401a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f627a == null) {
            sb.append("null");
        } else {
            sb.append(this.f627a);
        }
        sb.append(")");
        return sb.toString();
    }
}
