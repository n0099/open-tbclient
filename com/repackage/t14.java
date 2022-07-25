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
import com.repackage.fl2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class t14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ow2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s14 c;

        public a(s14 s14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ow2, com.repackage.pw2, com.repackage.nw2
        public void onEvent(@NonNull lw2 lw2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lw2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = lw2Var.a() != null ? lw2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (t14.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                s14 s14Var = this.c;
                s14Var.m = i;
                b73.x("976", s14Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755343622, "Lcom/repackage/t14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755343622, "Lcom/repackage/t14;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void b(s14 s14Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, s14Var) == null) || s14Var == null) {
            return;
        }
        dx2.Q().X(null, wr2.class, new a(s14Var));
    }

    public static void c(ce1 ce1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, ce1Var) == null) || ce1Var == null || (a2 = ce1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(rw3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= rw3.a()) {
            return;
        }
        s14 s14Var = new s14();
        s14Var.b = "stuck";
        s14Var.e = "jserror";
        s14Var.f = i03.g0();
        if (i03.M() != null && i03.M().Y() != null) {
            fl2.a Y = i03.M().Y();
            s14Var.c = Y.T();
            s14Var.a = b73.n(Y.G());
        }
        s14Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        s14Var.k = e14.d() ? 20 : 10;
        s14Var.n = rw3.b();
        s14Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(s14Var);
    }
}
