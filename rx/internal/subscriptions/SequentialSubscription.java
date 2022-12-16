package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i3a;
import com.baidu.tieba.y7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<i3a> implements i3a {
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

    public i3a current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i3a i3aVar = (i3a) super.get();
            if (i3aVar == Unsubscribed.INSTANCE) {
                return y7a.c();
            }
            return i3aVar;
        }
        return (i3a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i3a
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

    @Override // com.baidu.tieba.i3a
    public void unsubscribe() {
        i3a andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i3a i3aVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (i3aVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(i3a i3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(i3aVar);
    }

    public boolean replace(i3a i3aVar) {
        i3a i3aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i3aVar)) == null) {
            do {
                i3aVar2 = get();
                if (i3aVar2 == Unsubscribed.INSTANCE) {
                    if (i3aVar != null) {
                        i3aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(i3aVar2, i3aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(i3a i3aVar) {
        i3a i3aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, i3aVar)) == null) {
            do {
                i3aVar2 = get();
                if (i3aVar2 == Unsubscribed.INSTANCE) {
                    if (i3aVar != null) {
                        i3aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(i3aVar2, i3aVar));
            if (i3aVar2 != null) {
                i3aVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(i3a i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, i3aVar)) == null) {
            i3a i3aVar2 = get();
            if (i3aVar2 == Unsubscribed.INSTANCE) {
                if (i3aVar != null) {
                    i3aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(i3aVar2, i3aVar) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (i3aVar != null) {
                    i3aVar.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(i3a i3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, i3aVar)) == null) {
            i3a i3aVar2 = get();
            if (i3aVar2 == Unsubscribed.INSTANCE) {
                if (i3aVar != null) {
                    i3aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(i3aVar2, i3aVar)) {
                return true;
            } else {
                i3a i3aVar3 = get();
                if (i3aVar != null) {
                    i3aVar.unsubscribe();
                }
                if (i3aVar3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
