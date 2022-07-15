package com.repackage;

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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lz2;
import com.repackage.m53;
import com.repackage.p63;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, d> b;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context e = f53.e();
                Toast.makeText(e, "aiapps-oauth :: " + this.a, 0).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h53 a;

        public b(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h53Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (i == -2) {
                    f53.k("onNegBtn", Boolean.FALSE);
                    a73.q("click", this.a.b, false);
                    f53.d(this.a.b, false);
                } else if (i == -1) {
                    f53.k("onPosBtn", Boolean.FALSE);
                    a73.q("click", this.a.b, true);
                    f53.d(this.a.b, true);
                }
                pj2.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h53 a;

        public c(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h53Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                f53.k("onCancel", Boolean.FALSE);
                a73.q("click", this.a.b, false);
                f53.d(this.a.b, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<c53> a;

        public d(String str) {
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
            this.a = new HashSet();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755756883, "Lcom/repackage/f53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755756883, "Lcom/repackage/f53;");
                return;
            }
        }
        a = rg1.a;
        b = new HashMap();
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
                if (a) {
                    k("query :: " + key + " = " + value, Boolean.FALSE);
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
            String C = oj2.o().C();
            return (jSONObject == null || TextUtils.isEmpty(C)) ? jSONObject : jSONObject.optJSONObject(C);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void d(String str, boolean z) {
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            synchronized (b) {
                remove = b.remove(str);
            }
            if (remove == null || remove.a.isEmpty()) {
                return;
            }
            for (c53 c53Var : remove.a) {
                if (c53Var != null) {
                    c53Var.onResult(z);
                }
            }
        }
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static String f(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            switch (i) {
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
            if (a) {
                Log.w("OAuthUtils", i + " " + str);
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
                return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : lg4.d(signatureArr[0].toByteArray(), false);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean h(k53<m53.e> k53Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, k53Var)) == null) ? k53Var != null && k53Var.c() && k53Var.a.b : invokeL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "api");
        }
        return invokeL.booleanValue;
    }

    public static boolean j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), NativeConstants.COMPONENT);
        }
        return invokeL.booleanValue;
    }

    public static void k(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, bool) == null) {
            hx1.k("aiapps-oauth", str);
            if (a && bool.booleanValue()) {
                be3.a0(new a(str));
            }
        }
    }

    @Deprecated
    public static void l(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, runnable) == null) {
            be3.a0(runnable);
        }
    }

    public static synchronized void m(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, jSONObject) == null) {
            synchronized (f53.class) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("code")) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject.put("data", jSONObject2);
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void n(t53 t53Var, CallbackHandler callbackHandler, String str) {
        ac3 ac3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, t53Var, callbackHandler, str) == null) || t53Var == null || (ac3Var = t53Var.j) == null) {
            return;
        }
        int i = -1;
        try {
            i = (int) ac3Var.a();
        } catch (ClassCastException e) {
            if (a) {
                Log.e("OAuthUtils", e.toString());
            }
        }
        if (i < 0) {
            return;
        }
        o(i, callbackHandler, str);
    }

    public static void o(int i, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65551, null, i, callbackHandler, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String f = f(i);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, f).toString());
        hx1.o("OAuthUtils", "authorize failed : " + f);
    }

    public static void p(k53<m53.e> k53Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, k53Var, callbackHandler, unitedSchemeEntity) == null) {
            if (k53Var != null && k53Var.a() != null) {
                int b2 = k53Var.b();
                String f = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f));
                hx1.o("OAuthUtils", "authorize failed : " + f);
                return;
            }
            hx1.c("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q(k53<m53.e> k53Var, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, k53Var, callbackHandler, str) == null) {
            if (k53Var != null && k53Var.a() != null) {
                o(k53Var.b(), callbackHandler, str);
            } else {
                hx1.c("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            b.clear();
        }
    }

    public static void s(int i, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65555, null, i, str, str2) == null) {
            try {
                String g0 = h03.g0();
                if (TextUtils.isEmpty(g0)) {
                    g0 = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + StringHelper.STRING_MORE;
                } else {
                    str3 = str4 + str2;
                }
                p63.b bVar = new p63.b(i);
                bVar.h(g0);
                bVar.i(str3);
                bVar.m();
                hx1.k("OAuthUtils", "error reported: " + i + " ,content: " + str3);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (f53.class) {
                s(10004, str, str2);
            }
        }
    }

    public static void u(Context context, h03 h03Var, h53 h53Var, JSONObject jSONObject, c53 c53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, null, context, h03Var, h53Var, jSONObject, c53Var) == null) {
            if (h53Var != null && !TextUtils.isEmpty(h53Var.b)) {
                synchronized (b) {
                    d dVar = b.get(h53Var.b);
                    if (dVar != null) {
                        dVar.a.add(c53Var);
                        return;
                    }
                    d dVar2 = new d(h53Var.b);
                    dVar2.a.add(c53Var);
                    b.put(h53Var.b, dVar2);
                    b bVar = new b(h53Var);
                    c cVar = new c(h53Var);
                    a73.q("show", h53Var.b, false);
                    pj2.n().a("na_authorize_start");
                    v(context, h03Var, h53Var, jSONObject, bVar, cVar);
                    return;
                }
            }
            c53Var.onResult(false);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void v(Context context, h03 h03Var, h53 h53Var, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, h03Var, h53Var, jSONObject, onClickListener, onCancelListener}) == null) {
            lz2.a a2 = oj2.i0().a(context, h03Var, h53Var, jSONObject, onClickListener);
            if (a2 == null) {
                if (a) {
                    throw new RuntimeException("auth dialog builder is null");
                }
                return;
            }
            lz2 c2 = a2.c();
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100394);
            }
            SwanAppActivity w = h03Var == null ? null : h03Var.w();
            if (w == null || w.isFinishing()) {
                return;
            }
            c2.show();
        }
    }
}
