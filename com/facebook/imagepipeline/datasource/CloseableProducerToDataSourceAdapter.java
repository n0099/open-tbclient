package com.facebook.imagepipeline.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
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

    public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, producer, settableProducerContext, requestListener2)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
            }
            CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener2);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return closeableProducerToDataSourceAdapter;
        }
        return (DataSource) invokeLLL.objValue;
    }

    public void onNewResultImpl(CloseableReference<T> closeableReference, int i, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, closeableReference, i, producerContext) == null) {
            super.onNewResultImpl((CloseableProducerToDataSourceAdapter<T>) CloseableReference.cloneOrNull(closeableReference), i, producerContext);
        }
    }

    public void closeResult(CloseableReference<T> closeableReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, closeableReference) == null) {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public /* bridge */ /* synthetic */ void closeResult(Object obj) {
        closeResult((CloseableReference) ((CloseableReference) obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public CloseableReference<T> getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i, ProducerContext producerContext) {
        onNewResultImpl((CloseableReference) ((CloseableReference) obj), i, producerContext);
    }
}
