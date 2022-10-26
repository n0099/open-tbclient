package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class BlockingObservableLatest implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ObservableSource source;

    /* loaded from: classes8.dex */
    public final class BlockingObservableLatestIterator extends DisposableObserver implements Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Notification iteratorNotification;
        public final Semaphore notify;
        public final AtomicReference value;

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public BlockingObservableLatestIterator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.notify = new Semaphore(0);
            this.value = new AtomicReference();
        }

        @Override // java.util.Iterator
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (hasNext()) {
                    Object value = this.iteratorNotification.getValue();
                    this.iteratorNotification = null;
                    return value;
                }
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                throw new UnsupportedOperationException("Read-only iterator.");
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Notification notification = this.iteratorNotification;
                if (notification != null && notification.isOnError()) {
                    throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
                }
                if (this.iteratorNotification == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.notify.acquire();
                        Notification notification2 = (Notification) this.value.getAndSet(null);
                        this.iteratorNotification = notification2;
                        if (notification2.isOnError()) {
                            throw ExceptionHelper.wrapOrThrow(notification2.getError());
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.iteratorNotification = Notification.createOnError(e);
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                }
                return this.iteratorNotification.isOnNext();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.Observer
        public void onNext(Notification notification) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, notification) == null) {
                if (this.value.getAndSet(notification) == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.notify.release();
                }
            }
        }
    }

    public BlockingObservableLatest(ObservableSource observableSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
            Observable.wrap(this.source).materialize().subscribe(blockingObservableLatestIterator);
            return blockingObservableLatestIterator;
        }
        return (Iterator) invokeV.objValue;
    }
}
