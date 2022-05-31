package com.repackage;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d82 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813613, "Lcom/repackage/d82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813613, "Lcom/repackage/d82;");
                return;
            }
        }
        oi2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public d82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b(n82 n82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, n82Var) == null) && a && n82Var != null) {
            if (ProcessUtils.isMainProcess()) {
                e82.a(n82Var).b();
                m82.b().a(n82Var.a);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("recovery_level", n82Var.a);
            bundle.putStringArrayList("recovery_app_list", n82Var.b);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d82.class, bundle);
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            if (a) {
                int i = bundle.getInt("recovery_level", -1);
                ArrayList<String> stringArrayList = bundle.getStringArrayList("recovery_app_list");
                n82 n82Var = new n82();
                n82Var.a = i;
                if (stringArrayList != null) {
                    n82Var.b = stringArrayList;
                }
                e82.a(n82Var).b();
                m82.b().a(n82Var.a);
                return null;
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
