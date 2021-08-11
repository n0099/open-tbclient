package io.reactivex.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7028635084060361255L;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<Subscription> actual;
    public final AtomicReference<Disposable> resource;

    public AsyncSubscription() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SubscriptionHelper.cancel(this.actual);
            DisposableHelper.dispose(this.resource);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.actual.get() == SubscriptionHelper.CANCELLED : invokeV.booleanValue;
    }

    public boolean replaceResource(Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, disposable)) == null) ? DisposableHelper.replace(this.resource, disposable) : invokeL.booleanValue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            SubscriptionHelper.deferredRequest(this.actual, this, j2);
        }
    }

    public boolean setResource(Disposable disposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, disposable)) == null) ? DisposableHelper.set(this.resource, disposable) : invokeL.booleanValue;
    }

    public void setSubscription(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, subscription) == null) {
            SubscriptionHelper.deferredSetOnce(this.actual, this, subscription);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncSubscription(Disposable disposable) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {disposable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.resource.lazySet(disposable);
    }
}
