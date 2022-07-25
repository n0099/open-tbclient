package com.kwad.components.a.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.k;
import com.kwad.sdk.utils.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, JSONObject> Qb;
    public static boolean Qc;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String Qd;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125498105, "Lcom/kwad/components/a/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125498105, "Lcom/kwad/components/a/b/b;");
                return;
            }
        }
        Qb = new HashMap();
        Qc = true;
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, bVar, i) == null) {
            k.a(qu(), ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.ait).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setRatioCount(qv()).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.xo())));
        }
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            k.a(qu(), ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.ait).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setRatioCount(qv()).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.xo())).setFailReason(str));
        }
    }

    public static void a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65539, null, str, str2, i, str3) == null) {
            JSONObject jSONObject = Qb.get(str2);
            if (jSONObject == null) {
                currentTimeMillis = -3;
            } else {
                long optLong = jSONObject.optLong("c_loadUrl");
                if (optLong <= 0) {
                    currentTimeMillis = -2;
                } else {
                    currentTimeMillis = System.currentTimeMillis() - optLong;
                    if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                        currentTimeMillis = -1;
                    }
                }
            }
            k.a(qu(), i == 0 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setRatioCount(qv()).setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
            aV(str2);
        }
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), str3, Long.valueOf(j)}) == null) {
            k.b(qu(), i == 0 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(str2).setUrl(str).setRatioCount(qv()).setState(i).setInterval(String.valueOf((j > 60000 || j < 0) ? -1L : -1L)).setFailReason(str3));
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, str4) == null) {
            JSONObject aU = aU(str2);
            r.putValue(aU, "c_" + str3, System.currentTimeMillis());
            if (str3.equals("pageStatus")) {
                try {
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt("status");
                    String optString = jSONObject.optString("errorMsg", "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            aU.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            s(str, str2);
                        } else {
                            t(str, optString);
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                } finally {
                    aV(str2);
                }
            }
        }
    }

    public static JSONObject aU(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            JSONObject jSONObject = Qb.get(str);
            if (jSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                Qb.put(str, jSONObject2);
                return jSONObject2;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void aV(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            Qb.remove(str);
        }
    }

    public static void aW(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            JSONObject aU = aU(str);
            long qp = com.kwad.components.a.a.qo().qp();
            long currentTimeMillis = qp <= 0 ? -1L : System.currentTimeMillis() - qp;
            r.putValue(aU, "c_loadUrl", System.currentTimeMillis());
            r.putValue(aU, "c_init_interval", currentTimeMillis);
            r.putValue(aU, "c_init_state", Qc ? 1 : 2);
            Qc = false;
        }
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, str3) == null) {
            if (str3.contains("/")) {
                str3 = str3.substring(str3.lastIndexOf("/") + 1);
            }
            JSONObject aU = aU(str);
            r.putValue(aU, "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) {
            if (str3.contains("/")) {
                str3 = str3.substring(str3.lastIndexOf("/") + 1);
            }
            JSONObject aU = aU(str);
            r.putValue(aU, "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
        }
    }

    public static double qu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return 1.0d;
            }
            return d.bk(context);
        }
        return invokeV.doubleValue;
    }

    public static double qv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return 1.0d;
            }
            return 1.0d / d.bk(context);
        }
        return invokeV.doubleValue;
    }

    public static void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            JSONObject aU = aU(str);
            r.putValue(aU, "c_" + str2, System.currentTimeMillis());
        }
    }

    public static void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            a(str, str2, 1, "");
        }
    }

    public static void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            a(str, "", 0, str2);
        }
    }
}
