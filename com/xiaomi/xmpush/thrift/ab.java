package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ab implements Serializable, Cloneable, org.apache.thrift.a<ab, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j c = new org.apache.thrift.protocol.j("XmPushActionCheckClientInfo");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 8, 2);
    public int a;
    public int b;
    private BitSet f = new BitSet(2);

    public ab a(int i) {
        this.a = i;
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
                if (!a()) {
                    throw new org.apache.thrift.protocol.f("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
                c();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.t();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.t();
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

    public boolean a() {
        return this.f.get(0);
    }

    public boolean a(ab abVar) {
        return abVar != null && this.a == abVar.a && this.b == abVar.b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ab abVar) {
        int a;
        int a2;
        if (getClass().equals(abVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(abVar.a()));
            if (compareTo == 0) {
                if (!a() || (a2 = org.apache.thrift.b.a(this.a, abVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(abVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a = org.apache.thrift.b.a(this.b, abVar.b)) == 0) {
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
        return getClass().getName().compareTo(abVar.getClass().getName());
    }

    public ab b(int i) {
        this.b = i;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
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
        return this.f.get(1);
    }

    public void c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            return a((ab) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.a + ", pluginConfigVersion:" + this.b + ")";
    }
}
