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
import com.repackage.r91;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r91 a;

        public a(r91 r91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r91Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                r91.a aVar = new r91.a();
                aVar.a = 2;
                aVar.b = m91.a().getResources().getString(R.string.obfuscated_res_0x7f0f035b);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                r91.a aVar = new r91.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = r91.a.C0568a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = m91.a().getResources().getString(R.string.obfuscated_res_0x7f0f035b);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r91 a;

        public b(r91 r91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r91Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                r91.a aVar = new r91.a();
                aVar.a = 2;
                aVar.b = m91.a().getResources().getString(R.string.obfuscated_res_0x7f0f035b);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                r91.a aVar = new r91.a();
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
                        aVar.h = r91.a.C0568a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = m91.a().getResources().getString(R.string.obfuscated_res_0x7f0f035b);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, r91 r91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, r91Var) == null) {
            s71 s71Var = new s71();
            z71.d(s71Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, s71Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, s71Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, s71Var);
            r71 r71Var = new r71();
            r71Var.d("appKey", bundle.get("appKey").toString());
            r71Var.d("totalAmount", bundle.get("totalAmount").toString());
            r71Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new w71().a(a81.b(), s71Var, r71Var, new b(r91Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, r91 r91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, r91Var) == null) {
            s71 s71Var = new s71();
            z71.d(s71Var);
            if (!TextUtils.isEmpty(str)) {
                s71Var.d("Cookie", "BDUSS=" + str);
            }
            r71 r71Var = new r71();
            r71Var.d("appKey", str2);
            r71Var.d("totalAmount", str3);
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
                r71Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new w71().a(a81.b(), s71Var, r71Var, new a(r91Var));
        }
    }

    public static void c(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, s71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = s71Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            s71Var.d("Cookie", str2);
            return;
        }
        s71Var.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, s71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = s71Var.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            s71Var.d("Cookie", str2);
            return;
        }
        s71Var.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, s71Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = s71Var.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            s71Var.d("Cookie", str2);
            return;
        }
        s71Var.d("Cookie", a2 + "; " + str2);
    }
}
