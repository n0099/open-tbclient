package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.idl.authority.BuildConfig;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class w implements Serializable, Cloneable, org.apache.thrift.a<w, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> u;
    public String a;
    public u b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public aj h;
    public String i;
    public String j;
    public String l;
    public String m;
    public String n;
    public short o;
    public short p;
    public String q;
    public String r;
    public int s;
    public Map<String, String> t;
    private static final org.apache.thrift.protocol.j v = new org.apache.thrift.protocol.j("XmPushActionAckMessage");
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b(BuildConfig.BUILD_TYPE, (byte) 11, 1);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("messageTs", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("topic", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("request", (byte) 12, 8);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b("category", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("isOnline", (byte) 2, 11);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("regId", (byte) 11, 12);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("callbackUrl", (byte) 11, 13);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("userAccount", (byte) 11, 14);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("deviceStatus", (byte) 6, 15);
    private static final org.apache.thrift.protocol.b L = new org.apache.thrift.protocol.b("geoMsgStatus", (byte) 6, 16);
    private static final org.apache.thrift.protocol.b M = new org.apache.thrift.protocol.b("imeiMd5", (byte) 11, 20);
    private static final org.apache.thrift.protocol.b N = new org.apache.thrift.protocol.b("deviceId", (byte) 11, 21);
    private static final org.apache.thrift.protocol.b O = new org.apache.thrift.protocol.b("passThrough", (byte) 8, 22);
    private static final org.apache.thrift.protocol.b P = new org.apache.thrift.protocol.b("extra", (byte) 13, 23);
    private BitSet Q = new BitSet(5);
    public boolean k = false;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, BuildConfig.BUILD_TYPE),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, "appId"),
        MESSAGE_TS(5, "messageTs"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        REQUEST(8, "request"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        IS_ONLINE(11, "isOnline"),
        REG_ID(12, "regId"),
        CALLBACK_URL(13, "callbackUrl"),
        USER_ACCOUNT(14, "userAccount"),
        DEVICE_STATUS(15, "deviceStatus"),
        GEO_MSG_STATUS(16, "geoMsgStatus"),
        IMEI_MD5(20, "imeiMd5"),
        DEVICE_ID(21, "deviceId"),
        PASS_THROUGH(22, "passThrough"),
        EXTRA(23, "extra");
        
        private static final Map<String, a> u = new HashMap();
        private final short v;
        private final String w;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                u.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.v = s;
            this.w = str;
        }

        public String a() {
            return this.w;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b(BuildConfig.BUILD_TYPE, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.MESSAGE_TS, (a) new org.apache.thrift.meta_data.b("messageTs", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.TOPIC, (a) new org.apache.thrift.meta_data.b("topic", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.ALIAS_NAME, (a) new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REQUEST, (a) new org.apache.thrift.meta_data.b("request", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, aj.class)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.IS_ONLINE, (a) new org.apache.thrift.meta_data.b("isOnline", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.REG_ID, (a) new org.apache.thrift.meta_data.b("regId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CALLBACK_URL, (a) new org.apache.thrift.meta_data.b("callbackUrl", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.USER_ACCOUNT, (a) new org.apache.thrift.meta_data.b("userAccount", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DEVICE_STATUS, (a) new org.apache.thrift.meta_data.b("deviceStatus", (byte) 2, new org.apache.thrift.meta_data.c((byte) 6)));
        enumMap.put((EnumMap) a.GEO_MSG_STATUS, (a) new org.apache.thrift.meta_data.b("geoMsgStatus", (byte) 2, new org.apache.thrift.meta_data.c((byte) 6)));
        enumMap.put((EnumMap) a.IMEI_MD5, (a) new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DEVICE_ID, (a) new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PASS_THROUGH, (a) new org.apache.thrift.meta_data.b("passThrough", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.EXTRA, (a) new org.apache.thrift.meta_data.b("extra", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        u = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(w.class, u);
    }

    public w a(long j) {
        this.e = j;
        a(true);
        return this;
    }

    public w a(String str) {
        this.c = str;
        return this;
    }

    public w a(short s) {
        this.o = s;
        c(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!e()) {
                    throw new org.apache.thrift.protocol.f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                u();
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
                    if (i.b == 10) {
                        this.e = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 12) {
                        this.h = new aj();
                        this.h.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 11) {
                        this.i = eVar.w();
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
                    if (i.b == 2) {
                        this.k = eVar.q();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 11) {
                        this.l = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 13:
                    if (i.b == 11) {
                        this.m = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 14:
                    if (i.b == 11) {
                        this.n = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 15:
                    if (i.b == 6) {
                        this.o = eVar.s();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 16:
                    if (i.b == 6) {
                        this.p = eVar.s();
                        d(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 20:
                    if (i.b == 11) {
                        this.q = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 21:
                    if (i.b == 11) {
                        this.r = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 22:
                    if (i.b == 8) {
                        this.s = eVar.t();
                        e(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 23:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.t = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.t.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z2) {
        this.Q.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(w wVar) {
        if (wVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = wVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(wVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = wVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(wVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = wVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(wVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = wVar.d();
        if (((d || d2) && !(d && d2 && this.d.equals(wVar.d))) || this.e != wVar.e) {
            return false;
        }
        boolean f = f();
        boolean f2 = wVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(wVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = wVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(wVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = wVar.h();
        if ((h || h2) && !(h && h2 && this.h.a(wVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = wVar.i();
        if ((i || i2) && !(i && i2 && this.i.equals(wVar.i))) {
            return false;
        }
        boolean j = j();
        boolean j2 = wVar.j();
        if ((j || j2) && !(j && j2 && this.j.equals(wVar.j))) {
            return false;
        }
        boolean k = k();
        boolean k2 = wVar.k();
        if ((k || k2) && !(k && k2 && this.k == wVar.k)) {
            return false;
        }
        boolean l = l();
        boolean l2 = wVar.l();
        if ((l || l2) && !(l && l2 && this.l.equals(wVar.l))) {
            return false;
        }
        boolean m = m();
        boolean m2 = wVar.m();
        if ((m || m2) && !(m && m2 && this.m.equals(wVar.m))) {
            return false;
        }
        boolean n = n();
        boolean n2 = wVar.n();
        if ((n || n2) && !(n && n2 && this.n.equals(wVar.n))) {
            return false;
        }
        boolean o = o();
        boolean o2 = wVar.o();
        if ((o || o2) && !(o && o2 && this.o == wVar.o)) {
            return false;
        }
        boolean p = p();
        boolean p2 = wVar.p();
        if ((p || p2) && !(p && p2 && this.p == wVar.p)) {
            return false;
        }
        boolean q = q();
        boolean q2 = wVar.q();
        if ((q || q2) && !(q && q2 && this.q.equals(wVar.q))) {
            return false;
        }
        boolean r = r();
        boolean r2 = wVar.r();
        if ((r || r2) && !(r && r2 && this.r.equals(wVar.r))) {
            return false;
        }
        boolean s = s();
        boolean s2 = wVar.s();
        if ((s || s2) && !(s && s2 && this.s == wVar.s)) {
            return false;
        }
        boolean t = t();
        boolean t2 = wVar.t();
        return !(t || t2) || (t && t2 && this.t.equals(wVar.t));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(w wVar) {
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
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        if (getClass().equals(wVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(wVar.a()));
            if (compareTo == 0) {
                if (!a() || (a21 = org.apache.thrift.b.a(this.a, wVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(wVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a20 = org.apache.thrift.b.a(this.b, wVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(wVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a19 = org.apache.thrift.b.a(this.c, wVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(wVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a18 = org.apache.thrift.b.a(this.d, wVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(wVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a17 = org.apache.thrift.b.a(this.e, wVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(wVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a16 = org.apache.thrift.b.a(this.f, wVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(wVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a15 = org.apache.thrift.b.a(this.g, wVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(wVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a14 = org.apache.thrift.b.a(this.h, wVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(wVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a13 = org.apache.thrift.b.a(this.i, wVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(wVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a12 = org.apache.thrift.b.a(this.j, wVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(wVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a11 = org.apache.thrift.b.a(this.k, wVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(wVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a10 = org.apache.thrift.b.a(this.l, wVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(wVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a9 = org.apache.thrift.b.a(this.m, wVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(wVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a8 = org.apache.thrift.b.a(this.n, wVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(wVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a7 = org.apache.thrift.b.a(this.o, wVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(wVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a6 = org.apache.thrift.b.a(this.p, wVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(wVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a5 = org.apache.thrift.b.a(this.q, wVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(wVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a4 = org.apache.thrift.b.a(this.r, wVar.r)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(wVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a3 = org.apache.thrift.b.a(this.s, wVar.s)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(wVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a2 = org.apache.thrift.b.a(this.t, wVar.t)) == 0) {
                                                                                                                                                                            return 0;
                                                                                                                                                                        }
                                                                                                                                                                        return a2;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a3;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a4;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a5;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a6;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a7;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a8;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a9;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a10;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a11;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a12;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a13;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a14;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a15;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a16;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a17;
                                            }
                                            return compareTo5;
                                        }
                                        return a18;
                                    }
                                    return compareTo4;
                                }
                                return a19;
                            }
                            return compareTo3;
                        }
                        return a20;
                    }
                    return compareTo2;
                }
                return a21;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(wVar.getClass().getName());
    }

    public w b(String str) {
        this.d = str;
        return this;
    }

    public w b(short s) {
        this.p = s;
        d(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(v);
        if (this.a != null && a()) {
            eVar.a(w);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(x);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(y);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(z);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(A);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && f()) {
            eVar.a(B);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(C);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(D);
            this.h.b(eVar);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(E);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(F);
            eVar.a(this.j);
            eVar.b();
        }
        if (k()) {
            eVar.a(G);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && l()) {
            eVar.a(H);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && m()) {
            eVar.a(I);
            eVar.a(this.m);
            eVar.b();
        }
        if (this.n != null && n()) {
            eVar.a(J);
            eVar.a(this.n);
            eVar.b();
        }
        if (o()) {
            eVar.a(K);
            eVar.a(this.o);
            eVar.b();
        }
        if (p()) {
            eVar.a(L);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && q()) {
            eVar.a(M);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && r()) {
            eVar.a(N);
            eVar.a(this.r);
            eVar.b();
        }
        if (s()) {
            eVar.a(O);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && t()) {
            eVar.a(P);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.t.size()));
            for (Map.Entry<String, String> entry : this.t.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.Q.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public w c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z2) {
        this.Q.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public w d(String str) {
        this.g = str;
        return this;
    }

    public void d(boolean z2) {
        this.Q.set(3, z2);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z2) {
        this.Q.set(4, z2);
    }

    public boolean e() {
        return this.Q.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof w)) {
            return a((w) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public boolean k() {
        return this.Q.get(1);
    }

    public boolean l() {
        return this.l != null;
    }

    public boolean m() {
        return this.m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.Q.get(2);
    }

    public boolean p() {
        return this.Q.get(3);
    }

    public boolean q() {
        return this.q != null;
    }

    public boolean r() {
        return this.r != null;
    }

    public boolean s() {
        return this.Q.get(4);
    }

    public boolean t() {
        return this.t != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z3 = true;
        if (a()) {
            sb.append("debug:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z3 = false;
        }
        if (b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.e);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.m == null) {
                sb.append("null");
            } else {
                sb.append(this.m);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.n == null) {
                sb.append("null");
            } else {
                sb.append(this.n);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.p);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.q == null) {
                sb.append("null");
            } else {
                sb.append(this.q);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.r == null) {
                sb.append("null");
            } else {
                sb.append(this.r);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.s);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.t == null) {
                sb.append("null");
            } else {
                sb.append(this.t);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
