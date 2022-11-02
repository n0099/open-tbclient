package io.reactivex.subscribers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QUEUE_LINK_SIZE = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public final Subscriber<? super T> actual;
    public final boolean delayError;
    public volatile boolean done;
    public boolean emitting;
    public AppendOnlyLinkedArrayList<Object> queue;
    public Subscription subscription;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Subscriber) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actual = subscriber;
        this.delayError = z;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.subscription.cancel();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.reactivestreams.Subscriber<? super T>, org.reactivestreams.Subscriber<? super U> */
    public void emitLoop() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            do {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
            } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super T>) this.actual));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.complete());
                return;
            }
            this.done = true;
            this.emitting = true;
            this.actual.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            synchronized (this) {
                boolean z = true;
                if (!this.done) {
                    if (this.emitting) {
                        this.done = true;
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        Object error = NotificationLite.error(th);
                        if (this.delayError) {
                            appendOnlyLinkedArrayList.add(error);
                        } else {
                            appendOnlyLinkedArrayList.setFirst(error);
                        }
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.actual.onError(th);
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, t) != null) || this.done) {
            return;
        }
        if (t == null) {
            this.subscription.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            this.actual.onNext(t);
            emitLoop();
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) && SubscriptionHelper.validate(this.subscription, subscription)) {
            this.subscription = subscription;
            this.actual.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.subscription.request(j);
        }
    }
}
