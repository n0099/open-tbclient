package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;

    public JSONObject a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                h a = h.a(this.a, "re_po_rt");
                boolean e = a.e("a1_p_s_p_s");
                boolean e2 = a.e("a1_p_s_p_s_c_b");
                aj ajVar = new aj(this.a);
                jSONObject.put("0", ajVar.d());
                jSONObject.put("1", ajVar.a());
                jSONObject.put("2", ajVar.c());
                jSONObject.put("3", ajVar.f());
                jSONObject.put("24", ajVar.e());
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, ab.b() ? 1 : 0);
                jSONObject.put("36", ab.a(this.a) ? 1 : 0);
                JSONObject a2 = ai.a(this.a);
                if (a2 != null) {
                    jSONObject.put("4", a2);
                }
                z zVar = new z();
                JSONArray a3 = zVar.a(this.a);
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, a3);
                jSONObject.put("146", zVar.e());
                jSONObject.put("154", zVar.a());
                jSONObject.put("168", dj.b(a3));
                jSONObject.put("169", dj.a(a3));
                jSONObject.put("185", zVar.d());
                jSONObject.put("191", zVar.c());
                if (zVar.b() != null) {
                    jSONObject.put("161", zVar.b());
                }
                jSONObject.put("22", ab.a());
                ac acVar = new ac();
                jSONObject.put("7", acVar.a() ? 1 : 0);
                boolean a4 = acVar.a(this.a);
                jSONObject.put("8", a4 ? 1 : 0);
                if (a4) {
                    jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, acVar.b(this.a));
                }
                jSONObject.put("181", acVar.f(this.a) ? 1 : 0);
                jSONObject.put("9", acVar.d(this.a));
                jSONObject.put("10", acVar.e(this.a));
                jSONObject.put("11", acVar.c(this.a));
                ae aeVar = new ae();
                jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
                jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, aeVar.a("meminfo") ? 1 : 0);
                jSONObject.put("28", aeVar.b(bk.a) ? 1 : 0);
                jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK, aeVar.b(HardwareInfoUtils.MEM_INFO_FILE) ? 1 : 0);
                jSONObject.put("96", aeVar.a());
                jSONObject.put("134", aeVar.b());
                an anVar = new an();
                Set<String> b = anVar.b();
                Set<String> c = anVar.c();
                if (c != null) {
                    str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW;
                    jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK, 1);
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK, new JSONArray((Collection) c));
                } else {
                    str = PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW;
                    jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK, 0);
                }
                if (b != null) {
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, 1);
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK, new JSONArray((Collection) b));
                } else {
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, 0);
                }
                Set<String> a5 = anVar.a();
                if (a5 != null) {
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK, a5);
                    if (b != null || c != null) {
                        HashSet hashSet = new HashSet();
                        if (b != null) {
                            hashSet.add(b);
                        }
                        if (c != null) {
                            hashSet.add(c);
                        }
                        jSONObject.put("13", anVar.a(this.a, 13, hashSet));
                        jSONObject.put("14", anVar.a(this.a, 14, hashSet));
                        jSONObject.put("15", anVar.a(this.a, 15, hashSet));
                        jSONObject.put("16", anVar.a(this.a, 16, hashSet));
                        jSONObject.put("17", anVar.a(this.a, 17, hashSet));
                        jSONObject.put("18", anVar.a(this.a, 18, hashSet));
                        jSONObject.put("19", anVar.a(this.a, 19, hashSet));
                        jSONObject.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, anVar.a(this.a, 20, hashSet));
                        jSONObject.put("21", anVar.a(this.a, 21, hashSet));
                        jSONObject.put("130", anVar.b(hashSet));
                    }
                }
                ao aoVar = new ao();
                jSONObject.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, aoVar.d() ? 1 : 0);
                boolean b2 = aoVar.b();
                jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, b2 ? 1 : 0);
                if (b2) {
                    jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, aoVar.a() ? 1 : 0);
                }
                jSONObject.put(PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, aoVar.f() ? 1 : 0);
                jSONObject.put(PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK, aoVar.e());
                jSONObject.put(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, aoVar.c() ? 1 : 0);
                jSONObject.put(WorkPostNotifyFlutterData.FAIL_POST, aoVar.g() ? 1 : 0);
                jSONObject.put("99", new af().a());
                jSONObject.put("103", new ad().a() ? 1 : 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", bv.a(this.a));
                jSONObject2.put("03014", bh.g(this.a));
                jSONObject2.put("03020", bv.b(this.a));
                jSONObject2.put("03030", bg.d(this.a));
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, jSONObject2);
                an anVar2 = new an();
                jSONObject.put("107", anVar2.d());
                jSONObject.put("155", anVar2.e());
                jSONObject.put("170", anVar2.g());
                jSONObject.put("190", anVar2.f());
                ah ahVar = new ah();
                jSONObject.put("131", ahVar.a());
                jSONObject.put("145", ahVar.a(this.a));
                jSONObject.put("132", dk.a());
                jSONObject.put("133", new aj(this.a).g());
                if (a.b(df.an, 1) == 1) {
                    jSONObject.put("139", dl.c(this.a));
                    jSONObject.put("140", dl.d(this.a));
                    jSONObject.put("147", dl.a());
                    jSONObject.put("148", di.b());
                    jSONObject.put("149", di.c());
                    jSONObject.put("151", dk.b());
                }
                if (a.b(df.ac, 0) == 1) {
                    jSONObject.put("128", ad.b() ? 1 : 0);
                }
                if (Engine.loadSuccess) {
                    as asVar = new as(this.a, 100);
                    jSONObject.put("6", asVar.a("6"));
                    JSONArray a6 = asVar.a(asVar.a(), PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK);
                    if (a6 != null && a6.length() > 0) {
                        JSONArray c2 = asVar.c(asVar.a(), PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK);
                        JSONArray b3 = asVar.b(asVar.a(), PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK);
                        jSONObject.put("42", c2);
                        jSONObject.put(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK, b3);
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, asVar.a(asVar.a(a6, c2), b3));
                    }
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, asVar.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK));
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, asVar.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                    jSONObject.put("23", asVar.a("23"));
                    jSONObject.put("37", asVar.a("37"));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK, asVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, asVar.b(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK));
                    String str2 = str;
                    jSONObject.put(str2, asVar.b(str2));
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, asVar.e(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK));
                    jSONObject.put("91", asVar.a("91"));
                    jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, asVar.c(PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK));
                    jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_DONT_REMIND_CLICK, asVar.c(PayUVEventType.PAY_SIGN_DIALOG_DONT_REMIND_CLICK));
                    jSONObject.put("64", asVar.c("64"));
                    jSONObject.put("85", asVar.d("85"));
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, asVar.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK));
                    jSONObject.put(PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK, asVar.c(PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK, asVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK));
                    jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, asVar.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, asVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, asVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK));
                    jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, asVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK));
                    jSONObject.put("73", asVar.a("73"));
                    jSONObject.put("74", asVar.a("74"));
                    jSONObject.put("104", asVar.a("104"));
                    if (a.b(df.X, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                        ar arVar = new ar(this.a);
                        String a7 = arVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW);
                        if (!TextUtils.isEmpty(a7)) {
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, a7);
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, arVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                        }
                    }
                    jSONObject.put("77", asVar.a("77"));
                    jSONObject.put("78", asVar.a("78"));
                    jSONObject.put("79", asVar.a("79"));
                    jSONObject.put("84", asVar.a("84"));
                    jSONObject.put("80", asVar.a("80"));
                    jSONObject.put("81", asVar.a("81"));
                    jSONObject.put("82", asVar.a("82"));
                    jSONObject.put("83", asVar.a("83"));
                    jSONObject.put("87", asVar.a("87"));
                    jSONObject.put("89", asVar.a("89"));
                    jSONObject.put("90", asVar.d("90"));
                    jSONObject.put("75", asVar.a("75"));
                    jSONObject.put("88", asVar.a("88"));
                    jSONObject.put("92", asVar.a("92"));
                    jSONObject.put("93", asVar.a("93"));
                    jSONObject.put("94", asVar.a("94"));
                    jSONObject.put("95", asVar.a("95"));
                    jSONObject.put("98", asVar.a("98"));
                    jSONObject.put(YYOption.UrlProtocol.USER, asVar.a(YYOption.UrlProtocol.USER));
                    jSONObject.put("105", asVar.a("105"));
                    if (a.b(df.Z, 1) == 1) {
                        aq aqVar = new aq(this.a, 0);
                        jSONObject.put("108", aqVar.a("108"));
                        jSONObject.put("109", aqVar.a("109"));
                        jSONObject.put("111", aqVar.a("111"));
                    }
                    if (a.b(df.ab, 1) == 1) {
                        aq aqVar2 = new aq(this.a, 1);
                        jSONObject.put("112", aqVar2.b("112"));
                        jSONObject.put("113", aqVar2.a("113"));
                        jSONObject.put("114", aqVar2.a("114"));
                        jSONObject.put("115", aqVar2.a("115"));
                        jSONObject.put(ApsConstants.TYPE_ANDROID_PLUGIN, aqVar2.a(ApsConstants.TYPE_ANDROID_PLUGIN));
                        jSONObject.put("117", aqVar2.a("117"));
                        jSONObject.put("120", aqVar2.a("120"));
                        aq aqVar3 = new aq(this.a, 4);
                        jSONObject.put("124", aqVar3.a("124"));
                        jSONObject.put("125", aqVar3.a("125"));
                        jSONObject.put("126", aqVar3.a("126"));
                        jSONObject.put(SpeedStats.UBC_LAUNCH_SPEED_ID, aqVar3.a(SpeedStats.UBC_LAUNCH_SPEED_ID));
                    }
                    if (a.b(df.aj, 0) == 1) {
                        av avVar = new av(this.a, 100);
                        jSONObject.put("97", avVar.a("97"));
                        jSONObject.put("118", avVar.a("118"));
                        jSONObject.put("119", avVar.a("119"));
                        jSONObject.put("135", avVar.a("135"));
                        jSONObject.put("174", avVar.a("174"));
                        av avVar2 = new av(this.a, 200);
                        jSONObject.put("173", avVar2.a("173"));
                        jSONObject.put("182", avVar2.a("182"));
                    }
                    if (a.b(df.Y, 1) == 1) {
                        jSONObject.put("129", new be(this.a, 4).a("129"));
                        be beVar = new be(this.a, 1);
                        jSONObject.put("121", beVar.a(beVar.a(), "121"));
                        be beVar2 = new be(this.a, 2);
                        jSONObject.put("137", beVar2.a("137"));
                        jSONObject.put(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID, beVar2.a(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID));
                        jSONObject.put("141", beVar2.a("141"));
                        jSONObject.put("142", beVar2.a("142"));
                        bf bfVar = new bf(this.a, 3);
                        JSONArray b4 = bfVar.b("150");
                        jSONObject.put("150", b4);
                        if (b4 != null) {
                            jSONObject.put("188", bfVar.a(b4));
                        }
                    }
                    if (a.b(df.U, 1) == 1) {
                        ba baVar = new ba(this.a, 100);
                        jSONObject.put("152", baVar.a("152"));
                        jSONObject.put("153", baVar.a("153"));
                        jSONObject.put("156", baVar.a("156"));
                        jSONObject.put("157", baVar.a("157"));
                        jSONObject.put("163", baVar.a("163"));
                        jSONObject.put("171", baVar.a("171", true));
                        jSONObject.put("172", baVar.b("172"));
                        jSONObject.put("177", new ba(this.a, 500).d("177"));
                    }
                    if ((e || e2) && a.b(df.W, 0) == 1) {
                        jSONObject.put("158", new ba(this.a, 300).b("158"));
                    }
                    if (a.b(df.am, 0) == 1) {
                        bd bdVar = new bd(this.a);
                        jSONObject.put("162", bdVar.a("162"));
                        jSONObject.put("160", bdVar.a(bdVar.a(), "160"));
                        ba baVar2 = new ba(this.a, 400);
                        jSONObject.put("164", baVar2.a("164"));
                        jSONObject.put("165", baVar2.a("165"));
                        jSONObject.put("166", baVar2.c("166"));
                        jSONObject.put("167", baVar2.a("167"));
                    }
                    if (a.b(df.ak, 1) == 1) {
                        ay ayVar = new ay(this.a, 600);
                        jSONObject.put(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_LOGIN, ayVar.a(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_LOGIN));
                        jSONObject.put("186", ayVar.a("186"));
                        jSONObject.put("189", ayVar.a("189"));
                    }
                }
                jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, ab.b(this.a) ? 1 : 0);
                jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11008", a.b(df.g, bq.e));
                jSONObject.put("11009", bs.a(this.a.getApplicationContext()));
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                } catch (Throwable unused) {
                }
                String b5 = a.b(df.m, "", true);
                if (!TextUtils.isEmpty(b5)) {
                    jSONObject.put("183", b5);
                    a.c(df.m, "");
                }
                jSONObject.put("187", al.a(this.a) ? 1 : 0);
                int c3 = al.c();
                if (c3 > 0) {
                    jSONObject.put(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_DOWNLOAD, c3);
                }
                jSONObject.put("11006", e ? 1 : 0);
                jSONObject.put("11029", e2 ? 1 : 0);
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

    public cl(Context context, int i, int i2) {
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
