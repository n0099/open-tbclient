package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oz9;
import com.repackage.yu9;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<yu9> implements yu9 {
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

    public yu9 current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            yu9 yu9Var = (yu9) super.get();
            return yu9Var == Unsubscribed.INSTANCE ? oz9.c() : yu9Var;
        }
        return (yu9) invokeV.objValue;
    }

    @Override // com.repackage.yu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(yu9 yu9Var) {
        yu9 yu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yu9Var)) == null) {
            do {
                yu9Var2 = get();
                if (yu9Var2 == Unsubscribed.INSTANCE) {
                    if (yu9Var != null) {
                        yu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(yu9Var2, yu9Var));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(yu9 yu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yu9Var)) == null) {
            yu9 yu9Var2 = get();
            if (yu9Var2 == Unsubscribed.INSTANCE) {
                if (yu9Var != null) {
                    yu9Var.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(yu9Var2, yu9Var) && get() == Unsubscribed.INSTANCE) {
                if (yu9Var != null) {
                    yu9Var.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.yu9
    public void unsubscribe() {
        yu9 andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yu9 yu9Var = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (yu9Var == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(yu9 yu9Var) {
        yu9 yu9Var2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yu9Var)) == null) {
            do {
                yu9Var2 = get();
                if (yu9Var2 == Unsubscribed.INSTANCE) {
                    if (yu9Var != null) {
                        yu9Var.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(yu9Var2, yu9Var));
            if (yu9Var2 != null) {
                yu9Var2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(yu9 yu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yu9Var)) == null) {
            yu9 yu9Var2 = get();
            if (yu9Var2 == Unsubscribed.INSTANCE) {
                if (yu9Var != null) {
                    yu9Var.unsubscribe();
                }
                return false;
            } else if (compareAndSet(yu9Var2, yu9Var)) {
                return true;
            } else {
                yu9 yu9Var3 = get();
                if (yu9Var != null) {
                    yu9Var.unsubscribe();
                }
                return yu9Var3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(yu9 yu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(yu9Var);
    }
}
