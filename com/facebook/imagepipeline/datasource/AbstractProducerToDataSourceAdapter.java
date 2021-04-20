package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    public final RequestListener mRequestListener;
    public final SettableProducerContext mSettableProducerContext;

    public AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        }
        this.mSettableProducerContext = settableProducerContext;
        this.mRequestListener = requestListener;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
        }
        this.mRequestListener.onRequestStart(settableProducerContext.getImageRequest(), this.mSettableProducerContext.getCallerContext(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
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

    private Consumer<T> createConsumer() {
        return new BaseConsumer<T>() { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                AbstractProducerToDataSourceAdapter.this.onFailureImpl(th);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(@Nullable T t, int i) {
                AbstractProducerToDataSourceAdapter.this.onNewResultImpl(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f2) {
                AbstractProducerToDataSourceAdapter.this.setProgress(f2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onCancellationImpl() {
        Preconditions.checkState(isClosed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureImpl(Throwable th) {
        if (super.setFailure(th)) {
            this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), th, this.mSettableProducerContext.isPrefetch());
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (super.close()) {
            if (super.isFinished()) {
                return true;
            }
            this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
            this.mSettableProducerContext.cancel();
            return true;
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public ImageRequest getImageRequest() {
        return this.mSettableProducerContext.getImageRequest();
    }

    public void onNewResultImpl(@Nullable T t, int i) {
        boolean isLast = BaseConsumer.isLast(i);
        if (super.setResult(t, isLast) && isLast) {
            this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        }
    }
}
