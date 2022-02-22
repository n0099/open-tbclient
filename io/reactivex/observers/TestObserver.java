package io.reactivex.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Observer<? super T> actual;
    public QueueDisposable<T> qs;
    public final AtomicReference<Disposable> subscription;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class EmptyObserver implements Observer<Object> {
        public static final /* synthetic */ EmptyObserver[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EmptyObserver INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(271914549, "Lio/reactivex/observers/TestObserver$EmptyObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(271914549, "Lio/reactivex/observers/TestObserver$EmptyObserver;");
                    return;
                }
            }
            EmptyObserver emptyObserver = new EmptyObserver("INSTANCE", 0);
            INSTANCE = emptyObserver;
            $VALUES = new EmptyObserver[]{emptyObserver};
        }

        public EmptyObserver(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EmptyObserver valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EmptyObserver) Enum.valueOf(EmptyObserver.class, str) : (EmptyObserver) invokeL.objValue;
        }

        public static EmptyObserver[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EmptyObserver[]) $VALUES.clone() : (EmptyObserver[]) invokeV.objValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestObserver() {
        this(EmptyObserver.INSTANCE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Observer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> TestObserver<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new TestObserver<>() : (TestObserver) invokeV.objValue;
    }

    public static String fusionModeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return "Unknown(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    return "ASYNC";
                }
                return "SYNC";
            }
            return PolyActivity.NONE_PANEL_TYPE;
        }
        return (String) invokeI.objValue;
    }

    public final TestObserver<T> assertFuseable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.qs != null) {
                return this;
            }
            throw new AssertionError("Upstream is not fuseable.");
        }
        return (TestObserver) invokeV.objValue;
    }

    public final TestObserver<T> assertFusionMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.establishedFusionMode;
            if (i3 != i2) {
                if (this.qs != null) {
                    throw new AssertionError("Fusion mode different. Expected: " + fusionModeToString(i2) + ", actual: " + fusionModeToString(i3));
                }
                throw fail("Upstream is not fuseable");
            }
            return this;
        }
        return (TestObserver) invokeI.objValue;
    }

    public final TestObserver<T> assertNotFuseable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.qs == null) {
                return this;
            }
            throw new AssertionError("Upstream is fuseable.");
        }
        return (TestObserver) invokeV.objValue;
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, consumer)) == null) {
            try {
                consumer.accept(this);
                return this;
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (TestObserver) invokeL.objValue;
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            DisposableHelper.dispose(this.subscription);
        }
    }

    public final boolean hasSubscription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.subscription.get() != null : invokeV.booleanValue;
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? isDisposed() : invokeV.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? DisposableHelper.isDisposed(this.subscription.get()) : invokeV.booleanValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.checkSubscriptionOnce) {
                this.checkSubscriptionOnce = true;
                if (this.subscription.get() == null) {
                    this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
                }
            }
            try {
                this.lastThread = Thread.currentThread();
                this.completions++;
                this.actual.onComplete();
            } finally {
                this.done.countDown();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, th) == null) {
            if (!this.checkSubscriptionOnce) {
                this.checkSubscriptionOnce = true;
                if (this.subscription.get() == null) {
                    this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
                }
            }
            try {
                this.lastThread = Thread.currentThread();
                if (th == null) {
                    this.errors.add(new NullPointerException("onError received a null Throwable"));
                } else {
                    this.errors.add(th);
                }
                this.actual.onError(th);
            } finally {
                this.done.countDown();
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048591, this, t) != null) {
            return;
        }
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.actual.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.qs.poll();
                if (poll == null) {
                    return;
                }
                this.values.add(poll);
            } catch (Throwable th) {
                this.errors.add(th);
                this.qs.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, disposable) == null) {
            this.lastThread = Thread.currentThread();
            if (disposable == null) {
                this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            } else if (!this.subscription.compareAndSet(null, disposable)) {
                disposable.dispose();
                if (this.subscription.get() != DisposableHelper.DISPOSED) {
                    this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                }
            } else {
                int i2 = this.initialFusionMode;
                if (i2 != 0 && (disposable instanceof QueueDisposable)) {
                    QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                    this.qs = queueDisposable;
                    int requestFusion = queueDisposable.requestFusion(i2);
                    this.establishedFusionMode = requestFusion;
                    if (requestFusion == 1) {
                        this.checkSubscriptionOnce = true;
                        this.lastThread = Thread.currentThread();
                        while (true) {
                            try {
                                T poll = this.qs.poll();
                                if (poll != null) {
                                    this.values.add(poll);
                                } else {
                                    this.completions++;
                                    this.subscription.lazySet(DisposableHelper.DISPOSED);
                                    return;
                                }
                            } catch (Throwable th) {
                                this.errors.add(th);
                                return;
                            }
                        }
                    }
                }
                this.actual.onSubscribe(disposable);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, t) == null) {
            onNext(t);
            onComplete();
        }
    }

    public final TestObserver<T> setInitialFusionMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.initialFusionMode = i2;
            return this;
        }
        return (TestObserver) invokeI.objValue;
    }

    public TestObserver(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscription = new AtomicReference<>();
        this.actual = observer;
    }

    public static <T> TestObserver<T> create(Observer<? super T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, observer)) == null) ? new TestObserver<>(observer) : (TestObserver) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertNotSubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.subscription.get() == null) {
                if (this.errors.isEmpty()) {
                    return this;
                }
                throw fail("Not subscribed but errors found");
            }
            throw fail("Subscribed!");
        }
        return (TestObserver) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertSubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.subscription.get() != null) {
                return this;
            }
            throw fail("Not subscribed!");
        }
        return (TestObserver) invokeV.objValue;
    }
}
