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
import com.repackage.qz1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class q33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
            qz1 V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = ul2.U().V()) == null) {
                return;
            }
            qz1.b i = V.i(this.a);
            i.f();
            i.b();
            hx1.k("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755431104, "Lcom/repackage/q33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755431104, "Lcom/repackage/q33;");
                return;
            }
        }
        a = rg1.a;
    }

    public static y62 a(nm1<?> nm1Var, hq2 hq2Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nm1Var, hq2Var, str)) == null) {
            w03 f = ul2.U().f(hq2Var.d);
            y62 y62Var = new y62();
            y62Var.i = nm1Var.M();
            y62Var.a = hq2Var.c;
            if (h03.M() != null) {
                y62Var.c = h03.M().d0(hq2Var.d);
            }
            y62Var.k = v62.c(h03.M(), hq2Var.a);
            y62Var.b = hq2.b(hq2Var);
            y62Var.d = f.g;
            y62Var.e = String.valueOf(ex1.a());
            if (h03.M() != null) {
                String X = h03.M().X(hq2Var.d);
                if (!TextUtils.isEmpty(X)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + X);
                    }
                    y62Var.f = X;
                }
            }
            y62Var.g = a || ul2.U().N();
            y62Var.h = str;
            if (gw2.H()) {
                y62Var.j = kx1.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            ja3.b(y62Var.a, y62Var.b);
            return y62Var;
        }
        return (y62) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull h03 h03Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, h03Var, str, str2, list)) == null) {
            String f = zd3.f(str);
            String o = zd3.o(str);
            String b = z33.b(f);
            String c0 = h03Var.c0(f);
            String d0 = h03Var.d0(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", c0);
                jSONObject.put("pageType", d0);
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

    /* JADX WARN: Type inference failed for: r7v2, types: [com.repackage.om1] */
    public static void e(nm1<?> nm1Var, hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, nm1Var, hq2Var, str) == null) {
            lt2.a("route", "createAndLoadPage start.");
            String a2 = be3.a(hq2Var.c, hq2Var.a, hq2Var.b);
            y62 a3 = a(nm1Var, hq2Var, str);
            mt2.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            od3.d();
            nm1Var.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, hq2Var.e());
            nm1Var.T(a3.b);
            ul2.U().m(nm1Var.b(), y62.a(a3));
            if (z62.b()) {
                z62 z62Var = new z62();
                z62Var.a = nm1Var.b();
                ul2.U().u(z62.a(z62Var));
            }
            r63.F(nm1Var.b(), a3.b);
            m62.o(a2, nm1Var);
            lt2.a("route", "createAndLoadPage end.");
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
            ia2 ia2Var = new ia2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                ul2.U().u(ia2Var);
                return;
            }
            x62 x62Var = new x62();
            x62Var.t(createFromReLaunch);
            x62Var.t(ia2Var);
            ul2.U().u(x62Var);
        }
    }

    public static List<String> g(qz1 qz1Var) {
        InterceptResult invokeL;
        nz1 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, qz1Var)) == null) {
            if (qz1Var != null && qz1Var.k() >= aq1.g && (j = qz1Var.j(0)) != null && (j instanceof pz1)) {
                return ((pz1) j).u3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        nm1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            pz1 H = ul2.U().H();
            if (H == null || (o3 = H.o3()) == null) {
                return null;
            }
            return o3.n();
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
                String x1 = el2.x1(h);
                String x12 = el2.x1(str);
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

    public static void k(ho1 ho1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, ho1Var, str) == null) || ho1Var == null) {
            return;
        }
        ho1Var.d(str, new hs1(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, h03Var, str, str2, list, str3}) == null) || h03Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(h03Var, str2, str, list), 0).toString(), str3);
    }

    public static void m(ho1 ho1Var, h03 h03Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{ho1Var, h03Var, str, str2, list, str3}) == null) || ho1Var == null || h03Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        ho1Var.d(str3, new hs1(0, b(h03Var, str2, str, list)));
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
            hx1.k("ActionUtils", "popAllFragment: routeType=" + str);
            be3.e0(new a(str));
        }
    }
}
