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
/* loaded from: classes9.dex */
public final class FlowableRange extends Flowable<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int end;
    public final int start;

    /* loaded from: classes9.dex */
    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2252972430506210021L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final int end;
        public int index;

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i & 1 : invokeI.intValue;
        }

        public abstract void slowPath(long j);

        public BaseRangeSubscription(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.index = i;
            this.end = i2;
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.index == this.end) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final Integer poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i = this.index;
                if (i == this.end) {
                    return null;
                }
                this.index = i + 1;
                return Integer.valueOf(i);
            }
            return (Integer) invokeV.objValue;
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
    }

    /* loaded from: classes9.dex */
    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber<? super Integer> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.end;
                ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
                for (int i2 = this.index; i2 != i; i2++) {
                    if (this.cancelled) {
                        return;
                    }
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i2));
                }
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = this.end;
                int i2 = this.index;
                ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j && i2 != i) {
                            if (this.cancelled) {
                                return;
                            }
                            if (conditionalSubscriber.tryOnNext(Integer.valueOf(i2))) {
                                j2++;
                            }
                            i2++;
                        } else if (i2 == i) {
                            if (!this.cancelled) {
                                conditionalSubscriber.onComplete();
                                return;
                            }
                            return;
                        } else {
                            j = get();
                            if (j2 == j) {
                                this.index = i2;
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class RangeSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super Integer> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RangeSubscription(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.end;
                Subscriber<? super Integer> subscriber = this.actual;
                for (int i2 = this.index; i2 != i; i2++) {
                    if (this.cancelled) {
                        return;
                    }
                    subscriber.onNext(Integer.valueOf(i2));
                }
                if (this.cancelled) {
                    return;
                }
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = this.end;
                int i2 = this.index;
                Subscriber<? super Integer> subscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j && i2 != i) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onNext(Integer.valueOf(i2));
                            j2++;
                            i2++;
                        } else if (i2 == i) {
                            if (!this.cancelled) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        } else {
                            j = get();
                            if (j2 == j) {
                                this.index = i2;
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public FlowableRange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.start = i;
        this.end = i + i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
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
