package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ag implements Serializable, Cloneable, org.apache.thrift.a<ag, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j b = new org.apache.thrift.protocol.j("XmPushActionCustomConfig");
    private static final org.apache.thrift.protocol.b c = new org.apache.thrift.protocol.b("", (byte) 15, 1);
    public List<s> a;

    public List<s> a() {
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
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.a = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            s sVar = new s();
                            sVar.a(eVar);
                            this.a.add(sVar);
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

    public boolean a(ag agVar) {
        if (agVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = agVar.b();
        return !(b2 || b3) || (b2 && b3 && this.a.equals(agVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ag agVar) {
        int a;
        if (getClass().equals(agVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(agVar.b()));
            if (compareTo == 0) {
                if (!b() || (a = org.apache.thrift.b.a(this.a, agVar.a)) == 0) {
                    return 0;
                }
                return a;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(agVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(b);
        if (this.a != null) {
            eVar.a(c);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (s sVar : this.a) {
                sVar.b(eVar);
            }
            eVar.e();
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
            throw new org.apache.thrift.protocol.f("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ag)) {
            return a((ag) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
