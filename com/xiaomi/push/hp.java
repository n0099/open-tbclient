package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f488a;

    /* renamed from: a  reason: collision with other field name */
    public hm f489a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f490a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f491a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f487a = new jh("NormalConfig");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);
    private static final iz c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f488a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m344a()).compareTo(Boolean.valueOf(hpVar.m344a()));
            if (compareTo == 0) {
                if (!m344a() || (a4 = is.a(this.f488a, hpVar.f488a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f491a, hpVar.f491a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f489a, hpVar.f489a)) == 0) {
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
    public hm m342a() {
        return this.f489a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m343a() {
        if (this.f491a == null) {
            throw new jd("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!m344a()) {
                    throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m343a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 8) {
                        this.f488a = jcVar.m461a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f491a = new ArrayList(m464a.f795a);
                        for (int i = 0; i < m464a.f795a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f491a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 8) {
                        this.f489a = hm.a(jcVar.m461a());
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

    public void a(boolean z) {
        this.f490a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m344a() {
        return this.f490a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m345a(hp hpVar) {
        if (hpVar != null && this.f488a == hpVar.f488a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f491a.equals(hpVar.f491a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f489a.equals(hpVar.f489a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m343a();
        jcVar.a(f487a);
        jcVar.a(a);
        jcVar.a(this.f488a);
        jcVar.b();
        if (this.f491a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f491a.size()));
            for (hr hrVar : this.f491a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f489a != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f489a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f491a != null;
    }

    public boolean c() {
        return this.f489a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m345a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f488a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f491a == null) {
            sb.append("null");
        } else {
            sb.append(this.f491a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f489a == null) {
                sb.append("null");
            } else {
                sb.append(this.f489a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
