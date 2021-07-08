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
/* loaded from: classes9.dex */
public abstract class ConnectableFlowable<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnectableFlowable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public Flowable<T> autoConnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? autoConnect(1) : (Flowable) invokeV.objValue;
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

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @NonNull
    public Flowable<T> refCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableRefCount(this)) : (Flowable) invokeV.objValue;
    }

    @NonNull
    public Flowable<T> autoConnect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? autoConnect(i2, Functions.emptyConsumer()) : (Flowable) invokeI.objValue;
    }

    @NonNull
    public Flowable<T> autoConnect(int i2, @NonNull Consumer<? super Disposable> consumer) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, consumer)) == null) {
            if (i2 <= 0) {
                connect(consumer);
                return RxJavaPlugins.onAssembly((ConnectableFlowable) this);
            }
            return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, i2, consumer));
        }
        return (Flowable) invokeIL.objValue;
    }
}
