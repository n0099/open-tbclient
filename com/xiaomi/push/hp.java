package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f485a;

    /* renamed from: a  reason: collision with other field name */
    public hm f486a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f487a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f488a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f484a = new jh("NormalConfig");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);
    private static final iz c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f485a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m352a()).compareTo(Boolean.valueOf(hpVar.m352a()));
            if (compareTo == 0) {
                if (!m352a() || (a4 = is.a(this.f485a, hpVar.f485a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f488a, hpVar.f488a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f486a, hpVar.f486a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hm m350a() {
        return this.f486a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m351a() {
        if (this.f488a == null) {
            throw new jd("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                if (!m352a()) {
                    throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m351a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 8) {
                        this.f485a = jcVar.m469a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f488a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f488a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 8) {
                        this.f486a = hm.a(jcVar.m469a());
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

    public void a(boolean z) {
        this.f487a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m352a() {
        return this.f487a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m353a(hp hpVar) {
        if (hpVar != null && this.f485a == hpVar.f485a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f488a.equals(hpVar.f488a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f486a.equals(hpVar.f486a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m351a();
        jcVar.a(f484a);
        jcVar.a(a);
        jcVar.a(this.f485a);
        jcVar.b();
        if (this.f488a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f488a.size()));
            for (hr hrVar : this.f488a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f486a != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f486a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean b() {
        return this.f488a != null;
    }

    public boolean c() {
        return this.f486a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m353a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f485a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f488a == null) {
            sb.append("null");
        } else {
            sb.append(this.f488a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f486a == null) {
                sb.append("null");
            } else {
                sb.append(this.f486a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
