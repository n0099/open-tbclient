package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
/* loaded from: classes2.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Predicate<? super T> predicate;

    /* loaded from: classes2.dex */
    public static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Predicate<? super T> filter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, predicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ConditionalSubscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || tryOnNext(t)) {
                return;
            }
            this.s.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (T) invokeV.objValue;
            }
            QueueSubscription<T> queueSubscription = this.qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? transitiveBoundaryFusion(i2) : invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    return this.actual.tryOnNext(null);
                }
                try {
                    return this.filter.test(t) && this.actual.tryOnNext(t);
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Predicate<? super T> filter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, predicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || tryOnNext(t)) {
                return;
            }
            this.s.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (T) invokeV.objValue;
            }
            QueueSubscription<T> queueSubscription = this.qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? transitiveBoundaryFusion(i2) : invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return true;
                }
                try {
                    boolean test = this.filter.test(t);
                    if (test) {
                        this.actual.onNext(t);
                    }
                    return test;
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableFilter(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, predicate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.predicate = predicate;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            if (subscriber instanceof ConditionalSubscriber) {
                this.source.subscribe((FlowableSubscriber) new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.predicate));
            } else {
                this.source.subscribe((FlowableSubscriber) new FilterSubscriber(subscriber, this.predicate));
            }
        }
    }
}
