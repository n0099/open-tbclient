package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
import com.repackage.rl2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h33 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "SwanAppPageForbidden";
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<JSONObject> b;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d02 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b02 c;
        public final /* synthetic */ uq2 d;
        public final /* synthetic */ ForbiddenInfo e;

        public a(h33 h33Var, d02 d02Var, String str, b02 b02Var, uq2 uq2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h33Var, d02Var, str, b02Var, uq2Var, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d02Var;
            this.b = str;
            this.c = b02Var;
            this.d = uq2Var;
            this.e = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d02.b i = this.a.i(this.b);
                i.n(d02.g, d02.i);
                i.j(this.c);
                i.b();
                i73.j(this.d, this.e.errCode);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final h33 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-377499285, "Lcom/repackage/h33$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-377499285, "Lcom/repackage/h33$b;");
                    return;
                }
            }
            a = new h33(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755699223, "Lcom/repackage/h33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755699223, "Lcom/repackage/h33;");
                return;
            }
        }
        e = eh1.a;
    }

    public /* synthetic */ h33(a aVar) {
        this();
    }

    public static h33 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (h33) invokeV.objValue;
    }

    public boolean a(uq2 uq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uq2Var)) == null) {
            if (uq2Var != null && ws1.e(t03.J().r().X())) {
                if (!this.a) {
                    j();
                }
                List<JSONObject> list = this.b;
                if (list == null || list.isEmpty()) {
                    return false;
                }
                if (e) {
                    Log.d(d, "ForbiddenPage Check");
                }
                return g(uq2Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return str + "_forbidden_ban_page";
        }
        return (String) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return str + "_forbidden_tips";
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(String[] strArr, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, strArr, list)) == null) {
            if (list == null || list.isEmpty() || strArr == null || strArr.length == 0) {
                return false;
            }
            List asList = Arrays.asList(strArr);
            if (asList.isEmpty()) {
                return false;
            }
            for (String str : list) {
                if (!asList.contains(str)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(uq2 uq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uq2Var)) == null) {
            if (uq2Var == null) {
                return false;
            }
            String str = uq2Var.a;
            String str2 = uq2Var.d;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                List<JSONObject> list = this.b;
                if (list == null) {
                    return false;
                }
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null && !jSONObject.isNull("type") && !jSONObject.isNull("path")) {
                        int optInt = jSONObject.optInt("type");
                        String optString = jSONObject.optString("path");
                        if (TextUtils.equals(str, optString) || TextUtils.equals(str2, optString)) {
                            if (optInt == 1) {
                                return true;
                            }
                            if (optInt != 2) {
                                if (optInt == 3 && !jSONObject.isNull("query")) {
                                    String optString2 = jSONObject.optString("query");
                                    if (TextUtils.isEmpty(uq2Var.b)) {
                                        return false;
                                    }
                                    List<String> c = me3.c(optString2);
                                    String[] split = uq2Var.b.split("&");
                                    if (split == null || split.length == 0 || c == null || c.isEmpty()) {
                                        return false;
                                    }
                                    if (f(split, c)) {
                                        return true;
                                    }
                                }
                            } else if (jSONObject.isNull("query")) {
                                continue;
                            } else {
                                String optString3 = jSONObject.optString("query");
                                if (TextUtils.isEmpty(uq2Var.b)) {
                                    return false;
                                }
                                List<String> c2 = me3.c(optString3);
                                String[] split2 = uq2Var.b.split("&");
                                if (split2 == null || split2.length == 0 || c2 == null || c2.isEmpty() || split2.length != c2.size()) {
                                    return false;
                                }
                                if (f(split2, c2)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean h(uq2 uq2Var) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uq2Var)) == null) {
            if (uq2Var == null) {
                return false;
            }
            String str = uq2Var.d;
            if (TextUtils.isEmpty(str) || (list = this.b) == null) {
                return false;
            }
            for (JSONObject jSONObject : list) {
                if (jSONObject != null && TextUtils.equals(str, jSONObject.optString("path"))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(String str, uq2 uq2Var) {
        d02 V;
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, uq2Var) == null) || uq2Var == null || (V = hm2.U().V()) == null || (V.m() instanceof b02)) {
            return;
        }
        if (h(uq2Var)) {
            b2 = uq2.c(uq2Var);
        } else {
            b2 = uq2.b(uq2Var);
        }
        if (e) {
            String str2 = d;
            Log.d(str2, "jump from " + str + " ; path = " + b2);
        }
        u03 r = t03.J().r();
        rl2.a V2 = r.V();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = r.getAppId();
        forbiddenInfo.appKey = r.N();
        forbiddenInfo.appTitle = V2.K();
        forbiddenInfo.forbiddenReason = d();
        forbiddenInfo.forbiddenInformation = this.c;
        forbiddenInfo.launchSource = V2.T();
        forbiddenInfo.launchPath = b2;
        forbiddenInfo.enableSlidingFlag = 0;
        l(forbiddenInfo);
        oe3.e0(new a(this, V, str, b02.e3(String.valueOf(forbiddenInfo.errCode.a()), SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, "", -1, forbiddenInfo, 0, 0), uq2Var, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c93 a2 = i93.a();
            String N = t03.J().r().N();
            if (a2 == null) {
                return;
            }
            String string = a2.getString(c(N), null);
            if (e) {
                String str = d;
                Log.d(str, "readData, appKey = " + N + " ; tips = " + this.c + " ; page = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                this.b = null;
            } else {
                JSONArray e2 = ud3.e(string);
                if (e2 == null) {
                    return;
                }
                int length = e2.length();
                this.b = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = e2.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.b.add(optJSONObject);
                    }
                }
                this.c = a2.getString(e(N), null);
            }
            this.a = true;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (e) {
                Log.d(d, "releaseData");
            }
            this.a = false;
            this.c = null;
            List<JSONObject> list = this.b;
            if (list != null) {
                list.clear();
                this.b = null;
            }
        }
    }

    public final void l(ForbiddenInfo forbiddenInfo) {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, forbiddenInfo) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        a0.r();
        SwanAppActivity x = a0.x();
        if (x == null) {
            return;
        }
        String i = z93.i(hm2.U().M(), a0.X().G());
        nc3 nc3Var = new nc3();
        nc3Var.k(5L);
        nc3Var.i(48L);
        nc3Var.d("page forbidden");
        forbiddenInfo.errCode = nc3Var;
        forbiddenInfo.forbiddenDetail = x.getString(R.string.obfuscated_res_0x7f0f019d, oe3.D(), i, String.valueOf(nc3Var.a()));
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_key", str);
            kx2 e2 = kx2.e();
            mx2 mx2Var = new mx2(131, bundle);
            mx2Var.d();
            e2.h(mx2Var);
        }
    }

    public void n(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, jSONArray, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String c = c(str2);
        String e2 = e(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            String jSONArray2 = jSONArray.toString();
            if (optJSONObject != null) {
                i93.a().edit().putString(c, jSONArray2).putString(e2, str).apply();
                if (e) {
                    String str3 = d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        i93.a().edit().remove(c).remove(e2).apply();
        if (e) {
            String str4 = d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public h33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }
}
