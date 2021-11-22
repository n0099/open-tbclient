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
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final CompletableDisposable[] EMPTY;
    public static final CompletableDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<CompletableDisposable[]> observers;
    public final AtomicBoolean once;

    /* loaded from: classes2.dex */
    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7650903191002190468L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableObserver, completableSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject andSet;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-168615174, "Lio/reactivex/subjects/CompletableSubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-168615174, "Lio/reactivex/subjects/CompletableSubject;");
                return;
            }
        }
        EMPTY = new CompletableDisposable[0];
        TERMINATED = new CompletableDisposable[0];
    }

    public CompletableSubject() {
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
    public static CompletableSubject create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new CompletableSubject() : (CompletableSubject) invokeV.objValue;
    }

    public boolean add(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, completableDisposable)) == null) {
            do {
                completableDisposableArr = this.observers.get();
                if (completableDisposableArr == TERMINATED) {
                    return false;
                }
                int length = completableDisposableArr.length;
                completableDisposableArr2 = new CompletableDisposable[length + 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
                completableDisposableArr2[length] = completableDisposable;
            } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
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

    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.observers.get() == TERMINATED && this.error == null : invokeV.booleanValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.observers.get().length != 0 : invokeV.booleanValue;
    }

    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.observers.get() == TERMINATED && this.error != null : invokeV.booleanValue;
    }

    public int observerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.observers.get().length : invokeV.intValue;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.once.compareAndSet(false, true)) {
                for (CompletableDisposable completableDisposable : this.observers.getAndSet(TERMINATED)) {
                    completableDisposable.actual.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.error = th;
                for (CompletableDisposable completableDisposable : this.observers.getAndSet(TERMINATED)) {
                    completableDisposable.actual.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && this.observers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    public void remove(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, completableDisposable) == null) {
            do {
                completableDisposableArr = this.observers.get();
                int length = completableDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (completableDisposableArr[i3] == completableDisposable) {
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
                    completableDisposableArr2 = EMPTY;
                } else {
                    CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                    System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i2);
                    System.arraycopy(completableDisposableArr, i2 + 1, completableDisposableArr3, i2, (length - i2) - 1);
                    completableDisposableArr2 = completableDisposableArr3;
                }
            } while (!this.observers.compareAndSet(completableDisposableArr, completableDisposableArr2));
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, completableObserver) == null) {
            CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
            completableObserver.onSubscribe(completableDisposable);
            if (add(completableDisposable)) {
                if (completableDisposable.isDisposed()) {
                    remove(completableDisposable);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }
}
