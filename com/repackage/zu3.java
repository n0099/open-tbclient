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
import com.repackage.dz1;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements dz1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ os1 c;
        public final /* synthetic */ zu3 d;

        public a(zu3 zu3Var, boolean z, Context context, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu3Var, Boolean.valueOf(z), context, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zu3Var;
            this.a = z;
            this.b = context;
            this.c = os1Var;
        }

        @Override // com.repackage.dz1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.d.g(this.b, this.c);
                        return;
                    }
                    ex1.c(this.b, false);
                    this.d.e(this.c, true, "setEnableDebug:ok");
                    return;
                }
                dz1.c(this.b, str);
                zu3 zu3Var = this.d;
                zu3Var.e(this.c, false, zu3Var.f(str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ zu3 c;

        public b(zu3 zu3Var, Context context, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu3Var, context, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zu3Var;
            this.a = context;
            this.b = os1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    ex1.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                xu3.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public zu3(r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
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
        h03 M;
        SwanAppActivity w;
        p72 g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (M = h03.M()) == null || !M.w0() || (w = M.w()) == null) {
            return;
        }
        gd2 Q = w.Q();
        if ((Q instanceof hw3) && (g1 = ((hw3) Q).g1()) != null) {
            g1.dispatchEvent(uu3.a(jSONObject));
        }
    }

    public final void d(@NonNull h03 h03Var, @NonNull Context context, @NonNull os1 os1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{h03Var, context, os1Var, Boolean.valueOf(z)}) == null) {
            dz1.a(h03Var, context, new a(this, z, context, os1Var));
        }
    }

    public final void e(os1 os1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{os1Var, Boolean.valueOf(z), str}) == null) {
            pu3 pu3Var = new pu3();
            pu3Var.errMsg = str;
            s24.call(os1Var, z, pu3Var);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, os1Var) == null) {
            xu3.m().o(new b(this, context, os1Var));
        }
    }

    public void i(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        h03 M = h03.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(F, false, f("internal error"));
        } else if (l == ex1.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, w, F, l);
        }
    }
}
