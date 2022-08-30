package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hv9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<hv9> implements hv9 {
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

    public hv9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            hv9 hv9Var = (hv9) super.get();
            return hv9Var == Unsubscribed.INSTANCE ? xz9.c() : hv9Var;
        }
        return (hv9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hv9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(hv9 hv9Var) {
        hv9 hv9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hv9Var)) == null) {
            do {
                hv9Var2 = get();
                if (hv9Var2 == Unsubscribed.INSTANCE) {
                    if (hv9Var != null) {
                        hv9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(hv9Var2, hv9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(hv9 hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hv9Var)) == null) {
            hv9 hv9Var2 = get();
            if (hv9Var2 == Unsubscribed.INSTANCE) {
                if (hv9Var != null) {
                    hv9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(hv9Var2, hv9Var) && get() == Unsubscribed.INSTANCE) {
                if (hv9Var != null) {
                    hv9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hv9
    public void unsubscribe() {
        hv9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hv9 hv9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (hv9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(hv9 hv9Var) {
        hv9 hv9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hv9Var)) == null) {
            do {
                hv9Var2 = get();
                if (hv9Var2 == Unsubscribed.INSTANCE) {
                    if (hv9Var != null) {
                        hv9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(hv9Var2, hv9Var));
            if (hv9Var2 != null) {
                hv9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(hv9 hv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hv9Var)) == null) {
            hv9 hv9Var2 = get();
            if (hv9Var2 == Unsubscribed.INSTANCE) {
                if (hv9Var != null) {
                    hv9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(hv9Var2, hv9Var)) {
                return true;
            } else {
                hv9 hv9Var3 = get();
                if (hv9Var != null) {
                    hv9Var.unsubscribe();
                }
                return hv9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(hv9 hv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hv9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(hv9Var);
    }
}
