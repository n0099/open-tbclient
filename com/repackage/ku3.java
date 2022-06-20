package com.repackage;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oy1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ku3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements oy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ zr1 c;
        public final /* synthetic */ ku3 d;

        public a(ku3 ku3Var, boolean z, Context context, zr1 zr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku3Var, Boolean.valueOf(z), context, zr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ku3Var;
            this.a = z;
            this.b = context;
            this.c = zr1Var;
        }

        @Override // com.repackage.oy1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.d.g(this.b, this.c);
                        return;
                    }
                    pw1.c(this.b, false);
                    this.d.e(this.c, true, "setEnableDebug:ok");
                    return;
                }
                oy1.c(this.b, str);
                ku3 ku3Var = this.d;
                ku3Var.e(this.c, false, ku3Var.f(str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements le3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ zr1 b;
        public final /* synthetic */ ku3 c;

        public b(ku3 ku3Var, Context context, zr1 zr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ku3Var, context, zr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ku3Var;
            this.a = context;
            this.b = zr1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    pw1.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                iu3.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public ku3(c72 c72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void h(JSONObject jSONObject) {
        sz2 M;
        SwanAppActivity x;
        a72 g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (M = sz2.M()) == null || !M.w0() || (x = M.x()) == null) {
            return;
        }
        rc2 Q = x.Q();
        if ((Q instanceof sv3) && (g1 = ((sv3) Q).g1()) != null) {
            g1.dispatchEvent(fu3.a(jSONObject));
        }
    }

    public final void d(@NonNull sz2 sz2Var, @NonNull Context context, @NonNull zr1 zr1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{sz2Var, context, zr1Var, Boolean.valueOf(z)}) == null) {
            oy1.a(sz2Var, context, new a(this, z, context, zr1Var));
        }
    }

    public final void e(zr1 zr1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zr1Var, Boolean.valueOf(z), str}) == null) {
            au3 au3Var = new au3();
            au3Var.errMsg = str;
            d24.call(zr1Var, z, au3Var);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, zr1 zr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, zr1Var) == null) {
            iu3.m().o(new b(this, context, zr1Var));
        }
    }

    public void i(JsObject jsObject) {
        zr1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = zr1.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        sz2 M = sz2.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = M.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == pw1.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, x, F, l);
        }
    }
}
