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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final w03<x03> u;
    public static final v03<x03> v;
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
    public static class a extends w03<x03> {
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
        @Override // com.repackage.w03
        /* renamed from: b */
        public void a(@NonNull x03 x03Var, @NonNull oj2 oj2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x03Var, oj2Var) == null) {
                oj2Var.writeInt(x03Var.a);
                oj2Var.f(x03Var.b);
                oj2Var.f(x03Var.c);
                oj2Var.f(x03Var.d);
                oj2Var.writeInt(x03Var.e);
                oj2Var.writeBoolean(x03Var.f);
                oj2Var.f(x03Var.g);
                oj2Var.writeBoolean(x03Var.h);
                oj2Var.writeBoolean(x03Var.i);
                oj2Var.f(x03Var.j);
                oj2Var.writeBoolean(x03Var.k);
                oj2Var.writeBoolean(x03Var.l);
                oj2Var.writeBoolean(x03Var.m);
                oj2Var.writeBoolean(x03Var.n);
                oj2Var.writeBoolean(x03Var.o);
                oj2Var.writeBoolean(x03Var.p);
                oj2Var.f(x03Var.q);
                oj2Var.f(x03Var.r);
                oj2Var.f(x03Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends v03<x03> {
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
        @Override // com.repackage.v03
        /* renamed from: b */
        public x03 a(@NonNull nj2 nj2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nj2Var)) == null) {
                x03 x03Var = new x03();
                x03Var.a = nj2Var.readInt();
                x03Var.b = nj2Var.g();
                x03Var.c = nj2Var.g();
                x03Var.d = nj2Var.g();
                x03Var.e = nj2Var.readInt();
                x03Var.f = nj2Var.readBoolean();
                x03Var.g = nj2Var.g();
                x03Var.h = nj2Var.readBoolean();
                x03Var.i = nj2Var.readBoolean();
                x03Var.j = nj2Var.g();
                x03Var.k = nj2Var.readBoolean();
                x03Var.l = nj2Var.readBoolean();
                x03Var.m = nj2Var.readBoolean();
                x03Var.n = nj2Var.readBoolean();
                x03Var.o = nj2Var.readBoolean();
                x03Var.p = nj2Var.readBoolean();
                x03Var.q = nj2Var.g();
                x03Var.r = nj2Var.g();
                x03Var.s = nj2Var.g();
                return x03Var;
            }
            return (x03) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225450, "Lcom/repackage/x03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225450, "Lcom/repackage/x03;");
                return;
            }
        }
        t = sg1.a;
        u = new a();
        v = new b();
    }

    public x03() {
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

    public static x03 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (x03) invokeL.objValue;
    }

    public static x03 b(String str, @NonNull x03 x03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, x03Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return x03Var;
            }
            try {
                return e(new JSONObject(str), x03Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return x03Var;
            }
        }
        return (x03) invokeLL.objValue;
    }

    public static x03 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            x03 x03Var = new x03();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            x03Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            x03Var.c = optString2;
            x03Var.b = optJSONObject.optString("navigationBarTitleText");
            x03Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            x03Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            x03Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            x03Var.g = optJSONObject.optString("onReachBottomDistance");
            x03Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            x03Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            x03Var.j = optJSONObject.optString("navigationStyle", "default");
            x03Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            x03Var.q = optJSONObject.optString("textSizeAdjust");
            x03Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return x03Var;
        }
        return (x03) invokeL.objValue;
    }

    public static x03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new x03();
        }
        return (x03) invokeV.objValue;
    }

    public static x03 e(JSONObject jSONObject, @NonNull x03 x03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, x03Var)) == null) {
            x03 x03Var2 = new x03();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            x03Var2.a = TextUtils.isEmpty(optString) ? x03Var.a : SwanAppConfigData.t(optString);
            x03Var2.b = jSONObject.optString("navigationBarTitleText", x03Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = x03Var.c;
            }
            x03Var2.c = optString2;
            x03Var2.d = jSONObject.optString("backgroundTextStyle", x03Var.d);
            x03Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : x03Var.e;
            x03Var2.f = jSONObject.optBoolean("enablePullDownRefresh", x03Var.f);
            x03Var2.g = jSONObject.optString("onReachBottomDistance", x03Var.g);
            x03Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", x03Var.h);
            x03Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", x03Var.i);
            x03Var2.j = jSONObject.optString("navigationStyle", x03Var.j);
            x03Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", x03Var.k);
            x03Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            x03Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            x03Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            x03Var2.o = jSONObject.optBoolean("_hasVideo", false);
            x03Var2.r = jSONObject.optString("viewMode", x03Var.r);
            x03Var2.s = jSONObject.optString("htmlFontSize", x03Var.s);
            jSONObject.optJSONArray("fontFace");
            return x03Var2;
        }
        return (x03) invokeLL.objValue;
    }

    public static boolean f(x03 x03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, x03Var)) == null) {
            if (x03Var == null) {
                return false;
            }
            return x03Var.h || TextUtils.equals(x03Var.j, "custom");
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
