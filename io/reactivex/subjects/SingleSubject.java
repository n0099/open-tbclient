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
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SingleSubject extends Single implements SingleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final SingleDisposable[] EMPTY;
    public static final SingleDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference observers;
    public final AtomicBoolean once;
    public Object value;

    /* loaded from: classes8.dex */
    public final class SingleDisposable extends AtomicReference implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7650903191002190468L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver actual;

        public SingleDisposable(SingleObserver singleObserver, SingleSubject singleSubject) {
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
            SingleSubject singleSubject;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (singleSubject = (SingleSubject) getAndSet(null)) != null) {
                singleSubject.remove(this);
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
    public static SingleSubject create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new SingleSubject();
        }
        return (SingleSubject) invokeV.objValue;
    }

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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.observers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return invokeV.objValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (((SingleDisposable[]) this.observers.get()).length != 0) {
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
            return ((SingleDisposable[]) this.observers.get()).length;
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
        this.observers = new AtomicReference(EMPTY);
    }

    public boolean add(SingleDisposable singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleDisposable)) == null) {
            do {
                singleDisposableArr = (SingleDisposable[]) this.observers.get();
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
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && this.observers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.error = th;
                for (SingleDisposable singleDisposable : (SingleDisposable[]) this.observers.getAndSet(TERMINATED)) {
                    singleDisposable.actual.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.once.compareAndSet(false, true)) {
                this.value = obj;
                for (SingleDisposable singleDisposable : (SingleDisposable[]) this.observers.getAndSet(TERMINATED)) {
                    singleDisposable.actual.onSuccess(obj);
                }
            }
        }
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, singleObserver) == null) {
            SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
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
                singleObserver.onSuccess(this.value);
            }
        }
    }

    public void remove(SingleDisposable singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, singleDisposable) == null) {
            do {
                singleDisposableArr = (SingleDisposable[]) this.observers.get();
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
