package com.repackage;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pr3 {
    public static /* synthetic */ Interceptable $ic;
    public static pr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400352, "Lcom/repackage/pr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400352, "Lcom/repackage/pr3;");
                return;
            }
        }
        a = new pr3();
    }

    public pr3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static pr3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (pr3) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            w73 w73Var = new w73();
            w73Var.b = "beforeConfigRequest";
            w73Var.e = str;
            n73.g(w73Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str5 = z != null ? z.configName : "";
            String str6 = z != null ? z.targetAppPackageId : "";
            String str7 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = str;
            w73Var.g = "gbview";
            w73Var.e = str2;
            w73Var.a("gameAppkey", str3);
            w73Var.a("gamePosition", str4);
            w73Var.a("configName", str5);
            w73Var.a("targetPackageName", str6);
            w73Var.a("targetDownloadUrl", str7);
            n73.g(w73Var);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = str;
            w73Var.g = "gbview";
            w73Var.a("configName", str2);
            w73Var.a("targetPackageName", str3);
            w73Var.a("targetDownloadUrl", str4);
            if (str3.equals(xq3.a)) {
                if (oe3.F(bk2.c(), str3)) {
                    w73Var.a("isGamenowInstalled", "1");
                } else {
                    w73Var.a("isGamenowInstalled", "2");
                }
            }
            n73.g(w73Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            w73 w73Var = new w73();
            w73Var.b = "request";
            w73Var.g = "wdview";
            w73Var.a("requestStatus", str);
            w73Var.a("isFromNet", z ? "0" : "1");
            w73Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            n73.g(w73Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str7 = z != null ? z.configName : "";
            String str8 = z != null ? z.targetAppPackageId : "";
            String str9 = z != null ? z.targetAppDownloadUrl : "";
            if (!TextUtils.equals(str8, xq3.a)) {
                str6 = str9;
            }
            w73 w73Var = new w73();
            w73Var.b = str;
            w73Var.g = str2;
            w73Var.e = str3;
            w73Var.a("gameAppkey", str4);
            w73Var.a("gamePosition", str5);
            w73Var.a("configName", str7);
            w73Var.a("targetPackageName", str8);
            w73Var.a("targetDownloadUrl", str6);
            n73.g(w73Var);
        }
    }

    public void f(String str, or3 or3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, or3Var, str2, str3, str4) == null) {
            JSONObject d = ud3.d(str3);
            qr3 qr3Var = new qr3();
            qr3Var.g(or3Var);
            qr3Var.b = str;
            qr3Var.g = d.optString("from_view");
            qr3Var.e = d.optString("from_value");
            qr3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            qr3Var.a("targetPackageName", str2);
            qr3Var.a("targetDownloadUrl", str4);
            n73.g(qr3Var);
        }
    }

    public void g(String str, or3 or3Var, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, or3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = ud3.d(str3);
            long optLong = d.optLong("download_finish_time");
            long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
            qr3 qr3Var = new qr3();
            qr3Var.g(or3Var);
            qr3Var.e = d.optString("from_value");
            qr3Var.b = str;
            qr3Var.g = d.optString("from_view");
            qr3Var.a("error_code", Integer.valueOf(i));
            qr3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (elapsedRealtime != 0) {
                qr3Var.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
            }
            qr3Var.a("targetPackageName", str2);
            qr3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                qr3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                qr3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                qr3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            n73.x("936", qr3Var);
        }
    }

    public void h(String str, or3 or3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, or3Var, str2, str3, str4) == null) {
            g(str, or3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = "guideClick";
            w73Var.g = "wdview";
            w73Var.a("guideViewNum", String.valueOf(i));
            w73Var.a("configName", str);
            w73Var.a("targetPackageName", str2);
            w73Var.a("targetDownloadUrl", str3);
            n73.g(w73Var);
        }
    }

    public void j(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = "wdDialogClick";
            w73Var.g = "wdview";
            w73Var.e = str;
            w73Var.a("coinsThisTime", String.valueOf(i));
            w73Var.a("coinsTotal", String.valueOf(i2));
            w73Var.a("configName", str2);
            w73Var.a("targetPackageName", str3);
            w73Var.a("targetDownloadUrl", str4);
            n73.g(w73Var);
        }
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = "wdDialogShow";
            w73Var.g = "wdview";
            w73Var.a("coinsThisTime", String.valueOf(i));
            w73Var.a("coinsTotal", String.valueOf(i2));
            w73Var.a("configName", str);
            w73Var.a("targetPackageName", str2);
            w73Var.a("targetDownloadUrl", str3);
            if (str2.equals(xq3.a)) {
                if (oe3.F(bk2.c(), str2)) {
                    w73Var.a("isGamenowInstalled", "1");
                } else {
                    w73Var.a("isGamenowInstalled", "2");
                }
            }
            n73.g(w73Var);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.b = "guideShow";
            w73Var.g = "wdview";
            w73Var.a("configName", str);
            w73Var.a("targetPackageName", str2);
            w73Var.a("targetDownloadUrl", str3);
            n73.g(w73Var);
        }
    }

    public void m(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = sq3.o.z();
            String str3 = z != null ? z.configName : "";
            String str4 = z != null ? z.targetAppPackageId : "";
            String str5 = z != null ? z.targetAppDownloadUrl : "";
            w73 w73Var = new w73();
            w73Var.g = str;
            w73Var.e = str2;
            w73Var.a("configName", str3);
            w73Var.a("targetPackageName", str4);
            w73Var.a("targetDownloadUrl", str5);
            w73Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            n73.g(w73Var);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            kz1.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = kx3.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", bk2.h0().i(bk2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", bk2.n().a());
                jSONObject.put("version", oe3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) w74.h(bk2.c()).postRequest().cookieManager(bk2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = kx3.b().d();
            JSONObject jSONObject = new JSONObject();
            String str4 = TextUtils.equals(str, xq3.a) ? "2101000000" : "";
            sq3 sq3Var = sq3.o;
            if (sq3Var != null && sq3Var.z() != null && !TextUtils.isEmpty(sq3.o.z().gamenowChannel)) {
                str4 = sq3.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j);
                jSONObject.put("totalBytes", j2);
                jSONObject.put("errorReason", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) w74.h(bk2.c()).postRequest().cookieManager(bk2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
