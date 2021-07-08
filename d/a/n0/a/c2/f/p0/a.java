package d.a.n0.a.c2.f.p0;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.n0.a.h0.g.g;
import d.a.n0.a.v2.d0;
import d.a.n0.a.v2.o0;
import d.a.n0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43780a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.c2.f.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0655a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43781e;

        public RunnableC0655a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43781e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.a.h0.g.g W;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (W = d.a.n0.a.g1.f.V().W()) == null) {
                return;
            }
            g.b i2 = W.i(this.f43781e);
            i2.f();
            i2.b();
            d.a.n0.a.e0.d.h("ActionUtils", "popAllFragment: finish");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369833302, "Ld/a/n0/a/c2/f/p0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(369833302, "Ld/a/n0/a/c2/f/p0/a;");
                return;
            }
        }
        f43780a = d.a.n0.a.k.f45831a;
    }

    public static d.a.n0.a.h0.u.d a(d.a.n0.a.p.e.b<?> bVar, d.a.n0.a.l1.b bVar2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bVar, bVar2, str)) == null) {
            d.a.n0.a.a2.n.g e2 = d.a.n0.a.g1.f.V().e(bVar2.f45992h);
            d.a.n0.a.h0.u.d dVar = new d.a.n0.a.h0.u.d();
            dVar.f45252i = bVar.L();
            dVar.f45244a = bVar2.f45991g;
            if (d.a.n0.a.a2.e.i() != null) {
                dVar.f45246c = d.a.n0.a.a2.e.i().S(bVar2.f45992h);
            }
            dVar.k = d.a.n0.a.h0.u.a.c(d.a.n0.a.a2.e.i(), bVar2.f45989e);
            dVar.f45245b = d.a.n0.a.l1.b.e(bVar2);
            dVar.f45247d = e2.f43430g;
            dVar.f45248e = String.valueOf(d.a.n0.a.e0.a.a());
            if (d.a.n0.a.a2.e.i() != null) {
                String M = d.a.n0.a.a2.e.i().M(bVar2.f45992h);
                if (!TextUtils.isEmpty(M)) {
                    if (f43780a) {
                        Log.d("ActionUtils", "add initData: " + M);
                    }
                    dVar.f45249f = M;
                }
            }
            dVar.f45250g = f43780a || d.a.n0.a.g1.f.V().O();
            dVar.f45251h = str;
            if (d.a.n0.a.u1.a.a.G()) {
                dVar.j = d.a.n0.a.e0.f.b.d();
            }
            if (f43780a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            d.a.n0.a.n2.g.a.b(dVar.f45244a, dVar.f45245b);
            return dVar;
        }
        return (d.a.n0.a.h0.u.d) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull d.a.n0.a.a2.e eVar, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, eVar, str, str2, list)) == null) {
            String f2 = o0.f(str);
            String o = o0.o(str);
            String b2 = j.b(f2);
            String R = eVar.R(f2);
            String S = eVar.S(f2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, R);
                jSONObject.put("pageType", S);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("pageUrl", str);
                }
                if (!TextUtils.equals(f2, b2)) {
                    if (!TextUtils.isEmpty(o)) {
                        b2 = b2 + "?" + o;
                    }
                    jSONObject.put("pageRoutePath", b2);
                }
                if (list != null && !list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject.put("removedSlaveIDs", jSONArray);
                }
            } catch (JSONException e2) {
                if (f43780a) {
                    e2.printStackTrace();
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
                    jSONObject.put("pageUrl", str2);
                }
            } catch (JSONException e2) {
                if (f43780a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [d.a.n0.a.p.e.c] */
    public static void e(d.a.n0.a.p.e.b<?> bVar, d.a.n0.a.l1.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, bVar, bVar2, str) == null) {
            d.a.n0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage start.");
            String a2 = q0.a(bVar2.f45991g, bVar2.f45989e, bVar2.f45990f);
            d.a.n0.a.h0.u.d a3 = a(bVar, bVar2, str);
            d.a.n0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("slave_dispatch_start"));
            d0.d();
            bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar2.h());
            bVar.S(a3.f45245b);
            d.a.n0.a.g1.f.V().m(bVar.b(), d.a.n0.a.h0.u.d.a(a3));
            if (d.a.n0.a.h0.u.e.b()) {
                d.a.n0.a.h0.u.e eVar = new d.a.n0.a.h0.u.e();
                eVar.f45255a = bVar.b();
                d.a.n0.a.g1.f.V().v(d.a.n0.a.h0.u.e.a(eVar));
            }
            d.a.n0.a.j2.e.F(bVar.b(), a3.f45245b);
            d.a.n0.a.h0.t.a.m(a2, bVar);
            d.a.n0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            d.a.n0.a.o0.d.b bVar = new d.a.n0.a.o0.d.b(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                d.a.n0.a.g1.f.V().v(bVar);
                return;
            }
            d.a.n0.a.h0.u.c cVar = new d.a.n0.a.h0.u.c();
            cVar.h(createFromReLaunch);
            cVar.h(bVar);
            d.a.n0.a.g1.f.V().v(cVar);
        }
    }

    public static List<String> g(d.a.n0.a.h0.g.g gVar) {
        InterceptResult invokeL;
        d.a.n0.a.h0.g.d j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar != null && gVar.k() >= d.a.n0.a.u.e.k.b.f47705d && (j = gVar.j(0)) != null && (j instanceof d.a.n0.a.h0.g.f)) {
                return ((d.a.n0.a.h0.g.f) j).h3();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        d.a.n0.a.p.e.b b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            d.a.n0.a.h0.g.f J = d.a.n0.a.g1.f.V().J();
            if (J == null || (b3 = J.b3()) == null) {
                return null;
            }
            return b3.o();
        }
        return (String) invokeV.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h2 = h();
            if (f43780a) {
                Log.i("ActionUtils", "lastPageUrl: " + h2 + "\ncurPageUrl: " + str);
            }
            if (h2 != null && str != null) {
                String w1 = d.a.n0.a.f1.e.b.w1(h2);
                String w12 = d.a.n0.a.f1.e.b.w1(str);
                return (TextUtils.equals(w1, w12) || TextUtils.equals(Uri.decode(w1), w12) || TextUtils.equals(w1, Uri.decode(w12))) ? false : true;
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

    public static void k(d.a.n0.a.u.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, aVar, str) == null) || aVar == null) {
            return;
        }
        aVar.d(str, new d.a.n0.a.u.h.b(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, eVar, str, str2, list, str3}) == null) || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(eVar, str2, str, list), 0).toString(), str3);
    }

    public static void m(d.a.n0.a.u.c.a aVar, d.a.n0.a.a2.e eVar, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{aVar, eVar, str, str2, list, str3}) == null) || aVar == null || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        aVar.d(str3, new d.a.n0.a.u.h.b(0, b(eVar, str2, str, list)));
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
            } catch (JSONException e2) {
                if (f43780a) {
                    e2.printStackTrace();
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
            d.a.n0.a.e0.d.h("ActionUtils", "popAllFragment: routeType=" + str);
            q0.b0(new RunnableC0655a(str));
        }
    }
}
