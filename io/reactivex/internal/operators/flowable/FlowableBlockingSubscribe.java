package io.reactivex.internal.operators.flowable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes10.dex */
public final class FlowableBlockingSubscribe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FlowableBlockingSubscribe() {
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
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Subscriber<? super T> subscriber) {
        Object poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, publisher, subscriber) == null) {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
            publisher.subscribe(blockingSubscriber);
            do {
                try {
                    if (blockingSubscriber.isCancelled()) {
                        return;
                    }
                    poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        if (blockingSubscriber.isCancelled()) {
                            return;
                        }
                        BlockingHelper.verifyNonBlocking();
                        poll = linkedBlockingQueue.take();
                    }
                    if (blockingSubscriber.isCancelled() || publisher == BlockingSubscriber.TERMINATED) {
                        return;
                    }
                } catch (InterruptedException e2) {
                    blockingSubscriber.cancel();
                    subscriber.onError(e2);
                    return;
                }
            } while (!NotificationLite.acceptFull(poll, subscriber));
        }
    }

    public static <T> void subscribe(Publisher<? extends T> publisher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, publisher) == null) {
            BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
            LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.REQUEST_MAX);
            publisher.subscribe(lambdaSubscriber);
            BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaSubscriber);
            Throwable th = blockingIgnoringReceiver.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, publisher, consumer, consumer2, action) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            subscribe(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.REQUEST_MAX));
        }
    }
}
