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
public class wz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final vz2<wz2> u;
    public static final uz2<wz2> v;
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
    public static class a extends vz2<wz2> {
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
        @Override // com.repackage.vz2
        /* renamed from: b */
        public void a(@NonNull wz2 wz2Var, @NonNull ni2 ni2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz2Var, ni2Var) == null) {
                ni2Var.writeInt(wz2Var.a);
                ni2Var.f(wz2Var.b);
                ni2Var.f(wz2Var.c);
                ni2Var.f(wz2Var.d);
                ni2Var.writeInt(wz2Var.e);
                ni2Var.writeBoolean(wz2Var.f);
                ni2Var.f(wz2Var.g);
                ni2Var.writeBoolean(wz2Var.h);
                ni2Var.writeBoolean(wz2Var.i);
                ni2Var.f(wz2Var.j);
                ni2Var.writeBoolean(wz2Var.k);
                ni2Var.writeBoolean(wz2Var.l);
                ni2Var.writeBoolean(wz2Var.m);
                ni2Var.writeBoolean(wz2Var.n);
                ni2Var.writeBoolean(wz2Var.o);
                ni2Var.writeBoolean(wz2Var.p);
                ni2Var.f(wz2Var.q);
                ni2Var.f(wz2Var.r);
                ni2Var.f(wz2Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends uz2<wz2> {
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
        @Override // com.repackage.uz2
        /* renamed from: b */
        public wz2 a(@NonNull mi2 mi2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mi2Var)) == null) {
                wz2 wz2Var = new wz2();
                wz2Var.a = mi2Var.readInt();
                wz2Var.b = mi2Var.g();
                wz2Var.c = mi2Var.g();
                wz2Var.d = mi2Var.g();
                wz2Var.e = mi2Var.readInt();
                wz2Var.f = mi2Var.readBoolean();
                wz2Var.g = mi2Var.g();
                wz2Var.h = mi2Var.readBoolean();
                wz2Var.i = mi2Var.readBoolean();
                wz2Var.j = mi2Var.g();
                wz2Var.k = mi2Var.readBoolean();
                wz2Var.l = mi2Var.readBoolean();
                wz2Var.m = mi2Var.readBoolean();
                wz2Var.n = mi2Var.readBoolean();
                wz2Var.o = mi2Var.readBoolean();
                wz2Var.p = mi2Var.readBoolean();
                wz2Var.q = mi2Var.g();
                wz2Var.r = mi2Var.g();
                wz2Var.s = mi2Var.g();
                return wz2Var;
            }
            return (wz2) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755184158, "Lcom/repackage/wz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755184158, "Lcom/repackage/wz2;");
                return;
            }
        }
        t = rf1.a;
        u = new a();
        v = new b();
    }

    public wz2() {
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

    public static wz2 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (wz2) invokeL.objValue;
    }

    public static wz2 b(String str, @NonNull wz2 wz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, wz2Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return wz2Var;
            }
            try {
                return e(new JSONObject(str), wz2Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return wz2Var;
            }
        }
        return (wz2) invokeLL.objValue;
    }

    public static wz2 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            wz2 wz2Var = new wz2();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            wz2Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            wz2Var.c = optString2;
            wz2Var.b = optJSONObject.optString("navigationBarTitleText");
            wz2Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            wz2Var.e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            wz2Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            wz2Var.g = optJSONObject.optString("onReachBottomDistance");
            wz2Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            wz2Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            wz2Var.j = optJSONObject.optString("navigationStyle", "default");
            wz2Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            wz2Var.q = optJSONObject.optString("textSizeAdjust");
            wz2Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return wz2Var;
        }
        return (wz2) invokeL.objValue;
    }

    public static wz2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new wz2();
        }
        return (wz2) invokeV.objValue;
    }

    public static wz2 e(JSONObject jSONObject, @NonNull wz2 wz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, wz2Var)) == null) {
            wz2 wz2Var2 = new wz2();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            wz2Var2.a = TextUtils.isEmpty(optString) ? wz2Var.a : SwanAppConfigData.t(optString);
            wz2Var2.b = jSONObject.optString("navigationBarTitleText", wz2Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = wz2Var.c;
            }
            wz2Var2.c = optString2;
            wz2Var2.d = jSONObject.optString("backgroundTextStyle", wz2Var.d);
            wz2Var2.e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : wz2Var.e;
            wz2Var2.f = jSONObject.optBoolean("enablePullDownRefresh", wz2Var.f);
            wz2Var2.g = jSONObject.optString("onReachBottomDistance", wz2Var.g);
            wz2Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", wz2Var.h);
            wz2Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", wz2Var.i);
            wz2Var2.j = jSONObject.optString("navigationStyle", wz2Var.j);
            wz2Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", wz2Var.k);
            wz2Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            wz2Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            wz2Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            wz2Var2.o = jSONObject.optBoolean("_hasVideo", false);
            wz2Var2.r = jSONObject.optString("viewMode", wz2Var.r);
            wz2Var2.s = jSONObject.optString("htmlFontSize", wz2Var.s);
            jSONObject.optJSONArray("fontFace");
            return wz2Var2;
        }
        return (wz2) invokeLL.objValue;
    }

    public static boolean f(wz2 wz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, wz2Var)) == null) {
            if (wz2Var == null) {
                return false;
            }
            return wz2Var.h || TextUtils.equals(wz2Var.j, "custom");
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
