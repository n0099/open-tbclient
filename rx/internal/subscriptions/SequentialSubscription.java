package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hda;
import com.baidu.tieba.r8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<r8a> implements r8a {
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

    public r8a current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r8a r8aVar = (r8a) super.get();
            if (r8aVar == Unsubscribed.INSTANCE) {
                return hda.c();
            }
            return r8aVar;
        }
        return (r8a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r8a
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

    @Override // com.baidu.tieba.r8a
    public void unsubscribe() {
        r8a andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r8a r8aVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (r8aVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(r8a r8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r8aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(r8aVar);
    }

    public boolean replace(r8a r8aVar) {
        r8a r8aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r8aVar)) == null) {
            do {
                r8aVar2 = get();
                if (r8aVar2 == Unsubscribed.INSTANCE) {
                    if (r8aVar != null) {
                        r8aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(r8aVar2, r8aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(r8a r8aVar) {
        r8a r8aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, r8aVar)) == null) {
            do {
                r8aVar2 = get();
                if (r8aVar2 == Unsubscribed.INSTANCE) {
                    if (r8aVar != null) {
                        r8aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(r8aVar2, r8aVar));
            if (r8aVar2 != null) {
                r8aVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(r8a r8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, r8aVar)) == null) {
            r8a r8aVar2 = get();
            if (r8aVar2 == Unsubscribed.INSTANCE) {
                if (r8aVar != null) {
                    r8aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(r8aVar2, r8aVar) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (r8aVar != null) {
                    r8aVar.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(r8a r8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, r8aVar)) == null) {
            r8a r8aVar2 = get();
            if (r8aVar2 == Unsubscribed.INSTANCE) {
                if (r8aVar != null) {
                    r8aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(r8aVar2, r8aVar)) {
                return true;
            } else {
                r8a r8aVar3 = get();
                if (r8aVar != null) {
                    r8aVar.unsubscribe();
                }
                if (r8aVar3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
