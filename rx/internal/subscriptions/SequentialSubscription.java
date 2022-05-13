package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy9;
import com.repackage.t2a;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<dy9> implements dy9 {
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

    public dy9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dy9 dy9Var = (dy9) super.get();
            return dy9Var == Unsubscribed.INSTANCE ? t2a.c() : dy9Var;
        }
        return (dy9) invokeV.objValue;
    }

    @Override // com.repackage.dy9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(dy9 dy9Var) {
        dy9 dy9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dy9Var)) == null) {
            do {
                dy9Var2 = get();
                if (dy9Var2 == Unsubscribed.INSTANCE) {
                    if (dy9Var != null) {
                        dy9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(dy9Var2, dy9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dy9Var)) == null) {
            dy9 dy9Var2 = get();
            if (dy9Var2 == Unsubscribed.INSTANCE) {
                if (dy9Var != null) {
                    dy9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(dy9Var2, dy9Var) && get() == Unsubscribed.INSTANCE) {
                if (dy9Var != null) {
                    dy9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.dy9
    public void unsubscribe() {
        dy9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dy9 dy9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (dy9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(dy9 dy9Var) {
        dy9 dy9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dy9Var)) == null) {
            do {
                dy9Var2 = get();
                if (dy9Var2 == Unsubscribed.INSTANCE) {
                    if (dy9Var != null) {
                        dy9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(dy9Var2, dy9Var));
            if (dy9Var2 != null) {
                dy9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dy9Var)) == null) {
            dy9 dy9Var2 = get();
            if (dy9Var2 == Unsubscribed.INSTANCE) {
                if (dy9Var != null) {
                    dy9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(dy9Var2, dy9Var)) {
                return true;
            } else {
                dy9 dy9Var3 = get();
                if (dy9Var != null) {
                    dy9Var.unsubscribe();
                }
                return dy9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(dy9Var);
    }
}
