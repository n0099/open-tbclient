package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n1a;
import com.baidu.tieba.xw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<xw9> implements xw9 {
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

    public xw9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xw9 xw9Var = (xw9) super.get();
            return xw9Var == Unsubscribed.INSTANCE ? n1a.c() : xw9Var;
        }
        return (xw9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xw9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(xw9 xw9Var) {
        xw9 xw9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xw9Var)) == null) {
            do {
                xw9Var2 = get();
                if (xw9Var2 == Unsubscribed.INSTANCE) {
                    if (xw9Var != null) {
                        xw9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(xw9Var2, xw9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(xw9 xw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xw9Var)) == null) {
            xw9 xw9Var2 = get();
            if (xw9Var2 == Unsubscribed.INSTANCE) {
                if (xw9Var != null) {
                    xw9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(xw9Var2, xw9Var) && get() == Unsubscribed.INSTANCE) {
                if (xw9Var != null) {
                    xw9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xw9
    public void unsubscribe() {
        xw9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xw9 xw9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (xw9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(xw9 xw9Var) {
        xw9 xw9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xw9Var)) == null) {
            do {
                xw9Var2 = get();
                if (xw9Var2 == Unsubscribed.INSTANCE) {
                    if (xw9Var != null) {
                        xw9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(xw9Var2, xw9Var));
            if (xw9Var2 != null) {
                xw9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(xw9 xw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xw9Var)) == null) {
            xw9 xw9Var2 = get();
            if (xw9Var2 == Unsubscribed.INSTANCE) {
                if (xw9Var != null) {
                    xw9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(xw9Var2, xw9Var)) {
                return true;
            } else {
                xw9 xw9Var3 = get();
                if (xw9Var != null) {
                    xw9Var.unsubscribe();
                }
                return xw9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(xw9 xw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(xw9Var);
    }
}
