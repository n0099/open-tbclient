package com.facebook.datasource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Supplier<DataSource<T>> mCurrentDataSourceSupplier;
    public final Set<RetainingDataSource> mDataSources;

    /* renamed from: com.facebook.datasource.RetainingDataSourceSupplier$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public RetainingDataSourceSupplier() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataSources = Collections.newSetFromMap(new WeakHashMap());
        this.mCurrentDataSourceSupplier = null;
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, supplier) == null) {
            this.mCurrentDataSourceSupplier = supplier;
            for (RetainingDataSource retainingDataSource : this.mDataSources) {
                if (!retainingDataSource.isClosed()) {
                    retainingDataSource.setSupplier(supplier);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class RetainingDataSource<T> extends AbstractDataSource<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @GuardedBy("RetainingDataSource.this")
        @Nullable
        public DataSource<T> mDataSource;

        /* loaded from: classes12.dex */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RetainingDataSource this$0;

            public InternalDataSubscriber(RetainingDataSource retainingDataSource) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {retainingDataSource};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = retainingDataSource;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                    this.this$0.onDataSourceFailed(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource) == null) {
                    if (dataSource.hasResult()) {
                        this.this$0.onDataSourceNewResult(dataSource);
                    } else if (dataSource.isFinished()) {
                        this.this$0.onDataSourceFailed(dataSource);
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
                    this.this$0.onDatasourceProgress(dataSource);
                }
            }

            public /* synthetic */ InternalDataSubscriber(RetainingDataSource retainingDataSource, AnonymousClass1 anonymousClass1) {
                this(retainingDataSource);
            }
        }

        public RetainingDataSource() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDataSource = null;
        }

        public static <T> void closeSafely(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65541, null, dataSource) == null) || dataSource == null) {
                return;
            }
            dataSource.close();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, dataSource) == null) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, this, dataSource) == null) && dataSource == this.mDataSource) {
                setResult(null, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDatasourceProgress(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65544, this, dataSource) == null) && dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return invokeV.booleanValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            InterceptResult invokeV;
            T result;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    result = this.mDataSource != null ? this.mDataSource.getResult() : null;
                }
                return result;
            }
            return (T) invokeV.objValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
                    if (this.mDataSource != null) {
                        z = this.mDataSource.hasResult();
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public void setSupplier(@Nullable Supplier<DataSource<T>> supplier) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, supplier) == null) || isClosed()) {
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
                    dataSource.subscribe(new InternalDataSubscriber(this, null), CallerThreadExecutor.getInstance());
                }
                closeSafely(dataSource2);
            }
        }

        public /* synthetic */ RetainingDataSource(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RetainingDataSource retainingDataSource = new RetainingDataSource(null);
            retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
            this.mDataSources.add(retainingDataSource);
            return retainingDataSource;
        }
        return (DataSource) invokeV.objValue;
    }
}
