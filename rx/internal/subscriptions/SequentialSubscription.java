package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.s3a;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<bz9> implements bz9 {
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

    public bz9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bz9 bz9Var = (bz9) super.get();
            return bz9Var == Unsubscribed.INSTANCE ? s3a.c() : bz9Var;
        }
        return (bz9) invokeV.objValue;
    }

    @Override // com.repackage.bz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(bz9 bz9Var) {
        bz9 bz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bz9Var)) == null) {
            do {
                bz9Var2 = get();
                if (bz9Var2 == Unsubscribed.INSTANCE) {
                    if (bz9Var != null) {
                        bz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(bz9Var2, bz9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(bz9 bz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bz9Var)) == null) {
            bz9 bz9Var2 = get();
            if (bz9Var2 == Unsubscribed.INSTANCE) {
                if (bz9Var != null) {
                    bz9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(bz9Var2, bz9Var) && get() == Unsubscribed.INSTANCE) {
                if (bz9Var != null) {
                    bz9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.bz9
    public void unsubscribe() {
        bz9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bz9 bz9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (bz9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(bz9 bz9Var) {
        bz9 bz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bz9Var)) == null) {
            do {
                bz9Var2 = get();
                if (bz9Var2 == Unsubscribed.INSTANCE) {
                    if (bz9Var != null) {
                        bz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(bz9Var2, bz9Var));
            if (bz9Var2 != null) {
                bz9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(bz9 bz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bz9Var)) == null) {
            bz9 bz9Var2 = get();
            if (bz9Var2 == Unsubscribed.INSTANCE) {
                if (bz9Var != null) {
                    bz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(bz9Var2, bz9Var)) {
                return true;
            } else {
                bz9 bz9Var3 = get();
                if (bz9Var != null) {
                    bz9Var.unsubscribe();
                }
                return bz9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(bz9 bz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(bz9Var);
    }
}
