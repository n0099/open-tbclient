package io.reactivex.internal.observers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f45287d;
    public Throwable error;
    public T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingBaseObserver() {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final T blockingGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getCount() != 0) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    await();
                } catch (InterruptedException e2) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
        return (T) invokeV.objValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.cancelled = true;
            Disposable disposable = this.f45287d;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cancelled : invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            countDown();
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
            this.f45287d = disposable;
            if (this.cancelled) {
                disposable.dispose();
            }
        }
    }
}
