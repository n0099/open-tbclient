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
import com.repackage.dy1;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements dy1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ or1 c;
        public final /* synthetic */ zt3 d;

        public a(zt3 zt3Var, boolean z, Context context, or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt3Var, Boolean.valueOf(z), context, or1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zt3Var;
            this.a = z;
            this.b = context;
            this.c = or1Var;
        }

        @Override // com.repackage.dy1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.d.g(this.b, this.c);
                        return;
                    }
                    ew1.c(this.b, false);
                    this.d.e(this.c, true, "setEnableDebug:ok");
                    return;
                }
                dy1.c(this.b, str);
                zt3 zt3Var = this.d;
                zt3Var.e(this.c, false, zt3Var.f(str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ae3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ or1 b;
        public final /* synthetic */ zt3 c;

        public b(zt3 zt3Var, Context context, or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt3Var, context, or1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zt3Var;
            this.a = context;
            this.b = or1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    ew1.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                xt3.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public zt3(r62 r62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var};
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
        hz2 L;
        SwanAppActivity x;
        p62 g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (L = hz2.L()) == null || !L.v0() || (x = L.x()) == null) {
            return;
        }
        gc2 frame = x.getFrame();
        if ((frame instanceof hv3) && (g1 = ((hv3) frame).g1()) != null) {
            g1.dispatchEvent(ut3.a(jSONObject));
        }
    }

    public final void d(@NonNull hz2 hz2Var, @NonNull Context context, @NonNull or1 or1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hz2Var, context, or1Var, Boolean.valueOf(z)}) == null) {
            dy1.a(hz2Var, context, new a(this, z, context, or1Var));
        }
    }

    public final void e(or1 or1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{or1Var, Boolean.valueOf(z), str}) == null) {
            pt3 pt3Var = new pt3();
            pt3Var.errMsg = str;
            s14.call(or1Var, z, pt3Var);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, or1 or1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, or1Var) == null) {
            xt3.m().o(new b(this, context, or1Var));
        }
    }

    public void i(JsObject jsObject) {
        or1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = or1.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        hz2 L = hz2.L();
        if (L == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = L.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == ew1.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(L, x, F, l);
        }
    }
}
