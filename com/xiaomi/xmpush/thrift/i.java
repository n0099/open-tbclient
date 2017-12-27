package com.xiaomi.xmpush.thrift;

import android.net.http.Headers;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class i implements Serializable, Cloneable, org.apache.thrift.a<i, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> e;
    private static final org.apache.thrift.protocol.j f = new org.apache.thrift.protocol.j("GPS");
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b(Headers.LOCATION, (byte) 12, 1);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("provider", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("period", (byte) 10, 3);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("accuracy", (byte) 4, 4);
    public l a;
    public String b;
    public long c;
    public double d;
    private BitSet k = new BitSet(2);

    /* loaded from: classes2.dex */
    public enum a {
        LOCATION(1, Headers.LOCATION),
        PROVIDER(2, "provider"),
        PERIOD(3, "period"),
        ACCURACY(4, "accuracy");
        
        private static final Map<String, a> e = new HashMap();
        private final short f;
        private final String g;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                e.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public String a() {
            return this.g;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.LOCATION, (a) new org.apache.thrift.meta_data.b(Headers.LOCATION, (byte) 1, new org.apache.thrift.meta_data.g((byte) 12, l.class)));
        enumMap.put((EnumMap) a.PROVIDER, (a) new org.apache.thrift.meta_data.b("provider", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PERIOD, (a) new org.apache.thrift.meta_data.b("period", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.ACCURACY, (a) new org.apache.thrift.meta_data.b("accuracy", (byte) 2, new org.apache.thrift.meta_data.c((byte) 4)));
        e = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(i.class, e);
    }

    public i a(double d) {
        this.d = d;
        b(true);
        return this;
    }

    public i a(long j2) {
        this.c = j2;
        a(true);
        return this;
    }

    public i a(l lVar) {
        this.a = lVar;
        return this;
    }

    public i a(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                e();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = new l();
                        this.a.a(eVar);
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
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.u();
                        a(true);
                        break;
                    }
                case 4:
                    if (i2.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.v();
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
        this.k.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = iVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.a(iVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = iVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(iVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = iVar.c();
        if ((c || c2) && !(c && c2 && this.c == iVar.c)) {
            return false;
        }
        boolean d = d();
        boolean d2 = iVar.d();
        return !(d || d2) || (d && d2 && this.d == iVar.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(i iVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        if (getClass().equals(iVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(iVar.a()));
            if (compareTo == 0) {
                if (!a() || (a5 = org.apache.thrift.b.a(this.a, iVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a4 = org.apache.thrift.b.a(this.b, iVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a3 = org.apache.thrift.b.a(this.c, iVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a2 = org.apache.thrift.b.a(this.d, iVar.d)) == 0) {
                                            return 0;
                                        }
                                        return a2;
                                    }
                                    return compareTo4;
                                }
                                return a3;
                            }
                            return compareTo3;
                        }
                        return a4;
                    }
                    return compareTo2;
                }
                return a5;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(f);
        if (this.a != null) {
            eVar.a(g);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(h);
            eVar.a(this.b);
            eVar.b();
        }
        if (c()) {
            eVar.a(i);
            eVar.a(this.c);
            eVar.b();
        }
        if (d()) {
            eVar.a(j);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.k.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.k.get(0);
    }

    public boolean d() {
        return this.k.get(1);
    }

    public void e() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'location' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            return a((i) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GPS(");
        sb.append("location:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("provider:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        }
        if (c()) {
            sb.append(", ");
            sb.append("period:");
            sb.append(this.c);
        }
        if (d()) {
            sb.append(", ");
            sb.append("accuracy:");
            sb.append(this.d);
        }
        sb.append(")");
        return sb.toString();
    }
}
