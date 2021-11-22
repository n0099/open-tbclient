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
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final MaybeDisposable[] EMPTY;
    public static final MaybeDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<MaybeDisposable<T>[]> observers;
    public final AtomicBoolean once;
    public T value;

    /* loaded from: classes2.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7650903191002190468L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver<? super T> actual;

        public MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, maybeSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeSubject<T> andSet;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (andSet = getAndSet(null)) == null) {
                return;
            }
            andSet.remove(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == null : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(843030812, "Lio/reactivex/subjects/MaybeSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(843030812, "Lio/reactivex/subjects/MaybeSubject;");
                return;
            }
        }
        EMPTY = new MaybeDisposable[0];
        TERMINATED = new MaybeDisposable[0];
    }

    public MaybeSubject() {
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
        this.once = new AtomicBoolean();
        this.observers = new AtomicReference<>(EMPTY);
    }

    @CheckReturnValue
    public static <T> MaybeSubject<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new MaybeSubject<>() : (MaybeSubject) invokeV.objValue;
    }

    public boolean add(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, maybeDisposable)) == null) {
            do {
                maybeDisposableArr = this.observers.get();
                if (maybeDisposableArr == TERMINATED) {
                    return false;
                }
                int length = maybeDisposableArr.length;
                maybeDisposableArr2 = new MaybeDisposable[length + 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
                maybeDisposableArr2[length] = maybeDisposable;
            } while (!this.observers.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
            return true;
        }
        return invokeL.booleanValue;
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

    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.observers.get() == TERMINATED && this.value == null && this.error == null : invokeV.booleanValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.observers.get().length != 0 : invokeV.booleanValue;
    }

    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.observers.get() == TERMINATED && this.error != null : invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.observers.get() == TERMINATED && this.value != null : invokeV.booleanValue;
    }

    public int observerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.observers.get().length : invokeV.intValue;
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.once.compareAndSet(false, true)) {
                for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(TERMINATED)) {
                    maybeDisposable.actual.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.error = th;
                for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(TERMINATED)) {
                    maybeDisposable.actual.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, disposable) == null) && this.observers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.value = t;
                for (MaybeDisposable<T> maybeDisposable : this.observers.getAndSet(TERMINATED)) {
                    maybeDisposable.actual.onSuccess(t);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.MaybeSubject$MaybeDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, maybeDisposable) == null) {
            do {
                maybeDisposableArr = this.observers.get();
                int length = maybeDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (maybeDisposableArr[i3] == maybeDisposable) {
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
                    maybeDisposableArr2 = EMPTY;
                } else {
                    MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                    System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i2);
                    System.arraycopy(maybeDisposableArr, i2 + 1, maybeDisposableArr3, i2, (length - i2) - 1);
                    maybeDisposableArr2 = maybeDisposableArr3;
                }
            } while (!this.observers.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        }
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, maybeObserver) == null) {
            MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(maybeObserver, this);
            maybeObserver.onSubscribe(maybeDisposable);
            if (add(maybeDisposable)) {
                if (maybeDisposable.isDisposed()) {
                    remove(maybeDisposable);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            Object obj = (T) this.value;
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        }
    }
}
