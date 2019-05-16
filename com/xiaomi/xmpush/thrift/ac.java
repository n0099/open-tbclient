package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ac implements Serializable, Cloneable, org.apache.thrift.a<ac, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j b = new org.apache.thrift.protocol.j("XmPushActionCollectData");
    private static final org.apache.thrift.protocol.b c = new org.apache.thrift.protocol.b("", (byte) 15, 1);
    public List<k> a;

    public ac a(List<k> list) {
        this.a = list;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                b();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.a = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            k kVar = new k();
                            kVar.a(eVar);
                            this.a.add(kVar);
                        }
                        eVar.n();
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

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ac acVar) {
        if (acVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = acVar.a();
        return !(a || a2) || (a && a2 && this.a.equals(acVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ac acVar) {
        int a;
        if (getClass().equals(acVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(acVar.a()));
            if (compareTo == 0) {
                if (!a() || (a = org.apache.thrift.b.a(this.a, acVar.a)) == 0) {
                    return 0;
                }
                return a;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(acVar.getClass().getName());
    }

    public void b() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        b();
        eVar.a(b);
        if (this.a != null) {
            eVar.a(c);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (k kVar : this.a) {
                kVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ac)) {
            return a((ac) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
