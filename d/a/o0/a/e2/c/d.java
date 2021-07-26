package d.a.o0.a.e2.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.j2.c;
import d.a.o0.a.j2.k;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44820a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, C0696d> f44821b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44822e;

        public a(String str) {
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
            this.f44822e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context e2 = d.e();
                Toast.makeText(e2, "aiapps-oauth :: " + this.f44822e, 0).show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44823e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44823e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (i2 == -2) {
                    d.j("onNegBtn", Boolean.FALSE);
                    k.o(PrefetchEvent.STATE_CLICK, this.f44823e.f44831b, false);
                    d.d(this.f44823e.f44831b, false);
                } else if (i2 == -1) {
                    d.j("onPosBtn", Boolean.FALSE);
                    k.o(PrefetchEvent.STATE_CLICK, this.f44823e.f44831b, true);
                    d.d(this.f44823e.f44831b, true);
                }
                d.a.o0.a.c1.b.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44824e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44824e = fVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d.j("onCancel", Boolean.FALSE);
                k.o(PrefetchEvent.STATE_CLICK, this.f44824e.f44831b, false);
                d.d(this.f44824e.f44831b, false);
            }
        }
    }

    /* renamed from: d.a.o0.a.e2.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0696d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Set<d.a.o0.a.e2.c.a> f44825a;

        public C0696d(String str) {
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
            this.f44825a = new HashSet();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2136847246, "Ld/a/o0/a/e2/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2136847246, "Ld/a/o0/a/e2/c/d;");
                return;
            }
        }
        f44820a = d.a.o0.a.k.f46335a;
        f44821b = new HashMap();
    }

    public static RequestBody b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = "";
                }
                if (TextUtils.isEmpty(value)) {
                    value = "";
                }
                if (f44820a) {
                    j("query :: " + key + " = " + value, Boolean.FALSE);
                }
                builder.add(key, value);
            }
            return builder.build();
        }
        return (RequestBody) invokeL.objValue;
    }

    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            String A = d.a.o0.a.c1.a.n().A();
            return (jSONObject == null || TextUtils.isEmpty(A)) ? jSONObject : jSONObject.optJSONObject(A);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void d(String str, boolean z) {
        C0696d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            synchronized (f44821b) {
                remove = f44821b.remove(str);
            }
            if (remove == null || remove.f44825a.isEmpty()) {
                return;
            }
            for (d.a.o0.a.e2.c.a aVar : remove.f44825a) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static String f(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            switch (i2) {
                case 10001:
                    str = "internal error";
                    break;
                case 10002:
                    str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                    break;
                case 10003:
                    str = "user deny";
                    break;
                case 10004:
                    str = "user not logged in";
                    break;
                case 10005:
                    str = "system deny";
                    break;
                case 10006:
                    str = "no data";
                    break;
                default:
                    str = "Permission denied";
                    break;
            }
            if (f44820a) {
                Log.w("OAuthUtils", i2 + " " + str);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String g() {
        InterceptResult invokeV;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
                return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : d.a.o0.t.f.d(signatureArr[0].toByteArray(), false);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean h(i<b.e> iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iVar)) == null) ? iVar != null && iVar.c() && iVar.f44872a.f44887b : invokeL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, bool) == null) {
            d.a.o0.a.e0.d.h("aiapps-oauth", str);
            if (f44820a && bool.booleanValue()) {
                q0.X(new a(str));
            }
        }
    }

    @Deprecated
    public static void k(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, runnable) == null) {
            q0.X(runnable);
        }
    }

    public static synchronized void l(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, jSONObject) == null) {
            synchronized (d.class) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("code")) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject.put("data", jSONObject2);
                    } catch (JSONException e2) {
                        if (f44820a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void m(d.a.o0.a.e2.d.a aVar, CallbackHandler callbackHandler, String str) {
        d.a.o0.a.q2.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, aVar, callbackHandler, str) == null) || aVar == null || (aVar2 = aVar.j) == null) {
            return;
        }
        int i2 = -1;
        try {
            i2 = (int) aVar2.a();
        } catch (ClassCastException e2) {
            if (f44820a) {
                Log.e("OAuthUtils", e2.toString());
            }
        }
        if (i2 < 0) {
            return;
        }
        n(i2, callbackHandler, str);
    }

    public static void n(int i2, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65550, null, i2, callbackHandler, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String f2 = f(i2);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, f2).toString());
        d.a.o0.a.e0.d.l("OAuthUtils", "authorize failed : " + f2);
    }

    public static void o(i<b.e> iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, iVar, callbackHandler, unitedSchemeEntity) == null) {
            if (iVar != null && iVar.a() != null) {
                int b2 = iVar.b();
                String f2 = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f2));
                d.a.o0.a.e0.d.l("OAuthUtils", "authorize failed : " + f2);
                return;
            }
            d.a.o0.a.e0.d.b("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void p(i<b.e> iVar, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, iVar, callbackHandler, str) == null) {
            if (iVar != null && iVar.a() != null) {
                n(iVar.b(), callbackHandler, str);
            } else {
                d.a.o0.a.e0.d.b("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            f44821b.clear();
        }
    }

    public static void r(int i2, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65554, null, i2, str, str2) == null) {
            try {
                String V = d.a.o0.a.a2.e.V();
                if (TextUtils.isEmpty(V)) {
                    V = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + StringHelper.STRING_MORE;
                } else {
                    str3 = str4 + str2;
                }
                c.b bVar = new c.b(i2);
                bVar.h(V);
                bVar.i(str3);
                bVar.m();
                d.a.o0.a.e0.d.h("OAuthUtils", "error reported: " + i2 + " ,content: " + str3);
            } catch (Exception e2) {
                if (f44820a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized void s(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) {
            synchronized (d.class) {
                r(10004, str, str2);
            }
        }
    }

    public static void t(Context context, d.a.o0.a.a2.e eVar, f fVar, JSONObject jSONObject, d.a.o0.a.e2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65556, null, context, eVar, fVar, jSONObject, aVar) == null) {
            if (fVar != null && !TextUtils.isEmpty(fVar.f44831b)) {
                synchronized (f44821b) {
                    C0696d c0696d = f44821b.get(fVar.f44831b);
                    if (c0696d != null) {
                        c0696d.f44825a.add(aVar);
                        return;
                    }
                    C0696d c0696d2 = new C0696d(fVar.f44831b);
                    c0696d2.f44825a.add(aVar);
                    f44821b.put(fVar.f44831b, c0696d2);
                    b bVar = new b(fVar);
                    c cVar = new c(fVar);
                    k.o("show", fVar.f44831b, false);
                    d.a.o0.a.c1.b.n().a("na_authorize_start");
                    u(context, eVar, fVar, jSONObject, bVar, cVar);
                    return;
                }
            }
            aVar.onResult(false);
        }
    }

    public static void u(Context context, d.a.o0.a.a2.e eVar, f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, eVar, fVar, jSONObject, onClickListener, onCancelListener}) == null) {
            h.a a2 = d.a.o0.a.c1.a.b0().a(context, eVar, fVar, jSONObject, onClickListener);
            if (a2 == null) {
                if (f44820a) {
                    throw new RuntimeException("auth dialog builder is null");
                }
                return;
            }
            d.a.o0.a.z1.b.b.h c2 = a2.c();
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(d.a.o0.a.i.action_sheet_animation);
            }
            SwanAppActivity x = eVar == null ? null : eVar.x();
            if (x == null || x.isFinishing()) {
                return;
            }
            c2.show();
        }
    }
}
