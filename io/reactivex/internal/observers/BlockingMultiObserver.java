package io.reactivex.internal.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f63964d;
    public Throwable error;
    public T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingMultiObserver() {
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
    }

    public boolean blockingAwait(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) {
            if (getCount() != 0) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    if (!await(j2, timeUnit)) {
                        dispose();
                        return false;
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            Throwable th = this.error;
            if (th == null) {
                return true;
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
        return invokeJL.booleanValue;
    }

    public T blockingGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    public Throwable blockingGetError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getCount() != 0) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    await();
                } catch (InterruptedException e2) {
                    dispose();
                    return e2;
                }
            }
            return this.error;
        }
        return (Throwable) invokeV.objValue;
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.cancelled = true;
            Disposable disposable = this.f63964d;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            countDown();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            this.error = th;
            countDown();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) {
            this.f63964d = disposable;
            if (this.cancelled) {
                disposable.dispose();
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            this.value = t;
            countDown();
        }
    }

    public Throwable blockingGetError(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j2, timeUnit)) == null) {
            if (getCount() != 0) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    if (!await(j2, timeUnit)) {
                        dispose();
                        throw ExceptionHelper.wrapOrThrow(new TimeoutException());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            return this.error;
        }
        return (Throwable) invokeJL.objValue;
    }

    public T blockingGet(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
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
                T t2 = this.value;
                return t2 != null ? t2 : t;
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
        return (T) invokeL.objValue;
    }
}
