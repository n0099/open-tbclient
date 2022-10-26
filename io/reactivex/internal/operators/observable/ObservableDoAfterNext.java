package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;
/* loaded from: classes8.dex */
public final class ObservableDoAfterNext extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Consumer onAfterNext;

    /* loaded from: classes8.dex */
    public final class DoAfterObserver extends BasicFuseableObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Consumer onAfterNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoAfterObserver(Observer observer, Consumer consumer) {
            super(observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Observer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.onAfterNext = consumer;
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.actual.onNext(obj);
                if (this.sourceMode == 0) {
                    try {
                        this.onAfterNext.accept(obj);
                    } catch (Throwable th) {
                        fail(th);
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return transitiveBoundaryFusion(i);
            }
            return invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Object poll = this.qs.poll();
                if (poll != null) {
                    this.onAfterNext.accept(poll);
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableDoAfterNext(ObservableSource observableSource, Consumer consumer) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, consumer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.onAfterNext = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new DoAfterObserver(observer, this.onAfterNext));
        }
    }
}
