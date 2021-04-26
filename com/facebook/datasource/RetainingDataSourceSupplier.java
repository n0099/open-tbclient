package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());
    @Nullable
    public Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;

    /* loaded from: classes6.dex */
    public static class RetainingDataSource<T> extends AbstractDataSource<T> {
        @GuardedBy("RetainingDataSource.this")
        @Nullable
        public DataSource<T> mDataSource;

        /* loaded from: classes6.dex */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            public InternalDataSubscriber() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                RetainingDataSource.this.onDataSourceFailed(dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    RetainingDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }

        public RetainingDataSource() {
            this.mDataSource = null;
        }

        public static <T> void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(DataSource<T> dataSource) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDatasourceProgress(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (super.close()) {
                    DataSource<T> dataSource = this.mDataSource;
                    this.mDataSource = null;
                    closeSafely(dataSource);
                    return true;
                }
                return false;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            return this.mDataSource != null ? this.mDataSource.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            boolean z;
            if (this.mDataSource != null) {
                z = this.mDataSource.hasResult();
            }
            return z;
        }

        public void setSupplier(@Nullable Supplier<DataSource<T>> supplier) {
            if (isClosed()) {
                return;
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (isClosed()) {
                    closeSafely(dataSource);
                    return;
                }
                DataSource<T> dataSource2 = this.mDataSource;
                this.mDataSource = dataSource;
                if (dataSource != null) {
                    dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
                }
                closeSafely(dataSource2);
            }
        }
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (RetainingDataSource retainingDataSource : this.mDataSources) {
            if (!retainingDataSource.isClosed()) {
                retainingDataSource.setSupplier(supplier);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        RetainingDataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }
}
