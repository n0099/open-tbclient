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
/* loaded from: classes5.dex */
public class dr3 {
    public static /* synthetic */ Interceptable $ic;
    public static dr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755757844, "Lcom/repackage/dr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755757844, "Lcom/repackage/dr3;");
                return;
            }
        }
        a = new dr3();
    }

    public dr3() {
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

    public static dr3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (dr3) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            k73 k73Var = new k73();
            k73Var.b = "beforeConfigRequest";
            k73Var.e = str;
            b73.g(k73Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str5 = z != null ? z.configName : "";
            String str6 = z != null ? z.targetAppPackageId : "";
            String str7 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = str;
            k73Var.g = "gbview";
            k73Var.e = str2;
            k73Var.a("gameAppkey", str3);
            k73Var.a("gamePosition", str4);
            k73Var.a("configName", str5);
            k73Var.a("targetPackageName", str6);
            k73Var.a("targetDownloadUrl", str7);
            b73.g(k73Var);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = str;
            k73Var.g = "gbview";
            k73Var.a("configName", str2);
            k73Var.a("targetPackageName", str3);
            k73Var.a("targetDownloadUrl", str4);
            if (str3.equals(lq3.a)) {
                if (ce3.F(pj2.c(), str3)) {
                    k73Var.a("isGamenowInstalled", "1");
                } else {
                    k73Var.a("isGamenowInstalled", "2");
                }
            }
            b73.g(k73Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            k73 k73Var = new k73();
            k73Var.b = "request";
            k73Var.g = "wdview";
            k73Var.a("requestStatus", str);
            k73Var.a("isFromNet", z ? "0" : "1");
            k73Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            b73.g(k73Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str7 = z != null ? z.configName : "";
            String str8 = z != null ? z.targetAppPackageId : "";
            String str9 = z != null ? z.targetAppDownloadUrl : "";
            if (!TextUtils.equals(str8, lq3.a)) {
                str6 = str9;
            }
            k73 k73Var = new k73();
            k73Var.b = str;
            k73Var.g = str2;
            k73Var.e = str3;
            k73Var.a("gameAppkey", str4);
            k73Var.a("gamePosition", str5);
            k73Var.a("configName", str7);
            k73Var.a("targetPackageName", str8);
            k73Var.a("targetDownloadUrl", str6);
            b73.g(k73Var);
        }
    }

    public void f(String str, cr3 cr3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, cr3Var, str2, str3, str4) == null) {
            JSONObject d = id3.d(str3);
            er3 er3Var = new er3();
            er3Var.g(cr3Var);
            er3Var.b = str;
            er3Var.g = d.optString("from_view");
            er3Var.e = d.optString("from_value");
            er3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            er3Var.a("targetPackageName", str2);
            er3Var.a("targetDownloadUrl", str4);
            b73.g(er3Var);
        }
    }

    public void g(String str, cr3 cr3Var, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, cr3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = id3.d(str3);
            long optLong = d.optLong("download_finish_time");
            long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
            er3 er3Var = new er3();
            er3Var.g(cr3Var);
            er3Var.e = d.optString("from_value");
            er3Var.b = str;
            er3Var.g = d.optString("from_view");
            er3Var.a("error_code", Integer.valueOf(i));
            er3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (elapsedRealtime != 0) {
                er3Var.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
            }
            er3Var.a("targetPackageName", str2);
            er3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                er3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                er3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                er3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            b73.x("936", er3Var);
        }
    }

    public void h(String str, cr3 cr3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, cr3Var, str2, str3, str4) == null) {
            g(str, cr3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = "guideClick";
            k73Var.g = "wdview";
            k73Var.a("guideViewNum", String.valueOf(i));
            k73Var.a("configName", str);
            k73Var.a("targetPackageName", str2);
            k73Var.a("targetDownloadUrl", str3);
            b73.g(k73Var);
        }
    }

    public void j(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = "wdDialogClick";
            k73Var.g = "wdview";
            k73Var.e = str;
            k73Var.a("coinsThisTime", String.valueOf(i));
            k73Var.a("coinsTotal", String.valueOf(i2));
            k73Var.a("configName", str2);
            k73Var.a("targetPackageName", str3);
            k73Var.a("targetDownloadUrl", str4);
            b73.g(k73Var);
        }
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = "wdDialogShow";
            k73Var.g = "wdview";
            k73Var.a("coinsThisTime", String.valueOf(i));
            k73Var.a("coinsTotal", String.valueOf(i2));
            k73Var.a("configName", str);
            k73Var.a("targetPackageName", str2);
            k73Var.a("targetDownloadUrl", str3);
            if (str2.equals(lq3.a)) {
                if (ce3.F(pj2.c(), str2)) {
                    k73Var.a("isGamenowInstalled", "1");
                } else {
                    k73Var.a("isGamenowInstalled", "2");
                }
            }
            b73.g(k73Var);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.b = "guideShow";
            k73Var.g = "wdview";
            k73Var.a("configName", str);
            k73Var.a("targetPackageName", str2);
            k73Var.a("targetDownloadUrl", str3);
            b73.g(k73Var);
        }
    }

    public void m(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = gq3.o.z();
            String str3 = z != null ? z.configName : "";
            String str4 = z != null ? z.targetAppPackageId : "";
            String str5 = z != null ? z.targetAppDownloadUrl : "";
            k73 k73Var = new k73();
            k73Var.g = str;
            k73Var.e = str2;
            k73Var.a("configName", str3);
            k73Var.a("targetPackageName", str4);
            k73Var.a("targetDownloadUrl", str5);
            k73Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            b73.g(k73Var);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            yy1.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = yw3.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", pj2.h0().i(pj2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", pj2.n().a());
                jSONObject.put("version", ce3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) k74.h(pj2.c()).postRequest().cookieManager(pj2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = yw3.b().d();
            JSONObject jSONObject = new JSONObject();
            String str4 = TextUtils.equals(str, lq3.a) ? "2101000000" : "";
            gq3 gq3Var = gq3.o;
            if (gq3Var != null && gq3Var.z() != null && !TextUtils.isEmpty(gq3.o.z().gamenowChannel)) {
                str4 = gq3.o.z().gamenowChannel;
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
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) k74.h(pj2.c()).postRequest().cookieManager(pj2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
