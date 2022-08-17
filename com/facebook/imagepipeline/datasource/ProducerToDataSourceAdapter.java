package com.facebook.imagepipeline.datasource;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, settableProducerContext, requestListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Producer) objArr2[0], (SettableProducerContext) objArr2[1], (RequestListener2) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <T> DataSource<T> create(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, producer, settableProducerContext, requestListener2)) == null) ? new ProducerToDataSourceAdapter(producer, settableProducerContext, requestListener2) : (DataSource) invokeLLL.objValue;
    }
}
