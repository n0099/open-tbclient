package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fv9;
import com.baidu.tieba.vz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<fv9> implements fv9 {
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

    public fv9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fv9 fv9Var = (fv9) super.get();
            return fv9Var == Unsubscribed.INSTANCE ? vz9.c() : fv9Var;
        }
        return (fv9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(fv9 fv9Var) {
        fv9 fv9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fv9Var)) == null) {
            do {
                fv9Var2 = get();
                if (fv9Var2 == Unsubscribed.INSTANCE) {
                    if (fv9Var != null) {
                        fv9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(fv9Var2, fv9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(fv9 fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fv9Var)) == null) {
            fv9 fv9Var2 = get();
            if (fv9Var2 == Unsubscribed.INSTANCE) {
                if (fv9Var != null) {
                    fv9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(fv9Var2, fv9Var) && get() == Unsubscribed.INSTANCE) {
                if (fv9Var != null) {
                    fv9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fv9
    public void unsubscribe() {
        fv9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            fv9 fv9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (fv9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(fv9 fv9Var) {
        fv9 fv9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fv9Var)) == null) {
            do {
                fv9Var2 = get();
                if (fv9Var2 == Unsubscribed.INSTANCE) {
                    if (fv9Var != null) {
                        fv9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(fv9Var2, fv9Var));
            if (fv9Var2 != null) {
                fv9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(fv9 fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fv9Var)) == null) {
            fv9 fv9Var2 = get();
            if (fv9Var2 == Unsubscribed.INSTANCE) {
                if (fv9Var != null) {
                    fv9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(fv9Var2, fv9Var)) {
                return true;
            } else {
                fv9 fv9Var3 = get();
                if (fv9Var != null) {
                    fv9Var.unsubscribe();
                }
                return fv9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(fv9 fv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fv9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(fv9Var);
    }
}
