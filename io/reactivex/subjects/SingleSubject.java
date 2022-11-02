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
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final SingleDisposable[] EMPTY;
    public static final SingleDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<SingleDisposable<T>[]> observers;
    public final AtomicBoolean once;
    public T value;

    /* loaded from: classes8.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7650903191002190468L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver<? super T> actual;

        public SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, singleSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> andSet;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (andSet = getAndSet(null)) != null) {
                andSet.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (get() == null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1753904750, "Lio/reactivex/subjects/SingleSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1753904750, "Lio/reactivex/subjects/SingleSubject;");
                return;
            }
        }
        EMPTY = new SingleDisposable[0];
        TERMINATED = new SingleDisposable[0];
    }

    @CheckReturnValue
    @NonNull
    public static <T> SingleSubject<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new SingleSubject<>();
        }
        return (SingleSubject) invokeV.objValue;
    }

    @Nullable
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.observers.get() == TERMINATED) {
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
            if (this.observers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.observers.get().length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.observers.get() == TERMINATED && this.error != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.observers.get() == TERMINATED && this.value != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int observerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.observers.get().length;
        }
        return invokeV.intValue;
    }

    public SingleSubject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.once = new AtomicBoolean();
        this.observers = new AtomicReference<>(EMPTY);
    }

    public boolean add(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleDisposable)) == null) {
            do {
                singleDisposableArr = this.observers.get();
                if (singleDisposableArr == TERMINATED) {
                    return false;
                }
                int length = singleDisposableArr.length;
                singleDisposableArr2 = new SingleDisposable[length + 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
                singleDisposableArr2[length] = singleDisposable;
            } while (!this.observers.compareAndSet(singleDisposableArr, singleDisposableArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && this.observers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onError(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.error = th;
                for (SingleDisposable<T> singleDisposable : this.observers.getAndSet(TERMINATED)) {
                    singleDisposable.actual.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.value = t;
                for (SingleDisposable<T> singleDisposable : this.observers.getAndSet(TERMINATED)) {
                    singleDisposable.actual.onSuccess(t);
                }
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.Single
    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, singleObserver) == null) {
            SingleDisposable<T> singleDisposable = new SingleDisposable<>(singleObserver, this);
            singleObserver.onSubscribe(singleDisposable);
            if (add(singleDisposable)) {
                if (singleDisposable.isDisposed()) {
                    remove(singleDisposable);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess((T) this.value);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.SingleSubject$SingleDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, singleDisposable) == null) {
            do {
                singleDisposableArr = this.observers.get();
                int length = singleDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    singleDisposableArr2 = EMPTY;
                } else {
                    SingleDisposable[] singleDisposableArr3 = new SingleDisposable[length - 1];
                    System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                    System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                    singleDisposableArr2 = singleDisposableArr3;
                }
            } while (!this.observers.compareAndSet(singleDisposableArr, singleDisposableArr2));
        }
    }
}
