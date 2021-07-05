package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.k;
import h.u.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class SequentialSubscription extends AtomicReference<k> implements k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 995205034283130269L;
    public transient /* synthetic */ FieldHolder $fh;

    public SequentialSubscription() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public k current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            k kVar = (k) super.get();
            return kVar == Unsubscribed.INSTANCE ? e.c() : kVar;
        }
        return (k) invokeV.objValue;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Unsubscribed.INSTANCE : invokeV.booleanValue;
    }

    public boolean replace(k kVar) {
        k kVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar)) == null) {
            do {
                kVar2 = get();
                if (kVar2 == Unsubscribed.INSTANCE) {
                    if (kVar != null) {
                        kVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(kVar2, kVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kVar)) == null) {
            k kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return false;
            } else if (!compareAndSet(kVar2, kVar) && get() == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // h.k
    public void unsubscribe() {
        k andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k kVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (kVar == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
                return;
            }
            andSet.unsubscribe();
        }
    }

    public boolean update(k kVar) {
        k kVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kVar)) == null) {
            do {
                kVar2 = get();
                if (kVar2 == Unsubscribed.INSTANCE) {
                    if (kVar != null) {
                        kVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(kVar2, kVar));
            if (kVar2 != null) {
                kVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kVar)) == null) {
            k kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(kVar2, kVar)) {
                return true;
            } else {
                k kVar3 = get();
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return kVar3 == Unsubscribed.INSTANCE;
            }
        }
        return invokeL.booleanValue;
    }

    public SequentialSubscription(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(kVar);
    }
}
