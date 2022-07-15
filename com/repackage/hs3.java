package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import com.repackage.el2;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hs3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755637719, "Lcom/repackage/hs3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755637719, "Lcom/repackage/hs3;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(String str, String str2, String str3, String str4, fs3 fs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, fs3Var) == null) {
            String l = gs3.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (a) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            gs3 gs3Var = new gs3();
            gs3Var.m(fs3Var);
            gs3Var.b = l;
            gs3Var.e = str3;
            gs3Var.v = str;
            gs3Var.l = be3.D();
            if (h03.b0() != null) {
                el2.a W = h03.b0().W();
                gs3Var.a = a73.n(W.G());
                gs3Var.f = W.H();
                gs3Var.c = W.T();
            }
            gs3Var.t = str4;
            a73.x("1245", gs3Var);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            c(str, str2, "");
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            String l = gs3.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            gs3 gs3Var = new gs3();
            gs3Var.b = l;
            gs3Var.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            gs3Var.a("packageName", str3);
            a73.x("1245", gs3Var);
        }
    }

    public static void d(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = xw3.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", oj2.h0().i(oj2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", oj2.n().a());
                jSONObject.put("version", be3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) j74.h(oj2.c()).postRequest().cookieManager(oj2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
