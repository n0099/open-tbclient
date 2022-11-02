package io.reactivex.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2746389416410565408L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayCompositeSubscription(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Subscription andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (get(0) != SubscriptionHelper.CANCELLED) {
                int length = length();
                for (int i = 0; i < length; i++) {
                    Subscription subscription = get(i);
                    SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                    if (subscription != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != SubscriptionHelper.CANCELLED && andSet != null) {
                        andSet.cancel();
                    }
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (get(0) != SubscriptionHelper.CANCELLED) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Subscription replaceResource(int i, Subscription subscription) {
        Subscription subscription2;
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, subscription)) == null) {
            do {
                subscription2 = get(i);
                if (subscription2 == SubscriptionHelper.CANCELLED) {
                    if (subscription != null) {
                        subscription.cancel();
                        return null;
                    }
                    return null;
                }
            } while (!compareAndSet(i, subscription2, subscription));
            return subscription2;
        }
        return (Subscription) invokeIL.objValue;
    }

    public boolean setResource(int i, Subscription subscription) {
        Subscription subscription2;
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, subscription)) == null) {
            do {
                subscription2 = get(i);
                if (subscription2 == SubscriptionHelper.CANCELLED) {
                    if (subscription != null) {
                        subscription.cancel();
                        return false;
                    }
                    return false;
                }
            } while (!compareAndSet(i, subscription2, subscription));
            if (subscription2 != null) {
                subscription2.cancel();
                return true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }
}
