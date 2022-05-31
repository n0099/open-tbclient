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
import com.repackage.qy1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class q23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
            qy1 V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = uk2.U().V()) == null) {
                return;
            }
            qy1.b i = V.i(this.a);
            i.f();
            i.b();
            hw1.k("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755432065, "Lcom/repackage/q23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755432065, "Lcom/repackage/q23;");
                return;
            }
        }
        a = rf1.a;
    }

    public static y52 a(nl1<?> nl1Var, hp2 hp2Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nl1Var, hp2Var, str)) == null) {
            wz2 f = uk2.U().f(hp2Var.d);
            y52 y52Var = new y52();
            y52Var.i = nl1Var.M();
            y52Var.a = hp2Var.c;
            if (hz2.L() != null) {
                y52Var.c = hz2.L().c0(hp2Var.d);
            }
            y52Var.k = v52.c(hz2.L(), hp2Var.a);
            y52Var.b = hp2.b(hp2Var);
            y52Var.d = f.g;
            y52Var.e = String.valueOf(ew1.a());
            if (hz2.L() != null) {
                String W = hz2.L().W(hp2Var.d);
                if (!TextUtils.isEmpty(W)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + W);
                    }
                    y52Var.f = W;
                }
            }
            y52Var.g = a || uk2.U().N();
            y52Var.h = str;
            if (gv2.H()) {
                y52Var.j = kw1.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            j93.b(y52Var.a, y52Var.b);
            return y52Var;
        }
        return (y52) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull hz2 hz2Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, hz2Var, str, str2, list)) == null) {
            String f = zc3.f(str);
            String o = zc3.o(str);
            String b = z23.b(f);
            String b0 = hz2Var.b0(f);
            String c0 = hz2Var.c0(f);
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

    /* JADX WARN: Type inference failed for: r7v2, types: [com.repackage.ol1] */
    public static void e(nl1<?> nl1Var, hp2 hp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, nl1Var, hp2Var, str) == null) {
            ls2.a("route", "createAndLoadPage start.");
            String a2 = bd3.a(hp2Var.c, hp2Var.a, hp2Var.b);
            y52 a3 = a(nl1Var, hp2Var, str);
            ms2.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            oc3.d();
            nl1Var.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, hp2Var.e());
            nl1Var.U(a3.b);
            uk2.U().m(nl1Var.c(), y52.a(a3));
            if (z52.b()) {
                z52 z52Var = new z52();
                z52Var.a = nl1Var.c();
                uk2.U().u(z52.a(z52Var));
            }
            r53.F(nl1Var.c(), a3.b);
            m52.o(a2, nl1Var);
            ls2.a("route", "createAndLoadPage end.");
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
            i92 i92Var = new i92(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                uk2.U().u(i92Var);
                return;
            }
            x52 x52Var = new x52();
            x52Var.t(createFromReLaunch);
            x52Var.t(i92Var);
            uk2.U().u(x52Var);
        }
    }

    public static List<String> g(qy1 qy1Var) {
        InterceptResult invokeL;
        ny1 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, qy1Var)) == null) {
            if (qy1Var != null && qy1Var.k() >= ap1.g && (j = qy1Var.j(0)) != null && (j instanceof py1)) {
                return ((py1) j).t3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        nl1 n3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            py1 H = uk2.U().H();
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
                String x1 = ek2.x1(h);
                String x12 = ek2.x1(str);
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

    public static void k(hn1 hn1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, hn1Var, str) == null) || hn1Var == null) {
            return;
        }
        hn1Var.d(str, new hr1(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, hz2Var, str, str2, list, str3}) == null) || hz2Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(hz2Var, str2, str, list), 0).toString(), str3);
    }

    public static void m(hn1 hn1Var, hz2 hz2Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{hn1Var, hz2Var, str, str2, list, str3}) == null) || hn1Var == null || hz2Var == null || TextUtils.isEmpty(str3)) {
            return;
        }
        hn1Var.d(str3, new hr1(0, b(hz2Var, str2, str, list)));
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
            hw1.k("ActionUtils", "popAllFragment: routeType=" + str);
            bd3.e0(new a(str));
        }
    }
}
