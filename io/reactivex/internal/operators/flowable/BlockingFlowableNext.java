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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
/* loaded from: classes3.dex */
public final class BlockingFlowableNext<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher<? extends T> source;

    /* loaded from: classes3.dex */
    public static final class NextIterator<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Throwable error;
        public boolean hasNext;
        public boolean isNextConsumed;
        public final Publisher<? extends T> items;
        public T next;
        public final NextSubscriber<T> observer;
        public boolean started;

        public NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {publisher, nextSubscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hasNext = true;
            this.isNextConsumed = true;
            this.items = publisher;
            this.observer = nextSubscriber;
        }

        private boolean moveToNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                try {
                    if (!this.started) {
                        this.started = true;
                        this.observer.setWaiting();
                        Flowable.fromPublisher(this.items).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) this.observer);
                    }
                    Notification<T> takeNext = this.observer.takeNext();
                    if (takeNext.isOnNext()) {
                        this.isNextConsumed = false;
                        this.next = takeNext.getValue();
                        return true;
                    }
                    this.hasNext = false;
                    if (takeNext.isOnComplete()) {
                        return false;
                    }
                    if (takeNext.isOnError()) {
                        Throwable error = takeNext.getError();
                        this.error = error;
                        throw ExceptionHelper.wrapOrThrow(error);
                    }
                    throw new IllegalStateException("Should not reach here");
                } catch (InterruptedException e2) {
                    this.observer.dispose();
                    this.error = e2;
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Throwable th = this.error;
                if (th == null) {
                    if (this.hasNext) {
                        return !this.isNextConsumed || moveToNext();
                    }
                    return false;
                }
                throw ExceptionHelper.wrapOrThrow(th);
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Throwable th = this.error;
                if (th == null) {
                    if (hasNext()) {
                        this.isNextConsumed = true;
                        return this.next;
                    }
                    throw new NoSuchElementException("No more elements");
                }
                throw ExceptionHelper.wrapOrThrow(th);
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BlockingQueue<Notification<T>> buf;
        public final AtomicInteger waiting;

        public NextSubscriber() {
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
            this.buf = new ArrayBlockingQueue(1);
            this.waiting = new AtomicInteger();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Notification) ((Notification) obj));
        }

        public void setWaiting() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.waiting.set(1);
            }
        }

        public Notification<T> takeNext() throws InterruptedException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                setWaiting();
                BlockingHelper.verifyNonBlocking();
                return this.buf.take();
            }
            return (Notification) invokeV.objValue;
        }

        public void onNext(Notification<T> notification) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, notification) == null) {
                if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                    while (!this.buf.offer(notification)) {
                        Notification<T> poll = this.buf.poll();
                        if (poll != null && !poll.isOnNext()) {
                            notification = poll;
                        }
                    }
                }
            }
        }
    }

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NextIterator(this.source, new NextSubscriber()) : (Iterator) invokeV.objValue;
    }
}
