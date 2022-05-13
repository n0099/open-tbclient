package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am2;
import com.repackage.sj2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class pj2 extends sj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final k84 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755408071, "Lcom/repackage/pj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755408071, "Lcom/repackage/pj2;");
                return;
            }
        }
        f = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pj2(String str, k84 k84Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, k84Var};
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
        this.e = k84Var;
    }

    @Override // com.repackage.sj2.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        nc3 nc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            zl2 d = zl2.d(bundle.getString("launch_id"));
            am2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    nc3Var = m42.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    nc3 nc3Var2 = new nc3();
                    nc3Var2.k(11L);
                    nc3Var2.i(2300L);
                    nc3Var2.f("inputStream IOException:" + e2.toString());
                    rc3.a().f(nc3Var2);
                    d.g("SignChecker", nc3Var2.toString());
                    hf3.a(sourceChannel);
                    nc3Var = nc3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = nc3Var == null;
                if (nc3Var != null) {
                    d.g("SignChecker", nc3Var.toString());
                    b().putLong("result_error_code", nc3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                hf3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
