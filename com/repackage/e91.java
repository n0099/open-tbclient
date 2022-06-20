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
import com.repackage.d91;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends c71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d91 a;

        public a(d91 d91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d91Var;
        }

        @Override // com.repackage.c71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                d91.a aVar = new d91.a();
                aVar.a = 2;
                aVar.b = y81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0357);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.c71
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                d91.a aVar = new d91.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = d91.a.C0414a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = y81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0357);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends c71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d91 a;

        public b(d91 d91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d91Var;
        }

        @Override // com.repackage.c71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                d91.a aVar = new d91.a();
                aVar.a = 2;
                aVar.b = y81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0357);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.c71
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                d91.a aVar = new d91.a();
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
                        aVar.h = d91.a.C0414a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = y81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0357);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, d91 d91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, d91Var) == null) {
            e71 e71Var = new e71();
            l71.d(e71Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, e71Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, e71Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, e71Var);
            d71 d71Var = new d71();
            d71Var.d("appKey", bundle.get("appKey").toString());
            d71Var.d("totalAmount", bundle.get("totalAmount").toString());
            d71Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new i71().a(m71.b(), e71Var, d71Var, new b(d91Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, d91 d91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, d91Var) == null) {
            e71 e71Var = new e71();
            l71.d(e71Var);
            if (!TextUtils.isEmpty(str)) {
                e71Var.d("Cookie", "BDUSS=" + str);
            }
            d71 d71Var = new d71();
            d71Var.d("appKey", str2);
            d71Var.d("totalAmount", str3);
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
                d71Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new i71().a(m71.b(), e71Var, d71Var, new a(d91Var));
        }
    }

    public static void c(String str, e71 e71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, e71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = e71Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            e71Var.d("Cookie", str2);
            return;
        }
        e71Var.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, e71 e71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, e71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = e71Var.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            e71Var.d("Cookie", str2);
            return;
        }
        e71Var.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, e71 e71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, e71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = e71Var.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            e71Var.d("Cookie", str2);
            return;
        }
        e71Var.d("Cookie", a2 + "; " + str2);
    }
}
