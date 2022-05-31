package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nz9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<xu9> implements xu9 {
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

    public xu9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xu9 xu9Var = (xu9) super.get();
            return xu9Var == Unsubscribed.INSTANCE ? nz9.c() : xu9Var;
        }
        return (xu9) invokeV.objValue;
    }

    @Override // com.repackage.xu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(xu9 xu9Var) {
        xu9 xu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xu9Var)) == null) {
            do {
                xu9Var2 = get();
                if (xu9Var2 == Unsubscribed.INSTANCE) {
                    if (xu9Var != null) {
                        xu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(xu9Var2, xu9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(xu9 xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xu9Var)) == null) {
            xu9 xu9Var2 = get();
            if (xu9Var2 == Unsubscribed.INSTANCE) {
                if (xu9Var != null) {
                    xu9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(xu9Var2, xu9Var) && get() == Unsubscribed.INSTANCE) {
                if (xu9Var != null) {
                    xu9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.xu9
    public void unsubscribe() {
        xu9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xu9 xu9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (xu9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(xu9 xu9Var) {
        xu9 xu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xu9Var)) == null) {
            do {
                xu9Var2 = get();
                if (xu9Var2 == Unsubscribed.INSTANCE) {
                    if (xu9Var != null) {
                        xu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(xu9Var2, xu9Var));
            if (xu9Var2 != null) {
                xu9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(xu9 xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xu9Var)) == null) {
            xu9 xu9Var2 = get();
            if (xu9Var2 == Unsubscribed.INSTANCE) {
                if (xu9Var != null) {
                    xu9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(xu9Var2, xu9Var)) {
                return true;
            } else {
                xu9 xu9Var3 = get();
                if (xu9Var != null) {
                    xu9Var.unsubscribe();
                }
                return xu9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(xu9Var);
    }
}
