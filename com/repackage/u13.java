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
import com.repackage.ek2;
import com.repackage.qy1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u13 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "SwanAppPageForbidden";
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<JSONObject> b;
    public String c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qy1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ oy1 c;
        public final /* synthetic */ hp2 d;
        public final /* synthetic */ ForbiddenInfo e;

        public a(u13 u13Var, qy1 qy1Var, String str, oy1 oy1Var, hp2 hp2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u13Var, qy1Var, str, oy1Var, hp2Var, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qy1Var;
            this.b = str;
            this.c = oy1Var;
            this.d = hp2Var;
            this.e = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qy1.b i = this.a.i(this.b);
                i.n(qy1.g, qy1.i);
                i.j(this.c);
                i.b();
                v53.j(this.d, this.e.errCode);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final u13 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-7167364, "Lcom/repackage/u13$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-7167364, "Lcom/repackage/u13$b;");
                    return;
                }
            }
            a = new u13(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755313862, "Lcom/repackage/u13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755313862, "Lcom/repackage/u13;");
                return;
            }
        }
        e = rf1.a;
    }

    public /* synthetic */ u13(a aVar) {
        this();
    }

    public static u13 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (u13) invokeV.objValue;
    }

    public boolean a(hp2 hp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hp2Var)) == null) {
            if (hp2Var != null && jr1.e(gz2.J().r().X())) {
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
                return g(hp2Var);
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

    public boolean g(hp2 hp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hp2Var)) == null) {
            if (hp2Var == null) {
                return false;
            }
            String str = hp2Var.a;
            String str2 = hp2Var.d;
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
                                    if (TextUtils.isEmpty(hp2Var.b)) {
                                        return false;
                                    }
                                    List<String> c = zc3.c(optString2);
                                    String[] split = hp2Var.b.split("&");
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
                                if (TextUtils.isEmpty(hp2Var.b)) {
                                    return false;
                                }
                                List<String> c2 = zc3.c(optString3);
                                String[] split2 = hp2Var.b.split("&");
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

    public final boolean h(hp2 hp2Var) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hp2Var)) == null) {
            if (hp2Var == null) {
                return false;
            }
            String str = hp2Var.d;
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

    public void i(String str, hp2 hp2Var) {
        qy1 V;
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, hp2Var) == null) || hp2Var == null || (V = uk2.U().V()) == null || (V.m() instanceof oy1)) {
            return;
        }
        if (h(hp2Var)) {
            b2 = hp2.c(hp2Var);
        } else {
            b2 = hp2.b(hp2Var);
        }
        if (e) {
            String str2 = d;
            Log.d(str2, "jump from " + str + " ; path = " + b2);
        }
        hz2 r = gz2.J().r();
        ek2.a V2 = r.V();
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
        bd3.e0(new a(this, V, str, oy1.e3(String.valueOf(forbiddenInfo.errCode.a()), SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, "", -1, forbiddenInfo, 0, 0), hp2Var, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p73 a2 = v73.a();
            String N = gz2.J().r().N();
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
                JSONArray e2 = hc3.e(string);
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
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, forbiddenInfo) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        a0.r();
        SwanAppActivity x = a0.x();
        if (x == null) {
            return;
        }
        String i = m83.i(uk2.U().M(), a0.X().G());
        ab3 ab3Var = new ab3();
        ab3Var.k(5L);
        ab3Var.i(48L);
        ab3Var.d("page forbidden");
        forbiddenInfo.errCode = ab3Var;
        forbiddenInfo.forbiddenDetail = x.getString(R.string.obfuscated_res_0x7f0f019e, bd3.D(), i, String.valueOf(ab3Var.a()));
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_key", str);
            xv2 e2 = xv2.e();
            zv2 zv2Var = new zv2(131, bundle);
            zv2Var.d();
            e2.h(zv2Var);
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
                v73.a().edit().putString(c, jSONArray2).putString(e2, str).apply();
                if (e) {
                    String str3 = d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        v73.a().edit().remove(c).remove(e2).apply();
        if (e) {
            String str4 = d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public u13() {
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
