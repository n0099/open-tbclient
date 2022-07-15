package com.kwad.components.a.b;

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
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, JSONObject> a;
    public static boolean b;
    public static Boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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
        a = new HashMap();
        b = true;
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, bVar, i) == null) || a()) {
            return;
        }
        k.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.a).setH5Version(bVar.f).setLoadType(bVar.h).setState(i).setPackageUrl(bVar.e).setInterval(String.valueOf(System.currentTimeMillis() - bVar.a())));
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bVar, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) || a()) {
            return;
        }
        k.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.a).setH5Version(bVar.f).setLoadType(bVar.h).setState(0).setPackageUrl(bVar.e).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.a())).setFailReason(str));
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || a()) {
            return;
        }
        JSONObject b2 = b(str);
        long b3 = com.kwad.components.a.a.a().b();
        long currentTimeMillis = b3 <= 0 ? -1L : System.currentTimeMillis() - b3;
        r.a(b2, "c_loadUrl", System.currentTimeMillis());
        r.a(b2, "c_init_interval", currentTimeMillis);
        r.a(b2, "c_init_state", b ? 1 : 2);
        b = false;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || a()) {
            return;
        }
        JSONObject b2 = b(str);
        r.a(b2, "c_" + str2, System.currentTimeMillis());
    }

    public static void a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65541, null, str, str2, i, str3) == null) {
            if (a()) {
                c(str2);
                return;
            }
            JSONObject jSONObject = a.get(str2);
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
            k.a(i == 0 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
            c(str2);
        }
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, str2, Integer.valueOf(i), str3, Long.valueOf(j)}) == null) || a()) {
            return;
        }
        k.b(i == 0 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf((j > 60000 || j < 0) ? -1L : -1L)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, str, str2, str3) == null) || a()) {
            return;
        }
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject b2 = b(str);
        r.a(b2, "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65544, null, str, str2, str3, str4) == null) || a()) {
            return;
        }
        JSONObject b2 = b(str2);
        r.a(b2, "c_" + str3, System.currentTimeMillis());
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
                        b2.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (optInt == 1) {
                        c(str, str2);
                    } else {
                        b(str, optString);
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            } finally {
                c(str2);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (c == null) {
                c = Boolean.valueOf(new Random().nextFloat() < d.j(KsAdSDKImpl.get().getContext()));
            }
            return !c.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            JSONObject jSONObject = a.get(str);
            if (jSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                a.put(str, jSONObject2);
                return jSONObject2;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) || a()) {
            return;
        }
        a(str, "", 0, str2);
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65548, null, str, str2, str3) == null) || a()) {
            return;
        }
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject b2 = b(str);
        r.a(b2, "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            a.remove(str);
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) || a()) {
            return;
        }
        a(str, str2, 1, "");
    }
}
