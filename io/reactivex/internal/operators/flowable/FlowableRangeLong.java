package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class FlowableRangeLong extends Flowable<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long end;
    public final long start;

    /* loaded from: classes8.dex */
    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2252972430506210021L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final long end;
        public long index;

        public BaseRangeSubscription(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = j;
            this.end = j2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.index = this.end;
            }
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.index == this.end : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i & 1 : invokeI.intValue;
        }

        public abstract void slowPath(long j);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final Long poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                long j = this.index;
                if (j == this.end) {
                    return null;
                }
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            return (Long) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber<? super Long> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.end;
                ConditionalSubscriber<? super Long> conditionalSubscriber = this.actual;
                for (long j2 = this.index; j2 != j; j2++) {
                    if (this.cancelled) {
                        return;
                    }
                    conditionalSubscriber.tryOnNext(Long.valueOf(j2));
                }
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                long j2 = this.end;
                long j3 = this.index;
                ConditionalSubscriber<? super Long> conditionalSubscriber = this.actual;
                do {
                    long j4 = 0;
                    while (true) {
                        if (j4 == j || j3 == j2) {
                            if (j3 == j2) {
                                if (this.cancelled) {
                                    return;
                                }
                                conditionalSubscriber.onComplete();
                                return;
                            }
                            j = get();
                            if (j4 == j) {
                                this.index = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (this.cancelled) {
                            return;
                        } else {
                            if (conditionalSubscriber.tryOnNext(Long.valueOf(j3))) {
                                j4++;
                            }
                            j3++;
                        }
                    }
                } while (j != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class RangeSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super Long> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.end;
                Subscriber<? super Long> subscriber = this.actual;
                for (long j2 = this.index; j2 != j; j2++) {
                    if (this.cancelled) {
                        return;
                    }
                    subscriber.onNext(Long.valueOf(j2));
                }
                if (this.cancelled) {
                    return;
                }
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                long j2 = this.end;
                long j3 = this.index;
                Subscriber<? super Long> subscriber = this.actual;
                do {
                    long j4 = 0;
                    while (true) {
                        if (j4 == j || j3 == j2) {
                            if (j3 == j2) {
                                if (this.cancelled) {
                                    return;
                                }
                                subscriber.onComplete();
                                return;
                            }
                            j = get();
                            if (j4 == j) {
                                this.index = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (this.cancelled) {
                            return;
                        } else {
                            subscriber.onNext(Long.valueOf(j3));
                            j4++;
                            j3++;
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public FlowableRangeLong(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.start = j;
        this.end = j + j2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.start, this.end));
            } else {
                subscriber.onSubscribe(new RangeSubscription(subscriber, this.start, this.end));
            }
        }
    }
}
