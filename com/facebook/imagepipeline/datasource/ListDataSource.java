package com.facebook.imagepipeline.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ListDataSource extends AbstractDataSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource[] mDataSources;
    public int mFinishedDataSources;

    /* renamed from: com.facebook.imagepipeline.datasource.ListDataSource$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class InternalDataSubscriber implements DataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mFinished;
        public final /* synthetic */ ListDataSource this$0;

        public InternalDataSubscriber(ListDataSource listDataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {listDataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = listDataSource;
            this.mFinished = false;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                this.this$0.onDataSourceCancelled();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) != null) {
                return;
            }
            this.this$0.onDataSourceFailed(dataSource);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource) == null) && dataSource.isFinished() && tryFinish()) {
                this.this$0.onDataSourceFinished();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
                this.this$0.onDataSourceProgress();
            }
        }

        public /* synthetic */ InternalDataSubscriber(ListDataSource listDataSource, AnonymousClass1 anonymousClass1) {
            this(listDataSource);
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
    }

    public ListDataSource(DataSource[] dataSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSourceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataSources = dataSourceArr;
        this.mFinishedDataSources = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFailed(DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, dataSource) == null) {
            setFailure(dataSource.getFailureCause());
        }
    }

    public static ListDataSource create(DataSource... dataSourceArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dataSourceArr)) == null) {
            Preconditions.checkNotNull(dataSourceArr);
            if (dataSourceArr.length > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            ListDataSource listDataSource = new ListDataSource(dataSourceArr);
            for (DataSource dataSource : dataSourceArr) {
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
                z = true;
                int i = this.mFinishedDataSources + 1;
                this.mFinishedDataSources = i;
                if (i != this.mDataSources.length) {
                    z = false;
                }
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
    public void onDataSourceFinished() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && increaseAndCheckIfLast()) {
            setResult(null, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            float f = 0.0f;
            for (DataSource dataSource : this.mDataSources) {
                f += dataSource.getProgress();
            }
            setProgress(f / this.mDataSources.length);
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
            for (DataSource dataSource : this.mDataSources) {
                dataSource.close();
            }
            return true;
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
                    if (this.mFinishedDataSources == this.mDataSources.length) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public synchronized List getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (!hasResult()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.mDataSources.length);
                for (DataSource dataSource : this.mDataSources) {
                    arrayList.add(dataSource.getResult());
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }
}
