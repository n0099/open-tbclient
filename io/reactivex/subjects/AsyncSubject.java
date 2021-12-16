package io.reactivex.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class AsyncSubject<T> extends Subject<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncDisposable[] EMPTY;
    public static final AsyncDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<AsyncDisposable<T>[]> subscribers;
    public T value;

    /* loaded from: classes4.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5629876084736248016L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AsyncSubject<T> parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, asyncSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Observer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && super.tryDispose()) {
                this.parent.remove(this);
            }
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.actual.onError(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-645831888, "Lio/reactivex/subjects/AsyncSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-645831888, "Lio/reactivex/subjects/AsyncSubject;");
                return;
            }
        }
        EMPTY = new AsyncDisposable[0];
        TERMINATED = new AsyncDisposable[0];
    }

    public AsyncSubject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new AsyncSubject<>() : (AsyncSubject) invokeV.objValue;
    }

    public boolean add(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, asyncDisposable)) == null) {
            do {
                asyncDisposableArr = this.subscribers.get();
                if (asyncDisposableArr == TERMINATED) {
                    return false;
                }
                int length = asyncDisposableArr.length;
                asyncDisposableArr2 = new AsyncDisposable[length + 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
                asyncDisposableArr2[length] = asyncDisposable;
            } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.error;
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Nullable
    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T value = getValue();
            return value != null ? new Object[]{value} : new Object[0];
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.subscribers.get() == TERMINATED && this.error == null : invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.subscribers.get().length != 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.subscribers.get() == TERMINATED && this.error != null : invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.subscribers.get() == TERMINATED && this.value != null : invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
            AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
            if (asyncDisposableArr == asyncDisposableArr2) {
                return;
            }
            T t = this.value;
            AsyncDisposable<T>[] andSet = this.subscribers.getAndSet(asyncDisposableArr2);
            int i2 = 0;
            if (t == null) {
                int length = andSet.length;
                while (i2 < length) {
                    andSet[i2].onComplete();
                    i2++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i2 < length2) {
                andSet[i2].complete(t);
                i2++;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
            AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
            if (asyncDisposableArr == asyncDisposableArr2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.value = null;
            this.error = th;
            for (AsyncDisposable<T> asyncDisposable : this.subscribers.getAndSet(asyncDisposableArr2)) {
                asyncDisposable.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.subscribers.get() == TERMINATED) {
                return;
            }
            this.value = t;
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, disposable) == null) && this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.AsyncSubject$AsyncDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, asyncDisposable) == null) {
            do {
                asyncDisposableArr = this.subscribers.get();
                int length = asyncDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (asyncDisposableArr[i3] == asyncDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    asyncDisposableArr2 = EMPTY;
                } else {
                    AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                    System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i2);
                    System.arraycopy(asyncDisposableArr, i2 + 1, asyncDisposableArr3, i2, (length - i2) - 1);
                    asyncDisposableArr2 = asyncDisposableArr3;
                }
            } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, observer) == null) {
            AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(observer, this);
            observer.onSubscribe(asyncDisposable);
            if (add(asyncDisposable)) {
                if (asyncDisposable.isDisposed()) {
                    remove(asyncDisposable);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                asyncDisposable.complete(t);
            } else {
                asyncDisposable.onComplete();
            }
        }
    }

    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
            T value = getValue();
            if (value == null) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length == 0) {
                tArr = (T[]) Arrays.copyOf(tArr, 1);
            }
            tArr[0] = value;
            if (tArr.length != 1) {
                tArr[1] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }
}
