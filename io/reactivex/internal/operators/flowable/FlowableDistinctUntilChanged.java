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
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
/* loaded from: classes4.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BiPredicate<? super K, ? super K> comparer;
    public final Function<? super T, K> keySelector;

    /* loaded from: classes4.dex */
    public static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, function, biPredicate};
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
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || tryOnNext(t)) {
                return;
            }
            this.s.request(1L);
        }

        /* JADX DEBUG: Type inference failed for r4v0. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (T) invokeV.objValue;
            }
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                } else if (!this.comparer.test((K) this.last, apply)) {
                    this.last = apply;
                    return poll;
                } else {
                    this.last = apply;
                    if (this.sourceMode != 1) {
                        this.s.request(1L);
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? transitiveBoundaryFusion(i2) : invokeI.intValue;
        }

        /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    return this.actual.tryOnNext(t);
                }
                try {
                    K apply = this.keySelector.apply(t);
                    if (this.hasValue) {
                        boolean test = this.comparer.test((K) this.last, apply);
                        this.last = apply;
                        if (test) {
                            return false;
                        }
                    } else {
                        this.hasValue = true;
                        this.last = apply;
                    }
                    this.actual.onNext(t);
                    return true;
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiPredicate<? super K, ? super K> comparer;
        public boolean hasValue;
        public final Function<? super T, K> keySelector;
        public K last;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, biPredicate};
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
            this.keySelector = function;
            this.comparer = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || tryOnNext(t)) {
                return;
            }
            this.s.request(1L);
        }

        /* JADX DEBUG: Type inference failed for r4v0. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (T) invokeV.objValue;
            }
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                } else if (!this.comparer.test((K) this.last, apply)) {
                    this.last = apply;
                    return poll;
                } else {
                    this.last = apply;
                    if (this.sourceMode != 1) {
                        this.s.request(1L);
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? transitiveBoundaryFusion(i2) : invokeI.intValue;
        }

        /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: K, ? super K */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
                if (this.done) {
                    return false;
                }
                if (this.sourceMode != 0) {
                    this.actual.onNext(t);
                    return true;
                }
                try {
                    K apply = this.keySelector.apply(t);
                    if (this.hasValue) {
                        boolean test = this.comparer.test((K) this.last, apply);
                        this.last = apply;
                        if (test) {
                            return false;
                        }
                    } else {
                        this.hasValue = true;
                        this.last = apply;
                    }
                    this.actual.onNext(t);
                    return true;
                } catch (Throwable th) {
                    fail(th);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, biPredicate};
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
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            if (subscriber instanceof ConditionalSubscriber) {
                this.source.subscribe((FlowableSubscriber) new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.keySelector, this.comparer));
            } else {
                this.source.subscribe((FlowableSubscriber) new DistinctUntilChangedSubscriber(subscriber, this.keySelector, this.comparer));
            }
        }
    }
}
