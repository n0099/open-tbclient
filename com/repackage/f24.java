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
import com.repackage.rl2;
/* loaded from: classes6.dex */
public class f24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ax2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e24 c;

        public a(e24 e24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e24Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ax2, com.repackage.bx2, com.repackage.zw2
        public void onEvent(@NonNull xw2 xw2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xw2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = xw2Var.a() != null ? xw2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (f24.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                e24 e24Var = this.c;
                e24Var.m = i;
                n73.x("976", e24Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755759735, "Lcom/repackage/f24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755759735, "Lcom/repackage/f24;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void b(e24 e24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, e24Var) == null) || e24Var == null) {
            return;
        }
        px2.P().W(null, is2.class, new a(e24Var));
    }

    public static void c(pe1 pe1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, pe1Var) == null) || pe1Var == null || (a2 = pe1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(dx3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= dx3.a()) {
            return;
        }
        e24 e24Var = new e24();
        e24Var.b = "stuck";
        e24Var.e = "jserror";
        e24Var.f = u03.f0();
        if (u03.L() != null && u03.L().X() != null) {
            rl2.a X = u03.L().X();
            e24Var.c = X.T();
            e24Var.a = n73.n(X.G());
        }
        e24Var.l = str + ";" + str2;
        e24Var.k = q14.d() ? 20 : 10;
        e24Var.n = dx3.b();
        e24Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(e24Var);
    }
}
