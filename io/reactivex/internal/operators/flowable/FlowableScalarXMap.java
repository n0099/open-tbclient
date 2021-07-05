package io.reactivex.internal.operators.flowable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes10.dex */
public final class FlowableScalarXMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super T, ? extends Publisher<? extends R>> mapper;
        public final T value;

        public ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
            this.mapper = function;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply((T) this.value), "The mapper returned a null Publisher");
                    if (publisher instanceof Callable) {
                        try {
                            Object call = ((Callable) publisher).call();
                            if (call == null) {
                                EmptySubscription.complete(subscriber);
                                return;
                            } else {
                                subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    }
                    publisher.subscribe(subscriber);
                } catch (Throwable th2) {
                    EmptySubscription.error(th2, subscriber);
                }
            }
        }
    }

    public FlowableScalarXMap() {
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

    public static <T, U> Flowable<U> scalarXMap(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, function)) == null) ? RxJavaPlugins.onAssembly(new ScalarXMapFlowable(t, function)) : (Flowable) invokeLL.objValue;
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, publisher, subscriber, function)) == null) {
            if (publisher instanceof Callable) {
                try {
                    Object obj = (Object) ((Callable) publisher).call();
                    if (obj == 0) {
                        EmptySubscription.complete(subscriber);
                        return true;
                    }
                    try {
                        Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(function.apply(obj), "The mapper returned a null Publisher");
                        if (publisher2 instanceof Callable) {
                            try {
                                Object call = ((Callable) publisher2).call();
                                if (call == null) {
                                    EmptySubscription.complete(subscriber);
                                    return true;
                                }
                                subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                EmptySubscription.error(th, subscriber);
                                return true;
                            }
                        } else {
                            publisher2.subscribe(subscriber);
                        }
                        return true;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                        return true;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    EmptySubscription.error(th3, subscriber);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
