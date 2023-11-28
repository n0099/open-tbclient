package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public cj(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
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

    public JSONObject a() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                h a = h.a(this.a, "re_po_rt");
                boolean e = a.e("a1_p_s_p_s");
                boolean e2 = a.e("a1_p_s_p_s_c_b");
                if (a.b(df.G, 1) == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.b(df.K, 0) == 1 && Engine.loadSuccess) {
                        ap apVar = new ap(this.a);
                        jSONObject.put("0", apVar.b("0"));
                        jSONObject.put("1", apVar.b("1"));
                        jSONObject.put("2", apVar.b("2"));
                        jSONObject.put("4", apVar.b("4"));
                        jSONObject.put("5", apVar.b("5"));
                        jSONObject.put("6", apVar.b("6"));
                        jSONObject.put("7", apVar.b("7"));
                        jSONObject.put("8", apVar.b("8"));
                        jSONObject.put("9", apVar.b("9"));
                        jSONObject.put("10", apVar.b("10"));
                        jSONObject.put("11", apVar.b("11"));
                        jSONObject.put("12", apVar.b("12"));
                        jSONObject.put("13", apVar.b("13"));
                        jSONObject.put("14", apVar.b("14"));
                        jSONObject.put("15", apVar.b("15"));
                        jSONObject.put("16", apVar.b("16"));
                        jSONObject.put("17", apVar.b("17"));
                        jSONObject.put("18", apVar.b("18"));
                        jSONObject.put("19", apVar.b("19"));
                        jSONObject.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, apVar.b(PayUVEventType.PAY_WALLET_BANNER_SHOW));
                        jSONObject.put("21", apVar.b("21"));
                        jSONObject.put("22", apVar.b("22"));
                        jSONObject.put("23", apVar.b("23"));
                        jSONObject.put("24", apVar.b("24"));
                        jSONObject.put("25", apVar.b("25"));
                        jSONObject.put("26", apVar.b("26"));
                        jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, apVar.b(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK));
                        jSONObject.put("28", apVar.b("28"));
                        jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK, apVar.b(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK));
                        jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK, apVar.b(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, apVar.b(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK, apVar.b(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK, apVar.b(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK, apVar.b(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, apVar.b(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK));
                        jSONObject.put("36", apVar.b("36"));
                        jSONObject.put("37", apVar.b("37"));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK, apVar.b(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK, apVar.b(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, apVar.b(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, apVar.b(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK));
                        jSONObject.put("42", apVar.b("42"));
                        jSONObject.put(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK, apVar.a(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK, apVar.a(PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK));
                        jSONObject.put(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE, apVar.b(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE));
                        jSONObject.put(WorkPostNotifyFlutterData.FAIL_POST, apVar.b(WorkPostNotifyFlutterData.FAIL_POST));
                        jSONObject.put("105", apVar.b("105"));
                        jSONObject.put("106", apVar.b("106"));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, dl.b(this.a));
                    }
                    if (a.b(df.J, 1) == 1 && Engine.loadSuccess) {
                        at atVar = new at(this.a);
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, atVar.d(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW));
                        if (atVar.a()) {
                            i4 = 1;
                            jSONObject.put("93", 1);
                        } else {
                            i4 = 1;
                        }
                        if (atVar.b()) {
                            jSONObject.put("94", i4);
                        }
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, atVar.d(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, atVar.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, atVar.b(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK));
                        i = 0;
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, atVar.a(this.a, PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, 0));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, atVar.c(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, atVar.a(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW));
                        jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, di.d());
                        jSONObject.put("78", atVar.a("78"));
                        jSONObject.put("79", atVar.a("79"));
                        az azVar = new az(this.a, 200);
                        jSONObject.put(PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK, azVar.a(PayUVEventType.PAY_AMOUNT_MORE_PAY_WAY_CLICK));
                        jSONObject.put("71", azVar.a("71"));
                        jSONObject.put("72", azVar.a("72"));
                        jSONObject.put("73", azVar.a("73"));
                        jSONObject.put("74", azVar.a("74"));
                    } else {
                        i = 0;
                    }
                    if (a.b(df.M, 1) == 1) {
                        ax axVar = new ax(this.a);
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, axVar.a(this.a, PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, 1));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, axVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, axVar.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW));
                        if (e || e2) {
                            ak akVar = new ak();
                            jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, akVar.a(this.a));
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, akVar.d(this.a));
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, akVar.c(this.a));
                            jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, akVar.b(this.a));
                            jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, akVar.e(this.a));
                            jSONObject.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, akVar.f(this.a));
                            jSONObject.put(PayUVEventType.PAY_AMOUNT_FULL_PAGE_CHANNEL_CLICK, akVar.g(this.a));
                            jSONObject.put("75", akVar.h(this.a));
                            jSONObject.put("80", ak.a());
                            jSONObject.put("85", akVar.i(this.a));
                            jSONObject.put("87", akVar.j(this.a));
                            jSONObject.put("91", akVar.k(this.a));
                            jSONObject.put("92", akVar.l(this.a));
                        }
                        jSONObject.put("64", di.a());
                    }
                    if (a.b(df.N, 1) == 1) {
                        cs csVar = new cs();
                        jSONObject.put("98", csVar.a());
                        jSONObject.put("107", csVar.b());
                        String d = am.d();
                        if (!TextUtils.isEmpty(d)) {
                            jSONObject.put("77", d);
                        }
                        jSONObject.put("104", am.c());
                        jSONObject.put("109", dl.e(this.a));
                        aj ajVar = new aj(this.a);
                        jSONObject.put("82", ajVar.h());
                        String i5 = ajVar.i();
                        if (!TextUtils.isEmpty(i5)) {
                            jSONObject.put("83", i5);
                        }
                        String j = ajVar.j();
                        if (!TextUtils.isEmpty(j)) {
                            jSONObject.put("84", j);
                        }
                        String k = ajVar.k();
                        if (!TextUtils.isEmpty(k)) {
                            jSONObject.put(AddressEditActivity.CHINA_REGION_CODE, k);
                        }
                    }
                    if (a.b(df.L, 1) == 1) {
                        au auVar = new au(this.a);
                        jSONObject.put("95", auVar.b("95"));
                        if (auVar.a()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        jSONObject.put("96", i3);
                        jSONObject.put("97", di.e());
                        try {
                            jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                            jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                            jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                        } catch (Throwable unused) {
                        }
                    }
                    if (e) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject.put("11006", i2);
                    if (e2) {
                        i = 1;
                    }
                    jSONObject.put("11029", i);
                    jSONObject.put("11002", Engine.soVersion);
                    jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                }
            } catch (Throwable unused2) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
