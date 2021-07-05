package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Consumer<T> mConsumer;
    public final ProducerListener mProducerListener;
    public final String mProducerName;
    public final String mRequestId;

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {consumer, producerListener, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConsumer = consumer;
        this.mProducerListener = producerListener;
        this.mProducerName = str;
        this.mRequestId = str2;
        producerListener.onProducerStart(str2, str);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public abstract void disposeResult(T t);

    @Nullable
    public Map<String, String> getExtraMapOnCancellation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Nullable
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }

    @Nullable
    public Map<String, String> getExtraMapOnSuccess(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ProducerListener producerListener = this.mProducerListener;
            String str = this.mRequestId;
            producerListener.onProducerFinishWithCancellation(str, this.mProducerName, producerListener.requiresExtraMap(str) ? getExtraMapOnCancellation() : null);
            this.mConsumer.onCancellation();
        }
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            ProducerListener producerListener = this.mProducerListener;
            String str = this.mRequestId;
            producerListener.onProducerFinishWithFailure(str, this.mProducerName, exc, producerListener.requiresExtraMap(str) ? getExtraMapOnFailure(exc) : null);
            this.mConsumer.onFailure(exc);
        }
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            ProducerListener producerListener = this.mProducerListener;
            String str = this.mRequestId;
            producerListener.onProducerFinishWithSuccess(str, this.mProducerName, producerListener.requiresExtraMap(str) ? getExtraMapOnSuccess(t) : null);
            this.mConsumer.onNewResult(t, 1);
        }
    }
}
