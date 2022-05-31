package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fi2;
import com.repackage.nk2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class ci2 extends fi2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final x64 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755796315, "Lcom/repackage/ci2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755796315, "Lcom/repackage/ci2;");
                return;
            }
        }
        f = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci2(String str, x64 x64Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, x64Var};
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
        this.e = x64Var;
    }

    @Override // com.repackage.fi2.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ab3 ab3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            mk2 d = mk2.d(bundle.getString("launch_id"));
            nk2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ab3Var = z22.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    ab3 ab3Var2 = new ab3();
                    ab3Var2.k(11L);
                    ab3Var2.i(2300L);
                    ab3Var2.f("inputStream IOException:" + e2.toString());
                    eb3.a().f(ab3Var2);
                    d.g("SignChecker", ab3Var2.toString());
                    ud3.a(sourceChannel);
                    ab3Var = ab3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = ab3Var == null;
                if (ab3Var != null) {
                    d.g("SignChecker", ab3Var.toString());
                    b().putLong("result_error_code", ab3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                ud3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
