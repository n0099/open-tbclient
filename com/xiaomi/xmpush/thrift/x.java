package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class x implements Serializable, Cloneable, org.apache.thrift.a<x, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> l;
    private static final org.apache.thrift.protocol.j m = new org.apache.thrift.protocol.j("XmPushActionAckNotification");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b(AiAppsLifecycleMessage.APP_ID_KEY, (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("request", (byte) 12, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b(AudioStatusCallback.KEY_ERROR_CODE, (byte) 10, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b(WebSocketAction.PARAM_KEY_REASON, (byte) 11, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("extra", (byte) 13, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("packageName", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte) 11, 11);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public ae f;
    public long g;
    public String h;
    public Map<String, String> i;
    public String j;
    public String k;
    private BitSet y = new BitSet(1);

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, AiAppsLifecycleMessage.APP_ID_KEY),
        TYPE(5, "type"),
        REQUEST(6, "request"),
        ERROR_CODE(7, AudioStatusCallback.KEY_ERROR_CODE),
        REASON(8, WebSocketAction.PARAM_KEY_REASON),
        EXTRA(9, "extra"),
        PACKAGE_NAME(10, "packageName"),
        CATEGORY(11, "category");
        
        private static final Map<String, a> l = new HashMap();
        private final short m;
        private final String n;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                l.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.m = s;
            this.n = str;
        }

        public String a() {
            return this.n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b(AiAppsLifecycleMessage.APP_ID_KEY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REQUEST, (a) new org.apache.thrift.meta_data.b("request", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, ae.class)));
        enumMap.put((EnumMap) a.ERROR_CODE, (a) new org.apache.thrift.meta_data.b(AudioStatusCallback.KEY_ERROR_CODE, (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.REASON, (a) new org.apache.thrift.meta_data.b(WebSocketAction.PARAM_KEY_REASON, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.EXTRA, (a) new org.apache.thrift.meta_data.b("extra", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(x.class, l);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!h()) {
                    throw new org.apache.thrift.protocol.f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 12) {
                        this.b = new u();
                        this.b.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 4:
                    if (i.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 11) {
                        this.e = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 12) {
                        this.f = new ae();
                        this.f.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 10) {
                        this.g = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 11) {
                        this.h = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.i = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.i.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 11) {
                        this.j = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 11) {
                        this.k = eVar.w();
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

    public void a(boolean z) {
        this.y.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(x xVar) {
        if (xVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = xVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(xVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = xVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(xVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = xVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(xVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = xVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(xVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = xVar.f();
        if ((f || f2) && !(f && f2 && this.e.equals(xVar.e))) {
            return false;
        }
        boolean g = g();
        boolean g2 = xVar.g();
        if (((g || g2) && !(g && g2 && this.f.a(xVar.f))) || this.g != xVar.g) {
            return false;
        }
        boolean i = i();
        boolean i2 = xVar.i();
        if ((i || i2) && !(i && i2 && this.h.equals(xVar.h))) {
            return false;
        }
        boolean j = j();
        boolean j2 = xVar.j();
        if ((j || j2) && !(j && j2 && this.i.equals(xVar.i))) {
            return false;
        }
        boolean k = k();
        boolean k2 = xVar.k();
        if ((k || k2) && !(k && k2 && this.j.equals(xVar.j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = xVar.l();
        return !(l2 || l3) || (l2 && l3 && this.k.equals(xVar.k));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(x xVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        if (getClass().equals(xVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(xVar.a()));
            if (compareTo == 0) {
                if (!a() || (a12 = org.apache.thrift.b.a(this.a, xVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(xVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a11 = org.apache.thrift.b.a(this.b, xVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(xVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a10 = org.apache.thrift.b.a(this.c, xVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(xVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a9 = org.apache.thrift.b.a(this.d, xVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(xVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a8 = org.apache.thrift.b.a(this.e, xVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(xVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a7 = org.apache.thrift.b.a(this.f, xVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(xVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a6 = org.apache.thrift.b.a(this.g, xVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(xVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a5 = org.apache.thrift.b.a(this.h, xVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(xVar.j()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!j() || (a4 = org.apache.thrift.b.a(this.i, xVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(xVar.k()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!k() || (a3 = org.apache.thrift.b.a(this.j, xVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(xVar.l()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!l() || (a2 = org.apache.thrift.b.a(this.k, xVar.k)) == 0) {
                                                                                                    return 0;
                                                                                                }
                                                                                                return a2;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a3;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a4;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a5;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a6;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a7;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a8;
                                            }
                                            return compareTo5;
                                        }
                                        return a9;
                                    }
                                    return compareTo4;
                                }
                                return a10;
                            }
                            return compareTo3;
                        }
                        return a11;
                    }
                    return compareTo2;
                }
                return a12;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(xVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        m();
        eVar.a(m);
        if (this.a != null && a()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(o);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && e()) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(s);
            this.f.b(eVar);
            eVar.b();
        }
        eVar.a(t);
        eVar.a(this.g);
        eVar.b();
        if (this.h != null && i()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(v);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.i.size()));
            for (Map.Entry<String, String> entry : this.i.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.j != null && k()) {
            eVar.a(w);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && l()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof x)) {
            return a((x) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.y.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public boolean j() {
        return this.i != null;
    }

    public boolean k() {
        return this.j != null;
    }

    public boolean l() {
        return this.k != null;
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (a()) {
            sb.append("debug:");
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
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("type:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.g);
        if (i()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
