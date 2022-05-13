package com.repackage;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;

        public a(w73 w73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755902955, "Lcom/repackage/a83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755902955, "Lcom/repackage/a83;");
                return;
            }
        }
        a = eh1.a;
    }

    public static String a(Response response) {
        InterceptResult invokeL;
        ResponseBody body;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, response)) == null) {
            if (response == null || (body = response.body()) == null) {
                return "";
            }
            JSONObject jSONObject = null;
            try {
                str = body.string();
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                }
                str = null;
            }
            if (str == null) {
                return "";
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject == null ? "" : jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) || TextUtils.equals(str, "getLocation")) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        c02 H;
        an1 n3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            w73 w73Var = new w73();
            u03 a0 = u03.a0();
            if (a0 == null || (H = hm2.U().H()) == null || (n3 = H.n3()) == null) {
                return;
            }
            String o = n3.o();
            rl2.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            String W = V.W();
            String v1 = V.v1();
            String i3 = z93.i(hm2.U().M(), V.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            w73Var.a = n73.n(V.G());
            w73Var.c = a0.V().T();
            w73Var.d = a0.V().V();
            w73Var.f = appId;
            w73Var.a("name", Y);
            w73Var.a("apiName", str);
            w73Var.a("errorCode", String.valueOf(i));
            w73Var.a("errorMsg", str2);
            w73Var.a("pagePath", o);
            if (i2 != -1) {
                w73Var.a("oldErrorCode", String.valueOf(i2));
            }
            w73Var.a("oldErrorMsg", str3);
            w73Var.a("scheme", W);
            w73Var.a("appVersion", v1);
            w73Var.a("swan", i3);
            w73Var.a(BaseJsonData.TAG_REQUESTID, a2);
            w73Var.a("net", d);
            if (d84.b() != null) {
                w73Var.a("SDKVersion", d84.b().b());
                w73Var.a("hostName", d84.b().c());
            }
            od3.j(new a(w73Var), "monitor");
        }
    }
}
