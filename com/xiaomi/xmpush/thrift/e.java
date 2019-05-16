package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class e implements Serializable, Cloneable, org.apache.thrift.a<e, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j b = new org.apache.thrift.protocol.j("ClientUploadData");
    private static final org.apache.thrift.protocol.b c = new org.apache.thrift.protocol.b("", (byte) 15, 1);
    public List<f> a;

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public void a(f fVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(fVar);
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
                            f fVar = new f();
                            fVar.a(eVar);
                            this.a.add(fVar);
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

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = eVar.b();
        return !(b2 || b3) || (b2 && b3 && this.a.equals(eVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(e eVar) {
        int a;
        if (getClass().equals(eVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eVar.b()));
            if (compareTo == 0) {
                if (!b() || (a = org.apache.thrift.b.a(this.a, eVar.a)) == 0) {
                    return 0;
                }
                return a;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(eVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(b);
        if (this.a != null) {
            eVar.a(c);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (f fVar : this.a) {
                fVar.b(eVar);
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
            throw new org.apache.thrift.protocol.f("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e)) {
            return a((e) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
