package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes5.dex */
public class hp implements ir<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f489a;

    /* renamed from: a  reason: collision with other field name */
    public hm f490a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f491a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f492a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f488a = new jh("NormalConfig");
    private static final iz a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 15, 2);
    private static final iz c = new iz("", (byte) 8, 3);

    public int a() {
        return this.f489a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m335a()).compareTo(Boolean.valueOf(hpVar.m335a()));
            if (compareTo == 0) {
                if (!m335a() || (a4 = is.a(this.f489a, hpVar.f489a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f492a, hpVar.f492a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f490a, hpVar.f490a)) == 0) {
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
    public hm m333a() {
        return this.f490a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m334a() {
        if (this.f492a == null) {
            throw new jd("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!m335a()) {
                    throw new jd("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m334a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 8) {
                        this.f489a = jcVar.m452a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f492a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f492a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 8) {
                        this.f490a = hm.a(jcVar.m452a());
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

    public void a(boolean z) {
        this.f491a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m335a() {
        return this.f491a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m336a(hp hpVar) {
        if (hpVar != null && this.f489a == hpVar.f489a) {
            boolean b2 = b();
            boolean b3 = hpVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f492a.equals(hpVar.f492a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hpVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f490a.equals(hpVar.f490a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m334a();
        jcVar.a(f488a);
        jcVar.a(a);
        jcVar.a(this.f489a);
        jcVar.b();
        if (this.f492a != null) {
            jcVar.a(b);
            jcVar.a(new ja((byte) 12, this.f492a.size()));
            for (hr hrVar : this.f492a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f490a != null && c()) {
            jcVar.a(c);
            jcVar.a(this.f490a.a());
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f492a != null;
    }

    public boolean c() {
        return this.f490a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m336a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f489a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f492a == null) {
            sb.append("null");
        } else {
            sb.append(this.f492a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f490a == null) {
                sb.append("null");
            } else {
                sb.append(this.f490a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
