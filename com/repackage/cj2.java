package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fj2;
import com.repackage.nl2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class cj2 extends fj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final x74 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755795354, "Lcom/repackage/cj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755795354, "Lcom/repackage/cj2;");
                return;
            }
        }
        f = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj2(String str, x74 x74Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, x74Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = str;
        this.e = x74Var;
    }

    @Override // com.repackage.fj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ac3 ac3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            ml2 d = ml2.d(bundle.getString("launch_id"));
            nl2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ac3Var = z32.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    ac3 ac3Var2 = new ac3();
                    ac3Var2.k(11L);
                    ac3Var2.i(2300L);
                    ac3Var2.f("inputStream IOException:" + e2.toString());
                    ec3.a().f(ac3Var2);
                    d.g("SignChecker", ac3Var2.toString());
                    ue3.a(sourceChannel);
                    ac3Var = ac3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = ac3Var == null;
                if (ac3Var != null) {
                    d.g("SignChecker", ac3Var.toString());
                    c().putLong("result_error_code", ac3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                ue3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
