package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p4a;
import com.baidu.tieba.zz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<zz9> implements zz9 {
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

    public zz9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zz9 zz9Var = (zz9) super.get();
            if (zz9Var == Unsubscribed.INSTANCE) {
                return p4a.c();
            }
            return zz9Var;
        }
        return (zz9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zz9
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

    @Override // com.baidu.tieba.zz9
    public void unsubscribe() {
        zz9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zz9 zz9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (zz9Var != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(zz9 zz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(zz9Var);
    }

    public boolean replace(zz9 zz9Var) {
        zz9 zz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zz9Var)) == null) {
            do {
                zz9Var2 = get();
                if (zz9Var2 == Unsubscribed.INSTANCE) {
                    if (zz9Var != null) {
                        zz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(zz9Var2, zz9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(zz9 zz9Var) {
        zz9 zz9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zz9Var)) == null) {
            do {
                zz9Var2 = get();
                if (zz9Var2 == Unsubscribed.INSTANCE) {
                    if (zz9Var != null) {
                        zz9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(zz9Var2, zz9Var));
            if (zz9Var2 != null) {
                zz9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(zz9 zz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zz9Var)) == null) {
            zz9 zz9Var2 = get();
            if (zz9Var2 == Unsubscribed.INSTANCE) {
                if (zz9Var != null) {
                    zz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(zz9Var2, zz9Var) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (zz9Var != null) {
                    zz9Var.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(zz9 zz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zz9Var)) == null) {
            zz9 zz9Var2 = get();
            if (zz9Var2 == Unsubscribed.INSTANCE) {
                if (zz9Var != null) {
                    zz9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(zz9Var2, zz9Var)) {
                return true;
            } else {
                zz9 zz9Var3 = get();
                if (zz9Var != null) {
                    zz9Var.unsubscribe();
                }
                if (zz9Var3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
