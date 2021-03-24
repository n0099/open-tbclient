package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class DataSources {

    /* loaded from: classes.dex */
    public static class ValueHolder<T> {
        @Nullable
        public T value;

        public ValueHolder() {
            this.value = null;
        }
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() { // from class: com.facebook.datasource.DataSources.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setResult(t);
        return create;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() { // from class: com.facebook.datasource.DataSources.2
            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource2) {
                countDownLatch.countDown();
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Throwable, T] */
            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource2) {
                try {
                    valueHolder2.value = dataSource2.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource2) {
                if (dataSource2.isFinished()) {
                    try {
                        ValueHolder.this.value = dataSource2.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource2) {
            }
        }, new Executor() { // from class: com.facebook.datasource.DataSources.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        T t = valueHolder2.value;
        if (t == null) {
            return valueHolder.value;
        }
        throw ((Throwable) t);
    }
}
