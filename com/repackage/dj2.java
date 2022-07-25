package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gj2;
import com.repackage.ol2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class dj2 extends gj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final y74 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755765563, "Lcom/repackage/dj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755765563, "Lcom/repackage/dj2;");
                return;
            }
        }
        f = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj2(String str, y74 y74Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, y74Var};
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
        this.e = y74Var;
    }

    @Override // com.repackage.gj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        bc3 bc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            nl2 d = nl2.d(bundle.getString("launch_id"));
            ol2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    bc3Var = a42.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    bc3 bc3Var2 = new bc3();
                    bc3Var2.k(11L);
                    bc3Var2.i(2300L);
                    bc3Var2.f("inputStream IOException:" + e2.toString());
                    fc3.a().f(bc3Var2);
                    d.g("SignChecker", bc3Var2.toString());
                    ve3.a(sourceChannel);
                    bc3Var = bc3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = bc3Var == null;
                if (bc3Var != null) {
                    d.g("SignChecker", bc3Var.toString());
                    c().putLong("result_error_code", bc3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                ve3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
