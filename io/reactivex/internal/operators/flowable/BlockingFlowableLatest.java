package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
/* loaded from: classes10.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher<? extends T> source;

    /* loaded from: classes10.dex */
    public static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Notification<T> iteratorNotification;
        public final Semaphore notify;
        public final AtomicReference<Notification<T>> value;

        public LatestSubscriberIterator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.notify = new Semaphore(0);
            this.value = new AtomicReference<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Notification<T> notification = this.iteratorNotification;
                if (notification != null && notification.isOnError()) {
                    throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
                }
                Notification<T> notification2 = this.iteratorNotification;
                if ((notification2 == null || notification2.isOnNext()) && this.iteratorNotification == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.notify.acquire();
                        Notification<T> andSet = this.value.getAndSet(null);
                        this.iteratorNotification = andSet;
                        if (andSet.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.getError());
                        }
                    } catch (InterruptedException e2) {
                        dispose();
                        this.iteratorNotification = Notification.createOnError(e2);
                        throw ExceptionHelper.wrapOrThrow(e2);
                    }
                }
                return this.iteratorNotification.isOnNext();
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (hasNext() && this.iteratorNotification.isOnNext()) {
                    T value = this.iteratorNotification.getValue();
                    this.iteratorNotification = null;
                    return value;
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Notification) ((Notification) obj));
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                throw new UnsupportedOperationException("Read-only iterator.");
            }
        }

        public void onNext(Notification<T> notification) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, notification) == null) {
                if (this.value.getAndSet(notification) == null) {
                    this.notify.release();
                }
            }
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
            Flowable.fromPublisher(this.source).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) latestSubscriberIterator);
            return latestSubscriberIterator;
        }
        return (Iterator) invokeV.objValue;
    }
}
