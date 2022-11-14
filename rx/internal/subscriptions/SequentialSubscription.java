package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o4a;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<yz9> implements yz9 {
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

    public yz9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            yz9 yz9Var = (yz9) super.get();
            if (yz9Var == Unsubscribed.INSTANCE) {
                return o4a.c();
            }
            return yz9Var;
        }
        return (yz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz9
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

    @Override // com.baidu.tieba.yz9
    public void unsubscribe() {
        yz9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yz9 yz9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (yz9Var != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(yz9 yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(yz9Var);
    }

    public boolean replace(yz9 yz9Var) {
        yz9 yz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yz9Var)) == null) {
            do {
                yz9Var2 = get();
                if (yz9Var2 == Unsubscribed.INSTANCE) {
                    if (yz9Var != null) {
                        yz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(yz9Var2, yz9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(yz9 yz9Var) {
        yz9 yz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yz9Var)) == null) {
            do {
                yz9Var2 = get();
                if (yz9Var2 == Unsubscribed.INSTANCE) {
                    if (yz9Var != null) {
                        yz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(yz9Var2, yz9Var));
            if (yz9Var2 != null) {
                yz9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(yz9 yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yz9Var)) == null) {
            yz9 yz9Var2 = get();
            if (yz9Var2 == Unsubscribed.INSTANCE) {
                if (yz9Var != null) {
                    yz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(yz9Var2, yz9Var) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (yz9Var != null) {
                    yz9Var.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(yz9 yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yz9Var)) == null) {
            yz9 yz9Var2 = get();
            if (yz9Var2 == Unsubscribed.INSTANCE) {
                if (yz9Var != null) {
                    yz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(yz9Var2, yz9Var)) {
                return true;
            } else {
                yz9 yz9Var3 = get();
                if (yz9Var != null) {
                    yz9Var.unsubscribe();
                }
                if (yz9Var3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
