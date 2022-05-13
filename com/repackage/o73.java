package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ File b;
        public final /* synthetic */ String c;

        public a(HashMap hashMap, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashMap, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hashMap;
            this.b = file;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            il1 u;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (u = bk2.u()) == null) {
                return;
            }
            u.a(this.a, this.b, null, "error_js");
            if (o73.a) {
                Log.d("V8StabilityHelper", "extraData :" + this.a.toString());
                Log.d("V8StabilityHelper", "filePath :" + this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755486842, "Lcom/repackage/o73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755486842, "Lcom/repackage/o73;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                if (a) {
                    Log.d("V8StabilityHelper", "empty exceptionInfo");
                    return;
                }
                return;
            }
            c(v8ExceptionInfo);
            d(v8ExceptionInfo);
        }
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8ExceptionInfo) == null) {
            if (!bk2.g0().B()) {
                if (a) {
                    Log.d("V8StabilityHelper", "stability switch off");
                    return;
                }
                return;
            }
            u03 L = u03.L();
            rl2.a X = L != null ? L.X() : null;
            nc3 nc3Var = new nc3();
            nc3Var.k(5L);
            nc3Var.i(37L);
            v73 v73Var = new v73();
            v73Var.p(nc3Var);
            v73Var.r(X);
            v73Var.q(n73.n(t03.J().l()));
            v73Var.m(u03.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                    jSONObject.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                    jSONObject.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                    jSONObject.put("exceptionType", v8ExceptionInfo.exceptionType);
                }
                v73Var.e(jSONObject);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            n73.R(v73Var);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8ExceptionInfo) == null) {
            if (!bk2.g0().H()) {
                if (a) {
                    Log.d("V8StabilityHelper", "upload js switch off");
                }
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    if (a) {
                        Log.d("V8StabilityHelper", "file path start with js code prefix");
                        return;
                    }
                    return;
                }
                SwanCoreVersion e = z93.e(t03.J().l());
                if (e == null || TextUtils.isEmpty(e.swanCorePath)) {
                    return;
                }
                if (!str.startsWith(e.swanCorePath)) {
                    if (a) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    u03 L = u03.L();
                    if (!TextUtils.isEmpty(u03.f0())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, u03.f0());
                    }
                    if (L != null && !TextUtils.isEmpty(L.j0())) {
                        hashMap.put("appVersion", L.j0());
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                        hashMap.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                        hashMap.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                    }
                    if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                        hashMap.put("exceptionType", v8ExceptionInfo.exceptionType);
                    }
                    od3.k(new a(hashMap, file, str), "error_js");
                }
            }
        }
    }
}
