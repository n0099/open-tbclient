package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ada;
import com.baidu.tieba.qha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<ada> implements ada {
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

    public ada current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ada adaVar = (ada) super.get();
            if (adaVar == Unsubscribed.INSTANCE) {
                return qha.c();
            }
            return adaVar;
        }
        return (ada) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ada
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

    @Override // com.baidu.tieba.ada
    public void unsubscribe() {
        ada andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ada adaVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (adaVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(ada adaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(adaVar);
    }

    public boolean replace(ada adaVar) {
        ada adaVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adaVar)) == null) {
            do {
                adaVar2 = get();
                if (adaVar2 == Unsubscribed.INSTANCE) {
                    if (adaVar != null) {
                        adaVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(adaVar2, adaVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(ada adaVar) {
        ada adaVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adaVar)) == null) {
            do {
                adaVar2 = get();
                if (adaVar2 == Unsubscribed.INSTANCE) {
                    if (adaVar != null) {
                        adaVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(adaVar2, adaVar));
            if (adaVar2 != null) {
                adaVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(ada adaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, adaVar)) == null) {
            ada adaVar2 = get();
            if (adaVar2 == Unsubscribed.INSTANCE) {
                if (adaVar != null) {
                    adaVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(adaVar2, adaVar) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (adaVar != null) {
                    adaVar.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(ada adaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adaVar)) == null) {
            ada adaVar2 = get();
            if (adaVar2 == Unsubscribed.INSTANCE) {
                if (adaVar != null) {
                    adaVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(adaVar2, adaVar)) {
                return true;
            } else {
                ada adaVar3 = get();
                if (adaVar != null) {
                    adaVar.unsubscribe();
                }
                if (adaVar3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
