package io.reactivex.flowables;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
/* loaded from: classes8.dex */
public abstract class ConnectableFlowable<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    public ConnectableFlowable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public Flowable<T> autoConnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return autoConnect(1);
        }
        return (Flowable) invokeV.objValue;
    }

    public final Disposable connect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ConnectConsumer connectConsumer = new ConnectConsumer();
            connect(connectConsumer);
            return connectConsumer.disposable;
        }
        return (Disposable) invokeV.objValue;
    }

    @NonNull
    public Flowable<T> refCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return RxJavaPlugins.onAssembly(new FlowableRefCount(this));
        }
        return (Flowable) invokeV.objValue;
    }

    @NonNull
    public Flowable<T> autoConnect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return autoConnect(i, Functions.emptyConsumer());
        }
        return (Flowable) invokeI.objValue;
    }

    @NonNull
    public Flowable<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, consumer)) == null) {
            if (i <= 0) {
                connect(consumer);
                return RxJavaPlugins.onAssembly((ConnectableFlowable) this);
            }
            return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, i, consumer));
        }
        return (Flowable) invokeIL.objValue;
    }
}
