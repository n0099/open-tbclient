package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d4a;
import com.baidu.tieba.nz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<nz9> implements nz9 {
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

    public nz9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nz9 nz9Var = (nz9) super.get();
            if (nz9Var == Unsubscribed.INSTANCE) {
                return d4a.c();
            }
            return nz9Var;
        }
        return (nz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (get() == Unsubscribed.INSTANCE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nz9
    public void unsubscribe() {
        nz9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nz9 nz9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (nz9Var != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(nz9 nz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(nz9Var);
    }

    public boolean replace(nz9 nz9Var) {
        nz9 nz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nz9Var)) == null) {
            do {
                nz9Var2 = get();
                if (nz9Var2 == Unsubscribed.INSTANCE) {
                    if (nz9Var != null) {
                        nz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(nz9Var2, nz9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(nz9 nz9Var) {
        nz9 nz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nz9Var)) == null) {
            do {
                nz9Var2 = get();
                if (nz9Var2 == Unsubscribed.INSTANCE) {
                    if (nz9Var != null) {
                        nz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(nz9Var2, nz9Var));
            if (nz9Var2 != null) {
                nz9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(nz9 nz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nz9Var)) == null) {
            nz9 nz9Var2 = get();
            if (nz9Var2 == Unsubscribed.INSTANCE) {
                if (nz9Var != null) {
                    nz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(nz9Var2, nz9Var) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (nz9Var != null) {
                    nz9Var.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(nz9 nz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nz9Var)) == null) {
            nz9 nz9Var2 = get();
            if (nz9Var2 == Unsubscribed.INSTANCE) {
                if (nz9Var != null) {
                    nz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(nz9Var2, nz9Var)) {
                return true;
            } else {
                nz9 nz9Var3 = get();
                if (nz9Var != null) {
                    nz9Var.unsubscribe();
                }
                if (nz9Var3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
