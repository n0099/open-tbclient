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
import com.repackage.ek2;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638680, "Lcom/repackage/hr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638680, "Lcom/repackage/hr3;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(String str, String str2, String str3, String str4, fr3 fr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, fr3Var) == null) {
            String l = gr3.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (a) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            gr3 gr3Var = new gr3();
            gr3Var.m(fr3Var);
            gr3Var.b = l;
            gr3Var.e = str3;
            gr3Var.v = str;
            gr3Var.l = bd3.D();
            if (hz2.a0() != null) {
                ek2.a V = hz2.a0().V();
                gr3Var.a = a63.n(V.G());
                gr3Var.f = V.H();
                gr3Var.c = V.T();
            }
            gr3Var.t = str4;
            a63.x("1245", gr3Var);
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
            String l = gr3.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            gr3 gr3Var = new gr3();
            gr3Var.b = l;
            gr3Var.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            gr3Var.a("packageName", str3);
            a63.x("1245", gr3Var);
        }
    }

    public static void d(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = xv3.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", oi2.h0().i(oi2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", oi2.n().a());
                jSONObject.put("version", bd3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) j64.h(oi2.c()).postRequest().cookieManager(oi2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
