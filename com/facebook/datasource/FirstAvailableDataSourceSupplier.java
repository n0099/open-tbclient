package com.facebook.datasource;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    /* renamed from: com.facebook.datasource.FirstAvailableDataSourceSupplier$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @ThreadSafe
    /* loaded from: classes7.dex */
    public class FirstAvailableDataSource extends AbstractDataSource<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DataSource<T> mCurrentDataSource;
        public DataSource<T> mDataSourceWithResult;
        public int mIndex;
        public final /* synthetic */ FirstAvailableDataSourceSupplier this$0;

        /* loaded from: classes7.dex */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FirstAvailableDataSource this$1;

            public InternalDataSubscriber(FirstAvailableDataSource firstAvailableDataSource) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {firstAvailableDataSource};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = firstAvailableDataSource;
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
                    this.this$1.onDataSourceFailed(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSource) == null) {
                    if (dataSource.hasResult()) {
                        this.this$1.onDataSourceNewResult(dataSource);
                    } else if (dataSource.isFinished()) {
                        this.this$1.onDataSourceFailed(dataSource);
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
                    this.this$1.setProgress(Math.max(this.this$1.getProgress(), dataSource.getProgress()));
                }
            }

            public /* synthetic */ InternalDataSubscriber(FirstAvailableDataSource firstAvailableDataSource, AnonymousClass1 anonymousClass1) {
                this(firstAvailableDataSource);
            }
        }

        public FirstAvailableDataSource(FirstAvailableDataSourceSupplier firstAvailableDataSourceSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {firstAvailableDataSourceSupplier};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = firstAvailableDataSourceSupplier;
            this.mIndex = 0;
            this.mCurrentDataSource = null;
            this.mDataSourceWithResult = null;
            if (startNextDataSource()) {
                return;
            }
            setFailure(new RuntimeException("No data source supplier or supplier returned null."));
        }

        private synchronized boolean clearCurrentDataSource(DataSource<T> dataSource) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, dataSource)) == null) {
                synchronized (this) {
                    if (!isClosed() && dataSource == this.mCurrentDataSource) {
                        this.mCurrentDataSource = null;
                        return true;
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        private void closeSafely(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dataSource) == null) || dataSource == null) {
                return;
            }
            dataSource.close();
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            InterceptResult invokeV;
            DataSource<T> dataSource;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                synchronized (this) {
                    dataSource = this.mDataSourceWithResult;
                }
                return dataSource;
            }
            return (DataSource) invokeV.objValue;
        }

        @Nullable
        private synchronized Supplier<DataSource<T>> getNextSupplier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                synchronized (this) {
                    if (isClosed() || this.mIndex >= this.this$0.mDataSourceSuppliers.size()) {
                        return null;
                    }
                    List list = this.this$0.mDataSourceSuppliers;
                    int i = this.mIndex;
                    this.mIndex = i + 1;
                    return (Supplier) list.get(i);
                }
            }
            return (Supplier) invokeV.objValue;
        }

        private void maybeSetDataSourceWithResult(DataSource<T> dataSource, boolean z) {
            DataSource<T> dataSource2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65543, this, dataSource, z) == null) {
                synchronized (this) {
                    if (dataSource == this.mCurrentDataSource && dataSource != this.mDataSourceWithResult) {
                        if (this.mDataSourceWithResult != null && !z) {
                            dataSource2 = null;
                            closeSafely(dataSource2);
                        }
                        DataSource<T> dataSource3 = this.mDataSourceWithResult;
                        this.mDataSourceWithResult = dataSource;
                        dataSource2 = dataSource3;
                        closeSafely(dataSource2);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65544, this, dataSource) == null) && clearCurrentDataSource(dataSource)) {
                if (dataSource != getDataSourceWithResult()) {
                    closeSafely(dataSource);
                }
                if (startNextDataSource()) {
                    return;
                }
                setFailure(dataSource.getFailureCause(), dataSource.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(DataSource<T> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, dataSource) == null) {
                maybeSetDataSourceWithResult(dataSource, dataSource.isFinished());
                if (dataSource == getDataSourceWithResult()) {
                    setResult(null, dataSource.isFinished(), dataSource.getExtras());
                }
            }
        }

        private synchronized boolean setCurrentDataSource(DataSource<T> dataSource) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, dataSource)) == null) {
                synchronized (this) {
                    if (isClosed()) {
                        return false;
                    }
                    this.mCurrentDataSource = dataSource;
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        private boolean startNextDataSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
                Supplier<DataSource<T>> nextSupplier = getNextSupplier();
                DataSource<T> dataSource = nextSupplier != null ? nextSupplier.get() : null;
                if (setCurrentDataSource(dataSource) && dataSource != null) {
                    dataSource.subscribe(new InternalDataSubscriber(this, null), CallerThreadExecutor.getInstance());
                    return true;
                }
                closeSafely(dataSource);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (super.close()) {
                        DataSource<T> dataSource = this.mCurrentDataSource;
                        this.mCurrentDataSource = null;
                        DataSource<T> dataSource2 = this.mDataSourceWithResult;
                        this.mDataSourceWithResult = null;
                        closeSafely(dataSource2);
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
                    DataSource<T> dataSourceWithResult = getDataSourceWithResult();
                    result = dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
                }
                return result;
            }
            return (T) invokeV.objValue;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    DataSource<T> dataSourceWithResult = getDataSourceWithResult();
                    if (dataSourceWithResult != null) {
                        z = dataSourceWithResult.hasResult();
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) ? new FirstAvailableDataSourceSupplier<>(list) : (FirstAvailableDataSourceSupplier) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FirstAvailableDataSourceSupplier) {
                return Objects.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier) obj).mDataSourceSuppliers);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDataSourceSuppliers.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new FirstAvailableDataSource(this) : (DataSource) invokeV.objValue;
    }
}
