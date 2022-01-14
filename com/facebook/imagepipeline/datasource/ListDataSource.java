package com.facebook.imagepipeline.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource<CloseableReference<T>>[] mDataSources;
    @GuardedBy("this")
    public int mFinishedDataSources;

    /* renamed from: com.facebook.imagepipeline.datasource.ListDataSource$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataSources = dataSourceArr;
        this.mFinishedDataSources = 0;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dataSourceArr)) == null) {
            Preconditions.checkNotNull(dataSourceArr);
            Preconditions.checkState(dataSourceArr.length > 0);
            ListDataSource<T> listDataSource = new ListDataSource<>(dataSourceArr);
            for (DataSource<CloseableReference<T>> dataSource : dataSourceArr) {
                if (dataSource != null) {
                    listDataSource.getClass();
                    dataSource.subscribe(new InternalDataSubscriber(listDataSource, null), CallerThreadExecutor.getInstance());
                }
            }
            return listDataSource;
        }
        return (ListDataSource) invokeL.objValue;
    }

    private synchronized boolean increaseAndCheckIfLast() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this) {
                int i2 = this.mFinishedDataSources + 1;
                this.mFinishedDataSources = i2;
                z = i2 == this.mDataSources.length;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            setFailure(new CancellationException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFailed(DataSource<CloseableReference<T>> dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, dataSource) == null) {
            setFailure(dataSource.getFailureCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFinished() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && increaseAndCheckIfLast()) {
            setResult(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            float f2 = 0.0f;
            for (DataSource<CloseableReference<T>> dataSource : this.mDataSources) {
                f2 += dataSource.getProgress();
            }
            setProgress(f2 / this.mDataSources.length);
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (super.close()) {
                for (DataSource<CloseableReference<T>> dataSource : this.mDataSources) {
                    dataSource.close();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (!isClosed()) {
                    z = this.mFinishedDataSources == this.mDataSources.length;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("InternalDataSubscriber.this")
        public boolean mFinished;
        public final /* synthetic */ ListDataSource this$0;

        public InternalDataSubscriber(ListDataSource listDataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listDataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listDataSource;
            this.mFinished = false;
        }

        private synchronized boolean tryFinish() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                synchronized (this) {
                    if (this.mFinished) {
                        return false;
                    }
                    this.mFinished = true;
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                this.this$0.onDataSourceCancelled();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.this$0.onDataSourceFailed(dataSource);
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource) == null) && dataSource.isFinished() && tryFinish()) {
                this.this$0.onDataSourceFinished();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
                this.this$0.onDataSourceProgress();
            }
        }

        public /* synthetic */ InternalDataSubscriber(ListDataSource listDataSource, AnonymousClass1 anonymousClass1) {
            this(listDataSource);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public synchronized List<CloseableReference<T>> getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
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
        return (List) invokeV.objValue;
    }
}
