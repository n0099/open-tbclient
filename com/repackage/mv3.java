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
import com.repackage.qz1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements qz1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ bt1 c;
        public final /* synthetic */ mv3 d;

        public a(mv3 mv3Var, boolean z, Context context, bt1 bt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv3Var, Boolean.valueOf(z), context, bt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mv3Var;
            this.a = z;
            this.b = context;
            this.c = bt1Var;
        }

        @Override // com.repackage.qz1.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.d.g(this.b, this.c);
                        return;
                    }
                    rx1.c(this.b, false);
                    this.d.e(this.c, true, "setEnableDebug:ok");
                    return;
                }
                qz1.c(this.b, str);
                mv3 mv3Var = this.d;
                mv3Var.e(this.c, false, mv3Var.f(str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ bt1 b;
        public final /* synthetic */ mv3 c;

        public b(mv3 mv3Var, Context context, bt1 bt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv3Var, context, bt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mv3Var;
            this.a = context;
            this.b = bt1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    rx1.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                kv3.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public mv3(e82 e82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var};
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
        u03 L;
        SwanAppActivity x;
        c82 g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (L = u03.L()) == null || !L.v0() || (x = L.x()) == null) {
            return;
        }
        td2 frame = x.getFrame();
        if ((frame instanceof uw3) && (g1 = ((uw3) frame).g1()) != null) {
            g1.dispatchEvent(hv3.a(jSONObject));
        }
    }

    public final void d(@NonNull u03 u03Var, @NonNull Context context, @NonNull bt1 bt1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{u03Var, context, bt1Var, Boolean.valueOf(z)}) == null) {
            qz1.a(u03Var, context, new a(this, z, context, bt1Var));
        }
    }

    public final void e(bt1 bt1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bt1Var, Boolean.valueOf(z), str}) == null) {
            cv3 cv3Var = new cv3();
            cv3Var.errMsg = str;
            f34.call(bt1Var, z, cv3Var);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, bt1 bt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, bt1Var) == null) {
            kv3.m().o(new b(this, context, bt1Var));
        }
    }

    public void i(JsObject jsObject) {
        bt1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = bt1.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        u03 L = u03.L();
        if (L == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity x = L.x();
        if (x == null) {
            e(F, false, f("internal error"));
        } else if (l == rx1.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(L, x, F, l);
        }
    }
}
