package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class FlowableFromArray extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] array;

    /* loaded from: classes8.dex */
    public final class ArrayConditionalSubscription extends BaseArraySubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayConditionalSubscription(ConditionalSubscriber conditionalSubscriber, Object[] objArr) {
            super(objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {conditionalSubscriber, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                Object[] objArr = this.array;
                int length = objArr.length;
                ConditionalSubscriber conditionalSubscriber = this.actual;
                for (int i = this.index; i != length; i++) {
                    if (this.cancelled) {
                        return;
                    }
                    Object obj = objArr[i];
                    if (obj == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(obj);
                }
                if (this.cancelled) {
                    return;
                }
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Object[] objArr = this.array;
                int length = objArr.length;
                int i = this.index;
                ConditionalSubscriber conditionalSubscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j && i != length) {
                            if (this.cancelled) {
                                return;
                            }
                            Object obj = objArr[i];
                            if (obj == null) {
                                conditionalSubscriber.onError(new NullPointerException("array element is null"));
                                return;
                            }
                            if (conditionalSubscriber.tryOnNext(obj)) {
                                j2++;
                            }
                            i++;
                        } else if (i == length) {
                            if (!this.cancelled) {
                                conditionalSubscriber.onComplete();
                                return;
                            }
                            return;
                        } else {
                            j = get();
                            if (j2 == j) {
                                this.index = i;
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ArraySubscription extends BaseArraySubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2587302975077663557L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArraySubscription(Subscriber subscriber, Object[] objArr) {
            super(objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {subscriber, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                Object[] objArr = this.array;
                int length = objArr.length;
                Subscriber subscriber = this.actual;
                for (int i = this.index; i != length; i++) {
                    if (this.cancelled) {
                        return;
                    }
                    Object obj = objArr[i];
                    if (obj == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    subscriber.onNext(obj);
                }
                if (this.cancelled) {
                    return;
                }
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Object[] objArr = this.array;
                int length = objArr.length;
                int i = this.index;
                Subscriber subscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j && i != length) {
                            if (this.cancelled) {
                                return;
                            }
                            Object obj = objArr[i];
                            if (obj == null) {
                                subscriber.onError(new NullPointerException("array element is null"));
                                return;
                            }
                            subscriber.onNext(obj);
                            j2++;
                            i++;
                        } else if (i == length) {
                            if (!this.cancelled) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        } else {
                            j = get();
                            if (j2 == j) {
                                this.index = i;
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class BaseArraySubscription extends BasicQueueSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2252972430506210021L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] array;
        public volatile boolean cancelled;
        public int index;

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i & 1 : invokeI.intValue;
        }

        public abstract void slowPath(long j);

        public BaseArraySubscription(Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.array = objArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.index == this.array.length) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int i = this.index;
                Object[] objArr = this.array;
                if (i == objArr.length) {
                    return null;
                }
                this.index = i + 1;
                return ObjectHelper.requireNonNull(objArr[i], "array element is null");
            }
            return invokeV.objValue;
        }
    }

    public FlowableFromArray(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.array = objArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
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
