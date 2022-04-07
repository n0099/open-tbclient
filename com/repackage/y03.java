package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
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
public class y03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final x03<y03> u;
    public static final w03<y03> v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;

    /* loaded from: classes7.dex */
    public static class a extends x03<y03> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x03
        /* renamed from: b */
        public void a(@NonNull y03 y03Var, @NonNull pj2 pj2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y03Var, pj2Var) == null) {
                pj2Var.writeInt(y03Var.a);
                pj2Var.f(y03Var.b);
                pj2Var.f(y03Var.c);
                pj2Var.f(y03Var.d);
                pj2Var.writeInt(y03Var.e);
                pj2Var.writeBoolean(y03Var.f);
                pj2Var.f(y03Var.g);
                pj2Var.writeBoolean(y03Var.h);
                pj2Var.writeBoolean(y03Var.i);
                pj2Var.f(y03Var.j);
                pj2Var.writeBoolean(y03Var.k);
                pj2Var.writeBoolean(y03Var.l);
                pj2Var.writeBoolean(y03Var.m);
                pj2Var.writeBoolean(y03Var.n);
                pj2Var.writeBoolean(y03Var.o);
                pj2Var.writeBoolean(y03Var.p);
                pj2Var.f(y03Var.q);
                pj2Var.f(y03Var.r);
                pj2Var.f(y03Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends w03<y03> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w03
        /* renamed from: b */
        public y03 a(@NonNull oj2 oj2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj2Var)) == null) {
                y03 y03Var = new y03();
                y03Var.a = oj2Var.readInt();
                y03Var.b = oj2Var.g();
                y03Var.c = oj2Var.g();
                y03Var.d = oj2Var.g();
                y03Var.e = oj2Var.readInt();
                y03Var.f = oj2Var.readBoolean();
                y03Var.g = oj2Var.g();
                y03Var.h = oj2Var.readBoolean();
                y03Var.i = oj2Var.readBoolean();
                y03Var.j = oj2Var.g();
                y03Var.k = oj2Var.readBoolean();
                y03Var.l = oj2Var.readBoolean();
                y03Var.m = oj2Var.readBoolean();
                y03Var.n = oj2Var.readBoolean();
                y03Var.o = oj2Var.readBoolean();
                y03Var.p = oj2Var.readBoolean();
                y03Var.q = oj2Var.g();
                y03Var.r = oj2Var.g();
                y03Var.s = oj2Var.g();
                return y03Var;
            }
            return (y03) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755195659, "Lcom/repackage/y03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755195659, "Lcom/repackage/y03;");
                return;
            }
        }
        t = tg1.a;
        u = new a();
        v = new b();
    }

    public y03() {
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
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = -16777216;
        this.c = "#ffffff";
        this.j = "default";
        this.e = -1;
        this.f = false;
    }

    public static y03 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (y03) invokeL.objValue;
    }

    public static y03 b(String str, @NonNull y03 y03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, y03Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return y03Var;
            }
            try {
                return e(new JSONObject(str), y03Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return y03Var;
            }
        }
        return (y03) invokeLL.objValue;
    }

    public static y03 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            y03 y03Var = new y03();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            y03Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            y03Var.c = optString2;
            y03Var.b = optJSONObject.optString("navigationBarTitleText");
            y03Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            y03Var.e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            y03Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            y03Var.g = optJSONObject.optString("onReachBottomDistance");
            y03Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            y03Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            y03Var.j = optJSONObject.optString("navigationStyle", "default");
            y03Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            y03Var.q = optJSONObject.optString("textSizeAdjust");
            y03Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return y03Var;
        }
        return (y03) invokeL.objValue;
    }

    public static y03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new y03();
        }
        return (y03) invokeV.objValue;
    }

    public static y03 e(JSONObject jSONObject, @NonNull y03 y03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, y03Var)) == null) {
            y03 y03Var2 = new y03();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            y03Var2.a = TextUtils.isEmpty(optString) ? y03Var.a : SwanAppConfigData.t(optString);
            y03Var2.b = jSONObject.optString("navigationBarTitleText", y03Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = y03Var.c;
            }
            y03Var2.c = optString2;
            y03Var2.d = jSONObject.optString("backgroundTextStyle", y03Var.d);
            y03Var2.e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : y03Var.e;
            y03Var2.f = jSONObject.optBoolean("enablePullDownRefresh", y03Var.f);
            y03Var2.g = jSONObject.optString("onReachBottomDistance", y03Var.g);
            y03Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", y03Var.h);
            y03Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", y03Var.i);
            y03Var2.j = jSONObject.optString("navigationStyle", y03Var.j);
            y03Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", y03Var.k);
            y03Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            y03Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            y03Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            y03Var2.o = jSONObject.optBoolean("_hasVideo", false);
            y03Var2.r = jSONObject.optString("viewMode", y03Var.r);
            y03Var2.s = jSONObject.optString("htmlFontSize", y03Var.s);
            jSONObject.optJSONArray("fontFace");
            return y03Var2;
        }
        return (y03) invokeLL.objValue;
    }

    public static boolean f(y03 y03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, y03Var)) == null) {
            if (y03Var == null) {
                return false;
            }
            return y03Var.h || TextUtils.equals(y03Var.j, "custom");
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }
}
