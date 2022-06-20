package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qi2;
import com.repackage.yk2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class ni2 extends qi2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final i74 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755468614, "Lcom/repackage/ni2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755468614, "Lcom/repackage/ni2;");
                return;
            }
        }
        f = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni2(String str, i74 i74Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, i74Var};
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
        this.e = i74Var;
    }

    @Override // com.repackage.qi2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        lb3 lb3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            xk2 d = xk2.d(bundle.getString("launch_id"));
            yk2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    lb3Var = k32.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    lb3 lb3Var2 = new lb3();
                    lb3Var2.k(11L);
                    lb3Var2.i(2300L);
                    lb3Var2.f("inputStream IOException:" + e2.toString());
                    pb3.a().f(lb3Var2);
                    d.g("SignChecker", lb3Var2.toString());
                    fe3.a(sourceChannel);
                    lb3Var = lb3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = lb3Var == null;
                if (lb3Var != null) {
                    d.g("SignChecker", lb3Var.toString());
                    c().putLong("result_error_code", lb3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                fe3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
