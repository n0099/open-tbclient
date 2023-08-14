package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.baidu.tieba.tpb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        b0 b0Var;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            String replace = "{url}/getPublicKey?keytype=2".replace("{url}", c.f(str, str2));
            String f = b.f();
            HashMap hashMap = new HashMap();
            hashMap.put("App-Id", f);
            try {
                b0Var = a0.a(replace, new byte[0], hashMap);
            } catch (Exception e) {
                y.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
                b0Var = null;
            }
            if (b0Var == null) {
                str3 = "get pubKey response is null";
            } else if (b0Var.b() == 200) {
                if (TextUtils.isEmpty(b0Var.a())) {
                    return;
                }
                c(b0Var.a(), str2);
                return;
            } else {
                str3 = "get pubKey fail HttpCode :" + b0Var.b();
            }
            y.e("GetPublicKey", str3);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String a = b.a();
            if (TextUtils.isEmpty(a)) {
                a = g0.a(b.i(), "Privacy_MY", "public_key_time_interval", "");
                b.f(a);
            }
            String m = b.m();
            if (TextUtils.isEmpty(m)) {
                m = g0.a(b.i(), "Privacy_MY", "public_key_time_last", "");
                b.c(m);
            }
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(m)) {
                return true;
            }
            try {
                return System.currentTimeMillis() - Long.parseLong(m) > ((long) Integer.parseInt(a));
            } catch (NumberFormatException e) {
                y.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            String c = b.c();
            if (TextUtils.isEmpty(c)) {
                c = g0.a(b.i(), "Privacy_MY", "public_key_version", "");
                b.g(c);
            }
            if ("maint".equals(str2)) {
                o = b.n();
                if (TextUtils.isEmpty(o)) {
                    o = tpb.d("HiAnalytics_Sdk_Public_Sp_Key", g0.a(b.i(), "Privacy_MY", "public_key_maint", ""));
                    b.d(o);
                }
            } else {
                o = b.o();
                if (TextUtils.isEmpty(o)) {
                    o = tpb.d("HiAnalytics_Sdk_Public_Sp_Key", g0.a(b.i(), "Privacy_MY", "public_key_oper", ""));
                    b.e(o);
                }
            }
            if (TextUtils.isEmpty(o) || TextUtils.isEmpty(c) || a()) {
                o0.a().a(new m0(str, str2));
                return null;
            }
            return o;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("publicKey");
                String optString2 = jSONObject.optString("publicKeyOM");
                String optString3 = jSONObject.optString("pubkey_version");
                String str3 = System.currentTimeMillis() + "";
                String optString4 = jSONObject.optString("timeInterval");
                g0.b(b.i(), "Privacy_MY", "public_key_oper", tpb.g("HiAnalytics_Sdk_Public_Sp_Key", optString));
                g0.b(b.i(), "Privacy_MY", "public_key_maint", tpb.g("HiAnalytics_Sdk_Public_Sp_Key", optString2));
                g0.b(b.i(), "Privacy_MY", "public_key_time_interval", optString4);
                g0.b(b.i(), "Privacy_MY", "public_key_version", optString3);
                g0.b(b.i(), "Privacy_MY", "public_key_time_last", str3);
                b.e(optString);
                b.d(optString2);
                b.g(optString3);
                b.c(str3);
                b.f(optString4);
            } catch (JSONException e) {
                y.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
            }
        }
    }
}
