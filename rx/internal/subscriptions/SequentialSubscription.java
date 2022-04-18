package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iz9;
import com.repackage.z3a;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<iz9> implements iz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 995205034283130269L;
    public transient /* synthetic */ FieldHolder $fh;

    public SequentialSubscription() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public iz9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            iz9 iz9Var = (iz9) super.get();
            return iz9Var == Unsubscribed.INSTANCE ? z3a.c() : iz9Var;
        }
        return (iz9) invokeV.objValue;
    }

    @Override // com.repackage.iz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(iz9 iz9Var) {
        iz9 iz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iz9Var)) == null) {
            do {
                iz9Var2 = get();
                if (iz9Var2 == Unsubscribed.INSTANCE) {
                    if (iz9Var != null) {
                        iz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(iz9Var2, iz9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(iz9 iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iz9Var)) == null) {
            iz9 iz9Var2 = get();
            if (iz9Var2 == Unsubscribed.INSTANCE) {
                if (iz9Var != null) {
                    iz9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(iz9Var2, iz9Var) && get() == Unsubscribed.INSTANCE) {
                if (iz9Var != null) {
                    iz9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.iz9
    public void unsubscribe() {
        iz9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            iz9 iz9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (iz9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(iz9 iz9Var) {
        iz9 iz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iz9Var)) == null) {
            do {
                iz9Var2 = get();
                if (iz9Var2 == Unsubscribed.INSTANCE) {
                    if (iz9Var != null) {
                        iz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(iz9Var2, iz9Var));
            if (iz9Var2 != null) {
                iz9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(iz9 iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iz9Var)) == null) {
            iz9 iz9Var2 = get();
            if (iz9Var2 == Unsubscribed.INSTANCE) {
                if (iz9Var != null) {
                    iz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(iz9Var2, iz9Var)) {
                return true;
            } else {
                iz9 iz9Var3 = get();
                if (iz9Var != null) {
                    iz9Var.unsubscribe();
                }
                return iz9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(iz9 iz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(iz9Var);
    }
}
