package com.xiaomi.xmpush.thrift;

import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ad implements Serializable, Cloneable, org.apache.thrift.a<ad, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> d;
    private static final org.apache.thrift.protocol.j e = new org.apache.thrift.protocol.j("XmPushActionNormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("normalConfigs", (byte) 15, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b(AiAppsLifecycleMessage.APP_ID_KEY, (byte) 10, 4);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("packageName", (byte) 11, 5);
    public List<n> a;
    public long b;
    public String c;
    private BitSet i = new BitSet(1);

    /* loaded from: classes3.dex */
    public enum a {
        NORMAL_CONFIGS(1, "normalConfigs"),
        APP_ID(4, AiAppsLifecycleMessage.APP_ID_KEY),
        PACKAGE_NAME(5, "packageName");
        
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
        enumMap.put((EnumMap) a.NORMAL_CONFIGS, (a) new org.apache.thrift.meta_data.b("normalConfigs", (byte) 1, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, n.class))));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b(AiAppsLifecycleMessage.APP_ID_KEY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ad.class, d);
    }

    public List<n> a() {
        return this.a;
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
                            n nVar = new n();
                            nVar.a(eVar);
                            this.a.add(nVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                case 3:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 4:
                    if (i.b == 10) {
                        this.b = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = adVar.b();
        if ((b || b2) && !(b && b2 && this.a.equals(adVar.a))) {
            return false;
        }
        boolean c = c();
        boolean c2 = adVar.c();
        if ((c || c2) && !(c && c2 && this.b == adVar.b)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = adVar.d();
        return !(d2 || d3) || (d2 && d3 && this.c.equals(adVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ad adVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(adVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(adVar.b()));
            if (compareTo == 0) {
                if (!b() || (a4 = org.apache.thrift.b.a(this.a, adVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(adVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a3 = org.apache.thrift.b.a(this.b, adVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(adVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a2 = org.apache.thrift.b.a(this.c, adVar.c)) == 0) {
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
        return getClass().getName().compareTo(adVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (n nVar : this.a) {
                nVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (c()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && d()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        return this.i.get(0);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ad)) {
            return a((ad) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("appId:");
            sb.append(this.b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("packageName:");
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
