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
/* loaded from: classes7.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Consumer<T> mConsumer;
    public final ProducerContext mProducerContext;
    public final ProducerListener2 mProducerListener;
    public final String mProducerName;

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

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {consumer, producerListener2, producerContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConsumer = consumer;
        this.mProducerListener = producerListener2;
        this.mProducerName = str;
        this.mProducerContext = producerContext;
        producerListener2.onProducerStart(producerContext, str);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ProducerListener2 producerListener2 = this.mProducerListener;
            ProducerContext producerContext = this.mProducerContext;
            String str = this.mProducerName;
            if (producerListener2.requiresExtraMap(producerContext, str)) {
                map = getExtraMapOnCancellation();
            } else {
                map = null;
            }
            producerListener2.onProducerFinishWithCancellation(producerContext, str, map);
            this.mConsumer.onCancellation();
        }
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            ProducerListener2 producerListener2 = this.mProducerListener;
            ProducerContext producerContext = this.mProducerContext;
            String str = this.mProducerName;
            if (producerListener2.requiresExtraMap(producerContext, str)) {
                map = getExtraMapOnFailure(exc);
            } else {
                map = null;
            }
            producerListener2.onProducerFinishWithFailure(producerContext, str, exc, map);
            this.mConsumer.onFailure(exc);
        }
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T t) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            ProducerListener2 producerListener2 = this.mProducerListener;
            ProducerContext producerContext = this.mProducerContext;
            String str = this.mProducerName;
            if (producerListener2.requiresExtraMap(producerContext, str)) {
                map = getExtraMapOnSuccess(t);
            } else {
                map = null;
            }
            producerListener2.onProducerFinishWithSuccess(producerContext, str, map);
            this.mConsumer.onNewResult(t, 1);
        }
    }
}
