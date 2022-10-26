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
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class AsyncSubject extends Subject {
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncDisposable[] EMPTY;
    public static final AsyncDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference subscribers;
    public Object value;

    /* loaded from: classes8.dex */
    public final class AsyncDisposable extends DeferredScalarDisposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5629876084736248016L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AsyncSubject parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncDisposable(Observer observer, AsyncSubject asyncSubject) {
            super(observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, asyncSubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !isDisposed()) {
                this.actual.onComplete();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscribers = new AtomicReference(EMPTY);
    }

    @CheckReturnValue
    public static AsyncSubject create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new AsyncSubject();
        }
        return (AsyncSubject) invokeV.objValue;
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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object value = getValue();
            return value != null ? new Object[]{value} : new Object[0];
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.error == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (((AsyncDisposable[]) this.subscribers.get()).length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.error != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.value != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean add(AsyncDisposable asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, asyncDisposable)) == null) {
            do {
                asyncDisposableArr = (AsyncDisposable[]) this.subscribers.get();
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

    public Object[] getValues(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            Object value = getValue();
            if (value == null) {
                if (objArr.length != 0) {
                    objArr[0] = null;
                }
                return objArr;
            }
            if (objArr.length == 0) {
                objArr = Arrays.copyOf(objArr, 1);
            }
            objArr[0] = value;
            if (objArr.length != 1) {
                objArr[1] = null;
            }
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.subscribers.get() == TERMINATED) {
                return;
            }
            this.value = obj;
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, disposable) == null) && this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Object obj = this.subscribers.get();
            Object obj2 = TERMINATED;
            if (obj == obj2) {
                return;
            }
            Object obj3 = this.value;
            AsyncDisposable[] asyncDisposableArr = (AsyncDisposable[]) this.subscribers.getAndSet(obj2);
            int i = 0;
            if (obj3 == null) {
                int length = asyncDisposableArr.length;
                while (i < length) {
                    asyncDisposableArr[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncDisposableArr.length;
            while (i < length2) {
                asyncDisposableArr[i].complete(obj3);
                i++;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            Object obj = this.subscribers.get();
            Object obj2 = TERMINATED;
            if (obj == obj2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.value = null;
            this.error = th;
            for (AsyncDisposable asyncDisposable : (AsyncDisposable[]) this.subscribers.getAndSet(obj2)) {
                asyncDisposable.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, observer) == null) {
            AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
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
            Object obj = this.value;
            if (obj != null) {
                asyncDisposable.complete(obj);
            } else {
                asyncDisposable.onComplete();
            }
        }
    }

    public void remove(AsyncDisposable asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, asyncDisposable) == null) {
            do {
                asyncDisposableArr = (AsyncDisposable[]) this.subscribers.get();
                int length = asyncDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncDisposableArr[i2] == asyncDisposable) {
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
                    asyncDisposableArr2 = EMPTY;
                } else {
                    AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                    System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                    System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                    asyncDisposableArr2 = asyncDisposableArr3;
                }
            } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        }
    }
}
