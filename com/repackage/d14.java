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
import com.repackage.pk2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes5.dex */
public class d14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends yv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c14 c;

        public a(c14 c14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.yv2, com.repackage.zv2, com.repackage.xv2
        public void onEvent(@NonNull vv2 vv2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vv2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = vv2Var.a() != null ? vv2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (d14.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                c14 c14Var = this.c;
                c14Var.m = i;
                l63.x("976", c14Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755820278, "Lcom/repackage/d14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755820278, "Lcom/repackage/d14;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void b(c14 c14Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, c14Var) == null) || c14Var == null) {
            return;
        }
        nw2.Q().X(null, gr2.class, new a(c14Var));
    }

    public static void c(nd1 nd1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, nd1Var) == null) || nd1Var == null || (a2 = nd1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(bw3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= bw3.a()) {
            return;
        }
        c14 c14Var = new c14();
        c14Var.b = "stuck";
        c14Var.e = "jserror";
        c14Var.f = sz2.g0();
        if (sz2.M() != null && sz2.M().Y() != null) {
            pk2.a Y = sz2.M().Y();
            c14Var.c = Y.T();
            c14Var.a = l63.n(Y.G());
        }
        c14Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        c14Var.k = o04.d() ? 20 : 10;
        c14Var.n = bw3.b();
        c14Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(c14Var);
    }
}
