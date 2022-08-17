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
public class o13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final n13<o13> u;
    public static final m13<o13> v;
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
    public static class a extends n13<o13> {
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
        @Override // com.repackage.n13
        /* renamed from: b */
        public void a(@NonNull o13 o13Var, @NonNull fk2 fk2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o13Var, fk2Var) == null) {
                fk2Var.writeInt(o13Var.a);
                fk2Var.f(o13Var.b);
                fk2Var.f(o13Var.c);
                fk2Var.f(o13Var.d);
                fk2Var.writeInt(o13Var.e);
                fk2Var.writeBoolean(o13Var.f);
                fk2Var.f(o13Var.g);
                fk2Var.writeBoolean(o13Var.h);
                fk2Var.writeBoolean(o13Var.i);
                fk2Var.f(o13Var.j);
                fk2Var.writeBoolean(o13Var.k);
                fk2Var.writeBoolean(o13Var.l);
                fk2Var.writeBoolean(o13Var.m);
                fk2Var.writeBoolean(o13Var.n);
                fk2Var.writeBoolean(o13Var.o);
                fk2Var.writeBoolean(o13Var.p);
                fk2Var.f(o13Var.q);
                fk2Var.f(o13Var.r);
                fk2Var.f(o13Var.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends m13<o13> {
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
        @Override // com.repackage.m13
        /* renamed from: b */
        public o13 a(@NonNull ek2 ek2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek2Var)) == null) {
                o13 o13Var = new o13();
                o13Var.a = ek2Var.readInt();
                o13Var.b = ek2Var.g();
                o13Var.c = ek2Var.g();
                o13Var.d = ek2Var.g();
                o13Var.e = ek2Var.readInt();
                o13Var.f = ek2Var.readBoolean();
                o13Var.g = ek2Var.g();
                o13Var.h = ek2Var.readBoolean();
                o13Var.i = ek2Var.readBoolean();
                o13Var.j = ek2Var.g();
                o13Var.k = ek2Var.readBoolean();
                o13Var.l = ek2Var.readBoolean();
                o13Var.m = ek2Var.readBoolean();
                o13Var.n = ek2Var.readBoolean();
                o13Var.o = ek2Var.readBoolean();
                o13Var.p = ek2Var.readBoolean();
                o13Var.q = ek2Var.g();
                o13Var.r = ek2Var.g();
                o13Var.s = ek2Var.g();
                return o13Var;
            }
            return (o13) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755492608, "Lcom/repackage/o13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755492608, "Lcom/repackage/o13;");
                return;
            }
        }
        t = jh1.a;
        u = new a();
        v = new b();
    }

    public o13() {
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

    public static o13 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (o13) invokeL.objValue;
    }

    public static o13 b(String str, @NonNull o13 o13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, o13Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return o13Var;
            }
            try {
                return e(new JSONObject(str), o13Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return o13Var;
            }
        }
        return (o13) invokeLL.objValue;
    }

    public static o13 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            o13 o13Var = new o13();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            o13Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            o13Var.c = optString2;
            o13Var.b = optJSONObject.optString("navigationBarTitleText");
            o13Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            o13Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            o13Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            o13Var.g = optJSONObject.optString("onReachBottomDistance");
            o13Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            o13Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            o13Var.j = optJSONObject.optString("navigationStyle", "default");
            o13Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            o13Var.q = optJSONObject.optString("textSizeAdjust");
            o13Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return o13Var;
        }
        return (o13) invokeL.objValue;
    }

    public static o13 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new o13();
        }
        return (o13) invokeV.objValue;
    }

    public static o13 e(JSONObject jSONObject, @NonNull o13 o13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, o13Var)) == null) {
            o13 o13Var2 = new o13();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            o13Var2.a = TextUtils.isEmpty(optString) ? o13Var.a : SwanAppConfigData.t(optString);
            o13Var2.b = jSONObject.optString("navigationBarTitleText", o13Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = o13Var.c;
            }
            o13Var2.c = optString2;
            o13Var2.d = jSONObject.optString("backgroundTextStyle", o13Var.d);
            o13Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : o13Var.e;
            o13Var2.f = jSONObject.optBoolean("enablePullDownRefresh", o13Var.f);
            o13Var2.g = jSONObject.optString("onReachBottomDistance", o13Var.g);
            o13Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", o13Var.h);
            o13Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", o13Var.i);
            o13Var2.j = jSONObject.optString("navigationStyle", o13Var.j);
            o13Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", o13Var.k);
            o13Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            o13Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            o13Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            o13Var2.o = jSONObject.optBoolean("_hasVideo", false);
            o13Var2.r = jSONObject.optString("viewMode", o13Var.r);
            o13Var2.s = jSONObject.optString("htmlFontSize", o13Var.s);
            jSONObject.optJSONArray("fontFace");
            return o13Var2;
        }
        return (o13) invokeLL.objValue;
    }

    public static boolean f(o13 o13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, o13Var)) == null) {
            if (o13Var == null) {
                return false;
            }
            return o13Var.h || TextUtils.equals(o13Var.j, "custom");
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
