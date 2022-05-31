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
import com.repackage.ek2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class s04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends nv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r04 c;

        public a(r04 r04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nv2, com.repackage.ov2, com.repackage.mv2
        public void onEvent(@NonNull kv2 kv2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = kv2Var.a() != null ? kv2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (s04.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                r04 r04Var = this.c;
                r04Var.m = i;
                a63.x("976", r04Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755374374, "Lcom/repackage/s04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755374374, "Lcom/repackage/s04;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void b(r04 r04Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, r04Var) == null) || r04Var == null) {
            return;
        }
        cw2.P().W(null, vq2.class, new a(r04Var));
    }

    public static void c(cd1 cd1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, cd1Var) == null) || cd1Var == null || (a2 = cd1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(qv3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= qv3.a()) {
            return;
        }
        r04 r04Var = new r04();
        r04Var.b = "stuck";
        r04Var.e = "jserror";
        r04Var.f = hz2.f0();
        if (hz2.L() != null && hz2.L().X() != null) {
            ek2.a X = hz2.L().X();
            r04Var.c = X.T();
            r04Var.a = a63.n(X.G());
        }
        r04Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        r04Var.k = d04.d() ? 20 : 10;
        r04Var.n = qv3.b();
        r04Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(r04Var);
    }
}
