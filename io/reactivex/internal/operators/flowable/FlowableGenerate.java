package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableGenerate extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Consumer disposeState;
    public final BiFunction generator;
    public final Callable stateSupplier;

    /* loaded from: classes8.dex */
    public final class GeneratorSubscription extends AtomicLong implements Emitter, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7565982551505011832L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public final Consumer disposeState;
        public final BiFunction generator;
        public boolean hasNext;
        public Object state;
        public boolean terminate;

        public GeneratorSubscription(Subscriber subscriber, BiFunction biFunction, Consumer consumer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, biFunction, consumer, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = obj;
        }

        private void dispose(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, obj) == null) {
                try {
                    this.disposeState.accept(obj);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.terminate) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                this.terminate = true;
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                if (BackpressureHelper.add(this, 1L) == 0) {
                    Object obj = this.state;
                    this.state = null;
                    dispose(obj);
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.terminate) {
                this.terminate = true;
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && !this.terminate) {
                if (this.hasNext) {
                    onError(new IllegalStateException("onNext already called in this generate turn"));
                } else if (obj == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.hasNext = true;
                    this.actual.onNext(obj);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(1048580, this, j) != null) || !SubscriptionHelper.validate(j) || BackpressureHelper.add(this, j) != 0) {
                return;
            }
            Object obj = this.state;
            BiFunction biFunction = this.generator;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            this.state = null;
                            dispose(obj);
                            return;
                        }
                        this.hasNext = false;
                        try {
                            obj = biFunction.apply(obj, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                dispose(obj);
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.cancelled = true;
                            this.state = null;
                            onError(th);
                            dispose(obj);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            this.state = obj;
                            j = addAndGet(-j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableGenerate(Callable callable, BiFunction biFunction, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, biFunction, consumer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            try {
                subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.generator, this.disposeState, this.stateSupplier.call()));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        }
    }
}
