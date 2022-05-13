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
import com.repackage.fa1;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ga1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa1 a;

        public a(fa1 fa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa1Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                fa1.a aVar = new fa1.a();
                aVar.a = 2;
                aVar.b = aa1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0365);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                fa1.a aVar = new fa1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = fa1.a.C0412a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = aa1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0365);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa1 a;

        public b(fa1 fa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fa1Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                fa1.a aVar = new fa1.a();
                aVar.a = 2;
                aVar.b = aa1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0365);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                fa1.a aVar = new fa1.a();
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
                        aVar.h = fa1.a.C0412a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = aa1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0365);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, fa1 fa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, fa1Var) == null) {
            g81 g81Var = new g81();
            n81.d(g81Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, g81Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, g81Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, g81Var);
            f81 f81Var = new f81();
            f81Var.d("appKey", bundle.get("appKey").toString());
            f81Var.d("totalAmount", bundle.get("totalAmount").toString());
            f81Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new k81().a(o81.b(), g81Var, f81Var, new b(fa1Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, fa1 fa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, fa1Var) == null) {
            g81 g81Var = new g81();
            n81.d(g81Var);
            if (!TextUtils.isEmpty(str)) {
                g81Var.d("Cookie", "BDUSS=" + str);
            }
            f81 f81Var = new f81();
            f81Var.d("appKey", str2);
            f81Var.d("totalAmount", str3);
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
                f81Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new k81().a(o81.b(), g81Var, f81Var, new a(fa1Var));
        }
    }

    public static void c(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, g81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = g81Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            g81Var.d("Cookie", str2);
            return;
        }
        g81Var.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, g81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = g81Var.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            g81Var.d("Cookie", str2);
            return;
        }
        g81Var.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, g81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = g81Var.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            g81Var.d("Cookie", str2);
            return;
        }
        g81Var.d("Cookie", a2 + "; " + str2);
    }
}
