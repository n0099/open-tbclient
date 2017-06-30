package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class v implements Serializable, Cloneable, org.apache.thrift.a<v, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> d;
    private static final org.apache.thrift.protocol.j e = new org.apache.thrift.protocol.j("Wifi");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("macAddress", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("signalStrength", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("ssid", (byte) 11, 3);
    public String a;
    public int b;
    public String c;
    private BitSet i = new BitSet(1);

    /* loaded from: classes2.dex */
    public enum a {
        MAC_ADDRESS(1, "macAddress"),
        SIGNAL_STRENGTH(2, "signalStrength"),
        SSID(3, "ssid");
        
        private static final Map<String, a> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                d.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.MAC_ADDRESS, (a) new org.apache.thrift.meta_data.b("macAddress", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SIGNAL_STRENGTH, (a) new org.apache.thrift.meta_data.b("signalStrength", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.SSID, (a) new org.apache.thrift.meta_data.b("ssid", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(v.class, d);
    }

    public v a(int i) {
        this.b = i;
        a(true);
        return this;
    }

    public v a(String str) {
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
        this.i.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(v vVar) {
        if (vVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = vVar.a();
        if (((a2 || a3) && !(a2 && a3 && this.a.equals(vVar.a))) || this.b != vVar.b) {
            return false;
        }
        boolean c = c();
        boolean c2 = vVar.c();
        return !(c || c2) || (c && c2 && this.c.equals(vVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(v vVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(vVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(vVar.a()));
            if (compareTo == 0) {
                if (!a() || (a4 = org.apache.thrift.b.a(this.a, vVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(vVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = org.apache.thrift.b.a(this.b, vVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(vVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = org.apache.thrift.b.a(this.c, vVar.c)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(vVar.getClass().getName());
    }

    public v b(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        d();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(g);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && c()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.i.get(0);
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
        if (obj != null && (obj instanceof v)) {
            return a((v) obj);
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
