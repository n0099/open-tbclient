package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class x implements Serializable, Cloneable, org.apache.thrift.a<x, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j g = new org.apache.thrift.protocol.j("Target");
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("", (byte) 10, 1);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 2, 5);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    public String b;
    public String f;
    private BitSet n = new BitSet(2);
    public long a = 5;
    public String c = "xiaomi.com";
    public String d = "";
    public boolean e = false;

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                if (!a()) {
                    throw new org.apache.thrift.protocol.f("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                g();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = eVar.u();
                        a(true);
                        break;
                    }
                case 2:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.w();
                        break;
                    }
                case 3:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.w();
                        break;
                    }
                case 4:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.q();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
                case 7:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.n.set(0, z);
    }

    public boolean a() {
        return this.n.get(0);
    }

    public boolean a(x xVar) {
        if (xVar != null && this.a == xVar.a) {
            boolean b = b();
            boolean b2 = xVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(xVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = xVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(xVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = xVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(xVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = xVar.e();
            if ((e || e2) && !(e && e2 && this.e == xVar.e)) {
                return false;
            }
            boolean f = f();
            boolean f2 = xVar.f();
            return !(f || f2) || (f && f2 && this.f.equals(xVar.f));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(x xVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (getClass().equals(xVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(xVar.a()));
            if (compareTo == 0) {
                if (!a() || (a6 = org.apache.thrift.b.a(this.a, xVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(xVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a5 = org.apache.thrift.b.a(this.b, xVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(xVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a4 = org.apache.thrift.b.a(this.c, xVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(xVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a3 = org.apache.thrift.b.a(this.d, xVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(xVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a2 = org.apache.thrift.b.a(this.e, xVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(xVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a = org.apache.thrift.b.a(this.f, xVar.f)) == 0) {
                                                            return 0;
                                                        }
                                                        return a;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a2;
                                            }
                                            return compareTo5;
                                        }
                                        return a3;
                                    }
                                    return compareTo4;
                                }
                                return a4;
                            }
                            return compareTo3;
                        }
                        return a5;
                    }
                    return compareTo2;
                }
                return a6;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(xVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        g();
        eVar.a(g);
        eVar.a(h);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(i);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && c()) {
            eVar.a(j);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && d()) {
            eVar.a(k);
            eVar.a(this.d);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(m);
            eVar.a(this.f);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.n.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.n.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof x)) {
            return a((x) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("userId:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.c == null) {
                sb.append("null");
            } else {
                sb.append(this.c);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
