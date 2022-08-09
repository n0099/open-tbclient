package com.repackage;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fm2;
import com.repackage.xj2;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class uj2 extends xj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final p84 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755259116, "Lcom/repackage/uj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755259116, "Lcom/repackage/uj2;");
                return;
            }
        }
        f = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uj2(String str, p84 p84Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, p84Var};
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
        this.e = p84Var;
    }

    @Override // com.repackage.xj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        sc3 sc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            em2 d = em2.d(bundle.getString("launch_id"));
            fm2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    sc3Var = r42.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    sc3 sc3Var2 = new sc3();
                    sc3Var2.k(11L);
                    sc3Var2.i(2300L);
                    sc3Var2.f("inputStream IOException:" + e2.toString());
                    wc3.a().f(sc3Var2);
                    d.g("SignChecker", sc3Var2.toString());
                    mf3.a(sourceChannel);
                    sc3Var = sc3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = sc3Var == null;
                if (sc3Var != null) {
                    d.g("SignChecker", sc3Var.toString());
                    c().putLong("result_error_code", sc3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                mf3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
