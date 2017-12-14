package com.xiaomi.xmpush.thrift;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class af implements Serializable, Cloneable, org.apache.thrift.a<af, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> x;
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public t t;
    public Map<String, String> u;
    public String w;
    private static final org.apache.thrift.protocol.j y = new org.apache.thrift.protocol.j("XmPushActionRegistration");
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("appVersion", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("packageName", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b(Constants.EXTRA_KEY_TOKEN, (byte) 11, 7);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("deviceId", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("sdkVersion", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("regId", (byte) 11, 11);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("pushSdkVersionName", (byte) 11, 12);
    private static final org.apache.thrift.protocol.b L = new org.apache.thrift.protocol.b("pushSdkVersionCode", (byte) 8, 13);
    private static final org.apache.thrift.protocol.b M = new org.apache.thrift.protocol.b("appVersionCode", (byte) 8, 14);
    private static final org.apache.thrift.protocol.b N = new org.apache.thrift.protocol.b("androidId", (byte) 11, 15);
    private static final org.apache.thrift.protocol.b O = new org.apache.thrift.protocol.b("imei", (byte) 11, 16);
    private static final org.apache.thrift.protocol.b P = new org.apache.thrift.protocol.b("serial", (byte) 11, 17);
    private static final org.apache.thrift.protocol.b Q = new org.apache.thrift.protocol.b("imeiMd5", (byte) 11, 18);
    private static final org.apache.thrift.protocol.b R = new org.apache.thrift.protocol.b("spaceId", (byte) 8, 19);
    private static final org.apache.thrift.protocol.b S = new org.apache.thrift.protocol.b("reason", (byte) 8, 20);
    private static final org.apache.thrift.protocol.b T = new org.apache.thrift.protocol.b("connectionAttrs", (byte) 13, 100);
    private static final org.apache.thrift.protocol.b U = new org.apache.thrift.protocol.b("cleanOldRegInfo", (byte) 2, 101);
    private static final org.apache.thrift.protocol.b V = new org.apache.thrift.protocol.b("oldRegId", (byte) 11, 102);
    private BitSet W = new BitSet(4);
    public boolean v = false;

    /* loaded from: classes2.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        APP_VERSION(5, "appVersion"),
        PACKAGE_NAME(6, "packageName"),
        TOKEN(7, Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID(8, "deviceId"),
        ALIAS_NAME(9, "aliasName"),
        SDK_VERSION(10, "sdkVersion"),
        REG_ID(11, "regId"),
        PUSH_SDK_VERSION_NAME(12, "pushSdkVersionName"),
        PUSH_SDK_VERSION_CODE(13, "pushSdkVersionCode"),
        APP_VERSION_CODE(14, "appVersionCode"),
        ANDROID_ID(15, "androidId"),
        IMEI(16, "imei"),
        SERIAL(17, "serial"),
        IMEI_MD5(18, "imeiMd5"),
        SPACE_ID(19, "spaceId"),
        REASON(20, "reason"),
        CONNECTION_ATTRS(100, "connectionAttrs"),
        CLEAN_OLD_REG_INFO(101, "cleanOldRegInfo"),
        OLD_REG_ID(102, "oldRegId");
        
        private static final Map<String, a> x = new HashMap();
        private final short y;
        private final String z;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                x.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.y = s;
            this.z = str;
        }

        public String a() {
            return this.z;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b("target", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_VERSION, (a) new org.apache.thrift.meta_data.b("appVersion", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TOKEN, (a) new org.apache.thrift.meta_data.b(Constants.EXTRA_KEY_TOKEN, (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DEVICE_ID, (a) new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.ALIAS_NAME, (a) new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SDK_VERSION, (a) new org.apache.thrift.meta_data.b("sdkVersion", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REG_ID, (a) new org.apache.thrift.meta_data.b("regId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PUSH_SDK_VERSION_NAME, (a) new org.apache.thrift.meta_data.b("pushSdkVersionName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PUSH_SDK_VERSION_CODE, (a) new org.apache.thrift.meta_data.b("pushSdkVersionCode", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.APP_VERSION_CODE, (a) new org.apache.thrift.meta_data.b("appVersionCode", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.ANDROID_ID, (a) new org.apache.thrift.meta_data.b("androidId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.IMEI, (a) new org.apache.thrift.meta_data.b("imei", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SERIAL, (a) new org.apache.thrift.meta_data.b("serial", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.IMEI_MD5, (a) new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SPACE_ID, (a) new org.apache.thrift.meta_data.b("spaceId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.REASON, (a) new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.a((byte) 16, t.class)));
        enumMap.put((EnumMap) a.CONNECTION_ATTRS, (a) new org.apache.thrift.meta_data.b("connectionAttrs", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.CLEAN_OLD_REG_INFO, (a) new org.apache.thrift.meta_data.b("cleanOldRegInfo", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.OLD_REG_ID, (a) new org.apache.thrift.meta_data.b("oldRegId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        x = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(af.class, x);
    }

    public af a(int i) {
        this.m = i;
        a(true);
        return this;
    }

    public af a(t tVar) {
        this.t = tVar;
        return this;
    }

    public af a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                z();
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
                    if (i.b == 11) {
                        this.h = eVar.w();
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
                    if (i.b == 11) {
                        this.k = eVar.w();
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
                    if (i.b == 8) {
                        this.m = eVar.t();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 14:
                    if (i.b == 8) {
                        this.n = eVar.t();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 15:
                    if (i.b == 11) {
                        this.o = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 16:
                    if (i.b == 11) {
                        this.p = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 17:
                    if (i.b == 11) {
                        this.q = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 18:
                    if (i.b == 11) {
                        this.r = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 19:
                    if (i.b == 8) {
                        this.s = eVar.t();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 20:
                    if (i.b == 8) {
                        this.t = t.a(eVar.t());
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 100:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.u = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.u.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 101:
                    if (i.b == 2) {
                        this.v = eVar.q();
                        d(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 102:
                    if (i.b == 11) {
                        this.w = eVar.w();
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

    public void a(boolean z2) {
        this.W.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(af afVar) {
        if (afVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = afVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(afVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = afVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(afVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = afVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(afVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = afVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(afVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = afVar.f();
        if ((f || f2) && !(f && f2 && this.e.equals(afVar.e))) {
            return false;
        }
        boolean g = g();
        boolean g2 = afVar.g();
        if ((g || g2) && !(g && g2 && this.f.equals(afVar.f))) {
            return false;
        }
        boolean i = i();
        boolean i2 = afVar.i();
        if ((i || i2) && !(i && i2 && this.g.equals(afVar.g))) {
            return false;
        }
        boolean j = j();
        boolean j2 = afVar.j();
        if ((j || j2) && !(j && j2 && this.h.equals(afVar.h))) {
            return false;
        }
        boolean k = k();
        boolean k2 = afVar.k();
        if ((k || k2) && !(k && k2 && this.i.equals(afVar.i))) {
            return false;
        }
        boolean l = l();
        boolean l2 = afVar.l();
        if ((l || l2) && !(l && l2 && this.j.equals(afVar.j))) {
            return false;
        }
        boolean m = m();
        boolean m2 = afVar.m();
        if ((m || m2) && !(m && m2 && this.k.equals(afVar.k))) {
            return false;
        }
        boolean n = n();
        boolean n2 = afVar.n();
        if ((n || n2) && !(n && n2 && this.l.equals(afVar.l))) {
            return false;
        }
        boolean o = o();
        boolean o2 = afVar.o();
        if ((o || o2) && !(o && o2 && this.m == afVar.m)) {
            return false;
        }
        boolean p = p();
        boolean p2 = afVar.p();
        if ((p || p2) && !(p && p2 && this.n == afVar.n)) {
            return false;
        }
        boolean q = q();
        boolean q2 = afVar.q();
        if ((q || q2) && !(q && q2 && this.o.equals(afVar.o))) {
            return false;
        }
        boolean r = r();
        boolean r2 = afVar.r();
        if ((r || r2) && !(r && r2 && this.p.equals(afVar.p))) {
            return false;
        }
        boolean s = s();
        boolean s2 = afVar.s();
        if ((s || s2) && !(s && s2 && this.q.equals(afVar.q))) {
            return false;
        }
        boolean t = t();
        boolean t2 = afVar.t();
        if ((t || t2) && !(t && t2 && this.r.equals(afVar.r))) {
            return false;
        }
        boolean u = u();
        boolean u2 = afVar.u();
        if ((u || u2) && !(u && u2 && this.s == afVar.s)) {
            return false;
        }
        boolean v = v();
        boolean v2 = afVar.v();
        if ((v || v2) && !(v && v2 && this.t.equals(afVar.t))) {
            return false;
        }
        boolean w = w();
        boolean w2 = afVar.w();
        if ((w || w2) && !(w && w2 && this.u.equals(afVar.u))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = afVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.v == afVar.v)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = afVar.y();
        return !(y2 || y3) || (y2 && y3 && this.w.equals(afVar.w));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(af afVar) {
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
        int a22;
        int a23;
        int a24;
        if (getClass().equals(afVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(afVar.a()));
            if (compareTo == 0) {
                if (!a() || (a24 = org.apache.thrift.b.a(this.a, afVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(afVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a23 = org.apache.thrift.b.a(this.b, afVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(afVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a22 = org.apache.thrift.b.a(this.c, afVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(afVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a21 = org.apache.thrift.b.a(this.d, afVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(afVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a20 = org.apache.thrift.b.a(this.e, afVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(afVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a19 = org.apache.thrift.b.a(this.f, afVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(afVar.i()));
                                                            if (compareTo7 == 0) {
                                                                if (!i() || (a18 = org.apache.thrift.b.a(this.g, afVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(afVar.j()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!j() || (a17 = org.apache.thrift.b.a(this.h, afVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(afVar.k()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!k() || (a16 = org.apache.thrift.b.a(this.i, afVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(afVar.l()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!l() || (a15 = org.apache.thrift.b.a(this.j, afVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(afVar.m()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!m() || (a14 = org.apache.thrift.b.a(this.k, afVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(afVar.n()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!n() || (a13 = org.apache.thrift.b.a(this.l, afVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(afVar.o()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!o() || (a12 = org.apache.thrift.b.a(this.m, afVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(afVar.p()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!p() || (a11 = org.apache.thrift.b.a(this.n, afVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(afVar.q()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!q() || (a10 = org.apache.thrift.b.a(this.o, afVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(afVar.r()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!r() || (a9 = org.apache.thrift.b.a(this.p, afVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(afVar.s()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!s() || (a8 = org.apache.thrift.b.a(this.q, afVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(afVar.t()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!t() || (a7 = org.apache.thrift.b.a(this.r, afVar.r)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(afVar.u()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!u() || (a6 = org.apache.thrift.b.a(this.s, afVar.s)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(afVar.v()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!v() || (a5 = org.apache.thrift.b.a(this.t, afVar.t)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(afVar.w()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!w() || (a4 = org.apache.thrift.b.a(this.u, afVar.u)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(afVar.x()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!x() || (a3 = org.apache.thrift.b.a(this.v, afVar.v)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(afVar.y()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!y() || (a2 = org.apache.thrift.b.a(this.w, afVar.w)) == 0) {
                                                                                                                                                                                                    return 0;
                                                                                                                                                                                                }
                                                                                                                                                                                                return a2;
                                                                                                                                                                                            }
                                                                                                                                                                                            return compareTo23;
                                                                                                                                                                                        }
                                                                                                                                                                                        return a3;
                                                                                                                                                                                    }
                                                                                                                                                                                    return compareTo22;
                                                                                                                                                                                }
                                                                                                                                                                                return a4;
                                                                                                                                                                            }
                                                                                                                                                                            return compareTo21;
                                                                                                                                                                        }
                                                                                                                                                                        return a5;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a6;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a7;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a8;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a9;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a10;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a11;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a12;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a13;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a14;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a15;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a16;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a17;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a18;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a19;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a20;
                                            }
                                            return compareTo5;
                                        }
                                        return a21;
                                    }
                                    return compareTo4;
                                }
                                return a22;
                            }
                            return compareTo3;
                        }
                        return a23;
                    }
                    return compareTo2;
                }
                return a24;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(afVar.getClass().getName());
    }

    public af b(int i) {
        this.n = i;
        b(true);
        return this;
    }

    public af b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        z();
        eVar.a(y);
        if (this.a != null && a()) {
            eVar.a(z);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(A);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(B);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(C);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(D);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(E);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(F);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(G);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(H);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(I);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && m()) {
            eVar.a(J);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && n()) {
            eVar.a(K);
            eVar.a(this.l);
            eVar.b();
        }
        if (o()) {
            eVar.a(L);
            eVar.a(this.m);
            eVar.b();
        }
        if (p()) {
            eVar.a(M);
            eVar.a(this.n);
            eVar.b();
        }
        if (this.o != null && q()) {
            eVar.a(N);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && r()) {
            eVar.a(O);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && s()) {
            eVar.a(P);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && t()) {
            eVar.a(Q);
            eVar.a(this.r);
            eVar.b();
        }
        if (u()) {
            eVar.a(R);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && v()) {
            eVar.a(S);
            eVar.a(this.t.a());
            eVar.b();
        }
        if (this.u != null && w()) {
            eVar.a(T);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.u.size()));
            for (Map.Entry<String, String> entry : this.u.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (x()) {
            eVar.a(U);
            eVar.a(this.v);
            eVar.b();
        }
        if (this.w != null && y()) {
            eVar.a(V);
            eVar.a(this.w);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.W.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public af c(int i) {
        this.s = i;
        c(true);
        return this;
    }

    public af c(String str) {
        this.e = str;
        return this;
    }

    public void c(boolean z2) {
        this.W.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public af d(String str) {
        this.f = str;
        return this;
    }

    public String d() {
        return this.d;
    }

    public void d(boolean z2) {
        this.W.set(3, z2);
    }

    public af e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof af)) {
            return a((af) obj);
        }
        return false;
    }

    public af f(String str) {
        this.h = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public af g(String str) {
        this.l = str;
        return this;
    }

    public boolean g() {
        return this.f != null;
    }

    public af h(String str) {
        this.o = str;
        return this;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        return 0;
    }

    public af i(String str) {
        this.p = str;
        return this;
    }

    public boolean i() {
        return this.g != null;
    }

    public af j(String str) {
        this.q = str;
        return this;
    }

    public boolean j() {
        return this.h != null;
    }

    public af k(String str) {
        this.r = str;
        return this;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public boolean m() {
        return this.k != null;
    }

    public boolean n() {
        return this.l != null;
    }

    public boolean o() {
        return this.W.get(0);
    }

    public boolean p() {
        return this.W.get(1);
    }

    public boolean q() {
        return this.o != null;
    }

    public boolean r() {
        return this.p != null;
    }

    public boolean s() {
        return this.q != null;
    }

    public boolean t() {
        return this.r != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
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
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.g == null) {
            sb.append("null");
        } else {
            sb.append(this.g);
        }
        if (j()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.m);
        }
        if (p()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (q()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.o == null) {
                sb.append("null");
            } else {
                sb.append(this.o);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.p == null) {
                sb.append("null");
            } else {
                sb.append(this.p);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.q == null) {
                sb.append("null");
            } else {
                sb.append(this.q);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.r == null) {
                sb.append("null");
            } else {
                sb.append(this.r);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.s);
        }
        if (v()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.t == null) {
                sb.append("null");
            } else {
                sb.append(this.t);
            }
        }
        if (w()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.u == null) {
                sb.append("null");
            } else {
                sb.append(this.u);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.v);
        }
        if (y()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.w == null) {
                sb.append("null");
            } else {
                sb.append(this.w);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.W.get(2);
    }

    public boolean v() {
        return this.t != null;
    }

    public boolean w() {
        return this.u != null;
    }

    public boolean x() {
        return this.W.get(3);
    }

    public boolean y() {
        return this.w != null;
    }

    public void z() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'token' was not present! Struct: " + toString());
        }
    }
}
