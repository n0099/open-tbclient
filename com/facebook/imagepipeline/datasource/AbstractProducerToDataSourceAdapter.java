package com.facebook.imagepipeline.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class AbstractProducerToDataSourceAdapter extends AbstractDataSource implements HasImageRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RequestListener2 mRequestListener;
    public final SettableProducerContext mSettableProducerContext;

    public AbstractProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, settableProducerContext, requestListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        }
        this.mSettableProducerContext = settableProducerContext;
        this.mRequestListener = requestListener2;
        setInitialExtras();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
        }
        this.mRequestListener.onRequestStart(this.mSettableProducerContext);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
        }
        producer.produceResults(createConsumer(), settableProducerContext);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureImpl(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, th) == null) && super.setFailure(th, getExtras(this.mSettableProducerContext))) {
            this.mRequestListener.onRequestFailure(this.mSettableProducerContext, th);
        }
    }

    public Map getExtras(ProducerContext producerContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, producerContext)) == null) {
            return producerContext.getExtras();
        }
        return (Map) invokeL.objValue;
    }

    private Consumer createConsumer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return new BaseConsumer(this) { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractProducerToDataSourceAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.facebook.imagepipeline.producers.BaseConsumer
                public void onFailureImpl(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) != null) {
                        return;
                    }
                    this.this$0.onFailureImpl(th);
                }

                @Override // com.facebook.imagepipeline.producers.BaseConsumer
                public void onProgressUpdateImpl(float f) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeF(1048579, this, f) != null) {
                        return;
                    }
                    this.this$0.setProgress(f);
                }

                @Override // com.facebook.imagepipeline.producers.BaseConsumer
                public void onCancellationImpl() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onCancellationImpl();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseConsumer
                public void onNewResultImpl(@Nullable Object obj, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
                        AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.this$0;
                        abstractProducerToDataSourceAdapter.onNewResultImpl(obj, i, abstractProducerToDataSourceAdapter.mSettableProducerContext);
                    }
                }
            };
        }
        return (Consumer) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onCancellationImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (this) {
                Preconditions.checkState(isClosed());
            }
        }
    }

    private void setInitialExtras() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            setExtras(this.mSettableProducerContext.getExtras());
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!super.close()) {
                return false;
            }
            if (!super.isFinished()) {
                this.mRequestListener.onRequestCancellation(this.mSettableProducerContext);
                this.mSettableProducerContext.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public ImageRequest getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSettableProducerContext.getImageRequest();
        }
        return (ImageRequest) invokeV.objValue;
    }

    public void onNewResultImpl(@Nullable Object obj, int i, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, obj, i, producerContext) == null) {
            boolean isLast = BaseConsumer.isLast(i);
            if (super.setResult(obj, isLast, getExtras(producerContext)) && isLast) {
                this.mRequestListener.onRequestSuccess(this.mSettableProducerContext);
            }
        }
    }
}
