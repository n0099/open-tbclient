package io.reactivex.observers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
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
/* loaded from: classes8.dex */
public class TestObserver extends BaseTestConsumer implements Observer, Disposable, MaybeObserver, SingleObserver, CompletableObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Observer actual;
    public QueueDisposable qs;
    public final AtomicReference subscription;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class EmptyObserver implements Observer {
        public static final /* synthetic */ EmptyObserver[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EmptyObserver INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

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

        public static EmptyObserver[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (EmptyObserver[]) $VALUES.clone();
            }
            return (EmptyObserver[]) invokeV.objValue;
        }

        public EmptyObserver(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (EmptyObserver) Enum.valueOf(EmptyObserver.class, str);
            }
            return (EmptyObserver) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestObserver() {
        this(EmptyObserver.INSTANCE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Observer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static TestObserver create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new TestObserver();
        }
        return (TestObserver) invokeV.objValue;
    }

    public final TestObserver assertFuseable() {
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

    public final TestObserver assertNotFuseable() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.subscription.get() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return isDisposed();
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return DisposableHelper.isDisposed((Disposable) this.subscription.get());
        }
        return invokeV.booleanValue;
    }

    public TestObserver(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscription = new AtomicReference();
        this.actual = observer;
    }

    public static String fusionModeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return "Unknown(" + i + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    return "ASYNC";
                }
                return "SYNC";
            }
            return HlsPlaylistParser.METHOD_NONE;
        }
        return (String) invokeI.objValue;
    }

    public static TestObserver create(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, observer)) == null) {
            return new TestObserver(observer);
        }
        return (TestObserver) invokeL.objValue;
    }

    public final TestObserver assertOf(Consumer consumer) {
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

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, obj) == null) {
            onNext(obj);
            onComplete();
        }
    }

    public final TestObserver setInitialFusionMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.initialFusionMode = i;
            return this;
        }
        return (TestObserver) invokeI.objValue;
    }

    public final TestObserver assertFusionMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.establishedFusionMode;
            if (i2 != i) {
                if (this.qs != null) {
                    throw new AssertionError("Fusion mode different. Expected: " + fusionModeToString(i) + ", actual: " + fusionModeToString(i2));
                }
                throw fail("Upstream is not fuseable");
            }
            return this;
        }
        return (TestObserver) invokeI.objValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver assertNotSubscribed() {
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
    public final TestObserver assertSubscribed() {
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
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            if (!this.checkSubscriptionOnce) {
                this.checkSubscriptionOnce = true;
                if (this.subscription.get() == null) {
                    this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
                }
            }
            this.lastThread = Thread.currentThread();
            if (this.establishedFusionMode != 2) {
                this.values.add(obj);
                if (obj == null) {
                    this.errors.add(new NullPointerException("onNext received a null value"));
                }
                this.actual.onNext(obj);
                return;
            }
            while (true) {
                try {
                    Object poll = this.qs.poll();
                    if (poll != null) {
                        this.values.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.errors.add(th);
                    this.qs.dispose();
                    return;
                }
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
                int i = this.initialFusionMode;
                if (i != 0 && (disposable instanceof QueueDisposable)) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    this.qs = queueDisposable;
                    int requestFusion = queueDisposable.requestFusion(i);
                    this.establishedFusionMode = requestFusion;
                    if (requestFusion == 1) {
                        this.checkSubscriptionOnce = true;
                        this.lastThread = Thread.currentThread();
                        while (true) {
                            try {
                                Object poll = this.qs.poll();
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
}
