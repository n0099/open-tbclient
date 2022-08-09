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
import com.repackage.wl2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class k24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends fx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j24 c;

        public a(j24 j24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j24Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fx2, com.repackage.gx2, com.repackage.ex2
        public void onEvent(@NonNull cx2 cx2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cx2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = cx2Var.a() != null ? cx2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (k24.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                j24 j24Var = this.c;
                j24Var.m = i;
                s73.x("976", j24Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755610780, "Lcom/repackage/k24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755610780, "Lcom/repackage/k24;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void b(j24 j24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, j24Var) == null) || j24Var == null) {
            return;
        }
        ux2.Q().X(null, ns2.class, new a(j24Var));
    }

    public static void c(te1 te1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, te1Var) == null) || te1Var == null || (a2 = te1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(ix3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= ix3.a()) {
            return;
        }
        j24 j24Var = new j24();
        j24Var.b = "stuck";
        j24Var.e = "jserror";
        j24Var.f = z03.g0();
        if (z03.M() != null && z03.M().Y() != null) {
            wl2.a Y = z03.M().Y();
            j24Var.c = Y.T();
            j24Var.a = s73.n(Y.G());
        }
        j24Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        j24Var.k = v14.d() ? 20 : 10;
        j24Var.n = ix3.b();
        j24Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(j24Var);
    }
}
