package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class v implements Serializable, Cloneable, org.apache.thrift.a<v, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j b = new org.apache.thrift.protocol.j("RegisteredGeoFencing");
    private static final org.apache.thrift.protocol.b c = new org.apache.thrift.protocol.b("", (byte) 14, 1);
    public Set<m> a;

    public v a(Set<m> set) {
        this.a = set;
        return this;
    }

    public Set<m> a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                c();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 14) {
                        org.apache.thrift.protocol.i o = eVar.o();
                        this.a = new HashSet(o.b * 2);
                        for (int i2 = 0; i2 < o.b; i2++) {
                            m mVar = new m();
                            mVar.a(eVar);
                            this.a.add(mVar);
                        }
                        eVar.p();
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

    public boolean a(v vVar) {
        if (vVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = vVar.b();
        return !(b2 || b3) || (b2 && b3 && this.a.equals(vVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(v vVar) {
        int a;
        if (getClass().equals(vVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(vVar.b()));
            if (compareTo == 0) {
                if (!b() || (a = org.apache.thrift.b.a(this.a, vVar.a)) == 0) {
                    return 0;
                }
                return a;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(vVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(b);
        if (this.a != null) {
            eVar.a(c);
            eVar.a(new org.apache.thrift.protocol.i((byte) 12, this.a.size()));
            for (m mVar : this.a) {
                mVar.b(eVar);
            }
            eVar.f();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'geoFencings' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof v)) {
            return a((v) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RegisteredGeoFencing(");
        sb.append("geoFencings:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
