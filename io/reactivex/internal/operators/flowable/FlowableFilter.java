package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class FlowableFilter extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Predicate predicate;

    /* loaded from: classes8.dex */
    public final class FilterConditionalSubscriber extends BasicFuseableConditionalSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Predicate filter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Predicate predicate) {
            super(conditionalSubscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, predicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ConditionalSubscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && !tryOnNext(obj)) {
                this.s.request(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return transitiveBoundaryFusion(i);
            }
            return invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                QueueSubscription queueSubscription = this.qs;
                Predicate predicate = this.filter;
                while (true) {
                    Object poll = queueSubscription.poll();
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
            } else {
                return invokeV.objValue;
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    return this.actual.tryOnNext(null);
                }
                try {
                    if (!this.filter.test(obj) || !this.actual.tryOnNext(obj)) {
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class FilterSubscriber extends BasicFuseableSubscriber implements ConditionalSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Predicate filter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterSubscriber(Subscriber subscriber, Predicate predicate) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, predicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && !tryOnNext(obj)) {
                this.s.request(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return transitiveBoundaryFusion(i);
            }
            return invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                QueueSubscription queueSubscription = this.qs;
                Predicate predicate = this.filter;
                while (true) {
                    Object poll = queueSubscription.poll();
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
            } else {
                return invokeV.objValue;
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return true;
                }
                try {
                    boolean test = this.filter.test(obj);
                    if (test) {
                        this.actual.onNext(obj);
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
    public FlowableFilter(Flowable flowable, Predicate predicate) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, predicate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.predicate = predicate;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
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
