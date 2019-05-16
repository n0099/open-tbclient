package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class y implements Serializable, Cloneable, org.apache.thrift.a<y, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("Wifi");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    public String a;
    public int b;
    public String c;
    private BitSet h = new BitSet(1);

    public y a(int i) {
        this.b = i;
        a(true);
        return this;
    }

    public y a(String str) {
        this.a = str;
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
                    throw new org.apache.thrift.protocol.f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
                }
                d();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.w();
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.t();
                        a(true);
                        break;
                    }
                case 3:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.w();
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

    public boolean a() {
        return this.a != null;
    }

    public boolean a(y yVar) {
        if (yVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = yVar.a();
        if (((a || a2) && !(a && a2 && this.a.equals(yVar.a))) || this.b != yVar.b) {
            return false;
        }
        boolean c = c();
        boolean c2 = yVar.c();
        return !(c || c2) || (c && c2 && this.c.equals(yVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(y yVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(yVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(yVar.a()));
            if (compareTo == 0) {
                if (!a() || (a3 = org.apache.thrift.b.a(this.a, yVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(yVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = org.apache.thrift.b.a(this.b, yVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(yVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a = org.apache.thrift.b.a(this.c, yVar.c)) == 0) {
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
        return getClass().getName().compareTo(yVar.getClass().getName());
    }

    public y b(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        d();
        eVar.a(d);
        if (this.a != null) {
            eVar.a(e);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(f);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && c()) {
            eVar.a(g);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.h.get(0);
    }

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'macAddress' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof y)) {
            return a((y) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Wifi(");
        sb.append("macAddress:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(", ");
        sb.append("signalStrength:");
        sb.append(this.b);
        if (c()) {
            sb.append(", ");
            sb.append("ssid:");
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
