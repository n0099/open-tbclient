package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gl2;
/* loaded from: classes7.dex */
public class v14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends pw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u14 c;

        public a(u14 u14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pw2, com.repackage.qw2, com.repackage.ow2
        public void onEvent(@NonNull mw2 mw2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mw2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = mw2Var.a() != null ? mw2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (v14.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                u14 u14Var = this.c;
                u14Var.m = i;
                c73.x("976", u14Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755284040, "Lcom/repackage/v14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755284040, "Lcom/repackage/v14;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void b(u14 u14Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, u14Var) == null) || u14Var == null) {
            return;
        }
        ex2.P().W(null, xr2.class, new a(u14Var));
    }

    public static void c(ee1 ee1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, ee1Var) == null) || ee1Var == null || (a2 = ee1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(sw3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= sw3.a()) {
            return;
        }
        u14 u14Var = new u14();
        u14Var.b = "stuck";
        u14Var.e = "jserror";
        u14Var.f = j03.f0();
        if (j03.L() != null && j03.L().X() != null) {
            gl2.a X = j03.L().X();
            u14Var.c = X.T();
            u14Var.a = c73.n(X.G());
        }
        u14Var.l = str + ";" + str2;
        u14Var.k = g14.d() ? 20 : 10;
        u14Var.n = sw3.b();
        u14Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(u14Var);
    }
}
