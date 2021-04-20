package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final boolean mDataSourceLazy;
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    @ThreadSafe
    /* loaded from: classes5.dex */
    public class IncreasingQualityDataSource extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        public ArrayList<DataSource<T>> mDataSources;
        @Nullable
        public Throwable mDelayedError;
        public AtomicInteger mFinishedDataSources;
        @GuardedBy("IncreasingQualityDataSource.this")
        public int mIndexOfDataSourceWithResult;
        public int mNumberOfDataSources;

        /* loaded from: classes5.dex */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            public int mIndex;

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, dataSource);
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }

        public IncreasingQualityDataSource() {
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                return;
            }
            ensureDataSourceInitialized();
        }

        private void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        private void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources != null) {
                return;
            }
            synchronized (this) {
                if (this.mFinishedDataSources == null) {
                    this.mFinishedDataSources = new AtomicInteger(0);
                    int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                    this.mNumberOfDataSources = size;
                    this.mIndexOfDataSourceWithResult = size;
                    this.mDataSources = new ArrayList<>(size);
                    for (int i = 0; i < size; i++) {
                        DataSource<T> dataSource = (DataSource) ((Supplier) IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
                        this.mDataSources.add(dataSource);
                        dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
                        if (dataSource.hasResult()) {
                            break;
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized DataSource<T> getAndClearDataSource(int i) {
            DataSource<T> dataSource;
            dataSource = null;
            if (this.mDataSources != null && i < this.mDataSources.size()) {
                dataSource = this.mDataSources.set(i, null);
            }
            return dataSource;
        }

        @Nullable
        private synchronized DataSource<T> getDataSource(int i) {
            return (this.mDataSources == null || i >= this.mDataSources.size()) ? null : this.mDataSources.get(i);
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        private void maybeSetFailure() {
            Throwable th;
            if (this.mFinishedDataSources.incrementAndGet() != this.mNumberOfDataSources || (th = this.mDelayedError) == null) {
                return;
            }
            setFailure(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0024 A[LOOP:0: B:17:0x0022->B:18:0x0024, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void maybeSetIndexOfDataSourceWithResult(int i, DataSource<T> dataSource, boolean z) {
            synchronized (this) {
                int i2 = this.mIndexOfDataSourceWithResult;
                if (dataSource == getDataSource(i) && i != this.mIndexOfDataSourceWithResult) {
                    if (getDataSourceWithResult() != null && (!z || i >= this.mIndexOfDataSourceWithResult)) {
                        i = i2;
                        for (int i3 = this.mIndexOfDataSourceWithResult; i3 > i; i3--) {
                            closeSafely(getAndClearDataSource(i3));
                        }
                    }
                    this.mIndexOfDataSourceWithResult = i;
                    while (i3 > i) {
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(int i, DataSource<T> dataSource) {
            closeSafely(tryGetAndClearDataSource(i, dataSource));
            if (i == 0) {
                this.mDelayedError = dataSource.getFailureCause();
            }
            maybeSetFailure();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(int i, DataSource<T> dataSource) {
            maybeSetIndexOfDataSourceWithResult(i, dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, i == 0 && dataSource.isFinished());
            }
            maybeSetFailure();
        }

        @Nullable
        private synchronized DataSource<T> tryGetAndClearDataSource(int i, DataSource<T> dataSource) {
            if (dataSource == getDataSourceWithResult()) {
                return null;
            }
            if (dataSource == getDataSource(i)) {
                return getAndClearDataSource(i);
            }
            return dataSource;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            synchronized (this) {
                if (super.close()) {
                    ArrayList<DataSource<T>> arrayList = this.mDataSources;
                    this.mDataSources = null;
                    if (arrayList != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            closeSafely(arrayList.get(i));
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            boolean z;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            DataSource<T> dataSourceWithResult = getDataSourceWithResult();
            if (dataSourceWithResult != null) {
                z = dataSourceWithResult.hasResult();
            }
            return z;
        }
    }

    public IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return create(list, false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IncreasingQualityDataSourceSupplier) {
            return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
        }
        return false;
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list, boolean z) {
        return new IncreasingQualityDataSourceSupplier<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        return new IncreasingQualityDataSource();
    }
}
