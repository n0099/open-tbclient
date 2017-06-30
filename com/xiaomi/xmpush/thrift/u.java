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
public class u implements Serializable, Cloneable, org.apache.thrift.a<u, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> f;
    private static final org.apache.thrift.protocol.j g = new org.apache.thrift.protocol.j("Target");
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("channelId", (byte) 10, 1);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("userId", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("server", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("resource", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("isPreview", (byte) 2, 5);
    public String b;
    private BitSet m = new BitSet(2);
    public long a = 5;
    public String c = "xiaomi.com";
    public String d = "";
    public boolean e = false;

    /* loaded from: classes2.dex */
    public enum a {
        CHANNEL_ID(1, "channelId"),
        USER_ID(2, "userId"),
        SERVER(3, "server"),
        RESOURCE(4, "resource"),
        IS_PREVIEW(5, "isPreview");
        
        private static final Map<String, a> f = new HashMap();
        private final short g;
        private final String h;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                f.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.g = s;
            this.h = str;
        }

        public String a() {
            return this.h;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.CHANNEL_ID, (a) new org.apache.thrift.meta_data.b("channelId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.USER_ID, (a) new org.apache.thrift.meta_data.b("userId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SERVER, (a) new org.apache.thrift.meta_data.b("server", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.RESOURCE, (a) new org.apache.thrift.meta_data.b("resource", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.IS_PREVIEW, (a) new org.apache.thrift.meta_data.b("isPreview", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        f = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(u.class, f);
    }

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
                f();
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
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.m.set(0, z);
    }

    public boolean a() {
        return this.m.get(0);
    }

    public boolean a(u uVar) {
        if (uVar != null && this.a == uVar.a) {
            boolean b = b();
            boolean b2 = uVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(uVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = uVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(uVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = uVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(uVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = uVar.e();
            return !(e || e2) || (e && e2 && this.e == uVar.e);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(u uVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (getClass().equals(uVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(uVar.a()));
            if (compareTo == 0) {
                if (!a() || (a6 = org.apache.thrift.b.a(this.a, uVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(uVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a5 = org.apache.thrift.b.a(this.b, uVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(uVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a4 = org.apache.thrift.b.a(this.c, uVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(uVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a3 = org.apache.thrift.b.a(this.d, uVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(uVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a2 = org.apache.thrift.b.a(this.e, uVar.e)) == 0) {
                                                    return 0;
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
        return getClass().getName().compareTo(uVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        f();
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
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.m.set(1, z);
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
        return this.m.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof u)) {
            return a((u) obj);
        }
        return false;
    }

    public void f() {
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
        sb.append(")");
        return sb.toString();
    }
}
