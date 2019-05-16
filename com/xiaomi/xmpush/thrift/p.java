package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class p implements Serializable, Cloneable, org.apache.thrift.a<p, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("LocationInfo");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 15, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("", (byte) 15, 2);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("", (byte) 12, 3);
    public List<y> a;
    public List<c> b;
    public l c;

    public p a(l lVar) {
        this.c = lVar;
        return this;
    }

    public p a(List<y> list) {
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
                e();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.a = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            y yVar = new y();
                            yVar.a(eVar);
                            this.a.add(yVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.b = new ArrayList(m2.b);
                        for (int i3 = 0; i3 < m2.b; i3++) {
                            c cVar = new c();
                            cVar.a(eVar);
                            this.b.add(cVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 12) {
                        this.c = new l();
                        this.c.a(eVar);
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

    public boolean a(p pVar) {
        if (pVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = pVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(pVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = pVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(pVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = pVar.d();
        return !(d2 || d3) || (d2 && d3 && this.c.a(pVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(p pVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(pVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(pVar.a()));
            if (compareTo == 0) {
                if (!a() || (a3 = org.apache.thrift.b.a(this.a, pVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(pVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = org.apache.thrift.b.a(this.b, pVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(pVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a = org.apache.thrift.b.a(this.c, pVar.c)) == 0) {
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
        return getClass().getName().compareTo(pVar.getClass().getName());
    }

    public p b(List<c> list) {
        this.b = list;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(d);
        if (this.a != null && a()) {
            eVar.a(e);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (y yVar : this.a) {
                yVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (c cVar : this.b) {
                cVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null && d()) {
            eVar.a(g);
            this.c.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public l c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof p)) {
            return a((p) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("LocationInfo(");
        boolean z2 = true;
        if (a()) {
            sb.append("wifiList:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("cellList:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z = z2;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("gps:");
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
