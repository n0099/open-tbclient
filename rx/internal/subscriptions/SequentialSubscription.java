package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eea;
import com.baidu.tieba.uia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<eea> implements eea {
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

    public eea current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            eea eeaVar = (eea) super.get();
            if (eeaVar == Unsubscribed.INSTANCE) {
                return uia.c();
            }
            return eeaVar;
        }
        return (eea) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eea
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

    @Override // com.baidu.tieba.eea
    public void unsubscribe() {
        eea andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            eea eeaVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (eeaVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(eea eeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eeaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(eeaVar);
    }

    public boolean replace(eea eeaVar) {
        eea eeaVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eeaVar)) == null) {
            do {
                eeaVar2 = get();
                if (eeaVar2 == Unsubscribed.INSTANCE) {
                    if (eeaVar != null) {
                        eeaVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(eeaVar2, eeaVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(eea eeaVar) {
        eea eeaVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eeaVar)) == null) {
            do {
                eeaVar2 = get();
                if (eeaVar2 == Unsubscribed.INSTANCE) {
                    if (eeaVar != null) {
                        eeaVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(eeaVar2, eeaVar));
            if (eeaVar2 != null) {
                eeaVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(eea eeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eeaVar)) == null) {
            eea eeaVar2 = get();
            if (eeaVar2 == Unsubscribed.INSTANCE) {
                if (eeaVar != null) {
                    eeaVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(eeaVar2, eeaVar) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (eeaVar != null) {
                    eeaVar.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(eea eeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eeaVar)) == null) {
            eea eeaVar2 = get();
            if (eeaVar2 == Unsubscribed.INSTANCE) {
                if (eeaVar != null) {
                    eeaVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(eeaVar2, eeaVar)) {
                return true;
            } else {
                eea eeaVar3 = get();
                if (eeaVar != null) {
                    eeaVar.unsubscribe();
                }
                if (eeaVar3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
