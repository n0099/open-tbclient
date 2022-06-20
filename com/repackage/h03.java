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
/* loaded from: classes6.dex */
public class h03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final g03<h03> u;
    public static final f03<h03> v;
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

    /* loaded from: classes6.dex */
    public static class a extends g03<h03> {
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
        @Override // com.repackage.g03
        /* renamed from: b */
        public void a(@NonNull h03 h03Var, @NonNull yi2 yi2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h03Var, yi2Var) == null) {
                yi2Var.writeInt(h03Var.a);
                yi2Var.f(h03Var.b);
                yi2Var.f(h03Var.c);
                yi2Var.f(h03Var.d);
                yi2Var.writeInt(h03Var.e);
                yi2Var.writeBoolean(h03Var.f);
                yi2Var.f(h03Var.g);
                yi2Var.writeBoolean(h03Var.h);
                yi2Var.writeBoolean(h03Var.i);
                yi2Var.f(h03Var.j);
                yi2Var.writeBoolean(h03Var.k);
                yi2Var.writeBoolean(h03Var.l);
                yi2Var.writeBoolean(h03Var.m);
                yi2Var.writeBoolean(h03Var.n);
                yi2Var.writeBoolean(h03Var.o);
                yi2Var.writeBoolean(h03Var.p);
                yi2Var.f(h03Var.q);
                yi2Var.f(h03Var.r);
                yi2Var.f(h03Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends f03<h03> {
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
        @Override // com.repackage.f03
        /* renamed from: b */
        public h03 a(@NonNull xi2 xi2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi2Var)) == null) {
                h03 h03Var = new h03();
                h03Var.a = xi2Var.readInt();
                h03Var.b = xi2Var.g();
                h03Var.c = xi2Var.g();
                h03Var.d = xi2Var.g();
                h03Var.e = xi2Var.readInt();
                h03Var.f = xi2Var.readBoolean();
                h03Var.g = xi2Var.g();
                h03Var.h = xi2Var.readBoolean();
                h03Var.i = xi2Var.readBoolean();
                h03Var.j = xi2Var.g();
                h03Var.k = xi2Var.readBoolean();
                h03Var.l = xi2Var.readBoolean();
                h03Var.m = xi2Var.readBoolean();
                h03Var.n = xi2Var.readBoolean();
                h03Var.o = xi2Var.readBoolean();
                h03Var.p = xi2Var.readBoolean();
                h03Var.q = xi2Var.g();
                h03Var.r = xi2Var.g();
                h03Var.s = xi2Var.g();
                return h03Var;
            }
            return (h03) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755702106, "Lcom/repackage/h03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755702106, "Lcom/repackage/h03;");
                return;
            }
        }
        t = cg1.a;
        u = new a();
        v = new b();
    }

    public h03() {
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

    public static h03 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (h03) invokeL.objValue;
    }

    public static h03 b(String str, @NonNull h03 h03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, h03Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return h03Var;
            }
            try {
                return e(new JSONObject(str), h03Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return h03Var;
            }
        }
        return (h03) invokeLL.objValue;
    }

    public static h03 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            h03 h03Var = new h03();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            h03Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            h03Var.c = optString2;
            h03Var.b = optJSONObject.optString("navigationBarTitleText");
            h03Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            h03Var.e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            h03Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            h03Var.g = optJSONObject.optString("onReachBottomDistance");
            h03Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            h03Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            h03Var.j = optJSONObject.optString("navigationStyle", "default");
            h03Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            h03Var.q = optJSONObject.optString("textSizeAdjust");
            h03Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return h03Var;
        }
        return (h03) invokeL.objValue;
    }

    public static h03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new h03();
        }
        return (h03) invokeV.objValue;
    }

    public static h03 e(JSONObject jSONObject, @NonNull h03 h03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, h03Var)) == null) {
            h03 h03Var2 = new h03();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            h03Var2.a = TextUtils.isEmpty(optString) ? h03Var.a : SwanAppConfigData.t(optString);
            h03Var2.b = jSONObject.optString("navigationBarTitleText", h03Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = h03Var.c;
            }
            h03Var2.c = optString2;
            h03Var2.d = jSONObject.optString("backgroundTextStyle", h03Var.d);
            h03Var2.e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : h03Var.e;
            h03Var2.f = jSONObject.optBoolean("enablePullDownRefresh", h03Var.f);
            h03Var2.g = jSONObject.optString("onReachBottomDistance", h03Var.g);
            h03Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", h03Var.h);
            h03Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", h03Var.i);
            h03Var2.j = jSONObject.optString("navigationStyle", h03Var.j);
            h03Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", h03Var.k);
            h03Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            h03Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            h03Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            h03Var2.o = jSONObject.optBoolean("_hasVideo", false);
            h03Var2.r = jSONObject.optString("viewMode", h03Var.r);
            h03Var2.s = jSONObject.optString("htmlFontSize", h03Var.s);
            jSONObject.optJSONArray("fontFace");
            return h03Var2;
        }
        return (h03) invokeLL.objValue;
    }

    public static boolean f(h03 h03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, h03Var)) == null) {
            if (h03Var == null) {
                return false;
            }
            return h03Var.h || TextUtils.equals(h03Var.j, "custom");
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
