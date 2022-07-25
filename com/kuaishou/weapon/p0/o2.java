package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    public o2(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = i;
    }

    public String a(String str) {
        InterceptResult invokeL;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject a2 = new n2(str, l2.j).a(this.a);
                if (a2 == null || (a = a()) == null) {
                    return null;
                }
                a2.put("module_section", a);
                return a2.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v2 double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v3 double)] */
    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public JSONObject a() {
        InterceptResult invokeV;
        long j;
        i iVar;
        boolean z;
        boolean z2;
        String str;
        String str2;
        o2 o2Var;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                i a2 = i.a(this.a, "re_po_rt");
                boolean b = a2.b("a1_p_s_p_s");
                boolean b2 = a2.b("a1_p_s_p_s_c_b");
                if (a2.a(f3.I0, 1) == 1 && (b || b2)) {
                    String j2 = h1.j(this.a);
                    if (!TextUtils.isEmpty(j2) && !j2.startsWith("RISK")) {
                        jSONObject.put("01001", j2);
                    }
                    String p = h1.p(this.a);
                    if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                        jSONObject.put("01003", p);
                    }
                    String b3 = h1.b(this.a, 0);
                    if (!TextUtils.isEmpty(b3) && !b3.startsWith("RISK")) {
                        jSONObject.put("01019", b3);
                    }
                    String b4 = h1.b(this.a, 1);
                    if (!TextUtils.isEmpty(b4) && !b4.startsWith("RISK")) {
                        jSONObject.put("01004", b4);
                    }
                }
                if (a2.a(f3.J0, 1) == 1 && (b || b2)) {
                    String r = h1.r(this.a);
                    if (!TextUtils.isEmpty(r) && !r.startsWith("RISK")) {
                        jSONObject.put("01007", r);
                    }
                }
                if (a2.a(f3.K0, 1) == 1 && (b || b2)) {
                    jSONObject.put("01011", h1.o(this.a));
                }
                if (a2.a(f3.L0, 1) == 1 && (b || b2)) {
                    String g = h1.g(this.a);
                    if (!TextUtils.isEmpty(g) && !g.startsWith("RISK")) {
                        jSONObject.put("01016", g);
                    }
                }
                try {
                    if (a2.a(f3.z0, 1) == 1) {
                        if (b || b2) {
                            String c = h1.c(this.a);
                            if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                                jSONObject.put("01013", c);
                            }
                            jSONObject.put("02042", h1.a(this.a));
                            jSONObject.put("02024", g2.b(this.a));
                            jSONObject.put("02066", g2.c(this.a));
                        }
                        jSONObject.put("02054", h1.A(this.a));
                        j = currentTimeMillis;
                        str = "RISK";
                        z2 = b2;
                        z = b;
                        try {
                            if (Engine.loadSuccess) {
                                try {
                                    jSONObject.put("02019", l1.i(this.a));
                                    jSONObject.put("02021", l1.e(this.a));
                                    jSONObject.put("02022", l1.h(this.a));
                                    jSONObject.put("02030", l1.b(this.a));
                                    e2 e2Var = new e2(this.a);
                                    try {
                                        jSONObject.put("01014", e2Var.a("01014") != null ? e2Var.a("01014") : "");
                                        jSONObject.put("02001", e2Var.a("02001") != null ? e2Var.a("02001") : l1.u());
                                        jSONObject.put("02002", e2Var.a("02002") != null ? e2Var.a("02002") : l1.h());
                                        jSONObject.put("02003", e2Var.a("02003") != null ? e2Var.a("02003") : l1.v());
                                        jSONObject.put("02004", e2Var.a("02004") != null ? e2Var.a("02004") : l1.p());
                                        jSONObject.put("02005", e2Var.a("02005") != null ? e2Var.a("02005") : l1.y());
                                        jSONObject.put("02006", e2Var.a("02006") != null ? e2Var.a("02006") : l1.l());
                                        jSONObject.put("02007", e2Var.a("02007") != null ? e2Var.a("02007") : l1.f());
                                        jSONObject.put("02008", e2Var.a("02008") != null ? e2Var.a("02008") : l1.r());
                                        jSONObject.put("02009", e2Var.a("02009") != null ? e2Var.a("02009") : l1.J());
                                        jSONObject.put("02010", e2Var.a("02010") != null ? e2Var.a("02010") : l1.I());
                                        jSONObject.put("02011", e2Var.a("02011") != null ? e2Var.a("02011") : l1.G());
                                        jSONObject.put("02012", e2Var.a("02012") != null ? e2Var.a("02012") : l1.g());
                                        jSONObject.put("02013", e2Var.a("02013") != null ? e2Var.a("02013") : l1.i());
                                        jSONObject.put("02014", e2Var.a("02014") != null ? e2Var.a("02014") : l1.m());
                                        jSONObject.put("02015", e2Var.a("02015") != null ? e2Var.a("02015") : l1.t());
                                        jSONObject.put("02016", e2Var.a("02016") != null ? e2Var.a("02016") : l1.L());
                                        jSONObject.put("02017", e2Var.a("02017") != null ? e2Var.a("02017") : Integer.valueOf(l1.a()));
                                        jSONObject.put("02018", e2Var.a("02018") != null ? e2Var.a("02018") : l1.n());
                                        jSONObject.put("02020", e2Var.a("02020") != null ? e2Var.a("02020") : l1.K());
                                        if (e2Var.a("02023") != null) {
                                            a = e2Var.a("02023");
                                            o2Var = this;
                                        } else {
                                            o2Var = this;
                                            try {
                                                a = g2.a(o2Var.a);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        jSONObject.put("02023", a);
                                        jSONObject.put("02031", e2Var.a("02031") != null ? e2Var.a("02031") : l1.w());
                                        jSONObject.put("02032", e2Var.a("02032") != null ? e2Var.a("02032") : l1.j());
                                        jSONObject.put("02033", e2Var.a("02033") != null ? e2Var.a("02033") : l1.s());
                                        jSONObject.put("02034", e2Var.a("02034") != null ? e2Var.a("02034") : l1.q());
                                        jSONObject.put("02035", e2Var.a("02035") != null ? e2Var.a("02035") : l1.d());
                                        jSONObject.put("02036", e2Var.a("02036") != null ? e2Var.a("02036") : "");
                                        jSONObject.put("02037", e2Var.a("02037") != null ? e2Var.a("02037") : l1.k());
                                        jSONObject.put("02038", e2Var.a("02038") != null ? e2Var.a("02038") : l1.z());
                                        jSONObject.put("02045", e2Var.a("02045") != null ? e2Var.a("02045") : l1.e());
                                    } catch (Exception unused2) {
                                        o2Var = this;
                                    }
                                } catch (Exception unused3) {
                                    o2Var = this;
                                }
                            } else {
                                jSONObject.put("02001", l1.u());
                                jSONObject.put("02002", l1.h());
                                jSONObject.put("02003", l1.v());
                                jSONObject.put("02004", l1.p());
                                jSONObject.put("02005", l1.y());
                                jSONObject.put("02006", l1.l());
                                jSONObject.put("02007", l1.f());
                                jSONObject.put("02008", l1.r());
                                jSONObject.put("02009", l1.J());
                                jSONObject.put("02010", l1.I());
                                jSONObject.put("02011", l1.G());
                                jSONObject.put("02012", l1.g());
                                jSONObject.put("02013", l1.i());
                                jSONObject.put("02014", l1.m());
                                jSONObject.put("02015", l1.t());
                                jSONObject.put("02016", l1.L());
                                jSONObject.put("02017", l1.a());
                                jSONObject.put("02018", l1.n());
                                o2Var = this;
                                jSONObject.put("02019", l1.i(o2Var.a));
                                jSONObject.put("02020", l1.K());
                                jSONObject.put("02021", l1.e(o2Var.a));
                                jSONObject.put("02022", l1.h(o2Var.a));
                                jSONObject.put("02023", g2.a(o2Var.a));
                                jSONObject.put("02030", l1.b(o2Var.a));
                                jSONObject.put("02031", l1.w());
                                jSONObject.put("02032", l1.j());
                                jSONObject.put("02033", l1.s());
                                jSONObject.put("02034", l1.q());
                                jSONObject.put("02035", l1.d());
                                jSONObject.put("02037", l1.k());
                                jSONObject.put("02038", l1.z());
                                jSONObject.put("02045", l1.e());
                            }
                            str2 = "";
                            jSONObject.put("02067", o2Var.a.getApplicationContext().getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                            jSONObject.put("02039", h1.b());
                            jSONObject.put("02040", h1.c());
                            jSONObject.put("02041", h1.x(o2Var.a));
                            jSONObject.put("02044", l1.F());
                            jSONObject.put("02046", l1.x());
                            String a3 = h1.a("persist.service.adb.enable");
                            if (!TextUtils.isEmpty(a3)) {
                                jSONObject.put("03058", a3);
                            }
                            String a4 = h1.a("sys.resettype");
                            if (!TextUtils.isEmpty(a4)) {
                                jSONObject.put("03057", a4);
                            }
                            String a5 = h1.a("ro.boot.bootreason");
                            if (!TextUtils.isEmpty(a5)) {
                                jSONObject.put("03056", a5);
                            }
                            String a6 = h1.a("ro.runtime.firstboot");
                            if (!TextUtils.isEmpty(a6)) {
                                jSONObject.put("03055", a6);
                            }
                            String a7 = h1.a("init.svc.atcmdserver");
                            if (!TextUtils.isEmpty(a7)) {
                                jSONObject.put("03054", a7);
                            }
                            String a8 = h1.a("ro.build.date.utc");
                            if (!TextUtils.isEmpty(a8)) {
                                jSONObject.put("03061", a8);
                            }
                            String a9 = h1.a("ro.bootimage.build.date.utc");
                            if (!TextUtils.isEmpty(a9)) {
                                jSONObject.put("03062", a9);
                            }
                            String a10 = h1.a("ro.build.date.YmdHM");
                            if (!TextUtils.isEmpty(a10)) {
                                jSONObject.put("03063", a10);
                            }
                            String a11 = h1.a("dhcp.ipv6.wlan0.dns1");
                            if (!TextUtils.isEmpty(a11)) {
                                jSONObject.put("03067", a11);
                            }
                            String a12 = h1.a("dhcp.ipv6.wlan0.dns2");
                            if (!TextUtils.isEmpty(a12)) {
                                jSONObject.put("03068", a12);
                            }
                            String a13 = h1.a("dhcp.wlan0.dns1");
                            if (!TextUtils.isEmpty(a13)) {
                                jSONObject.put("03069", a13);
                            }
                            String a14 = h1.a("dhcp.wlan0.dns2");
                            if (!TextUtils.isEmpty(a14)) {
                                jSONObject.put("03070", a14);
                            }
                            String a15 = h1.a("net.change");
                            if (!TextUtils.isEmpty(a15)) {
                                jSONObject.put("03071", a15);
                            }
                            String a16 = h1.a("net.dns1");
                            if (!TextUtils.isEmpty(a16)) {
                                jSONObject.put("03072", a16);
                            }
                            String a17 = h1.a("net.dns2");
                            if (!TextUtils.isEmpty(a17)) {
                                jSONObject.put("03073", a17);
                            }
                            iVar = a2;
                            long a18 = iVar.a(f3.f, -1L);
                            if (a18 != -1) {
                                jSONObject.put("03074", a18 + System.currentTimeMillis());
                            }
                            try {
                                jSONObject.put("03064", Settings.System.getInt(o2Var.a.getContentResolver(), "screen_brightness_mode"));
                                jSONObject.put("03065", Settings.System.getInt(o2Var.a.getContentResolver(), "accelerometer_rotation"));
                            } catch (Throwable unused4) {
                            }
                            jSONObject.put("03081", l1.A());
                            jSONObject.put("03053", h1.w(o2Var.a));
                            jSONObject.put("03052", l1.j(o2Var.a));
                            jSONObject.put("03050", l1.f(o2Var.a));
                            jSONObject.put("03049", l1.g(o2Var.a));
                            jSONObject.put("02027", l1.B());
                            jSONObject.put("02028", l1.H());
                            jSONObject.put("02029", l1.c());
                            jSONObject.put("02057", l1.D());
                            jSONObject.put("02058", l1.C());
                        } catch (Throwable unused5) {
                            return null;
                        }
                    } else {
                        j = currentTimeMillis;
                        iVar = a2;
                        z = b;
                        z2 = b2;
                        str = "RISK";
                        str2 = "";
                        o2Var = this;
                    }
                    if (iVar.a(f3.A0, 1) == 1) {
                        jSONObject.put("03001", o1.a());
                        jSONObject.put("03002", o1.b());
                        jSONObject.put("03001", o1.a());
                        jSONObject.put("03043", SystemClock.elapsedRealtime());
                        jSONObject.put("03044", SystemClock.uptimeMillis());
                        jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                        y1 y1Var = new y1(o2Var.a);
                        if (Engine.loadSuccess) {
                            jSONObject.put("03004", y1Var.b("03004") != null ? y1Var.b("03004") : str2);
                            jSONObject.put("03036", y1Var.a("03036") != null ? y1Var.a("03036") : str2);
                            jSONObject.put("03039", y1Var.b("03039") != null ? y1Var.b("03039") : str2);
                            jSONObject.put("03040", y1Var.b("03040") != null ? y1Var.b("03040") : str2);
                            jSONObject.put("03041", y1Var.b("03041") != null ? y1Var.b("03041") : str2);
                            jSONObject.put("03042", y1Var.b("03042") != null ? y1Var.b("03042") : str2);
                            jSONObject.put("03079", y1Var.b("03079") != null ? y1Var.b("03079") : null);
                            jSONObject.put("03080", y1Var.b("03080") != null ? y1Var.b("03080") : null);
                        }
                        jSONObject.put("03007", v1.c(o2Var.a));
                        jSONObject.put("03008", v1.b(o2Var.a));
                        jSONObject.put("03011", n0.a(o2Var.a));
                        jSONObject.put("03012", n0.a());
                        jSONObject.put("03014", h1.B(o2Var.a));
                        jSONObject.put("03034", h1.C(o2Var.a));
                        jSONObject.put("03020", v1.a(o2Var.a));
                        jSONObject.put("03037", l1.b());
                        jSONObject.put("03038", l1.E());
                        jSONObject.put("03077", l1.o());
                    }
                    try {
                        g1 g1Var = new g1();
                        jSONObject.put("03006", g1Var.b(o2Var.a));
                        jSONObject.put("03010", g1Var.d(o2Var.a));
                        jSONObject.put("03033", g1Var.e(o2Var.a));
                        jSONObject.put("03013", g1Var.b());
                        jSONObject.put("03021", g1Var.a(o2Var.a));
                        jSONObject.put("03030", g1.f(o2Var.a));
                        jSONObject.put("10020", g1Var.c(o2Var.a));
                        jSONObject.put("10031", g1Var.a());
                    } catch (Exception unused6) {
                    }
                    if (iVar.a(f3.O0, 1) == 1) {
                        jSONObject.put("03019", h1.i(o2Var.a));
                        String t = h1.t(o2Var.a);
                        if (!TextUtils.isEmpty(t)) {
                            jSONObject.put("03046", t);
                        }
                        String k = h1.k(o2Var.a);
                        if (!TextUtils.isEmpty(k)) {
                            jSONObject.put("03047", k);
                        }
                        jSONObject.put("03018", h1.b(o2Var.a));
                    }
                    if (iVar.a(f3.P0, 1) == 1) {
                        jSONObject.put("02059", m1.a(o2Var.a));
                        jSONObject.put("02060", m1.d());
                        jSONObject.put("02061", m1.c());
                        jSONObject.put("02062", m1.b());
                        if (Engine.loadSuccess) {
                            a2 a2Var = new a2(o2Var.a);
                            jSONObject.put("08001", a2Var.a("08001") != null ? a2Var.a("08001") : str2);
                        }
                        JSONObject a19 = m1.a();
                        if (a19 != null && a19.length() > 0) {
                            jSONObject.put("10050", a19);
                        }
                    }
                    if (iVar.a(f3.N0, 1) == 1 && (z || z2)) {
                        jSONObject.put("03029", h1.s(o2Var.a));
                    }
                    if (iVar.a(f3.B0, 1) == 1) {
                        if (Engine.loadSuccess) {
                            z1 z1Var = new z1(o2Var.a);
                            jSONObject.put("04001", z1Var.a("04001") != null ? z1Var.a("04001") : str2);
                            jSONObject.put("04002", z1Var.a("04002") != null ? z1Var.a("04002") : str2);
                            jSONObject.put("04003", z1Var.a("04003") != null ? z1Var.a("04003") : str2);
                            jSONObject.put("04004", z1Var.a("04004") != null ? z1Var.a("04004") : str2);
                        } else {
                            try {
                                j1 b5 = k1.b();
                                jSONObject.put("04001", k1.a());
                                jSONObject.put("04002", b5.c());
                                jSONObject.put("04003", b5.a());
                                jSONObject.put("04004", b5.b());
                            } catch (Exception unused7) {
                            }
                        }
                    }
                    if (iVar.a(f3.E0, 0) == 1 && (z || z2)) {
                        JSONArray l = h1.l();
                        if (l != null) {
                            jSONObject.put("06014", l);
                        }
                        if (Engine.loadSuccess) {
                            f2 f2Var = new f2(o2Var.a);
                            jSONObject.put("06015", f2Var.a("06015") != null ? f2Var.a("06015") : str2);
                        }
                    }
                    if (z || z2) {
                        String g2 = h1.g();
                        if ((TextUtils.isEmpty(g2) || g2.startsWith(str)) && g2 == null) {
                            jSONObject.put("07005", str2);
                        } else {
                            jSONObject.put("07005", g2);
                        }
                    }
                    if (iVar.a(f3.C0, 0) == 1 && (z || z2)) {
                        if (Engine.loadSuccess) {
                            jSONObject.put("07007", new c2(o2Var.a).a("07007"));
                        }
                        JSONArray a20 = r1.a(o2Var.a);
                        if (a20 != null && a20.length() > 0) {
                            jSONObject.put("03035", a20);
                        }
                    }
                    if (z || z2) {
                        try {
                            double e = h1.e();
                            if (e > 0.0d) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(e);
                                jSONObject.put("09002", sb.toString());
                            }
                            double f = h1.f();
                            if (f > 0.0d) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(f);
                                jSONObject.put("09003", sb2.toString());
                            }
                            jSONObject.put("09001", h1.j());
                        } catch (Exception unused8) {
                        }
                    }
                    if (iVar.a(f3.G0, 1) == 1 && (z || z2)) {
                        jSONObject.put("10002", new x(o2Var.a).d(1));
                    }
                    if (iVar.a(f3.D0, 1) == 1 && Engine.loadSuccess) {
                        String a21 = new d2(o2Var.a).a("05001");
                        try {
                            if (!TextUtils.isEmpty(a21) && a21.length() > 10) {
                                jSONObject.put("05001", new JSONArray(a21));
                            }
                        } catch (Exception unused9) {
                        }
                    }
                    if (Engine.loadSuccess) {
                        b2 b2Var = new b2(o2Var.a);
                        jSONObject.put("13001", b2Var.a("13001") != null ? b2Var.a("13001") : str2);
                    }
                    jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                    jSONObject.put("11002", Engine.soVersion);
                    jSONObject.put("11003", i1.t);
                    jSONObject.put("11004", Engine.loadSoCount);
                    jSONObject.put("11006", z ? 1 : 0);
                    jSONObject.put("11029", z2 ? 1 : 0);
                    jSONObject.put("11008", iVar.a(f3.i, q1.e));
                    jSONObject.put("11009", s1.b(o2Var.a.getApplicationContext()));
                    try {
                        String v = h1.v(o2Var.a);
                        if (!TextUtils.isEmpty(v)) {
                            jSONObject.put("01026", v);
                        }
                        if (iVar.a(f3.F0, 1) == 1) {
                            String xb = com.kwad.sdk.c.b.xm().xb();
                            if (!TextUtils.isEmpty(xb)) {
                                jSONObject.put("11102", xb);
                            }
                            jSONObject.put("11104", com.kwad.sdk.c.b.xm().xi());
                            jSONObject.put("11105", com.kwad.sdk.c.b.xm().getDeviceId());
                            jSONObject.put("11106", com.kwad.sdk.c.b.xm().getIccId());
                            jSONObject.put("11107", com.kwad.sdk.c.b.xm().xa());
                            jSONObject.put("11108", com.kwad.sdk.c.b.xm().xd());
                            jSONObject.put("11109", com.kwad.sdk.c.b.xm().xe());
                            jSONObject.put("11110", com.kwad.sdk.c.b.xm().xf());
                            jSONObject.put("11111", com.kwad.sdk.c.b.xm().getIp());
                            jSONObject.put("11112", com.kwad.sdk.c.b.xm().getLocation());
                            jSONObject.put("11113", com.kwad.sdk.c.b.xm().getOaid());
                            jSONObject.put("11114", com.kwad.sdk.c.b.xm().xc());
                            jSONObject.put("11115", com.kwad.sdk.c.b.xm().xh());
                            jSONObject.put("11116", com.kwad.sdk.c.b.xm().xg());
                            jSONObject.put("11202", h1.b(com.kwad.sdk.c.b.xm().xb()));
                            jSONObject.put("11203", h1.b(com.kwad.sdk.c.b.xm().xk()));
                            jSONObject.put("11204", h1.b(com.kwad.sdk.c.b.xm().xi()));
                            jSONObject.put("11205", h1.b(com.kwad.sdk.c.b.xm().getDeviceId()));
                            jSONObject.put("11206", h1.b(com.kwad.sdk.c.b.xm().getIccId()));
                            jSONObject.put("11207", h1.b(com.kwad.sdk.c.b.xm().xa()));
                            jSONObject.put("11208", h1.b(com.kwad.sdk.c.b.xm().xd()));
                            jSONObject.put("11209", h1.b(com.kwad.sdk.c.b.xm().xe()));
                            jSONObject.put("11210", h1.b(com.kwad.sdk.c.b.xm().xf()));
                            jSONObject.put("11211", h1.b(com.kwad.sdk.c.b.xm().getIp()));
                            jSONObject.put("11212", h1.b(com.kwad.sdk.c.b.xm().getLocation()));
                            jSONObject.put("11213", h1.b(com.kwad.sdk.c.b.xm().getOaid()));
                            jSONObject.put("11214", h1.b(com.kwad.sdk.c.b.xm().xc()));
                            jSONObject.put("11215", h1.b(com.kwad.sdk.c.b.xm().xh()));
                            jSONObject.put("11216", h1.b(com.kwad.sdk.c.b.xm().xg()));
                            jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                            jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                            jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                        }
                    } catch (Throwable unused10) {
                    }
                    try {
                        jSONObject.put("02078", A.getE("W_S_V"));
                        jSONObject.put("02079", A.getE("W_S_S_V"));
                        if (Build.VERSION.SDK_INT > 21) {
                            jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                        }
                        String string = Settings.Global.getString(o2Var.a.getContentResolver(), "Phenotype_boot_count");
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.put("03085", string);
                        }
                        String string2 = Settings.Global.getString(o2Var.a.getContentResolver(), "boot_count");
                        if (!TextUtils.isEmpty(string2)) {
                            jSONObject.put("03086", string2);
                        }
                    } catch (Throwable unused11) {
                    }
                    jSONObject.put("11007", System.currentTimeMillis() - j);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                } catch (Throwable unused12) {
                    return null;
                }
            } catch (Throwable unused13) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
