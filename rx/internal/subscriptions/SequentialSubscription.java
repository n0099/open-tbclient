package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mz9;
import com.repackage.wu9;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<wu9> implements wu9 {
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

    public wu9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wu9 wu9Var = (wu9) super.get();
            return wu9Var == Unsubscribed.INSTANCE ? mz9.c() : wu9Var;
        }
        return (wu9) invokeV.objValue;
    }

    @Override // com.repackage.wu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(wu9 wu9Var) {
        wu9 wu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wu9Var)) == null) {
            do {
                wu9Var2 = get();
                if (wu9Var2 == Unsubscribed.INSTANCE) {
                    if (wu9Var != null) {
                        wu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(wu9Var2, wu9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(wu9 wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wu9Var)) == null) {
            wu9 wu9Var2 = get();
            if (wu9Var2 == Unsubscribed.INSTANCE) {
                if (wu9Var != null) {
                    wu9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(wu9Var2, wu9Var) && get() == Unsubscribed.INSTANCE) {
                if (wu9Var != null) {
                    wu9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.wu9
    public void unsubscribe() {
        wu9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wu9 wu9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (wu9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(wu9 wu9Var) {
        wu9 wu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wu9Var)) == null) {
            do {
                wu9Var2 = get();
                if (wu9Var2 == Unsubscribed.INSTANCE) {
                    if (wu9Var != null) {
                        wu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(wu9Var2, wu9Var));
            if (wu9Var2 != null) {
                wu9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(wu9 wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wu9Var)) == null) {
            wu9 wu9Var2 = get();
            if (wu9Var2 == Unsubscribed.INSTANCE) {
                if (wu9Var != null) {
                    wu9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(wu9Var2, wu9Var)) {
                return true;
            } else {
                wu9 wu9Var3 = get();
                if (wu9Var != null) {
                    wu9Var.unsubscribe();
                }
                return wu9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(wu9 wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(wu9Var);
    }
}
