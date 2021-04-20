package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    public final DataSource<CloseableReference<T>>[] mDataSources;
    @GuardedBy("this")
    public int mFinishedDataSources = 0;

    /* loaded from: classes5.dex */
    public class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        @GuardedBy("InternalDataSubscriber.this")
        public boolean mFinished;

        public InternalDataSubscriber() {
            this.mFinished = false;
        }

        private synchronized boolean tryFinish() {
            if (this.mFinished) {
                return false;
            }
            this.mFinished = true;
            return true;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceCancelled();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceFailed(dataSource);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            if (dataSource.isFinished() && tryFinish()) {
                ListDataSource.this.onDataSourceFinished();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceProgress();
        }
    }

    public ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.mDataSources = dataSourceArr;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        Preconditions.checkNotNull(dataSourceArr);
        Preconditions.checkState(dataSourceArr.length > 0);
        ListDataSource<T> listDataSource = new ListDataSource<>(dataSourceArr);
        for (DataSource<CloseableReference<T>> dataSource : dataSourceArr) {
            if (dataSource != null) {
                listDataSource.getClass();
                dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
            }
        }
        return listDataSource;
    }

    private synchronized boolean increaseAndCheckIfLast() {
        int i;
        i = this.mFinishedDataSources + 1;
        this.mFinishedDataSources = i;
        return i == this.mDataSources.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceCancelled() {
        setFailure(new CancellationException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFailed(DataSource<CloseableReference<T>> dataSource) {
        setFailure(dataSource.getFailureCause());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFinished() {
        if (increaseAndCheckIfLast()) {
            setResult(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceProgress() {
        float f2 = 0.0f;
        for (DataSource<CloseableReference<T>> dataSource : this.mDataSources) {
            f2 += dataSource.getProgress();
        }
        setProgress(f2 / this.mDataSources.length);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (super.close()) {
            for (DataSource<CloseableReference<T>> dataSource : this.mDataSources) {
                dataSource.close();
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        boolean z;
        if (!isClosed()) {
            z = this.mFinishedDataSources == this.mDataSources.length;
        }
        return z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public synchronized List<CloseableReference<T>> getResult() {
        if (hasResult()) {
            ArrayList arrayList = new ArrayList(this.mDataSources.length);
            for (DataSource<CloseableReference<T>> dataSource : this.mDataSources) {
                arrayList.add(dataSource.getResult());
            }
            return arrayList;
        }
        return null;
    }
}
