package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public k2(Context context) {
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
        String str;
        String str2;
        JSONObject g;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                i a = i.a(this.a, "re_po_rt");
                boolean b = a.b("a1_p_s_p_s");
                boolean b2 = a.b("a1_p_s_p_s_c_b");
                if (a.a(f3.G, 1) == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.a(f3.K, 1) == 1 && Engine.loadSuccess) {
                        q0 q0Var = new q0(this.a);
                        jSONObject.put("0", q0Var.a("0"));
                        jSONObject.put("1", q0Var.a("1"));
                        jSONObject.put("2", q0Var.a("2"));
                        jSONObject.put("3", q0Var.a("3"));
                        jSONObject.put("4", q0Var.a("4"));
                        jSONObject.put("5", q0Var.a("5"));
                        jSONObject.put("6", q0Var.a("6"));
                        jSONObject.put("7", q0Var.a("7"));
                        jSONObject.put("8", q0Var.a("8"));
                        jSONObject.put("9", q0Var.a("9"));
                        jSONObject.put("10", q0Var.a("10"));
                        jSONObject.put("11", q0Var.a("11"));
                        jSONObject.put("12", q0Var.a("12"));
                        jSONObject.put("13", q0Var.a("13"));
                        jSONObject.put("14", q0Var.a("14"));
                        jSONObject.put("15", q0Var.a("15"));
                        jSONObject.put("16", q0Var.a("16"));
                        jSONObject.put("17", q0Var.a("17"));
                        jSONObject.put("18", q0Var.a("18"));
                        jSONObject.put("19", q0Var.a("19"));
                        jSONObject.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, q0Var.a(PayUVEventType.PAY_WALLET_BANNER_SHOW));
                        jSONObject.put("21", q0Var.a("21"));
                        jSONObject.put("22", q0Var.a("22"));
                        jSONObject.put("23", q0Var.a("23"));
                        jSONObject.put("24", q0Var.a("24"));
                        jSONObject.put("25", q0Var.a("25"));
                        jSONObject.put("26", q0Var.a("26"));
                        jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, q0Var.a(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK));
                        jSONObject.put("28", q0Var.a("28"));
                        jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK, q0Var.a(PayUVEventType.THIRD_PAY_WAY_DIALOG_COMFIRM_BTN_CLICK));
                        jSONObject.put(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK, q0Var.a(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, q0Var.a(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK, q0Var.a(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK, q0Var.a(PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK, q0Var.a(PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, q0Var.a(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK));
                        jSONObject.put("36", q0Var.a("36"));
                        jSONObject.put("37", q0Var.a("37"));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK, q0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK, q0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, q0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, q0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK));
                        jSONObject.put("42", q0Var.a("42"));
                        jSONObject.put(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK, q0Var.b(PayUVEventType.PAY_WAY_DIALOG_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK, q0Var.b(PayUVEventType.PAY_WAY_FULL_PAGE_CLOSE_BTN_CLICK));
                        jSONObject.put("101", q0Var.a("101"));
                        jSONObject.put("102", q0Var.a("102"));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, q0Var.a(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, q0Var.a(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, l3.b(this.a));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, l3.a(this.a));
                    }
                    if (a.a(f3.J, 1) == 1 && Engine.loadSuccess) {
                        v0 v0Var = new v0(this.a);
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, v0Var.b(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW));
                        if (v0Var.b()) {
                            i = 1;
                            jSONObject.put(BaseUtils.METHOD_RECEIVEESSAGE, 1);
                        } else {
                            i = 1;
                        }
                        if (v0Var.a()) {
                            jSONObject.put(HttpConfig.UBC_HTTP_ID, i);
                        }
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK, v0Var.b(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, v0Var.d(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, v0Var.a(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, v0Var.a(this.a, PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, 0));
                        jSONObject.put("55", v0Var.c("55"));
                        jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, v0Var.d(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW));
                        jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, i3.c());
                        jSONObject.put("78", v0Var.d("78"));
                        jSONObject.put("79", v0Var.d("79"));
                        z0 z0Var = new z0(this.a, 200);
                        jSONObject.put("70", z0Var.a("70"));
                        jSONObject.put("71", z0Var.a("71"));
                        jSONObject.put("72", z0Var.a("72"));
                        jSONObject.put("73", z0Var.a("73"));
                        jSONObject.put("74", z0Var.a("74"));
                    }
                    if (a.a(f3.M, 1) == 1) {
                        x0 x0Var = new x0(this.a);
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, x0Var.a(this.a, PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW, 1));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK, x0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_AMOUNT_ITEM_CLICK));
                        jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW, x0Var.a(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_PAGE_SHOW));
                        if (b || b2) {
                            k0 k0Var = new k0();
                            jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_LINK_ITEM_CLICK, k0Var.i(this.a));
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, k0Var.j(this.a));
                            jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, k0Var.h(this.a));
                            jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, k0Var.b(this.a));
                            jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, k0Var.k(this.a));
                            jSONObject.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, k0Var.l(this.a));
                            jSONObject.put("69", k0Var.g(this.a));
                            jSONObject.put("75", k0Var.a(this.a));
                            jSONObject.put("80", k0.a());
                            jSONObject.put("85", k0Var.d(this.a));
                            jSONObject.put("87", k0Var.f(this.a));
                            jSONObject.put("91", k0Var.c(this.a));
                            jSONObject.put("92", k0Var.e(this.a));
                        }
                        jSONObject.put("64", i3.a());
                    }
                    if (a.a(f3.N, 1) == 1) {
                        t2 t2Var = new t2();
                        jSONObject.put("98", t2Var.a());
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, t2Var.b());
                        String d = n0.d();
                        if (!TextUtils.isEmpty(d)) {
                            jSONObject.put("77", d);
                        }
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE, n0.c());
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, l3.c(this.a));
                        j0 j0Var = new j0(this.a);
                        jSONObject.put("82", j0Var.d());
                        String b3 = j0Var.b();
                        if (!TextUtils.isEmpty(b3)) {
                            jSONObject.put("83", b3);
                        }
                        String c = j0Var.c();
                        if (!TextUtils.isEmpty(c)) {
                            jSONObject.put("84", c);
                        }
                        String f = j0Var.f();
                        if (!TextUtils.isEmpty(f)) {
                            jSONObject.put(AddressEditActivity.CHINA_REGION_CODE, f);
                        }
                    }
                    if (a.a(f3.L, 1) == 1) {
                        u0 u0Var = new u0(this.a);
                        jSONObject.put("95", u0Var.a("95"));
                        jSONObject.put("96", u0Var.a() ? 1 : 0);
                        jSONObject.put("97", i3.d());
                        try {
                            jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                            jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                            jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        if (i.a(this.a, "re_po_rt").a(f3.D0, 1) == 1) {
                            JSONObject c2 = new b1(this.a, 100, Environment.getExternalStorageDirectory().getAbsolutePath(), b1.a(this.a)).c();
                            if (c2 == null || c2.length() <= 10) {
                                str = "16102";
                                str2 = new b1(this.a, 200, "", true).a(str);
                            } else {
                                str = "16002";
                                str2 = c2;
                            }
                            jSONObject.put(str, str2);
                            if ((b || b2) && (g = g1.g(this.a)) != null && g.length() > 0) {
                                jSONObject.put("16116", g);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("11006", b ? 1 : 0);
                    jSONObject.put("11029", b2 ? 1 : 0);
                    jSONObject.put("11002", Engine.soVersion);
                    jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                }
            } catch (Throwable unused3) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
