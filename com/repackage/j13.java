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
public class j13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final i13<j13> u;
    public static final h13<j13> v;
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
    public static class a extends i13<j13> {
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
        @Override // com.repackage.i13
        /* renamed from: b */
        public void a(@NonNull j13 j13Var, @NonNull ak2 ak2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j13Var, ak2Var) == null) {
                ak2Var.writeInt(j13Var.a);
                ak2Var.f(j13Var.b);
                ak2Var.f(j13Var.c);
                ak2Var.f(j13Var.d);
                ak2Var.writeInt(j13Var.e);
                ak2Var.writeBoolean(j13Var.f);
                ak2Var.f(j13Var.g);
                ak2Var.writeBoolean(j13Var.h);
                ak2Var.writeBoolean(j13Var.i);
                ak2Var.f(j13Var.j);
                ak2Var.writeBoolean(j13Var.k);
                ak2Var.writeBoolean(j13Var.l);
                ak2Var.writeBoolean(j13Var.m);
                ak2Var.writeBoolean(j13Var.n);
                ak2Var.writeBoolean(j13Var.o);
                ak2Var.writeBoolean(j13Var.p);
                ak2Var.f(j13Var.q);
                ak2Var.f(j13Var.r);
                ak2Var.f(j13Var.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends h13<j13> {
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
        @Override // com.repackage.h13
        /* renamed from: b */
        public j13 a(@NonNull zj2 zj2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj2Var)) == null) {
                j13 j13Var = new j13();
                j13Var.a = zj2Var.readInt();
                j13Var.b = zj2Var.g();
                j13Var.c = zj2Var.g();
                j13Var.d = zj2Var.g();
                j13Var.e = zj2Var.readInt();
                j13Var.f = zj2Var.readBoolean();
                j13Var.g = zj2Var.g();
                j13Var.h = zj2Var.readBoolean();
                j13Var.i = zj2Var.readBoolean();
                j13Var.j = zj2Var.g();
                j13Var.k = zj2Var.readBoolean();
                j13Var.l = zj2Var.readBoolean();
                j13Var.m = zj2Var.readBoolean();
                j13Var.n = zj2Var.readBoolean();
                j13Var.o = zj2Var.readBoolean();
                j13Var.p = zj2Var.readBoolean();
                j13Var.q = zj2Var.g();
                j13Var.r = zj2Var.g();
                j13Var.s = zj2Var.g();
                return j13Var;
            }
            return (j13) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755641563, "Lcom/repackage/j13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755641563, "Lcom/repackage/j13;");
                return;
            }
        }
        t = eh1.a;
        u = new a();
        v = new b();
    }

    public j13() {
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

    public static j13 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (j13) invokeL.objValue;
    }

    public static j13 b(String str, @NonNull j13 j13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, j13Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return j13Var;
            }
            try {
                return e(new JSONObject(str), j13Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return j13Var;
            }
        }
        return (j13) invokeLL.objValue;
    }

    public static j13 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            j13 j13Var = new j13();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            j13Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            j13Var.c = optString2;
            j13Var.b = optJSONObject.optString("navigationBarTitleText");
            j13Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            j13Var.e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            j13Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            j13Var.g = optJSONObject.optString("onReachBottomDistance");
            j13Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            j13Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            j13Var.j = optJSONObject.optString("navigationStyle", "default");
            j13Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            j13Var.q = optJSONObject.optString("textSizeAdjust");
            j13Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return j13Var;
        }
        return (j13) invokeL.objValue;
    }

    public static j13 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new j13();
        }
        return (j13) invokeV.objValue;
    }

    public static j13 e(JSONObject jSONObject, @NonNull j13 j13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, j13Var)) == null) {
            j13 j13Var2 = new j13();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            j13Var2.a = TextUtils.isEmpty(optString) ? j13Var.a : SwanAppConfigData.t(optString);
            j13Var2.b = jSONObject.optString("navigationBarTitleText", j13Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = j13Var.c;
            }
            j13Var2.c = optString2;
            j13Var2.d = jSONObject.optString("backgroundTextStyle", j13Var.d);
            j13Var2.e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : j13Var.e;
            j13Var2.f = jSONObject.optBoolean("enablePullDownRefresh", j13Var.f);
            j13Var2.g = jSONObject.optString("onReachBottomDistance", j13Var.g);
            j13Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", j13Var.h);
            j13Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", j13Var.i);
            j13Var2.j = jSONObject.optString("navigationStyle", j13Var.j);
            j13Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", j13Var.k);
            j13Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            j13Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            j13Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            j13Var2.o = jSONObject.optBoolean("_hasVideo", false);
            j13Var2.r = jSONObject.optString("viewMode", j13Var.r);
            j13Var2.s = jSONObject.optString("htmlFontSize", j13Var.s);
            jSONObject.optJSONArray("fontFace");
            return j13Var2;
        }
        return (j13) invokeLL.objValue;
    }

    public static boolean f(j13 j13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, j13Var)) == null) {
            if (j13Var == null) {
                return false;
            }
            return j13Var.h || TextUtils.equals(j13Var.j, "custom");
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
