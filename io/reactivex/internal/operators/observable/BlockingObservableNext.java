package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ObservableSource<T> source;

    /* loaded from: classes8.dex */
    public static final class NextIterator<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Throwable error;
        public boolean hasNext;
        public boolean isNextConsumed;
        public final ObservableSource<T> items;
        public T next;
        public final NextObserver<T> observer;
        public boolean started;

        public NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observableSource, nextObserver};
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
            this.items = observableSource;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (!this.started) {
                    this.started = true;
                    this.observer.setWaiting();
                    new ObservableMaterialize(this.items).subscribe(this.observer);
                }
                try {
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
                    Throwable error = takeNext.getError();
                    this.error = error;
                    throw ExceptionHelper.wrapOrThrow(error);
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

    /* loaded from: classes8.dex */
    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BlockingQueue<Notification<T>> buf;
        public final AtomicInteger waiting;

        public NextObserver() {
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
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

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NextIterator(this.source, new NextObserver()) : (Iterator) invokeV.objValue;
    }
}
