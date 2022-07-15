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
import com.repackage.el2;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class n73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j73 a;

        public a(j73 j73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o63.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755516633, "Lcom/repackage/n73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755516633, "Lcom/repackage/n73;");
                return;
            }
        }
        a = rg1.a;
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
        pz1 H;
        nm1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            j73 j73Var = new j73();
            h03 b0 = h03.b0();
            if (b0 == null || (H = ul2.U().H()) == null || (o3 = H.o3()) == null) {
                return;
            }
            String n = o3.n();
            el2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = m93.i(ul2.U().M(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            j73Var.a = a73.n(W.G());
            j73Var.c = b0.W().T();
            j73Var.d = b0.W().V();
            j73Var.f = appId;
            j73Var.a("name", Z);
            j73Var.a("apiName", str);
            j73Var.a("errorCode", String.valueOf(i));
            j73Var.a("errorMsg", str2);
            j73Var.a("pagePath", n);
            if (i2 != -1) {
                j73Var.a("oldErrorCode", String.valueOf(i2));
            }
            j73Var.a("oldErrorMsg", str3);
            j73Var.a("scheme", W2);
            j73Var.a("appVersion", v1);
            j73Var.a("swan", i3);
            j73Var.a(BaseJsonData.TAG_REQUESTID, a2);
            j73Var.a("net", d);
            if (q74.b() != null) {
                j73Var.a("SDKVersion", q74.b().b());
                j73Var.a("hostName", q74.b().c());
            }
            bd3.j(new a(j73Var), "monitor");
        }
    }
}
