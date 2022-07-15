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
public class w03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final v03<w03> u;
    public static final u03<w03> v;
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
    public static class a extends v03<w03> {
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
        @Override // com.repackage.v03
        /* renamed from: b */
        public void a(@NonNull w03 w03Var, @NonNull nj2 nj2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w03Var, nj2Var) == null) {
                nj2Var.writeInt(w03Var.a);
                nj2Var.f(w03Var.b);
                nj2Var.f(w03Var.c);
                nj2Var.f(w03Var.d);
                nj2Var.writeInt(w03Var.e);
                nj2Var.writeBoolean(w03Var.f);
                nj2Var.f(w03Var.g);
                nj2Var.writeBoolean(w03Var.h);
                nj2Var.writeBoolean(w03Var.i);
                nj2Var.f(w03Var.j);
                nj2Var.writeBoolean(w03Var.k);
                nj2Var.writeBoolean(w03Var.l);
                nj2Var.writeBoolean(w03Var.m);
                nj2Var.writeBoolean(w03Var.n);
                nj2Var.writeBoolean(w03Var.o);
                nj2Var.writeBoolean(w03Var.p);
                nj2Var.f(w03Var.q);
                nj2Var.f(w03Var.r);
                nj2Var.f(w03Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends u03<w03> {
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
        @Override // com.repackage.u03
        /* renamed from: b */
        public w03 a(@NonNull mj2 mj2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mj2Var)) == null) {
                w03 w03Var = new w03();
                w03Var.a = mj2Var.readInt();
                w03Var.b = mj2Var.j();
                w03Var.c = mj2Var.j();
                w03Var.d = mj2Var.j();
                w03Var.e = mj2Var.readInt();
                w03Var.f = mj2Var.readBoolean();
                w03Var.g = mj2Var.j();
                w03Var.h = mj2Var.readBoolean();
                w03Var.i = mj2Var.readBoolean();
                w03Var.j = mj2Var.j();
                w03Var.k = mj2Var.readBoolean();
                w03Var.l = mj2Var.readBoolean();
                w03Var.m = mj2Var.readBoolean();
                w03Var.n = mj2Var.readBoolean();
                w03Var.o = mj2Var.readBoolean();
                w03Var.p = mj2Var.readBoolean();
                w03Var.q = mj2Var.j();
                w03Var.r = mj2Var.j();
                w03Var.s = mj2Var.j();
                return w03Var;
            }
            return (w03) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755255241, "Lcom/repackage/w03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755255241, "Lcom/repackage/w03;");
                return;
            }
        }
        t = rg1.a;
        u = new a();
        v = new b();
    }

    public w03() {
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

    public static w03 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (w03) invokeL.objValue;
    }

    public static w03 b(String str, @NonNull w03 w03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, w03Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return w03Var;
            }
            try {
                return e(new JSONObject(str), w03Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return w03Var;
            }
        }
        return (w03) invokeLL.objValue;
    }

    public static w03 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            w03 w03Var = new w03();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            w03Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            w03Var.c = optString2;
            w03Var.b = optJSONObject.optString("navigationBarTitleText");
            w03Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            w03Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            w03Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            w03Var.g = optJSONObject.optString("onReachBottomDistance");
            w03Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            w03Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            w03Var.j = optJSONObject.optString("navigationStyle", "default");
            w03Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            w03Var.q = optJSONObject.optString("textSizeAdjust");
            w03Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return w03Var;
        }
        return (w03) invokeL.objValue;
    }

    public static w03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new w03();
        }
        return (w03) invokeV.objValue;
    }

    public static w03 e(JSONObject jSONObject, @NonNull w03 w03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, w03Var)) == null) {
            w03 w03Var2 = new w03();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            w03Var2.a = TextUtils.isEmpty(optString) ? w03Var.a : SwanAppConfigData.t(optString);
            w03Var2.b = jSONObject.optString("navigationBarTitleText", w03Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = w03Var.c;
            }
            w03Var2.c = optString2;
            w03Var2.d = jSONObject.optString("backgroundTextStyle", w03Var.d);
            w03Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : w03Var.e;
            w03Var2.f = jSONObject.optBoolean("enablePullDownRefresh", w03Var.f);
            w03Var2.g = jSONObject.optString("onReachBottomDistance", w03Var.g);
            w03Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", w03Var.h);
            w03Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", w03Var.i);
            w03Var2.j = jSONObject.optString("navigationStyle", w03Var.j);
            w03Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", w03Var.k);
            w03Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            w03Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            w03Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            w03Var2.o = jSONObject.optBoolean("_hasVideo", false);
            w03Var2.r = jSONObject.optString("viewMode", w03Var.r);
            w03Var2.s = jSONObject.optString("htmlFontSize", w03Var.s);
            jSONObject.optJSONArray("fontFace");
            return w03Var2;
        }
        return (w03) invokeLL.objValue;
    }

    public static boolean f(w03 w03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, w03Var)) == null) {
            if (w03Var == null) {
                return false;
            }
            return w03Var.h || TextUtils.equals(w03Var.j, "custom");
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
