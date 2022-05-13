package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d02 V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = hm2.U().V()) == null) {
                return;
            }
            d02.b i = V.i(this.a);
            i.f();
            i.b();
            ux1.k("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755817426, "Lcom/repackage/d43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755817426, "Lcom/repackage/d43;");
                return;
            }
        }
        a = eh1.a;
    }

    public static l72 a(an1<?> an1Var, uq2 uq2Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, an1Var, uq2Var, str)) == null) {
            j13 f = hm2.U().f(uq2Var.d);
            l72 l72Var = new l72();
            l72Var.i = an1Var.M();
            l72Var.a = uq2Var.c;
            if (u03.L() != null) {
                l72Var.c = u03.L().c0(uq2Var.d);
            }
            l72Var.k = i72.c(u03.L(), uq2Var.a);
            l72Var.b = uq2.b(uq2Var);
            l72Var.d = f.g;
            l72Var.e = String.valueOf(rx1.a());
            if (u03.L() != null) {
                String W = u03.L().W(uq2Var.d);
                if (!TextUtils.isEmpty(W)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + W);
                    }
                    l72Var.f = W;
                }
            }
            l72Var.g = a || hm2.U().N();
            l72Var.h = str;
            if (tw2.H()) {
                l72Var.j = xx1.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            wa3.b(l72Var.a, l72Var.b);
            return l72Var;
        }
        return (l72) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull u03 u03Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, u03Var, str, str2, list)) == null) {
            String f = me3.f(str);
            String o = me3.o(str);
            String b = m43.b(f);
            String b0 = u03Var.b0(f);
            String c0 = u03Var.c0(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", b0);
                jSONObject.put("pageType", c0);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str);
                }
                if (!TextUtils.equals(f, b)) {
                    if (!TextUtils.isEmpty(o)) {
                        b = b + "?" + o;
                    }
                    jSONObject.put("pageRoutePath", b);
                }
                if (list != null && !list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject.put("removedSlaveIDs", jSONArray);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? d(str, "") : (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.repackage.bn1] */
    public static void e(an1<?> an1Var, uq2 uq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, an1Var, uq2Var, str) == null) {
            yt2.a("route", "createAndLoadPage start.");
            String a2 = oe3.a(uq2Var.c, uq2Var.a, uq2Var.b);
            l72 a3 = a(an1Var, uq2Var, str);
            zt2.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            be3.d();
            an1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, uq2Var.e());
            an1Var.U(a3.b);
            hm2.U().m(an1Var.c(), l72.a(a3));
            if (m72.b()) {
                m72 m72Var = new m72();
                m72Var.a = an1Var.c();
                hm2.U().u(m72.a(m72Var));
            }
            e73.F(an1Var.c(), a3.b);
            z62.o(a2, an1Var);
            yt2.a("route", "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            va2 va2Var = new va2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                hm2.U().u(va2Var);
                return;
            }
            k72 k72Var = new k72();
            k72Var.t(createFromReLaunch);
            k72Var.t(va2Var);
            hm2.U().u(k72Var);
        }
    }

    public static List<String> g(d02 d02Var) {
        InterceptResult invokeL;
        a02 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, d02Var)) == null) {
            if (d02Var != null && d02Var.k() >= nq1.g && (j = d02Var.j(0)) != null && (j instanceof c02)) {
                return ((c02) j).t3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        an1 n3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            c02 H = hm2.U().H();
            if (H == null || (n3 = H.n3()) == null) {
                return null;
            }
            return n3.o();
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h = h();
            if (a) {
                Log.i("ActionUtils", "lastPageUrl: " + h + "\ncurPageUrl: " + str);
            }
            if (h != null && str != null) {
                String x1 = rl2.x1(h);
                String x12 = rl2.x1(str);
                return (TextUtils.equals(x1, x12) || TextUtils.equals(Uri.decode(x1), x12) || TextUtils.equals(x1, Uri.decode(x12))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, unitedSchemeEntity, callbackHandler, str) == null) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
        }
    }

    public static void k(uo1 uo1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, uo1Var, str) == null) || uo1Var == null) {
            return;
        }
        uo1Var.d(str, new us1(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, u03Var, str, str2, list, str3}) == null) || u03Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(u03Var, str2, str, list), 0).toString(), str3);
    }

    public static void m(uo1 uo1Var, u03 u03Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{uo1Var, u03Var, str, str2, list, str3}) == null) || uo1Var == null || u03Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        uo1Var.d(str3, new us1(0, b(u03Var, str2, str, list)));
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, unitedSchemeEntity, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = unitedSchemeEntity.getParams().get(str);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                return new JSONObject(str3).optString(str2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) ? n(unitedSchemeEntity, str, "url") : (String) invokeLL.objValue;
    }

    @Nullable
    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optString("url");
        }
        return (String) invokeL.objValue;
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            ux1.k("ActionUtils", "popAllFragment: routeType=" + str);
            oe3.e0(new a(str));
        }
    }
}
