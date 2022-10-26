package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ey9;
import com.baidu.tieba.u2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference implements ey9 {
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

    public ey9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ey9 ey9Var = (ey9) super.get();
            if (ey9Var == Unsubscribed.INSTANCE) {
                return u2a.c();
            }
            return ey9Var;
        }
        return (ey9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ey9
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

    @Override // com.baidu.tieba.ey9
    public void unsubscribe() {
        ey9 ey9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ey9 ey9Var2 = (ey9) get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (ey9Var2 != unsubscribed && (ey9Var = (ey9) getAndSet(unsubscribed)) != null && ey9Var != Unsubscribed.INSTANCE) {
                ey9Var.unsubscribe();
            }
        }
    }

    public SequentialSubscription(ey9 ey9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ey9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(ey9Var);
    }

    public boolean replace(ey9 ey9Var) {
        ey9 ey9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ey9Var)) == null) {
            do {
                ey9Var2 = (ey9) get();
                if (ey9Var2 == Unsubscribed.INSTANCE) {
                    if (ey9Var != null) {
                        ey9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(ey9Var2, ey9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(ey9 ey9Var) {
        ey9 ey9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ey9Var)) == null) {
            do {
                ey9Var2 = (ey9) get();
                if (ey9Var2 == Unsubscribed.INSTANCE) {
                    if (ey9Var != null) {
                        ey9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(ey9Var2, ey9Var));
            if (ey9Var2 != null) {
                ey9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ey9Var)) == null) {
            ey9 ey9Var2 = (ey9) get();
            if (ey9Var2 == Unsubscribed.INSTANCE) {
                if (ey9Var != null) {
                    ey9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(ey9Var2, ey9Var) || ((ey9) get()) != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (ey9Var != null) {
                    ey9Var.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ey9Var)) == null) {
            ey9 ey9Var2 = (ey9) get();
            if (ey9Var2 == Unsubscribed.INSTANCE) {
                if (ey9Var != null) {
                    ey9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(ey9Var2, ey9Var)) {
                return true;
            } else {
                ey9 ey9Var3 = (ey9) get();
                if (ey9Var != null) {
                    ey9Var.unsubscribe();
                }
                if (ey9Var3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
