package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev9;
import com.repackage.uz9;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<ev9> implements ev9 {
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

    public ev9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ev9 ev9Var = (ev9) super.get();
            return ev9Var == Unsubscribed.INSTANCE ? uz9.c() : ev9Var;
        }
        return (ev9) invokeV.objValue;
    }

    @Override // com.repackage.ev9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(ev9 ev9Var) {
        ev9 ev9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev9Var)) == null) {
            do {
                ev9Var2 = get();
                if (ev9Var2 == Unsubscribed.INSTANCE) {
                    if (ev9Var != null) {
                        ev9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(ev9Var2, ev9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ev9Var)) == null) {
            ev9 ev9Var2 = get();
            if (ev9Var2 == Unsubscribed.INSTANCE) {
                if (ev9Var != null) {
                    ev9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(ev9Var2, ev9Var) && get() == Unsubscribed.INSTANCE) {
                if (ev9Var != null) {
                    ev9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ev9
    public void unsubscribe() {
        ev9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ev9 ev9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (ev9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(ev9 ev9Var) {
        ev9 ev9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ev9Var)) == null) {
            do {
                ev9Var2 = get();
                if (ev9Var2 == Unsubscribed.INSTANCE) {
                    if (ev9Var != null) {
                        ev9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(ev9Var2, ev9Var));
            if (ev9Var2 != null) {
                ev9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ev9Var)) == null) {
            ev9 ev9Var2 = get();
            if (ev9Var2 == Unsubscribed.INSTANCE) {
                if (ev9Var != null) {
                    ev9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(ev9Var2, ev9Var)) {
                return true;
            } else {
                ev9 ev9Var3 = get();
                if (ev9Var != null) {
                    ev9Var.unsubscribe();
                }
                return ev9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(ev9 ev9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ev9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(ev9Var);
    }
}
