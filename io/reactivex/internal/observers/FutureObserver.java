package io.reactivex.internal.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<Disposable> s;
    public T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FutureObserver() {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.s = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            do {
                disposable = this.s.get();
                if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                    return false;
                }
            } while (!this.s.compareAndSet(disposable, disposableHelper));
            if (disposable != null) {
                disposable.dispose();
            }
            countDown();
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getCount() != 0) {
                BlockingHelper.verifyNonBlocking();
                await();
            }
            if (!isCancelled()) {
                Throwable th = this.error;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            }
            throw new CancellationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DisposableHelper.isDisposed(this.s.get()) : invokeV.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? isDone() : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCount() == 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable disposable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.value == null) {
                onError(new NoSuchElementException("The source is empty"));
                return;
            }
            do {
                disposable = this.s.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    return;
                }
            } while (!this.s.compareAndSet(disposable, this));
            countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Disposable disposable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            if (this.error == null) {
                this.error = th;
                do {
                    disposable = this.s.get();
                    if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                        RxJavaPlugins.onError(th);
                        return;
                    }
                } while (!this.s.compareAndSet(disposable, this));
                countDown();
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            if (this.value != null) {
                this.s.get().dispose();
                onError(new IndexOutOfBoundsException("More than one element received"));
                return;
            }
            this.value = t;
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, disposable) == null) {
            DisposableHelper.setOnce(this.s, disposable);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, timeUnit)) == null) {
            if (getCount() != 0) {
                BlockingHelper.verifyNonBlocking();
                if (!await(j2, timeUnit)) {
                    throw new TimeoutException();
                }
            }
            if (!isCancelled()) {
                Throwable th = this.error;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            }
            throw new CancellationException();
        }
        return (T) invokeJL.objValue;
    }
}
