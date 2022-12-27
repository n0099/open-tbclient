package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j3a;
import com.baidu.tieba.z7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<j3a> implements j3a {
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

    public j3a current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j3a j3aVar = (j3a) super.get();
            if (j3aVar == Unsubscribed.INSTANCE) {
                return z7a.c();
            }
            return j3aVar;
        }
        return (j3a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j3a
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

    @Override // com.baidu.tieba.j3a
    public void unsubscribe() {
        j3a andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j3a j3aVar = get();
            Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
            if (j3aVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
                andSet.unsubscribe();
            }
        }
    }

    public SequentialSubscription(j3a j3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j3aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lazySet(j3aVar);
    }

    public boolean replace(j3a j3aVar) {
        j3a j3aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j3aVar)) == null) {
            do {
                j3aVar2 = get();
                if (j3aVar2 == Unsubscribed.INSTANCE) {
                    if (j3aVar != null) {
                        j3aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(j3aVar2, j3aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean update(j3a j3aVar) {
        j3a j3aVar2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, j3aVar)) == null) {
            do {
                j3aVar2 = get();
                if (j3aVar2 == Unsubscribed.INSTANCE) {
                    if (j3aVar != null) {
                        j3aVar.unsubscribe();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(j3aVar2, j3aVar));
            if (j3aVar2 != null) {
                j3aVar2.unsubscribe();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean replaceWeak(j3a j3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, j3aVar)) == null) {
            j3a j3aVar2 = get();
            if (j3aVar2 == Unsubscribed.INSTANCE) {
                if (j3aVar != null) {
                    j3aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(j3aVar2, j3aVar) || get() != Unsubscribed.INSTANCE) {
                return true;
            } else {
                if (j3aVar != null) {
                    j3aVar.unsubscribe();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean updateWeak(j3a j3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, j3aVar)) == null) {
            j3a j3aVar2 = get();
            if (j3aVar2 == Unsubscribed.INSTANCE) {
                if (j3aVar != null) {
                    j3aVar.unsubscribe();
                }
                return false;
            } else if (compareAndSet(j3aVar2, j3aVar)) {
                return true;
            } else {
                j3a j3aVar3 = get();
                if (j3aVar != null) {
                    j3aVar.unsubscribe();
                }
                if (j3aVar3 != Unsubscribed.INSTANCE) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
