package io.reactivex.internal.operators.observable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class ObservableAutoConnect extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger clients;
    public final Consumer connection;
    public final int numberOfObservers;
    public final ConnectableObservable source;

    public ObservableAutoConnect(ConnectableObservable connectableObservable, int i, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectableObservable, Integer.valueOf(i), consumer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = connectableObservable;
        this.numberOfObservers = i;
        this.connection = consumer;
        this.clients = new AtomicInteger();
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(observer);
            if (this.clients.incrementAndGet() == this.numberOfObservers) {
                this.source.connect(this.connection);
            }
        }
    }
}
