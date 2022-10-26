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
/* loaded from: classes8.dex */
public final class FlowableScalarXMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public final class ScalarXMapFlowable extends Flowable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function mapper;
        public final Object value;

        public ScalarXMapFlowable(Object obj, Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.mapper = function;
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
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

    public static Flowable scalarXMap(Object obj, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, function)) == null) {
            return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(obj, function));
        }
        return (Flowable) invokeLL.objValue;
    }

    public static boolean tryScalarXMapSubscribe(Publisher publisher, Subscriber subscriber, Function function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, publisher, subscriber, function)) == null) {
            if (publisher instanceof Callable) {
                try {
                    Object call = ((Callable) publisher).call();
                    if (call == null) {
                        EmptySubscription.complete(subscriber);
                        return true;
                    }
                    try {
                        Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null Publisher");
                        if (publisher2 instanceof Callable) {
                            try {
                                Object call2 = ((Callable) publisher2).call();
                                if (call2 == null) {
                                    EmptySubscription.complete(subscriber);
                                    return true;
                                }
                                subscriber.onSubscribe(new ScalarSubscription(subscriber, call2));
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
