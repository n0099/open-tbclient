package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s81;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s81 a;

        public a(s81 s81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s81Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                s81.a aVar = new s81.a();
                aVar.a = 2;
                aVar.b = n81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                s81.a aVar = new s81.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = s81.a.C0515a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = n81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s81 a;

        public b(s81 s81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s81Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                s81.a aVar = new s81.a();
                aVar.a = 2;
                aVar.b = n81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                s81.a aVar = new s81.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.e = optJSONObject.optLong("reduceAmount");
                        aVar.g = optJSONObject.optInt("overdueStatus");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = s81.a.C0515a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = n81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, s81 s81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, s81Var) == null) {
            t61 t61Var = new t61();
            a71.d(t61Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, t61Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, t61Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, t61Var);
            s61 s61Var = new s61();
            s61Var.d("appKey", bundle.get("appKey").toString());
            s61Var.d("totalAmount", bundle.get("totalAmount").toString());
            s61Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new x61().a(b71.b(), t61Var, s61Var, new b(s81Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, s81 s81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, s81Var) == null) {
            t61 t61Var = new t61();
            a71.d(t61Var);
            if (!TextUtils.isEmpty(str)) {
                t61Var.d("Cookie", "BDUSS=" + str);
            }
            s61 s61Var = new s61();
            s61Var.d("appKey", str2);
            s61Var.d("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                s61Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new x61().a(b71.b(), t61Var, s61Var, new a(s81Var));
        }
    }

    public static void c(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, t61Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = t61Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            t61Var.d("Cookie", str2);
            return;
        }
        t61Var.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, t61Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = t61Var.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            t61Var.d("Cookie", str2);
            return;
        }
        t61Var.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, t61Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = t61Var.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            t61Var.d("Cookie", str2);
            return;
        }
        t61Var.d("Cookie", a2 + "; " + str2);
    }
}
