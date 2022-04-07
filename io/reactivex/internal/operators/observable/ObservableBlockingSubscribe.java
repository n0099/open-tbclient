package io.reactivex.internal.operators.observable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public final class ObservableBlockingSubscribe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ObservableBlockingSubscribe() {
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
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void subscribe(ObservableSource<? extends T> observableSource, Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, observableSource, observer) == null) {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
            observer.onSubscribe(blockingObserver);
            observableSource.subscribe(blockingObserver);
            while (!blockingObserver.isDisposed()) {
                Object poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    try {
                        poll = linkedBlockingQueue.take();
                    } catch (InterruptedException e) {
                        blockingObserver.dispose();
                        observer.onError(e);
                        return;
                    }
                }
                if (blockingObserver.isDisposed() || observableSource == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, observer)) {
                    return;
                }
                while (!blockingObserver.isDisposed()) {
                }
            }
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> observableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, observableSource) == null) {
            BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
            LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.emptyConsumer());
            observableSource.subscribe(lambdaObserver);
            BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaObserver);
            Throwable th = blockingIgnoringReceiver.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, observableSource, consumer, consumer2, action) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            subscribe(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.emptyConsumer()));
        }
    }
}
