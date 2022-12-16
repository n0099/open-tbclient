package io.reactivex.subscribers;

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
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes9.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Subscriber<? super T> actual;
    public volatile boolean cancelled;
    public final AtomicLong missedRequested;
    public QueueSubscription<T> qs;
    public final AtomicReference<Subscription> subscription;

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class EmptySubscriber implements FlowableSubscriber<Object> {
        public static final /* synthetic */ EmptySubscriber[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EmptySubscriber INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1905719231, "Lio/reactivex/subscribers/TestSubscriber$EmptySubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1905719231, "Lio/reactivex/subscribers/TestSubscriber$EmptySubscriber;");
                    return;
                }
            }
            EmptySubscriber emptySubscriber = new EmptySubscriber("INSTANCE", 0);
            INSTANCE = emptySubscriber;
            $VALUES = new EmptySubscriber[]{emptySubscriber};
        }

        public static EmptySubscriber[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (EmptySubscriber[]) $VALUES.clone();
            }
            return (EmptySubscriber[]) invokeV.objValue;
        }

        public EmptySubscriber(String str, int i) {
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

        public static EmptySubscriber valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (EmptySubscriber) Enum.valueOf(EmptySubscriber.class, str);
            }
            return (EmptySubscriber) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Subscriber) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestSubscriber(long j) {
        this(EmptySubscriber.INSTANCE, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Subscriber) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String fusionModeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TestSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Subscriber) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber, Long.valueOf(j)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (j >= 0) {
            this.actual = subscriber;
            this.subscription = new AtomicReference<>();
            this.missedRequested = new AtomicLong(j);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    public static <T> TestSubscriber<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new TestSubscriber<>();
        }
        return (TestSubscriber) invokeV.objValue;
    }

    public final TestSubscriber<T> assertFuseable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.qs != null) {
                return this;
            }
            throw new AssertionError("Upstream is not fuseable.");
        }
        return (TestSubscriber) invokeV.objValue;
    }

    public final TestSubscriber<T> assertNotFuseable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.qs == null) {
                return this;
            }
            throw new AssertionError("Upstream is fuseable.");
        }
        return (TestSubscriber) invokeV.objValue;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.cancelled) {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.subscription);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cancel();
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
            return this.cancelled;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.cancelled;
        }
        return invokeV.booleanValue;
    }

    public static <T> TestSubscriber<T> create(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            return new TestSubscriber<>(j);
        }
        return (TestSubscriber) invokeJ.objValue;
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> consumer) {
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
        return (TestSubscriber) invokeL.objValue;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            SubscriptionHelper.deferredRequest(this.subscription, this.missedRequested, j);
        }
    }

    public final TestSubscriber<T> requestMore(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            request(j);
            return this;
        }
        return (TestSubscriber) invokeJ.objValue;
    }

    public final TestSubscriber<T> setInitialFusionMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.initialFusionMode = i;
            return this;
        }
        return (TestSubscriber) invokeI.objValue;
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, subscriber)) == null) {
            return new TestSubscriber<>(subscriber);
        }
        return (TestSubscriber) invokeL.objValue;
    }

    public final TestSubscriber<T> assertFusionMode(int i) {
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
        return (TestSubscriber) invokeI.objValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, th) == null) {
            if (!this.checkSubscriptionOnce) {
                this.checkSubscriptionOnce = true;
                if (this.subscription.get() == null) {
                    this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
                }
            }
            try {
                this.lastThread = Thread.currentThread();
                this.errors.add(th);
                if (th == null) {
                    this.errors.add(new IllegalStateException("onError received a null Throwable"));
                }
                this.actual.onError(th);
            } finally {
                this.done.countDown();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertNotSubscribed() {
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
        return (TestSubscriber) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestSubscriber<T> assertSubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.subscription.get() != null) {
                return this;
            }
            throw fail("Not subscribed!");
        }
        return (TestSubscriber) invokeV.objValue;
    }

    @Override // org.reactivestreams.Subscriber
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

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, t) == null) {
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
                    if (poll != null) {
                        this.values.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.errors.add(th);
                    this.qs.cancel();
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, subscription) == null) {
            this.lastThread = Thread.currentThread();
            if (subscription == null) {
                this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            } else if (!this.subscription.compareAndSet(null, subscription)) {
                subscription.cancel();
                if (this.subscription.get() != SubscriptionHelper.CANCELLED) {
                    this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                }
            } else {
                int i = this.initialFusionMode;
                if (i != 0 && (subscription instanceof QueueSubscription)) {
                    QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
                    this.qs = queueSubscription;
                    int requestFusion = queueSubscription.requestFusion(i);
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
                                    return;
                                }
                            } catch (Throwable th) {
                                this.errors.add(th);
                                return;
                            }
                        }
                    }
                }
                this.actual.onSubscribe(subscription);
                long andSet = this.missedRequested.getAndSet(0L);
                if (andSet != 0) {
                    subscription.request(andSet);
                }
                onStart();
            }
        }
    }
}
