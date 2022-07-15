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
import com.repackage.el2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class s14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends nw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r14 c;

        public a(r14 r14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw2, com.repackage.ow2, com.repackage.mw2
        public void onEvent(@NonNull kw2 kw2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kw2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = kw2Var.a() != null ? kw2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (s14.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                r14 r14Var = this.c;
                r14Var.m = i;
                a73.x("976", r14Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755373413, "Lcom/repackage/s14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755373413, "Lcom/repackage/s14;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void b(r14 r14Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, r14Var) == null) || r14Var == null) {
            return;
        }
        cx2.Q().X(null, vr2.class, new a(r14Var));
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
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(qw3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= qw3.a()) {
            return;
        }
        r14 r14Var = new r14();
        r14Var.b = "stuck";
        r14Var.e = "jserror";
        r14Var.f = h03.g0();
        if (h03.M() != null && h03.M().Y() != null) {
            el2.a Y = h03.M().Y();
            r14Var.c = Y.T();
            r14Var.a = a73.n(Y.G());
        }
        r14Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        r14Var.k = d14.d() ? 20 : 10;
        r14Var.n = qw3.b();
        r14Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(r14Var);
    }
}
