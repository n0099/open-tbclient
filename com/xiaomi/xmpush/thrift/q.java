package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class q implements Serializable, Cloneable, org.apache.thrift.a<q, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("NormalConfig");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("", (byte) 15, 2);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("", (byte) 8, 3);
    public int a;
    public List<s> b;
    public h c;
    private BitSet h = new BitSet(1);

    public int a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                f();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 8) {
                        this.a = eVar.t();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.b = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            s sVar = new s();
                            sVar.a(eVar);
                            this.b.add(sVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 8) {
                        this.c = h.a(eVar.t());
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.h.set(0, z);
    }

    public boolean a(q qVar) {
        if (qVar != null && this.a == qVar.a) {
            boolean c = c();
            boolean c2 = qVar.c();
            if ((c || c2) && !(c && c2 && this.b.equals(qVar.b))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = qVar.e();
            return !(e2 || e3) || (e2 && e3 && this.c.equals(qVar.c));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(q qVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(qVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(qVar.b()));
            if (compareTo == 0) {
                if (!b() || (a3 = org.apache.thrift.b.a(this.a, qVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(qVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a2 = org.apache.thrift.b.a(this.b, qVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(qVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a = org.apache.thrift.b.a(this.c, qVar.c)) == 0) {
                                    return 0;
                                }
                                return a;
                            }
                            return compareTo3;
                        }
                        return a2;
                    }
                    return compareTo2;
                }
                return a3;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(qVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        f();
        eVar.a(d);
        eVar.a(e);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (s sVar : this.b) {
                sVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null && e()) {
            eVar.a(g);
            eVar.a(this.c.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.h.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public h d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof q)) {
            return a((q) obj);
        }
        return false;
    }

    public void f() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.c == null) {
                sb.append("null");
            } else {
                sb.append(this.c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
