package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v2 double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v3 double)] */
    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public JSONObject a() {
        InterceptResult invokeV;
        long j;
        h hVar;
        boolean z;
        boolean z2;
        String str;
        String str2;
        cn cnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                h a = h.a(this.a, "re_po_rt");
                boolean e = a.e("a1_p_s_p_s");
                boolean e2 = a.e("a1_p_s_p_s_c_b");
                if (a.b(df.aO, 1) == 1 && (e || e2)) {
                    String a2 = bh.a(this.a);
                    if (!TextUtils.isEmpty(a2) && !a2.startsWith("RISK")) {
                        jSONObject.put("01001", a2);
                    }
                    String c = bh.c(this.a);
                    if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                        jSONObject.put("01003", c);
                    }
                    String b = bh.b(this.a, 0);
                    if (!TextUtils.isEmpty(b) && !b.startsWith("RISK")) {
                        jSONObject.put("01019", b);
                    }
                    String b2 = bh.b(this.a, 1);
                    if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                        jSONObject.put("01004", b2);
                    }
                    String d = bh.d(this.a);
                    if (!TextUtils.isEmpty(d) && !d.startsWith("RISK")) {
                        jSONObject.put("01007", d);
                    }
                }
                if (a.b(df.aP, 0) == 1 && (e || e2)) {
                    bg bgVar = new bg();
                    if (a.b(df.bc, 1) == 1) {
                        jSONObject.put("10020", bgVar.f(this.a));
                    }
                }
                if (a.b(df.aQ, 1) == 1 && (e || e2)) {
                    jSONObject.put("01011", bh.e(this.a));
                }
                if (a.b(df.aR, 1) == 1 && (e || e2)) {
                    String p = bh.p(this.a);
                    if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                        jSONObject.put("01016", p);
                    }
                }
                if (a.b(df.aF, 1) == 1) {
                    if (e || e2) {
                        String f = bh.f(this.a);
                        if (!TextUtils.isEmpty(f) && !f.startsWith("RISK")) {
                            jSONObject.put("01013", f);
                        }
                        jSONObject.put("02042", bh.u(this.a));
                    }
                    jSONObject.put("02054", bh.x(this.a));
                    j = currentTimeMillis;
                    str = "RISK";
                    z2 = e2;
                    z = e;
                    try {
                        if (Engine.loadSuccess) {
                            try {
                                jSONObject.put("02019", bl.b(this.a));
                                jSONObject.put("02021", bl.d(this.a));
                                jSONObject.put("02022", bl.c(this.a));
                                jSONObject.put("02030", bl.f(this.a));
                                ce ceVar = new ce(this.a);
                                jSONObject.put("01014", ceVar.a("01014") != null ? ceVar.a("01014") : "");
                                jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                                jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                                jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                                jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                                jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                                jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                                jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                                jSONObject.put("02008", ceVar.a("02008") != null ? ceVar.a("02008") : bl.h());
                                jSONObject.put("02009", ceVar.a("02009") != null ? ceVar.a("02009") : bl.i());
                                jSONObject.put("02010", ceVar.a("02010") != null ? ceVar.a("02010") : bl.j());
                                jSONObject.put("02011", ceVar.a("02011") != null ? ceVar.a("02011") : bl.k());
                                jSONObject.put("02012", ceVar.a("02012") != null ? ceVar.a("02012") : bl.l());
                                jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                                jSONObject.put("02014", ceVar.a("02014") != null ? ceVar.a("02014") : bl.n());
                                jSONObject.put("02015", ceVar.a("02015") != null ? ceVar.a("02015") : bl.p());
                                jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                                jSONObject.put("02017", ceVar.a("02017") != null ? ceVar.a("02017") : Integer.valueOf(bl.r()));
                                jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                                jSONObject.put("02020", ceVar.a("02020") != null ? ceVar.a("02020") : bl.u());
                                jSONObject.put("02023", ceVar.a("02023") != null ? ceVar.a("02023") : "");
                                jSONObject.put("02031", ceVar.a("02031") != null ? ceVar.a("02031") : bl.y());
                                jSONObject.put("02032", ceVar.a("02032") != null ? ceVar.a("02032") : bl.o());
                                jSONObject.put("02033", ceVar.a("02033") != null ? ceVar.a("02033") : bl.x());
                                jSONObject.put("02034", ceVar.a("02034") != null ? ceVar.a("02034") : bl.z());
                                jSONObject.put("02035", ceVar.a("02035") != null ? ceVar.a("02035") : bl.A());
                                jSONObject.put("02036", ceVar.a("02036") != null ? ceVar.a("02036") : "");
                                jSONObject.put("02037", ceVar.a("02037") != null ? ceVar.a("02037") : bl.w());
                                jSONObject.put("02038", ceVar.a("02038") != null ? ceVar.a("02038") : bl.v());
                                jSONObject.put("02045", ceVar.a("02045") != null ? ceVar.a("02045") : bl.B());
                            } catch (Exception unused) {
                            }
                            cnVar = this;
                        } else {
                            jSONObject.put("02001", bl.a());
                            jSONObject.put("02002", bl.b());
                            jSONObject.put("02003", bl.c());
                            jSONObject.put("02004", bl.d());
                            jSONObject.put("02005", bl.e());
                            jSONObject.put("02006", bl.f());
                            jSONObject.put("02007", bl.g());
                            jSONObject.put("02008", bl.h());
                            jSONObject.put("02009", bl.i());
                            jSONObject.put("02010", bl.j());
                            jSONObject.put("02011", bl.k());
                            jSONObject.put("02012", bl.l());
                            jSONObject.put("02013", bl.m());
                            jSONObject.put("02014", bl.n());
                            jSONObject.put("02015", bl.p());
                            jSONObject.put("02016", bl.q());
                            jSONObject.put("02017", bl.r());
                            jSONObject.put("02018", bl.s());
                            cnVar = this;
                            try {
                                jSONObject.put("02019", bl.b(cnVar.a));
                                jSONObject.put("02020", bl.u());
                                jSONObject.put("02021", bl.d(cnVar.a));
                                jSONObject.put("02022", bl.c(cnVar.a));
                                jSONObject.put("02030", bl.f(cnVar.a));
                                jSONObject.put("02031", bl.y());
                                jSONObject.put("02032", bl.o());
                                jSONObject.put("02033", bl.x());
                                jSONObject.put("02034", bl.z());
                                jSONObject.put("02035", bl.A());
                                jSONObject.put("02037", bl.w());
                                jSONObject.put("02038", bl.v());
                                jSONObject.put("02045", bl.B());
                            } catch (Throwable unused2) {
                                return null;
                            }
                        }
                        str2 = "";
                        jSONObject.put("02067", cnVar.a.getApplicationContext().getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                        jSONObject.put("02039", bh.i());
                        jSONObject.put("02040", bh.j());
                        jSONObject.put("02041", bh.t(cnVar.a));
                        jSONObject.put("02044", bl.t());
                        jSONObject.put("02046", bl.C());
                        String a3 = bh.a("persist.service.adb.enable");
                        if (!TextUtils.isEmpty(a3)) {
                            jSONObject.put("03058", a3);
                        }
                        String a4 = bh.a("sys.resettype");
                        if (!TextUtils.isEmpty(a4)) {
                            jSONObject.put("03057", a4);
                        }
                        String a5 = bh.a("ro.boot.bootreason");
                        if (!TextUtils.isEmpty(a5)) {
                            jSONObject.put("03056", a5);
                        }
                        String a6 = bh.a("ro.runtime.firstboot");
                        if (!TextUtils.isEmpty(a6)) {
                            jSONObject.put("03055", a6);
                        }
                        String a7 = bh.a("init.svc.atcmdserver");
                        if (!TextUtils.isEmpty(a7)) {
                            jSONObject.put("03054", a7);
                        }
                        String a8 = bh.a("ro.build.date.utc");
                        if (!TextUtils.isEmpty(a8)) {
                            jSONObject.put("03061", a8);
                        }
                        String a9 = bh.a("ro.bootimage.build.date.utc");
                        if (!TextUtils.isEmpty(a9)) {
                            jSONObject.put("03062", a9);
                        }
                        String a10 = bh.a("ro.build.date.YmdHM");
                        if (!TextUtils.isEmpty(a10)) {
                            jSONObject.put("03063", a10);
                        }
                        String a11 = bh.a("dhcp.ipv6.wlan0.dns1");
                        if (!TextUtils.isEmpty(a11)) {
                            jSONObject.put("03067", a11);
                        }
                        String a12 = bh.a("dhcp.ipv6.wlan0.dns2");
                        if (!TextUtils.isEmpty(a12)) {
                            jSONObject.put("03068", a12);
                        }
                        String a13 = bh.a("dhcp.wlan0.dns1");
                        if (!TextUtils.isEmpty(a13)) {
                            jSONObject.put("03069", a13);
                        }
                        String a14 = bh.a("dhcp.wlan0.dns2");
                        if (!TextUtils.isEmpty(a14)) {
                            jSONObject.put("03070", a14);
                        }
                        String a15 = bh.a("net.change");
                        if (!TextUtils.isEmpty(a15)) {
                            jSONObject.put("03071", a15);
                        }
                        String a16 = bh.a("net.dns1");
                        if (!TextUtils.isEmpty(a16)) {
                            jSONObject.put("03072", a16);
                        }
                        String a17 = bh.a("net.dns2");
                        if (!TextUtils.isEmpty(a17)) {
                            jSONObject.put("03073", a17);
                        }
                        hVar = a;
                        long a18 = hVar.a(df.d, -1L);
                        if (a18 != -1) {
                            jSONObject.put("03074", a18 + System.currentTimeMillis());
                        }
                        try {
                            jSONObject.put("03064", Settings.System.getInt(cnVar.a.getContentResolver(), "screen_brightness_mode"));
                            jSONObject.put("03065", Settings.System.getInt(cnVar.a.getContentResolver(), "accelerometer_rotation"));
                        } catch (Throwable unused3) {
                        }
                        jSONObject.put("03081", bl.L());
                        jSONObject.put("03053", bh.y(cnVar.a));
                        jSONObject.put("03052", bl.i(cnVar.a));
                        jSONObject.put("03050", bl.h(cnVar.a));
                        jSONObject.put("03049", bl.g(cnVar.a));
                        jSONObject.put("02027", bl.H());
                        jSONObject.put("02028", bl.D());
                        jSONObject.put("02029", bl.E());
                        jSONObject.put("02057", bl.F());
                        jSONObject.put("02058", bl.G());
                    } catch (Throwable unused4) {
                        return null;
                    }
                } else {
                    j = currentTimeMillis;
                    hVar = a;
                    z = e;
                    z2 = e2;
                    str = "RISK";
                    str2 = "";
                    cnVar = this;
                }
                if (hVar.b(df.aG, 1) == 1) {
                    jSONObject.put("03001", bo.a());
                    jSONObject.put("03002", bo.b());
                    jSONObject.put("03001", bo.a());
                    jSONObject.put("03043", SystemClock.elapsedRealtime());
                    jSONObject.put("03044", SystemClock.uptimeMillis());
                    jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    by byVar = new by(cnVar.a);
                    if (Engine.loadSuccess) {
                        jSONObject.put("03004", byVar.a("03004") != null ? byVar.a("03004") : str2);
                        jSONObject.put("03036", byVar.b("03036") != null ? byVar.b("03036") : str2);
                        jSONObject.put("03039", byVar.a("03039") != null ? byVar.a("03039") : str2);
                        jSONObject.put("03040", byVar.a("03040") != null ? byVar.a("03040") : str2);
                        jSONObject.put("03041", byVar.a("03041") != null ? byVar.a("03041") : str2);
                        jSONObject.put("03042", byVar.a("03042") != null ? byVar.a("03042") : str2);
                        jSONObject.put("03079", byVar.a("03079") != null ? byVar.a("03079") : null);
                        jSONObject.put("03080", byVar.a("03080") != null ? byVar.a("03080") : null);
                    }
                    jSONObject.put("03007", bv.a(cnVar.a));
                    jSONObject.put("03008", bv.c(cnVar.a));
                    jSONObject.put("03011", am.b(cnVar.a));
                    jSONObject.put("03012", am.b());
                    jSONObject.put("03014", bh.g(cnVar.a));
                    jSONObject.put("03034", bh.h(cnVar.a));
                    jSONObject.put("03020", bv.b(cnVar.a));
                    jSONObject.put("03037", bl.I());
                    jSONObject.put("03038", bl.J());
                    jSONObject.put("03077", bl.K());
                    try {
                        bg bgVar2 = new bg();
                        jSONObject.put("03006", bgVar2.a(cnVar.a));
                        jSONObject.put("03010", bgVar2.b(cnVar.a));
                        jSONObject.put("03033", bgVar2.c(cnVar.a));
                        jSONObject.put("03013", bgVar2.a());
                        jSONObject.put("03021", bgVar2.e(cnVar.a));
                        jSONObject.put("03030", bg.d(cnVar.a));
                        jSONObject.put("10031", bgVar2.b());
                    } catch (Exception unused5) {
                    }
                }
                if (hVar.b(df.aU, 0) == 1) {
                    jSONObject.put("03019", bh.k(cnVar.a));
                    String m = bh.m(cnVar.a);
                    if (!TextUtils.isEmpty(m)) {
                        jSONObject.put("03047", m);
                    }
                    jSONObject.put("03018", bh.i(cnVar.a));
                }
                if (hVar.b(df.aV, 1) == 1) {
                    jSONObject.put("02059", bm.a(cnVar.a));
                    jSONObject.put("02060", bm.a());
                    jSONObject.put("02061", bm.b());
                    jSONObject.put("02062", bm.c());
                    if (Engine.loadSuccess) {
                        ca caVar = new ca(cnVar.a);
                        jSONObject.put("08001", caVar.a("08001") != null ? caVar.a("08001") : str2);
                    }
                    JSONObject d2 = bm.d();
                    if (d2 != null && d2.length() > 0) {
                        jSONObject.put("10050", d2);
                    }
                }
                if (hVar.b(df.aT, 1) == 1 && (z || z2)) {
                    jSONObject.put("03029", bh.j(cnVar.a));
                }
                if (hVar.b(df.aH, 1) == 1) {
                    if (Engine.loadSuccess) {
                        bz bzVar = new bz(cnVar.a);
                        jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : str2);
                        jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : str2);
                        jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : str2);
                        jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : str2);
                    } else {
                        try {
                            bj b3 = bk.b();
                            jSONObject.put("04001", bk.a());
                            jSONObject.put("04002", b3.b());
                            jSONObject.put("04003", b3.c());
                            jSONObject.put("04004", b3.a());
                        } catch (Exception unused6) {
                        }
                    }
                }
                if (hVar.b(df.aK, 0) == 1 && (z || z2)) {
                    Object f2 = bh.f();
                    if (f2 != null) {
                        jSONObject.put("06014", f2);
                    }
                    if (Engine.loadSuccess) {
                        cf cfVar = new cf(cnVar.a);
                        jSONObject.put("06015", cfVar.b("06015") != null ? cfVar.b("06015") : str2);
                    }
                }
                if (z || z2) {
                    String h = bh.h();
                    if (!TextUtils.isEmpty(h) && !h.startsWith(str)) {
                        jSONObject.put("07005", h);
                    } else if (h == null) {
                        jSONObject.put("07005", str2);
                    } else {
                        jSONObject.put("07005", h);
                    }
                }
                if (hVar.b(df.aI, 0) == 1 && (z || z2)) {
                    if (Engine.loadSuccess) {
                        jSONObject.put("07007", new cc(cnVar.a).a("07007"));
                    }
                    JSONArray a19 = br.a(cnVar.a);
                    if (a19 != null && a19.length() > 0) {
                        jSONObject.put("03035", a19);
                    }
                }
                if (z || z2) {
                    try {
                        double b4 = bh.b();
                        if (b4 > 0.0d) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(b4);
                            jSONObject.put("09002", sb.toString());
                        }
                        double c2 = bh.c();
                        if (c2 > 0.0d) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(c2);
                            jSONObject.put("09003", sb2.toString());
                        }
                        jSONObject.put("09001", bh.d());
                    } catch (Exception unused7) {
                    }
                }
                if (hVar.b(df.aM, 0) == 1 && (z || z2)) {
                    jSONObject.put("10002", new w(cnVar.a).a(1));
                }
                if (hVar.b(df.aJ, 1) == 1 && Engine.loadSuccess) {
                    String a20 = new cd(cnVar.a).a("05001");
                    try {
                        if (!TextUtils.isEmpty(a20) && a20.length() > 10) {
                            jSONObject.put("05001", new JSONArray(a20));
                        }
                    } catch (Exception unused8) {
                    }
                }
                if (Engine.loadSuccess) {
                    cb cbVar = new cb(cnVar.a);
                    jSONObject.put("13001", cbVar.a("13001") != null ? cbVar.a("13001") : str2);
                }
                jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11003", bi.v);
                jSONObject.put("11004", Engine.loadSoCount);
                jSONObject.put("11006", z ? 1 : 0);
                jSONObject.put("11029", z2 ? 1 : 0);
                jSONObject.put("11008", hVar.b(df.g, bq.e));
                jSONObject.put("11009", bs.a(cnVar.a.getApplicationContext()));
                try {
                    String w = bh.w(cnVar.a);
                    if (!TextUtils.isEmpty(w)) {
                        jSONObject.put("01026", w);
                    }
                    if (hVar.b(df.aL, 1) == 1) {
                        String GY = com.kwad.sdk.f.b.Hj().GY();
                        if (!TextUtils.isEmpty(GY)) {
                            jSONObject.put("11102", GY);
                        }
                        jSONObject.put("11104", com.kwad.sdk.f.b.Hj().Hf());
                        jSONObject.put("11105", com.kwad.sdk.f.b.Hj().getDeviceId());
                        jSONObject.put("11106", com.kwad.sdk.f.b.Hj().getIccId());
                        jSONObject.put("11107", com.kwad.sdk.f.b.Hj().GX());
                        jSONObject.put("11108", com.kwad.sdk.f.b.Hj().Ha());
                        jSONObject.put("11109", com.kwad.sdk.f.b.Hj().Hb());
                        jSONObject.put("11110", com.kwad.sdk.f.b.Hj().Hc());
                        jSONObject.put("11111", com.kwad.sdk.f.b.Hj().getIp());
                        jSONObject.put("11112", com.kwad.sdk.f.b.Hj().getLocation());
                        jSONObject.put("11113", com.kwad.sdk.f.b.Hj().getOaid());
                        jSONObject.put("11114", com.kwad.sdk.f.b.Hj().GZ());
                        jSONObject.put("11115", com.kwad.sdk.f.b.Hj().He());
                        jSONObject.put("11116", com.kwad.sdk.f.b.Hj().Hd());
                        jSONObject.put("11202", bh.b(com.kwad.sdk.f.b.Hj().GY()));
                        jSONObject.put("11204", bh.b(com.kwad.sdk.f.b.Hj().Hf()));
                        jSONObject.put("11205", bh.b(com.kwad.sdk.f.b.Hj().getDeviceId()));
                        jSONObject.put("11206", bh.b(com.kwad.sdk.f.b.Hj().getIccId()));
                        jSONObject.put("11207", bh.b(com.kwad.sdk.f.b.Hj().GX()));
                        jSONObject.put("11208", bh.b(com.kwad.sdk.f.b.Hj().Ha()));
                        jSONObject.put("11209", bh.b(com.kwad.sdk.f.b.Hj().Hb()));
                        jSONObject.put("11210", bh.b(com.kwad.sdk.f.b.Hj().Hc()));
                        jSONObject.put("11211", bh.b(com.kwad.sdk.f.b.Hj().getIp()));
                        jSONObject.put("11212", bh.b(com.kwad.sdk.f.b.Hj().getLocation()));
                        jSONObject.put("11213", bh.b(com.kwad.sdk.f.b.Hj().getOaid()));
                        jSONObject.put("11214", bh.b(com.kwad.sdk.f.b.Hj().GZ()));
                        jSONObject.put("11215", bh.b(com.kwad.sdk.f.b.Hj().He()));
                        jSONObject.put("11216", bh.b(com.kwad.sdk.f.b.Hj().Hd()));
                        jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                        jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                        jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                    }
                } catch (Throwable unused9) {
                }
                try {
                    jSONObject.put("02078", A.getE("W_S_V"));
                    jSONObject.put("02079", A.getE("W_S_S_V"));
                    if (Build.VERSION.SDK_INT > 21) {
                        jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                    }
                    String string = Settings.Global.getString(cnVar.a.getContentResolver(), "Phenotype_boot_count");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("03085", string);
                    }
                    String string2 = Settings.Global.getString(cnVar.a.getContentResolver(), "boot_count");
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put("03086", string2);
                    }
                    String string3 = ApiReplaceUtil.getString(cnVar.a.getContentResolver(), "power_on_times");
                    if (!TextUtils.isEmpty(string3)) {
                        jSONObject.put("03091", string3);
                    }
                    String string4 = ApiReplaceUtil.getString(cnVar.a.getContentResolver(), "first_boot_flag");
                    if (!TextUtils.isEmpty(string4)) {
                        jSONObject.put("03104", string4);
                    }
                    jSONObject.put("03113", bh.a());
                } catch (Throwable unused10) {
                }
                jSONObject.put("11007", System.currentTimeMillis() - j);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            } catch (Throwable unused11) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public cn(Context context, int i) {
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
                JSONObject a2 = new cm(str, ck.l).a(this.a);
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
}
