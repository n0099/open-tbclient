package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;

    public m2(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = i;
        this.c = i2;
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

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                i a = i.a(this.a, "re_po_rt");
                boolean b = a.b("a1_p_s_p_s");
                boolean b2 = a.b("a1_p_s_p_s_c_b");
                j0 j0Var = new j0(this.a);
                jSONObject.put("0", j0Var.i());
                jSONObject.put("1", j0Var.a());
                jSONObject.put("2", j0Var.e());
                jSONObject.put("3", j0Var.g());
                jSONObject.put("24", j0Var.h());
                jSONObject.put("35", c0.a() ? 1 : 0);
                jSONObject.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, c0.a(this.a) ? 1 : 0);
                Object a2 = i0.a(this.a);
                if (a2 != null) {
                    jSONObject.put("4", a2);
                }
                a0 a0Var = new a0();
                JSONArray a3 = a0Var.a(this.a);
                jSONObject.put("49", a3);
                jSONObject.put("146", a0Var.d());
                jSONObject.put("154", a0Var.b());
                jSONObject.put("168", j3.a(a3));
                jSONObject.put("169", j3.b(a3));
                jSONObject.put("185", a0Var.e());
                jSONObject.put("191", a0Var.a());
                if (a0Var.c() != null) {
                    jSONObject.put("161", a0Var.c());
                }
                jSONObject.put("22", c0.b());
                d0 d0Var = new d0();
                jSONObject.put("7", d0Var.a() ? 1 : 0);
                boolean d = d0Var.d(this.a);
                jSONObject.put("8", d ? 1 : 0);
                if (d) {
                    jSONObject.put("61", d0Var.c(this.a));
                }
                jSONObject.put("181", d0Var.e(this.a) ? 1 : 0);
                jSONObject.put("9", d0Var.a(this.a));
                jSONObject.put("10", d0Var.f(this.a));
                jSONObject.put("11", d0Var.b(this.a));
                f0 f0Var = new f0();
                jSONObject.put("26", f0Var.a("cpuinfo") ? 1 : 0);
                jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, f0Var.a("meminfo") ? 1 : 0);
                jSONObject.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, f0Var.b(k1.a) ? 1 : 0);
                jSONObject.put("29", f0Var.b(HardwareInfoUtils.MEM_INFO_FILE) ? 1 : 0);
                jSONObject.put("96", f0Var.a());
                jSONObject.put("134", f0Var.b());
                p0 p0Var = new p0();
                Set<String> f = p0Var.f();
                Set<String> g = p0Var.g();
                if (g != null) {
                    jSONObject.put("30", 1);
                    jSONObject.put("32", new JSONArray((Collection) g));
                } else {
                    jSONObject.put("30", 0);
                }
                if (f != null) {
                    jSONObject.put("31", 1);
                    jSONObject.put("33", new JSONArray((Collection) f));
                } else {
                    jSONObject.put("31", 0);
                }
                Object e = p0Var.e();
                if (e != null) {
                    jSONObject.put("34", e);
                    if (f != null || g != null) {
                        HashSet hashSet = new HashSet();
                        if (f != null) {
                            hashSet.add(f);
                        }
                        if (g != null) {
                            hashSet.add(g);
                        }
                        jSONObject.put("13", p0Var.a(this.a, 13, hashSet));
                        jSONObject.put("14", p0Var.a(this.a, 14, hashSet));
                        jSONObject.put("15", p0Var.a(this.a, 15, hashSet));
                        jSONObject.put("16", p0Var.a(this.a, 16, hashSet));
                        jSONObject.put("17", p0Var.a(this.a, 17, hashSet));
                        jSONObject.put("18", p0Var.a(this.a, 18, hashSet));
                        jSONObject.put("19", p0Var.a(this.a, 19, hashSet));
                        jSONObject.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, p0Var.a(this.a, 20, hashSet));
                        jSONObject.put("21", p0Var.a(this.a, 21, hashSet));
                        jSONObject.put("130", p0Var.a(hashSet));
                    }
                }
                o0 o0Var = new o0();
                jSONObject.put("65", o0Var.f() ? 1 : 0);
                boolean e2 = o0Var.e();
                jSONObject.put("66", e2 ? 1 : 0);
                if (e2) {
                    jSONObject.put("67", o0Var.g() ? 1 : 0);
                }
                jSONObject.put("68", o0Var.c() ? 1 : 0);
                jSONObject.put("69", o0Var.b());
                jSONObject.put("101", o0Var.d() ? 1 : 0);
                jSONObject.put("102", o0Var.a() ? 1 : 0);
                jSONObject.put("99", new g0().a());
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, new e0().a() ? 1 : 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", v1.c(this.a));
                jSONObject2.put("03014", h1.B(this.a));
                jSONObject2.put("03020", v1.a(this.a));
                jSONObject2.put("03030", g1.f(this.a));
                jSONObject.put("51", jSONObject2);
                p0 p0Var2 = new p0();
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, p0Var2.b());
                jSONObject.put("155", p0Var2.c());
                jSONObject.put("170", p0Var2.d());
                jSONObject.put("190", p0Var2.a());
                h0 h0Var = new h0();
                jSONObject.put("131", h0Var.a());
                jSONObject.put("145", h0Var.a(this.a));
                jSONObject.put("132", k3.b());
                jSONObject.put("133", new j0(this.a).j());
                if (a.a(f3.h0, 1) == 1) {
                    jSONObject.put("139", l3.e(this.a));
                    jSONObject.put("140", l3.d(this.a));
                    jSONObject.put("143", o1.a(this.a));
                    jSONObject.put("147", l3.a());
                    jSONObject.put("148", i3.e());
                    jSONObject.put("149", i3.b());
                    jSONObject.put("151", k3.a());
                }
                if (a.a(f3.c0, 0) == 1) {
                    if (b || b2) {
                        jSONObject.put("25", m0.a(this.a) ? 1 : 0);
                    }
                    jSONObject.put("128", e0.b() ? 1 : 0);
                }
                if (Engine.loadSuccess) {
                    t0 t0Var = new t0(this.a, 100);
                    jSONObject.put("6", t0Var.c("6"));
                    JSONArray b3 = t0Var.b(t0Var.a(), "41");
                    if (b3 != null && b3.length() > 0) {
                        JSONArray c = t0Var.c(t0Var.a(), "41");
                        JSONArray a4 = t0Var.a(t0Var.a(), "41");
                        jSONObject.put(RoomMasterTable.DEFAULT_ID, c);
                        jSONObject.put("43", a4);
                        jSONObject.put("41", t0Var.a(t0Var.a(b3, c), a4));
                    }
                    jSONObject.put("47", t0Var.c("47"));
                    jSONObject.put("48", t0Var.c("48"));
                    jSONObject.put("23", t0Var.c("23"));
                    jSONObject.put(PayConfig.PAYMENT_POS_KEY_MANGA, t0Var.c(PayConfig.PAYMENT_POS_KEY_MANGA));
                    jSONObject.put("38", t0Var.c("38"));
                    jSONObject.put("40", t0Var.d("40"));
                    jSONObject.put("45", t0Var.d("45"));
                    jSONObject.put("46", t0Var.e("46"));
                    jSONObject.put("91", t0Var.c("91"));
                    jSONObject.put("62", t0Var.a("62"));
                    jSONObject.put("63", t0Var.a("63"));
                    jSONObject.put(WebKitFactory.OS_64, t0Var.a(WebKitFactory.OS_64));
                    jSONObject.put("85", t0Var.b("85"));
                    jSONObject.put("50", t0Var.c("50"));
                    jSONObject.put("70", t0Var.a("70"));
                    jSONObject.put("39", t0Var.c("39"));
                    jSONObject.put("52", t0Var.c("52"));
                    jSONObject.put("53", t0Var.c("53"));
                    jSONObject.put("54", t0Var.c("54"));
                    jSONObject.put(BaseUtils.METHOD_SENDMESSAGE, t0Var.c(BaseUtils.METHOD_SENDMESSAGE));
                    jSONObject.put("73", t0Var.c("73"));
                    jSONObject.put("74", t0Var.c("74"));
                    jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE, t0Var.c(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE));
                    if (a.a(f3.X, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                        s0 s0Var = new s0(this.a);
                        String a5 = s0Var.a("57");
                        if (!TextUtils.isEmpty(a5)) {
                            jSONObject.put("57", a5);
                            jSONObject.put("56", s0Var.a("56"));
                        }
                    }
                    jSONObject.put("77", t0Var.c("77"));
                    jSONObject.put("78", t0Var.c("78"));
                    jSONObject.put("79", t0Var.c("79"));
                    jSONObject.put("84", t0Var.c("84"));
                    jSONObject.put("80", t0Var.c("80"));
                    jSONObject.put("81", t0Var.c("81"));
                    jSONObject.put("82", t0Var.c("82"));
                    jSONObject.put("83", t0Var.c("83"));
                    jSONObject.put("87", t0Var.c("87"));
                    jSONObject.put("89", t0Var.c("89"));
                    jSONObject.put("90", t0Var.b("90"));
                    jSONObject.put("75", t0Var.c("75"));
                    jSONObject.put("88", t0Var.c("88"));
                    jSONObject.put("92", t0Var.c("92"));
                    jSONObject.put(BaseUtils.METHOD_RECEIVEESSAGE, t0Var.c(BaseUtils.METHOD_RECEIVEESSAGE));
                    jSONObject.put(HttpConfig.UBC_HTTP_ID, t0Var.c(HttpConfig.UBC_HTTP_ID));
                    jSONObject.put("95", t0Var.c("95"));
                    jSONObject.put("98", t0Var.c("98"));
                    jSONObject.put("100", t0Var.c("100"));
                    jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, t0Var.c(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN));
                    if (a.a(f3.Z, 1) == 1) {
                        r0 r0Var = new r0(this.a, 0);
                        jSONObject.put("108", r0Var.b("108"));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, r0Var.b(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        jSONObject.put("111", r0Var.b("111"));
                    }
                    if (a.a(f3.b0, 1) == 1) {
                        r0 r0Var2 = new r0(this.a, 1);
                        jSONObject.put("112", r0Var2.a("112"));
                        jSONObject.put("113", r0Var2.b("113"));
                        jSONObject.put("114", r0Var2.b("114"));
                        jSONObject.put("115", r0Var2.b("115"));
                        jSONObject.put(ApsConstants.TYPE_ANDROID_PLUGIN, r0Var2.b(ApsConstants.TYPE_ANDROID_PLUGIN));
                        jSONObject.put("117", r0Var2.b("117"));
                        jSONObject.put("120", r0Var2.b("120"));
                        r0 r0Var3 = new r0(this.a, 4);
                        jSONObject.put("124", r0Var3.b("124"));
                        jSONObject.put("125", r0Var3.b("125"));
                        jSONObject.put("126", r0Var3.b("126"));
                        jSONObject.put(SpeedStats.UBC_LAUNCH_SPEED_ID, r0Var3.b(SpeedStats.UBC_LAUNCH_SPEED_ID));
                    }
                    if (a.a(f3.d0, 0) == 1) {
                        w0 w0Var = new w0(this.a, 100);
                        jSONObject.put("97", w0Var.a("97"));
                        jSONObject.put("118", w0Var.a("118"));
                        jSONObject.put("119", w0Var.a("119"));
                        jSONObject.put("135", w0Var.a("135"));
                        jSONObject.put("174", w0Var.a("174"));
                        w0 w0Var2 = new w0(this.a, 200);
                        jSONObject.put("173", w0Var2.a("173"));
                        jSONObject.put("182", w0Var2.a("182"));
                    }
                    if (a.a(f3.Y, 1) == 1) {
                        jSONObject.put("129", new f1(this.a, 4).a("129"));
                        f1 f1Var = new f1(this.a, 1);
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN, f1Var.b(f1Var.a(), TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN));
                        f1 f1Var2 = new f1(this.a, 2);
                        jSONObject.put("137", f1Var2.a("137"));
                        jSONObject.put(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID, f1Var2.a(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID));
                        jSONObject.put("141", f1Var2.a("141"));
                        jSONObject.put("142", f1Var2.a("142"));
                        e1 e1Var = new e1(this.a, 3);
                        JSONArray a6 = e1Var.a("150");
                        jSONObject.put("150", a6);
                        if (a6 != null) {
                            jSONObject.put("188", e1Var.a(a6));
                        }
                    }
                    if (a.a(f3.U, 1) == 1) {
                        a1 a1Var = new a1(this.a, 100);
                        jSONObject.put("152", a1Var.b("152"));
                        jSONObject.put("153", a1Var.b("153"));
                        jSONObject.put("156", a1Var.b("156"));
                        jSONObject.put("157", a1Var.b("157"));
                        jSONObject.put("163", a1Var.b("163"));
                        jSONObject.put("171", a1Var.a("171", true));
                        jSONObject.put("172", a1Var.c("172"));
                        jSONObject.put("177", new a1(this.a, 500).d("177"));
                    }
                    if ((b || b2) && a.a(f3.W, 0) == 1) {
                        jSONObject.put("158", new a1(this.a, 300).c("158"));
                    }
                    if (a.a(f3.g0, 0) == 1) {
                        d1 d1Var = new d1(this.a);
                        jSONObject.put("162", d1Var.a("162"));
                        jSONObject.put("160", d1Var.b(d1Var.a(), "160"));
                        a1 a1Var2 = new a1(this.a, 400);
                        jSONObject.put("164", a1Var2.b("164"));
                        jSONObject.put("165", a1Var2.b("165"));
                        jSONObject.put("166", a1Var2.a("166"));
                        jSONObject.put("167", a1Var2.b("167"));
                    }
                    if (a.a(f3.e0, 1) == 1) {
                        y0 y0Var = new y0(this.a, 600);
                        jSONObject.put("179", y0Var.a("179"));
                        jSONObject.put("186", y0Var.a("186"));
                        jSONObject.put("189", y0Var.a("189"));
                    }
                }
                jSONObject.put("58", f0.a(this.a));
                jSONObject.put("60", c0.b(this.a) ? 1 : 0);
                jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11008", a.a(f3.i, q1.e));
                jSONObject.put("11009", s1.b(this.a.getApplicationContext()));
                try {
                    jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                    jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                    jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                } catch (Throwable unused) {
                }
                String a7 = a.a(f3.m, "", true);
                if (!TextUtils.isEmpty(a7)) {
                    jSONObject.put("183", a7);
                    a.b(f3.m, "");
                }
                jSONObject.put("187", l0.a(this.a) ? 1 : 0);
                jSONObject.put("11006", b ? 1 : 0);
                jSONObject.put("11029", b2 ? 1 : 0);
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("20000", this.b);
                jSONObject.put("20001", this.c);
                try {
                    jSONObject.put("02078", A.getE("W_S_V"));
                    jSONObject.put("02079", A.getE("W_S_S_V"));
                } catch (Throwable unused2) {
                }
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            } catch (Throwable unused3) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
