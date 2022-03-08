package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T[] array;

    /* loaded from: classes8.dex */
    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber<? super T> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Object[]) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                T[] tArr = this.array;
                int length = tArr.length;
                ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                for (int i2 = this.index; i2 != length; i2++) {
                    if (this.cancelled) {
                        return;
                    }
                    T t = tArr[i2];
                    if (t == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(t);
                }
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                T[] tArr = this.array;
                int length = tArr.length;
                int i2 = this.index;
                ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2 || i2 == length) {
                            if (i2 == length) {
                                if (this.cancelled) {
                                    return;
                                }
                                conditionalSubscriber.onComplete();
                                return;
                            }
                            j2 = get();
                            if (j3 == j2) {
                                this.index = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (this.cancelled) {
                            return;
                        } else {
                            T t = tArr[i2];
                            if (t == null) {
                                conditionalSubscriber.onError(new NullPointerException("array element is null"));
                                return;
                            }
                            if (conditionalSubscriber.tryOnNext(t)) {
                                j3++;
                            }
                            i2++;
                        }
                    }
                } while (j2 != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Object[]) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                T[] tArr = this.array;
                int length = tArr.length;
                Subscriber<? super T> subscriber = this.actual;
                for (int i2 = this.index; i2 != length; i2++) {
                    if (this.cancelled) {
                        return;
                    }
                    T t = tArr[i2];
                    if (t == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    subscriber.onNext(t);
                }
                if (this.cancelled) {
                    return;
                }
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                T[] tArr = this.array;
                int length = tArr.length;
                int i2 = this.index;
                Subscriber<? super T> subscriber = this.actual;
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2 || i2 == length) {
                            if (i2 == length) {
                                if (this.cancelled) {
                                    return;
                                }
                                subscriber.onComplete();
                                return;
                            }
                            j2 = get();
                            if (j3 == j2) {
                                this.index = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (this.cancelled) {
                            return;
                        } else {
                            T t = tArr[i2];
                            if (t == null) {
                                subscriber.onError(new NullPointerException("array element is null"));
                                return;
                            }
                            subscriber.onNext(t);
                            j3++;
                            i2++;
                        }
                    }
                } while (j2 != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2252972430506210021L;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] array;
        public volatile boolean cancelled;
        public int index;

        public BaseArraySubscription(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.array = tArr;
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
                this.index = this.array.length;
            }
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.index == this.array.length : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i2 = this.index;
                T[] tArr = this.array;
                if (i2 == tArr.length) {
                    return null;
                }
                this.index = i2 + 1;
                return (T) ObjectHelper.requireNonNull(tArr[i2], "array element is null");
            }
            return (T) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) && SubscriptionHelper.validate(j2) && BackpressureHelper.add(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 & 1 : invokeI.intValue;
        }

        public abstract void slowPath(long j2);
    }

    public FlowableFromArray(T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.array = tArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
            } else {
                subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
            }
        }
    }
}
