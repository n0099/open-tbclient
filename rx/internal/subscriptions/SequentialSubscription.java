package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c2a;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<mx9> implements mx9 {
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

    public mx9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mx9 mx9Var = (mx9) super.get();
            return mx9Var == Unsubscribed.INSTANCE ? c2a.c() : mx9Var;
        }
        return (mx9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mx9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(mx9 mx9Var) {
        mx9 mx9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mx9Var)) == null) {
            do {
                mx9Var2 = get();
                if (mx9Var2 == Unsubscribed.INSTANCE) {
                    if (mx9Var != null) {
                        mx9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(mx9Var2, mx9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(mx9 mx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mx9Var)) == null) {
            mx9 mx9Var2 = get();
            if (mx9Var2 == Unsubscribed.INSTANCE) {
                if (mx9Var != null) {
                    mx9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(mx9Var2, mx9Var) && get() == Unsubscribed.INSTANCE) {
                if (mx9Var != null) {
                    mx9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.mx9
    public void unsubscribe() {
        mx9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mx9 mx9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (mx9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(mx9 mx9Var) {
        mx9 mx9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mx9Var)) == null) {
            do {
                mx9Var2 = get();
                if (mx9Var2 == Unsubscribed.INSTANCE) {
                    if (mx9Var != null) {
                        mx9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(mx9Var2, mx9Var));
            if (mx9Var2 != null) {
                mx9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(mx9 mx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mx9Var)) == null) {
            mx9 mx9Var2 = get();
            if (mx9Var2 == Unsubscribed.INSTANCE) {
                if (mx9Var != null) {
                    mx9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(mx9Var2, mx9Var)) {
                return true;
            } else {
                mx9 mx9Var3 = get();
                if (mx9Var != null) {
                    mx9Var.unsubscribe();
                }
                return mx9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(mx9 mx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mx9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(mx9Var);
    }
}
