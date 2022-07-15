package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs9;
import com.repackage.rw9;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<bs9> implements bs9 {
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

    public bs9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bs9 bs9Var = (bs9) super.get();
            return bs9Var == Unsubscribed.INSTANCE ? rw9.c() : bs9Var;
        }
        return (bs9) invokeV.objValue;
    }

    @Override // com.repackage.bs9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(bs9 bs9Var) {
        bs9 bs9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bs9Var)) == null) {
            do {
                bs9Var2 = get();
                if (bs9Var2 == Unsubscribed.INSTANCE) {
                    if (bs9Var != null) {
                        bs9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(bs9Var2, bs9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(bs9 bs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bs9Var)) == null) {
            bs9 bs9Var2 = get();
            if (bs9Var2 == Unsubscribed.INSTANCE) {
                if (bs9Var != null) {
                    bs9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(bs9Var2, bs9Var) && get() == Unsubscribed.INSTANCE) {
                if (bs9Var != null) {
                    bs9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.bs9
    public void unsubscribe() {
        bs9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bs9 bs9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (bs9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(bs9 bs9Var) {
        bs9 bs9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bs9Var)) == null) {
            do {
                bs9Var2 = get();
                if (bs9Var2 == Unsubscribed.INSTANCE) {
                    if (bs9Var != null) {
                        bs9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(bs9Var2, bs9Var));
            if (bs9Var2 != null) {
                bs9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(bs9 bs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bs9Var)) == null) {
            bs9 bs9Var2 = get();
            if (bs9Var2 == Unsubscribed.INSTANCE) {
                if (bs9Var != null) {
                    bs9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(bs9Var2, bs9Var)) {
                return true;
            } else {
                bs9 bs9Var3 = get();
                if (bs9Var != null) {
                    bs9Var.unsubscribe();
                }
                return bs9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(bs9 bs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bs9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(bs9Var);
    }
}
