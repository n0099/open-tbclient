package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qs2 implements ml1, ll1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs2 b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public af3<SwanAppPageInfo> a;

    /* loaded from: classes7.dex */
    public class a implements cf3<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public a(qs2 qs2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs2Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: b */
        public Boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? Boolean.valueOf(TextUtils.isEmpty(this.a.optString(str))) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cf3<String, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public b(qs2 qs2Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs2Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
        @Override // com.repackage.cf3
        /* renamed from: b */
        public T a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a : invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755369631, "Lcom/repackage/qs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755369631, "Lcom/repackage/qs2;");
                return;
            }
        }
        boolean z = rg1.a;
        c = oj2.n().a();
        d = c + "_";
    }

    public qs2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static qs2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qs2.class) {
                    if (b == null) {
                        b = new qs2();
                    }
                }
            }
            return b;
        }
        return (qs2) invokeV.objValue;
    }

    @Override // com.repackage.ll1
    public void a(String str, iq2 iq2Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, iq2Var, context) == null) {
            if (iq2Var != null && g03.K().E()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "history");
                    jSONObject.put("url", iq2Var.i());
                    jSONObject.put("pageId", str);
                    c(jSONObject, iq2Var);
                    return;
                } catch (JSONException e) {
                    hx1.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
                    return;
                }
            }
            hx1.o("SwanAppPageInfoHelper", "onFragmentOpened: ret by pageParam is null or !hasAppOccupied");
        }
    }

    @Override // com.repackage.ml1
    public void b(h03 h03Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h03Var, jSONObject) == null) {
            c(jSONObject, null);
        }
    }

    public final void c(@NonNull JSONObject jSONObject, @Nullable iq2 iq2Var) {
        String i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, iq2Var) == null) {
            String optString = jSONObject.optString("type");
            if (!d(optString)) {
                hx1.o("SwanAppPageInfoHelper", "addPageHistory: ret by check type:" + optString);
                return;
            }
            pz1 g = g();
            if (g == null) {
                hx1.o("SwanAppPageInfoHelper", "addPageHistory: ret by null fragment");
                return;
            }
            iq2 N1 = g.N1();
            if (N1 == null) {
                hx1.o("SwanAppPageInfoHelper", "addPageHistory: ret by null param");
                return;
            }
            if (iq2Var == null) {
                iq2Var = N1;
            }
            try {
                i = iq2Var.i();
                str = "";
                if (TextUtils.isEmpty(i)) {
                    i = "";
                }
                l(jSONObject, "url", i);
                String optString2 = jSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    str = optString2;
                }
            } catch (JSONException e) {
                hx1.o("SwanAppPageInfoHelper", "addPageHistory: ret by catch:" + e + " trace:\n" + Log.getStackTraceString(e));
            }
            if (!str.startsWith(i)) {
                hx1.o("SwanAppPageInfoHelper", "addPageHistory: ret by isNotSamePage\n    fragmentUrl = " + i + "\n        dataUrl = " + str);
                return;
            }
            if (optString.startsWith(d)) {
                optString = optString.substring(d.length());
            }
            jSONObject.put("type", optString);
            l(jSONObject, "pageId", g.h0);
            l(jSONObject, "scheme", c + "://swan/" + g03.K().getAppId() + "/" + str);
            el2 f = f();
            if (f != null) {
                l(jSONObject, "appName", f.K());
                l(jSONObject, "iconUrl", f.Q());
                l(jSONObject, "appDesc", f.e1());
            }
            h(jSONObject);
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? !TextUtils.isEmpty(str) && ("history".equals(str) || str.startsWith(d)) : invokeL.booleanValue;
    }

    public final el2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || b0.W() == null) {
                return null;
            }
            return b0.W();
        }
        return (el2) invokeV.objValue;
    }

    public final pz1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            qz1 V = ul2.U().V();
            if (V == null) {
                return null;
            }
            return V.o();
        }
        return (pz1) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            if (!SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                i(new SwanAppPageInfo(jSONObject));
                return;
            }
            m();
            Bundle bundle = new Bundle();
            bundle.putString("page_info", jSONObject.toString());
            xw2.e().h(new zw2(24, bundle));
        }
    }

    public void i(SwanAppPageInfo swanAppPageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppPageInfo) == null) {
            hx1.i("SwanAppPageInfoHelper", "notifyCallBackLocally: data = " + swanAppPageInfo);
            af3<SwanAppPageInfo> af3Var = this.a;
            if (af3Var != null) {
                af3Var.a(swanAppPageInfo);
            }
        }
    }

    public final <T> JSONObject j(JSONObject jSONObject, String str, cf3<String, T> cf3Var, cf3<String, Boolean> cf3Var2) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, cf3Var, cf3Var2)) == null) {
            if (cf3Var2.a(str).booleanValue()) {
                jSONObject.put(str, cf3Var.a(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final <T> JSONObject k(JSONObject jSONObject, String str, T t, cf3<String, Boolean> cf3Var) throws JSONException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, jSONObject, str, t, cf3Var)) == null) {
            j(jSONObject, str, new b(this, t), cf3Var);
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public final JSONObject l(JSONObject jSONObject, String str, String str2) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, jSONObject, str, str2)) == null) {
            k(jSONObject, str, str2, new a(this, jSONObject));
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }
}
