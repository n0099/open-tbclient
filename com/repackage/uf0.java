package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class uf0 implements pl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ml0> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755263022, "Lcom/repackage/uf0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755263022, "Lcom/repackage/uf0;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new jf0());
        a.add(new uk0());
        a.add(new tf0());
        a.add(new wf0());
        xf0 xf0Var = new xf0();
        rb1<ml0> rb1Var = xf0Var.a;
        if (rb1Var == null || xx0.g(rb1Var.getList())) {
            return;
        }
        a.addAll(xf0Var.a.getList());
    }

    public uf0() {
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

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !a.isEmpty() : invokeV.booleanValue;
    }

    @Override // com.repackage.pl0
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityDestroyed(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityPaused(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityResumed(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, activity, bundle) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityStarted(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onActivityStopped(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onBackgroundToForeground(activity);
            }
        }
    }

    @Override // com.repackage.pl0
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && e()) {
            for (ml0 ml0Var : a) {
                ml0Var.onForegroundToBackground(activity);
            }
        }
    }
}
