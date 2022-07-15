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
public class d92 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755812652, "Lcom/repackage/d92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755812652, "Lcom/repackage/d92;");
                return;
            }
        }
        oj2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public d92() {
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

    public static void c(n92 n92Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, n92Var) == null) && a && n92Var != null) {
            if (ProcessUtils.isMainProcess()) {
                e92.a(n92Var).b();
                m92.b().a(n92Var.a);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("recovery_level", n92Var.a);
            bundle.putStringArrayList("recovery_app_list", n92Var.b);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d92.class, bundle);
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
                n92 n92Var = new n92();
                n92Var.a = i;
                if (stringArrayList != null) {
                    n92Var.b = stringArrayList;
                }
                e92.a(n92Var).b();
                m92.b().a(n92Var.a);
                return null;
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
