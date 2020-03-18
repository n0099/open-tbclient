package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f484a;

    /* renamed from: a  reason: collision with other field name */
    public hm f485a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f486a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f487a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f483a = new jh("NormalConfig");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);
    private static final iz c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f484a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m347a()).compareTo(Boolean.valueOf(hpVar.m347a()));
            if (compareTo == 0) {
                if (!m347a() || (a4 = is.a(this.f484a, hpVar.f484a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f487a, hpVar.f487a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f485a, hpVar.f485a)) == 0) {
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
    public hm m345a() {
        return this.f485a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m346a() {
        if (this.f487a == null) {
            throw new jd("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                if (!m347a()) {
                    throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m346a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a == 8) {
                        this.f484a = jcVar.m464a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 2:
                    if (m466a.a == 15) {
                        ja m467a = jcVar.m467a();
                        this.f487a = new ArrayList(m467a.f791a);
                        for (int i = 0; i < m467a.f791a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f487a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 3:
                    if (m466a.a == 8) {
                        this.f485a = hm.a(jcVar.m464a());
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

    public void a(boolean z) {
        this.f486a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a() {
        return this.f486a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a(hp hpVar) {
        if (hpVar != null && this.f484a == hpVar.f484a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f487a.equals(hpVar.f487a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f485a.equals(hpVar.f485a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m346a();
        jcVar.a(f483a);
        jcVar.a(a);
        jcVar.a(this.f484a);
        jcVar.b();
        if (this.f487a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f487a.size()));
            for (hr hrVar : this.f487a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f485a != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f485a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean b() {
        return this.f487a != null;
    }

    public boolean c() {
        return this.f485a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m348a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f484a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f487a == null) {
            sb.append("null");
        } else {
            sb.append(this.f487a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f485a == null) {
                sb.append("null");
            } else {
                sb.append(this.f485a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
