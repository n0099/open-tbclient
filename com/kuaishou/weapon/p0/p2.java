package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class p2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public p2(Context context) {
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

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    private JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                System.currentTimeMillis();
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
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK, c0.a() ? 1 : 0);
                jSONObject.put("36", c0.a(this.a) ? 1 : 0);
                Object a2 = i0.a(this.a);
                if (a2 != null) {
                    jSONObject.put("4", a2);
                }
                if (a.a(f3.c0, 0) == 1 && (b || b2)) {
                    jSONObject.put("25", m0.a(this.a) ? 1 : 0);
                }
                d0 d0Var = new d0();
                jSONObject.put("7", d0Var.a() ? 1 : 0);
                boolean d = d0Var.d(this.a);
                jSONObject.put("8", d ? 1 : 0);
                if (d) {
                    jSONObject.put(PayUVEventType.PAY_SIGN_DIALOG_SHOW, d0Var.c(this.a));
                }
                jSONObject.put("10", d0Var.f(this.a));
                jSONObject.put("11", d0Var.b(this.a));
                f0 f0Var = new f0();
                jSONObject.put("26", f0Var.a("cpuinfo") ? 1 : 0);
                jSONObject.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, f0Var.a("meminfo") ? 1 : 0);
                o0 o0Var = new o0();
                jSONObject.put(PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, o0Var.f() ? 1 : 0);
                boolean e = o0Var.e();
                jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, e ? 1 : 0);
                if (e) {
                    jSONObject.put(PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_CLICK, o0Var.g() ? 1 : 0);
                }
                jSONObject.put("68", o0Var.c() ? 1 : 0);
                jSONObject.put("69", o0Var.b());
                jSONObject.put("101", o0Var.d() ? 1 : 0);
                jSONObject.put("102", o0Var.a() ? 1 : 0);
                jSONObject.put("99", new g0().a());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", v1.c(this.a));
                jSONObject2.put("03014", h1.B(this.a));
                jSONObject2.put("03020", v1.a(this.a));
                jSONObject2.put("03030", g1.f(this.a));
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_LINK_ITEM_CLICK, jSONObject2);
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, new p0().b());
                jSONObject.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, c0.b(this.a) ? 1 : 0);
                try {
                    jSONObject.put("11028", WeaponHI.sKSSdkver);
                    jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                    jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                    jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                    jSONObject.put("11002", Engine.soVersion);
                } catch (Throwable unused) {
                }
                return jSONObject;
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String hostAddress = InetAddress.getByName(l3.a(str)).getHostAddress();
                try {
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (hostAddress.contains(".")) {
                            return hostAddress;
                        }
                    }
                    return "";
                } catch (UnknownHostException unused) {
                    return hostAddress;
                }
            } catch (UnknownHostException unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        JSONObject a;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                n2 n2Var = new n2(str, l2.j);
                String a3 = l3.a(v2.a);
                String a4 = a(a3);
                if (TextUtils.isEmpty(a4) || (a = n2Var.a(this.a)) == null) {
                    return null;
                }
                String str2 = v2.h + "?" + w2.d(this.a);
                if (v2.b() && v2.a.contains("api")) {
                    str2 = "/api" + str2;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", a4);
                jSONObject.put("host", a3);
                jSONObject.put("path", str2);
                String str3 = WeaponHI.cookieData;
                if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                    jSONObject.put("cookie", str3);
                }
                jSONObject.put("head", a);
                StringBuilder sb = new StringBuilder();
                sb.append("sdk=" + Build.VERSION.SDK_INT);
                jSONObject.put("parame", sb.toString());
                if (str.equals(l2.h) && (a2 = a()) != null) {
                    jSONObject.put("sjd", a2);
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
