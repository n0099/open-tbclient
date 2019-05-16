package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class o implements Serializable, Cloneable, org.apache.thrift.a<o, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j c = new org.apache.thrift.protocol.j("Location");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("", (byte) 4, 1);
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 4, 2);
    public double a;
    public double b;
    private BitSet f = new BitSet(2);

    public double a() {
        return this.a;
    }

    public o a(double d2) {
        this.a = d2;
        a(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'longitude' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new org.apache.thrift.protocol.f("Required field 'latitude' was not found in serialized data! Struct: " + toString());
                }
                e();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.v();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.v();
                        b(true);
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
        this.f.set(0, z);
    }

    public boolean a(o oVar) {
        return oVar != null && this.a == oVar.a && this.b == oVar.b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(o oVar) {
        int a;
        int a2;
        if (getClass().equals(oVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(oVar.b()));
            if (compareTo == 0) {
                if (!b() || (a2 = org.apache.thrift.b.a(this.a, oVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(oVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a = org.apache.thrift.b.a(this.b, oVar.b)) == 0) {
                            return 0;
                        }
                        return a;
                    }
                    return compareTo2;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(oVar.getClass().getName());
    }

    public o b(double d2) {
        this.b = d2;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(c);
        eVar.a(d);
        eVar.a(this.a);
        eVar.b();
        eVar.a(e);
        eVar.a(this.b);
        eVar.b();
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.f.set(1, z);
    }

    public boolean b() {
        return this.f.get(0);
    }

    public double c() {
        return this.b;
    }

    public boolean d() {
        return this.f.get(1);
    }

    public void e() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof o)) {
            return a((o) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Location(longitude:" + this.a + ", latitude:" + this.b + ")";
    }
}
