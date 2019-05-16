package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class af implements Serializable, Cloneable, org.apache.thrift.a<af, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j i = new org.apache.thrift.protocol.j("XmPushActionContainer");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("", (byte) 2, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 12, 7);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 12, 8);
    public a a;
    public ByteBuffer d;
    public String e;
    public String f;
    public x g;
    public u h;
    private BitSet r = new BitSet(2);
    public boolean b = true;
    public boolean c = true;

    public a a() {
        return this.a;
    }

    public af a(a aVar) {
        this.a = aVar;
        return this;
    }

    public af a(u uVar) {
        this.h = uVar;
        return this;
    }

    public af a(x xVar) {
        this.g = xVar;
        return this;
    }

    public af a(String str) {
        this.e = str;
        return this;
    }

    public af a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public af a(boolean z) {
        this.b = z;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                if (!d()) {
                    throw new org.apache.thrift.protocol.f("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!e()) {
                    throw new org.apache.thrift.protocol.f("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                o();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = a.a(eVar.t());
                        break;
                    }
                case 2:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.q();
                        b(true);
                        break;
                    }
                case 3:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.q();
                        d(true);
                        break;
                    }
                case 4:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.x();
                        break;
                    }
                case 5:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.w();
                        break;
                    }
                case 6:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
                case 7:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = new x();
                        this.g.a(eVar);
                        break;
                    }
                case 8:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.h = new u();
                        this.h.a(eVar);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public boolean a(af afVar) {
        if (afVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = afVar.b();
        if (((!b && !b2) || (b && b2 && this.a.equals(afVar.a))) && this.b == afVar.b && this.c == afVar.c) {
            boolean g = g();
            boolean g2 = afVar.g();
            if ((g || g2) && !(g && g2 && this.d.equals(afVar.d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = afVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.e.equals(afVar.e))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = afVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f.equals(afVar.f))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = afVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.g.a(afVar.g))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = afVar.n();
            return !(n2 || n3) || (n2 && n3 && this.h.a(afVar.h));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(af afVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(afVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(afVar.b()));
            if (compareTo == 0) {
                if (!b() || (a8 = org.apache.thrift.b.a(this.a, afVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(afVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a7 = org.apache.thrift.b.a(this.b, afVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(afVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a6 = org.apache.thrift.b.a(this.c, afVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(afVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a5 = org.apache.thrift.b.a(this.d, afVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(afVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a4 = org.apache.thrift.b.a(this.e, afVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(afVar.k()));
                                                    if (compareTo6 == 0) {
                                                        if (!k() || (a3 = org.apache.thrift.b.a(this.f, afVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(afVar.l()));
                                                            if (compareTo7 == 0) {
                                                                if (!l() || (a2 = org.apache.thrift.b.a(this.g, afVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(afVar.n()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!n() || (a = org.apache.thrift.b.a(this.h, afVar.h)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(afVar.getClass().getName());
    }

    public af b(String str) {
        this.f = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        o();
        eVar.a(i);
        if (this.a != null) {
            eVar.a(j);
            eVar.a(this.a.a());
            eVar.b();
        }
        eVar.a(k);
        eVar.a(this.b);
        eVar.b();
        eVar.a(l);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && i()) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(p);
            this.g.b(eVar);
            eVar.b();
        }
        if (this.h != null && n()) {
            eVar.a(q);
            this.h.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.r.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public af c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public void d(boolean z) {
        this.r.set(1, z);
    }

    public boolean d() {
        return this.r.get(0);
    }

    public boolean e() {
        return this.r.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof af)) {
            return a((af) obj);
        }
        return false;
    }

    public byte[] f() {
        a(org.apache.thrift.b.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public u m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.d == null) {
            sb.append("null");
        } else {
            org.apache.thrift.b.a(this.d, sb);
        }
        if (i()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.g == null) {
            sb.append("null");
        } else {
            sb.append(this.g);
        }
        if (n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
